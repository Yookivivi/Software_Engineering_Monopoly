package View;

import Model.LandSquare;

/**
 * This class is for printing property related messages
 */

public class PropertyRelatedView {
    /**
     * print choose whether to buy land or not messages
     * @param landSquare land square to be bought
     */
    public void printChooseBuyMessage(LandSquare landSquare){
        System.out.println("\n* Wow! You land on an unowned land square:" +landSquare.getName());
        System.out.println("* The price of "+landSquare.getName()+" is "+landSquare.getPrice()+".");
        System.out.println("* The rent of "+landSquare.getName()+" is "+landSquare.getRent()+".");
        System.out.println("* Do you want to buy it?");
        System.out.println("> Please enter your choice by (Y/N) (Y for Yes and N for No): ");
    }
    public void printInvalidChoiceMessage(){
        System.out.println("* Invalid input!");
        System.out.println("> Please enter a valid choice again: ");
    }
    public void printBuyMessage(LandSquare landSquare){
        System.out.println("* Success! "+landSquare.getName()+" is your now!");
    }
    public void printNotBuyMessage(){
        System.out.println("* OK! Thank you! Good Luck!");
    }
    public void printNoMoneyMessage(){
        System.out.println("* Sorry! You don't have enough money to buy.");
    }
}
