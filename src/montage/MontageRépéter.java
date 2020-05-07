package montage;

import film.Film;

public class MontageR�p�ter extends Montage {

	private int nbR�pEffectu�es;
	private int nbR�p�titions;

	public MontageR�p�ter(Film film, int num1) {
		super(film);
		this.nbR�p�titions = num1 > 0 ? num1 : 0;
		this.nbR�pEffectu�es = 0;
	}

	@Override
	public boolean suivante(char[][] �cran) {
		boolean suiv = getFilm().suivante(�cran);
		if(!suiv && this.nbR�pEffectu�es < this.nbR�p�titions) {
			this.nbR�pEffectu�es++;
			getFilm().rembobiner();
			return !suiv && this.nbR�pEffectu�es < this.nbR�p�titions;
		}
		return suiv && this.nbR�pEffectu�es < this.nbR�p�titions;
	}

}
