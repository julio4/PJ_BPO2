package montage;

/**
 * MontageExtrait.java 
 * Classe qui extrait une séquence d'un film délimité 
 * par la première et dernière image du film
 * 
 * @author Jules Doumèche, Gwénolé Martin
 */

import film.Film;
import film.Films;

public class MontageExtrait extends FilmMonté {

	private int numImage;
	private int première;
	private int dernière;

	public MontageExtrait(Film film, int pre, int der) {
		super(film);
		numImage = 0;
		première = (pre < 0 ? 0 : pre);
		dernière = der;
	}

	@Override
	public boolean suivante(char[][] écran) {
		while(numImage < première) {
			super.suivante(écran);
			Films.effacer(écran);
			numImage++;
		}
		numImage++;
		if(numImage - 1 <= dernière && super.suivante(écran)) {
			return true;
		}
		rembobiner();
		numImage = 0;
		return false;
	}
}
