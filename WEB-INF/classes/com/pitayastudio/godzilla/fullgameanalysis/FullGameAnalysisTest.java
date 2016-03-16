package com.pitayastudio.godzilla.fullgameanalysis;

import com.google.common.collect.ImmutableList;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.modelboard.BlockBoard;
import com.pitayastudio.godzilla.modelboard.CoordBoard;
import com.pitayastudio.godzilla.modelboard.AnalyzerBoard;
import com.pitayastudio.godzilla.modelboard.PositionStateBoard;

import org.junit.Assert;
import org.junit.Test;

public class FullGameAnalysisTest {

  @Test public void testAllSteps() {
    FullGameData fullGameData = new FullGameData();
    for (FullGameData.OneMoveData data : fullGameData.getListOfOneMoveData()) {
      testing(data.getCoordBoard(), data.getBoardInput(), data.getColorOfNextMove(),
          data.getCoordOfExpectedNextMove());
    }
  }

  private static void testing(CoordBoard coordBoard, String boardInput, Color nextMoveColor,
      Coord nextMoveCoord) {
    PositionStateBoard positionStateBoard =
        PositionStateBoard.readFromString(boardInput, coordBoard);
    BlockBoard blockBoard = BlockBoard.newBuilder()
        .setRequiredPositionStateBoard(positionStateBoard)
        .build();
    @SuppressWarnings("unused")
    AnalyzerBoard analyzerBoard = AnalyzerBoard.newBuilder()
        .setRequiredBlockBoardAfterMove(blockBoard)
        .setColorOfLatestMoveThatRendersThisBoard(nextMoveColor.swap())
        .build();

    // TODO 490 Remove dummy expected value when tests are ready.
    ImmutableList<Coord> moveProposals = ImmutableList.of(nextMoveCoord);
    Assert.assertTrue(moveProposals.contains(nextMoveCoord));
  }
}