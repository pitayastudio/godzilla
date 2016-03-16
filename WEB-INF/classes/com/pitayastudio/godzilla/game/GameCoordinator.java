package com.pitayastudio.godzilla.game;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.MoveType;
import com.pitayastudio.godzilla.common.PositionState;
import com.pitayastudio.godzilla.common.Utils;
import com.pitayastudio.godzilla.computerplayer.ComputerPlayer;
import com.pitayastudio.godzilla.computerplayer.MoveEngine;
import com.pitayastudio.godzilla.computerplayer.MoveHandling;
import com.pitayastudio.godzilla.computerplayer.SearchNode;
import com.pitayastudio.godzilla.endgame.EndGameTerritoryWithoutDeadAnalyzer;
import com.pitayastudio.godzilla.model.ColorBlock;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.modelboard.BlockBoard;
import com.pitayastudio.godzilla.modelboard.CoordBoard;
import com.pitayastudio.godzilla.modelboard.LandBoard;
import com.pitayastudio.godzilla.modelboard.LotBoard;
import com.pitayastudio.godzilla.modelboard.NeighborhoodBoard;
import com.pitayastudio.godzilla.modelboard.PositionStateBoard;

import java.util.logging.Logger;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class GameCoordinator {
  @SuppressWarnings("unused")
  private static final Logger logger = Logger.getLogger(GameCoordinator.class.getName());

  private static final boolean FLAG_PROFILE = true;

  private static final int MAX_NUMBER_OF_MOVES_TO_USE_OPENING_BOOK = 0;

  private final CoordBoard coordBoard;
  private final GameInfo gameInfo;
  private final GameStatus gameStatus;
  private final GameHistory gameHistory;
  private final ComputerPlayer computerPlayer;
  private BlockBoard endGameBlockBoard;
  private GameResult gameResult;

  public GameCoordinator(@Nonnull GameInfo gameInfo, @Nonnull MoveEngine.Type moveEngineType) {
    this.gameInfo = gameInfo;
    coordBoard = new CoordBoard(gameInfo.getBoardSize());
    int timeLimitInMin = gameInfo.getTimeLimitInMin();
    gameStatus = new GameStatus(timeLimitInMin);
    gameHistory = new GameHistory();
    computerPlayer = new ComputerPlayer(
        moveEngineType,
        gameInfo,
        gameStatus.getReadOnlyWrappedGameStatus(),
        gameHistory.getReadOnlyWrappedGameHistory(),
        coordBoard);
  }

  public CoordBoard getCoordBoard() {
    return coordBoard;
  }

  public GameInfo getGameInfo() {
    return gameInfo;
  }

  public GameStatus getMutableGameStatus() {
    return gameStatus;
  }

  @Nullable public GameResult getGameResult() {
    return gameResult;
  }

  public PlayStage getPlayStage() {
    return gameStatus.getCurrentPlayStage();
  }

  public int getDeadCountForColor(@Nonnull Color color) {
    return gameStatus.getDeadCount(color);
  }

  MoveHandling getLatestMoveHandling() {
    return gameHistory.getLatestMoveHandling();
  }

  public PositionStateBoard getCurrentPositionStateBoard() {
    return gameHistory.getLatestMoveHandling().getPositionStateBoardAfterMove();
  }

  public MoveHandling getMoveHandlingAtMoveCount(int moveCount) {
    return gameHistory.getMoveHandlingAtMoveCount(moveCount);
  }

  public BlockBoard getEndGameBlockBoard() {
    assert(getPlayStage() == PlayStage.PLAY_STAGE_STOPPED
        || getPlayStage() == PlayStage.PLAY_STAGE_PICKUP_DEAD);
    return endGameBlockBoard;
  }

  /**
   * Returns number of moves including pass moves.
   */
  public int findNumberOfMoves() {
    return gameHistory.findNumberOfMoves();
  }

  public Color findColorForNextMove() {
    return gameHistory.findColorForNextMove();
  }

  public JsonObject getGameHistorySummaryJsonObject() {
    return gameHistory.toSummaryJsonObject();
  }

  // TODO 150 Support GameCoordinator.startGame(rootBlockBoard)
  public void startGame() {
    gameStatus.startGame();
    gameHistory.startGame(coordBoard);
    computerPlayer.startGame();
  }

  public MoveType handleHumanMoveAtCoord(Color colorOfThisPlayer, int xPosition, int yPosition) {
    assert xPosition >= 1 && xPosition <= this.gameInfo.getBoardSize();
    assert yPosition >= 1 && yPosition <= this.gameInfo.getBoardSize();
    assert gameStatus.getCurrentPlayStage() == PlayStage.PLAY_STAGE_STARTED;
    assert gameHistory.findColorForNextMove() == colorOfThisPlayer;

    Coord coord =  coordBoard.getCoord(xPosition, yPosition);

    long time00;
    if (FLAG_PROFILE) time00 = System.nanoTime();
    MoveHandling latestMoveHandling = gameHistory.getLatestMoveHandling();
    assert latestMoveHandling != null
        : "Error: system is not ready b/c latestMoveHandling is null";
    PositionStateBoard blockBoardBeforeMove = latestMoveHandling.getPositionStateBoardAfterMove();
    Color nextMoveColor = latestMoveHandling.getMoveColor().swap();
    MoveHandling nextMoveHandling = MoveHandling.newBuilderForRegularMoveHandling()
        .setRequiredPositionStateBoardBeforeMove(blockBoardBeforeMove)
        .setRequiredMoveColor(nextMoveColor)
        .setRequiredPrevJieDeadCoordOptional(latestMoveHandling.getJieDeadCoordOptional())
        .setRequiredMoveCoord(coord)
        .build();

    // Return immediately if the move causes error.
    MoveType nextMoveType = nextMoveHandling.getMoveType();
    if (nextMoveType == MoveType.MOVE_ERROR_PREV_POSIT_IS_ALREADY_OCCUPIED
        || nextMoveType == MoveType.MOVE_ERROR_JIE_VIOLATION
        || nextMoveType == MoveType.MOVE_ERROR_SUICIDE) {
      return nextMoveType;
    }

    ImmutableSet<Coord> deadCoords = nextMoveHandling.getDeadCoords();
    int numberOfDeadStones = deadCoords.size();
    gameStatus.incrementDeadForColor(colorOfThisPlayer.swap(), numberOfDeadStones);
    gameStatus.getTimeStatus().updateTimeForColor(colorOfThisPlayer);
    int timeSpentMillis = gameStatus.getTimeStatus().getTimeSpentForLastMoveMillis();
    Optional<SearchNode> latestNodeOptional = Optional.of(gameHistory.getLatestNode());
    SearchNode nextNode = SearchNode.newBuilder()
        .setRequiredCoordOptional(nextMoveHandling.getMoveCoordOptional())
        .setRequiredParentNodeOptional(latestNodeOptional)
        .build();
    nextNode.setMoveHandling(nextMoveHandling);
    gameHistory.addNewNodeAndMoveHandlingAndTimeSpent(
        nextNode, nextMoveHandling, timeSpentMillis);

    if (FLAG_PROFILE) Utils.profile(time00, "GameCoordinator.handleHumanMoveAtCoord");
    return nextMoveType;
  }

  /**
   * Handles pass move.
   * Returns true if has got two consecutive passes.
   */
  public boolean handleHumanPassMove(Color colorOfThisPlayer) {
    assert gameStatus.getCurrentPlayStage() == PlayStage.PLAY_STAGE_STARTED;
    assert gameHistory.findColorForNextMove() == colorOfThisPlayer;

    gameStatus.getTimeStatus().updateTimeForColor(colorOfThisPlayer);
    int timeSpentMillis = gameStatus.getTimeStatus().getTimeSpentForLastMoveMillis();
    MoveHandling latestMoveHandling = gameHistory.getLatestMoveHandling();
    assert latestMoveHandling != null;
    Optional<SearchNode> parentNodeOptional = Optional.of(gameHistory.getLatestNode());
    SearchNode nextNode = SearchNode.newBuilder()
        .setRequiredParentNodeOptional(parentNodeOptional)
        .setRequiredCoordOptional(Optional.<Coord>absent())
        .build();
    PositionStateBoard positionStateBoard = latestMoveHandling.getPositionStateBoardAfterMove();
    MoveHandling passMoveHandling = MoveHandling.constructPassMoveHandling(latestMoveHandling);
    nextNode.setMoveHandling(passMoveHandling);
    gameHistory.addNewNodeAndMoveHandlingAndTimeSpent(nextNode, passMoveHandling, timeSpentMillis);

    // If it is a consecutive PASS move, then the game ends:
    if (latestMoveHandling.getMoveType() == MoveType.MOVE_PASS) {
      gameStatus.setCurrentPlayStage(PlayStage.PLAY_STAGE_PICKUP_DEAD);
      BlockBoard blockBoard = BlockBoard.newBuilder()
          .setRequiredPositionStateBoard(positionStateBoard)
          .build();
      endGameBlockBoard = blockBoard;
      return true;
    } else {
      return false;
    }
  }

  public void askComputerToGenNextMoveTakingLongTime(Color colorOfThisPlayer) {
    askComputerToGenNextMoveTakingLongTime(colorOfThisPlayer, true);
  }

  public void askComputerToGenNextMoveTakingLongTime(
      Color colorOfThisPlayer, boolean isPrintReachMaxNodeLevel) {
    assert gameStatus.getCurrentPlayStage() == PlayStage.PLAY_STAGE_STARTED;
    assert gameHistory.findColorForNextMove() == colorOfThisPlayer;

    MoveType moveTypeBeforeMove = this.gameHistory.getLatestMoveHandling().getMoveType();
    int numberOfMoves = this.gameHistory.findNumberOfMoves();
    this.findColorForNextMove();
    SearchNode nextBestNode;
    if (numberOfMoves <= MAX_NUMBER_OF_MOVES_TO_USE_OPENING_BOOK) {
      nextBestNode = computerPlayer.genFirstMove();
    } else {
      nextBestNode = computerPlayer.genNextMoveTakingLongTime(true, isPrintReachMaxNodeLevel);
    }
    assert nextBestNode.hasMoveHandling();
    MoveHandling moveHandling = nextBestNode.getMoveHandling();

    // Update everything.
    // TODO 100 Share code for updating between handleHumanMoveAtCoord() and
    // askComputerToCalculateNextMove().

    // This computer move is not the first move, and
    // this computer move is not a move after a PASS move.
    // This (next) computer move must exist, even if this computer move is a PASS.

    // Update dead coords.
    ImmutableSet<Coord> deadCoords = moveHandling.getDeadCoords();
    int deadCoordsCount = deadCoords.size();
    gameStatus.incrementDeadForColor(colorOfThisPlayer.swap(), deadCoordsCount);
    // Update timeSpent.
    gameStatus.getTimeStatus().updateTimeForColor(colorOfThisPlayer);
    int timeSpentMillis = gameStatus.getTimeStatus().getTimeSpentForLastMoveMillis();
    //logger.info("timeSpentMillis: " + timeSpentMillis);
    // Update GameHistory.
    gameHistory.addNewNodeAndMoveHandlingAndTimeSpent(
        nextBestNode, moveHandling, timeSpentMillis);

    // Handle consecutive 2 pass moves.
    if (moveTypeBeforeMove == MoveType.MOVE_PASS
        && moveHandling.getMoveType() == MoveType.MOVE_PASS) {
      this.gameStatus.setCurrentPlayStage(PlayStage.PLAY_STAGE_PICKUP_DEAD);
      PositionStateBoard positionStateBoard = moveHandling.getPositionStateBoardAfterMove();
      endGameBlockBoard = BlockBoard.newBuilder()
          .setRequiredPositionStateBoard(positionStateBoard)
          .build();
    }
  }

  /**
   * Handles UNDO move.
   * Nothing is changed if there is no previous move.
   */
  // TODO 200 Handle the case when handleUndoMove is called while computer is still generating
  //     the next move.
  public void handleUndoMove() {
    assert gameStatus.getCurrentPlayStage() == PlayStage.PLAY_STAGE_STARTED;

    if (this.findNumberOfMoves() == 0) {
      // No change.
      return;
    }

    MoveHandling latestMoveHandling = gameHistory.getLatestMoveHandling();
    assert latestMoveHandling != null
        : "Error: system is not ready b/c latestMoveHandling is null";

    // Revert dead count.
    ImmutableSet<Coord> deadCoords = latestMoveHandling.getDeadCoords();
    int deadCount = deadCoords.size();

    if (deadCount > 0) {
      Color colorOfCurrentMove = latestMoveHandling.getMoveColor();
      // The color of the dead is the other color. So, we need to swap color below.
      gameStatus.decrementDeadForColor(colorOfCurrentMove.swap(), deadCount);
    }

    // Update time in game status.
    // Note, any previous spent-time is NOT reverted for an UNDO move.
    // However, the previous spent-time will not be recorded in GameHistory.
    gameStatus.getTimeStatus().updateTimeForUndo(gameHistory);

    // Handle the latest item.
    // Removing last item must be done after updating timeStatus.
    gameHistory.removeLatestMoveHandlingAndTimeSpent();
  }

  public void handleResign(Color colorOfThisPlayer) {
    assert gameHistory.findColorForNextMove() == colorOfThisPlayer;

    // PlayStage could be any for RESIGN, so no need to check it.
    gameStatus.setCurrentPlayStage(PlayStage.PLAY_STAGE_STOPPED);
    gameResult = GameResult.newBuilder()
        .setColorOfWinner(colorOfThisPlayer.swap())
        .setIsResigned()
        .build();
  }

  public void handlePickupDeadBlockAtCoord(int xPosition, int yPosition) {
    assert xPosition >= 0 && xPosition <= this.gameInfo.getBoardSize();
    assert yPosition >= 0 && yPosition <= this.gameInfo.getBoardSize();
    assert endGameBlockBoard != null;
    assert gameStatus.getCurrentPlayStage() == PlayStage.PLAY_STAGE_PICKUP_DEAD;

    PositionStateBoard positionStateBoard = endGameBlockBoard.getPositionStateBoard();
    PositionState positionState = positionStateBoard.getPositionState(xPosition, yPosition);

    if (positionState == PositionState.VACANT) {
      return;  // Ignore invalid pickup.
    }

    ColorBlock deadColorBlock = endGameBlockBoard.getColorBlock(xPosition, yPosition);
    Color colorBud = deadColorBlock.getColor();

    // Update gameInfoStatus:
    gameStatus.incrementDeadForColor(colorBud, deadColorBlock.size());

    // Update endGameBlockBoard.
    PositionStateBoard newPositStateBoard = positionStateBoard.toBuilder()
        .setPositionStates(deadColorBlock.getCoords(), PositionState.VACANT)
        .build();
    BlockBoard newBlockBoard = BlockBoard.newBuilder()
        .setRequiredPositionStateBoard(newPositStateBoard)
        .build();
    endGameBlockBoard = newBlockBoard;
  }

  public void handleDoneOfPickupDeadStones() {
    assert endGameBlockBoard != null;
    assert this.gameStatus.getCurrentPlayStage() == PlayStage.PLAY_STAGE_PICKUP_DEAD;

    // Update gameStatus:
    gameStatus.setCurrentPlayStage(PlayStage.PLAY_STAGE_STOPPED);

    // Count territory:
    NeighborhoodBoard neighborhoodBoard =
        NeighborhoodBoard.newBuilder().setRequiredBlockBoard(endGameBlockBoard).build();

    LandBoard landBoard = LandBoard.newBuilder()
        .setNeighborhoodBoard(neighborhoodBoard)
        .build();  // throws exception if everything is vacant at end game
    LotBoard lotBoard = LotBoard.newBuilder()
        .setRequiredLandBoard(landBoard)
        .build();
    EndGameTerritoryWithoutDeadAnalyzer territoryAnalyzer =
        EndGameTerritoryWithoutDeadAnalyzer.newBuilder()
            .setRequiredLotBoard(lotBoard)
            .build();

    // Update gameResult:
    int vacantTerritoryOfBlack = territoryAnalyzer.getVacantTerritoryOfBlack();
    int vacantTerritoryOfWhite = territoryAnalyzer.getVacantTerritoryOfWhite();
    gameResult = GameResult.newBuilder()
        .setKomi(gameInfo.getKomi())
        .setBlackDeadCount(gameStatus.getDeadCount(Color.B))
        .setWhiteDeadCount(gameStatus.getDeadCount(Color.W))
        .setVacantTerritoryOfBlack(vacantTerritoryOfBlack)
        .setVacantTerritoryOfWhite(vacantTerritoryOfWhite)
        .build();
  }
}
