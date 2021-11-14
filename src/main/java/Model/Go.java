package Model;

public class Go extends MoneyRelatedSquare {
    public int award = 1500; // the money for players, normally = 1500

    /**
     * Give the player 1500 hkd when they pass through the square
     * @param p
     */
    public void updateMoney(Player p){
        int money = p.getMoney();
        p.setMoney(money + award);
    }

    /**
     * take effect on the player when the player is on the Go square
     * @param p
     * @return
     */
    public int takeEffect(Player p){
        updateMoney(p);
        return 0;
    }
}
