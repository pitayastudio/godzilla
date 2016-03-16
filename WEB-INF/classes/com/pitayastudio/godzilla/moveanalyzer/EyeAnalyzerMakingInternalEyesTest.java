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

public class EyeAnalyzerMakingInternalEyesTest {
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
        Color.B,
        PositionStateChars.BLACK,
        PositionStateChars.VACANT_EMPHASIZED_BLACK_SQUARE);  // TODO 250 update chars in tests
    ClosedProperty closedProperty = ClosedProperty.readFromString(
        boardInput,
        Color.B,
        PositionStateChars.VACANT_EMPHASIZED_BLACK_TRIANGLE,
        PositionStateChars.WHITE_EMPHASIZED,
        !isMoveFromExternal);  // including 'A' or not
    EyeAnalyzer analyzer = EyeAnalyzer.newBuilder()
        .setSemiRequiredBlockBoard(blockBoard)
        .setRequiredGang(gang)
        .setSemiRequiredCurrentMoveColor(Color.W)
        .setSemiRequiredClosedProperty(closedProperty)
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
      + "◦◦◦○◦◦◦◦◦"
      + "◦○○◦○○◦◦◦"
      + "○○●○●○○◦◦"
      + "○●●●●●○◦◦"
      + "○●▴A▴●○◦◦";
    testing(boardInput, false);
  }

  @Test public void test_02() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○◦○○"
      + "◦◦◦◦◦◦○●●"
      + "◦◦◦◦◦○●●▴"
      + "◦◦◦◦◦○●▴A";
    testing(boardInput, false);
  }

  @Test public void test_03() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦○○○○◦○◦◦"
      + "◦○●●●○◦◦◦"
      + "○●▴A▴●○◦◦"
      + "○●●●●●○◦◦"
      + "◦○○○○○◦◦◦";
    testing(boardInput, false);
  }

  @Test public void test_04() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○○○"
      + "◦◦◦◦◦○◦●●"
      + "◦◦◦◦◦○●A▴"
      + "◦◦◦◦◦○●▴●";
    testing(boardInput, false);
  }

  @Test public void test_05() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦"
      + "◦◦◦○○○◦◦◦"
      + "◦○◦○●●○○○"
      + "◦◦○●●▴●●○"
      + "◦◦○●▴A▴●○";
    testing(boardInput, false);
  }

  @Test public void test_07() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦"
      + "◦◦◦◦◦○◦○◦"
      + "◦◦◦◦○◦○●●"
      + "◦◦◦○◦○●▴A"
      + "◦◦◦◦◦●◦●▴";
    testing(boardInput, false);
  }

  @Test public void test_10() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦○◦○○○◦◦"
      + "◦○◦○●●●○◦"
      + "◦◦○●A▴●○◦"
      + "◦○●▴▴●○◦◦"
      + "◦○◦●●●○◦◦"
      + "◦◦○○○○○◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput, false);
  }

  @Test public void test_11() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦○○○○◦◦◦"
      + "◦◦○●●◦○○◦"
      + "◦◦○●◦●●○◦"
      + "◦◦○◦●▴A●◦";
    testing(boardInput, false);
  }

  @Test public void test_13() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦"
      + "◦◦○○○●●○◦"
      + "◦◦○●●▴●○◦"
      + "◦◦○●▴A●○◦"
      + "◦◦○●▴▴●○◦"
      + "◦◦○●●●●○◦"
      + "◦◦◦○○○○○◦";
    testing(boardInput, false);
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////
  // The move is from external.

  @Test public void test_externalMove_01() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○○◦"
      + "◦◦◦◦○○●A◦"
      + "◦◦◦◦○●▴●●"
      + "◦◦◦◦○●●●◦";
    testing(boardInput, true);
  }

  @Test public void test_externalMove_02a() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○○◦◦◦◦"
      + "◦◦○◦◦○○○◦"
      + "◦◦○●●A●●○"
      + "◦◦◦●▴●◦●◦";
    testing(boardInput, true);
  }

  @Test public void test_externalMove_02b() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○○◦◦◦◦"
      + "◦◦○◦◦○○○◦"
      + "◦◦○●●A●●○"
      + "◦◦◦●◦●▴●◦";
    testing(boardInput, true);
  }

  @Test public void test_externalMove_03() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○○○○○"
      + "◦○◦○◦A●●●"
      + "◦◦○●●●▴●◦";
    testing(boardInput, true);
  }

  @Test public void test_externalMove_04() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○◦◦◦"
      + "◦○◦○○◦○◦◦"
      + "◦◦○●A◦●○◦"
      + "◦○●▴●◦●○◦"
      + "◦○●●◦●○○◦";
    testing(boardInput, true);
  }

  @Test public void test_externalMove_05() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦○○◦◦◦◦◦◦"
      + "◦○●○○○◦○◦"
      + "◦○●◦A●○◦◦"
      + "◦○●◦●▴●○◦"
      + "◦○○●◦●●○◦";
    testing(boardInput, true);
  }

  @Test public void test_externalMove_06() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○○◦◦○◦"
      + "◦◦○A●○○◦◦"
      + "○○○●▴●●○◦"
      + "○●●◦●◦●◦◦";
    testing(boardInput, true);
  }

  @Test public void test_externalMove_07() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦○◦○◦"
      + "◦◦◦◦○◦○◦◦"
      + "◦◦○○●●●○◦"
      + "◦○◦A○●◦●○"
      + "◦◦○○●▴●●◦";
    testing(boardInput, true);
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////
  // With prisoners

  @Test public void test_03a() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦○○○○○◦○◦"
      + "◦○●●●●○◦◦"
      + "○●▴◇A▴●○◦"
      + "○●●●●●●○◦"
      + "◦○○○○○○◦◦";
    testing(boardInput, true);
  }

  @Test public void test_06() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦"
      + "◦◦◦◦○◦◦◦◦"
      + "◦◦◦◦◦◦○○◦"
      + "◦◦◦◦◦○●●●"
      + "◦◦◦◦○◦●▴●"
      + "◦◦◦◦○◦●A◇";
    testing(boardInput, true);
  }

  @Test public void test_08() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○◦◦◦"
      + "◦◦◦◦◦◦○○○"
      + "◦◦○◦○○●●○"
      + "◦◦◦○●●◇●◦"
      + "◦◦◦○●▴A●◦";
    testing(boardInput, true);
  }

  @Test public void test_09() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○○○○○◦"
      + "◦◦○◦●●●◦◦"
      + "◦○◦●◇▴●◦◦"
      + "◦○●▴A●○○◦"
      + "◦○●●●○◦◦◦"
      + "◦◦○○○◦○◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput, true);
  }

  @Test public void test_22() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦◦◦◦"
      + "◦○◦◦○○◦◦◦"
      + "◦○●●A●○◦◦"
      + "◦◦○●●◇●○◦"
      + "◦◦○●◇▴●○◦"
      + "◦◦○○●●●○◦"
      + "◦◦◦◦◦◦○◦◦";
    testing(boardInput, true);
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////
  // Special cases.

  /**
   * For this case, there are 2 candidates (5, 1) and (8, 0). Only one (5, 1) is correct.
   */
  @Test public void test_12() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○○◦◦◦"
      + "◦◦◦○●○◦○◦"
      + "◦◦◦○●◦○◦◦"
      + "◦◦◦○●●●○○"
      + "◦○◦○●A◇●●"
      + "◦◦◦◦◦●●○◦";
    testing(boardInput, false);
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
    testing(boardInput, false);
  }
}
