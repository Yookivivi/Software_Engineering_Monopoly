package Controller;


import Model.LandSquare;
import Model.Player;
import Model.PropertyRelatedAction;
import View.PropertyRelatedView;

import java.util.Scanner;

public class PropertyRelatedActionController {
    private PropertyRelatedAction propertyRelatedAction;
    private PropertyRelatedView propertyview = new PropertyRelatedView();

    public PropertyRelatedActionController(PropertyRelatedAction action){
        this.propertyRelatedAction = action;
    }
    public PropertyRelatedActionController(){}

    public String choosebuyland(LandSquare landSquare){
        propertyview.printChooseBuyMessage(landSquare);
        Scanner s = new Scanner(System.in);
        String input = s.toString();
        while(!input.equals("Y")&& !input.equals("N")){
            propertyview.printInvalidChoiceMessage();
            s = new Scanner(System.in);
            input = s.toString();
        }
        return input;
    }

    public void chooseResult(Player p, String input,LandSquare landSquare){
        if (input.equals("Y")){
            propertyRelatedAction.buyland(p,landSquare);
        }
        else{
            propertyview.printNotBuyMessage();
        }
    }
}
