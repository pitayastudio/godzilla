package com.pitayastudio.godzilla.moveanalyzer.connectionanalyzer;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.model.Gang;
import com.pitayastudio.godzilla.modelboard.BlockBoard;
import com.pitayastudio.godzilla.modelboard.CoordBoard;
import com.pitayastudio.godzilla.modelboard.GangBoard;
import com.pitayastudio.godzilla.modelboard.LandBoard;
import com.pitayastudio.godzilla.modelboard.LotBoard;
import com.pitayastudio.godzilla.modelboard.LotWithPropertyBoard;
import com.pitayastudio.godzilla.modelboard.AnalyzerBoard;
import com.pitayastudio.godzilla.modelboard.NeighborhoodBoard;
import com.pitayastudio.godzilla.moveanalyzer.DesignDoc;

import javax.annotation.Nonnull;

/**
 * TODO 400 implement TwoGangsConnectionAnalyzer.
 * @see DesignDoc#moveToConnectAndCut()
 */
public class TwoGangsConnectionAnalyzer extends ConnectionAnalyzer {
  public static Builder newBuilder() {
    return new Builder();
  }

  @SuppressWarnings("unused") private final AnalyzerBoard analyzerBoard;
  @SuppressWarnings("unused") private final Gang targetGang1;
  @SuppressWarnings("unused") private final Gang targetGang2;
  @SuppressWarnings("unused") private final boolean isReverseMode;
  private final ImmutableList<AnalyzerBoard> bestNextAnalyzerBoards;
  private final ImmutableList<Coord> bestMoveCoords;

  private TwoGangsConnectionAnalyzer(
      @Nonnull AnalyzerBoard analyzerBoard,
      @Nonnull Gang targetGang1,
      @Nonnull Gang targetGang2,
      @Nonnull ImmutableList<AnalyzerBoard> bestNextAnalyzerBoards,
      @Nonnull ImmutableList<Coord> bestMoveCoords,
      boolean isReverseMode) {
    this.analyzerBoard = analyzerBoard;
    this.targetGang1 = targetGang1;
    this.targetGang2 = targetGang2;
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
    private GangBoard gangBoard;
    private Color currentMoveColor;
    private Gang targetGang1;
    private Gang targetGang2;
    private ImmutableList<AnalyzerBoard> bestNextAnalyzerBoards;
    private ImmutableList<Coord> bestMoveCoords;
    private boolean isReverseMode = false;  // default false

    private Builder() {}

    /**
     * Sets current {@link AnalyzerBoard}.
     * If this method is called, then there is no need to call {@link #setSemiRequiredGangBoard} nor
     * {@link #setSemiRequiredCurrentMoveColor}.
     */
    public Builder setSemiRequiredAnalyzerBoard(@Nonnull AnalyzerBoard analyzerBoard) {
      assert(gangBoard == null);
      assert(currentMoveColor == null);
      this.analyzerBoard = analyzerBoard;
      return this;
    }

    public Builder setSemiRequiredGangBoard(@Nonnull GangBoard gangBoard) {
      this.gangBoard = gangBoard;
      return this;
    }

    /** TODO 250 setCurrentMoveColor() is redundant b/c it can be derived from isReverseMode. */
    public Builder setSemiRequiredCurrentMoveColor(@Nonnull Color currentMoveColor) {
      assert(analyzerBoard == null);
      this.currentMoveColor = currentMoveColor;
      return this;
    }

    public Builder setRequiredTargetGang1(@Nonnull Gang targetGang1) {
      this.targetGang1 = targetGang1;
      return this;
    }

    public Builder setRequiredTargetGang2(@Nonnull Gang targetGang2) {
      this.targetGang2 = targetGang2;
      return this;
    }

    /**
     * Sets mode as cutting. If this method is not called, then the default mode is connecting.
     */
    public Builder setReverseMode() {
      isReverseMode = true;
      return this;
    }

    public TwoGangsConnectionAnalyzer build() {
      assert (null != targetGang1);
      assert (null != targetGang2);
      if (analyzerBoard == null) {
        assert (null != gangBoard);
        assert (null != currentMoveColor);
        LotWithPropertyBoard lotWithPropertyBoard = gangBoard.getLotWithPropertyBoard();
        LotBoard lotBoard = lotWithPropertyBoard.getLotBoard();
        LandBoard landBoard = lotBoard.getLandBoard();
        NeighborhoodBoard neighborhoodBoard = landBoard.getNeighborhoodBoard();
        BlockBoard blockBoard = neighborhoodBoard.getBlockBoard();
        analyzerBoard = AnalyzerBoard.newBuilder()
            .setRequiredBlockBoardAfterMove(blockBoard)
            .setColorOfLatestMoveThatRendersThisBoard(currentMoveColor)
            .build();
      }
      calculateBestMoves();
      return new TwoGangsConnectionAnalyzer(analyzerBoard, targetGang1, targetGang2,
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
