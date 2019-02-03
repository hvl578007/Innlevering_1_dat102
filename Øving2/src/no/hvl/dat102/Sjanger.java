package no.hvl.dat102;

public enum Sjanger {
    POP(1), ROCK(2), OPERA(3), KLASSISK(4);
    private int nr;
    
    private Sjanger(int n) {
        this.nr = n;
    }

    public int getNr() {
        return nr;
    }

    public static Sjanger finnSjanger(int n) {
        Sjanger sjanger = null;
		for (Sjanger sj : Sjanger.values()) {
			if (sj.nr == n) {
				sjanger = sj;
				break;
			}
		}
		return sjanger;
    }
    
    public static Sjanger finnSjanger(String namn) {
        Sjanger sjanger = null;
		for (Sjanger sj : Sjanger.values()) {
			if (sj.toString().equals(namn.toUpperCase())) {
				sjanger = sj;
				break;
			}
		}
		return sjanger;
    }
};