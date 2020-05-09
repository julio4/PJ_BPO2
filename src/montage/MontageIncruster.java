package montage;

/**
 * MontageIncruster.java 
 * Classe qui permet d'incruster un film dans un autre 
 * à une positions indiquée
 * 
 * @author Jules Doumèche, Gwénolé Martin
 */

import film.Film;
import film.Films;

public class MontageIncruster extends Montage {

	private Film film2;
	private int nLignes;
	private int nColonnes;
	private int numImage;

	public MontageIncruster(Film f1, Film f2, int nL, int nC) {
		super(f1);
		film2 = f2;
		film2.rembobiner();
		numImage = 0;
		nLignes = nL > hauteur() ? hauteur() : nL;
		nColonnes = nC > largeur() ? largeur() : nC;
	}

	@Override
	public boolean suivante(char[][] écran) {
		boolean suiv = super.suivante(écran);
		char[][] écran2 = Films.getEcran(film2);

		film2.rembobiner();
		for(int i = 0; i < numImage; ++i) {
			film2.suivante(écran2);
		}
		numImage++;
		Films.effacer(écran2);
		boolean suiv2 = film2.suivante(écran2);

		if(suiv && suiv2) {
			for(int i = nLignes - 1; i < hauteur() - 1; ++i) {
				for(int j = nColonnes - 1; j < largeur() - 1 ; ++j) {
					écran[i][j] = écran2[i - nLignes + 1][j - nColonnes + 1];
				}
			}
		}
		if(suiv)
			return true;
		rembobiner();
		film2.rembobiner();
		numImage = 0;
		return false;
	}
}
