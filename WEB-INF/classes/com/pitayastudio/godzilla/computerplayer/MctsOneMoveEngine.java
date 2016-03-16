package com.pitayastudio.godzilla.computerplayer;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.MoveType;
import com.pitayastudio.godzilla.common.PositionState;
import com.pitayastudio.godzilla.common.Utils;
import com.pitayastudio.godzilla.endgame.EndGameAnalysisResultSuccessType;
import com.pitayastudio.godzilla.endgame.EndGameTerritoryWithoutDeadAnalyzer;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.modelboard.BlockBoard;
import com.pitayastudio.godzilla.modelboard.LandBoard;
import com.pitayastudio.godzilla.modelboard.LotBoard;
import com.pitayastudio.godzilla.modelboard.NeighborhoodBoard;
import com.pitayastudio.godzilla.modelboard.PositionStateBoard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import javax.annotation.Nonnull;

public class MctsOneMoveEngine implements MoveEngine {
  private static final Logger logger = Logger.getLogger(MctsOneMoveEngine.class.getName());

  private static final boolean FLAG_PROFILE = true;

  public static Builder newBuilder() {
    return new Builder();
  }

  @Nonnull private SearchNode bestNextNode;

  private MctsOneMoveEngine(@Nonnull SearchNode bestNextNode) {
    this.bestNextNode = bestNextNode;
  }

  @Override public SearchNode getBestNextNode() {
    return bestNextNode;
  }

  public static class Builder {
    private TimeManager timeManager;
    private SearchNode nodeBeforeTheMove;
    private final Random random;

    /**
     * Max node depth allowed for running one simulation.
     * So far, the max value found is 600+ for a 19x19 game.
     */
    private int maxNodeLevelForSimulation;

    /**
     * If komi = 6.5, then komiRoundedDown = 6.
     */
    private int komiRoundedDown = Integer.MIN_VALUE;  // initial value means not set

    private Builder() {
      random = new Random();
    }

    public Builder setRequiredTimeManager(@Nonnull TimeManager timeManager) {
      this.timeManager = timeManager;
      return this;
    }

    public Builder setRequiredNodeBeforeTheMove(@Nonnull SearchNode nodeBeforeTheMove) {
      this.nodeBeforeTheMove = nodeBeforeTheMove;
      return this;
    }

    public Builder setRequiredKomiRoundedDown(int komiRoundedDown) {
      this.komiRoundedDown = komiRoundedDown;
      return this;
    }

    /**
     * Builds {@link MctsOneMoveEngine}. This process could take a long time.
     */
    public MctsOneMoveEngine buildTakingLongTime(
        int maxSimulationsCount, boolean isEndGameEstimated, boolean isPrintReachMaxNodeLevel) {
      assert timeManager != null;
      assert nodeBeforeTheMove != null;
      assert nodeBeforeTheMove.hasMoveHandling();
      assert komiRoundedDown > Integer.MIN_VALUE;

      // Calculate maxNodeLevelForSimulation.
      this.maxNodeLevelForSimulation = calculateMaxNodeLevelForSimulation(nodeBeforeTheMove);

      // TODO 200 MCTS while-loop can be stopped when there is nothing more to search.
      timeManager.setMaxSimulationsCount(maxSimulationsCount);
      while (timeManager.hasTime()) {
        long time00, time01, time02, time03;
        if (FLAG_PROFILE) time00 = System.nanoTime();

        // MCTS-Select.
        SearchNode selectedNode = mctsSelect(nodeBeforeTheMove, random);
        // To avoid super-ko, we need to skip when node level goes too deep.
        int iterNodeLevel = selectedNode.getLevel();
        if (iterNodeLevel >= this.maxNodeLevelForSimulation) {
          if (isPrintReachMaxNodeLevel) {
            MoveHandling iterHandling = selectedNode.getMoveHandling();
            PositionStateBoard positionStateBoard = iterHandling.getPositionStateBoardAfterMove();
            logger.info("Reached max node level for selectedNode:\n" + selectedNode
                + "\nwith positionStateBoard:\n" + positionStateBoard);
          }
          break;
        }

        if (FLAG_PROFILE) time01 = Utils.profile(time00,
            "MctsMoveEngine.buildTakingLongTime.mctsSelect");

        // MCTS-Expand.
        mctsExpandAllChildNodes(selectedNode);

        if (FLAG_PROFILE) time02 = Utils.profile(time01,
            "MctsMoveEngine.buildTakingLongTime.mctsExpandAllChildNodes");

        // MCTS-Simulate.
        // Spent-time. Most time is spent in the Simulation stage among 4 MCTS stages.
        boolean isWin = mctsSimulate(selectedNode, komiRoundedDown, maxNodeLevelForSimulation,
            random, isEndGameEstimated, isPrintReachMaxNodeLevel);

        if (FLAG_PROFILE) time03 = Utils.profile(time02,
            "MctsMoveEngine.buildTakingLongTime.mctsSimulate");

        // MCTS-BackPropogate.
        mctsBackPropogate(selectedNode, isWin);

        if (FLAG_PROFILE) Utils.profile(time03,
            "MctsMoveEngine.buildTakingLongTime.mctsBackPropogate");
      }

      SearchNode bestNextNode =
          findNextNodeWithMostSimulationsOrReturnPassNode(nodeBeforeTheMove, random);
      return new MctsOneMoveEngine(bestNextNode);
    }

