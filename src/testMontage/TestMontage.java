package testMontage;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import exemple.LaDiagonaleDuFou;
import film.Film;
import film.Films;
import montage.Montage;

class TestMontage {
	
	@Test
	void testRépéter() {
		Film film = new LaDiagonaleDuFou();
		for(int i = 0; i < 1000; ++i) {
			Film filmMonté = Montage.répéter(film, i);
			assertEquals(i * getNbImages(film), getNbImages(filmMonté));
		}
		//Test récursif
		Film filmMonté = Montage.répéter(Montage.répéter(film, 2), 2);
		assertEquals(2 * 2 * getNbImages(film), getNbImages(filmMonté));
	}
	
	@Test
	void testExtrait() {
		Film film = new LaDiagonaleDuFou();
		int nbImages = getNbImages(film);
		//cas utilisation correcte
		for(int i = 0; i < nbImages; ++i) {
			for(int j = i; j < nbImages; ++j) {
				Film filmMonté = Montage.extrait(film, i, j);
				assertEquals(getNbImages(filmMonté), (j - i) + 1);
			}
		}
		//cas dépassement de la borne supérieure
		for(int i = nbImages; i < nbImages * 5; ++i) {
			Film filmMonté = Montage.extrait(film, 0, i);
			assertEquals(getNbImages(filmMonté), nbImages);
		}
		//cas dépassement de la borne inférieure
		for(int i = -1 * nbImages; i < 0; ++i) {
			Film filmMonté = Montage.extrait(film, i, nbImages - 1);
			assertEquals(getNbImages(filmMonté), nbImages);
		}
		//Cas borne supérieure <= borne inférieure
		for(int i = nbImages / 2, j = i; i < nbImages; ++i, --j) {
			Film filmMonté = Montage.extrait(film, i, j);
			assertEquals(getNbImages(filmMonté), (j - i < 0 ? 0 : j - i + 1));
		}
		//Test récursif
		Film filmMonté = Montage.extrait(Montage.extrait(film, 0, nbImages - 1)
				, 0, nbImages - 1);
		assertEquals(getNbImages(filmMonté), nbImages);
	}
	
	@Test
	void testColler() {
		Film film1 = new LaDiagonaleDuFou();
		Film film2 = new LaDiagonaleDuFou();
		Film filmMonté = Montage.coller(film1, film2);

		assertEquals(getNbImages(filmMonté), getNbImages(film1) + getNbImages(film2));
		//Test récursif
		filmMonté = Montage.coller(Montage.coller(film2, film1), film2);
		assertEquals(getNbImages(filmMonté), getNbImages(film1) + getNbImages(film2) * 2);
	}
	
	@Test
	void testEncadrer() {
		final char BORDURE = '*';
		Film film = new LaDiagonaleDuFou();
		Film filmMonté = Montage.encadrer(film);
		char[][] efilm = Films.getEcran(film);
		char[][] efilmMonté = Films.getEcran(filmMonté);
		while(filmMonté.suivante(efilmMonté)) {
			//Test bordure verticale
			assertEquals(efilm.length + 2, efilmMonté.length);
			for(int i = 0; i < efilmMonté.length; ++i) {
				assertEquals(efilmMonté[i][0], BORDURE);
				assertEquals(efilmMonté[i][efilmMonté[0].length - 1], BORDURE);
			}
			//Test bordure horizontale
			assertEquals(efilm[0].length + 2, efilmMonté[0].length);
			for(int i = 0; i < efilmMonté[0].length; ++i) {
				assertEquals(efilmMonté[0][i], BORDURE);
				assertEquals(efilmMonté[efilmMonté.length - 1][i], BORDURE);
			}
		}
		
		//Test récursif
		film = filmMonté;
		filmMonté = Montage.encadrer(film);
		efilm = Films.getEcran(film);
		efilmMonté = Films.getEcran(filmMonté);
		while(filmMonté.suivante(efilmMonté)) {
			//Test bordure verticale
			assertEquals(efilm.length + 2, efilmMonté.length);
			for(int i = 0; i < efilmMonté.length; ++i) {
				assertEquals(efilmMonté[i][0], BORDURE);
				assertEquals(efilmMonté[i][efilmMonté[0].length - 1], BORDURE);
			}
			//Test bordure horizontale
			assertEquals(efilm[0].length + 2, efilmMonté[0].length);
			for(int i = 0; i < efilmMonté[0].length; ++i) {
				assertEquals(efilmMonté[0][i], BORDURE);
				assertEquals(efilmMonté[efilmMonté.length - 1][i], BORDURE);
			}
		}
	}
	
	@Test
	void testIncruster() {
		final int A = 4;
		final int B = 8;
		Film film1 = new LaDiagonaleDuFou();
		Film film2 = new LaDiagonaleDuFou();
		Film filmMonté = Montage.incruster(film1, film2, A, B);
		//Test longueur
		assertEquals(getNbImages(film1), getNbImages(filmMonté));
		char[][] efilmMonté = Films.getEcran(filmMonté);
		char[][] efilm1 = Films.getEcran(film1);
		//Test taille
		assertEquals(efilmMonté.length, efilm1.length);
		assertEquals(efilmMonté[0].length, efilm1[0].length);
		//Test incrustation
		filmMonté.rembobiner();
		filmMonté.suivante(efilmMonté);
		char[][] efilm2 = Films.getEcran(film2);
		film2.rembobiner();
		film2.suivante(efilm2);
		for(int i = A - 1; i < efilm1.length; ++i) {
			for(int j = B - 1; j < efilm1[0].length; ++j) {
				assertEquals(efilmMonté[i][j], efilm2[i - A + 1][j - B + 1]);
			}
		}
	}
	
	int getNbImages(Film film) {
		film.rembobiner();
		int i = 0;
		char[][] écran = Films.getEcran(film);
		while(film.suivante(écran)) {
			++i;
		}
		return i;
	}

}
