package com.pitayastudio.godzilla.game;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.computerplayer.MoveHandling;

import javax.annotation.Nonnull;

/**
 * Mutable time status.
 */
public class TimeStatus {
  private int timeSpentForLastMoveMillis;
  private long lastTimeUpdatedInSystemMillis;
  private int blackRemainingTimeMillis;
  private int whiteRemainingTimeMillis;
  private final ReadOnlyWrappedTimeStatus readOnlyWrappedTimeStatus;
  // TODO 200 Handle black/whiteRemainingCountdownTimes.

  TimeStatus(int timeLimitInMin) {
    blackRemainingTimeMillis = timeLimitInMin * 60000;
    whiteRemainingTimeMillis = timeLimitInMin * 60000;
    readOnlyWrappedTimeStatus = new ReadOnlyWrappedTimeStatus(this);
  }

  int getTimeSpentForLastMoveMillis() {
    return timeSpentForLastMoveMillis;
  }

  int getRemainingTimeMillisForColor(@Nonnull Color color) {
    if (color == Color.B) {
      return blackRemainingTimeMillis;
    } else {
      return whiteRemainingTimeMillis;
    }
  }

  public ReadOnlyWrappedTimeStatus getReadOnlyWrappedTimeStatus() {
    return readOnlyWrappedTimeStatus;
  }

  void startGame() {
    lastTimeUpdatedInSystemMillis = System.currentTimeMillis();
  }

  void updateTimeForColor(@Nonnull Color colorOfThisMove) {
    long systemCurrentTimeMillis = System.currentTimeMillis();
    timeSpentForLastMoveMillis = (int) (systemCurrentTimeMillis - lastTimeUpdatedInSystemMillis);
    lastTimeUpdatedInSystemMillis = systemCurrentTimeMillis;

    if (colorOfThisMove == Color.B)
      this.blackRemainingTimeMillis -= timeSpentForLastMoveMillis;
    else
      this.whiteRemainingTimeMillis -= timeSpentForLastMoveMillis;
  }

  void updateTimeForUndo(@Nonnull GameHistory gameHistory) {
    int inHistSz = gameHistory.getNumOfMoveHandlingsIncludingTheRoot() - 1;
    MoveHandling latestMoveHandling = gameHistory.getLatestMoveHandling();
    assert latestMoveHandling != null : "Error: system is not ready b/c null latestMoveHandling.";
    Color colorOfTheMoveToBeUndone = latestMoveHandling.getMoveColor();
    if (colorOfTheMoveToBeUndone == Color.B) {
      this.blackRemainingTimeMillis += timeSpentForLastMoveMillis;
    } else {
      this.whiteRemainingTimeMillis += timeSpentForLastMoveMillis;
    }

    if (inHistSz > 1) {
      timeSpentForLastMoveMillis = gameHistory.getTimeSpentMillis(inHistSz - 1);
    } else {  // no last move
      timeSpentForLastMoveMillis = 0;
    }

    lastTimeUpdatedInSystemMillis = System.currentTimeMillis();
  }

  public static class ReadOnlyWrappedTimeStatus {
    private final TimeStatus timeStatus;

    private ReadOnlyWrappedTimeStatus(@Nonnull TimeStatus timeStatus) {
      this.timeStatus = timeStatus;
    }

    public int getTimeSpentForLastMoveMillis() {
      return timeStatus.timeSpentForLastMoveMillis;
    }

    public int getRemainingTimeMillisForColor(@Nonnull Color color) {
      return timeStatus.getRemainingTimeMillisForColor(color);
    }
  }
}
