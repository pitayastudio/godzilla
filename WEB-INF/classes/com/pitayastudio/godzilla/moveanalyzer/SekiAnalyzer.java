package com.pitayastudio.godzilla.moveanalyzer;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.model.Lot;
import com.pitayastudio.godzilla.model.OpenLand;
import com.pitayastudio.godzilla.modelboard.BlockBoard;
import com.pitayastudio.godzilla.modelboard.AnalyzerBoard;

import javax.annotation.Nonnull;

/** TODO 400 Implement SekiAnalyzer. */
public class SekiAnalyzer {
  public static Builder newBuilder() {
    return new Builder();
  }

  @SuppressWarnings("unused") private final AnalyzerBoard analyzerBoard;
  @SuppressWarnings("unused") private final ImmutableSet<OpenLand> openLands;
  @SuppressWarnings("unused") private final Lot buddyLotToBeSeki;
  private final ImmutableList<AnalyzerBoard> bestNextAnalyzerBoards;
  private final ImmutableList<Coord> bestMoveCoords;

  private SekiAnalyzer(
      @Nonnull AnalyzerBoard analyzerBoard,
      @Nonnull ImmutableSet<OpenLand> openLands,
      @Nonnull Lot buddyLotToBeSeki,
      @Nonnull ImmutableList<AnalyzerBoard> bestNextAnalyzerBoards,
      @Nonnull ImmutableList<Coord> bestMoveCoords) {
    this.analyzerBoard = analyzerBoard;
    this.openLands = openLands;
    this.buddyLotToBeSeki = buddyLotToBeSeki;
    this.bestNextAnalyzerBoards = bestNextAnalyzerBoards;
    this.bestMoveCoords = bestMoveCoords;
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
    private ImmutableSet.Builder<OpenLand> openLandsBuilder = ImmutableSet.builder();
    private Lot buddyLotToBeSeki;
    private ImmutableList<AnalyzerBoard> bestNextAnalyzerBoards;
    private ImmutableList<Coord> bestMoveCoords;

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

    public Builder setSemiRequiredCurrentMoveColor(@Nonnull Color currentMoveColor) {
      assert(analyzerBoard == null);
      this.currentMoveColor = currentMoveColor;
      return this;
    }

    public Builder addOpenLand(@Nonnull OpenLand openLand) {
      openLandsBuilder.add(openLand);
      return this;
    }

    public Builder addOpenLands(@Nonnull Iterable<OpenLand> openLands) {
      openLandsBuilder.addAll(openLands);
      return this;
    }

    public Builder setRequiredBuddyLotToBeSeki(@Nonnull Lot buddyLotToBeSeki) {
      this.buddyLotToBeSeki = buddyLotToBeSeki;
      return this;
    }

    public SekiAnalyzer build() {
      assert (null != buddyLotToBeSeki);
      if (analyzerBoard == null) {
        assert (null != blockBoard);
        assert (null != currentMoveColor);
        analyzerBoard = AnalyzerBoard.newBuilder()
            .setRequiredBlockBoardAfterMove(blockBoard)
            .setColorOfLatestMoveThatRendersThisBoard(currentMoveColor)
            .build();
      }
      ImmutableSet<OpenLand> openLands = openLandsBuilder.build();
      // TODO 200 Enable check non-empty openLands when ready.
      //assert(!openLands.isEmpty());

      // Dummy implementation.
      bestNextAnalyzerBoards = ImmutableList.of();
      bestMoveCoords = ImmutableList.of(blockBoard.getCoordBoard().getCoord(1, 1));

      return new SekiAnalyzer(analyzerBoard, openLands, buddyLotToBeSeki,
          bestNextAnalyzerBoards, bestMoveCoords);
    }
  }
}
