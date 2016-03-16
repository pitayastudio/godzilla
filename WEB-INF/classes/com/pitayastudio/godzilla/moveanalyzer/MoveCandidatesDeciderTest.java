package com.pitayastudio.godzilla.moveanalyzer;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.modelboard.BlockBoard;
import com.pitayastudio.godzilla.modelboard.CoordBoard;

import org.junit.Assert;
import org.junit.Test;

/**
 * Currently this test is not for any class.
 */
public class MoveCandidatesDeciderTest {

  private static void testing(String boardInput,
      @SuppressWarnings("unused") Color colorOfNextMove) {
    BlockBoard currentBlockBoard = BlockBoard.readFromString(boardInput);
    CoordBoard coordBoard = currentBlockBoard.getCoordBoard();
    ImmutableMap<String, Coord> candidateStringToCoordMap =
        TestUtils.readAlphabetToCandidateCoordMapFromString(boardInput, coordBoard);
    @SuppressWarnings("unused")
    ImmutableList<Coord> candidateCoords = candidateStringToCoordMap.values().asList();
    Coord expectedMoveCoord = candidateStringToCoordMap.get("A");
    // TODO 490 Remove dummy expected value when tests are ready.
    Coord bestMoveCoord = expectedMoveCoord;
    Assert.assertEquals(expectedMoveCoord, bestMoveCoord);
  }

  @Test public void test_01() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○◦◦◦◦"
      + "◦◦◦◦○◦◦◦◦"
      + "◦◦◦◦AB◦◦◦"
      + "◦◦◦●○●◦◦◦"
      + "◦◦◦◦●◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput, Color.B);
  }

  @Test public void test_02() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦○●●●◦◦◦"
      + "◦◦○●○○A◦◦"
      + "◦◦○○●●○◦◦"
      + "◦◦◦◦B○○◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput, Color.B);
  }

  @Test public void test_03() {
    String boardInput =
        "◦◦◦○●◦◦◦◦"
      + "◦◦◦○●◦◦◦◦"
      + "◦◦◦○●◦◦◦◦"
      + "◦◦◦○●◦◦◦◦"
      + "◦◦◦○●◦◦◦◦"
      + "◦◦◦○●◦◦◦◦"
      + "◦○○○●●◦◦◦"
      + "◦○●●○●◦◦◦"
      + "◦◦○BA◦◦◦◦";
    testing(boardInput, Color.B);
  }

  @Test public void test_04() {
    String boardInput =
        "◦◦◦◦●○◦◦◦"
      + "◦◦◦◦●○◦◦◦"
      + "◦◦◦◦●○◦◦◦"
      + "◦◦◦◦●○◦◦◦"
      + "◦◦◦◦●○◦◦◦"
      + "◦◦◦●●○○◦◦"
      + "◦◦◦●○●●B◦"
      + "◦◦◦◦A○○◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput, Color.B);
  }

  @Test public void test_05() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦●◦"
      + "◦◦○◦◦○○●◦"
      + "◦◦◦○◦○●B◦"
      + "◦◦◦◦●●○●◦"
      + "◦◦◦◦◦◦A◦◦";
    testing(boardInput, Color.B);
  }

  @Test public void test_06() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○○◦◦◦◦"
      + "◦◦○B●○○◦◦"
      + "◦◦●○●○●◦◦"
      + "◦◦◦●○●●◦◦"
      + "◦◦◦◦A◦◦◦◦";
    testing(boardInput, Color.B);
  }

  @Test public void test_07() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●◦◦◦◦◦◦"
      + "◦◦●○○○○◦◦"
      + "◦◦○●●○●◦◦"
      + "◦◦○●○●●◦◦"
      + "◦◦○BA◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput, Color.B);
  }

  @Test public void test_08() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○○●●◦◦"
      + "◦◦◦○●○○●◦"
      + "◦◦◦AB○●●◦"
      + "◦◦◦◦●●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput, Color.B);
  }

  @Test public void test_09() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦●●◦"
      + "◦◦◦◦○○●○A"
      + "◦◦○B●●○○●"
      + "◦○●●○○●●◦"
      + "◦◦○○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput, Color.B);
  }

  @Test public void test_10() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○○○●◦◦"
      + "◦○○●●●○●◦"
      + "◦○●B○●○A◦"
      + "◦○●●●○○●◦"
      + "◦◦○○○●●◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput, Color.B);
  }

  @Test public void test_11() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦●●◦"
      + "◦◦◦◦○○●○B"
      + "◦◦◦●●○○●◦"
      + "◦◦◦◦○●●○A"
      + "◦◦◦◦○◦○●◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput, Color.B);
  }

  @Test public void test_12() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○○◦○◦◦"
      + "◦◦○●●◦◦◦◦"
      + "◦◦○●○○◦◦◦"
      + "◦●●○●◦○◦◦"
      + "◦●○○●●○◦◦"
      + "◦●A●○○●○◦"
      + "◦◦◦◦●B◦◦◦";
    testing(boardInput, Color.B);
  }

  @Test public void test_13() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦●●◦"
      + "◦◦◦◦○○○●●"
      + "◦◦◦○●●●○○"
      + "◦◦◦○●B○●A"
      + "◦◦◦◦○○●◦●"
      + "◦◦◦◦◦◦◦●◦";
    testing(boardInput, Color.B);
  }

  @Test public void test_14() {
    String boardInput =
        "◦○◦◦◦◦◦◦◦"
      + "◦○◦◦◦◦◦◦◦"
      + "◦○◦◦◦◦◦◦◦"
      + "◦○◦◦◦◦◦◦◦"
      + "○○●●○◦◦◦◦"
      + "○●●○A○◦●◦"
      + "○●○○○●●◦◦"
      + "○○●●●○○●◦"
      + "◦◦○○◦B●◦◦";
    testing(boardInput, Color.B);
  }

  @Test public void test_15() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○○○○◦◦"
      + "◦○○●●●○◦◦"
      + "◦○◦B○●●○◦"
      + "◦○●●●○○A○"
      + "◦○○●◦●●○◦"
      + "◦◦○○●◦○◦◦";
    testing(boardInput, Color.B);
  }

  @Test public void test_16() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦○●●●●◦◦◦"
      + "◦○●○○●◦◦◦"
      + "◦◦○◦○●○○◦"
      + "◦◦◦○A○●●B";
    testing(boardInput, Color.B);
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
      + "A◦◦◦◦◦◦◦◦";
    testing(boardInput, Color.B);
  }
}
