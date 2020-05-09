package montage;

/**
 * MontageColler.java 
 * Classe sur laquelle repose chaque classe de Montage
 * Permet de faire le lien entre le film � monter et le film mont�
 * 
 * @author Jules Doum�che, Gw�nol� Martin
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
	public boolean suivante(char[][] �cran) {
		if(!finFilm1) {
			if(!super.suivante(�cran)) {
				finFilm1 = true;
				rembobiner();
				Films.effacer(�cran);
				return film2.suivante(�cran);
			}
			return true;
		}
		else {
			if(film2.suivante(�cran)) {
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
