//import org.junit.Test;
import Model.Property;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import Model.*;
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
        assertEquals("In-jail round is invalid.", exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class, () -> player.setInJailRound(4));
        assertEquals("In-jail round is invalid.", exception.getMessage());
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
        player.setPosition(1);
        assertEquals(1, player.getPosition(), "Player's position should be 1");
        
        player.setPosition(20);
        assertEquals(20, player.getPosition(), "Player's position should be 20");

        Throwable exception; // test exception when setting player's position
        exception = assertThrows(IllegalArgumentException.class, () -> player.setPosition(0));
        assertEquals("Position is invalid.", exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class, () -> player.setPosition(21));
        assertEquals("Position is invalid.", exception.getMessage());
    }

    @Test
    @DisplayName("Test getter and setter for player's is-out status")
    public void testIsOut(){
        player.setIsOut(true);
        assertTrue(player.getIsOut(), "Player should be out");

        player.setIsOut(false);
        assertFalse(player.getIsOut(), "Player should not be out");
    }

    // 11/14/22:13
    @Test
    @DisplayName("Test player's property list")
    public void testPropertyList(){
        player.setPropertyList(1, 1); // add land 1
        player.setPropertyList(1, 2); // add land 2
        player.setPropertyList(1, 3); // add land 3
        assertEquals(player.getPropertyList().getLandNum(), 3);
        assertTrue(player.getPropertyList().getLandList().contains(1));
        assertTrue(player.getPropertyList().getLandList().contains(2));
        assertTrue(player.getPropertyList().getLandList().contains(3));

        player.setPropertyList(0, 1); // remove land 1
        player.setPropertyList(0, 2); // remove land 2
        assertEquals(player.getPropertyList().getLandNum(), 1);
        assertTrue(player.getPropertyList().getLandList().contains(3));
    }
}
