package Model;

import java.io.*;
import java.util.Arrays;

import Controller.GameController;
import Controller.PlayerController;
import View.*;

public class Game implements Serializable{
    private GameView view;
    private GameController controller;
    
    public int playerNum; //the number of players
    public int currentRound = 0; //current round
    public int[] currentPlayers; //the existing players(which have not been week out)
    public Boolean isEnd = false; 
    public Player[] players; //an array for all the players
    public Board board;//game board
    public int currentPlayer;//the id of current player

    public Game(){

    };//constructor

    public void startGame(int input_num){
        board=new Board();
        playerNum=input_num;
        players=new Player[input_num];
        currentPlayers=new int[input_num];
        currentPlayer=1;
    };//to start a new game

    public void addNewPlayer(int id, String name){
        Player player=new Player(id, name);
        players[id-1]=player;
        currentPlayers[id-1]=id;
    };//to create the player and add him/her to the players

    // 11/14/21:39
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
        return controller.loadGameController();
    };// to load a game

    // 11/14/21:10
    public void saveGame(String name){
        File file = new File("save/"+name+".txt");
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
            controller.saveGameController();
        }
    };// to save game

    public void takeTurn(){
        //Player player=players[currentPlayers[i]-1];
        Player player=players[currentPlayer-1];
        PlayerController playerController=new PlayerController(player);
        playerController.startTurnController();
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

    
    public void judgeIsEnd(){
        if(currentPlayers.length==1){
            isEnd=true;
        }
        else if(currentRound==100){
            isEnd=true;
        }
    };// to judge whether the game is ended

    public String[] printWinner(){
        int winner_num=currentPlayers.length;
        String[] winners=new String[winner_num];
        for(int i=0; i<winner_num; i++){
            winners[i]=players[currentPlayers[i]-1].getName();
        }
        return winners;
    };// print the winner of the game
}
