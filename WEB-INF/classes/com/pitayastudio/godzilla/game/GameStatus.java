package com.pitayastudio.godzilla.game;

import com.google.gson.JsonObject;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.game.TimeStatus.ReadOnlyWrappedTimeStatus;

import javax.annotation.Nonnull;

/**
 * Mutable game status.
 */
public class GameStatus {
  // TODO 200 Add GameStatus.BLACK_REMAINING_COUNTDOWN_TIMES
  private static final String CURRENT_PLAY_STAGE = "currentPlayStage";
  private static final String BLACK_DEAD_COUNT = "blackDeadCount";
  private static final String WHITE_DEAD_COUNT = "whiteDeadCount";
  private static final String BLACK_TIME_LEFT_MILLIS = "blackRemainingTimeMillis";
  private static final String WHITE_TIME_LEFT_MILLIS = "whiteRemainingTimeMillis";

  private PlayStage currentPlayStage;
  private int blackDeadCount;
  private int whiteDeadCount;
  private final TimeStatus timeStatus;
  private final ReadOnlyWrappedGameStatus readOnlyWrappedGameStatus;

  public GameStatus(int timeLimitInMin) {
    currentPlayStage = PlayStage.PLAY_STAGE_STOPPED;
    timeStatus = new TimeStatus(timeLimitInMin);
    readOnlyWrappedGameStatus = new ReadOnlyWrappedGameStatus(this);
  }

  public PlayStage getCurrentPlayStage() {
    return currentPlayStage;
  }

  public void setCurrentPlayStage(PlayStage currentPlayStage) {
    this.currentPlayStage = currentPlayStage;
  }

  public TimeStatus getTimeStatus() {
    return timeStatus;
  }

  int getDeadCount(@Nonnull Color color) {
    if (color == Color.B) {
      return blackDeadCount;
    } else {
      return whiteDeadCount;
    }
  }

  public ReadOnlyWrappedGameStatus getReadOnlyWrappedGameStatus() {
    return readOnlyWrappedGameStatus;
  }

  void startGame() {
    currentPlayStage = PlayStage.PLAY_STAGE_STARTED;
    this.blackDeadCount = 0;
    this.whiteDeadCount = 0;
    timeStatus.startGame();
  }

  void incrementDeadForColor(@Nonnull Color color, int count) {
    assert(count >= 0);
    if (color == Color.B) {
      blackDeadCount += count;
    } else {
      whiteDeadCount += count;
    }
  }

  void decrementDeadForColor(@Nonnull Color color, int count) {
    assert(count >= 0);
    if (color == Color.B) {
      blackDeadCount -= count;
    } else {
      whiteDeadCount -= count;
    }
  }

  public JsonObject toJsonObject() {
    JsonObject json = new JsonObject();
    json.addProperty(CURRENT_PLAY_STAGE, currentPlayStage.toString());
    json.addProperty(BLACK_DEAD_COUNT, blackDeadCount);
    json.addProperty(WHITE_DEAD_COUNT, whiteDeadCount);
    json.addProperty(BLACK_TIME_LEFT_MILLIS, timeStatus.getRemainingTimeMillisForColor(Color.B));
    json.addProperty(WHITE_TIME_LEFT_MILLIS, timeStatus.getRemainingTimeMillisForColor(Color.W));
    return json;
  }

  @Override
  public String toString() {
    return toJsonObject().toString();
  }

  public static class ReadOnlyWrappedGameStatus {
    private final GameStatus gameStatus;

    private ReadOnlyWrappedGameStatus(GameStatus gameStatus) {
      this.gameStatus = gameStatus;
    }

    public PlayStage getCurrentPlayStage() {
      return gameStatus.currentPlayStage;
    }

    public ReadOnlyWrappedTimeStatus getReadOnlyWrappedTimeStatus() {
      return gameStatus.timeStatus.getReadOnlyWrappedTimeStatus();
    }

    public int getDeadCount(@Nonnull Color color) {
      return gameStatus.getDeadCount(color);
    }
  }
}
