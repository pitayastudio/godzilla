package com.pitayastudio.godzilla.moveanalyzer;

import com.google.common.collect.ImmutableList;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.PositionStateChars;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.model.Gang;
import com.pitayastudio.godzilla.model.OpenProperty;
import com.pitayastudio.godzilla.modelboard.BlockBoard;
import com.pitayastudio.godzilla.modelboard.CoordBoard;
import com.pitayastudio.godzilla.modelboard.GangBoard;
import com.pitayastudio.godzilla.modelboard.LandBoard;
import com.pitayastudio.godzilla.modelboard.LotBoard;
import com.pitayastudio.godzilla.modelboard.LotWithPropertyBoard;
import com.pitayastudio.godzilla.modelboard.NeighborhoodBoard;

import org.junit.Assert;
import org.junit.Test;

public class EyeAnalyzerMakingExternalEyesTest {
  private static void testing(String boardInput) {
    GangBoard gangBoard = GangBoard.readFromString(boardInput);
    LotWithPropertyBoard lotWithPropertyBoard = gangBoard.getLotWithPropertyBoard();
    LotBoard lotBoard = lotWithPropertyBoard.getLotBoard();
    LandBoard landBoard = lotBoard.getLandBoard();
    NeighborhoodBoard neighborhoodBoard = landBoard.getNeighborhoodBoard();
    BlockBoard blockBoard = neighborhoodBoard.getBlockBoard();
    Gang gang = Gang.readFromString(
        boardInput,
        gangBoard,
        Color.B,
        PositionStateChars.BLACK,
        PositionStateChars.VACANT_EMPHASIZED_BLACK_SQUARE);  // TODO 250 update chars in tests
    OpenProperty openProperty = OpenProperty.readFromString(
        boardInput,
        Color.B,
        PositionStateChars.VACANT_EMPHASIZED_BLACK_TRIANGLE,
        PositionStateChars.WHITE_EMPHASIZED,
        true);  // including 'A'
    EyeAnalyzer analyzer = EyeAnalyzer.newBuilder()
        .setSemiRequiredBlockBoard(blockBoard)
        .setRequiredGang(gang)
        .setSemiRequiredCurrentMoveColor(Color.W)
        .setSemiRequiredOpenProperty(openProperty)
        .build();
    ImmutableList<Coord> bestMoveCoords = analyzer.getBestMoveCoords();
    CoordBoard coordBoard = blockBoard.getCoordBoard();
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
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "○◦○○○○○◦◦"
      + "◦○●●●●●○◦"
      + "◦○A▴●▪●○◦";
    testing(boardInput);
  }

