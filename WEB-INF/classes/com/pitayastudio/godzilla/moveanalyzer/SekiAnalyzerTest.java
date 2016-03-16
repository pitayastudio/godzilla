package com.pitayastudio.godzilla.moveanalyzer;

import com.google.common.collect.ImmutableList;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.PositionStateChars;
import com.pitayastudio.godzilla.model.ColorBlock;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.model.Lot;
import com.pitayastudio.godzilla.modelboard.BlockBoard;
import com.pitayastudio.godzilla.modelboard.CoordBoard;
import com.pitayastudio.godzilla.modelboard.LandBoard;
import com.pitayastudio.godzilla.modelboard.LotBoard;
import com.pitayastudio.godzilla.modelboard.NeighborhoodBoard;

import org.junit.Assert;
import org.junit.Test;

public class SekiAnalyzerTest {
  private static void testing(String boardInput) {
    LotBoard lotBoard = LotBoard.readFromString(boardInput);
    LandBoard landBoard = lotBoard.getLandBoard();
    NeighborhoodBoard neighborhoodBoard = landBoard.getNeighborhoodBoard();
    BlockBoard blockBoard = neighborhoodBoard.getBlockBoard();
    CoordBoard coordBoard = blockBoard.getCoordBoard();
    ColorBlock buddyColorBlockToBeSeki = ColorBlock.readFromString(boardInput, coordBoard, Color.B,
        PositionStateChars.BLACK_EMPHASIZED);
    Lot buddyLotToBeSeki = lotBoard.getLot(buddyColorBlockToBeSeki);
    //OpenLand dummyOpenLand = OpenLand.readFromString(boardInput);
    //ImmutableSet<OpenLand> openLands = ImmutableSet.of(dummyOpenLand );
    SekiAnalyzer analyzer = SekiAnalyzer.newBuilder()
        .setSemiRequiredCurrentMoveColor(Color.B)
        .setSemiRequiredBlockBoard(blockBoard)
        // TODO 200 Enable addOpenLands() when ready.
        //.addOpenLands(openLands)
        .setRequiredBuddyLotToBeSeki(buddyLotToBeSeki)
        .build();
    ImmutableList<Coord> bestMoveCoords = analyzer.getBestMoveCoords();
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
      + "◦◦◦●●○○◦◦"
      + "◦◦◦●○◆◆○◦"
      + "◦◦◦●○◦◆○◦"
      + "◦◦◦A○◦◆○◦";
    testing(boardInput);
  }

