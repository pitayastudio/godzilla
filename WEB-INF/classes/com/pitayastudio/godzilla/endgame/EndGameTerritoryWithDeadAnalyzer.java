package com.pitayastudio.godzilla.endgame;

import com.google.common.collect.ImmutableSet;

import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.modelboard.CoordBoard;
import com.pitayastudio.godzilla.modelboard.PositionStateBoard;
import com.pitayastudio.godzilla.modelboard.VisualBoard;

import javax.annotation.Nonnull;

/**
 * TODO 200 Implement EndGameTerritoryWithDeadAnalyzer.
 *
 * Game game territory analyzer where all the dead stones need to be found out.
 */
public class EndGameTerritoryWithDeadAnalyzer {
  public static Builder newBuilder() {
    return new Builder();
  }

  public static EndGameTerritoryWithDeadAnalyzer readFromString(@Nonnull String boardInput) {
    int boardSize = VisualBoard.getBoardSizeFromBoardInput(boardInput);
    CoordBoard coordBoard = new CoordBoard(boardSize);
    PositionStateBoard positionStateBoard =
        PositionStateBoard.readFromString(boardInput, coordBoard);
    return newBuilder()
        .setPositionStateBoard(positionStateBoard)
        .build();
  }

  private final int blackTerritory;
  private final int whiteTerritory;
  private final ImmutableSet<Coord> blackDeadCoords;
  private final ImmutableSet<Coord> whiteDeadCoords;

  private EndGameTerritoryWithDeadAnalyzer(
      int blackTerritory,
      int whiteTerritory,
      @Nonnull ImmutableSet<Coord> blackDeadCoords,
      @Nonnull ImmutableSet<Coord> whiteDeadCoords) {
    this.blackTerritory = blackTerritory;
    this.whiteTerritory = whiteTerritory;
    this.blackDeadCoords = blackDeadCoords;
    this.whiteDeadCoords = whiteDeadCoords;
  }

  public int getBlackTerritoryWithoutDead() {
    return blackTerritory;
  }

  public int getWhiteTerritoryWithoutDead() {
    return whiteTerritory;
  }

  public ImmutableSet<Coord> getBlackDeadCoords() {
    return blackDeadCoords;
  }

  public ImmutableSet<Coord> getWhiteDeadCoords() {
    return whiteDeadCoords;
  }

  public static class Builder {
    @SuppressWarnings("unused") private PositionStateBoard positionStateBoard;
    private int blackTerritory = 0;
    private int whiteTerritory = 0;
    private final ImmutableSet.Builder<Coord> blackDeadCoordsBuilder = ImmutableSet.builder();
    private final ImmutableSet.Builder<Coord> whiteDeadCoordsBuilder = ImmutableSet.builder();

    private Builder() {}

    public Builder setPositionStateBoard(@Nonnull PositionStateBoard positionStateBoard) {
      this.positionStateBoard = positionStateBoard;
      return this;
    }

    public EndGameTerritoryWithDeadAnalyzer build() {
      ImmutableSet<Coord> blackDeadCoords = blackDeadCoordsBuilder.build();
      ImmutableSet<Coord> whiteDeadCoords = whiteDeadCoordsBuilder.build();
      return new EndGameTerritoryWithDeadAnalyzer(blackTerritory, whiteTerritory,
          blackDeadCoords, whiteDeadCoords);
    }
  }
}
