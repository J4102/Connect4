/**
 * @author J4102
 * @author www.github.com
 * @version 1.0
 */
public class Board
{
    //1 2 3 4 5 6 7
    private final char[][] board =  new char[6][7];

    //Array to keep track of each index increment that changes by 1 every time player makes a move
    private final int[] availRowsInColumn = new int[7];

    private char symbol;
    private int speed;
    private int totalPieces;

    public Board()
    {
        symbol = 'O';
        speed = 0;

        for(int row = 0; row < board.length; row++)
        {
            for(int col = 0; col < board[row].length; col++)
            {
                board[row][col] = symbol;
            }

        }

        for(int i = 0; i < availRowsInColumn.length; i++)
        {
            availRowsInColumn[i] = 5;
        }
    }

    public Board(char symbol)
    {
        this.symbol = symbol;
        speed = 0;

        for(int row = 0; row < board.length; row++)
        {
            for(int col = 0; col < board[row].length; col++)
            {
                board[row][col] = symbol;
            }

        }

        for(int i = 0; i < availRowsInColumn.length; i++)
        {
            availRowsInColumn[i] = 5;
        }

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

    //Updates board visually (just print out all the board elements)
    public void printBoard()
    {
        for(int row = 0; row < board.length; row++)
        {
            System.out.print("|");
            for(int col = 0; col < board[row].length; col++)
            {
                System.out.print(board[row][col] + "|");
            }

            System.out.println();
            System.out.println("---------------");
        }
    }
    //Returns if the board is full
    public boolean isFull()
    {
        return totalPieces == 42;
    }

    //Prints winning statistics for winning player
    public void printWin(Player p)
    {
        printBoard();
        System.out.println("Player 2 has won!");
        System.out.println("Amount of moves placed: " + p.getAmtPlaced());
        System.out.println("Winning move: " + p.toString());
    }

    public void clearBoard()
    {
        for (int row = 0; row < board.length; row++)
        {
            for (int col = 0; col < board[row].length; col++)
            {
                board[row][col] = symbol;
            }
        }

        for(int i = 0; i < availRowsInColumn.length; i++)
        {
            availRowsInColumn[i] = 5;
        }
    }
}
