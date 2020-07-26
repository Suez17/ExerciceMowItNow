package fr.mowitnow.exercice.metier;

import java.util.List;

import fr.mowitnow.exercice.bo.InformationsEntree;
import fr.mowitnow.exercice.bo.Tondeuse;

/**
 * Opérations sur des fichiers de données
 */
public interface OperationsFichiersDonnees {

	/**
	 * Lire un fichier de données en entrée
	 * 
	 * @param chemin
	 * @return les informations d'entrée
	 */
	InformationsEntree lireFichierEntree(String chemin);
	
	/**
	 * Créer un fichier de données en sortie
	 * 
	 * @param listeTondeuses
	 * @return le chemin du fichier de sortie
	 */
	String creerFichierSortie(List<Tondeuse> listeTondeuses);
}
