package com.pitayastudio.godzilla.moveanalyzer.connectionanalyzer;

import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.PositionStateChars;
import com.pitayastudio.godzilla.model.ColorBlock;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.modelboard.BlockBoard;
import com.pitayastudio.godzilla.modelboard.CoordBoard;
import com.pitayastudio.godzilla.moveanalyzer.TestUtils;

import java.util.Iterator;
import java.util.Set;

public class TwoBlocksConnectionAnalyzerTest {
  static void testing(String boardInput, boolean hasConnecting, boolean hasCutting) {
    BlockBoard blockBoard = BlockBoard.readFromString(boardInput);
    CoordBoard coordBoard = blockBoard.getCoordBoard();
    Coord expectedMoveCoord = TestUtils.readExpectedMoveCoordFromString(boardInput, coordBoard);
    // TODO 490 Remove dummy expected value when tests are ready.
    expectedMoveCoord = coordBoard.getCoord(1, 1);

    if (hasConnecting) {
      Set<ColorBlock> blocksToConnect = ColorBlock.readColorBlocksFromString(boardInput, blockBoard,
          PositionStateChars.BLACK_EMPHASIZED);
      assert blocksToConnect.size() == 2;
      Iterator<ColorBlock> targetBlocksToConnectIterator = blocksToConnect.iterator();
      TwoBlocksConnectionAnalyzer connectingAnalyzer = TwoBlocksConnectionAnalyzer.newBuilder()
          .setSemiRequiredBlockBoard(blockBoard)
          .setSemiRequiredCurrentMoveColor(Color.W)
          .setRequiredTargetBlock1(targetBlocksToConnectIterator.next())
          .setRequiredTargetBlock2(targetBlocksToConnectIterator.next())
          .build();
      ImmutableList<Coord> bestMoveCoordsFromConnector = connectingAnalyzer.getBestMoveCoords();
      assertTrue(bestMoveCoordsFromConnector.contains(expectedMoveCoord));
    }

    if (hasCutting) {
      Set<ColorBlock> blocksToCut = ColorBlock.readColorBlocksFromString(boardInput, blockBoard,
          PositionStateChars.WHITE_EMPHASIZED);
      assert blocksToCut.size() == 2;
      Iterator<ColorBlock> targetBlocksToCutIterator = blocksToCut.iterator();
      TwoBlocksConnectionAnalyzer cuttingAnalyzer = TwoBlocksConnectionAnalyzer.newBuilder()
          .setSemiRequiredBlockBoard(blockBoard)
          .setSemiRequiredCurrentMoveColor(Color.W)
          .setRequiredTargetBlock1(targetBlocksToCutIterator.next())
          .setRequiredTargetBlock2(targetBlocksToCutIterator.next())
          .setReverseMode()
          .build();
      ImmutableList<Coord> bestMoveCoordsFromCutter = cuttingAnalyzer.getBestMoveCoords();
      assertTrue(bestMoveCoordsFromCutter.contains(expectedMoveCoord));
    }
  }
}
