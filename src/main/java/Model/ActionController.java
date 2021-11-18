package Model;

/**
 * This class is the controller for update money / position action
 */

public class ActionController {
    public Dice currentDice=new Dice();
    private Player p;

    /**
     * Constructor for ActionController
     * @param player action related player
     */
    public ActionController(Player player){
        this.p = player;
    }

    /**
     * update player's money
     * @param p action related player
     * @param changeMoney amount of money to change
     */
    public void updateMoney(Player p, int changeMoney){
        p.setMoney(p.getMoney()+changeMoney);
    };

    /**
     * update player's position
     * @param p action related player
     * @param position new position for player
     */
    public void updatePosition(Player p, int position){
        p.setPosition(position);
    };
}
