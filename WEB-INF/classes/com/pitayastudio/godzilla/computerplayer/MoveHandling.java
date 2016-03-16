package com.pitayastudio.godzilla.computerplayer;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.MoveType;
import com.pitayastudio.godzilla.common.PositionState;
import com.pitayastudio.godzilla.common.Utils;
import com.pitayastudio.godzilla.model.ColorBlock;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.model.VacantBlock;
import com.pitayastudio.godzilla.modelboard.CoordBoard;
import com.pitayastudio.godzilla.modelboard.PositionStateBoard;
import com.pitayastudio.godzilla.moveanalyzer.DesignDoc;

import java.util.HashSet;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Immutable move handling.
 *
 * @see DesignDoc#stepsToHandleNextMove
 * @see DesignDoc#samePositionStateBoardViolation
 */
public class MoveHandling {
  private static final boolean FLAG_PROFILE = true;

  public static BuilderWithMove newBuilderForRegularMoveHandling() {
    return new BuilderWithMove();
  }

  public static MoveHandling constructRootMoveHandling(
      @Nonnull PositionStateBoard rootPositionStateBoard) {
    return new MoveHandling(
        rootPositionStateBoard,
        rootPositionStateBoard,
        Color.W,  // moveColor
        null,  // moveCoord
        MoveType.MOVE_PASS_BEFORE_GAME_START,
        null,  // deadCoords
        null);  // jieDeadCoord
  }

  public static MoveHandling constructPassMoveHandling(
      @Nonnull PositionStateBoard positionStateBoard, @Nonnull Color moveColor) {
    return new MoveHandling(
        positionStateBoard,
        positionStateBoard,
        moveColor,
        null,  // moveCoord
        MoveType.MOVE_PASS,
        null,  // deadCoords
        null);  // jieDeadCoord
  }

  public static MoveHandling constructPassMoveHandling(@Nonnull MoveHandling prevMoveHandling) {
    PositionStateBoard positionStateBoard = prevMoveHandling.getPositionStateBoardAfterMove();
    Color moveColor = prevMoveHandling.getMoveColor().swap();
    return constructPassMoveHandling(positionStateBoard, moveColor);
  }

  private final CoordBoard coordBoard;

  /**
   * Note: {@link #positionStateBoardBeforeMove} is the same as {@link #positionStateBoardAfterMove}
   * for the root {@link MoveHandling}.
   */
  @Nonnull private final PositionStateBoard positionStateBoardBeforeMove;

  /** Note: {@link #positionStateBoardAfterMove} is null for illegal {@link MoveType}. */
  private final PositionStateBoard positionStateBoardAfterMove;

  /**
   * moveColor is White when this is the Root {@link MoveHandling}.
   */
  @Nonnull private final Color moveColor;

  @Nonnull private final Optional<Coord> moveCoordOptional;
  @Nonnull private final MoveType moveType;
  @Nonnull private final ImmutableSet<Coord> deadCoords;
  @Nonnull private final Optional<Coord> jieDeadCoordOptional;

  /**
   * Note: This is lazily constructed.
   */
  private ImmutableList<Coord> availMoveCoordsExceptJie = null;

  private MoveHandling(
      @Nonnull PositionStateBoard positionStateBoardBeforeMove,
      @Nullable PositionStateBoard positionStateBoardAfterMove,
      @Nonnull Color moveColor,
      Coord moveCoord,
      @Nonnull MoveType moveType,
      ImmutableSet<Coord> deadCoords,
      Coord jieDeadCoord) {
    this.positionStateBoardBeforeMove = positionStateBoardBeforeMove;
    coordBoard = positionStateBoardBeforeMove.getCoordBoard();
    this.positionStateBoardAfterMove = positionStateBoardAfterMove;
    this.moveColor = moveColor;
    this.moveCoordOptional = Optional.fromNullable(moveCoord);
    this.moveType = moveType;
    this.deadCoords = deadCoords == null ? ImmutableSet.<Coord>of() : deadCoords;
    this.jieDeadCoordOptional = Optional.fromNullable(jieDeadCoord);
  }

