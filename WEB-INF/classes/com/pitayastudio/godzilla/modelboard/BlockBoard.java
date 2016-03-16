package com.pitayastudio.godzilla.modelboard;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.Direction;
import com.pitayastudio.godzilla.common.PositionState;
import com.pitayastudio.godzilla.common.Utils;
import com.pitayastudio.godzilla.model.Block;
import com.pitayastudio.godzilla.model.ColorBlock;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.model.Realm;
import com.pitayastudio.godzilla.model.VacantBlock;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Nonnull;

/**
 * Immutable board of {@link Block}.
 */
public class BlockBoard {
  private static final boolean FLAG_PROFILE = true;

  public static Builder newBuilder() {
    return new Builder();
  }

  public static BlockBoard readFromString(@Nonnull String boardInput) {
    int boardSize = VisualBoard.getBoardSizeFromBoardInput(boardInput);
    CoordBoard coordBoard = new CoordBoard(boardSize);
    PositionStateBoard positionStateBoard =
        PositionStateBoard.readFromString(boardInput, coordBoard);
    BlockBoard blockBoard = BlockBoard.newBuilder()
        .setRequiredPositionStateBoard(positionStateBoard)
        .build();
    return blockBoard;
  }

  private final int boardSize;
  private final CoordBoard coordBoard;
  private final PositionStateBoard positionStateBoard;
  /** Note: Size = bloardSize x boardSize */
  private final Block[][] blocks;
  private final ImmutableSet<VacantBlock> allVacantBlocks;
  private final EnumMap<Color, ImmutableSet<ColorBlock>> colorToBlocksMap;

  private BlockBoard(
      int boardSize,
      CoordBoard coordBoard,
      PositionStateBoard positionStateBoard,
      Block[][] blocksWithWall,
      ImmutableSet<VacantBlock> allVacantBlocks,
      EnumMap<Color, ImmutableSet<ColorBlock>> colorToBlocksMap) {
    this.boardSize = boardSize;
    this.coordBoard = coordBoard;
    this.positionStateBoard = positionStateBoard;
    this.blocks = blocksWithWall;
    this.allVacantBlocks = allVacantBlocks;
    this.colorToBlocksMap = colorToBlocksMap;
  }

  public int getBoardSize() {
    return boardSize;
  }

  public CoordBoard getCoordBoard() {
    return coordBoard;
  }

  public PositionStateBoard getPositionStateBoard() {
    return positionStateBoard;
  }

  public Block getBlock(int xPosition, int yPosition) {
    assert xPosition >= 1 && xPosition <= coordBoard.getBoardSize();
    assert yPosition >= 1 && yPosition <= coordBoard.getBoardSize();
    return blocks[xPosition - 1][yPosition - 1];
  }

  public ColorBlock getColorBlock(int xPosition, int yPosition) {
    assert xPosition >= 1 && xPosition <= coordBoard.getBoardSize();
    assert yPosition >= 1 && yPosition <= coordBoard.getBoardSize();
    assert positionStateBoard.getPositionState(xPosition, yPosition) == PositionState.BLACK
        || positionStateBoard.getPositionState(xPosition, yPosition) == PositionState.WHITE
        : "(" + xPosition + ", " + yPosition + ") is not color.";
    return (ColorBlock) getBlock(xPosition, yPosition);
  }

  public VacantBlock getVacantBlock(int xPosition, int yPosition) {
    assert xPosition >= 1 && xPosition <= coordBoard.getBoardSize();
    assert yPosition >= 1 && yPosition <= coordBoard.getBoardSize();
    assert positionStateBoard.getPositionState(xPosition, yPosition).isVacant()
        : "(" + xPosition + ", " + yPosition + ") is not vacant.";
    return (VacantBlock) getBlock(xPosition, yPosition);
  }

  public ImmutableSet<VacantBlock> getAllVacantBlocks() {
    return allVacantBlocks;
  }

  public ImmutableList<Coord> findAllVacantCoords() {
    ImmutableList.Builder<Coord> coordsBuilder = ImmutableList.builder();
    for (VacantBlock vacantBlock : allVacantBlocks) {
      coordsBuilder.addAll(vacantBlock.getCoords());
    }
    return coordsBuilder.build();
  }

