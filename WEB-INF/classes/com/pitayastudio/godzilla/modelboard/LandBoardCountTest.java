package com.pitayastudio.godzilla.modelboard;

import com.google.common.collect.ImmutableSet;

import com.pitayastudio.godzilla.model.ClosedLand;
import com.pitayastudio.godzilla.model.OpenLand;

import junit.framework.TestCase;

import org.junit.Test;

public class LandBoardCountTest extends TestCase {

  private static void testing(
          int expectedCountOfClosedLands,
          int expectedCountOfOpenLands,
          String boardInput) {
    LandBoard board = LandBoard.readFromString(boardInput);
    ImmutableSet<ClosedLand> closedLands = board.getClosedLands();
    ImmutableSet<OpenLand> openLands = board.getOpenLands();
    assertEquals(expectedCountOfClosedLands, closedLands.size());
    assertEquals(expectedCountOfOpenLands, openLands.size());
  }

  @Test public void testGetEndGameQiLotsOfColor() {
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
    testing(2, 0,
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
    testing(2, 0,
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
    testing(3, 0,
        "◦○○○◦◦◦◦◦"
      + "○●●●○◦◦◦◦"
      + "○●◦●○○◦◦◦"
      + "○●◦◦●○◦◦◦"
      + "◦○●◦●○◦◦◦"
      + "◦○●●●○◦◦◦"
      + "◦○○○○◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testSingleEye_4() {
    testing(2, 0,
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
    testing(2, 0,
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
    testing(2, 0,
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
    testing(2, 0,
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
    testing(2, 0,
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
    testing(3, 0,
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
    testing(3, 0,
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
    testing(3, 0,
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
    testing(3, 0,
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
    testing(3, 0,
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
    testing(3, 0,
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
    testing(3, 0,
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
    testing(3, 0,
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
    testing(4, 0,
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
    testing(5, 0,
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
    testing(5, 0,
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
    testing(5, 1,
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
    testing(3, 1,
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
    testing(3, 1,
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
    testing(4, 1,
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
    testing(5, 1,
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

  @Test public void testSingleEnclosedVacantBlockSeki_5() {
    testing(4, 1,
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "●●●●●◦●◦◦"
      + "○○○○●●◦◦◦"
      + "◦◦◦◦○○●●●"
      + "◦◦○○●●○○○"
      + "◦◦○●◦●○◦○"
      + "◦◦○●●◦○○○");
  }

  @Test public void testSingleEnclosedVacantBlockSeki_6() {
    testing(4, 1,
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
}
