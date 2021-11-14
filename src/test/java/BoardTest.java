import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BoardTest {
    @Test
    @DisplayName("Test the construction of the board")
    public void createBoard(){
        Board newBoard = new Board();
        Assertions.assertEquals(20,newBoard.squares.length); // test the board size
    }

}