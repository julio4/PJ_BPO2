package montage;

/**
 * MontageIncruster.java 
 * Classe qui permet d'incruster un film dans un autre 
 * � une positions indiqu�e
 * 
 * @author Jules Doum�che, Gw�nol� Martin
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
	public boolean suivante(char[][] �cran) {
		boolean suiv = super.suivante(�cran);
		char[][] �cran2 = Films.getEcran(film2);

		film2.rembobiner();
		for(int i = 0; i < numImage; ++i) {
			film2.suivante(�cran2);
		}
		numImage++;
		Films.effacer(�cran2);
		boolean suiv2 = film2.suivante(�cran2);

		if(suiv && suiv2) {
			for(int i = nLignes - 1; i < hauteur() - 1; ++i) {
				for(int j = nColonnes - 1; j < largeur() - 1 ; ++j) {
					�cran[i][j] = �cran2[i - nLignes + 1][j - nColonnes + 1];
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
