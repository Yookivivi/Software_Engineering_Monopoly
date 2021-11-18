package Controller;
import Model.*;
import View.*;

import java.io.Serializable;

public class BoardController implements Serializable {
    private Board board;
    private BoardView boardView;

    public BoardController(Board b, BoardView bw){
        this.board = b;
        this.boardView = bw;
    }

    /**
     * controller to control the boardView to print the board
     */
    public void printBoard(){
        boardView.printBoard(board);
    }

}
