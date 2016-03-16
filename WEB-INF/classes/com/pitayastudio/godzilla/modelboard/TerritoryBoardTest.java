package com.pitayastudio.godzilla.modelboard;

import org.junit.Test;

/** TODO 350 Implement TerritoryBoardTest. */
public class TerritoryBoardTest {
  private static void testing(@SuppressWarnings("unused") String boardInput) {
  }

  @Test public void test_05() {
    String boardInput =
        "◦◦◦◦◦○◦●◦◦◦◦◦"
      + "◦◦◦◦◦○●●●◦◦◦◦"
      + "◦◦◦○◦○○●○◦●◦◦"
      + "◦◦◦•◦◦○●◦●◦◦◦"
      + "◦◦○◦◦○●●◦◦◦◦◦"
      + "◦◦◦○◦○◦●◦●◦◦◦"
      + "◦◦◦◦○○●●◦◦●◦◦"
      + "○○○○●○◦●◦◦○●●"
      + "◦●●◦●◦○○●●●○●"
      + "●◦◦●●○◦◦○◦○○○"
      + "◦●◦◦●○○○◦○◦◦◦"
      + "◦◦◦◦●●●○◦○◦◦◦"
      + "◦◦◦◦◦◦●●○◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_06() {
    String boardInput =
        "◦○●●◦◦◦●●○◦◦◦"
      + "◦○○●●◦◦●○○◦○○"
      + "◦◦○○●◦◦●●○○○●"
      + "◦◦○●●●●○●●●●●"
      + "◦◦○◦◦○◦○●◦◦◦◦"
      + "○○○○○○○○●●●●◦"
      + "◦●●●●●●●●●○○○"
      + "●●◦●◦●◦◦○●○●◦"
      + "●○○◦○○○○○●○◦○"
      + "○○○○◦◦○●●●●○◦"
      + "◦◦◦◦◦○○○●◦◦●◦"
      + "◦◦◦◦◦●○◦○●●◦◦"
      + "◦◦◦◦◦◦◦○○○●◦◦";
    testing(boardInput);
  }
}
