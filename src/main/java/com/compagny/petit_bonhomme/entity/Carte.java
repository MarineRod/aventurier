package com.compagny.petit_bonhomme.entity;

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
    
}
