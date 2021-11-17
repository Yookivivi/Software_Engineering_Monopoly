package Model;

import java.io.Serializable;

public class IncomeTax extends MoneyRelatedSquare implements Serializable{
    private double percentage = 0.1;// Tax percentage, normally = 0.1

    public IncomeTax(){
        this.name = "INCOME TAX";
    }
    /**
     * let the player pay the tax
     * @param p the player on the Income Tax
     */
    public void updateMoney(Player p){
        int tax = (int)(p.getMoney() * percentage)/10 * 10; //calculate the tax (rounded down to a multiple of 10)
        p.setMoney(p.getMoney() - tax);
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
