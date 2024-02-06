package cs3500.pa03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa03.enums.ShipType;
import cs3500.pa03.model.Coord;
import cs3500.pa03.model.Ship;
import cs3500.pa03.model.player.AiPlayer;
import cs3500.pa03.model.player.Player;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * ai player test, implements all the abstract player's methods
 */
public class AiPlayerTest {

  private Player aiPlayer;

  private Map<ShipType, Integer> fleet;

  private List<Ship> result;

  /**
   * set up
   */
  @BeforeEach
  public void setUp() {

    Random randSeed = new Random(0);
    aiPlayer = new AiPlayer("maggie", randSeed);

    fleet = new HashMap<>();
    fleet.put(ShipType.CARRIER, 1);
    fleet.put(ShipType.DESTROYER, 1);
    fleet.put(ShipType.BATTLESHIP, 1);
    fleet.put(ShipType.SUBMARINE, 1);


    result = aiPlayer.setup(6, 6, fleet);
  }

  /**
   * test name
   */
  @Test
  public void testName() {
    assertEquals("maggie", aiPlayer.name());
  }

  /**
   * test set up
   */
  @Test
  public void testSetup() {

    assertEquals(fleet.size(), result.size());


  }

  /**
   * test takeshots
   */
  @Test
  public void testTakeShots() {
    List<Coord> shots = aiPlayer.takeShots();

    for (Coord shot : shots) {
      assertTrue(shot.getRow() >= 0 && shot.getRow() < 6);
      assertTrue(shot.getRow() >= 0 && shot.getColumn() < 6);
    }

  }

  /**
   * test report damage
   */
  @Test
  public void testReportDamage() {
    List<Coord> opponentShots = new ArrayList<>();
    opponentShots.add(new Coord(1, 1));
    opponentShots.add(new Coord(2, 2));
    opponentShots.add(new Coord(3, 3));


    aiPlayer.reportDamage(opponentShots);

  }

  /**
   * test successful hits
   */
  @Test
  public void testSuccessfulHits() {
    List<Coord> successfulShots = new ArrayList<>();
    successfulShots.add(new Coord(1, 1));
    successfulShots.add(new Coord(2, 2));

    aiPlayer.successfulHits(successfulShots);

  }


}
