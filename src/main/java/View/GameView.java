package View;
import Model.*;
import java.util.Scanner;
import java.io.Serializable;

public class GameView implements Serializable{
    public void printChooseModeMessage(){
        System.out.println("* Welcome to Monopoly");
        System.out.println("* You have 2 ways to start the game, they are:");
        System.out.println("* 1. Directly start a new game.");
        System.out.println("* 2. Load a previous version game.");
        System.out.println("> Please enter your choice by number (1/2): ");
    }

    public void printInvalidChoiceMessage(){
        System.out.println("* Invalid input!");
        System.out.println("> Please enter a valid choice again: ");
    }
    
    public void printNoSaveMessage(){
        System.out.println("* There is no save file. Please start a new game.");
    }

    public void printContinueMessage(){
        System.out.println("> Enter m to go back to menu and e to exit: ");
    }

    public void printEndGameMessage(){
        System.out.println("* Thank you for playing our game!\n");
        System.out.println(" ________  __                            __              __      __                  \n" +
                "/        |/  |                          /  |            /  \\    /  |                 \n" +
                "$$$$$$$$/ $$ |____    ______   _______  $$ |   __       $$  \\  /$$/______   __    __ \n" +
                "   $$ |   $$      \\  /      \\ /       \\ $$ |  /  |       $$  \\/$$//      \\ /  |  /  |\n" +
                "   $$ |   $$$$$$$  | $$$$$$  |$$$$$$$  |$$ |_/$$/         $$  $$//$$$$$$  |$$ |  $$ |\n" +
                "   $$ |   $$ |  $$ | /    $$ |$$ |  $$ |$$   $$<           $$$$/ $$ |  $$ |$$ |  $$ |\n" +
                "   $$ |   $$ |  $$ |/$$$$$$$ |$$ |  $$ |$$$$$$  \\           $$ | $$ \\__$$ |$$ \\__$$ |\n" +
                "   $$ |   $$ |  $$ |$$    $$ |$$ |  $$ |$$ | $$  |          $$ | $$    $$/ $$    $$/ \n" +
                "   $$/    $$/   $$/  $$$$$$$/ $$/   $$/ $$/   $$/           $$/   $$$$$$/   $$$$$$/  \n" +
                "                                                                                     \n");
    }

    public void printStartGameMessage(){
        System.out.println("***********************************************************************************************");
        System.out.println("* Please enter the number of players(any number from 2 to 6): ");
    }

    public void printTurnEndMessage(){
        System.out.println("> Enter s to save, e to exit and c to continue: ");
    }

    // new
    public void printSaveNameMessage(){
        System.out.println("> Please enter the file name: ");
    }

    // new
    public void printSaveSuccessfullyMessage(){
        System.out.println("* Game saved successfully.");
    }

    // new
    public void printSaveFailMessage(){
        System.out.println("* Game save failed.");
    }

    // 11/14/21:43
    public void printSaveOverwriteMessage(){
        System.out.println("* The file already exists. Do you want to overwrite this file?");
        System.out.println("> Press y for yes and n for no: ");
    }

    // new
    public void printLoadGameMessage(){
        System.out.println("* Which of the following games do you want to load? ");
    }

    // 11/14/21:25
    public void printSaveMessage(int index, String fileName){
        System.out.println("* "+index+". "+fileName+"");
    }

    // 11/14/21:28
    public void printLoadChooseMessage(){
        System.out.println("> Please enter the number of game you want to load: ");
    }

    // new
    public void printLoadSuccessfulMessage(){
        System.out.println("* Game loaded successfully.");
    }

    // new
    public void printLoadFailMessage(){
        System.out.println("* Game load failed.");
    }

    public void printAddNewPlayerMessage(int player_id){
        System.out.println("> Now please name the player with id "+player_id+" : ");
    }

    public void printSuccessfullyAddNewPlayerMessage(int player_id, String name){
        System.out.println("* Successfully add the new player with id "+player_id+" and name "+name+"");
    }

