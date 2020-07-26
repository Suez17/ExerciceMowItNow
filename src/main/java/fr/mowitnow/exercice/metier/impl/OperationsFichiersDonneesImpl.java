package fr.mowitnow.exercice.metier.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import fr.mowitnow.exercice.bo.Grille;
import fr.mowitnow.exercice.bo.InformationsEntree;
import fr.mowitnow.exercice.bo.Tondeuse;
import fr.mowitnow.exercice.enumeration.PointCardinal;
import fr.mowitnow.exercice.metier.OperationsFichiersDonnees;

/**
 * Implémentation OperationsFichiersDonnees
 */
public class OperationsFichiersDonneesImpl implements OperationsFichiersDonnees {

	/**
	 * Représentation du caractère espace
	 */
	private static final String CARACTERE_ESPACE = "\\s+";
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public InformationsEntree lireFichierEntree(String chemin) {
		
		InformationsEntree informationsEntree = null;
		
		try {
			BufferedReader reader = Files.newBufferedReader(Paths.get(chemin));
			List<String> lignesFichier = reader.lines().collect(Collectors.toList());
			
			informationsEntree = new InformationsEntree();
			
			String ligneGrille = lignesFichier.get(0);
			String[] infosLigneGrille = ligneGrille.split(CARACTERE_ESPACE);
			int maxX = Integer.parseInt(infosLigneGrille[0]);
			int maxY = Integer.parseInt(infosLigneGrille[1]);
			Grille grille = new Grille(maxX, maxY);
			
			for (int i = 1; i < lignesFichier.size(); i += 2) {
				Tondeuse tondeuse = new Tondeuse();
				String lignePositionTondeuse = lignesFichier.get(i);
				String[] infosLignePositionTondeuse = lignePositionTondeuse.split(CARACTERE_ESPACE);
				int positionX = Integer.parseInt(infosLignePositionTondeuse[0]);
				int positionY = Integer.parseInt(infosLignePositionTondeuse[1]);
				PointCardinal pointCardinal = PointCardinal.valueOf(infosLignePositionTondeuse[2]);
				String instructionTondeuse = lignesFichier.get(i + 1);
				tondeuse.setOrientation(pointCardinal);
				tondeuse.setPositionX(positionX);
				tondeuse.setPositionY(positionY);
				tondeuse.setInstruction(instructionTondeuse);
				informationsEntree.ajouterTondeuse(tondeuse);
			}
			
			informationsEntree.setGrille(grille);
			
		} catch (IOException e) {
			informationsEntree = null;
			e.printStackTrace();
		}
		
		return informationsEntree;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String creerFichierSortie(List<Tondeuse> listeTondeuses) {
		// TODO Auto-generated method stub
		return null;
	}

}
