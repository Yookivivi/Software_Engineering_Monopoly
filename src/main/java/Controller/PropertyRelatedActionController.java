package Controller;


import Model.LandSquare;
import Model.Player;
import Model.PropertyRelatedAction;
import View.PropertyRelatedView;

import java.util.Scanner;

/**
 * This class is the controller for property related action(buy land)
 */

public class PropertyRelatedActionController {
    private PropertyRelatedAction propertyRelatedAction;
    private PropertyRelatedView propertyView = new PropertyRelatedView();
    private Player player;

    /**
     * Constructor for PropertyRelatedActionController
     * @param player action related player
     */
    public PropertyRelatedActionController(Player player){
        this.player=player;
        this.propertyRelatedAction = new PropertyRelatedAction(this.player);
    }
    //public PropertyRelatedActionController(){}

    /**
     * controller for buy land operations
     * @param landSquare landSquare to be manipulated on
     */
    public void choosebuyland(LandSquare landSquare){
        if(player.getMoney() < landSquare.getPrice()){
            propertyView.printNoMoneyMessage();
        }
        else {
            propertyView.printChooseBuyMessage(landSquare);
            Scanner s = new Scanner(System.in);
            String input = s.nextLine();
            while (!input.equals("Y") && !input.equals("N")) {
                propertyView.printInvalidChoiceMessage();
                s = new Scanner(System.in);
                input = s.nextLine();
            }
            if (input.equals("Y")) {
                propertyRelatedAction.buyland(player, landSquare);
                propertyView.printBuyMessage(landSquare);
            } else {
                propertyView.printNotBuyMessage();
            }
        }
    }
}
