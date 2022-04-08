
public class ValidityCheck {

	public void userCheck(String user,String pass) throws Exception
	{
		user=user.trim();
		pass=pass.trim();
		if((user==null && pass==null) || (user.isEmpty() && pass.isEmpty()))
				{
			throw new Exception("name and password cant be empty");
				}
	}
	
	
	public void updateCheck(String operation)  throws Exception
	{
		if(operation==null || operation.isEmpty()) {
		throw new Exception("page couldn't get");
	}}
	
	public void numberCheck(long number) throws Exception{
		if(number<0) {
		throw new Exception("numbers required instead of texts");
	}}
	
	public void checkNumber(int number,int number1) throws Exception{
		if(number<0 || number1<0) {
		throw new Exception("numbers required instead of texts");}
	}
	
	public void intCheck(int number) throws Exception{
		if(number<0)
		throw new Exception("numbers required instead of texts or numbers less than zero");
	}
	
	public void balanceCheck(double number) throws Exception{
		if(number<0) {
		throw new Exception("number less than zero");
	}
	
}
	
	
	
	
}