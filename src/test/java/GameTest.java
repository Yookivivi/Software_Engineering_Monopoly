//import org.junit.Test;
import org.junit.jupiter.api.*;
import java.io.*;
import Model.*;

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
        
        assertNotNull(game.players, "Game should include at least 1 player.");
        assertEquals(game.playerNum, game.players.length, "All the players should be added in this game.");

        assertNotNull(game.currentPlayer, "Game should include at least 1 player.");
        assertEquals(game.playerNum, game.currentPlayer.length, "All the players should be added in this game.");

    }


   @Test
    @DisplayName("Test if the player could be correctly added")
    public void testAddPlayer(){
        int id=1;
        String name="Alice";
        game.players=new Player[1];
        game.currentPlayer=new int[1];
        game.addNewPlayer(id, name);
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
        /*
        game.currentRound=100;
        game.judgeIsEnd();
        assertTrue(game.isEnd, "Game should be end");

        game.currentPlayer[0]=1;
        game.judgeIsEnd();
        assertTrue(game.isEnd, "Game should be end");

        game.currentPlayer[0]=1;
        game.currentRound=97;
        game.currentPlayer[1]=1;
        game.judgeIsEnd();
        assertFalse(game.isEnd, "Game should be continue");
        */
    }


    @Test
    @DisplayName("Test if the game could correctly print the winner")
    public void testPrintWinner(){
        game.players=new Player[3];
        game.currentPlayer=new int[2];
        Player player1=new Player(1, "Alice");
        Player player2=new Player(2, "Bob");
        Player player3=new Player(3, "Cindy");

        game.players[0]=player1;
        game.players[1]=player2;
        game.players[2]=player3;
        game.currentPlayer[0]=1;
        game.currentPlayer[1]=3;
        String[] output=game.printWinner();
        assertEquals("Alice",output[0],"The winner 1 is correct!");
        assertEquals("Cindy",output[1],"The winner 2 is correct!");



    }
  
}
