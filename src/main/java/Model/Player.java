package Model;

import java.io.Serializable;

/**
 * This class is for implementation of player
 */

public class Player implements Serializable{
    private int id;
    private String name;
    private boolean inJail = false;// whether the player is in jail
    private int inJailRound = 0;// the round that the player be in the jail
    private int money = 1500;
    private int position = 1;
    private boolean isOut = false;// whether the player is out of the game
    private Property propertyList = new Property(); // property owned by the player

    /**
     * Constructor for Player
     * @param id player's id
     * @param name player's name
     */
    public Player(int id, String name){
        this.id = id;
        this.name = name;
    }
    public Player(){ };

    /**
     * setters and getters for id / name / inJail / inJailRound / money / position / isOut / propertyList
     */
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setInJail(boolean inJail){
        this.inJail = inJail;
    }
    public boolean getInJail(){
        return this.inJail;
    }

    public void setInJailRound(int round){
        if (round < 0 || round > 3){
            throw new IllegalArgumentException("In-jail round is invalid.");
        }
        else this.inJailRound = round;
    }
    public int getInJailRound(){
        return this.inJailRound;
    }

    public void setMoney(int money){
        this.money = money;
    }
    public int getMoney(){
        return this.money;
    }

    public void setPosition(int position){
        if (position < 1 || position > 20){
            throw new IllegalArgumentException("Position is invalid.");
        }
        else this.position = position;
    }
    public int getPosition(){
        return this.position;
    }

    public void setIsOut(boolean isOut){
        this.isOut = isOut;
    }
    public boolean getIsOut(){
        return this.isOut;
    }

    public void setPropertyList(int mode, int position){
        this.propertyList.updateProperty(mode, position);
    }
    public Property getPropertyList(){
        return this.propertyList;
    }
}

