package cs3500.pa03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa03.enums.ShipType;
import cs3500.pa03.enums.State;
import cs3500.pa03.model.Coord;
import cs3500.pa03.model.Ship;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * test ship class
 */
public class ShipTest {

  private Ship ship;
  private Random random;

  /**
   * set up tests
   */
  @BeforeEach
  public void setUp() {

    ship = new Ship();
    random = new Random(0);
  }

  /**
   * test overlap ships
   */
  @Test
  public void testOverlapShip() {
    Ship overlappingShip = new Ship();
    assertTrue(ship.overlapShip(overlappingShip));

    Ship nonOverlappingShip = new Ship(ShipType.CARRIER, 7, 7, random);
    assertFalse(ship.overlapShip(nonOverlappingShip));

    Ship nonOverlappingShip2 = new Ship(ShipType.SUBMARINE, 3, 3, random);
    assertFalse(ship.overlapShip(nonOverlappingShip2));
  }

  /**
   * test shot or miss
   */
  @Test
  public void testShotHitOrMiss() {
    Coord shot1 = new Coord(0, 0);

    ship.shotHitOrMiss(shot1);

    assertEquals(State.HIT, shot1.getState());
    assertEquals(1, ship.getCoordinates().size());


    Coord shot2 = new Coord(2, 2);

    ship.shotHitOrMiss(shot2);

    assertEquals(State.MISS, shot2.getState());
    assertEquals(1, ship.getCoordinates().size());

    ship.shotHitOrMiss(shot1);
    assertEquals(State.HIT, shot1.getState());

  }

  /**
   * test get coordinates
   */
  @Test
  public void testGetCoordinates() {
    Coord coord1 = new Coord(0, 0);
    coord1.setState(State.SHIP);
    Coord coord2 = new Coord(0, 1);
    coord2.setState(State.SHIP);
    List<Coord> expected = new ArrayList<>(Arrays.asList(coord1, coord2));

    List<Coord> coordinates = ship.getCoordinates();

    assertEquals(expected.size(), coordinates.size());
  }
}
