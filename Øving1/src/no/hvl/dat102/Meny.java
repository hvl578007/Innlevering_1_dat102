package no.hvl.dat102;

import no.hvl.dat102.adt.*;
import java.util.Scanner;
/**
 * Meny
 */
public class Meny {

    private Tekstgrensesnitt tekstgr;
    private CDarkivADT cda;
    private Scanner lesar; //?
    private boolean fortsette; //?
    
    public Meny(CDarkivADT cda) {
        tekstgr = new Tekstgrensesnitt();
        this.cda = cda;

        lesar = tekstgr.getScanner(); //?
        fortsette = true; //?
    }

    /**
     * Startar opp menyen til CDarkivet
     */
    public void start() {
        //5 val + avslutte, 1, 2, 3, 4, 5 og 0 som avslutte

        System.out.println("----------------------------------");
        System.out.println("----- Startar opp programmet -----");
        System.out.println("----------------------------------\n");

        System.out.println("Laste inn eit eksisterande CDarkiv? ( Y / N )");
        String val = lesar.nextLine();

        if(val.equalsIgnoreCase("Y")) {
            System.out.println("Skriv inn filnamnet (eller stien):");
            String filnamn = lesar.nextLine();
            cda = Fil.lesFraFil(filnamn);
        }

        tekstgr.valAlternativUtskrift();

        do {
            try {
                System.out.println("\nSkriv inn valet ditt (0-5), 6 for alternativa:");
                int verdi = Integer.parseInt(lesar.nextLine());

                val(verdi);
            } catch (NumberFormatException e) {
                System.out.println("Ikkje eit nummer!");
                tekstgr.valAlternativUtskrift();
            }
        } while (fortsette);
    }

    private void val(int verdi) {

        switch (verdi) {
            case 0: //avslutte
                System.out.println("\n----- Programmet avsluttar -----");

                if(cda.antall() != 0) { //treng ikkje lagre eit tomt arkiv
                    System.out.println("Skriv inn ynskja filnamn programmet skal lagre til:");
                    String filnamn = lesar.nextLine();
                    Fil.skrivTilFil(cda, filnamn);
                }

                fortsette = false;
                lesar.close();
                break;
            
            case 1: //legg til CD
                System.out.println("\n----- Legg til ein ny CD i arkivet -----\n");
                CD cd = tekstgr.lesCD();
                cda.leggTilCD(cd);
                break;

            case 2: //slette CD
                System.out.println("\n----- Sletter ein CD frå arkivet -----\n");
                System.out.println("Skriv inn nummeret på CD-en som skal slettast:");
                int cdnr = Integer.parseInt(lesar.nextLine());
                if(cda.slettCD(cdnr)) {
                    System.out.println("CDnr: " + cdnr + " vart sletta.");
                } else {
                    System.out.println("CDnr: " + cdnr + " finst ikkje i arkivet.");
                }
                break;

            case 3: //alle CD-ar med den tittelen
                System.out.println("\n----- CD-ar med ein gitt delstreng i tittelen ------");
                System.out.println("Skriv inn delstrengen:");
                String delstrTittel = lesar.nextLine();
                tekstgr.skrivUtCDDelstrengTittel(cda, delstrTittel);
                break;

            case 4: //alle CD-ar med den artisten
                System.out.println("\n----- CD-ar med ein gitt delstreng i artistnamnet ------");
                System.out.println("Skriv inn delstrengen:");
                String delstrArtist = lesar.nextLine();
                tekstgr.skrivUtCDDelstrengArtist(cda, delstrArtist);
                break;

            case 5: //statistikk om arkivet
                System.out.println("\n----- Statistikk om CDarkivet -----");
                tekstgr.skrivUtStatistikk(cda);
                break;
                
            default:
                System.out.println("\nProgrammet kjenner ikkje igjen talet du skreiv inn, prøv på nytt.\n");
                tekstgr.valAlternativUtskrift();
                break;
        }
    }
}