import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import Model.*;
class InJailTest {
    private InJail ij;
    private Player p;

    @BeforeEach
    @DisplayName("The initialization of InJail Test")
    public void setUp(){
        ij = new InJail(6);
        p = new Player(1,"Tony");
    }
    @Test
    @DisplayName("Test the takeEffect of InJail")
    public void testTakeEffect(){
        Assertions.assertEquals(0,ij.takeEffect(p));
    }


    @Test
    @DisplayName("Test the getPosition of InJail")
    public void testInJailPosition(){
        Assertions.assertEquals(6,ij.getPosition());
    }
}