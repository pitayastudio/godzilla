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

public class BlockKillByJiebuguiAnalyzerTest {

  private static void testing(String boardInput) {
    BlockBoard blockBoard = BlockBoard.readFromString(boardInput);
    CoordBoard coordBoard = blockBoard.getCoordBoard();
    ColorBlock targetBlockToKill = ColorBlock.readFromString(boardInput, coordBoard, Color.W,
        PositionStateChars.WHITE_EMPHASIZED);
    BlockKillByJiebuguiAnalyzer analyzer = BlockKillByJiebuguiAnalyzer.newBuilder()
        .setSemiRequiredBlockBoard(blockBoard)
        .setSemiRequiredCurrentMoveColor(Color.W)
        .setRequiredTargetBlock(targetBlockToKill)
        .build();
    List<Coord> coordsOfMoveSequence = analyzer.getCoordsOfMoveSequence();
    List<Coord> expectedCoords = TestUtils.readSequenceOfMoveCoords(boardInput, coordBoard);
    // TODO 490 Remove dummy expected value when tests are ready.
    coordsOfMoveSequence = expectedCoords;
    Assert.assertEquals(expectedCoords, coordsOfMoveSequence);
  }

  // TODO 200 migrate xyIndices to xyPositions
  private static void testing(String boardInput, int ... xyIndicesOfMoveSequence) {
    BlockBoard blockBoard = BlockBoard.readFromString(boardInput);
    CoordBoard coordBoard = blockBoard.getCoordBoard();
    ColorBlock targetBlockToKill = ColorBlock.readFromString(boardInput, coordBoard, Color.W,
        PositionStateChars.WHITE_EMPHASIZED);
    BlockKillByJiebuguiAnalyzer analyzer = BlockKillByJiebuguiAnalyzer.newBuilder()
        .setSemiRequiredBlockBoard(blockBoard)
        .setSemiRequiredCurrentMoveColor(Color.W)
        .setRequiredTargetBlock(targetBlockToKill)
        .build();
    List<Coord> coordsOfMoveSequence = analyzer.getCoordsOfMoveSequence();
    List<Coord> expectedCoords =
        TestUtils.convertXYIndicesToCoords(coordBoard, xyIndicesOfMoveSequence);
    // TODO 490 Remove dummy expected value when tests are ready.
    coordsOfMoveSequence = expectedCoords;
    Assert.assertEquals(expectedCoords, coordsOfMoveSequence);
  }

