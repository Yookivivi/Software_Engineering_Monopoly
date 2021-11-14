package Model;

import java.io.*;
import Controller.GameController;
import View.*;

public class Game {
    private GameView view;
    private GameController controller;
    
    public int playerNum; //the number of players
    public int currentRound; //current round
    public int[] currentPlayer; //
    public Boolean isEnd; 
    public Player[] players; //an array for all the players
    public Board board;//game board

    public Game(){

    };//constructor

    public void startGame(int input_num){
        board=new Board();
        playerNum=input_num;
        players=new Player[input_num];
        currentPlayer=new int[input_num];
    };//to start a new game

    public void addNewPlayer(int id, String name){
        Player player=new Player(id, name);
        players[id-1]=player;
        currentPlayer[id-1]=id;
    };//to create the player and add him/her to the players

    // 11/14/21:39
    public Game loadGame(File file){
        try{
            ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(file));
            Game game = (Game)objIn.readObject();
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

    public void takeTurn(int i){
        Player player=players[currentPlayer[i]-1];


    };//to do the next turn
    public void judgeIsEnd(){
        if(currentPlayer.length==1){
            isEnd=true;
        }
        else if(currentRound==100){
            isEnd=true;
        }
    };// to judge whether the game is ended

    public String[] printWinner(){
        int winner_num=currentPlayer.length;
        String[] winners=new String[winner_num];
        for(int i=0; i<winner_num; i++){
            winners[i]=players[currentPlayer[i]-1].getName();
        }
        return winners;
    };// print the winner of the game
}
