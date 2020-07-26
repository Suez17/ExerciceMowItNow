package fr.mowitnow.exercice.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * Représentation des informations reçues en entrée
 */
public class InformationsEntree {
	
	/**
	 * Grille de départ
	 */
	private Grille grille;
	
	/**
	 * Liste de tondeuses
	 */
	private List<Tondeuse> listeTondeuses;
	
	/**
	 * Constructeur par défaut
	 */
	public InformationsEntree() {
		this.listeTondeuses = new ArrayList<Tondeuse>();
	}

	/**
	 * Getter grille
	 * 
	 * @return the grille
	 */
	public Grille getGrille() {
		return grille;
	}

	/**
	 * Setter grille
	 * 
	 * @param grille the grille to set
	 */
	public void setGrille(Grille grille) {
		this.grille = grille;
	}
	
	/**
	 * Getter listeTondeuses
	 * 
	 * @return the listeTondeuses
	 */
	public List<Tondeuse> getListeTondeuses() {
		return listeTondeuses;
	}
	
	/**
	 * Ajouter une tondeuse dans la liste
	 * 
	 * @param tondeuse
	 */
	public void ajouterTondeuse(Tondeuse tondeuse) {
		this.listeTondeuses.add(tondeuse);
	}

}
