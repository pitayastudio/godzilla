package com.pitayastudio.godzilla.moveanalyzer;

import com.pitayastudio.godzilla.common.MoveType;
import com.pitayastudio.godzilla.common.PositionState;
import com.pitayastudio.godzilla.computerplayer.MoveHandling;
import com.pitayastudio.godzilla.level.Influence;
import com.pitayastudio.godzilla.model.ColorBlock;
import com.pitayastudio.godzilla.model.Dragon;
import com.pitayastudio.godzilla.model.LotWithProperty;
import com.pitayastudio.godzilla.model.Realm;
import com.pitayastudio.godzilla.model.SemiRealm;
import com.pitayastudio.godzilla.model.VacantBlock;
import com.pitayastudio.godzilla.modelboard.AnalyzerBoard;
import com.pitayastudio.godzilla.moveanalyzer.connectionanalyzer.ConnectionAnalyzer;
import com.pitayastudio.godzilla.moveanalyzer.killanalyzer.BlockKillByGongshaAnalyzer;
import com.pitayastudio.godzilla.moveanalyzer.killanalyzer.BlockKillByLadderAnalyzer;
import com.pitayastudio.godzilla.moveanalyzer.killanalyzer.KillAnalyzer;

public interface DesignDoc {
  /**
   * Basic logic:
   *
   * <p>If found any data for BuJue, use it. return.
   *
   * <p>There should be Recommended buddy moves in each Area from last round of calculation.
   *
   * <p>Find out which Areas need to calculate new Recommended moves.
   *
   * <p>If the Area is not Affected by the last enemy move,
   * then memorize the Recommended as ChoiceOfLastRecommendedMove##.
   *
   * <p>{Label 001} For any Affected Area:
   * <ul>
   *   <li>inThinkDepth++ (used in recursive calculation)
   *   <li>If found any data for DingShi, memorize its SCORE as ChoiceOfDingShi. (skip to Label 002)
   *   <li>If found any matched pattern (ZhongPan, GuanZi), memorize its SCORE as ChoiceOfPattern.
   *       (skip to Label 002)
   *   <li>(If the area is an affected area, the last move does not reside within this area,
   *       then what should be the starting posit for pattern matching?
   *       Ans. no pattern matching is needed for an affected area.)
   *   <li>Note: if the moves come from database, remember to find the variations by rotations.
   *   <li>re-analyze the Area and the influenced stuff:
   *     <ul>
   *       <li>Any dead blocks?
   *       <li>Any captured blocks?
   *       <li>Any new blocks with LiveLevel>=4?
   *       <li>Calculate LiveLevels or whatever
   *       <li>Rearrange Areas if necessary.
   *       <li>Mark Strategy Move is applicable
   *       <li>Important! Calculate StaticPseudoScore!
   *       <li>etc
   *     </ul>
   *   <li>Analyze Vacant Posit candidates in each of the rearranged sub Area:
   *     <ul>
   *       <li>Note: if the number of vacant posit in a small Area > MAX_THINK_WIDTH (say, 10),
   *           then we need to try only the following candidates:
   *         <ul>
   *           <li>SPECIAL MOVEs
   *           <li>move to fence territory
   *           <li>move to expand influence
   *           <li>move to reduce enemy's influence
   *           <li>move to run
   *           <li>move to seize
   *         </ul>
   *       <li>For each Vacant Posit candidate in the Area:
   *         <ul>
   *           <li>utilize Alpha-Beta
   *           <li>inThinkDepth <= MAX_THINK_DEPTH: recursively go to Label 001
   *         </ul>
   *       <li>Save the best move as the Recommended move for this sub Area.
   *           (Note: if there is no move needed, the Recommended move = null.)
   *           (Note: if the best move is from pattern/database, remember its details.)
   *       <li>{Label 002} sum up all the scores from all sub areas.
   *           This becomes the score of the area.
   *     </ul>
   * </ul>
   *
   * <p>list all of the best moves in all areas, and choose the next move according to move sequence
   * algorithm
   *
   * <p>Once decided, return the result to enemy, and continue analyzing BrdStatus.
   */
  void basicLogic();

