package com.pitayastudio.godzilla.model;

import com.google.common.collect.ImmutableSet;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.Constants;
import com.pitayastudio.godzilla.modelboard.BlockBoard;
import com.pitayastudio.godzilla.modelboard.GangBoard;
import com.pitayastudio.godzilla.modelboard.LandBoard;
import com.pitayastudio.godzilla.modelboard.LotBoard;
import com.pitayastudio.godzilla.modelboard.LotWithPropertyBoard;
import com.pitayastudio.godzilla.modelboard.NeighborhoodBoard;
import com.pitayastudio.godzilla.modelboard.VisualBoard;

import javax.annotation.Nonnull;

/**
 * TODO 300 Implement Gang.
 * @see DesignDoc#gang
 * @see DesignDoc#rimOfLotWithPropertyAndGang
 */
public class Gang {
  public static Builder newBuilder() {
    return new Builder();
  }

  public static Gang readFromString(
      @Nonnull String boardInput,
      @Nonnull GangBoard gangBoard,
      @Nonnull Color color,
      char targetColorChar,
      char targetVacantChar) {
    int boardSize = VisualBoard.getBoardSizeFromBoardInput(boardInput);
    LotWithPropertyBoard lotWithPropertyBoard = gangBoard.getLotWithPropertyBoard();
    LotBoard lotBoard = lotWithPropertyBoard.getLotBoard();
    lotBoard.getBoardSize();
    assert(boardSize == lotBoard.getBoardSize());

    LotWithProperty lotWithProperty = LotWithProperty.readFromString(
        boardInput, lotBoard, color, targetColorChar, targetVacantChar);
    Gang gang = Gang.newBuilder()
        .setRequiredColor(color)
        .addLotWithProperty(lotWithProperty)
        .build();
    return gang;
  }

  public static ImmutableSet<Gang> readGangsFromString(
      @Nonnull String boardInput,
      @Nonnull GangBoard gangBoard,
      @Nonnull Color color,
      char targetColorChar,
      @SuppressWarnings("unused") char targetVacantChar) {
    // Dummy implementation.
    LotWithPropertyBoard lotWithPropertyBoard = gangBoard.getLotWithPropertyBoard();
    LotBoard lotBoard = lotWithPropertyBoard.getLotBoard();
    LandBoard landBoard = lotBoard.getLandBoard();
    NeighborhoodBoard neighborhoodBoard = landBoard.getNeighborhoodBoard();
    BlockBoard blockBoard = neighborhoodBoard.getBlockBoard();
    ImmutableSet<ColorBlock> colorBlocks =
        ColorBlock.readColorBlocksFromString(boardInput, blockBoard, targetColorChar);
    ImmutableSet.Builder<Gang> gangsBuilder = ImmutableSet.builder();
    for (ColorBlock colorBlock : colorBlocks) {
      Lot lot = Lot.newBuilder()
          .setRequiredColor(color)
          .addColorBlock(colorBlock)
          .build();
      LotWithProperty lotWithProperty = LotWithProperty.newBuilder()
          .setRequiredColor(color)
          .setRequiredLot(lot)
          .build();
      Gang gang = Gang.newBuilder()
          .setRequiredColor(color)
          .addLotWithProperty(lotWithProperty )
          .build();
      gangsBuilder.add(gang);
    }
    return gangsBuilder.build();
  }

  private final Color color;
  private final ImmutableSet<LotWithProperty> linkedLotWithPropertySet;
  private final ImmutableSet<OpenProperty> openProperties;
  private final GangType gangType;

  private Gang(
      @Nonnull Color color,
      @Nonnull ImmutableSet<LotWithProperty> linkedLotWithPropertySet,
      @Nonnull ImmutableSet<OpenProperty> openProperties,
      @Nonnull GangType gangType) {
    this.color = color;
    this.linkedLotWithPropertySet = linkedLotWithPropertySet;
    this.openProperties = openProperties;
    this.gangType = gangType;
  }

  public Color getColor() {
    return color;
  }

  public ImmutableSet<LotWithProperty> getLinkedLotWithPropertySet() {
    return linkedLotWithPropertySet;
  }

  public ImmutableSet<OpenProperty> getExternalProperties() {
    return openProperties;
  }

  public GangType getGangType() {
    return gangType;
  }

  @Override public String toString() {
    return toString(Constants.BOARD_SIZE_19);
  }

  public String toString(int boardSize) {
    VisualBoard visualBoard = new VisualBoard(boardSize);
    return visualBoard.toString();
  }

  public static class Builder {
    private Color color;
    private final ImmutableSet.Builder<LotWithProperty> linkedLotWithPropertySetBuilder =
        ImmutableSet.builder();
    private final ImmutableSet.Builder<OpenProperty> externalPropertiesBuilder =
        ImmutableSet.builder();
    private GangType gangType;

    private Builder() {}

    public Builder setRequiredColor(@Nonnull Color color) {
      this.color = color;
      return this;
    }

    public Builder addLotWithProperty(@Nonnull LotWithProperty lotWithProperty) {
      linkedLotWithPropertySetBuilder.add(lotWithProperty);
      return this;
    }

    /**
     * Adds an {@link OpenProperty} to a set.
     */
    public Builder addOpenProperty(@Nonnull OpenProperty openProperty) {
      externalPropertiesBuilder.add(openProperty);
      return this;
    }

    public Gang build() {
      // Dummy implementation.
      assert (null != color);
      ImmutableSet<LotWithProperty> linkedLotWithPropertySet =
          linkedLotWithPropertySetBuilder.build();
      assert(!linkedLotWithPropertySet.isEmpty());
      ImmutableSet<OpenProperty> openProperties = externalPropertiesBuilder.build();
      gangType = GangType.LIVE;
      return new Gang(color, linkedLotWithPropertySet, openProperties, gangType);
    }
  }
}
