package com.pitayastudio.godzilla.modelboard;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.model.Gang;
import com.pitayastudio.godzilla.model.LotWithProperty;

import javax.annotation.Nonnull;

/**
 * Immutable board of {@link Gang}.
 *
 * <p>TODO 300 Implement GangBoard.
 * @see com.pitayastudio.godzilla.model.DesignDoc#gang()
 * @see com.pitayastudio.godzilla.level.DesignDoc#liveLevel()
 */
public class GangBoard {
  public static Builder newBuilder() {
    return new Builder();
  }

  public static GangBoard readFromString(@Nonnull String boardInput) {
    LotWithPropertyBoard lotWithPropertyBoard = LotWithPropertyBoard.readFromString(boardInput);
    GangBoard board = GangBoard.newBuilder()
        .setLotWithPropertyBoard(lotWithPropertyBoard)
        .build();
    return board;
  }

  private final int boardSize;
  private final LotWithPropertyBoard lotWithPropertyBoard;

  private GangBoard(@Nonnull LotWithPropertyBoard lotWithPropertyBoard) {
    this.lotWithPropertyBoard = lotWithPropertyBoard;
    boardSize = lotWithPropertyBoard.getBoardSize();
  }

  public int getBoardSize() {
    return boardSize;
  }

  public LotWithPropertyBoard getLotWithPropertyBoard() {
    return lotWithPropertyBoard;
  }

  public Gang getGang(@Nonnull LotWithProperty lotWithProperty) {
    Color color = lotWithProperty.getColor();
    // Dummy implementation.
    Gang dummyGang = Gang.newBuilder()
        .setRequiredColor(color)
        .addLotWithProperty(lotWithProperty)
        .build();
    return dummyGang;
  }

  public static class Builder {
    private LotWithPropertyBoard lotWithPropertyBoard;

    private Builder() {}

    public Builder setLotWithPropertyBoard(@Nonnull LotWithPropertyBoard lotWithPropertyBoard) {
      this.lotWithPropertyBoard = lotWithPropertyBoard;
      return this;
    }

    public GangBoard build() {
      return new GangBoard(lotWithPropertyBoard);
    }
  }
}
