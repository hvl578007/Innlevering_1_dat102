package no.hvl.dat102.adt;

import no.hvl.dat102.*;

/**
 * CDarkivADT
 */
public interface CDarkivADT {

    /**
     * Returnerer ein tabell av CD-ar
     * @return CD[]
     */
    CD[] hentCDTabell();

    /**
     * Legg til ein ny CD
     * @param nyCD
     */
    void leggTilCD(CD nyCD);

    /**
     * Sletter ein CD viss den finst
     * @param cdNr
     * @return boolean
     */
    boolean slettCD(int cdNr);

    /**
     * Søkjer og hentar CD-ar med ein gitt delstreng
     * @param delstreng
     * @return CD[]
     */
    CD[] sokTittel(String delstreng);

    /**
     * Søkjer og hentar artistar med ein gitt delstreng
     * @param delstreng
     * @return CD[]
     */
    CD[] sokArtist(String delstreng);

    /**
     * Henter antall CD-ar for ein gitt sjanger
     * @param sjanger
     * @return int
     */
    int antallSjanger(Sjanger sjanger);

    /**
     * Returnerer antall CD-er
     * @return int
     */
    int antall();

    
}