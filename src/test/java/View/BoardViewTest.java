package View;
import Model.*;
import Controller.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardViewTest {
    @Test
    @DisplayName("Test Print Board")
    public void testPrintBoard(){
        Board board = new Board();
        BoardView boardView = new BoardView();
        BoardController boardController = new BoardController(board, boardView);
        if(board.squares[1] instanceof LandSquare){
            boardController.printBoard();
        }
        /*
        Player p = new Player(10, "Tom");
        Square s = new LandSquare("Home", 100, 1000);
        ((LandSquare) s).setOwner(p);
        System.out.println(((LandSquare) s).getOwner().getName());

         */
    }

}