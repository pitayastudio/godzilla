package com.pitayastudio.godzilla.game;

public enum Command {
  NEW_GAME,
  HUMAN_MOVE,
  HUMAN_PASS,
  UNDO,
  RESIGN,
  PICKUP_DEAD,
  DONE_PICKUP_DEAD,
  SAVE_END_GAME,
  /**
   * Generate computer move.
   */
  GEN_MOVE
}
