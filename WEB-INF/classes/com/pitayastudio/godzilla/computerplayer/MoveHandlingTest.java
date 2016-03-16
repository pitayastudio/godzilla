package com.pitayastudio.godzilla.computerplayer;

import static com.pitayastudio.godzilla.common.MoveType.MOVE_EAT_CAUSING_JIE;
import static com.pitayastudio.godzilla.common.MoveType.MOVE_EAT_NO_JIE;
import static com.pitayastudio.godzilla.common.MoveType.MOVE_ERROR_JIE_VIOLATION;
import static com.pitayastudio.godzilla.common.MoveType.MOVE_ERROR_PREV_POSIT_IS_ALREADY_OCCUPIED;
import static com.pitayastudio.godzilla.common.MoveType.MOVE_ERROR_SUICIDE;
import static com.pitayastudio.godzilla.common.MoveType.MOVE_REGULAR;
import static com.pitayastudio.godzilla.common.MoveType.MOVE_SELF_FILL_ONE_EYE_FOR_ONE_BUDDY_BLOCK;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableSet;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.MoveType;
import com.pitayastudio.godzilla.common.PositionStateChars;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.modelboard.CoordBoard;
import com.pitayastudio.godzilla.modelboard.PositionStateBoard;
import com.pitayastudio.godzilla.modelboard.VisualBoard;
import com.pitayastudio.godzilla.moveanalyzer.TestUtils;

import junit.framework.TestCase;

import org.junit.Test;

public class MoveHandlingTest extends TestCase {
  private static MoveHandling testing(
      String boardInput,
      MoveType expectedMoveType) {
    return testing(
        boardInput,
        Optional.<Coord>absent(),
        expectedMoveType);
  }

  private static MoveHandling testing(
      String boardInput,
      Optional<Coord> currentJieDeadCoordOptional,
      MoveType expectedMoveType) {
    int boardSize = VisualBoard.getBoardSizeFromBoardInput(boardInput);
    CoordBoard coordBoard = new CoordBoard(boardSize);
    PositionStateBoard positionStateBoard =
        PositionStateBoard.readFromString(boardInput, coordBoard);
    Coord nextMoveCoord = TestUtils.readExpectedMoveCoordFromString(boardInput, coordBoard);
    MoveHandling moveHandling = MoveHandling.newBuilderForRegularMoveHandling()
        .setRequiredPositionStateBoardBeforeMove(positionStateBoard)
        .setRequiredMoveColor(Color.B)
        .setRequiredPrevJieDeadCoordOptional(currentJieDeadCoordOptional)
        .setRequiredMoveCoord(nextMoveCoord)
        .build();
    MoveType moveType = moveHandling.getMoveType();
    assertEquals(expectedMoveType, moveType);
    return moveHandling;
  }

