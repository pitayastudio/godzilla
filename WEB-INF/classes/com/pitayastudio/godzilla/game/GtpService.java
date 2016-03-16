package com.pitayastudio.godzilla.game;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.AbstractExecutionThreadService;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.Color.InvalidColorException;
import com.pitayastudio.godzilla.common.Flags;
import com.pitayastudio.godzilla.common.GtpVertex;
import com.pitayastudio.godzilla.common.GtpVertex.InvalidVertexException;
import com.pitayastudio.godzilla.common.MoveType;
import com.pitayastudio.godzilla.computerplayer.MoveHandling;
import com.pitayastudio.godzilla.model.Coord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.logging.Logger;

import javax.annotation.Nonnull;

// TODO 100 Fix GtpService takes too much CPU on Mac
public class GtpService extends AbstractExecutionThreadService {
  @SuppressWarnings("unused")
  private static final Logger logger = Logger.getLogger(GtpService.class.getName());

  private static final String GTP_CMD_LIST_COMMANDS = "list_commands";
  private static final String GTP_CMD_PROTOCOL_VERSION = "protocol_version";
  private static final String GTP_CMD_PROGRAM_NAME = "name";
  private static final String GTP_CMD_PROGRAM_VERSION = "version";
  private static final String GTP_CMD_BOARD_SIZE = "boardsize";
  private static final String GTP_CMD_CLEAR_BOARD = "clear_board";
  private static final String GTP_CMD_KOMI = "komi";
  private static final String GTP_CMD_HUMAN_PLAY = "play";
  private static final String GTP_CMD_GENMOVE = "genmove";
  private static final String GTP_CMD_HUMAN_UNDO = "undo";
  private static final String GTP_CMD_FINAL_SCORE = "final_score";
  private static final String GTP_CMD_QUIT = "quit";

  public static final String GTP_OUTPUT_PREFIX_SUCCESS = "=";
  public static final String GTP_OUTPUT_PREFIX_FAILURE = "?";
  public static final String GTP_OUTPUT_COMMENT = "#";
  public static final String GTP_OUTPUT_UNKNOWN_COMMAND = "unknown command";
  public static final String GTP_OUTPUT_SYNTAX_ERROR = "syntax error";
  public static final String GTP_OUTPUT_PROGRAM_VERSION = "0.2014.11.14.a";
  public static final String GTP_OUTPUT_PROGRAM_NAME = "Godzilla";
  public static final String GTP_OUTPUT_PROTOCOL_VERSION = "2";
  public static final String GTP_OUTPUT_ILLEGAL_MOVE = "illegal move";

  public static void main(String[] args) {
    GameInfo gameInfo = GameInfo.newBuilder()
        .setRequiredBoardSize(5)
        .setRequiredTimeLimitInMin(10)
        .build();
    GameCoordinator gameCoordinator = new GameCoordinator(gameInfo, Flags.MOVE_ENGINE_TYPE);
    new GtpService(System.in, System.out, gameCoordinator).startAsync();
  }

  private final InputStream inputStream;
  private final PrintStream printStream;
  private final GameCoordinator gameCoordinator;

  /**
   * Why we need to use {@link InputStream}?
   * <ul>
   *   <li>{@link java.io.Console} does not work with Eclipse.
   *   <li>The while-loop in {@link #run()} could be exited by utilizing {#link InputStream#close()}
   *       which would eventually trigger an {@link IOException}.
   *   <li>Neither {@link InputStreamReader#close()} nor {@link BufferedReader#close()} would
   *       trigger an {@link IOException}.
   *   <li>Note: {@link java.io.ByteArrayInputStream#close()} does not trigger {@link IOException}.
   * </ul>
   */
  public GtpService(
      @Nonnull InputStream inputStream,
      @Nonnull PrintStream printStream,
      @Nonnull GameCoordinator gameCoordinator) {
    this.inputStream = inputStream;
    this.printStream = printStream;
    this.gameCoordinator = gameCoordinator;

    gameCoordinator.startGame();
  }

