package testMontage;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import exemple.LaDiagonaleDuFou;
import film.Film;
import film.Films;
import montage.Montage;

class TestMontage {
	
	@Test
	void testR�p�ter() {
		Film film = new LaDiagonaleDuFou();
		for(int i = 0; i < 1000; ++i) {
			Film filmMont� = Montage.r�p�ter(film, i);
			assertEquals(i * getNbImages(film), getNbImages(filmMont�));
		}
		//Test r�cursif
		Film filmMont� = Montage.r�p�ter(Montage.r�p�ter(film, 2), 2);
		assertEquals(2 * 2 * getNbImages(film), getNbImages(filmMont�));
	}
	
	@Test
	void testExtrait() {
		Film film = new LaDiagonaleDuFou();
		int nbImages = getNbImages(film);
		//cas utilisation correcte
		for(int i = 0; i < nbImages; ++i) {
			for(int j = i; j < nbImages; ++j) {
				Film filmMont� = Montage.extrait(film, i, j);
				assertEquals(getNbImages(filmMont�), (j - i) + 1);
			}
		}
		//cas d�passement de la borne sup�rieure
		for(int i = nbImages; i < nbImages * 5; ++i) {
			Film filmMont� = Montage.extrait(film, 0, i);
			assertEquals(getNbImages(filmMont�), nbImages);
		}
		//cas d�passement de la borne inf�rieure
		for(int i = -1 * nbImages; i < 0; ++i) {
			Film filmMont� = Montage.extrait(film, i, nbImages - 1);
			assertEquals(getNbImages(filmMont�), nbImages);
		}
		//Cas borne sup�rieure <= borne inf�rieure
		for(int i = nbImages / 2, j = i; i < nbImages; ++i, --j) {
			Film filmMont� = Montage.extrait(film, i, j);
			assertEquals(getNbImages(filmMont�), (j - i < 0 ? 0 : j - i + 1));
		}
		//Test r�cursif
		Film filmMont� = Montage.extrait(Montage.extrait(film, 0, nbImages - 1)
				, 0, nbImages - 1);
		assertEquals(getNbImages(filmMont�), nbImages);
	}
	
	@Test
	void testColler() {
		Film film1 = new LaDiagonaleDuFou();
		Film film2 = new LaDiagonaleDuFou();
		Film filmMont� = Montage.coller(film1, film2);

		assertEquals(getNbImages(filmMont�), getNbImages(film1) + getNbImages(film2));
		//Test r�cursif
		filmMont� = Montage.coller(Montage.coller(film2, film1), film2);
		assertEquals(getNbImages(filmMont�), getNbImages(film1) + getNbImages(film2) * 2);
	}
	
	@Test
	void testEncadrer() {
		final char BORDURE = '*';
		Film film = new LaDiagonaleDuFou();
		Film filmMont� = Montage.encadrer(film);
		char[][] efilm = Films.getEcran(film);
		char[][] efilmMont� = Films.getEcran(filmMont�);
		while(filmMont�.suivante(efilmMont�)) {
			//Test bordure verticale
			assertEquals(efilm.length + 2, efilmMont�.length);
			for(int i = 0; i < efilmMont�.length; ++i) {
				assertEquals(efilmMont�[i][0], BORDURE);
				assertEquals(efilmMont�[i][efilmMont�[0].length - 1], BORDURE);
			}
			//Test bordure horizontale
			assertEquals(efilm[0].length + 2, efilmMont�[0].length);
			for(int i = 0; i < efilmMont�[0].length; ++i) {
				assertEquals(efilmMont�[0][i], BORDURE);
				assertEquals(efilmMont�[efilmMont�.length - 1][i], BORDURE);
			}
		}
		
		//Test r�cursif
		film = filmMont�;
		filmMont� = Montage.encadrer(film);
		efilm = Films.getEcran(film);
		efilmMont� = Films.getEcran(filmMont�);
		while(filmMont�.suivante(efilmMont�)) {
			//Test bordure verticale
			assertEquals(efilm.length + 2, efilmMont�.length);
			for(int i = 0; i < efilmMont�.length; ++i) {
				assertEquals(efilmMont�[i][0], BORDURE);
				assertEquals(efilmMont�[i][efilmMont�[0].length - 1], BORDURE);
			}
			//Test bordure horizontale
			assertEquals(efilm[0].length + 2, efilmMont�[0].length);
			for(int i = 0; i < efilmMont�[0].length; ++i) {
				assertEquals(efilmMont�[0][i], BORDURE);
				assertEquals(efilmMont�[efilmMont�.length - 1][i], BORDURE);
			}
		}
	}
	
	@Test
	void testIncruster() {
		final int A = 4;
		final int B = 8;
		Film film1 = new LaDiagonaleDuFou();
		Film film2 = new LaDiagonaleDuFou();
		Film filmMont� = Montage.incruster(film1, film2, A, B);
		//Test longueur
		assertEquals(getNbImages(film1), getNbImages(filmMont�));
		char[][] efilmMont� = Films.getEcran(filmMont�);
		char[][] efilm1 = Films.getEcran(film1);
		//Test taille
		assertEquals(efilmMont�.length, efilm1.length);
		assertEquals(efilmMont�[0].length, efilm1[0].length);
		//Test incrustation
		filmMont�.rembobiner();
		filmMont�.suivante(efilmMont�);
		char[][] efilm2 = Films.getEcran(film2);
		film2.rembobiner();
		film2.suivante(efilm2);
		for(int i = A - 1; i < efilm1.length; ++i) {
			for(int j = B - 1; j < efilm1[0].length; ++j) {
				assertEquals(efilmMont�[i][j], efilm2[i - A + 1][j - B + 1]);
			}
		}
	}
	
	int getNbImages(Film film) {
		film.rembobiner();
		int i = 0;
		char[][] �cran = Films.getEcran(film);
		while(film.suivante(�cran)) {
			++i;
		}
		return i;
	}

}
