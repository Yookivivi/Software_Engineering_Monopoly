import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActionControllerTest {
    private ActionController a;
    private Player p;

    @Test
    @DisplayName("Test update money when the change is positive.")
    void updateMoneyTest() {
        int original = 800;
        int change = 200;
        // set an original money for player
        p.setMoney(original);
        //update money
        a.updateMoney(p,change);
        //check whether the current money is equal to the difference between the original and the change money
        Assertions.assertEquals(original-change,p.getMoney());
    }

    @Test
    @DisplayName("Test update money when the change is negative")
    void updateMoneyTest2(){
        int original = 800;
        int change = -150;
        p.setMoney(original);
        a.updateMoney(p,change);
        Assertions.assertEquals(original-change,p.getMoney());
    }


    @Test
    @DisplayName("Test update position")
    void updatePositionTest() {
        int original = 2;
        int totalDice = 3;
        p.setPosition(original);
        a.updatePosition(p,original+totalDice);
        Assertions.assertEquals(5,p.getPosition());
    }
}
