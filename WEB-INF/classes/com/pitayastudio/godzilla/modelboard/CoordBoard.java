package com.pitayastudio.godzilla.modelboard;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import com.pitayastudio.godzilla.common.Direction;
import com.pitayastudio.godzilla.common.PositionStateChars;
import com.pitayastudio.godzilla.common.Utils;
import com.pitayastudio.godzilla.game.GameCoordinator;
import com.pitayastudio.godzilla.model.Coord;

import javax.annotation.Nonnull;

/**
 * Immutable board of {@link Coord}.
 */
public class CoordBoard {
  private final int boardSize;
  private final ImmutableList<ImmutableList<Coord>> coordListList;

  /** Used by {@link GameCoordinator} only plus testing code */
  public CoordBoard(int boardSize) {
    assert(Utils.isValidBoardSize(boardSize));
    this.boardSize = boardSize;
    ImmutableList.Builder<ImmutableList<Coord>> coordListListBuilder = ImmutableList.builder();
    for (int i = 0, max = boardSize + 1; i <= max; i++) {
      ImmutableList.Builder<Coord> coordListBuilder = ImmutableList.builder();
      for (int j = 0; j <= max; j++) {
        coordListBuilder.add(new Coord(i, j));
      }
      coordListListBuilder.add(coordListBuilder.build());
    }
    coordListList = coordListListBuilder.build();
  }

  public final int getBoardSize() {
    return boardSize;
  }

  public Coord getCoord(int xPosition, int yPosition) {
    assert xPosition >= 0 && xPosition <= boardSize + 1
        && yPosition >= 0 && yPosition <= boardSize + 1;
    return coordListList.get(xPosition).get(yPosition);
  }

  public Coord getNeighborCoordInDirection(@Nonnull Coord coord, @Nonnull Direction direction) {
    int neighborX = coord.getXPosition() + direction.getXIncrement();
    int neighborY = coord.getYPosition() + direction.getYIncrement();
    return getCoord(neighborX, neighborY);
  }

  public ImmutableSet<Coord> readCoordsFromStarsInBoardAsString(@Nonnull String boardInput) {
    int boardSize = (int) Math.sqrt(boardInput.length());
    ImmutableSet.Builder<Coord> coordsBuilder = ImmutableSet.builder();
    for (int xPosition = 1; xPosition <= boardSize; xPosition++) {
      for (int yPosition = 1; yPosition <= boardSize; yPosition++) {
        int indexInString = boardSize * (boardSize - yPosition) + xPosition - 1;
        char coordChar = boardInput.charAt(indexInString);
        if (coordChar == PositionStateChars.STAR) {
          coordsBuilder.add(getCoord(xPosition, yPosition));
        }
      }
    }
    return coordsBuilder.build();
  }

  @Override public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("boardSize: ").append(boardSize);
    return sb.toString();
  }
}
