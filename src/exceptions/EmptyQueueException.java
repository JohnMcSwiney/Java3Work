package exceptions;

public class EmptyQueueException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyQueueException() {
		super();
	}

	/*
	 * @param errMes
	 */
	public EmptyQueueException(String errMes) {
		super(errMes);
	}
}
