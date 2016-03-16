package com.pitayastudio.godzilla.endgame;

import junit.framework.TestCase;

import org.junit.Test;

/** TODO 200 Implement EndGameTerritoryWithoutDeadAnalyzerErrorFoundRemainingDeadTest. */
public class EndGameTerritoryWithoutDeadAnalyzerErrorFoundRemainingDeadTest extends TestCase {
  private static void testingErrorFoundRemainingDead(String boardInput) {
    EndGameTerritoryWithoutDeadAnalyzer analyzer =
        EndGameTerritoryWithoutDeadAnalyzer.readFromString(boardInput);
    EndGameAnalysisResultSuccessType result = analyzer.getAnalysisResultType();
    assertEquals(EndGameAnalysisResultSuccessType.OK, result);
  }

  @Test public void testErrorFoundRemainingDead_1() {
    testingErrorFoundRemainingDead(
        "◦●○◦◦◦◦◦◦"
      + "○○○◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testErrorFoundRemainingDead_2() {
    testingErrorFoundRemainingDead(
        "◦●○◦◦◦◦◦◦"
      + "●●○◦◦◦◦◦◦"
      + "○○○◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testErrorFoundRemainingDead_3() {
    testingErrorFoundRemainingDead(
        "◦◦●○◦◦◦◦◦"
      + "●●●○◦◦◦◦◦"
      + "○○○○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testErrorFoundRemainingDead_3a() {
    testingErrorFoundRemainingDead(
        "●●●○○◦◦◦◦"
      + "●◦◦●○◦◦◦◦"
      + "○●●●○◦◦◦◦"
      + "○○○○○◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testErrorFoundRemainingDead_4() {
    testingErrorFoundRemainingDead(
        "◦◦●○◦◦◦◦◦"
      + "◦◦●○◦◦◦◦◦"
      + "●●●○◦◦◦◦◦"
      + "○○○○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testErrorFoundRemainingDead_5() {
    testingErrorFoundRemainingDead(
        "◦◦◦●○◦◦◦◦"
      + "●●●●○◦◦◦◦"
      + "○○○○○◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testErrorFoundRemainingDead_6() {
    testingErrorFoundRemainingDead(
        "●◦◦◦●○◦◦◦"
      + "●●◦●●○◦◦◦"
      + "○●●●○○◦◦◦"
      + "○○○○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testErrorFoundRemainingDead_7() {
    testingErrorFoundRemainingDead(
        "◦◦◦●○◦◦◦◦"
      + "◦◦●●○◦◦◦◦"
      + "●●●○○◦◦◦◦"
      + "○○○◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testErrorFoundRemainingDead_8() {
    testingErrorFoundRemainingDead(
        "●●◦●●○◦◦◦"
      + "●◦◦◦●○◦◦◦"
      + "●●◦●●○◦◦◦"
      + "○●●●○○◦◦◦"
      + "○○○○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testErrorFoundRemainingDead_9() {
    testingErrorFoundRemainingDead(
        "◦◦●●○◦◦◦◦"
      + "◦◦◦●○◦◦◦◦"
      + "●◦●●○◦◦◦◦"
      + "●●●○○◦◦◦◦"
      + "○○○○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testErrorFoundRemainingDead_10() {
    testingErrorFoundRemainingDead(
        "◦◦●●○◦◦◦◦"
      + "◦◦◦●○◦◦◦◦"
      + "●◦◦●○◦◦◦◦"
      + "●●●●○◦◦◦◦"
      + "○○○○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testErrorFoundRemainingDead_11() {
    testingErrorFoundRemainingDead(
        "◦●◦●○◦◦◦◦"
      + "●●●○○◦◦◦◦"
      + "○○○○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testErrorFoundRemainingDead_11a() {
    testingErrorFoundRemainingDead(
        "◦●●◦●○◦◦◦"
      + "●●○●●○◦◦◦"
      + "○○○○○○◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testErrorFoundRemainingDead_12() {
    testingErrorFoundRemainingDead(
        "◦●◦◦●○◦◦◦"
      + "●●●●○○◦◦◦"
      + "○○○○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testErrorFoundRemainingDead_13() {
    testingErrorFoundRemainingDead(
        "◦●◦●●○◦◦◦"
      + "●●●○○○◦◦◦"
      + "○○○○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testErrorFoundRemainingDead_14() {
    testingErrorFoundRemainingDead(
        "◦○●◦●◦●○◦"
      + "◦○●●○●●○◦"
      + "◦○○○○○○○◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testErrorFoundRemainingDead_14a() {
    testingErrorFoundRemainingDead(
        "◦●○◦◦◦◦◦◦"
      + "○○○◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○○"
      + "◦◦◦○○○●●●"
      + "◦◦◦○●●◦●◦"
      + "◦◦◦○○○●●●"
      + "◦◦◦◦◦○○○○");
  }

  @Test public void testErrorFoundRemainingDead_15() {
    testingErrorFoundRemainingDead(
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○○"
      + "◦◦◦◦◦○○○●"
      + "◦◦◦◦○○●●◦"
      + "◦◦◦◦○●●◦●");
  }

  @Test public void testErrorFoundRemainingDead_15a() {
    testingErrorFoundRemainingDead(
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○○"
      + "◦◦◦◦○○○●●"
      + "◦◦◦◦○●●◦●"
      + "◦◦◦◦○○○●◦");
  }

  @Test public void testErrorFoundRemainingDead_16() {
    testingErrorFoundRemainingDead(
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○○○◦◦"
      + "◦◦◦○●●●○◦"
      + "◦◦◦○●◦●○◦"
      + "◦◦○●◦●●○◦"
      + "◦◦○●●○○○◦"
      + "◦◦○○○◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testErrorFoundRemainingDead_17() {
    testingErrorFoundRemainingDead(
        "◦●◦●◦◦●◦●○◦"
      + "●●●○●●○●●○◦"
      + "○○○○○○○○○◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testErrorFoundRemainingDead_18() {
    testingErrorFoundRemainingDead(
        "◦◦◦●○◦◦◦◦"
      + "◦●●●○◦◦◦◦"
      + "●●○○○◦◦◦◦"
      + "○○○◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void testErrorFoundRemainingDead_19() {
    testingErrorFoundRemainingDead(
        "◦◦◦●○◦◦◦◦"
      + "◦◦◦●○◦◦◦◦"
      + "●●●●○◦◦◦◦"
      + "○○○○○◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }
}
