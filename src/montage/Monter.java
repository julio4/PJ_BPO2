package montage;

import film.Film;

public class Monter{
	
	/*
	 * Répète un film num fois
	 */
	public static Film répéter(Film film, int num) {
		Montage filmMonté = new MontageRépéter(film, num);
		return (Film) filmMonté;
	}
	
	/*
	 * Obtiens un extrait du film indiqué par la première et dernière image de l'extrait
	 */
	public static Film extrait(Film film, int première, int dernière) {
		Montage filmMonté = new MontageExtrait(film, première, dernière);
		return (Film) filmMonté;
	}
	
	/*
	 * Encadre le film par quatres lignes d'étoiles sur les bords de l'écran
	 */
	public static Film encadrer(Film film) {
		Montage filmMonté = new MontageEncadrer(film);
		return (Film) filmMonté;
	}
	
	/*
	 * Colle deux films ensemble, film2 à la suite de film1
	 */
	public static Film coller(Film film1, Film film2) {
		Montage filmMonté = new MontageColler(film1, film2);
		return (Film) filmMonté;
	}
	
	/*
	 * Incruste film2 dans film1 
	 * avec le coin haut gauche du film2 à la ligne nLigne et à la colonne nColonne de film1
	 */
	public static Film incruster(Film film1, Film film2, int nLigne, int nColonne) {
		Montage filmMonté = new MontageIncruster(film1, film2, nLigne, nColonne);
		return (Film) filmMonté;
	}
}
