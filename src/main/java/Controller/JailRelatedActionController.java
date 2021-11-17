package Controller;

import Model.Dice;
import Model.JailRelatedAction;
import Model.Player;
import View.JailRelatedView;

import java.util.Scanner;

public class JailRelatedActionController {
    private JailRelatedAction j;
    private JailRelatedView jailview = new JailRelatedView();
    private Player p;
    public int choice;

    public JailRelatedActionController(Player player){
        this.p=player;
        this.j=new JailRelatedAction(player);
    }

    public void chooseHowToGetOut(){
        //1 throw double
        //2 pay fine
        jailview.printChooseMessage();
        Scanner s= new Scanner(System.in);
        choice = s.nextInt();
        while(choice != 1 && choice !=2){//invalid input
            jailview.printInvalidChoiceMessage();
            s =new Scanner(System.in);
            choice = s.nextInt();
        }
        if (choice == 1){//roll double
            jailview.printTrowDoubleMessage(p.getName());
            j.updateInJail_R(p);
            jailview.printDiceMessage(j.dice.dice1, j.dice.dice2, j.dice.totalDice);
            if(j.getrollDouble()){//successfully roll double
                jailview.printSuccessThrowDoubleMessage(p.getName());
                //j.updatePosition(p,p.getPosition()+j.dice.totalDice);
            }
            else{//fail to roll double
                jailview.printFailThrowDoubleMessage(p.getName());
            }
        }
        else{// pay fee
            jailview.printPayFeeMessage(p.getName());
            j.updateInJail_P(p);
        }
    }

}
