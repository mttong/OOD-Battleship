package cs3500.pa03.enums;

/**
 * State of the coordinate enum
 */
public enum State {
  HIT("H"), MISS("M"), SHIP("S"), EMPTY("0");

  private final String mark;

  /**
   * constructor
   *
   * @param m state string
   */
  State(String m) {
    this.mark = m;
  }

  /**
   * return State as a string
   *
   * @return String
   */
  @Override
  public String toString() {
    return this.mark;
  }

}
