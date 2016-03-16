package com.pitayastudio.godzilla.model;

import com.google.common.collect.ImmutableSet;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.Constants;
import com.pitayastudio.godzilla.modelboard.VisualBoard;

import javax.annotation.Nonnull;

/**
 * @see DesignDoc#land()
 */
public class ClosedLand extends Land {
  public static Builder newBuilder() {
    return new Builder();
  }

  private final Color color;
  private final VacantBlock vacantBlock;
  private final ImmutableSet<ColorBlock> colorBlocks;

  private ClosedLand(
      @Nonnull Color color,
      @Nonnull VacantBlock vacantBlock,
      @Nonnull ImmutableSet<ColorBlock> colorBlocks) {
    this.color = color;
    this.vacantBlock = vacantBlock;
    this.colorBlocks = colorBlocks;
    assert(!colorBlocks.isEmpty());
    assert(colorBlocks.iterator().next().getColor() == color);
  }

  public Color getColor() {
    return color;
  }

  public VacantBlock getVacantBlock() {
    return vacantBlock;
  }

  public ImmutableSet<ColorBlock> getColorBlocks() {
    return colorBlocks;
  }

  @Override
  public String toString() {
    return toString(Constants.BOARD_SIZE_19);
  }

  public String toString(int boardSize) {
    VisualBoard visualBoard = new VisualBoard(boardSize);
    for (ColorBlock colorBlock : colorBlocks) {
      visualBoard.updateBoardStateWithColorBlock(colorBlock, false);
    }
    visualBoard.updateBoardStateWithVacantBlock(vacantBlock, true);
    return visualBoard.toString();
  }

  public static class Builder {
    private Color color;
    private VacantBlock vacantBlock;
    private final ImmutableSet.Builder<ColorBlock> colorBlocksBuilder = ImmutableSet.builder();

    private Builder() {}

    public Builder setRequiredColor(@Nonnull Color color) {
      this.color = color;
      return this;
    }

    public Builder setRequiredVacantBlock(@Nonnull VacantBlock vacantBlock) {
      this.vacantBlock = vacantBlock;
      return this;
    }

    public Builder addColorBlock(@Nonnull ColorBlock colorBlock) {
      colorBlocksBuilder.add(colorBlock);
      return this;
    }

    public Builder addColorBlocks(@Nonnull Iterable<ColorBlock> colorBlocks) {
      colorBlocksBuilder.addAll(colorBlocks);
      return this;
    }

    public ClosedLand build() {
      assert (null != color);
      assert (null != vacantBlock);
      ImmutableSet<ColorBlock> colorBlocks = colorBlocksBuilder.build();
      assert(!colorBlocks.isEmpty());
      return new ClosedLand(color, vacantBlock, colorBlocks);
    }
  }
}
