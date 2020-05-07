package montage;

import film.Film;
import film.Films;

abstract class Montage implements Film{
	//private int nbImages;
	private Film film;
	
	public Montage(Film film) {
		this.film = film;
		//this.nbImages = getNbImages(film);
		this.film.rembobiner();
	}

	@Override
	public int hauteur() {
		return this.film.hauteur();
	}

	@Override
	public int largeur() {
		return this.film.largeur();
	}

	@Override
	public void rembobiner() {
		//this.num = 0;
	}
	/*
	int getNbImages() {
		return nbImages;
	}

	void setNbImages(int nbImages) {
		this.nbImages = nbImages;
	}
	*/

	Film getFilm() {
		return film;
	}

	int getNbImages(Film film) {
		int i = 0;
		char[][] écran = Films.getEcran(film);
		while(film.suivante(écran)) {
			++i;
		}
		return i;
	}
	
}
