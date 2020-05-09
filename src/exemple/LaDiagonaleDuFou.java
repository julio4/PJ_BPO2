package exemple;

import java.io.FileNotFoundException;

import film.Film;
import film.Films;
import montage.Monter;

/**
 * Un exemple basique d'impl�mentation de l'interface Film.
 */
public class LaDiagonaleDuFou implements Film {
	private int num = 0;
	private static final int NB_IMAGES = 20;

	@Override
	public int hauteur() {
		return 10;
	}

	@Override
	public int largeur() {
		return hauteur(); // ce sera un carr�
	}

	@Override
	public boolean suivante(char[][] �cran) {
		if (num == NB_IMAGES)
			return false;
		�cran[num % hauteur()][num % hauteur()] = 'a'; // un 'a' se balade sur
														// la diagonale
		++num;
		return true;
	}

	@Override
	public void rembobiner() {
		num = 0;
	}

	/**
	 * La projection (puis la sauvegarde) d'un tel film.
	 */
	public static void main(String[] args) {
		Film film = new LaDiagonaleDuFou();
		//Films.projeter(film);
		//film.rembobiner(); 
		
		Film testR�p�ter = Monter.r�p�ter(film, 2);
		Films.projeter(testR�p�ter);
		
		//Film testExtrait = Monter.extrait(film, 0, 9);
		//Films.projeter(testExtrait);
		
		//Film testEncadrer = Monter.encadrer(film);
		//Films.projeter(testEncadrer);
		
		//Film testColler = Monter.coller(film, film);
		//Films.projeter(testColler);
		
		//Film testIncruster = Monter.incruster(film, film, 5, 5);
		//Films.projeter(testIncruster);
		try {
			Films.sauvegarder(testR�p�ter, "fou.txt");
		} catch (FileNotFoundException e) {
			System.err.println("Le fichier 'fou.txt' n'a pas pu �tre cr��.");
		}
	}
}
