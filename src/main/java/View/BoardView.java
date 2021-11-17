package View;
import Model.*;

public class BoardView {
    public int BoardLength = 15;
    public void printName(String name){
        System.out.print("| "+name);
        for(int j = name.length(); j <= BoardLength; j++)
            System.out.print(" ");
    }

    public void printMiddleSquare(Square s1, Square s2){
        System.out.println("|                 |                                                                       |                 |");

        printName(s1.getName());
        System.out.print("|                                                                       ");
        printName(s2.getName());
        System.out.println("|");

        printPrice(s1);
        System.out.print("|                                                                       ");
        printPrice(s2);
        System.out.println("|");

    }

    public void printPrice(Square square){
        if(square instanceof LandSquare){
            int price = ((LandSquare)square).getPrice();
            System.out.print("| HKD "+price);
            for(int j = String.valueOf(price).length(); j <= BoardLength-4; j++)
                System.out.print(" ");
        } else{
            System.out.print("|                 ");
        }
    }

    public void printBoard(Board board){
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println("|                 |                 |                 |                 |                 |                 |");
        for(int i = 10; i < 16; i++){
           printName(board.squares[i].getName());
        }
        System.out.println("|");

        for(int i = 10; i < 16; i++){
           printPrice(board.squares[i]);
        }
        System.out.println("|");
       // System.out.println("|                 |                 |                 |                 |                 |                 |");
        System.out.println("-------------------------------------------------------------------------------------------------------------");

        for (int i = 0; i <3; i++){
            printMiddleSquare(board.squares[9-i],board.squares[16+i]);
            System.out.println("-------------------                                                                       -------------------");
        }
        printMiddleSquare(board.squares[6],board.squares[19]);

        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println("|                 |                 |                 |                 |                 |                 |");
        for(int i = 5; i >= 0; i--){
            printName(board.squares[i].getName());
        }
        System.out.println("|");
        System.out.print("|  /JUST VISITING ");

        for(int i = 4; i >= 0; i--){
            printPrice(board.squares[i]);
        }
        System.out.println("|");

        System.out.println("-------------------------------------------------------------------------------------------------------------");


    }
}
