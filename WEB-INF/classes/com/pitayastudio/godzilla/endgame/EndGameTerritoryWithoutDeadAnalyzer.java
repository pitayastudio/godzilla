package com.pitayastudio.godzilla.endgame;

import com.google.common.collect.ImmutableSet;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.model.Lot;
import com.pitayastudio.godzilla.modelboard.LandBoard;
import com.pitayastudio.godzilla.modelboard.LotBoard;

import javax.annotation.Nonnull;

public class EndGameTerritoryWithoutDeadAnalyzer {
  public static Builder newBuilder() {
    return new Builder();
  }

  public static EndGameTerritoryWithoutDeadAnalyzer readFromString(@Nonnull String boardInput) {
    LandBoard qiBoard = LandBoard.readFromString(boardInput);
    LotBoard lotBoard = LotBoard.newBuilder()
        .setRequiredLandBoard(qiBoard)
        .build();
    EndGameTerritoryWithoutDeadAnalyzer analyzer = newBuilder()
        .setRequiredLotBoard(lotBoard)
        .build();
    return analyzer;
  }

  private final EndGameAnalysisResultSuccessType analysisResultType;
  private final int vacantTerritoryOfBlack;
  private final int vacantTerritoryOfWhite;

  private EndGameTerritoryWithoutDeadAnalyzer(
      @Nonnull Builder builder,
      @Nonnull EndGameAnalysisResultSuccessType analysisResultType) {
    this.vacantTerritoryOfBlack = builder.vacantTerritoryOfBlack;
    this.vacantTerritoryOfWhite = builder.vacantTerritoryOfWhite;
    this.analysisResultType = analysisResultType;
  }

  public EndGameAnalysisResultSuccessType getAnalysisResultType() {
    return analysisResultType;
  }

  public int getVacantTerritoryOfBlack() {
    return vacantTerritoryOfBlack;
  }

  public int getVacantTerritoryOfWhite() {
    return vacantTerritoryOfWhite;
  }

  public static class Builder {
    private LotBoard lotBoard;
    // TODO 200 Count territory by China Rule.
    private int vacantTerritoryOfBlack = 0;
    private int vacantTerritoryOfWhite = 0;

    private Builder() {}

    public Builder setRequiredLotBoard(@Nonnull LotBoard lotBoard) {
      this.lotBoard = lotBoard;
      return this;
    }

    public EndGameTerritoryWithoutDeadAnalyzer build() {
      assert (null != lotBoard);
      EndGameAnalysisResultSuccessType analysisResultType = analyze();
      return new EndGameTerritoryWithoutDeadAnalyzer(this, analysisResultType);
    }

    /**
     * @see DesignDoc#endGameAssumption()
     * @see DesignDoc#countPoints()
     */
    private EndGameAnalysisResultSuccessType analyze() {
      vacantTerritoryOfBlack = 0;
      ImmutableSet<Lot> blackLotPluses = lotBoard.getLotsOfColor(Color.B);
      for (Lot lotPlus : blackLotPluses) {
        vacantTerritoryOfBlack += lotPlus.getVacantTerritoryCount();
      }

      vacantTerritoryOfWhite = 0;
      ImmutableSet<Lot> whiteLotPluses = lotBoard.getLotsOfColor(Color.W);
      for (Lot gameLot : whiteLotPluses) {
        vacantTerritoryOfWhite += gameLot.getVacantTerritoryCount();
      }

      return EndGameAnalysisResultSuccessType.OK;
    }
  }
}
