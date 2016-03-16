package com.pitayastudio.godzilla.modelboard;

import com.google.common.base.Stopwatch;

import com.pitayastudio.godzilla.common.Color;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Based on the result of performance tests, it takes ~30 ms to construct a {@link AnalyzerBoard}.
 * That means we can construct 1,000 instances of {@link AnalyzerBoard} in 30 seconds.
 *
 */
public class AnalyzerBoardPerformanceTest extends TestCase {

  private static boolean printOutput = false;

  private static void testing(String boardInput) {
    Stopwatch stopwatch = Stopwatch.createStarted();
    Color buddyColor = Color.B;
    BlockBoard blockBoard = BlockBoard.readFromString(boardInput);
    long elapsedMillisForBlockBoard = stopwatch.elapsed(TimeUnit.MILLISECONDS);
    AnalyzerBoard analyzerBoard = AnalyzerBoard.newBuilder()
        .setRequiredBlockBoardAfterMove(blockBoard)
        .setColorOfLatestMoveThatRendersThisBoard(buddyColor)
        .build();
    stopwatch.stop(); // optional
    long elapsedMillisForTotal = stopwatch.elapsed(TimeUnit.MILLISECONDS);
    if (printOutput) {
      System.out.println("elapsed time milli-seconds for block board: "
          + elapsedMillisForBlockBoard);
      System.out.println("elapsed time milli-seconds for total: " + elapsedMillisForTotal);
    }
    assertEquals(boardInput, analyzerBoard.toString().replaceAll("\n", ""));
  }

  // Note! The first time running a test will take longer time.
  // I guess it is for initialization.

  @Test public void test_01() {
    testing(
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦");
  }

  @Test public void test_02() {
    String boardInput =
        "◦◦○●●◦◦◦◦●●●●○◦◦○◦◦"
      + "◦◦○●◦●●●◦●○●●○○◦◦○○"
      + "◦◦○○●●○●●○○○●●○○○●○"
      + "◦◦◦●○◦○●○○◦○○○●●○●●"
      + "◦○○○○◦○●●○◦◦◦○●●●◦●"
      + "○◦○●○◦◦○○○◦◦○○○○●●◦"
      + "○○●●●●●●●●○○○○●●◦◦◦"
      + "○●●◦○●◦●○○◦◦○●◦◦◦◦◦"
      + "●●●○○○○●○◦◦●○●◦◦●●●"
      + "◦●○○●●○○○○○○●◦◦◦●○●"
      + "●●●○●○○●●●●●◦◦◦◦●○○"
      + "●○●●●◦○●◦○◦◦◦●●●○○◦"
      + "○○○●●●●◦●◦◦●◦●○●○●○"
      + "○○●●◦◦●◦◦○◦◦●○○●●○○"
      + "◦○○●●●◦◦◦●●●○◦◦○●○●"
      + "◦◦○●◦●◦●●○○○○○○○●●●"
      + "◦○◦○○●●○○◦○◦●◦◦◦○○○"
      + "◦◦◦○●●●○○◦○◦◦◦◦○◦◦◦"
      + "◦◦◦○○●●●○○◦◦◦◦◦◦◦◦◦";
    for (int i = 0; i < 3; i++) {
      testing(boardInput);
    }
  }
}
