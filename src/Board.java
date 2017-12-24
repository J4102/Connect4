public class Board
{
    private final char[][] board =  new char[6][7];

    //Needs to be string for future "font sizes";

    private char symbol;
    private int speed;
    private boolean allowAnimations;
    private int totalPieces;

    //Instance initializer, this code is copied to every constructor!
    {
        for(int row = 0; row < board.length; row++)
        {
            for(int col = 0; col < board[row].length; col++)
            {
                board[row][col] = symbol;
            }
        }
    }

    //Default constructor
    public Board()
    {
        symbol = 'O';
        allowAnimations = false;
        speed = 0;
    }

    //Normal Constructor
    public Board(int speed, boolean showAnimation, char symbol)
    {

        this.speed = speed;
        this.allowAnimations = showAnimation;
        this.symbol = symbol;
    }

    //Copy constructor
    public Board(Board boardObj)
    {
        this.symbol = boardObj.symbol;
        this.speed = boardObj.speed;
        this.allowAnimations = boardObj.allowAnimations;

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
    public int getTotalPieces()
    {
        return totalPieces;
    }

    //Return if animations are allowed
    public boolean getAllowAnimations()
    {
        return allowAnimations;
    }

    //Return the largest index of an available row
    public int getAvailRow(int col)
    {
        int row = 0;

        //If there is now available row in the column
        if(!(board[0][col] == symbol)) return -1;

        for(int i = 1; i < board.length; i++)
        {
            if(!(board[i][col] == symbol))
            {
                row = i;
                continue;
            }

            break;
        }

        return row;
    }


    //Returns the actual board
    public char[][] getBoard()
    {
        return board;
    }

    //Sets speed of animation
    public void setSpeed(int speed)
    {
        this.speed = speed;
    }

    //Sets if animations are allowed
    public void setAllowAnimations(boolean allowAnimations)
    {
        this.allowAnimations = allowAnimations;
    }

    //Sets the slot symbols of the board
    public void setSymbol(char symbol)
    {
        this.symbol = symbol;
    }

    //Updates board visually and increments number of pieces by 2
    public void updateBoard(Player player)
    {

    }

    //Returns if the board is full (if the totalPieces add to 42)
    public boolean isFull()
    {
        return totalPieces == 42;
    }
}
