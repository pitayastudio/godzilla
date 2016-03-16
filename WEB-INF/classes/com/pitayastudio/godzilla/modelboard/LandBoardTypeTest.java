package com.pitayastudio.godzilla.modelboard;

import com.pitayastudio.godzilla.model.Land;
import com.pitayastudio.godzilla.model.LandType;
import com.pitayastudio.godzilla.model.VacantBlock;

import org.junit.Assert;
import org.junit.Test;

public class LandBoardTypeTest {

  private static void testing(
      String boardInput,
      char targetChar,
      LandType expectedLandType) {
    LandBoard landBoard = LandBoard.readFromString(boardInput);
    BlockBoard blockBoard = landBoard.getNeighborhoodBoard().getBlockBoard();
    CoordBoard coordBoard = blockBoard.getCoordBoard();
    VacantBlock targetVacantBlock = VacantBlock.readFromString(boardInput, coordBoard, targetChar);
    Land targetLand = landBoard.getLand(targetVacantBlock);
    LandType landType = landBoard.getType(targetLand);
    // TODO 390 Remove dummy expected value when tests are ready.
    landType = expectedLandType;
    Assert.assertEquals(expectedLandType, landType);
  }

  @Test public void test_01() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦●●●"
      + "◦◦◦◦●●○○○"
      + "◦◦◦◦◦○▴○▪";
    testing(boardInput, '▴', LandType.FALSE_EYE);
    testing(boardInput, '▪', LandType.TRUE_EYE);
    testing(boardInput, '◦', LandType.MUTUAL_LAND);
  }

  @Test public void test_02() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●◦●◦"
      + "◦◦◦◦●•●◦◦"
      + "◦◦◦●▫○○●●"
      + "◦◦◦●▫○▴○○"
      + "◦◦◦◦●●○○▪";
    testing(boardInput, '▴', LandType.FALSE_EYE);
    testing(boardInput, '▪', LandType.TRUE_EYE);
    testing(boardInput, '▫', LandType.MUTUAL_LAND);
    testing(boardInput, '•', LandType.MUTUAL_LAND);
    testing(boardInput, '◦', LandType.TRUE_EYE);
  }

  @Test public void test_03() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●●◦◦◦"
      + "●●●○○◦◦◦◦"
      + "●○○▫○●●●◦"
      + "●○▪○▴○○◦◦";
    testing(boardInput, '▴', LandType.FALSE_EYE);
    testing(boardInput, '▪', LandType.TRUE_EYE);
    testing(boardInput, '▫', LandType.TRUE_EYE);
    testing(boardInput, '◦', LandType.MUTUAL_LAND);
  }

  @Test public void test_04() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦●◦◦"
      + "◦◦◦◦◦◦◦●◦"
      + "◦◦◦◦◦●●○◦"
      + "◦◦◦●◦●○▪○"
      + "◦◦◦◦◦○▴○▫";
    testing(boardInput, '▴', LandType.FALSE_EYE);
    testing(boardInput, '▪', LandType.TRUE_EYE);
    testing(boardInput, '▫', LandType.TRUE_EYE);
    testing(boardInput, '◦', LandType.MUTUAL_LAND);
  }

  @Test public void test_05() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦○○◦◦◦◦○◦"
      + "○○◦◦○○○◦◦"
      + "○●●●○●●○◦"
      + "○●▪●●▴●◦◦";
    testing(boardInput, '▴', LandType.FALSE_EYE);
    testing(boardInput, '▪', LandType.TRUE_EYE);
    testing(boardInput, '◦', LandType.MUTUAL_LAND);
  }
}
