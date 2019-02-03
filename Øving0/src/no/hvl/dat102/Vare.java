package no.hvl.dat102;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Vare {

    private int varenr;
    private String namn;
    private double pris;

    public Vare(int varenr, String namn, double pris) {
        this.varenr = varenr;
        this.namn = namn;
        this.pris = pris;
    }

    public Vare(int varenr) {
        this(varenr, "", 0.0);
    }

    public Vare() {
        this(0, "", 0.0);
    }

    public int getVarenr() {
        return this.varenr;
    }

    public void setVarenr(int varenr) {
        this.varenr = varenr;
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    //c)
    public void lesVare() {
        //Scanner lesar = new Scanner(System.in);

        System.out.println("Skriv inn namn:");
        setNamn(JOptionPane.showInputDialog("namn"));
        //setNamn(lesar.next());

        boolean lovleg = false;
        double pris;
        do {
            System.out.println("Skriv inn pris:");

            //pris = lesar.nextDouble();
            pris = Double.parseDouble(JOptionPane.showInputDialog("Pris"));
            lovleg = pris >= 0;

            if(!lovleg) {
                System.out.println("Ugyldig pris!");
            }
        } while (!lovleg);
        setPris(pris);

    
        //lesar.close();
    }

}
