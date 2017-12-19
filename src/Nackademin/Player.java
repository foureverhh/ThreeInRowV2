package Nackademin;

import sun.awt.SunHints;

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


    public void setX(int rowAndCol) {
        System.out.println(this.getName()+
                " ,your turn to input your coordinate X(input a number less than row number):");
        Scanner sc = new Scanner(System.in);
        x = getCoordinate(sc,rowAndCol);
        this.x = x-1;
    }

    public void setY(int rowAndCol) {
        System.out.println(this.getName()+
                " ,your turn to input your coordinate y(input a number less than row number):");
        Scanner sc = new Scanner(System.in);
        y = getCoordinate(sc,rowAndCol);
        this.y = y-1;
    }

    public void setMachineX(int rowAndCol) {
        Random r = new Random();
        this.x = r.nextInt(rowAndCol);
        System.out.println("Show X "+x);

    }

    public void setMachineY(int rowAndCol) {
        Random r = new Random();
        this.y = r.nextInt(rowAndCol);
        System.out.println("Show Y "+y);
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

    private int getCoordinate(Scanner sc,int rowAndCol)
    {      //To check whether the input is a number
        while (true)
        {
            try
            {
                String s = sc.nextLine();
                int value = Integer.parseInt(s);
                if(value>=1 && value<=rowAndCol)
                {
                    return value;
                }
                //Value out of range, throw error
                throw new Exception("Try again.");
            } catch (Exception e)
            {
                System.out.println("Try again please. Input as required.");
            }
        }
    }

    public String getStringInformation(Scanner sc)
    {
        while(true)
        {
            try
            {
                return sc.nextLine();
            }
            catch (Exception e)
            {
                System.out.println("Try again please. Input as required.");
            }

        }
    }
}
