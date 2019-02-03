package no.hvl.dat102;

import no.hvl.dat102.adt.*;

//Oppgåve 3 - øving 2
/**
 * CDarkiv2
 */
public class CDarkiv2 implements CDarkivADT{

    private LinearNode<CD> start;
    private int antall;

    public CDarkiv2() {
        start = null;
        antall = 0;
    }

    @Override
    public CD[] hentCDTabell() {
        if(antall == 0) {
            return null;
        }

        CD[] cdtab = new CD[antall];

        LinearNode<CD> denne = start;
        int i = 0;
        while(denne != null && i < antall) {
            cdtab[i] = denne.getElement();
            denne = denne.getNeste();
            i++;
        }
        return cdtab;
    }

    @Override
    public void leggTilCD(CD nyCD) {

        // MÅ SJÅ OVER!!!

        LinearNode<CD> nynode = new LinearNode<CD>(nyCD);

        if(antall == 0) {
            start = nynode;
        } else {
            LinearNode<CD> denne = start;
            while(denne.getNeste() != null) {
                denne = denne.getNeste();
            }
            denne.setNeste(nynode);
        }

        antall++;
    }

    @Override
    public boolean slettCD(int cdNr) {

        // MÅ SJÅ OVER!!!

        boolean funne = false;

        LinearNode<CD> denne = start;
        LinearNode<CD> etterfolger = null;

        while(!funne && denne != null) {
            
            if(denne.getElement().getNummer() == cdNr) {
                funne = true;
                if(etterfolger == null) {
                    start = denne.getNeste();
                } else {
                    etterfolger.setNeste(denne.getNeste());
                }
                antall--;
            } else {
                etterfolger = denne;
                denne = denne.getNeste();
            }
        }
        
        return funne;
    }

    @Override
    public CD[] sokTittel(String delstreng) {
        
        // MÅ SJÅ OVER!!!

        if(antall == 0) {
            return null;
        }
        CD[] cdtab = new CD[antall];

        LinearNode<CD> denne = start;
        int i = 0;
        while(denne != null && i < antall) {
            CD cd = denne.getElement();
            
            if(cd.getTittel().contains(delstreng)) {
                cdtab[i] = cd;
                i++;
            }
            
            denne = denne.getNeste();
        }
        // må ha ein trimtab !!! (?)
        return trimTab(cdtab, cdtab.length);
    }

    @Override
    public CD[] sokArtist(String delstreng) {

        // MÅ SJÅ OVER!!!

        if(antall == 0) {
            return null;
        }
        CD[] cdtab = new CD[antall];

        LinearNode<CD> denne = start;
        int i = 0;
        while(denne != null && i < antall) {
            CD cd = denne.getElement();
            
            if(cd.getArtist().contains(delstreng)) {
                cdtab[i] = cd;
                i++;
            }
            
            denne = denne.getNeste();
        }
        // må ha ein trimtab !!! (?)
        return trimTab(cdtab, cdtab.length);
    }

    @Override
    public int antallSjanger(Sjanger sjanger) {
        int antAvSjanger = 0;

        LinearNode<CD> denne = start;
        while(denne != null) {
            if(denne.getElement().getSjanger() == sjanger) {
                antAvSjanger++;
            }
            denne = denne.getNeste();
        }

        return antAvSjanger;
    }

    @Override
    public int antall() {
        return antall;
    }

    // hjelpemetode for å trimme tabellar
    // treng eg denne???
    private CD[] trimTab(CD[] tab, int n) {
        CD[] cdTab2 = new CD[n];

        for(int i = 0; i < n; i++) {
            cdTab2[i] = tab[i];
        }

        return cdTab2;
    }
    
}