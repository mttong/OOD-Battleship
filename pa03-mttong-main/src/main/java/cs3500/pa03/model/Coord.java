package cs3500.pa03.model;

import cs3500.pa03.enums.State;

/**
 * Coordinate class
 */
public class Coord {
  private final int row;
  private final int column;
  private State state;

  /**
   * constructor
   *
   * @param row    coordinate row
   * @param column coordinate column
   */
  public Coord(int row, int column) {
    this.row = row;
    this.column = column;
    this.state = State.EMPTY;
  }

  /**
   * Coordinate as string
   *
   * @return String
   */
  @Override
  public String toString() {
    return state.toString();
  }

  /**
   * check to see if this coordinate is the same as other coordinate
   *
   * @param other coordinate
   * @return true if same
   */
  public boolean sameCoordinate(Coord other) {
    return this.row == other.row && this.column == other.column;
  }

  /**
   * get state of Coord
   *
   * @return state
   */
  public State getState() {
    return this.state;
  }

  /**
   * set state of the coordinate
   *
   * @param state State enum
   */
  public void setState(State state) {
    this.state = state;
  }

  /**
   * row getter
   *
   * @return int
   */
  public int getRow() {
    return this.row;
  }

  /**
   * column getter
   *
   * @return int
   */
  public int getColumn() {
    return this.column;
  }
}
