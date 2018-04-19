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
    //pieceRow doesn't need to be checked if out of bounds because this is done with the avail method in the driver class
    public void setPiece(Board b, int col)
    {
        //subtract 1 from available rows from column
        b.getAvailRowsInColumn()[col]--;

        pieceRow = b.getAvailRow(col);

        b.getBoard()[pieceRow][col] = symbol;
        amtPlaced++;
    }
}
