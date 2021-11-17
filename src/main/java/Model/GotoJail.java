package Model;

import java.io.Serializable;

public class GotoJail extends Square implements Serializable{
    public int inJailPosition = 6; // the position of the jail

    public GotoJail(int position){
        super(position);
        this.setName("GO TO JAIL");
    }
    /**
     * let the player on the GotoJail go to jail
     * @param p the player on the GotoJail square
     */
    public void updateInJail(Player p){
        p.setPosition(inJailPosition);
        p.setInJail(true);
        p.setInJailRound(1);
    }//update the player's state in jail

    /**
     * when the player on the GotoJail square, they need to be sent to Jail
     * @param p the player on the GotoJail
     * @return 0 for run successfully
     */
    public int takeEffect(Player p){
        updateInJail(p);
        return 0;
    }
}
