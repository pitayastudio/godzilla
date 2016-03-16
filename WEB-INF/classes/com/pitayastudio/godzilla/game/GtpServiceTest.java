package com.pitayastudio.godzilla.game;

import com.pitayastudio.godzilla.common.GtpVertex;
import com.pitayastudio.godzilla.computerplayer.MoveEngine;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

public class GtpServiceTest {

  PrintStream printStream;
  ArgumentCaptor<String> outputCaptor;

  @Before public void setUp() throws Exception {
    printStream = Mockito.mock(PrintStream.class);
    outputCaptor = ArgumentCaptor.forClass(String.class);
  }

  private static GameInfo getDefaultGameInfo() {
    GameInfo gameInfo = GameInfo.newBuilder()
        .setRequiredBoardSize(5)
        .setRequiredTimeLimitInMin(10)
        .build();
    return gameInfo;
  }

  private void testAsynchronicallyWithQuitCommand(String commands, MoveEngine.Type moveEngineType) {
    InputStream inputStream = new ByteArrayInputStream(commands.getBytes());
    GameCoordinator gameCoordinator = new GameCoordinator(getDefaultGameInfo(), moveEngineType);
    GtpService service = new GtpService(inputStream, printStream, gameCoordinator);

    service.startAsync();
    // The following would fail in multi-thread environment.
    // In particular, when running all tests under javatests/.
    // So, don't use them.
    // service.awaitRunning();
    // Assert.assertTrue(service.isRunning());

    // The service will be terminated by the "quit" command.
    service.awaitTerminated();
    Assert.assertFalse(service.isRunning());
  }

  @Test public void testEmptyCommand_randomMoveEngineType() {
    testEmptyCommand(MoveEngine.Type.RANDOM);
  }
  @Test public void testEmptyCommand_mcts2MoveEngineType() {
    testEmptyCommand(MoveEngine.Type.MCTS);
  }
  private void testEmptyCommand(MoveEngine.Type moveEngineType) {
    String commands =
          "\n"
        + "quit\n";
    testAsynchronicallyWithQuitCommand(commands, moveEngineType);
    Mockito.verify(printStream, Mockito.times(2)).println(outputCaptor.capture());
    List<String> outputs = outputCaptor.getAllValues();
    Assert.assertTrue(outputs.get(0).startsWith(GtpService.GTP_OUTPUT_PREFIX_FAILURE));
  }

  @Test public void testEmptySpaceCommand_randomMoveEngineType() {
    testEmptySpaceCommand(MoveEngine.Type.RANDOM);
  }
  @Test public void testEmptySpaceCommand_mcts2MoveEngineType() {
    testEmptySpaceCommand(MoveEngine.Type.MCTS);
  }
  private void testEmptySpaceCommand(MoveEngine.Type moveEngineType) {
    String commands =
          " \n"
        + "quit\n";
    testAsynchronicallyWithQuitCommand(commands, moveEngineType);
    Mockito.verify(printStream, Mockito.times(2)).println(outputCaptor.capture());
    List<String> outputs = outputCaptor.getAllValues();
    Assert.assertTrue(outputs.get(0).startsWith(GtpService.GTP_OUTPUT_PREFIX_FAILURE));
  }

  @Test public void testProtocolVersionCommand_randomMoveEngineType() {
    testProtocolVersionCommand(MoveEngine.Type.RANDOM);
  }
  @Test public void testProtocolVersionCommand_mcts2MoveEngineType() {
    testProtocolVersionCommand(MoveEngine.Type.MCTS);
  }
  private void testProtocolVersionCommand(MoveEngine.Type moveEngineType) {
    String commands =
          "protocol_version\n"
        + "quit\n";
    testAsynchronicallyWithQuitCommand(commands, moveEngineType);
    Mockito.verify(printStream, Mockito.times(2)).println(outputCaptor.capture());
    List<String> outputs = outputCaptor.getAllValues();
    Assert.assertTrue(outputs.get(0).startsWith(GtpService.GTP_OUTPUT_PREFIX_SUCCESS));
    Assert.assertTrue(outputs.get(0).contains(GtpService.GTP_OUTPUT_PROTOCOL_VERSION));
  }