  /**
   * Types of moves in terms of FirstHand and BehindHand:
   *
   * <p>FirstHand Move (sente):
   * MoveThreat >= 2 * MoveScore_1
   * Note: The equality doesn't matter. Whether >= or > is fine.
   * (WRONG) MoveThreat > MoveScore_1 + MoveScore_2.
   * FirstHandScore (MoveScore_MMI):
   * MoveScore of a FirstHand Move is approximately equal to (2 * FirstHandScore)
   *
   * <p>AntiFirstHand Move:
   * A move to prevent from foe's FirstHand Move where MoveThreat >= 2 * MoveScore_1.
   * AntiFirstHandScore (MoveScore_IMMI):
   * MoveScore of a AntiFirstHand Move is approximately (2 * AntiFirstHandScore)
   *
   * <p>MutualFirstHand Move:
   * A move that is both a FirstHand Move and AntiFirstHand Move.
   *
   * <p>BehindHand Move (gote):
   * MoveThreat <= 2 * MoveScore_1
   */
  void typesOfMovesInTermsOfFirstHandAndBehindHand();

  /**
   * Each move has multiple functionalities.
   * The score of each move is the combination of scores from all functionalities.
   * Cf. ScoringSystem
   */
  void moveFunctions();

  /**
   * Move priority (from high to low):
   * <ul>
   *   <li>MutualFirstHand moves
   *   <li>FirstHand moves where FirstHandScore > MoveAdvantage_2
   *       Note: we want to save (as many as possible) FirstHand moves as JieCai,
   *       so use ">" instead of ">=".
   *   <li>AntiFirstHand moves where
   *       AntiFirstHandScore >= (2 * ScoreAdvantage_1) MoveScore_1
   *       Note: we want to have as few as possible AntiFirstHand moves,
   *       so that foe doesn't have many JieCai, thus, use ">=" instead of ">".
   *   <li>Jie: There are 3 kinds of Jie Moves: JieOpenMove, JieCloseMove, and JieThreatMove.
   *   <li>MoveScore_1
   * </ul>
   */
  void movePriority();

  /**
   * Move strategy depends on the status of game:
   * <ul>
   *   <li>wins a lot: defend first
   *   <li>falls behind a lot: offense first
   *   <li>time advantage: make complicated (time-consuming) moves
   *   <li>time disadvantage:
   *     <ul>
   *       <li>make simple moves
   *       <li>make moves with big threats to get more time
   *     </ul>
   * </ul>
   */
  void moveStrategy();

  /**
   * <p>When: When a Ctrl-{@link LotWithProperty} is in danger, then it needs to connect to a nearby Ctrl-{@link LotWithProperty}.
   *
   * <p>How: We could do it by Patterns or Strategies.
   *
   * <p>Strategies:
   * <ul>
   *   <li>Find vcnt posits that are on the rims of both Ctrl-{@link LotWithProperty}(s).
   *   <li>Calculate the sum and product of both numbers of rims for each such posit. For example,
   *       posit B is at 1nd rim and 5nd rim
   *       posit A is at 1st rim and 6th rim
   *       posit B is at 2nd rim and 2nd rim
   *       posit B is at 3nd rim and 3nd rim
   *       posit B is at 3nd rim and 4nd rim
   *   <li>prioritize the posits based on the following conditions:
   *       small sum
   *       big product
   *   <li>CtrlLvl
   *   <li>posits with higher priorities are better candidates for connectivity.
   * </ul>
   *
   * <p>"Cut" is similar to "Connect".
   *
   * @see ConnectionAnalyzer
   */
  void moveToConnectAndCut();

