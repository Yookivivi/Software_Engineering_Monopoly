package Controller;
import Model.*;
import View.*;

import java.io.Serializable;

/**
 * This class is the controller to control the boardView to print the board
 */

public class BoardController implements Serializable {
    private Board board;
    private BoardView boardView;

    /**
     * Constructor for BoardController
     * @param b Board instance
     * @param bw BoardView instance
     */
    public BoardController(Board b, BoardView bw){
        this.board = b;
        this.boardView = bw;
    }

    public void printBoard(){
        boardView.printBoard(board);
    }
}
