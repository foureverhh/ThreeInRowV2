package Nackademin;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
    Board gameBoard = new Board();
    Player player1 = new Player();
    Player player2 = new Player();

    player1.setName();
    player1.setChessLabel();

    if(gameBoard.playerIsMachine())
    {
        player2 = new Player("Machine");
        player2.setChessLabelMachine();
    }
    else
    {

        player2.setName();
        player2.setChessLabel();
    }

    while(!gameBoard.isGameRestart())
    {
        gameBoard.newBoard();
        gameBoard.printBoard();
        gameBoard.setGameGoesOn(true);

        while(gameBoard.isGameGoesOn())
        {
            gameBoard.getChess(player1);
            gameBoard.printBoard();
            gameBoard.getWinner(player1);
            gameBoard.showResult(player1,player2);
            if(!gameBoard.isGameGoesOn())
                break;

            if(gameBoard.isPlayerIsMachine()) {
                gameBoard.getMachineChess(player2);
                gameBoard.printBoard();
                gameBoard.getWinner(player2);
                gameBoard.showResult(player1, player2);
                if(!gameBoard.isGameGoesOn())
                    break;
            } else
            {
                gameBoard.getChess(player2);
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

    public String getStringInformation(Scanner sc)
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
}
