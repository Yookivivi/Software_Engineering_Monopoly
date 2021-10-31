import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FreeParkingTest {
    @Test
    public void parkingPositionTest(){
        FreeParking free = new FreeParking();
        Assertions.assertEquals(11,free.getPosition());
    }

}