    private static int calculateMaxNodeLevelForSimulation(@Nonnull SearchNode nodeBeforeTheMove) {
      MoveHandling moveHandling = nodeBeforeTheMove.getMoveHandling();
      int boardSize = moveHandling.getBoardSize();
      if (boardSize > 5) {
        return 2 * boardSize * boardSize;
      } else {
        // There are some unit tests (on 5x5 board) which contain extra manual PASS moves,
        // so bigger number is required for 5x5 games.
        return 100;
      }
    }

    /**
     * Goes down to the tree and selects a node that has not been fully expanded.
     */
    private static SearchNode mctsSelect(
        @Nonnull SearchNode startingSearchNode, @Nonnull Random random) {
      SearchNode iterSearchNode = startingSearchNode;
      while (iterSearchNode.isAllChildNodesExpanded()) {
        assert iterSearchNode.hasMoveHandling();
        MoveHandling iterMoveHandling = iterSearchNode.getMoveHandling();
        Color iterNextMoveColor = iterMoveHandling.getMoveColor().swap();
        PositionStateBoard iterPositionStateBoard =
            iterMoveHandling.getPositionStateBoardAfterMove();
        Optional<Coord> iterPrevJieDeadCoordOptional = iterMoveHandling.getJieDeadCoordOptional();
        int childNodesCount = iterSearchNode.getChildNodesCount();

        // Randomly select child node.
        // TODO 150 Apply RAVE to select child node.
        int randomIndex = random.nextInt(childNodesCount);
        boolean isAnyLegalChildFound = false;
        for (int i = 0; i < childNodesCount; i++) {
          int index = (randomIndex + i) % childNodesCount;
          SearchNode iterChildSearchNode = iterSearchNode.getChildNode(index);
          MoveHandling iterChildMoveHandling;
          // Create MoveHandling lazily.
          if (iterChildSearchNode.hasMoveHandling()) {
            iterChildMoveHandling = iterChildSearchNode.getMoveHandling();
          } else {
            iterChildMoveHandling = MoveHandling.newBuilderForRegularMoveHandling()
                .setRequiredMoveColor(iterNextMoveColor)
                // A PASS node must already have MoveHandling.
                // So, if a node does not have MoveHandling, then it is not a PASS move, and then
                // it must have coord.
                .setRequiredMoveCoord(iterChildSearchNode.getCoordOptional().get())
                .setRequiredPositionStateBoardBeforeMove(iterPositionStateBoard)
                .setRequiredPrevJieDeadCoordOptional(iterPrevJieDeadCoordOptional)
                .build();
            iterChildSearchNode.setMoveHandling(iterChildMoveHandling);
          }
          MoveType moveType = iterChildMoveHandling.getMoveType();
          if (!moveType.isIllegalMove()) {
            // Advanced one tree node.
            iterSearchNode = iterChildSearchNode;
            isAnyLegalChildFound = true;
            break;  // break for-loop
          } else {
            continue;  // continue for-loop with childNodesCount
          }
        }
        if (!isAnyLegalChildFound) {
          // No legal child node.
          // No more advance is needed.
          // Return a PASS node with parent as iterSearchNode.
          SearchNode passSearchNode = SearchNode.constructPassNodeWithMoveHandling(iterSearchNode);
          iterSearchNode.addChildNode(passSearchNode);
          return passSearchNode;
        }
      }
      return iterSearchNode;
    }