  /**
   * <p>move to increment number of qi:
   *   try every posit on the 1st rim
   *   FalseQi
   *
   * <p>move to decrement number of qi:
   *   FalseQi
   *
   * @see KillAnalyzer
   */
  void moveToIncrementOrDecrementNumberOfQis();

  /**
   * <p>move to make eyes
   *   by patterns
   *   try every posit in VacantBlock
   *   by killing
   *   by expanding freedom
   *
   * <p>move to destroy eyes
   *   by patterns
   *   try every posit in VacantBlock
   *   by killing
   *
   * @see EyeAnalyzer
   */
  void moveToMakeOrDestroyEyes();

  /**
   * Given: an area/{@link VacantBlock}
   * Find the move to generate the biggest value of:
   * {@link Realm}.size + 1/2 * {@link SemiRealm}.size
   * <br>TODO 250 In the above realm formula, the coefficient might not be 1/2.
   *
   * @see InfluenceAnalyzer
   */
  void moveToGainTerritory();

  /**
   * Move to expand or reduce Influence:
   * <ul>
   *   <li>by patterns (such as shadow cut)
   *   <li>by the approach similar to {@link #moveToGainTerritory()}.
   * </ul>
   *
   * @see InfluenceAnalyzer
   * @see Influence
   */
  void moveToExpandOrReduceInfluence();

  /**
   * Move to Escape:
   * <ul>
   *   <li>we need to make an escape-move lightly or heavily based on the value of the
   *       {@link Dragon}.
   *   <li>escape to the empty areas or areas with more control
   *   <li>solid escape: jump, Jian
   *   <li>medium escape: horse more
   *   <li>light escape: big jump, big horse move
   * </ul>
   *
   * @see KillAnalyzer
   */
  void moveToEscape();

  /**
   * Move to capture:
   * <ul>
   *   <li>Usually a move to seize is integrated with a move to gain.
   *   <li>Here our focus will be net-moves found by patterns.
   *   <li>YinZheng (引征) - when there is a ladder, the foe can take advantage of it by YinZheng.
   * </ul>
   *
   * @see KillAnalyzer
   */
  void moveToCapture();

  /**
   * Move to gain advantage by sacrifice.
   * It is difficult to find a Move of Sacrifice by pure calculation, so currently it is determined
   * by patterns.
   *
   * @see SacrificeAnalyzer
   */
  void moveToGainAdvantageBySacrifice();

  /**
   * Kill by Gongsha.
   *
   * <p>we need to count the number of dynamic inner qi's and dynamic outer qi's
   * <ul>
   *   <li>for counting dynamic outer qi's, we could utilize patterns or rules
   *   <li>for counting dynamic outer qi's, we need to know where we can extend qi's and
   *       where we can avoid qi's being decreased too quickly.
   * </ul>
   *
   * <p>Example Patterns:
   * <pre>
   * ............................................................................
   * ....A.....B.................................................................
   * ............................................................................
   * ..XXXXXXXOOOOOO.............................................................
   * ..XOOOOOOXXXX.O.............................................................
   * .XO...O.X..X.O.............................................................
   * ..XO..OO.X..X.O.............................................................
   * ..XOOOOOOXXXX.O.............................................................
   * ..XXXXXXXOOOOOO.............................................................
   * ............................................................................
   * ............................................................................
   * A: outer qi's = 8, inner qi's = 2
   * B: outer qi's = 5+4 = 9, inner qi's = 2
   * </pre>
   *
   * <p>Who Wins the Race?
   * <ul>
   *   <li>Assuming the next move is Black.
   *   <li>only outer qi's, no inner qi's, no Jie
   *   <li>Black wins if BlackOuterQis >= WhiteOuterQis.
   *   <li>both outer qi's and inner qi's exist, no Jie
   *     <ul>
   *       <li>Black wins if BlackOuterQis >= WhiteOuterQis + InnerQis - 1
   *       <li>Black loses if BlackOuterQis <= WhiteOuterQis - InnerQis
   *       <li>Otherwise, it is MutualLive. Namely, when:
   *       <li>WhiteOuterQis - InnerQis < BlackOuterQis < WhiteOuterQis + InnerQis - 1
   *     </ul>
   * </ul>
   *
   * @see BlockKillByGongshaAnalyzer
   */
  void killByGongsha();

