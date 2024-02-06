package cs3500.pa03.model.player;


import java.util.Random;

/**
 * inherit info from Abstract Player
 */
public class AiPlayer extends AbstractPlayer {

  /**
   * constructor
   *
   * @param name name of player
   */
  public AiPlayer(String name, Random random) {
    super(name, random);
  }
}
