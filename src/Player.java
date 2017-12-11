public class Player
{

    //The current index of a player
    private Index curPiece;
    private char symbol;

    public Player()
    {

    }

    public Player(char symbol)
    {
        this.symbol = symbol;
    }

    public Index getCurPiece()
    {
        return curPiece;
    }

    public char getSymbol()
    {
        return symbol;
    }

    public void setSymbol(char symbol)
    {
        this.symbol = symbol;
    }


    public void setIndexPos(int row, int col)
    {
        curPiece.row = row;
        curPiece.col = col;
    }

    //Represents an index of a piece
    private class Index
    {
        private int col;
        private int row;

        public Index(int col, int row)
        {
            this.col = col;
            this.row = row;
        }
    }
}
