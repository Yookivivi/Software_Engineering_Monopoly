import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IncomeTaxTest {
    private Player p;
    private IncomeTax it;

    @BeforeEach
    @DisplayName("The initialization of IncomeTaxTest")
    public void setUp(){
        p = new Player();
        it = new IncomeTax();
    }

    @Test
    @DisplayName("Test the updateMoney of IncomeTax")
    public void testTaxUpdate(){
        int m1 = p.getMoney() - (p.getMoney()/100)*10;//calculate the player's money after he or she pay tax
        it.takeEffect(p);
        int m2 = p.getMoney();//real money after he or she pay
        Assertions.assertEquals(m1, m2);
    }
    /*
    @Test
    @DisplayName("Test the getPosition of IncomeTax")
    public void testTaxPosition(){
        Assertions.assertEquals(4,it.getPosition());
    }
    */
}