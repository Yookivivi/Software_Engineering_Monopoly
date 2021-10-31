import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {
    @Test
    public void testGetPosition(){
        Square sq = new GO();
        Assertions.assertTrue(0 <= sq.getPosition() && sq.getPosition() <= 19);
    }

}