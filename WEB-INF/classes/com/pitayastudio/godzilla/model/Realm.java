package com.pitayastudio.godzilla.model;

import com.google.common.collect.ImmutableSet;

import java.util.logging.Logger;

import javax.annotation.Nonnull;

/**
 * TODO 300 Implement {@link Realm}.
 *
 * @see DesignDoc#realm()
 */
public class Realm extends VacantBlock {
  @SuppressWarnings("unused")
  private static final Logger logger = Logger.getLogger(Realm.class.getName());

  public Realm(int boardSize, @Nonnull ImmutableSet<Coord> coords) {
    super(boardSize, coords);
  }
}