    /**
     * Note: Even if the searchNode is a PASS, we can still expand its child nodes.
     */
    private static void mctsExpandAllChildNodes(@Nonnull SearchNode searchNode) {
      assert !searchNode.isAllChildNodesExpanded();
      // The selected searchNode cannot be illegal move. That means the node must have MoveHandling.
      assert searchNode.hasMoveHandling();

      MoveHandling currentMoveHandling = searchNode.getMoveHandling();
      ImmutableList<Coord> availCoordsForNextMove =
          currentMoveHandling.getOrFindAvailMoveCoordsExceptJie();
      assert(!availCoordsForNextMove.isEmpty());  // There are always vacant positions on the board.

      // Create nodes for all valid moves.
      // But MoveHandlng will be created lazily.
      for (Coord nextCoord : availCoordsForNextMove) {
        SearchNode newChildSearchNode = SearchNode.newBuilder()
            .setRequiredParentNodeOptional(Optional.of(searchNode))
            .setRequiredCoordOptional(Optional.of(nextCoord))
            .build();
        searchNode.addChildNode(newChildSearchNode);
      }
      searchNode.setAllChildNodesExpanded();
    }

    /**
     * Executes the simulation stage of MCTS, and returns whether it is a win for the searchNode.
     *
     * <p>Execution time.
     * 99+% of time is spent in the while loop with {@link #mctsSimulateAdvanceOneNode}.
     * The 2nd-large amount of time is spent in building {@link LandBoard}.
     * However, the time for constructing {@link LandBoard} is negligible compared to the loop with
     * {@link #mctsSimulateAdvanceOneNode}.
     */
    private static boolean mctsSimulate(
        @Nonnull SearchNode selectedSearchNode,
        int komiRoundedDown,
        int maxNodeLevelForSimulation,
        @Nonnull Random random,
        boolean isEndGameEstimated,
        boolean isPrintReachMaxNodeLevel) {
      assert selectedSearchNode.isAllChildNodesExpanded();
      assert selectedSearchNode.hasMoveHandling();

      MoveHandling moveHandlingOfSelectedSearchNode = selectedSearchNode.getMoveHandling();
      boolean isPreviousMovePass =
          moveHandlingOfSelectedSearchNode.getMoveType() == MoveType.MOVE_PASS;
      SearchNode iterNode = selectedSearchNode;

      long time00;
      if (FLAG_PROFILE) time00 = System.nanoTime();

      // Repeat simulations to end game via a while loop.
      // The break of while-loop happens when:
      // (1) Reach maxNodeLevelForSimulation, or
      // (2) 2 consecutive PASSes occur.
      while (true) {
        // Make sure we do not go to endless-deep node.
        // It is possible that the simulation never stops.
        // Below is a real sample (known as super-ko).
        //
        // ●●●●●
        // ●●●●●
        // ○●◦●○
        // ◦○●○◦
        // ○○○○○
        //
        // For simplicity purpose in simulation stage, it is not needed to detect super-ko.
        // Just allow the programs to execute until reaching maxNodeLevelForSimulation.
        int nodeLevel = iterNode.getLevel();
        assert nodeLevel <= maxNodeLevelForSimulation;
        if (nodeLevel == maxNodeLevelForSimulation) {
          if (isPrintReachMaxNodeLevel) {
            MoveHandling troubleMoveHandling = iterNode.getMoveHandling();
            PositionStateBoard troublePositionStateBoard =
                troubleMoveHandling.getPositionStateBoardAfterMove();
            logger.info("Reached max node level for selectedSearchNode:\n" + selectedSearchNode
                + "\ncurrent board:\n" + troublePositionStateBoard
                + "\niterNode:\n" + iterNode);
          }
          break;
        }

        // Advance one node.
        SearchNode nextIterNode = mctsSimulateAdvanceOneNode(iterNode, random);
        assert(!nextIterNode.isRoot());

        // Check 2-consecutive PASSes.
        if (nextIterNode.isPassOrRoot()) {
          if (isPreviousMovePass) {
            break;  // 2 consecutive PASSes
          } else {
            isPreviousMovePass = true;
          }
        } else {
          isPreviousMovePass = false;
        }

        // Everything is fine now. Prepare to advance to the next level of node.
        iterNode = nextIterNode;
      }  // end while
      if (FLAG_PROFILE) Utils.profile(time00,
          "MctsMoveEngine.buildTakingLongTime.mctsSimulate => while loop of calling mctsSimulateAdvanceOneNode's");

      // At this moment, usually iterNode is a PASS move to represent end-game.
      // However, it could be a regular move if super-ko occurs.

      // Evaluate end game.
      // Note, a super-ko which happens during simulation must be of quasi-end-game status.
      boolean isBlackWin =
          evalIfBlackWinsAtEndGameNode(iterNode, komiRoundedDown, isEndGameEstimated);
      Color colorOfSelectedSearchNode = moveHandlingOfSelectedSearchNode.getMoveColor();
      boolean isWin = (colorOfSelectedSearchNode == Color.B) ? isBlackWin : !isBlackWin;
      return isWin;
    }

