package com.pitayastudio.godzilla.modelboard;

import com.google.common.collect.ImmutableSet;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.Direction;
import com.pitayastudio.godzilla.common.PositionState;
import com.pitayastudio.godzilla.common.PositionStateChars;
import com.pitayastudio.godzilla.common.Utils;
import com.pitayastudio.godzilla.computerplayer.MctsOneMoveEngineLargeTest;
import com.pitayastudio.godzilla.model.Block;
import com.pitayastudio.godzilla.model.ColorBlock;
import com.pitayastudio.godzilla.model.Coord;

import java.util.Stack;
import java.util.logging.Logger;

import javax.annotation.Nonnull;

/**
 * Immutable board of {@link PositionState}.
 *
 * <p>To calculate required number of bits for storing position states on a NxN board:
 * (1) count of positions: (2 + N) x (2 + N)
 * (2) states per position: 4
 * => Total of 4(2 + N)(2 + N) bits.
 * For a 19x19 board, it will be 4x21x21 = 1,764 bits.
 *
 * <p>A long is 64 bits. An int is 32 bits. A byte is 8 bits.
 *
 * <p>Note that when a byte is involved in any operation (arithmetic,
 * comparison, bitwise, or shift operation), it will first be casted to an "int".
 *
 * <p>Use 1 long (64 bits) to hold 4 states (2 bits) for all positions.
 *
 * <p>Whether enable IS_STORAGE_TYPE_LONG or not, the performance seems to be unaffected.
 *
 * <p>Performance statistics via {@link MctsOneMoveEngineLargeTest}:
 * Using int is slightly better than using enum.
 * int: 3.64G, 55s, 71s
 * enum: 3.76G, 55s, 73s
 * int: 3.27G, 55s, 72s
 * enum: 4.10G, 55s, 84s
 *
 * <p>Performance statistics - real 19x19 games:
 * Store with int’s (1st round): stops at 130 moves, needs 5.14G
 * Store with enum’s (1st round): stops at 120 moves, needs 5.12G
 * Store with int’s (2nd round): stops at 126 moves, needs 5.18G
 * Store with enum’s (2nd round): stops at 126 moves, needs 5.06G
 */
public class PositionStateBoard {
  @SuppressWarnings("unused")
  private static final Logger logger = Logger.getLogger(PositionStateBoard.class.getName());

  /**
   * Creates a new Builder.
   */
  public static Builder newBuilder(@Nonnull CoordBoard coordBoard) {
    return new Builder(coordBoard);
  }

  public static PositionStateBoard readFromString(
      @Nonnull String boardInput, @Nonnull CoordBoard coordBoard) {
    return readFromStringWithLong(boardInput, coordBoard);
  }

