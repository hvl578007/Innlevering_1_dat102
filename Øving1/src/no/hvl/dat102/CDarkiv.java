package no.hvl.dat102;

import no.hvl.dat102.adt.*;

/**
 * CDarkiv
 */
public class CDarkiv implements CDarkivADT {

    private static final int STANDARD_STORRELSE = 20; //???

    private CD[] cdTabell;
    private int antall;

    public CDarkiv() {
        this(STANDARD_STORRELSE);
    }

    public CDarkiv(int storrelse) {
        cdTabell = new CD[storrelse];
        antall = 0;
    }

    @Override
    public CD[] hentCDTabell() {
        return trimTab(cdTabell, antall);
    }

    @Override
    public void leggTilCD(CD nyCD) {
        // kan sjekke om den finst i frå før? men gir jo ingen info til brukeren... er jo void returtype
        // sjekke om CD er ein null-referanse? antar at dei ikkje er det
        //antar at det unike cd-ar med unike nummer
        if(antall == cdTabell.length) {
            utvidTabell();
        }
        cdTabell[antall] = nyCD;
        antall++;

    }

    @Override
    public boolean slettCD(int cdNr) {
        int pos = finnPos(cdNr);
        if(pos != -1) {
            antall--;
            cdTabell[pos] = cdTabell[antall];
            cdTabell[antall] = null;
            return true;
        }
        return false;
    }

    @Override
    public CD[] sokTittel(String delstreng) {
        delstreng = delstreng.toLowerCase(); // treng ikkje lower case?
        //lage ny tabell som er like stor som den ein har
        //ta vare på antal titlar som blir funne?
        //søke igjennom tabellen etter titlar som passar
        //leggje til på den nye tabellen og opdatere antal funne
        //trimme tabellen og returnere den
        CD[] cdTittelTab = new CD[antall];
        int antFunne = 0;

        for (int i = 0; i < antall; i++) {
            String cdTittel = cdTabell[i].getTittel().toLowerCase(); //treng ikkje lower case?
            if(cdTittel.contains(delstreng)) {
                cdTittelTab[antFunne] = cdTabell[i];
                antFunne++;
            }
        }

        return trimTab(cdTittelTab, antFunne);
        //litt usikker på denne og sokArtist, finst nok betre måtar å gjere det på...
    }

    @Override
    public CD[] sokArtist(String delstreng) {
        delstreng = delstreng.toLowerCase(); // treng ikkje lower case?
        //same prosedyre/algoritme som på sokTittel
        CD[] cdArtistTab = new CD[antall];
        int antFunne = 0;

        for (int i = 0; i < antall; i++) {
            String cdArtist = cdTabell[i].getArtist().toLowerCase(); //treng ikkje lower case?
            if(cdArtist.contains(delstreng)) {
                cdArtistTab[antFunne] = cdTabell[i];
                antFunne++;
            }
        }

        return trimTab(cdArtistTab, antFunne);
    }

    @Override
    public int antallSjanger(Sjanger sjanger) {
        int antSjangrer = 0;

        for(int i = 0; i < antall; i++) {
            if(sjanger == cdTabell[i].getSjanger()) {
                antSjangrer++;
            }
        }
        return antSjangrer;
    }

    @Override
    public int antall() {
        return antall;
    }

    // returnerer ein verdi >= 0 om den finst, og -1 om den ikkje finst
    private int finnPos(int cdNr) {
        int i = 0;
        while(i < antall) {
            if(cdNr == cdTabell[i].getNummer()) {
                return i; //evt boolean og sjekk utanfor while løkka, eller noko anna variant.
            }
            i++;
        }
        return -1;
    }
    
    // hjelpemetode for å utvide tabellen med 10%
    private void utvidTabell() {
        int nyStr = (int)Math.ceil(1.1 * cdTabell.length);
        CD[] hjelpeTab = new CD[nyStr];

        //cdSamling = Arrays.copyOf(cdSamling, nyStr); //enkel og rask måte å lage ny tabell på

        for(int i = 0; i < cdTabell.length; i++) {
            hjelpeTab[i] = cdTabell[i];
        }
        cdTabell = hjelpeTab;
    }

    // hjelpemetode for å trimme tabellen
    private CD[] trimTab(CD[] tab, int n) {
        CD[] cdTab2 = new CD[n];

        for(int i = 0; i < n; i++) {
            cdTab2[i] = tab[i];
        }

        return cdTab2;
    }
}