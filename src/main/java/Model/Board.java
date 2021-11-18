package Model;

import java.io.Serializable;

/**
 * This class is for game board implementation
 */

public class Board implements Serializable{
    public Square[] squares; // the square array in the Board

    /**
     * the constructor of the class Board
     */
    public Board(){
        //initialize the board
        squares = new Square[20];
        squares[0] = new Go(1);
        squares[1] = new LandSquare("CENTRAL", 800, 90,2);
        squares[2] = new LandSquare("Wan Chai", 700, 65,3);
        squares[3] = new IncomeTax(4);
        squares[4] = new LandSquare("Stanley", 600, 60,5);
        squares[5] = new InJail(6);
        squares[6] = new LandSquare("Shek O", 400, 10,7);
        squares[7] = new LandSquare("Mong Kok", 500, 40,8);
        squares[8] = new Chance(9);
        squares[9] = new LandSquare("Tsing Yi", 400, 15,10);
        squares[10] = new FreeParking(11);
        squares[11] = new LandSquare("Shatin", 700,75,12);
        squares[12] = new Chance(13);
        squares[13] = new LandSquare("Tuen Mum", 400, 20,14);
        squares[14] = new LandSquare("Tai Po", 500, 25,15);
        squares[15] = new GotoJail(16);
        squares[16] = new LandSquare("Sai Kung", 400, 10,17);
        squares[17] = new LandSquare("Yuen Long", 400, 25,18);
        squares[18] = new Chance(19);
        squares[19] = new LandSquare("Tai O", 600, 25, 20);
    };
}
