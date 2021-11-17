package Controller;

import Model.Dice;
import Model.JailRelatedAction;
import Model.Player;
import View.JailRelatedView;

import java.util.Scanner;

public class JailRelatedActionController {
    private JailRelatedAction j;
    private JailRelatedView jailview = new JailRelatedView();

    public JailRelatedActionController(JailRelatedAction action){
        this.j = action;
    }
    public JailRelatedActionController(){}

    public void chooseHowToGetOut(Player p){
        //1 throw double
        //2 pay fine
        jailview.printChooseMessage();
        Scanner s= new Scanner(System.in);
        int choice = s.nextInt();
        while(choice != 1 && choice !=2){
            jailview.printInvalidChoiceMessage();
            s =new Scanner(System.in);
            choice = s.nextInt();
        }
        if (choice == 1){
            j.updateInJail_R(p);
        }
        else{
            j.updateInJail_P(p);
        }
    }

    public void throwDoubleController(Player p){
        //1 throw double
        //2 pay fine
        j.updateInJail_R(p);
    }

    public int getDiceController(){
        //1 throw double
        //2 pay fine
        return j.dice.totalDice;
    }




}
