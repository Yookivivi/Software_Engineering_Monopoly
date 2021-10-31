public class LandSquare extends Square {
    private String name;
    private int owner;
    private int rent;
    private int price;

    public LandSquare(){};// initialize the land square (name, rent and price)

    public void setOwner(int player){};
    public int getOwner(){
        return owner;
    }

    public int getPrice(){
        return price;
    }
    public int getRent(){
        return rent;
    }

    public void updateMoney(Player renter, Player owner){};
}
