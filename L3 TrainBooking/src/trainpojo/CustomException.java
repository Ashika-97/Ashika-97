package trainpojo;

public class CustomException extends Exception{
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomException(String exception)
	{
		super(exception);
	}
	
	public CustomException(Exception e)
	{
		super(e);
	}
}
