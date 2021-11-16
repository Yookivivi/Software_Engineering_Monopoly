package Controller;
import Model.*;
import View.PlayerView;

public class PlayerController {
    private Player player;
    private PlayerView playerView;

    public PlayerController(Player player){
        this.player=player;
        this.playerView=new PlayerView();
    }

    public void startTurnController(){
        playerView.printPlayerTurnMessage(player.getId(),player.getName());
    }


    public void updateIsOut(Board board){
        if (player.getMoney()<=0){
            player.setIsOut(true);
            Property property=player.getPropertyList();
            int propertyNum=player.getPropertyList().getLandList().size();
            for(int i=0; i<propertyNum; i++){
                int position=player.getPropertyList().getLandList().get(0);
                //LandSquare landSquare=
                property.updateProperty(0,player.getPropertyList().getLandList().get(0));

            }

        }

    }
}
