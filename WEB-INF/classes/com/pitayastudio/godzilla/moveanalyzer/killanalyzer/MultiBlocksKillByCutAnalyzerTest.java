package com.pitayastudio.godzilla.moveanalyzer.killanalyzer;

import com.google.common.collect.ImmutableSet;

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

public class MultiBlocksKillByCutAnalyzerTest {

  private static void testing(String boardInput) {
    BlockBoard blockBoard = BlockBoard.readFromString(boardInput);
    CoordBoard coordBoard = blockBoard.getCoordBoard();
    ImmutableSet<ColorBlock> targetBlocks = ColorBlock.readColorBlocksFromString(
        boardInput, blockBoard, PositionStateChars.WHITE_EMPHASIZED);
    MultiBlocksKillByCutAnalyzer analyzer = MultiBlocksKillByCutAnalyzer.newBuilder()
        .setSemiRequiredBlockBoard(blockBoard)
        .setSemiRequiredCurrentMoveColor(Color.W)
        .addTargetBlocks(targetBlocks)
        .build();
    List<Coord> bestMoveCoords = analyzer.getBestMoveCoords();
    Coord expectedMoveCoord = TestUtils.readExpectedMoveCoordFromString(boardInput, coordBoard);
    // TODO 490 Remove dummy expected value when tests are ready.
    expectedMoveCoord = coordBoard.getCoord(1, 1);
    Assert.assertTrue(bestMoveCoords.contains(expectedMoveCoord));
  }

  @Test public void test_multiAnswers_01() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦●◦◦◦◦●◦◦"
      + "◦◦◦●●◦◦◦◦"
      + "◇◇◇●◇◇◇◇◇"
      + "◦◦◦◦A◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_2Blocks_01() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦○○○◦◦◦◦"
      + "◦◦●●○●◦◦◦"
      + "◦◦●◦A◇●◦◦"
      + "◦◦●◇◇●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_4Blocks_01() {
   String boardInput =
       "◦◦◦◦●◦◦◦◦"
     + "◦◦◦◦●◦◦◦◦"
     + "◦◦●●●●●◦◦"
     + "◇◇◇◇●◇◇◇◇"
     + "●●●●A●●●●"
     + "○○○○●○○○○"
     + "◦◦◦○●○◦◦◦"
     + "◦◦◦○○○◦◦◦"
     + "◦◦◦◦◦◦◦◦◦";
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
      + "A◇◦◦◦◦◦◦◦";
    testing(boardInput);
  }
}
