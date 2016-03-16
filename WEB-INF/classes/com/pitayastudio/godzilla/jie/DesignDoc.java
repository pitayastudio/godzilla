package com.pitayastudio.godzilla.jie;

import com.pitayastudio.godzilla.moveanalyzer.JieAnalyzer;
import com.pitayastudio.godzilla.scoresystem.ScoreSystem;

/**
 * @see JieAnalyzer
 */
public interface DesignDoc {
  /**
   * MoveScore of a Jie Move is approximately a little bit more than (2/3 * JieScore).
   *
   * @see ScoreSystem
   */
  void jieScore();

  /**
   * <ul>
   *   <li>Those JieCai with
   *   <li>JieThreatScore > JieScore - ScoreAdvantage_2
   *   <li>are good JieCais (which will force foe to respond), otherwise they are bad JieCais.
   *   <li>Note: JieThreatScore >= 2 * MoveScore_1
   *   <li>otherwise just use MoveScore_1. See explanations later.
   *   <li>In summary:
   *   <li>JieCais: JieThreatScore >= 2 * MoveScore_1
   *   <li>where good JieCais happen when
   *   <li>JieThreatScore > JieScore - ScoreAdvantage_2
   *   <li>and bad JieCais happen when
   *   <li>JieScore - ScoreAdvantage_2 > JieThreatScore >= 2 * MoveScore_1
   *   <li>(Don't care about JieThreatScore = JieScore - ScoreAdvantage_2)
   * </ul>
   */
  void jieCai();

  /**
   * <ol>
   *   <li>jie1, dead1
   *   <li>jie2, dead2
   *   <li>jie3, dead3
   *   <li>jie4=dead1, dead4=jie1
   *   <li>jie5=dead2, dead5=jie2
   *   <li>jie6=dead3, dead6=jie3
   * </ol>
   *
   * <p>There is no need to handle Triple-Jie.
   */
  void tripleJieTypeI();

  /**
   * <pre>
   * ........
   * ...XXX..
   * ..XXOX..
   * ..XO.O..
   * ..O.OO..
   * ..OOO...
   * </pre>
   */
  void tripleJieTypeII();

  /** TODO 400a Add javadoc for foreverJieCai*/
  void foreverJieCai();

  /** TODO 400a Add javadoc for howToCreateBigJieCai*/
  void howToCreateBigJieCai();

  /**
   * These are used in MoveGenerator.
   * <ul>
   *   <li>JieOpenMove:
   *     <ul>
   *       <li>JieOpenMove happens when:
   *       <li>JieScore - MoveScore_1 - ScoreAdvantage_2 >=
   *           MoveScore_1 - JieScore + ScoreAdvantage_2
   *       <li>namely, JieScore >= MoveScore_1 + ScoreAdvantage_2
   *     </ul>
   *   <li>JieCloseMove:
   *     <ul>
   *       <li>if buddy has enough JieCais, then buddy doesn't need to make a JieCloseMove.
   *       <li>if buddy doesn't have enough JieCais, make a JieCloseMove when:
   *       <li>JieScore - ScoreAdv_1 >= MoveScore_1 + MoveScore_2 - JieScore + ScoreAdvantage_3
   *       <li>Namely, JieScore >= MoveScore_1 + ScoreAdvantage_3
   *     </ul>
   *   <li>JieThreatMove:
   *     <ul>
   *       <li>In order to save a Jie
   *          (namely, to make a JieOpenMove, thus, JieScore >= MoveScore_1 + ScoreAdvantage_2),
   *       <li>Question: if
   *           MoveScore_1 + ScoreAdvantage_2 > JieScore > MoveScore_1 = ScoreAdvantage_3,
   *           do we still need to save the Jie? Ans. No.
   *       <li>we need to make a JieThreatMove such that foe doesn't want to make a JieCloseMove and
   *           has to respond.
   *       <li>Namely, JieScore <= JieThreatScore (which becomes MoveScore_1) + ScoreAdvantage_2
   *          (the original one, which becomes ScoreAdvantage_3)
   *       <li>Namely, JieThreatScore >= JieScore - ScoreAdvantage_2.
   *       <li>The goal (to force foe to respond) might not be achieved,
   *           but we still need to try our best JieThreatMove.
   *       <li>We need to make an effective JieThreatMove anyway, otherwise, just use MoveScore_1.
   *       <li>So, JieThreatScore - JieScore - ScoreAdvantage_1 >=
   *           MoveScore_1 - JieScore + ScoreAdvantage_2
   *       <li>namely, JieThreatScore >= 2 * MoveScore_1
   *       <li>Note: JieThreatScore is the result of 2 moves.
   *     </ul>
   * </ul>
   */
  void threeKindsOfJieMoves();

  /**
   * 搖櫓劫 http://senseis.xmp.net/?DoubleKo
   * Molasses Jie http://senseis.xmp.net/?MolassesKo
   * 三劫循環 http://senseis.xmp.net/?TripleKo
   * 四劫循環 http://senseis.xmp.net/?QuadrupleKo
   * Moonshine Life http://senseis.xmp.net/?MoonshineLife
   * 賴皮劫 http://senseis.xmp.net/?ApproachKo
   * 長生劫 http://senseis.xmp.net/?EternalLife
   */
  void specialJies();
}