  private void printSuccess(@Nonnull Optional<Integer> commandIdOptional, @Nonnull String message) {
    StringBuilder sb = new StringBuilder();
    sb.append(GTP_OUTPUT_PREFIX_SUCCESS);
    if (commandIdOptional.isPresent()) {
      sb.append('[');
      sb.append(commandIdOptional.get());
      sb.append(']');
    }
    sb.append(' ');
    sb.append(message);
    sb.append('\n');
    printStream.println(sb.toString());
  }

  private void printFailure(@Nonnull Optional<Integer> commandIdOptional, @Nonnull String message) {
    StringBuilder sb = new StringBuilder();
    sb.append(GTP_OUTPUT_PREFIX_FAILURE);
    if (commandIdOptional.isPresent()) {
      sb.append('[');
      sb.append(commandIdOptional.get());
      sb.append(']');
    }
    sb.append(' ');
    sb.append(message);
    sb.append('\n');
    printStream.println(sb.toString());
  }

  private void printFailure(@Nonnull String message) {
    printFailure(Optional.<Integer>absent(), message);
  }

  private void printFailureWithInvalidCommandLine(
      @Nonnull Optional<Integer> commandIdOptional,
      @Nonnull String commandLine) {
    printFailure(commandIdOptional, GTP_OUTPUT_SYNTAX_ERROR + " '" + commandLine + "'");
  }

  private void printFailureWithInvalidCommandLine(@Nonnull String commandLine) {
    printFailureWithInvalidCommandLine(Optional.<Integer>absent(), commandLine);
  }

  @Override protected void run() {
    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
    BufferedReader reader = new BufferedReader(inputStreamReader);
    try {
      String commandLine = null;
      do {
        commandLine = reader.readLine();
        processCommand(commandLine);
      } while (!GTP_CMD_QUIT.equalsIgnoreCase(commandLine));
    } catch (IOException exception) {
      // The above while-loop could be exited by closing the input stream, and then reachs here.
      printFailure(exception.getMessage());
    }
  }

