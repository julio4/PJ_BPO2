package montage;

/**
 * Montage.java 
 * Classe sur laquelle repose chaque classe de Montage
 * Permet de faire le lien entre le film � monter et le film mont�
 * 
 * @author Jules Doum�che, Gw�nol� Martin
 */

import film.Film;
import film.Films;

class FilmMont� implements Film{
	private Film film;
	
	public FilmMont�(Film f) {
		film = f;
		rembobiner();
	}

	/**
	 * Indique la hauteur des images de ce film (en nombre de caract�res).
	 * 
	 * @return Hauteur minimale de l'�cran pour pouvoir afficher les images de
	 *         ce film.
	 */
	@Override
	public int hauteur() {
		return film.hauteur();
	}

	/**
	 * Indique la largeur des images de ce film (en nombre de caract�res).
	 * 
	 * @return largeur minimale de l'�cran pour pouvoir afficher les images de
	 *         ce film.
	 */
	@Override
	public int largeur() {
		return film.largeur();
	}
	
	/**
	 * Obtenir l'image suivante (s'il y en a une).
	 * 
	 * @param �cran
	 *            L'�cran o� afficher l'image
	 * @return vrai Si l'image suivante a �t� affich�e sur l'�cran et faux si le
	 *         film est termin�
	 */
	@Override
	public boolean suivante(char[][] �cran) {
		return film.suivante(�cran);
	}
	
	/**
	 * Rembobine le film en permettant de rejouer le film dans sa totalit� (via
	 * des appels successifs � la m�thode suivante()).
	 */
	@Override
	public void rembobiner() {
		film.rembobiner();
	}
}
