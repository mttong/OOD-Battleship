package cs3500.pa03.view;

import cs3500.pa03.enums.GameResult;
import cs3500.pa03.enums.ShipType;
import cs3500.pa03.model.Board;
import cs3500.pa03.model.Coord;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Mock View
 */
public class MockView implements View {

  public StringBuilder log;

  /**
   * constructor
   */
  public MockView() {
    this.log = new StringBuilder();
  }

  /**
   * welcome
   *
   * @return list of integers
   */
  @Override
  public List<Integer> welcome() {
    this.log.append("welcome called.");
    return new ArrayList<>(Arrays.asList(6, 6));
  }

  /**
   * fleet selection
   *
   * @param size max fleet size
   * @return HashMap
   */
  @Override
  public Map<ShipType, Integer> fleetSelection(int size) {
    this.log.append("fleetSelection called.");

    Map<ShipType, Integer> fleet = new HashMap<>();
    fleet.put(ShipType.CARRIER, 1);
    fleet.put(ShipType.DESTROYER, 1);
    fleet.put(ShipType.BATTLESHIP, 1);
    fleet.put(ShipType.SUBMARINE, 1);
    return fleet;
  }

  /**
   * display board
   *
   * @param board inputted board
   * @param name  name of player
   */
  @Override
  public void displayBoard(Board board, String name) {
    this.log.append("displayBoard called.");
  }

  /**
   * enter shots
   *
   * @param numShots  amount of shots
   * @param widthMax  board width
   * @param heightMax board height
   * @return list of coordinates
   */
  @Override
  public List<Coord> enterShots(int numShots, int widthMax, int heightMax) {
    this.log.append("enterShots called.");
    return new ArrayList<>(Arrays.asList(new Coord(1, 1), new Coord(0, 0)));
  }

  /**
   * game end
   *
   * @param result result of game
   */
  @Override
  public void gameEnd(GameResult result) {
    this.log.append("gameEnd called.");
  }
}
