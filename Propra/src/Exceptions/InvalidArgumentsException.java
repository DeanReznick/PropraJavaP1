package Exceptions;

/**
 * The Class InvalidArgumentsException.
 */
public class InvalidArgumentsException extends Exception {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new invalid arguments exception.
	 */
	public InvalidArgumentsException() {
	}

	/**
	 * Instantiates a new invalid arguments exception.
	 *
	 * @param message the message
	 */
	public InvalidArgumentsException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new invalid arguments exception.
	 *
	 * @param cause the cause
	 */
	public InvalidArgumentsException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new invalid arguments exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public InvalidArgumentsException(String message, Throwable cause) {
		super(message, cause);
	}

}
