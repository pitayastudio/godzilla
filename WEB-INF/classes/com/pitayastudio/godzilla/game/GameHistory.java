package com.pitayastudio.godzilla.game;

import com.google.common.base.Optional;
import com.google.gson.JsonObject;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.MoveType;
import com.pitayastudio.godzilla.computerplayer.MoveHandling;
import com.pitayastudio.godzilla.computerplayer.SearchNode;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.modelboard.BlockBoard;
import com.pitayastudio.godzilla.modelboard.CoordBoard;
import com.pitayastudio.godzilla.modelboard.PositionStateBoard;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Nonnull;

/**
 * Mutable game history.
 */
public class GameHistory {
  @SuppressWarnings("unused")
  private static final Logger logger = Logger.getLogger(GameHistory.class.getName());

  private static final String SUMMARY_OBJECT_LATEST_MOVE_COORD = "latestMoveCoord";
  private static final String SUMMARY_PROPERTY_IS_LATEST_MOVE_PASS = "isLatestMovePass";
  private static final String SUMMARY_PROPERTY_COLOR_FOR_NEXT_MOVE = "colorForNextMove";
  private static final String SUMMARY_PROPERTY_NUMBER_OF_MOVES = "numberOfMoves";

  private final ReadOnlyWrappedGameHistory readOnlyWrappedGameHistory;

  /**
   * List of {@link MoveHandling}'s.
   *
   * <p>Note: the initial one, namely, element 0 of the list, does not have any move.
   */
  private final List<MoveHandling> moveHandlingList = new ArrayList<>();

  /**
   * The initial time-spent for the root {@link MoveHandling} is 0.
   */
  private final List<Integer> timeSpentMillisList = new ArrayList<>();

  private SearchNode latestNode;

  private boolean isGameStarted;

  public GameHistory() {
    readOnlyWrappedGameHistory = new ReadOnlyWrappedGameHistory(this);
    isGameStarted = false;
  }

  public SearchNode getLatestNode() {
    assert(isGameStarted);
    return latestNode;
  }

  public ReadOnlyWrappedGameHistory getReadOnlyWrappedGameHistory() {
    return readOnlyWrappedGameHistory;
  }

  int getNumOfMoveHandlingsIncludingTheRoot() {
    assert(isGameStarted);
    return moveHandlingList.size();
  }

  /**
   * Gets {@link MoveHandling} at move count.
   * If move count is 0, then the returned one does not have any move.
   */
  public MoveHandling getMoveHandlingAtMoveCount(int moveCount) {
    assert isGameStarted;
    return moveHandlingList.get(moveCount);
  }

  public Integer getTimeSpentMillis(int moveCount) {
    assert isGameStarted;
    assert moveCount >= 1 && moveCount < timeSpentMillisList.size();
    return timeSpentMillisList.get(moveCount);
  }

  public MoveHandling getLatestMoveHandling() {
    assert(isGameStarted);
    assert(!moveHandlingList.isEmpty());
    return moveHandlingList.get(moveHandlingList.size() - 1);
  }

  /**
   * Starts game. Creates root {@link SearchNode}, initial {@link BlockBoard}, initial
   * {@link MoveHandling}, etc.
   */
  public void startGame(@Nonnull CoordBoard coordBoard) {
    assert(!isGameStarted);
    isGameStarted = true;
    PositionStateBoard initialPositStateBoard = PositionStateBoard.newBuilder(coordBoard).build();
    latestNode = SearchNode.constructRootNodeWithMoveHandling(initialPositStateBoard);
    moveHandlingList.clear();
    timeSpentMillisList.clear();
    MoveHandling initialMoveHandling = latestNode.getMoveHandling();
    moveHandlingList.add(initialMoveHandling);
    timeSpentMillisList.add(0);
  }

