package Controller;

import Model.Dice;
import Model.JailRelatedAction;
import Model.Player;
import View.JailRelatedView;

import java.util.Scanner;

/**
 * This class is the controller for jail related actions
 */

public class JailRelatedActionController {
    private JailRelatedAction j;
    private JailRelatedView jailView = new JailRelatedView();
    private Player p;
    public int choice;

    /**
     * Constructor for JailRelatedActionController
     * @param player action related player
     */
    public JailRelatedActionController(Player player){
        this.p=player;
        this.j=new JailRelatedAction(player);
    }

    /**
     * controller for getting out of jail action
     */
    public void chooseHowToGetOut(){
        // 1 throw double
        // 2 pay fine
        jailView.printChooseMessage();
        Scanner s= new Scanner(System.in);
        choice = s.nextInt();
        while(choice != 1 && choice !=2){ // invalid input
            jailView.printInvalidChoiceMessage();
            s =new Scanner(System.in);
            choice = s.nextInt();
        }
        if (choice == 1){ // roll double
            jailView.printTrowDoubleMessage(p.getName());
            jailView.printDiceMessage(j.dice.dice1, j.dice.dice2, j.dice.totalDice);
            j.updateInJail_R(p);
        }
        else{ // pay fine
            jailView.printPayFeeMessage(p.getName());
            j.updateInJail_P(p);
        }
    }

}
