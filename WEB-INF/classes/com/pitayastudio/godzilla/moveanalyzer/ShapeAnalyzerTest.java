package com.pitayastudio.godzilla.moveanalyzer;

import com.google.common.collect.ImmutableSet;

import com.pitayastudio.godzilla.model.Coord;
import com.pitayastudio.godzilla.modelboard.CoordBoard;

import junit.framework.TestCase;

import org.junit.Test;

public class ShapeAnalyzerTest extends TestCase {

  @Test public void testIsSquareFour() {
    int boardSize = 3;
    CoordBoard coordBoard = new CoordBoard(boardSize);
    ShapeAnalyzer shapeAnalyzer = new ShapeAnalyzer(coordBoard);
    ImmutableSet<Coord> coords = coordBoard.readCoordsFromStarsInBoardAsString(
        "◦**"
      + "◦**"
      + "◦◦◦");
    assertTrue(shapeAnalyzer.isSquareFour(coords));
  }

  @Test public void testIsNotSquareFour() {
    int boardSize = 3;
    CoordBoard coordBoard = new CoordBoard(boardSize);
    ShapeAnalyzer shapeAnalyzer = new ShapeAnalyzer(coordBoard);
    ImmutableSet<Coord> coords = coordBoard.readCoordsFromStarsInBoardAsString(
        "◦**"
      + "◦*◦"
      + "◦◦◦");
    assertFalse(shapeAnalyzer.isSquareFour(coords));
  }

  @Test public void testIsSameShape() {
    int boardSize = 3;
    CoordBoard coordBoard = new CoordBoard(boardSize);
    ShapeAnalyzer shapeAnalyzer = new ShapeAnalyzer(coordBoard);
    ImmutableSet<Coord> coords = coordBoard.readCoordsFromStarsInBoardAsString(
        "◦**"
      + "◦*◦"
      + "◦◦◦");
    ImmutableSet<Coord> normalizedCoords = coordBoard.readCoordsFromStarsInBoardAsString(
        "◦◦◦"
      + "**◦"
      + "*◦◦");
    assertTrue(shapeAnalyzer.isShapeMatchNormalizedShape(coords, normalizedCoords));
  }

  @Test public void testIsDifferentShape() {
    int boardSize = 3;
    CoordBoard coordBoard = new CoordBoard(boardSize);
    ShapeAnalyzer shapeAnalyzer = new ShapeAnalyzer(coordBoard);
    ImmutableSet<Coord> coords = coordBoard.readCoordsFromStarsInBoardAsString(
        "◦**"
      + "◦*◦"
      + "◦◦◦");
    ImmutableSet<Coord> normalizedCoords = coordBoard.readCoordsFromStarsInBoardAsString(
        "◦◦◦"
      + "◦*◦"
      + "**◦");
    assertFalse(shapeAnalyzer.isShapeMatchNormalizedShape(coords, normalizedCoords));
  }
}
