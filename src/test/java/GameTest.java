import org.testng.annotations.Test;
import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    
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
        game.startGame();
        assertNotNull(game.board, "Game should create the board.");
        assertNotNull(game.players[0], "Game should include at least 1 player.");
        assertEquals(game.playerNum, game.players.length, "All the players shold be added in this game.");
        for (int i = 0; i < game.playerNum; i++) {
            assertEquals(i+1, game.currentPlayer[i], "All the players have been included in this game.");
        }

    }


    @Test
    @DisplayName("Test if the player could be correctly added")
    public void testAddPlayer(){
        int id=1;
        String name="Alice\n";
        game.addNewPlayer(id);
        setInput(name);
        assertEquals(id, game.players[0].getId(),"The first player should be correctly added");
        assertEquals(name, game.players[0].getName(),"The first player should be correctly added");
    }


    @Test
    @DisplayName("Test if the game could ask the players take turns to play the game.")
    public void testTakeTurn(){
        game.currentRound=1;
        for(int i=0; i<50; i++){
            if(!game.isEnd){
                game.takeTurn();
                assertEquals(i % (game.currentPlayer.length) + 1, game.currentRound,"The current round should be "+game.currentRound);
            }
        }
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
        if(game.isEnd){
            game.printWinner();
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
            if(game.currentPlayer.length==1){
                assertEquals("The winner is "+game.players[game.currentPlayer[0]], outContent.toString(),
                        "The winner of this game should be "+game.players[game.currentPlayer[0]]);
            }
            else{
                String winner=game.players[game.currentPlayer[0]].getName();
                for (int i = 1; i < game.currentPlayer.length; i++) {
                    winner=winner+", "+game.players[game.currentPlayer[i]].getName();
                }
                assertEquals("The winners are "+ winner, outContent.toString());
            }
        }
    }
  
}
