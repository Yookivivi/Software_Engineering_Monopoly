package Model;

abstract public class Square {
    public int position;
    public int[] players;// current players on the square
    protected String name;

    public int getPosition(){
        return position;
    }

    public int takeEffect(Player p){return 0;};
    public String getName(){
        return name;
    }
    /*
    square will take effect on the player
    1: request user input
    0: take effect successfully
    */
}
