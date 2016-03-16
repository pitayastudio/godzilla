package com.pitayastudio.godzilla.computerplayer;

import com.google.common.base.Optional;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.game.GameHistory;
import com.pitayastudio.godzilla.game.GameHistory.ReadOnlyWrappedGameHistory;
import com.pitayastudio.godzilla.game.GameInfo;
import com.pitayastudio.godzilla.game.GameStatus.ReadOnlyWrappedGameStatus;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.modelboard.CoordBoard;
import com.pitayastudio.godzilla.modelboard.PositionStateBoard;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ComputerPlayerTest {

  @Test public void testGenNextMoveOptionalTakingLongTime_randomMoveEngine() {
    testCalculateNextNodeOptionalTakingLongTime(MoveEngine.Type.RANDOM);
  }
  @Test public void testGenNextMoveOptionalTakingLongTime_mcts2() {
    testCalculateNextNodeOptionalTakingLongTime(MoveEngine.Type.MCTS);
  }
  private static void testCalculateNextNodeOptionalTakingLongTime(MoveEngine.Type moveEngineType) {
    // Prepare.
    GameInfo mockGameInfo = Mockito.mock(GameInfo.class);
    ReadOnlyWrappedGameStatus mockGameStatus = Mockito.mock(ReadOnlyWrappedGameStatus.class);
    ReadOnlyWrappedGameHistory mockGameHistory = Mockito.mock(ReadOnlyWrappedGameHistory.class);
    // Board size must be big enough so that a live block could be constructed during simulation.
    int boardSize = 5;
    CoordBoard coordBoard = new CoordBoard(boardSize);
    PositionStateBoard rootPositionStateBoard = PositionStateBoard.newBuilder(coordBoard).build();
    SearchNode rootNode = SearchNode.constructRootNodeWithMoveHandling(rootPositionStateBoard);
    Optional<SearchNode> rootNodeOptional = Optional.of(rootNode);
    Mockito.when(mockGameHistory.getLatestNode()).thenReturn(rootNode);
    Mockito.when(mockGameInfo.getBoardSize()).thenReturn(boardSize);
    ComputerPlayer player = new ComputerPlayer(
        moveEngineType, mockGameInfo, mockGameStatus, mockGameHistory, coordBoard);

    // Assuming first move is at (1, 1).
    int prevMoveXPosition = 1;
    int prevMoveYPosition = 1;
    Mockito.when(mockGameHistory.findNumberOfMoves()).thenReturn(1);
    Coord firstCoord = coordBoard.getCoord(prevMoveXPosition, prevMoveYPosition);
    SearchNode firstNode = SearchNode.newBuilder()
        .setRequiredCoordOptional(Optional.of(firstCoord))
        .setRequiredParentNodeOptional(rootNodeOptional)
        .build();
    Mockito.when(mockGameHistory.getLatestNode()).thenReturn(firstNode);
    String boardInput =
        "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "●◦◦◦◦";
    PositionStateBoard positionStateBoard =
        PositionStateBoard.readFromString(boardInput, coordBoard);
    MoveHandling latestMoveHandling = MoveHandling.newBuilderForRegularMoveHandling()
        .setRequiredMoveColor(Color.B)
        .setRequiredMoveCoord(coordBoard.getCoord(3, 3))
        .setRequiredPositionStateBoardBeforeMove(positionStateBoard)
        .setRequiredPrevJieDeadCoordOptional(Optional.<Coord>absent())
        .build();
    firstNode.setMoveHandling(latestMoveHandling);
    Mockito.when(mockGameHistory.getLastestMoveHandling()).thenReturn(latestMoveHandling);
    Mockito.when(mockGameHistory.isGameStarted()).thenReturn(true);

    // Execute
    player.startGame();
    SearchNode nextNode = player.genNextMoveTakingLongTime(true, true);
    Coord nextCoord = nextNode.getCoordOptional().get();
    Assert.assertTrue(nextCoord.getXPosition() <= boardSize);
    Assert.assertTrue(nextCoord.getYPosition() <= boardSize);
    Assert.assertEquals(2, nextNode.getLevel());
    Assert.assertFalse(nextNode.isRoot());
  }

  /** Test method for {@link ComputerPlayer#genFirstMove} */
  @Test public void testGenFirstMove_randomMoveEngine() {
    testGenFirstMove(MoveEngine.Type.RANDOM);
  }
  @Test public void testGenFirstMove_mcts2() {
    testGenFirstMove(MoveEngine.Type.MCTS);
  }
  private static void testGenFirstMove(MoveEngine.Type moveEngineType) {
    GameInfo mockGameInfo = Mockito.mock(GameInfo.class);
    ReadOnlyWrappedGameStatus mockGameStatus = Mockito.mock(ReadOnlyWrappedGameStatus.class);
    GameHistory gameHistory = new GameHistory();
    int boardSize = 19;
    CoordBoard coordBoard = new CoordBoard(boardSize);
    gameHistory.startGame(coordBoard);
    ComputerPlayer player = new ComputerPlayer(moveEngineType, mockGameInfo, mockGameStatus,
        gameHistory.getReadOnlyWrappedGameHistory(), coordBoard);
    Mockito.when(mockGameInfo.getBoardSize()).thenReturn(boardSize);

    player.startGame();
    SearchNode firstNode = player.genFirstMove();
    Assert.assertEquals(1, firstNode.getLevel());
  }
}
