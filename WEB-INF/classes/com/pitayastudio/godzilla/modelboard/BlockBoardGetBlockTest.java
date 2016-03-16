package com.pitayastudio.godzilla.modelboard;

import com.pitayastudio.godzilla.model.Block;

import junit.framework.TestCase;

import org.junit.Test;

public class BlockBoardGetBlockTest extends TestCase {

  private static void testing(
      String boardInput,
      int xPosition,
      int yPosition,
      String expectedBlock) {
    BlockBoard blockBoard = BlockBoard.readFromString(boardInput);
    Block block = blockBoard.getBlock(xPosition, yPosition);
    String blockAsString = block.toString();
    assertEquals(expectedBlock, blockAsString.replaceAll("\n", ""));
  }

  @Test public void test_02() {
    String boardInput =
        "●●●"
      + "●●●"
      + "●●●";
    String expectedBlock =
        "●●●"
      + "●●●"
      + "●●●";
    testing(boardInput, 1, 1, expectedBlock);
  }

  @Test public void test_03() {
    String boardInput =
        "○○○"
      + "○○○"
      + "○○○";
    String expectedBlock =
        "○○○"
      + "○○○"
      + "○○○";
    testing(boardInput, 1, 1, expectedBlock);
  }

  @Test public void test_04() {
    String boardInput =
        "◦◦◦"
      + "◦◦◦"
      + "●◦◦";
    testing(boardInput, 1, 1,
        "◦◦◦"
      + "◦◦◦"
      + "●◦◦");
    testing(boardInput, 1, 2,
        "▫▫▫"
      + "▫▫▫"
      + "◦▫▫");
  }

  @Test public void test_05() {
    String boardInput =
        "◦◦●"
      + "◦◦◦"
      + "◦◦◦";
    testing(boardInput, 3, 3,
        "◦◦●"
      + "◦◦◦"
      + "◦◦◦");
    testing(boardInput, 1, 3,
        "▫▫◦"
      + "▫▫▫"
      + "▫▫▫");
  }

  @Test public void test_06() {
    String boardInput =
        "◦●◦"
      + "◦●◦"
      + "◦◦◦";
    testing(boardInput, 2, 2,
        "◦●◦"
      + "◦●◦"
      + "◦◦◦");
    testing(boardInput, 2, 1,
        "▫◦▫"
      + "▫◦▫"
      + "▫▫▫");
  }

  @Test public void test_07() {
    String boardInput =
        "◦◦◦"
      + "●●◦"
      + "◦◦◦";
    testing(boardInput, 1, 2,
        "◦◦◦"
      + "●●◦"
      + "◦◦◦");
    testing(boardInput, 2, 3,
        "▫▫▫"
      + "◦◦▫"
      + "▫▫▫");
  }

  @Test public void test_08() {
    String boardInput =
        "◦◦○"
      + "●●○"
      + "◦●◦";
    testing(boardInput, 1, 2,
        "◦◦◦"
      + "●●◦"
      + "◦●◦");
    testing(boardInput, 1, 1,
        "◦◦◦"
      + "◦◦◦"
      + "▫◦◦");
    testing(boardInput, 3, 1,
        "◦◦◦"
      + "◦◦◦"
      + "◦◦▫");
    testing(boardInput, 1, 3,
        "▫▫◦"
      + "◦◦◦"
      + "◦◦◦");
    testing(boardInput, 3, 3,
        "◦◦○"
      + "◦◦○"
      + "◦◦◦");
  }

  @Test public void test_09() {
    String boardInput =
        "◦◦◦◦◦"
      + "●●○○◦"
      + "●◦●○◦"
      + "●●○○●"
      + "◦◦◦●◦";
    testing(boardInput, 1, 1,
        "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "▫▫▫◦◦");
    testing(boardInput, 1, 2,
        "◦◦◦◦◦"
      + "●●◦◦◦"
      + "●◦◦◦◦"
      + "●●◦◦◦"
      + "◦◦◦◦◦");
    testing(boardInput, 1, 5,
        "▫▫▫▫▫"
      + "◦◦◦◦▫"
      + "◦◦◦◦▫"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦");
    testing(boardInput, 2, 3,
        "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦▫◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦");
    testing(boardInput, 3, 2,
        "◦◦◦◦◦"
      + "◦◦○○◦"
      + "◦◦◦○◦"
      + "◦◦○○◦"
      + "◦◦◦◦◦");
    testing(boardInput, 3, 3,
        "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦●◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦");
    testing(boardInput, 4, 1,
        "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦●◦");
    testing(boardInput, 5, 1,
        "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦▫");
    testing(boardInput, 5, 2,
        "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦●"
      + "◦◦◦◦◦");
  }
}
