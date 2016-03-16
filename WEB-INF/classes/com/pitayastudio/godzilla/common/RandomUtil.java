package com.pitayastudio.godzilla.common;

import java.util.List;
import java.util.Random;

import javax.annotation.Nonnull;

public class RandomUtil {
  @Nonnull private final Random random;

  public RandomUtil(@Nonnull Random random) {
    this.random = random;
  }

  public <T> T pickRandomElement(@Nonnull List<T> list) {
    int size = list.size();
    int randomIndex = random.nextInt(size);
    return list.get(randomIndex);
  }
}
