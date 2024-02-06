package cs3500.pa03.model.player;

import cs3500.pa03.enums.GameResult;
import cs3500.pa03.enums.ShipType;
import cs3500.pa03.model.Coord;
import cs3500.pa03.model.Ship;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Mock Player with empty shots
 */
public class MockPlayerEmptyShots implements Player {
  public StringBuilder log;

  /**
   * constructor
   */
  public MockPlayerEmptyShots() {
    this.log = new StringBuilder();

  }

  /**
   * name of player
   *
   * @return String
   */
  @Override
  public String name() {
    return "MockPlayer";
  }

  /**
   * set up
   *
   * @param height         the height of the board, range: [6, 15] inclusive
   * @param width          the width of the board, range: [6, 15] inclusive
   * @param specifications a map of ship type to the number of occurrences each ship should
   *                       appear on the board
   * @return String
   */
  @Override
  public List<Ship> setup(int height, int width, Map<ShipType, Integer> specifications) {

    this.log.append("Player setup called.");

    return new ArrayList<>(List.of(new Ship()));
  }

  /**
   * take shots
   *
   * @return list of coordinates
   */
  @Override
  public List<Coord> takeShots() {

    this.log.append("takeShots called.");

    return new ArrayList<>();
  }

  /**
   * reportDamage
   *
   * @param opponentShotsOnBoard the opponent's shots on this player's board
   * @return list of coordinates
   */
  @Override
  public List<Coord> reportDamage(List<Coord> opponentShotsOnBoard) {

    this.log.append("reportDamage called.");

    return new ArrayList<>();
  }

  /**
   * successful hits
   *
   * @param shotsThatHitOpponentShips the list of shots that successfully hit the opponent's ships
   */
  @Override
  public void successfulHits(List<Coord> shotsThatHitOpponentShips) {
    this.log.append("successfulHits called.");
  }

  /**
   * end of game
   *
   * @param result if the player has won, lost, or forced a draw
   * @param reason the reason for the game ending
   */
  @Override
  public void endGame(GameResult result, String reason) {
    this.log.append("endGame called.");
  }
}
