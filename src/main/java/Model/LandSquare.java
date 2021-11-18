package Model;

import java.io.Serializable;

/**
 * This class is for the land square implementation
 */

public class LandSquare extends Square implements Serializable{
    private Player owner;// owner of the property
    private int rent;// rent of the property
    private int price;// price of the property

    /**
     * the constructor of LandSquare
     * @param n name of the property
     * @param r the rent of the property
     * @param p the price of the property
     */
    public LandSquare(String n, int p, int r, int position){
        super(position);
        this.setName(n);
        this.price = p;
        this.rent = r;
        this.owner = null;
    }// initialize the land square (name, rent and price)

    /**
     * setters and getters for owner / price / rent
     */
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

    /**
     * let the player pay the rent to the owner
     * @param renter the player on the property
     */
    public void updateMoney(Player renter){ //renter pay rent to the owner
        int mRenter = renter.getMoney();
        int mOwner = owner.getMoney();
        renter.setMoney(mRenter - rent);//pay rent
        owner.setMoney(mOwner + rent);//to the owner
        System.out.println("* "+renter.getName() + " pays HKD " + rent + " to " + owner.getName());
    }

    /**
     * if the user land on the property square and it is owned by other player, the player will pay the rent
     * if it is unowned, the method will return 1 to ask for user input
     * @param p the player on the square
     * @return 0 for normal action, 1 for ask user input
     */
    public int takeEffect(Player p){ //squares take effect on the player
        if(this.owner != null){ // if it has a owner
            if(this.owner != p)// if the owner is not the player
                updateMoney(p);
        }
        else{
            return 1;// do not have an owner
        }
        return 0;
    }
}
