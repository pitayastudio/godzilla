package com.pitayastudio.godzilla.model;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import com.pitayastudio.godzilla.common.Utils;
import com.pitayastudio.godzilla.common.GtpVertex.InvalidVertexException;
import com.pitayastudio.godzilla.modelboard.CoordBoard;
import com.pitayastudio.godzilla.modelboard.VisualBoard;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @see DesignDoc#coord
 */
public class Coord {
  public static final String JSON_PROPERTY_Y_POSITION = "yPosition";
  public static final String JSON_PROPERTY_X_POSITION = "xPosition";

  private static final char FIRST_UPPER_CASE_CHAR = 'A';
  private static final char FIRST_LOWER_CASE_CHAR = 'a';
  private static final char SKIPPED_UPPER_CASE_CHAR_GTP = 'I';
  private static final char SKIPPED_LOWER_CASE_CHAR_GTP = 'i';
  private static final char LAST_UPPER_CASE_CHAR_GTP = 'T';
  private static final char LAST_LOWER_CASE_CHAR_GTP = 't';

  public static int convertGtpXCharToPosition(char xPositionChar)
      throws InvalidVertexException {
    if (xPositionChar >= FIRST_UPPER_CASE_CHAR
        && xPositionChar < SKIPPED_UPPER_CASE_CHAR_GTP) {
      return xPositionChar - FIRST_UPPER_CASE_CHAR + 1;
    } else if (xPositionChar > SKIPPED_UPPER_CASE_CHAR_GTP
        && xPositionChar <= LAST_UPPER_CASE_CHAR_GTP) {
      return xPositionChar - SKIPPED_UPPER_CASE_CHAR_GTP;
    } else if (xPositionChar >= FIRST_LOWER_CASE_CHAR
        && xPositionChar < SKIPPED_LOWER_CASE_CHAR_GTP) {
      return xPositionChar - FIRST_LOWER_CASE_CHAR + 1;
    } else if (xPositionChar > SKIPPED_LOWER_CASE_CHAR_GTP
        && xPositionChar <= LAST_LOWER_CASE_CHAR_GTP) {
      return xPositionChar - SKIPPED_LOWER_CASE_CHAR_GTP;
    } else {
      throw new InvalidVertexException("Invalid x position char: " + xPositionChar);
    }
  }

  public static int convertGtpYStringToPosition(@Nonnull String yPositionString)
      throws InvalidVertexException {
    try {
      int yPosition = Integer.parseInt(yPositionString);
      return yPosition;
    } catch (NumberFormatException e) {
      throw new InvalidVertexException("Invalid y position: " + yPositionString);
    }
  }

  public static String convertPositionToGtpXLowerCaseString(int xPosition) {
    assert xPosition >= 1 && xPosition <= 19;

    if (xPosition >= 1 && xPosition <= 8) {  // the position of 'I' is 9
      return String.valueOf((char) (FIRST_LOWER_CASE_CHAR + xPosition - 1));
    } else {
      return String.valueOf((char) (SKIPPED_UPPER_CASE_CHAR_GTP + xPosition - 1));
    }
  }

  public static String convertPositionToGtpYLowerCaseString(int yPosition) {
    String yPositionString = String.valueOf(yPosition);
    return yPositionString;
  }

  /**
   * Returns a~s for 1~19.
   */
  public static char convertSgfXPositionToSgfChar(int xPosition) {
    assert xPosition >= 1 && xPosition <= 19;

    return (char) (xPosition - 1 + FIRST_LOWER_CASE_CHAR);
  }

  /**
   * Returns s~a for 1~19.
   */
  public static char convertSgfYPositionToSgfChar(int yPosition, int boardSize) {
    assert yPosition >= 1 && yPosition <= 19;
    assert Utils.isValidBoardSize(boardSize);

    return (char) (boardSize - yPosition + FIRST_LOWER_CASE_CHAR);
  }

