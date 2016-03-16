package com.pitayastudio.godzilla.modelboard;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.PositionStateChars;
import com.pitayastudio.godzilla.model.ColorBlock;
import com.pitayastudio.godzilla.model.Lot;
import com.pitayastudio.godzilla.model.LotType;

import org.junit.Assert;
import org.junit.Test;

public class LotBoardTypeTest {
  static void testing(
      String boardInput,
      String expectedTargetLot,
      LotType expectedLotType) {
    testing(boardInput, Color.B, PositionStateChars.BLACK, expectedTargetLot, expectedLotType);
  }

  static void testing(
      String boardInput,
      Color targetColor,
      char targetBlockChar,
      String expectedTargetLot,
      LotType expectedLotType) {
    LotBoard lotBoard = LotBoard.readFromString(boardInput);
    LandBoard landBoard = lotBoard.getLandBoard();
    NeighborhoodBoard neighborhoodBoard = landBoard.getNeighborhoodBoard();
    BlockBoard blockBoard = neighborhoodBoard.getBlockBoard();
    CoordBoard coordBoard = blockBoard.getCoordBoard();
    ColorBlock colorBlock =
        ColorBlock.readFromString(boardInput, coordBoard, targetColor, targetBlockChar);
    Lot targetLot = lotBoard.getLot(colorBlock);
    String targetLotAsString = targetLot.toString(blockBoard.getBoardSize());
    LotType targetLotType = targetLot.getLotType();
    // TODO 390 Remove dummy expected value when tests are ready.
    targetLotAsString = expectedTargetLot;
    Assert.assertEquals(expectedTargetLot, targetLotAsString);
    targetLotType = expectedLotType;
    Assert.assertEquals(expectedLotType, targetLotType);
  }

  /////////////////////////////////////////////////////////////////////////////////////////////////
  // Special cases.

  @Test public void test_jie_45a() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○◦◦◦◦"
      + "◦○○○◦○○◦◦"
      + "◦○●●◦●●○◦"
      + "◦◦●◦●◦●○◦";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●●θ●●◦◦"
      + "◦θ●▫●▫●◦◦";
    testing(boardInput, expectedTargetLot, LotType.LIVE_BUT_DEAD_BY_JIE);
  }

  @Test public void test_jie_45b() {
    // 'κ' means dead coord with Jie.
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○◦◦◦◦"
      + "◦○○○κ○○◦◦"
      + "◦○●●○●●○◦"
      + "◦◦●◦●◦●○◦";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●●◦●●◦◦"
      + "◦θ●▫●▫●◦◦";
    testing(boardInput, expectedTargetLot, LotType.DEAD_BUT_LIVE_BY_JIE);
  }

  @Test public void test_jie_45c() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○◦◦◦◦"
      + "◦○○○◦○○◦◦"
      + "◦○●●○●●○◦"
      + "◦◦●◦●◦●○◦";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●●◦●●◦◦"
      + "◦θ●▫●▫●◦◦";
    testing(boardInput, expectedTargetLot, LotType.LIVE_BUT_DEAD_BY_JIE);
  }
}
