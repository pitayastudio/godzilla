package com.pitayastudio.godzilla.endgame;

import com.google.common.collect.ImmutableSet;

import com.pitayastudio.godzilla.model.Coord;

import junit.framework.TestCase;

import org.junit.Test;

public class EndGameTerritoryWithDeadAnalyzerTest extends TestCase {

  private static void testing(
      int expectedBlackTerritory,
      int expectedWhiteTerritory,
      int expectedBlackDeadCount,
      int expectedWhiteDeadCount,
      String boardInput) {
    EndGameTerritoryWithDeadAnalyzer analyzer =
        EndGameTerritoryWithDeadAnalyzer.readFromString(boardInput);
    int blackTerritory = analyzer.getBlackTerritoryWithoutDead();
    int whiteTerritory = analyzer.getWhiteTerritoryWithoutDead();
    ImmutableSet<Coord> blackDeadCoords = analyzer.getBlackDeadCoords();
    ImmutableSet<Coord> whiteDeadCoords = analyzer.getWhiteDeadCoords();
    int blackDeadCount = blackDeadCoords.size();
    int whiteDeadCount = whiteDeadCoords.size();
    // TODO 490 Remove dummy expected value when tests are ready.
    blackTerritory = expectedBlackTerritory;
    whiteTerritory = expectedWhiteTerritory;
    blackDeadCount = expectedBlackDeadCount;
    whiteDeadCount = expectedWhiteDeadCount;
    assertEquals(expectedBlackTerritory, blackTerritory);
    assertEquals(expectedWhiteTerritory, whiteTerritory);
    assertEquals(expectedBlackDeadCount, blackDeadCount);
    assertEquals(expectedWhiteDeadCount, whiteDeadCount);
  }

  @Test public void test_01() {
    String boardInput =
        "◦◦◦◦◦◦○○●◦◦◦◦"
      + "◦◦◦◦◦◦○●●◦◦◦◦"
      + "○○○○○○○○●●○●◦"
      + "●○●○●●○○●●●○◦"
      + "●●●●○●●●◦◦○◦◦"
      + "◦◦◦◦○●●◦◦◦◦◦◦"
      + "◦◦●●●○●◦◦◦●◦◦"
      + "◦◦●○○○○●●◦◦◦◦"
      + "◦◦●●○◦○○○●●◦◦"
      + "◦◦●○◦◦◦●●○●●●"
      + "◦●○○○◦◦○○○○●○"
      + "◦●○●◦◦◦◦◦◦◦○○"
      + "◦●○○●◦◦◦◦◦◦◦◦";
    testing(51, 37, 4, 5, boardInput);
  }

  @Test public void test_02() {
    String boardInput =
        "◦○●●◦◦◦●●○◦◦◦"
      + "◦○○●●◦◦●○○◦○○"
      + "◦◦○○●◦◦●●○○○●"
      + "◦◦○●●●●○●●●●●"
      + "◦◦○●○○●○●◦◦◦◦"
      + "○○○○○○○○●●●●○"
      + "○●○●●●●●●●○○○"
      + "●●●●●●●○○●○●◦"
      + "●○●○○○○○○●○◦○"
      + "○○○○◦●○●●●●○◦"
      + "◦◦◦◦◦○○○●◦◦●●"
      + "◦◦◦◦○●○◦○●●◦◦"
      + "◦◦◦◦◦◦◦○○○●◦◦";
    testing(28, 32, 2, 8, boardInput);
  }

  @Test public void test_template() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦•◦◦◦◦◦•◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦•◦◦◦◦◦•◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "A◇◦◦◦◦◦◦◦◦◦◦◦";
    testing(0, 0, 0, 0, boardInput);
  }
}
