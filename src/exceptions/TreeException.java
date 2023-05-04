package exceptions;

public class TreeException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3453003137947098627L;
	
	/**
	 * 
	 */
	public TreeException()
	{
		super();
	}

	/**
	 * @param inputErrorMessage
	 */
	public TreeException(String inputErrorMessage)
	{
		super(inputErrorMessage);
	}

	/**
	 * @param inputErrorMessage
	 */
	public TreeException(Throwable inputCause)
	{
		super(inputCause);
	}

	/**
	 * @param inputErrorMessage
	 * @param inputArg1
	 */
	public TreeException(String inputErrorMessage, Throwable inputCause)
	{
		super(inputErrorMessage, inputCause);
	}

	/**
	 * @param inputErrorMessage
	 * @param inputArg1
	 * @param inputArg2
	 * @param inputArg3
	 */
	public TreeException(String inputErrorMessage, Throwable inputCause, boolean inputEnableSuppression, boolean inputWritableStackTrace)
	{
		super(inputErrorMessage, inputCause, inputEnableSuppression, inputWritableStackTrace);
	}
}
