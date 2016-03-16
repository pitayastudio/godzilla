
'use strict';

var myApp = angular.module('MyApp', [
  'ngRoute'
]);

myApp.controller('RootCtrl', godzilla.RootCtrl);
myApp.controller('GamePlayCtrl', godzilla.GamePlayCtrl);

myApp.path = {};
/** @type {string} */
myApp.path.NEW_GAME_SETUP = '/new_game_setup';
/** @type {string} */
myApp.path.GAME_PLAY = '/game_play';

myApp.config([
  '$routeProvider',
  // TODO 160 Don't use GamePlayCtrl twice.
  function($routeProvider) {
    $routeProvider.
        when(myApp.path.NEW_GAME_SETUP, {
          templateUrl: 'new_game_setup.html',
          controller: 'GamePlayCtrl'
        }).
        when(myApp.path.GAME_PLAY, {
          templateUrl: 'game_play.html',
          controller: 'GamePlayCtrl'
        }).
        when('/', {
          redirectTo: '/new_game_setup'
        }).
        otherwise({
          redirectTo: '/new_game_setup'
        });
  }
]);

myApp.directive('myGameSettings', function() {
  return {
    restrict: 'A',
    templateUrl: 'template/game_settings.html'
  };
});

myApp.directive('myGameStatusAndHistory', function() {
  return {
    restrict: 'A',
    templateUrl: 'template/game_status_and_history.html'
  };
});

myApp.directive('myGameControl', function() {
  return {
    restrict: 'A',
    templateUrl: 'template/game_control.html'
  };
});

myApp.directive('myBoard', function() {
  return {
    restrict: 'A',
    templateUrl: 'template/board.html'
  };
});

myApp.directive('myBoardSize19', function() {
  return {
    restrict: 'A',
    templateUrl: 'template/board_19.html'
  };
});

myApp.directive('myBoardSize13', function() {
  return {
    restrict: 'A',
    templateUrl: 'template/board_13.html'
  };
});

myApp.directive('myBoardSize9', function() {
  return {
    restrict: 'A',
    templateUrl: 'template/board_9.html'
  };
});

myApp.directive('myBoardSize5', function() {
  return {
    restrict: 'A',
    templateUrl: 'template/board_5.html'
  };
});

myApp.directive('myGameResult', function() {
  return {
    restrict: 'A',
    templateUrl: 'template/game_result.html'
  };
});
