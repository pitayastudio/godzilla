package com.pitayastudio.godzilla.endgame;

import javax.annotation.Nonnull;

public class EndGameException extends Exception {
  private static final long serialVersionUID = 1L;

  public static final String ERROR_INVALID_MUTUAL_LIVE = "Error: Invalid Seki";

  public EndGameException(@Nonnull String message) {
    super(message);
  }
}
