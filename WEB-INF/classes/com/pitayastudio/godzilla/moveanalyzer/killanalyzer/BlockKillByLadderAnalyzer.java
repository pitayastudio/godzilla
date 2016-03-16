package com.pitayastudio.godzilla.moveanalyzer.killanalyzer;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.model.ColorBlock;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.model.GangType;
import com.pitayastudio.godzilla.model.LotType;
import com.pitayastudio.godzilla.modelboard.BlockBoard;
import com.pitayastudio.godzilla.modelboard.CoordBoard;
import com.pitayastudio.godzilla.modelboard.AnalyzerBoard;
import com.pitayastudio.godzilla.moveanalyzer.DesignDoc;

import javax.annotation.Nonnull;

/**
 * TODO 400 implement BlockKillByLadderAnalyzer.
 * @see DesignDoc#killByLadder()
 */
public class BlockKillByLadderAnalyzer extends KillAnalyzer {
  public static Builder newBuilder() {
    return new Builder();
  }

  @SuppressWarnings("unused") private final AnalyzerBoard analyzerBoard;
  @SuppressWarnings("unused") private final Color currentMoveColor;
  @SuppressWarnings("unused") private final ColorBlock targetColorBlock;
  private final AnalyzerBoard bestNextAnalyzerBoard;
  private final ImmutableList<Coord> coordsOfMoveSequence;
  /**
   * TODO 250 Evaluate to add isKillable to other kill-analyzers.
   * It might be merged with {@link LotType} or {@link GangType}.
   */
  private final boolean isKillable;

  private BlockKillByLadderAnalyzer(
      @Nonnull AnalyzerBoard analyzerBoard,
      @Nonnull ColorBlock targetColorBlock,
      @Nonnull AnalyzerBoard bestNextAnalyzerBoard,
      @Nonnull ImmutableList<Coord> coordsOfMoveSequence,
      boolean isKillable) {
    this.analyzerBoard = analyzerBoard;
    currentMoveColor = analyzerBoard.getColorOfCurrentMoveOptional().get();
    this.targetColorBlock = targetColorBlock;
    this.bestNextAnalyzerBoard = bestNextAnalyzerBoard;
    this.coordsOfMoveSequence = coordsOfMoveSequence;
    this.isKillable = isKillable;
  }

  public AnalyzerBoard getBestNextAnalyzerBoard() {
    assert(isKillable);
    return bestNextAnalyzerBoard;
  }

  @VisibleForTesting public ImmutableList<Coord> getCoordsOfMoveSequence() {
    assert(isKillable);
    return coordsOfMoveSequence;
  }

  public boolean isKillable() {
    return isKillable;
  }

  public static class Builder {
    private AnalyzerBoard analyzerBoard;
    private BlockBoard blockBoard;
    private Color currentMoveColor;
    private ColorBlock targetColorBlock;
    private AnalyzerBoard bestNextAnalyzerBoard;
    private ImmutableList<Coord> coordsOfMoveSequence;
    private boolean isKillable;

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

    public Builder setRequiredTargetColorBlock(@Nonnull ColorBlock targetColorBlock) {
      this.targetColorBlock = targetColorBlock;
      return this;
    }

    public BlockKillByLadderAnalyzer build() {
      assert (null != targetColorBlock);
      if (analyzerBoard == null) {
        assert (null != blockBoard);
        assert (null != currentMoveColor);
        analyzerBoard = AnalyzerBoard.newBuilder()
            .setRequiredBlockBoardAfterMove(blockBoard)
            .setColorOfLatestMoveThatRendersThisBoard(currentMoveColor)
            .build();
      }
      calculateBestMoves();
      return new BlockKillByLadderAnalyzer(analyzerBoard, targetColorBlock, bestNextAnalyzerBoard,
          coordsOfMoveSequence, isKillable);
    }

    private void calculateBestMoves() {
      // Dummy implementation.
      CoordBoard coordBoard = analyzerBoard.getBlockBoardAfterMove().getCoordBoard();
      blockBoard = BlockBoard.newBuilder()
          .setRequiredPositionStateBoard(analyzerBoard.getBlockBoardAfterMove().getPositionStateBoard())
          .build();
      bestNextAnalyzerBoard = AnalyzerBoard.newBuilder()
          .setRequiredBlockBoardAfterMove(blockBoard)
          .setColorOfLatestMoveThatRendersThisBoard(currentMoveColor)
          .build();
      coordsOfMoveSequence = ImmutableList.of(coordBoard.getCoord(1, 1));
      isKillable = true;
    }
  }
}
