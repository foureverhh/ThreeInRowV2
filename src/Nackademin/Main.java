package Nackademin;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    boolean playerIsMachine;
    int rowAndCol;

    //Create a game board
    System.out.println("Input how many rows would you like on your board?");
    Scanner sc = new Scanner(System.in);
    rowAndCol = getRowAmount(sc);
    Board gameBoard = new Board(rowAndCol);

    //Create player 1
    Player player1 = new Player();
    player1.setName();
    player1.setChessLabel();
    Player player2;

    //Create player 2
    System.out.println("Do you want to play with a machine?(Y/N)");
    sc = new Scanner(System.in);
    playerIsMachine = machinePlayer(sc);
    //
    if(playerIsMachine)
    {
        player2 = new Player("Machine");
        player2.setChessLabelMachine();
    }
    else
    {
        player2 = new Player();
        player2.setName();
        player2.setChessLabel();
    }

    while(!gameBoard.isGameRestart())
    {
        //Print new board
        gameBoard.setGameGoesOn(true);
        gameBoard.newBoard();
        gameBoard.printBoard();


        while(gameBoard.isGameGoesOn())
        {

            gameBoard.getChess(player1,rowAndCol);
            gameBoard.printBoard();
            gameBoard.getWinner(player1);
            gameBoard.showResult(player1, player2);
            if(!gameBoard.isGameGoesOn())
                break;

            if(playerIsMachine) {
                System.out.println("Is Machine?"+playerIsMachine);
                gameBoard.getMachineChess(player2,rowAndCol);
                gameBoard.printBoard();
                gameBoard.getWinner(player2);
                gameBoard.showResult(player1, player2);
                if(!gameBoard.isGameGoesOn())
                    break;
            } else
            {
                gameBoard.getChess(player2,rowAndCol);
                gameBoard.printBoard();
                gameBoard.getWinner(player2);
                gameBoard.showResult(player1,player2);
                if(!gameBoard.isGameGoesOn())
                    break;
            }
        }

        gameBoard.restartGame(player1, player2);
    }


    }

    public static String getStringInformation(Scanner sc)
    {
        while(true)
        {
            try {
                String s = sc.nextLine();
                return s;
            }
            catch (Exception e){
                System.out.println("Try again please. Input as required.");
            }

        }
    }

    public static int getRowAmount(Scanner sc)
    {
        while(true)
        {

            try {
                String s = sc.nextLine();
                return Integer.parseInt(s);
            }
            catch (Exception e){
                System.out.println("Try again please. Input as required.");
            }

        }
    }

    public static boolean machinePlayer(Scanner sc)
    {
        if (getStringInformation(sc).toLowerCase().equals("y"))
                return true;
        return false;
    }

}

