package cs3500.pa03.model;

import cs3500.pa03.enums.GameResult;
import cs3500.pa03.enums.ShipType;
import java.util.Map;

/**
 * Mock Model
 */
public class MockModel implements Model {

  public StringBuilder log;

  /**
   * constructor
   */
  public MockModel() {
    this.log = new StringBuilder();
  }

  /**
   * play round
   *
   * @return GameResult
   */
  @Override
  public GameResult playRound() {

    //only want to play one round while testing
    this.log.append("playRound called.");

    return GameResult.TIE;
  }

  /**
   * set up
   *
   * @param height         height of Board
   * @param width          width of Board
   * @param specifications how many of each ship
   */
  @Override
  public void setup(int height, int width, Map<ShipType, Integer> specifications) {
    this.log.append("Model setup called.");
  }
}
