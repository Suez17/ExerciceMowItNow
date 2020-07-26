package fr.mowitnow.exercice.metier;

import fr.mowitnow.exercice.bo.Grille;
import fr.mowitnow.exercice.bo.Tondeuse;

/**
 * Interpreteur de parcours de tondeuses
 */
public interface InterpreteurParcoursTondeuse {
	
	/**
	 * Interpreter le parcours d'une tonseuse dans la grille
	 * 
	 * @param grille
	 * @param tondeuse
	 */
	void interpreterParcoursTondeuse(Grille grille, Tondeuse tondeuse);
}
