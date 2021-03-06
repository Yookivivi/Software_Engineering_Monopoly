import Controller.*;
import Model.*;
import View.*;

import java.io.File;

/**
 * This class controls the main flow of the whole monopoly game
 */

public class Main {
    public static void main(String[] args){
        GameController ctrl = new GameController();
        GameView view = new GameView();

        File save = new File("save"); // The game should firstly ensure that there is a save directory
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
            else if (input_num.equals("2")){ // load a game
                Game game = ctrl.loadGameController();
                if (game == null){ // if there is no save file, start a new game
                    game = new Game();
                    controller = new GameController(game);
                    controller.startGameController();
                }
                else{
                    controller = new GameController(game);
                }
            }
            else{ // exit game
                view.printEndGameMessage();
                break;
            }
            controller.takeTurnController();
            if (controller.gameIsEnd()){
                String choice = controller.endGame();
                if (choice.equals("e")) break;
            }
        }
    }
}
