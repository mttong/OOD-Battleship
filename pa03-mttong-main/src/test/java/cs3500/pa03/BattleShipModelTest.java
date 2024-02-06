package cs3500.pa03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa03.model.BattleShipModel;
import cs3500.pa03.model.Model;
import cs3500.pa03.model.player.MockPlayer;
import cs3500.pa03.model.player.MockPlayerEmptyShots;
import java.util.HashMap;
import org.junit.jupiter.api.Test;

/**
 * model test
 */
public class BattleShipModelTest {
  private Model model;

  /**
   * test set up
   */
  @Test
  public void testSetup() {
    MockPlayer player1 = new MockPlayer();
    MockPlayer player2 = new MockPlayer();
    model = new BattleShipModel(player1, player2);

    model.setup(1, 1, new HashMap<>());

    assertEquals("Player setup called.", player1.log.toString());
    assertEquals("Player setup called.", player2.log.toString());
  }

  /**
   * test player round
   */
  @Test
  public void testPlayRound() {
    MockPlayer player1 = new MockPlayer();
    MockPlayer player2 = new MockPlayer();
    model = new BattleShipModel(player1, player2);

    model.playRound();

    assertEquals("takeShots called.reportDamage called.successfulHits called.",
        player1.log.toString());
    assertEquals("takeShots called.reportDamage called.successfulHits called.",
        player2.log.toString());

  }

  /**
   * test empty round of shots
   */
  @Test
  public void testPlayRoundEmptyShots() {
    MockPlayerEmptyShots player1 = new MockPlayerEmptyShots();
    MockPlayerEmptyShots player2 = new MockPlayerEmptyShots();
    model = new BattleShipModel(player1, player2);

    model.playRound();

    assertEquals("takeShots called.", player1.log.toString());
    assertEquals("takeShots called.", player2.log.toString());

  }

  /**
   * test empty round of shots
   */
  @Test
  public void testPlayRoundEmptyShot1() {
    MockPlayerEmptyShots player1 = new MockPlayerEmptyShots();
    MockPlayer player2 = new MockPlayer();
    model = new BattleShipModel(player1, player2);

    model.playRound();

    assertEquals("takeShots called.", player1.log.toString());
    assertEquals("takeShots called.", player2.log.toString());

  }

  /**
   * test empty round of shots
   */
  @Test
  public void testPlayRoundEmptyShot2() {
    MockPlayer player1 = new MockPlayer();
    MockPlayerEmptyShots player2 = new MockPlayerEmptyShots();
    model = new BattleShipModel(player1, player2);

    model.playRound();

    assertEquals("takeShots called.", player1.log.toString());
    assertEquals("takeShots called.", player2.log.toString());

  }
}
