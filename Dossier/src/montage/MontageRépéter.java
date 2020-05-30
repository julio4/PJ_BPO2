package montage;

/**
 * MontageR�p�ter.java 
 * Classe qui permet de r�p�ter un film 'num' fois
 * 
 * @author Jules Doum�che, Gw�nol� Martin
 */

import film.Film;
import film.Films;

public class MontageR�p�ter extends FilmMont� {

	private int nbR�pEffectu�es;
	private int nbR�p�titions;

	public MontageR�p�ter(Film film, int num1) {
		super(film);
		nbR�p�titions = num1 > 0 ? num1 : 0;
		nbR�pEffectu�es = 0;
	}

	@Override
	public boolean suivante(char[][] �cran) {
		boolean suiv = super.suivante(�cran);
		if(suiv && nbR�p�titions > 0) {
			return true;
		}
		else {
			nbR�pEffectu�es++;
			rembobiner();
			if(nbR�pEffectu�es < nbR�p�titions && super.suivante(�cran)) {
				return true;
			}
			nbR�pEffectu�es = 0;
			rembobiner();
			return false;
		}
	}
}
