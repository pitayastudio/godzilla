package com.pitayastudio.godzilla.moveanalyzer.connectionanalyzer;

import org.junit.Test;

public class TwoBlocksConnectionAnalyzerConnectingAndCuttingTest
    extends TwoBlocksConnectionAnalyzerTest {

  private static void testing(String boardInput) {
    boolean hasConnecting = true;
    boolean hasCutting = true;
    testing(boardInput, hasConnecting, hasCutting);
  }

  @Test public void test_01() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◆◦◦◦◦"
      + "◦◦◦◇A◇◦◦◦"
      + "◦◦◦◦◆◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
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
      + "●A◆◇◆◇◦◦◦";
    testing(boardInput);
  }
}
