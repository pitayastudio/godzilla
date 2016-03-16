package com.pitayastudio.godzilla.modelboard;

import com.pitayastudio.godzilla.model.Lot;
import com.pitayastudio.godzilla.model.LotWithProperty;

import javax.annotation.Nonnull;

/**
 * TODO 300 Implement LotWithPropertyBoard.
 * Immutable board of {@link LotWithProperty}.
 */
public class LotWithPropertyBoard {
  public static Builder newBuilder() {
    return new Builder();
  }

  public static LotWithPropertyBoard readFromString(@Nonnull String boardInput) {
    LotBoard lotBoard = LotBoard.readFromString(boardInput);
    LotWithPropertyBoard lotWithPropertyBoard = LotWithPropertyBoard.newBuilder()
        .setRequiredLotBoard(lotBoard)
        .build();
    return lotWithPropertyBoard;
  }

  private final int boardSize;
  private final LotBoard lotBoard;

  private LotWithPropertyBoard(@Nonnull LotBoard lotBoard) {
    this.lotBoard = lotBoard;
    boardSize = lotBoard.getBoardSize();
  }

  public int getBoardSize() {
    return boardSize;
  }

  public LotBoard getLotBoard() {
    return lotBoard;
  }

  public LotWithProperty getLotWithProperty(@Nonnull Lot lot) {
    // Dummy implementation.
    LotWithProperty lotWithProperty = LotWithProperty.newBuilder()
        .setRequiredColor(lot.getColor())
        .setRequiredLot(lot)
        .build();
    return lotWithProperty;
  }

  public static class Builder {
    private LotBoard lotBoard;

    private Builder() {}

    public Builder setRequiredLotBoard(@Nonnull LotBoard lotBoard) {
      this.lotBoard = lotBoard;
      return this;
    }

    public LotWithPropertyBoard build() {
      assert (null != lotBoard);
      return new LotWithPropertyBoard(lotBoard);
    }
  }
}
