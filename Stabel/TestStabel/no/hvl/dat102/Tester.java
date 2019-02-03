package no.hvl.dat102;

import org.junit.Before;
import org.junit.Test;

import no.hvl.dat102.adt.StabelADT;
import no.hvl.dat102.kjedet.*;

/**
 * Test
 */
public class Tester extends StabelTest {

    @Override
    protected StabelADT<Integer> opprettNyStabel() {
        StabelADT<Integer> tester = new KjedetStabel<Integer>();
        return tester;
    }
    
}