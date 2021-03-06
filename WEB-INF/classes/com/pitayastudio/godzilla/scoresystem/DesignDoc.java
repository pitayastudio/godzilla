package com.pitayastudio.godzilla.scoresystem;

import com.pitayastudio.godzilla.model.Dragon;
import com.pitayastudio.godzilla.model.Gang;
import com.pitayastudio.godzilla.model.LotWithProperty;
import com.pitayastudio.godzilla.model.Realm;

/**
 * @see ScoreSystem
 * @see com.pitayastudio.godzilla.jie.DesignDoc#jieScore()
 * @see com.pitayastudio.godzilla.jie.DesignDoc#jieCai()
 * @see com.pitayastudio.godzilla.jie.DesignDoc#threeKindsOfJieMoves()
 */
public interface DesignDoc {
  /**
   * Static pseudo score:
   *
   * <p>
   * <pre>
   * 4:
   * +------
   * |......
   * |......
   * |..X...
   * |......
   * |......
   * |......
   *
   * 11:
   * +-------
   * |.......
   * |.......
   * |...X...
   * |.......
   * |..X....
   * |.......
   * |.......
   * |.......
   *
   * 4.5:
   * +-------
   * |.......
   * |.......
   * |.......
   * |...X...
   * |.......
   * |.......
   * |.......
   *
   * 17:
   * +-------
   * |.......
   * |.......
   * |....X..
   * |...X...
   * |.......
   * |..X....
   * |.......
   * |.......
   * |.......
   *
   * 2:
   * ----------
   * ..........
   * ...X..X...
   * ..........
   * ..........
   * ..........
   *
   * 4:
   * ----------
   * ..........
   * ..........
   * ...X..X...
   * ..........
   * ..........
   * ..........
   *
   * 2:
   * ----------
   * ..........
   * ..........
   * ..........
   * ...X..X...
   * ..........
   * ..........
   * ..........
   *
   * 3:
   * ----------
   * ..........
   * ..........
   * ..........
   * ...X.X....
   * ..........
   * ..........
   * ..........
   * </pre>
   */
  void staticPseudoScore();

  /**
   * We need to create a Pattern Database for DynamicPseudoScore.
   *
   * <p>
   * <pre>
   * 7:
   * +------
   * |......
   * |......
   * |..X...
   * |......
   * |......
   * |......
   *
   * 14:
   * +-------
   * |.......
   * |.......
   * |...X...
   * |.......
   * |..X....
   * |.......
   * |.......
   * |.......
   *
   * 4.5:
   * +-------
   * |.......
   * |.......
   * |.......
   * |...X...
   * |.......
   * |.......
   * |.......
   *
   * 20:
   * +-------
   * |.......
   * |.......
   * |....X..
   * |...X...
   * |.......
   * |..X....
   * |.......
   * |.......
   * |.......
   *
   * 4:
   * ----------
   * ..........
   * ...X..X...
   * ..........
   * ..........
   * ..........
   *
   * 7:
   * ----------
   * ..........
   * ..........
   * ...X..X...
   * ..........
   * ..........
   * ..........
   *
   * 4.5:
   * ----------
   * ..........
   * ..........
   * ..........
   * ...X..X...
   * ..........
   * ..........
   * ..........
   *
   * 6:
   * ----------
   * ..........
   * ..........
   * ..........
   * ...X.X....
   * ..........
   * ..........
   * ..........
   * </pre>
   */
  void dynamicPseudoScore();

  /**
   * {@link LotWithProperty} doesn't need score, because score depends on LiveLevel.
   * So it is better to consider score with {@link Gang}s and/or {@link Dragon}s.
   *
   * <p>Score:
   * <ul>
   *   <li>LiveLevel >= 4: LiveScore = territory + 2 x number of prisoners
   *   <li>LiveLevel = 3: 2/3 x LiveScore + 1/3 x DeadScore
   *   <li>LiveLevel = 2: (LiveScore + DeadScore)/2 = (buddy - enemy).(# of prisoner stones)
   *   <li>LiveLevel = 1: 1/3 x LiveScore + 2/3 x DeadScore
   *   <li>LiveLevel = 0: DeadScore = -territory - 2 x number of buddy stones
   *       ({@link Gang} becomes prisoner)
   * </ul>
   */
  void scoreForGang();

