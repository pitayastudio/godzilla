package com.pitayastudio.godzilla;

import com.pitayastudio.godzilla.model.LotWithProperty;

public interface ArchivedDocs {

  /**
   * Update block-block neihoods:
   *
   * Blocks to be updated:
   * (1) Removed blocks:
   *   (1.1) vacantBlockThisOrig
   *   (1.2) veBlockBudWithThisAsQi
   * (2) Added blocks:
   *   (2.1) colorBlockThis
   *   (2.2) veVacantBlockSeparatedByThisPosit
   * (3) Changed blocks:
   *   (3.1) vacantBlockThisOrig's veBlockNeighBlack/REGULAR_WHITE
   *         (including dead/liveNeighborBlocksOfFoeColor, veBlockBudWithThisAsQi)
   *   (3.2) veBlockFoeNeighDead's veBlockNeighBlack/REGULAR_WHITE (Bud only)
   *   (3.3) veBlockBudWithThisAsQi's veBlockNeighVcnt/REGULAR_BLACK/REGULAR_WHITE (Foe only)
   */
  void updateLupBlockNeighborhood();

  /**
   * <p>Update Sub-{@link LotWithProperty}(s) and FalseEye for Base{@link LotWithProperty} via veColorBlock:
   *
   * <p>注意: 判斷 FalseEye 要從 ColorBlock 著手而不要從 VacantBlock 著手.
   * <ul>
   *   <li>清空 BrdStatus/Base{@link LotWithProperty} 中的所有 Sub-{@link LotWithProperty}(s)
   *   <li>依序對每個 colorBlockItr, 如果該 colorBlockItr 沒有屬於任一個 Sub{@link LotWithProperty},
   *       為其建一新的 Sub{@link LotWithProperty}, and recursively handle the Sub{@link LotWithProperty}.
   * </ul>
   *
   * <p>Recursively handle Sub{@link LotWithProperty}:<br>
   * 算算在 Base{@link LotWithProperty} 中, 該 Sub{@link LotWithProperty} 週遭的 non-FalseEye 的 ContactQi 總共有幾個:
   * <ul>
   *   <li>如果只剩零個的話, 表示到此為止, 不用多作處理.
   *   <li>如果有大於一個的話: do nothing
   *   <li>如果只剩一個的話:
   *     <ol>
   *       <li>該 ContactQi 就變成 FalseEye 了, 加進到 Sub{@link LotWithProperty}.
   *       <li>將週遭的 ColorBlocks 加進來:
   *         <ul>
   *           <li>若週遭的 ColorBlock 原本不屬於任一 Sub{@link LotWithProperty}: 加進來.
   *           <li>若週遭的 ColorBlock 原本屬於同一 Sub{@link LotWithProperty}: do nothing.
   *           <li>若週遭的 ColorBlock 原本屬於其他 Sub{@link LotWithProperty}: 把整個其他 Sub{@link LotWithProperty} 融進來.
   *         </ul>
   *       <li>若有新加進來的 ColorBlock 的話, recursively handle Sub{@link LotWithProperty}.
   *     </ol>
   * </ul>
   */
  void updateSubLotWithPropertiesAndFalseEye();

