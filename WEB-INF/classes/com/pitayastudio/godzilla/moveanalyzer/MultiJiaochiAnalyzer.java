package com.pitayastudio.godzilla.moveanalyzer;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.model.ColorBlock;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.modelboard.BlockBoard;
import com.pitayastudio.godzilla.modelboard.AnalyzerBoard;

import javax.annotation.Nonnull;

/**
 * TODO 400 Implement {@link MultiJiaochiAnalyzer}.
 */
public class MultiJiaochiAnalyzer {
  public static Builder newBuilder() {
    return new Builder();
  }

  @SuppressWarnings("unused") private final AnalyzerBoard analyzerBoard;
  @SuppressWarnings("unused") private final ImmutableSet<ColorBlock> targetBlocks;
  @SuppressWarnings("unused") private final boolean isReverseMode;
  private final ImmutableList<AnalyzerBoard> bestNextAnalyzerBoards;
  private final ImmutableList<Coord> bestMoveCoords;

  private MultiJiaochiAnalyzer(
      @Nonnull AnalyzerBoard analyzerBoard,
      @Nonnull ImmutableSet<ColorBlock> targetBlocks,
      @Nonnull ImmutableList<AnalyzerBoard> bestNextAnalyzerBoards,
      @Nonnull ImmutableList<Coord> bestMoveCoords,
      boolean isReverseMode) {
    this.analyzerBoard = analyzerBoard;
    this.targetBlocks = targetBlocks;
    this.bestNextAnalyzerBoards = bestNextAnalyzerBoards;
    this.bestMoveCoords = bestMoveCoords;
    this.isReverseMode = isReverseMode;
  }

  public ImmutableList<AnalyzerBoard> getBestNextAnalyzerBoards() {
    return bestNextAnalyzerBoards;
  }

  @VisibleForTesting public ImmutableList<Coord> getBestMoveCoords() {
    return bestMoveCoords;
  }

  public static class Builder {
    private AnalyzerBoard analyzerBoard;
    private BlockBoard blockBoard;
    private Color currentMoveColor;
    private ImmutableSet<ColorBlock> targetBlocks;
    private ImmutableList<AnalyzerBoard> bestNextAnalyzerBoards;
    private ImmutableList<Coord> bestMoveCoords;
    private boolean isReverseMode = false;  // default false

    private Builder() {}

    /**
     * Sets current {@link AnalyzerBoard}.
     * If this method is called, then there is no need to call {@link #setSemiRequiredBlockBoard}
     * nor {@link #setSemiRequiredCurrentMoveColor}.
     */
    public Builder setSemiRequiredAnalyzerBoard(@Nonnull AnalyzerBoard analyzerBoard) {
      assert(blockBoard == null);
      assert(currentMoveColor == null);
      this.analyzerBoard = analyzerBoard;
      return this;
    }

    public Builder setSemiRequiredBlockBoard(@Nonnull BlockBoard blockBoard) {
      assert(analyzerBoard == null);
      this.blockBoard = blockBoard;
      return this;
    }

    /** TODO 250 setCurrentMoveColor() is redundant b/c it can be derived from isReverseMode. */
    public Builder setSemiRequiredCurrentMoveColor(@Nonnull Color currentMoveColor) {
      assert(analyzerBoard == null);
      this.currentMoveColor = currentMoveColor;
      return this;
    }

    public Builder setRequiredTargetBlocks(@Nonnull ImmutableSet<ColorBlock> targetBlocks) {
      this.targetBlocks = targetBlocks;
      return this;
    }

    /**
     * Sets mode as preventing-blocks-from-being-eaten. If this method is not called, then the
     * default mode is eating.
     */
    public Builder setReverseMode() {
      isReverseMode = true;
      return this;
    }

    public MultiJiaochiAnalyzer build() {
      assert (null != targetBlocks);
      if (analyzerBoard == null) {
        assert (null != blockBoard);
        assert (null != currentMoveColor);
        analyzerBoard = AnalyzerBoard.newBuilder()
            .setRequiredBlockBoardAfterMove(blockBoard)
            .setColorOfLatestMoveThatRendersThisBoard(currentMoveColor)
            .build();
      }

      // Dummy implementation.
      bestNextAnalyzerBoards = ImmutableList.of();
      bestMoveCoords = ImmutableList.of(blockBoard.getCoordBoard().getCoord(1, 1));

      return new MultiJiaochiAnalyzer(analyzerBoard, targetBlocks, bestNextAnalyzerBoards, bestMoveCoords,
          isReverseMode);
    }
  }
}
