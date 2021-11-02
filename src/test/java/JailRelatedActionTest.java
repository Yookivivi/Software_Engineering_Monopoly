import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.jupiter.api.Assertions.*;

class JailRelatedActionTest {
    private Player p;
    private JailRelatedAction j;
    private Dice d;


    @Test
    @DisplayName("Test the first round in jail, suppose the player chooses to pay fine")
    void updateInJailTestRound1_P(){
        j.updateInJail(p);
        Assertions.assertFalse(p.getInJail());
    }


    @Test
    @DisplayName("Test the first round in jail, suppose the player chooses to roll dice")
    void updateInJailTestRound1_R() {
        j.currentDice = d;
        p.setInJailRound(1);
        d.dice1 = 3;
        d.dice2 = 3;
        j.updateInJail(p);
        // dice1=dice2, player goes out of jail
        Assertions.assertFalse(p.getInJail());
    }


    @Test
    @DisplayName("Test the second round in jail")
    void updateInJailTestRound2(){
        j.currentDice = d;
        p.setInJailRound(2);
        d.dice1 = 3;
        d.dice2 = 2;
        j.updateInJail(p);
        Assertions.assertTrue(p.getInJail());
    }

    @Test
    @DisplayName("Test the third round in jail")
    void updateInJailTestRound3(){
        j.currentDice = d;
        p.setInJailRound(3);
        d.dice1 = 2;
        d.dice2 = 2;
        j.updateInJail(p);
        Assertions.assertFalse(p.getInJail());
    }
}
