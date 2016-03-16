package com.pitayastudio.godzilla.computerplayer;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;

import com.pitayastudio.godzilla.common.MoveType;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.modelboard.PositionStateBoard;

import java.util.Random;

import javax.annotation.Nonnull;

public class RandomMoveEngine implements MoveEngine {

  public static Builder newBuilder() {
    return new Builder();
  }

  @Nonnull private final SearchNode bestNextNode;

  private RandomMoveEngine(@Nonnull SearchNode bestNextNode) {
    this.bestNextNode = bestNextNode;
  }

  @Override public SearchNode getBestNextNode() {
    return bestNextNode;
  }

  public static class Builder {
    private SearchNode nodeBeforeTheMove;
    private MoveHandling moveHandling;

    private Builder() {
    }

    public Builder setRequiredNodeBeforeTheMove(@Nonnull SearchNode nodeBeforeTheMove) {
      this.nodeBeforeTheMove = nodeBeforeTheMove;
      return this;
    }

    public RandomMoveEngine build() {
      assert (null != nodeBeforeTheMove);

      moveHandling = nodeBeforeTheMove.getMoveHandling();
      MoveHandling bestNextMoveHandling = pickRandomNextMoveHandling();
      SearchNode.Builder bestNextNodeBuilder = SearchNode.newBuilder()
          .setRequiredParentNodeOptional(Optional.of(nodeBeforeTheMove));
      if (bestNextMoveHandling.getMoveType() != MoveType.MOVE_PASS) {
        bestNextNodeBuilder.setRequiredCoordOptional(bestNextMoveHandling.getMoveCoordOptional());
      } else {
        bestNextNodeBuilder.setRequiredCoordOptional(Optional.<Coord>absent());
      }
      SearchNode bestNextNode = bestNextNodeBuilder.build();
      bestNextNode.setMoveHandling(bestNextMoveHandling);
      return new RandomMoveEngine(bestNextNode);
    }

    private MoveHandling pickRandomNextMoveHandling() {
      ImmutableList<Coord> candidateCoords = moveHandling.getOrFindAvailMoveCoordsExceptJie();

      // Check every candidate coord.
      // TODO 200 Implement pickRandomNextMoveHandling() with better approach without checking
      //     every candidate coord.
      ImmutableList.Builder<Coord> acceptableCoordsBuilder = ImmutableList.builder();
      Optional<SearchNode> nodeBeforeTheMoveOptional = Optional.of(nodeBeforeTheMove);
      PositionStateBoard currentPositionStateBoard = moveHandling.getPositionStateBoardAfterMove();
      for (Coord coord : candidateCoords) {
        MoveHandling nextMoveHandlingCandidates = MoveHandling.newBuilderForRegularMoveHandling()
            .setRequiredPositionStateBoardBeforeMove(currentPositionStateBoard)
            .setRequiredMoveColor(moveHandling.getMoveColor().swap())
            .setRequiredPrevJieDeadCoordOptional(moveHandling.getJieDeadCoordOptional())
            .setRequiredMoveCoord(coord)
            .build();
        SearchNode node = SearchNode.newBuilder()
            .setRequiredCoordOptional(Optional.of(coord))
            .setRequiredParentNodeOptional(nodeBeforeTheMoveOptional)
            .build();
        node.setMoveHandling(nextMoveHandlingCandidates);
        nodeBeforeTheMoveOptional.get().addChildNode(node);
        MoveType nextMoveType = nextMoveHandlingCandidates.getMoveType();
        if (nextMoveType.isIllegalMove()) {
          continue;
        }
        acceptableCoordsBuilder.add(coord);
      }
      ImmutableList<Coord> acceptableCoords = acceptableCoordsBuilder.build();

      // Approach with randomness.
      int acceptablesCount = acceptableCoords.size();
      if (acceptablesCount == 0) {
        MoveHandling passMoveHandling = MoveHandling.constructPassMoveHandling(moveHandling);
        return passMoveHandling;
      }
      Random random = new Random();
      int randomIndex = random.nextInt(acceptablesCount);
      Coord randomCoord = acceptableCoords.get(randomIndex);
      SearchNode randomNode = nodeBeforeTheMoveOptional.get().getChildNode(randomCoord);
      MoveHandling moveHandling = randomNode.getMoveHandling();
      return moveHandling;
    }
  }
}
