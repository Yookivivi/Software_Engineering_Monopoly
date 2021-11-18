package Model;

import java.util.ArrayList;
import java.io.Serializable;

/**
 * This class is for implementation of property owned by a player
 */

public class Property implements Serializable{
    private ArrayList<Integer> landList;// the indexes of lands owned by the player

    /**
     * Constructor for Property
     */
    public Property(){
        this.landList = new ArrayList<>();
    }

    /**
     * add and remove property from a player's property list
     * @param mode 1: add  2: remove
     * @param position position of land that is manipulated on
     */
    public void updateProperty(int mode, int position){ // change the property list
        if (mode == 1) landList.add(position);          // mode = 1(add), mode = 0(remove)
        else{
            for (int i = 0; i < landList.size(); i++){
                if (landList.get(i) == position){
                    landList.remove(i);
                    break;
                }
            }
        }
    }

    /**
     * getters for landList and number of lands owned by a player
     */
    public int getLandNum(){
        return landList.size();
    }
    public ArrayList<Integer> getLandList(){
        return landList;
    }
}
