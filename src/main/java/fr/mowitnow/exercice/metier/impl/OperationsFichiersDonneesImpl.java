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
	public InformationsEntree lireFichierEntree(String chemin) throws IOException {
		
		final InformationsEntree informationsEntree = new InformationsEntree();
		
		BufferedReader reader = Files.newBufferedReader(Paths.get(chemin));
		List<String> lignesFichier = reader.lines().collect(Collectors.toList());
		
		IntStream
			.range(0, lignesFichier.size() - 1)
			.forEach(i -> {
				if (i == 0) {
					String ligneGrille = lignesFichier.get(i);
					String[] infosLigneGrille = ligneGrille.split(CARACTERE_ESPACE);
					int maxX = Integer.parseInt(infosLigneGrille[0]);
					int maxY = Integer.parseInt(infosLigneGrille[1]);
					Grille grille = new Grille(maxX, maxY);
					informationsEntree.setGrille(grille);
				} else if ((i % 2) != 0) {
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
			});
		
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
