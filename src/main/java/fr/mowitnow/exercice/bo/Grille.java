package fr.mowitnow.exercice.bo;

/**
 * Grille représentant la pelouse
 */
public class Grille {
	
	/**
	 * Valeur x maximum
	 */
	private int maxX;
	
	/**
	 * Valeur y maximum
	 */
	private int maxY;
	
	/**
	 * Constructeur avec arguments
	 * 
	 * @param maxX
	 * @param maxY
	 */
	public Grille(int maxX, int maxY) {
		super();
		this.maxX = maxX;
		this.maxY = maxY;
	}

	/**
	 * Getter maxX
	 * 
	 * @return the maxX
	 */
	public int getMaxX() {
		return maxX;
	}

	/**
	 * Setter maxX
	 * 
	 * @param maxX the maxX to set
	 */
	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}

	/**
	 * Getter maxY
	 * 
	 * @return the maxY
	 */
	public int getMaxY() {
		return maxY;
	}

	/**
	 * Setter maxY
	 * 
	 * @param maxY the maxY to set
	 */
	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}
	
	/**
	 * Getter minX
	 * 
	 * @return the minX
	 */
	public int getMinX() {
		return 0;
	}
	
	/**
	 * Getter minY
	 * 
	 * @return the minY
	 */
	public int getMinY() {
		return 0;
	}
	
}
