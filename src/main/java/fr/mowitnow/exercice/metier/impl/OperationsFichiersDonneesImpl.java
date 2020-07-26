package fr.mowitnow.exercice.metier.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import fr.mowitnow.exercice.bo.Grille;
import fr.mowitnow.exercice.bo.InformationsEntree;
import fr.mowitnow.exercice.bo.Tondeuse;
import fr.mowitnow.exercice.enumeration.PointCardinal;
import fr.mowitnow.exercice.exception.ExceptionFichierEntree;
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
	 * Erreur concernant le fichier en entrée
	 */
	private static final String ERREUR_FICHIER_ENTREE = "Le fichier d'entrée est mal formaté";
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public InformationsEntree lireFichierEntree(String chemin) throws IOException, ExceptionFichierEntree {
		
		final InformationsEntree informationsEntree = new InformationsEntree();
		BufferedReader reader = null;
		
		try {
			reader = Files.newBufferedReader(Paths.get(chemin));
			List<String> lignesFichier = reader.lines().collect(Collectors.toList());
			
			if ((lignesFichier.size() % 2) == 0) {
				throw new ExceptionFichierEntree(ERREUR_FICHIER_ENTREE);
			}
			
			IntStream
				.range(0, lignesFichier.size() - 1)
				.forEach(i -> this.analyserLignesFichier(lignesFichier, i, informationsEntree));
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		
		return informationsEntree;
	}
	
	/**
	 * Analyser les lignes du fichier
	 * 
	 * @param lignesFichier
	 * @param i
	 * @param informationsEntree
	 * @throws ExceptionFichierEntree
	 */
	private void analyserLignesFichier(List<String> lignesFichier, int i, InformationsEntree informationsEntree) 
			throws ExceptionFichierEntree {
		if (i == 0) {
			Grille grille = this.creerGrille(lignesFichier, i);
			informationsEntree.setGrille(grille);
		} else if ((i % 2) != 0) {
			Tondeuse tondeuse = this.creerTondeuse(lignesFichier, i);
			informationsEntree.ajouterTondeuse(tondeuse);
		}
	}
	
	/**
	 * Créer un objet Tondeuse
	 * 
	 * @param lignesFichier
	 * @param i
	 * @return un objet Tondeuse
	 */
	private Tondeuse creerTondeuse(List<String> lignesFichier, int i) {
		String lignePositionTondeuse = lignesFichier.get(i);
		String[] infosLignePositionTondeuse = lignePositionTondeuse.split(CARACTERE_ESPACE);
		
		if (infosLignePositionTondeuse == null || infosLignePositionTondeuse.length != 3) {
			throw new ExceptionFichierEntree(ERREUR_FICHIER_ENTREE);
		}
		
		Tondeuse tondeuse = null;
		try {
			int positionX = Integer.parseInt(infosLignePositionTondeuse[0]);
			int positionY = Integer.parseInt(infosLignePositionTondeuse[1]);
			PointCardinal pointCardinal = PointCardinal.valueOf(infosLignePositionTondeuse[2]);
			String instructionTondeuse = lignesFichier.get(i + 1);
			
			tondeuse = new Tondeuse();
			tondeuse.setOrientation(pointCardinal);
			tondeuse.setPositionX(positionX);
			tondeuse.setPositionY(positionY);
			tondeuse.setInstruction(instructionTondeuse);
		} catch (IllegalArgumentException e) {
			throw new ExceptionFichierEntree(ERREUR_FICHIER_ENTREE);
		}
		
		return tondeuse;
	}
	
	/**
	 * Créer un objet Grille
	 * 
	 * @param lignesFichier
	 * @param i
	 * @return un objet Grille
	 * @throws ExceptionFichierEntree 
	 */
	private Grille creerGrille(List<String> lignesFichier, int i) throws ExceptionFichierEntree {
		String ligneGrille = lignesFichier.get(i);
		String[] infosLigneGrille = ligneGrille.split(CARACTERE_ESPACE);
		
		if (infosLigneGrille == null || infosLigneGrille.length != 2) {
			throw new ExceptionFichierEntree(ERREUR_FICHIER_ENTREE);
		}
		
		Grille grille = null;
		try {
			int maxX = Integer.parseInt(infosLigneGrille[0]);
			int maxY = Integer.parseInt(infosLigneGrille[1]);
			grille = new Grille(maxX, maxY);
		} catch (NumberFormatException exception) {
			throw new ExceptionFichierEntree(ERREUR_FICHIER_ENTREE);
		}

		return grille;
	}

}
