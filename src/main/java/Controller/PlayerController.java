package Controller;
import Model.*;
import View.PlayerView;

public class PlayerController {
    private Player player;
    private PlayerView playerView;
    private Board board;

    public PlayerController(Player player, Board board){
        this.player=player;
        this.playerView=new PlayerView();
        this.board=board;
    }

    public void startTurnController(){
        playerView.printPlayerTurnMessage(player.getId(),player.getName());
        if(player.getInJail()){
            playerView.printInJailMessage(player.getInJailRound());
            if(player.getInJailRound()==1){
                JailRelatedActionController jailRelatedActionController=new JailRelatedActionController();
                jailRelatedActionController.chooseHowToGetOut(player);
            }
        }
        else{
            ActionController actionController=new ActionController(player);
            actionController.currentDice.rollDice();
            int dice1= actionController.currentDice.dice1;
            int dice2= actionController.currentDice.dice2;
            int total_dice=actionController.currentDice.totalDice;
            playerView.printDiceMessage(dice1, dice2, total_dice);
            int position=player.getPosition()+total_dice;
            if(position>20){
                position-=20;
            }
            actionController.updatePosition(player,position);
            updateSquareController(position,actionController);
        }
    }

    public void updateSquareController(int position, ActionController actionController){
        Square square=board.squares[position-1];

        if (square.takeEffect(player)==1){
            
        }

    }


    public void updateIsOut(){
        if (player.getMoney()<=0){
            player.setIsOut(true);
            Property property=player.getPropertyList();
            int propertyNum=player.getPropertyList().getLandList().size();

            for(int i=0; i<propertyNum; i++){
                int position=player.getPropertyList().getLandList().get(0);
                Square square=board.squares[position-1];

                //square.
                //LandSquare landSquare=
                property.updateProperty(0,player.getPropertyList().getLandList().get(0));

            }

        }

    }
}
