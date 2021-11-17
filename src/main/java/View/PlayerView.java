package View;
import Model.*;
public class PlayerView {

    public void printPlayerTurnMessage(int player_id, String name){
        System.out.println("* Now it is the turn of player with ID "+player_id+", Name "+name+": \n");
    }

    public void printInJailMessage(int inJailRound){
        System.out.println("\n* Now you are in Jail, Round: "+inJailRound);
    }

    public void printDiceMessage(int dice1, int dice2, int totalDice){
        System.out.println("* Dice1: "+dice1);
        System.out.println("* Dice2: "+dice2);
        System.out.println("* Total: "+totalDice);
    }

    public void printUpdatedSquareMessage(int position, String name){
        System.out.println("\n* Now you are in the position: "+String.valueOf(position));
        System.out.println("* This Square is "+name);
    }

    /**
     * to print information in the format of "｜                      ｜"
     * @param input
     */
    public void replacePrint(String input){
        String format = "｜                                ｜";
        String output = format.substring(0,4) + input + format.substring(4+input.length(),format.length());
        System.out.println(output);
    }

    /**
     * to print information of a player
     * @param p
     * @param board
     */
    public void printPlayerPosition(Player p, Board board){
        replacePrint("Player " + p.getId() + ": "+ p.getName());
        replacePrint("Money: "+ p.getMoney());
        replacePrint("Location: " + String.valueOf(p.getPosition()) + " ("+board.squares[p.getPosition()].getName()+")");
    }
}