    public void printTakeTurnMessage(int round){
        //System.out.println("\n***********************************************************************************************");
        //System.out.println("\n-----------------------------------------------------------------------------------------------");
        System.out.println("\n===============================================================================================");
        System.out.println("\n* Now it is the Round "+round+ ": ");
    }
    public void printWinnerMessage(String[] winners, int[] winnerids){
        int winner_num=winners.length;
        System.out.println("\n\n===============================================================================================");
        System.out.println("\n* The game ends!\n\n");
        if(winner_num==1){
            System.out.println("* The winner is:\n* ID: "+winnerids[0]+", Name: "+winners[0]+".\n");
            System.out.println("  ______                                                          __            __              __      __                                __ \n" +
                    " /      \\                                                        /  |          /  |            /  |    /  |                              /  |\n" +
                    "/$$$$$$  |  ______   _______    ______    ______   ______    ____$$ | __    __ $$ |  ______   _$$ |_   $$/   ______   _______    _______ $$ |\n" +
                    "$$ |  $$/  /      \\ /       \\  /      \\  /      \\ /      \\  /    $$ |/  |  /  |$$ | /      \\ / $$   |  /  | /      \\ /       \\  /       |$$ |\n" +
                    "$$ |      /$$$$$$  |$$$$$$$  |/$$$$$$  |/$$$$$$  |$$$$$$  |/$$$$$$$ |$$ |  $$ |$$ | $$$$$$  |$$$$$$/   $$ |/$$$$$$  |$$$$$$$  |/$$$$$$$/ $$ |\n" +
                    "$$ |   __ $$ |  $$ |$$ |  $$ |$$ |  $$ |$$ |  $$/ /    $$ |$$ |  $$ |$$ |  $$ |$$ | /    $$ |  $$ | __ $$ |$$ |  $$ |$$ |  $$ |$$      \\ $$/ \n" +
                    "$$ \\__/  |$$ \\__$$ |$$ |  $$ |$$ \\__$$ |$$ |     /$$$$$$$ |$$ \\__$$ |$$ \\__$$ |$$ |/$$$$$$$ |  $$ |/  |$$ |$$ \\__$$ |$$ |  $$ | $$$$$$  | __ \n" +
                    "$$    $$/ $$    $$/ $$ |  $$ |$$    $$ |$$ |     $$    $$ |$$    $$ |$$    $$/ $$ |$$    $$ |  $$  $$/ $$ |$$    $$/ $$ |  $$ |/     $$/ /  |\n" +
                    " $$$$$$/   $$$$$$/  $$/   $$/  $$$$$$$ |$$/       $$$$$$$/  $$$$$$$/  $$$$$$/  $$/  $$$$$$$/    $$$$/  $$/  $$$$$$/  $$/   $$/ $$$$$$$/  $$/ \n" +
                    "                              /  \\__$$ |                                                                                                     \n" +
                    "                              $$    $$/                                                                                                      \n" +
                    "                               $$$$$$/                                                                                                       \n");
        }
        else {
            System.out.println("* The winners are:\n");
            for (int i = 0; i < winner_num; i++) {
                System.out.println("* ID: "+winnerids[i]+", Name: "+winners[i]);
            }
            System.out.println("  ______                                                          __            __              __      __                                __ \n" +
                    " /      \\                                                        /  |          /  |            /  |    /  |                              /  |\n" +
                    "/$$$$$$  |  ______   _______    ______    ______   ______    ____$$ | __    __ $$ |  ______   _$$ |_   $$/   ______   _______    _______ $$ |\n" +
                    "$$ |  $$/  /      \\ /       \\  /      \\  /      \\ /      \\  /    $$ |/  |  /  |$$ | /      \\ / $$   |  /  | /      \\ /       \\  /       |$$ |\n" +
                    "$$ |      /$$$$$$  |$$$$$$$  |/$$$$$$  |/$$$$$$  |$$$$$$  |/$$$$$$$ |$$ |  $$ |$$ | $$$$$$  |$$$$$$/   $$ |/$$$$$$  |$$$$$$$  |/$$$$$$$/ $$ |\n" +
                    "$$ |   __ $$ |  $$ |$$ |  $$ |$$ |  $$ |$$ |  $$/ /    $$ |$$ |  $$ |$$ |  $$ |$$ | /    $$ |  $$ | __ $$ |$$ |  $$ |$$ |  $$ |$$      \\ $$/ \n" +
                    "$$ \\__/  |$$ \\__$$ |$$ |  $$ |$$ \\__$$ |$$ |     /$$$$$$$ |$$ \\__$$ |$$ \\__$$ |$$ |/$$$$$$$ |  $$ |/  |$$ |$$ \\__$$ |$$ |  $$ | $$$$$$  | __ \n" +
                    "$$    $$/ $$    $$/ $$ |  $$ |$$    $$ |$$ |     $$    $$ |$$    $$ |$$    $$/ $$ |$$    $$ |  $$  $$/ $$ |$$    $$/ $$ |  $$ |/     $$/ /  |\n" +
                    " $$$$$$/   $$$$$$/  $$/   $$/  $$$$$$$ |$$/       $$$$$$$/  $$$$$$$/  $$$$$$/  $$/  $$$$$$$/    $$$$/  $$/  $$$$$$/  $$/   $$/ $$$$$$$/  $$/ \n" +
                    "                              /  \\__$$ |                                                                                                     \n" +
                    "                              $$    $$/                                                                                                      \n" +
                    "                               $$$$$$/                                                                                                       \n");
        }
    };

