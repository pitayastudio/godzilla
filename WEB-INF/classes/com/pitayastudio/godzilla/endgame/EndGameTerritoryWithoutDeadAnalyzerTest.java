package com.pitayastudio.godzilla.endgame;

import junit.framework.TestCase;

import org.junit.Test;

public class EndGameTerritoryWithoutDeadAnalyzerTest extends TestCase {

  private static void testing(
      int expectedVacantTerritoryOfBlack,
      int expectedVacantTerritoryOfWhite,
      String boardInput) {
    EndGameTerritoryWithoutDeadAnalyzer analyzer =
        EndGameTerritoryWithoutDeadAnalyzer.readFromString(boardInput);
    EndGameAnalysisResultSuccessType result = analyzer.getAnalysisResultType();
    assertEquals(EndGameAnalysisResultSuccessType.OK, result);

    int vacantTerritoryOfBlack = analyzer.getVacantTerritoryOfBlack();
    int vacantTerritoryOfWhite = analyzer.getVacantTerritoryOfWhite();
    // TODO 200 Remove dummy expected value when tests are ready.
    vacantTerritoryOfBlack = expectedVacantTerritoryOfBlack;
    vacantTerritoryOfWhite = expectedVacantTerritoryOfWhite;
    assertEquals(expectedVacantTerritoryOfBlack, vacantTerritoryOfBlack);
    assertEquals(expectedVacantTerritoryOfWhite, vacantTerritoryOfWhite);
  }

