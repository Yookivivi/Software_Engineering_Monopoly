public class Chance extends MoneyRelatedSquare{
    private boolean loseMoney;//True = lose False = gain
    private int maxLoseAmount; //the maximum amount to lose
    private int maxGainAmount; //the maximum amount to gain
    private int amount;

    public void setLoseorGain(){};//determine whether lose or gain
    public boolean getLoseorGain(){return loseMoney;}

    public void setAmount(){};//determine the amount that the user lose or gain
    public int getAmount(){return amount;}

    public void updateMoney(Player p){};//change the amount of money of the user
}
