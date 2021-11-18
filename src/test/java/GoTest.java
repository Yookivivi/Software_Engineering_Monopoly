import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Model.*;
import static org.junit.jupiter.api.Assertions.*;

class GoTest {
    private Go go;
    private Player p;
    @BeforeEach
    @DisplayName("The initialization of the GO test")
    public void setUp(){
        go = new Go(1);
        p = new Player();
    }

    @Test
    @DisplayName("Test the getPosition of GO")
    public void testGoPosition(){
        Assertions.assertEquals(1,go.getPosition());
    }

}