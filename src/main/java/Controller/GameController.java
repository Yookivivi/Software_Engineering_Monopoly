package Controller;
import Model.*;

import View.GameView;
//import main.java.Game;
import java.util.Scanner;

public class GameController {
    private Game game;
    private GameView gameView;

    public GameController(Game game, GameView gameView){
        this.game = game;
        this.gameView = gameView;
    }

    // 11/14/21:58
    public void choose_begin_way(){//choose the way that begin game
        gameView.printChooseModeMessage();
        Scanner S=new Scanner(System.in);
        String input_num=S.toString();
        while(!input_num.equals("1") && !input_num.equals("2")){
            gameView.printInvalidChoiceMessage();
            S=new Scanner(System.in);
            input_num=S.toString();
        }
        if(input_num.equals("1")){
            startGameController();
        }
        else{
            loadGameController();
        }
    }

    public void startGameController(){
        gameView.printStartGameMessage();
        Scanner S=new Scanner(System.in);
        int input_num=S.nextInt();
        while(input_num<2 || input_num>6){
            gameView.printInvalidChoiceMessage();
            S=new Scanner(System.in);
            input_num=S.nextInt();
        }
        game.startGame(input_num);
        addNewPlayerController(input_num);
    }

    public void addNewPlayerController(int input_num){
        for(int i=0; i<input_num; i++){
            gameView.printAddNewPlayerMessage(i+1);
            Scanner S=new Scanner(System.in);
            String name=S.toString();
            game.addNewPlayer(i+1, name);
            gameView.printSuccessfullyAddNewPlayerMessage(game.currentPlayer[i], game.players[i].getName());
        }
        takeTurnController();
    }

    // 11/14/21:49
    public void saveGameController(){
        gameView.printSaveGaveMessage();
        Scanner S=new Scanner(System.in);
        String choice=S.toString();
        while(!choice.equals("y") && !choice.equals("n")){
            gameView.printInvalidChoiceMessage();
            S = new Scanner(System.in);
            choice = S.toString();
        }
        if(choice.equals("y")){
            gameView.printSaveNameMessage();
            S=new Scanner(System.in);
            String name=S.toString(); // name should not include format (e.g. .txt)
            File file = new File("save/"+name+".txt");
            if (file.exists()){
                gameView.printSaveOverwriteMessage();
                S = new Scanner(System.in);
                String overwriteChoice = S.toString();
                while(!overwriteChoice.equals("y") && !overwriteChoice.equals("n")){
                    gameView.printInvalidChoiceMessage();
                    S = new Scanner(System.in);
                    overwriteChoice = S.toString();
                }
                if (overwriteChoice.equals("y")){
                    game.saveGame(name);
                }
                else{
                    saveGameController();
                }
            }
            else{
                game.saveGame(name);
            }
        }
    }

    // 11/14/21:33
    public Game loadGameController(){
        gameView.printLoadGameMessage();
        File dir = new File("save");
        File[] fs = dir.listFiles();

        int index = 1;
        for(File f:fs){
            gameView.printSaveMessage(index, f.getName());
            index++;
        }
        gameView.printLoadChooseMessage();
        Scanner s = new Scanner(System.in);
        int choice = s.nextInt();

        while(choice < 1 || choice > fs.length){
            gameView.printInvalidChoiceMessage();
            s = new Scanner(System.in);
            choice = s.nextInt();
        }
        return game.loadGame(fs[choice-1]);
    }


    // new
    public void takeTurnController(){
        while(!game.isEnd){
            int current_playerNum=game.currentPlayer.length;
            for(int i=0; i<current_playerNum; i++){
                gameView.printTakeTurnMessage(game.currentRound,game.players[game.currentPlayer[i]-1].getId(),game.players[game.currentPlayer[i]-1].getName());
                game.takeTurn(i);
                saveGameController();
                game.judgeIsEnd();
                if(game.isEnd){
                    break;
                }

            }
            game.currentRound++;
        }
        printWinnerController();
    }

    public void printWinnerController(){
        gameView.printWinnerMessage(game.printWinner(), game.currentPlayer);
    }
}
