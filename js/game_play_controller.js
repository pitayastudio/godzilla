
'use strict';


godzilla.GamePlayCtrl = function($http, $location, $scope) {

  var updateBoard_ = function(board) {
    console.log('in updateBoard_()');
    $scope.$parent.boardStringWithoutLineBreaks_ = board.replace(/\n/g, '');
  };

  $scope.latestMoveXPosition = null;
  $scope.latestMoveYPosition = null;
  
  $scope.newGame = function() {
    console.log('in newGame()');
    var data = {};
    var params = {
      cmd: godzilla.constant.CMD_NEW_GAME,
      blackPlayer: $scope.gameInfo.blackPlayer,
      whitePlayer: $scope.gameInfo.whitePlayer,
      boardSize: $scope.gameInfo.boardSize,
      gameName: $scope.gameInfo.gameName,
      gameDate: $scope.gameInfo.gameDate,
      handicapCount: $scope.gameInfo.handicapCount,
      komi: $scope.gameInfo.komi,
      timeLimitInMin: $scope.gameInfo.timeLimitInMin,
      timeCountdownInSec: $scope.gameInfo.timeCountdownInSec,
      timeCountdownTimes: $scope.gameInfo.timeCountdownTimes
    };
    var config = {
      params: params
    };
    $http.post(godzilla.constant.SERVLET_PATH, data, config).success(function(response) {
      console.log('response: %O', response);
      if (response.clientError != null) {
        $scope.showErrorMessage(response.clientError, godzilla.constant.CMD_NEW_GAME);
        return;
      }
      $scope.$parent.gameStatus = response.gameStatus;
      updateBoard_(response.board);
      $scope.$parent.gameHistorySummary = response.gameHistorySummary;
      $location.path(myApp.path.GAME_PLAY);
    }).error(function(data) {
      $scope.showErrorMessage(data, godzilla.constant.CMD_NEW_GAME);
    });
  };

  $scope.getBlackRemainingTimeString = function() {
    var allSec = Math.floor($scope.gameStatus.blackRemainingTimeMillis / 1000);
    var min = Math.floor(allSec / 60);
    var sec = allSec % 60;
    return min + ' min ' + sec + ' sec';
  };

  $scope.getWhiteRemainingTimeString = function() {
    var allSec = Math.floor($scope.gameStatus.whiteRemainingTimeMillis / 1000);
    var min = Math.floor(allSec / 60);
    var sec = allSec % 60;
    return min + ' min ' + sec + ' sec';
  };

  $scope.moveOrPickupDead = function(xPosition, yPosition) {
    console.log('in moveOrPickupDead() with xPosition=%d, yPosition=%d', xPosition, yPosition);

    var cmd = '';
    var humanMoveCount = 0;
    var colorOfThisPlayer = '';
    switch ($scope.$parent.gameStatus.currentPlayStage) {
      case godzilla.constant.PLAY_STAGE_STARTED:  // move
        cmd = godzilla.constant.CMD_HUMAN_MOVE;
        humanMoveCount = $scope.$parent.gameHistorySummary.numberOfMoves + 1;
        colorOfThisPlayer = $scope.$parent.gameHistorySummary.colorForNextMove;
        
        var data = {};
        var params = {
          cmd: cmd,
          humanMoveCount: humanMoveCount,
          xPosition: xPosition,
          yPosition: yPosition,
          colorOfThisPlayer: colorOfThisPlayer
        };
        var config = {
          params: params
        };
        $http.post(godzilla.constant.SERVLET_PATH, data, config).success(function(response) {
          if (response.clientError != null) {
            $scope.showErrorMessage(response.clientError, "moveOrPickupDead");
            return;
          }
          $scope.$parent.gameStatus = response.gameStatus;
          updateBoard_(response.board);
          $scope.$parent.gameHistorySummary = response.gameHistorySummary;
          var humanMoveType = response.humanMoveType;
          switch (humanMoveType) {
            case godzilla.constant.MOVE_ERROR_PREV_POSIT_IS_ALREADY_OCCUPIED:
              // fall through
            case godzilla.constant.MOVE_ERROR_JIE_VIOLATION:
              // fall through
            case godzilla.constant.MOVE_ERROR_SUICIDE:
              $scope.showWarningMessage('humanMoveType: ' + humanMoveType, 'moveOrPickupDead');
              break;
            case godzilla.constant.MOVE_PASS:
              $scope.showWarningMessage('humanMoveType: ' + humanMoveType, 'moveOrPickupDead');
              break;
            case godzilla.constant.MOVE_REGULAR:
              // fall through
            case godzilla.constant.MOVE_SELF_FILL_ONE_EYE_FOR_ONE_BUDDY_BLOCK:
              // fall through
            case godzilla.constant.MOVE_EAT_NO_JIE:
              // fall through
            case godzilla.constant.MOVE_EAT_CAUSING_JIE:
              $scope.showInfoMessage('humanMoveType: ' + humanMoveType, 'moveOrPickupDead');
              $scope.latestMoveXPosition = xPosition;
              $scope.latestMoveYPosition = yPosition;
              genComputerMove_();
              break;
            default:
              $scope.showErrorMessage('Invalid humanMoveType: ' + humanMoveType, 'moveOrPickupDead');
              break;
          }
        }).error(function(data) {
          $scope.showErrorMessage(data, 'moveOrPickupDead');
        });
        break;
      case godzilla.constant.PLAY_STAGE_PICKUP_DEAD:  // pickup dead
        cmd = godzilla.constant.CMD_PICKUP_DEAD;
        $scope.latestMoveXPosition = null;
        $scope.latestMoveyPosition = null;
        
        var data = {};
        var params = {
          cmd: cmd,
          xPosition: xPosition,
          yPosition: yPosition,
        };
        var config = {
          params: params
        };
        $http.post(godzilla.constant.SERVLET_PATH, data, config).success(function(response) {
          if (response.clientError != null) {
            $scope.showErrorMessage(response.clientError, "moveOrPickupDead");
            return;
          }
          $scope.$parent.gameStatus = response.gameStatus;
          updateBoard_(response.endGameBoard);
        }).error(function(data) {
          $scope.showErrorMessage(data, 'moveOrPickupDead');
        });

        break;
      case godzilla.constant.PLAY_STAGE_STOPPED:  // fall through
      default:
        console.warn('Invalid currentPlayStage: %s', $scope.$parent.gameStatus.currentPlayStage);
        break;
    }
  };
  
  var genComputerMove_ = function() {
    console.log('in genComputerMove_()');
    var colorOfThisPlayer = $scope.$parent.gameHistorySummary.colorForNextMove;
    var data = {};
    var params = {
      cmd: godzilla.constant.CMD_GEN_MOVE,
      colorOfThisPlayer: colorOfThisPlayer
    };
    var config = {
      params: params
    };
    $http.post(godzilla.constant.SERVLET_PATH, data, config).success(function(response) {
      console.log('in genComputerMove_.success() w/ response: %O', response);
      $scope.$parent.gameStatus = response.gameStatus;
      updateBoard_(response.board);
      
      var gameHistory = response.gameHistorySummary;
      $scope.$parent.gameHistorySummary = gameHistory;
      
      if (gameHistory.isLatestMovePass) {
        $scope.latestMoveXPosition = null;
        $scope.latestMoveYPosition = null;
      } else {
        var latestMoveCoord = gameHistory.latestMoveCoord;
        $scope.latestMoveXPosition = latestMoveCoord.xPosition;
        $scope.latestMoveYPosition = latestMoveCoord.yPosition;
      }
    }).error(function(data) {
      $scope.showErrorMessage(data, godzilla.constant.CMD_GEN_MOVE);
    });
  };

  /**
   * Used for determining CSS class.
   */
  $scope.getPositionState = function(xPosition, yPosition) {
    var boardSize = $scope.$parent.gameInfo.boardSize;
    var index = (boardSize - yPosition) * boardSize + xPosition - 1;
    var charAtIndex = $scope.$parent.boardStringWithoutLineBreaks_.charAt(index);
    var positionState;
    switch (charAtIndex) {
      case godzilla.constant.COLOR_CHAR_BLACK:
        positionState = godzilla.constant.COLOR_LOWER_STRING_BLACK;
        break;
      case godzilla.constant.COLOR_CHAR_WHITE:
        positionState = godzilla.constant.COLOR_LOWER_STRING_WHITE;
        break;
      case godzilla.constant.COLOR_CHAR_VACANT:
        positionState = godzilla.constant.COLOR_LOWER_STRING_VACANT;
        break;
      default:
        console.error('Invalid char[%s] at index=%d', charAtIndex, index);
        positionState = godzilla.constant.COLOR_LOWER_STRING_VACANT;
        break;
    }
    
    if ($scope.isLatestMove(xPosition, yPosition)) {
      positionState += '-is-latest-move'; 
    }
    
    return positionState;
  };

  $scope.isLatestMove = function(xPosition, yPosition) {
    return xPosition == $scope.latestMoveXPosition && yPosition == $scope.latestMoveYPosition;
  };

  $scope.pass = function() {
    console.log('in pass()');

    $scope.latestMoveXPosition = null;
    $scope.latestMoveYPosition = null;

    var colorOfThisPlayer = $scope.$parent.gameHistorySummary.colorForNextMove;
    var data = {};
    var params = {
      cmd: godzilla.constant.CMD_HUMAN_PASS,
      colorOfThisPlayer: colorOfThisPlayer
    };
    var config = {
      params: params
    };
    $http.post(godzilla.constant.SERVLET_PATH, data, config).success(function(response) {
      console.log('response: %O', response);
      if (response.clientError != null) {
        $scope.showErrorMessage(response.clientError, godzilla.constant.CMD_HUMAN_PASS);
        return;
      }
      
      $scope.$parent.gameStatus = response.gameStatus;
      var playStage = response.gameStatus.currentPlayStage;
      var gameHistory = response.gameHistorySummary;
      $scope.$parent.gameHistorySummary = gameHistory;

      // Update board. We only need to reset the latest move.
      $scope.latestMoveXPosition = null;
      $scope.latestMoveYPosition = null;
      
      if (playStage == godzilla.constant.PLAY_STAGE_STARTED) {
        genComputerMove_();
      } else if (playStage == godzilla.constant.PLAY_STAGE_PICKUP_DEAD) {
        // Do nothing.
      } else {
        console.warn('Invalid play stage for a pass move: ' + playStage);
      }
    }).error(function(data) {
      $scope.showErrorMessage(data, godzilla.constant.CMD_HUMAN_PASS);
    });
  };

  $scope.undo = function() {
    console.log('in undo()');
    var oldGameHistory = $scope.$parent.gameHistorySummary;
    var numberOfMoves = oldGameHistory.numberOfMoves;
    if (numberOfMoves < 1) {
      console.warn('Invalid UNDO for game history:%O', oldGameHistory);
      return;
    }

    var data = {};
    var params = {
      cmd: godzilla.constant.CMD_UNDO,
    };
    var config = {
      params: params
    };
    $http.post(godzilla.constant.SERVLET_PATH, data, config).success(function(response) {
      console.log('response: %O', response);
      if (response.clientError != null) {
        $scope.showErrorMessage(response.clientError, godzilla.constant.CMD_UNDO);
        return;
      }
      $scope.$parent.gameStatus = response.gameStatus;
      updateBoard_(response.board);
      var gameHistory = response.gameHistorySummary;
      $scope.$parent.gameHistorySummary = gameHistory;
      
      if (gameHistory.isLatestMovePass) {
        $scope.latestMoveXPosition = null;
        $scope.latestMoveYPosition = null;
      } else {
        var latestMoveCoord = gameHistory.latestMoveCoord;
        if (latestMoveCoord) {
          $scope.latestMoveXPosition = latestMoveCoord.xPosition;
          $scope.latestMoveYPosition = latestMoveCoord.yPosition;
        } else {
          $scope.latestMoveXPosition = null;
          $scope.latestMoveYPosition = null;
        }
      }
    }).error(function(data) {
      $scope.showErrorMessage(data, godzilla.constant.CMD_UNDO);
    });
  };

  $scope.resign = function() {
    console.log('in resign()');
    var oldGameHistory = $scope.$parent.gameHistorySummary;
    var colorOfThisPlayer = oldGameHistory.colorForNextMove;
    var data = {};
    var params = {
      cmd: godzilla.constant.CMD_RESIGN,
      colorOfThisPlayer: colorOfThisPlayer
    };
    var config = {
      params: params
    };
    $http.post(godzilla.constant.SERVLET_PATH, data, config).success(function(response) {
      console.log('response: %O', response);
      if (response.clientError != null) {
        $scope.showErrorMessage(response.clientError, godzilla.constant.CMD_RESIGN);
        return;
      }
      $scope.$parent.gameStatus = response.gameStatus;
      updateBoard_(response.board);
      $scope.$parent.gameResult = response.gameResult;
    }).error(function(data) {
      $scope.showErrorMessage(data, godzilla.constant.CMD_RESIGN);
    });
  };

  $scope.donePickupDead = function() {
    console.log('in donePickupDead()');
    var data = {};
    var params = {
      cmd: godzilla.constant.CMD_DONE_PICKUP_DEAD
    };
    var config = {
      params: params
    };
    $http.post(godzilla.constant.SERVLET_PATH, data, config).success(function(response) {
      console.log('response: %O', response);
      if (response.clientError != null) {
        $scope.showErrorMessage(response.clientError, godzilla.constant.CMD_DONE_PICKUP_DEAD);
        return;
      }
      $scope.$parent.gameStatus = response.gameStatus;
      updateBoard_(response.endGameBoard);
      $scope.$parent.gameResult = response.gameResult;
    }).error(function(data) {
      $scope.showErrorMessage(data, godzilla.constant.CMD_DONE_PICKUP_DEAD);
    });
  };

  $scope.saveEndGame = function() {
    console.log('in saveEndGame()');
    var data = {};
    var params = {
      cmd: godzilla.constant.CMD_SAVE_END_GAME
    };
    var config = {
      params: params
    };
    $http.post(godzilla.constant.SERVLET_PATH, data, config).success(function(response) {
      if (response.clientError != null) {
        $scope.showErrorMessage(response.clientError, godzilla.constant.CMD_SAVE_END_GAME);
        return;
      }
      var sgf = response.sgf;
      // Save SGF file locally.
      var hiddenAnchorElement = angular.element('<a/>');
      hiddenAnchorElement.attr({
        href: 'data:attachment/text;charset=utf-8,' + encodeURI(sgf),
        target: '_blank',
        download: 'SomeFilename.sgf'  // TODO 200 filename does not work for download in saveEndGame()
      })[0].click();
    }).error(function(data) {
      $scope.showErrorMessage(data, godzilla.constant.CMD_SAVE_END_GAME);
    });
  };
  
  $scope.isPlayStageStopped = function() {
    return $scope.gameStatus.currentPlayStage == godzilla.constant.PLAY_STAGE_STOPPED;
  };
};
