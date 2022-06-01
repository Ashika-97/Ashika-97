package taxiPojo;

public class CustomException extends Exception{
	
	
	public CustomException(String show)
	{
		super(show);
	}
	
	public CustomException(Exception exception)
	{
		super(exception);
	}

}
