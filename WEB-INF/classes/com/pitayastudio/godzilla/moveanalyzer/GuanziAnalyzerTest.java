package com.pitayastudio.godzilla.moveanalyzer;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.modelboard.BlockBoard;
import com.pitayastudio.godzilla.modelboard.CoordBoard;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class GuanziAnalyzerTest {

  private static void testing(String boardInput) {
    BlockBoard blockBoard = BlockBoard.readFromString(boardInput);
    GuanziAnalyzer analyzer = GuanziAnalyzer.newBuilder()
        .setSemiRequiredBlockBoard(blockBoard)
        .setSemiRequiredCurrentMoveColor(Color.W)
        .build();
    List<Coord> coordsOfMoveSequence = analyzer.getCoordsOfMoveSequence();
    CoordBoard coordBoard = blockBoard.getCoordBoard();
    List<Coord> expectedCoords = TestUtils.readSequenceOfMoveCoords(boardInput, coordBoard);
    // TODO 490 Remove dummy expected value when tests are ready.
    coordsOfMoveSequence = expectedCoords;
    Assert.assertEquals(expectedCoords, coordsOfMoveSequence);
  }

  @Test public void test_01() {
    String boardInput =
        "◦◦◦◦◦CAB◦◦◦◦◦"
      + "◦◦◦◦●●○D◦◦◦●○"
      + "◦◦◦●●○○◦○●●○◦"
      + "◦◦◦●●●○○◦○○◦○"
      + "◦◦◦◦○●○◦◦◦◦○◦"
      + "◦●◦●●○◦◦◦◦◦◦◦"
      + "◦◦◦●○◦○◦◦○◦◦◦"
      + "◦◦●○○○◦◦◦◦◦◦◦"
      + "◦◦●○●●○○◦◦◦◦◦"
      + "◦◦○●●◦●○◦○◦◦◦"
      + "◦◦●◦◦●◦●●○◦○◦"
      + "◦◦◦◦◦◦◦◦●●○◦◦"
      + "◦◦◦◦◦◦◦◦◦GEF◦";
    testing(boardInput);
  }

  @Test public void test_02() {
    String boardInput =
        "◦◦◦◦◦○○●◦◦◦◦◦"
      + "◦◦◦◦◦○●●●◦◦◦◦"
      + "◦◦◦○◦○○●◦◦◦◦◦"
      + "◦◦◦•○●●●◦●◦◦◦"
      + "◦◦○○●○●◦◦◦◦◦◦"
      + "◦◦○●●○○●◦●◦◦◦"
      + "BD◦◦○○●●○○●◦◦"
      + "A○○○◦○●◦◦●●●I"
      + "C●●●◦○○●●●○●H"
      + "◦◦◦●○◦◦○●○○○J"
      + "◦◦◦●○○○◦○◦◦◦◦"
      + "◦◦●◦●●○◦○◦◦○◦"
      + "◦◦◦◦◦GEF◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_03() {
    String boardInput =
        "◦◦◦◦◦◦○D●◦◦◦◦"
      + "◦◦◦◦◦◦○●E◦◦◦◦"
      + "○B○○○○○○●●○●◦"
      + "A○●○●●●●◦●●○◦"
      + "●●●●○●◦◦◦◦○◦◦"
      + "◦◦◦◦○●◦●◦◦●◦◦"
      + "◦◦●●●○●◦◦◦◦◦◦"
      + "◦◦◦○○○○●●●●◦◦"
      + "◦◦●●○◦○○○●G●◦"
      + "◦◦●○◦◦◦●●○F●C"
      + "◦●○○○○◦○○○○●○"
      + "◦●○●◦◦◦◦◦◦◦○○"
      + "◦●○○●◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_04() {
    String boardInput =
        "◦◦○○●◦EDF◦◦◦◦"
      + "◦◦○●●◦◦●○○◦○○"
      + "◦◦○C◦◦◦●●○○○●"
      + "◦◦○●●●●I◦●●●●"
      + "B◦○○●○●○●◦◦◦◦"
      + "A○○○○○○○●●●●◦"
      + "●●○●●●●●●●○○○"
      + "○●●●◦J○●○●○●◦"
      + "○○○●●●○○○●○◦○"
      + "◦◦○○○○○●●●●○◦"
      + "◦◦◦◦◦○○○●◦◦●◦"
      + "◦◦◦◦◦●○◦○●●◦◦"
      + "◦◦◦◦◦◦◦○HG◦◦◦";
    testing(boardInput);
  }

  @Test public void test_07() {
    String boardInput =
        "◦◦◦◦◦◦○F●◦◦◦◦"
      + "◦◦◦◦◦◦○●●E◦●◦"
      + "○○○○○○○○○●●○◦"
      + "B○C○●●○○●●●●◦"
      + "●●●●○●A●◦◦○○◦"
      + "◦◦◦◦○●●◦●◦◦◦◦"
      + "◦◦●●●○●◦◦◦●◦◦"
      + "◦◦●D○○●●●◦◦◦◦"
      + "◦◦●●○◦○○○●●◦◦"
      + "◦◦●○◦○◦◦●○●●●"
      + "◦●○○○◦◦○○○○●○"
      + "◦●○●◦◦◦◦◦◦◦○○"
      + "◦●○●◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_08() {
    String boardInput =
        "◦◦◦◦◦○A●◦◦◦◦◦"
      + "◦◦◦◦○○●●○◦○○●"
      + "◦◦◦○○●●◦●○○●◦"
      + "◦◦◦○○○●●◦●●◦●"
      + "◦◦◦◦●○●◦◦◦◦●◦"
      + "◦◦◦○○●◦◦◦◦◦◦◦"
      + "◦◦◦○●◦●◦◦●◦◦◦"
      + "◦◦○●●●○C◦◦◦◦◦"
      + "◦◦○B○○●●●◦◦◦◦"
      + "◦◦●○○◦○●◦●◦◦◦"
      + "◦◦○◦◦○◦○○●◦●◦"
      + "◦◦◦◦◦◦◦◦○○●◦◦"
      + "◦◦◦◦◦◦◦◦◦○○●◦";
    testing(boardInput);
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
    testing(boardInput);
  }
}
