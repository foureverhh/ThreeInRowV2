package Nackademin;

import java.util.Scanner;

public class Player
{
    //instance variable
    private String name;
    private String chessLabel;
    private boolean playerIsMachine;
    private int x,y;
    private int point;



    //Constructor
    public Player() {

    }


    //Instance methods
    public int getCoordinate(Scanner sc)
    {
        while(true)
        {

            try {
                String s = sc.nextLine();
                if(Integer.parseInt(s)<=3&&Integer.parseInt(s)>=1)
                {
                    return Integer.parseInt(s);
                }
            }
            catch (Exception e){
                System.out.println("Try again please. Input as required.");
            }

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
    public String getName() {
        return name;
    }

    public void setName() {
        System.out.println("Input player's name here:");
        Scanner sc = new Scanner(System.in);
        this.name = getStringInformation(sc);
    }

    public String getChessLabel() {
        return chessLabel;
    }

    public void setChessLabel() {
        System.out.println(this.getName()+" input your chess label here:(One signal for example X)");
        Scanner sc = new Scanner(System.in);
        this.chessLabel = getStringInformation(sc);
    }

    public boolean isPlayerIsMachine() {
        return playerIsMachine;
    }

    public void setPlayerIsMachine(boolean playerIsMachine) {
        this.playerIsMachine = playerIsMachine;
    }

    public int getX() {
        return x;
    }

    public void setX() {
        System.out.println(this.getName()+" ,your turn to input your coordinate X(1-3):");
        Scanner sc = new Scanner(System.in);
        x = getCoordinate(sc);
        this.x = x-1;
    }

    public int getY() {
        return y;
    }

    public void setY() {
        System.out.println(this.getName()+" ,your turn to input your coordinate y(1-3):");
        Scanner sc = new Scanner(System.in);
        y = getCoordinate(sc);
        this.y = y-1;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint() {

        this.point ++;
    }
}
