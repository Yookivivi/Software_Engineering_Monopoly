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

    public JailRelatedActionController(JailRelatedAction action){
        this.j = action;
    }
    public JailRelatedActionController(Player player){
        this.p=player;
        this.j=new JailRelatedAction(player);
    }

    public void chooseHowToGetOut(){
        //1 throw double
        //2 pay fine
        //jailview.printRoundMessage(p.getInJailRound());
        jailview.printChooseMessage();
        Scanner s= new Scanner(System.in);
        choice = s.nextInt();
        while(choice != 1 && choice !=2){
            jailview.printInvalidChoiceMessage();
            s =new Scanner(System.in);
            choice = s.nextInt();
        }
        if (choice == 1){
            jailview.printTrowDoubleMessage(p.getName());
            j.updateInJail_R(p);
            jailview.printDiceMessage(j.dice.dice1, j.dice.dice2, j.dice.totalDice);
            if(j.getrollDouble()){
                jailview.printSuccessThrowDoubleMessage(p.getName());
                //j.updatePosition(p,p.getPosition()+j.dice.totalDice);
            }
            else{
                jailview.printFailThrowDoubleMessage(p.getName());
            }
        }
        else{
            jailview.printPayFeeMessage(p.getName());
            j.updateInJail_P(p);
        }
    }

    public void throwDoubleController(Player p){
        //1 throw double
        //2 pay fine
        j.updateInJail_R(p);
        if(j.getrollDouble()){
            jailview.printSuccessThrowDoubleMessage(p.getName());
        }
        else{
            jailview.printFailThrowDoubleMessage(p.getName());
        }
    }

    public int getDiceController(){
        //1 throw double
        //2 pay fine
        return j.dice.totalDice;
    }




}
