package com.compagny.petit_bonhomme.entity;

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
	int x, y;
}
