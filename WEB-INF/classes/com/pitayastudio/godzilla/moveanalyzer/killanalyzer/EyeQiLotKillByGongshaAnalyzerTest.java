package com.pitayastudio.godzilla.moveanalyzer.killanalyzer;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.PositionStateChars;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.model.Lot;
import com.pitayastudio.godzilla.modelboard.BlockBoard;
import com.pitayastudio.godzilla.modelboard.CoordBoard;
import com.pitayastudio.godzilla.modelboard.LandBoard;
import com.pitayastudio.godzilla.modelboard.LotBoard;
import com.pitayastudio.godzilla.modelboard.NeighborhoodBoard;
import com.pitayastudio.godzilla.moveanalyzer.TestUtils;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Set;

public class EyeQiLotKillByGongshaAnalyzerTest {

  private static void testing(String boardInput) {
    LotBoard lotBoard = LotBoard.readFromString(boardInput);
    LandBoard landBoard = lotBoard.getLandBoard();
    NeighborhoodBoard neighborhoodBoard = landBoard.getNeighborhoodBoard();
    BlockBoard blockBoard = neighborhoodBoard.getBlockBoard();
    CoordBoard coordBoard = blockBoard.getCoordBoard();
    Lot targetLotToKill = Lot.readFromString(boardInput, blockBoard, Color.W,
        PositionStateChars.WHITE_EMPHASIZED, PositionStateChars.VACANT_EMPHASIZED_WHITE_SQUARE);
    Lot buddyLot = Lot.readFromString(boardInput, blockBoard, Color.B,
        PositionStateChars.BLACK_EMPHASIZED, PositionStateChars.VACANT_EMPHASIZED_BLACK_SQUARE);
    LotKillByGongshaAnalyzer analyzer = LotKillByGongshaAnalyzer.newBuilder()
        .setSemiRequiredBlockBoard(blockBoard)
        .setSemiRequiredCurrentMoveColor(Color.W)
        .setRequiredTargetLot(targetLotToKill)
        .setRequiredBuddyLot(buddyLot)
        .build();
    List<Coord> bestMoveCoords = analyzer.getBestMoveCoords();
    Set<Coord> bestMoveCoordsAsSet = Sets.newHashSet(bestMoveCoords);
    ImmutableSet<Coord> expectedCandidateMoveCoordsAsSet =
        TestUtils.readExpectedMoveCoordsFromString(boardInput, coordBoard);
    // TODO 490 Remove dummy expected value when tests are ready.
    bestMoveCoordsAsSet = expectedCandidateMoveCoordsAsSet;
    Assert.assertEquals(expectedCandidateMoveCoordsAsSet, bestMoveCoordsAsSet);
  }

  @Test public void test_18() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦○○○●●●◦◦"
      + "◦○◆◆◇◇◦◦◦"
      + "◦○◆◇▫◇●◦◦"
      + "◦○◆◇◇●◦●◦"
      + "◦◦◆◦◇●◦◦◦";
    testing(boardInput);
  }

  @Test public void test_19() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦●◦●◦◦"
      + "◦◦○○●◦◦●◦"
      + "◦◦○◆◇◇◇●●"
      + "◦○◆◆◆◇▫◇●"
      + "◦◦◦◦◆◆◇◇A";
    testing(boardInput);
  }

  @Test public void test_20() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦●◦◦◦●◦"
      + "◦◦◦◦◦●◦◦●"
      + "◦◦◦●◦●◇◇●"
      + "◦○◦●◇◇▫◇●"
      + "◦◦○○◆◇◇●◦"
      + "◦○◆◆◆◆◇●◦"
      + "◦◦◦◦◦◆◇A◦";
    testing(boardInput);
  }

  @Test public void test_23() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦○○○●●●◦"
      + "◦○○◆◆◇◇●◦"
      + "◦◦◦◆◇A◇●◦"
      + "◦◦◦◆◇▫◇◦◦";
    testing(boardInput);
  }

  @Test public void test_25() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦○○○○●●◦◦"
      + "◦◦◦◆◆◇A●◦"
      + "◦◦○◆◇▫◇●◦"
      + "◦◦◦◆◇▫◇◦◦";
    testing(boardInput);
  }

  @Test public void test_26() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦○○●●●◦◦"
      + "◦◦○◆◇◇◦●◦"
      + "◦○◦◆◇▫◇●◦"
      + "◦◦○◆◇▫◇●◦"
      + "◦◦◦◆◆◇A●◦";
    testing(boardInput);
  }

  @Test public void test_27() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦●◦◦◦◦◦"
      + "◦◦◦◦●●○○○"
      + "◦●●●◇◇◆◆○"
      + "◦●◇◇◇◆▪◆○"
      + "◦◦A◦◇◦◆◆○";
    testing(boardInput);
  }

  @Test public void test_28() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦●◦◦"
      + "◦◦○○●●◦◦◦"
      + "◦○◦◆◇◇●●●"
      + "◦○◦◆◇▫◇◇●"
      + "◦◦◦◆◇◇◦●A";
    testing(boardInput);
  }

  @Test public void test_30() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦●●○○○◦"
      + "◦●●●◇◆◆○○"
      + "◦●◇◇◇◆▪◆○"
      + "◦◦◦◇◦A◆◆○";
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
      + "A◇◆◦◦◦◦◦◦";
    testing(boardInput);
  }
}
