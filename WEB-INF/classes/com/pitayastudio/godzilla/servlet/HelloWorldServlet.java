package com.pitayastudio.godzilla.servlet;

import com.google.common.annotations.VisibleForTesting;
import com.google.gson.JsonObject;
import com.google.inject.Singleton;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.Flags;
import com.pitayastudio.godzilla.common.MoveType;
import com.pitayastudio.godzilla.game.Command;
import com.pitayastudio.godzilla.game.GameCoordinator;
import com.pitayastudio.godzilla.game.GameInfo;
import com.pitayastudio.godzilla.game.PlayStage;
import com.pitayastudio.godzilla.sgf.SgfWriter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Singleton
public class HelloWorldServlet extends HttpServlet {
  private static final Logger logger = Logger.getLogger(HelloWorldServlet.class.getName());
  private static final long serialVersionUID = 1L;

  @VisibleForTesting static final String REQ_PARAM_X_POSITION = "xPosition";
  @VisibleForTesting static final String REQ_PARAM_Y_POSITION = "yPosition";
  @VisibleForTesting static final String REQ_PARAM_HUMAN_MOVE_COUNT = "humanMoveCount";
  @VisibleForTesting static final String REQ_PARAM_COLOR_OF_THIS_PLAYER = "colorOfThisPlayer";

  @VisibleForTesting static final String JSON_PROP_CMD = "cmd";
  @VisibleForTesting static final String JSON_PROP_X_POSITION = REQ_PARAM_X_POSITION;
  @VisibleForTesting static final String JSON_PROP_Y_POSITION = REQ_PARAM_Y_POSITION;
  @VisibleForTesting static final String JSON_PROP_HUMAN_MOVE_TYPE = "humanMoveType";
  @VisibleForTesting static final String JSON_PROP_BOARD = "board";
  @VisibleForTesting static final String JSON_PROP_END_GAME_BOARD = "endGameBoard";
  @VisibleForTesting static final String JSON_PROP_SGF = "sgf";
  @VisibleForTesting static final String JSON_PROP_CLIENT_ERROR = "clientError";

  @VisibleForTesting static final String JSON_OBJECT_GAME_STATUS = "gameStatus";
  @VisibleForTesting static final String JSON_OBJECT_GAME_HISTORY_SUMMARY = "gameHistorySummary";
  @VisibleForTesting static final String JSON_OBJECT_GAME_RESULT = "gameResult";

  @VisibleForTesting static final String SESSION_ATTR_GAME_RECORDER = "game_recorder";

  @Override public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    response.setContentType("application/json");
    // For cross-domain access.
    //response.addHeader("Access-Control-Allow-Origin", "*");

    // Handle command.
    String commandString = request.getParameter(JSON_PROP_CMD);
    logger.fine("command: " + commandString);
    if (commandString == null) {
      return;
    }
    Command command = Command.valueOf(commandString);

