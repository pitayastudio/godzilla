package com.pitayastudio.godzilla.modelboard;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.PositionState;
import com.pitayastudio.godzilla.model.ColorBlock;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.model.VacantBlock;

import java.util.Set;

import javax.annotation.Nonnull;

/**
 * Immutable board.
 * Note: minimize building a {@link NeighborhoodBoard} because it is expensive.
 * See {@link Builder#buildNeighborhoods()} on why its performance is slow.
 */
public class NeighborhoodBoard {
  public static Builder newBuilder() {
    return new Builder();
  }

  public static NeighborhoodBoard readFromString(@Nonnull String boardInput) {
    BlockBoard blockBoard = BlockBoard.readFromString(boardInput);
    NeighborhoodBoard neighborhoodBoard = NeighborhoodBoard.newBuilder()
        .setRequiredBlockBoard(blockBoard)
        .build();
    return neighborhoodBoard;
  }

  private final BlockBoard blockBoard;
  private final ImmutableSetMultimap<ColorBlock, ColorBlock> multiMapFromColorToFoeBlocks;
  private final ImmutableSetMultimap<ColorBlock, VacantBlock> multiMapFromColorToVacantBlocks;
  private final ImmutableSetMultimap<VacantBlock, ColorBlock> multiMapFromVacantToBlackBlocks;
  private final ImmutableSetMultimap<VacantBlock, ColorBlock> multiMapFromVacantToWhiteBlocks;

  private NeighborhoodBoard(@Nonnull Builder builder) {
    this.blockBoard = builder.blockBoard;
    this.multiMapFromColorToFoeBlocks =
        ImmutableSetMultimap.copyOf(builder.multiMapFromColorToFoeBlocks);
    this.multiMapFromColorToVacantBlocks =
        ImmutableSetMultimap.copyOf(builder.multiMapFromColorToVacantBlocks);
    this.multiMapFromVacantToBlackBlocks =
        ImmutableSetMultimap.copyOf(builder.multiMapFromVacantToBlackBlocks);
    this.multiMapFromVacantToWhiteBlocks =
        ImmutableSetMultimap.copyOf(builder.multiMapFromVacantToWhiteBlocks);
  }

  public BlockBoard getBlockBoard() {
    return blockBoard;
  }

  public ImmutableSet<ColorBlock> getNeighborBlocksOfColorForVacantBlock(
      @Nonnull Color color, @Nonnull VacantBlock vacantBlock) {
    if (color == Color.B) {
      return multiMapFromVacantToBlackBlocks.get(vacantBlock);
    } else {
      return multiMapFromVacantToWhiteBlocks.get(vacantBlock);
    }
  }

  @VisibleForTesting
  public ImmutableSet<ColorBlock> getNeighborFoeBlocks(@Nonnull ColorBlock colorBlock) {
    return this.multiMapFromColorToFoeBlocks.get(colorBlock);
  }

  @VisibleForTesting
  ImmutableSet<VacantBlock> getNeighborVacantBlocks(@Nonnull ColorBlock colorBlock) {
    return this.multiMapFromColorToVacantBlocks.get(colorBlock);
  }

  @VisibleForTesting
  String drawBlockAtCoordWithNeighborhoods(int i, int j) {
    return drawBlockAtCoordWithNeighborhoods(blockBoard.getCoordBoard().getCoord(i, j));
  }

  /** Used for Testing. */
  private String drawBlockAtCoordWithNeighborhoods(@Nonnull Coord coord) {
    PositionState positionState = blockBoard.getPositionStateBoard().getPositionState(coord);
    switch (positionState) {
      case BLACK:
      case WHITE: {
        ColorBlock colorBlock =
            blockBoard.getColorBlock(coord.getXPosition(), coord.getYPosition());
        return drawColorBlockWithNeighborhoods(colorBlock);
      }
      case VACANT: {
        VacantBlock vacantBlock =
            blockBoard.getVacantBlock(coord.getXPosition(), coord.getYPosition());
        return drawVacantBlockWithNeighborhoods(vacantBlock);
      }
      default:
        throw new IllegalArgumentException("Invalid positionState: " + positionState);
    }
  }

  @VisibleForTesting
  String drawVacantBlockWithNeighborhoods(@Nonnull VacantBlock vacantBlock) {
    VisualBoard visualBoard = new VisualBoard(blockBoard.getBoardSize());
    visualBoard.updateBoardStateWithVacantBlock(vacantBlock, true);
    for (Color color : Color.values()) {
      Set<ColorBlock> colorBlocks = getNeighborBlocksOfColorForVacantBlock(color, vacantBlock);
      for (ColorBlock colorBlock : colorBlocks) {
        visualBoard.updateBoardStateWithColorBlock(colorBlock, false);
      }
    }
    return visualBoard.toString();
  }

  /** Used for Testing. */
  private String drawColorBlockWithNeighborhoods(@Nonnull ColorBlock colorBlock) {
    VisualBoard visualBoard = new VisualBoard(blockBoard.getBoardSize());
    visualBoard.updateBoardStateWithColorBlock(colorBlock, true);
    Set<ColorBlock> neighborColorBlocks = getNeighborFoeBlocks(colorBlock);
    for (ColorBlock neighborColorBlock : neighborColorBlocks) {
      visualBoard.updateBoardStateWithColorBlock(neighborColorBlock, false);
    }
    Set<VacantBlock> neighborVacantBlocks = getNeighborVacantBlocks(colorBlock);
    for (VacantBlock neighborVacantBlock : neighborVacantBlocks) {
      visualBoard.updateBoardStateWithVacantBlock(neighborVacantBlock, true);
    }
    return visualBoard.toString();
  }

