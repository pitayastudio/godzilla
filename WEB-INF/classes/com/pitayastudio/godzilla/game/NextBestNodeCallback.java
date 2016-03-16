package com.pitayastudio.godzilla.game;

import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.FutureCallback;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.computerplayer.MoveHandling;
import com.pitayastudio.godzilla.computerplayer.SearchNode;
import com.pitayastudio.godzilla.model.Coord;

import java.util.logging.Logger;

import javax.annotation.Nonnull;

/**
 * NOT USED YET.
 */
public class NextBestNodeCallback implements FutureCallback<SearchNode> {
  private static final Logger logger = Logger.getLogger(NextBestNodeCallable.class.getName());

  private final GameStatus gameStatus;
  private final GameHistory gameHistory;

  public NextBestNodeCallback(@Nonnull GameStatus gameStatus, @Nonnull GameHistory gameHistory) {
    this.gameStatus = gameStatus;
    this.gameHistory = gameHistory;
  }

  @Override public void onSuccess(SearchNode nextBestNode) {
    logger.info("in onSuccess");
    MoveHandling moveHandling = nextBestNode.getMoveHandling();

    // Update everything.
    // TODO 100 Share code for updating between handleHumanMoveAtCoord() and
    // askComputerToCalculateNextMove().

    // Get color of next move.
    // This computer move is not the first move, and
    // this computer move is not a move after a PASS move.
    // This (next) computer move must exist, even if this computer move is a PASS.
    Color colorOfNextMove = moveHandling.getMoveColor();

    // Update dead coords.
    ImmutableSet<Coord> deadCoords = moveHandling.getDeadCoords();
    int deadCoordsCount = deadCoords.size();
    gameStatus.incrementDeadForColor(colorOfNextMove.swap(), deadCoordsCount);
    // Update timeSpent.
    gameStatus.getTimeStatus().updateTimeForColor(colorOfNextMove);
    int timeSpentMillis = gameStatus.getTimeStatus().getTimeSpentForLastMoveMillis();
    //logger.info("timeSpentMillis: " + timeSpentMillis);
    // Update GameHistory.
    gameHistory.addNewNodeAndMoveHandlingAndTimeSpent(
        nextBestNode, moveHandling, timeSpentMillis);
  }
  @Override public void onFailure(Throwable thrown) {
    logger.info("in onFailure");
  }
}
