package Model;

abstract public class Square {
    public int position;
    public int[] players;// current players on the square
    protected String name;
    protected Player owner;

    public int getPosition(){
        return position;
    }

    public int takeEffect(Player p){return 0;};
    public String getName(){
        return name;
    }
    public void setOwner(Player owner){}
    /*
    square will take effect on the player
    1: request user input
    0: take effect successfully
    */
}
