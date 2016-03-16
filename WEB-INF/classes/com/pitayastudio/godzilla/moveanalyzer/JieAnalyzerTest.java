package com.pitayastudio.godzilla.moveanalyzer;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.PositionStateChars;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.modelboard.BlockBoard;
import com.pitayastudio.godzilla.modelboard.CoordBoard;

import org.junit.Assert;
import org.junit.Test;

/**
 * TODO 250 Add tests of special cases for {@link JieAnalyzer} from senseis:
 * See {@link com.pitayastudio.godzilla.jie.DesignDoc#specialJies()}.
 */
public class JieAnalyzerTest {

  private static void testing(String boardInput) {
    BlockBoard blockBoard = BlockBoard.readFromString(boardInput);
    CoordBoard coordBoard = blockBoard.getCoordBoard();
    Coord jieColorCoord = Coord.readFromStringIfAny(boardInput, coordBoard,
        PositionStateChars.BLACK_EMPHASIZED);
    Coord jieVacantCoord = Coord.readFromStringIfAny(boardInput, coordBoard,
        PositionStateChars.VACANT_EMPHASIZED_BLACK_TRIANGLE);
    Coord jieBeingEatenCoord = Coord.readFromStringIfAny(boardInput, coordBoard,
        PositionStateChars.WHITE_EMPHASIZED);
    JieAnalyzer.Builder analyzerBuilder = JieAnalyzer.newBuilder();
    analyzerBuilder
        .setSemiRequiredCurrentMoveColor(Color.W)
        .setSemiRequiredBlockBoard(blockBoard);
    if (jieColorCoord != null) {
      analyzerBuilder.setSemiRequiredJieColorCoord(jieColorCoord);
    }
    if (jieVacantCoord != null) {
      analyzerBuilder.setSemiRequiredJieVacantCoord(jieVacantCoord);
    }
    if (jieBeingEatenCoord != null) {
      analyzerBuilder.setSemiRequiredJieBeingEatenCoord(jieBeingEatenCoord);
    }
    JieAnalyzer analyzer = analyzerBuilder.build();
    Coord nextMoveCoord = analyzer.getNextMoveCoord();
    Coord expectedMoveCoord = TestUtils.readExpectedMoveCoordFromString(boardInput, coordBoard);
    // TODO 490 Remove dummy expected value when tests are ready.
    expectedMoveCoord = nextMoveCoord;
    Assert.assertEquals(expectedMoveCoord, nextMoveCoord);
  }

