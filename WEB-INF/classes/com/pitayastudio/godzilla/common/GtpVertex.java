package com.pitayastudio.godzilla.common;

import com.pitayastudio.godzilla.model.Coord;

import java.util.logging.Logger;

import javax.annotation.Nonnull;

/**
 * Defined by GTP. It means either a {@Coord} or a PASS.
 *
 * <p>Sample values:
 * <ul>
 *   <li>pass
 *   <li>A1
 *   <li>T19
 * </ul>
 */
public class GtpVertex {
  @SuppressWarnings("unused")
  private static final Logger logger = Logger.getLogger(GtpVertex.class.getName());

  public static final String VERTEX_PASS = "pass";
  private static final int POSITION_FOR_PASS = -1;

  public static GtpVertex instanceOf(@Nonnull String vertexString)
      throws InvalidVertexException {
    String vertexStringLowerCase = vertexString.toLowerCase();

    // Handle PASS.
    if (vertexStringLowerCase.equals(VERTEX_PASS)) {
      return new GtpVertex(vertexStringLowerCase, true, POSITION_FOR_PASS, POSITION_FOR_PASS);
    }

    // Handle regular move coordinate.
    int lengthOfVertexString = vertexStringLowerCase.length();
    if (lengthOfVertexString < 2 || lengthOfVertexString > 3) {
      throw new InvalidVertexException("Invalid vertex: '" + vertexString + "'");
    }
    char xPositionChar = vertexStringLowerCase.charAt(0);
    int xPosition = Coord.convertGtpXCharToPosition(xPositionChar);
    String yPositionString = vertexStringLowerCase.substring(1);
    int yPosition = Coord.convertGtpYStringToPosition(yPositionString);
    return new GtpVertex(vertexStringLowerCase, false, xPosition, yPosition);
  }

  private final String vertexStringLowerCase;
  private final boolean isPass;
  private final int xPosition;
  private final int yPosition;

  private GtpVertex(
      @Nonnull String vertexStringLowerCase, boolean isPass, int xPosition, int yPosition) {
    assert isPass
        ? xPosition == POSITION_FOR_PASS && yPosition == POSITION_FOR_PASS
        : xPosition >= 1 && xPosition <= 19 && yPosition >= 1 && yPosition <= 19;
    this.vertexStringLowerCase = vertexStringLowerCase;
    this.isPass = isPass;
    this.xPosition = xPosition;
    this.yPosition = yPosition;
  }

  public String getVertexStringLowerCase() {
    return vertexStringLowerCase;
  }

  public boolean isPass() {
    return isPass;
  }

  public int getXPosition() {
    return xPosition;
  }

  public int getYPosition() {
    return yPosition;
  }

  @Override public String toString() {
    return vertexStringLowerCase;
  }

  public static class InvalidVertexException extends Exception {
    private static final long serialVersionUID = 1L;

    public InvalidVertexException(String message) {
      super(message);
    }
  }
}