  private static PositionStateBoard readFromStringWithLong(
      @Nonnull String boardInput, @Nonnull CoordBoard coordBoard) {
    int boardSize = coordBoard.getBoardSize();
    long[] positionStates = new long[boardSize + 2];  // +2 for walls

    // Add left wall.
    for (int j = 0, max = boardSize + 1; j <= max; j++) {  // j=0 and j=boardSize+1 means corners
      updatePositionState(positionStates, 0, j, PositionState.WALL);
    }

    for (int i = 1; i <= boardSize; i++) {
      // Add bottom wall.
      updatePositionState(positionStates, i, 0, PositionState.WALL);

      // Copy board from boardInput.
      for (int j = 1; j <= boardSize; j++) {
        int indexInString = boardSize * (boardSize - j) + i - 1;
        char positChar = boardInput.charAt(indexInString);
        switch (positChar) {
          case PositionStateChars.BLACK:
          case PositionStateChars.BLACK_EMPHASIZED:
          case PositionStateChars.BLACK_CAPTURED:
            updatePositionState(positionStates, i, j, PositionState.BLACK);
            break;
          case PositionStateChars.WHITE:
          case PositionStateChars.WHITE_EMPHASIZED:
          case PositionStateChars.WHITE_CAPTURED:
            updatePositionState(positionStates, i, j, PositionState.WHITE);
            break;
          case PositionStateChars.VACANT:
          case PositionStateChars.VACANT_EMPHASIZED_BLACK_TRIANGLE:
          case PositionStateChars.VACANT_EMPHASIZED_WHITE_SQUARE:
          case PositionStateChars.VACANT_EMPHASIZED_BLACK_SQUARE:
          case PositionStateChars.VACANT_EMPHASIZED_BLACK_CIRCLE:
          case PositionStateChars.VACANT_FOR_JIE_DEAD:
            updatePositionState(positionStates, i, j, PositionState.VACANT);
            break;
          default:
            // A-Z and a-z are for testing purpose, and are treated as VACANT.
            if ((positChar >= PositionStateChars.A && positChar <= PositionStateChars.Z)
                || (positChar >= PositionStateChars.a && positChar <= PositionStateChars.z)){
              updatePositionState(positionStates, i, j, PositionState.VACANT);
              break;
            }
            throw new IllegalArgumentException("Invalid positChar '" + positChar + "' "
                + "at (" + i + ", " + j + ") with boardInput:\n" + boardInput);
        }
      }

      // Add top wall.
      updatePositionState(positionStates, i, boardSize + 1, PositionState.WALL);
    }

    // Add right wall.
    for (int j = 0, max = boardSize + 1; j <= max; j++) {  // j=0 and j=boardSize+1 means corners
      updatePositionState(positionStates, boardSize + 1, j, PositionState.WALL);
    }

    return new PositionStateBoard(coordBoard, positionStates);
  }

  /**
   * Bits:
   *   Vacant = 00
   *   Black  = 01
   *   White  = 10
   *   Wall   = 11
   */
  private static void updatePositionState(@Nonnull long[] positionStatesToBeUpdated,
      int xPosition, int yPosition, @Nonnull PositionState positionState) {
    assert(positionStatesToBeUpdated.length <= 21);  // 21 = 19 (board) + 2 (walls)
    assert(xPosition >= 0 && xPosition <= 20 && yPosition >= 0 && yPosition <= 20);

    // Update 1st (higher) and 2nd (lower) bits.
    int higherShift = (yPosition << 1) + 1;  // (yPosition x 2) + 1
    long higherMask = 1L << higherShift;
    int lowerShift = (yPosition << 1);  // (yPosition x 2)
    long lowerMask = 1L << lowerShift;
    switch (positionState) {
      case VACANT:
        positionStatesToBeUpdated[xPosition] &= ~higherMask;
        positionStatesToBeUpdated[xPosition] &= ~lowerMask;
        break;
      case BLACK:
        positionStatesToBeUpdated[xPosition] &= ~higherMask;
        positionStatesToBeUpdated[xPosition] |= lowerMask;
        break;
      case WHITE:
        positionStatesToBeUpdated[xPosition] |= higherMask;
        positionStatesToBeUpdated[xPosition] &= ~lowerMask;
        break;
      case WALL:
        positionStatesToBeUpdated[xPosition] |= higherMask;
        positionStatesToBeUpdated[xPosition] |= lowerMask;
        break;
      default:
        assert(false);
    }
  }

  private final int boardSize;
  /**
   * Note: size = boardSize + 2
   */
  private final long[] positionStates;
  private final CoordBoard coordBoard;

  private PositionStateBoard(
      @Nonnull CoordBoard coordBoard,
      @Nonnull long[] positionStates) {
    this.coordBoard = coordBoard;
    this.boardSize = coordBoard.getBoardSize();
    assert positionStates.length == boardSize + 2;
    this.positionStates = positionStates;
  }

  public int getBoardSize() {
    return boardSize;
  }

  public CoordBoard getCoordBoard() {
    return coordBoard;
  }

  /**
   * Prefer {@link #getPositionState(int, int)} over {@link #getPositionState(Coord)}.
   */
  public PositionState getPositionState(@Nonnull Coord coord) {
    return getPositionState(coord.getXPosition(), coord.getYPosition());
  }