  public CoordBoard getCoordBoard() {
    return coordBoard;
  }

  public PositionStateBoard getPositionStateBoardBeforeMove() {
    return this.positionStateBoardBeforeMove;
  }

  public PositionStateBoard getPositionStateBoardAfterMove() {
    return this.positionStateBoardAfterMove;
  }

  public Color getMoveColor() {
    return moveColor;
  }

  public Optional<Coord> getMoveCoordOptional() {
    return moveCoordOptional;
  }

  public MoveType getMoveType() {
    return moveType;
  }

  public ImmutableSet<Coord> getDeadCoords() {
    return deadCoords;
  }

  /**
   * <pre>
   * |.....
   * |.xxoo
   * |.xOXo
   * |.xxoo
   * |.....
   * </pre>
   * Assume in the current move, white ate X.
   * Then X=jieDeadCoord.
   *
   */
  public Optional<Coord> getJieDeadCoordOptional() {
    return jieDeadCoordOptional;
  }

  public int getBoardSize() {
    assert !moveType.isIllegalMove() : moveType;
    assert positionStateBoardAfterMove != null;
    return positionStateBoardAfterMove.getBoardSize();
  }

  // TODO 150 evaluate to deprecate getOrFindAvailMoveCoordsExceptJie()
  /**
   * Not recommended to use this method.
   * Directly use {@link #positionStateBoardAfterMove} instead.
   */
  public ImmutableList<Coord> getOrFindAvailMoveCoordsExceptJie() {
    assert !moveType.isIllegalMove();
    assert positionStateBoardAfterMove != null;

    if (availMoveCoordsExceptJie != null) {
      return availMoveCoordsExceptJie;
    }

    // Lazily construct availMoveCoordsExceptJie.
    int boardSize = this.getBoardSize();
    HashSet<Coord> allVacantCoordsNew = new HashSet<>();
    for (int xPosition = 0; xPosition <= boardSize; xPosition++) {
      for (int yPosition = 0; yPosition <= boardSize; yPosition++) {
        PositionState positionState =
            positionStateBoardAfterMove.getPositionState(xPosition, yPosition);
        if (positionState == PositionState.VACANT) {
          Coord coord = coordBoard.getCoord(xPosition, yPosition);
          allVacantCoordsNew.add(coord);
        }
      }
    }
    if (this.jieDeadCoordOptional.isPresent()) {
      boolean isRemoved = allVacantCoordsNew.remove(jieDeadCoordOptional.get());
      assert isRemoved;
    }
    availMoveCoordsExceptJie = ImmutableList.copyOf(allVacantCoordsNew);
    return availMoveCoordsExceptJie;
  }

  @Override public String toString() {
    assert !moveType.isIllegalMove();
    assert positionStateBoardAfterMove != null;
    return positionStateBoardAfterMove.toString();
  }

  public static class BuilderWithMove {
    private CoordBoard coordBoard;
    private PositionStateBoard positionStateBoardBeforeMove;
    private PositionStateBoard positionStateBoardAfterMove;
    private Optional<Coord> prevJieDeadCoordOptional;
    private Color moveColor;
    private Coord moveCoord;
    private int moveXPosition;
    private int moveYPosition;
    private MoveType moveType;
    private ImmutableSet<Coord> deadCoords;
    private Coord jieDeadCoord;

    // Checkers to make sure methods are executed in correct order.
    private boolean hasCalledHandleMove = false;
    private boolean hasCheckedErrorPrevPositIsAlreadyOccupied = false;
    private boolean hasCheckedErrorJieViolation = false;

    private BuilderWithMove() {
    }

    public BuilderWithMove setRequiredPositionStateBoardBeforeMove(
        @Nonnull PositionStateBoard positionStateBoard) {
      this.positionStateBoardBeforeMove = positionStateBoard;
      this.coordBoard = positionStateBoard.getCoordBoard();
      return this;
    }

