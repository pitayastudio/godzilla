package com.pitayastudio.godzilla.modelboard;

import com.pitayastudio.godzilla.model.LotType;

import org.junit.Test;

public class LotBoardTypeSemiLiveTest extends LotBoardTypeTest {

  @Test public void test_01() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○○"
      + "◦◦◦◦○◦●●●"
      + "◦◦◦◦◦●◦●◦";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦●●●"
      + "◦◦◦◦θ●▫●▫";
    testing(boardInput, expectedTargetLot, LotType.SEMI_LIVE);
  }

  @Test public void test_02() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○◦○◦"
      + "◦◦◦◦○◦○◦◦"
      + "◦◦◦○◦●●○○"
      + "◦◦◦○◦●◦●●"
      + "◦◦◦◦○◦●●◦";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦θ◦◦◦"
      + "◦◦◦◦θ●●◦◦"
      + "◦◦◦◦θ●▫●●"
      + "◦◦◦◦◦◦●●▫";
    testing(boardInput, expectedTargetLot, LotType.SEMI_LIVE);
  }

  @Test public void test_08() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦○○○○○○◦◦"
      + "◦○●●●●●○◦"
      + "◦○●◦◦◦●○◦";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●●●◦◦"
      + "◦◦●◦▫▫●◦◦";
    testing(boardInput, expectedTargetLot, LotType.SEMI_LIVE);
  }

  @Test public void test_10() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦○○○○"
      + "◦◦◦◦○●●●●"
      + "◦◦◦◦◦◦◦●◦";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●●●"
      + "◦◦◦◦◦◦θ●▫";
    testing(boardInput, expectedTargetLot, LotType.SEMI_LIVE);
  }

  @Test public void test_17() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○○○◦◦"
      + "◦◦◦○●●●○◦"
      + "◦◦○◦●◦●○◦"
      + "◦◦○●◦●●○◦"
      + "◦◦○●●○○◦◦"
      + "◦◦◦○○◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦●●●◦◦"
      + "◦◦◦◦●▫●◦◦"
      + "◦◦◦●▫●●◦◦"
      + "◦◦◦●●◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput, expectedTargetLot, LotType.SEMI_LIVE);
  }

  @Test public void test_20() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦"
      + "○◦○○○◦◦○◦"
      + "◦○●●◦●●○◦"
      + "◦◦●◦●◦●○◦";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦θθ◦◦"
      + "◦◦●●◦●●◦◦"
      + "◦θ●▫●▫●◦◦";
    testing(boardInput, expectedTargetLot, LotType.SEMI_LIVE);
  }

  @Test public void test_23() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○○◦○○○"
      + "◦◦○◦◦○●●●"
      + "◦◦○◦●●◦●◦"
      + "◦◦○○○◦●●●"
      + "◦◦◦◦○○○○○"
      + "◦◦◦◦◦◦◦◦◦";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦●●●"
      + "◦◦◦◦●●▫●▫"
      + "◦◦◦◦◦◦●●●"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput, expectedTargetLot, LotType.SEMI_LIVE);
  }

  @Test public void test_40() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○○○◦◦◦"
      + "◦◦○●●◦○◦◦"
      + "◦◦○●◦●○◦◦"
      + "◦◦○◦●◦●○◦"
      + "◦◦◦○◦●●○◦"
      + "◦◦◦◦○○○◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦●●θ◦◦◦"
      + "◦◦◦●▫●◦◦◦"
      + "◦◦◦◦●▫●◦◦"
      + "◦◦◦◦θ●●◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput, expectedTargetLot, LotType.SEMI_LIVE);
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
      + "◦◦◦◦◦◦◦◦●";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput, expectedTargetLot, LotType.SEMI_LIVE);
  }
}
