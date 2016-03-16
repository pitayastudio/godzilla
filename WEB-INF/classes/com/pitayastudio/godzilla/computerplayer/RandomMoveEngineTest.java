package com.pitayastudio.godzilla.computerplayer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.MoveType;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.modelboard.CoordBoard;
import com.pitayastudio.godzilla.modelboard.PositionStateBoard;

import org.junit.Test;

public class RandomMoveEngineTest {

  private static final int BOARD_SIZE = 3;
  private CoordBoard coordBoard = new CoordBoard(BOARD_SIZE);
  private SearchNode rootNode;
  RandomMoveEngine.Builder moveEngineBuilder;
  RandomMoveEngine moveEngine;

  private void prepare(String boardInput) {
    PositionStateBoard positionStateBoard = PositionStateBoard.readFromString(boardInput, coordBoard);
    rootNode = SearchNode.constructRootNodeWithMoveHandling(positionStateBoard);
    moveEngineBuilder = RandomMoveEngine.newBuilder()
        .setRequiredNodeBeforeTheMove(rootNode);
  }

  @Test public void testGetBestNextNode() {
    // Prepare
    String boardInput =
        "◦◦◦"
      + "◦◦◦"
      + "◦◦◦";
    prepare(boardInput);

    // Execute
    MoveEngine moveEngine = moveEngineBuilder.build();
    SearchNode bestNextNode = moveEngine.getBestNextNode();

    // Verify
    Coord bestNextMoveCoord = bestNextNode.getCoordOptional().get();
    MoveHandling bestNextMoveHandling = bestNextNode.getMoveHandling();
    assertEquals(Color.B, bestNextMoveHandling.getMoveColor());
    assertEquals(BOARD_SIZE, bestNextMoveHandling.getBoardSize());
    assertTrue(bestNextMoveCoord.getXPosition() <= BOARD_SIZE);
    assertTrue(bestNextMoveCoord.getYPosition() <= BOARD_SIZE);
  }

  @Test public void testGetBestNextNode_onlyTwoMoveChoicesForBlack() {
    // Prepare
    String boardInput =
        "◦◦○"
      + "○○○"
      + "◦○◦";
    prepare(boardInput);

    // Execute
    MoveEngine moveEngine = moveEngineBuilder.build();
    SearchNode bestNextNode = moveEngine.getBestNextNode();

    // Verify
    Coord bestNextMoveCoord = bestNextNode.getCoordOptional().get();
    MoveHandling bestNextMoveHandling = bestNextNode.getMoveHandling();
    assertEquals(Color.B, bestNextMoveHandling.getMoveColor());
    assertEquals(BOARD_SIZE, bestNextMoveHandling.getBoardSize());
    assertTrue(bestNextMoveCoord.getXPosition() <= BOARD_SIZE);
    assertTrue(bestNextMoveCoord.getYPosition() <= BOARD_SIZE);
    assertTrue(bestNextMoveCoord.equals(coordBoard.getCoord(1, 3))
        || bestNextMoveCoord.equals(coordBoard.getCoord(2, 3)));
  }

  @Test public void testGetBestNextNode_noMoveChoicesForBlack() {
    // Prepare
    String boardInput =
        "○◦○"
      + "○○○"
      + "◦○◦";
    prepare(boardInput);

    // Execute
    MoveEngine moveEngine = moveEngineBuilder.build();
    SearchNode bestNextNode = moveEngine.getBestNextNode();

    // Verify
    MoveHandling bestNextMoveHandling = bestNextNode.getMoveHandling();
    assertEquals(Color.B, bestNextMoveHandling.getMoveColor());
    assertEquals(BOARD_SIZE, bestNextMoveHandling.getBoardSize());
    assertEquals(MoveType.MOVE_PASS, bestNextMoveHandling.getMoveType());
    assertFalse(bestNextMoveHandling.getMoveCoordOptional().isPresent());
  }
}
