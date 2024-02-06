package cs3500.pa03.enums;

/**
 * Ship types
 */
public enum ShipType {
  CARRIER(6), BATTLESHIP(5), DESTROYER(4), SUBMARINE(3);

  private final int length;

  /**
   * constructor
   *
   * @param i length of shiptype
   */
  ShipType(int i) {
    this.length = i;
  }

  /**
   * getter for length
   *
   * @return length of ship
   */
  public int getLength() {
    return this.length;
  }
}
