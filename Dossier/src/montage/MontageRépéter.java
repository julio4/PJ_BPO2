package montage;

/**
 * MontageRépéter.java 
 * Classe qui permet de répéter un film 'num' fois
 * 
 * @author Jules Doumèche, Gwénolé Martin
 */

import film.Film;
import film.Films;

public class MontageRépéter extends FilmMonté {

	private int nbRépEffectuées;
	private int nbRépétitions;

	public MontageRépéter(Film film, int num1) {
		super(film);
		nbRépétitions = num1 > 0 ? num1 : 0;
		nbRépEffectuées = 0;
	}

	@Override
	public boolean suivante(char[][] écran) {
		boolean suiv = super.suivante(écran);
		if(suiv && nbRépétitions > 0) {
			return true;
		}
		else {
			nbRépEffectuées++;
			rembobiner();
			if(nbRépEffectuées < nbRépétitions && super.suivante(écran)) {
				return true;
			}
			nbRépEffectuées = 0;
			rembobiner();
			return false;
		}
	}
}
