package Controller;
import Model.*;

import View.GameView;
//import main.java.Game;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This class is the controller for users during the monopoly game
 */

public class GameController {
    private Game game;
    private GameView gameView = new GameView();

    /**
     * Constructor for GameController
     * @param game Game instance to manipulate on
     */
    public GameController(Game game){
        this.game = game;
    }
    public GameController(){ this.game = new Game(); }

    public boolean gameIsEnd(){
        return game.isEnd;
    }

    /**
     * end game interactions with user
     * @return user's choice
     */
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

    /**
     * choose start game mode (start new game / load game) or exit game
     * @return user's choice
     */
    public String chooseBeginWay(){//choose the way that begin game
        gameView.printChooseModeMessage();
        Scanner S=new Scanner(System.in);
        String input_num=S.nextLine();
        while(!input_num.equals("1") && !input_num.equals("2") && !input_num.equals("3")){
            gameView.printInvalidChoiceMessage();
            S=new Scanner(System.in);
            input_num=S.nextLine();
        }
        return input_num;
    }

    /**
     * game initialization interactions with users
     * - get player number from user and store it
     */
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

    /**
     * game initialization interactions with users
     * - get each player's name from user and store it
     * @param input_num num of players
     */
    public void addNewPlayerController(int input_num){
        for(int i=0; i<input_num; i++){
            gameView.printAddNewPlayerMessage(i+1);
            Scanner S=new Scanner(System.in);
            String name=S.nextLine();
            game.addNewPlayer(i+1, name);
            gameView.printSuccessfullyAddNewPlayerMessage(game.currentPlayers[i], game.players[i].getName());
        }
    }

    /**
     * controller to save game
     * @return 0: exit game  1: continue game
     */
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
            File file = new File("save/"+name+".dat");
            if (file.exists()){ // overwrite file
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

    /**
     * controller to load game
     * @return Game instance loaded from local files
     */
    public Game loadGameController(){
        File dir = new File("save");
        File[] fs = dir.listFiles();

        if (fs.length == 0){ // no files in save directory
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
            return game.loadGame(fs[choice-1]); // load game accordingly
        }
    }

    /**
     * controller to take turn within game
     */
    public void takeTurnController(){
        here:
        while(!game.isEnd){
            int current_playerNum=game.currentPlayers.length;
            gameView.printTakeTurnMessage(game.currentRound);
            if(game.currentPlayer>game.currentPlayers[current_playerNum-1]){ // if all the player in this round has played
                game.currentPlayer=game.currentPlayers[0]; // go back to the first player
            }
            while (game.currentPlayer<=game.currentPlayers[current_playerNum-1]){
                Player player=game.players[game.currentPlayer-1];
                PlayerController playerController=new PlayerController(player, game.board);
                playerController.startTurnController();
                // takeTurn
                game.takeTurn(player);
                // printBoard
                game.boardController.printBoard();
                // print player's information
                gameView.printPlayersPosition(game);
                current_playerNum=game.currentPlayers.length;
                int exit = saveGameController();
                if (exit == 0){
                    if(game.currentPlayer<=game.currentPlayers[current_playerNum-1]){
                        game.currentPlayer=game.currentPlayers[0];
                    }
                    break here;
                }
                // judge if game is end
                game.judgeIsEnd();
                if(game.isEnd){ // game is end
                    break here;
                }

            }
            game.currentRound++;
            // judge if game is end.
            game.judgeIsEnd();
            if (game.isEnd) break;
        }
        if (game.isEnd) printWinnerController();
    }

    /**
     * print winner messages
     */
    public void printWinnerController(){
        gameView.printWinnerMessage(game.printWinner(), game.currentPlayers);
    }
}
