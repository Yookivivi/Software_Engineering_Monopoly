import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FreeParkingTest {
    @Test
    @DisplayName("Test the takeEffect of FreeParking")
    public void parkingTest(){
        Player p = new Player();
        FreeParking free = new FreeParking();
        Assertions.assertEquals(0,free.takeEffect(p));
    }

}