  /**
   * StaticPseudoScore is approximately the sum of sizes of all {@link Realm}'s.
   *
   * <p>Score
   * <ul>
   *   <li>LiveLevel >= 4:
   *       LiveScore = territory + 2 x number of prisoners + buddy StaticPseudoScore
   *   <li>LiveLevel = 3:
   *       2/3 x LiveScore + 1/3 x DeadScore
   *   <li>LiveLevel = 2:
   *       (LiveScore + DeadScore)/2 = (buddy - enemy).(StaticPseudoScore - # of prisoner stones)
   *   <li>LiveLevel = 1:
   *       1/3 x LiveScore + 2/3 x DeadScore
   *   <li>LiveLevel = 0:
   *       DeadScore = -territory - 2 x number of buddy stones + enemy StaticPseudoScore
   *       ({@link Gang} becomes prisoner)
   * </ul>
   */
  void scoreForDragon();

  /**
   * <p>General Defn
   * <ul>
   *   <li>MoveScore for each Move depends on other best move candidate of each area.
   *   <li>the score of each move is the combination of scores from all functionalities.
   *       cf. MoveGenerator.
   *   <li>Static MoveScore =
   *       (The territory (increment) that buddy (potentially) gets w/ this buddy move) +
   *       (The territory (decrement) that foe (potentially) loses w/ this buddy move) +
   *       (The territory (increment) that foe (potentially) gets w/ a foe move in the same area) +
   *       (The territory (decrement) that buddy (potentially) loses w/ a foe move in the same area)
   *   <li>Defn of MoveScore_N:
   *     <ul>
   *       <li>MoveScore_1: the highest MoveScore
   *       <li>MoveScore_2: the 2nd highest MoveScore
   *       <li>MoveScore_3: the 3rd highest MoveScore
   *       <li>and so on.
   *     </ul>
   *   <li>MoveScore (MoveScore_M + MoveScore_I)/2
   *   <li>MoveScore for buddy move: MoveScore_M (MoveScore_MM + MoveScore_MI)/2
   *     <ul>
   *       <li>foe move: MoveScore_MM (MoveScore_MMM + MoveScore_MMI)/2
   *       <li>buddy move: MoveScore_MMM
   *       <li>buddy ignore: MoveScore_MMI => cf. FirstHandScore
   *       <li>foe ignore: MoveScore_MI (MoveScore_MIM + MoveScore_MII)/2
   *       <li>buddy move: MoveScore_MIM => cf. BuddyMoveThreat
   *       <li>buddy ignore: MoveScore_MII
   *       <li>buddy ignore: MoveScore_I (MoveScore_IM + MoveScore_II)/2
   *     </ul>
   *   <li>MoveScore for foe move: MoveScore_IM (MoveScore_IMM + MoveScore_IMI)/2
   *     <ul>
   *       <li>buddy move: MoveScore_IMM
   *       <li>foe move: MoveScore_IMMM
   *       <li>foe ignore: MoveScore_IMMI => cf. AntiFirstHandScore
   *       <li>buddy ignore: MoveScore_IMI
   *       <li>foe move: MoveScore_IMIM => cf. FoeMoveThreat
   *       <li>foe ignore: MoveScore_IMII
   *       <li>foe ignore: MoveScore_II (MoveScore_IIM + MoveScore_III)/2
   *       <li>buddy move: MoveScore_IIM
   *       <li>buddy ignore: MoveScore_III
   *     </ul>
   * </ul>
   *
   * <p>MoveThreat
   * <ul>
   *   <li>BuddyMoveThreat (cf. MoveScore_MIM)
   *   <li>FoeMoveThreat (cf. MoveScore_IMIM)
   * </ul>
   *
   * <p>MoveAdvantage
   * <ul>
   *   <li>MoveAdvantage_N = MoveScore_N - MoveScore_(N+1) + MoveScore_(N+2) - MoveScore_(N+3) + ...
   *       to the last MoveScore
   *   <li>Note: MoveScore_N could be equal to MoveScore_(N+1)
   *   <li>Roughly, MoveAdvantage_N (MoveScore_N)/2
   * </ul>
   */
  void scoreForMove();
}
