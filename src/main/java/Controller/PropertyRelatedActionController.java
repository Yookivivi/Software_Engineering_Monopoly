package Controller;


import Model.LandSquare;
import Model.Player;
import Model.PropertyRelatedAction;
import View.PropertyRelatedView;

import java.util.Scanner;

public class PropertyRelatedActionController {
    private PropertyRelatedAction propertyRelatedAction;
    private PropertyRelatedView propertyview = new PropertyRelatedView();
    private Player player;

    public PropertyRelatedActionController(Player player){
        this.player=player;
        this.propertyRelatedAction = new PropertyRelatedAction(this.player);
    }
    //public PropertyRelatedActionController(){}

    public void choosebuyland(LandSquare landSquare){
        propertyview.printChooseBuyMessage(landSquare);
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        while(!input.equals("Y")&& !input.equals("N")){
            propertyview.printInvalidChoiceMessage();
            s = new Scanner(System.in);
            input = s.nextLine();
        }
        if (input.equals("Y")){
            propertyRelatedAction.buyland(player,landSquare);
        }
        else{
            propertyview.printNotBuyMessage();
        }

    }

}
