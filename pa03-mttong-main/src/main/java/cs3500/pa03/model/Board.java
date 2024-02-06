package cs3500.pa03.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Board class
 */
public class Board {
  Coord[][] board;
  List<Coord> alreadyShot;

  /**
   * constructor
   *
   * @param height height of board
   * @param width  width of board
   */
  public Board(int height, int width) {
    alreadyShot = new ArrayList<>();
    initializeBoard(height, width);
  }

  /**
   * initialize board based on height and width
   *
   * @param height height dimension
   * @param width  width dimension
   */
  private void initializeBoard(int height, int width) {
    this.board = new Coord[height][width];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        board[i][j] = new Coord(i, j);
      }
    }
  }

  /**
   * baord to string to display on command line
   *
   * @return String
   */
  @Override
  public String toString() {
    StringBuilder boardString = new StringBuilder();
    for (Coord[] row : board) {
      for (Coord element : row) {
        boardString.append(element.toString()).append(" ");
      }
      boardString.append("\n");
    }
    return boardString.toString();
  }

  /**
   * height getter
   *
   * @return int
   */
  public int getHeight() {
    return board.length;
  }

  /**
   * width getter
   *
   * @return int
   */
  public int getWidth() {
    return board[0].length;
  }

  /**
   * create a board based on a list of ships and a list of shots
   *
   * @param shots opponent shots at board
   * @param ships my ships
   * @return Board
   */
  public Board generateMyBoard(List<Coord> shots, List<Ship> ships) {

    List<Coord> newStates = new ArrayList<>(shots);
    for (Ship ship : ships) {
      newStates.addAll(ship.getCoordinates());
    }

    this.updateBoard(newStates);

    return this;
  }

  /**
   * update a board's coordinate's states based on the given list
   *
   * @param hits opponent shots
   */
  public void updateBoard(List<Coord> hits) {
    for (Coord[] row : board) {
      for (Coord coord : row) {
        for (Coord hit : hits) {
          if (coord.sameCoordinate(hit)) {
            coord.setState(hit.getState());
          }
        }
      }
    }
  }

  /**
   * add to a list of already shot places
   *
   * @param shot new shot
   */
  public void updateShotsTaken(Coord shot) {
    this.alreadyShot.add(shot);
  }

  /**
   * already shot getter
   *
   * @return list of coordinates
   */
  public List<Coord> getAlreadyShot() {
    return alreadyShot;
  }


}
