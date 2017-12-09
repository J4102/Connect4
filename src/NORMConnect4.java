import java.util.Scanner;

public class NORMConnect4
{
    public static void main(String[] args)
    {
        char c = 'a';
        System.out.println(c);
        //7 width by 6 height
        //6 == how long big array is
        //7 == how long each individual array is
        String[][] board = new String[6][7];

        for(int row = 0; row < board.length; row++)
        {
            for(int col = 0; col < board[row].length; col++)
            {
                board[row][col] = "o";
                System.out.print(board[row][col] + " ");
            }

            System.out.println();

        }

        //Just to seperate board from the info
        System.out.println();

        System.out.println("Welcome to Connect4! This was created by J4102");
        System.out.println("Format of moving (ignore brackets): [column]");

        Scanner scanner = new Scanner(System.in);

        String[] symbols = new String[2];

        System.out.println("Player 1 - Pick a 1 letter symbol to play with: ");
        symbols[0] = scanner.next();

        System.out.println("Player 2 - Pick a 1 letter symbol to play with: ");
        symbols[1] = scanner.next();

        //Can't put more than 42 pieces into the connect4 board
        final int maxTurns = 42;

        boolean connect4 = false;

        int counter = 0;
        while(counter < 42 && !connect4)
        {
            displayBoard(board);

            System.out.println("Player 1 move: ");
            int col1 = scanner.nextInt();
            int row1 = getRow(board, col1, symbols);

            //Set piece to specified column and rowand then update the board
            board[row1][col1] = symbols[0];
            displayBoard(board);

            if(checkWin(board, row1, col1, symbols[0]))
            {
                System.out.println("Player 1 has won!");
                break;
            }

            System.out.println("Player 2 move: ");
            int col2 = scanner.nextInt();
            int row2 = getRow(board, col2, symbols);

            //Set piece to specified column and row and then update the board
            board[row2][col2] = symbols[1];
            displayBoard(board);

            if(checkWin(board, row2, col2, symbols[1]))
            {
                System.out.println("Player 2 has won!");
                break;
            }

            counter++;

        }
    }

    //Go through every index and print them out
    private static void displayBoard(String[][] board)
    {
        for(int row = 0; row < board.length; row++)
        {
            for(int col = 0; col < board[row].length; col++)
            {
                System.out.print(board[row][col] + " ");
            }

            System.out.println();

        }

        System.out.println();
    }

    private static int getRow(String board[][], int column, String[] symbols)
    {

        int row = 0;

        //Keep looping until you either find a piece under or end up on the bottom of the board

        for(int i = row; row<=5; row++)
        {
            if(board[row][column].equals(symbols[0]) || board[row][column].equals(symbols[1]))
            {
                row--;
                break;
            }
        }

        //don't know how to fix this yet without doing this.....
        if(row == 6) row--;


        return row;
    }

    private static boolean checkWin(String[][] board, int row, int col, String symbol)
    {
        //Used for both horizontally and vertically checks
        int amtAppear = 0;

        //Checking horizontally for a WIN

        for(int i = 0; i < 6; i++)
        {
            if(board[row][i].equals(symbol))
            {
                amtAppear++;
                //Return true if 4 in a row found
                if(amtAppear == 4)
                {
                    return true;
                }

                continue;
            }

            //Reset to 0 if couldn't find 4 consecutively
            amtAppear = 0;
        }

        //Checking vertically for a WIN
        for(int i = 0; i < 6; i++)
        {
            if(board[i][col].equals(symbol))
            {
                amtAppear++;

                if(amtAppear == 4)
                {
                    return true;
                }

                continue;
            }

            amtAppear = 0;
        }

        //Checking diagonal from top-left to bottom right for a WIN
        //Go down till you reach bottom right (5)
        int r1 = row;
        int c1 = col;

        //Loop until you meet the top left most the piece can reach diagonally
        while(r1 != 0 && c1 != 0)
        {
            r1--;
            c1--;
        }

        //Loop to now the most bottom right the piece can reach diagonally and find 4 in a row

        while(r1 != 6 && c1 != 7)
        {

            if(board[r1][c1].equals(symbol))
            {
                amtAppear++;

                if(amtAppear == 4)
                {
                    return true;
                }

                r1++;
                c1++;

                continue;
            }

            amtAppear = 0;
            r1++;
            c1++;
        }



        int r2 = row;
        int c2 = col;

        //Loop until you meet the top right most the piece can reach diagonally
        while(r2 != 0 && c2 != 6)
        {
            r2--;
            c2++;
        }

        //To the bottom left corner the piece can at most reach

        while(r2 != 6 && c2 != -1)
        {
            if(board[r2][c2].equals(symbol))
            {
                amtAppear++;

                if(amtAppear == 4)
                {
                    return true;
                }

                r2++;
                c2--;

                continue;
            }


            amtAppear = 0;
            r2++;
            c2--;
        }




        //Checking diagonal from top-right to bottom left for a WIN
        return false;
    }


}
