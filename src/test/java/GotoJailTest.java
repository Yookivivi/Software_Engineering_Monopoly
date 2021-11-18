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
       gtj = new GotoJail(16);
    }

    @Test
    @DisplayName("Test the updateInJail of GotoJail")
    public void testUpdateInJail(){
        gtj.takeEffect(p);
        Assertions.assertTrue(p.getInJail());// whether the player has gone to jail or not
        Assertions.assertEquals(6,p.getPosition());
        Assertions.assertEquals(1,p.getInJailRound());
    }

    @Test
    @DisplayName("Test the get position of GotoJail")
    public void testGoToJailPosition(){
        Assertions.assertEquals(16,gtj.getPosition());
    }

    @Test
    @DisplayName("Test the take Effect of GotoJail")
    public void testTakeEffect(){
        Assertions.assertEquals(0,gtj.takeEffect(p));
    }


}