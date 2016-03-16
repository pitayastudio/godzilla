package com.pitayastudio.godzilla.model;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.level.ControlLevel;
import com.pitayastudio.godzilla.model.PrisonerBlock.ExternallyControlledPrisonerBlock;
import com.pitayastudio.godzilla.model.PrisonerBlock.InternallyEnclosedPrisonerBlock;
import com.pitayastudio.godzilla.modelboard.GangBoard;
import com.pitayastudio.godzilla.modelboard.LandBoard;

public interface DesignDoc {
  /**
   * {@link Coord}.
   *
   * <p>black/white/vacant
   *
   * <p>it is used to called "posit".
   *
   * <p>Cf. mu: black/white
   *
   * <p>Cf. qi: black/white/both/none
   *
   * <p>Cf. point: counted for the results of territory
   *
   * <p>Cf. move: a move contains a {@link Coord}
   */
  void coord();

  /**
   * {@link Block}
   *
   * <p>{@link VacantBlock}
   * <ul>
   *   <li>status: isBuddyOfBlack/White/None
   *   <li>Record {@link VacantBlock}:
   *     <ul>
   *       <li>非吃子時:
   *           落子處所在的 {@link Coord} 的所屬 {@link VacantBlock},
   *           要判斷該 {@link VacantBlock} 有沒有被切割, 並記得要從該 {@link VacantBlock} 中移除該落子.
   *       <li>吃子時:
   *           每個死去的 {@link ColorBlock} 都變成 NONE color;
   *           接著同非吃子時.
   *       <li>Pass 時: 不變
   *     </ul>
   * </ul>
   *
   * <p>{@link ColorBlock}
   * <ul>
   *   <li>A {@link ColorBlock} could be a prisoner in 2 types:
   *       (1) internally-enclosed prisoner block
   *       (2) externally-controlled prisoner block
   * </ul>
   *
   * <p>{@link PrisonerBlock} extends {@link ColorBlock}.
   * It has 2 types {@link InternallyEnclosedPrisonerBlock} and
   * {@link ExternallyControlledPrisonerBlock}.
   */
  void block();

  /**
   * {@link Land} / {@link LandBoard}:
   *
   * <p>Type I - {@link ClosedLand}.
   *
   * <p>Components:
   * <ul>
   *   <li>{@link Color}</li>
   *   <li>{@link VacantBlock}</li>
   *   <li>non-empty set of {@link ColorBlock}s of same color</li>
   * </ul>
   *
   * <p>Type II - {@link OpenLand}.
   *
   * <p>Components:
   * <ul>
   *   <li>{@link VacantBlock}</li>
   *   <li>non-empty set of black {@link ColorBlock}s</li>
   *   <li>non-empty set of white {@link ColorBlock}s</li>
   * </ul>
   *
   * <p>Note: At end game, a {@link ColorBlock} can belong to 0..2 {@link OpenLand}'s.
   * Sample of one {@link ColorBlock} belonging to 2 {@link OpenLand}'s:
   * <pre>
   * "◦●◦○◦●◦●○"
   * "●●○○○●●●○"
   * "○○●●●○○○○"
   * "◦○●◦●○◦◦◦"
   * "◦○●◦●○◦◦◦"
   * "◦○●◦●○○○○"
   * "◦○●◦●●●●●"
   * "◦○●◦◦◦◦◦◦"
   * "◦○●◦◦◦◦◦◦"
   * </pre>
   */
  void land();

  /**
   * {@link ClosedProperty}.
   *
   * <p>Components:
   * <ul>
   *   <li>a {@link Color}
   *   <li>an enclosed non-empty set of {@link VacantBlock}'s
   *   <li>an enclosed emptiable set of {@link ColorBlock}'s as prisoners.
   * </ul>
   */
  void closedProperty();

  /**
   * {@link OpenProperty}.
   *
   * <p>It is not guaranteed to contains a true eye because it is external.
   *
   * <p>Components:
   * <ul>
   *   <li>a {@link Color}
   *   <li>a non-empty set of {@link Realm}'s
   *   <li>a emptiable set of {@link ColorBlock}'s as semi-prisoners.
   * </ul>
   */
  void openProperty();