  @Test public void testProtocolVersionCommand_extraArgument_randomMoveEngineType() {
    testProtocolVersionCommand_extraArgument(MoveEngine.Type.RANDOM);
  }
  @Test public void testProtocolVersionCommand_extraArgument_mcts2MoveEngineType() {
    testProtocolVersionCommand_extraArgument(MoveEngine.Type.MCTS);
  }
  private void testProtocolVersionCommand_extraArgument(MoveEngine.Type moveEngineType) {
    String commands =
          "protocol_version foo\n"
        + "quit\n";
    testAsynchronicallyWithQuitCommand(commands, moveEngineType);
    Mockito.verify(printStream, Mockito.times(2)).println(outputCaptor.capture());
    List<String> outputs = outputCaptor.getAllValues();
    Assert.assertTrue(outputs.get(0).startsWith(GtpService.GTP_OUTPUT_PREFIX_FAILURE));
  }

  @Test public void testNameCommand_randomMoveEngineType() {
    testNameCommand(MoveEngine.Type.RANDOM);
  }
  @Test public void testNameCommand_mcts2MoveEngineType() {
    testNameCommand(MoveEngine.Type.MCTS);
  }
  private void testNameCommand(MoveEngine.Type moveEngineType) {
    String commands =
          "name\n"
        + "quit\n";
    testAsynchronicallyWithQuitCommand(commands, moveEngineType);
    Mockito.verify(printStream, Mockito.times(2)).println(outputCaptor.capture());
    List<String> outputs = outputCaptor.getAllValues();
    Assert.assertTrue(outputs.get(0).startsWith(GtpService.GTP_OUTPUT_PREFIX_SUCCESS));
    Assert.assertTrue(outputs.get(0).contains(GtpService.GTP_OUTPUT_PROGRAM_NAME));
  }

  @Test public void testNameCommand_extraArgument_randomMoveEngineType() {
    testNameCommand_extraArgument(MoveEngine.Type.RANDOM);
  }
  @Test public void testNameCommand_extraArgument_mcts2MoveEngineType() {
    testNameCommand_extraArgument(MoveEngine.Type.MCTS);
  }
  private void testNameCommand_extraArgument(MoveEngine.Type moveEngineType) {
    String commands =
          "name foo\n"
        + "quit\n";
    testAsynchronicallyWithQuitCommand(commands, moveEngineType);
    Mockito.verify(printStream, Mockito.times(2)).println(outputCaptor.capture());
    List<String> outputs = outputCaptor.getAllValues();
    Assert.assertTrue(outputs.get(0).startsWith(GtpService.GTP_OUTPUT_PREFIX_FAILURE));
  }

  @Test public void testVersionCommand_randomMoveEngineType() {
    testVersionCommand(MoveEngine.Type.RANDOM);
  }
  @Test public void testVersionCommand_mcts2MoveEngineType() {
    testVersionCommand(MoveEngine.Type.MCTS);
  }
  private void testVersionCommand(MoveEngine.Type moveEngineType) {
    String commands =
          "version\n"
        + "quit\n";
    testAsynchronicallyWithQuitCommand(commands, moveEngineType);
    Mockito.verify(printStream, Mockito.times(2)).println(outputCaptor.capture());
    List<String> outputs = outputCaptor.getAllValues();
    Assert.assertTrue(outputs.get(0).startsWith(GtpService.GTP_OUTPUT_PREFIX_SUCCESS));
    Assert.assertTrue(outputs.get(0).contains(GtpService.GTP_OUTPUT_PROGRAM_VERSION));
  }

