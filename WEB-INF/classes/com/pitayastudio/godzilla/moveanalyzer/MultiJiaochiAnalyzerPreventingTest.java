package com.pitayastudio.godzilla.moveanalyzer;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.PositionStateChars;
import com.pitayastudio.godzilla.model.ColorBlock;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.modelboard.BlockBoard;
import com.pitayastudio.godzilla.modelboard.CoordBoard;
import com.pitayastudio.godzilla.modelboard.LandBoard;
import com.pitayastudio.godzilla.modelboard.LotBoard;
import com.pitayastudio.godzilla.modelboard.NeighborhoodBoard;

import org.junit.Assert;
import org.junit.Test;

public class MultiJiaochiAnalyzerPreventingTest {
  private static void testing(String boardInput) {
    LotBoard lotBoard = LotBoard.readFromString(boardInput);
    LandBoard landBoard = lotBoard.getLandBoard();
    NeighborhoodBoard neighborhoodBoard = landBoard.getNeighborhoodBoard();
    BlockBoard blockBoard = neighborhoodBoard.getBlockBoard();
    ImmutableSet<ColorBlock> targetBlocks = ColorBlock.readColorBlocksFromString(
        boardInput, blockBoard, PositionStateChars.BLACK_EMPHASIZED);
    MultiJiaochiAnalyzer analyzer = MultiJiaochiAnalyzer.newBuilder()
        .setSemiRequiredCurrentMoveColor(Color.B)
        .setSemiRequiredBlockBoard(blockBoard)
        .setRequiredTargetBlocks(targetBlocks)
        .setReverseMode()
        .build();
    ImmutableList<Coord> bestMoveCoords = analyzer.getBestMoveCoords();
    CoordBoard coordBoard = blockBoard.getCoordBoard();
    Coord expectedMoveCoord = TestUtils.readExpectedMoveCoordFromString(boardInput, coordBoard);
    // TODO 490 Remove dummy expected value when tests are ready.
    expectedMoveCoord = coordBoard.getCoord(1, 1);
    Assert.assertTrue(bestMoveCoords.contains(expectedMoveCoord));
  }

  @Test public void test_07() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦○◆A◦◦◦◦"
      + "◦◦◦○◆◦●◦◦"
      + "◦◦◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_08() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦●◦◦◦◦"
      + "◦◦◦●◦◦◦◦◦"
      + "◦◦○○◆A◦◦◦"
      + "◦◦◦◦○◆◦●◦"
      + "◦◦◦◦○○●◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_09() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◆A◦◦◦"
      + "◦◦◦◦○◆◦◦◦"
      + "◦◦◦○◦○●●◦"
      + "◦◦◦◦◦○○●◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_10() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦●◦◦◦◦◦"
      + "◦◦◦◦◆A◦◦◦"
      + "◦◦◦○○◆○◦◦"
      + "◦◦◦○●◦◦◦◦"
      + "◦◦◦○●◦●◦◦"
      + "◦◦◦◦●◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_11() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○◦●◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○○●◦◦◦"
      + "◦○◦○◆◦●◦◦"
      + "◦◦○◆A◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_12() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦●●◦"
      + "◦◦◦◦A◆○○◦"
      + "◦◦●◦◆○●○◦"
      + "◦◦◦◦○○◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_19() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●●◦◦◦◦◦"
      + "◦◦◦◦○○○○◦"
      + "◦◦●●○◆●○◦"
      + "◦◦◦○●A◦●◦"
      + "◦○◦○◆◦●◦◦"
      + "◦◦◦○○●◦●◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_20() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦○◦◦◦◦○◦"
      + "◦◦◦◦○○○◦◦"
      + "◦◦◦○●●●○○"
      + "◦◦◦○◆◦A◆●"
      + "◦◦◦○○●◦○◦";
    testing(boardInput);
  }

  @Test public void test_21() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦●○○○◦◦"
      + "◦◦◦●○◆●○◦"
      + "◦◦●○◆A◦○◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_22() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦○○○◦◦"
      + "◦◦◦○◆●○◦◦"
      + "◦◦◦◦○●○◦○"
      + "◦◦○○○●●○◦"
      + "◦●○◆●A◦●◦"
      + "●◦●○◦◦●◦◦"
      + "◦●◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_23() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦●◦"
      + "◦◦◦◦◦A◆○◦"
      + "◦◦◦◦◦●○◦◦"
      + "◦◦◦◦○◆○◦◦"
      + "◦◦◦◦●○◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_24() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦"
      + "◦◦◦◦○○◦◦◦"
      + "◦○○○◆●○○◦"
      + "◦○◆●A◦●●○"
      + "◦◦○◦◦●◦●◦";
    testing(boardInput);
  }

  @Test public void test_26() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○◦◦◦◦"
      + "◦●◦●○◦◦○◦"
      + "●◦●◦◦○○◦◦"
      + "○●◦A◆●●○◦"
      + "○○◆●○○○◦◦"
      + "◦◦○○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_27() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○○◦○◦◦"
      + "◦◦○◆●○◦◦◦"
      + "◦●●◦◦◆○○◦"
      + "◦◦◦●◦A●●◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_28() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○◦○○◦"
      + "◦◦◦◦◦○●●◦"
      + "◦◦◦○○●○●◦"
      + "◦◦●●○◆A◦◦"
      + "◦◦●○◆◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_29() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦●◦◦"
      + "◦◦○◦○○●◦◦"
      + "◦◦◦◦○●◦◦◦"
      + "◦◦○○◆◦●◦◦"
      + "◦○○●A◦●◦◦"
      + "◦○◆●◦◦◦◦◦";
    testing(boardInput);
  }

  /**
   * 星位定石之一.
   */
  @Test public void test_30() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○◦◦◦"
      + "◦◦◦●◦◆○◦◦"
      + "◦◦◦◦A◦◆○◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_31() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦"
      + "◦◦◦○○○◦◦◦"
      + "◦●◦●○●○○○"
      + "◦◦◦●○◆A◆○"
      + "◦◦◦◦●◦●◦●"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  /**
   * 小雪崩定石.
   */
  @Test public void test_32() {
    // When black has ladder-advantage, choose B; otherwise, choose A.
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦AB◦◦"
      + "◦◦◦◦◦◦◆○◦"
      + "◦◦◦○◆●○○◦"
      + "◦◦◦◦○○●◦◦"
      + "◦◦◦◦◦◦●◦◦"
      + "◦◦◦◦◦◦◦◦◦";
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
      + "A◆◦◦◦◦◦◦◦";
    testing(boardInput);
  }
}
