import java.util.Scanner;

public class Connect4Driver
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Player p1 = new Player();
        Player p2 = new Player();
        boolean playerWin = false;


        //SETUP of board-------------------------------------------------------------

        System.out.println("Hello! Welcome to Connect4! This is a text based game that is played solely on the terminal! Created by J4102.");
        System.out.println("The goal is to get 4 pieces in a row horizontally, vertically, or diagonally");

        System.out.println();

        System.out.println("Setup of Board: ");

        System.out.println("Board symbol (placeholders for empty spaces, 1 character): ");
        char boardSymbol = scanner.next().charAt(0);

        Board board = new Board(boardSymbol);

        //SETUP of players---------------------------------------------------------------


        System.out.print("Player 1, choose your symbol (1 letter character): ");
        p1.setSymbol(scanner.next().charAt(0));


        System.out.print("Player 2, choose your symbol (1 letter character): ");
        p2.setSymbol(scanner.next().charAt(0));
        System.out.println(p2.getSymbol());

        //GAMETIME --------------------------------------------------------------------
        String input = "y";
        while(input.equals("y") || input.equals("Y"))
        {
            while(!playerWin && !board.isFull())
            {
                //player 1 : enter column number
                System.out.print("[Player 1] Enter column number: ");

                int p1Col = scanner.nextInt();

                //Continue to try and find a correct column value (Needs to not go over board's length and be greater than 0
                while(!(p1.isValidCol(board, p1Col)))
                {
                    System.out.println("Input a valid column for player 1: ");
                    p1Col = scanner.nextInt();
                }

                p1.setPiece(board, p1Col);


                //Same code as player1 but now with player2
                System.out.print("[Player 2] Enter column number: ");
                int p2Col = scanner.nextInt();

                while(!(p2.isValidCol(board, p2Col)))
                {
                    System.out.println("Input a valid column for player 1: ");
                    p2Col = scanner.nextInt();
                }

                p2.setPiece(board, p2Col);

                //Print out the board for every move

                board.printBoard();
            }

            System.out.println("Play again? Type Y or y to continue.");
            input = scanner.next();
        }

        //GAMETIME --------------------------------------------------------------------


    }


}
