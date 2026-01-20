package com.compagny.petit_bonhomme.service;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.compagny.petit_bonhomme.entity.Carte;

@RunWith(MockitoJUnitRunner.class)
public class CarteHelperTest {

	@InjectMocks
	private CarteHelper testedObject;

	@Test
	public void testEstDansLaCarte() {
		
		Carte carte;
		testedObject.estDansLaCarte(carte, null)
	}

}
