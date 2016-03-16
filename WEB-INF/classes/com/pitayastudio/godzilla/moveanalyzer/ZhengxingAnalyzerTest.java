package com.pitayastudio.godzilla.moveanalyzer;

import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.PositionStateChars;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.model.Dragon;
import com.pitayastudio.godzilla.modelboard.BlockBoard;
import com.pitayastudio.godzilla.modelboard.CoordBoard;
import com.pitayastudio.godzilla.modelboard.GangBoard;
import com.pitayastudio.godzilla.modelboard.LandBoard;
import com.pitayastudio.godzilla.modelboard.LotBoard;
import com.pitayastudio.godzilla.modelboard.LotWithPropertyBoard;
import com.pitayastudio.godzilla.modelboard.NeighborhoodBoard;

import org.junit.Test;

public class ZhengxingAnalyzerTest {

  private static void testing(String boardInput) {
    GangBoard gangBoard = GangBoard.readFromString(boardInput);
    LotWithPropertyBoard lotWithPropertyBoard = gangBoard.getLotWithPropertyBoard();
    LotBoard lotBoard = lotWithPropertyBoard.getLotBoard();
    LandBoard landBoard = lotBoard.getLandBoard();
    NeighborhoodBoard neighborhoodBoard = landBoard.getNeighborhoodBoard();
    BlockBoard blockBoard = neighborhoodBoard.getBlockBoard();
    CoordBoard coordBoard = blockBoard.getCoordBoard();
    Coord expectedMoveCoord = TestUtils.readExpectedMoveCoordFromString(boardInput, coordBoard);
    // TODO 490 Remove dummy expected value when tests are ready.
    expectedMoveCoord = coordBoard.getCoord(1, 1);

    Dragon targetDragon = Dragon.readDragonFromString(boardInput, gangBoard, Color.B,
        PositionStateChars.BLACK, PositionStateChars.VACANT_EMPHASIZED_BLACK_TRIANGLE);
    ZhengxingAnalyzer analyzer = ZhengxingAnalyzer.newBuilder()
        .setSemiRequiredBlockBoard(blockBoard)
        .setSemiRequiredCurrentMoveColor(Color.W)
        .setRequiredTargetDragon(targetDragon)
        .build();
    ImmutableList<Coord> bestMoveCoords = analyzer.getBestMoveCoords();
    assertTrue(bestMoveCoords.contains(expectedMoveCoord));
  }

  @Test public void test_zhengxing_08() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦"
      + "◦◦◦◦●●○◦◦"
      + "◦◦◦◦◦◦●○◦"
      + "◦◦◦◦A◦●○◦"
      + "◦◦◦◦◦●○○◦"
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
      + "●A●◦◦◦◦◦◦";
    testing(boardInput);
  }
}
