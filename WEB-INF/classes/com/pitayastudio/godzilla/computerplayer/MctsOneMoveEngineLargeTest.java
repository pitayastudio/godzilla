package com.pitayastudio.godzilla.computerplayer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.modelboard.CoordBoard;
import com.pitayastudio.godzilla.modelboard.PositionStateBoard;
import com.pitayastudio.godzilla.modelboard.VisualBoard;

import org.junit.Test;

/**
 * Run with:
 * -ea -Xms1G -Xmx4G
 *
 * Results:
 *
 * 2014-12-14 with MAX_SIMULATIONS_COUNT = 150, MctsMoveEngine2
 * DONE testGetBestNextNode_boardSize19_endGame w/ spent-time (ms):7122
 * DONE testGetBestNextNode_boardSize19_openGame w/ spent-time (ms):9718
 * DONE testGetBestNextNode_boardSize19_middleGame w/ spent-time (ms):7288
 *
 * 2014-12-11 with MAX_SIMULATIONS_COUNT = 150, MctsMoveEngine
 * DONE testGetBestNextNode_boardSize19_endGame w/ spent-time (ms):7745
 * DONE testGetBestNextNode_boardSize19_openGame w/ spent-time (ms):13200
 * DONE testGetBestNextNode_boardSize19_middleGame w/ spent-time (ms):9218
 */
public class MctsOneMoveEngineLargeTest {
  final int MAX_SIMULATIONS_COUNT = 150;

  // The board size cannot be too small, otherwise, MCTS move engine might not be able to create any
  // live blocks during playout.

  private void testing(String boardInput, String testTarget, boolean isEndGameEstimated) {
    System.out.println("Starting " + testTarget);
    // Prepare
    TimeManager timeManager = new TimeManager();
    int boardSize = VisualBoard.getBoardSizeFromBoardInput(boardInput);
    CoordBoard coordBoard = new CoordBoard(boardSize);
    PositionStateBoard positionStateBoard =
        PositionStateBoard.readFromString(boardInput, coordBoard);
    SearchNode rootNode = SearchNode.constructRootNodeWithMoveHandling(positionStateBoard);
    int komiRoundedDown = 6;
    MctsOneMoveEngine.Builder moveEngineBuilder = MctsOneMoveEngine.newBuilder()
        .setRequiredTimeManager(timeManager)
        .setRequiredNodeBeforeTheMove(rootNode)
        .setRequiredKomiRoundedDown(komiRoundedDown);


    // Execute
    long time0 = System.nanoTime();
    MoveEngine moveEngine =
        moveEngineBuilder.buildTakingLongTime(MAX_SIMULATIONS_COUNT, isEndGameEstimated, true);
    long time1 = System.nanoTime();
    SearchNode bestNextNode = moveEngine.getBestNextNode();

    // Verify
    Coord bestNextMoveCoord = bestNextNode.getCoordOptional().get();
    MoveHandling bestNextMoveHandling = bestNextNode.getMoveHandling();
    assertEquals(Color.B, bestNextMoveHandling.getMoveColor());
    assertEquals(boardSize, bestNextMoveHandling.getBoardSize());
    assertTrue(bestNextMoveCoord.getXPosition() <= boardSize);
    assertTrue(bestNextMoveCoord.getYPosition() <= boardSize);
    System.out.println("DONE " + testTarget + " w/ spent-time (ms):"
        + (time1 - time0) / 1_000_000 + "\n");
  }

  @Test public void testGetBestNextNode_boardSize19_openGame_isEndGameEstimated_true() {
    testGetBestNextNode_boardSize19_openGame(
        "testGetBestNextNode_boardSize19_openGame_isEndGameEstimated_true", true);
  }
  @Test public void testGetBestNextNode_boardSize19_openGame_isEndGameEstimated_false() {
    testGetBestNextNode_boardSize19_openGame(
        "testGetBestNextNode_boardSize19_openGame_isEndGameEstimated_false", false);
  }
  private void testGetBestNextNode_boardSize19_openGame(String target, boolean isEndGameEstimated) {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    testing(boardInput, target, isEndGameEstimated);
  }

  @Test public void testGetBestNextNode_boardSize19_middleGame_isEndGameEstimated_true() {
    testGetBestNextNode_boardSize19_middleGame(
        "testGetBestNextNode_boardSize19_middleGame_isEndGameEstimated_true", true);
  }
  @Test public void testGetBestNextNode_boardSize19_middleGame_isEndGameEstimated_false() {
    testGetBestNextNode_boardSize19_middleGame(
        "testGetBestNextNode_boardSize19_middleGame_isEndGameEstimated_false", false);
  }
  private void testGetBestNextNode_boardSize19_middleGame(String target, boolean isEndGameEstimated) {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○◦○○●◦◦◦"
      + "◦◦◦●◦◦◦●●○●◦○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦●○●•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦●●◦●○○○○●○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦○◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    testing(boardInput, target, isEndGameEstimated);
  }

  @Test public void testGetBestNextNode_boardSize19_endGame_isEndGameEstimated_true() {
    testGetBestNextNode_boardSize19_endGame(
        "testGetBestNextNode_boardSize19_endGame_isEndGameEstimated_true", true);
  }
  @Test public void testGetBestNextNode_boardSize19_endGame_isEndGameEstimated_false() {
    testGetBestNextNode_boardSize19_endGame(
        "testGetBestNextNode_boardSize19_endGame_isEndGameEstimated_false", false);
  }
  private void testGetBestNextNode_boardSize19_endGame(String target, boolean isEndGameEstimated) {
    String boardInput =
        "◦●◦●◦●◦●◦○○○●◦◦◦◦○◦"
      + "◦◦●●●○●○●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○●●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○○●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "○○○○○○●○◦○○●●●●●◦◦◦"
      + "◦●◦○●○●◦○○◦○●○○●◦◦◦"
      + "●◦●●●●●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○○◦○●◦◦"
      + "○○○○●○◦●○○●○●○○○●◦◦"
      + "◦◦○●●○●○○●●◦●◦●○○●◦"
      + "◦◦◦○○○●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●●"
      + "◦◦○●●●◦◦●○○◦◦○◦○◦○◦";
    testing(boardInput, target, isEndGameEstimated);
  }
}
