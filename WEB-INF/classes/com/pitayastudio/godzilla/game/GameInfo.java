package com.pitayastudio.godzilla.game;

import com.google.gson.JsonObject;

import com.pitayastudio.godzilla.common.Utils;

import javax.annotation.Nonnull;

/**
 * Immutable Game Info.
 */
public class GameInfo {
  public static final String BLACK_PLAYER = "blackPlayer";
  public static final String WHITE_PLAYER = "whitePlayer";
  public static final String PLAYER_HUMAN = "human";
  public static final String PLAYER_COMPUTER = "computer";
  public static final String BOARD_SIZE = "boardSize";
  public static final String GAME_NAME = "gameName";
  public static final String GAME_DATE = "gameDate";
  public static final String HANDICAP_COUNT = "handicapCount";
  public static final String KOMI = "komi";
  public static final String TIME_LIMIT_IN_MIN = "timeLimitInMin";
  public static final String TIME_COUNTDOWN_IN_SEC = "timeCountdownInSec";
  public static final String TIME_COUNTDOWN_TIMES = "timeCountdownTimes";


  public static Builder newBuilder() {
    return new Builder();
  }

  /**
   * The values could be {@link #PLAYER_HUMAN} or {@link #PLAYER_COMPUTER}.
   */
  private final String blackPlayer;
  /**
   * The values could be {@link #PLAYER_HUMAN} or {@link #PLAYER_COMPUTER}.
   */
  private final String whitePlayer;
  private final int boardSize;
  private final String gameName;
  private final String gameDate;
  private final int handicapCount;
  private final double komi;
  private final int timeLimitInMin;
  private final int timeCountdownInSec;
  private final int timeCountdownTimes;

  private GameInfo(@Nonnull Builder builder) {
    this.blackPlayer = builder.blackPlayer;
    this.whitePlayer = builder.whitePlayer;
    this.boardSize = builder.boardSize;
    this.gameName = builder.gameName;
    this.gameDate = builder.gameDate;
    this.handicapCount = builder.handicapCount;
    this.komi = builder.komi;
    this.timeLimitInMin = builder.timeLimitInMin;
    this.timeCountdownInSec = builder.timeCountdownInSec;
    this.timeCountdownTimes = builder.timeCountdownTimes;
  }

  public int getBoardSize() {
    return boardSize;
  }

  public String getGameName() {
    return gameName;
  }

  public String getGameDate() {
    return gameDate;
  }

  public int getHandicapCount() {
    return handicapCount;
  }

  public double getKomi() {
    return komi;
  }

  public int getKomiRoundedDown() {
    return (int) komi;
  }

  public int getTimeLimitInMin() {
    return timeLimitInMin;
  }

  public int getTimeCountdownInSec() {
    return timeCountdownInSec;
  }

  public int getTimeCountodownTimes() {
    return timeCountdownTimes;
  }

  public JsonObject toJsonObject() {
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty(BLACK_PLAYER, blackPlayer);
    jsonObject.addProperty(WHITE_PLAYER, whitePlayer);
    jsonObject.addProperty(BOARD_SIZE, boardSize);
    jsonObject.addProperty(GAME_NAME, gameName);
    jsonObject.addProperty(GAME_DATE, gameDate);
    jsonObject.addProperty(HANDICAP_COUNT, handicapCount);
    jsonObject.addProperty(KOMI, komi);
    jsonObject.addProperty(TIME_LIMIT_IN_MIN, timeLimitInMin);
    jsonObject.addProperty(TIME_COUNTDOWN_IN_SEC, timeCountdownInSec);
    jsonObject.addProperty(TIME_COUNTDOWN_TIMES, timeCountdownTimes);
    return jsonObject;
  }

  @Override
  public String toString() {
    return toJsonObject().toString();
  }

  public static class Builder {
    private String blackPlayer;
    private String whitePlayer;
    private int boardSize;
    private String gameName;
    private String gameDate;
    private int handicapCount;
    private double komi;
    private int timeLimitInMin;
    private int timeCountdownInSec;
    private int timeCountdownTimes;

    private Builder() {}

    /** Not required. The black/white player could be both computer/human in one game. */
    public Builder setBlackPlayer(@Nonnull String blackPlayer) {
      this.blackPlayer = blackPlayer;
      return this;
    }

    /** Not required. The black/white player could be both computer/human in one game. */
    public Builder setWhitePlayer(@Nonnull String whitePlayer) {
      this.whitePlayer = whitePlayer;
      return this;
    }

    public Builder setRequiredBoardSize(int boardSize) {
      this.boardSize = boardSize;
      return this;
    }

    public Builder setGameName(@Nonnull String gameName) {
      this.gameName = gameName;
      return this;
    }

    public Builder setGameDate(@Nonnull String gameDate) {
      this.gameDate = gameDate;
      return this;
    }

    public Builder setHandicapCount(int handicapCount) {
      this.handicapCount = handicapCount;
      return this;
    }

    public Builder setKomi(double komi) {
      this.komi = komi;
      return this;
    }

    public Builder setRequiredTimeLimitInMin(int timeLimitInMin) {
      this.timeLimitInMin = timeLimitInMin;
      return this;
    }

    public Builder setTimeCountdownInSec(int timeCountdownInSec) {
      this.timeCountdownInSec = timeCountdownInSec;
      return this;
    }

    public Builder setTimeCountdownTimes(int timeCountdownTimes) {
      this.timeCountdownTimes = timeCountdownTimes;
      return this;
    }

    public GameInfo build() {
      assert(Utils.isValidBoardSize(boardSize));
      assert(handicapCount >= 0);
      assert(komi >= 0.0);
      assert(timeLimitInMin > 0);
      assert(timeCountdownInSec >= 0);
      assert(timeCountdownTimes >= 0);

      if (gameName == null) {
        gameName = "";
      }
      if (gameDate == null) {
        gameDate = "";
      }

      return new GameInfo(this);
    }
  }
}
