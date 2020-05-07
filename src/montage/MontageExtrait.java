package montage;

import film.Film;
import film.Films;

public class MontageExtrait extends Montage {
	private int num;
	private int premi�re;
	private int derni�re;

	public MontageExtrait(Film film, int num1, int num2) {
		super(film);
		this.num = 0;
		if(num1 > num2)
			this.num = getNbImages(getFilm());
		this.premi�re = (num1 < 0 ? 0 : num1);
		this.derni�re = (num2 < getNbImages(getFilm()) - 1 ? num2 : getNbImages(getFilm()) - 1);
	}

	@Override
	public boolean suivante(char[][] �cran) {
		while(this.num < this.premi�re) {
			getFilm().suivante(�cran);
			Films.effacer(�cran);
			this.num++;
		}
		if(this.num <= this.derni�re) {
			this.num++;
			return getFilm().suivante(�cran);
		}
		return false;
	}

}
