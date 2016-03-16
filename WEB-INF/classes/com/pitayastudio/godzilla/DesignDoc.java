package com.pitayastudio.godzilla;

/**
 * Design doc:
 *
 * <ul>
 *   <li>model and model board
 *   <li>level - Control, Connect, Live
 *   <li>score system
 *   <li>jie
 *   <li>database
 *   <li>game phases
 *     <ul>
 *       <li>buju
 *       <li>dingshi Cf. Database
 *       <li>zhongpan
 *       <li>guanzi Cf. Move Generator and Database
 *   <li>time control
 *   <li>move analyzer
 *   <li>end game
 * </ul>
 */
public interface DesignDoc {
}

// TODO 050 Verify that MCTS picks the right answer in each iteration.
// TODO 100 Use Zobrist hash to detect super-ko. But it is not required here.
// TODO 150 Fix the issue that UNDO needs to be executed twice, otherwise, the computer-player
//      and human-player will be swapped.
// TODO 150 Avoid SemiRequired methods.
// TODO 150 Handle undo pick-up-dead.
// TODO 200 Utilize keywords "Area", "District", "Field", "Place", "Range", "Region",
//      "Scope", "Terrain", "Yard", "Zone", "Domain", "Kingdom", "Phylum", "Family", "Genus".
// TODO 200 Create a tool for generating tests inputBoard's.
// TODO 200 Research database - Buju and Dingshi
// TODO 200 Find testing cases from http://senseis.xmp.net/
//
// TODO 300 Create testing mechanism that utilizes local sgf files.
//
// TODO 400a handle 盤角曲四
// TODO 400a handle 盤角曲五
// TODO 400a handle 雙提
// TODO 400a handle 不提三目
// TODO 400a handle 黏最後一劫
// TODO 400a handle 假生
//
// TODO 500 Visualize and examine ConnectLevel. Can we replace it with the concept of Influence?
// TODO 500 Visualize and examine LiveLevel.
// TODO 500 Visualize and examine Scoring System
//
// TODO 600 patterns data input
// TODO 600 parameters (machine-learning) tune-up
// TODO 600 self-evaluation of patterns data input
// TODO 600 self-learning
