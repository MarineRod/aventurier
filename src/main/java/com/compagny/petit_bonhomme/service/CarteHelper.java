package com.compagny.petit_bonhomme.service;

import com.compagny.petit_bonhomme.entity.Carte;
import com.compagny.petit_bonhomme.entity.Personnage;

public class CarteHelper {
	
	private boolean coordonneesValides(Carte carte, int x, int y) {
	    return x >= 0 && y >= 0 && x < carte.getLargeur() && y < carte.getHauteur();
	}

	public boolean estDansLaCarte(Carte carte, Personnage personnage) {
	    if (personnage == null) return false;
	    return coordonneesValides(carte, personnage.getX(), personnage.getY());
	}

	public boolean estValide(Carte carte, int x, int y) {
		 if (!coordonneesValides(carte, x, y)) return false;
		    return carte.getGrille()[y][x] == 0;
		}

	public void afficher(Carte carte) {
		for (int y = 0; y < carte.getHauteur(); y++) {
			for (int x = 0; x < carte.getLargeur(); x++) {
				System.out.print(carte.getGrille()[y][x] == 1 ? "#" : " ");
			}
			System.out.println();
		}
	}

}
