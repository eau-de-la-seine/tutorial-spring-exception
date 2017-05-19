package fr.ekinci.tutorialspringexception.exceptions;

/**
 * @author Gokan EKINCI
 */
public class WrongAddressException extends RuntimeException {
	public WrongAddressException(String message) {
		super(message);
	}
}
