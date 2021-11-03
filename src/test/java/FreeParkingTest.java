import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FreeParkingTest {
    @Test
    @DisplayName("Test the getPosition of FreeParking")
    public void parkingPositionTest(){
        FreeParking free = new FreeParking();
        Assertions.assertEquals(11,free.getPosition());
    }

}