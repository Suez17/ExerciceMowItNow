package fr.mowitnow.exercice.metier;

import java.io.IOException;
import java.util.List;

import fr.mowitnow.exercice.bo.InformationsEntree;
import fr.mowitnow.exercice.bo.Tondeuse;
import fr.mowitnow.exercice.exception.ExceptionFichierEntree;

/**
 * Op�rations sur des fichiers de donn�es
 */
public interface OperationsFichiersDonnees {

	/**
	 * Lire un fichier de donn�es en entr�e
	 * 
	 * @param chemin
	 * @return les informations d'entr�e
	 * @throws IOException 
	 */
	InformationsEntree lireFichierEntree(String chemin) throws IOException, ExceptionFichierEntree;
}
