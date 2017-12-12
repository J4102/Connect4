public class Board
{
    private final String[][] board =  new String[6][7];
    private final String boardSymbol = "O";
    private int speed;
    private boolean animation;
    private int fontSize;;


    public Board()
    {
        for(int row = 0; row < board.length; row++)
        {
            for(int col = 0; col < board[row].length; col++)
            {
                board[row][col] = boardSymbol;
            }
        }
        animation = false;
        fontSize = 1;
        speed = 0;
    }

    public Board(int speed, boolean showAnimation, int fontSize)
    {
        this.speed = speed;
        this.animation = showAnimation;
        this.fontSize = fontSize;
    }


    public Board(Board boardObj)
    {
        this.speed = boardObj.speed;
        this.animation = boardObj.animation;
        this.fontSize = boardObj.fontSize;

    }

    public int getSpeed()
    {
        return speed;
    }

    public boolean getAnimation()
    {
        return animation;
    }

    public int getFontSize()
    {
        return fontSize;
    }

    public String[][] getBoard()
    {
        return board;
    }

    public void setSpeed(int speed)
    {
        this.speed = speed;
    }

    public void setAnimation(boolean animation)
    {
        this.animation = animation;
    }

    public void setFontSize(int fontSize)
    {
        this.fontSize = fontSize;
    }

    public void updateBoard(Player p1, Player p2)
    {
        //Print out only the rows that have been changed
        //Obtain p1's row and p2's row and then update that by printing it out
    }

    public void rollDown(Player p, int col)
    {
        //Loop down column until a symbol
    }


}
