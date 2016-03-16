package com.pitayastudio.godzilla.model;

import com.google.common.collect.ImmutableSet;

import com.pitayastudio.godzilla.common.Color;

import javax.annotation.Nonnull;

/**
 * {@link LotPlus} is equivalent to {@link Lot} plus external {@link VacantBlock}s.
 *
 * @see DesignDoc#typesOfLotPlus
 * @see com.pitayastudio.godzilla.endgame.DesignDoc#endGameAssumption
 */
public class LotPlus {
  private static final boolean FLAG_ENABLE_SELF_ASSERT = true;

  public static Builder newBuilder() {
    return new Builder();
  }

  private final Color color;
  private final ImmutableSet<ClosedLand> closedLands;
  /** @see DesignDoc#land() */
  private final ImmutableSet<OpenLand> openLands;
  private final int closedLandsTerritoryCount;
  private final int openLandTerritoryCount;

  public LotPlus(
      @Nonnull Color color,
      @Nonnull ImmutableSet<ClosedLand> closedLands,
      @Nonnull ImmutableSet<OpenLand> openLands) {
    this.color = color;
    this.closedLands = closedLands;
    this.openLands = openLands;
    closedLandsTerritoryCount = calcClosedLandsTerritoryCount();
    openLandTerritoryCount = calcOpenLandTerritoryCount();

    selfAssert();
  }

  public int getClosedLandsTerritoryCount() {
    return closedLandsTerritoryCount;
  }

  public int getOpenLandTerritoryCount() {
    return openLandTerritoryCount;
  }

  private int calcClosedLandsTerritoryCount() {
    int count = 0;
    for (ClosedLand closedLand : closedLands) {
      VacantBlock vacantBlock = closedLand.getVacantBlock();
      count += vacantBlock.size();
    }
    return count;
  }

  private int calcOpenLandTerritoryCount() {
    int totalSekiQiCount = 0;
    for (OpenLand openLand : openLands) {
      VacantBlock vacantBlock = openLand.getVacantBlock();
      int sekiQiCount = vacantBlock.size();
      assert (sekiQiCount == 1 || sekiQiCount == 2):
          "Invalid sekiQiCount: " + sekiQiCount;
      totalSekiQiCount += sekiQiCount;
    }
    return totalSekiQiCount;
  }

  private void selfAssert() {
    if (!FLAG_ENABLE_SELF_ASSERT) {
      return;
    }
    for (ClosedLand closedLand : closedLands) {
      assert(color == closedLand.getColor());
    }
  }

  public static class Builder {
    private Color color;
    private final ImmutableSet.Builder<ClosedLand> closedLandsBuilder =
        ImmutableSet.builder();
    private final ImmutableSet.Builder<OpenLand> openLandsBuilder =
        ImmutableSet.builder();

    public Builder setColor(@Nonnull Color color) {
      this.color = color;
      return this;
    }

    public Builder addClosedLand(@Nonnull ClosedLand closedLand) {
      closedLandsBuilder.add(closedLand);
      return this;
    }

    public Builder addClosedLands(@Nonnull Iterable<ClosedLand> closedLands) {
      closedLandsBuilder.addAll(closedLands);
      return this;
    }

    public Builder addOpenLand(@Nonnull OpenLand openLand) {
      openLandsBuilder.add(openLand);
      return this;
    }

    public Builder addOpenLands(@Nonnull Iterable<OpenLand> openLands) {
      openLandsBuilder.addAll(openLands);
      return this;
    }

    public ImmutableSet<ClosedLand> getClosedLandsAggregatedSoFar() {
      return closedLandsBuilder.build();
    }

    @Deprecated public ImmutableSet<OpenLand> getOpenLandsAggregatedSoFar() {
      return openLandsBuilder.build();
    }

    public LotPlus build() {
      ImmutableSet<OpenLand> openLands = openLandsBuilder.build();
      return new LotPlus(
          color,
          closedLandsBuilder.build(),
          openLands);
    }
  }
}
