package Model;

import java.util.ArrayList;
import java.io.Serializable;

public class Property implements Serializable{
    private ArrayList<Integer> landList;// the indexes of lands owned by the player

    // constructor
    public Property(){
        this.landList = new ArrayList<>();
    }

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
    public int getLandNum(){
        return landList.size();
    }
    public ArrayList<Integer> getLandList(){
        return landList;
    }
}
