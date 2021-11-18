package Model;

import java.util.Random;
import java.io.Serializable;

/**
 * This class is for Chance square implementation
 */

public class Chance extends Square implements Serializable{
    private int maxLoseAmount = 300; //the maximum amount to lose normally 300
    private int maxGainAmount = 200; //the maximum amount to gain normally 200

    /**
     * Constructor for Chance
     * @param position position of this square
     */
    public Chance(int position){
        super(position);
        this.setName("CHANCE");
    }

    /**
     * let the player gain money or lose money randomly, and the upper bound of gain and lose are defined by maxGainAmount
     * and maxLoseAmount
     * @param p action related player
     */
    public void updateMoney(Player p){
        Random rand = new Random();
        int bound = (maxGainAmount + maxLoseAmount)/10 + 1;//calculate the upper bound
        int temp = rand.nextInt(bound);// generate a number from 0-50 randomly
        int moneyGot = temp*10 - 300;// range = [-300, 200] (multiple of 10)
        p.setMoney(p.getMoney() + moneyGot);
        if(moneyGot >= 0)
            System.out.println("* "+p.getName()+ " got HKD " + moneyGot);
        else
            System.out.println("* "+p.getName()+ " lost HKD " + String.valueOf(moneyGot * -1));
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
