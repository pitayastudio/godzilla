package com.pitayastudio.godzilla.modelboard;

import junit.framework.TestCase;

import org.junit.Test;

public class NeighborhoodBoardTest extends TestCase {

  private static void testing(
      String boardInput,
      int xPosition,
      int yPosition,
      String expectedOutput) {
    NeighborhoodBoard neighborhoodBoard = NeighborhoodBoard.readFromString(boardInput);
    String blockAsString =
        neighborhoodBoard.drawBlockAtCoordWithNeighborhoods(xPosition, yPosition);
    assertEquals(expectedOutput, blockAsString.replace("\n", ""));
  }

  @Test public void testGetNeighborBlocks_01() {
    String boardInput =
        "◦◦◦"
      + "◦◦◦"
      + "◦◦◦";
    testing(boardInput, 2, 2,
        "▫▫▫"
      + "▫▫▫"
      + "▫▫▫");
  }

  @Test public void testGetNeighborBlocks_02() {
    String boardInput =
        "◦◦◦"
      + "◦○◦"
      + "◦◦◦";
    testing(boardInput, 1, 1,
        "▫▫▫"
      + "▫○▫"
      + "▫▫▫");
  }

  @Test public void testGetNeighborBlocks_03() {
    String boardInput =
        "◦◦◦"
      + "◦●◦"
      + "◦◦◦";
    testing(boardInput, 1, 2,
        "▫▫▫"
      + "▫●▫"
      + "▫▫▫");
  }

  @Test public void testGetNeighborBlocks_04() {
    String boardInput =
        "◦◦◦"
      + "◦●◦"
      + "◦◦◦";
    testing(boardInput, 1, 2,
        "▫▫▫"
      + "▫●▫"
      + "▫▫▫");
  }

  @Test public void testGetNeighborBlocks_05() {
    String boardInput =
        "◦◦◦"
      + "◦●○"
      + "◦◦◦";
    testing(boardInput, 1, 1,
        "▫▫▫"
      + "▫●○"
      + "▫▫▫");
  }

  @Test public void testGetNeighborBlocks_06() {
    String boardInput =
        "◦◦◦"
      + "◦●○"
      + "◦◦◦";
    testing(boardInput, 2, 2,
        "▫▫▫"
      + "▫◆○"
      + "▫▫▫");
  }

  @Test public void testGetNeighborBlocks_07() {
    String boardInput =
        "◦◦◦"
      + "◦●○"
      + "◦◦◦";
    testing(boardInput, 3, 2,
        "▫▫▫"
      + "▫●◇"
      + "▫▫▫");
  }

  @Test public void testGetNeighborBlocks_08() {
    String boardInput =
        "◦●◦"
      + "◦◦◦"
      + "◦◦◦";
    testing(boardInput, 2, 2,
        "▫●▫"
      + "▫▫▫"
      + "▫▫▫");
  }

  @Test public void testGetNeighborBlocks_09() {
    String boardInput =
        "◦●◦"
      + "◦◦◦"
      + "◦◦◦";
    testing(boardInput, 2, 3,
        "▫◆▫"
      + "▫▫▫"
      + "▫▫▫");
  }

  @Test public void testGetNeighborBlocks_10() {
    String boardInput =
        "◦◦◦"
      + "●◦◦"
      + "◦◦◦";
    testing(boardInput, 2, 2,
        "▫▫▫"
      + "●▫▫"
      + "▫▫▫");
  }

  @Test public void testGetNeighborBlocks_11() {
    String boardInput =
        "◦◦◦"
      + "●◦◦"
      + "◦◦◦";
    testing(boardInput, 1, 2,
        "▫▫▫"
      + "◆▫▫"
      + "▫▫▫");
  }

  @Test public void testGetNeighborBlocks_12() {
    String boardInput =
        "◦●●"
      + "◦◦◦"
      + "◦◦◦";
    testing(boardInput, 2, 2,
        "▫●●"
      + "▫▫▫"
      + "▫▫▫");
  }

  @Test public void testGetNeighborBlocks_13() {
    String boardInput =
        "◦●●"
      + "◦◦◦"
      + "◦◦◦";
    testing(boardInput, 2, 3,
        "▫◆◆"
      + "▫▫▫"
      + "▫▫▫");
  }

  @Test public void testGetNeighborBlocks_14() {
    String boardInput =
        "◦◦◦"
      + "●◦◦"
      + "●◦◦";
    testing(boardInput, 2, 2,
        "▫▫▫"
      + "●▫▫"
      + "●▫▫");
  }

  @Test public void testGetNeighborBlocks_15() {
    String boardInput =
        "◦◦◦"
      + "●◦◦"
      + "●◦◦";
    testing(boardInput, 1, 2,
        "▫▫▫"
      + "◆▫▫"
      + "◆▫▫");
  }