    public BuilderWithMove setRequiredPrevJieDeadCoordOptional(
        @Nonnull Optional<Coord> coordOptional) {
      this.prevJieDeadCoordOptional = coordOptional;
      return this;
    }

    public BuilderWithMove setRequiredMoveColor(@Nonnull Color moveColor) {
      this.moveColor = moveColor;
      return this;
    }

    public BuilderWithMove setRequiredMoveCoord(@Nonnull Coord moveCoord) {
      this.moveCoord = moveCoord;
      return this;
    }

    public MoveHandling build() {
      assert coordBoard != null;
      assert positionStateBoardBeforeMove != null;
      assert prevJieDeadCoordOptional != null;
      assert moveColor != null;
      assert moveCoord != null;
      moveXPosition = moveCoord.getXPosition();
      moveYPosition = moveCoord.getYPosition();

      long time00;
      if (FLAG_PROFILE) time00 = System.nanoTime();
      handleMove();
      assert moveType != null;
      if (FLAG_PROFILE) Utils.profile(
          time00,
          5,  // 5 ms
          "MoveHandling.build => handleMove");

      return new MoveHandling(
          positionStateBoardBeforeMove,
          positionStateBoardAfterMove,  // Nullable
          moveColor,
          moveCoord,
          moveType,
          deadCoords,
          jieDeadCoord);
    }

    private void handleMove() {
      assert(!hasCalledHandleMove);
      hasCalledHandleMove = true;

      // Pre-check to see if it is an obvious error move.
      if (isErrorPrevPositIsAlreadyOccupied()) {
        moveType = MoveType.MOVE_ERROR_PREV_POSIT_IS_ALREADY_OCCUPIED;
        return;
      }
      if (isErrorJieViolation()) {
        moveType = MoveType.MOVE_ERROR_JIE_VIOLATION;
        return;
      }

      // Create candidate board after the move.
      // The reason why we need a candidate is because there might be some special cases.
      PositionStateBoard positionStateBoardAfterMoveCandidate =
          positionStateBoardBeforeMove.toBuilder()
              .setPositionState(moveXPosition, moveYPosition, moveColor.getPositionState())
              .build();
      ColorBlock createdColorBlockAfterMoveCandidate =
          (ColorBlock) positionStateBoardAfterMoveCandidate.constructBlock(
              moveCoord, moveColor.getPositionState());
      ImmutableSet<ColorBlock> neighborBlocksAfterMoveCandidate =
          positionStateBoardAfterMoveCandidate.constructNeighborColorBlocks(
              createdColorBlockAfterMoveCandidate);
      ImmutableSet.Builder<ColorBlock> zeroQiNeighborBlocksBuilder = ImmutableSet.builder();
      for (ColorBlock neighborBlock : neighborBlocksAfterMoveCandidate) {
        boolean hasAnyQi = positionStateBoardAfterMoveCandidate.hasAnyQiForBlock(neighborBlock);
        if (!hasAnyQi) {
          zeroQiNeighborBlocksBuilder.add(neighborBlock);
        }
      }
      ImmutableSet<ColorBlock> zeroQiNeighborBlocksOfMoveBlockAfterMoveCandidate =
          zeroQiNeighborBlocksBuilder.build();

      int countOfZeroQiNeighborBlocksOfMoveBlockAfterMoveCandidate =
          zeroQiNeighborBlocksOfMoveBlockAfterMoveCandidate.size();

      boolean isMoveBlockZeroQi = !positionStateBoardAfterMoveCandidate.hasAnyQiForBlock(
          createdColorBlockAfterMoveCandidate);

      // Handle the case when no neighbor block is dead.
      if (countOfZeroQiNeighborBlocksOfMoveBlockAfterMoveCandidate == 0) {
        if (isMoveBlockZeroQi) {
          moveType = MoveType.MOVE_ERROR_SUICIDE;
          return;
        }

        positionStateBoardAfterMove = positionStateBoardAfterMoveCandidate;

        // Determine if it is self-fill-eye or regular move.
        if (isMoveOfSelfFillOneEyeForOneBuddyBlock()) {
          moveType = MoveType.MOVE_SELF_FILL_ONE_EYE_FOR_ONE_BUDDY_BLOCK;
          return;
        } else {  // It is a regular move.
          moveType = MoveType.MOVE_REGULAR;
          return;
        }
      }

      // It must be an eating move (with or without Jie) now.
      // Update deadCoords.
      assert(countOfZeroQiNeighborBlocksOfMoveBlockAfterMoveCandidate > 0);
      ImmutableSet.Builder<Coord> allDeadCoordsBuilder = ImmutableSet.builder();
      for (ColorBlock deadBlock : zeroQiNeighborBlocksOfMoveBlockAfterMoveCandidate) {
        allDeadCoordsBuilder.addAll(deadBlock.getCoords());
      }
      deadCoords = allDeadCoordsBuilder.build();

      // Construct board updated with dead.
      positionStateBoardAfterMove = positionStateBoardAfterMoveCandidate.toBuilder()
          .setPositionStates(deadCoords, PositionState.VACANT)
          .build();

      // Determine if it is a Jie or a regular eating move.
      if (createdColorBlockAfterMoveCandidate.size() == 1
          && deadCoords.size() == 1
          && isMoveBlockZeroQi) {  // It is Jie.
        jieDeadCoord = deadCoords.iterator().next();
        moveType = MoveType.MOVE_EAT_CAUSING_JIE;
        return;
      } else {  // Else, it is a regular eating move.
        moveType = MoveType.MOVE_EAT_NO_JIE;
        return;
      }
    }

