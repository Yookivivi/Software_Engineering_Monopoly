package Model;

import java.io.Serializable;

/**
 * This class is for FreeParking square implementation
 */

public class FreeParking extends Square implements Serializable{

    /**
     * Constructor for FreeParking
     * @param position position of FreeParking square
     */
    public FreeParking(int position){
        super(position);
        this.setName("FREE PARKING");
    }
}
