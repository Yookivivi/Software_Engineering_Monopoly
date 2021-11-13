public class Board {
    public Square[] squares;

    /**
     * the constructor of the class Board
     */
    public Board(){
        //initialize the board
        squares = new Square[20];
        squares[0] = new Go();
        squares[1] = new LandSquare("CENTRAL", 800, 90);
        squares[2] = new LandSquare("Wan Chai", 700, 65);
        squares[3] = new IncomeTax();
        squares[4] = new LandSquare("Stanley", 600, 60);
        squares[5] = new InJail();
        squares[6] = new LandSquare("Shek O", 400, 10);
        squares[7] = new LandSquare("Mong Kok", 500, 40);
        squares[8] = new Chance();
        squares[9] = new LandSquare("Tsing Yi", 400, 15);
        squares[10] = new FreeParking();
        squares[11] = new LandSquare("Shatin", 700,75);
        squares[12] = new Chance();
        squares[13] = new LandSquare("Tuen Mum", 400, 20);
        squares[14] = new LandSquare("Tai Po", 500, 25);
        squares[15] = new GotoJail();
        squares[16] = new LandSquare("Sai Kung", 400, 10);
        squares[17] = new LandSquare("Yuen Long", 400, 25);
        squares[18] = new Chance();
        squares[19] = new LandSquare("Tai O", 600, 25);
    };
    public void printBoard(){}; //print the board
}
