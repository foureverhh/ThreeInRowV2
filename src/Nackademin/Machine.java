package Nackademin;

import java.util.Scanner;

public class Machine extends Player {
    private String name;

    @Override
    public void setName()
    {
        System.out.println("Input Machine's name");
        Scanner sc = new Scanner(System.in);
        this.name = getStringInformation(sc);
    }
    @Override
    public String getName()
    {
        System.out.println("Show machine's name");
        return this.name;
    }
}
