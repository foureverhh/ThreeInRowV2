package Nackademin;

import java.util.Random;
import java.util.Scanner;

public class Player
{
    //instance variable
    private String name;
    private String chessLabel;
    private int x,y;
    private int point;



    //Constructor
    public Player() {

    }

    public Player(String name)
    {
        this.name = name;
    }

    //Instance methods
    public void setChessLabel() {
        System.out.println(this.getName()+" input your chess label here:(One signal for example X)");
        Scanner sc = new Scanner(System.in);
        this.chessLabel = getStringInformation(sc);
    }

    public void setChessLabelMachine() {
        System.out.println("Input chess label for machine player here:(One signal for example X)");
        Scanner sc = new Scanner(System.in);
        this.chessLabel = getStringInformation(sc);
    }


    public void setX() {
        System.out.println(this.getName()+" ,your turn to input your coordinate X(1-3):");
        Scanner sc = new Scanner(System.in);
        x = getCoordinate(sc);
        this.x = x-1;
    }

    public void setMachineX() {
        Random r = new Random();
        this.x = r.nextInt(3);
    }

    public void setY() {
        System.out.println(this.getName()+" ,your turn to input your coordinate y(1-3):");
        Scanner sc = new Scanner(System.in);
        y = getCoordinate(sc);
        this.y = y-1;
    }

    public void setMachineY() {
        Random r = new Random();
        this.y = r.nextInt(3);
    }

    public int getPoint() {
        return point;
    }

    public void setPoint() {

        this.point ++;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public void setName() {
        System.out.println("Input player's name here:");
        Scanner sc = new Scanner(System.in);
        this.name = getStringInformation(sc);
    }

    public String getName() {
        return name;
    }

    public String getChessLabel() {
        return chessLabel;
    }

    private int getCoordinate(Scanner sc)
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
}
