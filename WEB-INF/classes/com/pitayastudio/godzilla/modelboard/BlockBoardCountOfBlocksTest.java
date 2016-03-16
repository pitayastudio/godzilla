package com.pitayastudio.godzilla.modelboard;

import com.pitayastudio.godzilla.common.Color;

import junit.framework.TestCase;

import org.junit.Test;

public class BlockBoardCountOfBlocksTest extends TestCase {

  private static void testing(
      String boardInput,
      int expectedVacantBlocksSize,
      int expectedBlackBlocksSize,
      int expectedWhiteBlocksSize) {
    BlockBoard blockBoard = BlockBoard.readFromString(boardInput);
    assertEquals(expectedVacantBlocksSize, blockBoard.getAllVacantBlocks().size());
    assertEquals(expectedBlackBlocksSize, blockBoard.getAllBlocksOfColor(Color.B).size());
    assertEquals(expectedWhiteBlocksSize, blockBoard.getAllBlocksOfColor(Color.W).size());
  }

  @Test public void test_oneFullVacantBlock() {
    String boardInput =
        "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦";
    testing(boardInput, 1, 0, 0);
  }

  @Test public void test_oneMove() {
    String boardInput =
        "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦●◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦";
    testing(boardInput, 1, 1, 0);
  }

  @Test public void test_oneCornerMove1() {
    String boardInput =
        "●◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦";
    testing(boardInput, 1, 1, 0);
  }

  @Test public void test_oneCornerMove2() {
    String boardInput =
        "◦◦◦◦●"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦";
    testing(boardInput, 1, 1, 0);
  }

  @Test public void test_oneCornerMove3() {
    String boardInput =
        "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "●◦◦◦◦";
    testing(boardInput, 1, 1, 0);
  }

  @Test public void test_oneCornerMove4() {
    String boardInput =
        "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦●";
    testing(boardInput, 1, 1, 0);
  }

  @Test public void test_oneSideMove() {
    String boardInput =
        "◦◦●◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦";
    testing(boardInput, 1, 1, 0);
  }

  @Test public void test_oneUpperMiddleMove() {
    String boardInput =
        "◦◦◦◦◦"
      + "◦◦●◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦";
    testing(boardInput, 1, 1, 0);
  }

  @Test public void test_twoConnectedMoves_up() {
    String boardInput =
        "◦●●◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦";
    testing(boardInput, 1, 1, 0);
  }

  @Test public void test_twoConnectedMoves_left() {
    String boardInput =
        "◦◦◦◦◦"
      + "●◦◦◦◦"
      + "●◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦";
    testing(boardInput, 1, 1, 0);
  }

  @Test public void test_twoLooselyConnectedMoves() {
    String boardInput =
        "◦●◦◦◦"
      + "●◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦○"
      + "◦◦◦○◦";
    testing(boardInput, 3, 2, 2);
  }

  @Test public void test_twoSeparatedMoves() {
    String boardInput =
        "◦●◦●◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦";
    testing(boardInput, 1, 2, 0);
  }

  @Test public void test_oneFullColorBlock() {
    String boardInput =
        "●●●●●"
      + "●●●●●"
      + "●●●●●"
      + "●●●●●"
      + "●●●●●";
    testing(boardInput, 0, 1, 0);
  }

  @Test public void test_2SeparatedColorBlocks() {
    String boardInput =
        "◦●◦○◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦";
    testing(boardInput, 1, 1, 1);
  }

  @Test public void test_2ConnectedColorBlocks() {
    String boardInput =
        "◦●●○○"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦";
    testing(boardInput, 1, 1, 1);
  }

  @Test public void test_oneLShapeColorBlock() {
    String boardInput =
        "◦◦◦◦◦"
      + "◦●●◦◦"
      + "◦◦●◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦";
    testing(boardInput, 1, 1, 0);
  }

  @Test public void test_complicate_1() {
    String boardInput =
        "◦●●○○"
      + "●○○●○"
      + "●◦○●○"
      + "●●○●○"
      + "◦●●●◦";
    testing(boardInput, 4, 2, 2);
  }
}
