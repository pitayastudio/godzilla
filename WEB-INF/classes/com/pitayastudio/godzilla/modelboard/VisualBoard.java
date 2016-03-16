package com.pitayastudio.godzilla.modelboard;

import com.google.common.annotations.VisibleForTesting;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.PositionState;
import com.pitayastudio.godzilla.common.PositionStateChars;
import com.pitayastudio.godzilla.model.ColorBlock;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.model.VacantBlock;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Nonnull;

/**
 * Mutable board for visual purpose.
 */
public class VisualBoard {
  public static int getBoardSizeFromBoardInput(@Nonnull String boardInput) {
    int boardSize = (int) Math.sqrt(boardInput.length());
    assert boardInput.length() == boardSize * boardSize :
        "Invalid boardInput.length() = " + boardInput.length() + ", and boardSize = " + boardSize;
    return boardSize;
  }

  @VisibleForTesting static String drawColorBlockWithNeighborhoodsAndQis(
      @Nonnull ColorBlock colorBlock,
      @Nonnull BlockBoard blockBoard) {
    VisualBoard visualBoard = new VisualBoard(blockBoard.getBoardSize());
    NeighborhoodBoard neighborhoodBoard =
        NeighborhoodBoard.newBuilder().setRequiredBlockBoard(blockBoard).build();
    QiBoard qiBoard = QiBoard.newBuilder()
        .setBlockBoard(blockBoard)
        .build();

    visualBoard.updateBoardStateWithColorBlock(colorBlock, false);

    Set<ColorBlock> foeColorBlocks = neighborhoodBoard.getNeighborFoeBlocks(colorBlock);
    for (ColorBlock foeColorBlock : foeColorBlocks) {
      visualBoard.updateBoardStateWithColorBlock(foeColorBlock, false);
    }

    Set<Coord> allQiCoords = qiBoard.getAllQiCoordsForColorBlock(colorBlock);
    char state = PositionStateChars.VACANT_AS_QI;
    for (Coord qiCoord : allQiCoords) {
      visualBoard.updatePositStateForView(qiCoord.getXPosition(), qiCoord.getYPosition(), state);
    }

    return visualBoard.toString();
  }

  static String drawBlocksWithoutAnyQis(@Nonnull BlockBoard blockBoard) {
    VisualBoard visualBoard = new VisualBoard(blockBoard.getBoardSize());
    QiBoard qiBoard = QiBoard.newBuilder()
      .setBlockBoard(blockBoard)
      .build();
    for (Color color : Color.values()) {
      for (ColorBlock colorBlock : qiBoard.getAllBlocksOfColorWithZeroQi(color)) {
        visualBoard.updateBoardStateWithColorBlock(colorBlock, false);
      }
    }
    return visualBoard.toString();
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////
  // End of static stuff
  //////////////////////////////////////////////////////////////////////////////////////////////////

  private final int boardSize;
  private final List<List<Character>> mutablePositStateForViewListList;

  public VisualBoard(int boardSize, boolean isAsciiChar) {
    this.boardSize = boardSize;
    mutablePositStateForViewListList = new ArrayList<>();
    for (int i = 0; i < boardSize; i++) {
      List<Character> positionStateList = new ArrayList<>();
      mutablePositStateForViewListList.add(positionStateList);
      for (int j = 0; j < boardSize; j++) {
        char positionState = isAsciiChar ? PositionStateChars.VACANT_ASCII : PositionStateChars.VACANT;
        positionStateList.add(positionState);
      }
    }
  }

  public VisualBoard(int boardSize) {
    this(boardSize, false);
  }

  public VisualBoard(@Nonnull PositionStateBoard positionStateBoard, boolean isAsciiChar) {
    this.boardSize = positionStateBoard.getBoardSize();
    mutablePositStateForViewListList = new ArrayList<>();
    for (int xPosition = 1; xPosition <= boardSize; xPosition++) {
      List<Character> positionStateList = new ArrayList<>();
      for (int yPosition = 1; yPosition <= boardSize; yPosition++) {
        PositionState positionState = positionStateBoard.getPositionState(xPosition, yPosition);
        char positionStateForView = (positionState == PositionState.VACANT)
            ? (isAsciiChar? PositionStateChars.VACANT_ASCII : PositionStateChars.VACANT)
            : (positionState == PositionState.BLACK)
                ? (isAsciiChar? PositionStateChars.BLACK_ASCII : PositionStateChars.BLACK)
                : (isAsciiChar? PositionStateChars.WHITE_ASCII : PositionStateChars.WHITE);
        positionStateList.add(positionStateForView);
      }
      mutablePositStateForViewListList.add(positionStateList);
    }
  }

  public VisualBoard(@Nonnull PositionStateBoard positionStateBoard) {
    this(positionStateBoard, false);
  }

  public void updatePositStateForView(int xPosition, int yPosition, char state) {
    assert xPosition >= 1 && xPosition <= this.boardSize;
    assert yPosition >= 1 && yPosition <= this.boardSize;
    mutablePositStateForViewListList.get(xPosition - 1).set(yPosition - 1, state);
  }

  public void updatePositStatesForView(@Nonnull Set<Coord> coords, char state) {
    for (Coord coord : coords) {
      updatePositStateForView(coord.getXPosition(), coord.getYPosition(), state);
    }
  }

  public void updateBoardStateWithVacantBlock(
      @Nonnull VacantBlock vacantBlock, boolean isEmphasized) {
    char state = isEmphasized
        ? PositionStateChars.VACANT_EMPHASIZED_WHITE_SQUARE
        : PositionStateChars.VACANT;
    updatePositStatesForView(vacantBlock.getCoords(), state);
  }

  public void updateBoardStateWithColorBlock(
      @Nonnull ColorBlock colorBlock, boolean isEmphasized) {
    char state = isEmphasized
        ? ((colorBlock.getColor() == Color.B)
            ? PositionStateChars.BLACK_EMPHASIZED
            : PositionStateChars.WHITE_EMPHASIZED)
        : ((colorBlock.getColor() == Color.B)
            ? PositionStateChars.BLACK
            : PositionStateChars.WHITE);
    updatePositStatesForView(colorBlock.getCoords(), state);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < boardSize; i++) {
      for (int j = 0; j < boardSize; j++) {
        int xPosition = j;
        int yPosition = boardSize - 1 - i;
        sb.append(mutablePositStateForViewListList.get(xPosition).get(yPosition));
      }
      sb.append('\n');
    }
    return sb.toString();
  }
}
