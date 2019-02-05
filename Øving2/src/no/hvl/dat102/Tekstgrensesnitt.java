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
     * @return ein cd med alle opplysningane 
     */
    public CD lesCD() {

        int nr = 0, lanseringsAar = 0;
        String artist = "", tittel = "", plateselskap = "";
        Sjanger sjanger = Sjanger.POP;

        //scanner er ... vrient... dette fungere OK~ då
        //vil gje feilmelding så fort ein skriv feil då
        //veit nå at ein kan bruke nextInt() men må ha ein "tom" nextLine() rett etterpå for å lese inn neste linje/linjeskift

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
     * @param cd cden som skal visast
     */
    public void visCD(CD cd) {
        //husk tekst for sjanger
        System.out.println(cd + "\n");
    }

    /**
     * Skriver ut alle CD-ar med ein spesiell delstreng i tittelen
     * @param cda CDarkivet som det skal skrivast ut info om
     * @param delstreng strengen som skal søkjast etter
     */
    public void skrivUtCDDelstrengTittel(CDarkivADT cda, String delstreng) {
        CD[] cdTab = cda.sokTittel(delstreng);

        for(CD cd : cdTab) {
            visCD(cd);
        }
    }

    /**
     * Skriver ut alle CD-ar av ein artist / ei gruppe
     * @param cda CDarkivet som det skal skrivast ut info om
     * @param delstreng strengen som skal søkjast etter
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
     * @param cda CDarkivet ein skal skrive ut statistikk frå
     */
    public void skrivUtStatistikk(CDarkivADT cda) {
        System.out.println("Antal CD-ar totalt: " + cda.antall());
        for(Sjanger sj : Sjanger.values()) {
            System.out.println("Antal " + sj + " CD-ar: " + cda.antallSjanger(sj));
        }
    }
    
    /**
     * Får tak i skanneren i tekstgrensesnittet for å berre ha eit skanneobjekt,
     * som ein også kan avslutte ved programslutt.
     * @return scanner-objektet i tekstgrensesnitt
     */
    public Scanner getScanner() {
        return lesar;
    }

    /**
     * Skriv ut alle valalternativa for menyen
     */
    public void valAlternativUtskrift() {
        System.out.println("\n---------- VALALTERNATIV ----------");
        System.out.println("1 - Les inn ein CD og legg den inn i arkivet."); //??
        System.out.println("2 - Slett ein CD.");
        System.out.println("3 - Skrive ut alle CD-ar med ein gitt delstreng i tittelen.");
        System.out.println("4 - Skrive ut alle CD-ar med ein gitt delstreng i artist-namnet.");
        System.out.println("5 - Skriv ut statistikk om arkivet.");
        System.out.println("0 - Avslutte programmet.");
    }
}