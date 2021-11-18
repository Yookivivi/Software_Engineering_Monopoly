import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import Model.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardTest {
    @Test
    @DisplayName("Test the construction of the board")
    public void createBoard(){
        Board newBoard = new Board();
        assertEquals(20,newBoard.squares.length); // test the board size
    }

    @Test
    @DisplayName("Test each square' name of the board")
    public void testSquareName(){
        Board newBoard = new Board();
        assertEquals("GO", newBoard.squares[0].getName());
        assertEquals("CENTRAL", newBoard.squares[1].getName());
        assertEquals("Wan Chai", newBoard.squares[2].getName());
        assertEquals("INCOME TAX", newBoard.squares[3].getName());
        assertEquals("Stanley", newBoard.squares[4].getName());
        assertEquals("IN JAIL", newBoard.squares[5].getName());
        assertEquals("Shek O", newBoard.squares[6].getName());
        assertEquals("Mong Kok", newBoard.squares[7].getName());
        assertEquals("CHANCE", newBoard.squares[8].getName());
        assertEquals("Tsing Yi", newBoard.squares[9].getName());
        assertEquals("FREE PARKING", newBoard.squares[10].getName());
        assertEquals("Shatin", newBoard.squares[11].getName());
        assertEquals("CHANCE", newBoard.squares[12].getName());
        assertEquals("Tuen Mum", newBoard.squares[13].getName());
        assertEquals("Tai Po", newBoard.squares[14].getName());
        assertEquals("GO TO JAIL", newBoard.squares[15].getName());
        assertEquals("Sai Kung", newBoard.squares[16].getName());
        assertEquals("Yuen Long", newBoard.squares[17].getName());
        assertEquals("CHANCE", newBoard.squares[18].getName());
        assertEquals("Tai O", newBoard.squares[19].getName());
    }
}