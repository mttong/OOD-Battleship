package cs3500.pa03.model;

import cs3500.pa03.enums.Orientation;
import cs3500.pa03.enums.ShipType;
import cs3500.pa03.enums.State;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Ship class
 */
public class Ship {
  private final ShipType type;

  private final List<Coord> coordinates;

  Random random;


  /**
   * constructor
   *
   * @param type   ship type
   * @param height height of board
   * @param width  width of board
   */
  public Ship(ShipType type, int height, int width, Random r) {
    this.random = r;
    this.type = type;

    this.coordinates = initializeShip(height, width);
  }


  /**
   * constructor for testing purposes
   */
  public Ship() {
    this.type = ShipType.SUBMARINE;
    Coord coord1 = new Coord(0, 0);
    coord1.setState(State.SHIP);
    Coord coord2 = new Coord(0, 1);
    coord2.setState(State.SHIP);
    this.coordinates = new ArrayList<>(Arrays.asList(coord1, coord2));
  }


  /**
   * initialize a ship based on board height and width
   *
   * @param height board height
   * @param width  board width
   * @return List of coordinates where the ship is
   */
  private List<Coord> initializeShip(int height, int width) {
    Orientation orientation = randomOrientation();
    int shipLength = type.getLength();
    List<Coord> coordinates = new ArrayList<>();

    //vertical ship placement
    if (orientation == Orientation.VERTICAL) {
      int widthIndex = random.nextInt(width);
      int startHeightIndex = random.nextInt(height - shipLength + 1);
      for (int i = 0; i < shipLength; i++) {
        Coord currCoord = new Coord(widthIndex, startHeightIndex + i);
        currCoord.setState(State.SHIP);
        coordinates.add(currCoord);
      } //horizontal ship placement
    } else if (orientation == Orientation.HORIZONTAL) {
      int heightIndex = random.nextInt(height);
      int startWidthIndex = random.nextInt(width - shipLength + 1);
      for (int i = 0; i < shipLength; i++) {
        Coord currCoord = new Coord(startWidthIndex + i, heightIndex);
        currCoord.setState(State.SHIP);
        coordinates.add(currCoord);
      }
    }


    return coordinates;
  }

  /**
   * see if two ships are overlapping
   *
   * @param other other ship
   * @return boolean if overlapping
   */
  public boolean overlapShip(Ship other) {
    boolean flag = false;
    for (Coord thisCoordinate : coordinates) {
      for (Coord otherCoordinate : other.coordinates) {
        flag = flag || thisCoordinate.sameCoordinate(otherCoordinate);
      }
    }
    return flag;
  }

  /**
   * choosing a vertical or horizontal orientation
   *
   * @return Orientation
   */
  public Orientation randomOrientation() {
    Orientation[] values = Orientation.class.getEnumConstants();
    return values[random.nextInt(values.length)];
  }

  /**
   * change state of coordinate based on whether it was a hit or miss
   *
   * @param shot shot from opponent
   * @return Coordinate with new state
   */
  public Coord shotHitOrMiss(Coord shot) {
    if (shot.getState() == State.HIT) {
      return shot;
    }
    shot.setState(State.MISS);

    Coord removeShot = null;
    for (Coord shipCoordinate : coordinates) {
      if (shot.sameCoordinate(shipCoordinate)) {
        shot.setState(State.HIT);


        //adds reference to shipCoordinate reference
        removeShot = shipCoordinate;


      }
    }

    coordinates.remove(removeShot);


    return shot;
  }

  /**
   * coordinates getter
   *
   * @return list of coordinates of ship
   */
  public List<Coord> getCoordinates() {
    return coordinates;
  }

}
