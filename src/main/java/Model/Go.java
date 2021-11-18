package Model;

import java.io.Serializable;

/**
 * This class is for Go square implementation
 */

public class Go extends Square implements Serializable{
    public int award = 1500; // the money for players, normally = 1500

    /**
     * Constructor for position
     * @param position position of Go square
     */
    public Go(int position){
        super(position);
        this.setName("GO");
    }
}
