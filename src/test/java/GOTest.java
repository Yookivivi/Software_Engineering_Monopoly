import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GOTest {
    private GO go;
    private Player p;
    @BeforeEach
    public void setUp(){
        go = new GO();
        p = new Player();
    }
    @Test
    public void testGoUpdate(){
        int m1 = p.getMoney();
        go.updateMoney(p);
        Assertions.assertEquals(1500 + m1, p.getMoney());
    }
    @Test
    public void testGoPosition(){
        Assertions.assertEquals(1,go.getPosition());
    }

}