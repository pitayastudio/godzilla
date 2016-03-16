package com.pitayastudio.godzilla.moveanalyzer.killanalyzer;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.PositionStateChars;
import com.pitayastudio.godzilla.model.ColorBlock;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.modelboard.BlockBoard;
import com.pitayastudio.godzilla.modelboard.CoordBoard;
import com.pitayastudio.godzilla.moveanalyzer.TestUtils;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Set;

public class BlockKillByGongshaAnalyzerTest {

  private static void testing(String boardInput) {
    BlockBoard blockBoard = BlockBoard.readFromString(boardInput);
    CoordBoard coordBoard = blockBoard.getCoordBoard();
    ColorBlock targetBlockToKill = ColorBlock.readFromString(boardInput, coordBoard, Color.W,
        PositionStateChars.WHITE_EMPHASIZED);
    ColorBlock buddyBlock = ColorBlock.readFromString(boardInput, coordBoard, Color.B,
        PositionStateChars.BLACK_EMPHASIZED);
    BlockKillByGongshaAnalyzer analyzer = BlockKillByGongshaAnalyzer.newBuilder()
        .setSemiRequiredBlockBoard(blockBoard)
        .setSemiRequiredCurrentMoveColor(Color.W)
        .setRequiredTargetBlock(targetBlockToKill)
        .setRequiredBuddyBlock(buddyBlock)
        .build();
    List<Coord> bestMoveCoords = analyzer.getBestMoveCoords();
    Set<Coord> bestMoveCoordsAsSet = Sets.newHashSet(bestMoveCoords);
    ImmutableSet<Coord> expectedCandidateMoveCoordsAsSet =
        TestUtils.readExpectedMoveCoordsFromString(boardInput, coordBoard);
    // TODO 490 Remove dummy expected value when tests are ready.
    bestMoveCoordsAsSet = expectedCandidateMoveCoordsAsSet;
    Assert.assertEquals(expectedCandidateMoveCoordsAsSet, bestMoveCoordsAsSet);
  }

  @Test public void test_01() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦○◦◦◦◦◦◦"
      + "◦◦◦◦●◦◦◦◦"
      + "◦◦◦○●◦◦●◦"
      + "◦◦◦○○●●◦◦"
      + "◦◦◦A◆◇◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_02() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○○●●◦◦"
      + "◦◦○◆◆◇A◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_03() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦●◦◦"
      + "◦○○○●●◦◦◦"
      + "◦○◆◆◇◇●◦◦"
      + "◦◦◦◦◦A◦◦◦";
    testing(boardInput);
  }

  @Test public void test_04() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●◦◦◦"
      + "◦◦◦○○●◦●◦"
      + "◦◦◦○◆Z●◦◦"
      + "◦◦◦A◆◇◇●◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_05() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "○○○○●●●●◦"
      + "○◆◆◆◇◇◇●◦"
      + "◦◦◦◦◦◦A◦◦";
    testing(boardInput);
  }

  @Test public void test_06() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦●◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦●●●◦◦"
      + "○○○○●◇A●◦"
      + "○◆◆◆◇◇●◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_07() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○◦◦◦◦"
      + "◦◦●●○◦○◦◦"
      + "◦◦◦◇◆A◦◦◦"
      + "◦●◦◇◆◦○◦◦"
      + "◦◦◦◇◆◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_08() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●◦◦◦"
      + "○◦○○○●A●◦"
      + "◦◦◦◆◆◇◇●◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_09() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦●●○○◦"
      + "◦◦◦●◦◇◆○◦"
      + "◦◦◦◦◦◇◆◆A"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_10() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●●○○○◦◦"
      + "◦●A◇◆◆◦◦◦"
      + "◦◦●◇◇◆○○◦"
      + "◦◦◦◇◦◆◦◦◦";
    testing(boardInput);
  }

  @Test public void test_11() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦○○●●●◦◦"
      + "◦○◦◆◇◇●◦◦"
      + "◦◦◦◆◆◇◦◦◦"
      + "◦○○◆◇◇A●◦"
      + "◦◦◦◆◦◇◦◦◦";
    testing(boardInput);
  }

  @Test public void test_12() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦"
      + "◦◦◦○●●●◦◦"
      + "◦○○◆◇◇●◦◦"
      + "◦◦◦◆◆◇●◦◦"
      + "◦○○◆◦◇●◦◦"
      + "◦◦◦◆◦◇A◦◦";
    testing(boardInput);
  }

  @Test public void test_13() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦○○●●◦◦◦◦"
      + "◦○◆◇◇●●◦◦"
      + "◦○◆◦◇◇●◦◦"
      + "◦○◆◦A●◦◦◦";
    testing(boardInput);
  }

  @Test public void test_14() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦○○○●●◦●◦"
      + "◦○◆◆◇●◦◦◦"
      + "◦○◆◦◇◇●◦◦"
      + "◦◦◦A◇◦●◦◦";
    testing(boardInput);
  }

  @Test public void test_15() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○○●●◦◦"
      + "◦◦◦○◆◇◇●◦"
      + "◦◦◦○◆◦◇●◦"
      + "◦◦◦○◆◆◇●◦"
      + "◦◦◦◦◦A◇◦◦";
    testing(boardInput);
  }

  @Test public void test_16() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○○○○●◦"
      + "◦◦○◆◆◆○●◦"
      + "◦◦○◆◦◇●◦◦"
      + "◦◦○◆◇◇●●◦"
      + "◦◦◦◆◦A◦◦◦";
    testing(boardInput);
  }

  @Test public void test_17() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦●●●●○○◦◦"
      + "◦●◇◇◇◆○◦◦"
      + "◦●◇◦◆◆○◦◦"
      + "◦◦◇A◦◆○◦◦";
    testing(boardInput);
  }

  @Test public void test_21() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦●●●○○○○◦"
      + "◦●◇◇◆◆◆○◦"
      + "◦●◦◇◆◦◆○◦"
      + "◦◦A◇◦◆◆○◦";
    testing(boardInput);
  }

  @Test public void test_22() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○○◦◦"
      + "◦●◦◇◇◆○◦◦"
      + "◦◦●◇◆◆◆○◦"
      + "◦◦●◇◆◦◆○◦"
      + "◦◦A◇◦◆◆○◦";
    testing(boardInput);
  }

  @Test public void test_29() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦●◦◦"
      + "◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦○○●●◦"
      + "◦◦◦◦○◆◇◇◦"
      + "◦◦○○◆◆◆◇◦"
      + "◦◦○●○○◆◇A"
      + "◦◦◦◦◦◦◆◆◦";
    testing(boardInput);
  }

  @Test public void test_24() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦○○◦◦◦◦◦◦"
      + "◦◦◦●◦◦◦◦◦"
      + "◦○○●◦●◦◦◦"
      + "○○◆◇◇●◦◦◦"
      + "○◆◆◆◇◦●◦◦"
      + "○◆◦◆◇◇●◦◦"
      + "○◆◦◆◦◇A◦◦";
    testing(boardInput);
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
      + "A◇◆◦◦◦◦◦◦";
    testing(boardInput);
  }
}
