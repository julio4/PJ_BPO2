package montage;

/**
 * MontageColler.java 
 * Classe sur laquelle repose chaque classe de Montage
 * Permet de faire le lien entre le film à monter et le film monté
 * 
 * @author Jules Doumèche, Gwénolé Martin
 */

import film.Film;
import film.Films;

public class MontageColler extends Montage{

	Film film2;
	boolean finFilm1;

	public MontageColler(Film f1, Film f2) {
		super(f1);
		film2 = f2;
		film2.rembobiner();
		finFilm1 = false;
	}

	@Override
	public boolean suivante(char[][] écran) {
		if(!finFilm1) {
			if(!super.suivante(écran)) {
				finFilm1 = true;
				rembobiner();
				Films.effacer(écran);
				return film2.suivante(écran);
			}
			return true;
		}
		else {
			if(film2.suivante(écran)) {
				return true;
			}
			rembobiner();
			film2.rembobiner();
			finFilm1 = false;
			return false;
		}
	}

	@Override
	public int hauteur() {
		return super.hauteur() > film2.hauteur() ? 
				super.hauteur() : film2.hauteur();
	}

	@Override
	public int largeur() {
		return super.largeur() > film2.largeur() ? 
				super.largeur() : film2.largeur();
	}
}
