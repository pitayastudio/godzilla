package com.pitayastudio.godzilla.game;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.Constants;
import com.pitayastudio.godzilla.common.MoveType;
import com.pitayastudio.godzilla.computerplayer.MoveEngine;
import com.pitayastudio.godzilla.computerplayer.MoveHandling;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.modelboard.BlockBoard;
import com.pitayastudio.godzilla.modelboard.CoordBoard;

import junit.framework.TestCase;

import org.junit.Test;

public class GameCoordinatorTest extends TestCase {

  GameCoordinator gameCoordinator;
  CoordBoard coordBoard;

  private void prepare(MoveEngine.Type moveEngineType) {
    int boardSize = 5;
    GameInfo gameInfo = GameInfo.newBuilder()
        .setBlackPlayer("black player")
        .setWhitePlayer("white player")
        .setRequiredBoardSize(boardSize)
        .setGameName("Godzilla Game")
        .setGameDate("N/A")
        .setHandicapCount(0)
        .setKomi(Constants.DEFAULT_KOMI)
        .setRequiredTimeLimitInMin(Constants.DEFAULT_MAX_GAME_TIME_IN_MIN)
        .build();
    gameCoordinator = new GameCoordinator(gameInfo, moveEngineType);
    gameCoordinator.startGame();
    coordBoard = gameCoordinator.getCoordBoard();
  }

  /**
   * Tests {@link GameCoordinator#startGame()}.
   */
  @Test public void testStartGame_randomMoveEngineType() {
    testStartGame(MoveEngine.Type.RANDOM);
  }
  @Test public void testStartGame_mcts2MoveEngineType() {
    testStartGame(MoveEngine.Type.MCTS);
  }
  private void testStartGame(MoveEngine.Type moveEngineType) {
    prepare(moveEngineType);
    assertEquals(PlayStage.PLAY_STAGE_STARTED, gameCoordinator.getPlayStage());
  }

  /**
   * Tests {@link GameCoordinator#handleHumanMoveAtCoord}.
   */
  @Test public void testHandleHumanMoveAtCoord_randomMoveEngineType() {
    testHandleHumanMoveAtCoord(MoveEngine.Type.RANDOM);
  }
  @Test public void testHandleHumanMoveAtCoord_mcts2MoveEngineType() {
    testHandleHumanMoveAtCoord(MoveEngine.Type.MCTS);
  }
  private void testHandleHumanMoveAtCoord(MoveEngine.Type moveEngineType) {
    prepare(moveEngineType);
    assertEquals(Color.B, gameCoordinator.findColorForNextMove());
    MoveType moveType = gameCoordinator.handleHumanMoveAtCoord(Color.B, 4, 4);

    assertEquals(MoveType.MOVE_REGULAR, moveType);
    assertEquals(Color.W, gameCoordinator.findColorForNextMove());
    assertEquals(0, gameCoordinator.getDeadCountForColor(Color.B));
    assertEquals(0, gameCoordinator.getDeadCountForColor(Color.W));
    assertEquals(PlayStage.PLAY_STAGE_STARTED, gameCoordinator.getPlayStage());
    assertEquals(1, gameCoordinator.findNumberOfMoves());
  }

  /**
   * Tests {@link GameCoordinator#handleHumanMoveAtCoord}.
   */
  @Test public void testHandleHumanMoveAtCoord_errorPrevPositIsAlreadyOccupied_randomMoveEngineType() {
    testHandleHumanMoveAtCoord_errorPrevPositIsAlreadyOccupied(MoveEngine.Type.RANDOM);
  }
  @Test public void testHandleHumanMoveAtCoord_errorPrevPositIsAlreadyOccupied_mcts2MoveEngineType() {
    testHandleHumanMoveAtCoord_errorPrevPositIsAlreadyOccupied(MoveEngine.Type.MCTS);
  }
  private void testHandleHumanMoveAtCoord_errorPrevPositIsAlreadyOccupied(MoveEngine.Type moveEngineType) {
    prepare(moveEngineType);
    MoveType moveType = gameCoordinator.handleHumanMoveAtCoord(Color.B, 4, 4);
    assertEquals(MoveType.MOVE_REGULAR, moveType);

    moveType = gameCoordinator.handleHumanMoveAtCoord(Color.W, 4, 4);
    assertEquals(MoveType.MOVE_ERROR_PREV_POSIT_IS_ALREADY_OCCUPIED, moveType);
  }

