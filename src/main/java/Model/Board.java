package Model;

import java.io.Serializable;

public class Board implements Serializable{
    public Square[] squares;

    /**
     * the constructor of the class Board
     */
    public Board(){
        //initialize the board
        squares = new Square[20];
        squares[0] = new Go(0);
        squares[1] = new LandSquare("CENTRAL", 800, 90,1);
        squares[2] = new LandSquare("Wan Chai", 700, 65,2);
        squares[3] = new IncomeTax(3);
        squares[4] = new LandSquare("Stanley", 600, 60,4);
        squares[5] = new InJail(5);
        squares[6] = new LandSquare("Shek O", 400, 10,6);
        squares[7] = new LandSquare("Mong Kok", 500, 40,7);
        squares[8] = new Chance(8);
        squares[9] = new LandSquare("Tsing Yi", 400, 15,9);
        squares[10] = new FreeParking(10);
        squares[11] = new LandSquare("Shatin", 700,75,11);
        squares[12] = new Chance(12);
        squares[13] = new LandSquare("Tuen Mum", 400, 20,13);
        squares[14] = new LandSquare("Tai Po", 500, 25,14);
        squares[15] = new GotoJail(15);
        squares[16] = new LandSquare("Sai Kung", 400, 10,16);
        squares[17] = new LandSquare("Yuen Long", 400, 25,17);
        squares[18] = new Chance(18);
        squares[19] = new LandSquare("Tai O", 600, 25, 19);
    };
    public void printBoard(){}; //print the board
}
