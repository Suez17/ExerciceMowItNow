package fr.mowitnow.exercice.bo;

import fr.mowitnow.exercice.enumeration.PointCardinal;

/**
 * Représentation d'une tondeuse
 */
public class Tondeuse {

	/**
	 * Orientation initiale
	 */
	private PointCardinal orientationInitiale;
	
	/**
	 * Position X initiale
	 */
	private int positionXInitiale;
	
	/**
	 * Position Y initiale
	 */
	private int positionYInitiale;
	
	/**
	 * Instuction pour se déplacer
	 */
	private String instruction;

	/**
	 * Getter orientationInitiale
	 * 
	 * @return the orientationInitiale
	 */
	public PointCardinal getOrientationInitiale() {
		return orientationInitiale;
	}

	/**
	 * Setter orientationInitiale
	 * 
	 * @param orientationInitiale the orientationInitiale to set
	 */
	public void setOrientationInitiale(PointCardinal orientationInitiale) {
		this.orientationInitiale = orientationInitiale;
	}

	/**
	 * Getter positionXInitiale
	 * 
	 * @return the positionXInitiale
	 */
	public int getPositionXInitiale() {
		return positionXInitiale;
	}

	/**
	 * Setter positionXInitiale
	 * 
	 * @param positionXInitiale the positionXInitiale to set
	 */
	public void setPositionXInitiale(int positionXInitiale) {
		this.positionXInitiale = positionXInitiale;
	}

	/**
	 * Getter positionYInitiale
	 * 
	 * @return the positionYInitiale
	 */
	public int getPositionYInitiale() {
		return positionYInitiale;
	}

	/**
	 * Setter positionYInitiale
	 * 
	 * @param positionYInitiale the positionYInitiale to set
	 */
	public void setPositionYInitiale(int positionYInitiale) {
		this.positionYInitiale = positionYInitiale;
	}

	/**
	 * Getter instruction
	 * 
	 * @return the instruction
	 */
	public String getInstruction() {
		return instruction;
	}

	/**
	 * Setter instruction
	 * 
	 * @param instruction the instruction to set
	 */
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	
}
