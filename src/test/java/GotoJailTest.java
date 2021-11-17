import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import Model.*;
class GotoJailTest {
    private Player p;
    private GotoJail gtj;

    @BeforeEach
    @DisplayName("The initialization of GoToJail Test")
    public void setup() {
       p = new Player();
       gtj = new GotoJail(15);
    }

    @Test
    @DisplayName("Test the updateInJail of GotoJail")
    public void testUpdateInJail(){
        gtj.takeEffect(p);
        Assertions.assertTrue(p.getInJail());// whether the player has gone to jail or not
    }
    /*
    @Test
    @DisplayName("Test the get position of GotoJail")
    public void testGoToJailPosition(){
        Assertions.assertEquals(6,gtj.getPosition());
    }
    @Test
    @DisplayName("Test the updatePosition of GotoJail")
    public void testUpdatePosition(){
        int position = 13;
        //gtj.updatePosition(p,position);
        Assertions.assertEquals(13,p.getPosition());
    }

    @Test
    @DisplayName("Test wrong(lower) input for updatePosition of GotoJail")
    public void testWrongUpdateLow(){
        Assertions.assertThrows(RuntimeException.class, () ->{
           // gtj.updatePosition(p,-1);
        });
    }
    @Test
    @DisplayName("Test wrong(higher) input for updatePosition of GotoJail")
    public void testWrongUpdateHigh(){
        Assertions.assertThrows(RuntimeException.class, () ->{
         //   gtj.updatePosition(p,20);
        });
    }

    */

}