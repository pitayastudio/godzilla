package com.pitayastudio.godzilla.model;

import com.google.common.collect.ImmutableSet;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.Constants;
import com.pitayastudio.godzilla.modelboard.BlockBoard;
import com.pitayastudio.godzilla.modelboard.VisualBoard;

import java.util.Set;

import javax.annotation.Nonnull;

/**
 * TODO 300 Implement Lot.
 * @see DesignDoc#lot()
 */
public class Lot {
  public static Builder newBuilder() {
    return new Builder();
  }

  public static Lot readFromString(
      @Nonnull String boardInput,
      @Nonnull BlockBoard blockBoard,
      @Nonnull Color lotColor,
      char targetColorChar,
      char targetVacantChar) {
    int boardSize = VisualBoard.getBoardSizeFromBoardInput(boardInput);
    assert(boardSize == blockBoard.getBoardSize());
    Lot.Builder lotBuilder = Lot.newBuilder().setRequiredColor(lotColor);
    for (int xPosition = 1; xPosition <= boardSize; xPosition++) {
      for (int yPosition = 1; yPosition <= boardSize; yPosition++) {
        int indexInString = boardSize * (boardSize - yPosition) + xPosition - 1;
        char positionChar = boardInput.charAt(indexInString);
        if (positionChar == targetColorChar) {
          ColorBlock colorBlock = blockBoard.getColorBlock(xPosition, yPosition);
          lotBuilder.addColorBlock(colorBlock);
        } else if (positionChar == targetVacantChar) {
          VacantBlock enclosedVacantBlock = blockBoard.getVacantBlock(xPosition, yPosition);
          lotBuilder.addEnclosedVacantBlock(enclosedVacantBlock);
        }
      }
    }
    return lotBuilder.build();
  }

  public static ImmutableSet<Lot> readLotsFromString(
      @Nonnull String boardInput,
      @Nonnull BlockBoard blockBoard,
      char colorBlockChar) {
    // Dummy implementation.
    Set<ColorBlock> colorBlocks =
        ColorBlock.readColorBlocksFromString(boardInput, blockBoard, colorBlockChar);
    Lot dummyLot = Lot.newBuilder()
        .setRequiredColor(Color.B)
        .addColorBlocks(colorBlocks)
        .build();
    ImmutableSet.Builder<Lot> lotsBuilder = ImmutableSet.builder();
    lotsBuilder.add(dummyLot);
    return lotsBuilder.build();
  }

  private final Color color;
  /**
   * Emptiable enclosed {@link VacantBlock}s.
   */
  private final ImmutableSet<VacantBlock> enclosedVacantBlocks;
  /**
   * Non-empty {@link ColorBlock}s.
   */
  private final ImmutableSet<ColorBlock> colorBlocks;
  private final LotType lotType;
  private final int vacantTerritoryCount;

  private Lot(
      @Nonnull Color color,
      @Nonnull ImmutableSet<ColorBlock> colorBlocks,
      @Nonnull ImmutableSet<VacantBlock> enclosedVacantBlocks,
      @Nonnull LotType lotType,
      int vacantTerritoryCount) {
    this.color = color;
    this.colorBlocks = colorBlocks;
    this.enclosedVacantBlocks = enclosedVacantBlocks;
    this.lotType = lotType;
    this.vacantTerritoryCount = vacantTerritoryCount;
  }

  public Color getColor() {
    return color;
  }

  public ImmutableSet<ColorBlock> getColorBlocks() {
    return colorBlocks;
  }

  public ImmutableSet<VacantBlock> getEnclosedVacantBlocks() {
    return enclosedVacantBlocks;
  }

  public LotType getLotType() {
    return lotType;
  }

  public int getVacantTerritoryCount() {
    return vacantTerritoryCount;
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
    private final ImmutableSet.Builder<ColorBlock> colorBlocksBuilder;
    private final ImmutableSet.Builder<VacantBlock> enclosedVacantBlocksBuilder;
    private LotType lotType;

    private Builder() {
      colorBlocksBuilder = ImmutableSet.builder();
      enclosedVacantBlocksBuilder = ImmutableSet.builder();
    }

    public Builder setRequiredColor(@Nonnull Color color) {
      this.color = color;
      return this;
    }

    /**
     * Adds a {@link ColorBlock} to a set.
     */
    public Builder addColorBlock(@Nonnull ColorBlock colorBlock) {
      colorBlocksBuilder.add(colorBlock);
      return this;
    }

    public Builder addColorBlocks(@Nonnull Iterable<ColorBlock> colorBlocks) {
      colorBlocksBuilder.addAll(colorBlocks);
      return this;
    }

    /**
     * Adds an enclosed {@link VacantBlock} to a set.
     */
    public Builder addEnclosedVacantBlock(@Nonnull VacantBlock vacantBlock) {
      enclosedVacantBlocksBuilder.add(vacantBlock);
      return this;
    }

    public Lot build() {
      // Dummy implementation.
      color = Color.B;
      assert (null != color);
      ImmutableSet<VacantBlock> enclosedVacantBlocks = enclosedVacantBlocksBuilder.build();
      ImmutableSet<ColorBlock> colorBlocks = colorBlocksBuilder.build();
      assert(!colorBlocks.isEmpty());
      lotType = LotType.LIVE;
      int vacantTerritoryCount = countVacantTerritory(enclosedVacantBlocks);
      return new Lot(color, colorBlocks, enclosedVacantBlocks, lotType, vacantTerritoryCount);
    }

    private static int countVacantTerritory(@Nonnull ImmutableSet<VacantBlock> enclosedVacantBlocks) {
      int count = 0;
      for (VacantBlock vacantBlock : enclosedVacantBlocks) {
        count += vacantBlock.size();
      }
      return count;
    }
  }
}