  public ImmutableSet<ColorBlock> getAllBlocksOfColor(@Nonnull Color color) {
    return colorToBlocksMap.get(color);
  }

  public ImmutableSet<ColorBlock> findNeighborFoeBlocks(@Nonnull ColorBlock colorBlock) {
    ImmutableSet.Builder<ColorBlock> colorBlocksBuilder = ImmutableSet.builder();
    Color foeColor = colorBlock.getColor().swap();
    PositionState foePositionState = foeColor.getPositionState();
    for (Coord coord : colorBlock.getCoords()) {
      for (Direction direction : Direction.values()) {
        Coord neighborCoord = coordBoard.getNeighborCoordInDirection(coord, direction);
        PositionState neighborPositionState = positionStateBoard.getPositionState(neighborCoord);
        if (neighborPositionState == foePositionState) {
          ColorBlock neighborBlock =
              getColorBlock(neighborCoord.getXPosition(), neighborCoord.getYPosition());
          colorBlocksBuilder.add(neighborBlock);
        }
      }
    }
    return colorBlocksBuilder.build();
  }

  public ImmutableSet<ColorBlock> findNeighborColorBlocksForVacantBlock(
      @Nonnull Color neighborColor, @Nonnull VacantBlock vacantBlock) {
    PositionState targetNeighborPositionState = neighborColor.getPositionState();
    ImmutableSet.Builder<ColorBlock> colorBlocksBuilder = ImmutableSet.builder();
    for (Coord coord : vacantBlock.getCoords()) {
      for (Direction direction : Direction.values()) {
        Coord neighborCoord = coordBoard.getNeighborCoordInDirection(coord, direction);
        PositionState neighborPositionState = positionStateBoard.getPositionState(neighborCoord);
        if (neighborPositionState == targetNeighborPositionState) {
          ColorBlock neighborBlock =
              getColorBlock(neighborCoord.getXPosition(), neighborCoord.getYPosition());
          colorBlocksBuilder.add(neighborBlock);
        }
      }
    }
    return colorBlocksBuilder.build();
  }

  public boolean hasAnyQiForBlock(@Nonnull ColorBlock colorBlock) {
    ImmutableSet<Coord> colorCoords = colorBlock.getCoords();
    for (Coord colorCoord : colorCoords) {
      for (Direction direction : Direction.values()) {
        Coord neighborCoord = coordBoard.getNeighborCoordInDirection(colorCoord, direction);
        PositionState positionState = positionStateBoard.getPositionState(neighborCoord);
        if (positionState.isVacant()) {
          return true;
        }
      }
    }
    return false;
  }

  public ImmutableSet<Coord> findQiCoordsForBlock(ColorBlock colorBlock) {
    ImmutableSet<Coord> colorCoords = colorBlock.getCoords();
    Set<Coord> qiCoords = new HashSet<>();
    for (Coord colorCoord : colorCoords) {
      for (Direction direction : Direction.values()) {
        Coord neighborCoord = coordBoard.getNeighborCoordInDirection(colorCoord, direction);
        PositionState positionState = positionStateBoard.getPositionState(neighborCoord);
        if (positionState.isVacant()) {
          qiCoords.add(neighborCoord);
        }
      }
    }
    ImmutableSet<Coord> result = ImmutableSet.copyOf(qiCoords);
    return result;
  }

  public BlockBoard constructBlockBoardWithNewMoveWithoutConsideringDead(
      int nextMoveXPosition, int nextMoveYPosition, @Nonnull Color colorOfMove) {
    assert nextMoveXPosition >= 1 && nextMoveXPosition <= coordBoard.getBoardSize();
    assert nextMoveYPosition >= 1 && nextMoveYPosition <= coordBoard.getBoardSize();
    VacantBlock affectedVacantBlock = this.getVacantBlock(nextMoveXPosition, nextMoveYPosition);
    int sizeOfAffectedVacantBlock = affectedVacantBlock.size();
    // The number 355 is determined from constructNewBlockBoardForProfiling() below.
    // TODO 200 Always use constructNewBlockBoardFromCurrent when opening-game is supported.
    if (sizeOfAffectedVacantBlock > 355) {
      return constructBlockBoardWithNewMoveWithoutConsideringDeadFromScratch(
          nextMoveXPosition, nextMoveYPosition, colorOfMove);
    } else {
      return constructBlockBoardWithNewMoveWithoutConsideringDeadFromCurrentBlockBoard(
          nextMoveXPosition, nextMoveYPosition, colorOfMove);
    }
  }

