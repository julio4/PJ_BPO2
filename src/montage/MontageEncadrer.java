package montage;

import film.Film;

public class MontageEncadrer extends Montage {
	private static final char BORDURE = '*';

	public MontageEncadrer(Film film) {
		super(film);
	}

	@Override
	public boolean suivante(char[][] écran) {
		boolean suiv;
		suiv = getFilm().suivante(écran);
		for(int i = this.largeur() - 1; i > 1; --i) {
			for(int j = this.hauteur() - 1; j > 1; --j) {
				if(i < this.largeur() - 1 && j < this.hauteur() - 1)
					écran[i+1][j+1] = écran[i][j];
			}
		}
		for(int i = 0; i < this.largeur(); ++i) {
			for(int j = 0; j < this.hauteur(); ++j) {
				if(i == 0 || j == 0 || i == this.largeur() - 1 
						|| j == this.hauteur() - 1) {
					écran[i][j] = BORDURE;
				}
			}
		}
		return suiv;
	}

	@Override
	public int hauteur() {
		return getFilm().hauteur() + 2;
	}

	@Override
	public int largeur() {
		return getFilm().largeur() + 2;
	}

}