  @Test public void testVersionCommand_extraArgument_randomMoveEngineType() {
    testVersionCommand_extraArgument(MoveEngine.Type.RANDOM);
  }
  @Test public void testVersionCommand_extraArgument_mcts2MoveEngineType() {
    testVersionCommand_extraArgument(MoveEngine.Type.MCTS);
  }
  private void testVersionCommand_extraArgument(MoveEngine.Type moveEngineType) {
    String commands =
          "version foo\n"
        + "quit\n";
    testAsynchronicallyWithQuitCommand(commands, moveEngineType);
    Mockito.verify(printStream, Mockito.times(2)).println(outputCaptor.capture());
    List<String> outputs = outputCaptor.getAllValues();
    Assert.assertTrue(outputs.get(0).startsWith(GtpService.GTP_OUTPUT_PREFIX_FAILURE));
  }

  @Test public void testHumanPlay_randomMoveEngineType() {
    testHumanPlay(MoveEngine.Type.RANDOM);
  }
  @Test public void testHumanPlay_mcts2MoveEngineType() {
    testHumanPlay(MoveEngine.Type.MCTS);
  }
  private void testHumanPlay(MoveEngine.Type moveEngineType) {
    String commands =
          "play b A1\n"
        + "quit\n";
    testAsynchronicallyWithQuitCommand(commands, moveEngineType);
    Mockito.verify(printStream, Mockito.times(2)).println(outputCaptor.capture());
    List<String> outputs = outputCaptor.getAllValues();
    Assert.assertTrue(outputs.get(0).startsWith(GtpService.GTP_OUTPUT_PREFIX_SUCCESS));
  }

  @Test public void testHumanPlay_extraArgument_randomMoveEngineType() {
    testHumanPlay_extraArgument(MoveEngine.Type.RANDOM);
  }
  @Test public void testHumanPlay_extraArgument_mcts2MoveEngineType() {
    testHumanPlay_extraArgument(MoveEngine.Type.MCTS);
  }
  private void testHumanPlay_extraArgument(MoveEngine.Type moveEngineType) {
    String commands =
          "play b A1 foo\n"
        + "quit\n";
    testAsynchronicallyWithQuitCommand(commands, moveEngineType);
    Mockito.verify(printStream, Mockito.times(2)).println(outputCaptor.capture());
    List<String> outputs = outputCaptor.getAllValues();
    Assert.assertTrue(outputs.get(0).startsWith(GtpService.GTP_OUTPUT_PREFIX_FAILURE));
  }

  @Test public void testHumanPlay_pass_randomMoveEngineType() {
    testHumanPlay_pass(MoveEngine.Type.RANDOM);
  }
  @Test public void testHumanPlay_pass_mcts2MoveEngineType() {
    testHumanPlay_pass(MoveEngine.Type.MCTS);
  }
  private void testHumanPlay_pass(MoveEngine.Type moveEngineType) {
    String commands =
          "play b pass\n"
        + "quit\n";
    testAsynchronicallyWithQuitCommand(commands, moveEngineType);
    Mockito.verify(printStream, Mockito.times(2)).println(outputCaptor.capture());
    List<String> outputs = outputCaptor.getAllValues();
    Assert.assertTrue(outputs.get(0).startsWith(GtpService.GTP_OUTPUT_PREFIX_SUCCESS));
  }

  @Test public void testHumanPlay_invalidColor_randomMoveEngineType() {
    testHumanPlay_invalidColor(MoveEngine.Type.RANDOM);
  }
  @Test public void testHumanPlay_invalidColor_mcts2MoveEngineType() {
    testHumanPlay_invalidColor(MoveEngine.Type.MCTS);
  }
  private void testHumanPlay_invalidColor(MoveEngine.Type moveEngineType) {
    String commands =
          "play w A1\n"
        + "quit\n";
    testAsynchronicallyWithQuitCommand(commands, moveEngineType);
    Mockito.verify(printStream, Mockito.times(2)).println(outputCaptor.capture());
    List<String> outputs = outputCaptor.getAllValues();
    Assert.assertTrue(outputs.get(0).startsWith(GtpService.GTP_OUTPUT_PREFIX_FAILURE));
  }

