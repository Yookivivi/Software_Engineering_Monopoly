package Model;

import java.io.Serializable;

public class Go extends Square implements Serializable{
    public int award = 1500; // the money for players, normally = 1500

    public Go(int position){
        super(position);
        this.setName("GO");
    }

    /**
     * take effect on the player when the player is on the Go square
     * @param p
     * @return
     */
    public int takeEffect(Player p){
        return 0;
    }
}
