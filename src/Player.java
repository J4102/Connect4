public class Player
{
    //The current index of a player
    private char symbol;
    private int amtPlaced;
    private int curPieceRow;
    private int curPieceCol;

    public Player()
    {

    }

    public Player(char symbol)
    {
        this.symbol = symbol;
    }

    public int getCurPieceRow()
    {
        return curPieceRow;
    }

    public int getCurPieceCol()
    {
        return curPieceCol;
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

    public void setAmtPlaced(int amtPlaced)
    {
        this.amtPlaced = amtPlaced;
    }

    //Place player's symbol onto the specified column
    //Return's false if setting the piece failed
    public void setPiece(Board board, int col)
    {

        curPieceRow = board.getAvailRow(col);

        board.getBoard()[curPieceRow][col] = symbol;

        amtPlaced++;
        board.getAvailRowsInColumn()[col]--;

    }

    public boolean isValidCol(Board board, int col)
    {
        return (col<= board.getBoard()[0].length || col > 0) && board.getAvailRow(col) != -1;
    }

    public boolean hasWon(Board board)
    {

        return false;
    }
}
