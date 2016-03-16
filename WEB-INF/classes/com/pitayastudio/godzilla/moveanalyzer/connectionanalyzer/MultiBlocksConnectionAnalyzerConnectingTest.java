package com.pitayastudio.godzilla.moveanalyzer.connectionanalyzer;

import org.junit.Test;

public class MultiBlocksConnectionAnalyzerConnectingTest
    extends MultiBlocksConnectionAnalyzerTest {

  private static void testing(String boardInput) {
    boolean hasConnecting = true;
    boolean hasCutting = false;
    testing(boardInput, hasConnecting, hasCutting);
  }

  @Test public void test_07() {
    testing(
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦"
      + "◦◦◦○◦○◦◦◦"
      + "◦◦◆◆◦◆○◦◦"
      + "◦◦◦◦◦A◆◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void test_08() {
    testing(
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦"
      + "◦◦◦◆◦○◦◦◦"
      + "◦◦◦◦A◆○◦◦"
      + "◦◦◦◦◦◦◆◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void test_3Blocks_byEating_01() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦"
      + "◦◦◦◦◦○◆◦◦"
      + "◦◦◦◦●○◆◦◦"
      + "◦◦◦●◦◆○◆◦"
      + "◦◦◦◦◦◦A◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_3Blocks_byEating_02() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦"
      + "◦◦○◦◆◆○◦◦"
      + "◦○◦○◆◆○●◦"
      + "◦◦○A○○◆◦●"
      + "◦◦○◦◆◆○●◦"
      + "◦◦○◦◦◆○◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_3Blocks_byEating_03() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○○○◦◦"
      + "◦◦◦◦A○◆◦◦"
      + "◦◦◦◆○◆◆◦◦"
      + "◦○◦◆○◆◦◦◦"
      + "◦◦○○◆◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_4Blocks_01() {
   String boardInput =
       "◦◦◦◦◆◦◦◦◦"
     + "◦◦◦◦◆◦◦◦◦"
     + "◦◦◦◦◆◦◦◦◦"
     + "◦◦◦◦◆◦◦◦◦"
     + "◆◆◆◆A◆◆◆◆"
     + "○○○○◆○○○○"
     + "◦◦◦○◆○◦◦◦"
     + "◦◦◦○○○◦◦◦"
     + "◦◦◦◦◦◦◦◦◦";
   testing(boardInput);
  }

  @Test public void test_4Blocks_02() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦●◦◦◦○◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦●●◦◦○◦◦"
      + "◦◦◦◦○○◦◦◦"
      + "◦◦●●○◆○○◦"
      + "○◦●◦◆A◆◆◆"
      + "◦○○◦○◆○○○"
      + "◦◦◦◦○○◦◦◦";
    testing(boardInput);
  }

  @Test public void test_5Blocks_byEating_01() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○◆◦◦◦"
      + "◦◦◦◆○◆○○◦"
      + "◦◦◆○A○◆◦◦"
      + "◦○◦◆○◆◆◦◦"
      + "◦◦○◦○◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////
  // Zhengxing

  @Test public void test_zhengxing_03() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◆◦A◦"
      + "◦◦◦◦◦○◆◦◦"
      + "◦◦◦○◦○○◆◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_zhengxing_04() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○○◦"
      + "◦◦◦◦◦◦○◆◦"
      + "◦◦◦◦◦●○◆◦"
      + "◦◦◦◦○○◆◦◦"
      + "◦◦◦◦○◆◦A◦"
      + "◦◦◦◦◦◆◦◦◦";
    testing(boardInput);
  }

  @Test public void test_zhengxing_09() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◆◦○◦◦"
      + "◦◦◦○◆◦A◦◦"
      + "◦◦◦◦○◆◦◦◦"
      + "◦◦◦◦○○◆◆◦"
      + "◦◦◦◦◦◦○○◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_zhengxing_11() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦○○●◦"
      + "◦◦◦◦A◦◆◦◦"
      + "◦◦◆◦◆◦◆◦◦"
      + "◦◦◦◦◦○○●◦"
      + "◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_zhengxing_12() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◆◆○◦◦"
      + "◦◦◦◦◦◦○◦◦"
      + "◦◦◦○A◆○◦◦"
      + "◦◦○◦◦◦○◦◦"
      + "◦◦○◦◆◆○◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_zhengxing_14() {
    String boardInput =
        "◦◦◦◦◦◦◦○◦"
      + "◦◦◦◦○◦◦◦◦"
      + "◦◦◦◦◦◦○○◦"
      + "◦◦◦◦◦◆○◆◦"
      + "◦◦◆◦A◦◆◆◦"
      + "◦○◆◦○◦○○◦"
      + "◦◦◆◦◦◦◦◦◦"
      + "◦◦◦●○◦○○◦"
      + "◦◦◦◦○◦◦◦◦";
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
      + "◆A◆◦◦◦◦◦◦";
    testing(boardInput);
  }
}
