package Controller;
import Model.*;
import View.*;

public class BoardController {
    private Board board;
    private BoardView boardView;

    public BoardController(Board b, BoardView bw){
        this.board = b;
        this.boardView = bw;
    }
    public void printBoard(){
        boardView.printBoard(board);
    }

}
