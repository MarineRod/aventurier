package com.compagny.petit_bonhomme;

import com.compagny.petit_bonhomme.domain.Carte;
import com.compagny.petit_bonhomme.domain.Personnage;
import com.compagny.petit_bonhomme.domain.Position;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		int[][] grille = {
				{1,1,1,0,0,0,0,1,1,1,1,1,1,0,0,0,1,1,1},
			    {1,1,1,0,0,0,0,0,1,1,0,0,0,0,0,1,1,1,1},
			    {1,1,0,0,0,0,1,1,0,0,1,1,0,0,0,1,1,0,0},
			    {1,0,0,0,0,0,1,1,0,0,1,1,0,0,0,0,0,0,1},
			    {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
			    {1,1,1,1,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1},
			    {1,1,1,1,1,1,0,0,1,1,0,0,1,1,1,1,1,0,0},
			    {0,1,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,1,0},
			    {0,0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0,0,0},
			    {0,0,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0},
			    {0,0,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0},
			    {0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,1},
			    {0,1,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,1,1},
			    {1,1,1,1,1,1,0,0,1,1,0,0,1,1,1,1,1,1,1},
			    {1,1,1,1,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1},
			    {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			    {1,0,0,0,1,1,0,1,0,0,0,1,0,0,1,1,0,0,1},
			    {1,1,0,0,0,1,1,0,0,0,0,0,0,1,1,0,0,1,1},
			    {1,1,1,0,0,1,0,0,0,0,0,0,1,0,0,1,1,1,1},
			    {1,1,1,0,0,1,1,1,1,1,1,1,1,0,0,1,1,1,1}
			};
		Carte carte = new Carte(grille);
	
		carte.afficher();
		Personnage perso = new Personnage();
		perso.setPosition(new Position(3, 0));
		perso.afficherPosition();
		String directions = "SSSSEEEEEENN";
		perso.deplacerDirections(directions, carte);
        perso.afficherPosition();
        
        System.out.println("==================");
        Personnage perso2 = new Personnage();
        perso2.setPosition(new Position(6,7));
        perso2.afficherPosition();
        String directions2 ="OONOOOSSO";
        perso2.deplacerDirections(directions2, carte);
        perso2.afficherPosition();
        
	
	}
}
