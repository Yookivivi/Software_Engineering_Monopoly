import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceTest {
    private Player p;
    private Chance chance;

    @BeforeEach
    public void setUp(){
        p = new Player();
        chance = new Chance();
    }
    @Test
    public void testSetLoseorGain(){
        chance.setLoseorGain();
        Assertions.assertNotNull(chance.getLoseorGain());
    }
    @Test
    public void testSetAmount(){
        if(chance.getLoseorGain()){//lose
            chance.setAmount();
            Assertions.assertTrue(chance.getAmount() <= 300 && chance.getAmount() >= 0 && chance.getAmount()%10 == 0);
        }else{//gain
            chance.setAmount();
            Assertions.assertTrue(chance.getAmount() <= 200 && chance.getAmount() >= 0 && chance.getAmount()%10 == 0);
        }
    }
    @Test
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