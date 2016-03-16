package com.pitayastudio.godzilla.modelboard;

import com.pitayastudio.godzilla.model.ColorBlock;
import com.pitayastudio.godzilla.model.VacantBlock;

import junit.framework.TestCase;

import org.junit.Test;

public class NeighborhoodBoardQisTest extends TestCase {

  /**
   * @param containedXPositForTargetBlock xPosit used for identifying Block
   * @param containedYPositForTargetBlock yPosit used for identifying Block
   */
  private static void testing(
      String boardInput,
      String expectedBoard,
      int containedXPositForTargetBlock,
      int containedYPositForTargetBlock) {
    BlockBoard blockBoard = BlockBoard.readFromString(boardInput);
    assertEquals(boardInput, blockBoard.toString().replaceAll("\n", ""));

    if (blockBoard.getPositionStateBoard()
        .getPositionState(containedXPositForTargetBlock, containedYPositForTargetBlock)
        .isVacant()) {
      VacantBlock vacantBlock = blockBoard.getVacantBlock(
          containedXPositForTargetBlock, containedYPositForTargetBlock);
      NeighborhoodBoard neighborhoodBoard = NeighborhoodBoard.newBuilder()
          .setRequiredBlockBoard(blockBoard).build();
      String result = neighborhoodBoard.drawVacantBlockWithNeighborhoods(vacantBlock);
      assertEquals(expectedBoard, result.replaceAll("\n", ""));
    } else {
      ColorBlock colorBlock = blockBoard.getColorBlock(
          containedXPositForTargetBlock, containedYPositForTargetBlock);
      String result =
          VisualBoard.drawColorBlockWithNeighborhoodsAndQis(colorBlock, blockBoard);
      assertEquals(expectedBoard, result.replaceAll("\n", ""));
    }
  }

  @Test public void test_oneFullVacantBlock() {
    String boardInput =
        "◦◦◦"
      + "◦◦◦"
      + "◦◦◦";
    String expectedBoard =
        "▫▫▫"
      + "▫▫▫"
      + "▫▫▫";
    testing(boardInput, expectedBoard, 1, 1);
  }

  @Test public void test_oneBlackBlock_2() {
    String boardInput =
        "◦◦◦"
      + "◦●◦"
      + "◦◦◦";
    String expectedBoard =
        "◦θ◦"
      + "θ●θ"
      + "◦θ◦";
    testing(boardInput, expectedBoard, 2, 2);
  }

  @Test public void test_oneBlackOneWhite_2() {
    String boardInput =
        "◦◦◦"
      + "◦●○"
      + "◦◦◦";
    String expectedBoard =
        "◦θ◦"
      + "θ●○"
      + "◦θ◦";
    testing(boardInput, expectedBoard, 2, 2);
  }

  @Test public void test_oneBlackOneWhite_3() {
    String boardInput =
        "◦◦◦"
      + "◦●○"
      + "◦◦◦";
    String expectedBoard =
        "◦◦θ"
      + "◦●○"
      + "◦◦θ";
    testing(boardInput, expectedBoard, 3, 2);
  }

  @Test public void test_oneSideBlack_up_2() {
    String boardInput =
        "◦●◦"
      + "◦◦◦"
      + "◦◦◦";
    String expectedBoard =
        "θ●θ"
      + "◦θ◦"
      + "◦◦◦";
    testing(boardInput, expectedBoard, 2, 3);
  }

  @Test public void test_oneSideBlack_left_2() {
    String boardInput =
        "◦◦◦"
      + "●◦◦"
      + "◦◦◦";
    String expectedBoard =
        "θ◦◦"
      + "●θ◦"
      + "θ◦◦";
    testing(boardInput, expectedBoard, 1, 2);
  }

  @Test public void test_twoSideBlacks_2() {
    String boardInput =
        "◦●◦"
      + "●◦◦"
      + "◦◦◦";
    String expectedBoard =
        "θ●θ"
      + "◦θ◦"
      + "◦◦◦";
    testing(boardInput, expectedBoard, 2, 3);
  }

  @Test public void test_twoSideBlacks_3() {
    String boardInput =
        "◦●◦"
      + "●◦◦"
      + "◦◦◦";
    String expectedBoard =
        "θ◦◦"
      + "●θ◦"
      + "θ◦◦";
    testing(boardInput, expectedBoard, 1, 2);
  }

  @Test public void test_complicate_2() {
    String boardInput =
        "◦●●○○"
      + "●○○●○"
      + "●◦○●○"
      + "●●○●○"
      + "◦●●●◦";
    String expectedBoard =
        "θ●●○○"
      + "◦○○◦○"
      + "◦◦○◦○"
      + "◦◦○◦○"
      + "◦◦◦◦◦";
    testing(boardInput, expectedBoard, 2, 5);
  }

  @Test public void test_complicate_3() {
    String boardInput =
        "◦●●○○"
      + "●○○●○"
      + "●◦○●○"
      + "●●○●○"
      + "◦●●●◦";
    String expectedBoard =
        "◦●●○○"
      + "●◦◦●○"
      + "●◦◦●○"
      + "●●◦●○"
      + "◦●●●θ";
    testing(boardInput, expectedBoard, 4, 5);
  }

  @Test public void test_complicate_4() {
    String boardInput =
        "◦●●○○"
      + "●○○●○"
      + "●◦○●○"
      + "●●○●○"
      + "◦●●●◦";
    String expectedBoard =
        "θ◦◦○○"
      + "●○○●○"
      + "●θ○●○"
      + "●●○●○"
      + "θ●●●θ";
    testing(boardInput, expectedBoard, 1, 4);
  }

  @Test public void test_complicate_5() {
    String boardInput =
        "◦●●○○"
      + "●○○●○"
      + "●◦○●○"
      + "●●○●○"
      + "◦●●●◦";
    String expectedBoard =
        "◦●●◦◦"
      + "●○○●◦"
      + "●θ○●◦"
      + "●●○●◦"
      + "◦●●●◦";
    testing(boardInput, expectedBoard, 2, 4);
  }
}
