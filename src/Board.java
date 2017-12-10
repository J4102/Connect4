public class Board
{
    private String[][] board =  new String[6][7];
    private Index[] diffs = new Index[2]; //Holds the pieces each player has placed in 1 turn
    private int speed;
    private boolean showAnimation;
    private int fontSize;


    public Board()
    {
        showAnimation = false;
        fontSize = 1;
        speed = 0;
    }

    public Board(int speed, boolean showAnimation, int fontSize)
    {
        this.speed = speed;
        this.showAnimation = showAnimation;
        this.fontSize = fontSize;
    }


    public Board(Board boardObj)
    {
        this.speed = boardObj.speed;
        this.showAnimation = boardObj.showAnimation;
        this.fontSize = boardObj.fontSize;

    }

    public void updateBoard()
    {

    }

    public void addDiff(int row, int col)
    {
        //diffs[] find way to add it to either 0 or 1 index
    }

    public String[][] getBoard()
    {
        return board;
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

        public int getCol()
        {
            return col;
        }

        public int getRow()
        {
            return row;
        }

        public void setCol(int col)
        {
            this.col = col;
        }

        public void setRow(int row)
        {
            this.row = row;
        }


    }
}
