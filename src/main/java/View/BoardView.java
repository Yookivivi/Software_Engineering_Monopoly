package View;
import Model.*;

import java.io.Serializable;

public class BoardView implements Serializable {
    public int BoardLength = 15;

    /**
     * print the name in the format
     * @param name
     */
    public void printName(String name){
        System.out.print("|");
        String format = "                 ";
        int sup;
        if(name.length()%2 == 0)
            sup = 1;
        else
            sup = 0;
        int spaceLength = (BoardLength + 2 - name.length())/2;

        String output = format.substring(0,spaceLength) + name + format.substring(format.length()-spaceLength-sup,format.length());
        System.out.print(output);
    }

    public void printPosition(int position){
        String format = "|                 ";
        String input = String.valueOf(position);
        String output = format.substring(0,9) + input + format.substring(9+input.length(),format.length());
        System.out.print(output);
    }
    /**
     * print the squareName that is in the middle
     * @param s1
     * @param s2
     */
    public void printMiddleSquare(Square s1, Square s2){
        printPosition(s1.getPosition());
        System.out.print("|                                                                       ");
        printPosition(s2.getPosition());
        System.out.println("|");

        printName(s1.getName());
        System.out.print("|                                                                       ");
        printName(s2.getName());
        System.out.println("|");

        printPrice(s1);
        System.out.print("|                                                                       ");
        printPrice(s2);
        System.out.println("|");

    }

    /**
     * if the square is a LandSquare, print the price
     * Otherwise, print spaces
     * @param square
     */
    public void printPrice(Square square){
        if(square instanceof LandSquare){
            String price = "HKD "+String.valueOf(((LandSquare)square).getPrice());
            System.out.print("|");
            String format = "                 ";
            int sup;
            if(price.length()%2 == 0)
                sup = 1;
            else
                sup = 0;
            int spaceLength = (BoardLength + 2 - price.length())/2;

            String output = format.substring(0,spaceLength) + price + format.substring(format.length()-spaceLength-sup,format.length());
            System.out.print(output);
        } else{
            System.out.print("|                 ");
        }
    }

    /**
     * a function print the board
     * @param board
     */
    public void printBoard(Board board){
        // print the first row of squares(11-16)
        System.out.println("-------------------------------------------------------------------------------------------------------------");
       // System.out.println("|                 |                 |                 |                 |                 |                 |");
        for(int i = 10; i < 16; i++) {
            printPosition(i+1);
        }
        System.out.println("|");

        for(int i = 10; i < 16; i++){
           printName(board.squares[i].getName());
        }
        System.out.println("|");

        for(int i = 10; i < 16; i++){
           printPrice(board.squares[i]);
        }
        System.out.println("|");
        System.out.println("-------------------------------------------------------------------------------------------------------------");

        //print the squares in the middle (7-10), (17-20)
        for (int i = 0; i <3; i++){
            printMiddleSquare(board.squares[9-i],board.squares[16+i]);
            System.out.println("-------------------                                                                       -------------------");
        }
        printMiddleSquare(board.squares[6],board.squares[19]);

        //print the bottom squares(1-6)
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        //System.out.println("|                 |                 |                 |                 |                 |                 |");
        for(int i = 5; i >= 0; i--){
            printPosition(i+1);
        }
        System.out.println("|");

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
