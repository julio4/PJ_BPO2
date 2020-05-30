package montage;

/**
 * Monter.java 
 * Classe statique qui comprend toutes les m�thodes statiques
 * des fonctionnalit�es de montage de film
 * 
 * @author Jules Doum�che, Gw�nol� Martin
 */

import film.Film;

public class Montage{
	
	/**
	 * R�p�te un film 'num' fois
	 * 
	 * @return Le nouveau film qui r�p�te 'num' fois le film d'origine
	 *         Le film d'origine si 'num' = 1
	 */
	public static Film r�p�ter(Film film, int num) {
		return (num == 1) ? film : new MontageR�p�ter(film, num);
	}
	
	/**
	 * Obtiens un extrait du film indiqu� par la premi�re et derni�re 
	 * image de l'extrait
	 * 
	 * @return Le nouveau film correspondant � l'extrait du film d'origine
	 */
	public static Film extrait(Film film, int premi�re, int derni�re) {
		return new MontageExtrait(film, premi�re, derni�re);
	}	

	/**
	 * Encadre le film par quatres lignes d'�toiles sur les bords de
	 * l'�cran
	 * 
	 * @return Le nouveau film correspondant au film d'origine encadr�
	 */
	public static Film encadrer(Film film) {
		return new MontageEncadrer(film);
	}
	
	/**
	 * Colle deux films ensemble, film2 � la suite de film1
	 * 
	 * @return Le nouveau film correspondant au premier film d'origine 
	 * suivi du second
	 */
	public static Film coller(Film film1, Film film2) {
		return new MontageColler(film1, film2);
	}
	
	/**
	 * Incruste film2 dans film1 avec le coin haut gauche du film2 � la 
	 * ligne nLigne et � la colonne nColonne de film1
	 * 
	 * @return Le nouveau film avec le film2 d'origine incrust� dans le
	 * film1 d'origine
	 */
	public static Film incruster(Film film1, Film film2, int nLigne, int nColonne) {
		return new MontageIncruster(film1, film2, nLigne, nColonne);
	}
}
