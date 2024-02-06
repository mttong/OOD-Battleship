package cs3500.pa03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa03.enums.GameResult;
import cs3500.pa03.model.Board;
import cs3500.pa03.view.BattleShipCommandView;
import cs3500.pa03.view.View;
import java.io.StringReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * view test
 */
public class BattleShipCommandViewTest {

  private Appendable append;
  private View gameView;

  /**
   * set up
   */
  @BeforeEach
  public void setUp() {
    append = new StringBuilder();
  }

  /**
   * test welcome
   */
  @Test
  public void testWelcome() {
    Readable read = new StringReader("6 6");
    View view = new BattleShipCommandView(read, append);

    view.welcome();

    assertEquals("""
        Hello! Welcome to the OOD BattleSalvo Game!
        Please enter a valid height and width below:\s
        ----------------------------------------------------
        """, append.toString());
  }

  /**
   * welcome should fail
   */
  @Test
  public void testWelcomeFail() {
    String input = """
        hello bye
        6 6
        """;
    Readable read = new StringReader(input);
    View view = new BattleShipCommandView(read, append);

    view.welcome();

    assertEquals("""
        Hello! Welcome to the OOD BattleSalvo Game!
        Please enter a valid height and width below:\s
        ----------------------------------------------------
        Uh oh! You've entered invalid numbers.\s
         Please remember to enter in two numbers within the range of (6, 15),\s
         inclusive to set the dimensions of your game.
         """, append.toString());
  }

  /**
   * test should fail
   */
  @Test
  public void testWelcomeFail1() {
    String input = """
        4 4
        6 6
        """;
    Readable read = new StringReader(input);
    View view = new BattleShipCommandView(read, append);

    view.welcome();

    assertEquals("""
        Hello! Welcome to the OOD BattleSalvo Game!
        Please enter a valid height and width below:\s
        ----------------------------------------------------
        Uh oh! You've entered invalid numbers.\s
         Please remember to enter in two numbers within the range of (6, 15),\s
         inclusive to set the dimensions of your game.
         """, append.toString());
  }

  /**
   * test should fail
   */
  @Test
  public void testWelcomeFail4() {
    String input = """
        16 16
        6 6
        """;
    Readable read = new StringReader(input);
    View view = new BattleShipCommandView(read, append);

    view.welcome();

    assertEquals("""
        Hello! Welcome to the OOD BattleSalvo Game!
        Please enter a valid height and width below:\s
        ----------------------------------------------------
        Uh oh! You've entered invalid numbers.\s
         Please remember to enter in two numbers within the range of (6, 15),\s
         inclusive to set the dimensions of your game.
         """, append.toString());
  }

  /**
   * tests should fail
   */
  @Test
  public void testWelcomeFail5() {
    String input = """
        6 4
        6 6
        """;
    Readable read = new StringReader(input);
    View view = new BattleShipCommandView(read, append);

    view.welcome();

    assertEquals("""
        Hello! Welcome to the OOD BattleSalvo Game!
        Please enter a valid height and width below:\s
        ----------------------------------------------------
        Uh oh! You've entered invalid numbers.\s
         Please remember to enter in two numbers within the range of (6, 15),\s
         inclusive to set the dimensions of your game.
         """, append.toString());
  }

  /**
   * test should fail
   */
  @Test
  public void testWelcomeFail6() {
    String input = """
        6 17
        6 6
        """;
    Readable read = new StringReader(input);
    View view = new BattleShipCommandView(read, append);

    view.welcome();

    assertEquals("""
        Hello! Welcome to the OOD BattleSalvo Game!
        Please enter a valid height and width below:\s
        ----------------------------------------------------
        Uh oh! You've entered invalid numbers.\s
         Please remember to enter in two numbers within the range of (6, 15),\s
         inclusive to set the dimensions of your game.
         """, append.toString());
  }

  /**
   * test should fail
   */
  @Test
  public void testWelcomeFail7() {
    String input = """
        4 6
        6 6
        """;
    Readable read = new StringReader(input);
    View view = new BattleShipCommandView(read, append);

    view.welcome();

    assertEquals("""
        Hello! Welcome to the OOD BattleSalvo Game!
        Please enter a valid height and width below:\s
        ----------------------------------------------------
        Uh oh! You've entered invalid numbers.\s
         Please remember to enter in two numbers within the range of (6, 15),\s
         inclusive to set the dimensions of your game.
         """, append.toString());
  }

  /**
   * test should fail
   */
  @Test
  public void testWelcomeFail8() {
    String input = """
        24 6
        6 6
        """;
    Readable read = new StringReader(input);
    View view = new BattleShipCommandView(read, append);

    view.welcome();

    assertEquals("""
        Hello! Welcome to the OOD BattleSalvo Game!
        Please enter a valid height and width below:\s
        ----------------------------------------------------
        Uh oh! You've entered invalid numbers.\s
         Please remember to enter in two numbers within the range of (6, 15),\s
         inclusive to set the dimensions of your game.
         """, append.toString());
  }

  /**
   * test should fail
   */
  @Test
  public void testWelcomeFail2() {
    String input = """
        4
        6 6
        """;
    Readable read = new StringReader(input);
    View view = new BattleShipCommandView(read, append);

    view.welcome();

    assertEquals("""
        Hello! Welcome to the OOD BattleSalvo Game!
        Please enter a valid height and width below:\s
        ----------------------------------------------------
        Uh oh! You've entered invalid numbers.\s
         Please remember to enter in two numbers within the range of (6, 15),\s
         inclusive to set the dimensions of your game.
         """, append.toString());
  }