    private static SearchNode mctsSimulateAdvanceOneNode(
        @Nonnull SearchNode searchNode, @Nonnull Random random) {
      assert searchNode.hasMoveHandling();

      long time00, time01;
      if (FLAG_PROFILE) time00 = System.nanoTime();

      MoveHandling currentMoveHandling = searchNode.getMoveHandling();
      // TODO 200 Evaluate if it is worthy to pass around availCoordsForNextMove.
      ImmutableList<Coord> availCoordsForNextMove =
          currentMoveHandling.getOrFindAvailMoveCoordsExceptJie();
      assert(!availCoordsForNextMove.isEmpty());  // There are always vacant positions on the board.
      int childCount = availCoordsForNextMove.size();
      // Pick one random coord to construct the child node and move.
      // TODO 200 Apply a good algorithm to pick a child node to advance during simulation.
      // If the picked child node is invalid, then repeat with the next available child node.
      int randomIndex = random.nextInt(childCount);

      if (FLAG_PROFILE) time01 = Utils.profile(time00,
          "MctsMoveEngine.buildTakingLongTime.mctsSimulate.mctsSimulateAdvanceOneNode => before for-loop-child");

      // TODO 100 Improve performance of mctsSimulateAdvanceOneNode(): for-loop-child.
      // Majority time spent in mctsSimulateAdvanceOneNode() falls in this for-loop-child.
      for (int i = 0; i < childCount; i++) {
        int index = (i + randomIndex) % childCount;
        Coord coordForNextMove = availCoordsForNextMove.get(index);

        // Get newChildSearchNode.
        SearchNode newChildSearchNode;
        if (searchNode.containsChildNode(coordForNextMove)) {
          newChildSearchNode = searchNode.getChildNode(coordForNextMove);
        } else {
          newChildSearchNode = SearchNode.newBuilder()
              .setRequiredParentNodeOptional(Optional.of(searchNode))
              .setRequiredCoordOptional(Optional.of(coordForNextMove))
              .build();
          searchNode.addChildNode(newChildSearchNode);
        }

        // Get nextMoveHandling and nextMoveType.
        MoveType nextMoveType;
        if (newChildSearchNode.hasMoveHandling()) {
          MoveHandling nextMoveHandling = newChildSearchNode.getMoveHandling();
          nextMoveType = nextMoveHandling.getMoveType();
        } else {
          // Get nextMoveHandling.
          PositionStateBoard currentPositionStateBoard =
              currentMoveHandling.getPositionStateBoardAfterMove();
          Color nextMoveColor = currentMoveHandling.getMoveColor().swap();
          MoveHandling nextMoveHandling = MoveHandling.newBuilderForRegularMoveHandling()
              .setRequiredPositionStateBoardBeforeMove(currentPositionStateBoard)
              .setRequiredMoveColor(nextMoveColor)
              .setRequiredPrevJieDeadCoordOptional(currentMoveHandling.getJieDeadCoordOptional())
              .setRequiredMoveCoord(coordForNextMove)
              .build();
          nextMoveType = nextMoveHandling.getMoveType();
          newChildSearchNode.setMoveHandling(nextMoveHandling);
        }
        // nextMoveType cannot be PASS because the move was constructed with a Coord.
        assert nextMoveType != MoveType.MOVE_PASS;

        // Update isAllChildNodesExpanded if applicable.
        if (i == childCount - 1) {
          searchNode.isAllChildNodesExpanded();
        }

        // Return a legal move or keep searching.
        if (nextMoveType == MoveType.MOVE_REGULAR
            || nextMoveType == MoveType.MOVE_EAT_NO_JIE
            || nextMoveType == MoveType.MOVE_EAT_CAUSING_JIE) {
          return newChildSearchNode;
        } else {
          // else, continue to search for a good child node.
        }
      }

      if (FLAG_PROFILE) Utils.profile(time01,
          "MctsMoveEngine.buildTakingLongTime.mctsSimulate.mctsSimulateAdvanceOneNode => for-loop-child");

      // Cannot find any valid move.
      // => create a PASS move.
      SearchNode passNode = SearchNode.constructPassNodeWithMoveHandling(searchNode);
      searchNode.addChildNode(passNode);
      return passNode;
    }

