package fr.mowitnow.exercice.metier.impl;

import java.util.Arrays;
import java.util.List;

import fr.mowitnow.exercice.bo.Grille;
import fr.mowitnow.exercice.bo.InformationsEntree;
import fr.mowitnow.exercice.bo.Tondeuse;
import fr.mowitnow.exercice.enumeration.PointCardinal;
import fr.mowitnow.exercice.metier.InterpreteurParcoursTondeuses;

/**
 * Implémentation InterpreteurParcoursTondeuse
 */
public class InterpreteurParcoursTondeusesImpl implements InterpreteurParcoursTondeuses {

	/**
	 * Action rotation droite
	 */
	private static final char ACTION_ROTATION_DROITE = 'D';
	
	/**
	 * Action rotation gauche
	 */
	private static final char ACTION_ROTATION_GAUCHE = 'G';
	
	/**
	 * Action avancer
	 */
	private static final char ACTION_AVANCER = 'A';
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void interpreterParcoursTondeuses(InformationsEntree informationsEntree) {
		final Grille grille = informationsEntree.getGrille();
		final List<Tondeuse> listeTondeuses = informationsEntree.getListeTondeuses();

		listeTondeuses.stream().forEach(tondeuse -> {
			String instruction = tondeuse.getInstruction();
			instruction.chars().forEach(action -> {
				switch (action) {
					case ACTION_ROTATION_DROITE: {
							PointCardinal[] pointsCardinaux = PointCardinal.values();
							int iOrientation = Arrays.binarySearch(pointsCardinaux, tondeuse.getOrientation());
							iOrientation++;
							if (iOrientation >= pointsCardinaux.length) {
								iOrientation = 0;
							}
							tondeuse.setOrientation(pointsCardinaux[iOrientation]);
						}
						break;
					case ACTION_ROTATION_GAUCHE: {
							PointCardinal[] pointsCardinaux = PointCardinal.values();
							int iOrientation = Arrays.binarySearch(pointsCardinaux, tondeuse.getOrientation());
							iOrientation--;
							if (iOrientation < 0) {
								iOrientation = pointsCardinaux.length - 1;
							}
							tondeuse.setOrientation(pointsCardinaux[iOrientation]);
						}
						break;
					case ACTION_AVANCER: 
						avancerTondeuse(tondeuse, grille);
						break;
				}
			});
		});
		
	}
	
	/**
	 * Avancer une tondeuse dans la grille
	 * 
	 * @param tondeuse
	 * @param grille
	 */
	private void avancerTondeuse(Tondeuse tondeuse, Grille grille) {
		switch (tondeuse.getOrientation()) {
			case E:
				if (tondeuse.getPositionX() < grille.getMaxX()) {
					tondeuse.avancerX();
				}
				break;
			case N:
				if (tondeuse.getPositionY() < grille.getMaxY()) {
					tondeuse.avancerY();
				}
				break;
			case S:
				if (tondeuse.getPositionY() > 0) {
					tondeuse.reculerY();
				}
				break;
			case W:
				if (tondeuse.getPositionX() > 0) {
					tondeuse.reculerX();
				}
				break;
		}
	}

}
