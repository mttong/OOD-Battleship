package cs3500.pa03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa03.enums.State;
import cs3500.pa03.model.Coord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * test coord class
 */
public class CoordTest {

  private Coord coord;

  /**
   * creating coordinate before each class
   */
  @BeforeEach
  public void setUp() {
    coord = new Coord(2, 3);
  }

  /**
   * testing state to string
   */
  @Test
  public void testToString() {
    assertEquals("0", coord.toString());
  }

  /**
   * testing if same coordinate
   */
  @Test
  public void testSameCoordinate() {
    Coord sameCoord = new Coord(2, 3);
    Coord differentCoord = new Coord(4, 5);

    assertTrue(coord.sameCoordinate(sameCoord));
    assertFalse(coord.sameCoordinate(differentCoord));
  }

  /**
   * testing getting state
   */
  @Test
  public void testGetState() {
    assertEquals(State.EMPTY, coord.getState());
  }

  /**
   * testing setting state
   */
  @Test
  public void testSetState() {
    coord.setState(State.HIT);
    assertEquals(State.HIT, coord.getState());
  }

  /**
   * row getter
   */
  @Test
  public void testGetRow() {
    assertEquals(2, coord.getRow());
  }

  /**
   * column getter
   */
  @Test
  public void testGetColumn() {
    assertEquals(3, coord.getColumn());
  }
}
