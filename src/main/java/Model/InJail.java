package Model;

import java.io.Serializable;

/**
 * This class is for InJail square implementation
 */

public class InJail extends Square implements Serializable{
    /**
     * when player go to the 6th square, they do nothing
     * @param p the player on the square
     * @return 0 for run successfully
     */
    public int takeEffect(Player p){
        return 0;
    }

    /**
     * Constructor for InJail
     * @param position position of InJail square
     */
    public InJail(int position){
        super(position);
        this.setName("IN JAIL");
    }
}