  public static class Builder {
    private BlockBoard blockBoard;
    private PositionStateBoard positionStateBoard;
    private int boardSize;
    private final HashMultimap<ColorBlock, VacantBlock> multiMapFromColorToVacantBlocks =
        HashMultimap.create();
    private final HashMultimap<ColorBlock, ColorBlock> multiMapFromColorToFoeBlocks =
        HashMultimap.create();
    private final HashMultimap<VacantBlock, ColorBlock> multiMapFromVacantToBlackBlocks =
        HashMultimap.create();
    private final HashMultimap<VacantBlock, ColorBlock> multiMapFromVacantToWhiteBlocks =
        HashMultimap.create();

    private Builder() {}

    public Builder setRequiredBlockBoard(@Nonnull BlockBoard blockBoard) {
      this.blockBoard = blockBoard;
      return this;
    }

    public NeighborhoodBoard build() {
      assert (null != blockBoard);
      positionStateBoard = blockBoard.getPositionStateBoard();
      boardSize = blockBoard.getBoardSize();

      buildNeighborhoods();
      return new NeighborhoodBoard(this);
    }

    /**
     * Note: the performance here is bad. So, minimize building a NeighborhoodBoard.
     */
    private void buildNeighborhoods() {
      // Handle x = 1, y = 2..N
      for (int y = 2; y <= boardSize; y++) {
        buildNeighborhoodIfAnyForThisPositAndPrevPosit(1, y, 1, y - 1);
      }

      // Handle y = 1, x = 2..N
      for (int x = 2; x <= boardSize; x++) {
        buildNeighborhoodIfAnyForThisPositAndPrevPosit(x, 1, x - 1, 1);
      }  // end for i

      // Handle x = 2..N, y = 2..N
      for (int x = 2; x <= boardSize; x++) {
        for (int y = 2; y <= boardSize; y++) {
          buildNeighborhoodIfAnyForThisPositAndPrevPosit(x, y, x - 1, y);

          // Create neighborhood between this coord and yPrevCoord
          // only when both previous Coords are of different Blocks.
          if (blockBoard.getBlock(x - 1, y) != blockBoard.getBlock(x, y - 1)) {
            buildNeighborhoodIfAnyForThisPositAndPrevPosit(x, y, x, y - 1);
          }
        }  // end for j
      }  // end for i
    }

    private void buildNeighborhoodIfAnyForThisPositAndPrevPosit(
        int thisX, int thisY, int prevX, int prevY) {
      PositionState thisPositState = positionStateBoard.getPositionState(thisX, thisY);
      PositionState prevPositState = positionStateBoard.getPositionState(prevX, prevY);
      if (thisPositState == prevPositState) {
        // Neighborhood does not exist between two Blocks of the same PositState.
        return;
      }

      // Create neighborhood if not created yet.
      if (thisPositState == PositionState.VACANT && prevPositState == PositionState.BLACK) {
        ColorBlock blackBlock = blockBoard.getColorBlock(prevX, prevY);
        VacantBlock vacantBlock = blockBoard.getVacantBlock(thisX, thisY);
        this.multiMapFromColorToVacantBlocks.put(blackBlock, vacantBlock);
        this.multiMapFromVacantToBlackBlocks.put(vacantBlock, blackBlock);
      } else if (thisPositState == PositionState.VACANT && prevPositState == PositionState.WHITE) {
        ColorBlock whiteBlock = blockBoard.getColorBlock(prevX, prevY);
        VacantBlock vacantBlock = blockBoard.getVacantBlock(thisX, thisY);
        this.multiMapFromColorToVacantBlocks.put(whiteBlock, vacantBlock);
        this.multiMapFromVacantToWhiteBlocks.put(vacantBlock, whiteBlock);
      } else if (thisPositState == PositionState.BLACK && prevPositState == PositionState.VACANT) {
        ColorBlock blackBlock = blockBoard.getColorBlock(thisX, thisY);
        VacantBlock vacantBlock = blockBoard.getVacantBlock(prevX, prevY);
        this.multiMapFromColorToVacantBlocks.put(blackBlock, vacantBlock);
        this.multiMapFromVacantToBlackBlocks.put(vacantBlock, blackBlock);
      } else if (thisPositState == PositionState.BLACK && prevPositState == PositionState.WHITE) {
        ColorBlock blackBlock = blockBoard.getColorBlock(thisX, thisY);
        ColorBlock whiteBlock = blockBoard.getColorBlock(prevX, prevY);
        this.multiMapFromColorToFoeBlocks.put(blackBlock, whiteBlock);
        this.multiMapFromColorToFoeBlocks.put(whiteBlock, blackBlock);
      } else if (thisPositState == PositionState.WHITE && prevPositState == PositionState.VACANT) {
        ColorBlock whiteBlock = blockBoard.getColorBlock(thisX, thisY);
        VacantBlock vacantBlock = blockBoard.getVacantBlock(prevX, prevY);
        this.multiMapFromColorToVacantBlocks.put(whiteBlock, vacantBlock);
        this.multiMapFromVacantToWhiteBlocks.put(vacantBlock, whiteBlock);
      } else if (thisPositState == PositionState.WHITE && prevPositState == PositionState.BLACK) {
        ColorBlock blackBlock = blockBoard.getColorBlock(prevX, prevY);
        ColorBlock whiteBlock = blockBoard.getColorBlock(thisX, thisY);
        this.multiMapFromColorToFoeBlocks.put(blackBlock, whiteBlock);
        this.multiMapFromColorToFoeBlocks.put(whiteBlock, blackBlock);
      }
    }  // end buildNeighborhoodIfAnyForThisPositAndPrevPosit
  }  // end Builder
}
