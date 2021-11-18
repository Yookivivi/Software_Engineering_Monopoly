package Model;

import java.io.Serializable;

/**
 * This class is for IncomeTax square implementation
 */

public class IncomeTax extends Square implements Serializable{
    private double percentage = 0.1;// Tax percentage, normally = 0.1

    /**
     * Constructor for IncomeTax
     * @param position position of IncomeTax square
     */
    public IncomeTax(int position){
        super(position);
        this.setName("INCOME TAX");
    }

    /**
     * let the player pay the tax
     * @param p the player on the Income Tax
     */
    public void updateMoney(Player p){
        int tax = (int)(p.getMoney() * percentage)/10 * 10; //calculate the tax (rounded down to a multiple of 10)
        p.setMoney(p.getMoney() - tax);
        System.out.println("* "+p.getName()+" has paid HKD "+tax+" for tax");// print how much money the player should pay
    }//change the player's money

    /**
     * when the player on the Income Tax, they will pay the tax
     * @param p the palyer on the square
     * @return 0 for run successfully
     */
    public int takeEffect(Player p){
        updateMoney(p);
        return 0;
    }
}
