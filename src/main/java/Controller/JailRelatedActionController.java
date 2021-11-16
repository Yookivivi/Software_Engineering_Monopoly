package Controller;

import Model.JailRelatedAction;
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
}
