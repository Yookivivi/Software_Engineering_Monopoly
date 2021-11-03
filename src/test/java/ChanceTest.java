import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("Test the setter and getter of loseMoney")
    public void testSetLoseorGain(){
        chance.setLoseorGain();
        Assertions.assertNotNull(chance.getLoseorGain());
    }

    @Test
    @DisplayName("Test the getter and setter of amount and evaluate its correctness")
    public void testSetAmount(){
        if(chance.getLoseorGain()){//lose
            chance.setAmount();
            //test the value is in correct range when the player is going to lose money
            Assertions.assertTrue(chance.getAmount() <= 300 && chance.getAmount() >= 0 && chance.getAmount()%10 == 0);
        }else{//gain
            chance.setAmount();
            //test the value is in correct range when the player is going to lose money
            Assertions.assertTrue(chance.getAmount() <= 200 && chance.getAmount() >= 0 && chance.getAmount()%10 == 0);
        }
    }

    @Test
    @DisplayName("Test the update money of Chance class")
    public void testChanceUpdate(){
        int m1 = p.getMoney();
        chance.updateMoney(p);
        if(chance.getLoseorGain()){//lose
            Assertions.assertEquals(m1-chance.getAmount(), p.getMoney());
        }else{//gain
            Assertions.assertEquals(m1+chance.getAmount(), p.getMoney());
        }
    }

}