  /**
   * See {@link LotWithProperty}.
   *
   * AbsLive {@link LotWithProperty}(s):
   * <pre>
   * +------- +--------- +------ +------- +----------- +------
   * |.●.●○.. |.●.●.●○.. |.●.○.. |●●●.○.. |.●.●.●.●○.. |●.●○..
   * |●●.●○.. |.●..○●○.. |●.●○.. |●.●.○.. |●●●○●●●●○.. |.●●○..
   * |○○●●○.. |●●●●●●○.. |●●●○.. |.●.●○.. |○○○○○○○○... |●.●○..
   * |.○○○●.. |○○○○○○○.. |○○○... |.●●●○.. |........... |○●○●..
   * |....... |......... |...... |○○○○○.. |........... |○.○...
   * |....... |......... |...... |....... |........... |.○....
   *
   * TwoMoreMovesToDead {@link LotWithProperty}(s):
   *
   * +-------- +------- +------- +------- +--------
   * |....●○.. |..●●○.. |.●●●○.. |...●○.. |●...●○..
   * |●●●●●○.. |●..●○.. |...●○.. |.●●●○.. |●...●○..
   * |○○○○○... |●●●●○.. |●●●●○.. |.●○○... |●●●●●○..
   * |........ |○○○○○.. |○○○○○.. |●●○.... |○○○○○○..
   * |........ |....... |....... |○○..... |........
   * |........ |....... |....... |....... |........
   *
   * OneMoreMoveToLive {@link LotWithProperty}(s):
   *
   * +------- +------- +------- +------- +------- +------- +--------
   * |...●○.. |...●○.. |...●○.. |●.●●○.. |..●●○.. |..●●○.. |.●..●○..
   * |●●●●○.. |●.●●○.. |..●●○.. |...●○.. |...●○.. |...●○.. |●●●●○○..
   * |○○○○... |●●●○... |●●●○... |●.●●○.. |●.●●○.. |●..●○.. |○○○○●...
   * |....... |○○○○... |○○○.... |●●●○○.. |●●●○○.. |●●●●○.. |........
   * |....... |....... |....... |○○○○... |○○○○... |○○○○○.. |........
   * |....... |....... |....... |....... |....... |....... |........
   *
   * CornerOneMoreMoveToLive {@link LotWithProperty}(s):
   *
   * +------- +-------
   * |...●○.. |...●○..
   * |.●●●○.. |...●○..
   * |●●○○... |●●●●○..
   * |○○..... |○○○○○..
   * |....... |.......
   *
   * TwoMoreMovesToLive {@link LotWithProperty}(s):
   *
   * +------
   * |..●○..
   * |..●○..
   * |●●●○..
   * |○○○○..
   * |......
   *
   * ThreeMoreMovesToLive {@link LotWithProperty}(s):
   *
   * +------
   * |○.●○..
   * |○●●○..
   * |○.●○..
   * |●●●○..
   * |○○○...
   * |......
   *
   * AbsDead {@link LotWithProperty}(s):
   *
   * +------ +------ +-------
   * |.●○... |.●○... |..●○...
   * |○○○... |●●○... |●●●○...
   * |...... |○○.... |○○○....
   * |...... |...... |.......
   * |...... |...... |.......
   *
   * +------- +-------- +------------
   * |.●.●○.. |.●.●●○.. |.●.●..●.●○..
   * |●●●○○.. |●●●○.○.. |●●●○●●○●●○..
   * |○○○●... |○○○.○●.. |○○○○○○○○○...
   * |....... |........ |............
   *
   * Seki {@link LotWithProperty}(s):
   *
   * +------------+-------- +--------- +----------- +--------------
   * |●.●○.●○.○.. |.○●.●○.. |..○●.●○.. |.●.●.○.○●.. |.●.●..●.○.○●..
   * |●●●○.●○○○.. |○.●●●○.. |..○●.●○.. |●●●○○○○○●.. |●●●○●●○○○○○●..
   * |●.●○○●○.○.. |●●●○○... |○○○●●●○.. |○○○○○○○●●.. |○○○○○○○○○○○●..
   * |●●●●●○○○○.. |○○○..... |...●○○●.. |●●●●●●●○... |●●●●●●●●●●●○..
   * |........... |........ |●●●●○.... |........... |..............
   * |........... |........ |○○○○○.... |........... |..............
   * |........... |........ |......... |........... |..............
   * </pre>
   *
   * <p>Base{@link LotWithProperty} consists of Sub-{@link LotWithProperty}(s) and VacantBlocks.
   *
   * <p>The posits in vacantBlocks could be counted as territory,
   * but the vacant posits in Sub-{@link LotWithProperty}(s) are not counted because they are false eye's.
   *
   * <pre>
   * +-----
   * |.●...
   * |●.●..
   * |●●●..
   * |.....
   *
   * ........
   * ..●●●...
   * ..●.●...
   * ...●.●..
   * ...●●●..
   * ........
   *
   * ..............
   * ..●●●●.●●●●...
   * ..●..●●..●●...
   * ...●●..●●..●..
   * ...●●●●.●●●●..
   * ..............
   * </pre>
   *
   *
   *
   * <p>Sub{@link LotWithProperty} exists within Base{@link LotWithProperty}.
   * Two types:
   *
   * <p>(1) isPeriph - consisting of ColorBlocks and FalseEyes. Sample:
   * <pre>
   * +-------------
   * |.●.●..●.●.○..
   * |●●●○●●○●●.○..
   * |○○○○○○○○○○○..
   * |.............
   * </pre>
   * where all ● belong to the same Sub{@link LotWithProperty}.
   *
   * <p>(2) Not isPeriph. Sample:
   * <pre>
   * +------
   * |●.●○..
   * |.●●○..
   * |●.●○..
   * |○●○○..
   * |○.○○..
   * |○○○○..
   * |......
   * </pre>
   * where the upper-left black stone is not peripheral.
   */
  void baseLotWithProperties();

  /**
   * One difference between Japan rule and China rule about 雙活 at end game:
   * <ul>
   *   <li>Japan rule: no territory
   *   <li>China rule: half territory. The player who passes first might take an extra point.
   * </ul>
   */
  void sekiDifferenceBetweenJapanAndChinaRulesAtEndGame();
}
