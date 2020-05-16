package montage;

/**
 * Montage.java 
 * Classe sur laquelle repose chaque classe de Montage
 * Permet de faire le lien entre le film à monter et le film monté
 * 
 * @author Jules Doumèche, Gwénolé Martin
 */

import film.Film;
import film.Films;

class FilmMonté implements Film{
	private Film film;
	
	public FilmMonté(Film f) {
		film = f;
		rembobiner();
	}

	/**
	 * Indique la hauteur des images de ce film (en nombre de caractères).
	 * 
	 * @return Hauteur minimale de l'écran pour pouvoir afficher les images de
	 *         ce film.
	 */
	@Override
	public int hauteur() {
		return film.hauteur();
	}

	/**
	 * Indique la largeur des images de ce film (en nombre de caractères).
	 * 
	 * @return largeur minimale de l'écran pour pouvoir afficher les images de
	 *         ce film.
	 */
	@Override
	public int largeur() {
		return film.largeur();
	}
	
	/**
	 * Obtenir l'image suivante (s'il y en a une).
	 * 
	 * @param écran
	 *            L'écran où afficher l'image
	 * @return vrai Si l'image suivante a été affichée sur l'écran et faux si le
	 *         film est terminé
	 */
	@Override
	public boolean suivante(char[][] écran) {
		return film.suivante(écran);
	}
	
	/**
	 * Rembobine le film en permettant de rejouer le film dans sa totalité (via
	 * des appels successifs à la méthode suivante()).
	 */
	@Override
	public void rembobiner() {
		film.rembobiner();
	}
}
