package no.hvl.dat102;

/**
 * Butikk
 */
public class Butikk {

    private String namn;
    private Vare[] vare;
    private int[] lager;
    private int antallTyper;

    public Butikk(String namn, int maksantvarer) {
        this.namn = namn;
        vare = new Vare[maksantvarer];
        lager = new int[maksantvarer];
        antallTyper = 0;
    }

    public int finnVare(int varenr) {
        int i = 0;
        while(i < antallTyper) {
            if(vare[i].getVarenr() == varenr) {
                return i; //evt. boolean og if og så returnere utanfor
            }
            i++;
        }
        return -1;
    }

    public boolean erLedigPlass() {
        return antallTyper < vare.length;
    }

    public void leggInnNyVare(int varenr) {
        if(erLedigPlass()) {
            if(finnVare(varenr) == -1) {

                //må opprette ny vare!!!
                Vare v = new Vare(varenr);
                v.lesVare();

                vare[antallTyper] = v;
                lager[antallTyper] = 0;

                antallTyper++;
            } else {
                System.out.println("Varen finst i frå før!");
            }
            
        } else {
            System.out.println("Det er fullt!");
        }
    }

    public void slettVare(int varenr) {
        int pos = finnVare(varenr);
        if(pos == -1) {
            System.out.println("Varen finst ikkje!");
        } else {
            antallTyper--;
            vare[pos] = vare[antallTyper];
            vare[antallTyper] = null;
            lager[pos] = lager[antallTyper];
            lager[antallTyper] = 0;
        }
    }

    public void detaljSal(int varenr) {
        int pos = finnVare(varenr);
        if(pos == -1) {
            System.out.println("Varen finst ikkje!");
        } else {
            if(lager[pos] > 0) {
                lager[pos]--;
            } else {
                System.out.println("Det er 0 stk igjen på lager!");
            }
        }
    }

    public void grossInnkjop(int varenr, int tal) {
        if(tal <= 0) {
            System.out.println("Talet er ikkje positivt!");
        }
        int pos = finnVare(varenr);
        if(pos != -1) {
            lager[pos] += tal;
        } else {
            System.out.println("Varen finst ikkje!");
        }
    }

    public double salsVerdi() {
        double total = 0.0;
        for(int i = 0; i < antallTyper; i++) {
            total += vare[i].getPris() * lager[i];
        }
        return total;
    }
}