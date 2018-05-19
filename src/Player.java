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
        curPieceCol = col;

        board.getBoard()[curPieceRow][col] = symbol;

        amtPlaced++;
        board.getAvailRowsInColumn()[col]--;

    }

    public boolean isValidCol(Board board, int col)
    {
        return (col<= board.getBoard()[0].length || col > 0) && board.getAvailRow(col) != -1;
    }

    public boolean checkWin(Board board)
    {

        return getNumPiecesHorizontal(board) == 4 || getNumPiecesVertical(board) == 4;

    }

    private int getNumPiecesHorizontal(Board board)
    {
        char[][] cBoard = board.getBoard();

        int cnt = 0;

        int tmpCol = curPieceCol-1;

        //First checking left for same piece
        while(tmpCol >= 0 && cBoard[curPieceRow][tmpCol] == symbol)
        {
            tmpCol--;
            cnt++;
        }

        tmpCol = curPieceCol;

        while(tmpCol < cBoard[0].length && cBoard[curPieceRow][tmpCol] == symbol)
        {
            tmpCol++;
            cnt++;
        }

        return cnt;
    }

    private int getNumPiecesVertical(Board board)
    {
        char[][] cBoard = board.getBoard();

        int cnt = 0;

        int tmpRow = curPieceRow-1;

        //checking up for same piece
        while(tmpRow >= 0&& cBoard[tmpRow][curPieceCol] == symbol)
        {
            tmpRow--;
            cnt++;
        }

        tmpRow = curPieceRow;

        //Checking down for same piece
        while(tmpRow < cBoard.length && cBoard[tmpRow][curPieceCol] == symbol)
        {
            tmpRow++;
            cnt++;
        }

        return cnt;
    }

    private int getNumPiecesDiagLeft(Board board)
    {
        char[][] cBoard = board.getBoard();

        int cnt = 0;

        int tmpRow = curPieceRow;
        int tmpCol = curPieceCol;

        //checking up for same piece
        while(tmpRow >= 0&& cBoard[tmpRow][curPieceCol] == symbol)
        {
            tmpRow--;
            cnt++;
        }

        tmpRow = curPieceRow;

        //Checking down for same piece
        while(tmpRow < cBoard.length && cBoard[tmpRow][curPieceCol] == symbol)
        {
            tmpRow++;
            cnt++;
        }

        return cnt;
    }

    private int getNumPiecesDiagRight()
    {

        return 5;
    }

    public String toString()
    {
        return "Row: ["+curPieceRow+"] Col: ["+curPieceCol+"]";
    }

    /*/
    //Check for pieces surrounding current piece
        //If find a piece, go the direction both ways (but stop 1 way if there is a 0 or the piece of opposite symbol)
        //Go direction depending on the closests piece orientation

        ////HORIZONTAL MOVING left and right CHECKING FOR CONNECT 4

        //Moving to the right checking for same piece
        while(tmpPieceCol < cBoard.length && cBoard[curPieceRow][tmpPieceCol] == symbol)
        {
            tmpPieceCol++;
            count++;
        }

        //Moving to the left checking for same piece
        tmpPieceCol = curPieceCol-1;
        while(tmpPieceCol >= 0 && cBoard[curPieceRow][tmpPieceCol] == symbol)
        {
            tmpPieceCol--;
            count++;
        }

        if(count == NUM_WIN)
        {
            return true;
        }

        ////HORIZONTAL MOVING left and right CHECKING FOR CONNECT 4

        count = 0;

        //VERTICAL MOVING UP AND DOWN CHECKING FOR CONNECT 4

        //Moving up to check for same piece
        while(tmpPieceRow >= 0 && cBoard[tmpPieceRow][curPieceCol] == symbol)
        {
            tmpPieceRow--;
            count++;
        }

        //Moving down to check for the same piece
        tmpPieceRow = curPieceRow+1;
        while(tmpPieceRow < cBoard.length && cBoard[tmpPieceRow][curPieceCol] == symbol)
        {
            tmpPieceRow++;
            count++;
        }

        //VERTICAL MOVING UP AND DOWN CHECKING FOR CONNECT 4

        count = 0;

        //DIAGONAL moving

     */
}