    String jsonResponse = null;
    switch (command) {
      case NEW_GAME:
        jsonResponse = handleNewGame(request);
        break;
      case HUMAN_MOVE:
        jsonResponse = handleHumanMove(request);
        break;
      case HUMAN_PASS:
        jsonResponse = handleHumanPass(request);
        break;
      case UNDO:
        jsonResponse = handleUndo(request);
        break;
      case RESIGN:
        jsonResponse = handleResign(request);
        break;
      case PICKUP_DEAD:
        jsonResponse = handlePickupDead(request);
        break;
      case DONE_PICKUP_DEAD:
        jsonResponse = handleDonePickupDead(request);
        break;
      case SAVE_END_GAME:
        jsonResponse = handleSaveEndGame(request);
        break;
      case GEN_MOVE:
        jsonResponse = handleGenComputerMoveTakingLongTime(request);
        break;
      default:
        logger.severe("Invalid command: " + commandString);
        break;
    }
    //logger.info("jsonResponse:\n" + jsonResponse);
    try (
      PrintWriter out = response.getWriter();
    ) {
      out.println(jsonResponse);
    }
  }

  @Override public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    doGet(request, response);
  }

  private static String createErrorJson(String errorMessage) {
    JsonObject responseJson = new JsonObject();
    responseJson.addProperty(JSON_PROP_CLIENT_ERROR, errorMessage);
    return responseJson.toString();
  }

  private static JsonObject createResponseJson(GameCoordinator gameCoordinator) {
    JsonObject responseJson = new JsonObject();
    responseJson.add(JSON_OBJECT_GAME_HISTORY_SUMMARY,
        gameCoordinator.getGameHistorySummaryJsonObject());
    responseJson.add(JSON_OBJECT_GAME_STATUS,
        gameCoordinator.getMutableGameStatus().toJsonObject());
    responseJson.addProperty(JSON_PROP_BOARD,
        gameCoordinator.getCurrentPositionStateBoard().toAsciiString());
    return responseJson;
  }

  private static String handleNewGame(HttpServletRequest request) {
    //logger.info("in handleNewGame with request: " + request);

    // Prepare new game info.
    // The values of black/whitePlayer could be GameInfo#PLAYER_HUMAN or GameInfo#PLAYER_COMPUTER.
    String blackPlayer = request.getParameter(GameInfo.BLACK_PLAYER);
    String whitePlayer = request.getParameter(GameInfo.WHITE_PLAYER);
    String boardSizeString = request.getParameter(GameInfo.BOARD_SIZE);
    int boardSize = Integer.parseInt(boardSizeString);
    String gameName = request.getParameter(GameInfo.GAME_NAME);
    String gameDate = request.getParameter(GameInfo.GAME_DATE);
    String handicapCountString = request.getParameter(GameInfo.HANDICAP_COUNT);
    int handicapCount = Integer.parseInt(handicapCountString);
    String komiString = request.getParameter(GameInfo.KOMI);
    double komi = Double.parseDouble(komiString);
    String timeLimitInMinString = request.getParameter(GameInfo.TIME_LIMIT_IN_MIN);
    int timeLimitInMin = Integer.parseInt(timeLimitInMinString);
    String timeCountdownInSecString = request.getParameter(GameInfo.TIME_COUNTDOWN_IN_SEC);
    int timeCountdownInSec = Integer.parseInt(timeCountdownInSecString);
    String timeCountdownTimesString = request.getParameter(GameInfo.TIME_COUNTDOWN_TIMES);
    int timeCountdownTimes = Integer.parseInt(timeCountdownTimesString);
    GameInfo gameInfo = GameInfo.newBuilder()
        .setBlackPlayer(blackPlayer)
        .setWhitePlayer(whitePlayer)
        .setRequiredBoardSize(boardSize)
        .setGameName(gameName)
        .setGameDate(gameDate)
        .setHandicapCount(handicapCount)
        .setKomi(komi)
        .setRequiredTimeLimitInMin(timeLimitInMin)
        .setTimeCountdownInSec(timeCountdownInSec)
        .setTimeCountdownTimes(timeCountdownTimes)
        .build();
    //logger.info("gameInfo:\n" + gameInfo);

    // Setup game coordinator.
    GameCoordinator gameCoordinator = new GameCoordinator(gameInfo, Flags.MOVE_ENGINE_TYPE);
    HttpSession session = request.getSession(true);
    //logger.info("session.isNew: " + session.isNew());
    session.setAttribute(SESSION_ATTR_GAME_RECORDER, gameCoordinator);
    // Start game.
    gameCoordinator.startGame();

    if (GameInfo.PLAYER_HUMAN.equals(blackPlayer)
        && GameInfo.PLAYER_COMPUTER.equals(whitePlayer)) {
      JsonObject responseJson = createResponseJson(gameCoordinator);
      return responseJson.toString();
    } else if (GameInfo.PLAYER_COMPUTER.equals(blackPlayer)
        && GameInfo.PLAYER_HUMAN.equals(whitePlayer)) {
      // If black is computer, ask computer to calculate first move.
      gameCoordinator.askComputerToGenNextMoveTakingLongTime(Color.B);
      JsonObject responseJson = createResponseJson(gameCoordinator);
      return responseJson.toString();
    } else {
      return createErrorJson("Players combination is not supported");
    }
  }

  private static String handleHumanMove(HttpServletRequest request) {
    // Get game coordinator.
    GameCoordinator gameCoordinator = retrieveGameCoordinator(request);
    // Verify PlayStage.
    PlayStage playStage = gameCoordinator.getMutableGameStatus().getCurrentPlayStage();
    if (playStage != PlayStage.PLAY_STAGE_STARTED) {
      return createErrorJson("PlayStage=" + playStage.toString() + " is not for HUMAN_MOVE.");
    }

    // Get parameters.
    String colorOfThisPlayerString = request.getParameter(REQ_PARAM_COLOR_OF_THIS_PLAYER);
    Color colorOfThisPlayer = Color.valueOf(colorOfThisPlayerString);
    String xPositionString = request.getParameter(REQ_PARAM_X_POSITION);
    int xPosition = Integer.parseInt(xPositionString);
    String yPositionString = request.getParameter(REQ_PARAM_Y_POSITION);
    int yPosition = Integer.parseInt(yPositionString);

    // Handle human move.
    MoveType humanMoveType =
        gameCoordinator.handleHumanMoveAtCoord(colorOfThisPlayer, xPosition, yPosition);

    // Asking computer to move is better to be handled in a separate action.
    // Benefit:
    //     The code is cleaner.
    //     I don't have to write code with infinite loop to wait for result.

    // Construct response json object.
    JsonObject responseJson = createResponseJson(gameCoordinator);
    responseJson.addProperty(JSON_PROP_HUMAN_MOVE_TYPE, humanMoveType.toString());
    return responseJson.toString();
  }

  private static String handleHumanPass(HttpServletRequest request) {
    GameCoordinator gameCoordinator = retrieveGameCoordinator(request);
    // Verify PlayStage.
    PlayStage playStage = gameCoordinator.getMutableGameStatus().getCurrentPlayStage();
    if (playStage != PlayStage.PLAY_STAGE_STARTED) {
      return createErrorJson("PlayStage=" + playStage.toString() + " is not for PASS.");
    }

    // Get parameters.
    String colorOfThisPlayerString = request.getParameter(REQ_PARAM_COLOR_OF_THIS_PLAYER);
    Color colorOfThisPlayer = Color.valueOf(colorOfThisPlayerString);

    gameCoordinator.handleHumanPassMove(colorOfThisPlayer);

    // Construct response json object.
    JsonObject responseJson = createResponseJson(gameCoordinator);
    return responseJson.toString();
  }

  private static String handleUndo(HttpServletRequest request) {
    GameCoordinator gameCoordinator = retrieveGameCoordinator(request);
    // Verify PlayStage.
    PlayStage playStage = gameCoordinator.getMutableGameStatus().getCurrentPlayStage();
    if (playStage != PlayStage.PLAY_STAGE_STARTED) {
      return createErrorJson("PlayStage=" + playStage.toString() + " is not for UNDO.");
    }

    gameCoordinator.handleUndoMove();

    // Construct response json object.
    JsonObject responseJson = createResponseJson(gameCoordinator);
    return responseJson.toString();
  }

  private static String handleResign(HttpServletRequest request) {
    GameCoordinator gameCoordinator = retrieveGameCoordinator(request);
    // PlayStage could be any for RESIGN, so no need to check it.

    // Get parameters.
    String colorOfThisPlayerString = request.getParameter(REQ_PARAM_COLOR_OF_THIS_PLAYER);
    Color colorOfThisPlayer = Color.valueOf(colorOfThisPlayerString);

    gameCoordinator.handleResign(colorOfThisPlayer);

    // Construct response json object.
    JsonObject responseJson = createResponseJson(gameCoordinator);
    responseJson.add(JSON_OBJECT_GAME_RESULT, gameCoordinator.getGameResult().toJsonObject());
    return responseJson.toString();
  }

  private static String handlePickupDead(HttpServletRequest request) {
    GameCoordinator gameCoordinator = retrieveGameCoordinator(request);
    // Verify PlayStage.
    PlayStage playStage = gameCoordinator.getMutableGameStatus().getCurrentPlayStage();
    if (playStage != PlayStage.PLAY_STAGE_PICKUP_DEAD) {
      return createErrorJson("PlayStage=" + playStage.toString() + " is not for PICKUP_DEAD.");
    }

    // Get parameters.
    String xPositionString = request.getParameter(REQ_PARAM_X_POSITION);
    int xPosition = Integer.parseInt(xPositionString);
    String yPositionString = request.getParameter(REQ_PARAM_Y_POSITION);
    int yPosition = Integer.parseInt(yPositionString);

    gameCoordinator.handlePickupDeadBlockAtCoord(xPosition, yPosition);

    // Construct response json object.
    JsonObject responseJson = createResponseJson(gameCoordinator);
    responseJson.addProperty(JSON_PROP_END_GAME_BOARD,
        gameCoordinator.getEndGameBlockBoard().getPositionStateBoard().toAsciiString());
    return responseJson.toString();
  }

  private static String handleDonePickupDead(HttpServletRequest request) {
    GameCoordinator gameCoordinator = retrieveGameCoordinator(request);
    // Verify PlayStage.
    PlayStage playStage = gameCoordinator.getMutableGameStatus().getCurrentPlayStage();
    if (playStage != PlayStage.PLAY_STAGE_PICKUP_DEAD) {
      return createErrorJson("PlayStage=" + playStage.toString() + " is not for DONE_PICKUP_DEAD.");
    }

    gameCoordinator.handleDoneOfPickupDeadStones();

    // Construct response json object.
    JsonObject responseJson = createResponseJson(gameCoordinator);
    responseJson.addProperty(JSON_PROP_END_GAME_BOARD,
        gameCoordinator.getEndGameBlockBoard().getPositionStateBoard().toAsciiString());
    responseJson.add(JSON_OBJECT_GAME_RESULT, gameCoordinator.getGameResult().toJsonObject());
    return responseJson.toString();
  }

  private static String handleSaveEndGame(HttpServletRequest request) {
    GameCoordinator gameCoordinator = retrieveGameCoordinator(request);
    // Verify PlayStage.
    PlayStage playStage = gameCoordinator.getMutableGameStatus().getCurrentPlayStage();
    if (playStage != PlayStage.PLAY_STAGE_STOPPED) {
      return createErrorJson("PlayStage=" + playStage.toString() + " is not for SAVE_END_GAME.");
    }

    SgfWriter sgfWriter = new SgfWriter(gameCoordinator);

    // Construct response json object.
    JsonObject responseJson = createResponseJson(gameCoordinator);
    responseJson.addProperty(JSON_PROP_SGF, sgfWriter.toString());
    return responseJson.toString();
  }

  private static String handleGenComputerMoveTakingLongTime(HttpServletRequest request) {
    GameCoordinator gameCoordinator = retrieveGameCoordinator(request);
    // Verify PlayStage.
    PlayStage playStage = gameCoordinator.getMutableGameStatus().getCurrentPlayStage();
    if (playStage != PlayStage.PLAY_STAGE_STARTED) {
      return createErrorJson("PlayStage=" + playStage.toString() + " is not for GEN_MOVE.");
    }

    // Get parameters.
    String colorOfThisPlayerString = request.getParameter(REQ_PARAM_COLOR_OF_THIS_PLAYER);
    Color colorOfThisPlayer = Color.valueOf(colorOfThisPlayerString);

    gameCoordinator.askComputerToGenNextMoveTakingLongTime(colorOfThisPlayer);

    // Construct response json object.
    JsonObject responseJson = createResponseJson(gameCoordinator);
    return responseJson.toString();
  }

  @VisibleForTesting static GameCoordinator retrieveGameCoordinator(HttpServletRequest request) {
    HttpSession session = request.getSession(false);
    if (session == null) {
      throw new IllegalStateException("Session is null.");
    }
    GameCoordinator gameCoordinator =
        (GameCoordinator) session.getAttribute(SESSION_ATTR_GAME_RECORDER);
    return gameCoordinator;
  }
}
