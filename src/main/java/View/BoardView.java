package View;
import Model.*;

public class BoardView {
    public int BoardLength = 15;
    public void printName(String name){
        System.out.print("| "+name);
        for(int j = name.length(); j <= BoardLength; j++)
            System.out.print(" ");
    }
    public void printMiddleSquare(String s1, String s2){
        System.out.println("|                 |                                                                       |                 |");

        printName(s1);
        System.out.print("|                                                                       ");
        printName(s2);
        System.out.println("|");
        System.out.println("|                 |                                                                       |                 |");
    }
    public void printBoard(Board board){
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println("|                 |                 |                 |                 |                 |                 |");
        for(int i = 10; i < 16; i++){
           printName(board.squares[i].getName());
        }
        System.out.println("|");
        System.out.println("|                 |                 |                 |                 |                 |                 |");
        System.out.println("-------------------------------------------------------------------------------------------------------------");

        for (int i = 0; i <3; i++){
            printMiddleSquare(board.squares[9-i].getName(),board.squares[16+i].getName());
            System.out.println("-------------------                                                                       -------------------");
        }
        printMiddleSquare(board.squares[6].getName(),board.squares[19].getName());

        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println("|                 |                 |                 |                 |                 |                 |");
        for(int i = 5; i >= 0; i--){
            printName(board.squares[i].getName());
        }
        System.out.println("|");
        System.out.println("|  /JUST VISITING |                 |                 |                 |                 |                 |");
        System.out.println("-------------------------------------------------------------------------------------------------------------");


    }
}
