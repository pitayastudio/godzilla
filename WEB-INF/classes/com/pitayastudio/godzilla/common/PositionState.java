package com.pitayastudio.godzilla.common;

public enum PositionState {
  BLACK(false),
  WHITE(false),
  VACANT(true),
  /** WALL is treated as non-VACANT */
  WALL(false);

  private final boolean isVacant;

  private PositionState(boolean isVacant) {
    this.isVacant = isVacant;
  }

  public boolean isVacant() {
    return isVacant;
  }
}
