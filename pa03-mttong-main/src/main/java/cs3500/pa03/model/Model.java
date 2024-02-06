package cs3500.pa03.model;

import cs3500.pa03.enums.GameResult;
import cs3500.pa03.enums.ShipType;
import java.util.Map;

/**
 * Model interface
 */
public interface Model {

  /**
   * Play round of game
   *
   * @return GameResult
   */
  GameResult playRound();

  /**
   * set up player ships
   *
   * @param height         height of Board
   * @param width          width of Board
   * @param specifications how many of each ship
   */
  void setup(int height, int width, Map<ShipType, Integer> specifications);
}
