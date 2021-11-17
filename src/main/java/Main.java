import Controller.*;
import Model.*;
import View.*;

import java.io.File;

public class Main {
    public static void main(String[] args){
        GameController ctrl = new GameController();
        GameView view = new GameView();

        File save = new File("save"); // create save directory
        if (!save.exists()) {
            boolean b = save.mkdir();
            while(!b){
                b = save.mkdir();
            }
        }
        
        while(true){
            view.printWelcomeMessage();
            //view.printChooseModeMessage();
            String input_num = ctrl.chooseBeginWay();
            GameController controller;
            if (input_num.equals("1")){ // start a new game
                Game game = new Game();
                controller = new GameController(game);
                controller.startGameController();
            }
            else{ // load a game
                Game game = ctrl.loadGameController();
                if (game == null){ // no save files
                    game = new Game();
                    controller = new GameController(game);
                    controller.startGameController();
                }
                else{ // load game
                    controller = new GameController(game);
                }
            }
            controller.takeTurnController();
            if (controller.gameIsEnd()){
                String choice = controller.endGame();
                if (choice.equals("e")) break;
            }
        }
    }
}
