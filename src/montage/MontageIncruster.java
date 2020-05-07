package montage;

import film.Film;
import film.Films;

public class MontageIncruster extends Montage {
	private Film film2;
	private int nLignes;
	private int nColonnes;

	public MontageIncruster(Film film1, Film film2, int nLignes, int nColonnes) {
		super(film1);
		this.film2 = film2;
		this.film2.rembobiner();
		this.nLignes = nLignes;
		this.nColonnes = nColonnes;
	}

	@Override
	public boolean suivante(char[][] écran) {
		boolean suiv = getFilm().suivante(écran);
		char[][] écran2 = Films.getEcran(this.film2);
		boolean suiv2 = this.film2.suivante(écran2);
		if(suiv2 && suiv) {
			for(int i = this.nLignes - 1; i < hauteur(); ++i) {
				for(int j = this.nColonnes - 1; i < largeur() ; ++j) {
					écran[i][j] = écran2[i - this.nLignes + 1][j - this.nColonnes + 1];
				}
			}
		}
		return suiv;
	}

	@Override
	public int hauteur() {
		return getFilm().hauteur();
	}

	@Override
	public int largeur() {
		return getFilm().largeur();
	}

}
