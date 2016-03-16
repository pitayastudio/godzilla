package com.pitayastudio.godzilla.modelboard;

import junit.framework.TestCase;

import org.junit.Test;

public class BlockBoardWithoutAnyQiTest extends TestCase {

  private static void testing(
      String boardInput,
      String expectedBoard) {
    BlockBoard blockBoard = BlockBoard.readFromString(boardInput);
    assertEquals(boardInput, blockBoard.toString().replaceAll("\n", ""));
    String actualBoard = VisualBoard.drawBlocksWithoutAnyQis(blockBoard);
    assertEquals(expectedBoard, actualBoard.replaceAll("\n", ""));
  }

  @Test public void test_01() {
    String boardInput =
        "◦◦◦"
      + "◦◦◦"
      + "◦◦◦";
    String expectedBoard =
        "◦◦◦"
      + "◦◦◦"
      + "◦◦◦";
    testing(boardInput, expectedBoard);
  }

  @Test public void test_02() {
    String boardInput =
        "●●●"
      + "●●●"
      + "●●●";
    String expectedBoard =
        "●●●"
      + "●●●"
      + "●●●";
    testing(boardInput, expectedBoard);
  }

  @Test public void test_03() {
    String boardInput =
        "○○○"
      + "○○○"
      + "○○○";
    String expectedBoard =
        "○○○"
      + "○○○"
      + "○○○";
    testing(boardInput, expectedBoard);
  }

  @Test public void test_04() {
    String boardInput =
        "◦◦◦"
      + "◦●◦"
      + "◦◦◦";
    String expectedBoard =
        "◦◦◦"
      + "◦◦◦"
      + "◦◦◦";
    testing(boardInput, expectedBoard);
  }

  @Test public void test_05() {
    String boardInput =
        "◦◦◦"
      + "◦●○"
      + "◦◦◦";
    String expectedBoard =
        "◦◦◦"
      + "◦◦◦"
      + "◦◦◦";
    testing(boardInput, expectedBoard);
  }

  @Test public void test_06() {
    String boardInput =
        "◦◦●"
      + "◦●○"
      + "◦◦●";
    String expectedBoard =
        "◦◦◦"
      + "◦◦○"
      + "◦◦◦";
    testing(boardInput, expectedBoard);
  }

  @Test public void test_07() {
    String boardInput =
        "○●◦"
      + "●●◦"
      + "○●◦";
    String expectedBoard =
        "○◦◦"
      + "◦◦◦"
      + "○◦◦";
    testing(boardInput, expectedBoard);
  }

  @Test public void test_08() {
    String boardInput =
        "○○○"
      + "●●●"
      + "●◦●";
    String expectedBoard =
        "○○○"
      + "◦◦◦"
      + "◦◦◦";
    testing(boardInput, expectedBoard);
  }

  @Test public void test_09() {
    String boardInput =
        "○●○"
      + "●◦●"
      + "○●○";
    String expectedBoard =
        "○◦○"
      + "◦◦◦"
      + "○◦○";
    testing(boardInput, expectedBoard);
  }

  @Test public void test_10() {
    String boardInput =
        "◦●●○○"
      + "●○○●○"
      + "●◦○●○"
      + "●●○●○"
      + "◦●●●◦";
    String expectedBoard =
        "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦";
    testing(boardInput, expectedBoard);
  }

  @Test public void test_11() {
    String boardInput =
        "◦●●○○"
      + "●○○●○"
      + "●◦○●○"
      + "●◦○●○"
      + "○●●●◦";
    String expectedBoard =
        "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "○◦◦◦◦";
    testing(boardInput, expectedBoard);
  }
}
