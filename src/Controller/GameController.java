package Controller;

import View.GameView;
import main.java.Game;

import java.util.Scanner;

public class GameController {
    private Game game;
    private GameView gameView;

    public GameController(Game game, GameView gameView){
        this.game = game;
        this.gameView = gameView;
    }

    public void choose_begin_way(){//choose the way that begin game
        gameView.printChooseModeMessage();
        Scanner S=new Scanner(System.in);
        String input_num=S.toString();
        while(input_num!="1" && input_num !="2"){
            gameView.printInvalidChoiceMessage();
            S=new Scanner(System.in);
            input_num=S.toString();
        }
        if(input_num=="1"){
            startGameController();
        }
        else{
            game.loadGame();
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
            gameView.printSuccessfullyAddNewPlayerMessage(game.currentPlayer[i],game.players[i].getName());
        }
        takeTurnController();
    }

    public void saveGameController(){
        Scanner S=new Scanner(System.in);
        String name=S.toString();
        while(name!="y" && name!="n"){
            gameView.printInvalidChoiceMessage();
        }
        if(name=="y"){
            game.saveGame();
        }
    }

    public void takeTurnController(){
        while(!game.isEnd){
            int current_playerNum=game.currentPlayer.length;
            for(int i=0; i<current_playerNum; i++){
                gameView.printTakeTurnMessage(game.currentRound,game.players[game.currentPlayer[i]-1].getId(),game.players[game.currentPlayer[i]-1].getName());
                game.takeTurn(i);
                gameView.printSaveGaveMessage();
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

