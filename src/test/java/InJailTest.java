import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InJailTest {
    private InJail ij;
    private Player p;

    @BeforeEach
    @DisplayName("The initialization of InJail Test")
    public void setUp(){
        ij = new InJail();
        p = new Player();
    }

    @Test
    @DisplayName("Test the getPosition of InJail")
    public void testInJailPosition(){
        Assertions.assertEquals(6,ij.getPosition());
    }

    @Test
    @DisplayName("Test the updateInJail of InJail")
    public void testUpdateInJail(){
        ij.updateInJail(p);
        Assertions.assertFalse(p.getInJail());//whether the player has got out of the jail
    }

}