  private void processCommand(String commandLine) {
    if (Strings.isNullOrEmpty(commandLine)) {
      printFailure("Command line is empty.");
      return;
    }

    // Note: There will at least one arg even when the trimmed string is empty.
    String[] wholeArgs = commandLine.trim().toLowerCase().split("\\s+");
    if (wholeArgs.length == 0) {
      printFailureWithInvalidCommandLine(commandLine);
      return;
    }

    Optional<Integer> commandIdOptional;
    String commandName;
    String[] commandArgs;
    try {
      int commandId = Integer.parseInt(wholeArgs[0]);
      // Successful parsing means that command ID exists. So there must be 2+ args.
      if (wholeArgs.length == 1) {
        printFailureWithInvalidCommandLine(commandLine);
        return;
      }
      commandIdOptional = Optional.of(commandId);
      commandName = wholeArgs[1];
      commandArgs = Arrays.copyOfRange(wholeArgs, 2, wholeArgs.length);
    } catch (NumberFormatException ignored) {
      // Parsing exception means no command ID.
      commandIdOptional = Optional.absent();
      commandName = wholeArgs[0];
      commandArgs = Arrays.copyOfRange(wholeArgs, 1, wholeArgs.length);
    }

    switch (commandName) {
      case GTP_CMD_LIST_COMMANDS:
        if (commandArgs.length != 0) {
          printFailureWithInvalidCommandLine(commandIdOptional, commandLine);
          return;
        }
        handleListCommands(commandIdOptional);
        break;
      case GTP_CMD_PROTOCOL_VERSION:
        if (commandArgs.length != 0) {
          printFailureWithInvalidCommandLine(commandIdOptional, commandLine);
          return;
        }
        handleProtocolVersion(commandIdOptional);
        break;
      case GTP_CMD_PROGRAM_NAME:
        if (commandArgs.length != 0) {
          printFailureWithInvalidCommandLine(commandIdOptional, commandLine);
          return;
        }
        handleProgramName(commandIdOptional);
        break;
      case GTP_CMD_PROGRAM_VERSION:
        if (commandArgs.length != 0) {
          printFailureWithInvalidCommandLine(commandIdOptional, commandLine);
          return;
        }
        handleProgramVersion(commandIdOptional);
        break;
      case GTP_CMD_BOARD_SIZE:
        if (commandArgs.length != 1) {
          printFailureWithInvalidCommandLine(commandIdOptional, commandLine);
          return;
        }
        handleBoardSize(commandIdOptional, commandArgs[0]);
        break;
      case GTP_CMD_CLEAR_BOARD:
        if (commandArgs.length != 0) {
          printFailureWithInvalidCommandLine(commandIdOptional, commandLine);
          return;
        }
        handleClearBoard(commandIdOptional);
        break;
      case GTP_CMD_KOMI:
        if (commandArgs.length != 1) {
          printFailureWithInvalidCommandLine(commandIdOptional, commandLine);
          return;
        }
        handleKomi(commandIdOptional, commandArgs[0]);
        break;
      case GTP_CMD_HUMAN_PLAY:
        if (commandArgs.length != 2) {
          printFailureWithInvalidCommandLine(commandIdOptional, commandLine);
          return;
        }
        handleHumanPlay(commandIdOptional, commandArgs[0], commandArgs[1]);
        break;
      case GTP_CMD_GENMOVE:
        if (commandArgs.length != 1) {
          printFailureWithInvalidCommandLine(commandIdOptional, commandLine);
          return;
        }
        handleComputerGenmoveTakingLongTime(commandIdOptional, commandArgs[0]);
        break;
      case GTP_CMD_HUMAN_UNDO:
        if (commandArgs.length != 0) {
          printFailureWithInvalidCommandLine(commandIdOptional, commandLine);
          return;
        }
        handleUndo(commandIdOptional);
        break;
      case GTP_CMD_FINAL_SCORE:
        if (commandArgs.length != 0) {
          printFailureWithInvalidCommandLine(commandIdOptional, commandLine);
          return;
        }
        handleFinalScore(commandIdOptional);
        break;
      case GTP_CMD_QUIT:
        if (commandArgs.length != 0) {
          printFailureWithInvalidCommandLine(commandIdOptional, commandLine);
          return;
        }
        handleQuit(commandIdOptional);
        break;
      default:
        printFailureWithInvalidCommandLine(commandIdOptional, commandLine);
        break;
    }
  }

  private void handleListCommands(@Nonnull Optional<Integer> commandIdOptional) {
    printSuccess(commandIdOptional,
        GTP_CMD_LIST_COMMANDS + "\n"
        + GTP_CMD_PROTOCOL_VERSION + "\n"
        + GTP_CMD_PROGRAM_NAME + "\n"
        + GTP_CMD_PROGRAM_VERSION + "\n"
        + GTP_CMD_BOARD_SIZE + "\n"
        + GTP_CMD_CLEAR_BOARD + "\n"
        + GTP_CMD_KOMI + "\n"
        + GTP_CMD_HUMAN_PLAY + "\n"
        + GTP_CMD_GENMOVE + "\n"
        + GTP_CMD_HUMAN_UNDO + "\n"
        + GTP_CMD_QUIT);
  }

  private void handleProtocolVersion(@Nonnull Optional<Integer> commandIdOptional) {
    printSuccess(commandIdOptional, GTP_OUTPUT_PROTOCOL_VERSION);
  }

  private void handleProgramName(@Nonnull Optional<Integer> commandIdOptional) {
    printSuccess(commandIdOptional, GTP_OUTPUT_PROGRAM_NAME);
  }

  private void handleProgramVersion(@Nonnull Optional<Integer> commandIdOptional) {
    printSuccess(commandIdOptional, GTP_OUTPUT_PROGRAM_VERSION);
  }

  // TODO 200 Support handleBoardSize()
  private void handleBoardSize(
      @Nonnull Optional<Integer> commandIdOptional,
      @Nonnull String boardSizeString) {
    int boardSize = Integer.parseInt(boardSizeString);
    printSuccess(commandIdOptional, GTP_OUTPUT_COMMENT + " boardSize=" + boardSize);
  }

