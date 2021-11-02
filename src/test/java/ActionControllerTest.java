import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActionControllerTest {
    private ActionController a;
    private Player p;
    private JailRelatedAction j;
    private PropertyRelatedAction y;

    @Test
    void updateMoneyTest() {
        int fine = 150;
        int m1 = p.getMoney() - fine;
        if (p.getInJailRound()>3){
            a.updateMoney(p);
            int m2 = p.getMoney();
            Assertions.assertEquals(m1,m2);
        }

    }

    @Test
    void updatePositionTest() {
    }
}