package View;

import Model.Player;

public class PlayerView {

    public void printPlayerTurnMessage(int player_id, String name){
        System.out.println("\n-----------------------------------------------------------------------------------------------");
        System.out.println("\n* Now it is the turn of player with ID "+player_id+", Name "+name+": \n");
    }

    public void printInJailMessage(int inJailRound){
        System.out.println("\n* Now you are in Jail, Round: "+inJailRound);
    }

    public void printDiceMessage(int dice1, int dice2, int totalDice,Player player){
        System.out.println("\n*Now "+player.getName()+" is rolling the dice");
        System.out.println("\n+--------------+\n"+
                              "|  Dice1: " + dice1 +"    |\n"+
                              "|  Dice2: " + dice2 +"    |\n"+
                              "+--------------+\n"+
                              "|  Total: " + totalDice+ "    |\n"+
                              "+--------------+\n");
    }

    public void printUpdatedSquareMessage(int position, String name){
        System.out.println("\n* Now you are in the position: "+position);
        System.out.println("* This Square is "+name+"\n");
    }

    public void printThrowDoubleTrueMessage(){
        System.out.println("\n* Congratulations!");
        System.out.println("* You successfully throw double!");
        System.out.println("* You go out of the jail.");
    }

    public void printThrowDoubleFalseMessage(){
        System.out.println("\n* Oh no");
        System.out.println("* You fail to throw double!");
    }
}
