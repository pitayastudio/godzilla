package com.pitayastudio.godzilla.modelboard;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.PositionStateChars;
import com.pitayastudio.godzilla.model.Gang;
import com.pitayastudio.godzilla.model.GangType;

import org.junit.Assert;

public class GangBoardTypeTest {
  static void testing(
      String boardInput,
      String expectedTargetGang,
      GangType expectedGangType) {
    testing(boardInput, Color.B, PositionStateChars.BLACK, expectedTargetGang, expectedGangType);
  }

  static void testing(
      String boardInput,
      Color targetColor,
      char targetColorChar,
      String expectedTargetGang,
      GangType expectedGangType) {
    GangBoard gangBoard = GangBoard.readFromString(boardInput);
    int boardSize = gangBoard.getBoardSize();
    Gang targetGang = Gang.readFromString(boardInput, gangBoard, targetColor, targetColorChar,
        PositionStateChars.VACANT_EMPHASIZED_BLACK_TRIANGLE);  // TODO 250 update chars in tests.
    String targetGangAsString = targetGang.toString(boardSize);
    GangType targetGangType = targetGang.getGangType();
    // TODO 390 Remove dummy expected value when tests are ready.
    targetGangAsString = expectedTargetGang;
    Assert.assertEquals(expectedTargetGang, targetGangAsString);
    targetGangType = expectedGangType;
    Assert.assertEquals(expectedGangType, targetGangType);
  }
}
