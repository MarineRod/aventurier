package com.compagny.petit_bonhomme.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Représente une carte pour le jeu.
 * 
 * La carte est une grille de cases pouvant être libres ou contenir des obstacles.
 * Les coordonnées sont indexées à partir de 0 : (x = 0, y = 0) est en haut à gauche.
 */
@Getter
@Setter
public class Carte {
	private int largeur;
    private int hauteur;
    private int[][] grille;
	
    public Carte(int[][] grille) {
        this.grille = grille;
        this.hauteur = grille.length;    
        this.largeur = grille[0].length;
    }
    
    public boolean estDansLaCarte(int x, int y) {
        return x >= 0 && y >= 0 && x < largeur && y < hauteur;
    }

    public boolean estLibre(int x, int y) {
        return estDansLaCarte(x, y) && grille[y][x] == 0;
    }


    public void afficher() {
        for (int y = 0; y < hauteur; y++) {
            for (int x = 0; x < largeur; x++) {
                System.out.print(grille[y][x] == 1 ? "#" : " ");
            }
            System.out.println();
        }
    }
}
