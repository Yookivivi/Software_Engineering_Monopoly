package View;

public class JailRelatedView {
    /*public void printRoundMessage(int round){
        System.out.println("\n*In Jail Round "+round+"\n");
        //System.out.println("> Please enter a valid choice again: ");
    }*/
    public void printChooseMessage(){
        System.out.println("* You are in jail now!");
        System.out.println("* You have 2 ways to get out of jail.");
        System.out.println("* 1. Throw doubles");
        System.out.println("* 2. Pay a fine of HKD 150 and get out right now");
        System.out.println("> Please enter your choice by number (1/2): ");
    }
    public void printInvalidChoiceMessage(){
        System.out.println("* Invalid input!\n");
        System.out.println("> Please enter a valid choice again: ");
    }
    public void printTrowDoubleMessage(String name){
        System.out.println("* "+name+" chooses to throw double");
        System.out.println("* Now throw the dice\n ");
    }
    public void printPayFeeMessage(String name){
        System.out.println("* "+name+" pays HKD 150");
        System.out.println("* "+ name+" goes out of the jail\n");
    }
    public void printDiceMessage(int dice1, int dice2, int totalDice){
        System.out.println("* Dice1: "+dice1);
        System.out.println("* Dice2: "+dice2);
        System.out.println("* Total: "+totalDice);
    }
    public void printSuccessThrowDoubleMessage(String name){
        System.out.println("\n* "+name+" successfully throw double");
        System.out.println("* "+ name+" goes out of the jail\n");
    }

    public void printFailThrowDoubleMessage(String name){
        System.out.println("\n* "+name+" fail to throw double");
    }
}
