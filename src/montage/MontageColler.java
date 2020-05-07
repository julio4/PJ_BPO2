package montage;

import film.Film;

public class MontageColler extends Montage{
	Film film2;
	boolean premi�re;

	public MontageColler(Film film1, Film film2) {
		super(film1);
		this.film2 = film2;
		this.film2.rembobiner();
		this.premi�re = false;
	}

	@Override
	public boolean suivante(char[][] �cran) {
		if(premi�re) {
			return this.film2.suivante(�cran);
		}
		else {
			if(!getFilm().suivante(�cran)) {
				this.premi�re = true;
				getFilm().rembobiner();
			}
			return true;
		}
	}
	
	@Override
	public int hauteur() {
		return getFilm().hauteur() > this.film2.hauteur() ? 
				getFilm().hauteur() : this.film2.hauteur();
	}

	@Override
	public int largeur() {
		return getFilm().largeur() > this.film2.largeur() ? 
				getFilm().largeur() : this.film2.largeur();
	}
}
