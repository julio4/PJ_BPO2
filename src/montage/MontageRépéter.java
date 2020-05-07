package montage;

import film.Film;

public class MontageRépéter extends Montage {

	private int nbRépEffectuées;
	private int nbRépétitions;

	public MontageRépéter(Film film, int num1) {
		super(film);
		this.nbRépétitions = num1 > 0 ? num1 : 0;
		this.nbRépEffectuées = 0;
	}

	@Override
	public boolean suivante(char[][] écran) {
		boolean suiv = getFilm().suivante(écran);
		if(!suiv && this.nbRépEffectuées < this.nbRépétitions) {
			this.nbRépEffectuées++;
			getFilm().rembobiner();
			return !suiv && this.nbRépEffectuées < this.nbRépétitions;
		}
		return suiv && this.nbRépEffectuées < this.nbRépétitions;
	}

}
