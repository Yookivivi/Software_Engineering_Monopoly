import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
//import sun.jvm.hotspot.utilities.Assert;

import static org.junit.jupiter.api.Assertions.*;
import Model.*;
class JailRelatedActionTest {
    private Player p;
    private JailRelatedAction j;
    private Dice d;

    @BeforeEach
    @DisplayName("Initialization of the JailRelatedActionTest")
    public void setUp(){
        p = new Player();
        j = new JailRelatedAction(p);
        d = new Dice();
        j.dice=d;
    }


    @Test
    @DisplayName("Test the first round in jail, suppose the player chooses to pay fine")
    void updateInJailTestRound1_P(){
        j.updateInJail_P(p);
        Assertions.assertFalse(p.getInJail());
    }

    @Test
    @DisplayName("Test get roll double when dice1 is equal to dice2")
    void rollDoubleTest1(){
        d.dice1 = 1;
        d.dice2 = 1;
        Assertions.assertTrue(j.getrollDouble());
    }

    @Test
    @DisplayName("Test get roll double when dice1 is not equal to dice2")
    void rollDoubleTest2(){
        d.dice1 = 2;
        d.dice2 = 3;
        Assertions.assertFalse(j.getrollDouble());
    }


    @Test
    @DisplayName("Test the first round in jail, suppose the player chooses to roll dice")
    void updateInJailTestRound1_R() {
        j.currentDice = d;
        p.setInJailRound(1);
        d.dice1 = 3;
        d.dice2 = 3;
        j.getrollDouble();
        j.updateInJail_R(p);
        // dice1 is equal to dice2, the player can get out of jail
        Assertions.assertFalse(p.getInJail());
    }


    @Test
    @DisplayName("Test the second round in jail")
    void updateInJailTestRound2(){
        j.currentDice = d;
        p.setInJailRound(2);
        d.dice1 = 3;
        d.dice2 = 2;
        j.getrollDouble();
        j.updateInJail_R(p);
        // dice1 is not equal to dice2, the player is still in jail
        Assertions.assertTrue(p.getInJail());
    }

    @Test
    @DisplayName("Test the third round in jail")
    void updateInJailTestRound3(){
        j.currentDice = d;
        p.setInJailRound(3);
        d.dice1 = 2;
        d.dice2 = 2;
        j.getrollDouble();
        j.updateInJail_R(p);
        Assertions.assertFalse(p.getInJail());
    }

    @Test
    @DisplayName("Test the third round action")
    void testThirdRoundAction(){
        j.currentDice = d;
        p.setInJailRound(3);
        d.dice1 = 2;
        d.dice2 = 3;
        j.getrollDouble();
        j.updateInJail_R(p);
        Assertions.assertFalse(p.getInJail());
    }
}
