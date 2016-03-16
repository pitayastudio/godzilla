package com.pitayastudio.godzilla.sgf;

import com.google.common.base.Optional;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.MoveType;
import com.pitayastudio.godzilla.computerplayer.MoveHandling;
import com.pitayastudio.godzilla.game.GameCoordinator;
import com.pitayastudio.godzilla.game.GameInfo;
import com.pitayastudio.godzilla.game.GameResult;
import com.pitayastudio.godzilla.game.PlayStage;
import com.pitayastudio.godzilla.model.Coord;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

import javax.annotation.Nonnull;

/**
 * SGF Writer for end game.
 */
public class SgfWriter {
  private static final Logger logger = Logger.getLogger(SgfWriter.class.getName());

  private GameCoordinator gameCoordinator;
  private StringBuilder sbContent;

  public SgfWriter(@Nonnull GameCoordinator gameCoordinator) {
    this.gameCoordinator = gameCoordinator;
    assert gameCoordinator.getMutableGameStatus().getCurrentPlayStage()
        == PlayStage.PLAY_STAGE_STOPPED;

    sbContent = new StringBuilder();
    initialize();
  }

  private void initialize() {
    // Write group start:
    sbContent.append('(');

    writeTheFirstNode();
    writeTheMoves();
    writeTheLastNode();

    // Write group end:
    sbContent.append("\n)");
  }

  private void writeTheFirstNode() {
    GameInfo gameInfo = gameCoordinator.getGameInfo();
    GameResult gameResult = gameCoordinator.getGameResult();

    sbContent.append("\n;GM[1]FF[4]");
    sbContent.append("GN[").append(gameInfo.getGameName()).append("]");
    sbContent.append("SZ[").append(gameInfo.getBoardSize()).append("]");
    sbContent.append("DT[").append(gameInfo.getGameDate()).append("]");
    // TODO 200 Verify possible values of RU (rule) in SGF file.
    sbContent.append("RU[").append("CHINA").append("]");
    sbContent.append("KM[").append(gameInfo.getKomi()).append("]");
    sbContent.append("HA[").append(gameInfo.getHandicapCount()).append("]");

    // Write game result:
    Color colorWinner = gameResult.getColorOfWinner();
    String stColorWinner = (colorWinner == Color.B) ? "B" : "W";
    double dbWinPointsByJapanRule = gameResult.calcWinPointsByJapanRule();
    sbContent.append("\nRE[").append(stColorWinner).append('+');
    if (gameResult.isResigned()) {
      sbContent.append("Resign]");
    } else {
      sbContent.append(dbWinPointsByJapanRule).append(']');
    }
  }

  private void writeTheMoves() {
    sbContent.append('\n');
    int inHistSz = gameCoordinator.findNumberOfMoves();
    int boardSize = gameCoordinator.getCoordBoard().getBoardSize();
    for (int i = 1; i <= inHistSz; i++) {  // note that i starts at 1
      MoveHandling moveHandling = gameCoordinator.getMoveHandlingAtMoveCount(i);
      if (moveHandling.getMoveType() != MoveType.MOVE_PASS) {
        Optional<Coord> coordOptional = moveHandling.getMoveCoordOptional();
        assert(coordOptional.isPresent());
        Coord coord = coordOptional.get();
        Color colorOfMove = moveHandling.getMoveColor();
        int xPosition = coord.getXPosition();
        int yPosition = coord.getYPosition();
        char chX = Coord.convertSgfXPositionToSgfChar(xPosition);
        char chY = Coord.convertSgfYPositionToSgfChar(yPosition, boardSize);
        sbContent.append(';').append(colorOfMove.toString());
        sbContent.append('[').append(chX).append(chY).append("] ");
      }

      // Make it human-readable.
      if (i % 10 == 0) {
        sbContent.append('\n');
      }
    }
  }

  private void writeTheLastNode() {
    sbContent.append('\n');
  }

  public void saveToFile() {
    try (FileWriter fileWriter = new FileWriter("New.sgf")) {
      fileWriter.write(sbContent.toString());
      fileWriter.flush();
    } catch (IOException e) {
      logger.severe(e.getMessage());
    }
  }

  @Override
  public String toString() {
    return sbContent.toString();
  }
}
