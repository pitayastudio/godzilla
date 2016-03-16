package com.pitayastudio.godzilla.computerplayer;

import com.google.common.base.Optional;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.Flags;
import com.pitayastudio.godzilla.game.GameHistory.ReadOnlyWrappedGameHistory;
import com.pitayastudio.godzilla.game.GameInfo;
import com.pitayastudio.godzilla.game.GameStatus.ReadOnlyWrappedGameStatus;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.modelboard.CoordBoard;
import com.pitayastudio.godzilla.modelboard.PositionStateBoard;

import java.util.logging.Logger;

import javax.annotation.Nonnull;

public class ComputerPlayer {
  private static final Logger logger = Logger.getLogger(ComputerPlayer.class.getName());

  private final MoveEngine.Type moveEngineType;
  private final GameInfo gameInfo;
  @SuppressWarnings("unused")  // TODO 160 Utilize gameStatus in ComputerPlayer.
  private final ReadOnlyWrappedGameStatus gameStatus;
  private final ReadOnlyWrappedGameHistory gameHistory;
  private final CoordBoard coordBoard;
  private boolean isComputerPlayerReady;

  public ComputerPlayer(
      @Nonnull MoveEngine.Type moveEngineType,
      @Nonnull GameInfo gameInfo,
      @Nonnull ReadOnlyWrappedGameStatus gameStatus,
      @Nonnull ReadOnlyWrappedGameHistory gameHistory,
      @Nonnull CoordBoard coordBoard) {
    logger.fine("in ComputerPlayer");
    this.moveEngineType = moveEngineType;
    this.gameInfo = gameInfo;
    this.gameStatus = gameStatus;
    this.gameHistory = gameHistory;  // gameHistory.startGame() is not called yet.
    this.coordBoard = coordBoard;
    this.isComputerPlayerReady = false;
  }

  public void startGame() {
    assert(!isComputerPlayerReady);
    assert(gameHistory.isGameStarted());
    this.isComputerPlayerReady = true;
  }

  public SearchNode genFirstMove() {
    assert(isComputerPlayerReady);
    // TODO 150 Calculate better first node.
    int xPosition = 3;
    int yPosition = 3;
    Coord firstCoord = coordBoard.getCoord(xPosition, yPosition);
    SearchNode rootNode = gameHistory.getLatestNode();
    SearchNode firstNode = SearchNode.newBuilder()
        .setRequiredCoordOptional(Optional.of(firstCoord))
        .setRequiredParentNodeOptional(Optional.of(rootNode))
        .build();
    PositionStateBoard rootPositionStateBoard =
        gameHistory.getLastestMoveHandling().getPositionStateBoardAfterMove();
    MoveHandling firstMoveHandling = MoveHandling.newBuilderForRegularMoveHandling()
        .setRequiredPositionStateBoardBeforeMove(rootPositionStateBoard)
        .setRequiredMoveColor(Color.B)
        .setRequiredPrevJieDeadCoordOptional(Optional.<Coord>absent())
        .setRequiredMoveCoord(firstCoord)
        .build();
    firstNode.setMoveHandling(firstMoveHandling);
    return firstNode;
  }

  public SearchNode genNextMoveTakingLongTime(boolean isEndGameEstimated, boolean isPrintReachMaxNodeLevel) {
    assert(isComputerPlayerReady);

    MoveEngine moveEngine = null;
    SearchNode latestNode = gameHistory.getLatestNode();
    TimeManager timeManager = new TimeManager();
    switch (moveEngineType) {
      case MCTS:
        int komiRoundedDown = gameInfo.getKomiRoundedDown();
        moveEngine = MctsOneMoveEngine.newBuilder()
            .setRequiredTimeManager(timeManager)
            .setRequiredNodeBeforeTheMove(latestNode)
            .setRequiredKomiRoundedDown(komiRoundedDown)
            .buildTakingLongTime(
                Flags.MAX_MCTS_SIMULATIONS_COUNT, isEndGameEstimated, isPrintReachMaxNodeLevel);
        break;
      case RANDOM:
        moveEngine = RandomMoveEngine.newBuilder()
            .setRequiredNodeBeforeTheMove(latestNode)
            .build();
        break;
      default:
        assert false : "Invalid moveEngineType: " + moveEngineType;
        break;
    }
    SearchNode bestNextNode = moveEngine.getBestNextNode();
    return bestNextNode;
  }
}