  // TODO 200 Support handleClearBoard()
  private void handleClearBoard(@Nonnull Optional<Integer> commandIdOptional) {
    printSuccess(commandIdOptional, GTP_OUTPUT_COMMENT + " in handleClearBoard()");
  }

  // TODO 200 Support handleKomi()
  private void handleKomi(
      @Nonnull Optional<Integer> commandIdOptional,
      @Nonnull String komiString) {
    printSuccess(commandIdOptional, GTP_OUTPUT_COMMENT + " komi=" + komiString);
  }

  private void handleHumanPlay(
      @Nonnull Optional<Integer> commandIdOptional,
      @Nonnull String colorString, @Nonnull String vertexString) {
    try {
      Color color = Color.instanceOf(colorString);
      GtpVertex gtpVertex = GtpVertex.instanceOf(vertexString);

      // Verify color.
      Color expectedColorForNextMove = gameCoordinator.findColorForNextMove();
      if (expectedColorForNextMove != color) {
        printFailure(commandIdOptional, "Invalid color: " + color);
        return;
      }

      if (gtpVertex.isPass()) {
        boolean isTwoConsecutivePasses = gameCoordinator.handleHumanPassMove(color);
        if (isTwoConsecutivePasses) {
          printSuccess(commandIdOptional, GTP_OUTPUT_COMMENT + " in handleHumanPlay() 2 passes ");
          return;
        }
      } else {
        MoveType moveType = gameCoordinator.handleHumanMoveAtCoord(
            color, gtpVertex.getXPosition(), gtpVertex.getYPosition());
        if (moveType.isIllegalMove()) {
          printFailure(GTP_OUTPUT_ILLEGAL_MOVE);
          return;
        }
      }
      printSuccess(commandIdOptional,
          GTP_OUTPUT_COMMENT + " handleHumanPlay w/ vertex=" + vertexString);
    } catch (InvalidColorException | InvalidVertexException e) {
      printFailure(commandIdOptional, e.getMessage());
      return;
    }
  }

  private void handleComputerGenmoveTakingLongTime(
      @Nonnull Optional<Integer> commandIdOptional,
      @Nonnull String colorString) {
    try {
      Color color = Color.instanceOf(colorString);

      // Verify color.
      Color expectedColorForNextMove = gameCoordinator.findColorForNextMove();
      if (expectedColorForNextMove != color) {
        printFailure(commandIdOptional, "Invalid color: " + color);
        return;
      }

      // Handle computer genmove.
      gameCoordinator.askComputerToGenNextMoveTakingLongTime(color);
      MoveHandling resultMoveHandling = gameCoordinator.getLatestMoveHandling();
      if (resultMoveHandling.getMoveType() == MoveType.MOVE_PASS) {
        printSuccess(commandIdOptional, GtpVertex.VERTEX_PASS);
        return;
      } else {
        Optional<Coord> resultCoordOptional = resultMoveHandling.getMoveCoordOptional();
        Coord resultCoord = resultCoordOptional.get();
        String vertexString = resultCoord.toGtpVertexString();
        printSuccess(commandIdOptional, vertexString);
        return;
      }
    } catch (InvalidColorException e) {
      printFailure(commandIdOptional, e.getMessage());
      return;
    }
  }

  private void handleUndo(@Nonnull Optional<Integer> commandIdOptional) {
    gameCoordinator.handleUndoMove();
    printSuccess(commandIdOptional, GTP_OUTPUT_COMMENT + " in handleUndo()");
  }

  // TODO 200 Support handleFinalScore()
  private void handleFinalScore(@Nonnull Optional<Integer> commandIdOptional) {
    printSuccess(commandIdOptional, GTP_OUTPUT_COMMENT + " in handleFinalScore()");
  }

  // TODO 200 Support handleQuit()
  private void handleQuit(@Nonnull Optional<Integer> commandIdOptional) {
    printSuccess(commandIdOptional, GTP_OUTPUT_COMMENT + " in handleQuit()");
  }

  @Override protected void triggerShutdown() {
    try {
      inputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
