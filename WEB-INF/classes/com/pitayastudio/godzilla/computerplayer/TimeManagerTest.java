package com.pitayastudio.godzilla.computerplayer;

import org.junit.Assert;
import org.junit.Test;

public class TimeManagerTest {

  /** Test for {@link TimeManager#hasTime} */
  @Test public void testHasTime() {
    TimeManager timeManager = new TimeManager();
    // The time manager should always have time when being asked the first time.
    timeManager.setMaxSimulationsCount(2);
    Assert.assertTrue(timeManager.hasTime());
    Assert.assertTrue(timeManager.hasTime());
    Assert.assertFalse(timeManager.hasTime());
  }
}
