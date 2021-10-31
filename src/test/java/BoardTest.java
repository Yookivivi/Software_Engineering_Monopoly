import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BoardTest {
    @Test
    public void createBoard(){
        Board newBoard = new Board();
        Assertions.assertEquals(20,newBoard.squares.length);
    }

}