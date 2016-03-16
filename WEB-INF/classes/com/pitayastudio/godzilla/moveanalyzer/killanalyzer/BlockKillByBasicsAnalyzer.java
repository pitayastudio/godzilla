package com.pitayastudio.godzilla.moveanalyzer.killanalyzer;

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
 * TODO 400 implement BlockKillByBasicsAnalyzer.
 * @see DesignDoc#moveToEscape
 */
public class BlockKillByBasicsAnalyzer extends KillAnalyzer {
  public static Builder newBuilder() {
    return new Builder();
  }

  @SuppressWarnings("unused") private final AnalyzerBoard analyzerBoard;
  @SuppressWarnings("unused") private final Color currentMoveColor;
  @SuppressWarnings("unused") private final ColorBlock targetBlock;
  @SuppressWarnings("unused") private final boolean isReverseMode;
  private final ImmutableList<AnalyzerBoard> bestNextAnalyzerBoards;
  private final ImmutableList<Coord> bestMoveCoords;

  private BlockKillByBasicsAnalyzer(
      @Nonnull AnalyzerBoard analyzerBoard,
      @Nonnull ColorBlock targetBlock,
      @Nonnull ImmutableList<AnalyzerBoard> bestNextAnalyzerBoards,
      @Nonnull ImmutableList<Coord> bestMoveCoords,
      boolean isReverseMode) {
    this.analyzerBoard = analyzerBoard;
    currentMoveColor = analyzerBoard.getColorOfCurrentMoveOptional().get();
    this.targetBlock = targetBlock;
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
    private ColorBlock targetBlock;
    private ImmutableList<AnalyzerBoard> bestNextAnalyzerBoards;
    private ImmutableList<Coord> bestMoveCoords;
    private boolean isReverseMode;

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

    public Builder setRequiredTargetBlock(@Nonnull ColorBlock targetBlock) {
      this.targetBlock = targetBlock;
      return this;
    }

    /**
     * Sets mode as escaping. If this method is not called, then the default mode is killing.
     */
    public Builder setReverseMode() {
      isReverseMode = true;
      return this;
    }

    public BlockKillByBasicsAnalyzer build() {
      assert (null != targetBlock);
      if (analyzerBoard == null) {
        assert (null != blockBoard);
        assert (null != currentMoveColor);
        analyzerBoard = AnalyzerBoard.newBuilder()
            .setRequiredBlockBoardAfterMove(blockBoard)
            .setColorOfLatestMoveThatRendersThisBoard(currentMoveColor)
            .build();
      }
      calculateBestMoves();
      return new BlockKillByBasicsAnalyzer(analyzerBoard, targetBlock, bestNextAnalyzerBoards,
          bestMoveCoords, isReverseMode);
    }

    private void calculateBestMoves() {
      // Dummy implementation.
      CoordBoard coordBoard = analyzerBoard.getBlockBoardAfterMove().getCoordBoard();
      bestNextAnalyzerBoards = ImmutableList.of();
      bestMoveCoords = ImmutableList.of(coordBoard.getCoord(1, 1));
    }
  }
}