  /**
   * Removes latest {@link MoveHandling} and time-spent.
   * If the current move is an UNDO, the previous spent-time is not reverted in {@link GameStatus}.
   * However, the previous spent-time is removed from {@link GameHistory}.
   * So, this method must be called after {@link TimeStatus#updateTimeForUndo}
   * for an UNDO move.
   */
  void removeLatestMoveHandlingAndTimeSpent() {
    assert(isGameStarted);
    assert(latestNode.getParentOptional().isPresent());

    // Note, time-spent is not reverted in an UNDO move.
    int timeSpentsCount = timeSpentMillisList.size();
    assert(timeSpentsCount > 0);
    int size = moveHandlingList.size();
    assert(size > 0);
    assert(timeSpentsCount == size);

    timeSpentMillisList.remove(timeSpentsCount - 1);
    moveHandlingList.remove(size - 1);

    // Update latestNode.
    latestNode = latestNode.getParentOptional().get();
  }

  public void addNewNodeAndMoveHandlingAndTimeSpent(
      @Nonnull SearchNode searchNode,
      @Nonnull MoveHandling moveHandling,
      @Nonnull Integer timeSpentMillis) {
    assert(isGameStarted);
    assert(timeSpentMillis >= 0);
    latestNode = searchNode;
    moveHandlingList.add(moveHandling);
    timeSpentMillisList.add(timeSpentMillis);
  }

  /**
   * Returns number of moves including pass moves.
   */
  public int findNumberOfMoves() {
    assert(isGameStarted);
    int count = getNumOfMoveHandlingsIncludingTheRoot();
    // There should be always at least one representing the original empty one.
    assert(count >= 1);
    return count - 1;
  }

  public Color findColorForNextMove() {
    assert(isGameStarted);
    int moveCount = findNumberOfMoves();
    return findColorForMoveCount(moveCount + 1);
  }

  private static Color findColorForMoveCount(int moveCount) {
    assert(moveCount > 0);
    return ((moveCount & 1) == 0) ? Color.W : Color.B;
  }

  public JsonObject toSummaryJsonObject() {
    assert(isGameStarted);
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty(SUMMARY_PROPERTY_NUMBER_OF_MOVES, findNumberOfMoves());
    jsonObject.addProperty(SUMMARY_PROPERTY_COLOR_FOR_NEXT_MOVE, findColorForNextMove().toString());

    MoveHandling latestMoveHandling = getLatestMoveHandling();
    boolean isLatestMovePass = latestMoveHandling.getMoveType() == MoveType.MOVE_PASS;
    jsonObject.addProperty(SUMMARY_PROPERTY_IS_LATEST_MOVE_PASS, isLatestMovePass);
    if (!isLatestMovePass) {
      Optional<Coord> latestMoveCoordOptional = latestMoveHandling.getMoveCoordOptional();
      if (latestMoveCoordOptional.isPresent()) {
        jsonObject.add(SUMMARY_OBJECT_LATEST_MOVE_COORD,
            latestMoveCoordOptional.get().toJsonObject());
      }
    }
    return jsonObject;
  }

  public static class ReadOnlyWrappedGameHistory {
    private final GameHistory gameHistory;

    private ReadOnlyWrappedGameHistory(@Nonnull GameHistory gameHistory) {
      this.gameHistory = gameHistory;
    }

    int getNumOfMoveHandlingsIncludingTheRoot() {
      return gameHistory.getNumOfMoveHandlingsIncludingTheRoot();
    }

    public MoveHandling getMoveHandlingAtMoveCount(int moveCount) {
      return gameHistory.getMoveHandlingAtMoveCount(moveCount);
    }

    public Integer getTimeSpentMillis(int moveCount) {
      return gameHistory.getTimeSpentMillis(moveCount);
    }

    public MoveHandling getLastestMoveHandling() {
      return gameHistory.getLatestMoveHandling();
    }

    /**
     * Returns number of moves including pass moves.
     */
    public int findNumberOfMoves() {
      return gameHistory.findNumberOfMoves();
    }

    public Color findColorForNextMove() {
      return gameHistory.findColorForNextMove();
    }

    public JsonObject toSummaryJsonObject() {
      return gameHistory.toSummaryJsonObject();
    }

    public SearchNode getLatestNode() {
      return gameHistory.getLatestNode();
    }

    public boolean isGameStarted() {
      return gameHistory.isGameStarted;
    }
  }
}
