import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import Model.*;
class LandSquareTest {

    private LandSquare land;

    @BeforeEach
    @DisplayName("The initialization of LandSquareTest")
    public void setUp(){
        land = new LandSquare("CENTRAL", 800, 90,1);
    }
    /*
    @Test
    @DisplayName("Test the getPosition of LandSquare")
    public void testLandSquarePosition(){
        int[] arr = {2,3,5,7,8,10,12,14,15,17,18,20};
        boolean test = false;
        for (int element : arr) {
            if (element == land.getPosition()) {// ensure that the position is in correct value
                test = true;
                break;
            }
        }
        Assertions.assertTrue(test);
    }
    */
    @Test
    @DisplayName("Test the setter and getter of owner in LandSquare")
    public void testOwner(){
        Player p = new Player();
        land.setOwner(p);
        Assertions.assertNotNull(land.getOwner());
    }

    @Test
    @DisplayName("Test the upateMoney of LandSquare")
    public void testUpdateMoney(){
        Player renter = new Player();
        int m1 = renter.getMoney();// renter's money
        int m2 = land.getOwner().getMoney();// player's money
        int rent = land.getRent();
        land.updateMoney(renter);// pay rent to the owner
        // to check whether the rent has been paid and received
        Assertions.assertTrue(m1 == (renter.getMoney() - rent) && m2 == (land.getOwner().getMoney() + rent) );
    }

}