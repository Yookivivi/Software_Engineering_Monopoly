package Controller;

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

    public int chooseHowToGetOut(){
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
        return choice;
    }

    //?????
    public void chooseResult(Player p, int choice){
        if (choice == 1){
            j.updateInJail_R(p);
        }
        else{
            j.updateInJail_P(p);
        }
    }


}