  /**
   * Kill by Ladder.
   *
   * <p>
   * <pre>
   * ............................................................................
   * ............................................................................
   * ...XX......XX...............................................................
   * ..XO......XOOX..............................................................
   * ...........XOOX.............................................................
   * ............XOOX............................................................
   * .............XOOX...........................................................
   * ..........---------.........................................................
   * ............................................................................
   * ............................................................................
   * </pre>
   *
   * <p>Required Conditions for Ladder?
   * <ul>
   *   <li>there are only 2 qi's left for a {@link ColorBlock} where the leading foe stone is at (x0,y0).
   *   <li>One and only one of the 2 qi's must have x coordinate = x0,
   *       namely, qi_1 = (x0, y0+y_diff)
   *       where y_diff = 1 or -1.
   *   <li>The other qi must be (x0+x_diff, y0) where x_diff = 1 or -1.
   *   <li>If (x0+x_diff, y0-y_diff) or (x0-x_diff, y0+y_diff) (one and only one)
   *       is occupied by buddy already, then (x0, y0+y_diff) or (x0+x_diff, y0) is Ladder.
   *   <li>Note: If both (x0+x_diff, y0-y_diff) or (x0-x_diff, y0+y_diff) are occupied by buddy
   *       already, then it is a gate with GatePosit = (x0+x_diff, y0+y_diff)
   * </ul>
   *
   * <p>How to determine if a Ladder is good or bad?
   * <ul>
   *   <li>Assume:
   *     <ul>
   *       <li>(x0,y0) is the leading foe stone
   *       <li>qi_1 = (x0, y0+y_diff), qi_2 = (x0+x_diff, y0)
   *       <li>(x0+x_diff, y0-y_diff) is occupied by buddy already.
   *       <li>(x0, y0+y_diff) is the Ladder posit.
   *     </ul>
   *   <li>There are 6 diagonal lines we need to pay attention to. They are:
   *     <ul>
   *       <li>outer diagonal line 1 starting at: (x0-x_diff, y0+y_diff)
   *       <li>attack diagonal line 1 starting at the Ladder posit (x0, y0+y_diff)
   *       <li>escape diagonal line 1 starting at the original foe leading stone (x0, y0)
   *       <li>escape diagonal line 2 staring at (x0+x_diff, y0)
   *       <li>attack diagonal line 2 starting at the original occupied stone (x0+x_diff, y0-y_diff)
   *       <li>outer diagonal line 2 starting at (x0+2x_diff, y0-y_diff)
   *     </ul>
   *   <li>If there is a foe stone at any of the 6 lines without any preceding buddy stone on the
   *       way, then it is a bad Ladder.
   *   <li>If there is a foe stone at the N position of outer line 1:
   *       <br>If there is a buddy stone(s) at: both (N-1) and (N+1) positions of outer line 1,
   *       the N (or before) position of attack line 1, the N (or before) position of escape line 1,
   *       the N (or before) position of escape line 2, or the N (or before) position of attack
   *       line 2, it is still a good Ladder.
   *   <li>If there is a foe stone at the N position of attack line 1:
   *       <br>If there is a buddy stone at: the (N-1) (or before) position of attack line 1,
   *       the N (or before) position of escape line 1, the (N-1) (or before) position of escape
   *       line 2, or the N (or before) position of attack line 2, it is still a good Ladder.
   *   <li>If there is a foe stone at the N position of escape line 1:
   *       <br>If there is a buddy stone at: the N (or before) position of attack line 1,
   *       the (N-1) (or before) position of escape line 1, the (N-1) (or before) position of escape
   *       line 2, or the N (or before) position of attack line 2, it is still a good Ladder.
   *   <li>If there is a foe stone at the N position of escape line 2:
   *       <br>If there is a buddy stone at: the N (or before) position of attack line 1,
   *       the N (or before) position of escape line 1, the (N-1) (or before) position of escape
   *       line 2, or the (N+1) (or before) position of attack line 2, it is still a good Ladder.
   *   <li>If there is a foe stone at the N position of attack line 2:
   *       <br>If there is a buddy stone at: the (N-1) (or before) position of attack line 1,
   *       the (N-1) (or before) position of escape line 1, the (N-1) (or before) position of escape
   *       line 2, or the (N-1) (or before) position of attack line 2, it is still a good Ladder.
   *   <li>If there is a foe stone at the N position of outer line 2:
   *       <br>If there is a buddy stone at: the N (or before) position of attack line 1,
   *       the (N+1) (or before) position of escape line 1, the N (or before) position of escape
   *       line 2, or the (N+1) (or before) position of attack line 2, it is still a good Ladder.
   *   <li>Note: There might be some other complicated cases such as one foe stone and two buddy
   *       stones on the lines ... etc.
   *   <li>Be careful about the wall.
   *  </ul>
   *
   *  @see BlockKillByLadderAnalyzer
   */
  void killByLadder();