  /**
   * Prefer {@link #getPositionState(int, int)} over {@link #getPositionState(Coord)}.
   */
  public PositionState getPositionState(int xPosition, int yPosition) {
    assert xPosition >= 0 && xPosition <= boardSize + 1
        && yPosition >= 0 && yPosition <= boardSize + 1;
    long targetLong = this.positionStates[xPosition];
    int higherShift = (yPosition << 1) + 1;  // (yPosition x 2) + 1
    int lowerShift = (yPosition << 1);
    long higherBit = (targetLong >>> higherShift) & 1L;
    long lowerBit = (targetLong >>> lowerShift) & 1L;
    boolean isHigherBitSet = (higherBit != 0L);
    boolean isLowerBitSet = (lowerBit != 0L);
    if (isHigherBitSet) {
      if (isLowerBitSet) {
        return PositionState.WALL;  // 11
      } else {
        return PositionState.WHITE;  // 10
      }
    } else {
      if (isLowerBitSet) {
        return PositionState.BLACK;  // 01
      } else {
        return PositionState.VACANT;  // 00
      }
    }
  }

  public Builder toBuilder() {
    long[] clonedPositionStates = positionStates.clone();
    return new Builder(boardSize, coordBoard, clonedPositionStates);
  }

  public Block constructBlock(@Nonnull Coord startingCoord, @Nonnull PositionState positionState) {
    boolean[][] visited = new boolean[boardSize + 2][boardSize + 2];
    return constructBlock(startingCoord, positionState, visited);
  }

  private Block constructBlock(@Nonnull Coord startingCoord, @Nonnull PositionState positionState,
      @Nonnull boolean[][] visited) {
    Block.Builder blockBuilder = Block.newBuilder()
        .setRequiredBoardSize(boardSize)
        .setRequiredPositState(positionState);
    Stack<Coord> toBeProcessed = new Stack<>();
    toBeProcessed.push(startingCoord);
    while (!toBeProcessed.empty()) {
      Coord coord = toBeProcessed.pop();
      if (visited[coord.getXPosition()][coord.getYPosition()]) {
        continue;
      }
      blockBuilder.addCoord(coord);
      visited[coord.getXPosition()][coord.getYPosition()] = true;
      for (Direction direction : Direction.values()) {
        int neighborXPosition = coord.getXPosition() + direction.getXIncrement();
        int neighborYPosition = coord.getYPosition() + direction.getYIncrement();
        if (visited[neighborXPosition][neighborYPosition]) {
          continue;
        }
        if (getPositionState(neighborXPosition, neighborYPosition) != positionState) {
          continue;
        }
        toBeProcessed.push(coordBoard.getCoord(neighborXPosition, neighborYPosition));
      }
    }
    return blockBuilder.build();
  }

  public ImmutableSet<ColorBlock> constructNeighborColorBlocks(
      @Nonnull Block block, @Nonnull Color neighborColor) {
    PositionState neighborPositionState = neighborColor.getPositionState();
    ImmutableSet.Builder<ColorBlock> neighborBlocksBuilder = ImmutableSet.builder();
    boolean[][] visited = new boolean[boardSize + 2][boardSize + 2];
    for (Coord coord : block.getCoords()) {
      int xPosition = coord.getXPosition();
      int yPosition = coord.getYPosition();
      // For the return result, non-foe-color coords do not need to be processed.
      visited[xPosition][yPosition] = true;
      for (Direction direction : Direction.values()) {
        int neighborXPosition = xPosition + direction.getXIncrement();
        int neighborYPosition = yPosition + direction.getYIncrement();
        if (visited[neighborXPosition][neighborYPosition]) {
          continue;
        }
        if (this.getPositionState(neighborXPosition, neighborYPosition) != neighborPositionState) {
          // For the return result, non-foe-color coords do not need to be processed.
          visited[xPosition][yPosition] = true;
          continue;
        }
        ColorBlock neighborBlock = (ColorBlock) constructBlock(
            coordBoard.getCoord(neighborXPosition, neighborYPosition),
            neighborPositionState,
            visited);
        neighborBlocksBuilder.add(neighborBlock);
      }
    }
    return neighborBlocksBuilder.build();
  }

