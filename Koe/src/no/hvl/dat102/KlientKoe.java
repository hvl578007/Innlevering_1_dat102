package no.hvl.dat102;

import no.hvl.dat102.kjedet.KjedetKoe;
import no.hvl.dat102.sirkulaer.SirkulaerKoe;
import no.hvl.dat102.tabell.TabellKoe;

public class KlientKoe {
	public static void main(String[] args) {
		
		//TabellKoe<Character> tegnKoe = new TabellKoe<Character>();
		//KjedetKoe<Character> tegnKoe = new KjedetKoe<Character>();
		SirkulaerKoe<Character> tegnKoe = new SirkulaerKoe<Character>();

		String streng = " Denne koen er en FIFO datastruktur.";
		int lengde = streng.length();

		for (int i = 0; i < lengde; i++) {
			tegnKoe.innKoe(Character.valueOf(streng.charAt(i)));
		}
		while (!tegnKoe.erTom()) {
			Character tegn_obj =  tegnKoe.utKoe();
			System.out.print(tegn_obj);
		}

	}

}// class
