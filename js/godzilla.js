
'use strict';

var godzilla = {};

/** @type {Object} */
godzilla.constant = {};

/** @type {string} */
godzilla.constant.SERVLET_PATH = 'HelloWorld';
/** @type {string} */
godzilla.constant.CMD_NEW_GAME = 'NEW_GAME';
/** @type {string} */
godzilla.constant.CMD_HUMAN_MOVE = 'HUMAN_MOVE';
/** @type {string} */
godzilla.constant.CMD_HUMAN_PASS = 'HUMAN_PASS';
/** @type {string} */
godzilla.constant.CMD_UNDO = 'UNDO';
/** @type {string} */
godzilla.constant.CMD_RESIGN = 'RESIGN';
/** @type {string} */
godzilla.constant.CMD_PICKUP_DEAD = 'PICKUP_DEAD';
/** @type {string} */
godzilla.constant.CMD_DONE_PICKUP_DEAD = 'DONE_PICKUP_DEAD';
/** @type {string} */
godzilla.constant.CMD_SAVE_END_GAME = 'SAVE_END_GAME';
/** @type {string} */
godzilla.constant.CMD_GEN_MOVE = 'GEN_MOVE';
/** @type {string} */
godzilla.constant.PLAY_STAGE_STARTED = 'PLAY_STAGE_STARTED';
/** @type {string} */
godzilla.constant.PLAY_STAGE_PICKUP_DEAD = 'PLAY_STAGE_PICKUP_DEAD';
/** @type {string} */
godzilla.constant.PLAY_STAGE_STOPPED = 'PLAY_STAGE_STOPPED';
/** @type {string} */
godzilla.constant.COLOR_CHAR_BLACK = 'X';
/** @type {string} */
godzilla.constant.COLOR_CHAR_WHITE = 'O';
/** @type {string} */
godzilla.constant.COLOR_CHAR_VACANT = '.';
/** @type {string} */
godzilla.constant.COLOR_ENUM_BLACK = 'B';
/** @type {string} */
godzilla.constant.COLOR_ENUM_WHITE = 'W';
/** @type {string} */
godzilla.constant.COLOR_LOWER_STRING_BLACK = 'black';
/** @type {string} */
godzilla.constant.COLOR_LOWER_STRING_WHITE = 'white';
/** @type {string} */
godzilla.constant.COLOR_LOWER_STRING_VACANT = 'vacant';

// Move types. These names must be consistent with those in MoveType.java.
/** @type {string} */
godzilla.constant.MOVE_PASS = 'MOVE_PASS';
/** @type {string} */
godzilla.constant.MOVE_ERROR_PREV_POSIT_IS_ALREADY_OCCUPIED =
    'MOVE_ERROR_PREV_POSIT_IS_ALREADY_OCCUPIED';
/** @type {string} */
godzilla.constant.MOVE_ERROR_JIE_VIOLATION = 'MOVE_ERROR_JIE_VIOLATION';
/** @type {string} */
godzilla.constant.MOVE_ERROR_SUICIDE = 'MOVE_ERROR_SUICIDE';
/** @type {string} */
godzilla.constant.MOVE_REGULAR = 'MOVE_REGULAR';
/** @type {string} */
godzilla.constant.MOVE_SELF_FILL_ONE_EYE_FOR_ONE_BUDDY_BLOCK =
    'MOVE_SELF_FILL_ONE_EYE_FOR_ONE_BUDDY_BLOCK';
/** @type {string} */
godzilla.constant.MOVE_EAT_NO_JIE = 'MOVE_EAT_NO_JIE';
/** @type {string} */
godzilla.constant.MOVE_EAT_CAUSING_JIE = 'MOVE_EAT_CAUSING_JIE';

/** @type {Object} */
godzilla.model = {};

/**
 * @typedef {{
 *   blackPlayer: string,
 *   whitePlayer: string,
 *   boardSize: number,
 *   gameName: string,
 *   gameDate: string,
 *   handicapCount: number,
 *   komi: number,
 *   timeLimitInMin: number,
 *   timeCountdownInSec: number,
 *   timeCountdownTimes: number
 * }}
 */
godzilla.model.GameInfo;

/**
 * @typedef {{
 *   currentPlayStage: string,
 *   blackDeadCount: number,
 *   whiteDeadCount: number,
 *   blackRemainingTimeMillis: number,
 *   whiteRemainingTimeMillis: number,
 *   blackRemainingCountdownTimes: number,
 *   whiteRemainingCountdownTimes: number
 * }}
 */
godzilla.model.GameStatus;

/**
 * @typedef {{
 *   numberOfMoves: number,
 *   colorForNextMove: string,
 *   isLatestMovePass: boolean,
 *   latestMoveCoord: Object
 * }}
 */
godzilla.model.GameHistorySummary;

/**
 * @typedef {{
 *   colorOfWinner: string,
 *   isResigned: boolean,
 *   blackDeadCount: number,
 *   whiteDeadCount: number,
 *   vacantTerritoryOfBlack: number,
 *   vacantTerritoryOfWhite: number,
 *   blackWinPoints: number
 * }}
 */
godzilla.model.GameResult;
