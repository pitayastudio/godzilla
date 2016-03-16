package com.pitayastudio.godzilla.timecontrol;

public interface DesignDoc {
  /**
   * Params Defn:
   * <p>
   * <ul>
   *   <li>TimeLimit (= 25/40/60/180 min for each color)
   *   <li>TimeOver (= 10 sec or 1 min for each move)
   *   <li>ForceDecisionTime (= 5 sec): the max possible time that Godzilla needs in order to make a
   *       right-away decision when it is forced to move. The value needs to be obtained by testing.
   *   <li>Assume ExpectedMaxMoveNum = 200 for each color.
   *   <li>Assume Godzilla Server is a single Thread application in order to have the best
   *       performance and to avoid complexity.
   *   <li>Define some CheckTimes in Godzilla program. Godzilla needs to check time status whenever
   *       it reaches an instance of CheckTimes. For examples:
   *     <ul>
   *       <li>when analysis/update is done
   *       <li>when the first round of wide search for move candidates is done Godzilla can make a
   *           RightAwayMove after this stage is finished.
   *       <li>end of each search of deep search for move candidates
   *     </ul>
   * </ul>
   */
  void paramsDefn();

  /**
   * Over time style:
   * <p>
   * <ul>
   *   <li>RecommendedThinkingTime = max of
   *       <li>RemainingTime/(ExpectedMaxMoveNum-NumOfMovesMade)
   *       <li>TimeOver - ForceDecisionTime
   *   <li>2ndRecommendedThinkingTime = BuddyRemainingRegularTime - FoeRemainingRegularTime could be
   *       less than RecommendedThinkingTime
   *       <li>If Godzilla has not made the decision within RecommendedThinkingTime:
   *       <li>if in TimeOver: it is forced to make a RightAwayMove.
   *         <ul>
   *           <li>if not in TimeOver:
   *           <li>if within 2ndRecommendedThinkingTime: reduce search depth by 1
   *           <li>if passed 2ndRecommendedThinkingTime: reduce search depth by 2
   *         </ul>
   * </ul>
   */
  void overTimeStyle();

  /**
   * No over time style:
   * <p>
   * <ul>
   *   <li>MaxThinkingTime = RemainingTime - (ExpectedMaxMoveNum-NumOfMovesMade) * ForceDecisionTime
   *   <li>HurryMode: when remaining regular time < 1/3 TimeLimit
   *   <li>RecommendedThinkingTime = RemainingTime/(ExpectedMaxMoveNum-NumOfMovesMade)
   *   <li>2ndRecommendedThinkingTime = BuddyRemainingRegularTime - FoeRemainingRegularTime could be
   *       less than RecommendedThinkingTime
   *   <li>At each CheckTime, always first to check to see if Godzilla has passed MaxThinkingTime.
   *       If Yes, then it is forced to make a move.
   *   <li>If Godzilla has not made the decision within RecommendedThinkingTime:
   *     <ul>
   *       <li>if within 2ndRecommendedThinkingTime: do nothing if not in HurryMode, otherwise
   *           reduce search depth by 1.
   *       <li>if passed 2ndRecommendedThinkingTime: reduce search depth by 1 if not in HurryMode,
   *           otherwise reduce search depth by 2.
   *     </ul>
   * </ul>
   */
  void noOverTimeStyle();

  /**
   * Computation usage with time control:
   *
   * <p>while foe is thinking to make the next move:
   * <ul>
   *   <li>update info on buddy side if necessary.
   *   <li>guess what move(s) foe will make, and do the corresponding analysts (with desired search
   *       depth) in advance.
   * </ul>
   */
  void computationUsageWithTimeControl();

  /**
   * exceeding time limit means lost.
   * time left cannot be less than zero.
   * once the timer is set with max min, the value cannot be changed.
   */
  void misc();
}
