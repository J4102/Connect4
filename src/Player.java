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
        return (col<= board.getBoard()[0].length && col >= 0) && board.getAvailRow(col) != -1;
    }

    public boolean checkWin(Board board)
    {

        return getNumPiecesHorizontal(board) == 4 || getNumPiecesVertical(board) == 4
                || getNumPiecesDiagLeft(board) == 4  || getNumPiecesDiagRight(board) == 4;

    }

    //Checking for number of consecutive pieces that are the same horizontally
    private int getNumPiecesHorizontal(Board board)
    {
        char[][] cBoard = board.getBoard();

        int cnt = 1;

        int tmpCol = curPieceCol-1;

        //First checking left for same piece
        while(tmpCol >= 0 && cBoard[curPieceRow][tmpCol] == symbol)
        {
            tmpCol--;
            cnt++;
        }

        //Checking the right now

        tmpCol = curPieceCol+1;

        while(tmpCol < cBoard[0].length && cBoard[curPieceRow][tmpCol] == symbol)
        {
            tmpCol++;
            cnt++;
        }

        return cnt;
    }

    //Checking for number of consecutive pieces that are the same vertically
    private int getNumPiecesVertical(Board board)
    {
        char[][] cBoard = board.getBoard();

        int cnt = 1;

        int tmpRow = curPieceRow-1;

        //checking up for same piece
        while(tmpRow >= 0&& cBoard[tmpRow][curPieceCol] == symbol)
        {
            tmpRow--;
            cnt++;
        }

        tmpRow = curPieceRow+1;

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

        int cnt = 1;

        int tmpRow = curPieceRow-1;
        int tmpCol = curPieceCol-1;

        //checking up diagonally to the left
        while(tmpRow >= 0 && tmpCol >= 0 &&  cBoard[tmpRow][tmpCol] == symbol)
        {
            tmpRow--;
            tmpCol--;
            cnt++;
        }

        tmpRow = curPieceRow+1;
        tmpCol = curPieceCol+1;

        //Checking down diagonally to the right
        while(tmpRow < cBoard.length && tmpCol < cBoard[0].length && cBoard[tmpRow][tmpCol] == symbol)
        {
            tmpRow++;
            tmpCol++;
            cnt++;
        }

        return cnt;
    }

    private int getNumPiecesDiagRight(Board board)
    {
        char[][] cBoard = board.getBoard();

        int cnt = 1;

        int tmpRow = curPieceRow-1;
        int tmpCol = curPieceCol+1;

        //checking up diagonally to the right
        while(tmpRow >= 0 && tmpCol < cBoard[0].length && cBoard[tmpRow][tmpCol] == symbol)
        {
            tmpRow--;
            tmpCol++;
            cnt++;
        }

        tmpRow = curPieceRow+1;
        tmpCol = curPieceCol-1;

        //Checking down diagonally to the left
        while(tmpRow < cBoard.length && tmpCol >= 0 && cBoard[tmpRow][tmpCol] == symbol)
        {
            tmpRow++;
            tmpCol--;
            cnt++;
        }

        return cnt;
    }


    public String toString()
    {
        return "Row: ["+curPieceRow+"] Col: ["+curPieceCol+"]";
    }

    /*/
        private enum Color
    {

        BLACK("\u001B[30m"),
        RED("\u001B[31m"),
        GREEN("\u001B[32m"),
        YELLOW("\u001B[33m"),
        BLUE("\u001B[34m"),
        PURPLE("\u001B[35m"),
        CYAN("\u001B[36m"),
        WHITE("\u001B[37m");

        private final String code;
        Color(String code)
        {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
     */
}
