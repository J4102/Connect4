public class Player
{
    //The current index of a player
    private char symbol;
    private int amtPlaced;
    private int pieceRow;
    private int pieceCol;

    public Player()
    {

    }

    public Player(char symbol)
    {
        this.symbol = symbol;
    }

    public int getPieceRow()
    {
        return pieceRow;
    }

    public int getPieceCol()
    {
        return pieceCol;
    }

    public int getAmtPlaced()
    {
        return amtPlaced;
    }

    public char getSymbol()
    {
        return symbol;
    }

    public void setSymbol(char symbol)
    {
        this.symbol = symbol;
    }

    public void setAmtPlaced(int amtPlaced) { this.amtPlaced = amtPlaced; }

    //Place player's symbol onto the specified column
    public void setPiece(Board b, int col)
    {
        pieceRow = b.getAvailRow(col);

        if(pieceRow == -1)
        {
            System.out.println("No piece was set. There is no more available row space in the column");
            return;
        }


        b.getBoard()[pieceRow][col] = symbol;
        amtPlaced++;
    }
}
