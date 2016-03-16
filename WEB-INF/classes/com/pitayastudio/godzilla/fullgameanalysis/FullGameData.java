package com.pitayastudio.godzilla.fullgameanalysis;

import com.pitayastudio.godzilla.common.Color;
import com.pitayastudio.godzilla.common.PositionStateChars;
import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.modelboard.CoordBoard;
import com.pitayastudio.godzilla.modelboard.VisualBoard;

import java.util.ArrayList;
import java.util.List;

// TODO 150 Apply FullGameData to tests.
public class FullGameData {
  public static class OneMoveData {
    private CoordBoard coordBoard;
    private String boardInput;
    private Color colorOfNextMove;
    private Coord coordOfExpectedNextMove;

    private OneMoveData(String boardInput, Color colorOfNextMove) {
      this.boardInput = boardInput;
      this.colorOfNextMove = colorOfNextMove;
      int boardSize = VisualBoard.getBoardSizeFromBoardInput(boardInput);
      this.coordBoard = new CoordBoard(boardSize);
      this.coordOfExpectedNextMove =
          Coord.readFromStringIfAny(boardInput, coordBoard , PositionStateChars.A);
    }

    public CoordBoard getCoordBoard() {
      return this.coordBoard;
    }

    public String getBoardInput() {
      return boardInput;
    }

    public Color getColorOfNextMove() {
      return colorOfNextMove;
    }

    public Coord getCoordOfExpectedNextMove() {
      return this.coordOfExpectedNextMove;
    }
  }

  private List<OneMoveData> listOfOneMoveData = new ArrayList<>();
  public List<OneMoveData> getListOfOneMoveData() {
    return this.listOfOneMoveData;
  }

