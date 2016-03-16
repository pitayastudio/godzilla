package com.pitayastudio.godzilla.modelboard;

import com.pitayastudio.godzilla.model.LotType;

import org.junit.Test;

public class LotBoardTypeSekiTest extends LotBoardTypeTest {

  @Test public void test_01() {
    String boardInput =
        "●◦●○◦●○◦○"
      + "●●●○◦●○○○"
      + "●◦●○○●○◦○"
      + "●●●●●○○○○"
      + "○○○○○○◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    String expectedBlackTargetLot =
        "◦◦◦◦θ●◦◦◦"
      + "◦◦◦◦θ●◦◦◦"
      + "◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    String expectedWhiteTargetLot =
        "◦◦◦○θ◦◦◦◦"
      + "◦◦◦○θ◦◦◦◦"
      + "◦◦◦○○◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput, expectedBlackTargetLot, LotType.MUTUAL_LIVE);
    testing(boardInput, expectedWhiteTargetLot, LotType.MUTUAL_LIVE);
  }

  @Test public void test_02() {
    String boardInput =
        "◦○●◦●○◦◦◦"
      + "○◦●●●○◦◦◦"
      + "●●●○○○◦◦◦"
      + "○○○◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    String expectedBlackTargetLot =
        "◦◦●▫●◦◦◦◦"
      + "◦θ●●●◦◦◦◦"
      + "●●●◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    String expectedWhiteTargetLot =
        "▫○◦◦◦◦◦◦◦"
      + "○θ◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput, expectedBlackTargetLot, LotType.MUTUAL_LIVE);
    testing(boardInput, expectedWhiteTargetLot, LotType.MUTUAL_LIVE);
  }

  @Test public void test_03() {
    String boardInput =
        "◦◦○●◦●○◦◦"
      + "○○○●◦●○◦◦"
      + "○○○●●●○◦◦"
      + "○○◦●○○○◦◦"
      + "●●●●○◦◦◦◦"
      + "○○○○○◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    String expectedBlackTargetLot =
        "◦◦◦●▫●◦◦◦"
      + "◦◦◦●▫●◦◦◦"
      + "◦◦◦●●●◦◦◦"
      + "◦◦θ●◦◦◦◦◦"
      + "●●●●◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    String expectedWhiteTargetLot =
        "▫▫○◦◦◦◦◦◦"
      + "○○○◦◦◦◦◦◦"
      + "○○○◦◦◦◦◦◦"
      + "○○θ◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput, expectedBlackTargetLot, LotType.MUTUAL_LIVE);
    testing(boardInput, expectedWhiteTargetLot, LotType.MUTUAL_LIVE);
  }

  @Test public void test_04() {
    String boardInput =
        "◦●◦●◦○◦○●"
      + "●●●○○○○○●"
      + "○○○○○○○●●"
      + "●●●●●●●●◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    String expectedBlackTargetLot =
        "▫●▫●θ◦◦◦◦"
      + "●●●◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    String expectedWhiteTargetLot =
        "◦◦◦◦θ○▫○◦"
      + "◦◦◦○○○○○◦"
      + "○○○○○○○◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput, expectedBlackTargetLot, LotType.MUTUAL_LIVE);
    testing(boardInput, expectedWhiteTargetLot, LotType.MUTUAL_LIVE);
  }

  @Test public void test_05() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "●●●●◦◦●◦◦"
      + "○○○○●●◦◦◦"
      + "◦◦◦◦○○●●●"
      + "◦◦○○●●○○○"
      + "◦◦○●◦●○◦○"
      + "◦◦○●●◦○○○";
    String expectedBlackTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦●●◦◦◦"
      + "◦◦◦●▫●◦◦◦"
      + "◦◦◦●●θ◦◦◦";
    String expectedWhiteTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○○○"
      + "◦◦◦◦◦◦○▫○"
      + "◦◦◦◦◦θ○○○";
    testing(boardInput, expectedBlackTargetLot, LotType.MUTUAL_LIVE);
    testing(boardInput, expectedWhiteTargetLot, LotType.MUTUAL_LIVE);
  }

  @Test public void test_06() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "●●◦◦◦◦◦◦◦"
      + "○○●●●●◦●◦"
      + "◦○○○●○●◦◦"
      + "◦○●●○○○●●"
      + "◦○●◦●○◦○●"
      + "◦○●●◦○○○●";
    String expectedBlackTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●●◦◦◦◦◦"
      + "◦◦●▫●◦◦◦◦"
      + "◦◦●●θ◦◦◦◦";
    String expectedWhiteTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○◦◦◦"
      + "◦◦◦◦○○○◦◦"
      + "◦◦◦◦◦○▫○◦"
      + "◦◦◦◦θ○○○◦";
    testing(boardInput, expectedBlackTargetLot, LotType.MUTUAL_LIVE);
    testing(boardInput, expectedWhiteTargetLot, LotType.MUTUAL_LIVE);
  }

  @Test public void test_07() {
    String boardInput =
        "◦●◦●◦◦●◦○◦○●◦"
      + "●●●○●●○○○○○●◦"
      + "○○○○○○○○○○○●◦"
      + "●●●●●●●●●●●●◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦";
    String expectedBlackTargetLot =
        "▫●▫●▫▫●θ◦◦◦◦◦"
      + "●●●◦●●◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦";
    String expectedWhiteTargetLot =
        "◦◦◦◦◦◦◦θ○▫○◦◦"
      + "◦◦◦○◦◦○○○○○◦◦"
      + "○○○○○○○○○○○◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦";
    testing(boardInput, expectedBlackTargetLot, LotType.MUTUAL_LIVE);
    testing(boardInput, expectedWhiteTargetLot, LotType.MUTUAL_LIVE);
  }

  @Test public void test_08() {
    String boardInput =
        "◦●◦○◦●◦●○"
      + "●●○○○●●●○"
      + "○○●●●○○○○"
      + "◦○◦◦●○◦◦◦"
      + "◦○◦◦●○◦◦◦"
      + "◦○◦◦●○○○○"
      + "◦○◦◦●●●●●"
      + "◦○◦◦●◦◦◦◦"
      + "◦○◦◦●◦◦◦◦";
    String expectedBlackTargetLot1 =
        "▫●θ◦◦◦◦◦◦"
      + "●●◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    String expectedBlackTargetLot2 =
        "◦◦θ○θ◦◦◦◦"
      + "◦◦○○○◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    String expectedWhiteTargetLot =
        "◦◦◦◦θ●▫●◦"
      + "◦◦◦◦◦●●●◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput, expectedBlackTargetLot1, LotType.MUTUAL_LIVE);
    testing(boardInput, expectedBlackTargetLot2, LotType.MUTUAL_LIVE);
    testing(boardInput, expectedWhiteTargetLot, LotType.MUTUAL_LIVE);
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
    String expectedBlackTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    String expectedWhiteTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput, expectedBlackTargetLot, LotType.MUTUAL_LIVE);
    testing(boardInput, expectedWhiteTargetLot, LotType.MUTUAL_LIVE);
  }
}
