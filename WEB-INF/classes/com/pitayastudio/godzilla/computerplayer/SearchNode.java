package com.pitayastudio.godzilla.computerplayer;

import com.google.common.base.Optional;

import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.modelboard.PositionStateBoard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;

/**
 * Mutable SearchNode.
 *
 * <p>Root node is a PASS move, and its level is 0.
 *
 * <p>The initial board for the root node could be either empty or a board with some specified
 * moves.
 */
public class SearchNode {  // TODO 100 Rename SearchNode to Node.

  public static final String SEARCH_PATH_FOR_ROOT = "ROOT";
  public static final String SEARCH_PATH_SEGMENT_FOR_PASS = "00";

  public static Builder newBuilder() {
    return new Builder();
  }

  public static SearchNode constructRootNodeWithMoveHandling(
      @Nonnull PositionStateBoard rootPositionStateBoard) {
    SearchNode rootSearchNode = SearchNode.newBuilder()
        .setRequiredParentNodeOptional(Optional.<SearchNode>absent())
        .setRequiredCoordOptional(Optional.<Coord>absent())
        .build();
    MoveHandling moveHandling = MoveHandling.constructRootMoveHandling(rootPositionStateBoard);
    rootSearchNode.setMoveHandling(moveHandling);
    return rootSearchNode;
  }

  public static SearchNode constructPassNodeWithMoveHandling(
      @Nonnull SearchNode searchNodeBeforePass) {
    assert searchNodeBeforePass.hasMoveHandling();
    SearchNode passSearchNode = SearchNode.newBuilder()
        .setRequiredParentNodeOptional(Optional.of(searchNodeBeforePass))
        .setRequiredCoordOptional(Optional.<Coord>absent())
        .build();
    MoveHandling prevMoveHandling = searchNodeBeforePass.getMoveHandling();
    MoveHandling moveHandling = MoveHandling.constructPassMoveHandling(prevMoveHandling);
    passSearchNode.setMoveHandling(moveHandling);
    return passSearchNode;
  }

  private final int level;
  @Nonnull private final Optional<SearchNode> parentNodeOptional;
  @Nonnull private final Optional<Coord> coordOptional;
  /**
   * Search path - derived from parentNodeOptional recursively.
   */
  @Nonnull private final String searchPath;
  @Nonnull private final List<SearchNode> childNodes;
  @Nonnull private final Map<Coord, SearchNode> mapFromCoordToChildNode;
  private boolean isAllChildNodesExpanded;
  private MoveHandling moveHandling = null;
  private int winsCount;
  private int simulationsCount;

  private SearchNode(@Nonnull Builder builder, String searchPath) {
    this.level = builder.level;
    this.parentNodeOptional = builder.parentNodeOptional;
    this.coordOptional = builder.coordOptional;
    this.searchPath = searchPath;
    this.childNodes = new ArrayList<>();
    this.mapFromCoordToChildNode = new HashMap<>();
    isAllChildNodesExpanded = false;
    winsCount = 0;
    simulationsCount = 0;
  }

  public int getLevel() {
    return level;
  }

  public Optional<SearchNode> getParentOptional() {
    return parentNodeOptional;
  }

  public Optional<Coord> getCoordOptional() {
    return coordOptional;
  }

  public boolean isRoot() {
    if (level == 0) {
      assert(!parentNodeOptional.isPresent());
      return true;
    }
    return false;
  }

  public boolean isPassOrRoot() {
    return !coordOptional.isPresent();
  }

  public String getSearchPath() {
    return searchPath;
  }

  public int getChildNodesCount() {
    return childNodes.size();
  }

  public SearchNode getChildNode(int index) {
    assert index >= 0 && index < getChildNodesCount();
    return childNodes.get(index);
  }

  public boolean containsChildNode(@Nonnull Coord coord) {
    return this.mapFromCoordToChildNode.containsKey(coord);
  }

  public SearchNode getChildNode(Coord coord) {
    return this.mapFromCoordToChildNode.get(coord);
  }

  public void addChildNode(@Nonnull SearchNode newChildNode) {
    this.childNodes.add(newChildNode);
    Optional<Coord> childCoordOptional = newChildNode.getCoordOptional();
    if (childCoordOptional.isPresent()) {
      this.mapFromCoordToChildNode.put(childCoordOptional.get(), newChildNode);
    }
  }

  public boolean isAllChildNodesExpanded() {
    return isAllChildNodesExpanded;
  }

