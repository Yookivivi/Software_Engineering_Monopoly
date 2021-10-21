public class Player {
    private int id;
    private String name;
    private boolean inJail;// whether the player is in jail
    private int inJailRound;// the round that the player be in the jail
    private int money;
    private int position;
    private boolean isOut;// whether the player is out of the game
    private Property propertyList;// player's property List

    public void setId(int id){};
    public int getId(){
        return id;
    }

    public void setName(String name){};
    public String getName(){
        return name;
    }

    public void setInJail(boolean inJail){};
    public boolean getInJail(){
        return inJail;
    }

    public void setInJailRound(int round){};
    public int getInJailRound(){
        return inJailRound;
    };

    public void setMoney(int money){};
    public int getMoney(){
        return money;
    }

    public void setPosition(int position){};
    public int getPosition(){
        return position;
    }

    public void setIsOut(boolean isOut){};
    public boolean getIsOut(){
        return isOut;
    }

    public void setPropertyList(Property p){};
    public Property getPropertyList(){
        return propertyList;
    }
}
