import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LandSquareTest {

    private LandSquare land;
    @BeforeEach
    public void setUp(){
        land = new LandSquare();
    }
    @Test
    public void testInJailPosition(){
        int[] arr = {2,3,5,7,8,10,12,14,15,17,18,20};
        boolean test = false;
        for (int element : arr) {
            if (element == land.getPosition()) {
                test = true;
                break;
            }
        }
        Assertions.assertTrue(test);
    }
    @Test
    public void testOwner(){
        land.setOwner(1);
        Assertions.assertEquals(1, land.getOwner());
    }
    @Test
    public void testUpdateMoney(){
        Player renter = new Player();
        Player owner = new Player();
        int m1 = renter.getMoney();
        int m2 = owner.getMoney();
        int rent = land.getRent();
        land.updateMoney(renter, owner);
        Assertions.assertTrue(m1 == (renter.getMoney() - rent) && m2 == (owner.getMoney() + rent) );
    }

}