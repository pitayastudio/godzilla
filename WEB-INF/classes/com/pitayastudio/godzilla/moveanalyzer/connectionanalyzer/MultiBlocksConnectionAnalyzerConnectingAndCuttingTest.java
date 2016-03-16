package com.pitayastudio.godzilla.moveanalyzer.connectionanalyzer;

import org.junit.Test;

public class MultiBlocksConnectionAnalyzerConnectingAndCuttingTest
    extends MultiBlocksConnectionAnalyzerTest {

  private static void testing(String boardInput) {
    boolean hasConnecting = true;
    boolean hasCutting = true;
    testing(boardInput, hasConnecting, hasCutting);
  }

  @Test public void test_02() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◆○◦◦◦"
      + "◦●●◦◆◦○◦◦"
      + "◦○◦◦◆◦◦◦◦"
      + "◦◦◦◦◆◦◇◦◦"
      + "◦○◦◦◦A◦◇◦"
      + "◦◦○◦◇◦◆◇◦"
      + "◦◦◦◦◇◆◦●◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////
  // Side effect - Kill

  @Test public void test_04() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦"
      + "◦◦◦○◦◦●●◦"
      + "◦◦◦◦◦◆◦◦◦"
      + "◦◦◦◇◇A◇◇◦"
      + "◦◦◆◆◆◦◆◇◦"
      + "◦◦◦◦◦◦◆◦◦"
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
      + "◇A◆◇◆◦◦◦◦";
    testing(boardInput);
  }
}
