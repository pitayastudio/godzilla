package com.pitayastudio.godzilla.common;

import javax.annotation.Nonnull;

/**
 * Color. Only 2 types of colors: Black and White.
 *
 * <p>"Current color" and "next color" are used when talking about moves.
 *
 * <p>"Buddy color" and "foe color" are used when talking about neighborhoods.
 */
public enum Color {
  B(PositionState.BLACK, "Black"),
  W(PositionState.WHITE, "White");

  public static Color instanceOf(@Nonnull String colorString) throws InvalidColorException {
    String colorStringLowerCase = colorString.toLowerCase();
    if (colorStringLowerCase.equals("black") || colorStringLowerCase.equals("b")) {
      return B;
    } else if (colorStringLowerCase.equals("white") || colorStringLowerCase.equals("w")) {
      return W;
    } else {
      throw new InvalidColorException("Invalid colorString: " + colorString);
    }
  }

  // Note: When Color has an attribute of PositState, and PositState cannot have an attribute of
  // Color. Otherwise, there will be a hard-to-detect flaky error of cyclic dependency during
  // initialization of both enums.
  // In short, the dependency between Color and PositState must be one-way.
  private final PositionState positionState;
  private final String fullName;

  private Color(@Nonnull PositionState positionState, @Nonnull String fullName) {
    this.positionState = positionState;
    this.fullName = fullName;
  }

  public PositionState getPositionState() {
    return positionState;
  }

  public String getFullName() {
    return fullName;
  }

  public Color swap() {
    return (this == B) ? W : B;
  }

  public static class InvalidColorException extends Exception {
    private static final long serialVersionUID = 1L;

    public InvalidColorException(String message) {
      super(message);
    }
  }
}
