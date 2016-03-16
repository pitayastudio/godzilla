package com.pitayastudio.godzilla.moveanalyzer.connectionanalyzer;

import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.PositionStateChars;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.model.Gang;
import com.pitayastudio.godzilla.modelboard.BlockBoard;
import com.pitayastudio.godzilla.modelboard.CoordBoard;
import com.pitayastudio.godzilla.modelboard.GangBoard;
import com.pitayastudio.godzilla.modelboard.LandBoard;
import com.pitayastudio.godzilla.modelboard.LotBoard;
import com.pitayastudio.godzilla.modelboard.LotWithPropertyBoard;
import com.pitayastudio.godzilla.modelboard.NeighborhoodBoard;
import com.pitayastudio.godzilla.moveanalyzer.TestUtils;

public class TwoGangsConnectionAnalyzerTest {

  static void testing(String boardInput, boolean hasConnecting, boolean hasCutting) {
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

    if (hasConnecting) {
      Gang gang1ToConnect = Gang.readFromString(boardInput, gangBoard, Color.B,
          PositionStateChars.BLACK, PositionStateChars.VACANT_EMPHASIZED_BLACK_CIRCLE);
      Gang gang2ToConnect = Gang.readFromString(boardInput, gangBoard, Color.B,
          PositionStateChars.BLACK_EMPHASIZED, PositionStateChars.VACANT_EMPHASIZED_BLACK_TRIANGLE);
      TwoGangsConnectionAnalyzer connectingAnalyzer = TwoGangsConnectionAnalyzer.newBuilder()
          .setSemiRequiredGangBoard(gangBoard)
          .setSemiRequiredCurrentMoveColor(Color.W)
          .setRequiredTargetGang1(gang1ToConnect)
          .setRequiredTargetGang2(gang2ToConnect)
          .build();
      ImmutableList<Coord> bestMoveCoordsForConnecting = connectingAnalyzer.getBestMoveCoords();
      assertTrue(bestMoveCoordsForConnecting.contains(expectedMoveCoord));
    }

    if (hasCutting) {
      Gang gang1ToCut = Gang.readFromString(boardInput, gangBoard, Color.W,
          PositionStateChars.WHITE, PositionStateChars.VACANT_EMPHASIZED_BLACK_SQUARE);
      Gang gang2ToCut = Gang.readFromString(boardInput, gangBoard, Color.W,
          PositionStateChars.WHITE_EMPHASIZED, PositionStateChars.VACANT_EMPHASIZED_WHITE_SQUARE);
      TwoGangsConnectionAnalyzer cuttingAnalyzer = TwoGangsConnectionAnalyzer.newBuilder()
          .setSemiRequiredGangBoard(gangBoard)
          .setSemiRequiredCurrentMoveColor(Color.W)
          .setRequiredTargetGang1(gang1ToCut)
          .setRequiredTargetGang2(gang2ToCut)
          .build();
      ImmutableList<Coord> bestMoveCoordsForCutting = cuttingAnalyzer.getBestMoveCoords();
      assertTrue(bestMoveCoordsForCutting.contains(expectedMoveCoord));
    }
  }
}
