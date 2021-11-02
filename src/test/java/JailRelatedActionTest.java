import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.jupiter.api.Assertions.*;

class JailRelatedActionTest {
    private Player p;
    private JailRelatedAction j;

    @Test
    void updateInJailTest() {
        if ( p.getInJailRound() <= 3){
            //rollDouble public or private
            //private get roll double
            //update round?
            if (j.rollDouble) {
                j.updateInJail();
                Assertions.assertTrue(p.getInJail());
            }
        }
    }
}