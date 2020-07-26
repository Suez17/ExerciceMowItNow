package fr.mowitnow.exercice.bo;

import fr.mowitnow.exercice.enumeration.PointCardinal;

/**
 * Représentation d'une tondeuse
 */
public class Tondeuse {

	/**
	 * Orientation
	 */
	private PointCardinal orientation;
	
	/**
	 * Position X
	 */
	private int positionX;
	
	/**
	 * Position Y
	 */
	private int positionY;
	
	/**
	 * Instuction pour se déplacer
	 */
	private String instruction;

	/**
	 * Getter orientation
	 * 
	 * @return the orientation
	 */
	public PointCardinal getOrientation() {
		return orientation;
	}

	/**
	 * Setter orientation
	 * 
	 * @param orientation the orientation to set
	 */
	public void setOrientation(PointCardinal orientation) {
		this.orientation = orientation;
	}

	/**
	 * Getter positionX
	 * 
	 * @return the positionX
	 */
	public int getPositionX() {
		return positionX;
	}

	/**
	 * Setter positionX
	 * 
	 * @param positionX the positionX to set
	 */
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	/**
	 * Getter positionY
	 * 
	 * @return the positionY
	 */
	public int getPositionY() {
		return positionY;
	}

	/**
	 * Setter positionY
	 * 
	 * @param positionY the positionY to set
	 */
	public void setPositionY(int positionY) {
		this.positionY = positionY;
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
	
	/**
	 * Avancer X
	 */
	public void avancerX() {
		this.positionX++;
	}
	
	/**
	 * Reculer X
	 */
	public void reculerX() {
		this.positionX--;
	}
	
	/**
	 * Avancer Y
	 */
	public void avancerY() {
		this.positionY++;
	}
	
	/**
	 * Reculer Y
	 */
	public void reculerY() {
		this.positionY--;
	}

	@Override
	public String toString() {
		return this.positionX + " " + this.positionY + " " + this.orientation;
	}	
	
}
