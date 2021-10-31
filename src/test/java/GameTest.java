import org.junit.Test;
import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    
    Game game;

    @BeforeEach
    void setUp(){
        game = new Game();
    }

    //不太确定这里
    @Test
    @DisplayName("Test if user could correctly start game")
    public void testStartGame(){
        game.startGame();
        assertNotNull(game.board, "Game has created the board.");
        assertNotNull(game.players[0], "Game has been included at least 1 player.");
        assertEquals(game.playerNum, game.players.length, "All the players have been added in this game.");
        for (int i = 0; i < game.playerNum; i++) {
            assertEquals(i+1, game.currentPlayer[i], "All the players have been included in this game.");
        }

    }

    @Test
    @DisplayName("Test if user could correctly start game")
    public void testLoadGame(){
    }

    @Test
    @DisplayName("Test if user could correctly start game")
    public void testSaveGame(){
    }

    @Test
    @DisplayName("Test if the game could ask the players take turns to play the game.")
    public void testTakeTurn(){
        game.currentRound=1;
        for(int i=0; i<50; i++){
            if(!game.isEnd){
                game.takeTurn();
                assertEquals(i % (game.currentPlayer.length) + 1, game.currentRound);
            }
        }
    }

    @Test
    @DisplayName("Test if the game could correctly judge if the game has been ended")
    public void testJudgeIsEnd(){
        game.judgeIsEnd();
        if(game.currentPlayer.length==1 || game.currentRound==100){
            assertTrue(game.isEnd);
        }
        else{
            assertFalse(game.isEnd);
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
                assertEquals("The winner is "+game.players[game.currentPlayer[0]], outContent.toString());
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
