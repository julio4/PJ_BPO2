package montage;

import film.Film;

public class Monter{
	
	/*
	 * R�p�te un film num fois
	 */
	public static Film r�p�ter(Film film, int num) {
		Montage filmMont� = new MontageR�p�ter(film, num);
		return (Film) filmMont�;
	}
	
	/*
	 * Obtiens un extrait du film indiqu� par la premi�re et derni�re image de l'extrait
	 */
	public static Film extrait(Film film, int premi�re, int derni�re) {
		Montage filmMont� = new MontageExtrait(film, premi�re, derni�re);
		return (Film) filmMont�;
	}
	
	/*
	 * Encadre le film par quatres lignes d'�toiles sur les bords de l'�cran
	 */
	public static Film encadrer(Film film) {
		Montage filmMont� = new MontageEncadrer(film);
		return (Film) filmMont�;
	}
	
	/*
	 * Colle deux films ensemble, film2 � la suite de film1
	 */
	public static Film coller(Film film1, Film film2) {
		Montage filmMont� = new MontageColler(film1, film2);
		return (Film) filmMont�;
	}
	
	/*
	 * Incruste film2 dans film1 
	 * avec le coin haut gauche du film2 � la ligne nLigne et � la colonne nColonne de film1
	 */
	public static Film incruster(Film film1, Film film2, int nLigne, int nColonne) {
		Montage filmMont� = new MontageIncruster(film1, film2, nLigne, nColonne);
		return (Film) filmMont�;
	}
}