    // TODO 150 Improve performance of isMoveOfSelfFillOneEyeForOneBuddyBlock().
    private boolean isMoveOfSelfFillOneEyeForOneBuddyBlock() {
      long time00;
      if (FLAG_PROFILE) time00 = System.nanoTime();
      VacantBlock vacantBlockBeforeMove = (VacantBlock)
          positionStateBoardBeforeMove.constructBlock(moveCoord, PositionState.VACANT);
      if (vacantBlockBeforeMove.size() > 1) {
        return false;
      }

      Color buddyColor = this.moveColor;
      ImmutableSet<ColorBlock> buddyNeighborBlocksBeforeMove = positionStateBoardBeforeMove
          .constructNeighborColorBlocks(vacantBlockBeforeMove, buddyColor);
      if (buddyNeighborBlocksBeforeMove.size() > 1) {
        return false;
      }

      ImmutableSet<ColorBlock> foeNeighborBlocksBeforeMove = positionStateBoardBeforeMove
          .constructNeighborColorBlocks(vacantBlockBeforeMove, buddyColor.swap());
      if (FLAG_PROFILE) Utils.profile(
          time00,
          5,  // max 5 ms
          "isMoveOfSelfFillOneEyeForOneBuddyBlock");
      return (foeNeighborBlocksBeforeMove.size() == 0);
    }

    private boolean isErrorPrevPositIsAlreadyOccupied() {
      assert(!hasCheckedErrorPrevPositIsAlreadyOccupied);
      hasCheckedErrorPrevPositIsAlreadyOccupied = true;
      PositionState positionState =
          positionStateBoardBeforeMove.getPositionState(moveXPosition, moveYPosition);
      return !positionState.isVacant();
    }

    private boolean isErrorJieViolation() {
      assert(hasCheckedErrorPrevPositIsAlreadyOccupied);
      assert(!hasCheckedErrorJieViolation);
      hasCheckedErrorJieViolation = true;
      if (!prevJieDeadCoordOptional.isPresent()) {
        return false;
      }
      Coord currentJieDeadCoord = prevJieDeadCoordOptional.get();
      return moveCoord.equals(currentJieDeadCoord);
    }
  }
}