  public ImmutableSet<ColorBlock> constructNeighborColorBlocks(@Nonnull ColorBlock block) {
    return constructNeighborColorBlocks(block, block.getColor().swap());
  }

  public boolean hasAnyQiForBlock(@Nonnull ColorBlock colorBlock) {
    for (Coord coord : colorBlock.getCoords()) {
      int xPosition = coord.getXPosition();
      int yPosition = coord.getYPosition();
      for (Direction direction : Direction.values()) {
        int neighborXPosition = xPosition + direction.getXIncrement();
        int neighborYPosition = yPosition + direction.getYIncrement();
        if (this.getPositionState(neighborXPosition, neighborYPosition) == PositionState.VACANT) {
          return true;
        }
      }
    }
    return false;
  }

  public String toAsciiString() {
    boolean isAsciiChar = true;
    VisualBoard visualBoard = new VisualBoard(this, isAsciiChar);
    return visualBoard.toString();
  }

  /**
   * Note: String with non-ASCII characters.
   */
  @Override public String toString() {
    VisualBoard visualBoard = new VisualBoard(this);
    return visualBoard.toString();
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////
  // Builder
  //////////////////////////////////////////////////////////////////////////////////////////////////
  public static class Builder {
    private final int boardSize;
    private final CoordBoard coordBoard;
    private long[] positionStates;

    private Builder(@Nonnull CoordBoard coordBoard) {
      this.coordBoard = coordBoard;
      this.boardSize = coordBoard.getBoardSize();
      positionStates = createNewPositionStates();
    }

    private Builder(int boardSize, @Nonnull CoordBoard coordBoard, @Nonnull long[] positionStates) {
      assert(Utils.isValidBoardSize(boardSize));
      this.boardSize = boardSize;
      this.coordBoard = coordBoard;
      this.positionStates = positionStates;
    }

    private long[] createNewPositionStates() {
      assert(Utils.isValidBoardSize(boardSize));

      long[] positionStates = new long[boardSize + 2];  // +2 for walls

      // Add left wall.
      for (int j = 0, max = boardSize + 1; j <= max; j++) {  // j=0 and j=boardSize+1 means corners
        updatePositionState(positionStates, 0, j, PositionState.WALL);
      }

      for (int i = 1; i <= boardSize; i++) {
        // Add bottom wall.
        updatePositionState(positionStates, i, 0, PositionState.WALL);

        // Copy board from boardInput.
        for (int j = 1; j <= boardSize; j++) {
          updatePositionState(positionStates, i, j, PositionState.VACANT);
        }

        // Add top wall.
        updatePositionState(positionStates, i, boardSize + 1, PositionState.WALL);
      }

      // Add right wall.
      for (int j = 0, max = boardSize + 1; j <= max; j++) {  // j=0 and j=boardSize+1 means corners
        updatePositionState(positionStates, boardSize + 1, j, PositionState.WALL);
      }
      return positionStates;
    }

    public Builder setPositionState(int xPosition, int yPosition,
        @Nonnull PositionState positionState) {
      assert xPosition >= 1 && xPosition <= boardSize
          && yPosition >= 1 && yPosition <= boardSize;
      updatePositionState(this.positionStates, xPosition, yPosition, positionState);
      return this;
    }

    public Builder setPositionStates(@Nonnull ImmutableSet<Coord> coords,
        @Nonnull PositionState positionState) {
      for (Coord coord : coords) {
        setPositionState(coord.getXPosition(), coord.getYPosition(), positionState);
      }
      return this;
    }

    public PositionStateBoard build() {
      assert coordBoard != null;
      assert positionStates != null;
      return new PositionStateBoard(coordBoard, positionStates);
    }
  }
}
