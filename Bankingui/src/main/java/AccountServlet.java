

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bankdb.AccountInformation;
import bankdb.*;





public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AccountServlet() {
        super();
        
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	BankLogic logic=new BankLogic();
		String operation=request.getParameter("operation");
		
    	

		if(operation.equals("deactivate"))
		{
			String id=request.getParameter("cusId");
			String accId=request.getParameter("accId");
			int number=Integer.parseInt(id);
			int number1=Integer.parseInt(accId);
			
		try {
			logic.changeStatusAccount(number1, number,0);
		}
		catch(Exception e)
		{
			System.out.println("Exception in deactivate servlet");
		}
		
		request.getRequestDispatcher("Admin.jsp").forward(request, response);
		
		}
		if(operation.equals("deactivateCustomer"))
		{
			String id=request.getParameter("cusId");
			int number=Integer.parseInt(id);
			try {
				logic.changeCustomerstatus(number,0);
			}
			catch(Exception e)
			{
				System.out.println("Exception in deactivate customer Servlet");
			}
			request.getRequestDispatcher("Customer.jsp").forward(request, response);
			
		}
	 
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BankLogic logic=new BankLogic();
		String operation=request.getParameter("operation");
		
	
		
		
		if(operation.equals("addAccount")) {
			
			String name=request.getParameter("customerId");
			String name1=request.getParameter("branch");
			String balance=request.getParameter("balance");
			String status=request.getParameter("status");
			String message="Account added successfully";
			
			boolean bool=Boolean.parseBoolean(status);
			int number=Integer.parseInt(name);
			double balance1=Double.parseDouble(balance);
			
			AccountInformation account=new AccountInformation();
			account.setCustomerId(number);
			account.setBalance(balance1);
			account.setBranch(name1);
			account.setStatus(bool);
			
			
			
			
		try {
			logic.insertAccount(account);
		}
		catch(Exception e)
		{
			System.out.println("Exception in add account servlet");
		}
		
		request.setAttribute("msg",message);
		request.getRequestDispatcher("AddAccount.jsp").forward(request, response);
		System.out.println("add account");
		}
	
	
	if(operation.equals("addCustomer"))
	{
		String name=request.getParameter("Enter Name");
		String address=request.getParameter("Enter Address");
		String mobileNumber=request.getParameter("Enter MobileNumber");
		String email=request.getParameter("Enter email");
		
		String message="Information updated successfully";
		
		PrintWriter out=response.getWriter();
		CustomerInformation custom=new CustomerInformation();
		custom.setCustomerName(name);
		custom.setAddress(address);
		custom.setMobileNumber(mobileNumber);
		custom.setEmail(email);
		
		try {
			logic.insertCustomer(custom);
			
		}
		catch(Exception e)
		{
			out.println("error in inserting details");
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("AddCustomer.jsp").forward(request, response);			
			
		}
		
	 if(operation.equals("updateCustomer")) {
			String name=request.getParameter("replace Name");
			String address=request.getParameter("replace Address");
			String mobilenumber=request.getParameter("replace MobileNumber");
			String mail=request.getParameter("replace email");
			String message="Information updated successfully";
			
			 CustomerInformation custom=new CustomerInformation();
			 custom.setCustomerName(name);
			 custom.setAddress(address);
			 custom.setMobileNumber(mobilenumber);
			 custom.setEmail(mail);
			 
			 
			 try {
				 logic.updationCustomer(custom);
			 }
			 catch(Exception e)
			 {
				 System.out.println("error in updation servlet ");
			 }
			 request.setAttribute("msg",message);
			 request.getRequestDispatcher("UpdateCustomer.jsp").forward(request, response);
		}	
		
	 if(operation.equals("updateAccount"))
	 {
		 
		    String number=request.getParameter("accountId");
			String number1=request.getParameter("customerId");
			String branch=request.getParameter("branch");
			String balance=request.getParameter("balance");
			String status=request.getParameter("status");
			String message="Account Update successfully";
			
			double balance1=Double.parseDouble(balance);
			int numForm=Integer.parseInt(number);
			int numForm1=Integer.parseInt(number1);
			boolean bool=Boolean.parseBoolean(status);
			
			AccountInformation account=new AccountInformation();
			account.setAccountId(numForm);
			account.setCustomerId(numForm1);
			account.setBranch(branch);
			account.setBalance(balance1);
			account.setStatus(bool);
			
		  try {
			  logic.updateAccount(account);
		  }
		  catch(Exception ex)
		  {
			  System.out.println("error in update Account");
		  }
		  request.setAttribute("message",message);
		  request.getRequestDispatcher("UpdateAccount.jsp").forward(request, response);
		
		}
	 
	 
	 if(operation.equals("transaction")) {
			String name=request.getParameter("from accountNumber");
			String name1=request.getParameter("to accountNumber");
			double num=Double.parseDouble(request.getParameter("balance"));
	        String message="Amount Transaction successfully";
	        int number1=Integer.parseInt(name);
	        int number2=Integer.parseInt(name1);
	         
	         
	        
			AccountInformation acc=new AccountInformation();
			acc.setAccountId(number1);
			acc.setAccountId(number2);
			acc.setBalance(num);
		
			
				try {
			
				logic.updateWithdraw(acc);
				logic.updatedeposit(acc);
				
				 
				
				    }
				catch(Exception e)
				  {
					System.out.println("Exception in amount deposit servlet");
					e.printStackTrace();
			}
			
				request.setAttribute("message",message);
				request.getRequestDispatcher("Transaction.jsp").forward(request, response);
				
			}
	 
	 if(operation.equals("transfer"))
		{
			String name=request.getParameter("accnumber");
			String name1=request.getParameter("to accnumber");
			double num=Double.parseDouble(request.getParameter("amount"));
	        String message="Amount Transaction successfully";
	        int number1=Integer.parseInt(name);
	        int number2=Integer.parseInt(name1);
	         
			AccountInformation acc=new AccountInformation();
			acc.setAccountId(number1);
			acc.setAccountId(number2);
			acc.setBalance(num);

				try {
					logic.updateWithdraw(acc);
					logic.updatedeposit(acc);
				
				    }
				catch(Exception e)
				  {
					System.out.println("Exception in amount deposit in account servlet");
					e.printStackTrace();
			}
			
				request.setAttribute("msg",message);
				request.getRequestDispatcher("TransactionInAccount.jsp").forward(request, response);
				
		}
	 

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	}
}
	 