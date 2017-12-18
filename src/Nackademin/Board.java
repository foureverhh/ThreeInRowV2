package Nackademin;

import java.util.Scanner;

public class Board
{
//Instance variable
    private int x,y;
    private int blockAmount;
    private String winner;
    private boolean gameRestart;
    private boolean gameGoesOn;
    private String[][] gameZone;

//Constructor
    public Board() {
        this.blockAmount = 9;
        this.gameZone = new String[3][3] ;
    }


//Instance methods

    //Create a new game board
    public void newBoard()
    {
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                this.gameZone[i][j]=" ";
    }

    //Print board
    public void printBoard()
    {
        System.out.println("Enjoy your game,and good luck!");
        for(int i=0;i<3;i++)
        {
            System.out.print(" ---");
        }
        System.out.println();
        for(int i=0;i<3;i++){

            for(int j=0;j<3;j++)
            {
                System.out.print("| "+gameZone[i][j]+" ");
            }
            System.out.println("|");
            for(int k=0;k<3;k++)
            {
                System.out.print(" ---");
            }
            System.out.println();
        }
        System.out.println();
    }

    //Get players' chess
    public void getChess(Player p)
    {
        p.setX();
        p.setY();
        while(!gameZone[p.getX()][p.getY()].equals(" ") &&!gameZone[p.getX()][p.getY()].isEmpty())
        {
            System.out.println(p.getName()+", the place you chose is taken, try again please.");
            p.setX();
            p.setY();
        }
        gameZone[p.getX()][p.getY()]=p.getChessLabel();
        blockAmount--;
    }

    //

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
        while(i<3)
        {
            int k=0;
            for(int j=0;j<3;j++)
            {
                if(gameZone[i][j].equals(p.getChessLabel()))
                {
                    k++;
                }else
                {
                    break;
                }
            }
            if(k==3)
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
        while(j<3)
        {
            int k=0;
            for(int i=0;i<3;i++)
            {
                if(gameZone[i][j].equals(p.getChessLabel()))
                {
                    k++;
                }else
                {
                    break;
                }
            }
            if(k==3)
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
        for(int i=0;i<3;i++)
        {
            if(gameZone[i][i].equals(p.getChessLabel()))
            {
                k++;
            }else {
                break;
            }

            if(k==3)
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
        for(int i=0;i<3;i++)
        {
            if(gameZone[i][3-i-1].equals(p.getChessLabel()))
            {
                k++;
            }else {
                break;
            }
            if(k==3)
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
                    +p1.getName()+" won "+p1.getPoint()+" times."+"\n"
                    +p2.getName()+" won "+p2.getPoint()+" times."+"\n");
            gameGoesOn=false;

        }else if(blockAmount==0){
            System.out.println("All blocks are used up, no winner this round"+"\n"
                    +p1.getName()+" won "+p1.getPoint()+" times."+"\n"
                    +p2.getName()+" won "+p2.getPoint()+" times."+"\n");
            gameGoesOn=false;
        }
    }

    //Ask whether restart game
    public void restartGame(Player p1,Player p2)
    {
        System.out.println("Do you players want to restart the game?(Y/N)");
        Scanner sc = new Scanner(System.in);
        if(getStringInformation(sc).toLowerCase().equals("n"))
        {
            gameRestart = true;
            System.out.println("Game is over, see you next time!" + "\n"
                    + p1.getName() + " won " + p1.getPoint() + " times." + "\n"
                    + p2.getName() + " won " + p2.getPoint() + " times." + "\n");
        }
    }

    //Setter and getter
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

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
    //
}
