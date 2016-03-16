package com.pitayastudio.godzilla.common;

/**
 * Move type enum.
 *
 * <p>These names must be consistent with those defined in godzilla.js.
 */
public enum MoveType {
  MOVE_ERROR_PREV_POSIT_IS_ALREADY_OCCUPIED,
  MOVE_ERROR_JIE_VIOLATION,

  /**
   * (Next move color = Black)
   * <pre>
   * ..................
   * ..○....○○....○○○..
   * .○*○..○●*○..○●*●○.
   * ..○....○○....○○○..
   * ..................
   * </pre>
   */
  MOVE_ERROR_SUICIDE,

  /**
   * (Next move color = Black)
   * <pre>
   * ..............
   * .●*●...●*...*.
   * ..............
   * </pre>
   */
  MOVE_REGULAR,

  /**
   * (Next move color = Black)
   * <pre>
   * ◦◦◦◦◦
   * ◦◦◦◦◦
   * ◦◦◦◦◦
   * ●●◦◦◦
   * *●◦◦◦
   * </pre>
   */
  MOVE_SELF_FILL_ONE_EYE_FOR_ONE_BUDDY_BLOCK,

  /**
   * (Next move color = Black)
   * <pre>
   * .........................
   * ..●....●●....●.●....●○●..
   * .●○*..●○○*..●○*○●..●○*○●.
   * ..●....●●....●.●....●○●..
   * .........................
   * </pre>
   */
  MOVE_EAT_NO_JIE,

  /**
   * (Next move color = Black)
   * <pre>
   * ......
   * ..●○..
   * .●○*○.
   * ..●○..
   * ......
   * </pre>
   */
  MOVE_EAT_CAUSING_JIE,

  MOVE_PASS,

  MOVE_PASS_BEFORE_GAME_START;

  public boolean isIllegalMove() {
    return this == MOVE_ERROR_PREV_POSIT_IS_ALREADY_OCCUPIED
        || this == MOVE_ERROR_JIE_VIOLATION
        || this == MOVE_ERROR_SUICIDE;
  }
}