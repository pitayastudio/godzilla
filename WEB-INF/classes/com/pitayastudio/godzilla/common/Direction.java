package com.pitayastudio.godzilla.common;

public enum Direction {
  RIGHT(1, 0),
  LEFT(-1, 0),
  UP(0, 1),
  DOWN(0, -1);

  private final int xIncrement;
  private final int yIncrement;

  private Direction(int xIncrement, int yIncrement) {
    this.xIncrement = xIncrement;
    this.yIncrement = yIncrement;
  }

  public int getXIncrement() {
    return xIncrement;
  }

  public int getYIncrement() {
    return yIncrement;
  }
}
