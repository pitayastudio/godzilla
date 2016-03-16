package com.pitayastudio.godzilla.model;

import com.google.common.collect.ImmutableSet;

import com.pitayastudio.godzilla.common.PositionState;

/**
 * Used for design doc. It is not actually used.
 *
 * @see DesignDoc#block
 */
public abstract class PrisonerBlock extends ColorBlock {
  PrisonerBlock(PositionState positionState, int boardSize, ImmutableSet<Coord> coords) {
    super(positionState, boardSize, coords);
  }

  public abstract class InternallyEnclosedPrisonerBlock extends PrisonerBlock {
    InternallyEnclosedPrisonerBlock(PositionState state, int boSize, ImmutableSet<Coord> coords) {
      super(state, boSize, coords);
    }
  }

  public abstract class ExternallyControlledPrisonerBlock extends PrisonerBlock {
    ExternallyControlledPrisonerBlock(PositionState state, int boSize, ImmutableSet<Coord> coords) {
      super(state, boSize, coords);
    }
  }
}
