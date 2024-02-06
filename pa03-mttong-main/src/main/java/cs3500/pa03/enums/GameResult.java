package cs3500.pa03.enums;

/**
 * Result of game
 */
public enum GameResult {
  PLAYER1("Player 1 won"),
  PLAYER2("Player 2 won"),
  TIE("Tie!"),
  STILLGOING("");


  private final String message;

  /**
   * constructor
   *
   * @param message who won message
   */
  GameResult(String message) {
    this.message = message;
  }

  /**
   * message getter
   *
   * @return String
   */
  public String getMessage() {
    return this.message;
  }


}
