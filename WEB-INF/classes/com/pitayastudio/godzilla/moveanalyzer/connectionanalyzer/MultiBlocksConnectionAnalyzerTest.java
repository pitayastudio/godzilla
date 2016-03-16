package com.pitayastudio.godzilla.moveanalyzer.connectionanalyzer;

import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.PositionStateChars;
import com.pitayastudio.godzilla.model.ColorBlock;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.modelboard.BlockBoard;
import com.pitayastudio.godzilla.modelboard.CoordBoard;
import com.pitayastudio.godzilla.moveanalyzer.TestUtils;

import java.util.Set;

public class MultiBlocksConnectionAnalyzerTest {
  static void testing(String boardInput, boolean hasConnecting, boolean hasCutting) {
    BlockBoard blockBoard = BlockBoard.readFromString(boardInput);
    CoordBoard coordBoard = blockBoard.getCoordBoard();
    Set<Coord> expectedCoords = TestUtils.readExpectedMoveCoordsFromString(boardInput, coordBoard);
    // TODO 490 Remove dummy expected value when tests are ready.
    expectedCoords = Sets.newHashSet(coordBoard.getCoord(1, 1));

    if (hasConnecting) {
      Set<ColorBlock> targetBlocksToConnect = ColorBlock.readColorBlocksFromString(boardInput, blockBoard,
          PositionStateChars.BLACK_EMPHASIZED);
      MultiBlocksConnectionAnalyzer connectingAnalyzer = MultiBlocksConnectionAnalyzer.newBuilder()
          .setSemiRequiredBlockBoard(blockBoard)
          .setSemiRequiredCurrentMoveColor(Color.W)
          .addTargetBlocks(targetBlocksToConnect)
          .build();
      ImmutableList<Coord> bestMoveCoordsForConnecting = connectingAnalyzer.getBestMoveCoords();
      assertTrue(bestMoveCoordsForConnecting.containsAll(expectedCoords));
    }

    if (hasCutting) {
      Set<ColorBlock> targetBlocksToCut = ColorBlock.readColorBlocksFromString(boardInput, blockBoard,
          PositionStateChars.WHITE_EMPHASIZED);
      MultiBlocksConnectionAnalyzer cuttingAnalyzer = MultiBlocksConnectionAnalyzer.newBuilder()
          .setSemiRequiredBlockBoard(blockBoard)
          .setSemiRequiredCurrentMoveColor(Color.W)
          .addTargetBlocks(targetBlocksToCut)
          .setReverseMode()
          .build();
      ImmutableList<Coord> bestMoveCoordsForCutting = cuttingAnalyzer.getBestMoveCoords();
      assertTrue(bestMoveCoordsForCutting.containsAll(expectedCoords));
    }
  }
}
