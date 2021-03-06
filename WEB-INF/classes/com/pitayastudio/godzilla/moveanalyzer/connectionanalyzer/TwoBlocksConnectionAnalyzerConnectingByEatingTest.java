package com.pitayastudio.godzilla.moveanalyzer.connectionanalyzer;

import org.junit.Test;

public class TwoBlocksConnectionAnalyzerConnectingByEatingTest
    extends TwoBlocksConnectionAnalyzerTest {

  private static void testing(String boardInput) {
    boolean hasConnecting = true;
    boolean hasCutting = false;
    testing(boardInput, hasConnecting, hasCutting);
  }

  @Test public void test_02() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦"
      + "◦◦◦◦○◦○◦◦"
      + "◦◦◦◦◦◆◆○◦"
      + "◦◦◦○◦◆○A◦"
      + "◦◦◦◦○○◆◆◦"
      + "◦◦◦◦◦●◦◆◦"
      + "◦◦◦◦◦◦●◦◦";
    testing(boardInput);
  }


  @Test public void test_06() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○◦◦◦"
      + "◦◦◦◦◦◦○◦◦"
      + "◦◦◦◦○○◆◆◦"
      + "◦◦◦○◆◆○◆◦"
      + "◦◦◦◦○◆○◆◦"
      + "◦◦◦◦◦◦A◦◦";
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
      + "●A◆◦◆◦◦◦◦";
    testing(boardInput);
  }
}
