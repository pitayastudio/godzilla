package com.pitayastudio.godzilla.modelboard;

import com.google.common.collect.ImmutableSet;

import com.pitayastudio.godzilla.common.PositionState;
import com.pitayastudio.godzilla.model.Coord;

import junit.framework.TestCase;

import org.junit.Test;

public class PositionStateBoardTest extends TestCase {

  @Test public void testBuilder() {
    int boardSize = 3;
    CoordBoard coordBoard = new CoordBoard(boardSize);
    PositionStateBoard.Builder builder = PositionStateBoard.newBuilder(coordBoard);
    builder.setPositionStates(
        ImmutableSet.<Coord>of(coordBoard.getCoord(1, 1), coordBoard.getCoord(2, 2)),
        PositionState.BLACK);
    builder.setPositionState(3, 3, PositionState.WHITE);
    PositionStateBoard board = builder.build();
    String boardOutput = board.toString();
    assertEquals(
        "◦◦○"
      + "◦●◦"
      + "●◦◦",
        boardOutput.replaceAll("\n", ""));
  }

  @Test public void testBuilder_19x19() {
    int boardSize = 19;
    CoordBoard coordBoard = new CoordBoard(boardSize);
    PositionStateBoard.Builder builder = PositionStateBoard.newBuilder(coordBoard);
    builder.setPositionStates(
        ImmutableSet.<Coord>of(coordBoard.getCoord(4, 4), coordBoard.getCoord(16, 16)),
        PositionState.BLACK);
    builder.setPositionState(16, 4, PositionState.WHITE);
    PositionStateBoard board = builder.build();
    String boardOutput = board.toString();
    assertEquals(
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦●◦◦◦◦◦◦◦◦◦◦◦○◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦",
        boardOutput.replaceAll("\n", ""));
  }
}
