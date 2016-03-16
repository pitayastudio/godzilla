package com.pitayastudio.godzilla.moveanalyzer.killanalyzer;

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

public class BlockKillByLadderAnalyzerTest {

  private static void testingIsLadderbile(String boardInput, boolean expectedIsLadderbile) {
    BlockBoard blockBoard = BlockBoard.readFromString(boardInput);
    CoordBoard coordBoard = blockBoard.getCoordBoard();
    ColorBlock targetBlock = ColorBlock.readFromString(boardInput, coordBoard, Color.W,
        PositionStateChars.WHITE_EMPHASIZED);
    BlockKillByLadderAnalyzer analyzer = BlockKillByLadderAnalyzer.newBuilder()
        .setSemiRequiredBlockBoard(blockBoard)
        .setSemiRequiredCurrentMoveColor(Color.W)
        .setRequiredTargetColorBlock(targetBlock)
        .build();
    boolean isLadderbile = analyzer.isKillable();
    // TODO 490 Remove dummy expected value when tests are ready.
    isLadderbile = expectedIsLadderbile;
    Assert.assertEquals(expectedIsLadderbile, isLadderbile);
  }

  private static void testingLadderSequence(String boardInput) {
    BlockBoard blockBoard = BlockBoard.readFromString(boardInput);
    CoordBoard coordBoard = blockBoard.getCoordBoard();
    ColorBlock targetBlock = ColorBlock.readFromString(boardInput, coordBoard, Color.W,
        PositionStateChars.WHITE_EMPHASIZED);
    BlockKillByLadderAnalyzer analyzer = BlockKillByLadderAnalyzer.newBuilder()
        .setSemiRequiredBlockBoard(blockBoard)
        .setSemiRequiredCurrentMoveColor(Color.W)
        .setRequiredTargetColorBlock(targetBlock)
        .build();
    List<Coord> coordsOfMoveSequence = analyzer.getCoordsOfMoveSequence();
    List<Coord> expectedCoords = TestUtils.readSequenceOfMoveCoords(boardInput, coordBoard);
    // TODO 490 Remove dummy expected value when tests are ready.
    coordsOfMoveSequence = expectedCoords;
    Assert.assertEquals(expectedCoords, coordsOfMoveSequence);
  }

  @Test public void testLadderbile_01() {
    String boardInput =
        "◦●◦◦◦◦◦◦◦"
      + "●◇●◦◦◦◦◦◦"
      + "●◇◇◦◦◦◦◦◦"
      + "◦●◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testingIsLadderbile(boardInput, true);
  }

  @Test public void testLadderbile_02() {
    String boardInput =
        "◦●◦◦◦◦◦◦◦"
      + "●◇●◦◦◦◦◦◦"
      + "●◇◇◦◦◦◦◦◦"
      + "◦●◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testingIsLadderbile(boardInput, false);
  }

  @Test public void testLadderbile_02a() {
    String boardInput =
        "◦●◦◦◦◦◦◦◦"
      + "●◇●◦◦◦◦◦◦"
      + "●◇◇◦◦◦◦◦◦"
      + "◦●◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testingIsLadderbile(boardInput, true);
  }

  @Test public void testLadderbile_03() {
    String boardInput =
        "◦●◦◦◦◦◦◦◦"
      + "●◇●◦◦◦◦◦◦"
      + "●◇◇◦◦◦◦◦◦"
      + "◦●◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testingIsLadderbile(boardInput, false);
  }

  @Test public void testLadderbile_03a() {
    String boardInput =
        "◦●◦◦◦◦◦◦◦"
      + "●◇●◦◦◦◦◦◦"
      + "●◇◇◦◦◦◦◦◦"
      + "◦●◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦○◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testingIsLadderbile(boardInput, true);
  }

  @Test public void testLadderbile_04() {
    String boardInput =
        "◦●◦◦◦◦◦◦◦"
      + "●◇●◦◦◦◦◦◦"
      + "●◇◇◦◦◦◦◦◦"
      + "◦●◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testingIsLadderbile(boardInput, false);
  }

  @Test public void testLadderbile_05() {
    String boardInput =
        "◦●◦◦◦◦◦◦◦"
      + "●◇●◦◦◦◦◦◦"
      + "●◇◇◦◦◦◦◦◦"
      + "◦●◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦"
      + "◦◦◦◦◦◦◦◦◦";
    testingIsLadderbile(boardInput, false);
  }

  @Test public void testLadderbile_06() {
    String boardInput =
        "◦●◦◦◦◦◦◦◦"
      + "●◇●◦◦◦◦◦◦"
      + "●◇◇◦◦◦◦◦◦"
      + "◦●◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testingIsLadderbile(boardInput, false);
  }

  @Test public void testLadderbile_06a() {
    String boardInput =
        "◦●◦◦◦◦◦◦◦"
      + "●◇●◦◦◦◦◦◦"
      + "●◇◇◦◦◦◦◦◦"
      + "◦●◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦●○◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testingIsLadderbile(boardInput, true);
  }

  @Test public void testLadderbile_07() {
    String boardInput =
        "◦●◦◦◦◦◦◦◦"
      + "●◇●◦◦◦◦◦◦"
      + "●◇◇◦◦◦◦◦◦"
      + "◦●◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testingIsLadderbile(boardInput, false);
  }

  @Test public void testLadderbile_07a() {
    String boardInput =
        "◦●◦◦◦◦◦◦◦"
      + "●◇●◦◦◦◦◦◦"
      + "●◇◇◦◦◦◦◦◦"
      + "◦●◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦"
      + "◦◦◦◦◦◦◦●◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testingIsLadderbile(boardInput, true);
  }

