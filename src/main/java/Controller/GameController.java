package Controller;
import Model.*;

import View.GameView;
//import main.java.Game;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class GameController {
    private Game game;
    private GameView gameView = new GameView();

    public GameController(Game game){
        this.game = game;
    }
    public GameController(){}

    public boolean gameIsEnd(){
        return game.isEnd;
    }

    public String endGame(){
        gameView.printContinueMessage();
        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        while(!choice.equals("m") && !choice.equals("e")){
            gameView.printInvalidChoiceMessage();
            s = new Scanner(System.in);
            choice = s.nextLine();
        }
        if (choice.equals("e")){
            gameView.printEndGameMessage();
        }
        return choice;
    }

    // 11/14/21:58
    public String chooseBeginWay(){//choose the way that begin game
        gameView.printChooseModeMessage();
        Scanner S=new Scanner(System.in);
        String input_num=S.nextLine();
        while(!input_num.equals("1") && !input_num.equals("2")){
            gameView.printInvalidChoiceMessage();
            S=new Scanner(System.in);
            input_num=S.nextLine();
        }
        return input_num;
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
            String name=S.nextLine();
            game.addNewPlayer(i+1, name);
            gameView.printSuccessfullyAddNewPlayerMessage(game.currentPlayers[i], game.players[i].getName());
        }
    }

    // 11/14/21:49
    public int saveGameController(){ // return 0: exit 1: continue
        gameView.printTurnEndMessage();
        Scanner S=new Scanner(System.in);
        String choice=S.nextLine();
        while(!choice.equals("s") && !choice.equals("e") && !choice.equals("c")){
            gameView.printInvalidChoiceMessage();
            S = new Scanner(System.in);
            choice = S.nextLine();
        }
        if(choice.equals("s")){ // save game
            gameView.printSaveNameMessage();
            S=new Scanner(System.in);
            String name=S.nextLine(); // name should not include format (e.g. .txt)
            File file = new File("save/"+name+".txt");
            if (file.exists()){
                gameView.printSaveOverwriteMessage();
                S = new Scanner(System.in);
                String overwriteChoice = S.nextLine();
                while(!overwriteChoice.equals("y") && !overwriteChoice.equals("n")){
                    gameView.printInvalidChoiceMessage();
                    S = new Scanner(System.in);
                    overwriteChoice = S.nextLine();
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
            return 1;
        }
        else if (choice.equals("e")){ // exit game
            return 0;
        }
        else{ // continue
            return 1;
        }
    }

   // 11/14/21:33
    public Game loadGameController(){
        File dir = new File("save");
        File[] fs = dir.listFiles();

        if (fs.length == 0){
            gameView.printNoSaveMessage();
            return null;
        }
        else{
            gameView.printLoadGameMessage();
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
    }

    // new
    public void takeTurnController(){
        here:
        while(!game.isEnd){
            int current_playerNum=game.currentPlayers.length;
            gameView.printTakeTurnMessage(game.currentRound);
            if(game.currentPlayer>game.currentPlayers[current_playerNum-1]){
                game.currentPlayer=game.currentPlayers[0];
            }
            while (game.currentPlayer<=game.currentPlayers[current_playerNum-1]){
            //for(int i=0; i<current_playerNum; i++){ // how to keep track of current player
                //gameView.printTakeTurnMessage(game.currentRound,game.players[game.currentPlayer].getId(),game.players[game.currentPlayer].getName());
                game.takeTurn();

                current_playerNum=game.currentPlayers.length;
                int exit = saveGameController();
                if (exit == 0){
                    if(game.currentPlayer<=game.currentPlayers[current_playerNum-1]){
                        game.currentPlayer=game.currentPlayers[0];
                    }
                    break here;
                }
                game.judgeIsEnd();
                if(game.isEnd){
                    break here;
                }

            }
            game.currentRound++;
            game.judgeIsEnd();
            if (game.isEnd) break;
        }
        if (game.isEnd) printWinnerController();
    }


    public void printWinnerController(){
        gameView.printWinnerMessage(game.printWinner(), game.currentPlayers);
    }
}
