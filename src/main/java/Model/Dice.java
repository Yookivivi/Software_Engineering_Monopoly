package Model;

import java.util.Random;

public class Dice {
    public int dice1;// the first 4 faces dice
    public int dice2;// the second 4 faces dice
    public int totalDice;

    public void rollDice(){
        Random d1 = new Random();
        dice1 = d1.nextInt(4)+1;
        Random d2 = new Random();
        dice2 = d2.nextInt(4)+1;
        totalDice = dice1 + dice2;
    };// roll the dices
}
