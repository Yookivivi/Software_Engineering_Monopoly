import org.junit.Test;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PropertyTest {
    Property property;

    @BeforeEach
    void setup(){
        property = new Property();
    }

    @Test
    @DisplayName("Test property update function")
    public void testPropertyUpdate(){
        property.updateProperty(1, 5); // add land 5
        property.updateProperty(1, 3); // add land 3
        property.updateProperty(1, 10); // add land 10
        property.updateProperty(1, 13); // add land 13
        property.updateProperty(0, 13); // remove land 13
        assertEquals(3, property.getLandNum(), "Number of property should be 3");
        assertEquals(3, property.getProperty()[0], "First land is at 3");
        assertEquals(5, property.getProperty()[1], "Second land is at 5");
        assertEquals(10, property.getProperty()[2], "Second land is at 10");
    }
}
