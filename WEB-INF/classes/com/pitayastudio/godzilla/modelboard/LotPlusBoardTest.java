package com.pitayastudio.godzilla.modelboard;

import com.google.common.collect.ImmutableSet;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.model.LotPlus;

import junit.framework.TestCase;

import org.junit.Test;

@Deprecated public class LotPlusBoardTest extends TestCase {

  private static void testing(
      int expectedCountOfBlackLotPluses,
      int expectedCountOfWhiteLotPluses,
      String boardInput) {
    LotPlusBoard board = LotPlusBoard.readFromString(boardInput);
    ImmutableSet<LotPlus> blackLotPluses = board.getLotPlusesOfColor(Color.B);
    assertEquals(expectedCountOfBlackLotPluses, blackLotPluses.size());
    ImmutableSet<LotPlus> whiteLotPluses = board.getLotPlusesOfColor(Color.W);
    assertEquals(expectedCountOfWhiteLotPluses, whiteLotPluses.size());
  }

  @Test public void testGetLotPlusesOfColor() {
    testing(0, 0,
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  /////////////////////////////////////////////////////////////////////////////////////////////////
  // Single Eye
  /////////////////////////////////////////////////////////////////////////////////////////////////

  @Test public void testSingleEye_1() {
    testing(1, 1,
        "◦●○◦◦◦◦◦◦"
      + "◦●○◦◦◦◦◦◦"
      + "◦●○◦◦◦◦◦◦"
      + "◦●○◦◦◦◦◦◦"
      + "●●○◦◦◦◦◦◦"
      + "○○○◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testSingleEye_2() {
    testing(1, 1,
        "◦●○○◦◦◦◦◦"
      + "◦●●○◦◦◦◦◦"
      + "◦◦●○◦◦◦◦◦"
      + "●●●○◦◦◦◦◦"
      + "○○○◦◦◦◦◦◦"
      + "◦◦◦◦○◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testSingleEye_3() {
    testing(1, 1,
        "◦○○○○◦◦◦◦"
      + "○●●●○○◦◦◦"
      + "○●◦●●○◦◦◦"
      + "○●◦◦●○◦◦◦"
      + "○●●◦●○◦◦◦"
      + "○○●●●○◦◦◦"
      + "◦○○○○○◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testSingleEye_3a() {
    testing(1, 1,
        "◦○○○◦◦◦◦◦"
      + "○●●●○○◦◦◦"
      + "○●◦●●○◦◦◦"
      + "○●◦◦●○◦◦◦"
      + "○●●◦●○◦◦◦"
      + "◦○●●●○◦◦◦"  // without white at (0, 3)
      + "◦○○○○○◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testSingleEye_3b() {
    testing(1, 1,
        "◦○○○◦◦◦◦◦"
      + "○●●●○◦◦◦◦"
      + "○●◦●○○◦◦◦"
      + "○●◦◦●○◦◦◦"
      + "◦○●◦●○◦◦◦"
      + "◦○●●●○◦◦◦"
      + "◦○○○○◦◦◦◦"  // without white at (4, 2)
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testSingleEye_4() {
    testing(1, 1,
        "◦◦●○◦◦◦◦◦"
      + "●◦●○◦◦◦◦◦"
      + "◦◦●○◦◦◦◦◦"
      + "●●●○◦◦◦◦◦"
      + "○○○◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testSingleEye_5() {
    testing(1, 1,
        "◦◦◦●○◦◦◦◦"
      + "◦●●●○◦◦◦◦"
      + "◦●○○○◦◦◦◦"
      + "●●○◦◦◦◦◦◦"
      + "○○◦◦◦◦◦◦◦"
      + "◦◦○◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testSingleEye_6() {
    testing(1, 1,
        "○○○○◦◦◦◦◦"
      + "●●●○◦◦◦◦◦"
      + "◦◦●○◦◦◦◦◦"
      + "◦◦●○◦◦◦◦◦"
      + "◦◦●○◦◦◦◦◦"
      + "●●●○◦◦◦◦◦"
      + "○○○◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testSingleEye_7() {
    testing(1, 1,
        "○○○○○◦◦◦◦"
      + "●●●●○◦◦◦◦"
      + "●◦◦●○◦◦◦◦"
      + "●◦◦●○◦◦◦◦"
      + "●◦◦●○◦◦◦◦"
      + "●●●●○◦◦◦◦"
      + "○○○○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testSingleEye_8() {
    testing(1, 1,
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "●●●●●●●●●"
      + "○○○○○○○○○"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  /////////////////////////////////////////////////////////////////////////////////////////////////
  // Two and Multi Eyes
  /////////////////////////////////////////////////////////////////////////////////////////////////

  @Test public void testTwoEyes_1() {
    testing(1, 1,
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○◦○○"
      + "◦◦◦◦◦◦○●●"
      + "◦◦◦◦◦○●●◦"
      + "◦◦◦◦◦○●◦●");
  }

  @Test public void testTwoEyes_2() {
    testing(1, 1,
        "◦●○◦◦◦◦◦◦"
      + "●●○◦◦◦◦◦◦"
      + "◦●○◦◦◦◦◦◦"
      + "●●○◦◦◦◦◦◦"
      + "○○○◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testTwoEyes_3() {
    testing(1, 1,
        "◦●○◦◦◦◦◦◦"
      + "●●○◦◦◦◦◦◦"
      + "◦●○◦◦◦◦◦◦"
      + "◦●○◦◦◦◦◦◦"
      + "●●○◦◦◦◦◦◦"
      + "○○○◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testTwoEyes_4() {
    testing(1, 1,
        "◦●●○◦◦◦◦◦"
      + "●◦●○◦◦◦◦◦"
      + "●●○◦◦◦◦◦◦"
      + "○○○◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testTwoEyes_5() {
    testing(1, 1,
        "◦●○○◦◦◦◦◦"
      + "●◦●○◦◦◦◦◦"
      + "●◦●○◦◦◦◦◦"
      + "●●○◦◦◦◦◦◦"
      + "○○○◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testTwoEyes_6() {
    testing(1, 1,
        "◦●○◦◦◦◦◦◦"
      + "◦●○◦○◦◦◦◦"
      + "●◦●○◦◦◦◦◦"
      + "●●●○◦◦◦◦◦"
      + "○○○◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testTwoEyes_7() {
    testing(1, 1,
        "○○○○◦◦◦◦◦"
      + "●●●○◦○◦◦◦"
      + "●◦●○◦◦◦◦◦"
      + "○●◦●○◦◦◦◦"
      + "○●●●○◦◦◦◦"
      + "○○○○◦◦◦◦◦"
      + "◦◦◦◦◦○◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testTwoEyes_8() {
    testing(1, 1,
        "○○○○◦◦◦◦◦"
      + "●●●○○◦◦◦◦"
      + "●◦●○◦◦◦◦◦"
      + "○●◦●○◦◦◦◦"
      + "○●◦●○◦◦◦◦"
      + "○○●●○◦◦◦◦"
      + "◦◦○○◦◦◦◦◦"
      + "◦○◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testTwoEyes_9() {
    testing(1, 1,
        "◦●◦●○◦◦◦◦"
      + "●●◦●○◦◦◦◦"
      + "○○●●○◦◦◦◦"
      + "◦○○○○○○○○"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testTwoEyes_10() {
    testing(1, 1,
        "◦●◦●◦●◦●○"
      + "●●●○●●●●○"
      + "○○○○○○○○○"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testMultiEyes_1() {
    testing(1, 1,
        "◦●◦●◦●◦●○"
      + "●●●●●●●●○"
      + "○○○○○○○○○"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  /////////////////////////////////////////////////////////////////////////////////////////////////
  // Seki
  /////////////////////////////////////////////////////////////////////////////////////////////////

  @Test public void testZeroEnclosedVacantBlockSeki_1() {
    testing(2, 2,
        "●◦●○◦●○◦○"
      + "●●●○◦●○○○"
      + "●◦●○○●○◦○"
      + "●●●●●○○○○"
      + "○○○○○○◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testSingleEnclosedVacantBlockSeki_1() {
    testing(1, 2,
        "◦○●◦●○◦◦◦"
      + "○◦●●●○◦◦◦"
      + "●●●○○○◦◦◦"
      + "○○○◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testSingleEnclosedVacantBlockSeki_2() {
    testing(1, 2,
        "◦◦○●◦●○◦◦"
      + "○○○●◦●○◦◦"
      + "○○○●●●○◦◦"
      + "○○◦●○○○◦◦"
      + "●●●●○◦◦◦◦"
      + "○○○○○◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testSingleEnclosedVacantBlockSeki_3() {
    testing(2, 1,
        "◦●◦●◦○◦○●"
      + "●●●○○○○○●"
      + "○○○○○○○●●"
      + "●●●●●●●●◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testSingleEnclosedVacantBlockSeki_4() {
    testing(2, 2,
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "●●●●◦◦●◦◦"
      + "○○○○●●◦◦◦"
      + "◦◦◦◦○○●●●"
      + "◦◦○○●●○○○"
      + "◦◦○●◦●○◦○"
      + "◦◦○●●◦○○○");
  }

  @Test public void testSingleEnclosedVacantBlockSeki_5() {
    testing(2, 2,
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "●●◦◦◦◦◦◦◦"
      + "○○●●●●◦●◦"
      + "◦○○○●○●◦◦"
      + "◦○●●○○○●●"
      + "◦○●◦●○◦○●"
      + "◦○●●◦○○○●");
  }

  @Test public void testSingleEnclosedVacantBlockSeki_6() {
    testing(2, 1,
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
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testSeki_special_1() {
    String boardInput =
        "◦●◦○◦●◦●○"
      + "●●○○○●●●○"
      + "○○●●●○○○○"
      + "◦○●◦●○◦◦◦"
      + "◦○●◦●○◦◦◦"
      + "◦○●◦●○○○○"
      + "◦○●◦●●●●●"
      + "◦○●◦◦◦◦◦◦"
      + "◦○●◦◦◦◦◦◦";
    testing(3, 3, boardInput);
  }
}
