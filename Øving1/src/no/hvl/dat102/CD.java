package no.hvl.dat102;

/**
 * CD
 */
public class CD {

    private int nummer;
    private String artist;
    private String tittel;
    private int lanseringsAar; //betre namn???
    private Sjanger sjanger;
    private String plateselskap;

    /**
     * Standard konstruktør som opprettar ein "tom" CD
     */
    public CD() {
        this(0, "", "", 0, Sjanger.POP, ""); //kva standardverdi burde eg ha på sjanger??? ny verdi i enum-klassen?
    }
    
    /**
     * Konstruktør med parametre for alle variablane til objektet
     * @param nummer
     * @param artist
     * @param tittel
     * @param lanseringsAar
     * @param sjanger
     * @param plateselskap
     */
    public CD(int nummer, String artist, String tittel, int lanseringsAar, Sjanger sjanger, String plateselskap) {
        this.nummer = nummer;
        this.artist = artist;
        this.tittel = tittel;
        this.lanseringsAar = lanseringsAar;
        this.sjanger = sjanger;
        this.plateselskap = plateselskap;
    }

    /**
     * @return nummer
     */
    public int getNummer() {
        return nummer;
    }

    /**
     * @return tittel
     */
    public String getTittel() {
        return tittel;
    }

    /**
     * @return artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * @return lanseringsAar
     */
    public int getLanseringsAar() {
        return lanseringsAar;
    }

    /**
     * @return plateselskap
     */
    public String getPlateselskap() {
        return plateselskap;
    }

    /**
     * 
     * @return Sjanger
     */
    public Sjanger getSjanger() {
        return sjanger;
    }

    @Override
    public String toString() {
        return "CD-nummer: " + nummer + "\nTittel: " + tittel + "\nArtist: " + artist
         + "\nÅr: " + lanseringsAar + "\nSjanger: " + sjanger + "\nSelskap: " + plateselskap;
    }
}