  @Nullable public static Coord readFromStringIfAny(
      @Nonnull String boardInput,
      @Nonnull CoordBoard coordBoard,
      char targetChar) {
    int boardSize = VisualBoard.getBoardSizeFromBoardInput(boardInput);
    for (int i = 1; i <= boardSize; i++) {
      for (int j = 1; j <= boardSize; j++) {
        int indexInString = boardSize * (boardSize - j) + i - 1;
        char positionChar = boardInput.charAt(indexInString);
        if (positionChar == targetChar) {
          Coord coord = coordBoard.getCoord(i, j);
          return coord;
        }
      }
    }
    return null;
  }

  public static ImmutableSet<Coord> readCoordsFromString(
      @Nonnull String boardInput, @Nonnull CoordBoard coordBoard, char targetChar) {
    int boardSize = VisualBoard.getBoardSizeFromBoardInput(boardInput);
    ImmutableSet.Builder<Coord> coordsBuilder = ImmutableSet.builder();
    for (int i = 1; i <= boardSize; i++) {
      for (int j = 1; j <= boardSize; j++) {
        int indexInString = boardSize * (boardSize - j) + i - 1;
        char positionChar = boardInput.charAt(indexInString);
        if (positionChar == targetChar) {
          Coord coord = coordBoard.getCoord(i, j);
          coordsBuilder.add(coord);
        }
      }
    }
    ImmutableSet<Coord> coords = coordsBuilder.build();
    return coords;
  }

  private final int xPosition;
  private final int yPosition;
  private final int hashCode;

  /**
   * Used by {@link CoordBoard#CoordBoard} only (plus testing code).
   */
  public Coord(int xPosition, int yPosition) {
    assert xPosition >= 0 && xPosition <= 20
        && yPosition >= 0 && yPosition <= 20;
    this.xPosition = xPosition;
    this.yPosition = yPosition;
    // Note, there could be walls, so we need to use 21 to avoid collision.
    // Make hashCode to be positive to minimize affecting other depending object's hash code.
    hashCode = xPosition * 21 + yPosition + 1;
  }

  public int getXPosition() {
    return xPosition;
  }

  public int getYPosition() {
    return yPosition;
  }

  /**
   * Converts to a short String as a segment in a SearchPath.
   * Its format must be compact.
   * Format:
   *   for black - [A-S][A-S]
   *   for white - [a-s][a-s]
   *   for black pass - ZZ
   *   for white pass - zz
   * Example 1 for coord = (0, 3) of Black => segment = "AD".
   * Example 2 for coord = (17, 18) of white => segment = "rs".
   * Note, no skipping of "I" or "i".
   */
  public String toSearchPathSegment(boolean isBlack) {
    char charBase = isBlack ? FIRST_UPPER_CASE_CHAR : FIRST_LOWER_CASE_CHAR;
    StringBuilder sb = new StringBuilder();
    sb.append((char) (xPosition - 1 + charBase)).append((char)(yPosition - 1 + charBase));
    return sb.toString();
  }

  public JsonObject toJsonObject() {
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty(JSON_PROPERTY_X_POSITION, xPosition);
    jsonObject.addProperty(JSON_PROPERTY_Y_POSITION, yPosition);
    return jsonObject;
  }

  public String toGtpVertexString() {
    String xVertex = Coord.convertPositionToGtpXLowerCaseString(this.xPosition);
    String yVertex = Coord.convertPositionToGtpYLowerCaseString(this.yPosition);
    return xVertex + yVertex;
  }

  @Override public int hashCode() {
    return hashCode;
  }

  @Override public boolean equals(@Nullable Object other) {
    if (this == other) {
      return true;
    }
    if (other == null) {
      return false;
    }
    assert(other instanceof Coord);
    Coord otherCoord = (Coord) other;
    return hashCode == otherCoord.hashCode;
  }

  @Override public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append('(').append(xPosition).append(',').append(' ').append(yPosition).append(')');
    return sb.toString();
  }
}
