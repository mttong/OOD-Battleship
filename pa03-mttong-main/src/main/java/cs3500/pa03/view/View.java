package cs3500.pa03.view;

import cs3500.pa03.enums.GameResult;
import cs3500.pa03.enums.ShipType;
import cs3500.pa03.model.Board;
import cs3500.pa03.model.Coord;
import java.util.List;
import java.util.Map;

/**
 * view interface
 */
public interface View {

  /**
   * welcoming the user
   *
   * @return list of integers
   */
  List<Integer> welcome();

  /**
   * selecting fleet
   *
   * @param size max fleet size
   * @return Hashmap of fleet
   */
  Map<ShipType, Integer> fleetSelection(int size);

  /**
   * displaying the board
   *
   * @param board inputted board
   * @param name  name of player
   */
  void displayBoard(final Board board, String name);

  /**
   * allow user to enter shots
   *
   * @param numShots  amount of shots
   * @param widthMax  board width
   * @param heightMax board height
   * @return list of coordinates of shots
   */
  List<Coord> enterShots(int numShots, int widthMax, int heightMax);

  /**
   * game end display
   *
   * @param result result of game
   */
  void gameEnd(GameResult result);
}