  /**
   * {@link Realm}.
   *
   * <p>Components:
   * <ul>
   *   <li>controlling color</li>
   *   <li>set of vacant {@link Coord}s with high {@link ControlLevel}.</li>
   *   <li>parent {@link VacantBlock}.</li>
   * </ul>
   *
   * <p>A {@link VacantBlock} can be divided into several {@link Realm}'s.
   * A {@link Realm} can optionally belong to one {@link Dragon}.
   *
   * <p>{@link SemiRealm}:
   * <ul>
   *   <li>attribute: controllingColor
   *   <li>consists of vacant {@link Coord}s (in the same {@link VacantBlock}) with medium-to-high ControlLevel
   *   <li>say, MID_CTRL_LVL = 73 = 100 x sqrt(2) / 2
   *   <li>1/2 chances of occupancy, so we need ">=" instead of ">"
   *   <li>There could be overlaps between neighbored black and white {@link SemiRealm}'s.
   *   <li>The following vacant {@link Coord} at A1 is still treated as a {@link SemiRealm},
   *       even though black can not make a move here
   *       (otherwise, white could kill B1-B2 by making a move at C2).
   * </ul>
   * <pre>
   * 5 ......
   * 4 .OOO..
   * 3 OOXXX.
   * 2 OX....
   * 1 .X....
   *   ABCDEF
   * </pre>
   *
   * <p>CombatVacancy:
   * consists of vacant {@link Coord}s (in the same {@link VacantBlock})
   * with CtrlLvl of both black and white >= MID_CTRL_LVL
   */
  void realm();

  /**
   * {@link Lot}.
   *
   * <p>Components:
   * <ul>
   *   <li>{@link Color}</li>
   *   <li>non-empty set of {@link ColorBlock}s</li>
   *   <li>set of enclosed {@link VacantBlock}s</li>
   * </ul>
   *
   * <p>Samples:
   * <pre>
   * Type I - single {@link ColorBlock}:
   * One {@link ColorBlock} with 0..N enclosed buddy {@link VacantBlock}'s.
   * Note: the {@link VacantBlock} is not necessary a TrueEyeBlock.
   * Note: "buddy" means all surrounding {@link ColorBlock}'s are of the buddy color.
   *
   * ......
   * XXXXX.
   * ......
   *
   * ......
   * XXXXX.
   * X...X.
   * X...X.
   * X...X.
   * XXXXX.
   * ......
   *
   * ......
   * XXXXX.
   * X.X.X.
   * X.X.X.
   * X.X.X.
   * XXXXX.
   * ......
   *
   * Type II - multiple {@link ColorBlock}s:
   * {@link ColorBlock}'s connected via buddy {@link VacantBlock}'s.
   * Note: the {@link VacantBlock} is not necessary a TrueEyeBlock.
   * Note: "buddy" means all surrounding {@link ColorBlock}'s are of the buddy color.
   * ......
   * XXXXX.
   * X...X.
   * X.X.X.
   * X...X.
   * XXXXX.
   * ......
   * ......
   * XXX...
   * X.X...
   * .X.X..
   * .XXX..
   * ......
   * ......
   * .X....
   * X.X...
   * .X....
   * ......
   * ......
   * OOO...
   * OXX...
   * X.X...
   * -------
   * </pre>
   */
  void lot();

  /**
   * {@link LotWithProperty}.
   *
   * <p>Components:
   * <ul>
   *   <li>{@link Color}</li>
   *   <li>{@link Lot}</li>
   *   <li>set of {@link ClosedProperty}s</li>
   * </ul>
   * <pre>
   * samples:
   * .......
   * XXXXXXX
   * X.X...X
   * XXX.O.X
   * ...XXXX
   * .......
   * .......
   * XXXXXXX
   * X.....X
   * X.X.O.X
   * X.....X
   * XXXXXXX
   * .......
   * </pre>
   */
  void lotWithProperty();

  /**
   * {@link Gang}.
   *
   * <p>Components:
   * <ul>
   *   <li>{@link Color}</li>
   *   <li>set of {@link LotWithProperty}</li>
   *   <li>set of {@link OpenProperty}</li>
   * </ul>
   *
   * <pre>
   * samples:
   * .....
   * .OOO.
   * .OXX.
   * .XOX.
   * .....
   * -----
   *
   * .........
   * .XXXXXXX.
   * .X.....X.
   * .X.X.O.X.
   * .X.....X.
   * ...XXXXX.
   * .........
   *
   * .OOOOO.
   * XX...XX
   * ..X....
   * -------
   * </pre>
   *
   * @see GangBoard
   */
  void gang();

