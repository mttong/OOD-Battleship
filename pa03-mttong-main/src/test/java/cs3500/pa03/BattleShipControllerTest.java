package cs3500.pa03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa03.controller.BattleShipController;
import cs3500.pa03.controller.Controller;
import cs3500.pa03.model.MockModel;
import cs3500.pa03.view.MockView;
import org.junit.jupiter.api.Test;

/**
 * battleship controller test
 */
public class BattleShipControllerTest {

  /**
   * run test
   */
  @Test
  public void testRun() {
    MockView view = new MockView();
    MockModel model = new MockModel();

    Controller controller = new BattleShipController(model, view);

    controller.run();

    assertEquals("welcome called.fleetSelection called.gameEnd called.",
        view.log.toString());
    assertEquals("Model setup called.playRound called.", model.log.toString());
  }
}
