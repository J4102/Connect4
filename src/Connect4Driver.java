import java.util.Scanner;

public class Connect4Driver
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        Player p1 = new Player();
        Player p2 = new Player();
        boolean playerWin = false;


        //SETUP of board-------------------------------------------------------------

        System.out.println("Hello! Welcome to Connect4! This is a text based game that is played solely on the terminal! Created by J4102.");
        System.out.println("The goal is to get 4 pieces in a row horizontally, vertically, or diagonally");

        System.out.println();

        System.out.println("Setup of Board: ");

        System.out.println("Board symbol (placeholders for empty spaces, 1 character): ");
        board.setSymbol(scanner.next().charAt(0));

        //Need threads for this!!
        System.out.print("Speed of animation in ms (1 s = 1000ms)- the higher the slower. Type in 0 for no speed: ");
        board.setSpeed(scanner.nextInt());


        //SETUP of players---------------------------------------------------------------


        System.out.print("Player 1, choose your symbol (1 letter character): ");
        p1.setSymbol(scanner.next().charAt(0));


        System.out.print("Player 2, choose your symbol (1 letter character): ");
        p1.setSymbol(scanner.next().charAt(0));

        //GAMETIME --------------------------------------------------------------------
        String input = "y";
        while(input.equals("y") || input.equals("Y"))
        {
            while(!playerWin && !board.isFull())
            {
                //player 1 : enter column number
                System.out.print("[Player 1] Enter column number: ");

                int p1Col = scanner.nextInt();

                while(p1Col >= board.getBoard().length || p1Col < 0 && (board.getAvailRow(p1Col) >= 0))
                {
                    System.out.println("Input a valid column for player 1: ");
                    p1Col = scanner.nextInt();
                }

                p1.setPiece(board, p1Col);



                System.out.print("[Player 2] Enter column number: ");
                int p2Col = scanner.nextInt();

                while(p2Col >= board.getBoard().length || p2Col < 0 &&  (board.getAvailRow(p1Col) >= 0))
                {
                    System.out.println("Input a valid column for player 2: ");
                    p2Col = scanner.nextInt();
                }

                p2.setPiece(board, p2Col);

                //players have made 2 moves, add them to the total
                board.setTotalMoves(board.getTotalMoves()+2);

                //Print out the board for every move

                board.updateBoard();
            //board.checkwin // something like that
            }

            System.out.println("Play again? Type Y or y to continue.");
            input = scanner.next();
        }

        //GAMETIME --------------------------------------------------------------------


    }


}