  /**
   * Tests {@link GameCoordinator#handleHumanMoveAtCoord}.
   *
   * <p>Board:
   * <pre>
   * .....
   * ..X..
   * .X.X.
   * ..X..
   * .OOO.
   * </pre>
   * (2, 2) is suicide for white.
   */
  @Test public void testHandleHumanMoveAtCoord_errorSuicide_randomMoveEngineType() {
    testHandleHumanMoveAtCoord_errorSuicide(MoveEngine.Type.RANDOM);
  }
  @Test public void testHandleHumanMoveAtCoord_errorSuicide_mcts2MoveEngineType() {
    testHandleHumanMoveAtCoord_errorSuicide(MoveEngine.Type.MCTS);
  }
  private void testHandleHumanMoveAtCoord_errorSuicide(MoveEngine.Type moveEngineType) {
    prepare(moveEngineType);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,2, 3);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,2, 1);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,3, 2);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,3, 1);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,3, 4);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,4, 1);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,4, 3);
    MoveType moveType = gameCoordinator.handleHumanMoveAtCoord(Color.W ,3, 3);
    assertEquals(MoveType.MOVE_ERROR_SUICIDE, moveType);
  }

  /**
   * Tests {@link GameCoordinator#handleHumanMoveAtCoord}.
   *
   * <p>Board:
   * <pre>
   * .....
   * .....
   * .XO..
   * XO.O.
   * .XO..
   * </pre>
   * (2, 1) is jie-violation for black.
   */
  @Test public void testHandleHumanMoveAtCoord_jie_randomMoveEngineType() {
    testHandleHumanMoveAtCoord_jie(MoveEngine.Type.RANDOM);
  }
  @Test public void testHandleHumanMoveAtCoord_jie_mcts2MoveEngineType() {
    testHandleHumanMoveAtCoord_jie(MoveEngine.Type.MCTS);
  }
  private void testHandleHumanMoveAtCoord_jie(MoveEngine.Type moveEngineType) {
    prepare(moveEngineType);
    MoveType moveType;
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,3, 2);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,4, 2);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,2, 1);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,3, 1);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,2, 3);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,3, 3);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,1, 2);
    moveType = gameCoordinator.handleHumanMoveAtCoord(Color.W ,2, 2);
    assertEquals(MoveType.MOVE_EAT_CAUSING_JIE, moveType);
    moveType = gameCoordinator.handleHumanMoveAtCoord(Color.B ,3, 2);
    assertEquals(MoveType.MOVE_ERROR_JIE_VIOLATION, moveType);
  }

  /**
   * Tests {@link GameCoordinator#handleHumanPassMove(Color)}.
   */
  @Test public void testHandleHumanPassMove_once_randomMoveEngineType() {
    testHandleHumanPassMove_once(MoveEngine.Type.RANDOM);
  }
  @Test public void testHandleHumanPassMove_once_mcts2MoveEngineType() {
    testHandleHumanPassMove_once(MoveEngine.Type.MCTS);
  }
  private void testHandleHumanPassMove_once(MoveEngine.Type moveEngineType) {
    prepare(moveEngineType);
    boolean isTwoConsecutivePassMoves = gameCoordinator.handleHumanPassMove(Color.B);
    assertFalse(isTwoConsecutivePassMoves);
  }

  /**
   * Tests {@link GameCoordinator#handleHumanPassMove(Color)}.
   */
  @Test public void testHandleHumanPassMove_twice_randomMoveEngineType() {
    testHandleHumanPassMove_twice(MoveEngine.Type.RANDOM);
  }
  @Test public void testHandleHumanPassMove_twice_mcts2MoveEngineType() {
    testHandleHumanPassMove_twice(MoveEngine.Type.MCTS);
  }
  private void testHandleHumanPassMove_twice(MoveEngine.Type moveEngineType) {
    prepare(moveEngineType);
    assertEquals(PlayStage.PLAY_STAGE_STARTED, gameCoordinator.getPlayStage());
    boolean isTwoConsecutivePassMoves = gameCoordinator.handleHumanPassMove(Color.B);
    assertFalse(isTwoConsecutivePassMoves);
    assertEquals(PlayStage.PLAY_STAGE_STARTED, gameCoordinator.getPlayStage());
    isTwoConsecutivePassMoves = gameCoordinator.handleHumanPassMove(Color.W);
    assertTrue(isTwoConsecutivePassMoves);
    assertEquals(PlayStage.PLAY_STAGE_PICKUP_DEAD, gameCoordinator.getPlayStage());
  }

  /**
   * Tests {@link GameCoordinator#askComputerToGenNextMoveTakingLongTime(Color)}}.
   */
  @Test public void testAskComputerToMove_randomMoveEngineType() {
    testAskComputerToMove(MoveEngine.Type.RANDOM);
  }
  @Test public void testAskComputerToMove_mcts2MoveEngineType() {
    testAskComputerToMove(MoveEngine.Type.MCTS);
  }
  private void testAskComputerToMove(MoveEngine.Type moveEngineType) {
    prepare(moveEngineType);
    assertEquals(PlayStage.PLAY_STAGE_STARTED, gameCoordinator.getPlayStage());
    assertEquals(Color.B, gameCoordinator.findColorForNextMove());
    assertEquals(0, gameCoordinator.findNumberOfMoves());

    // 1st move by computer
    gameCoordinator.askComputerToGenNextMoveTakingLongTime(Color.B);
    assertEquals(PlayStage.PLAY_STAGE_STARTED, gameCoordinator.getPlayStage());
    assertEquals(Color.W, gameCoordinator.findColorForNextMove());
    assertEquals(1, gameCoordinator.findNumberOfMoves());

    // 2nd move by computer
    gameCoordinator.askComputerToGenNextMoveTakingLongTime(Color.W);
    assertEquals(PlayStage.PLAY_STAGE_STARTED, gameCoordinator.getPlayStage());
    assertEquals(Color.B, gameCoordinator.findColorForNextMove());
    assertEquals(2, gameCoordinator.findNumberOfMoves());

    // 3rd move - PASS - by human
    boolean isTwoConsecutivePassMoves = gameCoordinator.handleHumanPassMove(Color.B);
    assertFalse(isTwoConsecutivePassMoves);
    assertEquals(PlayStage.PLAY_STAGE_STARTED, gameCoordinator.getPlayStage());
    assertEquals(Color.W, gameCoordinator.findColorForNextMove());
    assertEquals(3, gameCoordinator.findNumberOfMoves());

    // 4th move by computer
    gameCoordinator.askComputerToGenNextMoveTakingLongTime(Color.W);
    assertEquals(PlayStage.PLAY_STAGE_STARTED, gameCoordinator.getPlayStage());
    assertEquals(4, gameCoordinator.findNumberOfMoves());
    assertEquals(Color.B, gameCoordinator.findColorForNextMove());
  }

  /**
   * Tests {@link GameCoordinator#askComputerToGenNextMoveTakingLongTime(Color)}}.
   *
   * <p>Board:
   * <pre>
   * .X.X.
   * X.X.X
   * .X.X.
   * X.X.X
   * .X.X.
   * </pre>
   * The next move for white is PASS.
   */
  @Test public void testAskWhiteComputerToMoveAndTheResultIsPass_randomMoveEngineType() {
    testAskWhiteComputerToMoveAndTheResultIsPass(MoveEngine.Type.RANDOM);
  }
  @Test public void testAskWhiteComputerToMoveAndTheResultIsPass_mcts2MoveEngineType() {
    testAskWhiteComputerToMoveAndTheResultIsPass(MoveEngine.Type.MCTS);
  }
  private void testAskWhiteComputerToMoveAndTheResultIsPass(MoveEngine.Type moveEngineType) {
    prepare(moveEngineType);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,1, 2);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,1, 4);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,2, 1);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,2, 3);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,2, 5);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,3, 2);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,3, 4);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,4, 1);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,4, 3);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,4, 5);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,5, 2);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,5, 4);
    gameCoordinator.askComputerToGenNextMoveTakingLongTime(Color.W);
    assertEquals(PlayStage.PLAY_STAGE_STARTED, gameCoordinator.getPlayStage());
    assertEquals(24, gameCoordinator.findNumberOfMoves());
    assertEquals(MoveType.MOVE_PASS, gameCoordinator.getLatestMoveHandling().getMoveType());
    assertEquals(Color.B, gameCoordinator.findColorForNextMove());
  }

  /**
   * Tests {@link GameCoordinator#askComputerToGenNextMoveTakingLongTime(Color)}.
   *
   * <p>Board:
   * <pre>
   * .O.O.
   * O.OOX
   * .O.OO
   * O.O.O
   * .O.O.
   * </pre>
   * The next move for black is PASS.
   */
  @Test public void testAskBlackComputerToMoveAndTheResultIsPass_afterWhitePass_randomMoveEngineType() {
    testAskBlackComputerToMoveAndTheResultIsPass_afterWhitePass(MoveEngine.Type.RANDOM);
  }
  @Test public void testAskBlackComputerToMoveAndTheResultIsPass_afterWhitePass_mcts2MoveEngineType() {
    testAskBlackComputerToMoveAndTheResultIsPass_afterWhitePass(MoveEngine.Type.MCTS);
  }
  private void testAskBlackComputerToMoveAndTheResultIsPass_afterWhitePass(MoveEngine.Type moveEngineType) {
    prepare(moveEngineType);
    gameCoordinator.handleHumanPassMove(Color.B);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,1, 2);
    gameCoordinator.handleHumanPassMove(Color.B);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,1, 4);
    gameCoordinator.handleHumanPassMove(Color.B);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,2, 1);
    gameCoordinator.handleHumanPassMove(Color.B);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,2, 3);
    gameCoordinator.handleHumanPassMove(Color.B);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,2, 5);
    gameCoordinator.handleHumanPassMove(Color.B);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,3, 2);
    gameCoordinator.handleHumanPassMove(Color.B);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,3, 4);
    gameCoordinator.handleHumanPassMove(Color.B);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,4, 1);
    gameCoordinator.handleHumanPassMove(Color.B);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,4, 3);
    gameCoordinator.handleHumanPassMove(Color.B);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,4, 4);
    gameCoordinator.handleHumanPassMove(Color.B);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,4, 5);
    gameCoordinator.handleHumanPassMove(Color.B);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,5, 2);
    gameCoordinator.handleHumanPassMove(Color.B);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,5, 3);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,5, 4);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.askComputerToGenNextMoveTakingLongTime(Color.B);
    assertEquals(PlayStage.PLAY_STAGE_PICKUP_DEAD, gameCoordinator.getPlayStage());
    assertEquals(29, gameCoordinator.findNumberOfMoves());
    assertEquals(MoveType.MOVE_PASS, gameCoordinator.getLatestMoveHandling().getMoveType());
    assertEquals(Color.W, gameCoordinator.findColorForNextMove());
  }

  /**
   * Tests {@link GameCoordinator#askComputerToGenNextMoveTakingLongTime(Color)}.
   *
   * <p>Board:
   * <pre>
   * .X.X.
   * X.XXO
   * .X.XX
   * X.X.X
   * .X.X.
   * </pre>
   * Assuming Black passes next, then the next move for white is PASS.
   */
  @Test public void testAskBlackComputerToMoveAndTheResultIsPass_afterBlackPass_randomMoveEngineType() {
    testAskBlackComputerToMoveAndTheResultIsPass_afterBlackPass(MoveEngine.Type.RANDOM);
  }
  @Test public void testAskBlackComputerToMoveAndTheResultIsPass_afterBlackPass_mcts2MoveEngineType() {
    testAskBlackComputerToMoveAndTheResultIsPass_afterBlackPass(MoveEngine.Type.MCTS);
  }
  private void testAskBlackComputerToMoveAndTheResultIsPass_afterBlackPass(MoveEngine.Type moveEngineType) {
    prepare(moveEngineType);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,1, 2);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,1, 4);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,2, 1);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,2, 3);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,2, 5);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,3, 2);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,3, 4);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,4, 1);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,4, 3);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,4, 4);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,4, 5);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,5, 2);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,5, 3);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,5, 4);
    boolean hasTwoPasses = gameCoordinator.handleHumanPassMove(Color.B);
    assertFalse(hasTwoPasses);
    gameCoordinator.askComputerToGenNextMoveTakingLongTime(Color.W);

    assertEquals(28, gameCoordinator.findNumberOfMoves());
    assertEquals(Color.B, gameCoordinator.findColorForNextMove());
    MoveHandling latestMoveHandling = gameCoordinator.getLatestMoveHandling();
    assertTrue(latestMoveHandling.getMoveType() == MoveType.MOVE_PASS);
    assertEquals(PlayStage.PLAY_STAGE_PICKUP_DEAD, gameCoordinator.getPlayStage());
  }

  @Test public void testAskComputerToMove_verifyColor_randomMoveEngineType() {
    testAskComputerToMove_verifyColor(MoveEngine.Type.RANDOM);
  }
  @Test public void testAskComputerToMove_verifyColor_mcts2MoveEngineType() {
    testAskComputerToMove_verifyColor(MoveEngine.Type.MCTS);
  }
  private void testAskComputerToMove_verifyColor(MoveEngine.Type moveEngineType) {
    prepare(moveEngineType);
    MoveType moveType;
    MoveHandling latestMoveHandling;
    Color moveColor;

    moveType = gameCoordinator.handleHumanMoveAtCoord(Color.B ,1, 2);
    assertEquals(MoveType.MOVE_REGULAR, moveType);
    latestMoveHandling = gameCoordinator.getLatestMoveHandling();
    moveColor = latestMoveHandling.getMoveColor();
    assertEquals(Color.B, moveColor);

    boolean hasTwoPasses = gameCoordinator.handleHumanPassMove(Color.W);
    assertFalse(hasTwoPasses);
    latestMoveHandling = gameCoordinator.getLatestMoveHandling();
    moveColor = latestMoveHandling.getMoveColor();
    assertEquals(Color.W, moveColor);

    moveType = gameCoordinator.handleHumanMoveAtCoord(Color.B ,1, 4);
    assertEquals(MoveType.MOVE_REGULAR, moveType);
    latestMoveHandling = gameCoordinator.getLatestMoveHandling();
    moveColor = latestMoveHandling.getMoveColor();
    assertEquals(Color.B, moveColor);
  }

  /**
   * Tests {@link GameCoordinator#askComputerToGenNextMoveTakingLongTime(Color)}}.
   *
   * <p>Board:
   * <pre>
   * .XXOO
   * X.XOO
   * .XXOX
   * X.XO.
   * .XXXX
   * </pre>
   * The next move for white is EAT at (5, 2).
   */
  @Test public void testAskWhiteComputerToMoveAndTheResultIsEat_afterNonPassMove_randomMoveEngineType() {
    testAskWhiteComputerToMoveAndTheResultIsEat_afterNonPassMove(MoveEngine.Type.RANDOM);
  }
  @Test public void testAskWhiteComputerToMoveAndTheResultIsEat_afterNonPassMove_mcts2MoveEngineType() {
    testAskWhiteComputerToMoveAndTheResultIsEat_afterNonPassMove(MoveEngine.Type.MCTS);
  }
  private void testAskWhiteComputerToMoveAndTheResultIsEat_afterNonPassMove(MoveEngine.Type moveEngineType) {
    prepare(moveEngineType);
    // Set up black moves.
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,1, 2);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,1, 4);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,2, 1);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,2, 3);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,2, 5);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,3, 1);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,3, 2);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,3, 3);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,3, 4);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,3, 5);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,4, 1);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,5, 1);

    // Set up white moves.
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,4, 2);
    gameCoordinator.handleHumanPassMove(Color.B);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,4, 3);
    gameCoordinator.handleHumanPassMove(Color.B);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,4, 4);
    gameCoordinator.handleHumanPassMove(Color.B);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,4, 5);
    gameCoordinator.handleHumanPassMove(Color.B);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,5, 4);
    gameCoordinator.handleHumanPassMove(Color.B);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,5, 5);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,5, 3);

    // The next move is for white.
    gameCoordinator.askComputerToGenNextMoveTakingLongTime(Color.W);
    assertEquals(PlayStage.PLAY_STAGE_STARTED, gameCoordinator.getPlayStage());
    assertEquals(36, gameCoordinator.findNumberOfMoves());
    assertEquals(MoveType.MOVE_EAT_NO_JIE, gameCoordinator.getLatestMoveHandling().getMoveType());
    assertEquals(Color.B, gameCoordinator.findColorForNextMove());
    Coord coordForTheLatestMove =
        gameCoordinator.getLatestMoveHandling().getMoveCoordOptional().get();
    assertEquals(coordBoard.getCoord(5, 2), coordForTheLatestMove);
    assertEquals(1, gameCoordinator.getDeadCountForColor(Color.B));
    assertEquals(0, gameCoordinator.getDeadCountForColor(Color.W));
  }

  /**
   * Tests {@link GameCoordinator#askComputerToGenNextMoveTakingLongTime(Color)}}.
   *
   * <p>Board:
   * <pre>
   * .XXOO
   * X.XOO
   * .XXOX
   * X.XO.
   * .XXXX
   * </pre>
   * The next move for white is EAT at (5, 2).
   */
  @Test public void testAskWhiteComputerToMoveAndTheResultIsEat_afterPassMove_randomMoveEngineType() {
    testAskWhiteComputerToMoveAndTheResultIsEat_afterPassMove(MoveEngine.Type.RANDOM);
  }
  @Test public void testAskWhiteComputerToMoveAndTheResultIsEat_afterPassMove_mcts2MoveEngineType() {
    testAskWhiteComputerToMoveAndTheResultIsEat_afterPassMove(MoveEngine.Type.MCTS);
  }
  private void testAskWhiteComputerToMoveAndTheResultIsEat_afterPassMove(MoveEngine.Type moveEngineType) {
    prepare(moveEngineType);
    // Set up black moves.
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,1, 2);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,1, 4);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,2, 1);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,2, 3);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,2, 5);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,3, 1);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,3, 2);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,3, 3);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,3, 4);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,3, 5);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,4, 1);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,5, 1);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,5, 3);

    // Set up white moves.
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,4, 2);
    gameCoordinator.handleHumanPassMove(Color.B);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,4, 3);
    gameCoordinator.handleHumanPassMove(Color.B);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,4, 4);
    gameCoordinator.handleHumanPassMove(Color.B);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,4, 5);
    gameCoordinator.handleHumanPassMove(Color.B);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,5, 4);
    gameCoordinator.handleHumanPassMove(Color.B);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,5, 5);
    gameCoordinator.handleHumanPassMove(Color.B);

    gameCoordinator.askComputerToGenNextMoveTakingLongTime(Color.W);
    assertEquals(PlayStage.PLAY_STAGE_STARTED, gameCoordinator.getPlayStage());
    assertEquals(38, gameCoordinator.findNumberOfMoves());
    assertEquals(MoveType.MOVE_EAT_NO_JIE, gameCoordinator.getLatestMoveHandling().getMoveType());
    assertEquals(Color.B, gameCoordinator.findColorForNextMove());
    Coord coordForTheLatestBlackMove =
        gameCoordinator.getLatestMoveHandling().getMoveCoordOptional().get();
    assertEquals(coordBoard.getCoord(5, 2), coordForTheLatestBlackMove);
    assertEquals(1, gameCoordinator.getDeadCountForColor(Color.B));
    assertEquals(0, gameCoordinator.getDeadCountForColor(Color.W));
  }

  /**
   * <pre>
   * Root board:
   *
   * "●●●●●"
   * "●●●●●"
   * "○●◦●○"
   * "◦○●○◦"
   * "○○○○○"
   *
   * 1st move - Black at (1, 2):
   * jieDeadCoord = (1, 3)
   *
   * "●●●●●"
   * "●●●●●"
   * "◦●◦●○"
   * "●○●○◦"
   * "○○○○○"
   *
   * 2nd move - White at (3, 3):
   * jieDeadCoord = (3, 2)
   *
   * "●●●●●"
   * "●●●●●"
   * "◦●○●○"
   * "●○◦○◦"
   * "○○○○○"
   *
   * 3rd move - Black at (5, 2):
   * jieDeadCoord = (5, 3)
   *
   * "●●●●●"
   * "●●●●●"
   * "◦●○●◦"
   * "●○◦○●"
   * "○○○○○"
   *
   * 4rd move - White at (1, 3):
   * jieDeadCoord = (1, 2)
   *
   * "●●●●●"
   * "●●●●●"
   * "○●○●◦"
   * "◦○◦○●"
   * "○○○○○"
   *
   * 5rd move - Black at (3, 2):
   * jieDeadCoord = (3, 3)
   *
   * "●●●●●"
   * "●●●●●"
   * "○●◦●◦"
   * "◦○●○●"
   * "○○○○○"
   *
   * 6rd move - White at (5, 3):
   * jieDeadCoord = (5, 2)
   *
   * "●●●●●"
   * "●●●●●"
   * "○●◦●○"
   * "◦○●○◦"
   * "○○○○○"
   *
   * Repeat.
   *
   * </pre>
   */
  @Test public void testAskComputerToMove_superKo_randomMoveEngineType() {
    testAskComputerToMove_superKo(MoveEngine.Type.RANDOM);
  }
  @Test public void testAskComputerToMove_superKo_mcts2MoveEngineType() {
    testAskComputerToMove_superKo(MoveEngine.Type.MCTS);
  }
  private void testAskComputerToMove_superKo(MoveEngine.Type moveEngineType) {
    prepare(moveEngineType);
    // Prepare board to be like this:
    //
    // "●●●●●"
    // "●●●●●"
    // "○●◦●○"
    // "◦○●○◦"
    // "○○○○○"
    //
    // Set up black moves.
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,1, 5);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,2, 5);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,3, 5);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,4, 5);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,5, 5);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,1, 4);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,2, 4);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,3, 4);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,4, 4);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,5, 4);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,2, 3);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,3, 2);
    gameCoordinator.handleHumanPassMove(Color.W);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,4, 3);
    // Set up white moves.
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,1, 1);
    gameCoordinator.handleHumanPassMove(Color.B);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,2, 1);
    gameCoordinator.handleHumanPassMove(Color.B);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,3, 1);
    gameCoordinator.handleHumanPassMove(Color.B);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,4, 1);
    gameCoordinator.handleHumanPassMove(Color.B);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,5, 1);
    gameCoordinator.handleHumanPassMove(Color.B);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,1, 3);
    gameCoordinator.handleHumanPassMove(Color.B);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,2, 2);
    gameCoordinator.handleHumanPassMove(Color.B);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,4, 2);
    gameCoordinator.handleHumanPassMove(Color.B);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,5, 3);

    MoveHandling latestMoveHandling;

    assertEquals(PlayStage.PLAY_STAGE_STARTED, gameCoordinator.getPlayStage());
    assertEquals(42, gameCoordinator.findNumberOfMoves());
    assertEquals(0, gameCoordinator.getDeadCountForColor(Color.B));
    assertEquals(0, gameCoordinator.getDeadCountForColor(Color.W));
    latestMoveHandling = gameCoordinator.getLatestMoveHandling();
    assertEquals(MoveType.MOVE_REGULAR, latestMoveHandling.getMoveType());
    assertEquals(Color.W, latestMoveHandling.getMoveColor());
    assertEquals(coordBoard.getCoord(5, 3), latestMoveHandling.getMoveCoordOptional().get());
    assertFalse(latestMoveHandling.getJieDeadCoordOptional().isPresent());
    assertEquals(0, latestMoveHandling.getDeadCoords().size());
    assertEquals(3, latestMoveHandling.getOrFindAvailMoveCoordsExceptJie().size());

    // 1st move (Human) - Black at (1, 2):
    // jieDeadCoord = (1, 3)
    //
    // "●●●●●"
    // "●●●●●"
    // "◦●◦●○"
    // "●○●○◦"
    // "○○○○○"
    gameCoordinator.handleHumanMoveAtCoord(Color.B, 1, 2);
    assertEquals(PlayStage.PLAY_STAGE_STARTED, gameCoordinator.getPlayStage());
    assertEquals(43, gameCoordinator.findNumberOfMoves());
    assertEquals(0, gameCoordinator.getDeadCountForColor(Color.B));
    assertEquals(1, gameCoordinator.getDeadCountForColor(Color.W));
    latestMoveHandling = gameCoordinator.getLatestMoveHandling();
    assertEquals(MoveType.MOVE_EAT_CAUSING_JIE, latestMoveHandling.getMoveType());
    assertEquals(Color.B, latestMoveHandling.getMoveColor());
    assertEquals(coordBoard.getCoord(1, 2), latestMoveHandling.getMoveCoordOptional().get());
    assertEquals(coordBoard.getCoord(1, 3), latestMoveHandling.getJieDeadCoordOptional().get());
    assertEquals(1, latestMoveHandling.getDeadCoords().size());
    assertEquals(2, latestMoveHandling.getOrFindAvailMoveCoordsExceptJie().size());

    boolean isPrintReachMaxNodeLevel = false;

    // 2nd move (computer) - White at (3, 3):
    // jieDeadCoord = (3, 2)
    //
    // "●●●●●"
    // "●●●●●"
    // "◦●○●○"
    // "●○◦○◦"
    // "○○○○○"
    //
    gameCoordinator.askComputerToGenNextMoveTakingLongTime(Color.W, isPrintReachMaxNodeLevel);
    assertEquals(PlayStage.PLAY_STAGE_STARTED, gameCoordinator.getPlayStage());
    assertEquals(44, gameCoordinator.findNumberOfMoves());
    assertEquals(1, gameCoordinator.getDeadCountForColor(Color.B));
    assertEquals(1, gameCoordinator.getDeadCountForColor(Color.W));
    latestMoveHandling = gameCoordinator.getLatestMoveHandling();
    assertEquals(MoveType.MOVE_EAT_CAUSING_JIE, latestMoveHandling.getMoveType());
    assertEquals(Color.W, latestMoveHandling.getMoveColor());
    assertEquals(coordBoard.getCoord(3, 3), latestMoveHandling.getMoveCoordOptional().get());
    assertEquals(coordBoard.getCoord(3, 2), latestMoveHandling.getJieDeadCoordOptional().get());
    assertEquals(1, latestMoveHandling.getDeadCoords().size());
    assertEquals(2, latestMoveHandling.getOrFindAvailMoveCoordsExceptJie().size());

    // 3rd move (computer) - Black at (5, 2):
    // jieDeadCoord = (5, 3)
    //
    // "●●●●●"
    // "●●●●●"
    // "◦●○●◦"
    // "●○◦○●"
    // "○○○○○"
    gameCoordinator.askComputerToGenNextMoveTakingLongTime(Color.B, isPrintReachMaxNodeLevel);
    assertEquals(PlayStage.PLAY_STAGE_STARTED, gameCoordinator.getPlayStage());
    assertEquals(45, gameCoordinator.findNumberOfMoves());
    assertEquals(1, gameCoordinator.getDeadCountForColor(Color.B));
    assertEquals(2, gameCoordinator.getDeadCountForColor(Color.W));
    latestMoveHandling = gameCoordinator.getLatestMoveHandling();
    assertEquals(MoveType.MOVE_EAT_CAUSING_JIE, latestMoveHandling.getMoveType());
    assertEquals(Color.B, latestMoveHandling.getMoveColor());
    assertEquals(coordBoard.getCoord(5, 2), latestMoveHandling.getMoveCoordOptional().get());
    assertEquals(coordBoard.getCoord(5, 3), latestMoveHandling.getJieDeadCoordOptional().get());
    assertEquals(1, latestMoveHandling.getDeadCoords().size());
    assertEquals(2, latestMoveHandling.getOrFindAvailMoveCoordsExceptJie().size());

    // 4rd move (computer) - White at (1, 3):
    // jieDeadCoord = (1, 2)
    //
    // "●●●●●"
    // "●●●●●"
    // "○●○●◦"
    // "◦○◦○●"
    // "○○○○○"
    gameCoordinator.askComputerToGenNextMoveTakingLongTime(Color.W, isPrintReachMaxNodeLevel);
    assertEquals(PlayStage.PLAY_STAGE_STARTED, gameCoordinator.getPlayStage());
    assertEquals(46, gameCoordinator.findNumberOfMoves());
    assertEquals(2, gameCoordinator.getDeadCountForColor(Color.B));
    assertEquals(2, gameCoordinator.getDeadCountForColor(Color.W));
    latestMoveHandling = gameCoordinator.getLatestMoveHandling();
    assertEquals(MoveType.MOVE_EAT_CAUSING_JIE, latestMoveHandling.getMoveType());
    assertEquals(Color.W, latestMoveHandling.getMoveColor());
    assertEquals(coordBoard.getCoord(1, 3), latestMoveHandling.getMoveCoordOptional().get());
    assertEquals(coordBoard.getCoord(1, 2), latestMoveHandling.getJieDeadCoordOptional().get());
    assertEquals(1, latestMoveHandling.getDeadCoords().size());
    assertEquals(2, latestMoveHandling.getOrFindAvailMoveCoordsExceptJie().size());

    // 5rd move (computer) - Black at (3, 2):
    // jieDeadCoord = (3, 3)
    //
    // "●●●●●"
    // "●●●●●"
    // "○●◦●◦"
    // "◦○●○●"
    // "○○○○○"
    gameCoordinator.askComputerToGenNextMoveTakingLongTime(Color.B, isPrintReachMaxNodeLevel);
    assertEquals(PlayStage.PLAY_STAGE_STARTED, gameCoordinator.getPlayStage());
    assertEquals(47, gameCoordinator.findNumberOfMoves());
    assertEquals(2, gameCoordinator.getDeadCountForColor(Color.B));
    assertEquals(3, gameCoordinator.getDeadCountForColor(Color.W));
    latestMoveHandling = gameCoordinator.getLatestMoveHandling();
    assertEquals(MoveType.MOVE_EAT_CAUSING_JIE, latestMoveHandling.getMoveType());
    assertEquals(Color.B, latestMoveHandling.getMoveColor());
    assertEquals(coordBoard.getCoord(3, 2), latestMoveHandling.getMoveCoordOptional().get());
    assertEquals(coordBoard.getCoord(3, 3), latestMoveHandling.getJieDeadCoordOptional().get());
    assertEquals(1, latestMoveHandling.getDeadCoords().size());
    assertEquals(2, latestMoveHandling.getOrFindAvailMoveCoordsExceptJie().size());

    // 6rd move (computer) - White at (5, 3):
    // jieDeadCoord = (5, 2)
    //
    // "●●●●●"
    // "●●●●●"
    // "○●◦●○"
    // "◦○●○◦"
    // "○○○○○"
    gameCoordinator.askComputerToGenNextMoveTakingLongTime(Color.W, isPrintReachMaxNodeLevel);
    assertEquals(PlayStage.PLAY_STAGE_STARTED, gameCoordinator.getPlayStage());
    assertEquals(48, gameCoordinator.findNumberOfMoves());
    assertEquals(3, gameCoordinator.getDeadCountForColor(Color.B));
    assertEquals(3, gameCoordinator.getDeadCountForColor(Color.W));
    latestMoveHandling = gameCoordinator.getLatestMoveHandling();
    assertEquals(MoveType.MOVE_EAT_CAUSING_JIE, latestMoveHandling.getMoveType());
    assertEquals(Color.W, latestMoveHandling.getMoveColor());
    assertEquals(coordBoard.getCoord(5, 3), latestMoveHandling.getMoveCoordOptional().get());
    assertEquals(coordBoard.getCoord(5, 2), latestMoveHandling.getJieDeadCoordOptional().get());
    assertEquals(1, latestMoveHandling.getDeadCoords().size());
    assertEquals(2, latestMoveHandling.getOrFindAvailMoveCoordsExceptJie().size());

    // Repeat (super-ko).
    // TODO 200 Support detecting super-ko.
}

  /**
   * Tests {@link GameCoordinator#handleUndoMove()}.
   */
  @Test public void testHandleUndoMove_randomMoveEngineType() {
    testHandleUndoMove(MoveEngine.Type.RANDOM);
  }
  @Test public void testHandleUndoMove_mcts2MoveEngineType() {
    testHandleUndoMove(MoveEngine.Type.MCTS);
  }
  private void testHandleUndoMove(MoveEngine.Type moveEngineType) {
    prepare(moveEngineType);
    MoveType moveType = gameCoordinator.handleHumanMoveAtCoord(Color.B ,4, 3);
    assertEquals(MoveType.MOVE_REGULAR, moveType);

    gameCoordinator.handleUndoMove();
    assertEquals(Color.B, gameCoordinator.findColorForNextMove());
    assertEquals(0, gameCoordinator.getDeadCountForColor(Color.B));
    assertEquals(0, gameCoordinator.getDeadCountForColor(Color.W));
    assertEquals(PlayStage.PLAY_STAGE_STARTED, gameCoordinator.getPlayStage());
    assertEquals(0, gameCoordinator.findNumberOfMoves());
  }

  /**
   * Tests {@link GameCoordinator#handleUndoMove()}.
   */
  @Test public void testHandleUndoMove_noPreviousMove_randomMoveEngineType() {
    testHandleUndoMove_noPreviousMove(MoveEngine.Type.RANDOM);
  }
  @Test public void testHandleUndoMove_noPreviousMove_mcts2MoveEngineType() {
    testHandleUndoMove_noPreviousMove(MoveEngine.Type.MCTS);
  }
  private void testHandleUndoMove_noPreviousMove(MoveEngine.Type moveEngineType) {
    prepare(moveEngineType);
    gameCoordinator.handleUndoMove();
    // Nothing changed.

    assertEquals(Color.B, gameCoordinator.findColorForNextMove());
    assertEquals(0, gameCoordinator.getDeadCountForColor(Color.B));
    assertEquals(0, gameCoordinator.getDeadCountForColor(Color.W));
    assertEquals(PlayStage.PLAY_STAGE_STARTED, gameCoordinator.getPlayStage());
    assertEquals(0, gameCoordinator.findNumberOfMoves());
  }

  /**
   * Tests {@link GameCoordinator#handleUndoMove()}.
   *
   * <p>Board:
   * <pre>
   * .....
   * .....
   * .....
   * X....
   * OX...
   * </pre>
   */
  @Test public void testHandleUndoMove_withDead_randomMoveEngineType() {
    testHandleUndoMove_withDead(MoveEngine.Type.RANDOM);
  }
  @Test public void testHandleUndoMove_withDead_mcts2MoveEngineType() {
    testHandleUndoMove_withDead(MoveEngine.Type.MCTS);
  }
  private void testHandleUndoMove_withDead(MoveEngine.Type moveEngineType) {
    prepare(moveEngineType);
    MoveType moveType;
    moveType = gameCoordinator.handleHumanMoveAtCoord(Color.B ,1, 2);
    assertEquals(MoveType.MOVE_REGULAR, moveType);
    moveType = gameCoordinator.handleHumanMoveAtCoord(Color.W ,1, 1);
    assertEquals(MoveType.MOVE_REGULAR, moveType);
    moveType = gameCoordinator.handleHumanMoveAtCoord(Color.B ,2, 1);
    assertEquals(MoveType.MOVE_EAT_NO_JIE, moveType);
    assertEquals(0, gameCoordinator.getDeadCountForColor(Color.B));
    assertEquals(1, gameCoordinator.getDeadCountForColor(Color.W));
    assertEquals(3, gameCoordinator.findNumberOfMoves());

    gameCoordinator.handleUndoMove();
    assertEquals(Color.B, gameCoordinator.findColorForNextMove());
    assertEquals(0, gameCoordinator.getDeadCountForColor(Color.B));
    assertEquals(0, gameCoordinator.getDeadCountForColor(Color.W));
    assertEquals(PlayStage.PLAY_STAGE_STARTED, gameCoordinator.getPlayStage());
    assertEquals(2, gameCoordinator.findNumberOfMoves());
  }

  /**
   * Tests {@link GameCoordinator#handleResign(Color)}.
   */
  @Test public void testHandleResign_randomMoveEngineType() {
    testHandleResign(MoveEngine.Type.RANDOM);
  }
  @Test public void testHandleResign_mcts2MoveEngineType() {
    testHandleResign(MoveEngine.Type.MCTS);
  }
  private void testHandleResign(MoveEngine.Type moveEngineType) {
    prepare(moveEngineType);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,4, 4);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,5, 4);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,5, 3);
    gameCoordinator.handleResign(Color.W);

    assertEquals(Color.W, gameCoordinator.findColorForNextMove());
    assertEquals(0, gameCoordinator.getDeadCountForColor(Color.B));
    assertEquals(0, gameCoordinator.getDeadCountForColor(Color.W));
    assertEquals(PlayStage.PLAY_STAGE_STOPPED, gameCoordinator.getPlayStage());
    assertEquals(3, gameCoordinator.findNumberOfMoves());
  }

  /**
   * Tests {@link GameCoordinator#handleResign(Color)}.
   */
  @Test public void testHandleResign_noPreviousMove_randomMoveEngineType() {
    testHandleResign_noPreviousMove(MoveEngine.Type.RANDOM);
  }
  @Test public void testHandleResign_noPreviousMove_mcts2MoveEngineType() {
    testHandleResign_noPreviousMove(MoveEngine.Type.MCTS);
  }
  private void testHandleResign_noPreviousMove(MoveEngine.Type moveEngineType) {
    prepare(moveEngineType);
    gameCoordinator.handleResign(Color.B);

    assertEquals(Color.B, gameCoordinator.findColorForNextMove());
    assertEquals(0, gameCoordinator.getDeadCountForColor(Color.B));
    assertEquals(0, gameCoordinator.getDeadCountForColor(Color.W));
    assertEquals(PlayStage.PLAY_STAGE_STOPPED, gameCoordinator.getPlayStage());
    assertEquals(0, gameCoordinator.findNumberOfMoves());
  }

  /**
   * Tests {@link GameCoordinator#handlePickupDeadBlockAtCoord(int, int)} and
   * {@link GameCoordinator#handleDoneOfPickupDeadStones()}.
   */
  @Test public void testHandlePickupDeadBlockAtCoordAndHandleDoneOfPickupDeadStones_randomMoveEngineType() {
    testHandlePickupDeadBlockAtCoordAndHandleDoneOfPickupDeadStones(MoveEngine.Type.RANDOM);
  }
  @Test public void testHandlePickupDeadBlockAtCoordAndHandleDoneOfPickupDeadStones_mcts2MoveEngineType() {
    testHandlePickupDeadBlockAtCoordAndHandleDoneOfPickupDeadStones(MoveEngine.Type.MCTS);
  }
  private void testHandlePickupDeadBlockAtCoordAndHandleDoneOfPickupDeadStones(MoveEngine.Type moveEngineType) {
    prepare(moveEngineType);
    // Set up moves including a dead white block.
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,1, 2);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,1, 5);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,2, 2);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,2, 5);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,3, 2);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,3, 5);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,4, 2);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,4, 5);
    gameCoordinator.handleHumanMoveAtCoord(Color.B ,5, 2);
    gameCoordinator.handleHumanMoveAtCoord(Color.W ,5, 5);
    gameCoordinator.handleHumanPassMove(Color.B);
    gameCoordinator.handleHumanPassMove(Color.W);

    // Sanity check.
    assertEquals(
        "○○○○○"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "●●●●●"
      + "◦◦◦◦◦",
        gameCoordinator.getLatestMoveHandling().getPositionStateBoardAfterMove().toString()
            .replaceAll("\n", ""));
    assertEquals(Color.B, gameCoordinator.findColorForNextMove());
    assertEquals(0, gameCoordinator.getDeadCountForColor(Color.B));
    assertEquals(0, gameCoordinator.getDeadCountForColor(Color.W));
    assertEquals(PlayStage.PLAY_STAGE_PICKUP_DEAD, gameCoordinator.getPlayStage());
    assertEquals(12, gameCoordinator.findNumberOfMoves());

    // Pick up dead. White block is dead
    gameCoordinator.handlePickupDeadBlockAtCoord(1, 5);

    // Check after pickup dead.
    BlockBoard endGameBlockBoard = gameCoordinator.getEndGameBlockBoard();
    assertEquals(
        "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "●●●●●"
      + "◦◦◦◦◦",
        endGameBlockBoard.toString().replaceAll("\n", ""));
    assertEquals(Color.B, gameCoordinator.findColorForNextMove());
    assertEquals(0, gameCoordinator.getDeadCountForColor(Color.B));
    assertEquals(5, gameCoordinator.getDeadCountForColor(Color.W));
    assertEquals(PlayStage.PLAY_STAGE_PICKUP_DEAD, gameCoordinator.getPlayStage());
    assertEquals(12, gameCoordinator.findNumberOfMoves());

    // Done of pickup dead.
    // Throws exception if everything is vacant at end game.
    gameCoordinator.handleDoneOfPickupDeadStones();

    // Check final state.
    BlockBoard finalEndGameBlockBoard = gameCoordinator.getEndGameBlockBoard();
    assertEquals(
        "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "◦◦◦◦◦"
      + "●●●●●"
      + "◦◦◦◦◦",
        finalEndGameBlockBoard.toString().replaceAll("\n", ""));
    assertEquals(Color.B, gameCoordinator.findColorForNextMove());
    assertEquals(0, gameCoordinator.getDeadCountForColor(Color.B));
    assertEquals(5, gameCoordinator.getDeadCountForColor(Color.W));
    assertEquals(PlayStage.PLAY_STAGE_STOPPED, gameCoordinator.getPlayStage());
    assertEquals(12, gameCoordinator.findNumberOfMoves());
  }
}
