package Model;

import java.io.Serializable;

/**
 * This class is for FreeParking square implementation
 */

public class FreeParking extends Square implements Serializable{
    /**
     * when the player is on the free parking, do nothing
     * @param p the player on the free parking
     * @return 0 for run successfully
     */
    public int takeEffect(Player p){
        return 0;
    }

    /**
     * Constructor for FreeParking
     * @param position position of FreeParking square
     */
    public FreeParking(int position){
        super(position);
        this.setName("FREE PARKING");
    }
}
