package no.hvl.dat102;

import no.hvl.dat102.adt.*;
/**
 * CDarkivKlient
 */
public class CDarkivKlient {

    public static void main(String[] args) {
        
        CDarkivADT cda = new CDarkiv();

        Meny meny = new Meny(cda);
        meny.start();
    }
}