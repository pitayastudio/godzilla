package com.pitayastudio.godzilla.model;

import com.google.common.collect.ImmutableSet;

import com.pitayastudio.godzilla.common.PositionState;
import com.pitayastudio.godzilla.modelboard.CoordBoard;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ColorBlockTest extends TestCase {

  ColorBlock colorBlock1;
  ColorBlock colorBlock2;

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    int boardSize = 3;
    CoordBoard coordBoard = new CoordBoard(boardSize);
    colorBlock1 = (ColorBlock) Block.newBuilder()
        .setRequiredPositState(PositionState.BLACK)
        .setRequiredBoardSize(boardSize)
        .addCoord(coordBoard.getCoord(1, 1))
        .build();
    colorBlock2 = (ColorBlock) Block.newBuilder()
        .setRequiredPositState(PositionState.BLACK)
        .setRequiredBoardSize(boardSize)
        .addCoord(coordBoard.getCoord(3, 3))
        .build();
  }

  /**
   * Tests {@link ColorBlock#hashCode}.
   */
  @Test public void testHashCode_hashMap() {
    HashMap<Block, String> blockToStringMap = new HashMap<>();
    blockToStringMap.put(colorBlock1, "block 1");
    blockToStringMap.put(colorBlock2, "block 2");
    assertEquals("block 2", blockToStringMap.get(colorBlock2));
  }

  /**
   * Tests {@link ColorBlock#hashCode}.
   */
  @Test public void testHashCode_HashSet() {
    HashSet<Block> blockHashSet = new HashSet<>();
    blockHashSet.add(colorBlock1);
    blockHashSet.add(colorBlock2);
    assertTrue(blockHashSet.contains(colorBlock2));
  }

  /**
   * Tests {@link ColorBlock#hashCode} and {@link ColorBlock#equals}.
   */
  @Test public void testHashCodeAndEquals_immutableSet() {
    ImmutableSet.Builder<Block> blockImmutableSetBuilder = ImmutableSet.builder();
    blockImmutableSetBuilder.add(colorBlock1);
    blockImmutableSetBuilder.add(colorBlock2);
    ImmutableSet<Block> blockImmutableSet = blockImmutableSetBuilder.build();
    assertTrue(blockImmutableSet.contains(colorBlock2));  // Calls both hashCode() and equals()
  }

  /**
   * Tests {@link ColorBlock#equals}.
   */
  @Test public void testEquals_ArrayList() {
    ArrayList<Block> blockArrayList = new ArrayList<>();
    blockArrayList.add(colorBlock1);
    blockArrayList.add(colorBlock2);
    // ArrayList.contains() calls twice equals() for both colorBlock1 and colorBlock2.
    assertTrue(blockArrayList.contains(colorBlock2));
  }
}
