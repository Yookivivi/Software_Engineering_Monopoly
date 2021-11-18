package Model;

import java.io.Serializable;

/**
 * This class is for InJail square implementation
 */

public class InJail extends Square implements Serializable{

    /**
     * Constructor for InJail
     * @param position position of InJail square
     */
    public InJail(int position){
        super(position);
        this.setName("IN JAIL");
    }
}
