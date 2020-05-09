package montage;

/**
 * MontageEncadrer.java 
 * Classe qui encadre un film par quatres lignes 
 * d'�toiles sur les bords de l'�cran
 * 
 * @author Jules Doum�che, Gw�nol� Martin
 */

import film.Film;
import film.Films;

public class MontageEncadrer extends Montage {

	private char[][] �cranOrigine;
	private static final char BORDURE = '*';

	public MontageEncadrer(Film film) {
		super(film);
		�cranOrigine = Films.getEcran(film);
	}

	@Override
	public boolean suivante(char[][] �cran) {
		boolean suiv;
		Films.effacer(�cranOrigine);
		suiv = super.suivante(�cranOrigine);
		for(int i = 0; i < hauteur() - 2; ++i) {
			�cran[i+1][0] = �cran[i+1][largeur() - 1] = BORDURE;
			System.arraycopy(�cranOrigine[i], 0, �cran[i+1], 1, largeur() - 2);
		}
		for(int i = 0; i < largeur(); ++i) {
			�cran[0][i] = �cran[hauteur() - 1][i] = BORDURE;
		}
		if(suiv)
			return true;
		rembobiner();
		return false;
	}

	@Override
	public int hauteur() {
		return super.hauteur() + 2;
	}

	@Override
	public int largeur() {
		return super.largeur() + 2;
	}

}
