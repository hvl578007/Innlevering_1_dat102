package no.hvl.dat102.adt;

import no.hvl.dat102.*;

/**
 * CDarkivADT
 */
public interface CDarkivADT {

    /**
     * Returnerer ein tabell av CD-ar
     * @return CD[] tabell av CDane i arkivet
     */
    CD[] hentCDTabell();

    /**
     * Legg til ein ny CD
     * @param nyCD ny CD som skal leggjast til
     */
    void leggTilCD(CD nyCD);

    /**
     * Sletter ein CD viss den finst
     * @param cdNr nummeret til cden som skal bli sletta
     * @return boolean, true om den blei sletta, false om den ikkje finst
     */
    boolean slettCD(int cdNr);

    /**
     * Søkjer og hentar CD-ar med ein gitt delstreng
     * @param delstreng strengen ein søkjer med etter ein tittel
     * @return CD[] tabell med CDar av gitt tittel
     */
    CD[] sokTittel(String delstreng);

    /**
     * Søkjer og hentar artistar med ein gitt delstreng
     * @param delstreng strengen ein søkjer med etter ein artist
     * @return CD[] tabell med CDar av gitt artist
     */
    CD[] sokArtist(String delstreng);

    /**
     * Henter antall CD-ar for ein gitt sjanger
     * @param sjanger sjangeren ein skal telje opp talet på
     * @return int - tal på CDar med den gitte sjangeren
     */
    int antallSjanger(Sjanger sjanger);

    /**
     * Returnerer antall CD-er
     * @return int - tal på CDar i arkivet
     */
    int antall();

    
}