    public void printWelcomeMessage() {
        System.out.println("\n\n===============================================================================================\n"+
                        "                                                                                               \n"+

                "        __       __   ______   __    __   ______   _______    ______   __    __      __ \n" +
                "       /  \\     /  | /      \\ /  \\  /  | /      \\ /       \\  /      \\ /  |  /  \\    /  |\n" +
                "       $$  \\   /$$ |/$$$$$$  |$$  \\ $$ |/$$$$$$  |$$$$$$$  |/$$$$$$  |$$ |  $$  \\  /$$/ \n" +
                "       $$$  \\ /$$$ |$$ |  $$ |$$$  \\$$ |$$ |  $$ |$$ |__$$ |$$ |  $$ |$$ |   $$  \\/$$/  \n" +
                "       $$$$  /$$$$ |$$ |  $$ |$$$$  $$ |$$ |  $$ |$$    $$/ $$ |  $$ |$$ |    $$  $$/   \n" +
                "       $$ $$ $$/$$ |$$ |  $$ |$$ $$ $$ |$$ |  $$ |$$$$$$$/  $$ |  $$ |$$ |     $$$$/    \n" +
                "       $$ |$$$/ $$ |$$ \\__$$ |$$ |$$$$ |$$ \\__$$ |$$ |      $$ \\__$$ |$$ |_____ $$ |    \n" +
                "       $$ | $/  $$ |$$    $$/ $$ | $$$ |$$    $$/ $$ |      $$    $$/ $$       |$$ |    \n" +
                "       $$/      $$/  $$$$$$/  $$/   $$/  $$$$$$/  $$/        $$$$$$/  $$$$$$$$/ $$/     \n" +
                "                                                                                        \n" +
                "                                                                                        \n" +
                "===============================================================================================\n" +
                "                                                                                        \n");
    }

    /**
     * print the players' information in the game
     * @param game
     */
    public void printPlayersPosition(Game game){
        System.out.println("Player Information:");
        PlayerView pv = new PlayerView();
        System.out.println("-----------------------------------");

        for(Player p: game.players){
            if(p.getIsOut()) continue;
            pv.printPlayerPosition(p, game.board);                //
            System.out.println("-----------------------------------");
        }
    }
}