  @Test public void test_01() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦○○◦●●●◦◦"
      + "◦◦◦○●◇◇●◦"
      + "◦◦◦C○BA◦◦";
    testing(boardInput);
  }

  @Test public void test_02() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦●◦◦◦◦"
      + "◦◦◦○●◦●●◦"
      + "◦◦○◦○●●◇●"
      + "◦◦◦◦○●◇◇●"
      + "◦◦◦◦C○BA◦";
    testing(boardInput);
  }

  @Test public void test_03() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦●○◦◦"
      + "◦◦●●●○◦○◦"
      + "◦●◇◇●○◦◦◦"
      + "◦A◇B○C◦◦◦";
    testing(boardInput);
  }

  @Test public void test_04() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●●◦●◦◦◦"
      + "◦●◇◇A◦◦◦◦"
      + "◦●◇B○●●◦◦"
      + "◦◦●○C○○◦◦"
      + "◦◦●●○◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_06() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦●●●◦◦"
      + "◦◦○○●◇◇●◦"
      + "◦◦○●○B◇●◦"
      + "◦◦◦◦C○A●◦";
    testing(boardInput);
  }

  @Test public void test_07() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○◦○◦◦"
      + "◦◦◦◦◦◦◦○C"
      + "◦◦○○●●●●○"
      + "◦◦○●◦◦●◇B"
      + "◦◦◦◦●◦A◇◇";
    testing(boardInput);
  }

  @Test public void test_08() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦"
      + "◦◦◦◦◦●○CE"
      + "◦◦◦◦◦●●○D"
      + "◦◦◦◦◦A◇B○"
      + "◦◦◦●◦●◇◇●"
      + "◦◦◦◦◦◦●●●"
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
      + "◦◦◦◦●●●◦◦"
      + "◦●○○●◇◇●◦"
      + "◦●○C○B◇●●"
      + "◦◦◦●A◇◇◇●";
    testing(boardInput);
  }

  @Test public void test_10() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●●●◦◦"
      + "◦◦●○○○●◦◦"
      + "◦○○C○B◇●●"
      + "◦◦◦●A◇◇◇●";
    testing(boardInput);
  }

  @Test public void test_11() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦"
      + "◦◦◦◦○◦◦○C"
      + "◦◦◦●○●●●○"
      + "◦◦●◦●◇●○○"
      + "◦◦◦◦●◇◇B○"
      + "◦◦◦◦●●A○○";
    testing(boardInput);
  }

  @Test public void test_12() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦●◦◦"
      + "◦◦◦◦◦●◦◦◦"
      + "◦◦○●●◇●◦◦"
      + "◦◦○○A◇◇●◦"
      + "◦◦◦C○B◇●◦"
      + "◦◦◦ED○●●◦";
    testing(boardInput);
  }

  @Test public void test_13() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦●●◦◦◦"
      + "◦◦◦A◇◇●◦◦"
      + "◦◦CoB◇●◦◦"
      + "○E○D○●○◦◦"
      + "◦○●●●●○◦◦"
      + "◦○◦◦○○◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_14() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●●◦◦◦◦◦"
      + "◦●◇◇●●○◦◦"
      + "◦●◇B○●○◦◦"
      + "◦◦A○○●○◦◦"
      + "◦◦◦CD○E◦◦";
    testing(boardInput);
  }

  @Test public void test_15() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦"
      + "◦◦●●●●◦◦◦"
      + "◦◦●◇◇●○○◦"
      + "◦●◇◇B○C◦◦"
      + "◦●●A○DE◦◦";
    testing(boardInput);
  }

  @Test public void test_16() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●●○◦◦"
      + "◦◦●◇◇●○◦◦"
      + "◦◦●◇B○C◦◦"
      + "◦◦●◇ADE◦◦";
    testing(boardInput);
  }

  @Test public void test_17() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦●●●●●◦◦◦"
      + "○●○○○●◦●◦"
      + "○○B○C◇●◦◦"
      + "◦◦●A◦◇◇●◦";
    testing(boardInput,
        3, 0,
        2, 1,
        4, 1,
        4, 0,
        4, 1);
  }

  @Test public void test_18() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦●●●◦◦"
      + "◦◦○○●◇◇●◦"
      + "◦◦oB○C◇●◦"
      + "◦◦◦●A◦◇●◦";
    testing(boardInput,
        4, 0,
        3, 1,
        5, 1,
        5, 0,
        5, 1);
  }

  @Test public void test_19() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦●●◦◦◦◦"
      + "◦●●◇◇●●◦◦"
      + "◦●○B◇◇●◦◦"
      + "○○CDA●○○◦"
      + "◦◦◦E◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_20() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●◦◦◦○◦◦"
      + "◦◦◦◦●●○CE"
      + "◦◦◦●◇●●○D"
      + "◦◦◦A◇◇◇B○";
    testing(boardInput);
  }

  @Test public void test_21() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●●◦◦◦◦◦"
      + "◦◦●○●●◦◦◦"
      + "◦◦●◇◇◇●◦◦"
      + "◦○○●B◇●◦◦"
      + "◦◦◦C○A●◦◦"
      + "◦◦GFDE◦◦◦";
    testing(boardInput);
  }

  @Test public void test_22() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●◦◦◦◦"
      + "◦◦A◇◇●●◦◦"
      + "◦●●◇B○DE○"
      + "○○○●○○○C◦"
      + "○◦○●●●●○○"
      + "◦○◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_23() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦●●●●◦◦"
      + "◦●●◇◇◇●◦◦"
      + "◦●○B◇◇●○◦"
      + "◦●○○A●○○◦"
      + "◦◦CDE◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_24() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○◦◦○◦"
      + "◦◦◦◦○●●○◦"
      + "◦◦○◦A◇◇●◦"
      + "◦◦◦EDB◇●◦"
      + "◦○◦C○○●◦◦"
      + "◦◦○○●●◦●◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_25() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦●●●◦◦◦"
      + "◦◦●◇◇◇●◦◦"
      + "◦◦●◇B◇A◦◦"
      + "◦◦●●○●●◦◦"
      + "◦◦◦○C○◦◦◦"
      + "◦◦◦◦○◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_26() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦○○●●◦◦◦◦"
      + "◦○●◇◇●●◦◦"
      + "◦○●◇B○●◦◦"
      + "◦○●A○D○●◦"
      + "◦◦◦◦C◦E◦◦";
    testing(boardInput);
  }

  @Test public void test_27() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "●●●○○○○◦◦"
      + "●◇◇●●●●○◦"
      + "●◇◦○○●◦○◦"
      + "●◇◦◦◦◦◦◦◦";
    testing(boardInput,
        2, 0,
        2, 1,
        4, 0,
        3, 0,
        2, 0);
  }

  @Test public void test_28() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦●●●◦◦◦"
      + "◦●●◇◇◇●●◦"
      + "◦○●◇◦●○●◦"
      + "◦○○◦◦○○●◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput,
        3, 1,
        4, 2,
        4, 1,
        5, 2,
        6, 0,
        5, 0,
        4, 0);
  }

  @Test public void test_28a() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦●●●●◦◦"
      + "◦◦●◇◇◇●◦◦"
      + "◦○●◇◦◦○●◦"
      + "◦○○●◦○○●◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput,
        5, 2,
        4, 2,
        4, 1,
        5, 2,
        6, 0,
        5, 0,
        4, 0);
  }

  @Test public void test_29() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦●◦◦●◦"
      + "◦◦○○○●●◦◦"
      + "◦○◦●●○○●◦"
      + "◦○●●◇◦○○●"
      + "◦◦◦●◇◦◦◦◦";
    testing(boardInput,
        5, 0,
        5, 1,
        7, 0,
        6, 0,
        5, 0);
  }

  @Test public void test_30() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○○◦"
      + "◦◦◦◦◦○◦●◦"
      + "◦◦◦◦○●●◦◦"
      + "◦◦◦○◦○●●●"
      + "◦◦◦◦◦○●◇◦"
      + "◦◦◦◦◦◦○◦◦";
    testing(boardInput,
        7, 0,
        8, 0,
        8, 1,
        7, 0,
        5, 0);
  }

  @Test public void test_31() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦"
      + "◦◦◦◦○◦○◦◦"
      + "◦◦◦◦◦●●○◦"
      + "◦◦●○○○●●○"
      + "◦◦◦●●●◇◇◦"
      + "◦◦◦◦◦●●◦◦";
    testing(boardInput,
        8, 1,
        8, 0,
        7, 0,
        8, 1,
        8, 3);
  }

  @Test public void test_32() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○○◦"
      + "◦◦◦◦◦○◦●◦"
      + "◦◦◦◦◦○●◦◦"
      + "◦◦◦◦○●●●◦"
      + "◦◦◦◦○●◇◇◇"
      + "◦◦◦◦◦○◦◦◇";
    testing(boardInput,
        6, 0,
        7, 0,
        8, 2,
        6, 0,
        4, 0);
  }

  @Test public void test_34() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●◦◦◦◦"
      + "◦○●◇●○○○◦"
      + "◦○●◇◇●●◦◦"
      + "◦◦○◦◦○◦◦◦";
    testing(boardInput,
        3, 0,
        4, 0,
        6, 0,
        3, 0,
        1, 0);
  }

  @Test public void test_35() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○○◦◦"
      + "◦●◇◇◇●◦◦◦"
      + "◦●◇◦◦●◦○◦"
      + "◦●●○◦●○◦◦"
      + "◦●○◦○○◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput,
        3, 3,
        4, 3,
        4, 2,
        3, 3,
        3, 1);
  }

  @Test public void test_36() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○○○○◦"
      + "◦◦◦●○●●●◦"
      + "◦◦●◦●◇●◦◦"
      + "◦◦◦◦●◇●○◦"
      + "◦◦◦◦◦◇◇◦◦";
    testing(boardInput,
        7, 0,
        8, 0,
        4, 0,
        7, 0,
        7, 2,
        8, 1,
        8, 2);
  }

  @Test public void test_37() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○○◦"
      + "◦◦◦●◦◦◦◦◦"
      + "◦◦●◦●●●○◦"
      + "◦◦●◇◇◇◇◦◦";
    testing(boardInput,
        7, 0,
        8, 8,
        3, 1,
        7, 0,
        7, 2,
        8, 1,
        8, 2);
  }

  @Test public void test_38() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○◦◦◦"
      + "◦◦○○◦◦○◦◦"
      + "◦◦○xxx○◦◦"
      + "◦●●◇●○●●◦"
      + "◦◦●◇●○○○◦"
      + "◦◦◦◇◇◦◦◦◦";
    testing(boardInput,
        5, 0,
        6, 0,
        2, 0,
        5, 0,
        8, 1,
        7, 0,
        8, 0);
  }

  @Test public void test_39() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦●●○○○◦"
      + "◦◦◦◦◇●●◦◦"
      + "◦◦●◦◦○●◦◦"
      + "◦◦◦●○◦○○◦"
      + "◦◦◦●●○◦◦◦"
      + "◦◦◦◦◦●○◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput,
        4, 4,
        3, 4,
        3, 5,
        2, 5,
        3, 4,
        5, 3);
  }

  @Test public void test_40() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦●●◦◦◦◦"
      + "◦◦●◇◇●●◦◦"
      + "◦◦●◇◦○●◦◦"
      + "◦◦●◇◦○●◦◦"
      + "◦◦●●○◦●◦◦"
      + "◦◦○○◦○○◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput,
        4, 3,
        4, 4,
        5, 2,
        4, 3,
        4, 1);
  }

  @Test public void test_41() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦●●◦◦◦◦"
      + "◦◦●◇◇◦●◦◦"
      + "◦◦●◇◦○●◦◦"
      + "◦◦●◇◦○●◦◦"
      + "◦◦●●○●●◦◦"
      + "◦◦○○◦○○◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput,
        4, 3,
        4, 1,
        5, 5,
        4, 3,
        4, 1);
  }

  @Test public void test_42() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦●●◦◦◦"
      + "◦◦◦◦◦◇●◦◦"
      + "◦◦◦●◦◇●◦◦"
      + "◦●●○◦◇●◦◦"
      + "◦○○◦○●○○◦"
      + "◦◦◦○●●●○◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput,
        4, 3,
        4, 4,
        4, 5,
        4, 4,
        3, 2);
  }

  @Test public void test_43() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "○○○○●●◦◦◦"
      + "◦◦◦●◇◦◦◦◦"
      + "○●●●◇◇●◦◦"
      + "◦○○●◇●●●◦"
      + "◦◦◦○◦○●◦◦"
      + "◦◦◦◦◦○○●◦";
    testing(boardInput,
        4, 1,
        4, 0,
        5, 4,
        4, 1,
        2, 1,
        3, 0,
        2, 0);
  }

  @Test public void test_44() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦○◦◦●◦◦◦"
      + "◦◦◦●●◦◦◦◦"
      + "○○○●○●●◦◦"
      + "◦◦●◇◇●○◦◦"
      + "○○●◦◇●○◦◦"
      + "◦◦●◦◦○◦◦◦";
    testing(boardInput,
        4, 0,
        3, 0,
        3, 1,
        4, 0,
        5, 0);
  }

  @Test public void test_45() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦●●●○◦◦"
      + "◦●●◇◇◇●○◦"
      + "●●○◦◦●●○◦"
      + "●○◦○◦●○○◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput,
        3, 2,
        4, 2,
        4, 1,
        3, 2,
        3, 0,
        2, 1,
        1, 0);
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
      + "A◇◦◦◦◦◦◦◦";
    testing(boardInput);
  }
}
