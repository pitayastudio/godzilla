package com.pitayastudio.godzilla.model;

import com.google.common.collect.ImmutableSet;

import com.pitayastudio.godzilla.common.PositionState;
import com.pitayastudio.godzilla.common.Utils;

import java.util.Objects;
import java.util.logging.Logger;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * TODO 100 Evaluate to store Block as a bitmap (instead of a set of pairs of int's)?
 *      That would need 361 + 2 (for vacant/color) bits.
 *      Each char is 16 bits, each int is 32 bits. So we need 23 chars to store a Block.
 * TODO 100 Evaluate to store Block.coords as a List instead of a Set.
 * TODO 100 Should the coords in a block be sorted, so that it is faster to compare 2 blocks?
 * @see DesignDoc#block
 */
public abstract class Block {
  @SuppressWarnings("unused")
  private static final Logger logger = Logger.getLogger(Block.class.getName());

  public static Builder newBuilder() {
    return new Builder();
  }

  private final PositionState positionState;

  /** Useful for drawing Block for debugging. */
  protected final int boardSize;

  private final ImmutableSet<Coord> coords;

  Block(@Nonnull PositionState positionState, int boardSize, @Nonnull ImmutableSet<Coord> coords) {
    this.positionState = positionState;
    this.boardSize = boardSize;
    this.coords = coords;
  }

  public ImmutableSet<Coord> getCoords() {
    return coords;
  }

  public int size() {
    return coords.size();
  }

  // TODO 100 Improve hash code for Block.
  @Override public int hashCode() {
    //logger.info("Entering Block.hashCode()");
    int hashCode = coords.hashCode();
    hashCode <<= 2;
    hashCode += this.positionState.ordinal();
    return hashCode;
  }

  @Override public boolean equals(@Nullable Object obj) {
    //logger.info("Entering Block.equals()");
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    assert(obj instanceof Block);
    Block other = (Block) obj;
    return Objects.equals(coords, other.coords);
  }

  public static class Builder {
    /** Used for determining if this should be a vacant, black, or white block. */
    private PositionState positionState;
    private int boardSize;
    private final ImmutableSet.Builder<Coord> coordsBuilder = ImmutableSet.builder();

    private Builder() {}

    public Builder setRequiredPositState(@Nonnull PositionState positionState) {
      this.positionState = positionState;
      return this;
    }

    public Builder setRequiredBoardSize(int boardSize) {
      assert(Utils.isValidBoardSize(boardSize));
      this.boardSize = boardSize;
      return this;
    }

    public Builder addCoord(@Nonnull Coord coord) {
      coordsBuilder.add(coord);
      return this;
    }

    public Builder addAllCoords(@Nonnull Iterable<Coord> coords) {
      this.coordsBuilder.addAll(coords);
      return this;
    }

    public Block build() {
      assert positionState == PositionState.VACANT
          || positionState == PositionState.BLACK
          || positionState == PositionState.WHITE
          : "Invalid positionState: " + positionState;
      assert(Utils.isValidBoardSize(boardSize));

      ImmutableSet<Coord> coords = coordsBuilder.build();
      assert coords.size() > 0;
      if (positionState == PositionState.VACANT) {
        return new VacantBlock(boardSize, coords);
      } else {
        return new ColorBlock(positionState, boardSize, coords);
      }
    }
  }
}