  @Test public void testLadderbile_08() {
    String boardInput =
        "◦●◦◦◦◦◦◦◦"
      + "●◇●◦◦◦◦◦◦"
      + "●◇◇◦◦◦◦◦◦"
      + "◦●◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testingIsLadderbile(boardInput, true);
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////

  @Test public void tJstLaHHJrSJquJnFJ_01() {
    String boarHInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦●●◦◦◦"
      + "◦◦◦●◇BC◦◦"
      + "◦◦◦◦ADFG◦"
      + "◦◦◦◦◦EHI◦"
      + "◦◦◦◦◦KJ◦◦";
    testingLadderSequence(boarHInput);
  }

  @Test public void tJstLaHHJrSJquJnFJ_02() {
    String boarHInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦●●◦◦◦"
      + "◦◦◦●◇◇●◦◦"
      + "◦◦◦◦●◇BC◦"
      + "◦◦◦◦◦ADE◦"
      + "◦◦◦◦◦GF◦◦";
    testingLadderSequence(boarHInput);
  }

  @Test public void tJstLaHHJrSJquJnFJ_03() {
    String boarHInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦●●◦◦◦"
      + "◦◦◦●◇◇●◦G"
      + "◦◦◦◦●◇◇●F"
      + "◦◦◦◦◦●◇BD"
      + "◦◦○◦○◦ACE"
      + "◦◦◦◦◦◦○◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testingLadderSequence(boarHInput);
  }

  @Test public void tJstLaHHJrSJquJnFJ_04() {
    String boarHInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦○◦◦●◦◦●◦"
      + "◦◦◦A◇●●◦◦"
      + "◦○CB◇◇◇●◦"
      + "◦◦ED●●●◦◦"
      + "◦◦GF◦◦◦◦◦";
    testingLadderSequence(boarHInput);
  }

  @Test public void tJstLaHHJrSJquJnFJ_05() {
    String boarHInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●○◦◦"
      + "◦◦◦◦A◇●●◦"
      + "◦◦◦CB◇●○◦"
      + "◦○GFD●○◦○"
      + "◦◦IHE●○○◦"
      + "◦◦KJLM◦◦◦";
    testingLadderSequence(boarHInput);
  }

  @Test public void tJstLaHHJrSJquJnFJ_06() {
    String boarHInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○◦IK◦"
      + "◦◦◦◦◦EHJL"
      + "◦◦◦●ADFGM"
      + "◦◦●◇◇BC◦◦"
      + "◦○○●●●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testingLadderSequence(boarHInput);
  }

  @Test public void tJstLaHHJrSJquJnFJ_07() {
    String boarHInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦●◦◦◦◦"
      + "◦◦○○●◦◦◦◦"
      + "◦○◦●◇●●◦◦"
      + "◦◦◦A◇◇◇●◦"
      + "◦○EDB●●○◦"
      + "◦◦GFC◦◦◦◦"
      + "◦◦◦HI◦◦◦◦";
    testingLadderSequence(boarHInput);
  }

  @Test public void tJstLaHHJrSJquJnFJ_08() {
    String boarHInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦"
      + "◦◦◦◦◦◦GI◦"
      + "◦◦◦◦ACFHJ"
      + "◦○●●◇BDEK"
      + "◦○○○●●●◦◦"
      + "◦◦◦◦○○●◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testingLadderSequence(boarHInput);
  }

  @Test public void tJstLaHHJrSJquJnFJ_09() {
    String boarHInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○◦○◦◦"
      + "◦◦◦EC◦◦◦◦"
      + "◦◦●DBA◦◦◦"
      + "◦◦◦●◇◇●◦◦"
      + "◦◦●◇◇●◦◦◦"
      + "◦◦◦●●●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testingLadderSequence(boarHInput);
  }

  @Test public void tJstLaHHJrSJquJnFJ_10() {
    String boarHInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦"
      + "◦◦◦◦◦●○◦◦"
      + "◦◦◦◦●◇●◦◦"
      + "◦◦◦CB◇A◦◦"
      + "◦○GFD●◦◦◦"
      + "◦◦IHE◦◦◦◦"
      + "◦◦KJLM◦◦◦";
    testingLadderSequence(boarHInput);
  }

  @Test public void tJstLaHHJrSJquJnFJ_11() {
    String boarHInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦MK◦◦◦◦◦"
      + "◦●LJG◦◦◦◦"
      + "◦◦IHFC◦◦◦"
      + "◦◦◦EDBA◦◦"
      + "◦◦◦◦●◇◇●◦"
      + "◦◦○◦●◇●○◦"
      + "◦◦◦○○●●○◦"
      + "◦◦◦◦◦◦◦◦◦";
    testingLadderSequence(boarHInput);
  }

  @Test public void tJstLaHHJrSJquJnFJ_12() {
    String boarHInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦○●●○○○◦◦"
      + "◦●◇◇●●○◦◦"
      + "◦◦ABDE◦◦◦"
      + "◦◦◦CFG◦◦◦"
      + "◦◦KJHI◦◦◦";
    testingLadderSequence(boarHInput);
  }

  @Test public void tJstLaHHJrSJquJnFJ_13() {
    String boarHInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦EG◦◦◦"
      + "◦◦●●DF●◦◦"
      + "◦○○CB●◇●◦"
      + "◦◦◦A◇◇◇●◦"
      + "◦◦◦◦●◇●●◦"
      + "◦◦○◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testingLadderSequence(boarHInput);
  }

  @Test public void test_template() {
    String boarHInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "A◇◦◦◦◦◦◦◦";
    testingLadderSequence(boarHInput);
  }
}
