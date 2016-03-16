package com.pitayastudio.godzilla.modelboard;

import com.google.common.collect.ImmutableSet;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.model.ClosedLand;
import com.pitayastudio.godzilla.model.ColorBlock;
import com.pitayastudio.godzilla.model.LotPlus;
import com.pitayastudio.godzilla.model.OpenLand;

import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nonnull;

@Deprecated public class LotPlusBoard {
  public static Builder newBuilder() {
    return new Builder();
  }

  public static LotPlusBoard readFromString(@Nonnull String boardInput) {
    LotPlusBoard.Builder boardBuilder = LotPlusBoard.newBuilder();
    LandBoard landBoard = LandBoard.readFromString(boardInput);
    boardBuilder.setQiLotBoard(landBoard);
    LotPlusBoard board = boardBuilder.build();
    return board;
  }

  private final EnumMap<Color, ImmutableSet<LotPlus>> colorToLotPlusesMap;

  private LotPlusBoard(
      @Nonnull EnumMap<Color, ImmutableSet<LotPlus>> colorToLotPlusesMap) {
    this.colorToLotPlusesMap = colorToLotPlusesMap;
  }

  public ImmutableSet<LotPlus> getLotPlusesOfColor(@Nonnull Color color) {
    return colorToLotPlusesMap.get(color);
  }

  public static class Builder {
    private LandBoard landBoard;
    private final EnumMap<Color, ImmutableSet<LotPlus>> colorToLotPlusesMap;

    private Builder() {
      colorToLotPlusesMap = new EnumMap<>(Color.class);
    }

    public Builder setQiLotBoard(@Nonnull LandBoard landBoard) {
      this.landBoard = landBoard;
      return this;
    }

    public LotPlusBoard build() {
      findLotPluses();
      return new LotPlusBoard(colorToLotPlusesMap);
    }

    /**
     * Finds {@link LotPlus}es.
     *
     * <p><pre>
     * For each {@link ColorBlock},
     *   if it belongs to any {@link ClosedLand},
     *     Iterate through each {@link ClosedLand}
     *       create a new {@link LotPlus} if the {@link ClosedLand} does not belong to any
     *           {@link LotPlus} yet;
     *       otherwise, add the {@link ClosedLand} to existing {@link LotPlus}
     * </pre>
     */
    private void findLotPluses() {
      NeighborhoodBoard neighborhoodBoard = landBoard.getNeighborhoodBoard();
      BlockBoard blockBoard = neighborhoodBoard.getBlockBoard();
      // Iterate through each color (B, W).
      for (Color color : Color.values()) {
        Map<ClosedLand, LotPlus.Builder> closedLandToLotPlusBuilderMap = new HashMap<>();
        Map<OpenLand, LotPlus.Builder> openLandToLotPlusBuilderMap = new HashMap<>();
        Set<ColorBlock> colorBlocks = blockBoard.getAllBlocksOfColor(color);
        // Iterate through each ColorBlock.
        for (ColorBlock colorBlock : colorBlocks) {
          ImmutableSet<ClosedLand> closedLands =
              landBoard.getClosedLandsForColorBlock(colorBlock);
          ImmutableSet<OpenLand> openLands =
              landBoard.getOpenLandsForColorBlock(colorBlock);

          // Find oldLotPlusBuilders, newClosedLands, newOpenLands.
          Set<LotPlus.Builder> oldLotPlusBuildersToBeMerged = new HashSet<>();
          Set<ClosedLand> newClosedLands = new HashSet<>();
          Set<OpenLand> newOpenLands = new HashSet<>();
          for (ClosedLand closedLand : closedLands) {
            if (closedLandToLotPlusBuilderMap.containsKey(closedLand)) {
              LotPlus.Builder oldLotPlusBuilder = closedLandToLotPlusBuilderMap.get(closedLand);
              oldLotPlusBuildersToBeMerged.add(oldLotPlusBuilder);
            } else {
              newClosedLands.add(closedLand);
            }
          }
          for (OpenLand openLand : openLands) {
            if (openLandToLotPlusBuilderMap.containsKey(openLand)) {
              LotPlus.Builder oldLotPlusBuilder = openLandToLotPlusBuilderMap.get(openLand);
              oldLotPlusBuildersToBeMerged.add(oldLotPlusBuilder);
            } else {
              newOpenLands.add(openLand);
            }
          }

          // Determine newLotPlusBuilder and merge old ones if necessary.
          LotPlus.Builder newLotPlusBuilder;
          if (oldLotPlusBuildersToBeMerged.isEmpty()) {
            newLotPlusBuilder = LotPlus.newBuilder().setColor(color);
          } else {
            // Update old qiLots:
            // (1) Merge old lotPluses to the new lotPlus.
            // (2) Update maps such that old QiLots map to the new lotPlus.
            Iterator<LotPlus.Builder> oldLotPlusBuilderIterator =
                oldLotPlusBuildersToBeMerged.iterator();
            // Reuse the 1st one, and merge the rest into the 1st one.
            newLotPlusBuilder = oldLotPlusBuilderIterator.next();
            while (oldLotPlusBuilderIterator.hasNext()) {
              LotPlus.Builder oldLotPlusBuilder = oldLotPlusBuilderIterator.next();

              ImmutableSet<ClosedLand> oldClosedLands = oldLotPlusBuilder.getClosedLandsAggregatedSoFar();
              newLotPlusBuilder.addClosedLands(oldClosedLands);
              for (ClosedLand oldClosedLand : oldClosedLands) {
                closedLandToLotPlusBuilderMap.put(oldClosedLand, newLotPlusBuilder);
              }

              ImmutableSet<OpenLand> oldOpenLands =
                  oldLotPlusBuilder.getOpenLandsAggregatedSoFar();
              newLotPlusBuilder.addOpenLands(oldOpenLands);
              for (OpenLand oldOpenLand : oldOpenLands) {
                openLandToLotPlusBuilderMap.put(oldOpenLand, newLotPlusBuilder);
              }
            }
          }

          // Process newClosedLands.
          for (ClosedLand newClosedLand : newClosedLands) {
            newLotPlusBuilder.addClosedLand(newClosedLand);
            closedLandToLotPlusBuilderMap.put(newClosedLand, newLotPlusBuilder);
          }
          for (OpenLand newOpenLand : newOpenLands) {
            newLotPlusBuilder.addOpenLand(newOpenLand);
            openLandToLotPlusBuilderMap.put(newOpenLand, newLotPlusBuilder);
          }
        }  // end for colorBlock

        // Build all lotPluses found.
        Set<LotPlus.Builder> allLotPlusBuilders = new HashSet<>();
        Collection<LotPlus.Builder> lotPlusBuildersFromClosedLand =
            closedLandToLotPlusBuilderMap.values();
        allLotPlusBuilders.addAll(lotPlusBuildersFromClosedLand);
        Collection<LotPlus.Builder> lotBuildersFromOpenLand =
            openLandToLotPlusBuilderMap.values();
        allLotPlusBuilders.addAll(lotBuildersFromOpenLand);
        ImmutableSet.Builder<LotPlus> lotPlusesBuilder = ImmutableSet.builder();
        for (LotPlus.Builder builder : allLotPlusBuilders) {
          lotPlusesBuilder.add(builder.build());
        }
        colorToLotPlusesMap.put(color, lotPlusesBuilder.build());
      }  // end for color
    }  // end findLotPluses()
  }  // end Builder
}
