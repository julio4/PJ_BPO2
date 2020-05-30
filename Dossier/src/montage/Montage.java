package montage;

/**
 * Monter.java 
 * Classe statique qui comprend toutes les méthodes statiques
 * des fonctionnalitées de montage de film
 * 
 * @author Jules Doumèche, Gwénolé Martin
 */

import film.Film;

public class Montage{
	
	/**
	 * Répète un film 'num' fois
	 * 
	 * @return Le nouveau film qui répète 'num' fois le film d'origine
	 *         Le film d'origine si 'num' = 1
	 */
	public static Film répéter(Film film, int num) {
		return (num == 1) ? film : new MontageRépéter(film, num);
	}
	
	/**
	 * Obtiens un extrait du film indiqué par la première et dernière 
	 * image de l'extrait
	 * 
	 * @return Le nouveau film correspondant à l'extrait du film d'origine
	 */
	public static Film extrait(Film film, int première, int dernière) {
		return new MontageExtrait(film, première, dernière);
	}	

	/**
	 * Encadre le film par quatres lignes d'étoiles sur les bords de
	 * l'écran
	 * 
	 * @return Le nouveau film correspondant au film d'origine encadré
	 */
	public static Film encadrer(Film film) {
		return new MontageEncadrer(film);
	}
	
	/**
	 * Colle deux films ensemble, film2 à la suite de film1
	 * 
	 * @return Le nouveau film correspondant au premier film d'origine 
	 * suivi du second
	 */
	public static Film coller(Film film1, Film film2) {
		return new MontageColler(film1, film2);
	}
	
	/**
	 * Incruste film2 dans film1 avec le coin haut gauche du film2 à la 
	 * ligne nLigne et à la colonne nColonne de film1
	 * 
	 * @return Le nouveau film avec le film2 d'origine incrusté dans le
	 * film1 d'origine
	 */
	public static Film incruster(Film film1, Film film2, int nLigne, int nColonne) {
		return new MontageIncruster(film1, film2, nLigne, nColonne);
	}
}
