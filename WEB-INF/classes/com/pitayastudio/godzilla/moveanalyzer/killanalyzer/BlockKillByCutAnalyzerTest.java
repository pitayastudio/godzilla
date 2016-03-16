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

public class BlockKillByCutAnalyzerTest {

  private static void testing(String boardInput) {
    BlockBoard blockBoard = BlockBoard.readFromString(boardInput);
    CoordBoard coordBoard = blockBoard.getCoordBoard();
    ColorBlock targetBlockToKill = ColorBlock.readFromString(boardInput, coordBoard, Color.W,
        PositionStateChars.WHITE_EMPHASIZED);
    BlockKillByCutAnalyzer analyzer = BlockKillByCutAnalyzer.newBuilder()
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
      + "◦◦◦●◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦"
      + "◦◦◦●◦○◦◦◦"
      + "◦◦◦◦●○A◦◦"
      + "◦◦◦◦●●◇◦◦";
    testing(boardInput);
  }

  @Test public void test_02() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○◦○◦◦"
      + "◦◦◦○◦◦◦◦◦"
      + "◦◦●○●◦○◦◦"
      + "◦◦●●◇A○◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_03() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●◦◦◦"
      + "◦◦◦○◦●◦◦◦"
      + "◦○◦○A◇●◦◦"
      + "◦◦◦◦◦◦●◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_04() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦○○○●●◦◦◦"
      + "○●●●◇●◦◦◦"
      + "○●◦◦◇●◦◦◦"
      + "○◦◦◦A◦◦◦◦"
      + "◦○◦○○◦●◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_05() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦"
      + "◦◦◦○●●○◦◦"
      + "◦◦○●◇◇●●◦"
      + "◦◦◦●◦A○◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_06() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦●◦◦●◦◦"
      + "◦◦○●◦◦◦◦◦"
      + "◦◦○○●●◦◦◦"
      + "◦◦◦A◇◇●◦◦"
      + "◦◦◦◦◦●◦◦◦";
    testing(boardInput);
  }

  @Test public void test_07() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦"
      + "◦◦◦◦◦●○◦◦"
      + "◦◦◦○A◇●◦◦"
      + "◦◦○◦◦◇●◦◦"
      + "◦◦◦◦●●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_08() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦●◦◦"
      + "◦◦◦◦◦◦◦●●"
      + "◦◦◦◦◦●●◇◇"
      + "◦◦●●●○○A◦"
      + "◦◦◦○○◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_09() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦●◦"
      + "◦◦◦●●●●◦◦"
      + "◦◦○●◇◇◇●●"
      + "◦○◦○●◦A○○"
      + "◦◦○◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_10() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦●◦◦"
      + "◦◦◦◦◦◦◦●◦"
      + "◦◦◦◦◦●●○◦"
      + "◦◦●●●○○○◦"
      + "◦◦●◇◇A◦◦◦"
      + "◦◦◦●◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_11() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦"
      + "◦◦◦○◦◦●●◦"
      + "◦◦◦◦◦●◦◦◦"
      + "◦◦◦○○A◇◇◦"
      + "◦◦●●●◦●◇◦"
      + "◦◦◦◦◦◦●◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_12() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦●◦◦"
      + "◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦●◇◦◦"
      + "◦◦◦○◦A◇◦◦"
      + "◦○◦◦○◦◦●◦"
      + "◦◦◦◦◦◦●◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_13() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●◦◦"
      + "◦◦◦○A◇◦●◦"
      + "◦◦◦◦●◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_14() {
    testing(
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦○●●●●◦◦"
      + "◦◦◦○●◇◦◦◦"
      + "◦◦○◦○A◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void test_15() {
    testing(
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦◦◦◦"
      + "◦◦○●●●◦◦◦"
      + "◦◦A◇●◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void test_16() {
    testing(
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦●◦◦"
      + "◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦○◦◦●◦"
      + "◦◦◦◦◦○A◦◦"
      + "◦◦◦◦●●◇◇◦"
      + "◦◦◦◦◦◦●◇◦"
      + "◦◦◦◦◦●◦●◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void test_17() {
    testing(
        "◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦○◦"
      + "◦◦◦◦◦●●◇◇◦◦"
      + "◦◦◦◦○●◇●◦○◦"
      + "◦○◦◦A◇◇●◦◦◦"
      + "◦◦◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦");
  }

  @Test public void test_18() {
    testing(
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦"
      + "◦◦◦◦◦○◦◦◦"
      + "◦◦●●●○◦◦◦"
      + "◦◦◦◇●○◦◦◦"
      + "◦◦◦◇A◦◦◦◦");
  }

  @Test public void test_19() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦○◦○◦●◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●○○◦●◦◦"
      + "◦◦●◦A●◦◦◦"
      + "◦●◦◦◇◇●◦◦"
      + "◦◦◦◦◇◇◦◦◦";
    testing(boardInput);
  }

  @Test public void test_20() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦●●○○◦◦"
      + "◦◦◦●◇A◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_21() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦●◦◦"
      + "◦◦◦◦◦●◇●◦"
      + "◦◦○◦◦●◇●◦"
      + "○○◦○◦●◇◇◦"
      + "◦◦◦◦○A◦◇◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_22() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦●◦○◦◦"
      + "◦◦◦◦◦●◦○◦"
      + "◦◦◦◦●◦◦○○"
      + "◦◦◦●◦◦A◦○"
      + "◦●◦●●◇◦●○"
      + "◦◦◦◇◇◇◦●○";
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
