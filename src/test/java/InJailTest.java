import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InJailTest {
    private InJail ij;
    private Player p;
    @BeforeEach
    public void setUp(){
        ij = new InJail();
        p = new Player();
    }
    @Test
    public void testInJailPosition(){
        Assertions.assertEquals(6,ij.getPosition());
    }
    @Test
    public void testUpdateInJail(){
        ij.updateInJail(p);
        Assertions.assertFalse(p.getInJail());
    }

}