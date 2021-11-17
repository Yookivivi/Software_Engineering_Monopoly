package Model;

public class JailRelatedAction extends ActionController {
    private boolean rollDouble;
    private Player p;
    public Dice dice;

    public JailRelatedAction(Player player) {
        super(player);
        this.dice = new Dice();
    }


    public boolean getrollDouble(Dice d){
        if (d.dice1 == d.dice2) {
            rollDouble = true;
        }
        else{
            rollDouble = false;
        }
        return rollDouble;
    }


    // update the players' state of inJail
    public void updateInJail_R(Player p) {
        int fine = 150;

        //if player throw doubles, she can immediately get out of jail.
        if(getrollDouble(currentDice)){
            p.setInJail(false);
            updatePosition(p,p.getPosition()+ currentDice.totalDice);
        }
        //judge the round in jail
        else{
            //if the player does not throw doubles by her third turn, she must pay fine and then get out of jail
            if(p.getInJailRound() == 3){
                p.setInJail(false);
                updateMoney(p,-fine);
                updatePosition(p,p.getPosition()+ currentDice.totalDice);
            }
            p.setInJailRound(p.getInJailRound()+1);
            p.setInJail(true);
        }
    }

    public void updateInJail_P(Player p){
        int fine = 150;
        p.setInJail(false);
        updateMoney(p,-fine);
    }
}
