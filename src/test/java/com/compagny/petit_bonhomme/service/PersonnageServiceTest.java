package com.compagny.petit_bonhomme.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.compagny.petit_bonhomme.entity.Carte;
import com.compagny.petit_bonhomme.entity.Personnage;

@RunWith(MockitoJUnitRunner.class)
public class PersonnageServiceTest {

	@InjectMocks
	private PersonnageService testedObject;

	@Mock
	private CarteHelper carteHelperMock;

	@Test
	public void testDeplacer() {
		int[][] grille = { { 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1 },
				{ 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1 },
				{ 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0 } };

		Carte carte = new Carte(grille);

		Personnage perso = new Personnage(4, 0);
		when(carteHelperMock.estValide(carte, 3, 0)).thenReturn(true);
		testedObject.deplacer(perso, carte, -1, 0);

		assertEquals(3, perso.getX());
		assertEquals(0, perso.getY());
	}

	@Test
	public void testDeplacer_WhenPersoIsBlocked_ReturnsFalse() {

		int[][] grille = { { 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1 },
				{ 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1 },
				{ 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0 } };

		Carte carte = new Carte(grille);

		Personnage perso = new Personnage(3, 0);
		when(carteHelperMock.estValide(carte, 2, 0)).thenReturn(false);
		testedObject.deplacer(perso, carte, -1, 0);

		assertEquals(3, perso.getX());
		assertEquals(0, perso.getY());
	}

	@Test
	public void testDeplacer_WhenPersoIsOut_ReturnsFalse() {
		int[][] grille = { { 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1 },
				{ 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1 },
				{ 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0 } };

		Carte carte = new Carte(grille);

		Personnage perso = new Personnage(0, 0);
		when(carteHelperMock.estValide(carte, 0, -1)).thenReturn(false);
		testedObject.deplacer(perso, carte, 0, -1);

		assertEquals(0, perso.getX());
		assertEquals(0, perso.getY());
	}

	@Test
	public void testDeplacerDirections() {
		int[][] grille = { { 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1 },
				{ 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1 },
				{ 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0 } };

		Carte carte = new Carte(grille);

		Personnage personnage = new Personnage(3, 1);
		String directions = "SEE";
		when(carteHelperMock.estValide(carte, 3, 2)).thenReturn(true);
		when(carteHelperMock.estValide(carte, 4, 2)).thenReturn(true);
		when(carteHelperMock.estValide(carte, 5, 2)).thenReturn(true);
		testedObject.deplacerDirections(personnage, directions, carte);
		assertEquals(5, personnage.getX());
		assertEquals(2, personnage.getY());

	}

	@Test
	public void testDeplacerDirections_WhenInvalidDirection_ThenDoNothing() {
		int[][] grille = { { 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1 },
				{ 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1 },
				{ 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0 } };

		Carte carte = new Carte(grille);

		Personnage personnage = new Personnage(3, 1);
		String directions = "X";
		testedObject.deplacerDirections(personnage, directions, carte);
		assertEquals(3, personnage.getX());
		assertEquals(1, personnage.getY());
		verify(carteHelperMock, never()).estValide(any(Carte.class), anyInt(), anyInt());
	}
	
	@Test
	public void testDeplacerDirections_WhenPersoIsBlocked_ThenDoNothing() {
		int[][] grille = { { 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1 },
				{ 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1 },
				{ 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0 } };

		Carte carte = new Carte(grille);

		Personnage personnage = new Personnage(3, 0);
		String directions = "O";
		testedObject.deplacerDirections(personnage, directions, carte);
		assertEquals(3, personnage.getX());
		assertEquals(0, personnage.getY());
	}
}
