package no.hib.dat102.tabell;
import no.hib.dat102.adt.StabelADT;
import no.hib.dat102.adt.StabelADTTest;
import org.junit.Test;
import static org.junit.Assert.*;
public class TabellStabelTest extends StabelADTTest{	

    private static final int SIZE = 105;

    @Override
    protected StabelADT<Integer> reset() {
        return new TabellStabel<Integer>();
    }
    // Her kan en vel legge til test p� at stabelen
    // utvider seg

    // Henta berre frå TabellStabelUtenUnntak

    @Test
    public final void utviderStabelSeg() {
    stabel.push(e1);
    for (int i = 0; i < SIZE; i++) {
        stabel.push(e0);
    }
    stabel.push(e2);
    assertEquals(SIZE + 2, stabel.antall());
    assertEquals(e2, stabel.pop());
    for (int i = 0; i < SIZE; i++) {
        stabel.pop();
    }
    assertEquals(e1, stabel.pop());
    assertTrue(stabel.erTom());
    }
}