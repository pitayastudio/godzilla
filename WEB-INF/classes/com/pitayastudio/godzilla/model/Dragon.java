package com.pitayastudio.godzilla.model;

import com.google.common.collect.ImmutableSet;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.modelboard.GangBoard;

import javax.annotation.Nonnull;

/**
 * TODO 300 Implement Dragon.
 * @see DesignDoc#dragonAndArea()
 */
public class Dragon {
  public static Builder newBuilder() {
    return new Builder();
  }

  public static Dragon readDragonFromString(String boardInput, GangBoard gangBoard,
      Color color, char targetColorChar, char targetVacantChar) {
    ImmutableSet<Gang> gangs =
        Gang.readGangsFromString(boardInput, gangBoard, color, targetColorChar, targetVacantChar);
    return newBuilder().setRequiredColor(color).addGangs(gangs).build();
  }

  private final Color color;
  private final ImmutableSet<Gang> gangs;
  private final ImmutableSet<SemiRealm> semiRealms;

  private Dragon(
      @Nonnull Color color,
      @Nonnull ImmutableSet<Gang> gangs,
      @Nonnull ImmutableSet<SemiRealm> semiRealms) {
    this.color = color;
    this.gangs = gangs;
    this.semiRealms = semiRealms;
  }

  public Color getColor() {
    return color;
  }

  public ImmutableSet<Gang> getGangs() {
    return gangs;
  }

  public ImmutableSet<SemiRealm> getSemiRealms() {
    return semiRealms;
  }

  public static class Builder {
    private Color color;
    private final ImmutableSet.Builder<Gang> gangsBuilder = ImmutableSet.builder();
    private final ImmutableSet.Builder<SemiRealm> semiRealmsBuilder = ImmutableSet.builder();

    private Builder() {}

    public Builder setRequiredColor(@Nonnull Color color) {
      this.color = color;
      return this;
    }

    public Builder addGang(@Nonnull Gang gang) {
      gangsBuilder.add(gang);
      return this;
    }

    public Builder addGangs(@Nonnull Iterable<Gang> gangs) {
      gangsBuilder.addAll(gangs);
      return this;
    }

    public Builder addSemiRealm(@Nonnull SemiRealm semiRealm) {
      semiRealmsBuilder.add(semiRealm);
      return this;
    }

    public Builder addSemiRealms(@Nonnull Iterable<SemiRealm> semiRealms) {
      semiRealmsBuilder.addAll(semiRealms);
      return this;
    }

    public Dragon build() {
      assert (null != color);
      ImmutableSet<Gang> gangs = gangsBuilder.build();
      assert(!gangs.isEmpty());
      ImmutableSet<SemiRealm> semiRealms = semiRealmsBuilder.build();
      return new Dragon(color, gangs, semiRealms);
    }
  }
}