  @Test public void testHumanPlay_illegalMove_randomMoveEngineType() {
    testHumanPlay_illegalMove(MoveEngine.Type.RANDOM);
  }
  @Test public void testHumanPlay_illegalMove_mcts2MoveEngineType() {
    testHumanPlay_illegalMove(MoveEngine.Type.MCTS);
  }
  private void testHumanPlay_illegalMove(MoveEngine.Type moveEngineType) {
    String commands =
          "play b A1\n"
        + "play w A1\n"
        + "quit\n";
    testAsynchronicallyWithQuitCommand(commands, moveEngineType);
    Mockito.verify(printStream, Mockito.times(3)).println(outputCaptor.capture());
    List<String> outputs = outputCaptor.getAllValues();
    Assert.assertTrue(outputs.get(0).startsWith(GtpService.GTP_OUTPUT_PREFIX_SUCCESS));
    Assert.assertTrue(outputs.get(1).startsWith(GtpService.GTP_OUTPUT_PREFIX_FAILURE));
    Assert.assertTrue(outputs.get(1).contains(GtpService.GTP_OUTPUT_ILLEGAL_MOVE));
  }

  @Test public void testComputerGenmove_randomMoveEngineType() {
    testComputerGenmove(MoveEngine.Type.RANDOM);
  }
  @Test public void testComputerGenmove_mcts2MoveEngineType() {
    testComputerGenmove(MoveEngine.Type.MCTS);
  }
  private void testComputerGenmove(MoveEngine.Type moveEngineType) {
    String commands =
          "genmove b\n"
        + "quit\n";
    testAsynchronicallyWithQuitCommand(commands, moveEngineType);
    Mockito.verify(printStream, Mockito.times(2)).println(outputCaptor.capture());
    List<String> outputs = outputCaptor.getAllValues();
    Assert.assertTrue(outputs.get(0).startsWith(GtpService.GTP_OUTPUT_PREFIX_SUCCESS));
    Assert.assertFalse(outputs.get(0).contains(GtpVertex.VERTEX_PASS));
  }

  /**
   * White move for the following board is PASS.
   * <pre>
   * 5 .X.X.
   * 4 X.X.X
   * 3 .X.X.
   * 2 X.X.X
   * 2 .X.X.
   *   ABCDE
   * </pre>
   */
  @Test public void testComputerGenmove_pass_randomMoveEngineType() {
    testComputerGenmove_pass(MoveEngine.Type.RANDOM);
  }
  @Test public void testComputerGenmove_pass_mcts2MoveEngineType() {
    testComputerGenmove_pass(MoveEngine.Type.MCTS);
  }
  private void testComputerGenmove_pass(MoveEngine.Type moveEngineType) {
    String commands =
          "play b A2\n"
        + "play w pass\n"
        + "play b A4\n"
        + "play w pass\n"
        + "play b B1\n"
        + "play w pass\n"
        + "play b B3\n"
        + "play w pass\n"
        + "play b B5\n"
        + "play w pass\n"
        + "play b C2\n"
        + "play w pass\n"
        + "play b C4\n"
        + "play w pass\n"
        + "play b D1\n"
        + "play w pass\n"
        + "play b D3\n"
        + "play w pass\n"
        + "play b D5\n"
        + "play w pass\n"
        + "play b E2\n"
        + "play w pass\n"
        + "play b E4\n"
        + "genmove w\n"  // move #24 (index = 23)
        + "quit\n";
    testAsynchronicallyWithQuitCommand(commands, moveEngineType);

    // Verify.
    Mockito.verify(printStream, Mockito.times(25)).println(outputCaptor.capture());
    List<String> outputs = outputCaptor.getAllValues();
    Assert.assertTrue(outputs.get(23).startsWith(GtpService.GTP_OUTPUT_PREFIX_SUCCESS));
    Assert.assertTrue("Error outputs:\n" + outputs,
        outputs.get(23).contains(GtpVertex.VERTEX_PASS));
  }

