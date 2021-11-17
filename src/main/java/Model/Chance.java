package Model;

import java.util.Random;

public class Chance extends MoneyRelatedSquare {
    private int maxLoseAmount = 300; //the maximum amount to lose normally 300
    private int maxGainAmount = 200; //the maximum amount to gain normally 200

    public Chance(){
        this.name = "CHANCE";
    }
    /**
     * let the player gain money or lose money randomly, and the upper bound of gain and lose are defined by maxGainAmount
     * and maxLoseAmount
     * @param p
     */
    public void updateMoney(Player p){
        Random rand = new Random();
        int bound = (maxGainAmount + maxLoseAmount)/10 + 1;//calculate the upper bound
        int temp = rand.nextInt(bound);// generate a number from 0-50 randomly
        int moneyGot = temp*10 - 300;// range = [-300, 200] (multiple of 10)
        p.setMoney(p.getMoney() + moneyGot);
    }//change the amount of money of the user

    /**
     * let the player on the Chance get a random amount of money
     * @param p the player on the chance
     * @return 0 for run successfully
     */
    public int takeEffect(Player p){
        updateMoney(p);
        return 0;
    }
}