  @Test public void test_02() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○○○"
      + "◦◦◦◦○◦○●●"
      + "◦◦◦◦◦○●▴●"
      + "◦◦◦◦◦▴▴A▴";
    testing(boardInput);
  }

  @Test public void test_03() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○○◦◦◦◦"
      + "◦○○●●○○◦◦"
      + "◦○▴A▴●●○◦"
      + "◦◦○●●▪●○◦"
      + "◦◦○○●●○◦◦"
      + "◦◦◦◦○○◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_06() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○○"
      + "◦◦◦◦○▴▴A▴"
      + "◦◦◦◦◦○●▴●"
      + "◦◦◦◦◦◦◦●▪";
    testing(boardInput);
  }

  @Test public void test_08() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦○◦◦◦"
      + "◦◦○◦○◦◦◦◦"
      + "◦○◦●●○○◦◦"
      + "◦○●●▴●●○◦"
      + "◦◦●▴A▴▴○◦";
    testing(boardInput);
  }

  @Test public void test_11() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦○○○○◦◦◦"
      + "◦○◦◦●▴○◦◦"
      + "◦○●◦●A○◦◦"
      + "◦○●◦●▴●○◦"
      + "◦○●◦●▴●○◦";
    testing(boardInput);
  }

  @Test public void test_12() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦○○○◦◦◦◦"
      + "◦◦○●▴○○◦◦"
      + "◦○●●▴A●○◦"
      + "◦○●▪●▴●○◦"
      + "◦◦○●●●○◦◦"
      + "◦○◦○○○◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_14() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦"
      + "◦◦◦◦○●●○○"
      + "◦◦◦◦○●○●○"
      + "◦◦◦○◦●▪●▴"
      + "◦◦◦○○○●●▴"
      + "◦◦◦◦◦◦○A▴";
    testing(boardInput);
  }

  @Test public void test_16() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○○○○◦◦"
      + "◦◦○◦●●●○◦"
      + "◦◦○●●▪●○◦"
      + "◦◦○A▴●○○◦"
      + "◦◦◦▴▴●◦◦◦";
    testing(boardInput);
  }

  @Test public void test_18() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○◦○◦◦"
      + "◦◦◦◦◦○◦○◦"
      + "◦◦◦◦○●●○◦"
      + "◦◦◦◦○●▴●●"
      + "◦◦◦◦○A▴●▪";
    testing(boardInput);
  }

  @Test public void test_21() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦○○○○○◦◦◦"
      + "◦○●●●▴○○◦"
      + "◦○●▴A▴●○◦"
      + "◦○◦●▴●◦○◦";
    testing(boardInput);
  }

  @Test public void test_26() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦"
      + "◦◦○○○●●○◦"
      + "◦◦○●●▴●○◦"
      + "◦◦○●▴A●○◦"
      + "◦◦◦●▴▴○○◦";
    testing(boardInput);
  }

  @Test public void test_28() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦○○○◦"
      + "◦◦◦◦○●●●○"
      + "◦◦◦◦○●▪●○"
      + "◦◦◦○●▴●○○"
      + "◦◦◦○A▴▴●◦";
    testing(boardInput);
  }

  @Test public void test_29() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦○○○○○○○◦"
      + "○●●●▴●●○◦"
      + "○◦●▴A▴●○◦"
      + "◦○●●▴●●○◦"
      + "◦◦○○○○○◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_30() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○○○○◦◦"
      + "◦○◦○●●◦○◦"
      + "◦◦○●●▴●●○"
      + "◦◦▴▴▴A▴▴▴";
    testing(boardInput);
  }

  @Test public void test_31() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○◦○○◦"
      + "◦◦◦◦◦○◦◦◦"
      + "◦◦◦○○●●○○"
      + "◦◦◦○●▪▪●○"
      + "◦○◦○●●●◦○"
      + "◦◦○●▴●○○◦"
      + "◦◦▴▴A▴▴◦◦";
    testing(boardInput);
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////
  // With Semi-Prisoners

  @Test public void test_withSemiPrisoners10() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦○○○○◦◦◦"
      + "◦○●●▴▴◦○◦"
      + "○○●▪●▴A○◦"
      + "○●●●●◇●○◦"
      + "◦○●●○●●○◦"
      + "◦◦○○○○○◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_withSemiPrisoners15() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦○○○○◦◦◦"
      + "◦○▴●●◦○◦◦"
      + "◦○▴●▪●○◦◦"
      + "◦○A▴●◦○◦◦"
      + "◦○●◇●○◦◦◦"
      + "◦○●●○○◦◦◦"
      + "◦◦○○◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_withSemiPrisoners17() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○○◦◦◦"
      + "◦○◦○◦◦○◦◦"
      + "◦◦○●●●●○◦"
      + "◦○●◇A▴●○◦"
      + "◦○●●▴●○◦○"
      + "◦○○●▴○○◦◦";
    testing(boardInput);
  }

  @Test public void test_withSemiPrisoners18a() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○◦○◦◦"
      + "◦◦◦◦◦○◦○◦"
      + "◦◦◦◦○●●○◦"
      + "◦◦◦◦○●◇●●"
      + "◦◦◦◦○A▴●▪";
    testing(boardInput);
  }

  @Test public void test_withSemiPrisoners20() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○◦◦◦"
      + "◦◦○○○◦◦◦◦"
      + "○○◦●●○○◦◦"
      + "○●●●▪●●○◦"
      + "◦●▪▪●◇A○◦";
    testing(boardInput);
  }

  @Test public void test_withSemiPrisoners24() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○◦○◦"
      + "◦◦◦◦◦◦○●○"
      + "◦◦○◦○○○●▴"
      + "◦◦◦○●●●A◇"
      + "◦◦◦◦●▪▪●●";
    testing(boardInput);
  }

  @Test public void test_withSemiPrisoners25() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○○◦"
      + "◦◦◦◦○○●A○"
      + "◦◦◦○◦●●◇▴"
      + "◦◦◦◦○○●◇●"
      + "◦◦◦◦◦◦◦●◦";
    testing(boardInput);
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////
  // Special cases.

  /**
   * For this case, there are 2 candidates (4, 0) and (8, 1). Only one (4, 0) is correct.
   */
  @Test public void test_27() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○○○"
      + "◦◦○◦○○●●○"
      + "◦◦◦○●●▴●◦"
      + "◦◦◦○A▴▴●◦";
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
      + "A●◦◦◦◦◦◦◦";
    testing(boardInput);
  }
}
