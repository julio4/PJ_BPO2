package montage;

import film.Film;
import film.Films;

public class MontageExtrait extends Montage {
	private int num;
	private int première;
	private int dernière;

	public MontageExtrait(Film film, int num1, int num2) {
		super(film);
		this.num = 0;
		if(num1 > num2)
			this.num = getNbImages(getFilm());
		this.première = (num1 < 0 ? 0 : num1);
		this.dernière = (num2 < getNbImages(getFilm()) - 1 ? num2 : getNbImages(getFilm()) - 1);
	}

	@Override
	public boolean suivante(char[][] écran) {
		while(this.num < this.première) {
			getFilm().suivante(écran);
			Films.effacer(écran);
			this.num++;
		}
		if(this.num <= this.dernière) {
			this.num++;
			return getFilm().suivante(écran);
		}
		return false;
	}

}
