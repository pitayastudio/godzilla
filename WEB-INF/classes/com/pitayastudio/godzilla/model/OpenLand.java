package com.pitayastudio.godzilla.model;

import com.google.common.collect.ImmutableSet;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.Constants;
import com.pitayastudio.godzilla.modelboard.VisualBoard;

import javax.annotation.Nonnull;

/**
 * Not implemented yet.
 *
 * @see DesignDoc#land()
 */
public class OpenLand extends Land {
  public static Builder newBuilder() {
    return new Builder();
  }

  public static OpenLand readFromString(@SuppressWarnings("unused") String boardInput) {
    return new OpenLand(null, null, null);
  }

  private final VacantBlock vacantBlock;
  private final ImmutableSet<ColorBlock> blackBlocks;
  private final ImmutableSet<ColorBlock> whiteBlocks;

  private OpenLand(
      VacantBlock vacantBlock,
      ImmutableSet<ColorBlock> blackBlocks,
      ImmutableSet<ColorBlock> whiteBlocks) {
    this.vacantBlock = vacantBlock;
    this.blackBlocks = blackBlocks;
    this.whiteBlocks = whiteBlocks;
    assert(blackBlocks.iterator().next().getColor() == Color.B);
    assert(whiteBlocks.iterator().next().getColor() == Color.W);
    // TODO 200 Enable the following checks for EndGame.
    //assert(blackBlocks.size() == 1 || blackBlocks.size() == 2,
    //    "Invalid blackBlocks: " + blackBlocks);
    //assert(whiteBlocks.size() == 1 || whiteBlocks.size() == 2,
    //    "Invalid whiteBlocks: " + whiteBlocks);
  }

  public VacantBlock getVacantBlock() {
    return vacantBlock;
  }

  public ImmutableSet<ColorBlock> getBlackBlock() {
    return blackBlocks;
  }

  public ImmutableSet<ColorBlock> getWhiteBlock() {
    return whiteBlocks;
  }

  @Override
  public String toString() {
    return toString(Constants.BOARD_SIZE_19);
  }

  public String toString(int boardSize) {
    VisualBoard visualBoard = new VisualBoard(boardSize);
    for (ColorBlock colorBlock : blackBlocks) {
      visualBoard.updateBoardStateWithColorBlock(colorBlock, false);
    }
    for (ColorBlock colorBlock : whiteBlocks) {
      visualBoard.updateBoardStateWithColorBlock(colorBlock, false);
    }
    visualBoard.updateBoardStateWithVacantBlock(vacantBlock, true);
    return visualBoard.toString();
  }

  public static class Builder {
    private VacantBlock vacantBlock;
    private final ImmutableSet.Builder<ColorBlock> blackBlocksBuilder = ImmutableSet.builder();
    private final ImmutableSet.Builder<ColorBlock> whiteBlocksBuilder = ImmutableSet.builder();

    private Builder() {}

    public Builder setRequiredVacantBlock(@Nonnull VacantBlock vacantBlock) {
      this.vacantBlock = vacantBlock;
      return this;
    }

    public Builder addBlackBlock(@Nonnull ColorBlock colorBlock) {
      blackBlocksBuilder.add(colorBlock);
      return this;
    }

    public Builder addBlackBlocks(@Nonnull Iterable<ColorBlock> colorBlocks) {
      blackBlocksBuilder.addAll(colorBlocks);
      return this;
    }

    public Builder addWhiteBlock(@Nonnull ColorBlock colorBlock) {
      whiteBlocksBuilder.add(colorBlock);
      return this;
    }

    public Builder addWhiteBlocks(@Nonnull Iterable<ColorBlock> colorBlocks) {
      whiteBlocksBuilder.addAll(colorBlocks);
      return this;
    }

    public OpenLand build() {
      assert (null != vacantBlock);
      ImmutableSet<ColorBlock> blackBlocks = blackBlocksBuilder.build();
      assert(!blackBlocks.isEmpty());
      ImmutableSet<ColorBlock> whiteBlocks = whiteBlocksBuilder.build();
      assert(!whiteBlocks.isEmpty());
      return new OpenLand(vacantBlock, blackBlocks, whiteBlocks);
    }
  }
}
