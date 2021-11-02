public class Game {
    public int playerNum; //the number of players
    public int currentRound; //current round
    public int[] currentPlayer; //
    public Boolean isEnd; 
    public Player[] players; //an array for all the players
    public Board board;//game board

    public Game(){};//constructor
    public void startGame(){};//to start a new game
    public void addNewPlayer(int id){};//to create the player and add him/her to the players
    public void loadGame(){};//to load a game
    public void saveGame(){};//to save a game
    public void takeTurn(){};//to do the next turn
    public void judgeIsEnd(){};// to judge whether the game is ended
    public void printWinner(){};// print the winner of the game
}
