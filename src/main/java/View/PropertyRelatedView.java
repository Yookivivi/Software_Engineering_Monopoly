package View;

import Model.LandSquare;

public class PropertyRelatedView {
    public void printChooseBuyMessage(LandSquare landSquare){
        System.out.println("Wow!You land on an unowned land square\n\n");
        System.out.println("The price of "+landSquare.getName()+" is "+landSquare.getPrice()+" .\n");
        System.out.println("The rent of "+landSquare.getName()+" is "+landSquare.getRent()+" .\n");
        System.out.println("Do you want to buy it?\n");
        System.out.println("Please enter your choice by (Y/N) (Y for Yes and N for No): \n");
    }


    public void printInvalidChoiceMessage(){
        System.out.println("* Invalid input!\n");
        System.out.println("> Please enter a valid choice again: ");
    }

    public void printNotBuyMessage(){
        System.out.println("OK! Thank you! Good Luck!");
    }

}
