package exceptions;

public class FullQueueException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FullQueueException() {
		super();
	}

	/*
	 * @param inputErrorMessage
	 */

	public FullQueueException(String err_message) {
		super(err_message);
	}
}