  private BlockBoard constructBlockBoardWithNewMoveWithoutConsideringDeadFromScratch(
      int nextMoveXPosition, int nextMoveYPosition, Color colorOfNextMove) {
    assert nextMoveXPosition >= 1 && nextMoveXPosition <= coordBoard.getBoardSize();
    assert nextMoveYPosition >= 1 && nextMoveYPosition <= coordBoard.getBoardSize();
    long time00;
    if (FLAG_PROFILE) time00 = System.nanoTime();
    PositionStateBoard newPositionStateBoard = positionStateBoard.toBuilder()
        .setPositionState(nextMoveXPosition, nextMoveYPosition, colorOfNextMove.getPositionState())
        .build();
    BlockBoard blockBoard = BlockBoard.newBuilder()
        .setRequiredPositionStateBoard(newPositionStateBoard)
        .build();
    if (FLAG_PROFILE) Utils.profile(time00,
        "BlockBoard.constructBlockBoardWithNewMoveWithoutConsideringDeadFromScratch");
    return blockBoard;
  }

  private BlockBoard constructBlockBoardWithNewMoveWithoutConsideringDeadFromCurrentBlockBoard(
      int nextMoveXPosition, int nextMoveYPosition, @Nonnull Color colorOfNextMove) {
    assert nextMoveXPosition >= 1 && nextMoveXPosition <= coordBoard.getBoardSize();
    assert nextMoveYPosition >= 1 && nextMoveYPosition <= coordBoard.getBoardSize();
    long time00, time01, time02, time02a, time03;
    if (FLAG_PROFILE) time00 = System.nanoTime();

    // Initialize fields for the new board.
    PositionStateBoard newPositionStateBoard = positionStateBoard.toBuilder()
        .setPositionState(nextMoveXPosition, nextMoveYPosition, colorOfNextMove.getPositionState())
        .build();
    Block[][] newBlocksWithoutWall = cloneBlocks(blocks);
    HashSet<VacantBlock> newAllVacantBlocks = new HashSet<>(allVacantBlocks);
    EnumMap<Color, ImmutableSet<ColorBlock>> newColorToBlocksMap = new EnumMap<>(Color.class);
    if (FLAG_PROFILE) time01 = Utils.profile(time00,
        "BlockBoard.constructBlockBoardWithNewMoveWithoutConsideringDeadFromCurrentBlockBoard => Initialize fields");

    // Process affected the vacant block.
    VacantBlock affectedVacantBlock = this.getVacantBlock(nextMoveXPosition, nextMoveYPosition);
    boolean isRemoved = newAllVacantBlocks.remove(affectedVacantBlock);
    assert isRemoved;
    // Note: performance of findVacantBlocksFromAffectedVacantBlock() is almost optimized.
    ImmutableSet<VacantBlock> newVacantBlocksFromAffectedVacantBlock =
        findVacantBlocksFromAffectedVacantBlock(
            affectedVacantBlock, nextMoveXPosition, nextMoveYPosition, newPositionStateBoard);
    newAllVacantBlocks.addAll(newVacantBlocksFromAffectedVacantBlock);
    if (FLAG_PROFILE) time02 = Utils.profile(time01,
        "BlockBoard.constructBlockBoardWithNewMoveWithoutConsideringDeadFromCurrentBlockBoard => Process affected vacant block");
    // Process affected the vacant block - Update newBlocks.
    for (VacantBlock newVacantBlock : newVacantBlocksFromAffectedVacantBlock) {
      for (Coord coord : newVacantBlock.getCoords()) {
        newBlocksWithoutWall[coord.getXPosition() - 1][coord.getYPosition() - 1] = newVacantBlock;
      }
    }
    if (FLAG_PROFILE) time02a = Utils.profile(time02,
        "BlockBoard.constructBlockBoardWithNewMoveWithoutConsideringDeadFromCurrentBlockBoard => Update newBlocks");

    // Process affected buddy blocks.
    Set<ColorBlock> affectedBuddyBlocks =
        findNeighborColorBlocksForCoord(nextMoveXPosition, nextMoveYPosition, colorOfNextMove);
    Coord nextMoveCoord = coordBoard.getCoord(nextMoveXPosition, nextMoveYPosition);
    Block.Builder newMergedBuddyBlockBuilder = Block.newBuilder()
        .setRequiredBoardSize(boardSize)
        .setRequiredPositState(colorOfNextMove.getPositionState())
        .addCoord(nextMoveCoord);
    for (ColorBlock affectedBuddyBlock : affectedBuddyBlocks) {
      newMergedBuddyBlockBuilder.addAllCoords(affectedBuddyBlock.getCoords());
    }
    ColorBlock newMergedBuddyBlock = (ColorBlock) newMergedBuddyBlockBuilder.build();
    HashSet<ColorBlock> newAllBuddyBlocks = Sets.newHashSet(colorToBlocksMap.get(colorOfNextMove));
    newAllBuddyBlocks.removeAll(affectedBuddyBlocks);
    newAllBuddyBlocks.add(newMergedBuddyBlock);
    newColorToBlocksMap.put(colorOfNextMove, ImmutableSet.copyOf(newAllBuddyBlocks));
    ImmutableSet<ColorBlock> oldAllFoeBlocks = colorToBlocksMap.get(colorOfNextMove.swap());
    newColorToBlocksMap.put(colorOfNextMove.swap(), oldAllFoeBlocks);
    // Process affected buddy blocks - Update newBlocks.
    for (ColorBlock newBuddyBlock : newAllBuddyBlocks) {
      for (Coord coord : newBuddyBlock.getCoords()) {
        newBlocksWithoutWall[coord.getXPosition() - 1][coord.getYPosition() - 1] = newBuddyBlock;
      }
    }
    if (FLAG_PROFILE) time03 = Utils.profile(time02a,
        "BlockBoard.constructBlockBoardWithNewMoveWithoutConsideringDeadFromCurrentBlockBoard => Process affected buddy blocks");

    // Construct new board.
    BlockBoard newBoard = new BlockBoard(boardSize, coordBoard, newPositionStateBoard,
        newBlocksWithoutWall, ImmutableSet.copyOf(newAllVacantBlocks), newColorToBlocksMap);
    if (FLAG_PROFILE) Utils.profile(time03,
        "BlockBoard.constructBlockBoardWithNewMoveWithoutConsideringDeadFromCurrentBlockBoard => Construct new board");
    return newBoard;
  }

