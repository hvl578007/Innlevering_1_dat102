﻿package no.hvl.dat102;

import no.hvl.dat102.adt.*;
import no.hvl.dat102.sirkulaer.*;
import no.hvl.dat102.exception.*;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

/**
 * TestSirkulaerKoe
 */
public class TestSirkulaerKoe {

    //Køen
    private KoeADT<Integer> koe;

    //Test data
    private Integer e0 = 0;
    private Integer e1 = 1;
    private Integer e2 = 2;
    private Integer e3 = 3;
    private Integer e4 = 4;
    private Integer e5 = 5;
    
    @Before
    public final void setup() {
        koe = new SirkulaerKoe<>();
    }

    @Test
    public final void nyKoeErTom() {
        assertTrue(koe.erTom());
    }

    @Test
    public final void koeErIkkjeTom() {
        koe.innKoe(e0);
        assertFalse(koe.erTom());
    }

    @Test(expected = EmptyCollectionException.class)
    public final void utFraaTomKoeUnntak() {
        koe.utKoe();
    }

    @Test(expected = EmptyCollectionException.class)
    public final void foresteFraaTomKoeUnntak() {
        koe.foerste();
    }

    @Test
    public final void erTomVedInnOgUt() {
        koe.innKoe(e4);
        try {
            assertEquals(e4, koe.utKoe());
            assertTrue(koe.erTom());
        } catch (EmptyCollectionException e) {
            fail("uventa unntak" + e.getMessage());
        }
    }

    @Test
    public final void innOgUt() {
        koe.innKoe(e0);
        koe.innKoe(e2);
        koe.innKoe(e4);
        koe.innKoe(e1);

        try {
            assertEquals(e0, koe.utKoe());
            assertEquals(e2, koe.utKoe());
            assertEquals(e4, koe.utKoe());
            assertEquals(e1, koe.utKoe());
        } catch (EmptyCollectionException e) {
            fail("uventa unntak" + e.getMessage());
        }
    }

    @Test
    public final void innOgUtMedDuplikat() {
        koe.innKoe(e0);
        koe.innKoe(e2);
        koe.innKoe(e2);
        koe.innKoe(e1);

        try {
            assertEquals(e0, koe.utKoe());
            assertEquals(e2, koe.utKoe());
            assertEquals(e2, koe.utKoe());
            assertEquals(e1, koe.utKoe());
        } catch (EmptyCollectionException e) {
            fail("uventa unntak" + e.getMessage());
        }
    }

    @Test
    public final void innOgUtOgFoerste() {
        try {
            koe.innKoe(e5);
            koe.innKoe(e3);
            assertEquals(e5, koe.utKoe());
            koe.innKoe(e1);
            assertEquals(e3, koe.utKoe());
            assertEquals(e1, koe.foerste());
        } catch (EmptyCollectionException e) {
            fail("uventa unntak" + e.getMessage());
        }

    }

    @Test
    public final void koeReversererIkkje() {
        koe.innKoe(e2);
        koe.innKoe(e3);
        koe.innKoe(e4);
        koe.innKoe(e5);
        
        try {
            assertNotEquals(e5, koe.utKoe());
            assertNotEquals(e4, koe.utKoe());
            assertNotEquals(e3, koe.utKoe());
            assertNotEquals(e2, koe.utKoe());
        } catch (EmptyCollectionException e) {
            fail("uventa unntak" + e.getMessage());
        }
    }
}