package com.pitayastudio.godzilla.common;

import com.pitayastudio.godzilla.computerplayer.MoveEngine;

public class Flags {
  public static final MoveEngine.Type MOVE_ENGINE_TYPE = MoveEngine.Type.MCTS;

  /**
   * 5 for profiling.
   * 500 for regular execution.
   */
  public static final int PROFILE_BAR_FOR_SPENT_TIME_MS = 500;

  /**
   * Note: With the default eclipse settings, the program hangs when
   * {@link #MAX_MCTS_SIMULATIONS_COUNT} is big.
   * This hanging issue can be lifted by adding Java VM arguments:
   * -Xms4G -Xmx6G
   * where -Xms specifies the initial memory allocation pool,
   * and -Xmx specifies the maximum memory allocation pool for a JVM.
   *
   * <p>
   * Value = 150 for regular execution.
   * Value = 2 for development and quick testing.
   */
  public static final int MAX_MCTS_SIMULATIONS_COUNT = 2;
}
