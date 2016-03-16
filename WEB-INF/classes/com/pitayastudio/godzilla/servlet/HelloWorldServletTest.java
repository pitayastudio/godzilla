package com.pitayastudio.godzilla.servlet;

import com.google.gson.JsonObject;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.MoveType;
import com.pitayastudio.godzilla.game.Command;
import com.pitayastudio.godzilla.game.GameCoordinator;
import com.pitayastudio.godzilla.game.GameInfo;
import com.pitayastudio.godzilla.game.GameStatus;
import com.pitayastudio.godzilla.game.PlayStage;
import com.pitayastudio.godzilla.modelboard.PositionStateBoard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HelloWorldServletTest {

  HelloWorldServlet servlet;

  @Before public void setUp() throws Exception {
    servlet = new HelloWorldServlet();
  }

  /**
   * Test method for {@link HelloWorldServlet#doGet}
   */
  @Test public final void testDoGet_noCommand() throws IOException, ServletException {
    HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
    servlet.doGet(request, response);
  }

  /**
   * Test method for {@link HelloWorldServlet#doGet}
   */
  @Test public final void testDoGet_commandFoo() throws IOException, ServletException {
    HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
    Mockito.when(request.getParameter(HelloWorldServlet.JSON_PROP_CMD)).thenReturn("FOO");
    try {
      servlet.doGet(request, response);
      Assert.fail();
    } catch (IllegalArgumentException expected) {
    }
  }

  /**
   * Test method for {@link HelloWorldServlet#doGet}
   */
  @Test public final void testDoGet_commandNewGame_humanVsComputer() throws Exception {
    // Prepare mocks.
    HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
    HttpSession httpSession = Mockito.mock(HttpSession.class);
    @SuppressWarnings("resource")
    PrintWriter printWriter = Mockito.mock(PrintWriter.class);

    Mockito.when(request.getParameter(HelloWorldServlet.JSON_PROP_CMD))
        .thenReturn(Command.NEW_GAME.toString());
    Mockito.when(request.getParameter(GameInfo.BLACK_PLAYER))
        .thenReturn(GameInfo.PLAYER_HUMAN);
    Mockito.when(request.getParameter(GameInfo.WHITE_PLAYER))
        .thenReturn(GameInfo.PLAYER_COMPUTER);
    Mockito.when(request.getParameter(GameInfo.BOARD_SIZE))
        .thenReturn("19");
    Mockito.when(request.getParameter(GameInfo.GAME_NAME))
        .thenReturn("some game name");
    Mockito.when(request.getParameter(GameInfo.GAME_DATE))
        .thenReturn("some game date");
    Mockito.when(request.getParameter(GameInfo.HANDICAP_COUNT))
        .thenReturn("0");
    Mockito.when(request.getParameter(GameInfo.KOMI))
        .thenReturn("6.5");
    Mockito.when(request.getParameter(GameInfo.TIME_LIMIT_IN_MIN))
        .thenReturn("30");
    Mockito.when(request.getParameter(GameInfo.TIME_COUNTDOWN_IN_SEC))
        .thenReturn("30");
    Mockito.when(request.getParameter(GameInfo.TIME_COUNTDOWN_TIMES))
        .thenReturn("5");
    Mockito.when(request.getSession(true))  // Returns the current session or a new session.
        .thenReturn(httpSession);
    Mockito.when(response.getWriter())
        .thenReturn(printWriter);

    // Execute
    servlet.doGet(request, response);

    // Verify
    ArgumentCaptor<String> argumentForResponse = ArgumentCaptor.forClass(String.class);
    Mockito.verify(printWriter).println(argumentForResponse.capture());
    String responseValue = argumentForResponse.getValue();
    //System.out.println("responseValue: " + responseValue);
    Assert.assertTrue(responseValue.contains(PlayStage.PLAY_STAGE_STARTED.toString()));
  }

  /**
   * Test method for {@link HelloWorldServlet#doGet}
   */
  @Test public final void testDoGet_commandNewGame_computerVsHuman() throws Exception {
    // Prepare mocks.
    HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
    HttpSession httpSession = Mockito.mock(HttpSession.class);
    @SuppressWarnings("resource")
    PrintWriter printWriter = Mockito.mock(PrintWriter.class);

    Mockito.when(request.getParameter(HelloWorldServlet.JSON_PROP_CMD))
        .thenReturn(Command.NEW_GAME.toString());
    Mockito.when(request.getParameter(GameInfo.BLACK_PLAYER))
        .thenReturn(GameInfo.PLAYER_COMPUTER);
    Mockito.when(request.getParameter(GameInfo.WHITE_PLAYER))
        .thenReturn(GameInfo.PLAYER_HUMAN);
    Mockito.when(request.getParameter(GameInfo.BOARD_SIZE))
        .thenReturn("19");
    Mockito.when(request.getParameter(GameInfo.GAME_NAME))
        .thenReturn("some game name");
    Mockito.when(request.getParameter(GameInfo.GAME_DATE))
        .thenReturn("some game date");
    Mockito.when(request.getParameter(GameInfo.HANDICAP_COUNT))
        .thenReturn("0");
    Mockito.when(request.getParameter(GameInfo.KOMI))
        .thenReturn("6.5");
    Mockito.when(request.getParameter(GameInfo.TIME_LIMIT_IN_MIN))
        .thenReturn("30");
    Mockito.when(request.getParameter(GameInfo.TIME_COUNTDOWN_IN_SEC))
        .thenReturn("30");
    Mockito.when(request.getParameter(GameInfo.TIME_COUNTDOWN_TIMES))
        .thenReturn("5");
    Mockito.when(request.getSession(true))  // Returns the current session or a new session.
        .thenReturn(httpSession);
    Mockito.when(response.getWriter())
        .thenReturn(printWriter);

    // Execute
    servlet.doGet(request, response);

    // Verify
    ArgumentCaptor<String> argumentForResponse = ArgumentCaptor.forClass(String.class);
    Mockito.verify(printWriter).println(argumentForResponse.capture());
    String responseValue = argumentForResponse.getValue();
    //System.out.println("responseValue: " + responseValue);
    Assert.assertTrue(responseValue.contains(PlayStage.PLAY_STAGE_STARTED.toString()));
  }


  /**
   * Test method for {@link HelloWorldServlet#doGet}
   */
  @Test public final void testDoGet_commandHumanMove() throws Exception {
    // Prepare mocks.
    HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

    Mockito.when(request.getParameter(HelloWorldServlet.JSON_PROP_CMD))
        .thenReturn(Command.HUMAN_MOVE.toString());
    Mockito.when(request.getParameter(HelloWorldServlet.REQ_PARAM_HUMAN_MOVE_COUNT))
        .thenReturn("1");
    Mockito.when(request.getParameter(HelloWorldServlet.REQ_PARAM_X_POSITION))
        .thenReturn("3");
    Mockito.when(request.getParameter(HelloWorldServlet.REQ_PARAM_Y_POSITION))
        .thenReturn("3");
    Mockito.when(request.getParameter(HelloWorldServlet.REQ_PARAM_COLOR_OF_THIS_PLAYER))
        .thenReturn(Color.B.toString());
    HttpSession httpSession = Mockito.mock(HttpSession.class);
    Mockito.when(request.getSession(false))  // Returns the current session or null.
        .thenReturn(httpSession);
    GameCoordinator gameCoordinator = Mockito.mock(GameCoordinator.class);
    Mockito.when(httpSession.getAttribute(HelloWorldServlet.SESSION_ATTR_GAME_RECORDER))
        .thenReturn(gameCoordinator);
    Mockito.when(gameCoordinator.handleHumanMoveAtCoord(Color.B ,3, 3))
        .thenReturn(MoveType.MOVE_REGULAR);
    JsonObject historyJson = new JsonObject();
    historyJson.addProperty("historyFoo", "bar");
    Mockito.when(gameCoordinator.getGameHistorySummaryJsonObject())
        .thenReturn(historyJson);
    GameStatus gameStatus = Mockito.mock(GameStatus.class);
    Mockito.when(gameCoordinator.getMutableGameStatus())
        .thenReturn(gameStatus);
    Mockito.when(gameStatus.getCurrentPlayStage())
        .thenReturn(PlayStage.PLAY_STAGE_STARTED);
    JsonObject statusJson = new JsonObject();
    statusJson.addProperty("statusFoo", "bar");
    Mockito.when(gameStatus.toJsonObject())
        .thenReturn(statusJson);
    PositionStateBoard positionStateBoard = Mockito.mock(PositionStateBoard.class);
    Mockito.when(gameCoordinator.getCurrentPositionStateBoard())
        .thenReturn(positionStateBoard);
    Mockito.when(positionStateBoard.toAsciiString())
        .thenReturn("boardFoo");
    @SuppressWarnings("resource")
    PrintWriter printWriter = Mockito.mock(PrintWriter.class);
    Mockito.when(response.getWriter())
        .thenReturn(printWriter);

    // Execute
    servlet.doGet(request, response);

    // Verify
    ArgumentCaptor<String> argumentForResponse = ArgumentCaptor.forClass(String.class);
    Mockito.verify(printWriter).println(argumentForResponse.capture());
    String responseValue = argumentForResponse.getValue();
    //System.out.println("responseValue: " + responseValue);
    Assert.assertTrue(responseValue.contains(MoveType.MOVE_REGULAR.toString()));
    Assert.assertTrue(responseValue.contains("historyFoo"));
    Assert.assertTrue(responseValue.contains("statusFoo"));
    Assert.assertTrue(responseValue.contains("boardFoo"));
  }
}
