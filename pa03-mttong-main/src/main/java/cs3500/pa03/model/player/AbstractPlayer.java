package cs3500.pa03.model.player;

import cs3500.pa03.enums.GameResult;
import cs3500.pa03.enums.ShipType;
import cs3500.pa03.model.Board;
import cs3500.pa03.model.Coord;
import cs3500.pa03.model.Ship;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Abstract Player that implements Player interface
 */
public abstract class AbstractPlayer implements Player {

  protected final String name;
  protected final Random random;
  protected List<Ship> myShips;
  protected List<Coord> opponentShots;
  protected Board otherBoard;


  /**
   * constructor
   *
   * @param name player name
   */
  public AbstractPlayer(String name, Random random) {
    this.name = name;
    this.otherBoard = null;
    this.myShips = new ArrayList<>();
    this.opponentShots = new ArrayList<>();

    this.random = random;
  }


  /**
   * Get the player's name.
   *
   * @return the player's name
   */
  public String name() {
    return name;
  }

  /**
   * Given the specifications for a BattleSalvo board, return a list of ships with their locations
   * on the board.
   *
   * @param height         the height of the board, range: [6, 15] inclusive
   * @param width          the width of the board, range: [6, 15] inclusive
   * @param specifications a map of ship type to the number of occurrences each ship should
   *                       appear on the board
   * @return the placements of each ship on the board
   */
  public List<Ship> setup(int height, int width, Map<ShipType, Integer> specifications) {
    this.otherBoard = new Board(height, width);

    //initializing list of ships
    List<Ship> ships = new ArrayList<>();

    List<ShipType> lstShipTypes = new ArrayList<>(specifications.keySet());
    Collections.sort(lstShipTypes);

    for (ShipType entry : lstShipTypes) {
      for (int i = 0; i < specifications.get(entry); i++) {

        Ship currShip = new Ship(entry, height, width, random);
        while (!validLocation(ships, currShip)) {
          currShip = new Ship(entry, height, width, random);
        }

        ships.add(currShip);

      }

    }

    this.myShips = ships;

    return ships;
  }


  /**
   * Returns this player's shots on the opponent's board. The number of shots returned should
   * equal the number of ships on this player's board that have not sunk.
   *
   * @return the locations of shots on the opponent's board
   */
  public List<Coord> takeShots() {
    List<Coord> aiShots = new ArrayList<>();
    int width = otherBoard.getWidth();
    int height = otherBoard.getHeight();
    int numOfShots = myShips.size(); //number of shots based on how many ships are "left"


    for (int i = 0; i < numOfShots; i++) {
      int randomX = random.nextInt(width);
      int randomY = random.nextInt(height);

      Coord currCoord = new Coord(randomX, randomY);
      //make sure the place hasn't already been shot at previously
      while (notValidShot(currCoord)) {
        randomX = random.nextInt(width);
        randomY = random.nextInt(height);

        currCoord = new Coord(randomX, randomY);
      }

      otherBoard.updateShotsTaken(currCoord);
      aiShots.add(currCoord);

    }

    return aiShots;
  }


  /**
   * Given the list of shots the opponent has fired on this player's board, report which
   * shots hit a ship on this player's board.
   *
   * @param opponentShotsOnBoard the opponent's shots on this player's board
   * @return a filtered list of the given shots that contain all locations of shots that hit a
   *         ship on this board
   */
  public List<Coord> reportDamage(List<Coord> opponentShotsOnBoard) {

    //keeping track of shots that hit
    List<Coord> updatedOpponentShotsOnBoard = new ArrayList<>();

    List<Ship> removeShips = new ArrayList<>();

    for (Ship ship : this.myShips) {
      for (Coord opponentShot : opponentShotsOnBoard) {
        updatedOpponentShotsOnBoard.add(ship.shotHitOrMiss(opponentShot));
      }

      if (ship.getCoordinates().size() == 0) {
        removeShips.add(ship);
      }
    }

    opponentShots.addAll(updatedOpponentShotsOnBoard);

    myShips.removeAll(removeShips);

    return updatedOpponentShotsOnBoard;
  }

  /**
   * Reports to this player what shots in their previous volley returned from takeShots()
   * successfully hit an opponent's ship.
   *
   * @param shotsThatHitOpponentShips the list of shots that successfully hit the opponent's ships
   */
  public void successfulHits(List<Coord> shotsThatHitOpponentShips) {
    otherBoard.updateBoard(shotsThatHitOpponentShips);
  }

  /**
   * Notifies the player that the game is over.
   * Win, lose, and draw should all be supported
   *
   * @param result if the player has won, lost, or forced a draw
   * @param reason the reason for the game ending
   */
  public void endGame(GameResult result, String reason) {

  }

  /**
   * are any of the current ship's coordinates already in any of the ships
   * in the ship list's coordinates
   *
   * @param shipList list of ships to compare to
   * @param currShip current ship
   * @return boolean
   */
  private boolean validLocation(List<Ship> shipList, Ship currShip) {
    boolean flag = true;
    for (Ship ship : shipList) {
      flag = flag && !currShip.overlapShip(ship);
    }
    return flag;
  }

  /**
   * generates a board based on the opponentsShots and list of ships
   *
   * @return Board
   */
  protected Board generateMyBoard() {
    Board board = new Board(otherBoard.getHeight(), otherBoard.getWidth());
    return board.generateMyBoard(this.opponentShots, this.myShips);
  }


  /**
   * make sure a new shot hasn't been shot before
   *
   * @param newShot new shot
   * @return boolean
   */
  protected boolean notValidShot(Coord newShot) {
    //checking to see if any of the shots have been shot before
    for (Coord existingShot : otherBoard.getAlreadyShot()) {
      return newShot.sameCoordinate(existingShot);

    }
    return false;
  }

}
