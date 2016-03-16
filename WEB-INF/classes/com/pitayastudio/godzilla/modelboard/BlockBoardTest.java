package com.pitayastudio.godzilla.modelboard;

import com.google.common.collect.ImmutableSet;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.PositionStateChars;
import com.pitayastudio.godzilla.model.ColorBlock;
import com.pitayastudio.godzilla.model.Coord;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BlockBoardTest {

  @Before public void setUp() throws Exception {
  }

  @Test public void testConstructNewBlockBoardWithDead_fromScratch() {
    // The old board contains one dead block at (1, 1).
    String oldBoardInput =
        "○◦◦"
      + "●●◦"
      + "◇◇●";
    BlockBoard oldBlockBoard = BlockBoard.readFromString(oldBoardInput);
    ImmutableSet<ColorBlock> deadBlocks = ColorBlock.readColorBlocksFromString(
        oldBoardInput, oldBlockBoard, PositionStateChars.WHITE_EMPHASIZED);
    // Assuming there is one one dead block.
    ImmutableSet<Coord> deadCoords = ImmutableSet.copyOf(deadBlocks.iterator().next().getCoords());
    boolean isConstructFromScratch = true;
    BlockBoard newBlockBoard = oldBlockBoard.constructNewBlockBoardWithDead(
        isConstructFromScratch, Color.W, deadBlocks, deadCoords);
    String newBoardString = newBlockBoard.toString();
    String expectedNewBoardString =
        "○◦◦"
      + "●●◦"
      + "◦◦●";
    Assert.assertEquals(expectedNewBoardString, newBoardString.replaceAll("\n", ""));
  }

  @Test public void testConstructNewBlockBoardWithDead_fromCurrentBlockBoard() {
    // The old board contains one dead block at (1, 1).
    String oldBoardInput =
        "○◦◦"
      + "●●◦"
      + "◇◇●";
    BlockBoard oldBlockBoard = BlockBoard.readFromString(oldBoardInput);
    ImmutableSet<ColorBlock> deadBlocks = ColorBlock.readColorBlocksFromString(
        oldBoardInput, oldBlockBoard, PositionStateChars.WHITE_EMPHASIZED);
    // Assuming there is one one dead block.
    ImmutableSet<Coord> deadCoords = ImmutableSet.copyOf(deadBlocks.iterator().next().getCoords());
    boolean isConstructFromScratch = false;
    BlockBoard newBlockBoard = oldBlockBoard.constructNewBlockBoardWithDead(
        isConstructFromScratch, Color.W, deadBlocks, deadCoords);
    String newBoardString = newBlockBoard.toString();
    String expectedNewBoardString =
        "○◦◦"
      + "●●◦"
      + "◦◦●";
    Assert.assertEquals(expectedNewBoardString, newBoardString.replaceAll("\n", ""));
  }
}