  public BlockBoard constructNewBlockBoardWithDead(boolean isConstructFromScratch,
      Color deadColor, ImmutableSet<ColorBlock> deadBlocks, ImmutableSet<Coord> deadCoords) {
    if (isConstructFromScratch) {
      // "FromScratch" is faster for beginning-game and middle-game phases.
      return constructNewBlockBoardFromScratch(deadCoords);
    } else {
      // "FromCurrentBlockBoard" is faster for ending-game phase.
      return constructNewBlockBoardFromCurrentBlockBoard(deadColor, deadBlocks);
    }
  }

  private BlockBoard constructNewBlockBoardFromCurrentBlockBoard(
      Color deadColor, ImmutableSet<ColorBlock> deadBlocks) {
    if (deadBlocks.size() == 0) {
      return this;
    }

    PositionStateBoard.Builder newPositionStateBoardBuilder = positionStateBoard.toBuilder();
    ImmutableSet.Builder<VacantBlock> newAllVacantBlocksBuilder = ImmutableSet.builder();
    newAllVacantBlocksBuilder.addAll(allVacantBlocks);
    EnumMap<Color, ImmutableSet<ColorBlock>> newColorToBlocksMap = new EnumMap<>(Color.class);
    newColorToBlocksMap.put(deadColor.swap(), this.colorToBlocksMap.get(deadColor.swap()));
    Set<ColorBlock> newColorBlocksOfDeadColor = new HashSet<>(this.colorToBlocksMap.get(deadColor));
    Block[][] newBlocks = this.blocks.clone();
    for (ColorBlock deadBlock : deadBlocks) {
      ImmutableSet<Coord> deadCoords = deadBlock.getCoords();
      newPositionStateBoardBuilder.setPositionStates(deadCoords, PositionState.VACANT);
      VacantBlock newVacantBlock = (VacantBlock) Block.newBuilder()
          .setRequiredBoardSize(boardSize)
          .setRequiredPositState(PositionState.VACANT)
          .addAllCoords(deadCoords)
          .build();
      newAllVacantBlocksBuilder.add(newVacantBlock);
      for (Coord deadCoord: deadCoords) {
        // Note: size of newBlocks is boardSize x boardSize
        newBlocks[deadCoord.getXPosition() - 1][deadCoord.getYPosition() - 1] = newVacantBlock;
      }
      boolean isRemoved = newColorBlocksOfDeadColor.remove(deadBlock);
      assert isRemoved;
    }
    newColorToBlocksMap.put(deadColor, ImmutableSet.copyOf(newColorBlocksOfDeadColor));
    // Construct new board.
    BlockBoard newBoard = new BlockBoard(
        boardSize,
        coordBoard,
        newPositionStateBoardBuilder.build(),
        newBlocks,
        newAllVacantBlocksBuilder.build(),
        newColorToBlocksMap);
    return newBoard;
  }

