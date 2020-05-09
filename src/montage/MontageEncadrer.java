package montage;

/**
 * MontageEncadrer.java 
 * Classe qui encadre un film par quatres lignes 
 * d'étoiles sur les bords de l'écran
 * 
 * @author Jules Doumèche, Gwénolé Martin
 */

import film.Film;
import film.Films;

public class MontageEncadrer extends Montage {

	private char[][] écranOrigine;
	private static final char BORDURE = '*';

	public MontageEncadrer(Film film) {
		super(film);
		écranOrigine = Films.getEcran(film);
	}

	@Override
	public boolean suivante(char[][] écran) {
		boolean suiv;
		Films.effacer(écranOrigine);
		suiv = super.suivante(écranOrigine);
		for(int i = 0; i < hauteur() - 2; ++i) {
			écran[i+1][0] = écran[i+1][largeur() - 1] = BORDURE;
			System.arraycopy(écranOrigine[i], 0, écran[i+1], 1, largeur() - 2);
		}
		for(int i = 0; i < largeur(); ++i) {
			écran[0][i] = écran[hauteur() - 1][i] = BORDURE;
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
