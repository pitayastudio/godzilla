package com.pitayastudio.godzilla.moveanalyzer;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedMap;

import com.pitayastudio.godzilla.common.PositionStateChars;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.modelboard.CoordBoard;
import com.pitayastudio.godzilla.modelboard.VisualBoard;

import javax.annotation.Nonnull;

public class TestUtils {
  /**
   * Converts (x, y) indexes to {@link Coord}'s.
   *
   * @param xyIndices Sample input: [x1Index, y1Index, x2Index, y2Index, x3Index, y3Index]
   */
  public static ImmutableList<Coord> convertXYIndicesToCoords(
      @Nonnull CoordBoard coordBoard,
      int[] xyIndices) {
    assert (xyIndices.length & 1) == 0;  // the count number must be even
    ImmutableList.Builder<Coord> coordsBuilder = ImmutableList.builder();
    for (int i = 0; i < xyIndices.length - 1; i += 2) {
      int xPosition = xyIndices[i] + 1;
      int yPosition = xyIndices[i + 1] + 1;
      Coord coord = coordBoard.getCoord(xPosition, yPosition);
      coordsBuilder.add(coord);
    }
    return coordsBuilder.build();
  }

  /**
   * Reads candidate coords from board input. The coords are marked with A-Z.
   */
  public static ImmutableMap<String, Coord> readAlphabetToCandidateCoordMapFromString(
      @Nonnull String boardInput, @Nonnull CoordBoard coordBoard) {
    int boardSize = VisualBoard.getBoardSizeFromBoardInput(boardInput);
    ImmutableMap.Builder<String, Coord> candidateStringToCoordMapBuilder = ImmutableMap.builder();
    for (int xPosition = 1; xPosition <= boardSize; xPosition++) {
      for (int yPosition = 1; yPosition <= boardSize; yPosition++) {
        int indexInString = boardSize * (boardSize - yPosition) + xPosition - 1;
        char positionChar = boardInput.charAt(indexInString);
        if (positionChar >= PositionStateChars.A && positionChar <= PositionStateChars.Z) {
          String key = String.valueOf(positionChar);
          Coord value = coordBoard.getCoord(xPosition, yPosition);
          candidateStringToCoordMapBuilder.put(key, value);
        }
      }
    }
    return candidateStringToCoordMapBuilder.build();
  }

  /**
   * Reads expected move coord from board input. The coord is marked with
   * {@link PositionStateChars#A}.
   */
  public static Coord readExpectedMoveCoordFromString(
      @Nonnull String boardInput, @Nonnull CoordBoard coordBoard) {
    Coord coord = Coord.readFromStringIfAny(boardInput, coordBoard, PositionStateChars.A);
    if (coord != null) {
      return coord;
    }
    throw new IllegalArgumentException("Missing 'A' in boardInput");
  }

  /**
   * Reads expected move coords from board input. The coords are marked with
   * {@link PositionStateChars#A} - {@link PositionStateChars#Z}.
   */
  public static ImmutableSet<Coord> readExpectedMoveCoordsFromString(
      @Nonnull String boardInput, @Nonnull CoordBoard coordBoard) {
    int boardSize = VisualBoard.getBoardSizeFromBoardInput(boardInput);
    ImmutableSet.Builder<Coord> coordsBuilder = ImmutableSet.builder();
    for (int xPosition = 1; xPosition <= boardSize; xPosition++) {
      for (int yPosition = 1; yPosition <= boardSize; yPosition++) {
        int indexInString = boardSize * (boardSize - yPosition) + xPosition - 1;
        char positionChar = boardInput.charAt(indexInString);
        if (positionChar >= PositionStateChars.A && positionChar <= PositionStateChars.Z) {
          Coord coord = coordBoard.getCoord(xPosition, yPosition);
          coordsBuilder.add(coord);
        }
      }
    }
    ImmutableSet<Coord> coords = coordsBuilder.build();
    return coords;
  }

  /**
   * Reads sequence of move coords with the order of A-Z.
   */
  public static ImmutableList<Coord> readSequenceOfMoveCoords(
      @Nonnull String boardInput, @Nonnull CoordBoard coordBoard) {
    int boardSize = VisualBoard.getBoardSizeFromBoardInput(boardInput);
    ImmutableSortedMap.Builder<Character, Coord> sortedCharToCoordMapBuilder =
        ImmutableSortedMap.naturalOrder();
    for (int xPosition = 1; xPosition <= boardSize; xPosition++) {
      for (int yPosition = 1; yPosition <= boardSize; yPosition++) {
        int indexInString = boardSize * (boardSize - yPosition) + xPosition - 1;
        char positionChar = boardInput.charAt(indexInString);
        if (positionChar >= PositionStateChars.A && positionChar <= PositionStateChars.Z) {
          Coord coord = coordBoard.getCoord(xPosition, yPosition);
          sortedCharToCoordMapBuilder.put(positionChar, coord);
        }
      }
    }
    ImmutableSortedMap<Character, Coord> charToCoordMap = sortedCharToCoordMapBuilder.build();
    ImmutableList<Coord> moveCoords = charToCoordMap.values().asList();
    assert !moveCoords.isEmpty();
    return moveCoords;
  }
}
