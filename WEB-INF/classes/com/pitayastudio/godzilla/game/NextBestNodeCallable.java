package com.pitayastudio.godzilla.game;

import com.pitayastudio.godzilla.computerplayer.ComputerPlayer;
import com.pitayastudio.godzilla.computerplayer.SearchNode;

import java.util.concurrent.Callable;
import java.util.logging.Logger;

import javax.annotation.Nonnull;

/**
 * NOT USED YET.
 */
public class NextBestNodeCallable implements Callable<SearchNode> {
  private static final Logger logger = Logger.getLogger(NextBestNodeCallable.class.getName());

  private final ComputerPlayer computerPlayer;

  private NextBestNodeCallable(@Nonnull ComputerPlayer computerPlayer) {
    logger.info("in NextBestNodeCallable()");
    this.computerPlayer = computerPlayer;
  }

  @Override public SearchNode call() throws Exception {
    logger.info("in NextBestNodeCallable.call()");
    SearchNode nextBestNode = computerPlayer.genNextMoveTakingLongTime(true, true);
    return nextBestNode;
  }
}
