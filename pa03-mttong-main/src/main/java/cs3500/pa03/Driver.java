package cs3500.pa03;

import cs3500.pa03.controller.BattleShipController;
import cs3500.pa03.controller.Controller;
import cs3500.pa03.model.BattleShipModel;
import cs3500.pa03.model.Model;
import cs3500.pa03.model.player.AiPlayer;
import cs3500.pa03.model.player.UserPlayer;
import cs3500.pa03.view.BattleShipCommandView;
import cs3500.pa03.view.View;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * This is the main driver of this project.
 */
public class Driver {
  /**
   * Project entry point
   *
   * @param args - no command line args required
   */
  public static void main(String[] args) {
    //to change -> BattleShip.run();
    Random random = new Random();
    View view = new BattleShipCommandView(new InputStreamReader(System.in), System.out);
    Model model =
        new BattleShipModel(new UserPlayer("maggie", random, view),
            new AiPlayer("ohNO", random));
    Controller controller = new BattleShipController(model, view);
    controller.run();
  }
}