package com.pitayastudio.godzilla.game;

import com.google.gson.JsonObject;

import com.pitayastudio.godzilla.common.Color;

import javax.annotation.Nonnull;

/**
 * Immutable game result.
 */
public class GameResult {

  public static Builder newBuilder() {
    return new Builder();
  }

  private final Color colorOfWinner;
  private final boolean isResigned;
  private final int blackDeadCount;
  private final int whiteDeadCount;
  private final int vacantTerritoryOfBlack;
  private final int vacantTerritoryOfWhite;
  private final double blackWinPoints;

  private GameResult(Builder builder) {
    this.colorOfWinner = builder.colorOfWinner;
    this.isResigned = builder.isResigned;
    this.blackDeadCount = builder.blackDeadCount;
    this.whiteDeadCount = builder.whiteDeadCount;
    this.vacantTerritoryOfBlack = builder.vacantTerritoryOfBlack;
    this.vacantTerritoryOfWhite = builder.vacantTerritoryOfWhite;
    this.blackWinPoints = builder.blackWinPointsByJapanRule;
  }

  public Color getColorOfWinner() {
    return colorOfWinner;
  }

  public boolean isResigned() {
    return isResigned;
  }

  public int getDeadCountForColor(Color color) {
    return color == Color.B
        ? blackDeadCount
        : whiteDeadCount;
  }

  public double calcWinPointsByJapanRule() {
    return Math.abs(blackWinPoints);
  }

  public int getVacantTerritory(@Nonnull Color color) {
    if (color == Color.B) {
      return vacantTerritoryOfBlack;
    } else {
      return vacantTerritoryOfWhite;
    }
  }

  public JsonObject toJsonObject() {
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("colorOfWinner", colorOfWinner.toString());
    jsonObject.addProperty("isResigned", isResigned);
    jsonObject.addProperty("blackDeadCount", blackDeadCount);
    jsonObject.addProperty("whiteDeadCount", whiteDeadCount);
    jsonObject.addProperty("vacantTerritoryOfBlack", vacantTerritoryOfBlack);
    jsonObject.addProperty("vacantTerritoryOfWhite", vacantTerritoryOfWhite);
    jsonObject.addProperty("blackWinPoints", blackWinPoints);
    return jsonObject;
  }

  @Override
  public String toString() {
    return toJsonObject().toString();
  }

  public static class Builder {
    private Color colorOfWinner;
    private boolean isResigned = false;  // default
    private double komi;
    private int blackDeadCount;
    private int whiteDeadCount;
    private int vacantTerritoryOfBlack;
    private int vacantTerritoryOfWhite;
    private double blackWinPointsByJapanRule;

    public Builder setColorOfWinner(@Nonnull Color colorOfWinner) {
      this.colorOfWinner = colorOfWinner;
      return this;
    }

    public Builder setIsResigned() {
      this.isResigned = true;
      return this;
    }

    public Builder setKomi(double komi) {
      this.komi = komi;
      return this;
    }

    public Builder setBlackDeadCount(int blackDeadCount) {
      this.blackDeadCount = blackDeadCount;
      return this;
    }

    public Builder setWhiteDeadCount(int whiteDeadCount) {
      this.whiteDeadCount = whiteDeadCount;
      return this;
    }

    public Builder setVacantTerritoryOfBlack(int vacantTerritoryOfBlack) {
      this.vacantTerritoryOfBlack = vacantTerritoryOfBlack;
      return this;
    }

    public Builder setVacantTerritoryOfWhite(int vacantTerritoryOfWhite) {
      this.vacantTerritoryOfWhite = vacantTerritoryOfWhite;
      return this;
    }

    public GameResult build() {
      if (!isResigned) {
        blackWinPointsByJapanRule = calcBlackWinPointsByJapanRule();
        updateColorOfWinnerByCountingPoints();
      }
      return new GameResult(this);
    }

    private void updateColorOfWinnerByCountingPoints() {
      assert(blackWinPointsByJapanRule != 0);
      colorOfWinner = (blackWinPointsByJapanRule > 0) ? Color.B : Color.W;
    }

    private double calcBlackWinPointsByJapanRule() {
      return calcBlackTotalPointsByJapanRule() - calcWhiteTotalPointsWithKomiByJapanRule();
    }

    private int calcBlackTotalPointsByJapanRule() {
      return vacantTerritoryOfBlack + whiteDeadCount;
    }

    private double calcWhiteTotalPointsWithKomiByJapanRule() {
      return vacantTerritoryOfWhite + blackDeadCount + komi;
    }
  }
}
