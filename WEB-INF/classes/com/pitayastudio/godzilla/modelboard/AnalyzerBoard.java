package com.pitayastudio.godzilla.modelboard;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.model.Coord;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Nonnull;

/**
 * NOT USED BY MCTS.
 * Immutable board used by XxxAnalyzer's.
 */
public class AnalyzerBoard {
  @SuppressWarnings("unused")
  private static final Logger logger = Logger.getLogger(AnalyzerBoard.class.getName());

  public static Builder newBuilder() {
    return new Builder();
  }

  private final BlockBoard blockBoardAfterMove;
  private final Optional<Color> colorOfCurrentMoveOptional;
  private final Optional<Coord> currentMoveCoordOptional;
  private final Optional<Coord> currentJieDeadCoordOptional;
  private final Optional<ImmutableSet<Coord>> deadCoordsOptional;
  private final boolean isPassMove;

  private AnalyzerBoard(
      @Nonnull BlockBoard blockBoardAfterMove,
      @Nonnull Optional<Color> currentMoveColorOptional,
      @Nonnull Optional<Coord> currentMoveCoordOptional,
      @Nonnull Optional<Coord> currentJieDeadCoordOptional,
      @Nonnull Optional<ImmutableSet<Coord>> deadCoordsOptional,
      boolean isPassMove) {
    this.blockBoardAfterMove = blockBoardAfterMove;
    this.colorOfCurrentMoveOptional = currentMoveColorOptional;
    this.currentMoveCoordOptional = currentMoveCoordOptional;
    this.currentJieDeadCoordOptional = currentJieDeadCoordOptional;
    this.deadCoordsOptional = deadCoordsOptional;
    this.isPassMove = isPassMove;
  }

  public int getBoardSize() {
    return blockBoardAfterMove.getCoordBoard().getBoardSize();
  }

  public BlockBoard getBlockBoardAfterMove() {
    return blockBoardAfterMove;
  }

  public Optional<Color> getColorOfCurrentMoveOptional() {
    return colorOfCurrentMoveOptional;
  }

  /**
   * Returns next color in turn; or returns Black when the current move is undefined.
   */
  public Color getColorOfNextMove() {
    return colorOfCurrentMoveOptional.isPresent()
        ? colorOfCurrentMoveOptional.get().swap()
        : Color.B;
  }

  public Optional<Coord> getCurrentMoveCoordOptional() {
    return currentMoveCoordOptional;
  }

  /**
   * <pre>
   * |.....
   * |.xxoo
   * |.xOXo
   * |.xxoo
   * |.....
   * </pre>
   * Assume in the current move, white ate X.
   * Then X=jieDeadCoord.
   *
   */
  public Optional<Coord> getCurrentJieDeadCoordOptional() {
    return currentJieDeadCoordOptional;
  }

  public Optional<ImmutableSet<Coord>> getDeadCoordsOptional() {
    return deadCoordsOptional;
  }

  public boolean isPassMove() {
    return isPassMove;
  }

  public ImmutableList<Coord> findAvailMoveCoordsExceptJie() {
    ImmutableList<Coord> allVacantCoords = this.blockBoardAfterMove.findAllVacantCoords();
    if (!this.currentJieDeadCoordOptional.isPresent()) {
      return allVacantCoords;
    }

    // Remove jie coord from available coords.
    List<Coord> allVacantCoordsExcludeJie = new ArrayList<>(allVacantCoords);
    boolean removed = allVacantCoordsExcludeJie.remove(this.currentJieDeadCoordOptional.get());
    assert(removed);
    return ImmutableList.copyOf(allVacantCoordsExcludeJie);
  }

  public String toAsciiString() {
    return this.blockBoardAfterMove.getPositionStateBoard().toAsciiString();
  }

  @Override public String toString() {
    return this.blockBoardAfterMove.getPositionStateBoard().toString();
  }

  public static class Builder {
    private BlockBoard blockBoardAfterMove;
    private Color currentMoveColor;
    private Coord currentMoveCoord;
    private Coord currentJieDeadCoord;
    private ImmutableSet<Coord> deadCoords;
    private boolean isPassMove = false;  // default is not pass move

    private Builder() {}

    public Builder setRequiredBlockBoardAfterMove(@Nonnull BlockBoard blockBoard) {
      this.blockBoardAfterMove = blockBoard;
      return this;
    }

    public Builder setColorOfLatestMoveThatRendersThisBoard(@Nonnull Color color) {
      this.currentMoveColor = color;
      return this;
    }

    public Builder setCoordOfLatestMoveThatRendersThisBoard(@Nonnull Coord coord) {
      this.currentMoveCoord = coord;
      return this;
    }

    public Builder setDeadCoordFromLatestMoveThatIsJieAndRendersThisBoard(@Nonnull Coord coord) {
      this.currentJieDeadCoord = coord;
      return this;
    }

    public Builder setDeadCoordsFromLatestMoveThatIsNonJieAndRendersThisBoard(
        @Nonnull ImmutableSet<Coord> deadCoords) {
      this.deadCoords = deadCoords;
      return this;
    }

    public Builder setIsPassMove() {
      isPassMove = true;
      return this;
    }

    public AnalyzerBoard build() {
      assert(blockBoardAfterMove != null);
      return new AnalyzerBoard(
          blockBoardAfterMove,
          Optional.fromNullable(currentMoveColor),
          Optional.fromNullable(currentMoveCoord),
          Optional.fromNullable(currentJieDeadCoord),
          Optional.fromNullable(deadCoords),
          isPassMove);
    }
  }
}