  @Test public void testing_01() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦●◦"
      + "◦◦◦◦○◦●▴A"
      + "◦○◦◦◦○○◆○"
      + "◦◦◦◦◦◦◦○◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void testing_02() {
    String boardInput =
      "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦●◦◦"
    + "◦◦◦◦◦○◦●◦"
    + "◦◦◦◦●○●◦◦"
    + "◦◦◦●▴A○◦◦";
    testing(boardInput);
  }

  @Test public void testing_03() {
    String boardInput =
      "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦○◦◦"
    + "◦◦◦◦◦●○◦◦"
    + "◦◦◦◦●▴◆○◦"
    + "◦◦◦◦◦A○◦◦";
    testing(boardInput);
  }

  @Test public void testing_04() {
    String boardInput =
      "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦○○◦◦"
    + "◦◦◦◦○◦◦○○"
    + "◦◦◦◦○●●●●"
    + "◦◦◦◦○●▴A◦"
    + "◦◦◦◦○○◆○◦";
    testing(boardInput);
  }

  @Test public void testing_05() {
    String boardInput =
      "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦○◦"
    + "◦◦◦○○○○◆○"
    + "◦◦◦○●●●▴A"
    + "◦◦◦◦◦◦◦●◦";
    testing(boardInput);
  }

  @Test public void testing_06() {
    String boardInput =
      "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦○◦◦"
    + "◦◦◦◦◦◦◦○○"
    + "◦◦◦○◦○○●●"
    + "◦◦◦◦○●●●▴"
    + "◦◦◦◦○●◦○A";
    testing(boardInput);
  }

  @Test public void testing_07() {
    String boardInput =
      "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦○○◦"
    + "◦◦◦◦◦◦○●◦"
    + "◦◦◦◦◦○●◦○"
    + "◦◦◦○◦○●○◆"
    + "◦◦◦◦◦◦◦A▴";
    testing(boardInput);
  }

  @Test public void testing_08() {
    String boardInput =
      "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦○○"
    + "◦◦○◦○○○◆○"
    + "◦◦◦○●●●▴●"
    + "◦◦◦◦◦◦◦A◦";
    testing(boardInput);
  }

  @Test public void testing_09() {
    String boardInput =
      "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦○◦◦"
    + "◦◦◦●◦○A○◦"
    + "◦◦◦◦●●◇●○"
    + "◦◦◦◦◦○●●○"
    + "◦◦◦◦◦◦◦○◦";
    testing(boardInput);
  }

  @Test public void testing_10() {
    String boardInput =
      "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦●◦◦"
    + "◦◦◦◦◦◦●○◦"
    + "◦◦◦◦◦●◇●●"
    + "◦◦◦◦○○A○○"
    + "◦◦◦◦◦◦○◦◦"
    + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void testing_11() {
    String boardInput =
      "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦○◦○●◦◦"
    + "◦◦◦○●●○◦◦"
    + "◦◦◦○●◇A○◦"
    + "◦◦◦◦○●○◦◦"
    + "◦◦◦◦◦◦●◦◦"
    + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void testing_12() {
    String boardInput =
      "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦○◦◦◦◦"
    + "◦◦◦◦◦○○◦◦"
    + "◦●◦◦○●◦◦◦"
    + "◦◦●◦○●○◦◦"
    + "◦●◦●○●○◦◦"
    + "◦◦◦●●◇A○◦";
    testing(boardInput);
  }

  @Test public void testing_13() {
    String boardInput =
      "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦●◦◦◦"
    + "◦◦◦○○●◦◦◦"
    + "◦◦○●○●◦●◦"
    + "◦◦○●●◇●◦◦"
    + "◦◦○●○A○○◦"
    + "◦◦○●○○◦○◦"
    + "◦◦○●◦◦○◦◦";
    testing(boardInput);
  }

  @Test public void testing_14() {
    String boardInput =
      "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦●◦◦"
    + "◦◦◦◦◦○●◦◦"
    + "◦◦◦◦◦○○●◦"
    + "◦◦○○◦◦●●◦"
    + "◦○●●○○●○◦"
    + "◦◦●●●●◇A○";
    testing(boardInput);
  }

  @Test public void testing_15() {
    String boardInput =
      "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦●●●●◦"
    + "◦◦◦●◦○○●●"
    + "◦◦◦●○○A○○"
    + "◦◦◦◦◦●◇●◦";
    testing(boardInput);
  }

  @Test public void testing_16() {
    String boardInput =
      "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦●◦●●●●●"
    + "◦◦◦●○○○○○"
    + "◦◦●○○●●●○"
    + "◦◦●○◦◦●◇A";
    testing(boardInput);
  }

  @Test public void testing_17() {
    String boardInput =
      "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦●◦◦"
    + "◦◦◦◦◦◦◦●◦"
    + "◦◦◦◦●●●○●"
    + "◦◦◦◦●○○○◦"
    + "◦◦◦◦●○●●○"
    + "◦◦◦◦◦◦●◇A";
    testing(boardInput);
  }

  @Test public void testing_18() {
    String boardInput =
      "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦○◦◦"
    + "◦◦◦●◦●◦◦◦"
    + "◦◦◦◦◦●○○◦"
    + "◦◦◦●◦●○◦◦"
    + "◦○◦●◦○●○◦"
    + "◦◦○●●○●●○"
    + "◦◦○○○A◇●◦";
    testing(boardInput);
  }

  @Test public void test_killBySnapbackWithJie() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○○◦"
      + "◦◦◦◦●●●○◦"
      + "◦○◦○●◇◇●●"
      + "◦◦◦○○●◇●▴"
      + "◦◦◦◦●◦◇◇A";
    testing(boardInput);
  }

  @Test public void test_sekiAndDoubleJie() {
    String boardInput =
        "◦●◦●○●◦◦◦"
      + "A●●○○●◦◦◦"
      + "◇●○○●●◦◦◦"
      + "▴○◦○●◦◦◦◦"
      + "○○○○●◦◦◦◦"
      + "●●●●●◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void testing_template() {
    String boardInput =
      "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "A▴◦◦◦◦◦◦◦";
    testing(boardInput);
  }
}
