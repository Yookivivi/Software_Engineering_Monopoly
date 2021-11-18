package Controller;
import Model.*;
import View.PlayerView;

/**
 * This class is the controller for player's action within each round
 */

public class PlayerController {
    private Player player;
    private PlayerView playerView;
    private Board board;

    /**
     * Constructor for PlayerController
     * @param player action related player
     * @param board Board instance
     */
    public PlayerController(Player player, Board board){
        this.player=player;
        this.playerView=new PlayerView();
        this.board=board;
    }

    /**
     * controller for actions within each turn
     */
    public void startTurnController(){ // control the condition that player is in jail and not in jail
        playerView.printPlayerTurnMessage(player.getId(),player.getName());
        if(player.getInJail()){ // in jail
            playerView.printInJailMessage(player.getInJailRound());
            JailRelatedActionController jailRelatedActionController=new JailRelatedActionController(player);
            jailRelatedActionController.chooseHowToGetOut(); // choose the way to get out of the jail
            if (jailRelatedActionController.choice==2){ // player choose to pay money
                updateIsOut(); // judge if the player is out
                if(!player.getIsOut()) notInJailActionController(); // not out, then go to roll the dice
            }
            else{
                if(!player.getInJail()){ // go out by throw double
                    updateSquareController(player.getPosition());
                }
            }

        }
        else{ // not in jail
            notInJailActionController();
        }
    }

    /**
     * controller for player's action if he/she is not in jail
     */
    public void notInJailActionController(){//not in jail
        ActionController actionController=new ActionController(player);
        actionController.currentDice.rollDice();
        int dice1= actionController.currentDice.dice1;
        int dice2= actionController.currentDice.dice2;
        int total_dice=actionController.currentDice.totalDice;
        playerView.printDiceMessage(dice1, dice2, total_dice);
        int position=player.getPosition()+total_dice;
        if(position>20){ // after one circle, go back to the first square and start again
            position-=20;
            player.setMoney(player.getMoney()+1500); // pass go, add money
            System.out.println("* "+player.getName()+" has passed the GO, and got HKD1500");
        }
        actionController.updatePosition(player,position); // update the position
        updateSquareController(position); // get the action of this position
    }

    /**
     * controller for actions within the player's current square
     * @param position player's current position
     */
    public void updateSquareController(int position){ // control the action on the current square
        Square square=board.squares[position-1];
        playerView.printUpdatedSquareMessage(position,square.getName());
        if (square.takeEffect(player)==1){ // land on an unowned land
            LandSquare landSquare=(LandSquare) square;
            PropertyRelatedActionController p=new PropertyRelatedActionController(player);
            p.choosebuyland(landSquare); // ask if buy land
        }
        updateIsOut();
    }

    /**
     *
     */
    public void updateIsOut(){ // judge if the player is out
        if (player.getMoney()<=0){
            player.setIsOut(true);
            Property property=player.getPropertyList();
            int propertyNum=player.getPropertyList().getLandList().size();

            for(int i=0; i<propertyNum; i++){ // release the player's property
                int position=player.getPropertyList().getLandList().get(0);
                Square square=board.squares[position-1];
                LandSquare landSquare=(LandSquare) square;
                landSquare.setOwner(null);
                property.updateProperty(0,player.getPropertyList().getLandList().get(0));
            }

        }

    }
}