  public FullGameData() {
    listOfOneMoveData.add(constructOneMoveData_001());
    listOfOneMoveData.add(constructOneMoveData_002());
    listOfOneMoveData.add(constructOneMoveData_003());
    listOfOneMoveData.add(constructOneMoveData_004());
    listOfOneMoveData.add(constructOneMoveData_005());
    listOfOneMoveData.add(constructOneMoveData_006());
    listOfOneMoveData.add(constructOneMoveData_007());
    listOfOneMoveData.add(constructOneMoveData_008());
    listOfOneMoveData.add(constructOneMoveData_009());
    listOfOneMoveData.add(constructOneMoveData_010());
    listOfOneMoveData.add(constructOneMoveData_011());
    listOfOneMoveData.add(constructOneMoveData_012());
    listOfOneMoveData.add(constructOneMoveData_013());
    listOfOneMoveData.add(constructOneMoveData_014());
    listOfOneMoveData.add(constructOneMoveData_015());
    listOfOneMoveData.add(constructOneMoveData_016());
    listOfOneMoveData.add(constructOneMoveData_017());
    listOfOneMoveData.add(constructOneMoveData_018());
    listOfOneMoveData.add(constructOneMoveData_019());
    listOfOneMoveData.add(constructOneMoveData_020());
    listOfOneMoveData.add(constructOneMoveData_021());
    listOfOneMoveData.add(constructOneMoveData_022());
    listOfOneMoveData.add(constructOneMoveData_023());
    listOfOneMoveData.add(constructOneMoveData_024());
    listOfOneMoveData.add(constructOneMoveData_025());
    listOfOneMoveData.add(constructOneMoveData_026());
    listOfOneMoveData.add(constructOneMoveData_027());
    listOfOneMoveData.add(constructOneMoveData_028());
    listOfOneMoveData.add(constructOneMoveData_029());
    listOfOneMoveData.add(constructOneMoveData_030());
    listOfOneMoveData.add(constructOneMoveData_031());
    listOfOneMoveData.add(constructOneMoveData_032());
    listOfOneMoveData.add(constructOneMoveData_033());
    listOfOneMoveData.add(constructOneMoveData_034());
    listOfOneMoveData.add(constructOneMoveData_035());
    listOfOneMoveData.add(constructOneMoveData_036());
    listOfOneMoveData.add(constructOneMoveData_037());
    listOfOneMoveData.add(constructOneMoveData_038());
    listOfOneMoveData.add(constructOneMoveData_039());
    listOfOneMoveData.add(constructOneMoveData_040());
    listOfOneMoveData.add(constructOneMoveData_041());
    listOfOneMoveData.add(constructOneMoveData_042());
    listOfOneMoveData.add(constructOneMoveData_043());
    listOfOneMoveData.add(constructOneMoveData_044());
    listOfOneMoveData.add(constructOneMoveData_045());
    listOfOneMoveData.add(constructOneMoveData_046());
    listOfOneMoveData.add(constructOneMoveData_047());
    listOfOneMoveData.add(constructOneMoveData_048());
    listOfOneMoveData.add(constructOneMoveData_049());
    listOfOneMoveData.add(constructOneMoveData_050());
    listOfOneMoveData.add(constructOneMoveData_051());
    listOfOneMoveData.add(constructOneMoveData_052());
    listOfOneMoveData.add(constructOneMoveData_053());
    listOfOneMoveData.add(constructOneMoveData_054());
    listOfOneMoveData.add(constructOneMoveData_055());
    listOfOneMoveData.add(constructOneMoveData_056());
    listOfOneMoveData.add(constructOneMoveData_057());
    listOfOneMoveData.add(constructOneMoveData_058());
    listOfOneMoveData.add(constructOneMoveData_059());
    listOfOneMoveData.add(constructOneMoveData_060());
    listOfOneMoveData.add(constructOneMoveData_061());
    listOfOneMoveData.add(constructOneMoveData_062());
    listOfOneMoveData.add(constructOneMoveData_063());
    listOfOneMoveData.add(constructOneMoveData_064());
    listOfOneMoveData.add(constructOneMoveData_065());
    listOfOneMoveData.add(constructOneMoveData_066());
    listOfOneMoveData.add(constructOneMoveData_067());
    listOfOneMoveData.add(constructOneMoveData_068());
    listOfOneMoveData.add(constructOneMoveData_069());
    listOfOneMoveData.add(constructOneMoveData_070());
    listOfOneMoveData.add(constructOneMoveData_071());
    listOfOneMoveData.add(constructOneMoveData_072());
    listOfOneMoveData.add(constructOneMoveData_073());
    listOfOneMoveData.add(constructOneMoveData_074());
    listOfOneMoveData.add(constructOneMoveData_075());
    listOfOneMoveData.add(constructOneMoveData_076());
    listOfOneMoveData.add(constructOneMoveData_077());
    listOfOneMoveData.add(constructOneMoveData_078());
    listOfOneMoveData.add(constructOneMoveData_079());
    listOfOneMoveData.add(constructOneMoveData_080());
    listOfOneMoveData.add(constructOneMoveData_081());
    listOfOneMoveData.add(constructOneMoveData_082());
    listOfOneMoveData.add(constructOneMoveData_083());
    listOfOneMoveData.add(constructOneMoveData_084());
    listOfOneMoveData.add(constructOneMoveData_085());
    listOfOneMoveData.add(constructOneMoveData_086());
    listOfOneMoveData.add(constructOneMoveData_087());
    listOfOneMoveData.add(constructOneMoveData_088());
    listOfOneMoveData.add(constructOneMoveData_089());
    listOfOneMoveData.add(constructOneMoveData_090());
    listOfOneMoveData.add(constructOneMoveData_091());
    listOfOneMoveData.add(constructOneMoveData_092());
    listOfOneMoveData.add(constructOneMoveData_093());
    listOfOneMoveData.add(constructOneMoveData_094());
    listOfOneMoveData.add(constructOneMoveData_095());
    listOfOneMoveData.add(constructOneMoveData_096());
    listOfOneMoveData.add(constructOneMoveData_097());
    listOfOneMoveData.add(constructOneMoveData_098());
    listOfOneMoveData.add(constructOneMoveData_099());
    listOfOneMoveData.add(constructOneMoveData_100());

    listOfOneMoveData.add(constructOneMoveData_101());
    listOfOneMoveData.add(constructOneMoveData_102());
    listOfOneMoveData.add(constructOneMoveData_103());
    listOfOneMoveData.add(constructOneMoveData_104());
    listOfOneMoveData.add(constructOneMoveData_105());
    listOfOneMoveData.add(constructOneMoveData_106());
    listOfOneMoveData.add(constructOneMoveData_107());
    listOfOneMoveData.add(constructOneMoveData_108());
    listOfOneMoveData.add(constructOneMoveData_109());
    listOfOneMoveData.add(constructOneMoveData_110());
    listOfOneMoveData.add(constructOneMoveData_111());
    listOfOneMoveData.add(constructOneMoveData_112());
    listOfOneMoveData.add(constructOneMoveData_113());
    listOfOneMoveData.add(constructOneMoveData_114());
    listOfOneMoveData.add(constructOneMoveData_115());
    listOfOneMoveData.add(constructOneMoveData_116());
    listOfOneMoveData.add(constructOneMoveData_117());
    listOfOneMoveData.add(constructOneMoveData_118());
    listOfOneMoveData.add(constructOneMoveData_119());
    listOfOneMoveData.add(constructOneMoveData_120());
    listOfOneMoveData.add(constructOneMoveData_121());
    listOfOneMoveData.add(constructOneMoveData_122());
    listOfOneMoveData.add(constructOneMoveData_123());
    listOfOneMoveData.add(constructOneMoveData_124());
    listOfOneMoveData.add(constructOneMoveData_125());
    listOfOneMoveData.add(constructOneMoveData_126());
    listOfOneMoveData.add(constructOneMoveData_127());
    listOfOneMoveData.add(constructOneMoveData_128());
    listOfOneMoveData.add(constructOneMoveData_129());
    listOfOneMoveData.add(constructOneMoveData_130());
    listOfOneMoveData.add(constructOneMoveData_131());
    listOfOneMoveData.add(constructOneMoveData_132());
    listOfOneMoveData.add(constructOneMoveData_133());
    listOfOneMoveData.add(constructOneMoveData_134());
    listOfOneMoveData.add(constructOneMoveData_135());
    listOfOneMoveData.add(constructOneMoveData_136());
    listOfOneMoveData.add(constructOneMoveData_137());
    listOfOneMoveData.add(constructOneMoveData_138());
    listOfOneMoveData.add(constructOneMoveData_139());
    listOfOneMoveData.add(constructOneMoveData_140());
    listOfOneMoveData.add(constructOneMoveData_141());
    listOfOneMoveData.add(constructOneMoveData_142());
    listOfOneMoveData.add(constructOneMoveData_143());
    listOfOneMoveData.add(constructOneMoveData_144());
    listOfOneMoveData.add(constructOneMoveData_145());
    listOfOneMoveData.add(constructOneMoveData_146());
    listOfOneMoveData.add(constructOneMoveData_147());
    listOfOneMoveData.add(constructOneMoveData_148());
    listOfOneMoveData.add(constructOneMoveData_149());
    listOfOneMoveData.add(constructOneMoveData_150());
    listOfOneMoveData.add(constructOneMoveData_151());
    listOfOneMoveData.add(constructOneMoveData_152());
    listOfOneMoveData.add(constructOneMoveData_153());
    listOfOneMoveData.add(constructOneMoveData_154());
    listOfOneMoveData.add(constructOneMoveData_155());
    listOfOneMoveData.add(constructOneMoveData_156());
    listOfOneMoveData.add(constructOneMoveData_157());
    listOfOneMoveData.add(constructOneMoveData_158());
    listOfOneMoveData.add(constructOneMoveData_159());
    listOfOneMoveData.add(constructOneMoveData_160());
    listOfOneMoveData.add(constructOneMoveData_161());
    listOfOneMoveData.add(constructOneMoveData_162());
    listOfOneMoveData.add(constructOneMoveData_163());
    listOfOneMoveData.add(constructOneMoveData_164());
    listOfOneMoveData.add(constructOneMoveData_165());
    listOfOneMoveData.add(constructOneMoveData_166());
    listOfOneMoveData.add(constructOneMoveData_167());
    listOfOneMoveData.add(constructOneMoveData_168());
    listOfOneMoveData.add(constructOneMoveData_169());
    listOfOneMoveData.add(constructOneMoveData_170());
    listOfOneMoveData.add(constructOneMoveData_171());
    listOfOneMoveData.add(constructOneMoveData_172());
    listOfOneMoveData.add(constructOneMoveData_173());
    listOfOneMoveData.add(constructOneMoveData_174());
    listOfOneMoveData.add(constructOneMoveData_175());
    listOfOneMoveData.add(constructOneMoveData_176());
    listOfOneMoveData.add(constructOneMoveData_177());
    listOfOneMoveData.add(constructOneMoveData_178());
    listOfOneMoveData.add(constructOneMoveData_179());
    listOfOneMoveData.add(constructOneMoveData_180());
    listOfOneMoveData.add(constructOneMoveData_181());
    listOfOneMoveData.add(constructOneMoveData_182());
    listOfOneMoveData.add(constructOneMoveData_183());
    listOfOneMoveData.add(constructOneMoveData_184());
    listOfOneMoveData.add(constructOneMoveData_185());
    listOfOneMoveData.add(constructOneMoveData_186());
    listOfOneMoveData.add(constructOneMoveData_187());
    listOfOneMoveData.add(constructOneMoveData_188());
    listOfOneMoveData.add(constructOneMoveData_189());
    listOfOneMoveData.add(constructOneMoveData_190());
    listOfOneMoveData.add(constructOneMoveData_191());
    listOfOneMoveData.add(constructOneMoveData_192());
    listOfOneMoveData.add(constructOneMoveData_193());
    listOfOneMoveData.add(constructOneMoveData_194());
    listOfOneMoveData.add(constructOneMoveData_195());
    listOfOneMoveData.add(constructOneMoveData_196());
    listOfOneMoveData.add(constructOneMoveData_197());
    listOfOneMoveData.add(constructOneMoveData_198());
    listOfOneMoveData.add(constructOneMoveData_199());
    listOfOneMoveData.add(constructOneMoveData_200());

    listOfOneMoveData.add(constructOneMoveData_201());
    listOfOneMoveData.add(constructOneMoveData_202());
    listOfOneMoveData.add(constructOneMoveData_203());
    listOfOneMoveData.add(constructOneMoveData_204());
    listOfOneMoveData.add(constructOneMoveData_205());
    listOfOneMoveData.add(constructOneMoveData_206());
    listOfOneMoveData.add(constructOneMoveData_207());
    listOfOneMoveData.add(constructOneMoveData_208());
    listOfOneMoveData.add(constructOneMoveData_209());
    listOfOneMoveData.add(constructOneMoveData_210());
    listOfOneMoveData.add(constructOneMoveData_211());
    listOfOneMoveData.add(constructOneMoveData_212());
    listOfOneMoveData.add(constructOneMoveData_213());
    listOfOneMoveData.add(constructOneMoveData_214());
    listOfOneMoveData.add(constructOneMoveData_215());
    listOfOneMoveData.add(constructOneMoveData_216());
    listOfOneMoveData.add(constructOneMoveData_217());
  }

