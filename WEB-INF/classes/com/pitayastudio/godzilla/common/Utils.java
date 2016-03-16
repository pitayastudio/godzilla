package com.pitayastudio.godzilla.common;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

public class Utils {

  public static <T> List<List<T>> copyAsMutableListList(
      @Nonnull ImmutableList<ImmutableList<T>> oldImmutableListList) {
    List<List<T>> newListList = new ArrayList<>();
    for (List<T> oldList : oldImmutableListList) {
      List<T> newList = Lists.newArrayList(oldList);
      newListList.add(newList);
    }
    return newListList;
  }

  public static boolean isValidBoardSize(int boardSize) {
    return boardSize == 3 || boardSize == 5 || boardSize == 7
        || boardSize == 9 || boardSize == 11 || boardSize == 13 || boardSize == 19;
  }

  /**
   * Prints spent-time when spent-time > profileBarForSpentTimeMs since startNanoTime.
   * Returns current time in nano sec.
   */
  public static long profile(
      long startNanoTime, long profileBarForSpentTimeMs, @Nonnull String sourceCode) {
    long currentNanoTime = System.nanoTime();
    long spentMsTime = (currentNanoTime - startNanoTime) / 1_000_000;  // ms
    // TODO 200 Lower max allowed spentMsTime in Utils.profile().
    // For locating bottleneck of performance, use spentMsTime > 5.
    if (spentMsTime > profileBarForSpentTimeMs) {
      System.out.println("spent-time (ms) for [" + sourceCode + "]: " + spentMsTime);
    }
    return currentNanoTime;
  }

  /**
   * Prints spent-time when spent-time > max since startNanoTime.
   * Returns current time in nano sec.
   */
  public static long profile(long startNanoTime, @Nonnull String sourceCode) {
    return profile(startNanoTime, Flags.PROFILE_BAR_FOR_SPENT_TIME_MS, sourceCode);
  }
}
