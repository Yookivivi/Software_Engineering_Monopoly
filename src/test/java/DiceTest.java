import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {
    private Dice dice;

    @Test
    @DisplayName("Test the dice range")
    void rollDiceTest() {
        int max = 4;
        int min = 1;
        // test 100 times, whether the dice number is in range.
        for (int i = 0; i < 100; i++) {
            dice.rollDice();
            Assertions.assertTrue((min <= dice.dice1 && dice.dice1 <= max),"The first dice is in range.");
            Assertions.assertTrue((min <= dice.dice1 && dice.dice2 <= max),"The second dice is in range.");
            Assertions.assertTrue((2*min <= dice.totalDice && dice.totalDice<= 2*max),"The total dice is in range");
        }

    }
}