package com.pitayastudio.godzilla.moveanalyzer.killanalyzer;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.PositionStateChars;
import com.pitayastudio.godzilla.model.ColorBlock;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.modelboard.BlockBoard;
import com.pitayastudio.godzilla.modelboard.CoordBoard;
import com.pitayastudio.godzilla.moveanalyzer.TestUtils;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class BlockKillBySnapbackAnalyzerTest {

  private static void testing(String boardInput) {
    BlockBoard blockBoard = BlockBoard.readFromString(boardInput);
    CoordBoard coordBoard = blockBoard.getCoordBoard();
    ColorBlock targetBlockToKill = ColorBlock.readFromString(boardInput, coordBoard, Color.W,
        PositionStateChars.WHITE_EMPHASIZED);
    BlockKillBySnapbackAnalyzer analyzer = BlockKillBySnapbackAnalyzer.newBuilder()
        .setSemiRequiredBlockBoard(blockBoard)
        .setSemiRequiredCurrentMoveColor(Color.W)
        .setRequiredTargetBlock(targetBlockToKill)
        .build();
    List<Coord> bestMoveCoords = analyzer.getBestMoveCoords();
    Coord expectedMoveCoord = TestUtils.readExpectedMoveCoordFromString(boardInput, coordBoard);
    // TODO 490 Remove dummy expected value when tests are ready.
    expectedMoveCoord = coordBoard.getCoord(1, 1);
    Assert.assertTrue(bestMoveCoords.contains(expectedMoveCoord));
  }

  @Test public void test_01() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦●●●◦◦◦"
      + "◦◦○●◇◇●◦◦"
      + "◦○◦○A◦●◦◦"
      + "◦◦◦◦○●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_02() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●◦◦◦◦"
      + "●●◇◇◇●●◦◦"
      + "◦○●◦A○○◦◦"
      + "◦○◦●○◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_03() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦○◦◦◦◦◦◦"
      + "◦◦◦○●●◦◦◦"
      + "◦○○◦○●◦◦◦"
      + "○●●○A◇●●◦"
      + "◦◦◦●◦◇◇●◦";
    testing(boardInput);
  }

  @Test public void test_06() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○●◦◦"
      + "◦◦◦○○●◦●◦"
      + "◦◦●●●◇◇●◦"
      + "◦◦◦○○●A○◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_07() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦●●◦◦◦◦"
      + "◦◦●◇◇●◦◦◦"
      + "◦◦●◦◇●●●◦"
      + "◦○○●◇◇●○◦"
      + "◦◦◦○A●○○◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_08() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦A○○◦◦"
      + "◦◦◦●◇●○◦◦"
      + "◦◦◦●◇◦●○◦"
      + "◦◦◦◦●●◦○◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_09() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦●◦●○◦"
      + "◦◦◦◦◦◦●○◦"
      + "◦○○●●●○◦◦"
      + "◦○●◇◇●○◦◦"
      + "◦◦●◦A○○◦◦";
    testing(boardInput);
  }

  @Test public void test_10() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○○○○◦"
      + "◦◦◦○◦●●●○"
      + "◦◦◦○●◦●◇A"
      + "◦◦◦◦●◦●◇◦";
    testing(boardInput);
  }

  @Test public void test_11() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦●●○◦◦"
      + "◦●●●◇●○◦◦"
      + "◦●◇◇◇●○◦◦"
      + "◦A◇◦●○○◦◦";
    testing(boardInput);
  }

  @Test public void test_12() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦○○●●●●◦"
      + "○◦○●◇◇◇●◦"
      + "◦◦◦●●◇●○◦"
      + "◦◦◦◦A◇◦●◦";
    testing(boardInput);
  }

  @Test public void test_13() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦●●◦◦◦"
      + "◦◦◦●◇◇●◦◦"
      + "◦◦○○A◇●◦◦"
      + "◦◦○●◦◇●◦◦"
      + "◦◦◦◦●●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_14() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○◦●◦◦"
      + "◦◦◦●○A◦◦◦"
      + "◦◦●◇●◇●◦◦"
      + "◦◦●◇◦◇●◦◦"
      + "◦○●◇◇◇●○◦"
      + "◦○○●●●○◦○"
      + "◦◦◦◦◦◦◦○◦";
    testing(boardInput);
  }

  @Test public void test_17() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦◦"
      + "◦◦○◦●◇◇●◦"
      + "◦◦◦○○A◇●◦"
      + "◦◦◦◦●◦◇●◦";
    testing(boardInput);
  }

  @Test public void test_18() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦"
      + "◦◦●◦◦◦○◦◦"
      + "◦◦◦◦●●◦◦◦"
      + "◦○●●◇●○○◦"
      + "◦○●◇◇◇●●○"
      + "◦◦○A◦●◦◦◦";
    testing(boardInput);
  }

  @Test public void test_19() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦"
      + "◦◦◦◦◦◦◦○◦"
      + "◦◦○●◦●●○◦"
      + "◦○◦○●●◇●◦"
      + "◦◦◦○●◇◇●◦"
      + "◦◦◦◦○A◦●◦";
    testing(boardInput);
  }

  @Test public void test_20() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦●◇●●◦"
      + "◦◦◦●◇◇◇●○"
      + "◦◦◦●◇◦●○○"
      + "◦◦◦◦A●○◦◦";
    testing(boardInput);
  }

  @Test public void test_22() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●●◦◦◦"
      + "◦●◇◇◇●○◦◦"
      + "◦●◇◦●○○◦◦"
      + "◦●◇◇◇A◦◦◦"
      + "◦◦●●●◦○◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_23() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●◦◦◦◦○◦"
      + "○○●◦◦◦◦◦◦"
      + "○●◇●●●●○◦"
      + "◦●◇◇◇◇●○◦"
      + "◦●◇◦●A○○◦";
    testing(boardInput);
  }

  @Test public void test_24() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦●◦"
      + "◦◦◦◦◦○○●◦"
      + "◦◦◦◦◦○●◦◦"
      + "◦◦◦◦○●●●●"
      + "◦◦◦◦○●◇◇◇"
      + "◦◦◦◦○○A●◦";
    testing(boardInput);
  }

  @Test public void test_25() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○◦○○◦"
      + "◦◦◦◦◦◦◦●◦"
      + "◦◦◦●●○○●◦"
      + "◦◦◦●◇●○●◦"
      + "◦◦◦A◇◦●◦◦";
    testing(boardInput);
  }

  @Test public void test_26() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦○○○○○◦◦"
      + "◦●○●●●◦◦◦"
      + "◦◦●◇◦●○◦◦"
      + "◦◦●◇●○◦○◦"
      + "◦◦●A○◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_27() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦●●●●◦◦"
      + "◦◦◦●◇◇◇●◦"
      + "◦◦○○●◦◇●◦"
      + "◦◦◦◦○●◇●◦"
      + "◦◦◦◦◦●◇A◦";
    testing(boardInput);
  }

  @Test public void test_28() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦●●●●◦"
      + "◦◦●●◇◇◇●◦"
      + "◦○◦○●◦◇●◦"
      + "◦◦◦○○●◇●◦"
      + "◦◦◦◦◦A◇●◦";
    testing(boardInput);
  }

  @Test public void test_29() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●●◦◦◦"
      + "◦●◇◇◇●◦◦◦"
      + "◦●◇◦●○●●◦"
      + "◦●◇A○○○○◦"
      + "◦◦●◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_30() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦"
      + "◦◦●●●●◦◦◦"
      + "●●◇◇◇●○◦◦"
      + "●◇◇◦●○◦○◦"
      + "◦A●●○○◦◦◦";
    testing(boardInput);
  }

  @Test public void test_32() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦●◦"
      + "◦○○●●●●●○"
      + "◦○●◇◇◇●○◦"
      + "◦◦●◇◦A○○○"
      + "◦◦●●◇◇●◦◦";
    testing(boardInput);
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////
  // Special cases:

  @Test public void test_killBySnapbackWithJie() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○○◦"
      + "◦◦◦◦●●●○◦"
      + "◦○◦○●◇◇●●"
      + "◦◦◦○○●◇●◦"
      + "◦◦◦◦●◦◇◇A";
    testing(boardInput);
  }

  @Test public void test_template() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "A◇◦◦◦◦◦◦◦";
    testing(boardInput);
  }
}
