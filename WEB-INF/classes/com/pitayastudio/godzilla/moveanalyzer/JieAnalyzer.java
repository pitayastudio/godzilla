package com.pitayastudio.godzilla.moveanalyzer;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.modelboard.BlockBoard;
import com.pitayastudio.godzilla.modelboard.CoordBoard;
import com.pitayastudio.godzilla.modelboard.AnalyzerBoard;
import com.pitayastudio.godzilla.modelboard.PositionStateBoard;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * TODO 300 Implement JieHandler.
 * @see com.pitayastudio.godzilla.jie.DesignDoc
 */
public class JieAnalyzer {
  public static Builder newBuilder() {
    return new Builder();
  }

  @SuppressWarnings("unused") private final AnalyzerBoard analyzerBoard;
  private AnalyzerBoard bestNextAnalyzerBoard;

  private final Coord jieColorCoord;
  private final Coord jieVacantCoord;
  private final Coord jieBeingEatenCoord;

  private JieAnalyzer(
      @Nonnull AnalyzerBoard analyzerBoard,
      @Nonnull AnalyzerBoard bestNextAnalyzerBoard,
      Coord jieColorCoord,
      Coord jieVacantCoord,
      Coord jieBeingEatenCoord) {
    this.analyzerBoard = analyzerBoard;
    this.bestNextAnalyzerBoard = bestNextAnalyzerBoard;
    this.jieColorCoord = jieColorCoord;
    this.jieVacantCoord = jieVacantCoord;
    this.jieBeingEatenCoord = jieBeingEatenCoord;
  }

  public AnalyzerBoard getNextAnalyzerBoard() {
    return bestNextAnalyzerBoard;
  }

  public Coord getNextMoveCoord() {
    return bestNextAnalyzerBoard.getCurrentMoveCoordOptional().get();
  }

  @Nullable public Coord getJieColorCoord() {
    return jieColorCoord;
  }

  @Nullable public Coord getJieVacantCoord() {
    return jieVacantCoord;
  }

  @Nullable public Coord getJieBeingEatenCoord() {
    return jieBeingEatenCoord;
  }

  public static class Builder {
    private AnalyzerBoard analyzerBoard;
    private BlockBoard blockBoard;
    private Color currentMoveColor;
    private AnalyzerBoard bestNextAnalyzerBoard;
    private Coord jieColorCoord;
    private Coord jieVacantCoord;
    private Coord jieBeingEatenCoord;

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

    public Builder setSemiRequiredJieColorCoord(@Nonnull Coord jieColorCoord) {
      this.jieColorCoord = jieColorCoord;
      return this;
    }

    public Builder setSemiRequiredJieVacantCoord(@Nonnull Coord jieVacantCoord) {
      this.jieVacantCoord = jieVacantCoord;
      return this;
    }

    public Builder setSemiRequiredJieBeingEatenCoord(@Nonnull Coord jieBeingEatenCoord) {
      this.jieBeingEatenCoord = jieBeingEatenCoord;
      return this;
    }

    public JieAnalyzer build() {
      assert(
          jieColorCoord != null
          || jieVacantCoord != null
          || jieBeingEatenCoord != null);
      if (analyzerBoard == null) {
        assert (null != blockBoard);
        assert (null != currentMoveColor);
        analyzerBoard = AnalyzerBoard.newBuilder()
            .setRequiredBlockBoardAfterMove(blockBoard)
            .setColorOfLatestMoveThatRendersThisBoard(currentMoveColor)
            .build();
      }
      calculateJieMove();
      return new JieAnalyzer(analyzerBoard, bestNextAnalyzerBoard, jieColorCoord, jieVacantCoord,
          jieBeingEatenCoord);
    }

    private void calculateJieMove() {
      // Dummy implementation.
      CoordBoard coordBoard = analyzerBoard.getBlockBoardAfterMove().getCoordBoard();
      PositionStateBoard positionStateBoard = analyzerBoard.getBlockBoardAfterMove().getPositionStateBoard();
      BlockBoard blockBoard = BlockBoard.newBuilder()
          .setRequiredPositionStateBoard(positionStateBoard)
          .build();
      bestNextAnalyzerBoard = AnalyzerBoard.newBuilder()
          .setRequiredBlockBoardAfterMove(blockBoard)
          .setColorOfLatestMoveThatRendersThisBoard(currentMoveColor.swap())
          .setCoordOfLatestMoveThatRendersThisBoard(coordBoard.getCoord(1, 1))
          .build();
    }
  }
}
