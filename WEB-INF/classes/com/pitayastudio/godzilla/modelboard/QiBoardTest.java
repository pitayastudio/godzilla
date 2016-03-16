package com.pitayastudio.godzilla.modelboard;

import com.google.common.collect.ImmutableSet;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.model.ColorBlock;
import com.pitayastudio.godzilla.model.Coord;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class QiBoardTest extends TestCase {

  /**
   * Note: spent-time is bigger when running coverage instead of unit-test.
   */
  private static final int ALLOWED_TIME_MS_FOR_READ_FROM_STRING = 35;

  private static void testGetAllBlocksOfColorWithZeroQi(
      String boardInput,
      int expectedCoutOfBlackBlocksWithZeroQi,
      int expectedCoutOfWhiteBlocksWithZeroQi) {
    QiBoard qiBoard = QiBoard.readFromString(boardInput);
    Set<ColorBlock> blackBlocksWithZeroQi = qiBoard.getAllBlocksOfColorWithZeroQi(Color.B);
    Set<ColorBlock> whiteBlocksWithZeroQi = qiBoard.getAllBlocksOfColorWithZeroQi(Color.W);
    assertEquals(expectedCoutOfBlackBlocksWithZeroQi, blackBlocksWithZeroQi.size());
    assertEquals(expectedCoutOfWhiteBlocksWithZeroQi, whiteBlocksWithZeroQi.size());
  }

  @Test public void testGetAllBlocksOfColorWithZeroQi_01() {
    String boardInput =
        "◦◦◦"
      + "◦◦◦"
      + "◦◦◦";
    testGetAllBlocksOfColorWithZeroQi(boardInput, 0, 0);
  }

  @Test public void testGetAllBlocksOfColorWithZeroQi_02() {
    String boardInput =
        "●●●"
      + "●●●"
      + "●●●";
    testGetAllBlocksOfColorWithZeroQi(boardInput, 1, 0);
  }

  @Test public void testGetAllBlocksOfColorWithZeroQi_03() {
    String boardInput =
        "○○○"
      + "○○○"
      + "○○○";
      testGetAllBlocksOfColorWithZeroQi(boardInput, 0, 1);
  }

  @Test public void testGetAllBlocksOfColorWithZeroQi_04() {
    String boardInput =
        "◦◦◦"
      + "◦●◦"
      + "◦◦◦";
    testGetAllBlocksOfColorWithZeroQi(boardInput, 0, 0);
  }

  @Test public void testGetAllBlocksOfColorWithZeroQi_05() {
    String boardInput =
        "◦●○"
      + "●●○"
      + "○○○";
    testGetAllBlocksOfColorWithZeroQi(boardInput, 0, 1);
  }

  @Test public void testGetAllBlocksOfColorWithZeroQi_06() {
    String boardInput =
        "○○○"
      + "○●○"
      + "○○○";
    testGetAllBlocksOfColorWithZeroQi(boardInput, 1, 1);
  }

  @Test public void testGetAllBlocksOfColorWithZeroQi_07() {
    String boardInput =
        "◦●○●◦"
      + "●●○●●"
      + "○○●○○"
      + "●●○●●"
      + "◦●○●◦";
    testGetAllBlocksOfColorWithZeroQi(boardInput, 1, 4);
  }

  @Test public void testGetAllBlocksOfColorWithZeroQi_08() {
    String boardInput =
        "◦●●○○"
      + "●○○●○"
      + "●◦○●○"
      + "●●○●○"
      + "◦●●●◦";
    testGetAllBlocksOfColorWithZeroQi(boardInput, 0, 0);
  }

  /////////////////////////////////////////////////////////////////////////////////////////////////
  private static void testGetQisCountForBlock(
      String boardInput,
      int xPositionForBlock,
      int yPositionForBlock,
      int expectedQisCount) {
    QiBoard qiBoard = QiBoard.readFromString(boardInput);
    BlockBoard blockBoard = qiBoard.getBlockBoard();
    ColorBlock colorBlock = blockBoard.getColorBlock(xPositionForBlock, yPositionForBlock);
    ImmutableSet<Coord> qiCoords = qiBoard.getAllQiCoordsForColorBlock(colorBlock);
    int qisCount = qiCoords.size();
    assertEquals(expectedQisCount, qisCount);
  }

  @Test public void testGetQisCountForBlock_01() {
    String boardInput =
        "◦◦◦"
      + "◦●◦"
      + "◦◦◦";
    testGetQisCountForBlock(boardInput, 2, 2, 4);
  }

  @Test public void testGetQisCountForBlock_02() {
    String boardInput =
        "◦◦◦"
      + "●◦◦"
      + "◦◦◦";
    testGetQisCountForBlock(boardInput, 1, 2, 3);
  }

  @Test public void testGetQisCountForBlock_03() {
    String boardInput =
        "◦◦◦"
      + "◦◦◦"
      + "●◦◦";
    testGetQisCountForBlock(boardInput, 1, 1, 2);
  }

  @Test public void testGetQisCountForBlock_04() {
    String boardInput =
        "◦○◦"
      + "●●◦"
      + "◦◦◦";
    testGetQisCountForBlock(boardInput, 2, 2, 4);
  }

  @Test public void testGetQisCountForBlock_05() {
    String boardInput =
        "◦◦◦"
      + "◦○◦"
      + "●●◦";
    testGetQisCountForBlock(boardInput, 1, 1, 2);
  }

  @Test public void testGetQisCountForBlock_06() {
    String boardInput =
        "◦○◦"
      + "●●●"
      + "◦●◦";
    testGetQisCountForBlock(boardInput, 2, 2, 4);
  }

  /////////////////////////////////////////////////////////////////////////////////////////////////

  @Test public void testIsColorBlockOfZeroQi() {
    String boardInput =
        "◦●○●◦"
      + "●●○●●"
      + "○○●○○"
      + "●●○●●"
      + "◦●○●◦";
    QiBoard qiBoard = QiBoard.readFromString(boardInput);
    BlockBoard blockBoard = qiBoard.getBlockBoard();
    ColorBlock colorBlock = blockBoard.getColorBlock(3, 3);
    Assert.assertTrue(qiBoard.isColorBlockOfZeroQi(colorBlock));
  }

  @Test public void test19x19_1() {
    String boardInput =
        "◦●◦●◦●◦●◦○○○●◦◦◦◦○◦"
      + "◦◦●●●○●○●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○●●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○○●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "○○○○○○●○◦○○●●●●●◦◦◦"
      + "◦●◦○●○●◦○○◦○●○○●◦◦◦"
      + "●◦●●A●●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○○◦○●◦◦"
      + "○○○○●○◦●○○●○●○○○●◦◦"
      + "◦◦○●●○●○○●●◦●◦●○○●◦"
      + "◦◦◦○○○●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●●"
      + "◦◦○●●●◦◦●○○◦◦○◦○◦○◦";
    QiBoard qiBoard = QiBoard.readFromString(boardInput);
    Assert.assertEquals(0, qiBoard.getAllBlocksOfColorWithZeroQi(Color.B).size());
    Assert.assertEquals(0, qiBoard.getAllBlocksOfColorWithZeroQi(Color.W).size());
  }

  @Test public void test19x19_2() {
    String boardInput =
        "◦●●◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "●◦●◦●◦●◦●◦●◦●◦●◦●◦●"
      + "◦●◦●◦●◦●◦●◦●◦●◦●◦●◦"
      + "●◦●◦●◦●◦●◦●◦●◦●◦●◦●"
      + "◦●◦●◦●◦●◦●◦●◦●◦●◦●◦"
      + "●◦●◦●◦●◦●◦●◦●◦●◦●◦●"
      + "◦●◦●◦●◦●◦●◦●◦●◦●◦●◦"
      + "●◦●◦●◦●◦●◦●◦●◦●◦●◦●"
      + "◦●◦●◦●◦●◦●◦●◦●◦●◦●◦"
      + "○○○○○○◦◦◦◦◦◦◦○○○○○○"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "○○○○○○◦◦◦◦◦◦◦○○○○○○"
      + "○○○○○○◦◦◦◦◦◦◦○○○○○○"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "○○○○○○◦◦◦◦◦◦◦○○○○○○"
      + "○○○○○○◦◦◦◦◦◦◦○○○○○○"
      + "○◦◦◦○○◦◦◦◦◦◦◦○○○○○○"
      + "○○○○○○◦◦◦◦◦◦◦○○○○○○"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○○○○○○";
    long timeStart = System.nanoTime();
    QiBoard qiBoard = QiBoard.readFromString(boardInput);
    long spentTimeMs = (System.nanoTime() - timeStart) / 1_000_000;  // ms
    Assert.assertEquals(0, qiBoard.getAllBlocksOfColorWithZeroQi(Color.B).size());
    Assert.assertEquals(0, qiBoard.getAllBlocksOfColorWithZeroQi(Color.W).size());
    BlockBoard blockBoard = qiBoard.getBlockBoard();
    ColorBlock colorBlock = blockBoard.getColorBlock(1, 2);
    ImmutableSet<Coord> qiCoords = qiBoard.getAllQiCoordsForColorBlock(colorBlock);
    Assert.assertEquals(19, qiCoords.size());
    if (spentTimeMs > ALLOWED_TIME_MS_FOR_READ_FROM_STRING) {
      fail("Too big spent-time (ms) for constructing a 19x19 QiBoard: " + spentTimeMs);
    }
  }
}
