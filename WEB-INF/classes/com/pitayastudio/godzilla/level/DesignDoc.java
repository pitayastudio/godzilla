package com.pitayastudio.godzilla.level;

import com.pitayastudio.godzilla.model.Dragon;
import com.pitayastudio.godzilla.model.Gang;
import com.pitayastudio.godzilla.model.LotWithProperty;
import com.pitayastudio.godzilla.modelboard.GangBoard;
import com.pitayastudio.godzilla.moveanalyzer.EyeAnalyzer;
import com.pitayastudio.godzilla.moveanalyzer.InfluenceAnalyzer;
import com.pitayastudio.godzilla.moveanalyzer.connectionanalyzer.ConnectionAnalyzer;

public interface DesignDoc {

  /**
   * Control Level.
   *
   * <p>Influence is generated radically from color stones of {@link Gang}s, and is received by nearby
   * vacant posits.
   * Received Influence on a vacant posit is cumulative, and the sum is called CtrlLevel.
   * Influence is radiated from {@link Gang}s, but not from {@link Dragon}s.
   * Prisoners don't radiate.
   * Radiated influence could be reflected by walls.
   * The corner doesn't reflect anyhow.
   * If the stone touches the wall, it doesn't reflect.
   * Influence could pass through foe stones unless it is totally stopped by Live dragons.
   *
   * <pre>
   * BaseInfluence function f(x,y):
   * f(0,0)=1024
   * f(1,0)=f(0,1)=512
   * f(2,0)=f(0,2)=256
   * f(3,0)=f(0,3)=128
   * f(4,0)=f(0,4)=64
   * f(5,0)=f(0,5)=32
   * f(6,0)=f(0,6)=16
   * f(7,0)=f(0,7)=8
   * f(8,0)=f(0,8)=4
   * f(9,0)=f(0,9)=2
   * f(10,0)=f(0,10)=1
   * f(a,b)= 1.5 x f(a-1,b) x f(a,b-1) / ( f(a-1,b) + f(a,b-1) )
   *
   * BaseInfluence Values:
   * 1024 512 256 128 064 032 016 008 004 002 001
   * 512 384 230 123 063 032 016 008 004 002 001
   * 256 230 173 108 060 031 016 008 004 002 001
   * 128 123 108 081 052 029 015 008 004 002 001
   * 064 063 060 052 039 025 014 008 004 002 001
   * 032 032 031 029 025 019 012 007 004 002 001
   * 016 016 016 015 014 012 009 006 004 002 001
   * 008 008 008 008 008 007 006 005 003 002 001
   * 004 004 004 004 004 004 004 003 002 001 001
   * 002 002 002 002 002 002 002 002 001 001 001
   * 001 001 001 001 001 001 001 001 001 001 001
   * </pre>
   *
   * Influence = BaseInfluence * LiveLevel
   * Note: LiveLevel is a function of Influence too.
   * CtrlLevel on a vacant posit could be used to calculate the possibility for the posit to become
   * a territory.
   *
   * <p>The java class CtrlLevel
   * <pre>
   * Members
   * inInfluenceReceivedFromBlack
   * inInfluenceReceivedFromWhite
   * Methods
   * calcCtrlLevelForClr
   * (optional) calcEffectiveInfluenceReceivedFromClr
   * (optional) calcBattleLevel
   * </pre>
   *
   * <p>Influence in other computer programs:
   *
   * <p>Influence in Intelect.
   * radiates exponentially with rate 0.5
   *
   * <p>Influence in ManyFaces.
   * radiates hyperbolically with rate 1/distance
   *
   * <p>Influence and deg of liberty point in Wulu.
   * Wulu defines the degree of liberty points as in the following figures.
   * Liberty point must be empty.
   * <pre>
   *      y2y
   *     yz1zy        mn
   *     21O12        OX
   *     yz1zy        mn
   *      y2y
   *      (a)         (b)
   * </pre>
   * In fig.a, O is a white stone and those points with other characters are empty.
   * The points 1 (adjacent) is the liberty point with degree 1 of the stone;
   * points 2 (jump) --degree 2;
   * points z (diagonal adjacent) --degree 1.5;
   * points y (knight) --degree 2.5.
   * In fig.b, O is a white stone, X is a black stone, and those points with m or n are empty.
   * m is a liberty point of the black stone with degree 2 (hane point),
   * and n is a liberty point of the white stone with degree 2.
   * The influence from stones of a color depends only on the nearest stone (with least degree):
   * <pre>
   *     degree              1     1.5    2    2.5
   *     white influence     6     5      3    2
   *     black influence    -6    -5     -3   -2
   * </pre>
   * Influence from both white and black can be compensated mutually.
   *  There is also a rounding scheme in Wulu like that in Handtalk with some differences.
   * As the calculation of influence is much simpler than that in Handtalk, the evaluation is much
   * faster.
   *
   * <p>Influence in Handtalk.
   * The influence of a normal white stone:
   * on its adjacent points is 4;
   * on its diagonal adjacent points is 3;
   * on its jump or knight points is 2;
   * on some points a little farer than jump or knight is 1.
   * A normal black stone radiates negative influence.
   * Dead stone radiates influence with opposite sign.
   * Half-dead or injured stone radiates less influence.
   * The influences of stones on a point are additive, but not linear additive.
   * For example, the influence on a point adjacent or diagonally adjacent to both black and white
   * stones is 0, independent on the numbers of black and white stones.
   * If the influence value of a point is 1 or -1, set it 0
   * (retaining 1|-1 to denote false eye-point of white|black).
   * If the influence value is greater than 2,
   * it is treated as a full white controlled point first and then rounded (see below);
   * if the influence value is less than -2,
   * it is treated as a full black controlled point first and then rounded.
   * A full white|black controlled point has its influence value of 6|-6.
   * The unit of resulting influence is referred to as dot.
   * The rounding scheme includes the following rules:
   * If adjacent to a point with 0 or negative influence, it never exceeds 3 dots;
   * If adjacent to a point with 1 or 2 dots, it never exceeds 5 dots.
   * There are similar rules for negative dots (black influence).
   * 1|-1 dot means false eye-point of white|black.
   *
   * <p>Influence in Jimmy.
   * The concept of influence has been used many times in computer Go.
   * The reason is that influence can simulate human player’s vision estimation of thickness.
   *
   * @see InfluenceAnalyzer
   * @see Influence
   */
  void controlLevelAndInfluence();

