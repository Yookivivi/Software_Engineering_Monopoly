import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IncomeTaxTest {
    private Player p;
    private IncomeTax it;
    @BeforeEach
    public void setUp(){
        p = new Player();
        it = new IncomeTax();
    }
    @Test
    public void testTaxUpdate(){
        int m1 = p.getMoney() - (p.getMoney()/100)*10;
        it.updateMoney(p);
        int m2 = p.getMoney();
        Assertions.assertEquals(m1, m2);
    }
    @Test
    public void testTaxPosition(){
        Assertions.assertEquals(4,it.getPosition());
    }

}