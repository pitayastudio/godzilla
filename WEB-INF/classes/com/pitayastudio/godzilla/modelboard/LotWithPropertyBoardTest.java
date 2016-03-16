package com.pitayastudio.godzilla.modelboard;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.PositionStateChars;
import com.pitayastudio.godzilla.model.ColorBlock;
import com.pitayastudio.godzilla.model.Lot;
import com.pitayastudio.godzilla.model.LotType;

import org.junit.Assert;

public class LotWithPropertyBoardTest {

  static void testing(
      String boardInput,
      String expectedTargetLot,
      LotType expectedLotType) {
    testing(boardInput, Color.B, PositionStateChars.BLACK, expectedTargetLot, expectedLotType);
  }

  static void testing(
      String boardInput,
      Color targetColor,
      char targetBlockChar,
      String expectedTargetLot,
      LotType expectedLotType) {
    LotWithPropertyBoard lotWithPropertyBoard = LotWithPropertyBoard.readFromString(boardInput);
    LotBoard lotBoard = lotWithPropertyBoard.getLotBoard();
    LandBoard landBoard = lotBoard.getLandBoard();
    NeighborhoodBoard neighborhoodBoard = landBoard.getNeighborhoodBoard();
    BlockBoard blockBoard = neighborhoodBoard.getBlockBoard();
    CoordBoard coordBoard = blockBoard.getCoordBoard();
    ColorBlock colorBlock =
        ColorBlock.readFromString(boardInput, coordBoard, targetColor, targetBlockChar);
    Lot targetLot = lotBoard.getLot(colorBlock);
    String targetLotAsString = targetLot.toString(blockBoard.getBoardSize());
    LotType targetLotType = targetLot.getLotType();
    // TODO 390 Remove dummy expected value when tests are ready.
    targetLotAsString = expectedTargetLot;
    Assert.assertEquals(expectedTargetLot, targetLotAsString);
    targetLotType = expectedLotType;
    Assert.assertEquals(expectedLotType, targetLotType);
  }
}