  /**
   * Connection Level.
   *
   * <p>Definition:
   * <ul>
   *   <li>ConnectLevel = 2 + (number of foe moves to reach a guaranteed-cut state)
   *       - (number of buddy moves to reach a guaranteed-connect state)
   *   <li>The ConnectLevel might be involved by not only 2 {@link LotWithProperty}(s) but 3 or more {@link LotWithProperty}(s).
   * </ul>
   *
   * <p>ConnectLevel between two Posits above 3rd lines:
   * <ul>
   *   <li>Diagonal: 4
   *   <li>Horse: 2.5
   *   <li>Jump: 2
   *   <li>Big Horse: 2
   *   <li>Big Jump: 2
   *   <li>Big Diagonal: 2
   *   <li>Super Jump: 1
   * </ul>
   *
   * <p>ConnectLevel between two {@link LotWithProperty}(s)
   * <ul>
   *   <li>+N: N>=5, foe needs N more moves to cut it ==> treated as AbsConnect
   *   <li>4: foe needs 2 more moves to cut it
   *   <li>3: foe needs a KO to cut it
   *   <li>2: foe needs 1 more move to cut it; buddy needs 1 more move to connect
   *   <li>1: buddy needs a KO to connect
   *   <li>0: buddy needs 2 more moves to connect
   *   <li><0: treated as AbsCut
   * </ul>
   *
   * <p>How to determine ConnectionLevel between 2 gangs?
   *
   * <p>Note: ConnectLevel >= 3 means connected
   *
   * <p>Only analyze the last move of the game to see what it could be connected.
   *
   * <p>if 2 buddy gangs share 2+ qi's, then they are connected
   *
   * <p>if 2 buddy gangs share 1 qi's:
   * <ul>
   *   <li>if the only qi is buddy-protected (with zero or one opening qi), then they are connected
   *   <li>else, the only qi must have 2 opening qi's
   *   <li>pseudo make a foe move at the shared qi
   *   <li>try to kill the foe move from 2 possible opening qi's
   *   <li>the foe escape to the remaining qi (if the foe doesn't need to escape, then it is cut
   *   <li>make one more buddy move to:
   *     <ul>
   *       <li>connect the previous buddy move to one of the buddy gangs if possible
   *       <li>analyze the consequent situations to see if the new 2 buddy moves can connect to both
   *           gangs
   *       <li>try to kill foe
   *     </ul>
   * </ul>
   *
   * <p>if any consequent situations can lead to connected state, then they are treated as connected
   *
   * <p>if 2 buddy gangs share 0 qi, then:
   *
   * <p>if for each gang, there are 2+ close qi's (of either gang without big influence from foe)
   * residing at 2nd-rim of the other gang
   *
   * <p>if there are 2+ consecutive qi's at 3rd-rim of one gang,
   * and 3+ consecutive qi's at 3rd-rim of
   *
   * <p>by patterns:
   * <pre>
   * ............................
   * .................X..........
   * ..X.......XX......X.....XX..
   * ............................
   * ..XX........................
   * ..........XX.....X..........
   * ..................X.....XXX.
   * ............................
   * ............................
   *
   * ------------------
   * ..X..X......X.....
   * ...............X..
   * ..OOOO......OOOO..
   * ..................
   *
   * -------------------------
   * .........................
   * ..X..X...................
   * ...........X..X..........
   * ....................X.X..
   * .........................
   * </pre>
   *
   * <p>How to determine ConnectLevel among 3 or more {@link LotWithProperty}(s)?
   *
   * <p>first, find {@link Gang}s of 2 {@link LotWithProperty}(s), then incrementally find {@link Gang}s of {@link Gang} + {@link LotWithProperty}.
   *
   * <p>samples:
   * <pre>
   * .......................
   * .......................
   * ...X.......X......X.X..
   * ..X.......X............
   * ..................XX...
   * ...X......X............
   * .......................
   * .......................
   *
   * ---------
   * ...X.....
   * ..X...X..
   * ..OOOOO..
   * .........
   * </pre>
   *
   * @see ConnectionAnalyzer
   */
 void connectionLevel();

