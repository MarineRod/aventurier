package com.compagny.petit_bonhomme.service;

import com.compagny.petit_bonhomme.entity.Carte;
import com.compagny.petit_bonhomme.entity.Personnage;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PersonnageService {

	private final CarteHelper carteHelper;


	public boolean deplacer(Personnage personnage, Carte carte, int dx, int dy) {

		int nx = personnage.getX() + dx;
		int ny = personnage.getY() + dy;

		if (carteHelper.estValide(carte, nx, ny)) {
			personnage.setX(nx);
			personnage.setY(ny);
			return true;
		}

		return false;
	}

	public void afficherPosition(Personnage personnage) {
		System.out.println("Position du personnage : x = " + personnage.getX() + ", y = " + personnage.getY());
	}

	public void deplacerDirections(Personnage personnage, String directions, Carte carte) {
		for (char dir : directions.toCharArray()) {
			boolean okDeplacement = true;
			switch (Character.toUpperCase(dir)) {
			case 'N':
				okDeplacement = deplacer(personnage, carte, 0, -1);
				break;
			case 'S':
				okDeplacement = deplacer(personnage, carte, 0, 1);
				break;
			case 'E':
				okDeplacement = deplacer(personnage, carte, 1, 0);
				break;
			case 'O':
				okDeplacement = deplacer(personnage, carte, -1, 0);
				break;
			default:
				System.out.println("Direction invalide : " + dir);
			}

			if (okDeplacement) {
				afficherPosition(personnage);
			} else {
				System.out.println("Déplacement bloqué pour la direction : " + dir);
			}
		}
	}

}
