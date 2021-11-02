import org.junit.Test;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    Player player;

    @BeforeEach
    void setUp(){
        player = new Player();
    }

    @Test
    @DisplayName("Test getter and setter for player's id")
    public void testId(){
        player.setId(1);
        assertEquals(1, player.getId(), "Player's id should be 1");
    }

    @Test
    @DisplayName("Test getter and setter for player's name")
    public void testName(){
        player.setName("Max");
        assertEquals("Max", player.getName(), "Player's name should be Max");
    }

    @Test
    @DisplayName("Test getter and setter for player's in-jail status")
    public void testInJail(){
        player.setInJail(true);
        assertTrue(player.getInJail(), "Player should be in jail");

        player.setInJail(false);
        assertFalse(player.getInJail(), "Player should not be in jail");
    }

    @Test
    @DisplayName("Test getter and setter for player's in-jail round")
    public void testInJailRound(){
        for (int i = 0; i < 4; i++){
            player.setInJailRound(i);
            assertEquals(i, player.getInJailRound(), "Player's in-jail round should be " + i);
        }

        Throwable exception; // test exception when setting in-jail round
        exception = assertThrows(IllegalArgumentException.class, () -> player.setInJailRound(-1));
        assertEquals("In-jail round must be positive or zero", exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class, () -> player.setInJailRound(4));
        assertEquals("In-jail round must be smaller than 4", exception.getMessage());
    }

    @Test
    @DisplayName("Test getter and setter for player's money")
    public void testMoney(){
        player.setMoney(1500);
        assertEquals(1500, player.getMoney(), "Player's money should be 1500");

        player.setMoney(player.getMoney() + 500);
        assertEquals(2000, player.getMoney(), "Player's money should be 2000");

        player.setMoney(player.getMoney() - 500);
        assertEquals(1500, player.getMoney(), "Player's money should be 1500");

        player.setMoney((int)(player.getMoney() * 0.9));
        assertEquals(1350, player.getMoney(), "Player's money should be 1350");
    }

    @Test
    @DisplayName("Test getter and setter for player's position")
    public void testPosition(){
        player.setPosition(0);
        assertEquals(0, player.getPosition(), "Player's position should be 0");

        player.setPosition(19);
        assertEquals(19, player.getPosition(), "Player's position should be 19");

        Throwable exception; // test exception when setting player's position
        exception = assertThrows(IllegalArgumentException.class, () -> player.setPosition(-1));
        assertEquals("Position must be positive or zero", exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class, () -> player.setPosition(20));
        assertEquals("Position must not exceed 19", exception.getMessage());
    }

    @Test
    @DisplayName("Test getter and setter for player's is-out status")
    public void testIsOut(){
        player.setIsOut(true);
        assertTrue(player.getIsOut(), "Player should be out");

        player.setIsOut(false);
        assertFalse(player.getIsOut(), "Player should not be out");
    }

    @Test
    @DisplayName("Test player's property list")
    public void testPropertyList(){
        Property property = new Property();
        player.setPropertyList(property);
        assertSame(property, player.getPropertyList(), "Player's property list should work"); // test whether the property list is consistent
    }
}
