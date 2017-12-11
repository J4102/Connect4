import java.util.Scanner;

public class Connect4Driver
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        //SETUP of board-------------------------------------------------------------
        Board board = new Board();

        System.out.println("Hello! Welcome to Connect4! This is a text based game that is played solely on the terminal! Created by J4102.");
        System.out.println("The goal is to get 4 pieces in a row horizontally, vertically, or diagonally");

        System.out.println();
        System.out.println("Setup of Board: ");

        System.out.print("Allow Animations? true or false: ");
        board.setAnimation(scanner.nextBoolean());

        if(board.getAnimation())
        {
            System.out.print("Speed of animation in ms (1 s = 1000ms)- the higher the slower: ");
            board.setSpeed(scanner.nextInt());

        }

        System.out.print("Font size: ");
        board.setFontSize(scanner.nextInt());

        //SETUP of board-------------------------------------------------------------

        Player p1 = new Player();
        Player p2 = new Player();
        

        System.out.print("Player 1, choose your symbol (1 letter character): ");
        p1.setSymbol(scanner.next().charAt(0));


        System.out.print("Player 2, choose your symbol (1 letter character): ");
        p1.setSymbol(scanner.next().charAt(0));
        //System.out.println("Player 2, choose your symbol: ");

    }


}
