package com.pitayastudio.godzilla.computerplayer;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.MoveType;
import com.pitayastudio.godzilla.game.GameCoordinatorTest;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.modelboard.CoordBoard;
import com.pitayastudio.godzilla.modelboard.PositionStateBoard;
import com.pitayastudio.godzilla.modelboard.VisualBoard;

import org.junit.Assert;
import org.junit.Test;

/**
 * Note: super-ko tests are not suitable here because they need setup of the previous jieDeadCoord.
 * They are better to be tested in {@link GameCoordinatorTest}.
 */
public class MctsOneMoveEngineTest {
  final int MAX_SIMULATIONS_COUNT = 3;

  int boardSize;
  private CoordBoard coordBoard;
  private TimeManager timeManager;
  private SearchNode rootNode;
  MctsOneMoveEngine.Builder moveEngineBuilder;

  private void prepare(String boardInput) {
    timeManager = new TimeManager();
    boardSize = VisualBoard.getBoardSizeFromBoardInput(boardInput);
    coordBoard = new CoordBoard(boardSize);
    PositionStateBoard positionStateBoard =
        PositionStateBoard.readFromString(boardInput, coordBoard);
    rootNode = SearchNode.constructRootNodeWithMoveHandling(positionStateBoard);
    int komiRoundedDown = 6;
    moveEngineBuilder = MctsOneMoveEngine.newBuilder()
        .setRequiredTimeManager(timeManager)
        .setRequiredNodeBeforeTheMove(rootNode)
        .setRequiredKomiRoundedDown(komiRoundedDown);
  }

  @Test public void testGetBestNextNode_isEndGameEstimated_true() {
    testGetBestNextNode(true);
  }
  @Test public void testGetBestNextNode_isEndGameEstimated_false() {
    testGetBestNextNode(false);
  }
  private void testGetBestNextNode(boolean isEndGameEstimated) {
    // Prepare
    String boardInput =
        "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦";
    prepare(boardInput);

    // Execute
    MoveEngine moveEngine =
        moveEngineBuilder.buildTakingLongTime(MAX_SIMULATIONS_COUNT, isEndGameEstimated, true);
    SearchNode bestNextNode = moveEngine.getBestNextNode();

    // Verify
    Coord bestNextMoveCoord = bestNextNode.getCoordOptional().get();
    MoveHandling bestNextMoveHandling = bestNextNode.getMoveHandling();
    Assert.assertEquals(Color.B, bestNextMoveHandling.getMoveColor());
    Assert.assertEquals(boardSize, bestNextMoveHandling.getBoardSize());
    Assert.assertTrue(bestNextMoveCoord.getXPosition() <= boardSize);
    Assert.assertTrue(bestNextMoveCoord.getYPosition() <= boardSize);
  }

  @Test public void testGetBestNextNode_9x9_isEndGameEstimated_true() {
    testGetBestNextNode_9x9(true);
  }
  @Test public void testGetBestNextNode_9x9_isEndGameEstimated_false() {
    testGetBestNextNode_9x9(false);
  }
  private void testGetBestNextNode_9x9(boolean isEndGameEstimated) {
    // Prepare
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    prepare(boardInput);

    // Execute
    MoveEngine moveEngine =
        moveEngineBuilder.buildTakingLongTime(MAX_SIMULATIONS_COUNT, isEndGameEstimated, true);
    SearchNode bestNextNode = moveEngine.getBestNextNode();

    // Verify
    Coord bestNextMoveCoord = bestNextNode.getCoordOptional().get();
    MoveHandling bestNextMoveHandling = bestNextNode.getMoveHandling();
    Assert.assertEquals(Color.B, bestNextMoveHandling.getMoveColor());
    Assert.assertEquals(boardSize, bestNextMoveHandling.getBoardSize());
    Assert.assertTrue(bestNextMoveCoord.getXPosition() <= boardSize);
    Assert.assertTrue(bestNextMoveCoord.getYPosition() <= boardSize);
  }

  @Test public void testGetBestNextNode_onlyTwoMoveChoicesForBlack_isEndGameEstimated_true() {
    testGetBestNextNode_onlyTwoMoveChoicesForBlack(true);
  }
  @Test public void testGetBestNextNode_onlyTwoMoveChoicesForBlack_isEndGameEstimated_false() {
    testGetBestNextNode_onlyTwoMoveChoicesForBlack(false);
  }
  private void testGetBestNextNode_onlyTwoMoveChoicesForBlack(boolean isEndGameEstimated) {
    // Prepare
    String boardInput =
        "○○○○○"
      + "○○○○○"
      + "◦◦○○○"
      + "○○○○○"
      + "◦○◦○○";
    prepare(boardInput);

    // Execute
    MoveEngine moveEngine =
        moveEngineBuilder.buildTakingLongTime(MAX_SIMULATIONS_COUNT, isEndGameEstimated, true);
    SearchNode bestNextNode = moveEngine.getBestNextNode();

    // Verify
    Coord bestNextMoveCoord = bestNextNode.getCoordOptional().get();
    MoveHandling bestNextMoveHandling = bestNextNode.getMoveHandling();
    Assert.assertEquals(Color.B, bestNextMoveHandling.getMoveColor());
    Assert.assertEquals(boardSize, bestNextMoveHandling.getBoardSize());
    Assert.assertTrue(bestNextMoveCoord.equals(coordBoard.getCoord(1, 3))
        || bestNextMoveCoord.equals(coordBoard.getCoord(2, 3)));
  }

  @Test public void testGetBestNextNode_noMoveChoicesForBlack_isEndGameEstimated_true() {
    testGetBestNextNode_noMoveChoicesForBlack(true);
  }
  @Test public void testGetBestNextNode_noMoveChoicesForBlack_isEndGameEstimated_false() {
    testGetBestNextNode_noMoveChoicesForBlack(false);
  }
  private void testGetBestNextNode_noMoveChoicesForBlack(boolean isEndGameEstimated) {
    // Prepare
    String boardInput =
        "○○○○○"
      + "○○○○○"
      + "○◦○○○"
      + "○○○○○"
      + "◦○◦○○";
    prepare(boardInput);

    // Execute
    MoveEngine moveEngine =
        moveEngineBuilder.buildTakingLongTime(MAX_SIMULATIONS_COUNT, isEndGameEstimated, true);
    SearchNode bestNextNode = moveEngine.getBestNextNode();

    // Verify
    MoveHandling bestNextMoveHandling = bestNextNode.getMoveHandling();
    Assert.assertEquals(Color.B, bestNextMoveHandling.getMoveColor());
    Assert.assertEquals(boardSize, bestNextMoveHandling.getBoardSize());
    Assert.assertEquals(MoveType.MOVE_PASS, bestNextMoveHandling.getMoveType());
    Assert.assertFalse(bestNextMoveHandling.getMoveCoordOptional().isPresent());
  }
}
