package fr.mowitnow.exercice.metier;

import fr.mowitnow.exercice.bo.InformationsEntree;

/**
 * Interpreteur de parcours de tondeuses
 */
public interface InterpreteurParcoursTondeuses {
	
	/**
	 * Interpreter le parcours des tondeuses dans la grille
	 * 
	 * @param informationsEntree
	 */
	void interpreterParcoursTondeuses(InformationsEntree informationsEntree);
}
