package cs3500.pa03.controller;

import cs3500.pa03.enums.GameResult;
import cs3500.pa03.enums.ShipType;
import cs3500.pa03.model.Model;
import cs3500.pa03.view.View;
import java.util.List;
import java.util.Map;

/**
 * Controller for BattleShip
 */
public class BattleShipController implements Controller {
  private final Model model;
  private final View view;
  private boolean gameGoing;

  /**
   * constructor
   *
   * @param model Battleship model
   * @param view  Battleship view
   */
  public BattleShipController(Model model, View view) {
    this.model = model;
    this.view = view;
    this.gameGoing = true;
  }

  /**
   * run game
   */
  public void run() {
    List<Integer> dimensions = view.welcome();

    int maxFleet = getMin(dimensions);
    Map<ShipType, Integer> fleet = view.fleetSelection(maxFleet);


    model.setup(dimensions.get(0), dimensions.get(1), fleet);

    while (gameGoing) {
      GameResult result = model.playRound();
      if (!(result == GameResult.STILLGOING)) {
        view.gameEnd(result);
        gameGoing = false;
      }

    }


  }

  /**
   * helper to get minimum in a list
   *
   * @param lst list
   * @return minimum int
   */
  private int getMin(List<Integer> lst) {
    int min = lst.get(0);
    for (int num : lst) {
      if (num < min) {
        min = num;
      }
    }
    return min;
  }


}

