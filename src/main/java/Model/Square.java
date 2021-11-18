package Model;

import java.io.Serializable;

/**
 * This class is for square implementation
 */

abstract public class Square implements Serializable {
    private String name;
    private int position;

    /**
     * Constructor for Square
     * @param position position of the square
     */
    public Square(int position){
        this.position = position;
    }

    /**
     * getter of the position
     * @return position of square
     */
    public int getPosition(){
        return position;
    }

    /**
     * getter of the name
     * @return name of square
     */
    public String getName(){
        return name;
    }

    /**
     * setter of the name
     * @param name name of square
     */
    public void setName(String name){
        this.name = name;
    }

    /**
    square will take effect on the player
    1: request user input
    0: take effect successfully
    */
    public int takeEffect(Player p){return 0;};
}