  private BlockBoard constructNewBlockBoardFromScratch(ImmutableSet<Coord> deadCoords) {
    PositionStateBoard nextPositStateBoardUpdatedWithDead = positionStateBoard.toBuilder()
            .setPositionStates(deadCoords, PositionState.VACANT)
            .build();
    BlockBoard nextUpdatedBlockBoard = BlockBoard.newBuilder()
        .setRequiredPositionStateBoard(nextPositStateBoardUpdatedWithDead)
        .build();
    return nextUpdatedBlockBoard;
  }

  private Block[][] cloneBlocks(Block[][] oldBlocks) {
    Block[][] newBlocks = new Block[boardSize][boardSize];
    for (int i = 0; i < boardSize; i++) {
      newBlocks[i] = new Block[boardSize];
      for (int j = 0; j < boardSize; j++) {
        newBlocks[i][j] = oldBlocks[i][j];
      }
    }
    return newBlocks;
  }

  private ImmutableSet<VacantBlock> findVacantBlocksFromAffectedVacantBlock(
      @Nonnull VacantBlock affectedVacantBlock,
      int excludedXPosition,
      int excludedYPosition,
      @Nonnull PositionStateBoard newPositionStateBoard) {
    assert excludedXPosition >= 1 && excludedXPosition <= this.boardSize;
    assert excludedYPosition >= 1 && excludedYPosition <= this.boardSize;
    Coord excludedCoord = coordBoard.getCoord(excludedXPosition, excludedYPosition);
    HashSet<Coord> allCoords = Sets.newHashSet(affectedVacantBlock.getCoords());
    boolean isRemoved = allCoords.remove(excludedCoord);
    assert isRemoved;
    ImmutableSet<VacantBlock> vacantBlocks = constructVacantBlocksFromProvidedVacantCoords(
        allCoords, newPositionStateBoard);
    return vacantBlocks;
  }

