package Model;

import View.JailRelatedView;

/**
 * This class is for jail related action
 */

public class JailRelatedAction extends ActionController {
    private boolean rollDouble;
    private Player p;
    public Dice dice;
    private JailRelatedView view = new JailRelatedView();

    /**
     * Constructor for JailRelatedAction
     * @param player action related player
     */
    public JailRelatedAction(Player player) {
        super(player);
        this.dice = new Dice();
        this.dice.rollDice();
    }

    /**
     * roll two dice to get double
     * @return true: success  false: fail
     */
    public boolean getrollDouble(){
        if (dice.dice1 == dice.dice2) {
            rollDouble = true;
        }
        else{
            rollDouble = false;
        }
        return rollDouble;
    }


    /**
     * update the players' state of inJail
     * @param p action related player
     */
    public void updateInJail_R(Player p) {
        int fine = 150;
        //if player throw doubles, she can immediately get out of jail.
        if(getrollDouble()){
            p.setInJail(false);
            updatePosition(p,p.getPosition()+ dice.totalDice);
            view.printSuccessThrowDoubleMessage(p.getName());
        }
        //judge the round in jail
        else{
            //if the player does not throw doubles by her third turn, she must pay fine and then get out of jail
            //System.out.println("inJailRound" + p.getInJailRound());
            view.printFailThrowDoubleMessage(p.getName());
            if(p.getInJailRound() == 3){
                p.setInJail(false);
                updateMoney(p,-fine);
                view.printPayFeeMessage(p.getName());
                updatePosition(p,p.getPosition()+ dice.totalDice);
            }
            else{
                p.setInJailRound(p.getInJailRound()+1);
                //System.out.println("current round"+p.getInJailRound());
                p.setInJail(true);
            }

        }
    }

    /**
     * pay fine to get out of jail
     * @param p action related player
     */
    public void updateInJail_P(Player p){
        int fine = 150;
        p.setInJail(false);
        updateMoney(p,-fine);
    }
}