  /**
   * {@link Dragon} and Area.
   *
   * <p>{@link Dragon}
   *
   * <p>Components:
   * <ul>
   *   <li>color: black/white
   *   <li>half-linked {@link Gang}(s)
   *   <li>{@link  SemiRealm}(s)
   * <ul>
   *
   * <pre>
   * samples:
   * 1 Black {@link Dragon}
   * 1 White {@link Dragon}
   * ..........
   * ..X.......
   * ..........
   * ...X......
   * ..X..O..O.
   * ...O......
   * ..........
   * ----------
   * </pre>
   *
   * <p>Area
   * <ul>
   *   <li>NeuralArea:
   *     <ul>
   *       <li>defn: vacant area with both black and white CtrlLvl < MID_CTRL_LVL
   *       <li>There are some pre-defined neural vacant areas at the beginning of game.
   *       <li>We need to track what neural areas remain valid after each move.
   *       <li>NeuralArea could be within Black or White {@link Dragon}.
   *     </ul>
   *   <li>CombatArea:
   *       Area with CombatVacancy(s) except those used for connecting {@link Dragon}s.
   * </ul>
   *
   * <p>Area vs {@link Dragon}
   * <ul>
   *   <li>Areas and {@link Dragon}s could be overlapped.
   *   <li>Affected Areas/{@link Dragon}s.
   *     <ul>
   *       <li>When a move is made, the area(s)/dragon(s) where the move is located are directly affected.
   *       <li>The areas/dragons surrounding the directly affected area(s)/dragon(s) are secondly affected.
   *       <li>And so on...
   *     </ul>
   * </ul>
   */
  void dragonAndArea();

  /**
   * Rim of {@link LotWithProperty} and {@link Gang}.
   *
   * <p>1st rim: the vacant {@link Coord}s around the {@link Gang} or {@link LotWithProperty}.
   * including direct-contact {@link Coord}s and corner {@link Coord}s
   * the corner {@link Coord}s are only included when the two direct-contact {@link Coord}s belong to the 1st rim.
   *
   * <p>2nd rim: the vacant {@link Coord}s around the 1st rim
   * for n-th rim with n>=2, only direct-contact {@link Coord}s are considered
   *
   * <p>3rd rim: the vacant {@link Coord}s around the 2nd rim
   *
   * <p>n-th rim: the vacant {@link Coord}s around the (n-1)-th rim
   *
   * <p>n<=4 (Too many efforts to go beyond 4)
   *
   * <p>Note: the influence values of {@link Coord}s in the same neighbor rim could be different.
   *
   * <p>Note: the vacant {@link Coord}s (for connection) of {@link Gang} do not belong to Rim.
   *
   * <p>sample of rims:
   * <pre>
   * .222222222.
   * 21111111112
   * 21XXXXXXX12
   * 21X.X...X12
   * 21XXX.O.X12
   * 21111XXXX12
   * .2221111112
   * ....222222.
   * </pre>
   */
  void rimOfLotWithPropertyAndGang();

  /**
   * @deprecated Types of {@link LotPlus}:
   *
   * <ul>
   *   <li>SingleBigEyeLotPlus
   *     <ul>
   *       <li>1..N Buddy ColorBlocks
   *       <li>1 Enclosed VacantBlock
   *       <li>0..N external BlackWhiteNeighborhoods
   *       <li>No ColorVacantNeighborhood
   *     </ul>
   *   </li>
   *   <li>MultiEyeLotPlus
   *     <ul>
   *       <li>1..N Buddy ColorBlocks
   *       <li>2..N Enclosed VacantBlock (TrueEyeBlock or FalseEyeBlock)
   *       <li>0..N external BlackWhiteNeighborhoods
   *       <li>No ColorVacantNeighborhood
   *     </ul>
   *   </li>
   *   <li>ZeroEnclosedVacantBlockSekiLotPlus
   *     <ul>
   *       <li>1 Buddy ColorBlocks
   *       <li>0 Enclosed VacantBlock
   *       <li>0..N external BlackWhiteNeighborhoods
   *       <li>external 1 ColorVacantNeighborhood with 2 Qi's
   *     </ul>
   *   </li>
   *   <li>SingleEnclosedVacantBlockSekiLotPlus
   *     <ul>
   *       <li>1..N Buddy ColorBlocks
   *       <li>1..N Enclosed VacantBlock
   *       <li>0..N external BlackWhiteNeighborhoods
   *       <li>external 1 ColorVacantNeighborhood with 1 Qi
   *     </ul>
   *   </li>
   * </ul>
   *
   * <p>Note #1 {@link Lot}s at EndGame must be live.
   *
   * <p>Note #2 Non-LotPlus:
   * <ul>
   *   <li>SemiLiveLot
   *   <li>NonLiveLot
   * </ul>
   */
  @Deprecated void typesOfLotPlus();
}
