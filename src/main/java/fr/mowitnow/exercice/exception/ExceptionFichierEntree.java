package fr.mowitnow.exercice.exception;

/**
 * Exception concernant le fichier en entrée
 */
public class ExceptionFichierEntree extends RuntimeException {
	
	public ExceptionFichierEntree(String message) {
		super(message);
	}
}
