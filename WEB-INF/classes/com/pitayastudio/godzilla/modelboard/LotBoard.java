package com.pitayastudio.godzilla.modelboard;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableSet;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.PositionStateChars;
import com.pitayastudio.godzilla.model.ClosedLand;
import com.pitayastudio.godzilla.model.ColorBlock;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.model.Lot;
import com.pitayastudio.godzilla.model.VacantBlock;

import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nonnull;

/**
 * Immutable board of {@link Lot}.
 */
public class LotBoard {
  public static Builder newBuilder() {
    return new Builder();
  }

  public static LotBoard readFromString(@Nonnull String boardInput) {
    LandBoard landBoard = LandBoard.readFromString(boardInput);
    CoordBoard coordBoard = landBoard.getNeighborhoodBoard().getBlockBoard().getCoordBoard();
    Coord jieDeadCoord =
        Coord.readFromStringIfAny(boardInput, coordBoard, PositionStateChars.VACANT_FOR_JIE_DEAD);
    LotBoard.Builder lotBoardBuilder = LotBoard.newBuilder()
        .setRequiredLandBoard(landBoard);
    if (jieDeadCoord != null) {
      lotBoardBuilder.setCurrentJieDeadCoord(jieDeadCoord);
    }
    return lotBoardBuilder.build();
  }

  private final int boardSize;
  /** TODO 250 LotBoard might need BlockBoard instead of QiBoard. */
  private final LandBoard landBoard;
  private final Optional<Coord> currentJieDeadCoordOptional;
  private final EnumMap<Color, ImmutableSet<Lot>> colorToLotsMap;

  private LotBoard(
      @Nonnull LandBoard landBoard,
      @Nonnull Optional<Coord> currentJieDeadCoordOptional,
      @Nonnull EnumMap<Color, ImmutableSet<Lot>> colorToLotsMap) {
    this.landBoard = landBoard;
    boardSize = landBoard.getBoardSize();
    this.currentJieDeadCoordOptional = currentJieDeadCoordOptional;
    this.colorToLotsMap = colorToLotsMap;
  }

  public int getBoardSize() {
    return boardSize;
  }

  public LandBoard getLandBoard() {
    return landBoard;
  }

  public Optional<Coord> getCurrentJieDeadCoordOptional() {
    return currentJieDeadCoordOptional;
  }

  public Lot getLot(@Nonnull ColorBlock colorBlock) {
    // Dummy implementation.
    Lot dummyLot = Lot.newBuilder()
        .setRequiredColor(Color.B)
        .addColorBlock(colorBlock)
        .build();
    return dummyLot;
  }

  public ImmutableSet<Lot> getLotsOfColor(@Nonnull Color color) {
    return colorToLotsMap.get(color);
  }

  public static class Builder {
    private LandBoard landBoard;
    private Optional<Coord> currentJieDeadCoordOptional;
    private final EnumMap<Color, ImmutableSet<Lot>> colorToLotsMap = new EnumMap<>(Color.class);

    private Builder() {}

    public Builder setRequiredLandBoard(@Nonnull LandBoard landBoard) {
      this.landBoard = landBoard;
      return this;
    }

    public Builder setCurrentJieDeadCoord(@Nonnull Coord coord) {
      currentJieDeadCoordOptional = Optional.of(coord);
      return this;
    }

    public LotBoard build() {
      assert (null != landBoard);
      if (currentJieDeadCoordOptional == null) {
        currentJieDeadCoordOptional = Optional.absent();
      }
      initColorToLotsMap();
      return new LotBoard(landBoard, currentJieDeadCoordOptional, colorToLotsMap);
    }


