package cs3500.pa03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa03.enums.ShipType;
import cs3500.pa03.model.player.Player;
import cs3500.pa03.model.player.UserPlayer;
import cs3500.pa03.view.MockView;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * user player test
 */
public class UserPlayerTest {
  private Player userPlayer;

  private MockView view;

  /**
   * set up tests
   */
  @BeforeEach
  public void setUp() {
    view = new MockView();

    Random randSeed = new Random(0);
    userPlayer = new UserPlayer("maggie", randSeed, view);

    Map<ShipType, Integer> fleet = new HashMap<>();
    fleet.put(ShipType.CARRIER, 1);
    fleet.put(ShipType.DESTROYER, 1);
    fleet.put(ShipType.BATTLESHIP, 1);
    fleet.put(ShipType.SUBMARINE, 1);


    userPlayer.setup(6, 6, fleet);
  }

  /**
   * take shots test
   */
  @Test
  public void testTakeShots() {
    userPlayer.takeShots();

    assertEquals("displayBoard called.displayBoard called.enterShots called.", view.log.toString());

  }


}
