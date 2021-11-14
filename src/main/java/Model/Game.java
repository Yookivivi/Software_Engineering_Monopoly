package Model;


public class Game {
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

    public void loadGame(){};//to load a game

    public void saveGame(){};//to save a game

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
