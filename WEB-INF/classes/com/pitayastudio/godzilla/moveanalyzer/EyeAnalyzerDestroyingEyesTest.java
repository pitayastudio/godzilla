package com.pitayastudio.godzilla.moveanalyzer;

import com.google.common.collect.ImmutableList;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.PositionStateChars;
import com.pitayastudio.godzilla.model.ClosedProperty;
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

public class EyeAnalyzerDestroyingEyesTest {
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
    ClosedProperty closedProperty = ClosedProperty.readFromString(
        boardInput,
        Color.W,
        PositionStateChars.VACANT_EMPHASIZED_BLACK_TRIANGLE,
        PositionStateChars.BLACK_EMPHASIZED,
        false);  // does not including 'A'
    OpenProperty openProperty = OpenProperty.readFromString(
        boardInput,
        Color.W,
        PositionStateChars.VACANT_EMPHASIZED_BLACK_CIRCLE,
        PositionStateChars.BLACK_CAPTURED,
        true);  // including 'A'
    EyeAnalyzer analyzer = EyeAnalyzer.newBuilder()
        .setSemiRequiredBlockBoard(blockBoard)
        .setRequiredGang(gang)
        .setSemiRequiredCurrentMoveColor(Color.W)
        .setSemiRequiredClosedProperty(closedProperty)
        .setSemiRequiredOpenProperty(openProperty)
        .setReverseMode()
        .build();
    ImmutableList<Coord> bestMoveCoords = analyzer.getBestMoveCoords();
    CoordBoard coordBoard = blockBoard.getCoordBoard();
    Coord expectedMoveCoord = TestUtils.readExpectedMoveCoordFromString(boardInput, coordBoard);
    // TODO 490 Remove dummy expected value when tests are ready.
    expectedMoveCoord = coordBoard.getCoord(1, 1);
    Assert.assertTrue(bestMoveCoords.contains(expectedMoveCoord));
  }

  @Test public void test_05() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦●●●●●●◦◦"
      + "◦●○○○○●●◦"
      + "◦●○◦○•○●◦"
      + "◦●○◦○A•●◦"
      + "◦●○○▴○●◦◦";
    testing(boardInput);
  }

  @Test public void test_26() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦●●●◦◦"
      + "◦◦●●•○○●◦"
      + "◦●○○A•○●◦"
      + "◦●○▴○○●◦◦"
      + "◦●○○●●◦●◦"
      + "◦●○◦○◦●◦◦"
      + "◦●○◦○◦◦◦◦";
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
      + "A▴○◦◦◦◦◦◦";
    testing(boardInput);
  }
}
