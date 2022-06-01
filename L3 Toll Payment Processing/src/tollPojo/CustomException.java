package tollPojo;

public class CustomException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CustomException(String source)
	{
		super(source);
	}
	public CustomException(Exception e)
	{
		super(e);
	}

}
