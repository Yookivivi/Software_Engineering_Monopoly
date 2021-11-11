import java.util.ArrayList;

public class Property {
    private ArrayList<Integer> landList = new ArrayList<>();// the indexes of lands owned by the player

    // constructor
    public Property(){}

    public void updateProperty(int mode, int position){ // change the property list
        if (mode == 1) landList.add(position);          // mode = 1(add), mode = 0(remove)
        else landList.remove(position);
    }
    public int getLandNum(){
        return landList.size();
    }
    public ArrayList<Integer> getLandList(){
        return landList;
    }
}