  @Test public void testGetNeighborBlocks_16() {
    String boardInput =
        "◦●◦"
      + "●◦◦"
      + "◦◦◦";
    testing(boardInput, 1, 3,
        "▫●◦"
      + "●◦◦"
      + "◦◦◦");
  }

  @Test public void testGetNeighborBlocks_17() {
    String boardInput =
        "◦●◦"
      + "●◦◦"
      + "◦◦◦";
    testing(boardInput, 2, 3,
        "▫◆▫"
      + "◦▫▫"
      + "▫▫▫");
  }

  @Test public void testGetNeighborBlocks_18() {
    String boardInput =
        "◦●◦"
      + "●◦◦"
      + "◦◦◦";
    testing(boardInput, 1, 2,
        "▫◦▫"
      + "◆▫▫"
      + "▫▫▫");
  }

  @Test public void testGetNeighborBlocks_19() {
    String boardInput =
        "◦◦◦◦◦"
      + "○○○○◦"
      + "○●◦○◦"
      + "●○○○◦"
      + "◦◦◦◦◦";
    testing(boardInput, 3, 3,
        "◦◦◦◦◦"
      + "○○○○◦"
      + "○●▫○◦"
      + "◦○○○◦"
      + "◦◦◦◦◦");
  }

  @Test public void testGetNeighborBlocks_20() {
    String boardInput =
        "◦●●○○"
      + "●○○●○"
      + "●◦○●○"
      + "●●○●○"
      + "◦●●●◦";
    testing(boardInput, 1, 5,
        "▫●●◦◦"
      + "●◦◦●◦"
      + "●◦◦●◦"
      + "●●◦●◦"
      + "◦●●●◦");
  }

  @Test public void testGetNeighborBlocks_21() {
    String boardInput =
        "◦●●○○"
      + "●○○●○"
      + "●◦○●○"
      + "●●○●○"
      + "◦●●●◦";
    testing(boardInput, 2, 5,
        "▫◆◆○○"
      + "◦○○◦○"
      + "◦◦○◦○"
      + "◦◦○◦○"
      + "◦◦◦◦◦");
  }

  @Test public void testGetNeighborBlocks_22() {
    String boardInput =
        "◦●●○○"
      + "●○○●○"
      + "●◦○●○"
      + "●●○●○"
      + "◦●●●◦";
    testing(boardInput, 4, 5,
        "◦●●◇◇"
      + "●◦◦●◇"
      + "●◦◦●◇"
      + "●●◦●◇"
      + "◦●●●▫");
  }

  @Test public void testGetNeighborBlocks_23() {
    String boardInput =
        "◦●●○○"
      + "●○○●○"
      + "●◦○●○"
      + "●●○●○"
      + "◦●●●◦";
    testing(boardInput, 1, 4,
        "▫◦◦○○"
      + "◆○○◆○"
      + "◆▫○◆○"
      + "◆◆○◆○"
      + "▫◆◆◆▫");
  }

  @Test public void testGetNeighborBlocks_24() {
    String boardInput =
        "◦●●○○"
      + "●○○●○"
      + "●◦○●○"
      + "●●○●○"
      + "◦●●●◦";
    testing(boardInput, 2, 4,
        "◦●●◦◦"
      + "●◇◇●◦"
      + "●▫◇●◦"
      + "●●◇●◦"
      + "◦●●●◦");
  }

  @Test public void testGetNeighborBlocks_25() {
    String boardInput =
        "◦●●○○"
      + "●○○●○"
      + "●◦○●○"
      + "●●○●○"
      + "◦●●●◦";
    testing(boardInput, 2, 3,
        "◦◦◦◦◦"
      + "●○○●◦"
      + "●▫○●◦"
      + "●●○●◦"
      + "◦●●●◦");
  }

  @Test public void testGetNeighborBlocks_26() {
    String boardInput =
        "◦●●○○"
      + "●○○●○"
      + "●◦○●○"
      + "●●○●○"
      + "◦●●●◦";
    testing(boardInput, 1, 1,
        "◦◦◦◦◦"
      + "●◦◦●◦"
      + "●◦◦●◦"
      + "●●◦●◦"
      + "▫●●●◦");
  }

  @Test public void testGetNeighborBlocks_27() {
    String boardInput =
        "◦●●○○"
      + "●○○●○"
      + "●◦○●○"
      + "●●○●○"
      + "◦●●●◦";
    testing(boardInput, 5, 1,
        "◦◦◦○○"
      + "●◦◦●○"
      + "●◦◦●○"
      + "●●◦●○"
      + "◦●●●▫");
  }
}