  private ImmutableSet<VacantBlock> constructVacantBlocksFromProvidedVacantCoords(
      Set<Coord> providedVacantCoords,
      // newPositionStateBoard is not useful, but keep it here for a while.
      @SuppressWarnings("unused") @Nonnull PositionStateBoard newPositionStateBoard) {
    ImmutableSet.Builder<VacantBlock> blocksBuilder = ImmutableSet.builder();
    Set<Coord> visitedCoords = new HashSet<>();
    for (Coord providedCoord : providedVacantCoords) {
      if (visitedCoords.contains(providedCoord)) {
        continue;
      }
      visitedCoords.add(providedCoord);

      Block.Builder blockBuilder = Block.newBuilder()
          .setRequiredPositState(PositionState.VACANT)
          .setRequiredBoardSize(boardSize);
      Set<Coord> coordsToBeProcessed = new HashSet<>();
      coordsToBeProcessed.add(providedCoord);
      while (!coordsToBeProcessed.isEmpty()) {
        Coord coordToBeProcessed = coordsToBeProcessed.iterator().next();
        boolean isRemoved = coordsToBeProcessed.remove(coordToBeProcessed);
        assert isRemoved;
        blockBuilder.addCoord(coordToBeProcessed);
        visitedCoords.add(coordToBeProcessed);

        int xCoordToBeProcessed = coordToBeProcessed.getXPosition();
        int yCoordToBeProcessed = coordToBeProcessed.getYPosition();
        for (Direction direction : Direction.values()) {
          int neighborX = xCoordToBeProcessed + direction.getXIncrement();
          int neighborY = yCoordToBeProcessed + direction.getYIncrement();
          // Note: Utilizing PositionState does not improve performance.
          //PositionState neighborState = newPositionStateBoard.getPositionState(neighborX, neighborY);
          //if (neighborState != PositionState.VACANT) {
          //  continue;
          //}
          Coord neighborCoord = coordBoard.getCoord(neighborX, neighborY);
          if (!providedVacantCoords.contains(neighborCoord)) {
            continue;
          }
          if (visitedCoords.contains(neighborCoord)) {
            continue;
          }
          coordsToBeProcessed.add(neighborCoord);
        }
      }
      VacantBlock vacantVlock = (VacantBlock) blockBuilder.build();
      blocksBuilder.add(vacantVlock);
    }
    return blocksBuilder.build();
  }

  private ImmutableSet<ColorBlock> findNeighborColorBlocksForCoord(
      int xPosition, int yPosition, @Nonnull Color color) {
    assert xPosition >= 1 && xPosition <= this.boardSize;
    assert yPosition >= 1 && yPosition <= this.boardSize;
    PositionState targetPositionState = color.getPositionState();
    ImmutableSet.Builder<ColorBlock> colorBlocksBuilder = ImmutableSet.builder();
    for (Direction direction : Direction.values()) {
      int neighborXPosition = xPosition + direction.getXIncrement();
      int neighborYPosition = yPosition + direction.getYIncrement();
      PositionState neighborPositionState =
          positionStateBoard.getPositionState(neighborXPosition, neighborYPosition);
      if (neighborPositionState != targetPositionState) {
        continue;
      }
      ColorBlock neighborBlock = (ColorBlock) getBlock(neighborXPosition, neighborYPosition);
      colorBlocksBuilder.add(neighborBlock);
    }
    return colorBlocksBuilder.build();
  }

  /** TODO 250 Implement BlockBoard.getRealm(). */
  public Realm getRealm(int xPosition, int yPosition) {
    assert xPosition >= 1 && xPosition <= this.boardSize;
    assert yPosition >= 1 && yPosition <= this.boardSize;
    assert positionStateBoard.getPositionState(xPosition, yPosition).isVacant()
        : "PositionState at (" + xPosition + ", " + yPosition + ") is not vacant.";
    Coord coord = coordBoard.getCoord(xPosition, yPosition);
    ImmutableSet<Coord> coords = ImmutableSet.of(coord);
    return new Realm(boardSize, coords);
  }

  @Override public String toString() {
    VisualBoard visualBoard = new VisualBoard(positionStateBoard);
    return visualBoard.toString();
  }

  public static class Builder {
    private CoordBoard coordBoard;
    private int boardSize;
    private PositionStateBoard positionStateBoard;
    private Block[][] blocks;
    // Note: ImmutableSet seems to have better performance than ImmutableList for allVacantBlocks.
    private ImmutableSet<VacantBlock> allVacantBlocks;
    private final EnumMap<Color, ImmutableSet<ColorBlock>> colorToBlocksMap =
        new EnumMap<>(Color.class);

    private Builder() {
    }

