package com.pitayastudio.godzilla.modelboard;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.PositionStateChars;
import com.pitayastudio.godzilla.model.GangType;

import org.junit.Test;

public class GangBoardTypeLiveTest extends GangBoardTypeTest {

  @Test public void test_30() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○○○○◦◦"
      + "◦○○●●◦●○◦"
      + "◦○●◦●◦●○◦"
      + "◦○●●◦●○○◦";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦●●θ●◦◦"
      + "◦◦●▫●θ●◦◦"
      + "◦◦●●▫●◦◦◦";
    testing(boardInput, expectedTargetLot, GangType.LIVE);
  }

  @Test public void test_31() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○○○○◦"
      + "◦◦◦◦○●●●◦"
      + "◦◦◦◦○●◇◇●"
      + "◦◦◦◦◦◦◦●◦";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●●θ"
      + "◦◦◦◦◦●◦◦●"
      + "◦◦◦◦◦θθ●θ";
    testing(boardInput, expectedTargetLot, GangType.LIVE);
    String prisoner =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○○◦"
      + "◦◦◦◦◦◦θ◦◦";
    testing(boardInput, Color.W, PositionStateChars.WHITE_EMPHASIZED, prisoner, GangType.PRISONER);
  }

  @Test public void test_41() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○◦◦◦"
      + "◦◦◦◦○◦○◦◦"
      + "◦◦◦○●◦◦○◦"
      + "◦◦◦○●◦●○◦"
      + "◦◦○○●◇●○◦"
      + "◦◦○●◦●○○◦"
      + "◦◦○●●●◦◦◦";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦●θθ◦◦"
      + "◦◦◦◦●θ●◦◦"
      + "◦◦◦◦●◦●◦◦"
      + "◦◦◦●▫●◦◦◦"
      + "◦◦◦●●●θ◦◦";
    testing(boardInput, expectedTargetLot, GangType.LIVE);
    String prisoner =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦θ◦◦◦"
      + "◦◦◦◦◦○◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput, Color.W, PositionStateChars.WHITE_EMPHASIZED, prisoner, GangType.PRISONER);
  }

  @Test public void test_42() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○◦◦○○"
      + "◦◦◦◦◦○○●●"
      + "◦◦◦◦○●●●◇"
      + "◦◦◦◦○●◦●◦"
      + "◦◦◦◦○○●●◇"
      + "◦◦◦◦◦◦○○◦";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦●●"
      + "◦◦◦◦◦●●●◦"
      + "◦◦◦◦◦●▫●θ"
      + "◦◦◦◦◦◦●●◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput, expectedTargetLot, GangType.LIVE);
    String prisoner =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦○"
      + "◦◦◦◦◦◦◦◦θ"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput, Color.W, PositionStateChars.WHITE_EMPHASIZED, prisoner, GangType.PRISONER);
  }

  @Test public void test_46() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○○○◦◦"
      + "◦◦◦◦○●◦○◦"
      + "◦◦◦◦○●◦●●"
      + "◦◦◦◦○●◇●◦";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●θ◦◦"
      + "◦◦◦◦◦●θ●●"
      + "◦◦◦◦◦●◦●▫";
    testing(boardInput, expectedTargetLot, GangType.DEAD);
  }

  @Test public void test_49() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦○◦○○○○◦"
      + "◦◦◦○●●●●●"
      + "◦◦◦◦○◦◇●◦";
    String expectedTargetLot =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦●●●●●"
      + "◦◦◦◦◦θ◦●▫";
    testing(boardInput, expectedTargetLot, GangType.LIVE);
    String prisoner =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦θ○◦◦";
    testing(boardInput, Color.W, PositionStateChars.WHITE_EMPHASIZED, prisoner, GangType.PRISONER);
  }
}
