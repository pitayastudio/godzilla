package com.pitayastudio.godzilla.model;

import com.google.common.collect.ImmutableSet;

import com.pitayastudio.godzilla.ArchivedDocs;
import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.modelboard.BlockBoard;
import com.pitayastudio.godzilla.modelboard.LandBoard;
import com.pitayastudio.godzilla.modelboard.LotBoard;
import com.pitayastudio.godzilla.modelboard.NeighborhoodBoard;
import com.pitayastudio.godzilla.modelboard.VisualBoard;

import javax.annotation.Nonnull;

/**
 * TODO 300 Implement {@link LotWithProperty}.
 *
 * @see DesignDoc#lotWithProperty()
 * @see DesignDoc#rimOfLotWithPropertyAndGang()
 * @see ArchivedDocs#baseLotWithProperties()
 */
public class LotWithProperty {
  public static Builder newBuilder() {
    return new Builder();
  }

  public static LotWithProperty readFromString(
      @Nonnull String boardInput,
      @Nonnull LotBoard lotBoard,
      @Nonnull Color color,
      char targetColorChar,
      char targetVacantChar) {
    int boardSize = VisualBoard.getBoardSizeFromBoardInput(boardInput);
    assert(boardSize == lotBoard.getBoardSize());
    LandBoard landBoard = lotBoard.getLandBoard();
    NeighborhoodBoard neighborhoodBoard = landBoard.getNeighborhoodBoard();
    BlockBoard blockBoard = neighborhoodBoard.getBlockBoard();
    Lot lot = Lot.readFromString(boardInput, blockBoard, color, targetColorChar, targetVacantChar);
    LotWithProperty lotWithProperty = LotWithProperty.newBuilder()
        .setRequiredColor(color)
        .setRequiredLot(lot)
        .build();
    return lotWithProperty;
}

  private final Color color;
  private final Lot lot;
  private final ImmutableSet<ClosedProperty> closedProperties;

  private LotWithProperty(
      @Nonnull Color color,
      @Nonnull Lot lot,
      @Nonnull ImmutableSet<ClosedProperty> closedProperties) {
    this.color = color;
    this.lot = lot;
    this.closedProperties = closedProperties;
  }

  public Color getColor() {
    return color;
  }

  public Lot getLot() {
    return lot;
  }

  public ImmutableSet<ClosedProperty> getInternalProperties() {
    return closedProperties;
  }

  public static class Builder {
    private Color color;
    private Lot lot;
    private final ImmutableSet.Builder<ClosedProperty> internalPropertiesBuilder =
        ImmutableSet.builder();

    public Builder setRequiredColor(@Nonnull Color color) {
      this.color = color;
      return this;
    }

    public Builder setRequiredLot(@Nonnull Lot lot) {
      this.lot = lot;
      return this;
    }

    public Builder addClosedProperty(@Nonnull ClosedProperty closedProperty) {
      internalPropertiesBuilder.add(closedProperty);
      return this;
    }

    public LotWithProperty build() {
      assert (null != color);
      assert (null != lot);
      ImmutableSet<ClosedProperty> closedProperties = internalPropertiesBuilder.build();
      return new LotWithProperty(color, lot, closedProperties);
    }
  }
}
