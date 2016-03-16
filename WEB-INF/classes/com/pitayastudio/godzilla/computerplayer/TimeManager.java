package com.pitayastudio.godzilla.computerplayer;

public class TimeManager {

  int maxSimulationsCount;

  public TimeManager() {
  }

  public void setMaxSimulationsCount(int count) {
    this.maxSimulationsCount = count;
  }

  public boolean hasTime() {
    maxSimulationsCount--;
    return maxSimulationsCount >= 0;
  }
}
