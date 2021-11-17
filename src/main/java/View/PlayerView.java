package View;

public class PlayerView {

    public void printPlayerTurnMessage(int player_id, String name){
        System.out.println("\n* Now it is the turn of player with ID "+player_id+", Name "+name+": \n");
    }

    public void printInJailMessage(int inJailRound){
        System.out.println("\n* Now you are in Jail, Round: "+inJailRound);
    }

    public void printDiceMessage(int dice1, int dice2, int totalDice){
        System.out.println("\n* Dice1: "+dice1);
        System.out.println("* Dice2: "+dice2);
        System.out.println("* Total: "+totalDice+"\n");
    }

    public void printUpdatedSquareMessage(int position, String name){
        System.out.println("\n* Now you are in the position: "+position);
        System.out.println("\n* This Square is "+name);
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