    public Builder setRequiredPositionStateBoard(@Nonnull PositionStateBoard positionStateBoard) {
      this.positionStateBoard = positionStateBoard;
      this.coordBoard = positionStateBoard.getCoordBoard();
      return this;
    }

    public BlockBoard build() {
      assert (null != coordBoard);
      assert (null != positionStateBoard);
      boardSize = coordBoard.getBoardSize();

      long time00;
      if (FLAG_PROFILE) time00 = System.nanoTime();
      buildBlocks();
      if (FLAG_PROFILE) Utils.profile(time00, "BlockBoard.build => buildBlocks");

      BlockBoard blockBoard = new BlockBoard(boardSize, coordBoard, positionStateBoard,
          blocks, allVacantBlocks, colorToBlocksMap);
      return blockBoard;
    }

    private void buildBlocks() {
      blocks = new Block[boardSize][boardSize];
      for (int i = 0; i < boardSize; i++) {
        blocks[i] = new Block[boardSize];
      }
      // Prepare builders for all ImmutableSet's.
      ImmutableSet.Builder<VacantBlock> allVacantBlocksBuilder = ImmutableSet.builder();
      EnumMap<Color, ImmutableSet.Builder<ColorBlock>> colorToBlocksBuilderMap =
          new EnumMap<>(Color.class);
      for (Color color : Color.values()) {
        ImmutableSet.Builder<ColorBlock> allBlocksOfColorBuilder = ImmutableSet.builder();
        colorToBlocksBuilderMap.put(color, allBlocksOfColorBuilder);
      }

      boolean[][] visited = new boolean[boardSize + 2][boardSize + 2];
      for (int xPosition = 1; xPosition <= boardSize; xPosition++) {
        for (int yPosition = 1; yPosition <= boardSize; yPosition++) {
          if (visited[xPosition][yPosition]) {
            continue;
          }
          PositionState positionState = positionStateBoard.getPositionState(xPosition, yPosition);
          Coord coord = coordBoard.getCoord(xPosition, yPosition);
          Block.Builder blockBuilder = Block.newBuilder()
              .setRequiredPositState(positionState)
              .setRequiredBoardSize(boardSize);
          // Use HashSet instead of Queue to track coords because it is slow to look up if a coord
          // is already in a Queue.
          Set<Coord> coordsToBeAdded = new HashSet<>();
          coordsToBeAdded.add(coord);
          while (!coordsToBeAdded.isEmpty()) {
            Coord nextCoord = coordsToBeAdded.iterator().next();
            coordsToBeAdded.remove(nextCoord);
            assert(positionStateBoard.getPositionState(nextCoord) == positionState);
            blockBuilder.addCoord(nextCoord);
            visited[nextCoord.getXPosition()][nextCoord.getYPosition()] = true;
            for (Direction direction : Direction.values()) {
              Coord neighborCoord = coordBoard.getNeighborCoordInDirection(nextCoord, direction);
              PositionState neighborState = positionStateBoard.getPositionState(neighborCoord);
              if (neighborState != positionState) {
                continue;
              }
              if (visited[neighborCoord.getXPosition()][neighborCoord.getYPosition()]) {
                continue;
              }
              coordsToBeAdded.add(neighborCoord);
            }
          }  // end while
          Block block = blockBuilder.build();

          Set<Coord> coords = block.getCoords();
          for (Coord coordIter : coords) {
            blocks[coordIter.getXPosition() - 1][coordIter.getYPosition() - 1] = block;
          }

          if (block instanceof VacantBlock) {
            allVacantBlocksBuilder.add((VacantBlock) block);
          } else {
            ColorBlock colorBlock = (ColorBlock) block;
            Color color = colorBlock.getColor();
            colorToBlocksBuilderMap.get(color).add(colorBlock);
          }
        }
      }

      // Build result ImmutableSet's.
      allVacantBlocks = allVacantBlocksBuilder.build();
      for (Color color : Color.values()) {
        ImmutableSet<ColorBlock> colorBlocks = colorToBlocksBuilderMap.get(color).build();
        colorToBlocksMap.put(color, colorBlocks);
      }
    }
  }  // end class Builder
}
