/**
 * @author J4102
 * @author www.github.com
 * @version 1.0
 */
public class Board
{
    private final char[][] board =  new char[6][7];

    //values in each index increment by 1 every time player makes a move

    private final int[] availRowsInColumn = new int[6];

    //Needs to be string for future "font sizes";

    private char symbol;
    private int speed;
    private int totalPieces;

    //Instance initializer, this code is copied to every constructor!
    //Initializes board array with filled indexes
    //Fill up availRowsInColsList array all to 6 (starting position of all pieces)
    {
        for(int row = 0; row < board.length; row++)
        {
            for(int col = 0; col < board[row].length; col++)
            {
                board[row][col] = symbol;
            }
        }

        for(int i = 0; i < availRowsInColumn.length; i++)
        {
            availRowsInColumn[i] = 6;
        }
    }

    /** Default constructor - symbol set to letter O and speed set to number 0
     *
     */
    public Board()
    {
        symbol = 'O';
        speed = 0;
    }

    /**
     *
     * @param speed Speed of animation
     * @param symbol Symbol of player's piece
     */
    public Board(int speed, char symbol)
    {

        this.speed = speed;
        this.symbol = symbol;
    }

    //Copy constructor
    public Board(Board boardObj)
    {
        this.symbol = boardObj.symbol;
        this.speed = boardObj.speed;
    }

    //Return board symbol
    public char getSymbol()
    {
        return symbol;
    }

    //Return speed of animation (0 by default)

    public int getSpeed()
    {
        return speed;
    }

    //Return total pieces of both player's amount placed added together
    public int getTotalMoves()
    {
        return totalPieces;
    }

    //Return the largest index of an available row - there could be a better algorithm for this
    //Create another array that stores which indexes are filled up
    //So int array = new int[6];
    //Index location designates which column
    //Index value represents how many x positions board has to go up.
        //
    public int getAvailRow(int col)
    {
        return availRowsInColumn[col];
    }


    //Returns the actual board
    public char[][] getBoard()
    {
        return board;
    }

    public int[] getAvailRowsInColumn() { return availRowsInColumn; }

    //Sets speed of animation
    public void setSpeed(int speed)
    {
        this.speed = speed;
    }

    //Sets the slot symbols of the board
    public void setSymbol(char symbol)
    {
        this.symbol = symbol;
    }

    public void setTotalMoves(int totalPieces)
    {
        this.totalPieces = totalPieces;
    }

    //Updates board visually (just print out all the board elements)
    public void updateBoard()
    {
        for(int row = 0; row < board.length; row++)
        {
            for(int col = 0; col < board[row].length; col++)
            {
                System.out.println(board[row][col]);
            }
        }
    }

    //Returns if the board is full
    public boolean isFull()
    {
        return totalPieces == 42;
    }
}