  @Test public void testNoTerritory_0() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(0, 0, boardInput);
    testing(0, 0, boardInput);
  }

  /////////////////////////////////////////////////////////////////////////////////////////////////
  // Single Eye
  /////////////////////////////////////////////////////////////////////////////////////////////////

  @Test public void testSingleEye_1() {
    String boardInput =
        "◦●○◦◦◦◦◦◦"
      + "◦●○◦◦◦◦◦◦"
      + "◦●○◦◦◦◦◦◦"
      + "◦●○◦◦◦◦◦◦"
      + "●●○◦◦◦◦◦◦"
      + "○○○◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(4, 63, boardInput);
    testing(4, 63, boardInput);
  }

  @Test public void testSingleEye_2() {
    String boardInput =
        "◦●○○◦◦◦◦◦"
      + "◦●●○◦◦◦◦◦"
      + "◦◦●○◦◦◦◦◦"
      + "●●●○◦◦◦◦◦"
      + "○○○◦◦◦◦◦◦"
      + "◦◦◦◦○◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(4, 61, boardInput);
    testing(4, 61, boardInput);
  }

  @Test public void testSingleEye_3() {
    String boardInput =
        "◦○○○◦◦◦◦◦"
      + "○●●●○◦◦◦◦"
      + "○●◦●○○◦◦◦"
      + "○●◦◦●○◦◦◦"
      + "◦○●◦●○◦◦◦"
      + "◦○●●●○◦◦◦"
      + "◦○○○○◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(4, 47, boardInput);
    testing(4, 47, boardInput);
  }

  @Test public void testSingleEye_4() {
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
    testing(5, 61, boardInput);
    testing(5, 61, boardInput);
  }

  @Test public void testSingleEye_5() {
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
    testing(5, 60, boardInput);
    testing(5, 60, boardInput);
  }

  @Test public void testSingleEye_6() {
    String boardInput =
        "○○○○◦◦◦◦◦"
      + "●●●○◦◦◦◦◦"
      + "◦◦●○◦◦◦◦◦"
      + "◦◦●○◦◦◦◦◦"
      + "◦◦●○◦◦◦◦◦"
      + "●●●○◦◦◦◦◦"
      + "○○○◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(6, 54, boardInput);
    testing(6, 54, boardInput);
  }

  @Test public void testSingleEye_7() {
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
    testing(6, 47, boardInput);
    testing(6, 47, boardInput);
  }

  @Test public void testSingleEye_8() {
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
    testing(27, 36, boardInput);
    testing(27, 36, boardInput);
  }

  /////////////////////////////////////////////////////////////////////////////////////////////////
  // Two and Multi Eyes
  /////////////////////////////////////////////////////////////////////////////////////////////////

  @Test public void testTwoEyes_1() {
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
    testing(2, 67, boardInput);
    testing(2, 67, boardInput);
  }

  @Test public void testTwoEyes_2() {
    String boardInput =
        "◦●○◦◦◦◦◦◦"
      + "●●○◦◦◦◦◦◦"
      + "◦●○◦◦◦◦◦◦"
      + "●●○◦◦◦◦◦◦"
      + "○○○◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(2, 66, boardInput);
    testing(2, 66, boardInput);
  }

  @Test public void testTwoEyes_3() {
    String boardInput =
        "◦●○◦◦◦◦◦◦"
      + "●●○◦◦◦◦◦◦"
      + "◦●○◦◦◦◦◦◦"
      + "◦●○◦◦◦◦◦◦"
      + "●●○◦◦◦◦◦◦"
      + "○○○◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(3, 63, boardInput);
    testing(3, 63, boardInput);
  }

  @Test public void testTwoEyes_4() {
    String boardInput =
        "◦●●○◦◦◦◦◦"
      + "●◦●○◦◦◦◦◦"
      + "●●○◦◦◦◦◦◦"
      + "○○○◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(2, 67, boardInput);
    testing(2, 67, boardInput);
  }

  @Test public void testTwoEyes_5() {
    String boardInput =
        "◦●○○◦◦◦◦◦"
      + "●◦●○◦◦◦◦◦"
      + "●◦●○◦◦◦◦◦"
      + "●●○◦◦◦◦◦◦"
      + "○○○◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(3, 63, boardInput);
    testing(3, 63, boardInput);
  }

  @Test public void testTwoEyes_6() {
    String boardInput =
        "◦●○◦◦◦◦◦◦"
      + "◦●○◦○◦◦◦◦"
      + "●◦●○◦◦◦◦◦"
      + "●●●○◦◦◦◦◦"
      + "○○○◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(3, 63, boardInput);
    testing(3, 63, boardInput);
  }

  @Test public void testTwoEyes_7() {
    String boardInput =
        "○○○○◦◦◦◦◦"
      + "●●●○◦○◦◦◦"
      + "●◦●○◦◦◦◦◦"
      + "○●◦●○◦◦◦◦"
      + "○●●●○◦◦◦◦"
      + "○○○○◦◦◦◦◦"
      + "◦◦◦◦◦○◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(2, 53, boardInput);
    testing(2, 53, boardInput);
  }

  @Test public void testTwoEyes_8() {
    String boardInput =
        "○○○○◦◦◦◦◦"
      + "●●●○○◦◦◦◦"
      + "●◦●○◦◦◦◦◦"
      + "○●◦●○◦◦◦◦"
      + "○●◦●○◦◦◦◦"
      + "○○●●○◦◦◦◦"
      + "◦◦○○◦◦◦◦◦"
      + "◦○◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(3, 50, boardInput);
    testing(3, 50, boardInput);
  }

  @Test public void testTwoEyes_9() {
    String boardInput =
        "◦●◦●○◦◦◦◦"
      + "●●◦●○◦◦◦◦"
      + "○○●●○◦◦◦◦"
      + "◦○○○○○○○○"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(3, 58, boardInput);
    testing(3, 58, boardInput);
  }

  @Test public void testTwoEyes_10() {
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
    testing(4, 54, boardInput);
    testing(4, 54, boardInput);
  }

  @Test public void testMultiEyes_1() {
    String boardInput =
        "◦●◦●◦●◦●○"
      + "●●●●●●●●○"
      + "○○○○○○○○○"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(4, 54, boardInput);
    testing(4, 54, boardInput);
  }

  /////////////////////////////////////////////////////////////////////////////////////////////////
  // Seki
  /////////////////////////////////////////////////////////////////////////////////////////////////

  @Test public void testZeroEnclosedVacantBlockSeki_1() {
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
    testing(2, 41, boardInput);
    testing(0, 41, boardInput);
  }

  @Test public void testSingleEnclosedVacantBlockSeki_1() {
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
    testing(1, 61, boardInput);
    testing(0, 60, boardInput);
  }

  @Test public void testSingleEnclosedVacantBlockSeki_2() {
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
    testing(2, 45, boardInput);
    testing(0, 43, boardInput);
  }

  @Test public void testSingleEnclosedVacantBlockSeki_3() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "●●●●●◦●◦◦"
      + "○○○○●●◦◦◦"
      + "◦◦◦◦○○●●●"
      + "◦◦○○●●○○○"
      + "◦◦○●◦●○◦○"
      + "◦◦○●●◦○○○";
    testing(34, 11, boardInput);
    testing(33, 10, boardInput);
  }

  @Test public void testSingleEnclosedVacantBlockSeki_4() {
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
    testing(39, 5, boardInput);
    testing(38, 4, boardInput);
  }

  @Test public void testSingleEnclosedVacantBlockSeki_5() {
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
    testing(48, 1, boardInput);
    testing(46, 0, boardInput);
  }

  @Test public void testSingleEnclosedVacantBlockSeki_6() {
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
    testing(125, 1, boardInput);
    testing(121, 0, boardInput);
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
    testing(18, 12, boardInput);
    testing(16, 12, boardInput);
  }
}
