package View;
import Controller.GameController;
import Model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameViewTest {

    @Test
    @DisplayName("Test Print Players Position")
    public void testPrintPlayersPosition(){
        Game game = new Game();
        GameView gameView = new GameView();

        game.startGame(2);
        game.addNewPlayer(1, "Tom");
        game.addNewPlayer(2, "Alice");

        gameView.printPlayersPosition(game);
    }

}