    /**
     * Evaluates if black wins at a {@link SearchNode} which represents end-game status.
     *
     * <p>Note, when a super-ko happens during simulation, it must be of a quasi-end-game status
     * because there is always only one available move for either black or white.
     * Also, there is no dead stones left on the board for a super-ko case.
     */
    private static boolean evalIfBlackWinsAtEndGameNode(
        @Nonnull SearchNode searchNode, int komiRoundedDown, boolean isEstimate) {
      assert searchNode.hasMoveHandling();
      MoveHandling moveHandling = searchNode.getMoveHandling();
      PositionStateBoard positionStateBoard = moveHandling.getPositionStateBoardAfterMove();
      int vacantTerritoryOfBlack = 0;
      int vacantTerritoryOfWhite = 0;
      long time00;
      if (FLAG_PROFILE) time00 = System.nanoTime();
      // isEstimate=true is slightly better than isEstimate=false.
      if (isEstimate) {
        int boardSize = positionStateBoard.getBoardSize();
        for (int x = 1; x <= boardSize; x++) {
          for (int y = 1; y <= boardSize; y++) {
            PositionState positionState = positionStateBoard.getPositionState(x, y);
            if (positionState == PositionState.BLACK) {
              vacantTerritoryOfBlack++;
            } else if (positionState == PositionState.WHITE){
              vacantTerritoryOfWhite++;
            }
            // Ignore VACANT positions, because it is estimate.
          }
        }
        if (FLAG_PROFILE) Utils.profile(
            time00,
            5,  // 5 ms
            "MctsMoveEngine.buildTakingLongTime.mctsSimulate.evalIfBlackWinsAtEndGameNode => isEstimate=true");
      } else {
        BlockBoard blockBoard = BlockBoard.newBuilder()
            .setRequiredPositionStateBoard(positionStateBoard)
            .build();
        assert blockBoard != null;
        NeighborhoodBoard neighborhoodBoard = NeighborhoodBoard.newBuilder()
            .setRequiredBlockBoard(blockBoard)
            .build();
        LandBoard landBoard = LandBoard.newBuilder()
            .setNeighborhoodBoard(neighborhoodBoard)
            .build();
        LotBoard lotBoard = LotBoard.newBuilder()
            .setRequiredLandBoard(landBoard)
            .build();
        EndGameTerritoryWithoutDeadAnalyzer endGameAnalyzer =
            EndGameTerritoryWithoutDeadAnalyzer.newBuilder()
                .setRequiredLotBoard(lotBoard)
                .build();
        EndGameAnalysisResultSuccessType resultType = endGameAnalyzer.getAnalysisResultType();
        // By nature of MCTS simulation, there should be no dead stones at end of simulation.
        // A special case is super-ko where the simulation is cancelled. In this case, there is
        // no dead stones on the board.
        // So, resultType will always be OK.
        assert resultType == EndGameAnalysisResultSuccessType.OK;

        // Calculate territories.
        vacantTerritoryOfBlack = endGameAnalyzer.getVacantTerritoryOfBlack();
        assert(vacantTerritoryOfBlack >= 0);
        vacantTerritoryOfWhite = endGameAnalyzer.getVacantTerritoryOfWhite();
        assert(vacantTerritoryOfWhite >= 0);
        if (FLAG_PROFILE) Utils.profile(
            time00,
            5,  // 5 ms
            "MctsMoveEngine.buildTakingLongTime.mctsSimulate.evalIfBlackWinsAtEndGameNode => isEstimate=false");
      }

      // Determine who wins.
      int blackWinCount = vacantTerritoryOfBlack - vacantTerritoryOfWhite - komiRoundedDown;
      // If komi = 6.5, then komiRoundedDown = 6.
      // Sample, blackCount = 106, whiteCount = 100, komi = 6.5, komiRoundedDown = 6.
      //   blackCount - whiteCount - komiRoundedDown = 0.
      //   White wins.
      return blackWinCount > 0;
    }

