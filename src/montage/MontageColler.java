package montage;

import film.Film;

public class MontageColler extends Montage{
	Film film2;
	boolean première;

	public MontageColler(Film film1, Film film2) {
		super(film1);
		this.film2 = film2;
		this.film2.rembobiner();
		this.première = false;
	}

	@Override
	public boolean suivante(char[][] écran) {
		if(première) {
			return this.film2.suivante(écran);
		}
		else {
			if(!getFilm().suivante(écran)) {
				this.première = true;
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
