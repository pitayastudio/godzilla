
'use strict';

godzilla.RootCtrl = function($http, $location, $scope) {

  /** @type {godzilla.model.GameInfo} */
  $scope.gameInfo = {
    blackPlayer: 'human',
    whitePlayer: 'computer',
    boardSize: 5,
    // TODO 200 Implement gameInfo.gameName and gameDate.
    gameName: 'SomeGameName',
    gameDate: 'SomeGameDate',
    handicapCount: 0,
    komi: 6.5,
    timeLimitInMin: 25,
    timeCountdownInSec: 30,
    timeCountdownTimes: 5      
  };
  
  /** @type {godzilla.model.GameStatus} */
  $scope.gameStatus = {
    currentPlayStage: godzilla.constant.PLAY_STAGE_STARTED,
    blackDeadCount: 0,
    whiteDeadCount: 0,
    blackRemainingTimeMillis: 1500000,
    whiteRemainingTimeMillis: 1500000,
    blackRemainingCountdownTimes: 5,
    whiteRemainingCountdownTimes: 5
  };
  
  /** @type {godzilla.model.GameHistorySummary} */
  $scope.gameHistorySummary = {
    numberOfMoves: 0,
    colorForNextMove: godzilla.constant.COLOR_ENUM_BLACK,
    isLatestMovePass: false,
    // Initially, there is no latestMoveCoord.
  };
  
  /** @type {godzilla.model.GameResult} */
  $scope.gameResult = null;
  
  $scope.showInfoMessage = function(message, opt_src) {
    console.info(getFullMsg_(message, opt_src));
  };
 
  $scope.showWarningMessage = function(message, opt_src) {
    console.warn(getFullMsg_(message, opt_src));
  };
 
  $scope.showErrorMessage = function(message, opt_src) {
    console.error(getFullMsg_(message, opt_src));
  };

  var getFullMsg_ = function(message, opt_src) {
    var fullMsg = '';
    if (opt_src) {
      fullMsg += '[' + opt_src + '] ';
    }
    fullMsg += message;
    return fullMsg;
  };

  /** @type {string} */
  $scope.boardStringWithoutLineBreaks_ =
      '...................' +
      '...................' +
      '...................' +
      '...................' +
      '...................' +
      '...................' +
      '...................' +
      '...................' +
      '...................' +
      '...................' +
      '...................' +
      '...................' +
      '...................' +
      '...................' +
      '...................' +
      '...................' +
      '...................' +
      '...................' +
      '...................';
};
