package com.pitayastudio.godzilla.moveanalyzer;

import com.google.common.collect.ImmutableList;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.PositionStateChars;
import com.pitayastudio.godzilla.model.ClosedProperty;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.model.Gang;
import com.pitayastudio.godzilla.modelboard.BlockBoard;
import com.pitayastudio.godzilla.modelboard.CoordBoard;
import com.pitayastudio.godzilla.modelboard.GangBoard;
import com.pitayastudio.godzilla.modelboard.LandBoard;
import com.pitayastudio.godzilla.modelboard.LotBoard;
import com.pitayastudio.godzilla.modelboard.LotWithPropertyBoard;
import com.pitayastudio.godzilla.modelboard.NeighborhoodBoard;

import org.junit.Assert;
import org.junit.Test;

public class EyeAnalyzerDestroyingInternalEyesTest {
  private static void testing(String boardInput, boolean isMoveFromExternal) {
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
    ClosedProperty closedProperty = ClosedProperty.readFromString(
        boardInput,
        Color.W,
        PositionStateChars.VACANT_EMPHASIZED_BLACK_TRIANGLE,
        PositionStateChars.BLACK_EMPHASIZED,
        !isMoveFromExternal);  // including 'A' or not
    EyeAnalyzer internalEyeAnalyzer = EyeAnalyzer.newBuilder()
        .setSemiRequiredBlockBoard(blockBoard)
        .setRequiredGang(gang)
        .setSemiRequiredCurrentMoveColor(Color.W)
        .setSemiRequiredClosedProperty(closedProperty)
        .setReverseMode()
        .build();
    ImmutableList<Coord> bestMoveCoords = internalEyeAnalyzer.getBestMoveCoords();
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
      + "●●●●●●●◦◦"
      + "●○○○○○●◦◦"
      + "●○▴A▴○●◦◦";
    testing(boardInput, false);
  }

  @Test public void test_02() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●◦●●"
      + "◦◦◦◦◦◦●○○"
      + "◦◦◦◦◦●○○▴"
      + "◦◦◦◦◦●○▴A";
    testing(boardInput, false);
  }

  @Test public void test_03() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦●●●●◦●◦◦"
      + "◦●○○○●◦◦◦"
      + "●○▴A▴○●◦◦"
      + "●○○○○○●◦◦"
      + "◦●●●●●◦◦◦";
    testing(boardInput, false);
  }

  @Test public void test_04() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦●●●"
      + "◦◦◦◦◦●○○○"
      + "◦◦◦◦◦●○▴A"
      + "◦◦◦◦◦●●○▴";
    testing(boardInput, false);
  }

  @Test public void test_05() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦●◦◦◦◦◦"
      + "◦◦●◦●●◦●◦"
      + "◦●◦○○○●◦◦"
      + "◦●◦○A▴○●◦"
      + "◦◦●○▴○○●◦"
      + "◦◦◦◦○◦●◦◦";
    testing(boardInput, false);
  }

  @Test public void test_06() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦●●●●●●"
      + "◦●◦●○○○○○"
      + "●◦○○A▴○●◦"
      + "◦●◦●○○○○○"
      + "◦◦◦●●●●●◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput, false);
  }

  @Test public void test_07() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●●●"
      + "◦◦◦●●○○○○"
      + "◦◦◦◦○A▴○◦";
    testing(boardInput, false);
  }

  @Test public void test_08() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦●●◦"
      + "◦◦◦◦●◦●○○"
      + "◦◦◦●◦●○○◦"
      + "◦◦◦◦○○A▴○";
    testing(boardInput, false);
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
      + "◦◦●●○○○○○"
      + "◦◦◦○A◆▴○◦";
    testing(boardInput, false);
  }

  @Test public void test_10() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦●●●●●"
      + "◦◦◦◦●○○○○"
      + "◦◦◦◦◦○▴A◆";
    testing(boardInput, false);
  }

  @Test public void test_11() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦●●●●●●"
      + "◦◦◦●○○○○○"
      + "◦◦◦◦○▴A◆▴";
    testing(boardInput, false);
  }

  @Test public void test_12() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦●●●●●●"
      + "◦◦◦●○○○○○"
      + "◦◦◦◦○◆A◆▴";
    testing(boardInput, false);
  }

  @Test public void test_13() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●◦●●●●◦"
      + "◦◦◦●○○○●◦"
      + "◦◦◦●○▴A○○"
      + "◦◦◦●●○▴▴▴";
    testing(boardInput, false);
  }

  @Test public void test_14() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●◦●●◦◦◦"
      + "◦◦◦●◦◦●◦◦"
      + "◦●●○○○○●◦"
      + "◦●○▴A▴○●◦"
      + "◦●○○▴○○●◦"
      + "◦◦●◦○◦●◦◦";
    testing(boardInput, false);
  }

  @Test public void test_15() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦●●◦"
      + "◦◦◦◦●●○○◦"
      + "◦◦●◦●○▴○○"
      + "◦◦◦◦◦○A◆◆";
    testing(boardInput, false);
  }

  @Test public void test_16() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●◦◦◦◦"
      + "◦◦●○◦●◦◦◦"
      + "◦●○▴○○●●◦"
      + "◦●○A▴▴○●◦"
      + "◦◦●○○◆○●◦"
      + "◦●◦●●○○●◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput, false);
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////
  // The move is from external.

  @Test public void test_externalMove_01() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●●●"
      + "◦◦◦◦●A○○○"
      + "◦◦◦◦◦○▴○◦";
    testing(boardInput, true);
  }

  @Test public void test_externalMove_02() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●◦●◦"
      + "◦◦◦◦●◦●◦●"
      + "◦◦◦●◦○○A◦"
      + "◦◦◦●◦○▴○○"
      + "◦◦◦◦●●○○◦";
    testing(boardInput, true);
  }

  @Test public void test_externalMove_03() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●◦◦◦◦"
      + "●●●○○●●◦◦"
      + "●○○○▴○◦●◦"
      + "●○◦◦○A●◦◦";
    testing(boardInput, true);
  }

  @Test public void test_externalMove_04() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●●●"
      + "◦◦◦●●A○○○"
      + "◦◦◦◦○○▴○◦"
      + "◦●◦●●●○○○"
      + "◦◦◦◦◦◦●●◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput, true);
  }

  @Test public void test_externalMove_11() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦●◦"
      + "◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦●◦◦●●"
      + "◦◦◦◦◦●○○●"
      + "◦◦◦◦◦●○▴○"
      + "◦◦◦◦◦●A○◦";
    testing(boardInput, true);
  }

  @Test public void test_externalMove_14() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●●●●◦"
      + "●◦●○○○○A◦"
      + "●○○◦●○▴○◦";
    testing(boardInput, true);
  }

  @Test public void test_externalMove_22() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●●◦"
      + "◦◦◦◦●○○○●"
      + "◦◦◦◦●○◦○●"
      + "◦●●●○▴○●●"
      + "◦◦○○◦○A●◦";
    testing(boardInput, true);
  }

  @Test public void test_externalMove_23() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "●◦●●●◦◦◦◦"
      + "◦●○○○●●●◦"
      + "●○◦○▴○○●◦"
      + "●◦●A○◦○◦◦";
    testing(boardInput, true);
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
    testing(boardInput, false);
  }
}
