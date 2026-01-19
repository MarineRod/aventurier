package com.compagny.petit_bonhomme.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Personnage dans le jeu qui peut se déplacer sur une carte.
 * 
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Personnage {
	Position position;

	public boolean deplacer(int dx, int dy, Carte carte) {
		int nx = position.getX() + dx;
		int ny = position.getY() + dy;

		if (carte.estLibre(nx, ny)) {
			position.setX(nx);
			position.setY(ny);
			return true;

		}
		return false;
	}

	public void afficherPosition() {
		System.out.println("Position du personnage : x = " + position.getX() + ", y = " + position.getY());
	}

	public void deplacerDirections(String directions, Carte carte) {
		for (char dir : directions.toCharArray()) {
			boolean okDeplacement = true;
			switch (Character.toUpperCase(dir)) {
			case 'N':
				okDeplacement = deplacer(0, -1, carte);
				break;
			case 'S':
				okDeplacement = deplacer(0, 1, carte);
				break;
			case 'E':
				okDeplacement = deplacer(1, 0, carte);
				break;
			case 'O':
				okDeplacement = deplacer(-1, 0, carte);
				break;
			default:
				System.out.println("Direction invalide : " + dir);
			}
			
			if (okDeplacement) {
				afficherPosition();
			} else {
				System.out.println("Déplacement bloqué pour la direction : " + dir);
			}
		}
	}
}
