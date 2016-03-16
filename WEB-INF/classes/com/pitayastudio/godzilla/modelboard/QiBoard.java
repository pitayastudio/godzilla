package com.pitayastudio.godzilla.modelboard;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.Utils;
import com.pitayastudio.godzilla.model.ColorBlock;
import com.pitayastudio.godzilla.model.Coord;

import java.util.EnumMap;

import javax.annotation.Nonnull;

/**
 * Immutable board of Qi-{@link Coord}'s.
 * So far it is used only for testing code.
 * It is expensive to construct a QiBoard, so it is not used in production yet.
 */
public class QiBoard {
  private static final boolean FLAG_PROFILE = true;

  public static Builder newBuilder() {
    return new Builder();
  }

  public static QiBoard readFromString(@Nonnull String boardInput) {
    BlockBoard blockBoard = BlockBoard.readFromString(boardInput);
    return newBuilder().setBlockBoard(blockBoard).build();
  }

  private final BlockBoard blockBoard;
  private final ImmutableMap<ColorBlock, ImmutableSet<Coord>> blockToQiCoordsMap;
  private final EnumMap<Color, ImmutableSet<ColorBlock>> colorToBlocksWithZeroQi;

  private QiBoard(
      @Nonnull BlockBoard blockBoard,
      @Nonnull ImmutableMap<ColorBlock, ImmutableSet<Coord>> blockToQiCoordsMap,
      @Nonnull EnumMap<Color, ImmutableSet<ColorBlock>> colorToBlocksWithZeroQi) {
    this.blockBoard = blockBoard;
    this.blockToQiCoordsMap = blockToQiCoordsMap;
    this.colorToBlocksWithZeroQi = colorToBlocksWithZeroQi;
  }

  public BlockBoard getBlockBoard() {
    return blockBoard;
  }

  public ImmutableSet<Coord> getAllQiCoordsForColorBlock(@Nonnull ColorBlock colorBlock) {
    return blockToQiCoordsMap.get(colorBlock);
  }

  public ImmutableSet<ColorBlock> getAllBlocksOfColorWithZeroQi(@Nonnull Color color) {
    return colorToBlocksWithZeroQi.get(color);
  }

  public boolean isColorBlockOfZeroQi(@Nonnull ColorBlock colorBlock) {
    return colorToBlocksWithZeroQi.get(colorBlock.getColor()).contains(colorBlock);
  }

  public static class Builder {
    private BlockBoard blockBoard;
    private final EnumMap<Color, ImmutableSet<ColorBlock>> colorToBlocksWithZeroQiBuilder =
        new EnumMap<>(Color.class);
    private final ImmutableMap.Builder<ColorBlock, ImmutableSet<Coord>> blockToQiCoordsMapBuilder =
        ImmutableMap.builder();

    private Builder() {}

    public Builder setBlockBoard(@Nonnull BlockBoard blockBoard) {
      this.blockBoard = blockBoard;
      return this;
    }

    public QiBoard build() {
      assert (null != blockBoard);
      if (FLAG_PROFILE) {
        long time00 = System.nanoTime();
        findQiCoordsForAllColorBlocks();
        Utils.profile(time00, "QiBoard.build => findQiCoordsForAllColorBlocks");
      } else {
        findQiCoordsForAllColorBlocks();
      }
      ImmutableMap<ColorBlock, ImmutableSet<Coord>> blockToQiCoordsMap =
          blockToQiCoordsMapBuilder.build();
      if (FLAG_PROFILE) {
        long time00 = System.nanoTime();
        findBlocksWithZeroQi(blockToQiCoordsMap);
        Utils.profile(time00, "QiBoard.build => findBlocksWithZeroQi");
      } else {
        findBlocksWithZeroQi(blockToQiCoordsMap);
      }
      QiBoard qiBoard =
          new QiBoard(blockBoard, blockToQiCoordsMap, colorToBlocksWithZeroQiBuilder);
      return qiBoard;
    }

    private void findQiCoordsForAllColorBlocks() {
      for (Color color : Color.values()) {
        for (ColorBlock colorBlock : blockBoard.getAllBlocksOfColor(color)) {
          ImmutableSet<Coord> qiCoords = findQiCoordsForBlock(colorBlock);
          blockToQiCoordsMapBuilder.put(colorBlock, qiCoords);
        }
      }
    }

    private ImmutableSet<Coord> findQiCoordsForBlock(ColorBlock colorBlock) {
      return blockBoard.findQiCoordsForBlock(colorBlock);
    }

    private void findBlocksWithZeroQi(
        ImmutableMap<ColorBlock, ImmutableSet<Coord>> blockToQiCoordsMap) {
      for (Color color : Color.values()) {
        ImmutableSet.Builder<ColorBlock> blocksOfColorWithZeroQiBuilder = ImmutableSet.builder();
        for (ColorBlock colorBlock : blockBoard.getAllBlocksOfColor(color)) {
          if (blockToQiCoordsMap.get(colorBlock).isEmpty()) {
            blocksOfColorWithZeroQiBuilder.add(colorBlock);
          }
        }
        colorToBlocksWithZeroQiBuilder.put(color, blocksOfColorWithZeroQiBuilder.build());
      }
    }
  }
}