    private static void mctsBackPropogate(@Nonnull SearchNode selectedSearchNode, boolean isWin) {
      SearchNode currNode = selectedSearchNode;
      boolean currIsWin = isWin;
      while (!currNode.isRoot()) {
        currNode.recordWinsCount(currIsWin);
        currNode = currNode.getParentOptional().get();
        // Swap isWin for black and white.
        currIsWin = !currIsWin;
      }
    }

    private static SearchNode findNextNodeWithMostSimulationsOrReturnPassNode(
        @Nonnull SearchNode nodeBeforeTheMove, @Nonnull Random random) {
      // The following log could take a long time because it is recursive.
      //logger.info("node tree:\n" + nodeBeforeTheMove.toFullStringRecursive());

      int childNodesCount = nodeBeforeTheMove.getChildNodesCount();
      assert childNodesCount > 0;

      int maxSimsCount = 0;
      List<SearchNode> childNodesWithoutMoveHandling = new ArrayList<>();
      List<SearchNode> childNodesWithSameMaxSimsCount = new ArrayList<>();
      for (int i = 0; i < childNodesCount; i++) {
        SearchNode childNode = nodeBeforeTheMove.getChildNode(i);

        // Record the child node that is not processed yet.
        if (!childNode.hasMoveHandling()) {
          childNodesWithoutMoveHandling.add(childNode);
          continue;
        }

        // Skip illegal move.
        MoveHandling moveHandling = childNode.getMoveHandling();
        MoveType moveType = moveHandling.getMoveType();
        if (moveType.isIllegalMove()) {
          continue;
        }

        // Skip self-fill-eye move.
        // TODO 100 add tests for self-fill-eye in MctsMoveEngine.
        if (moveType == MoveType.MOVE_SELF_FILL_ONE_EYE_FOR_ONE_BUDDY_BLOCK) {
          continue;
        }

        // Find winner candidate.
        int simsCount = childNode.getSimulationsCount();
        if (simsCount > maxSimsCount) {  // a new winner occurs
          maxSimsCount = simsCount;
          childNodesWithSameMaxSimsCount.clear();
          childNodesWithSameMaxSimsCount.add(childNode);  // the only winner so far
        } else if (simsCount == maxSimsCount) {  // a tie happens
          // The following line of code might not be covered with unit tests because of randomness.
          childNodesWithSameMaxSimsCount.add(childNode);
        }
      }

      // Find winner.
      if (childNodesWithSameMaxSimsCount.isEmpty()) {
        if (childNodesWithoutMoveHandling.isEmpty()) {
          SearchNode passNode = SearchNode.constructPassNodeWithMoveHandling(nodeBeforeTheMove);
          nodeBeforeTheMove.addChildNode(passNode);
          return passNode;
        } else {
          logger.warning("Do not have time to process all child nodes in order to find the best"
              + " and legal node with most simulations.");
          SearchNode passNode = SearchNode.constructPassNodeWithMoveHandling(nodeBeforeTheMove);
          // Do not add this passNode to the parent node - nodeBeforeTheMove to avoid misleading.
          return passNode;
        }
      } else {
        // TODO 200 Handle tie-breaker in findNextNodeWithMostSimulations().
        //      Return a random node for now.
        int randomIndex = random.nextInt(childNodesWithSameMaxSimsCount.size());
        SearchNode randomSearchNode = childNodesWithSameMaxSimsCount.get(randomIndex);
        return randomSearchNode;
      }
    }
  }
}
