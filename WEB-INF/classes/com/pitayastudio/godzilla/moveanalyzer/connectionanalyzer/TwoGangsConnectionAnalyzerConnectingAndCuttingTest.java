package com.pitayastudio.godzilla.moveanalyzer.connectionanalyzer;

import org.junit.Test;

public class TwoGangsConnectionAnalyzerConnectingAndCuttingTest
    extends TwoGangsConnectionAnalyzerTest{

  private static void testing(String boardInput) {
    boolean hasConnecting = true;
    boolean hasCutting = true;
    testing(boardInput, hasConnecting, hasCutting);
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////
  // Side effect - Kill

  @Test public void test_03() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◇◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦●◦◇◦◦"
      + "◦◦◦◦◦●◦◇◦"
      + "◦◦◦◦●◦◦◇◇"
      + "◦◦◦●◦◦A◦◇"
      + "◦●◦●●○◦◆◇"
      + "◦◦◦○○○◦◆◇";
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
      + "A●○◆◇◦◦◦◦";
    testing(boardInput);
  }
}
