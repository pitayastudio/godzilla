package com.pitayastudio.godzilla.model;

import com.google.common.collect.ImmutableSet;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.PositionState;
import com.pitayastudio.godzilla.modelboard.BlockBoard;
import com.pitayastudio.godzilla.modelboard.CoordBoard;
import com.pitayastudio.godzilla.modelboard.VisualBoard;

import java.util.logging.Logger;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @see DesignDoc#block()
 */
public class ColorBlock extends Block {
  @SuppressWarnings("unused")
  private static final Logger logger = Logger.getLogger(ColorBlock.class.getName());

  public static ColorBlock readFromString(
      String boardInput,
      CoordBoard coordBoard,
      Color color,
      char targetColorChar) {
    int boardSize = VisualBoard.getBoardSizeFromBoardInput(boardInput);
    assert(coordBoard.getBoardSize() == boardSize);
    Block.Builder blockBuilder = Block.newBuilder()
        .setRequiredBoardSize(boardSize);
    PositionState positionState = color.getPositionState();
    blockBuilder.setRequiredPositState(positionState);
    for (int xPosition = 1; xPosition <= boardSize; xPosition++) {
      for (int yPosition = 1; yPosition <= boardSize; yPosition++) {
        int indexInString = boardSize * (boardSize - yPosition) + xPosition - 1;
        char positionChar = boardInput.charAt(indexInString);
        if (positionChar == targetColorChar) {
          Coord coord = coordBoard.getCoord(xPosition, yPosition);
          blockBuilder.addCoord(coord);
        }
      }
    }
    return (ColorBlock) blockBuilder.build();
  }

  public static ImmutableSet<ColorBlock> readColorBlocksFromString(
      @Nonnull String boardInput, @Nonnull BlockBoard blockBoard, char colorBlockChar) {
    int boardSize = VisualBoard.getBoardSizeFromBoardInput(boardInput);
    ImmutableSet.Builder<ColorBlock> colorBlocksBuilder = ImmutableSet.builder();
    for (int xPosition = 1; xPosition <= boardSize; xPosition++) {
      for (int yPosition = 1; yPosition <= boardSize; yPosition++) {
        int indexInString = boardSize * (boardSize - yPosition) + xPosition - 1;
        char positionChar = boardInput.charAt(indexInString);
        if (positionChar == colorBlockChar) {
          ColorBlock colorBlock = blockBoard.getColorBlock(xPosition, yPosition);
          colorBlocksBuilder.add(colorBlock);
        }
      }
    }
    ImmutableSet<ColorBlock> colorBlocks = colorBlocksBuilder.build();
    if (colorBlocks.isEmpty()) {
      throw new IllegalArgumentException(
          "Missing ColorBlock of char(" + colorBlockChar + ") in boardInput:\n" + boardInput);
    }
    return colorBlocks;
  }

  private final Color color;

  ColorBlock(@Nonnull PositionState positionState, int boardSize,
      @Nonnull ImmutableSet<Coord> coords) {
    super(positionState, boardSize, coords);
    assert positionState == PositionState.BLACK || positionState == PositionState.WHITE;
    this.color = positionState == PositionState.BLACK ? Color.B : Color.W;
  }

  public Color getColor() {
    return color;
  }

  @Override
  public boolean equals(@Nullable Object obj) {
    //logger.info("Entering ColorBlock.equals()");
    if (this == obj) {
      return true;
    }
    if (!super.equals(obj)) {
      return false;
    }
    assert(obj instanceof ColorBlock);
    ColorBlock other = (ColorBlock) obj;
    return color == other.color;
  }

  @Override
  public String toString() {
    VisualBoard visualBoard = new VisualBoard(boardSize);
    boolean isEmphasized = false;
    visualBoard.updateBoardStateWithColorBlock(this, isEmphasized);
    return visualBoard.toString();
  }
}
