package Square;



public class LandSquare extends Square {
    private String name;
    private int player;
    private int rent;
    private int price;

    public LandSquare(){};// initialize the land square (name, rent and price)

    public void setOwner(int player){};
    public int getOwner(){
        return player;
    }

    public int getPrice(){
        return price;
    }
    public int getRent(){
        return rent;
    }
}
