package fr.mowitnow.exercice.metier;

import java.util.List;

import fr.mowitnow.exercice.bo.InformationsEntree;
import fr.mowitnow.exercice.bo.Tondeuse;

/**
 * Op�rations sur des fichiers de donn�es
 */
public interface OperationsFichiersDonnees {

	/**
	 * Lire un fichier de donn�es en entr�e
	 * 
	 * @param chemin
	 * @return les informations d'entr�e
	 */
	InformationsEntree lireFichierEntree(String chemin);
	
	/**
	 * Cr�er un fichier de donn�es en sortie
	 * 
	 * @param listeTondeuses
	 * @return le chemin du fichier de sortie
	 */
	String creerFichierSortie(List<Tondeuse> listeTondeuses);
}
