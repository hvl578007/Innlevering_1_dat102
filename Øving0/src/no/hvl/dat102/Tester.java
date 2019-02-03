package no.hvl.dat102;

import javax.swing.JOptionPane;

/**
 * Tester
 */
public class Tester {

    public static void main(String[] args) {
        Butikk butikk = new Butikk("Bunnpris Sand", 100);
        int varenr, tal;

        System.out.println("Vareregistrering");
        for(int i = 0; i < 3; i++) { //lese inn antall varer
            varenr = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn varenr"));
            butikk.leggInnNyVare(varenr);
        } //skal eg lage eigne varer??
        /**
         * butikk.leggInnNyVare(123);
         * butikk.leggInnNyVare(125);
         * butikk.leggInnNyVare(234);
         */

        System.out.println("Grossinnkjøp");
        for(int i = 0; i < 3; i++) { //lese inn antall varer
            varenr = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn varenr"));
            tal = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn kor mange av varen som blir kjøpt inn"));
            butikk.grossInnkjop(varenr, tal);
        } //skal eg lage eigne varer??
        /**
         * butikk.grossInnkjop(123, 30);
         * butikk.grossInnkjop(125, 53);
         * butikk.grossInnkjop(234, 41);
         */

        System.out.println("Totalverdi av varene: " + butikk.salsVerdi());

        varenr = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn varenr til varen som skal slettast:"));
        butikk.slettVare(varenr);
        //butikk.slettVare(123);

        System.out.println("Detaljsal");
        for(int i = 0; i < 2; i++) { //lese inn antall varer som skal seljast!
            varenr = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn varenr til den som blir solgt"));
            butikk.detaljSal(varenr);
        } //skal eg lage eigne varer??
        /**
         * butikk.detaljSal(125);
         * butikk.detaljSal(234);
         */

        butikk.grossInnkjop(varenr, 0);
        //butikk.grossInnkjop()

        System.out.println("Ny totalverdi: " + butikk.salsVerdi());
    }
}