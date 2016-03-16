package com.pitayastudio.godzilla.endgame;

import com.pitayastudio.godzilla.model.Block;
import com.pitayastudio.godzilla.model.ColorBlock;
import com.pitayastudio.godzilla.model.LotWithProperty;
import com.pitayastudio.godzilla.model.PrisonerBlock;
import com.pitayastudio.godzilla.model.VacantBlock;

public interface DesignDoc {
  /**
   * End game territory analyzer. Assuming:
   * <ul>
   *   <li>Chinese Rule
   *   <li>all the dead stones are already picked up
   *   <li>no external false-Mu's
   *   <li>no {@link VacantBlock}s between black and white unless it is double-live and the
   *       {@link VacantBlock} has 2 Qi's
   * </ul>
   *
   * @see EndGameTerritoryWithoutDeadAnalyzer
   */
  void endGameAssumption();

  /**
   * Counts points.
   *
   * <p>Steps:
   * <ul>
   *   <li>Determine {@link PrisonerBlock}s
   *   <li>players confirm dead {@link ColorBlock}s
   *     <ul>
   *       <li>remove dead {@link ColorBlock}s
   *       <li>create new {@link VacantBlock}s
   *       <li>update {@link Block}s: combine connected vacant {@link Block}s
   *       <li>update neighborhoods
   *       <li>update gangs
   *     </ul>
   *   </li>
   *   <li>once picking up dead stones is done, then count the points
   *   <li>將所有同時為黑白氣 (isNeiOfBothColors) 的 {@link VacantBlock}s 標示出來, 這些都絕對不是地, 剩餘的才可能是地.
   *   <li>FalseMu: 唯一的氣可讓某一 {@link ColorBlock} (或由 {@link ColorBlock}s 和 FalseMus 所連成的串) 連到 {@link LotWithProperty}.
   *   <li>找出所有的 {@link LotWithProperty}'s:
   *     <ul>
   *       <li>對 boardStatus 中的每個 Black/White {@link Block}
   *       <li>對其每個 non-isNeiOfBothColors {@link VacantBlock}, 連結其 buddy {@link Block}s
   *       <li>重複上述步驟直到通通找完
   *     </ul>
   *   </li>
   *   <li>盤末判斷 {@link LotWithProperty} 是否有地 (see below)
   *     <ul>
   *       <li>注意名詞的意義:
   *         <ul>
   *           <li>兩眼的活叫淨活, 大單眼的活有穩活或雙活
   *           <li>淨死 v.s. 穩死
   *         </ul>
   *       </li>
   *       <li>底下的分析皆須先排除 ConnectQis
   *       <li>0 PossibleEyeBlock 為淨死或雙活 -> 盤末視為雙活.
   *       <li>1 PossibleEyeBlock 時為淨死, 穩死, 雙活, 或穩活:
   *         <ul>
   *           <li>若為 1 目空: 淨死或雙活 -> 盤末視為雙活.
   *           <li>若為 2 目空: 淨死或雙活 -> 盤末視為雙活.
   *           <li>方塊四: 穩死或雙活 -> 盤末視為雙活.
   *           <li>"三目", "T四", "刀五", "叉五", "魚六", "蝶七": 可補活. 盤末時, 對方不下, 自己又不補棋,
   *               表示不補即可殺對方某些子而淨活, 否則違反棋理; 但是對方被殺的棋子理應被人工拿掉, 故矛盾,
   *               故這些情況在盤末不會發生.
   *           <li>角上特例: "盤角曲四", "角方塊六", 等等: 可補活. 盤末時, 對方不下, 自己又不補棋,
   *               表示不補即可殺對方某些子而淨活, 否則違反棋理; 但是對方被殺的棋子理應被人工拿掉, 故矛盾,
   *               故這些情況在盤末不會發生.
   *           <li>條四, 蛇四, L四, 非刀五的五目, 非領帶六的六目, 非蝴蝶七的七目, 八目以上: 穩活 -> 有地
   *           <li>2 PossibleEyeBlocks -> 盤末時, 雙活雖然是有可能, 但是敵方需犧牲至少一子來破眼而造成假眼,
   *               犧牲一子在記地上有差一子, 故盤末人工取完死子後, 雙活的情況不該發生. 故視為活, 有地.
   *         </ul>
   *       </li>
   *       <li>3 PossibleEyeBlocks -> 盤末時, 雙活雖然是有可能, 但是敵方需犧牲至少二子來破眼而造成假眼,
   *           盤末不會發生. 故視為活, 有地.
   *       <li>4 or more PossibleEyeBlocks -> 活, 有地.
   *     </ul>
   *   </li>
   * </ul>
   *
   * <p>Handle counting end-game points for mutual live:
   * <pre>
   * China rule: who moving last might take the extra point.
   * Japan rule: does not count.
   * It is better to use Japan rule.
   * However, to make things easier, ignore counting points for mutual live.
   * </pre>
   *
   * @see EndGameTerritoryWithoutDeadAnalyzer
   */
  void countPoints();
}
