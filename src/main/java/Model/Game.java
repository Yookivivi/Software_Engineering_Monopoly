package Model;

import java.io.*;
import java.util.Arrays;

import Controller.BoardController;
import Controller.PlayerController;
import View.*;

/**
 * This class is for game implementation(with all data and operations in each game)
 */

public class Game implements Serializable{
    private GameView view;
    public int playerNum; //the number of players
    public int currentRound = 1; //current round
    public int[] currentPlayers; //the existing players(which have not been week out)
    public Boolean isEnd = false; 
    public Player[] players; //an array for all the players
    public Board board;//game board
    public int currentPlayer;//the id of current player
    public BoardView boardView;//board view
    public BoardController boardController;//board controller

    /**
     * Constructor for Game
     */
    public Game(){
        view = new GameView();
    };

    /**
     * start game initialization
     * @param input_num number of players
     */
    public void startGame(int input_num){
        board=new Board();
        playerNum=input_num;
        players=new Player[input_num];
        currentPlayers=new int[input_num];
        currentPlayer=1;
        boardView = new BoardView();
        boardController = new BoardController(board,boardView);
    };//to start a new game

    /**
     * add new player to game
     * @param id id of each player
     * @param name name of each player
     */
    public void addNewPlayer(int id, String name){
        Player player=new Player(id, name);
        players[id-1]=player;
        currentPlayers[id-1]=id;
    };//to create the player and add him/her to the players

    /**
     * load game from existing file
     * @param file save file
     * @return Game instance converted from the file
     */
    public Game loadGame(File file){
        try{
            ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(file));
            Game game = (Game)objIn.readObject();
            view.printLoadSuccessfulMessage();
            return game;
        } catch(IOException | ClassNotFoundException e) {
            view.printLoadFailMessage();
            e.printStackTrace();
        }
        return null;
    };// to load a game

    /**
     * save game to file
     * @param name name of file
     */
    public void saveGame(String name){
        File file = new File("save/"+name+".dat");
        FileOutputStream out;
        try{
            ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(file));
            objOut.writeObject(this);
            objOut.flush();
            objOut.close();
            view.printSaveSuccessfullyMessage();
        } catch (IOException e) {
            view.printSaveFailMessage();
            e.printStackTrace();
        }
    };// to save game

    /**
     * how to take turn
     * @param player current player
     */
    public void takeTurn(Player player){
        if(player.getIsOut()){
            int index= Arrays.binarySearch(currentPlayers, currentPlayer);
            int formal_length=currentPlayers.length;
            int[] formalPlayers=currentPlayers;
            currentPlayers=new int[formal_length-1];
            for(int i=0; i<formal_length; i++){
                if(i<index){
                    currentPlayers[i]=formalPlayers[i];
                }
                else if(i>index){
                    currentPlayers[i-1]=formalPlayers[i];
                }
                else{
                    continue;
                }
            }
            if(currentPlayer>=currentPlayers[currentPlayers.length-1]){
                currentPlayer++;//jump out this round
            }
            else{
                currentPlayer=currentPlayers[index];
            }
        }
        else{
            if(currentPlayer==currentPlayers[currentPlayers.length-1]){
                currentPlayer++;//jump out the while loop
            }
            else{
                int index= Arrays.binarySearch(currentPlayers, currentPlayer);
                currentPlayer=currentPlayers[index+1];
            }
        }
    };//to do the next turn

    /**
     * check whether the game is end
     */
    public void judgeIsEnd(){
        if(currentPlayers.length==1){
            isEnd=true;
        }
        else if(currentRound>100){
            isEnd=true;
        }
    };// to judge whether the game is ended

    /**
     * get list of winners' name
     * @return  list of winners' name
     */
    public String[] printWinner(){
        int winner_num=currentPlayers.length;
        String[] winners=new String[winner_num];
        for(int i=0; i<winner_num; i++){
            winners[i]=players[currentPlayers[i]-1].getName();
        }
        return winners;
    };// print the winner of the game
}