  @Test public void testComputerGenmove_extraArgument_randomMoveEngineType() {
    testComputerGenmove_extraArgument(MoveEngine.Type.RANDOM);
  }
  @Test public void testComputerGenmove_extraArgument_mcts2MoveEngineType() {
    testComputerGenmove_extraArgument(MoveEngine.Type.MCTS);
  }
  private void testComputerGenmove_extraArgument(MoveEngine.Type moveEngineType) {
    String commands =
          "genmove b foo\n"
        + "quit\n";
    testAsynchronicallyWithQuitCommand(commands, moveEngineType);
    Mockito.verify(printStream, Mockito.times(2)).println(outputCaptor.capture());
    List<String> outputs = outputCaptor.getAllValues();
    Assert.assertTrue(outputs.get(0).startsWith(GtpService.GTP_OUTPUT_PREFIX_FAILURE));
  }

  @Test public void testComputerGenmove_invalidColor_randomMoveEngineType() {
    testComputerGenmove_invalidColor(MoveEngine.Type.RANDOM);
  }
  @Test public void testComputerGenmove_invalidColor_mcts2MoveEngineType() {
    testComputerGenmove_invalidColor(MoveEngine.Type.MCTS);
  }
  private void testComputerGenmove_invalidColor(MoveEngine.Type moveEngineType) {
    String commands =
          "genmove w\n"
        + "quit\n";
    testAsynchronicallyWithQuitCommand(commands, moveEngineType);
    Mockito.verify(printStream, Mockito.times(2)).println(outputCaptor.capture());
    List<String> outputs = outputCaptor.getAllValues();
    Assert.assertTrue(outputs.get(0).startsWith(GtpService.GTP_OUTPUT_PREFIX_FAILURE));
  }

  @Test public void testHumanUndo_randomMoveEngineType() {
    testHumanUndo(MoveEngine.Type.RANDOM);
  }
  @Test public void testHumanUndo_mcts2MoveEngineType() {
    testHumanUndo(MoveEngine.Type.MCTS);
  }
  private void testHumanUndo(MoveEngine.Type moveEngineType) {
    String commands =
          "play b a1\n"
        + "undo\n"
        + "quit\n";
    testAsynchronicallyWithQuitCommand(commands, moveEngineType);
    Mockito.verify(printStream, Mockito.times(3)).println(outputCaptor.capture());
    List<String> outputs = outputCaptor.getAllValues();
    Assert.assertTrue(outputs.get(0).startsWith(GtpService.GTP_OUTPUT_PREFIX_SUCCESS));
  }

  @Test public void testHumanUndo_extraArgument_randomMoveEngineType() {
    testHumanUndo_extraArgument(MoveEngine.Type.RANDOM);
  }
  @Test public void testHumanUndo_extraArgument_mcts2MoveEngineType() {
    testHumanUndo_extraArgument(MoveEngine.Type.MCTS);
  }
  private void testHumanUndo_extraArgument(MoveEngine.Type moveEngineType) {
    String commands =
          "play b pass\n"
        + "undo foo\n"
        + "quit\n";
    testAsynchronicallyWithQuitCommand(commands, moveEngineType);
    Mockito.verify(printStream, Mockito.times(3)).println(outputCaptor.capture());
    List<String> outputs = outputCaptor.getAllValues();
    Assert.assertTrue(outputs.get(0).startsWith(GtpService.GTP_OUTPUT_PREFIX_SUCCESS));
    Assert.assertTrue(outputs.get(1).startsWith(GtpService.GTP_OUTPUT_PREFIX_FAILURE));
  }

  @Test public void testQuit_extraArgument_randomMoveEngineType() {
    testQuit_extraArgument(MoveEngine.Type.RANDOM);
  }
  @Test public void testQuit_extraArgument_mcts2MoveEngineType() {
    testQuit_extraArgument(MoveEngine.Type.MCTS);
  }
  private void testQuit_extraArgument(MoveEngine.Type moveEngineType) {
    String commands =
        "quit foo\n"  // the failed quit
      + "quit\n";  // the real quit
    testAsynchronicallyWithQuitCommand(commands, moveEngineType);
    Mockito.verify(printStream, Mockito.times(2)).println(outputCaptor.capture());
    List<String> outputs = outputCaptor.getAllValues();
    Assert.assertTrue(outputs.get(0).startsWith(GtpService.GTP_OUTPUT_PREFIX_FAILURE));
  }
}
