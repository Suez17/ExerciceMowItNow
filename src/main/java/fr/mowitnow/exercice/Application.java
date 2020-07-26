package fr.mowitnow.exercice;

import java.io.IOException;

import fr.mowitnow.exercice.bo.InformationsEntree;
import fr.mowitnow.exercice.metier.InterpreteurParcoursTondeuses;
import fr.mowitnow.exercice.metier.OperationsFichiersDonnees;
import fr.mowitnow.exercice.metier.impl.InterpreteurParcoursTondeusesImpl;
import fr.mowitnow.exercice.metier.impl.OperationsFichiersDonneesImpl;

/**
 * Classe principale de l'application
 */
public class Application {

	public static void main(String[] args) throws IOException {
		String cheminFichierEntree = args[0];
		InterpreteurParcoursTondeuses interpreteurParcoursTondeuses = new InterpreteurParcoursTondeusesImpl();
		OperationsFichiersDonnees operationsFichiersDonnees = new OperationsFichiersDonneesImpl();
		InformationsEntree informationsEntree = operationsFichiersDonnees.lireFichierEntree(cheminFichierEntree);
		interpreteurParcoursTondeuses.interpreterParcoursTondeuses(informationsEntree);
	}

}
