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


    public void setX(Board b) {
        System.out.println(this.getName()+" ,your turn to input your coordinate X(input a number):");
        Scanner sc = new Scanner(System.in);
        x = getCoordinate(sc,b);
        this.x = x-1;
    }

    public void setY(Board b) {
        System.out.println(this.getName()+" ,your turn to input your coordinate y(input a number):");
        Scanner sc = new Scanner(System.in);
        y = getCoordinate(sc,b);
        this.y = y-1;
    }

    public void setMachineX(Board b) {
        Random r = new Random();

        int a = b.getRolAndCol();
        System.out.println(a);
        int c = r.nextInt(a);
        System.out.println(c);
        this.x = c;

    }

    public void setMachineY(Board b) {
        Random r = new Random();
        this.y = r.nextInt(b.getRolAndCol());
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

    private int getCoordinate(Scanner sc, Board b)
    {

        while(true) {

            try {

                String s = sc.nextLine();
                int a = Integer.parseInt(s);
                return a;
            } catch (Exception e) {
                System.out.println("Try again please. Input as required.");
            }


            /*
            * if(a<=b.getRolAndCol() && a>=1)
            {
                return a;
            } else
                System.out.println("Try again please. Input as required.");
*/
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
