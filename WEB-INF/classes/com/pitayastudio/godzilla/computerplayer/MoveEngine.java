package com.pitayastudio.godzilla.computerplayer;


public interface MoveEngine {

  SearchNode getBestNextNode();

  public enum Type {
    RANDOM, MCTS
  }
}
