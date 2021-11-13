public class LandSquare extends Square {
    private String name;// name of the property
    private Player owner;// owner of the property
    private int rent;// rent of the property
    private int price;// price of the property

    /**
     * the constructor of LnadSquare
     * @param n name of the property
     * @param r the rent of the property
     * @param p the price of the property
     */
    public LandSquare(String n, int r, int p){
        this.name = n;
        this.rent = r;
        this.price = p;
        this.owner = null;
    }// initialize the land square (name, rent and price)

    public void setOwner(Player player){
        this.owner = player;
    } // setter of the owner
    public Player getOwner(){
        return owner;
    } // getter of the owner

    public int getPrice(){
        return price;
    } // getter of the price
    public int getRent(){
        return rent;
    } // getter of the rent

    public String getName(){ return name; } // getter of the name

    /**
     * let the player pay the rent to the owner
     * @param renter the player on the property
     */
    public void updateMoney(Player renter){ //renter pay rent to the owner
        int mRenter = renter.getMoney();
        int mOwner = owner.getMoney();
        renter.setMoney(mRenter - rent);//pay rent
        owner.setMoney(mOwner + rent);//to the owner
    }

    /**
     * if the user land on the property square and it is owned by other player, the player will pay the rent
     * if it is unowned, the method will return 1 to ask for user input
     * @param p the player on the square
     * @return 0 for normal action, 1 for ask user input
     */
    public int takeEffect(Player p){ //squares take effect on the player
        if(this.owner != null)// if it has an owner
            updateMoney(p);
        else// do not have an owner
            return 1;
        return 0;
    }
}
