package no.hvl.dat102;

import java.io.*;
import no.hvl.dat102.adt.*;

/**
 * Fil
 */
public class Fil {

    private final static String SKILLE = "#"; //evt parameter i metodane


    /**
     * Lese eit CDarkiv frå tekstfil
     * @param filnamn
     * @param cda
     */
    public static CDarkivADT lesFraFil(String filnamn) {

        CDarkivADT cda = null;

        try {
            BufferedReader innfil = new BufferedReader(new FileReader(filnamn));

            String linje = innfil.readLine();
            int n = Integer.parseInt(linje);

            cda = new CDarkiv2();

            for (int i = 0; i < n; i++) {

                linje = innfil.readLine();
                String[] strTab = linje.split(SKILLE);
                int nr = Integer.parseInt(strTab[0]);
                String artist = strTab[1];
                String tittel = strTab[2];
                int aar = Integer.parseInt(strTab[3]);
                Sjanger sj = Sjanger.finnSjanger(strTab[4]);
                String plateselskap = strTab[5];

                CD cd = new CD(nr, artist, tittel, aar, sj, plateselskap);

                cda.leggTilCD(cd);

            }

            innfil.close();

        } catch (FileNotFoundException e) {
            System.out.println("Finn ikkje fila " + filnamn);
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Feil ved lesing av fil: " + e);
            System.exit(2);
        }

        return cda;
    }

    /**
     * Lagre eit CDarkiv til tekstfil
     * @param cdarkiv
     * @param filnamn
     */
    public static void skrivTilFil(CDarkivADT cdarkiv, String filnamn) {

        try {
            
            PrintWriter utfil = new PrintWriter(new FileWriter(filnamn));

            int antall = cdarkiv.antall();
            //antall cd-er på første linje
            utfil.println(antall);

            CD[] tabell = cdarkiv.hentCDTabell();

            for(int i = 0; i < antall; i++) {
                utfil.print(tabell[i].getNummer());
                utfil.print(SKILLE);
                utfil.print(tabell[i].getArtist());
                utfil.print(SKILLE);
                utfil.print(tabell[i].getTittel());
                utfil.print(SKILLE);
                utfil.print(tabell[i].getLanseringsAar());
                utfil.print(SKILLE);
                utfil.print(tabell[i].getSjanger());
                utfil.print(SKILLE);
                utfil.println(tabell[i].getPlateselskap());
            }

            utfil.close();

        } catch (FileNotFoundException e) {
            System.out.println("Finn ikkje fila " + filnamn);
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Feil ved lesing av fil: " + e);
            System.exit(2);
        }
    }
}