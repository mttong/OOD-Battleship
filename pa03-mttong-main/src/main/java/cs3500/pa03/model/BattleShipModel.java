package cs3500.pa03.model;

import cs3500.pa03.enums.GameResult;
import cs3500.pa03.enums.ShipType;
import cs3500.pa03.model.player.Player;
import java.util.List;
import java.util.Map;

/**
 * Model for BattleShip
 */
public class BattleShipModel implements Model {

  private final Player player1;
  private final Player player2;

  /**
   * constructor
   *
   * @param player1 userPlayer
   * @param player2 AiPlayer
   */
  public BattleShipModel(Player player1, Player player2) {
    this.player1 = player1;
    this.player2 = player2;
  }

  /**
   * set up both player's ships
   *
   * @param height         height of Board
   * @param width          width of Board
   * @param specifications how many of each ship
   */
  public void setup(int height, int width, Map<ShipType, Integer> specifications) {
    player1.setup(height, width, specifications);
    player2.setup(height, width, specifications);

  }

  /**
   * playing each round
   *
   * @return GameResult
   */
  public GameResult playRound() {

    List<Coord> player1Shots = player1.takeShots();
    List<Coord> player2Shots = player2.takeShots();

    if (player1Shots.size() == 0 && player2Shots.size() == 0) {
      return GameResult.TIE;
    } else if (player1Shots.size() == 0) {
      return GameResult.PLAYER2;
    } else if (player2Shots.size() == 0) {
      return GameResult.PLAYER1;
    }

    List<Coord> player1SuccessfulHits = player1.reportDamage(player2Shots);
    List<Coord> player2SuccessfulHits = player2.reportDamage(player1Shots);

    player1.successfulHits(player2SuccessfulHits);
    player2.successfulHits(player1SuccessfulHits);

    return GameResult.STILLGOING;
  }


}
