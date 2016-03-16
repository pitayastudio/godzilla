package com.pitayastudio.godzilla.moveanalyzer.connectionanalyzer;

import org.junit.Test;

public class MultiBlocksConnectionAnalyzerCuttingTest
    extends MultiBlocksConnectionAnalyzerTest {

  private static void testing(String boardInput) {
    boolean hasConnecting = false;
    boolean hasCutting = true;
    testing(boardInput, hasConnecting, hasCutting);
  }

  @Test public void test_02() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦●◦◦◦◦◦"
      + "◦◦◇A◇◦●◦◦"
      + "◦◦◦◇●●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_03() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦●◦◦"
      + "◦◦◦●●◦◦◦◦"
      + "◦◦◇●◇◇◦◦◦"
      + "◦◇◦A◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_04() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◇●◇◦◦"
      + "◦◦◦◦◇A◦◇◦"
      + "◦◦◦●◇●◦◦◦"
      + "◦◦◦◦●●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////
  // Multiple answers.

  @Test public void test_multiAnswers_14() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦●●◦◦◦◦"
      + "◦◇◦●◇◦◦◦◦"
      + "◦◦◇●◇◦◦◦◦"
      + "◦◦CAB◦◦◦◦";
    testing(boardInput);
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////
  // Side effect - Kill

  @Test public void test_00() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦●◦◦"
      + "◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦●◇◦◦"
      + "◦◦◦◇◦A◇◦◦"
      + "◦○◦◦◇◦◦●◦"
      + "◦◦◦◦◦◦●◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_01() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◇●●◦◦"
      + "◦◦◦◇A◇◦●◦"
      + "◦◦◦◦●◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_05() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◇◇◇◦◦◦◦"
      + "◦◦●●◇●◦◦◦"
      + "◦◦●◦A◇●◦◦"
      + "◦◦●◇◇●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_4Blocks_01() {
   String boardInput =
       "◦◦◦◦●◦◦◦◦"
     + "◦◦◦◦●◦◦◦◦"
     + "◦◦●●●●●◦◦"
     + "◇◇◇◇●◇◇◇◇"
     + "●●●●A●●●●"
     + "◇◇◇◇●◇◇◇◇"
     + "◦◦◦◇●◇◦◦◦"
     + "◦◦◦◇◇◇◦◦◦"
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
      + "◇A◇◦◦◦◦◦◦";
    testing(boardInput);
  }
}
