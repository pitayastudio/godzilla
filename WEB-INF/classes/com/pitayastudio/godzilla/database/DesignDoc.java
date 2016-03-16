package com.pitayastudio.godzilla.database;

import com.pitayastudio.godzilla.moveanalyzer.DingshiAnalyzer;

public interface DesignDoc {
  /**
   * Database creation:
   * <ul>
   *   <li>Used by BuJue DB, DingShi DB, GuanZi Pattern, Life-and-Death Pattern, ShouZin Pattern,
   *       Connect Pattern, DoorMove (門), Move of Sacrifice (棄子), move to expand/reduce influence,
   *       etc.
   *   <li>I have to create a tool to enter data.
   *   <li>Initially the score must be entered by myself.
   *   <li>Eventually Godzilla needs to know how to evaluate and verify scores.
   * </ul>
   */
  void databaseCreation();

  /**
   * Tables.
   *
   * <p>There are several sets of Move Tables: GuanZi, BuJue, DingShi.
   *
   * <pre>
   * MOVE:
   *
   * ID, int, PK
   * POS_X, short, NOT NULL
   * POS_Y, short, NOT NULL
   * CONDITION_ID, int, FK, NULL
   * SCORE, int, NULL
   * THREAT, int, NULL
   * STYLE, short, NULL
   *
   * PRE_NEXT_MOVE:
   *
   * PREV_MOVE_ID, int, PK
   * NEXT_MOVE_ID, int, PK
   *
   * CONDITION (we might not need this table):
   *
   * NAME, String
   * DESC, String
   *
   * Sample NAME of CONDITION:
   *
   * ZhengZi (ZZ) Good
   * left hand side has support
   * downward side has support
   * number of lines from the right wall
   * number of lines from the upper wall
   *
   * PATTERN:
   *
   * ID, int, PK
   * SIZE, short, 3-13
   * CONTENT, String, NOT NULL
   * LOCATION, String, {SIDE, CORNER, CENTER, ANY}
   * INNER_PATTERN_ID, int, NULL if SIZE=3; NOT NULL otherwise
   * ROT_NUM, byte, NOT NULL
   *
   * TODO 600 Is it necessary to use INNER_PATTERN_ID?
   * TODO 600 Is it necessary to use ROT_NUM?
   * Note: The color of the next move is always Black.
   * Maybe i can use tables PATTERN_IN, PATTERN_MID, and PATTERN_OUT
   * where PATTERN_IN and PATTERN_MID are searched by index/hash
   *   and PATTERM_OUT is searched by calculation/comparison.
   *
   * PATTERN_MOVE:
   *
   * PATTERN_ID, int, PK
   * MOVE_ID, int, PK
   * </pre>
   */
  void tables();

  /**
   * Pattern comparison:
   *
   * <p>Comparison Approach I:
   * <ul>
   *   <li>Board: B=100, W=010, V=001
   *   <li>Pattern: B-Must=100, W-Must=010, V-Must=001, BorW=110, BorV=101, WorV=011, Any=111
   *   <li>Match = Board AND Pattern
   *   <li>Result = Match_1st_digit OR Match_2nd_digit OR Match_3rd_digit
   * </ul>
   * <p>Comparison Approach I:
   * <ul>
   *   <li>Approach I needs to read each data and do the comparison and calculation.
   *       Approach II save all the variations of data in the database.
   *       Approach II doesn't need to do any calculation; it just need to compare the
   *       indexed/hashed CONTEXT.
   *   <li>Get the Posit of the current Move.
   *   <li>Get the 9 3x3 areas where the current Posit is located at
   *       (0,0), (0,1), (0,2), (1,0), (1,1), (1,2), (2,0), (2,1), and (2,2).
   *   <li>Get all the 3x3 areas within the Area where the current Posit belongs to.
   *   <li>There are about 20,000 possible variations for the 3x3 kind of area.
   *   <li>Search the 9 areas against the database.
   *   <li>Note: there is no need to calculate any rotations for the 9 areas,
   *       because all rotations of the same pattern are already stored in the database.
   *       Thus, the database size becomes 8-times bigger (only for the 3x3 data),
   *       but the performance is kept about the same.
   *   <li>Then search 5x5 which is based on 3x3.
   *   <li>Then search 7x7 which is based on 5x5.
   *   <li>and so on
   *   <li>Note: the pattern need not be a square 5x5.
   *   <li>Drawbacks:
   *     <ul>
   *       <li>the size of the DB might become 1,000 times bigger.
   *       <li>the last move must be within the central 3x3 area
   *     </ul>
   * </ul>
   */
  void patternComparision();

  /**
   * Dingshi database:
   *
   * <p>The 1st move is always in the upper-right corner.
   *
   * <p>I have to tell Godzilla the default style to use before a game starts.
   * The style could be dynamically changed during a game depending on the status.
   * Note that usually the style of this move is different from the style of the previous move.
   *
   * <p>size = 16x16 by ManyFaces 1993
   *
   * @see DingshiAnalyzer
   */
  void dingshiDatabase();

  /**
   * Misc.
   *
   * <p>8 Rotations of original Posit at (x, y):
   * #0(x, y), #1(-x, y), #2(x, -y), #3(-x, -y), #4(y, x), #5(-y, x), #6(y, -x), #7(-y, -x).
   *
   * <p>ManyFaces1993 has 500 8x8 patterns in the database.
   *
   * <p>In Handtalk (as of 1999), the size of pattern is not fixed, but not exceed the following
   * scope:
   * <pre>
   *  ...
   * .....
   * .......
   * ...*...
   * .......
   * .....
   *  ...
   * </pre>
   *
   * <p>Pattern Management in Wulu:
   * <pre>
   * A new scheme of pattern management was designed in Autumn of 1997 and used first in Wulu.
   * The patterns are represented by figures consisting of characters:
   * O = white stone,  X = black stone
   * o = white or empty,  x = black or empty
   * * = the center of the pattern
   * . = empty point,  space = any (don't care)
   * # = out of the go board
   * </pre>
   *
   * <p>TODO 700 是否可以取消 MOVE.SCORE 這個 column?
   * 而所有 SCORE 都由 Eval function 來決定. (or SCORE = GOOD or BAD)
   */
  void misc();
}