  /**
   * Steps to handle next move.
   * <ul>
   *   <li>Given current {@link AnalyzerBoard} and next move coord.
   *   <li>Execute {@link MoveHandling}.
   *   <li>If next move type is {@link MoveType#MOVE_ERROR_PREV_POSIT_IS_ALREADY_OCCUPIED} or
   *       {@link MoveType#MOVE_ERROR_JIE_VIOLATION}, then stop.
   *   <li>Build candidate {@link AnalyzerBoard} with {@link PositionState} updated with the new move.
   *   <li>Else, see the implementation of {@link MoveHandling}
   * <ul>
   *
   * @see MoveHandling
   */
  void stepsToHandleNextMove();

  /**
   * 同型禁著 violation:
   * <ul>
   *   <li>compare the board with the 6th previous boards to see if they are the same.
   *   <li>We all need to compare the 8th, 10th, ... previous ones as well.
   *   <li>For simplicity, just compare the 8th one and ignore the rest of them.
   * </ul>
   *
   * @see MoveHandling
   */
  void samePositionStateBoardViolation();

  /**
   * Buju with database:
   *
   * <p>This is the first phase of the game. Once this phase is over or pause, it follows with one
   * of the following phases:
   * <ul>
   *   <li>BuJue-VcntJump
   *   <li>DingShi
   *   <li>ZhongPan
   * </ul>
   *
   * <p>The 1st move is always in the upper-right corner,
   * and the 2nd move could be in the corner of:
   * <ul>
   *   <li>upper-right:
   *   <li>upper-left:
   *   <li>lower-left:
   * </ul>
   *
   * <p>I have to tell Godzilla the default style to use before a game starts.
   * The style could be dynamically changed during a game depending on the status.
   * Note that usually the style of this move is different from the style of the previous move.
   *
   * @see BujuAnalyzer
   */
  void bujuWithDatabase();

  /**
   * Buju with {@link VacantBlock}.
   *
   * <p>Move candidate types:
   * <ul>
   *   <li>Move at the 3rd line
   *   <li>Move at the 4th line
   *   <li>Move of fence
   * </ul>
   *
   * <p>Find move candidates:
   * <ul>
   *   <li>Find all VacantBlocks bigger than 20.
   *   <li>I don't know at which line (3rd or 4th) the move is better.
   * </ul>
   *
   * <p>Evaluate score of move candidates
   *
   * @see BujuAnalyzer
   */
  void bujuWithVacantBlock();
}
