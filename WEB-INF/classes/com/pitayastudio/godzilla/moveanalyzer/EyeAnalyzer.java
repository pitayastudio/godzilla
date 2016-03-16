package com.pitayastudio.godzilla.moveanalyzer;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.model.ClosedProperty;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.model.Gang;
import com.pitayastudio.godzilla.model.OpenProperty;
import com.pitayastudio.godzilla.modelboard.BlockBoard;
import com.pitayastudio.godzilla.modelboard.AnalyzerBoard;

import javax.annotation.Nonnull;

/**
 * TODO 400 Implement {@link EyeAnalyzer}.
 * TODO 400a {@link EyeAnalyzer} should know which eye block to look into without being told.
 *
 * <p>It calculate the best move(s) based on the given {@link ClosedProperty} and/or
 * {@link OpenProperty}.
 * So far, the analyzer relies on the caller to tell the analyzer which eye block
 * ({@link ClosedProperty} and/or {@link OpenProperty}) to look into.
 *
 * @see DesignDoc#moveToMakeOrDestroyEyes()
 * @see com.pitayastudio.godzilla.level.DesignDoc#analyzeNumberOfEyes()
 */
public class EyeAnalyzer {
  public static Builder newBuilder() {
    return new Builder();
  }

  @SuppressWarnings("unused") private final AnalyzerBoard analyzerBoard;
  @SuppressWarnings("unused") private final Gang gang;
  @SuppressWarnings("unused") private final ClosedProperty closedProperty;
  @SuppressWarnings("unused") private final OpenProperty openProperty;
  @SuppressWarnings("unused") private final boolean isReverseMode;
  private final ImmutableList<AnalyzerBoard> bestNextAnalyzerBoards;
  private final ImmutableList<Coord> bestMoveCoords;

  private EyeAnalyzer(
      @Nonnull AnalyzerBoard analyzerBoard,
      @Nonnull Gang gang,
      @Nonnull ClosedProperty closedProperty,
      @Nonnull OpenProperty openProperty,
      @Nonnull ImmutableList<AnalyzerBoard> bestNextAnalyzerBoards,
      @Nonnull ImmutableList<Coord> bestMoveCoords,
      boolean isReverseMode) {
    this.analyzerBoard = analyzerBoard;
    this.gang = gang;
    this.closedProperty = closedProperty;
    this.openProperty = openProperty;
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
    private Gang gang;
    private Color currentMoveColor;
    private ClosedProperty closedProperty;
    private OpenProperty openProperty;
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

    public Builder setRequiredGang(@Nonnull Gang gang) {
      this.gang = gang;
      return this;
    }

    public Builder setSemiRequiredCurrentMoveColor(@Nonnull Color currentMoveColor) {
      assert(analyzerBoard == null);
      this.currentMoveColor = currentMoveColor;
      return this;
    }

    public Builder setSemiRequiredClosedProperty(@Nonnull ClosedProperty closedProperty) {
      this.closedProperty = closedProperty;
      return this;
    }

    public Builder setSemiRequiredOpenProperty(@Nonnull OpenProperty openProperty) {
      this.openProperty = openProperty;
      return this;
    }

    /**
     * Sets mode as destroying-eye. If this method is not called, then the default mode is
     * making-eye.
     */
    public Builder setReverseMode() {
      isReverseMode = true;
      return this;
    }

    public EyeAnalyzer build() {
      assert (null != gang);
      assert(closedProperty != null || openProperty != null);
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
      return new EyeAnalyzer(analyzerBoard, gang, closedProperty, openProperty, bestNextAnalyzerBoards,
          bestMoveCoords, isReverseMode);
    }
  }
}