  public void setAllChildNodesExpanded() {
    isAllChildNodesExpanded = true;
  }

  public boolean hasMoveHandling() {
    return moveHandling != null;
  }

  public MoveHandling getMoveHandling() {
    return moveHandling;
  }

  public void setMoveHandling(@Nonnull MoveHandling moveHandling) {
    this.moveHandling = moveHandling;
  }

  public int getWinsCount() {
    return winsCount;
  }

  public int getSimulationsCount() {
    return simulationsCount;
  }

  public void recordWinsCount(boolean isWin) {
    this.simulationsCount++;
    if (isWin) {
      this.winsCount++;
    }
  }

  public String toFullString() {
    StringBuilder sb = new StringBuilder(searchPath);
    sb.append('\n');
    sb.append("sims count: ").append(this.simulationsCount).append('\n');
    sb.append("wins count: ").append(this.winsCount).append('\n');
    if (!this.childNodes.isEmpty()) {
      sb.append("children: [");
      for (SearchNode childNode : childNodes) {
        sb.append(childNode.searchPath).append(", ");
      }
      sb.append(']').append('\n');
    }
    return sb.toString();
  }

  public String toFullStringRecursive() {
    StringBuilder sb = new StringBuilder();
    sb.append("sims count: ").append(this.simulationsCount).append(',').append(' ');
    sb.append("wins count: ").append(this.winsCount).append(',').append(' ');
    sb.append(searchPath).append('\n');
    if (!this.childNodes.isEmpty()) {
      sb.append("children: [");
      for (SearchNode childNode : childNodes) {
        sb.append(childNode.toFullStringRecursive());
      }
      sb.append(']').append('\n');
    }
    return sb.toString();
  }

  @Override public String toString() {
    return this.searchPath;
  }

  public static class Builder {
    private int level;
    private Optional<Coord> coordOptional;
    private Optional<SearchNode> parentNodeOptional;

    private Builder() {
    }

    public Builder setRequiredCoordOptional(@Nonnull Optional<Coord> coordOptional) {
      this.coordOptional = coordOptional;
      return this;
    }

    public Builder setRequiredParentNodeOptional(@Nonnull Optional<SearchNode> parentNodeOptional) {
      this.parentNodeOptional = parentNodeOptional;
      return this;
    }

    public SearchNode build() {
      assert (null != parentNodeOptional);
      assert (null != coordOptional);

      // Determine level.
      if (!this.parentNodeOptional.isPresent()) {
        level = 0;
      } else {
        level = this.parentNodeOptional.get().getLevel() + 1;
      }

      String searchPath = constructSearchPath();
      return new SearchNode(this, searchPath);
    }

    /**
     * @see Coord#toSearchPathSegment(boolean)
     */
    private String constructSearchPath() {
      if (level == 0) {  // This must be a root node.
        assert (!coordOptional.isPresent());
        return SEARCH_PATH_FOR_ROOT;
      }

      assert(level > 0);
      assert(parentNodeOptional.isPresent());
      String[] searchPathSegments = new String[level];
      // Determine the searchPathSegment for the current new node.
      boolean isBlack = ((level & 1) == 1);
      if (this.coordOptional.isPresent()) {
        searchPathSegments[level - 1] = this.coordOptional.get().toSearchPathSegment(isBlack);
      } else {
        searchPathSegments[level - 1] = SEARCH_PATH_SEGMENT_FOR_PASS;
      }
      // Iterate through all parent nodes (if any) to get the searchPathSegments.
      SearchNode currentNode = this.parentNodeOptional.get();
      for (int currentLevel = level - 1; currentLevel > 0; currentLevel--) {
        // Swap color.
        isBlack = isBlack ? false : true;
        if (currentNode.getCoordOptional().isPresent()) {
          Coord currentCoord = currentNode.getCoordOptional().get();
          searchPathSegments[currentLevel - 1] = currentCoord.toSearchPathSegment(isBlack);
        } else {
          searchPathSegments[currentLevel - 1] = SEARCH_PATH_SEGMENT_FOR_PASS;
        }
        Optional<SearchNode> parentNodeOptional = currentNode.getParentOptional();
        assert(parentNodeOptional.isPresent());
        currentNode = parentNodeOptional.get();
      }

      // Combine all searchPathSegments.
      StringBuilder searchPath = new StringBuilder();
      for (String segment : searchPathSegments) {
        searchPath.append(segment);
      }
      return searchPath.toString();
    }
  }
}
