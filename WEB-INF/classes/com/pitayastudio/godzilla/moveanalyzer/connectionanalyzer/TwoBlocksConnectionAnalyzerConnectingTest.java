package com.pitayastudio.godzilla.moveanalyzer.connectionanalyzer;

import org.junit.Test;

public class TwoBlocksConnectionAnalyzerConnectingTest
  extends TwoBlocksConnectionAnalyzerTest {

  private static void testing(String boardInput) {
    boolean hasConnecting = true;
    boolean hasCutting = false;
    testing(boardInput, hasConnecting, hasCutting);
  }

  @Test public void test_01() {
    testing(
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◆◦◦◦◦"
      + "◦◦◦○A○◦◦◦"
      + "◦◦◦◦◆◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void test_02() {
    testing(
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦A◆◦◦◦"
      + "◦◦◦◦◆○◦◦◦"
      + "◦◦◦◦◦○◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void test_04() {
    testing(
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦○◦◆◦◦◦◦◦"
      + "◦◦A◦◦◦◦◦◦"
      + "◦◆◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void test_05() {
    testing(
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◆◦◦"
      + "◦◦◦◦◦◦◦A◦"
      + "◦◦◦◦◦◦○◆◦"
      + "◦◦◦◦◦◦◦○◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void test_06() {
    testing(
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦"
      + "◦◦◦◦◦○◆◦◦"
      + "◦◦◦◦◦◦A◦◦"
      + "◦◦◦◦◦◆◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦");
  }

  @Test public void test_09() {
    testing(
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦●◦◦"
      + "◦◦◦◦◦◆◦◦◦"
      + "◦◦○○○◆◦◦◦"
      + "◦◦◦◆○◆◦◦◦"
      + "◦◦◦◆A◦◦◦◦");
  }

  @Test public void test_10() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦○◦◦◦◦○◦◦"
      + "◦◦◦○○◦◦◦◦"
      + "◦◆◆○◆◆◦◦◦"
      + "◦◦◦A◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_11() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦○◦◦◦◦○◦◦"
      + "◦◦◦○○◦◦◦◦"
      + "◆◆◆○◆◆◆◆◆"
      + "◦◦◦A◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_12() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◆◦◦"
      + "◦◦◦◦○○A◦◦"
      + "◦○◦◦○◆◦◦◦"
      + "◦◦◦◦◦◆◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_zhengxing_01() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◆○○◦◦"
      + "◦◦◦A◦◆○◦◦"
      + "◦◦◦◦◦◆○◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_zhengxing_02() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◆○○○◦◦"
      + "◦◦A◦◆◆○◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_zhengxing_05() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦"
      + "◦◦◦◦◆A◦◦◦"
      + "◦○◦○◦◦○◦◦"
      + "◦◦◦○◆◆○◦◦"
      + "◦◦◦◦◦◦●○◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_zhengxing_06() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦●◦◦A◆◆◦◦"
      + "◦●◦○◦◦○◦◦"
      + "◦◦◦○◆◆○◦◦"
      + "◦◦●●○○◦○◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_zhengxing_07() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦"
      + "◦◦◦◦◆◦◆○◦"
      + "◦◦○◦A◦◆○◦"
      + "◦◦◦○◦○○●◦"
      + "◦◦◦◦◦◦●◦●"
      + "◦◦◦◦◦◦◦●◦";
    testing(boardInput);
  }

  @Test public void test_zhengxing_10() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦A◦◦"
      + "◦◦◦◦◦◆◦◦◦"
      + "◦◦◦◦○○◆◦◦"
      + "◦◦○◦○◆◆◦◦"
      + "◦●◦◦●○○○◦"
      + "◦●●◦●○◦○◦"
      + "◦◦◦◦●●○◦◦";
    testing(boardInput);
  }

  @Test public void test_zhengxing_13() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦○◦○◦○◦○"
      + "◦◦◦◦◦A◦◦◦"
      + "◦◦◦◦◦◦◆◆◦"
      + "◦◦◦◦◆◆○◆◦"
      + "◦◦●◦◦◦○○◦"
      + "◦◦◦◦○◦○◦◦"
      + "◦◦◦◦◦◦◦○◦";
    testing(boardInput);
  }

  @Test public void test_zhengxing_15() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦A◦◦◦○◦"
      + "◦◦◦◦◦◆◆◆○"
      + "◦◦◦◦◆○○◆○"
      + "◦◦◦◦◆○◦○○"
      + "◦◦◦◦◦◦○◦◦";
    testing(boardInput);
  }

  @Test public void test_zhengxing_16() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○◦◦○◦"
      + "◦◦◦◦◆○◦◦◦"
      + "◦◦◦◦◆○◦○◦"
      + "◦◦◦A◦◆◆○◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦";
    testing(boardInput);
  }

  @Test public void test_zhengxing_17() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦"
      + "◦◦◦A◦◦◦◦◦"
      + "◦◦◦◦◦◆◆◆◦"
      + "◦◦◦◦◆○○◆◦"
      + "◦◦◦◦◆○◦○◦"
      + "◦◦◦◦◆○○◦◦"
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
      + "●A◆◦◆◦◦◦◦";
    testing(boardInput);
  }
}
