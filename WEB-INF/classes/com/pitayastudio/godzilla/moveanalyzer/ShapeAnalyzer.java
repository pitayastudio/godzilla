package com.pitayastudio.godzilla.moveanalyzer;

import com.google.common.collect.ImmutableSet;

import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.modelboard.CoordBoard;

import javax.annotation.Nonnull;

public class ShapeAnalyzer {
  private final CoordBoard coordBoard;
  private final ImmutableSet<Coord> squareFourShapeCoords;

  public ShapeAnalyzer(@Nonnull CoordBoard coordBoard) {
    this.coordBoard = coordBoard;

    squareFourShapeCoords = ImmutableSet.<Coord>builder()
        .add(coordBoard.getCoord(1, 1))
        .add(coordBoard.getCoord(2, 1))
        .add(coordBoard.getCoord(1, 2))
        .add(coordBoard.getCoord(2, 2))
        .build();
  }

  public boolean isSquareFour(@Nonnull ImmutableSet<Coord> coords) {
    return isShapeMatchNormalizedShape(coords, squareFourShapeCoords);
  }

  public boolean isShapeMatchNormalizedShape(
      @Nonnull ImmutableSet<Coord> shapeCoords1,
      @Nonnull ImmutableSet<Coord> normalizedShapeCoords2) {

    if (shapeCoords1.size() != normalizedShapeCoords2.size()) {
      return false;
    }

    Coord bottomLeftCoord1 = calcBottomLeftPositOfEnclosingRectangle(shapeCoords1);
    ImmutableSet<Coord> normalizedCoords1 = shiftPositsToBottomLeft(shapeCoords1, bottomLeftCoord1);
    return normalizedCoords1.equals(normalizedShapeCoords2);
  }

  // Note: The returned coord does not need to be an element of vePosit.
  private Coord calcBottomLeftPositOfEnclosingRectangle(@Nonnull ImmutableSet<Coord> coords) {
    int boardSize = coordBoard.getBoardSize();
    int smallestXPosition = boardSize;  // init value
    int smallestYPosition = boardSize;  // init value
    for (Coord coord : coords) {
      smallestXPosition = Math.min(coord.getXPosition(), smallestXPosition);
      smallestYPosition = Math.min(coord.getYPosition(), smallestXPosition);
    }
    return coordBoard.getCoord(smallestXPosition, smallestYPosition);
  }

  private ImmutableSet<Coord> shiftPositsToBottomLeft(
      @Nonnull ImmutableSet<Coord> origCoords, @Nonnull Coord mostBottomLeftCoord) {
    ImmutableSet.Builder<Coord> shiftedCoordsBuilder = ImmutableSet.builder();
    for (Coord origCoord : origCoords) {
      Coord coordShifted = shiftPositRelToBasePosit(origCoord, mostBottomLeftCoord);
      shiftedCoordsBuilder.add(coordShifted);
    }
    return shiftedCoordsBuilder.build();
  }

  private Coord shiftPositRelToBasePosit(
      @Nonnull Coord coordToBeShifted, @Nonnull Coord baseCoord) {
    int shiftedXPosition = coordToBeShifted.getXPosition() - baseCoord.getXPosition() + 1;
    int shiftedYPosition = coordToBeShifted.getYPosition() - baseCoord.getYPosition() + 1;
    Coord shiftedCoord = coordBoard.getCoord(shiftedXPosition, shiftedYPosition);
    return shiftedCoord;
  }
}