 /**
  * Live Level.
  *
  * <p>Definition.
  * <ul>
  *   <li>Live Level could be affected by:
  *     <ul>
  *       <li>number of eyes
  *       <li>size (inner)
  *       <li>freedom (outer)
  *     </ul>
  *   <li>Claimed by Handtalk:
  *       It has been found that when the number of moves to surround a block increases by 1,
  *       the danger will be halved. However, the number of foe moves to surround a block may be
  *       difficult to calculate.
  *   <li>LiveLevelInMoves = (number of enemy moves to reach the guaranteed dead state)
  *       - (number of buddy moves to reach the guaranteed live state) + 2
  *   <li>LiveLevelInSafety = 2 ^ LiveLevelInMoves
  *   <li>Explanations of LiveLevelInMoves:
  *     <ul>
  *       <li>+Infinity: AbsLive
  *           ("Infinity" is only meaningful in math; it doesn't make sense in practice.)
  *       <li>>4: enemy needs N (N>2) more moves to kill it ==> treated as AbsLive
  *       <li>4: enemy needs 2 more moves to kill it
  *       <li>3: enemy needs a Jie to kill it
  *       <li>2: enemy needs 1 more move to kill it; buddy needs 1 more move to live
  *       <li>1: buddy needs a Jie to live
  *       <li>0: buddy needs 2 more moves to live
  *       <li><0: buddy needs N (N>2) more moves to live ==> treated as AbsDead
  *       <li>-Infinity: AbsDead
  *     </ul>
  *   <li>Note: Radiated Influence = BaseInfluence * LiveLevel
  *       So we cannot have LiveLevel = +Infinity, otherwise, Influence will become infinitive.
  *       Therefore, I define LiveLevelInMoves = 5 for AbsLive.
  * </ul>
  *
  * <p>Calculate the LiveLevel for a {@link Gang} consisting of 2 {@link LotWithProperty}(s).
  * The following table shows the LiveLevelInMoves of the {@link Gang} based on the LiveLevelInMoves of
  * the 2 {@link LotWithProperty}(s).
  * Note: The following doesn't consider the case where each {@link LotWithProperty} has one eye
  * (thus the {@link Gang} is live).
  * <pre>
  *   ,  <0,   0,   1,   2,   3,   4,  >4
  * >4, >=4, >=4, >=4, >=4, >=4, >=4, >=4,
  *  4,   4,   4, >=4, >=4, >=4, >=4, >=4,
  *  3,   3,   3, >=4, >=4, >=4, >=4, >=4,
  *  2,   2,   2,   3,   3, >=4, >=4, >=4,
  *  1,   1,   1,   2,   3, >=4, >=4, >=4,
  *  0,   0,   1,   1,   2,   3,   4, >=4,
  * <0,  <0,   1,   1,   2,   3,   4, >=4,
  * </pre>
  *
  * <p>LiveLevel of a {@link Dragon} Consisting of 2 {@link Gang}s:
  * The process is similar to (but slightly lower) LiveLevel of a {@link Gang} Consisting of 2 {@link LotWithProperty}(s).
  *
  * @see GangBoard
  */
 void liveLevel();

