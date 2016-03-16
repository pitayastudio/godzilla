package com.pitayastudio.godzilla.moveanalyzer.connectionanalyzer;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.model.ColorBlock;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.modelboard.BlockBoard;
import com.pitayastudio.godzilla.modelboard.CoordBoard;
import com.pitayastudio.godzilla.modelboard.AnalyzerBoard;
import com.pitayastudio.godzilla.moveanalyzer.DesignDoc;

import javax.annotation.Nonnull;

/**
 * TODO 400 implement TwoBlocksConnectionAnalyzer.
 * @see DesignDoc#moveToConnectAndCut()
 */
public class TwoBlocksConnectionAnalyzer extends ConnectionAnalyzer {
  public static Builder newBuilder() {
    return new Builder();
  }

  @SuppressWarnings("unused") private final AnalyzerBoard analyzerBoard;
  @SuppressWarnings("unused") private final ColorBlock targetBlock1;
  @SuppressWarnings("unused") private final ColorBlock targetBlock2;
  @SuppressWarnings("unused") private final boolean isReverseMode;
  private final ImmutableList<AnalyzerBoard> bestNextAnalyzerBoards;
  private final ImmutableList<Coord> bestMoveCoords;

  private TwoBlocksConnectionAnalyzer(
      @Nonnull AnalyzerBoard analyzerBoard,
      @Nonnull ColorBlock targetBlock1,
      @Nonnull ColorBlock targetBlock2,
      @Nonnull ImmutableList<AnalyzerBoard> bestNextAnalyzerBoards,
      @Nonnull ImmutableList<Coord> bestMoveCoords,
      boolean isReverseMode) {
    this.analyzerBoard = analyzerBoard;
    this.targetBlock1 = targetBlock1;
    this.targetBlock2 = targetBlock2;
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
    private ColorBlock targetBlock1;
    private ColorBlock targetBlock2;
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

    public Builder setRequiredTargetBlock1(@Nonnull ColorBlock targetBlock1) {
      this.targetBlock1 = targetBlock1;
      return this;
    }

    public Builder setRequiredTargetBlock2(@Nonnull ColorBlock targetBlock2) {
      this.targetBlock2 = targetBlock2;
      return this;
    }

    /**
     * Sets mode as cutting. If this method is not called, then the default mode is connecting.
     */
    public Builder setReverseMode() {
      isReverseMode = true;
      return this;
    }

    public TwoBlocksConnectionAnalyzer build() {
      assert (null != targetBlock1);
      assert (null != targetBlock2);
      if (analyzerBoard == null) {
        assert (null != blockBoard);
        assert (null != currentMoveColor);
        analyzerBoard = AnalyzerBoard.newBuilder()
            .setRequiredBlockBoardAfterMove(blockBoard)
            .setColorOfLatestMoveThatRendersThisBoard(currentMoveColor)
            .build();
      }
      calculateBestMoves();
      return new TwoBlocksConnectionAnalyzer(analyzerBoard, targetBlock1, targetBlock2,
          bestNextAnalyzerBoards, bestMoveCoords, isReverseMode);
    }

    private void calculateBestMoves() {
      // Dummy results.
      CoordBoard coordBoard = analyzerBoard.getBlockBoardAfterMove().getCoordBoard();
      bestNextAnalyzerBoards = ImmutableList.of();
      bestMoveCoords = ImmutableList.of(coordBoard.getCoord(1, 1));
    }
  }
}
