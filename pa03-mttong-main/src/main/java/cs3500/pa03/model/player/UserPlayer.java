package cs3500.pa03.model.player;

import cs3500.pa03.model.Coord;
import cs3500.pa03.view.View;
import java.util.List;
import java.util.Random;

/**
 * UserPlayer extended from abstract player
 */
public class UserPlayer extends AbstractPlayer {

  private final View manualDataEntry;


  /**
   * constructor
   *
   * @param name player name
   * @param view same view controller is using, how player enters shots
   */
  public UserPlayer(String name, Random random, View view) {
    super(name, random);
    this.manualDataEntry = view;
  }

  /**
   * Override abstract takeShots, which is randomized, to allow user input
   *
   * @return List of coordinates
   */
  @Override
  public List<Coord> takeShots() {

    //to display user's board and opponent's board based on what the user knows
    manualDataEntry.displayBoard(this.generateMyBoard(), this.name());
    manualDataEntry.displayBoard(otherBoard, "Opponent");


    List<Coord> shots =
        manualDataEntry.enterShots(myShips.size(), otherBoard.getWidth(), otherBoard.getHeight());

    //remove any shots user has already shot
    for (Coord shot : shots) {
      for (Coord alreadyShot : otherBoard.getAlreadyShot()) {
        if (!shot.sameCoordinate(alreadyShot)) {
          otherBoard.updateShotsTaken(shot);
        }
      }

    }

    return shots;
  }


}
