import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GotoJailTest {
    private Player p;
    private GotoJail gtj;
    @BeforeEach
    public void setup() {
       p = new Player();
       gtj = new GotoJail();
    }
    @Test
    public void testGoToJailPosition(){
        Assertions.assertEquals(6,gtj.getPosition());
    }
    @Test
    public void testUpdateInJail(){
        gtj.updateInJail(p);
        Assertions.assertTrue(p.getInJail());
    }
    @Test
    public void testUpdatePosition(){
        int position = 13;
        gtj.updatePosition(p,position);
        Assertions.assertEquals(13,p.getPosition());
    }
    @Test
    public void testWrongUpdateLow(){
        Assertions.assertThrows(RuntimeException.class, () ->{
            gtj.updatePosition(p,-1);
        });
    }
    @Test
    public void testWrongUpdateHigh(){
        Assertions.assertThrows(RuntimeException.class, () ->{
            gtj.updatePosition(p,20);
        });
    }

}