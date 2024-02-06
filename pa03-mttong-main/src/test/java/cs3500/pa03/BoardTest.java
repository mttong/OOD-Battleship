package cs3500.pa03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa03.enums.State;
import cs3500.pa03.model.Board;
import cs3500.pa03.model.Coord;
import cs3500.pa03.model.Ship;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Board test class
 */
public class BoardTest {

  private Board board;

  /**
   * set up
   */
  @BeforeEach
  public void setUp() {
    board = new Board(3, 3);
  }

  /**
   * board to string test
   */
  @Test
  public void testToString() {
    String expected = """
        0 0 0\s
        0 0 0\s
        0 0 0\s
        """;

    assertEquals(expected, board.toString());
  }

  /**
   * get height test
   */
  @Test
  public void testGetHeight() {
    assertEquals(3, board.getHeight());
  }

  /**
   * get width test
   */
  @Test
  public void testGetWidth() {
    assertEquals(3, board.getWidth());
  }

  /**
   * generate board test
   */
  @Test
  public void testGenerateMyBoard() {
    Coord coord1 = new Coord(2, 2);
    coord1.setState(State.HIT);
    Coord coord2 = new Coord(1, 1);
    coord2.setState(State.MISS);
    List<Coord> shots = new ArrayList<>(Arrays.asList(coord1, coord2));


    List<Ship> ships = new ArrayList<>();
    ships.add(new Ship());

    board.generateMyBoard(shots, ships);

    String expected = """
        S S 0\s
        0 M 0\s
        0 0 H\s
        """;

    assertEquals(expected, board.toString());
  }

  /**
   * update board test
   */
  @Test
  public void testUpdateBoard() {
    Coord coord1 = new Coord(0, 0);
    coord1.setState(State.HIT);
    Coord coord2 = new Coord(1, 1);
    coord2.setState(State.MISS);
    Coord coord3 = new Coord(2, 2);
    coord3.setState(State.SHIP);

    List<Coord> hits = new ArrayList<>(Arrays.asList(coord1, coord2, coord3));

    board.updateBoard(hits);

    String expected = """
        H 0 0\s
        0 M 0\s
        0 0 S\s
        """;

    assertEquals(expected, board.toString());
  }

  /**
   * update shots test
   */
  @Test
  public void testUpdateShotsTaken() {
    Coord shot = new Coord(0, 0);

    board.updateShotsTaken(shot);
    List<Coord> alreadyShot = board.getAlreadyShot();

    assertEquals(1, alreadyShot.size());
    assertTrue(alreadyShot.contains(shot));
  }
}
