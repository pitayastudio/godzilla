package com.pitayastudio.godzilla.modelboard;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.PositionStateChars;
import com.pitayastudio.godzilla.model.LotType;

import org.junit.Test;

public class LotBoardTypeLiveTest extends LotBoardTypeTest {

  @Test public void testSingleEye_01() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○○○○○○"
      + "◦◦◦○●●●●●"
      + "◦◦◦○●◦◦◦◦";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦●●●●●"
      + "◦◦◦◦●▫▫▫▫";
    testing(boardInput, expectedTargetLot, LotType.LIVE);
  }

  @Test public void testSingleEye_02() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○○○○○"
      + "◦◦◦◦○●●●◦"
      + "◦◦◦◦○●◦●●"
      + "◦◦◦◦○●◦◦◦";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●●◦"
      + "◦◦◦◦◦●▫●●"
      + "◦◦◦◦◦●▫▫▫";
    testing(boardInput, expectedTargetLot, LotType.LIVE);
  }

  @Test public void testSingleEye_03() {
    String boardInput =
        "◦○○○○◦◦◦◦"
      + "○●●●○○◦◦◦"
      + "○●◦●●○◦◦◦"
      + "○●◦◦●○◦◦◦"
      + "○●●◦●○◦◦◦"
      + "○○●●●○◦◦◦"
      + "◦○○○○○◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦●●●◦◦◦◦◦"
      + "◦●▫●●◦◦◦◦"
      + "◦●▫▫●◦◦◦◦"
      + "◦●●▫●◦◦◦◦"
      + "◦◦●●●◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput, expectedTargetLot, LotType.LIVE);
  }

  @Test public void testSingleEye_04() {
    String boardInput =
        "◦◦●○◦◦◦◦◦"
      + "●◦●○◦◦◦◦◦"
      + "◦◦●○◦◦◦◦◦"
      + "●●●○◦◦◦◦◦"
      + "○○○◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    String expectedTargetLot =
        "▫▫●◦◦◦◦◦◦"
      + "●▫●◦◦◦◦◦◦"
      + "▫▫●◦◦◦◦◦◦"
      + "●●●◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput, expectedTargetLot, LotType.LIVE);
  }

  @Test public void testSingleEye_05() {
    String boardInput =
        "◦◦◦●○◦◦◦◦"
      + "◦●●●○◦◦◦◦"
      + "◦●○○○◦◦◦◦"
      + "●●○◦◦◦◦◦◦"
      + "○○◦◦◦◦◦◦◦"
      + "◦◦○◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    String expectedTargetLot =
        "▫▫▫●◦◦◦◦◦"
      + "▫●●●◦◦◦◦◦"
      + "▫●◦◦◦◦◦◦◦"
      + "●●◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput, expectedTargetLot, LotType.LIVE);
  }

  @Test public void testSingleEye_06() {
    String boardInput =
        "○○○○○◦◦◦◦"
      + "●●●●○◦◦◦◦"
      + "●◦◦●○◦◦◦◦"
      + "●◦◦●○◦◦◦◦"
      + "●◦◦●○◦◦◦◦"
      + "●●●●○◦◦◦◦"
      + "○○○○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "●●●●◦◦◦◦◦"
      + "●▫▫●◦◦◦◦◦"
      + "●▫▫●◦◦◦◦◦"
      + "●▫▫●◦◦◦◦◦"
      + "●●●●◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput, expectedTargetLot, LotType.LIVE);
  }

  @Test public void testSingleEye_07() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "●●●●●●●●●"
      + "○○○○○○○○○"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    String expectedTargetLot =
        "▫▫▫▫▫▫▫▫▫"
      + "▫▫▫▫▫▫▫▫▫"
      + "▫▫▫▫▫▫▫▫▫"
      + "●●●●●●●●●"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput, expectedTargetLot, LotType.LIVE);
  }

  @Test public void test_03() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦○○○○◦◦◦"
      + "○○○●●◦◦◦◦"
      + "○●●◦●○○○◦"
      + "○●◦●◦●●◦◦";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦●●θ◦◦◦"
      + "◦●●▫●◦◦◦◦"
      + "◦●▫●▫●●θ◦";
    testing(boardInput, expectedTargetLot, LotType.LIVE);
  }

  @Test public void test_04() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦"
      + "◦◦◦◦◦◦◦○◦"
      + "◦◦◦◦◦○○●◦"
      + "◦◦◦○◦○●◦●"
      + "◦◦◦◦◦●◦●◦";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦●θ"
      + "◦◦◦◦◦◦●▫●"
      + "◦◦◦◦θ●▫●▫";
    testing(boardInput, expectedTargetLot, LotType.LIVE);
  }

  @Test public void test_06() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦○○○○"
      + "◦◦◦◦○●●●●"
      + "◦◦◦◦○●◦●◦";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●●●"
      + "◦◦◦◦◦●▫●▫";
    testing(boardInput, expectedTargetLot, LotType.LIVE);
  }

  @Test public void test_07() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○◦○○○"
      + "◦◦◦◦◦○●●●"
      + "◦◦◦◦◦○●◦●"
      + "◦◦◦◦◦○○●◦";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦●●●"
      + "◦◦◦◦◦◦●▫●"
      + "◦◦◦◦◦◦◦●▫";
    testing(boardInput, expectedTargetLot, LotType.LIVE);
  }

  @Test public void test_09() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○○○○◦◦"
      + "◦◦○●●●●○◦"
      + "◦◦○●◦●○◦◦"
      + "◦○●◦●○◦○◦"
      + "◦○●●●○◦◦◦"
      + "◦◦○○○◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦●●●●◦◦"
      + "◦◦◦●▫●◦◦◦"
      + "◦◦●▫●◦◦◦◦"
      + "◦◦●●●◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput, expectedTargetLot, LotType.LIVE);
  }

  @Test public void test_13() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦○◦◦"
      + "○○●●○○◦◦◦"
      + "○●●◦●●○◦◦"
      + "◦◦◦●◦●◦◦◦";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●●◦◦◦◦◦"
      + "◦●●▫●●◦◦◦"
      + "◦θθ●▫●θ◦◦";
    testing(boardInput, expectedTargetLot, LotType.LIVE);
  }

  @Test public void test_18() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○◦○○"
      + "◦◦◦◦◦◦○●●"
      + "◦◦◦◦◦○●●◦"
      + "◦◦◦◦◦○●◦●";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦●●"
      + "◦◦◦◦◦◦●●▫"
      + "◦◦◦◦◦◦●▫●";
    testing(boardInput, expectedTargetLot, LotType.LIVE);
  }

  @Test public void test_19() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○○○"
      + "◦◦◦◦○○●●◦"
      + "◦◦◦◦○●●◦◦"
      + "◦◦◦◦○●◦●◦";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦●●θ"
      + "◦◦◦◦◦●●θ◦"
      + "◦◦◦◦◦●▫●θ";
    testing(boardInput, expectedTargetLot, LotType.LIVE);
  }

  @Test public void test_22() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦"
      + "◦◦◦○○○○◦◦"
      + "◦◦◦○●●◦○○"
      + "◦◦◦○●◦●●●"
      + "◦◦◦○◦●●◦◦";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦●●θ◦◦"
      + "◦◦◦◦●▫●●●"
      + "◦◦◦◦θ●●θθ";
    testing(boardInput, expectedTargetLot, LotType.LIVE);
  }

  @Test public void test_25() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦○○○○◦◦◦"
      + "◦○○●●◦○○◦"
      + "◦○●●◦●●●○"
      + "◦◦○◦●◦◦◦◦";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦●●◦◦◦◦"
      + "◦◦●●▫●●●◦"
      + "◦◦◦θ●θθθ◦";
    testing(boardInput, expectedTargetLot, LotType.LIVE);
  }

  @Test public void test_29() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦○○○○○○○○"
      + "◦○●●●●●●○"
      + "◦◦◦◦◦●◦●○";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●●●●◦"
      + "◦◦θθθ●▫●◦";
    testing(boardInput, expectedTargetLot, LotType.LIVE);
  }

  @Test public void test_32() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦○◦○○○○○○"
      + "◦◦○●●●●●●"
      + "◦◦◦◦◦◦◦◦◦";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦●●●●●●"
      + "◦◦◦θθθθθθ";
    testing(boardInput, expectedTargetLot, LotType.LIVE);
  }

  @Test public void test_33() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○○○○○◦"
      + "◦◦○◦●●●○○"
      + "◦◦○●●◦◦●○"
      + "◦◦○●◦●◦●○";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦●●●◦◦"
      + "◦◦◦●●▫▫●◦"
      + "◦◦◦●▫●▫●◦";
    testing(boardInput, expectedTargetLot, LotType.LIVE);
  }

  @Test public void test_34() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦○◦○○○◦◦"
      + "◦◦◦○◦●●○◦"
      + "◦◦○●●◦●○◦"
      + "◦◦○●◦●◦○◦"
      + "◦◦○◦◦●○◦◦";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦θ●●◦◦"
      + "◦◦◦●●▫●◦◦"
      + "◦◦◦●θ●θ◦◦"
      + "◦◦◦θθ●◦◦◦";
    testing(boardInput, expectedTargetLot, LotType.LIVE);
  }

  @Test public void test_37() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦"
      + "◦◦◦◦◦◦◦◦○"
      + "◦◦○◦○○○○●"
      + "◦◦◦○◦●●●●"
      + "◦◦◦◦◦●◇◦◇";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦●"
      + "◦◦◦◦θ●●●●"
      + "◦◦◦◦θ●◦θ◦";
    testing(boardInput, expectedTargetLot, LotType.LIVE);
    String prisoner1 =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○θ◦";
    testing(boardInput, Color.W, PositionStateChars.WHITE_EMPHASIZED, prisoner1, LotType.PRISONER);
    String prisoner2 =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦θ○";
    testing(boardInput, Color.W, PositionStateChars.WHITE_EMPHASIZED, prisoner2, LotType.PRISONER);
  }

  @Test public void test_39() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦○○○○◦◦◦"
      + "◦○○●●●○○◦"
      + "◦○●●◦●●○◦"
      + "◦◦◦◦●◦◦◦◦";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦●●●◦◦◦"
      + "◦◦●●▫●●◦◦"
      + "◦◦θθ●θθ◦◦";
    testing(boardInput, expectedTargetLot, LotType.LIVE);
  }

  @Test public void test_45() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○○◦◦◦◦"
      + "◦○○◦◦○○◦◦"
      + "◦○●●◦●●○◦"
      + "◦◦●◦●◦●○◦";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦θ◦◦◦◦◦"
      + "◦◦●●θ●●◦◦"
      + "◦θ●▫●▫●◦◦";
    testing(boardInput, expectedTargetLot, LotType.LIVE);
  }

  @Test public void test_47() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○◦○○"
      + "◦◦◦◦◦◦○◦◦"
      + "◦◦◦◦◦○◦●●"
      + "◦◦◦◦◦○●●◇"
      + "◦◦◦◦◦○●◇◦";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦θθ"
      + "◦◦◦◦◦◦θ●●"
      + "◦◦◦◦◦◦●●◦"
      + "◦◦◦◦◦◦●◦◦";
    testing(boardInput, expectedTargetLot, LotType.LIVE);
    String prisoner =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦○"
      + "◦◦◦◦◦◦◦○▫";
    testing(boardInput, Color.W, PositionStateChars.WHITE_EMPHASIZED, prisoner, LotType.PRISONER);
  }

  @Test public void test_51() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○◦◦◦"
      + "◦◦◦◦◦◦○○○"
      + "◦◦◦○○○●●○"
      + "◦◦◦○●●◦●◦"
      + "◦◦◦○●◦◦●◦";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦●●◦"
      + "◦◦◦◦●●▫●θ"
      + "◦◦◦◦●▫▫●θ";
    testing(boardInput, expectedTargetLot, LotType.LIVE);
  }

  @Test public void test_60() {
    String boardInput =
        "◦●◦●◦●◦●○"
      + "●●●○●●●●○"
      + "○○○○○○○○○"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    String expectedTargetLot =
        "▫●▫●▫●▫●◦"
      + "●●●◦●●●●◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput, expectedTargetLot, LotType.LIVE);
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
    testing(boardInput, expectedTargetLot, LotType.LIVE);
  }
}
