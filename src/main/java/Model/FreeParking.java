package Model;

import java.io.Serializable;

public class FreeParking extends Square implements Serializable{
    /**
     * when the player is on the free parking, do nothing
     * @param p the player on the free parking
     * @return 0 for run successfully
     */
    public int takeEffect(Player p){
        return 0;
    }
    public FreeParking(int position){
        super(position);
        this.setName("FREE PARKING");
    }
}
