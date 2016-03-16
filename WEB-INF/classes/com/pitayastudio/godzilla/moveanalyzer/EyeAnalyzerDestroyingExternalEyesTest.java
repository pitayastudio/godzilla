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

public class EyeAnalyzerDestroyingExternalEyesTest {
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
        Color.W,
        PositionStateChars.WHITE,
        PositionStateChars.VACANT_EMPHASIZED_WHITE_SQUARE);  // TODO 250 update chars in tests
    OpenProperty openProperty = OpenProperty.readFromString(
        boardInput,
        Color.W,
        PositionStateChars.VACANT_EMPHASIZED_BLACK_TRIANGLE,
        PositionStateChars.BLACK_EMPHASIZED,
        true);
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

  @Test public void test_07() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●◦●◦"
      + "◦●◦●◦●◦●◦"
      + "◦◦●▴○○○○○"
      + "◦◦◦▴A▴○●◦";
    testing(boardInput);
  }

  @Test public void test_08() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "●◦●●●●●◦◦"
      + "◦●○○○○○●◦"
      + "◦●A▴○◦○●◦";
    testing(boardInput);
  }

  @Test public void test_09() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦●●●●●"
      + "◦◦◦◦●○○○A"
      + "◦◦◦◦●○◦○▴";
    testing(boardInput);
  }

  @Test public void test_10() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●◦●●●◦◦"
      + "◦●◦●○○●◦◦"
      + "◦◦●○◦○○●◦"
      + "◦◦●○○▴A●◦"
      + "◦◦●◦○▴▴◦◦";
    testing(boardInput);
  }

  @Test public void test_12() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦●◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●●◦"
      + "◦◦◦◦●▴○○◦"
      + "◦◦◦◦◦A▴○○"
      + "◦◦◦◦◦▴▴○◦";
    testing(boardInput);
  }

  @Test public void test_13() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●●◦◦◦"
      + "◦●◦◦○▴●◦◦"
      + "◦●○◦○▴●◦◦"
      + "◦●○◦○A○●◦"
      + "◦●○◦○▴○●◦";
    testing(boardInput);
  }

  @Test public void test_15() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●●◦"
      + "◦◦◦●●○○○●"
      + "◦◦◦●○○◦○A"
      + "◦◦◦●◦◦◦○▴";
    testing(boardInput);
  }

  @Test public void test_17() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "●◦◦◦●●◦◦◦"
      + "◦●●●○○●●◦"
      + "●◦○○▴○○●◦"
      + "◦●○▴A▴▴▴◦";
    testing(boardInput);
  }

  @Test public void test_18() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦●◦◦"
      + "◦◦◦◦◦◦◦●◦"
      + "◦◦◦●◦◦●○●"
      + "◦◦◦◦●◦●○◦"
      + "◦◦◦◦●○○▴○"
      + "◦◦◦◦▴▴▴A▴";
    testing(boardInput);
  }

  @Test public void test_19() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦●◦●●●●●◦"
      + "◦◦●○○○○▴▴"
      + "◦◦◦○◦○▴▴●"
      + "◦●●●○▴A◦●"
      + "◦◦◦◦○▴▴◦◦";
    testing(boardInput);
  }

  @Test public void test_20() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦●◦"
      + "◦◦◦◦◦◦●◦◦"
      + "◦◦◦●◦●◦●◦"
      + "◦◦◦◦●○○○●"
      + "◦◦◦●●○◦○●"
      + "◦●◦●○○○◦●"
      + "◦◦●○▴○▴●◦"
      + "◦◦●○▴A▴●◦";
    testing(boardInput);
  }

  @Test public void test_21() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●●●◦◦"
      + "◦◦◦○○○●◦◦"
      + "◦◦●○◦○○●◦"
      + "◦●◦●○▴○●◦"
      + "◦◦◦●▴A▴▴◦";
    testing(boardInput);
  }


  @Test public void test_24() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦●●◦"
      + "◦◦◦●◦●▴▴●"
      + "◦◦◦◦●○○▴▴"
      + "◦◦◦●○○◦○A"
      + "◦◦◦●○◦●○▴";
    testing(boardInput);
  }

  @Test public void test_25() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●◦◦◦◦◦◦"
      + "◦◦◦◦●●●◦◦"
      + "◦◦◦●○○●●◦"
      + "◦◦◦●○▴○○○"
      + "◦◦◦▴A▴▴▴▴";
    testing(boardInput);
  }

  @Test public void test_26() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦●●●"
      + "◦◦◦●◦●○○●"
      + "◦◦◦◦●▴A▴○"
      + "◦◦●●○◆○○○"
      + "◦◦◦◦○○○◦◦";
    testing(boardInput);
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////
  // Special cases:

  @Test public void test_withPrisoner_01() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●●◦◦◦"
      + "◦●○○○◦◦◦◦"
      + "◦●○◦○●●◦◦"
      + "◦●●○◆○●◦◦"
      + "◦◦◦A▴○◦◦◦";
    testing(boardInput);
  }

  @Test public void test_destroyEyesByEscapingSemiPrisonerBlock_01() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦●●●"
      + "◦◦◦◦●●○○A"
      + "◦◦◦●◦○◦○◆"
      + "◦◦◦●◦○●○○"
      + "◦◦◦◦●○○●●"
      + "◦◦◦◦◦●●●◦";
    testing(boardInput);
  }

  /**
   * Note: The white stone at (7, 0) does not belong to the target {@link Gang}.
   */
  @Test public void test_destroyEyesByEscapingSemiPrisonerBlock_02() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦●●●◦●◦"
      + "◦◦●◦○○●◦◦"
      + "◦◦●◦○●○●◦"
      + "◦◦◦●○◦○●◦"
      + "◦●●○▴○○●◦"
      + "◦◦◦○●●●◇A";
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
      + "A○◦◦◦◦◦◦◦";
    testing(boardInput);
  }
}
