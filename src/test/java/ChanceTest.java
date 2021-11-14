import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import Model.*;
import static org.junit.jupiter.api.Assertions.*;

class ChanceTest {
    private Player p;
    private Chance chance;

    @BeforeEach
    @DisplayName("Initialization of the Chance Test")
    public void setUp(){
        p = new Player();
        chance = new Chance();
    }


    @Test
    @DisplayName("Test the update money of Chance class")
    public void testChanceUpdate(){
        int m1 = p.getMoney();
        int result = chance.takeEffect(p);
        if(result == 0) System.out.println("take effect run successfully");
        int m2 = p.getMoney();
        Assertions.assertTrue((m1-300) <= m2 && m2 <= (m1+200));
    }

}