  /**
   * test should fail
   */
  @Test
  public void testWelcomeFail3() {
    String input = """
        -1 -1
        6 6
        """;
    Readable read = new StringReader(input);
    View view = new BattleShipCommandView(read, append);

    view.welcome();

    assertEquals("""
        Hello! Welcome to the OOD BattleSalvo Game!
        Please enter a valid height and width below:\s
        ----------------------------------------------------
        Uh oh! You've entered invalid numbers.\s
         Please remember to enter in two numbers within the range of (6, 15),\s
         inclusive to set the dimensions of your game.
         """, append.toString());
  }

  /**
   * test fleet selection
   */
  @Test
  public void testFleetSelection() {
    Readable read = new StringReader("1 1 1 1");
    View view = new BattleShipCommandView(read, append);

    view.fleetSelection(6);

    assertEquals("""
        Please enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine]\s
        Remember, your fleet may not exceed size 6
        """, append.toString());
  }

  /**
   * fleet selection should fail
   */
  @Test
  public void testFleetSelectionError() {
    String input = """
        2 2 2 2
        1 1 1 1
        """;
    Readable read = new StringReader(input);
    View view = new BattleShipCommandView(read, append);

    view.fleetSelection(6);

    assertEquals("""
        Please enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine]\s
        Remember, your fleet may not exceed size 6
        Uh oh! Invalid fleet numbers\s
        Please enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine]\s
        Remember, your fleet may not exceed size 6
        """, append.toString());
  }

  /**
   * fleet selection error
   */
  @Test
  public void testFleetSelectionError1() {
    String input = """
        2 2 2 0
        1 1 1 1
        """;
    Readable read = new StringReader(input);
    View view = new BattleShipCommandView(read, append);

    view.fleetSelection(6);

    assertEquals("""
        Please enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine]\s
        Remember, your fleet may not exceed size 6
        Uh oh! Invalid fleet numbers\s
        Please enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine]\s
        Remember, your fleet may not exceed size 6
        """, append.toString());
  }

  /**
   * display board test
   */
  @Test
  public void testDisplayBoard() {
    Board board = new Board(2, 2);
    Readable read = new StringReader("");
    View view = new BattleShipCommandView(read, append);

    view.displayBoard(board, "maggie");

    assertEquals("""
        maggie's Board
        0 0\s
        0 0\s
        """, append.toString());

  }

  /**
   * enter shots test
   */
  @Test
  public void testEnterShots() {
    String input = """
        1 1
        0 0
        """;
    Readable read = new StringReader(input);
    View view = new BattleShipCommandView(read, append);

    view.enterShots(2, 2, 2);

    assertEquals("Please enter 2 shots \n", append.toString());
  }

  /**
   * enter shots error
   */
  @Test
  public void testEnterShotsError() {
    String input = """
        1 1
        3 3
        0 0
        """;
    Readable read = new StringReader(input);
    View view = new BattleShipCommandView(read, append);

    view.enterShots(2, 2, 2);

    assertEquals("""
        Please enter 2 shots\s
        Your shot 1 was invalid. Please enter another one.\s
        Your width max is 1 and your height max is 1
        """, append.toString());
  }

  /**
   * enter shots error
   */
  @Test
  public void testEnterShotsError1() {
    String input = """
        1 1
        3 1
        0 0
        """;
    Readable read = new StringReader(input);
    View view = new BattleShipCommandView(read, append);

    view.enterShots(2, 2, 2);

    assertEquals("""
        Please enter 2 shots\s
        Your shot 1 was invalid. Please enter another one.\s
        Your width max is 1 and your height max is 1
        """, append.toString());
  }

  /**
   * enter shots error
   */
  @Test
  public void testEnterShotsError2() {
    String input = """
        1 1
        1 3
        0 0
        """;
    Readable read = new StringReader(input);
    View view = new BattleShipCommandView(read, append);

    view.enterShots(2, 2, 2);

    assertEquals("""
        Please enter 2 shots\s
        Your shot 1 was invalid. Please enter another one.\s
        Your width max is 1 and your height max is 1
        """, append.toString());
  }

  /**
   * game set up
   */
  public void gameEndSetUp() {
    Readable read = new StringReader("");
    gameView = new BattleShipCommandView(read, append);

  }

  /**
   * game end test
   */
  @Test
  public void testGameEnd1() {
    gameEndSetUp();

    gameView.gameEnd(GameResult.PLAYER1);
    assertEquals("Player 1 won", append.toString());


  }

  /**
   * game end test
   */
  @Test
  public void testGameEnd2() {
    gameEndSetUp();
    gameView.gameEnd(GameResult.PLAYER2);
    assertEquals("Player 2 won", append.toString());
  }

  /**
   * game end test
   */
  @Test
  public void testGameEnd3() {
    gameEndSetUp();
    gameView.gameEnd(GameResult.TIE);
    assertEquals("Tie!", append.toString());
  }

  /**
   * game end test
   */
  @Test
  public void testGameEnd4() {
    gameEndSetUp();
    gameView.gameEnd(GameResult.STILLGOING);
    assertEquals("", append.toString());
  }

}
