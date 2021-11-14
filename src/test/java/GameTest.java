package test.java;//import org.junit.Test;
import main.java.Game;
import main.java.Player;
import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest{
    Game game;
    public void setInput(String input){
        ByteArrayInputStream in;
        in=new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @BeforeEach
    void setUp(){
        game = new Game();
    }

    @Test
    @DisplayName("Test if user could correctly start game")
    public void testStartGame(){
        game.startGame(3);
        assertNotNull(game.board, "Game should create the board.");

        //assertNotNull(game.players[0], "Game should include at least 1 player.");
        //assertEquals(game.playerNum, game.players.length, "All the players shold be added in this game.");
        //for (int i = 0; i < game.playerNum; i++) {
            //assertEquals(i+1, game.currentPlayer[i], "All the players have been included in this game.");
        //}

    }


    @Test
    @DisplayName("Test if the player could be correctly added")
    public void testAddPlayer(){
        int id=1;
        String name="Alice\n";
        game.addNewPlayer(id, name);
        setInput(name);
        assertEquals(id, game.players[0].getId(),"The first player should be correctly added");
        assertEquals(name, game.players[0].getName(),"The first player should be correctly added");
    }


    @Test
    @DisplayName("Test if the game could ask the players take turns to play the game.")
    public void testTakeTurn(){
        /*game.currentRound=1;
        for(int i=0; i<50; i++){
            if(!game.isEnd){
                game.takeTurn(i);
                assertEquals(i % (game.currentPlayer.length) + 1, game.currentRound,"The current round should be "+game.currentRound);
            }
        }*/
    }

    @Test
    @DisplayName("Test if the game could correctly judge if the game has been ended")
    public void testJudgeIsEnd(){
        game.judgeIsEnd();
        if(game.currentPlayer.length==1 || game.currentRound==100){
            assertTrue(game.isEnd, "Game should be end");
        }
        else{
            assertFalse(game.isEnd, "Game should be continue");
        }
    }


    @Test
    @DisplayName("Test if the game could correctly print the winner")
    public void testPrintWinner(){
        Player player1=new Player(1, "Alice");
        Player player2=new Player(2, "Bob");
        Player player3=new Player(3, "Cindy");

        game.players[0]=player1;
        game.players[1]=player2;
        game.players[2]=player3;
        game.currentPlayer[0]=1;
        game.currentPlayer[1]=3;
        String[] output=game.printWinner();
        assertEquals(new String[]{"Alice", "Cindy"}, output,"The winner are correct!");
    }
  
}
