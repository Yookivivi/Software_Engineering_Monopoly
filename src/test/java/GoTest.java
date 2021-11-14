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
        go = new Go();
        p = new Player();
    }

    @Test
    @DisplayName("Test the updateMoney of GO")
    public void testGoUpdate(){
        int m1 = p.getMoney();
        go.updateMoney(p);
        Assertions.assertEquals(1500 + m1, p.getMoney());// whether the player is actually get 1500
    }

    @Test
    @DisplayName("Test the getPosition of GO")
    public void testGoPosition(){
        Assertions.assertEquals(1,go.getPosition());
    }

}