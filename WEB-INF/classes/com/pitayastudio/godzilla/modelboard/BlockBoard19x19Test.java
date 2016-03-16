package com.pitayastudio.godzilla.modelboard;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.moveanalyzer.TestUtils;

import junit.framework.TestCase;

import org.junit.Test;

public class BlockBoard19x19Test extends TestCase {

  @Test public void test_complicate_1() {
    String boardInput =
        "◦●●○○◦◦◦◦◦◦◦◦◦◦◦◦◦A"
      + "●○○●○◦●●●●●●●●●◦◦◦◦"
      + "●◦○●○◦○○○○○○○○○◦◦◦◦"
      + "●◦○●○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "●◦○●○◦●●●●●●●●●◦◦◦◦"
      + "●◦○●○◦○○○○○○○○○◦◦◦◦"
      + "●◦◦●◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "●◦○●○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "●◦○●○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "●◦○●○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "●◦○●○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "●◦○●○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "●◦○●○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "●◦○●○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "●◦○●○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "●◦○●○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "●◦○●○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "●●○●○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦●●●◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    BlockBoard blockBoard = BlockBoard.readFromString(boardInput);
    assertEquals(4, blockBoard.getAllVacantBlocks().size());
    assertEquals(4, blockBoard.getAllBlocksOfColor(Color.B).size());
    assertEquals(6, blockBoard.getAllBlocksOfColor(Color.W).size());

    CoordBoard coordBoard = blockBoard.getCoordBoard();
    Coord nextMoveCoord = TestUtils.readExpectedMoveCoordFromString(boardInput, coordBoard);
    int nextMoveXPosition = nextMoveCoord.getXPosition();
    int nextMoveYPosition = nextMoveCoord.getYPosition();
    Color colorOfNextMove = Color.B;
    long time00 = System.nanoTime();
    BlockBoard newBlockBoard =
        blockBoard.constructBlockBoardWithNewMoveWithoutConsideringDead(nextMoveXPosition, nextMoveYPosition, colorOfNextMove);
    long spentTimeMs = (System.nanoTime() - time00) / 1_000_000;
    assertEquals(4, newBlockBoard.getAllVacantBlocks().size());
    assertEquals(5, newBlockBoard.getAllBlocksOfColor(Color.B).size());
    assertEquals(6, newBlockBoard.getAllBlocksOfColor(Color.W).size());
    if (spentTimeMs > 1) {
      fail("Too big spent-time ms for lockBoard.constructNewBlockBoard: " + spentTimeMs);
    }
  }
}
