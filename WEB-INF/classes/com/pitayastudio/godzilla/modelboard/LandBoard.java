package com.pitayastudio.godzilla.modelboard;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.model.ClosedLand;
import com.pitayastudio.godzilla.model.ColorBlock;
import com.pitayastudio.godzilla.model.Land;
import com.pitayastudio.godzilla.model.LandType;
import com.pitayastudio.godzilla.model.OpenLand;
import com.pitayastudio.godzilla.model.VacantBlock;

import javax.annotation.Nonnull;

/**
 * Immutable board of {@link Land}.
 *
 * @see Land
 */
public class LandBoard {
  public static Builder newBuilder() {
    return new Builder();
  }

  public static LandBoard readFromString(@Nonnull String boardInput) {
    NeighborhoodBoard neighborhoodBoard = NeighborhoodBoard.readFromString(boardInput);
    Builder builder = new Builder();
    builder.setNeighborhoodBoard(neighborhoodBoard );
    return builder.build();
  }

  private final int boardSize;
  private final NeighborhoodBoard neighborhoodBoard;
  private final ImmutableMultimap<ColorBlock, ClosedLand> colorBlockToClosedLandsMap;
  private final ImmutableMultimap<ColorBlock, OpenLand> colorBlockToOpenLandsMap;

  private LandBoard(
      @Nonnull NeighborhoodBoard neighborhoodBoard,
      @Nonnull ImmutableMultimap<ColorBlock, ClosedLand> colorBlockToClosedLandsMap,
      @Nonnull ImmutableMultimap<ColorBlock, OpenLand> colorBlockToOpenLandsMap) {
    this.neighborhoodBoard = neighborhoodBoard;
    this.colorBlockToClosedLandsMap = colorBlockToClosedLandsMap;
    this.colorBlockToOpenLandsMap = colorBlockToOpenLandsMap;
    boardSize = neighborhoodBoard.getBlockBoard().getBoardSize();
  }

  public int getBoardSize() {
    return boardSize;
  }

  public NeighborhoodBoard getNeighborhoodBoard() {
    return neighborhoodBoard;
  }

  /**
   * TODO 250 Implement LandBoard.getLand()
   */
  public Land getLand(@SuppressWarnings("unused") @Nonnull VacantBlock targetVacantBlock) {
    return null;
  }

  /**
   * TODO 250 Implement LandBoard.getType()
   */
  @Nonnull public LandType getType(@SuppressWarnings("unused") Land targetLand) {
    return LandType.TRUE_EYE;
  }

  @Nonnull
  public ImmutableSet<ClosedLand> getClosedLandsForColorBlock(@Nonnull ColorBlock colorBlock) {
    ImmutableCollection<ClosedLand> closedLands = colorBlockToClosedLandsMap.get(colorBlock);
    return ImmutableSet.copyOf(closedLands);
  }

  /** @see com.pitayastudio.godzilla.model.DesignDoc#land() */
  @Nonnull public ImmutableSet<OpenLand> getOpenLandsForColorBlock(
      @Nonnull ColorBlock colorBlock) {
    // The returned openLands is never null.
    ImmutableCollection<OpenLand> openLands =
        colorBlockToOpenLandsMap.get(colorBlock);
    assert(openLands.size() <= 2);
    return ImmutableSet.copyOf(openLands);
  }

  public ImmutableSet<ClosedLand> getClosedLands() {
    return ImmutableSet.copyOf(colorBlockToClosedLandsMap.values());
  }

  public ImmutableSet<OpenLand> getOpenLands() {
    return ImmutableSet.copyOf(colorBlockToOpenLandsMap.values());
  }

  public static class Builder {
    private NeighborhoodBoard neighborhoodBoard;
    private final ImmutableMultimap.Builder<ColorBlock, ClosedLand>
        colorBlockToClosedLandsMapBuilder = ImmutableMultimap.builder();
    private final ImmutableMultimap.Builder<ColorBlock, OpenLand>
        colorBlockToOpenLandsMapBuilder = ImmutableMultimap.builder();

    public Builder setNeighborhoodBoard(@Nonnull NeighborhoodBoard neighborhoodBoard) {
      this.neighborhoodBoard = neighborhoodBoard;
      return this;
    }

    /**
     * Builds {@link LandBoard}.
     */
    public LandBoard build() {
      findLands();
      return new LandBoard(
          neighborhoodBoard,
          colorBlockToClosedLandsMapBuilder.build(),
          colorBlockToOpenLandsMapBuilder.build());
    }

    /**
     * Finds {@link Land}s.
     *
     * <p>Iterate each {@link VacantBlock}:
     * <ul>
     *   <li>If it is enclosed by only one color, create a new {@link ClosedLand}.
     *   <li>Else, create a new {@link OpenLand}.
     * </ul>
     */
    private void findLands() {
      BlockBoard blockBoard = neighborhoodBoard.getBlockBoard();
      ImmutableSet<VacantBlock> allVacantBlocks = blockBoard.getAllVacantBlocks();
      for (VacantBlock vacantBlock : allVacantBlocks) {
        ImmutableSet<ColorBlock> blackBlocks =
            neighborhoodBoard.getNeighborBlocksOfColorForVacantBlock(Color.B, vacantBlock);
        ImmutableSet<ColorBlock> whiteBlocks =
            neighborhoodBoard.getNeighborBlocksOfColorForVacantBlock(Color.W, vacantBlock);
        if (blackBlocks.isEmpty()) {
          if (whiteBlocks.isEmpty()) {
            // Everything is vacant. Do nothing.
          } else {
            ClosedLand closedLand = ClosedLand.newBuilder()
                .setRequiredColor(Color.W)
                .setRequiredVacantBlock(vacantBlock)
                .addColorBlocks(whiteBlocks)
                .build();
            for (ColorBlock colorBlock : whiteBlocks) {
              colorBlockToClosedLandsMapBuilder.put(colorBlock, closedLand);
            }
          }
        } else {  // blackBlocks is not empty
          if (whiteBlocks.isEmpty()) {
            ClosedLand closedLand = ClosedLand.newBuilder()
                .setRequiredColor(Color.B)
                .setRequiredVacantBlock(vacantBlock)
                .addColorBlocks(blackBlocks)
                .build();
            for (ColorBlock colorBlock : blackBlocks) {
              colorBlockToClosedLandsMapBuilder.put(colorBlock, closedLand);
            }
          } else {  // both blackBlocks and whiteBlocks are not empty
            // At ChinaEndGame, this case should be a Seki.
            OpenLand openLand = OpenLand.newBuilder()
                .setRequiredVacantBlock(vacantBlock)
                .addBlackBlocks(blackBlocks)
                .addWhiteBlocks(whiteBlocks)
                .build();
            for (ColorBlock colorBlock : blackBlocks) {
              colorBlockToOpenLandsMapBuilder.put(colorBlock, openLand);
            }
            for (ColorBlock colorBlock : whiteBlocks) {
              colorBlockToOpenLandsMapBuilder.put(colorBlock, openLand);
            }
          }
        }
      }
    }
  }
}
