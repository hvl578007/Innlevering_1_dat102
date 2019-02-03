package no.hvl.dat102;

import no.hvl.dat102.adt.*;
import java.util.Scanner;

/**
 * Tekstgrensesnitt
 */
public class Tekstgrensesnitt {

    private Scanner lesar;

    public Tekstgrensesnitt() {
        lesar = new Scanner(System.in); //opprettar scanneren her
    }

    /**
     * Les opplysningane om ein CD frå tastaturet
     * @return
     */
    public CD lesCD() {

        int nr = 0, lanseringsAar = 0;
        String artist = "", tittel = "", plateselskap = "";
        Sjanger sjanger = Sjanger.POP;

        //scanner er ... vrient... dette fungere OK~ då
        //vil gje feilmelding så fort ein skriv feil då

        System.out.println("Skriv inn nummeret til CD-en:");
        nr = Integer.parseInt(lesar.nextLine());

        System.out.println("Skriv inn namnet på artisten/gruppa:");
        artist = lesar.nextLine();

        System.out.println("Skriv inn tittelen til CD-en:");
        tittel = lesar.nextLine();

        System.out.println("Skriv inn lanseringsåret til CD-en:");
        lanseringsAar = Integer.parseInt(lesar.nextLine());

        System.out.println("Skriv inn ein sjanger (POP, ROCK, OPERA, KLASSISK):");
        sjanger = Sjanger.finnSjanger(lesar.nextLine());

        System.out.println("Skriv inn plateselskapet til CD-en:");
        plateselskap = lesar.nextLine();

        CD cd = new CD(nr, artist, tittel, lanseringsAar, sjanger, plateselskap);

        return cd;
    }

    /**
     * Visar ein CD med alle opplysningane på skjermen
     * @param cd
     */
    public void visCD(CD cd) {
        //husk tekst for sjanger
        System.out.println(cd + "\n");
    }

    /**
     * Skriver ut alle CD-ar med ein spesiell delstreng i tittelen
     * @param cda
     * @param delstreng
     */
    public void skrivUtCDDelstrengTittel(CDarkivADT cda, String delstreng) {
        CD[] cdTab = cda.sokTittel(delstreng);

        for(CD cd : cdTab) {
            visCD(cd);
        }
    }

    /**
     * Skriver ut alle CD-ar av ein artist / ei gruppe
     */
    public void skrivUtCDDelstrengArtist(CDarkivADT cda, String delstreng) {
        CD[] cdTab = cda.sokArtist(delstreng);

        for(CD cd : cdTab) {
            visCD(cd);
        }
    }

    /**
     * Skriver ut ein enkel statistikk som inneheld antal CD-ar totalt
     * og kor mange det er i kvar sjanger
     * @param cda
     */
    public void skrivUtStatistikk(CDarkivADT cda) {
        System.out.println("Antal CD-ar totalt: " + cda.antall());
        for(Sjanger sj : Sjanger.values()) {
            System.out.println("Antal " + sj + " CD-ar: " + cda.antallSjanger(sj));
        }
    }
    
    /**
     * @return the lesar
     */
    public Scanner getScanner() {
        return lesar;
    }
}