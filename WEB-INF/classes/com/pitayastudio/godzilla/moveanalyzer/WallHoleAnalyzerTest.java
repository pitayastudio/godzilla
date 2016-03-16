package com.pitayastudio.godzilla.moveanalyzer;

import com.google.common.collect.ImmutableList;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.model.VacantBlock;
import com.pitayastudio.godzilla.modelboard.BlockBoard;
import com.pitayastudio.godzilla.modelboard.CoordBoard;

import org.junit.Assert;
import org.junit.Test;

public class WallHoleAnalyzerTest {
  private static void testing(String boardInput) {
    BlockBoard blockBoard = BlockBoard.readFromString(boardInput);
    CoordBoard coordBoard = blockBoard.getCoordBoard();
    Coord expectedMoveCoord = TestUtils.readExpectedMoveCoordFromString(boardInput, coordBoard);
    VacantBlock vacantBlockWithHoleToFix = blockBoard.getVacantBlock(
        expectedMoveCoord.getXPosition(), expectedMoveCoord.getYPosition());
    WallHoleAnalyzer wallHoleAnalyzer = WallHoleAnalyzer.newBuilder()
        .setSemiRequiredBlockBoard(blockBoard)
        .setSemiRequiredCurrentMoveColor(Color.W)
        .setRequiredVacantBlockWithWallHoleToFix(vacantBlockWithHoleToFix)
        .build();
    ImmutableList<Coord> bestMoveCoords = wallHoleAnalyzer.getBestMoveCoords();
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
      + "◦◦◦◦◦◦○○○"
      + "◦◦○○○○●●●"
      + "◦◦○●●A◦◦◦"
      + "◦◦○●◦◦◦●◦"
      + "◦◦○●◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_02() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○○◦○◦◦"
      + "◦◦◦○●○◦◦◦"
      + "◦◦○○●●○○○"
      + "◦○●●●◦A●●"
      + "◦○●◦●◦◦◦◦"
      + "◦○●◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_03() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦"
      + "◦◦◦◦○○◦◦◦"
      + "◦◦○○●●○○○"
      + "◦◦○●●◦●○●"
      + "◦◦○●◦◦●A●"
      + "◦◦○●◦◦◦◦◦"
      + "◦◦○●◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_04() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦○○○○○○○"
      + "◦◦○●●○●●○"
      + "◦◦○●◦A◦◦●"
      + "◦○○●◦◦◦●◦"
      + "◦○●●◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_05() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦"
      + "◦◦○○○○○◦◦"
      + "◦◦○●●●●○○"
      + "◦○●●◦◦◦●●"
      + "◦○○●◦◦●◦◦"
      + "◦◦◦○A◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_06() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○○○"
      + "◦◦◦◦○○●●○"
      + "◦◦◦◦○●◦◦●"
      + "◦○○○◦●◦●◦"
      + "◦○●●A◦◦◦◦"
      + "◦○●◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_07() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦○◦◦○○○○"
      + "◦◦◦○○●○●●"
      + "◦◦◦○●●●◦◦"
      + "◦◦○●○●◦●◦"
      + "◦◦○●A◦◦◦◦"
      + "◦◦○●◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_08() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦"
      + "◦◦◦◦◦◦◦○○"
      + "◦◦◦◦○○○●●"
      + "◦◦○◦○●●A◦"
      + "◦◦◦○●◦●◦◦"
      + "◦◦◦◦●●◦◦◦";
    testing(boardInput);
  }

  @Test public void test_09() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○○"
      + "◦◦◦◦◦○○●●"
      + "◦◦○○○●●A◦"
      + "◦◦○●●◦◦◦◦"
      + "◦◦○●◦●◦◦◦";
    testing(boardInput);
  }

  @Test public void test_10() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○◦○○○"
      + "◦◦◦◦◦○●●○"
      + "◦◦◦◦○●○A●"
      + "◦○○○◦●◦●◦"
      + "◦○●●●◦◦◦◦"
      + "◦○●◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_11() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○○○"
      + "◦◦○○○○●●○"
      + "◦○●○●●◦A●"
      + "◦○●●◦●◦◦◦"
      + "◦○●◦●◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_12() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦○◦◦◦○○○"
      + "◦◦◦○○○●●●"
      + "◦◦○●●●○◦◦"
      + "◦◦○●◦◦●●◦"
      + "◦◦○●A◦◦◦◦"
      + "◦◦○○●◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_13() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○○"
      + "◦○○○○○○●●"
      + "○○●●○●●●◦"
      + "○●●◦A◦◦◦◦"
      + "○●◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_14() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○○○◦◦◦"
      + "○○○○●○◦○◦"
      + "●●○A●●○◦◦"
      + "●◦●◦●○●○○"
      + "●◦◦◦◦◦●●●"
      + "●◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_15() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○○"
      + "◦◦◦◦○○○●●"
      + "◦◦○○○●●◦●"
      + "◦◦○●●○◦●◦"
      + "◦○○●◦A◦◦◦"
      + "◦○●●◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_16() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦"
      + "◦◦◦○○●●○○"
      + "◦◦◦○●◦●●●"
      + "◦◦◦○●A◦●◦"
      + "◦◦◦○○●●○◦";
    testing(boardInput);
  }

  @Test public void test_17() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦"
      + "◦◦◦○○◦◦○○"
      + "◦○○●●○○●●"
      + "◦○●◦◦●○●◦"
      + "◦○●●◦●●A◦"
      + "◦○●◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_18() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦"
      + "◦◦◦◦◦○○◦◦"
      + "◦○○○○●●○○"
      + "◦○●●●◦A●●"
      + "◦○●◦●◦◦◦◦"
      + "◦○○●◦◦◦◦◦";
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
      + "A◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }
}