  private static OneMoveData constructOneMoveData_001() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦•◦◦◦◦◦•◦◦◦◦◦A◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦•◦◦◦◦◦•◦◦◦◦◦•◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦•◦◦◦◦◦•◦◦◦◦◦•◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    //return new OneMoveData(boardInput, Color.B);
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_002() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦A◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦•◦◦◦◦◦•◦◦◦◦◦•◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦•◦◦◦◦◦•◦◦◦◦◦•◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_003() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦•◦◦◦◦◦•◦◦◦◦◦•◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦•◦◦◦◦◦•◦◦◦◦◦A◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_004() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦•◦◦◦◦◦•◦◦◦◦◦•◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦A◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_005() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦•◦◦◦◦◦•◦◦◦◦◦A◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_006() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦A◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦•◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_007() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦A◦○◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦•◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_008() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦◦A◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦•◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_009() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦◦○◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦◦●A◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦•◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_010() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦A○◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦◦●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦•◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_011() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦A●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦•◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_012() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦A◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦•◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_013() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦A◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦•◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_014() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦•◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦A◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_015() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦•◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•A◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_016() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦•◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦A◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_017() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦•◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦◦◦◦●A◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦○◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_018() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦•◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦◦◦◦●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦A○◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_019() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦•◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦◦◦A●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦○○◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_020() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦•◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦◦◦●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦○○A◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_021() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦•◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦◦A●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_022() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦•◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦◦●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦A○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_023() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦•◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦A●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_024() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦A◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_025() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦A◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_026() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦A◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_027() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦A◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_028() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦A◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_029() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦A◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_030() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦A◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_031() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦A◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_032() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦A◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_033() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦A◦●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_034() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦◦A◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦●◦●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_035() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦A●◦●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_036() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦A○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_037() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦A◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_038() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦A◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_039() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦A◦○◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_040() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦A◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_041() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦A◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_042() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦●◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦A◦◦◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_043() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦●◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦○◦A◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_044() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦●◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦○A●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_045() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦●◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦◦◦◦◦A◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_046() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦●◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦◦◦◦A◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_047() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦●◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦◦◦◦○A◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_048() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦●◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦◦◦◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦A◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_049() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦●◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦◦◦◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦A◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_050() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦●◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦◦◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦A◦◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦●◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_051() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•◦●◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦◦A◦◦●◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦○◦◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦●◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_052() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•A●◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦◦●◦◦●◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦○◦◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦●◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_053() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●◦A◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•○●◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦◦●◦◦●◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦○◦◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦●◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_054() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●◦●◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•○●◦◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦A●◦◦●◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦○◦◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦●◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_055() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●◦●◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•○●A◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦○◦◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦●◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_056() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●◦●◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦A○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦○◦◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦●◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_057() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●A●◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦○◦◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦●◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_058() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦○◦◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦●◦◦○◦A◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_059() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦○◦◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦●◦◦○◦○A◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_060() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦○◦◦○●◦◦"
      + "◦◦A◦◦◦◦◦◦◦●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_061() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦◦A◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦○◦◦○●◦◦"
      + "◦◦○◦◦◦◦◦◦◦●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_062() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦A●◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦○◦◦○●◦◦"
      + "◦◦○◦◦◦◦◦◦◦●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_063() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦A◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦○●◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦◦○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦○◦◦○●◦◦"
      + "◦◦○◦◦◦◦◦◦◦●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_064() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦○●◦◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦A○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦○◦◦○●◦◦"
      + "◦◦○◦◦◦◦◦◦◦●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_065() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦○●A◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦○○◦●◦◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦○◦◦○●◦◦"
      + "◦◦○◦◦◦◦◦◦◦●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_066() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦○●●◦◦◦◦◦◦●◦○◦○○◦◦"
      + "◦◦○○◦●A◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦○◦◦○●◦◦"
      + "◦◦○◦◦◦◦◦◦◦●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_067() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦"
      + "◦◦○●●◦◦◦◦◦◦●◦○◦○○A◦"
      + "◦◦○○◦●○◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦○◦◦○●◦◦"
      + "◦◦○◦◦◦◦◦◦◦●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_068() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●◦◦◦◦◦◦◦◦◦◦○◦◦◦A◦"
      + "◦◦○●●◦◦◦◦◦◦●◦○◦○○●◦"
      + "◦◦○○◦●○◦◦•◦◦◦◦●●●◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦○◦◦○●◦◦"
      + "◦◦○◦◦◦◦◦◦◦●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_069() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●◦◦◦◦◦◦◦◦◦◦○◦◦◦○◦"
      + "◦◦○●●◦◦◦◦◦◦●◦○◦○○●◦"
      + "◦◦○○◦●○◦◦•◦◦◦◦●●●A◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦○◦◦○●◦◦"
      + "◦◦○◦◦◦◦◦◦◦●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_070() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●◦◦A◦◦◦◦◦◦◦○◦◦◦○◦"
      + "◦◦○●●◦◦◦◦◦◦●◦○◦○○●◦"
      + "◦◦○○◦●○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦○◦◦○●◦◦"
      + "◦◦○◦◦◦◦◦◦◦●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_071() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●◦A○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "◦◦○●●◦◦◦◦◦◦●◦○◦○○●◦"
      + "◦◦○○◦●○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦○◦◦○●◦◦"
      + "◦◦○◦◦◦◦◦◦◦●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_072() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●◦●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "◦◦○●●A◦◦◦◦◦●◦○◦○○●◦"
      + "◦◦○○◦●○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦○◦◦○●◦◦"
      + "◦◦○◦◦◦◦◦◦◦●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_073() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●◦●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "◦A○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦◦○○◦●○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦○◦◦○●◦◦"
      + "◦◦○◦◦◦◦◦◦◦●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_074() {
    String boardInput =
        "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●◦●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "◦●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦A○○◦●○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦○◦◦○●◦◦"
      + "◦◦○◦◦◦◦◦◦◦●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_075() {
    String boardInput =
        "◦A◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●◦●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "◦●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○◦●○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦○◦◦○●◦◦"
      + "◦◦○◦◦◦◦◦◦◦●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_076() {
    String boardInput =
        "◦●◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●◦●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "◦●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○A●○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦○◦◦○●◦◦"
      + "◦◦○◦◦◦◦◦◦◦●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_077() {
    String boardInput =
        "◦●◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●◦●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "A●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦○◦◦○●◦◦"
      + "◦◦○◦◦◦◦◦◦◦●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_078() {
    String boardInput =
        "◦●◦◦A◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●◦●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦○◦◦○●◦◦"
      + "◦◦○◦◦◦◦◦◦◦●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_079() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●A●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦○◦◦○●◦◦"
      + "◦◦○◦◦◦◦◦◦◦●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_080() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦◦◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦○◦◦○●◦◦"
      + "◦◦○◦◦◦◦◦◦◦●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦A◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_081() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦A◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦○◦◦○●◦◦"
      + "◦◦○◦◦◦◦◦◦◦●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_082() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦A○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦◦◦◦◦●◦○◦◦○◦◦○●◦◦"
      + "◦◦○◦◦◦◦◦◦◦●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_083() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦A◦◦◦●◦○◦◦○◦◦○●◦◦"
      + "◦◦○◦◦◦◦◦◦◦●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_084() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦●◦◦◦●◦○◦◦○◦◦○●◦◦"
      + "◦◦○A◦◦◦◦◦◦●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_085() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦●◦◦◦●◦○◦◦○◦◦○●◦◦"
      + "◦◦○○◦◦◦◦◦◦●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦A◦◦◦◦◦○○◦○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_086() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦●◦◦◦●◦○◦◦○◦◦○●◦◦"
      + "◦◦○○◦◦◦◦◦◦●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦●◦◦◦A◦○○◦○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_087() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦●◦◦◦●◦○◦◦○◦◦○●◦◦"
      + "◦◦○○◦◦◦◦◦◦●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦●◦◦A○◦○○◦○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_088() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦●◦◦◦●◦○◦◦○◦◦○●◦◦"
      + "◦◦○○◦◦◦◦◦◦●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦●◦◦●○A○○◦○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_089() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦◦◦◦○◦○○●◦◦◦"
      + "◦◦◦●◦◦◦●◦○A◦○◦◦○●◦◦"
      + "◦◦○○◦◦◦◦◦◦●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦●◦◦●○○○○◦○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_090() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦◦◦A○◦○○●◦◦◦"
      + "◦◦◦●◦◦◦●◦○●◦○◦◦○●◦◦"
      + "◦◦○○◦◦◦◦◦◦●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦●◦◦●○○○○◦○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_091() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦◦A○○◦○○●◦◦◦"
      + "◦◦◦●◦◦◦●◦○●◦○◦◦○●◦◦"
      + "◦◦○○◦◦◦◦◦◦●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦●◦◦●○○○○◦○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_092() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦A●○○◦○○●◦◦◦"
      + "◦◦◦●◦◦◦●◦○●◦○◦◦○●◦◦"
      + "◦◦○○◦◦◦◦◦◦●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦●◦◦●○○○○◦○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_093() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○●○○◦○○●◦◦◦"
      + "◦◦◦●◦◦◦●A○●◦○◦◦○●◦◦"
      + "◦◦○○◦◦◦◦◦◦●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦●◦◦●○○○○◦○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_094() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○●○○◦○○●◦◦◦"
      + "◦◦◦●◦◦◦●●○●◦○◦◦○●◦◦"
      + "◦◦○○◦◦◦◦◦A●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦●◦◦●○○○○◦○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_095() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○●○○◦○○●◦◦◦"
      + "◦◦◦●◦◦◦●●○●◦○◦◦○●◦◦"
      + "◦◦○○◦◦◦◦◦○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦A◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦●◦◦●○○○○◦○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_096() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○●○○◦○○●◦◦◦"
      + "◦◦◦●◦◦◦●●○●◦○◦◦○●◦◦"
      + "◦◦○○◦◦◦◦A○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦●◦◦●○○○○◦○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_097() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○●○○◦○○●◦◦◦"
      + "◦◦◦●◦◦◦●●○●◦○◦◦○●◦◦"
      + "◦◦○○◦◦◦A○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦●◦◦●○○○○◦○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_098() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○●○○◦○○●◦◦◦"
      + "◦◦◦●◦◦◦●●○●◦○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦A●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦◦•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦●◦◦●○○○○◦○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_099() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○●○○◦○○●◦◦◦"
      + "◦◦◦●◦◦◦●●○●◦○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦◦○●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦A•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦●◦◦●○○○○◦○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_100() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○●○○◦○○●◦◦◦"
      + "◦◦◦●◦◦◦●●○●◦○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦◦A○●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦●•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦●◦◦●○○○○◦○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_101() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○●○○◦○○●◦◦◦"
      + "◦◦◦●◦◦◦●●○●◦○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦A○○●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦◦●•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦●◦◦●○○○○◦○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_102() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○●○○◦○○●◦◦◦"
      + "◦◦◦●◦◦◦●●○●◦○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦A●•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦●◦◦●○○○○◦○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_103() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○◦◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○●○○◦○○●◦◦◦"
      + "◦◦◦●◦◦◦●●○●◦○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦○●•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦●A◦●○○○○◦○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_104() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○A◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○●○○◦○○●◦◦◦"
      + "◦◦◦●◦◦◦●●○●◦○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦◦○●•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦●●◦●○○○○◦○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_105() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○◦○○◦○○●◦◦◦"
      + "◦◦◦●◦◦◦●●○●◦○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦A○●•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦●●◦●○○○○◦○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_106() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○A○○◦○○●◦◦◦"
      + "◦◦◦●◦◦◦●●○●◦○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦●○●•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦●●◦●○○○○◦○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_107() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○◦○○●◦◦◦"
      + "◦◦◦●◦◦◦●●○●◦○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦●○●•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦●●◦●○○○○A○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_108() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○◦○○●◦◦◦"
      + "◦◦◦●◦◦◦●●○●◦○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦●○●•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦●●◦●○○○○●○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦A◦◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_109() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○◦○○●◦◦◦"
      + "◦◦◦●◦◦◦●●○●◦○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦●○●•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦●●◦●○○○○●○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦○A◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_110() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○◦○○●◦◦◦"
      + "◦◦◦●◦◦◦●●○●◦○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦○◦◦●○●•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦●●◦●○○○○●○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦○●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦A◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_111() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦◦◦◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○◦○○●◦◦◦"
      + "◦◦◦●◦◦◦●●○●◦○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦A◦◦◦◦◦◦"
      + "◦◦◦○◦◦●○●•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦●●◦●○○○○●○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦○●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_112() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●◦●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦◦A◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○◦○○●◦◦◦"
      + "◦◦◦●◦◦◦●●○●◦○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦◦●○●•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦●●◦●○○○○●○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦○●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_113() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●A●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦◦○◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦◦◦◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○◦○○●◦◦◦"
      + "◦◦◦●◦◦◦●●○●◦○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦◦●○●•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦●●◦●○○○○●○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦○●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_114() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●●●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦◦○◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦A◦◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○◦○○●◦◦◦"
      + "◦◦◦●◦◦◦●●○●◦○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦◦●○●•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦●●◦●○○○○●○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦○●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_115() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●●●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦◦○◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦○◦◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○A○○●◦◦◦"
      + "◦◦◦●◦◦◦●●○●◦○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦◦●○●•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦●●◦●○○○○●○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦○●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_116() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●●●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦◦○◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦○◦◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦◦◦●◦◦◦●●○●A○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦◦●○●•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦●●◦●○○○○●○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦○●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_117() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●●●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦◦◦○◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦○A◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦◦◦●◦◦◦●●○●○○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦◦●○●•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦●●◦●○○○○●○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦○●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_118() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●●●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦A◦○◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦◦◦●◦◦◦●●○●○○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦◦●○●•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦●●◦●○○○○●○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦○●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_119() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●●●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦○A○◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦◦◦●◦◦◦●●○●○○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦◦●○●•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦●●◦●○○○○●○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦○●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_120() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●●●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦◦◦●◦◦◦●●○●○○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦A◦◦◦"
      + "◦◦◦○◦◦●○●•●◦●●●●●◦◦"
      + "◦◦◦◦◦◦●●◦●○○○○●○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦○●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_121() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦◦◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●●●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦◦◦●◦◦◦●●○●○○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦○◦◦◦"
      + "◦◦◦○◦◦●○●•●◦●●●●●A◦"
      + "◦◦◦◦◦◦●●◦●○○○○●○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦○●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_122() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦A◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦◦●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●●●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦◦◦●◦◦◦●●○●○○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦○◦◦◦"
      + "◦◦◦○◦◦●○●•●◦●●●●●●◦"
      + "◦◦◦◦◦◦●●◦●○○○○●○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦○●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_123() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦○◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦A●◦○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●●●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦◦◦●◦◦◦●●○●○○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦○◦◦◦"
      + "◦◦◦○◦◦●○●•●◦●●●●●●◦"
      + "◦◦◦◦◦◦●●◦●○○○○●○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦○●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_124() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦○◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦●●A○◦○○●◦"
      + "◦○○○○◦○◦◦•◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●●●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦◦◦●◦◦◦●●○●○○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦○◦◦◦"
      + "◦◦◦○◦◦●○●•●◦●●●●●●◦"
      + "◦◦◦◦◦◦●●◦●○○○○●○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦○●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_125() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦○◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦●●○○◦○○●◦"
      + "◦○○○○◦○◦◦A◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦●●●●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦◦◦●◦◦◦●●○●○○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦○◦◦◦"
      + "◦◦◦○◦◦●○●•●◦●●●●●●◦"
      + "◦◦◦◦◦◦●●◦●○○○○●○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦○●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_126() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦○◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦●●○○◦○○●◦"
      + "◦○○○○◦○◦◦●◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦A●●●●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦◦◦●◦◦◦●●○●○○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦○◦◦◦"
      + "◦◦◦○◦◦●○●•●◦●●●●●●◦"
      + "◦◦◦◦◦◦●●◦●○○○○●○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦○●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_127() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦○◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦●●○○◦○○●◦"
      + "◦○○○○◦○◦◦●◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦A●●●●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦◦◦●A◦◦●●○●○○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦○◦◦◦"
      + "◦◦◦○◦◦●○●•●◦●●●●●●◦"
      + "◦◦◦◦◦◦●●◦●○○○○●○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦○●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_128() {
    String boardInput =
        "◦●◦◦○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦○◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦●●○○◦○○●◦"
      + "A○○○○◦○◦◦●◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦◦◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦○◦◦◦"
      + "◦◦◦○◦◦●○●•●◦●●●●●●◦"
      + "◦◦◦◦◦◦●●◦●○○○○●○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦○●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_129() {
    String boardInput =
        "◦●◦A○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦○◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦◦◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦○◦◦◦"
      + "◦◦◦○◦◦●○●•●◦●●●●●●◦"
      + "◦◦◦◦◦◦●●◦●○○○○●○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦○●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_130() {
    String boardInput =
        "◦●◦●○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦○◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦A○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦◦◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦○◦◦◦"
      + "◦◦◦○◦◦●○●•●◦●●●●●●◦"
      + "◦◦◦◦◦◦●●◦●○○○○●○○○◦"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦○●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_131() {
    String boardInput =
        "◦●◦●○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦○◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦◦◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦○◦◦◦"
      + "◦◦◦○◦◦●○●•●◦●●●●●●◦"
      + "◦◦◦◦◦◦●●◦●○○○○●○○○A"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦○●◦◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_132() {
    String boardInput =
        "◦●◦●○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦○◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦◦◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦○◦◦◦"
      + "◦◦◦○◦◦●○●•●◦●●●●●●◦"
      + "◦◦◦◦◦◦●●◦●○○○○●○○○●"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦○●A◦◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_133() {
    String boardInput =
        "◦●◦●○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦○◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦◦◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦○◦◦◦"
      + "◦◦◦○◦◦●○●•●◦●●●●●●◦"
      + "◦◦◦◦◦◦●●◦●○○○○●○○○●"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦○●○A◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦◦◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_134() {
    String boardInput =
        "◦●◦●○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦○◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦◦◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦◦◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦○◦◦◦"
      + "◦◦◦○◦◦●○●•●◦●●●●●●◦"
      + "◦◦◦◦◦◦●●◦●○○○○●○○○●"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦○●○●◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦A◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_135() {
    String boardInput =
        "◦●◦●○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦○◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦◦○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦A◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦◦◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦○◦◦◦"
      + "◦◦◦○◦◦●○●•●◦●●●●●●◦"
      + "◦◦◦◦◦◦●●◦●○○○○●○○○●"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦○◦○●◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_136() {
    String boardInput =
        "◦●◦●○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦○◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦A○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦◦◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦○◦◦◦"
      + "◦◦◦○◦◦●○●•●◦●●●●●●◦"
      + "◦◦◦◦◦◦●●◦●○○○○●○○○●"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦○◦○●◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_137() {
    String boardInput =
        "◦●◦●○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦○◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦A◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦◦○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦○◦◦◦"
      + "◦◦◦○◦◦●○●•●◦●●●●●●◦"
      + "◦◦◦◦◦◦●●◦●○○○○●○○○●"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦○◦○●◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_138() {
    String boardInput =
        "◦●◦●○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦○◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦A○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦○◦◦◦"
      + "◦◦◦○◦◦●○●•●◦●●●●●●◦"
      + "◦◦◦◦◦◦●●◦●○○○○●○○○●"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦○◦○●◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_139() {
    String boardInput =
        "◦●◦●○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦○◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦○○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦○◦◦◦"
      + "◦◦◦○◦◦●○●•●◦●●●●●●◦"
      + "◦◦◦◦A◦●●◦●○○○○●○○○●"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦○◦○●◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_140() {
    String boardInput =
        "◦●◦●○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦○◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦○○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦○◦◦◦"
      + "◦◦◦○◦◦●○●•●◦●●●●●●◦"
      + "◦◦◦A●◦●●◦●○○○○●○○○●"
      + "◦◦◦◦○◦◦◦◦◦◦◦◦◦○◦○●◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_141() {
    String boardInput =
        "◦●◦●○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦○◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦○○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦○◦◦◦"
      + "◦◦◦○◦◦●○●•●◦●●●●●●◦"
      + "◦◦◦○●◦●●◦●○○○○●○○○●"
      + "◦◦◦◦○A◦◦◦◦◦◦◦◦○◦○●◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_142() {
    String boardInput =
        "◦●◦●○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦○◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦○○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦○◦◦◦"
      + "◦◦◦○A◦●○●•●◦●●●●●●◦"
      + "◦◦◦○●◦●●◦●○○○○●○○○●"
      + "◦◦◦◦○●◦◦◦◦◦◦◦◦○◦○●◦"
      + "◦◦◦◦◦◦◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_143() {
    String boardInput =
        "◦●◦●○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦○◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦○○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○●◦●●◦●○○○○●○○○●"
      + "◦◦◦◦○●◦◦◦◦◦◦◦◦○◦○●◦"
      + "◦◦◦◦A◦◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_144() {
    String boardInput =
        "◦●◦●○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦○◦○◦◦◦○◦"
      + "●●○●●○◦◦◦◦●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦○○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○●◦●●◦●○○○○●○○○●"
      + "◦◦◦A○●◦◦◦◦◦◦◦◦○◦○●◦"
      + "◦◦◦◦●◦◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_145() {
    String boardInput =
        "◦●◦●○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦○◦○◦◦◦○A"
      + "●●○●●○◦◦◦◦●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦◦◦◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦○○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○●◦●●◦●○○○○●○○○●"
      + "◦◦◦○○●◦◦◦◦◦◦◦◦○◦○●◦"
      + "◦◦◦◦●◦◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_146() {
    String boardInput =
        "◦●◦●○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦○◦○◦◦◦○●"
      + "●●○●●○◦◦◦◦●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦◦A◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦○○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○●◦●●◦●○○○○●○○○●"
      + "◦◦◦○○●◦◦◦◦◦◦◦◦○◦○●◦"
      + "◦◦◦◦●◦◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_147() {
    String boardInput =
        "◦●◦●○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦◦◦○◦○◦◦◦○●"
      + "●●○●●○◦◦◦◦●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦A○◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦○○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○●◦●●◦●○○○○●○○○●"
      + "◦◦◦○○●◦◦◦◦◦◦◦◦○◦○●◦"
      + "◦◦◦◦●◦◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_148() {
    String boardInput =
        "◦●◦●○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦A◦○◦○◦◦◦○●"
      + "●●○●●○◦◦◦◦●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦●○◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦○○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○●◦●●◦●○○○○●○○○●"
      + "◦◦◦○○●◦◦◦◦◦◦◦◦○◦○●◦"
      + "◦◦◦◦●◦◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_149() {
    String boardInput =
        "◦●◦●○◦◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦○A○◦○◦◦◦○●"
      + "●●○●●○◦◦◦◦●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦●○◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦○○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○●◦●●◦●○○○○●○○○●"
      + "◦◦◦○○●◦◦◦◦◦◦◦◦○◦○●◦"
      + "◦◦◦◦●◦◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_150() {
    String boardInput =
        "◦●◦●○◦◦◦◦◦A◦◦◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦○●○◦○◦◦◦○●"
      + "●●○●●○◦◦◦◦●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦●○◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦○○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○●◦●●◦●○○○○●○○○●"
      + "◦◦◦○○●◦◦◦◦◦◦◦◦○◦○●◦"
      + "◦◦◦◦●◦◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_151() {
    String boardInput =
        "◦●◦●○◦◦◦◦◦○◦A◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦○●○◦○◦◦◦○●"
      + "●●○●●○◦◦◦◦●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦●○◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦○○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○●◦●●◦●○○○○●○○○●"
      + "◦◦◦○○●◦◦◦◦◦◦◦◦○◦○●◦"
      + "◦◦◦◦●◦◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_152() {
    String boardInput =
        "◦●◦●○◦◦◦◦◦○A●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦○●○◦○◦◦◦○●"
      + "●●○●●○◦◦◦◦●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦●○◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦○○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦◦○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○●◦●●◦●○○○○●○○○●"
      + "◦◦◦○○●◦◦◦◦◦◦◦◦○◦○●◦"
      + "◦◦◦◦●◦◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_153() {
    String boardInput =
        "◦●◦●○◦◦◦◦◦○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦○●○◦○◦◦◦○●"
      + "●●○●●○◦◦◦◦●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦●○◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦○○○◦◦◦●○○●◦◦○◦○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦A○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○●◦●●◦●○○○○●○○○●"
      + "◦◦◦○○●◦◦◦◦◦◦◦◦○◦○●◦"
      + "◦◦◦◦●◦◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_154() {
    String boardInput =
        "◦●◦●○◦◦◦◦◦○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦◦○●○◦○◦◦◦○●"
      + "●●○●●○◦◦◦◦●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦●○◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦○○○◦◦◦●○○●◦◦○A○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○●◦●●◦●○○○○●○○○●"
      + "◦◦◦○○●◦◦◦◦◦◦◦◦○◦○●◦"
      + "◦◦◦◦●◦◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_155() {
    String boardInput =
        "◦●◦●○◦◦◦◦◦○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦A○●○◦○◦◦◦○●"
      + "●●○●●○◦◦◦◦●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦●○◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦○○○◦◦◦●○○●◦◦○○○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○●◦●●◦●○○○○●○○○●"
      + "◦◦◦○○●◦◦◦◦◦◦◦◦○◦○●◦"
      + "◦◦◦◦●◦◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_156() {
    String boardInput =
        "◦●◦●○◦◦◦◦◦○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○◦◦A○●"
      + "●●○●●○◦◦◦◦●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦●○◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦○○○◦◦◦●○○●◦◦○○○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○●◦●●◦●○○○○●○○○●"
      + "◦◦◦○○●◦◦◦◦◦◦◦◦○◦○●◦"
      + "◦◦◦◦●◦◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_157() {
    String boardInput =
        "◦●◦●○◦◦◦◦◦○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○◦◦○○●"
      + "●●○●●○◦◦◦A●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦●○◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦○○○◦◦◦●○○●◦◦○○○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○●◦●●◦●○○○○●○○○●"
      + "◦◦◦○○●◦◦◦◦◦◦◦◦○◦○●◦"
      + "◦◦◦◦●◦◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_158() {
    String boardInput =
        "◦●◦●○◦◦◦◦A○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○◦◦○○●"
      + "●●○●●○◦◦◦●●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦●○◦●●●●◦"
      + "◦◦◦◦◦○○◦◦◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦○○○◦◦◦●○○●◦◦○○○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○●◦●●◦●○○○○●○○○●"
      + "◦◦◦○○●◦◦◦◦◦◦◦◦○◦○●◦"
      + "◦◦◦◦●◦◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_159() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○◦◦○○●"
      + "●●○●●○◦◦◦●●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦●○◦●●●●◦"
      + "◦◦◦◦◦○○◦A◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦○○○◦◦◦●○○●◦◦○○○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○●◦●●◦●○○○○●○○○●"
      + "◦◦◦○○●◦◦◦◦◦◦◦◦○◦○●◦"
      + "◦◦◦◦●◦◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_160() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○◦◦○○●"
      + "●●○●●○◦◦◦●●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦●○◦●●●●◦"
      + "◦◦◦◦◦○○◦●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦○○○◦◦◦●○○●◦◦○○○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○●◦●●◦●○○○○●○○○●"
      + "◦◦◦○○●◦◦◦◦A◦◦◦○◦○●◦"
      + "◦◦◦◦●◦◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_161() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○◦◦○○●"
      + "●●○●●○◦◦◦●●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦●○◦●●●●◦"
      + "◦◦◦◦◦○○◦●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦○○○◦◦◦●○○●◦◦○○○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○●◦●●◦●○○○○●○○○●"
      + "◦◦◦○○●◦◦◦A○◦◦◦○◦○●◦"
      + "◦◦◦◦●◦◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_162() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○◦◦○○●"
      + "●●○●●○◦◦◦●●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦●○◦●●●●◦"
      + "◦◦◦◦◦○○◦●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦○○○◦◦◦●○○●◦◦○○○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○●A●●◦●○○○○●○○○●"
      + "◦◦◦○○●◦◦◦●○◦◦◦○◦○●◦"
      + "◦◦◦◦●◦◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_163() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○◦◦○○●"
      + "●●○●●○◦◦◦●●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦●○◦●●●●◦"
      + "◦◦◦◦◦○○◦●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦○○○◦◦◦●○○●◦◦○○○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦◦○○●A◦◦●○◦◦◦○◦○●◦"
      + "◦◦◦◦●◦◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_164() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○◦◦○○●"
      + "●●○●●○◦A◦●●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦●○◦●●●●◦"
      + "◦◦◦◦◦○○◦●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦○○○◦◦◦●○○●◦◦○○○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦◦○○●●◦◦●○◦◦◦○◦○●◦"
      + "◦◦◦◦●◦◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_165() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○◦◦○○●"
      + "●●○●●○◦○A●●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦●○◦●●●●◦"
      + "◦◦◦◦◦○○◦●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "◦●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦○○○◦◦◦●○○●◦◦○○○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦◦○○●●◦◦●○◦◦◦○◦○●◦"
      + "◦◦◦◦●◦◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_166() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○◦◦○○●"
      + "●●○●●○◦○●●●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦●○◦●●●●◦"
      + "◦◦◦◦◦○○◦●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "◦◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "A●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦○○○◦◦◦●○○●◦◦○○○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦◦○○●●◦◦●○◦◦◦○◦○●◦"
      + "◦◦◦◦●◦◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_167() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○◦◦○○●"
      + "●●○●●○◦○●●●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦●○◦●●●●◦"
      + "◦◦◦◦◦○○◦●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "A◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "◦○○○◦◦◦●○○●◦◦○○○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦◦○○●●◦◦●○◦◦◦○◦○●◦"
      + "◦◦◦◦●◦◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_168() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○◦◦○○●"
      + "●●○●●○◦○●●●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦●○◦●●●●◦"
      + "◦◦◦◦◦○○◦●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "●◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "A○○○◦◦◦●○○●◦◦○○○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦◦○○●●◦◦●○◦◦◦○◦○●◦"
      + "◦◦◦◦●◦◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_169() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○◦◦○○●"
      + "●●○●●○◦○●●●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦●○◦●●●●◦"
      + "◦◦◦◦◦○○◦●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "●◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "○○○○◦◦◦●○○●◦◦○○○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦◦○○●●◦◦●○◦◦◦○◦○●◦"
      + "◦◦◦A●◦◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_170() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○◦◦○○●"
      + "●●○●●○◦○●●●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦●○◦●●●●◦"
      + "◦◦◦◦◦○○◦●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "●◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "○○○○◦◦◦●○○●◦◦○○○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦◦○○●●◦◦●○◦◦◦○◦○●◦"
      + "◦◦A●●◦◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_171() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○◦◦○○●"
      + "●●○●●○◦○●●●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦●○◦●●●●◦"
      + "◦◦◦◦◦○○◦●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "●◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "○○○○◦◦◦●○○●◦◦○○○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦◦○○●●◦◦●○◦◦◦○◦○●◦"
      + "◦◦○●●A◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_172() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○◦◦○○●"
      + "●●○●●○◦○●●●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦●○◦●●●●◦"
      + "◦◦◦◦◦○○◦●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "●◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "○○○○◦◦◦●○○●◦◦○○○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦A○○●●◦◦●○◦◦◦○◦○●◦"
      + "◦◦○●●●◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_173() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○◦◦○○●"
      + "●●○●●○◦○●●●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦●○◦●●●●◦"
      + "◦◦◦◦◦○○◦●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●◦A◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "●◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "○○○○◦◦◦●○○●◦◦○○○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●◦"
      + "◦◦○●●●◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_174() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○◦◦○○●"
      + "●●○●●○◦○●●●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦●○◦●●●●◦"
      + "◦◦◦◦◦○○◦●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●A●◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○◦●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "●◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "○○○○◦◦◦●○○●◦◦○○○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●◦"
      + "◦◦○●●●◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_175() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○◦◦○○●"
      + "●●○●●○◦○●●●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦●○◦●●●●◦"
      + "◦◦◦◦◦○○◦●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○A●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "●◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "○○○○◦◦◦●○○●◦◦○○○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●◦"
      + "◦◦○●●●◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_176() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○◦◦○○●"
      + "●●○●●○◦○●●●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦●○◦●●●●◦"
      + "◦◦◦◦◦○○A●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "●◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "○○○○◦◦◦●○○●◦◦○○○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●◦"
      + "◦◦○●●●◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_177() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○◦◦○○●"
      + "●●○●●○◦○●●●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦●○◦●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●A◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○◦◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "●◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "○○○○◦◦◦●○○●◦◦○○○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●◦"
      + "◦◦○●●●◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_178() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○◦◦○○●"
      + "●●○●●○◦○●●●●○○◦○○●◦"
      + "○○○○○◦○◦◦●◦●○◦●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○A◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "●◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "○○○○◦◦◦●○○●◦◦○○○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●◦"
      + "◦◦○●●●◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_179() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○◦◦○○●"
      + "●●○●●○◦○●●●●○○A○○●◦"
      + "○○○○○◦○◦◦●◦●○◦●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "●◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "○○○○◦◦◦●○○●◦◦○○○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●◦"
      + "◦◦○●●●◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_180() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○A◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○◦●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "●◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "○○○○◦◦◦●○○●◦◦○○○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●◦"
      + "◦◦○●●●◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_181() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○A●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "●◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "○○○○◦◦◦●○○●◦◦○○○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●◦"
      + "◦◦○●●●◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_182() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○●●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "●◦●◦◦◦●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "○○○○◦A◦●○○●◦◦○○○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●◦"
      + "◦◦○●●●◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_183() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○●●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦◦◦○●◦○○◦○●◦◦●◦◦◦"
      + "●◦●◦◦A●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "○○○○◦○◦●○○●◦◦○○○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●◦"
      + "◦◦○●●●◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_184() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○●●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦A◦○●◦○○◦○●◦◦●◦◦◦"
      + "●◦●◦◦●●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "○○○○◦○◦●○○●◦◦○○○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●◦"
      + "◦◦○●●●◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_185() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○●●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "◦○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦○◦○●◦○○◦○●◦◦●◦◦◦"
      + "●◦●A◦●●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "○○○○◦○◦●○○●◦◦○○○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●◦"
      + "◦◦○●●●◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_186() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○●●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "A○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦○◦○●◦○○◦○●◦◦●◦◦◦"
      + "●◦●●◦●●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "○○○○◦○◦●○○●◦◦○○○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●◦"
      + "◦◦○●●●◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_187() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○●●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "○○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦○◦○●◦○○◦○●◦◦●◦◦◦"
      + "●◦●●◦●●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "○○○○A○◦●○○●◦◦○○○●◦◦"
      + "◦◦◦◦◦◦●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●◦"
      + "◦◦○●●●◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_188() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○●●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "○○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦○◦○●◦○○◦○●◦◦●◦◦◦"
      + "●◦●●◦●●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "○○○○●○◦●○○●◦◦○○○●◦◦"
      + "◦◦◦◦◦A●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●◦"
      + "◦◦○●●●◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_189() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○●●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "○○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦○◦○●◦○○◦○●◦◦●◦◦◦"
      + "●◦●●◦●●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "○○○○●○◦●○○●◦◦○○○●◦◦"
      + "◦◦◦◦A○●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○◦●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●◦"
      + "◦◦○●●●◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_190() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○●●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "○○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦○◦○●◦○○◦○●◦◦●◦◦◦"
      + "●◦●●◦●●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "○○○○●○◦●○○●◦◦○○○●◦◦"
      + "◦◦◦◦●○●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○A●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●◦"
      + "◦◦○●●●◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_191() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○●●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "○○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦○◦○●◦○○◦○●◦◦●◦◦◦"
      + "●◦●●◦●●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "○○○○●○◦●○○●◦◦○○○●◦◦"
      + "◦◦◦A●○●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○○●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●◦"
      + "◦◦○●●●◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_192() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○●●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "○○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦○◦○●◦○○◦○●◦◦●◦◦◦"
      + "●◦●●◦●●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "○○○○●○◦●○○●◦◦○○○●◦◦"
      + "◦◦A●●○●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○○●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●◦"
      + "◦◦○●●●◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_193() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○●●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "○○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦○◦○●◦○○◦○●◦◦●◦◦◦"
      + "●◦●●◦●●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "○○○○●○◦●○○●◦A○○○●◦◦"
      + "◦◦○●●○●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○○●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●◦"
      + "◦◦○●●●◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_194() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○●●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "○○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦○◦○●◦○○◦○●◦◦●◦◦◦"
      + "●◦●●◦●●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "○○○○●○◦●○○●A●○○○●◦◦"
      + "◦◦○●●○●○○●◦◦●◦●○◦◦◦"
      + "◦◦◦○○○●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●◦"
      + "◦◦○●●●◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_195() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○●●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "○○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦○◦○●◦○○◦○●◦◦●◦◦◦"
      + "●◦●●◦●●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○◦◦○●◦◦"
      + "○○○○●○◦●○○●○●○○○●◦◦"
      + "◦◦○●●○●○○●A◦●◦●○◦◦◦"
      + "◦◦◦○○○●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●◦"
      + "◦◦○●●●◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_196() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○●●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "○○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦○◦○●◦○○◦○●◦◦●◦◦◦"
      + "●◦●●◦●●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○A◦○●◦◦"
      + "○○○○●○◦●○○●○●○○○●◦◦"
      + "◦◦○●●○●○○●●◦●◦●○◦◦◦"
      + "◦◦◦○○○●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●◦"
      + "◦◦○●●●◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_197() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○●●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "○○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦○◦○●◦○○◦○●◦◦●◦◦◦"
      + "●◦●●◦●●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○○◦○●◦◦"
      + "○○○○●○◦●○○●○●○○○●◦◦"
      + "◦◦○●●○●○○●●◦●◦●○◦◦◦"
      + "◦◦◦○○○●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●A"
      + "◦◦○●●●◦◦◦◦◦◦◦○◦○◦◦◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_198() {
    String boardInput =
        "◦●◦●○◦◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○●●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "○○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦○◦○●◦○○◦○●◦◦●◦◦◦"
      + "●◦●●◦●●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○○◦○●◦◦"
      + "○○○○●○◦●○○●○●○○○●◦◦"
      + "◦◦○●●○●○○●●◦●◦●○◦◦◦"
      + "◦◦◦○○○●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●●"
      + "◦◦○●●●◦◦◦◦◦◦◦○◦○◦A◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_199() {
    String boardInput =
        "◦●◦●○A◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○●●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "○○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦○◦○●◦○○◦○●◦◦●◦◦◦"
      + "●◦●●◦●●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○○◦○●◦◦"
      + "○○○○●○◦●○○●○●○○○●◦◦"
      + "◦◦○●●○●○○●●◦●◦●○◦◦◦"
      + "◦◦◦○○○●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●●"
      + "◦◦○●●●◦◦◦◦◦◦◦○◦○◦○◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_200() {
    String boardInput =
        "◦●◦●◦●◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○●●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "○○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦○◦○●◦○○◦○●◦◦●◦◦◦"
      + "●◦●●◦●●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○○◦○●◦◦"
      + "○○○○●○◦●○○●○●○○○●◦◦"
      + "◦◦○●●○●○○●●◦●◦●○A◦◦"
      + "◦◦◦○○○●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●●"
      + "◦◦○●●●◦◦◦◦◦◦◦○◦○◦○◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_201() {
    String boardInput =
        "◦●◦●◦●◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○●●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "○○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦○◦○●◦○○◦○●◦◦●◦◦◦"
      + "●◦●●◦●●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○○◦○●◦◦"
      + "○○○○●○◦●○○●○●○○○●◦◦"
      + "◦◦○●●○●○○●●◦●◦●○○A◦"
      + "◦◦◦○○○●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●●"
      + "◦◦○●●●◦◦◦◦◦◦◦○◦○◦○◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_202() {
    String boardInput =
        "◦●◦●◦●◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○●●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "○○○○◦○●○◦○○●●◦◦●◦◦◦"
      + "◦●◦○◦○●◦○○◦○●A◦●◦◦◦"
      + "●◦●●◦●●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○○◦○●◦◦"
      + "○○○○●○◦●○○●○●○○○●◦◦"
      + "◦◦○●●○●○○●●◦●◦●○○●◦"
      + "◦◦◦○○○●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●●"
      + "◦◦○●●●◦◦◦◦◦◦◦○◦○◦○◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_203() {
    String boardInput =
        "◦●◦●◦●◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○●●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "○○○○◦○●○◦○○●●A◦●◦◦◦"
      + "◦●◦○◦○●◦○○◦○●○◦●◦◦◦"
      + "●◦●●◦●●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○○◦○●◦◦"
      + "○○○○●○◦●○○●○●○○○●◦◦"
      + "◦◦○●●○●○○●●◦●◦●○○●◦"
      + "◦◦◦○○○●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●●"
      + "◦◦○●●●◦◦◦◦◦◦◦○◦○◦○◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_204() {
    String boardInput =
        "◦●◦●◦●◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○●●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "○○○○◦○●○◦○○●●●◦●◦◦◦"
      + "◦●◦○◦○●◦○○◦○●○A●◦◦◦"
      + "●◦●●◦●●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○○◦○●◦◦"
      + "○○○○●○◦●○○●○●○○○●◦◦"
      + "◦◦○●●○●○○●●◦●◦●○○●◦"
      + "◦◦◦○○○●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●●"
      + "◦◦○●●●◦◦◦◦◦◦◦○◦○◦○◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_205() {
    String boardInput =
        "◦●◦●◦●◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○●●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "○○○○◦○●○◦○○●●●A●◦◦◦"
      + "◦●◦○◦○●◦○○◦○●○○●◦◦◦"
      + "●◦●●◦●●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○○◦○●◦◦"
      + "○○○○●○◦●○○●○●○○○●◦◦"
      + "◦◦○●●○●○○●●◦●◦●○○●◦"
      + "◦◦◦○○○●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●●"
      + "◦◦○●●●◦◦◦◦◦◦◦○◦○◦○◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_206() {
    String boardInput =
        "◦●◦●◦●◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○●●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "○○○○◦○●○◦○○●●●●●◦◦◦"
      + "◦●◦○◦○●◦○○◦○●○○●◦◦◦"
      + "●◦●●◦●●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○○◦○●◦◦"
      + "○○○○●○◦●○○●○●○○○●◦◦"
      + "◦◦○●●○●○○●●◦●◦●○○●◦"
      + "◦◦◦○○○●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●●"
      + "◦◦○●●●◦◦◦A◦◦◦○◦○◦○◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_207() {
    String boardInput =
        "◦●◦●◦●◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○●●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "○○○○◦○●○◦○○●●●●●◦◦◦"
      + "◦●◦○◦○●◦○○◦○●○○●◦◦◦"
      + "●◦●●◦●●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○○◦○●◦◦"
      + "○○○○●○◦●○○●○●○○○●◦◦"
      + "◦◦○●●○●○○●●◦●◦●○○●◦"
      + "◦◦◦○○○●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●●"
      + "◦◦○●●●◦◦A○◦◦◦○◦○◦○◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_208() {
    String boardInput =
        "◦●◦●◦●◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○●●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "○○○○◦○●○◦○○●●●●●◦◦◦"
      + "◦●◦○◦○●◦○○◦○●○○●◦◦◦"
      + "●◦●●◦●●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○○◦○●◦◦"
      + "○○○○●○◦●○○●○●○○○●◦◦"
      + "◦◦○●●○●○○●●◦●◦●○○●◦"
      + "◦◦◦○○○●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●●"
      + "◦◦○●●●◦◦●○A◦◦○◦○◦○◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_209() {
    String boardInput =
        "◦●◦●◦●◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○●●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "○○○○◦○●○◦○○●●●●●◦◦◦"
      + "◦●◦○A○●◦○○◦○●○○●◦◦◦"
      + "●◦●●◦●●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○○◦○●◦◦"
      + "○○○○●○◦●○○●○●○○○●◦◦"
      + "◦◦○●●○●○○●●◦●◦●○○●◦"
      + "◦◦◦○○○●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●●"
      + "◦◦○●●●◦◦●○○◦◦○◦○◦○◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_210() {
    String boardInput =
        "◦●◦●◦●◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○◦◦●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○●●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "○○○○A○●○◦○○●●●●●◦◦◦"
      + "◦●◦○●○●◦○○◦○●○○●◦◦◦"
      + "●◦●●◦●●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○○◦○●◦◦"
      + "○○○○●○◦●○○●○●○○○●◦◦"
      + "◦◦○●●○●○○●●◦●◦●○○●◦"
      + "◦◦◦○○○●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●●"
      + "◦◦○●●●◦◦●○○◦◦○◦○◦○◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_211() {
    String boardInput =
        "◦●◦●◦●◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○A◦●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○●●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "○○○○○○●○◦○○●●●●●◦◦◦"
      + "◦●◦○●○●◦○○◦○●○○●◦◦◦"
      + "●◦●●◦●●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○○◦○●◦◦"
      + "○○○○●○◦●○○●○●○○○●◦◦"
      + "◦◦○●●○●○○●●◦●◦●○○●◦"
      + "◦◦◦○○○●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●●"
      + "◦◦○●●●◦◦●○○◦◦○◦○◦○◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_212() {
    String boardInput =
        "◦●◦●◦●◦◦◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○●A●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○●●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "○○○○○○●○◦○○●●●●●◦◦◦"
      + "◦●◦○●○●◦○○◦○●○○●◦◦◦"
      + "●◦●●◦●●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○○◦○●◦◦"
      + "○○○○●○◦●○○●○●○○○●◦◦"
      + "◦◦○●●○●○○●●◦●◦●○○●◦"
      + "◦◦◦○○○●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●●"
      + "◦◦○●●●◦◦●○○◦◦○◦○◦○◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_213() {
    String boardInput =
        "◦●◦●◦A◦●◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○●○●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○●●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○◦◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "○○○○○○●○◦○○●●●●●◦◦◦"
      + "◦●◦○●○●◦○○◦○●○○●◦◦◦"
      + "●◦●●◦●●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○○◦○●◦◦"
      + "○○○○●○◦●○○●○●○○○●◦◦"
      + "◦◦○●●○●○○●●◦●◦●○○●◦"
      + "◦◦◦○○○●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●●"
      + "◦◦○●●●◦◦●○○◦◦○◦○◦○◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_214() {
    String boardInput =
        "◦●◦●◦●◦●◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○●○●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○●●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○A◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "○○○○○○●○◦○○●●●●●◦◦◦"
      + "◦●◦○●○●◦○○◦○●○○●◦◦◦"
      + "●◦●●◦●●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○○◦○●◦◦"
      + "○○○○●○◦●○○●○●○○○●◦◦"
      + "◦◦○●●○●○○●●◦●◦●○○●◦"
      + "◦◦◦○○○●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●●"
      + "◦◦○●●●◦◦●○○◦◦○◦○◦○◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_215() {
    String boardInput =
        "◦●◦●◦●◦●◦○○○●◦◦◦◦◦◦"
      + "◦◦●●●○●○●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○●●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○○A◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "○○○○○○●○◦○○●●●●●◦◦◦"
      + "◦●◦○●○●◦○○◦○●○○●◦◦◦"
      + "●◦●●◦●●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○○◦○●◦◦"
      + "○○○○●○◦●○○●○●○○○●◦◦"
      + "◦◦○●●○●○○●●◦●◦●○○●◦"
      + "◦◦◦○○○●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●●"
      + "◦◦○●●●◦◦●○○◦◦○◦○◦○◦";
    return new OneMoveData(boardInput, Color.B);
  }

  private static OneMoveData constructOneMoveData_216() {
    String boardInput =
        "◦●◦●◦●◦●◦○○○●◦◦◦◦A◦"
      + "◦◦●●●○●○●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○●●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○○●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "○○○○○○●○◦○○●●●●●◦◦◦"
      + "◦●◦○●○●◦○○◦○●○○●◦◦◦"
      + "●◦●●◦●●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○○◦○●◦◦"
      + "○○○○●○◦●○○●○●○○○●◦◦"
      + "◦◦○●●○●○○●●◦●◦●○○●◦"
      + "◦◦◦○○○●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●●"
      + "◦◦○●●●◦◦●○○◦◦○◦○◦○◦";
    return new OneMoveData(boardInput, Color.W);
  }

  private static OneMoveData constructOneMoveData_217() {
    String boardInput =
        "◦●◦●◦●◦●◦○○○●◦◦◦◦○◦"
      + "◦◦●●●○●○●○●○◦○○◦○○●"
      + "●●○●●○◦○●●●●○○●○○●◦"
      + "○○○○○◦○◦◦●◦●○●●●●●◦"
      + "◦◦◦◦◦○○○●◦◦◦●◦◦◦◦◦◦"
      + "◦◦◦○◦●○●●◦◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦◦◦○●●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦◦○○○○●◦◦◦◦◦◦◦◦◦"
      + "◦◦◦◦○●●●●●●◦◦◦◦◦◦◦◦"
      + "○○○○○○●○◦○○●●●●●◦◦◦"
      + "◦●◦○●○●◦○○◦○●○○●◦◦◦"
      + "●◦●●A●●◦○○○○●○○●◦◦◦"
      + "○●◦●●◦◦●●○●○○○◦○●◦◦"
      + "○○○○●○◦●○○●○●○○○●◦◦"
      + "◦◦○●●○●○○●●◦●◦●○○●◦"
      + "◦◦◦○○○●○●•●◦●●●●●●◦"
      + "◦◦◦○◦○●●◦●○○○○●○○○●"
      + "◦◦○○○●●◦◦●○◦◦◦○◦○●●"
      + "◦◦○●●●◦◦●○○◦◦○◦○◦○◦";
    return new OneMoveData(boardInput, Color.B);
  }
}
