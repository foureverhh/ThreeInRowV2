package Nackademin;

import java.util.Random;
import java.util.Scanner;

public class Board
{
//Instance variable
    private int x,y;
    private int rolAndCol;
    private int blockAmount;
    private String winner;
    private boolean gameRestart;
    private boolean gameGoesOn;
    private boolean playerIsMachine;
    private String[][] gameZone;

//Constructor
    public Board()
    {

    }

    public Board(int rowAndCol) {
        this.blockAmount = rowAndCol*rowAndCol;
        this.gameZone = new String[rowAndCol][rowAndCol] ;
    }


//Instance methods

    //Input how big the board would be
    public void setRolAndCol()
    {
        System.out.println("Input how many rows would you like on your board?");
        Scanner sc = new Scanner(System.in);
        this.rolAndCol = getRowAmount(sc);
    }

    public int getRolAndCol() {
        return rolAndCol;
    }

    //Ask whether here is a machine player
    public boolean playerIsMachine()
    {
        System.out.println("Do you want to play with a machine?(Y/N)");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if(str.toLowerCase().equals("y"))
        {
            playerIsMachine = true;
        }
        return playerIsMachine;
    }

    //Create a new game board
    public void newBoard()
    {
        for(int i=0;i<gameZone.length;i++)
            for(int j=0;j<gameZone.length;j++)
                this.gameZone[i][j]=" ";
    }

    //Print board
    public void printBoard()
    {
        System.out.println("Enjoy your game,and good luck!");
        for(int i=0;i<gameZone.length;i++)
        {
            System.out.print(" ---");
        }
        System.out.println();
        for(int i=0;i<gameZone.length;i++){

            for(int j=0;j<gameZone.length;j++)
            {
                System.out.print("| "+gameZone[i][j]+" ");
            }
            System.out.println("|");
            for(int k=0;k<gameZone.length;k++)
            {
                System.out.print(" ---");
            }
            System.out.println();
        }
        System.out.println();
    }

    //Get players' chess
    public void getChess(Player p,Board b)
    {
        p.setX(b);
        p.setY(b);
        while(!gameZone[p.getX()][p.getY()].equals(" ") &&!gameZone[p.getX()][p.getY()].isEmpty())
        {
            System.out.println(p.getName()+", the place you chose is taken, try again please.");
            p.setX(b);
            p.setY(b);
        }
        gameZone[p.getX()][p.getY()]=p.getChessLabel();
        blockAmount--;
    }



    //Get Machine' chess
    public void getMachineChess(Player p,Board b)
    {
        p.setMachineX(b);
        p.setMachineY(b);
        while(!gameZone[getX()][getY()].equals(" ") &&!gameZone[getX()][getY()].isEmpty())
        {
            p.setMachineX(b);
            p.setMachineY(b);
        }
        gameZone[getX()][getY()]=p.getChessLabel();
        blockAmount--;
    }

    //Get winner
    public void getWinner(Player p)
    {
        checkWinnerDiagonallyBackslash(p);
        if (winner != null)
            return;
        checkWinnerDiagonallySlash(p);
        if (winner != null)
            return;
        checkWinnerHorizontally(p);
        if (winner != null)
            return;
        checkWinnerVertically(p);

    }

    //Check horizontally
    private void checkWinnerHorizontally(Player p)
    {
        int i=0;
        while(i<gameZone.length)
        {
            int k=0;
            for(int j=0;j<gameZone.length;j++)
            {
                if(gameZone[i][j].equals(p.getChessLabel()))
                {
                    k++;
                }else
                {
                    break;
                }
            }
            if(k==gameZone.length)
            {
                this.winner=p.getName();
                p.setPoint();
            }
            i++;
        }
    }

    //Check winner vertically
    private void checkWinnerVertically(Player p)
    {
        int j=0;
        while(j<gameZone.length)
        {
            int k=0;
            for(int i=0;i<gameZone.length;i++)
            {
                if(gameZone[i][j].equals(p.getChessLabel()))
                {
                    k++;
                }else
                {
                    break;
                }
            }
            if(k==gameZone.length)
            {
                this.winner=p.getName();
                p.setPoint();
            }
            j++;
        }
    }

    //Check winner diagonally-Backslash
    private void checkWinnerDiagonallyBackslash(Player p)
    {
        int k=0;
        for(int i=0;i<gameZone.length;i++)
        {
            if(gameZone[i][i].equals(p.getChessLabel()))
            {
                k++;
            }else {
                break;
            }

            if(k==gameZone.length)
            {
                this.winner=p.getName();
                p.setPoint();
            }
        }


    }

    //Check winner diagonally-slash
    private void checkWinnerDiagonallySlash(Player p)
    {
        int k=0;
        for(int i=0;i<gameZone.length;i++)
        {
            if(gameZone[i][gameZone.length-i-1].equals(p.getChessLabel()))
            {
                k++;
            }else {
                break;
            }
            if(k==gameZone.length)
            {
                this.winner=p.getName();
                p.setPoint();
            }
        }
    }

    //Show result
    public void showResult(Player p1,Player p2)
    {
        if(winner!=null){
            System.out.println("Winner is "+winner+"\n"
                    +p1.getName()+" win "+p1.getPoint()+" times."+"\n"
                    +p2.getName()+" win "+p2.getPoint()+" times."+"\n");
            gameGoesOn=false;

        }else if(blockAmount==0){
            System.out.println("All blocks are used up, no winner this round"+"\n"
                    +p1.getName()+" win "+p1.getPoint()+" times."+"\n"
                    +p2.getName()+" win "+p2.getPoint()+" times."+"\n");
            gameGoesOn=false;
        }
    }

    //Ask whether restart game
    public void restartGame(Player p1,Player p2)
    {
        System.out.println("Game continues?(Y/N)");
        Scanner sc = new Scanner(System.in);
        if(getStringInformation(sc).toLowerCase().equals("n"))
        {
            gameRestart = true;
            System.out.println("Game is over, see you next time!" + "\n"
                    + p1.getName() + " won " + p1.getPoint() + " times." + "\n"
                    + p2.getName() + " won " + p2.getPoint() + " times." + "\n");
        } else
        {
            //Set game restart to false and make winner to be null
            gameRestart=false;
            winner=null;
            blockAmount = getRolAndCol()*getRolAndCol();
        }
    }

    //Setter and getter



    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public boolean isGameRestart() {
        return gameRestart;
    }

    public void setGameRestart(boolean gameRestart) {
        this.gameRestart = gameRestart;
    }

    public boolean isGameGoesOn() {
        return gameGoesOn;
    }

    public void setGameGoesOn(boolean gameGoesOn) {
        this.gameGoesOn = gameGoesOn;
    }

    public boolean isPlayerIsMachine() {
        return playerIsMachine;
    }

    private String getStringInformation(Scanner sc)
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

    private int getRowAmount(Scanner sc)
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
