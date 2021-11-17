package View;

public class JailRelatedView {
    public void printChooseMessage(){
        System.out.println("You are in jail now\n\n");
        System.out.println("You have 2 ways to get out of jail.\n");
        System.out.println("1. Throw doubles(both dice coming out the same face up) on next three turns.\n");
        System.out.println("2. Pay a dine of HKD 150 and get out right now.\n\n");
        System.out.println("Please enter your choice by number (1/2): ");
    }
    public void printInvalidChoiceMessage(){
        System.out.println("Invalid input!\n");
        System.out.println("Please enter a valid choice again: ");
    }

    }
