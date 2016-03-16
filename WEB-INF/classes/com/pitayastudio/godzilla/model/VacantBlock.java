package com.pitayastudio.godzilla.model;

import com.google.common.collect.ImmutableSet;

import com.pitayastudio.godzilla.common.PositionState;
import com.pitayastudio.godzilla.common.PositionStateChars;
import com.pitayastudio.godzilla.modelboard.CoordBoard;
import com.pitayastudio.godzilla.modelboard.VisualBoard;

import java.util.logging.Logger;

import javax.annotation.Nonnull;

/**
 * @see DesignDoc#block
 */
public class VacantBlock extends Block {
  @SuppressWarnings("unused")
  private static final Logger logger = Logger.getLogger(VacantBlock.class.getName());

  public static VacantBlock readFromString(
      @Nonnull String boardInput, @Nonnull CoordBoard coordBoard, char targetChar) {
    int boardSize = VisualBoard.getBoardSizeFromBoardInput(boardInput);
    assert(coordBoard.getBoardSize() == boardSize);
    Block.Builder blockBuilder = Block.newBuilder()
        .setRequiredPositState(PositionState.VACANT)
        .setRequiredBoardSize(boardSize);
    for (int xPosition = 1; xPosition <= boardSize; xPosition++) {
      for (int yPosition = 1; yPosition <= boardSize; yPosition++) {
        int indexInString = boardSize * (boardSize - yPosition) + xPosition - 1;
        char positionChar = boardInput.charAt(indexInString);
        if (positionChar == targetChar) {
          Coord coord = coordBoard.getCoord(xPosition, yPosition);
          blockBuilder.addCoord(coord);
        }
      }
    }
    return (VacantBlock) blockBuilder.build();
  }

  VacantBlock(int boardSize, @Nonnull ImmutableSet<Coord> coords) {
    super(PositionState.VACANT, boardSize, coords);
  }

  @Override
  public String toString() {
    VisualBoard visualBoard = new VisualBoard(boardSize);
    visualBoard.updatePositStatesForView(getCoords(),
        PositionStateChars.VACANT_EMPHASIZED_WHITE_SQUARE);
    return visualBoard.toString();
  }
}
