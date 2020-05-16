package montage;

/**
 * MontageExtrait.java 
 * Classe qui extrait une s�quence d'un film d�limit� 
 * par la premi�re et derni�re image du film
 * 
 * @author Jules Doum�che, Gw�nol� Martin
 */

import film.Film;
import film.Films;

public class MontageExtrait extends FilmMont� {

	private int numImage;
	private int premi�re;
	private int derni�re;

	public MontageExtrait(Film film, int pre, int der) {
		super(film);
		numImage = 0;
		premi�re = (pre < 0 ? 0 : pre);
		derni�re = der;
	}

	@Override
	public boolean suivante(char[][] �cran) {
		while(numImage < premi�re) {
			super.suivante(�cran);
			Films.effacer(�cran);
			numImage++;
		}
		numImage++;
		if(numImage - 1 <= derni�re && super.suivante(�cran)) {
			return true;
		}
		rembobiner();
		numImage = 0;
		return false;
	}
}
