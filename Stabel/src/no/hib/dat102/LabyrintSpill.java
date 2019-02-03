package no.hib.dat102;

import no.hib.dat102.adt.StabelADT;
import no.hib.dat102.exception.*;
import no.hib.dat102.tabell.*;
import no.hib.dat102.kjedet.*;

public class LabyrintSpill {
	private Labyrint labyrint;

	public LabyrintSpill(Labyrint labyrint) {
		this.labyrint = labyrint;
	}

	/**
	 * Fors�ke � gjennomg� labyrinten
	 */
	
	public boolean gjennomgaa() {
		boolean ferdig = false;
		Posisjon pos = new Posisjon();
		//StabelADT<Posisjon> stabel = new KjedetStabel<Posisjon>();
		StabelADT<Posisjon> stabel = new TabellStabel<Posisjon>();
		stabel.push(pos);
        try{
		while (!stabel.erTom() && !(ferdig)) {
			pos = stabel.pop();
			labyrint.forsoekPosisjon(pos.getX(), pos.getY());
			if (pos.getX() == labyrint.getRekker()-1 && 
					      pos.getY() == labyrint.getKolonner() - 1){
				ferdig = true; // labyrinten er gjennomg�tt
			}
			else{
				 push_ny_pos(pos.getX(), pos.getY() - 1, stabel);
				 push_ny_pos(pos.getX(), pos.getY() + 1, stabel);
				 push_ny_pos(pos.getX() - 1, pos.getY(), stabel);
				 push_ny_pos(pos.getX() + 1, pos.getY(), stabel);
			}
        }//while
		
				
       }
		catch(EmptyCollectionException ex) {
	         System.out.println(ex.getMessage());
	    }
                
		return ferdig;
	}
	
	
	private void push_ny_pos(int x, int y, StabelADT<Posisjon> stabel) {
		Posisjon nypos = new Posisjon();
		nypos.setX(x);
		nypos.setY(y);
		if (labyrint.gyldigPosisjon(x, y)){
			stabel.push(nypos);
		}
	}
}//class