    /**
     * Finds {@link Lot}s.
     *
     * <p><pre>
     * For each {@link ColorBlock}:
     *     Iterate through each {@link ClosedLand}
     *       create a new {@link Lot} if the {@link ClosedLand} does not belong to any
     *           {@link Lot} yet;
     *       otherwise, add the {@link ClosedLand} to existing {@link Lot}
     * </pre>
     *
     * <p> TODO 250 Refactor performance of LotBoard.findLots().
     *     We probably could use union of Blocks (ColorBlocks + VacantBlocks).
     */
    private void initColorToLotsMap() {
      NeighborhoodBoard neighborhoodBoard = landBoard.getNeighborhoodBoard();
      BlockBoard blockBoard = neighborhoodBoard.getBlockBoard();
      // Iterate through each color (B, W).
      for (Color color : Color.values()) {
        Map<ClosedLand, HashSet<ClosedLand>> closedLandToSetMap = new HashMap<>();
        Set<ColorBlock> colorBlocks = blockBoard.getAllBlocksOfColor(color);
        // Iterate through each ColorBlock.
        for (ColorBlock colorBlock : colorBlocks) {
          ImmutableSet<ClosedLand> closedLands = landBoard.getClosedLandsForColorBlock(colorBlock);

          // Find oldClosedLandSetSetToBeMerged and newClosedLandsToBeAdded.
          Set<HashSet<ClosedLand>> oldClosedLandSetSetToBeMerged = new HashSet<>();
          Set<ClosedLand> newClosedLandsToBeAdded = new HashSet<>();
          for (ClosedLand closedLand : closedLands) {
            if (closedLandToSetMap.containsKey(closedLand)) {
              HashSet<ClosedLand> oldClosedLandSet = closedLandToSetMap.get(closedLand);
              oldClosedLandSetSetToBeMerged.add(oldClosedLandSet);
            } else {
              newClosedLandsToBeAdded.add(closedLand);
            }
          }

          // Determine newClosedLandSet and merge old ones if necessary.
          HashSet<ClosedLand> newClosedLandSet;
          if (oldClosedLandSetSetToBeMerged.isEmpty()) {
            newClosedLandSet = new HashSet<>();
          } else {
            // Update old closedLands:
            // (1) Merge old ClosedLandSet to the new ClosedLandSet.
            // (2) Update maps such that old closedLands map to the new ClosedLandSet.
            Iterator<HashSet<ClosedLand>> oldClosedLandSetSetIterator =
                oldClosedLandSetSetToBeMerged.iterator();
            // Reuse the 1st one, and merge the rest into the 1st one.
            newClosedLandSet = oldClosedLandSetSetIterator.next();
            while (oldClosedLandSetSetIterator.hasNext()) {
              HashSet<ClosedLand> oldClosedLandSet = oldClosedLandSetSetIterator.next();
              newClosedLandSet.addAll(oldClosedLandSet);
              for (ClosedLand oldClosedLand : oldClosedLandSet) {
                closedLandToSetMap.put(oldClosedLand, newClosedLandSet);
              }
            }
          }

          // Process newClosedLandsToBeAdded.
          for (ClosedLand newClosedLand : newClosedLandsToBeAdded) {
            newClosedLandSet.add(newClosedLand);
            closedLandToSetMap.put(newClosedLand, newClosedLandSet);
          }
        }  // end for colorBlock

        // Build all Lots based on found closedLandSetSet.
        Collection<HashSet<ClosedLand>> closedLandSetCollection = closedLandToSetMap.values();
        Set<HashSet<ClosedLand>> closedLandSetSet = ImmutableSet.copyOf(closedLandSetCollection);
        ImmutableSet.Builder<Lot> lotsBuilder = ImmutableSet.builder();
        for (Set<ClosedLand> closedLandSet : closedLandSetSet) {
          Lot.Builder lotBuilder = Lot.newBuilder().setRequiredColor(color);
          for (ClosedLand closedLand : closedLandSet) {
            VacantBlock vacantBlock = closedLand.getVacantBlock();
            Set<ColorBlock> localColorBlocks = closedLand.getColorBlocks();
            lotBuilder.addEnclosedVacantBlock(vacantBlock).addColorBlocks(localColorBlocks);
          }
          Lot lot = lotBuilder.build();
          lotsBuilder.add(lot);
        }
        ImmutableSet<Lot> lots = lotsBuilder.build();
        colorToLotsMap.put(color, lots);
      }  // end for color
    }  // end initColorToLotsMap()
  }
}
