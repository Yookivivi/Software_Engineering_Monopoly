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
        //if the player does not have enough money to buy the land
        if(player.getMoney() < landSquare.getPrice()){
            propertyView.printNoMoneyMessage();
        }
        else {
            propertyView.printChooseBuyMessage(landSquare);
            Scanner s = new Scanner(System.in);
            String input = s.nextLine();
            //invalid input
            while (!input.equals("Y") && !input.equals("N")) {
                propertyView.printInvalidChoiceMessage();
                s = new Scanner(System.in);
                input = s.nextLine();
            }
            //player choose to buy land
            if (input.equals("Y")) {
                propertyRelatedAction.buyland(player, landSquare);
                propertyView.printBuyMessage(landSquare);
            }
            //player choose not to buy land
            else {
                propertyView.printNotBuyMessage();
            }
        }
    }
}