  @Test public void test_02() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦○○○●●◦◦◦"
      + "◦○◆A○●◦◦◦"
      + "◦○◆◦○●◦◦◦"
      + "◦○◆◦○●◦◦◦";
    testing(boardInput);
  }

  @Test public void test_03() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●●A○○○◦"
      + "◦◦●○○◆◆○◦"
      + "◦◦●○◦◆○○◦"
      + "◦◦●○◦◆○◦◦";
    testing(boardInput);
  }

  @Test public void test_04() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦○○○○●●◦"
      + "◦◦○◆◆◆○●◦"
      + "◦◦○◆◦○○●◦"
      + "◦◦◦◆◦○◦A◦";
    testing(boardInput);
  }

  @Test public void test_05() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●●○○○◦◦"
      + "◦●◦○◆◆◦○◦"
      + "◦◦◦○○◆○◦◦"
      + "◦●A○◦◆◦○◦"
      + "◦◦◦○◦◆◦◦◦";
    testing(boardInput);
  }

  @Test public void test_06() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦○○●●●●◦◦"
      + "◦○◆○○○●◦◦"
      + "◦○◆◆◦○●◦◦"
      + "◦○○◆◦○A◦◦"
      + "◦◦○◆◦○◦◦◦";
    testing(boardInput);
  }

  @Test public void test_07() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○○○◦"
      + "◦◦●○○◆◆○◦"
      + "◦◦●○◦A◆○◦"
      + "◦◦●○○◦◆○◦";
    testing(boardInput);
  }

  @Test public void test_08() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦○○○●●◦◦"
      + "◦◦○◆◆○●◦◦"
      + "◦◦○◆◦○○●◦"
      + "◦◦○◆A◦○●◦";
    testing(boardInput);
  }

  // There are 2 {@link VacantBlock}s involved for Seki.
  @Test public void test_09() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦●◦◦◦◦◦◦◦"
      + "◦◦◦○○○○◦◦"
      + "◦●◦○◆◆◆○◦"
      + "◦◦●●○◦◆○◦"
      + "◦◦●○○○◆○◦"
      + "◦◦●○◦A◆○◦";
    testing(boardInput);
  }

  // There are 2 {@link VacantBlock}s involved for Seki.
  @Test public void test_10() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○○◦◦"
      + "◦◦●○○◆○◦◦"
      + "◦●●○◦◆○○○"
      + "◦●○○○◆◆◆○"
      + "◦●○◦○A◦◆○";
    testing(boardInput);
  }

  @Test public void test_11() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○◦◦◦"
      + "◦◦●●●○◦○◦"
      + "◦◦●○○◆◆○◦"
      + "◦◦●○◦A◆○◦"
      + "◦◦●○○◦◆○◦"
      + "◦◦●◦○◆◆○◦";
    testing(boardInput);
  }

  @Test public void test_12() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○○●●◦◦"
      + "◦◦○○◆○●◦◦"
      + "◦◦○◆◆○◦●◦"
      + "◦○○◆◦○○●◦"
      + "◦◦◦◆A◦○●◦";
    testing(boardInput);
  }

  @Test public void test_13() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦"
      + "◦◦◦◦◦◦◦○○"
      + "◦◦●●●○○◆◆"
      + "◦●●○○◆◆◦◆"
      + "◦●○○◦○◆◆◆"
      + "◦●○◦A○○○◦";
    testing(boardInput);
  }

  @Test public void test_14() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦○◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦○○○●●●●"
      + "◦○○◆◆○○○●"
      + "◦○◆◦◆○◦○●"
      + "◦○◆◆◦○A○●";
    testing(boardInput);
    testing(boardInput);
  }

  @Test public void test_15() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●●●"
      + "◦◦◦●●○○○○"
      + "◦◦◦●○◦○◦A"
      + "◦◦◦●○○○◆◦";
    testing(boardInput);
  }

  @Test public void test_16() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○○○○○"
      + "◦◦○○○◆◆◆◆"
      + "◦◦○◆◆◆◦○○"
      + "◦◦○◆◦◆○A◦";
    testing(boardInput);
  }

  // There are 2 {@link VacantBlock}s involved for Seki.
  @Test public void test_17() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦●●●"
      + "◦◦◦◦◦●●○○"
      + "◦◦◦●●●○○◦"
      + "◦◦◦●○○○◆◆"
      + "◦◦◦●○◦○A◦";
    testing(boardInput);
  }

  @Test public void test_18() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●◦◦◦○◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●●○○○◦◦"
      + "●●●○◆◆◆○◦"
      + "●○○○◆◦◆○◦"
      + "●○A○○◆◆○◦"
      + "●○●◦○◦◆○◦";
    testing(boardInput);
    testing(boardInput);
  }

  @Test public void test_19() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦○◦◦◦◦●◦◦"
      + "◦◦○○●●◦◦◦"
      + "○○◆◆○○●●◦"
      + "○◆◦◆○◦○●◦"
      + "○◆◆◦○A○◦◦";
    testing(boardInput);
    testing(boardInput);
  }

  @Test public void test_20() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦○◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦○○◦◦◦◦◦◦"
      + "◦◦◦●●◦●◦◦"
      + "○○○●○●◦◦◦"
      + "○◆◆○○○●●◦"
      + "○◆◦◆○◦○●◦"
      + "○◆◆◦○A○●◦";
    testing(boardInput);
    testing(boardInput);
  }

  @Test public void test_21() {
    String boardInput =
        "◦◆◦○●◦◦◦◦"
      + "○A○○●◦◦◦◦"
      + "◦○○●●◦◦◦◦"
      + "○○●●◦◦◦◦◦"
      + "●●●◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_22() {
    String boardInput =
        "◦◆◦○●◦◦◦◦"
      + "○A○○●◦◦◦◦"
      + "◦○◦○●◦◦◦◦"
      + "○○○●●◦◦◦◦"
      + "●●●●◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_23() {
    String boardInput =
        "◦◆◆◆A◦○◦◦"
      + "○○○○○○○◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "●A◦◦◦◦◦◦◦";
    testing(boardInput);
  }
  // There are 3 blocks to become Seki, so 2 SekiAnalyzers are needed.
  @Test public void test_SekiWith3Blocks_01() {
    String boardInput =
        "◦A◦○◦●◦●○"
      + "◆◆○○○●●●○"
      + "○○●●●○○○○"
      + "◦○◦◦●○◦◦◦"
      + "◦○◦◦●○◦◦◦"
      + "◦○◦◦●○○○○"
      + "◦○◦◦●●●●●"
      + "◦○◦◦●◦◦◦◦"
      + "◦○◦◦●◦◦◦◦";
    testing(boardInput);
  }

  // There are 3 blocks to become Seki, so 2 SekiAnalyzers are needed.
  @Test public void test_SekiWith3Blocks_02() {
    String boardInput =
        "◦◆◦○◦●◦●○"
      + "◆◆A○●●●●○"
      + "○○○●●○○○○"
      + "◦○◦○○○◦◦◦"
      + "◦○◦◦●○◦◦◦"
      + "◦○◦◦●○○○○"
      + "◦○◦◦●●●●●"
      + "◦○◦◦●◦◦◦◦"
      + "◦○◦◦○◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_doubleJie() {
    String boardInput =
        "◦◆◦◆○●◦◦◦"
      + "A◆◆○○●◦◦◦"
      + "○◆○○●●◦◦◦"
      + "◦○◦○●◦◦◦◦"
      + "○○○○●◦◦◦◦"
      + "●●●●●◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_special_01() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "○○○◦◦◦◦◦◦"
      + "◆◆○◦◦◦◦◦◦"
      + "◦◆○◦◦◦◦◦◦"
      + "◆◆○●●◦◦◦◦"
      + "◦◆◆○●◦◦◦◦"
      + "A○○○●◦◦◦◦"
      + "◦○◦○●◦◦◦◦";
    testing(boardInput);
  }

  /**
   * Assuming move A is done.
   * For either side, capturing starts a capturing-race that the other side can win.
   * So, best play is to leave this.
   */
  @Test public void test_special_02() {
    // TODO 490 implement SekiAnalyzerTest.test_special_xx()
    @SuppressWarnings("unused")
    String boardInput =
        "○●○●◦○A◦◦"
      + "○●○●○●●◦◦"
      + "○●○●○●◦◦◦"
      + "◦●○○○●◦◦◦"
      + "●●◦○●●◦◦◦"
      + "○○○○●◦◦◦◦"
      + "●●●●●◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
  }

  @Test public void test_special_03() {
    // TODO 490 implement SekiAnalyzerTest.test_special_xx()
    @SuppressWarnings("unused")
    String boardInput =
        "◦○◦●◦○◦○●◦●○●"
      + "○○○●○○○○●●●○●"
      + "A●●○●●●●●◦○○●"
      + "◦◦●○○○○○●○○●●"
      + "◦◦●●●○◦○○○●●◦"
      + "◦◦◦◦◦●○○●●●◦◦"
      + "◦◦◦◦◦●●●●◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦";
  }
}
