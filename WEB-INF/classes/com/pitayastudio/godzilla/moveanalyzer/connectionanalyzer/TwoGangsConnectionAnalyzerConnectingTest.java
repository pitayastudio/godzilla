package com.pitayastudio.godzilla.moveanalyzer.connectionanalyzer;

import org.junit.Test;

public class TwoGangsConnectionAnalyzerConnectingTest
    extends TwoGangsConnectionAnalyzerTest{

  private static void testing(String boardInput) {
    boolean hasConnecting = true;
    boolean hasCutting = false;
    testing(boardInput, hasConnecting, hasCutting);
  }

  @Test public void test_13() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○◦◦◦"
      + "◦◦◦◦●○◆◦◦"
      + "◦◦◦◦●A◦◆◦"
      + "◦◦◦○●○◦◦◦"
      + "◦◦◦◦○○◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_3Blocks_01() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦●○○◦◦"
      + "◦◦◦●A◆◦○◦"
      + "◦◦◦◦○◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_3Blocks_02() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◆◦"
      + "◦◦◦◦○○○A◦"
      + "◦◦◦◦○●●◦◦"
      + "◦◦◦◦◦◦◦●◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_template() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "●A◆◦◦◦◦◦◦";
    testing(boardInput);
  }
}