 /**
  * Analyze number of eyes:
  *
  * <p>Types (assuming next turn is Black):
  * <pre>
  * ................................................................
  * ....A.........B..........C...........D...........E..............
  * ......................OOOOOOO.....OOOOOOO.....OOOOOOO...........
  * ..XXXXX.....XXXXX.....OXXXXXO.....OXXXXXO.....OXXXXXO...........
  * ..X...X.....X...X.....OX.X.XO.....OX.X.XO.....OX.X.XO...........
  * ..XXXXX.....XX.XX.....OOX.XOO.....OOXOXOO.....OOXOXOO...........
  * .............XXX.......OOXOO.......OO.OO.......OO.OO............
  * ........................OOO.........OOO.........OOO.............
  * ................................................................
  * ...........................................Jie Prohibited.......
  * NumOf1or2Eye: A, B
  * NumOf0or2EyeWithCloseJie: C
  * NumOf0or2EyeWithOpenJie: D
  * NumOf0or2EyeWithOpenJieProhibited: E
  *
  * ..................................................................
  * ....a........b.........c.........d.........e......................
  * ......................XXOO......XXOO......XXOO....................
  * ..XXXOO.....XXXX.....XX.XO.....XXO.O.....XXO.O....................
  * ..X..XO.....X..X.....X.XOO.....X.XOO.....X.XOO....................
  * ..XXXOO.....XXXX.....XXOO......XXOO......XXOO.....................
  * ..................................................................
  * ......................................Jie Prohibited..............
  * NumOf0or1Eye: a
  * NumOf1Eye: b
  * NumOf1EyeWithCloseJie: c
  * NumOf1EyeWithOpenJie: d
  * NumOf1EyeWithOpenJieProhibited: e
  * </pre>
  *
  * <p>
  * <ul>
  *   <li>Now, we are going to see if Black is guaranteed Live by ignoring the next move.
  *       Namely, Black will make a move somewhere else.
  *       Also, assume White is going to make the next move trying to kill Black.
  *     <ul>
  *       <li>In that case, the ProhibitedJie of cases E and e disappear when White moves.
  *       <li>Then if Black is not guaranteed Live by ignoring the next move,
  *           can Black be guaranteed Live by acting immediately? The answer is Yes.
  *     </ul>
  *   <li>SumOf1Eye = 3/2 x NumOf1or2Eye + 1 x NumOf1Eye + 2/3 x NumOf1EyeWithCloseJie
  *       + 1/3 x NumOfEyeWithOpenJie + 1/3 x NumOfEyeWithOpenJieProhibited
  *   <li>If SumOf1Eye >= 2, Live. Return.
  *   <li>SumOf2Eye = 4/3 x NumOf0or2EyeWithCloseJie + 2/3 x NumOf0or2EyeWithOpenJie
  *       + 2/3 x NumOf0or2EyeWithOpenJieProhibited
  *   <li>Else If SumOf2Eye >= 2, Live. Return.
  *   <li>Else If SumOf1Eye + SumOf2Eye >= 2 1/3, Live. Return.
  *   <li>Note: case A/B + case D/E is not Live yet.
  *   <li>Note: case c + 2 cases D/E is not Live yet.
  * </ul>
  *
  * @see EyeAnalyzer
  */
 void analyzeNumberOfEyes();
}
