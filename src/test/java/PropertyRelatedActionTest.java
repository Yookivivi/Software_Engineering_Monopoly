import Model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyRelatedActionTest {
    private Player p1;
    private Player p2;
    private Property pro;
    private Property pro2;
    private PropertyRelatedAction y1;
    private PropertyRelatedAction y2;
    private LandSquare l1;
    private LandSquare l2;



    @Test
    @DisplayName("Test buy land and update property list")
    void buylandTest() {
        p1.getPropertyList().updateProperty(1,2);
        p1.getPropertyList().updateProperty(1,3);
        //a player is at position 5 and buy the land
        l1.position = 5;
        p1.setPosition(l1.position);
        y1.buyland(p1,l1);
        y1.updateProperty(p1,l1);
        Assertions.assertEquals(p1.getId(),l1.getOwner());
        Assertions.assertEquals(5,p1.getProperty()[2]);
    }

    @Test
    void updatePropertyTest() {
        p2.getPropertyList().updateProperty(1,7);
        p2.getPropertyList().updateProperty(1,8);
        // player 2 is at position 10
        l2.position = 10;
        p2.setPosition(l2.position);
        y2.buyland(p2, l2);
        y2.updateProperty(p2,l2);
        Assertions.assertEquals(p2.getId(),l2.getOwner());
        Assertions.assertSame(pro2,p2.getProperty()[2]);
    }
}
