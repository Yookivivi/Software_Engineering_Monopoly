package View;

import Controller.BoardController;
import Model.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BoardView {
    @Test
    @DisplayName("Test Print Board")
    public void printBoard(){
        Board board = new Board();
        BoardView boardView = new BoardView();
        BoardController boardController = new BoardController(board, boardView);

        Square s = new LandSquare("house",100,100);
    //    LandSquare h = s;
    }
}