  // Test special case that needs currentJieEatenCoord.
  @Test public void testErrorJieViolation() {
    String boardInput =
        "◦◦◦◦◦"
      + "●●○○◦"
      + "●○A○◦"
      + "●●○○◦"
      + "◦◦◦◦◦";
    int boardSize = VisualBoard.getBoardSizeFromBoardInput(boardInput);
    CoordBoard coordBoard = new CoordBoard(boardSize);
    Coord currentJieEatenCoord = coordBoard.getCoord(3, 3);
    PositionStateBoard positionStateBoard =
        PositionStateBoard.readFromString(boardInput, coordBoard);
    Coord nextMoveCoord = TestUtils.readExpectedMoveCoordFromString(boardInput, coordBoard);
    MoveHandling moveHandling = MoveHandling.newBuilderForRegularMoveHandling()
        .setRequiredPositionStateBoardBeforeMove(positionStateBoard)
        .setRequiredMoveColor(Color.B)
        .setRequiredPrevJieDeadCoordOptional(Optional.of(currentJieEatenCoord))
        .setRequiredMoveCoord(nextMoveCoord)
        .build();
    MoveType moveType = moveHandling.getMoveType();
    assertEquals(MOVE_ERROR_JIE_VIOLATION, moveType);
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////
  // MOVE_SELF_FILL_ONE_EYE_FOR_ONE_BUDDY_BLOCK

  @Test public void testSelfFillOneEyeForOneBuddyBlockMove_01() {
    String boardInput =
        "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "●●◦◦◦"
      + "A●◦◦◦";
    Coord currentJieEatenCoord = null;
    MoveHandling moveHandling = testing(boardInput,
        Optional.fromNullable(currentJieEatenCoord),
        MOVE_SELF_FILL_ONE_EYE_FOR_ONE_BUDDY_BLOCK);

    String nextBoard = moveHandling.getPositionStateBoardAfterMove().toString();
    //System◦out◦println("nextBoard:\n" + nextBoard);
    assertEquals(
        "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "●●◦◦◦"
      + "●●◦◦◦",
      nextBoard.replaceAll("\n", ""));
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////
  // Regular moves

  @Test public void testRegularMove_01() {
    String boardInput =
        "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦A◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦";
    Coord currentJieEatenCoord = null;
    MoveHandling moveHandling = testing(boardInput,
        Optional.fromNullable(currentJieEatenCoord),
        MOVE_REGULAR);

    String nextBoard = moveHandling.getPositionStateBoardAfterMove().toString();
    //System◦out◦println("nextBoard:\n" + nextBoard);
    assertEquals(
        "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦●◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦",
      nextBoard.replaceAll("\n", ""));
  }

  @Test public void testRegularMove_02() {
    String boardInput =
        "◦◦◦●A"
      + "◦◦◦◦●"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦";
    Coord currentJieEatenCoord = null;
    MoveHandling moveHandling = testing(boardInput,
        Optional.fromNullable(currentJieEatenCoord),
        MOVE_REGULAR);

    String nextBoard = moveHandling.getPositionStateBoardAfterMove().toString();
    assertEquals(
        "◦◦◦●●"
      + "◦◦◦◦●"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦",
      nextBoard.replaceAll("\n", ""));
  }

  @Test public void testRegularMove_03() {
    String boardInput =
        "◦◦◦◦◦"
      + "○○●◦◦"
      + "○●A●◦"
      + "○○●○◦"
      + "◦○○○◦";
    testing(boardInput, MOVE_REGULAR);
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////
  // Error moves

  @Test public void testMoveErrorPrevPositIsAlreadyOccupied() {
    String boardInput =
        "◦◦◦◦◦"
      + "●●○○◦"
      + "●○◦○◦"
      + "●●○○◦"
      + "◦◦◦◦◦";
    int boardSize = VisualBoard.getBoardSizeFromBoardInput(boardInput);
    CoordBoard coordBoard = new CoordBoard(boardSize);
    PositionStateBoard positionStateBoard =
        PositionStateBoard.readFromString(boardInput, coordBoard);
    Coord nextMoveCoord = coordBoard.getCoord(1, 2);
    MoveHandling moveHandling = MoveHandling.newBuilderForRegularMoveHandling()
        .setRequiredPositionStateBoardBeforeMove(positionStateBoard)
        .setRequiredMoveColor(Color.B)
        .setRequiredPrevJieDeadCoordOptional(Optional.<Coord>absent())
        .setRequiredMoveCoord(nextMoveCoord)
        .build();
    MoveType moveType = moveHandling.getMoveType();
    assertEquals(MOVE_ERROR_PREV_POSIT_IS_ALREADY_OCCUPIED, moveType);
  }

  @Test public void testErrorSuicide_01() {
    String boardInput =
        "◦◦◦◦◦"
      + "○○○○◦"
      + "○●A○◦"
      + "●○○○◦"
      + "◦◦◦◦◦";
    testing(boardInput, MOVE_ERROR_SUICIDE);
  }

  @Test public void testErrorSuicide_02() {
    String boardInput =
        "◦◦○◦◦"
      + "○○●○◦"
      + "○●A●○"
      + "○○○○◦"
      + "◦◦◦◦◦";
    testing(boardInput, MOVE_ERROR_SUICIDE);
  }

  @Test public void testErrorSuicide_03() {
    String boardInput =
        "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "●●●●●"
      + "●○○○○"
      + "●○A○◦";
    testing(boardInput, MOVE_ERROR_SUICIDE);
  }

  @Test public void testErrorSuicide_04() {
    String boardInput =
        "◦●●●●●◦"
      + "◦●○○○●◦"
      + "●●○◦○●◦"
      + "●○A○●◦◦"
      + "●○○○●◦◦"
      + "●●●●●◦◦"
      + "◦◦◦◦◦◦◦";
    testing(boardInput, MOVE_ERROR_SUICIDE);
  }

  @Test public void testErrorSuicide_05() {
    String boardInput =
        "◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦"
      + "◦●●●●●●"
      + "◦●○○○○○"
      + "◦○A●○◦○";
    testing(boardInput, MOVE_ERROR_SUICIDE);
  }

  @Test public void testEat_01() {
    String boardInput =
        "◦◦◦◦◦"
      + "A○○○◦"
      + "◬●◦○◦"
      + "●○○○◦"
      + "◦◦◦◦◦";
    MoveHandling moveHandling = testing(boardInput, MOVE_EAT_NO_JIE);
    CoordBoard coordBoard = moveHandling.getCoordBoard();
    ImmutableSet<Coord> expectedDeadCoords = Coord.readCoordsFromString(
        boardInput, coordBoard, PositionStateChars.WHITE_CAPTURED);
    assertEquals(expectedDeadCoords, moveHandling.getDeadCoords());

    String nextBoard = moveHandling.getPositionStateBoardAfterMove().toString();
    assertEquals(
        "◦◦◦◦◦"
      + "●○○○◦"
      + "◦●◦○◦"
      + "●○○○◦"
      + "◦◦◦◦◦",
      nextBoard.replaceAll("\n", ""));
  }

  @Test public void testEat_02() {
    String boardInput =
        "◦◦◦◦◦"
      + "●●●◦◦"
      + "●○○A◦"
      + "●●○●◦"
      + "○○○●◦";
    Coord currentJieEatenCoord = null;
    MoveHandling moveHandling = testing(boardInput,
        Optional.fromNullable(currentJieEatenCoord),
        MOVE_EAT_NO_JIE);
    CoordBoard coordBoard = moveHandling.getCoordBoard();
    ImmutableSet<Coord> expectedDeadCoords = Coord.readCoordsFromString(
        boardInput, coordBoard, PositionStateChars.WHITE);
    assertEquals(expectedDeadCoords, moveHandling.getDeadCoords());

    String nextBoard = moveHandling.getPositionStateBoardAfterMove().toString();
    assertEquals(
        "◦◦◦◦◦"
      + "●●●◦◦"
      + "●◦◦●◦"
      + "●●◦●◦"
      + "◦◦◦●◦",
      nextBoard.replaceAll("\n", ""));
  }

  @Test public void testEat_03() {
    String boardInput =
        "◦◦◦◦◦"
      + "●●●○◦"
      + "●○○A○"
      + "●●●○◦"
      + "◦◦◦◦◦";
    Coord currentJieEatenCoord = null;
    MoveHandling moveHandling = testing(boardInput,
        Optional.fromNullable(currentJieEatenCoord),
        MOVE_EAT_NO_JIE);

    String nextBoard = moveHandling.getPositionStateBoardAfterMove().toString();
    assertEquals(
        "◦◦◦◦◦"
      + "●●●○◦"
      + "●◦◦●○"
      + "●●●○◦"
      + "◦◦◦◦◦",
      nextBoard.replaceAll("\n", ""));
  }

  @Test public void testEat_04() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦●●●●●●◦◦"
      + "◦●○○○○●◦◦"
      + "◦●○●A○●◦◦"
      + "◦●○○○○●◦◦"
      + "◦●●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    Coord currentJieEatenCoord = null;
    MoveHandling moveHandling = testing(boardInput,
        Optional.fromNullable(currentJieEatenCoord),
        MOVE_EAT_NO_JIE);

    String nextBoard = moveHandling.getPositionStateBoardAfterMove().toString();
    assertEquals(
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦●●●●●●◦◦"
      + "◦●◦◦◦◦●◦◦"
      + "◦●◦●●◦●◦◦"
      + "◦●◦◦◦◦●◦◦"
      + "◦●●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦",
      nextBoard.replaceAll("\n", ""));
  }

  @Test public void testEat_05() {
    String boardInput =
        "◦◦●◦◦"
      + "●●○●◦"
      + "●○A○○"
      + "●●○●◦"
      + "◦◦●◦◦";
    Coord currentJieEatenCoord = null;
    MoveHandling moveHandling = testing(boardInput,
        Optional.fromNullable(currentJieEatenCoord),
        MOVE_EAT_NO_JIE);

    String nextBoard = moveHandling.getPositionStateBoardAfterMove().toString();
    assertEquals(
        "◦◦●◦◦"
      + "●●◦●◦"
      + "●◦●○○"
      + "●●◦●◦"
      + "◦◦●◦◦",
      nextBoard.replaceAll("\n", ""));
  }

  @Test public void testEat_06() {
    String boardInput =
        "◦◦◦◦◦"
      + "◦●●●◦"
      + "●○○○●"
      + "○●A●○"
      + "◦○○○◦";
    testing(boardInput, MOVE_EAT_NO_JIE);
  }

  @Test public void testEat_07() {
    String boardInput =
        "◦◦◦●◦"
      + "◦◦●○●"
      + "◦●○A○"
      + "◦◦●○◦"
      + "◦◦◦◦◦";
    testing(boardInput, MOVE_EAT_NO_JIE);
  }

  @Test public void testEat_08() {
    String boardInput =
        "◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●◦"
      + "◦◦◦◦●○◦"
      + "◦●●●○●○"
      + "●○○○A●○"
      + "◦●○●○○◦"
      + "●●●●◦◦◦";
    testing(boardInput, MOVE_EAT_NO_JIE);
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////
  // Jie Moves

  @Test public void testEatCausingJie_00() {
    String boardInput =
        "◦◦◦◦◦"
      + "●●○◦◦"
      + "●○A○◦"
      + "●●○◦◦"
      + "◦◦◦◦◦";
    Coord currentJieEatenCoord = null;
    MoveHandling moveHandling = testing(boardInput,
        Optional.fromNullable(currentJieEatenCoord),
        MOVE_EAT_CAUSING_JIE);

    String nextBoard = moveHandling.getPositionStateBoardAfterMove().toString();
    assertEquals(
        "◦◦◦◦◦"
      + "●●○◦◦"
      + "●◦●○◦"
      + "●●○◦◦"
      + "◦◦◦◦◦",
      nextBoard.replaceAll("\n", ""));
  }

  @Test public void testEatCausingJie_01() {
    String boardInput =
      "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦○◦◦"
    + "◦◦◦●◦○A○◦"
    + "◦◦◦◦●●○●○"
    + "◦◦◦◦◦○●●○"
    + "◦◦◦◦◦◦◦○◦";
    testing(boardInput, MOVE_EAT_CAUSING_JIE);
  }

  @Test public void testEatCausingJie_02() {
    String boardInput =
      "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦●◦◦"
    + "◦◦◦◦◦◦●○◦"
    + "◦◦◦◦◦●○●●"
    + "◦◦◦◦○○A○○"
    + "◦◦◦◦◦◦○◦◦"
    + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput, MOVE_EAT_CAUSING_JIE);
  }

  @Test public void testEatCausingJie_03() {
    String boardInput =
      "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦○◦○●◦◦"
    + "◦◦◦○●●○◦◦"
    + "◦◦◦○●○A○◦"
    + "◦◦◦◦○●○◦◦"
    + "◦◦◦◦◦◦●◦◦"
    + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput, MOVE_EAT_CAUSING_JIE);
  }

  @Test public void testEatCausingJie_04() {
    String boardInput =
      "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦○◦◦◦◦"
    + "◦◦◦◦◦○○◦◦"
    + "◦●◦◦○●◦◦◦"
    + "◦◦●◦○●○◦◦"
    + "◦●◦●○●○◦◦"
    + "◦◦◦●●○A○◦";
    testing(boardInput, MOVE_EAT_CAUSING_JIE);
  }

  @Test public void testEatCausingJie_05() {
    String boardInput =
      "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦●◦◦◦"
    + "◦◦◦○○●◦◦◦"
    + "◦◦○●○●◦●◦"
    + "◦◦○●●○●◦◦"
    + "◦◦○●○A○○◦"
    + "◦◦○●○○◦○◦"
    + "◦◦○●◦◦○◦◦";
    testing(boardInput, MOVE_EAT_CAUSING_JIE);
  }

  @Test public void testEatCausingJie_06() {
    String boardInput =
      "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦●◦◦"
    + "◦◦◦◦◦○●◦◦"
    + "◦◦◦◦◦○○●◦"
    + "◦◦○○◦◦●●◦"
    + "◦○●●○○●○◦"
    + "◦◦●●●●○A○";
    testing(boardInput, MOVE_EAT_CAUSING_JIE);
  }

  @Test public void testEatCausingJie_07() {
    String boardInput =
      "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦●●●●◦"
    + "◦◦◦●◦○○●●"
    + "◦◦◦●○○A○○"
    + "◦◦◦◦◦●○●◦";
    testing(boardInput, MOVE_EAT_CAUSING_JIE);
  }

  @Test public void testEatCausingJie_08() {
    String boardInput =
      "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦●◦●●●●●"
    + "◦◦◦●○○○○○"
    + "◦◦●○○●●●○"
    + "◦◦●○◦◦●○A";
    testing(boardInput, MOVE_EAT_CAUSING_JIE);
  }

  @Test public void testEatCausingJie_09() {
    String boardInput =
      "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦●◦◦"
    + "◦◦◦◦◦◦◦●◦"
    + "◦◦◦◦●●●○●"
    + "◦◦◦◦●○○○◦"
    + "◦◦◦◦●○●●○"
    + "◦◦◦◦◦◦●○A";
    testing(boardInput, MOVE_EAT_CAUSING_JIE);
  }

  @Test public void testEatCausingJie_10() {
    String boardInput =
      "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦◦◦◦"
    + "◦◦◦◦◦◦○◦◦"
    + "◦◦◦●◦●◦◦◦"
    + "◦◦◦◦◦●○○◦"
    + "◦◦◦●◦●○◦◦"
    + "◦○◦●◦○●○◦"
    + "◦◦○●●○●●○"
    + "◦◦○○○A○●◦";
    testing(boardInput, MOVE_EAT_CAUSING_JIE);
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////
  // PASS moves

  @Test public void testPassMove_1() {
    String boardInput =
        "◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦";
    int boardSize = VisualBoard.getBoardSizeFromBoardInput(boardInput);
    CoordBoard coordBoard = new CoordBoard(boardSize);
    PositionStateBoard positionStateBoard =
        PositionStateBoard.readFromString(boardInput, coordBoard);
    MoveHandling moveHandling = MoveHandling.constructPassMoveHandling(
        positionStateBoard, Color.B);
    MoveType moveType = moveHandling.getMoveType();
    assertEquals(MoveType.MOVE_PASS, moveType);
  }

  @Test public void testPassMove_2() {
    String boardInput =
        "◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦"
      + "◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦";
    int boardSize = VisualBoard.getBoardSizeFromBoardInput(boardInput);
    CoordBoard coordBoard = new CoordBoard(boardSize);
    PositionStateBoard positionStateBoard =
        PositionStateBoard.readFromString(boardInput, coordBoard);
    MoveHandling moveHandling = MoveHandling.constructPassMoveHandling(
        positionStateBoard, Color.W);
    MoveType moveType = moveHandling.getMoveType();
    assertEquals(MoveType.MOVE_PASS, moveType);
  }
}
