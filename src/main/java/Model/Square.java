package Model;

import java.io.Serializable;

abstract public class Square implements Serializable {
    private String name;
    private int position;

    public Square(int position){
        this.position = position;
    }
    /**
     * getter of the position
     * @return
     */
    public int getPosition(){
        return position;
    }
    /**
     * getter of the name
     * @return
     */
    public String getName(){
        return name;
    }

    /**
     * setter of the name
     * @param name
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
