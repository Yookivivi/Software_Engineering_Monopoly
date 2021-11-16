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


    public void updateIsOut(){
        if (player.getMoney()<=0){
            player.setIsOut(true);
        }
    }
}
