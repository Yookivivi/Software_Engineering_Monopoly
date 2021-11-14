package View;

public class GameView {
    public void printChooseModeMessage(){
        System.out.println("Welcome to Monopoly\n\n");
        System.out.println("You have 2 ways to start the game, they are:\n");
        System.out.println("1. Directly start a new game.\n");
        System.out.println("2. Load a previous version game.\n\n");
        System.out.println("Please enter your choice by number (1/2): ");
    }

    public void printInvalidChoiceMessage(){
        System.out.println("Invalid input!\n");
        System.out.println("Please enter a valid choice again: ");
    }

    public void printStartGameMessage(){
        System.out.println("\n\nPlease enter the number of players(any number from 2 to 6): \n");
        System.out.println("You have 2 ways to start the game, they are:\n");
        System.out.println("1. Directly start a new game.\n");
        System.out.println("2. Load a previous version game.\n\n");
        System.out.println("Please enter your choice by number (1/2): ");
    }

    public void printSaveGaveMessage(){
        System.out.println("Do you want to save the game now?\n");
        System.out.println("Press y for yes and n for no:");
    }
    
    // new
    public void printSaveNameMessage(){
        System.out.println("Please enter the file name: ");
    }

    // new
    public void printSaveSuccessfullyMessage(){
        System.out.println("Game saved successfully.\n");
    }

    // new
    public void printSaveFailMessage(){
        System.out.println("Game save failed.\n");
    }

    // new
    public void printLoadGameMessage(){
        System.out.println("Please enter the path of game file you want to load: ");
    }

    // 11/14/21:25
    public void printSaveMessage(int index, String fileName){
        System.out.println(index+". "+fileName+"\n");
    }
    
    // 11/14/21:28
    public void printLoadChooseMessage(){
        System.out.println("Please enter the number of game you want to load: ");
    }

    // new
    public void printLoadSuccessfulMessage(){
        System.out.println("Game loaded successfully.\n");
    }

    // new
    public void printLoadFailMessage(){
        System.out.println("Game load failed.\n");
    }

    public void printAddNewPlayerMessage(int player_id){
        System.out.println("Now please name the player with id "+player_id+" : ");
    }

    public void printSuccessfullyAddNewPlayerMessage(int player_id, String name){
        System.out.println("Successfully add the new player with id "+player_id+" and name "+name+"\n\n");
    }

    public void printTakeTurnMessage(int round, int player_id, String name){
        System.out.println("\n\nNow it is the Round "+round+ ": \n");
        System.out.println("It is id "+player_id+", name "+name+": \n");
    }
    public void printWinnerMessage(String[] winners, int[] winnerids){
        int winner_num=winners.length;
        if(winner_num==1){
            System.out.println("\n\nThe winner is:\nID: "+winnerids[0]+", Name: "+winners[0]+". \nCongratulations!!!\n\n");
        }
        else {
            System.out.println("\n\nThe winners are:\n");
            for (int i = 0; i < winner_num; i++) {
                System.out.println("ID: "+winnerids[i]+", Name: "+winners[i]+"\n");
            }
            System.out.println("Congratulations!!!\n\n");
        }
    };
}
