

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bankdb.*;





public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AccountServlet() {
        super();
        
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	BankLogic logic=(BankLogic) request.getServletContext().getAttribute("logic");
		String operation=request.getParameter("operation");
		ValidityCheck check=new ValidityCheck();
    	
		if(operation.equals("deactivate"))
		{
			String id=request.getParameter("cusId");
			String accId=request.getParameter("accId");
			int number=Integer.parseInt(id);
			int number1=Integer.parseInt(accId);
			String message="Account deactivated scuccessfully";
			
		try {
			check.checkNumber(number, number1);
			check.userCheck(id,accId);
			logic.changeStatusAccount(number1, number,0);
			
		}
		catch(Exception e)
		{  request.setAttribute("DeactivateAccount", message);
			System.out.println("Exception in deactivate servlet");
		} 
		request.setAttribute("DeactivateAccount", message);
		request.getRequestDispatcher("Admin.jsp").forward(request, response);
		
		}
		
		if(operation.equals("deactivateCustomer"))
		{
			String id=request.getParameter("cusId");
			int number=Integer.parseInt(id);
			String message="Account Deactivated Successfully";
			try {
				logic.changeCustomerStatusOnly(number,0);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				request.setAttribute("deactivateCustomer", message);
				System.out.println("Exception in deactivate customer Servlet"+e.getMessage());
				
			}
			request.setAttribute("deactivateCustomer", message);
			request.getRequestDispatcher("AllCustomers.jsp").forward(request, response);
			
		}
			
	 
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BankLogic logic=new BankLogic();
		String operation=request.getParameter("operation");
		ValidityCheck check=new ValidityCheck();
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("user"));
		
		if(session.getAttribute("user")==null)
		{
		   request.getRequestDispatcher("Login.jsp").forward(request, response);
			return;
		}
		
		
		

		if(operation.equals("addAccount")) {
		
		
			      
					String name=request.getParameter("customerId");
					String name1=request.getParameter("branch");
					String balance=request.getParameter("balance");
				   
					String message="Account added successfully";
					
					
					//boolean bool=Boolean.parseBoolean(status);
					int number=Integer.parseInt(name);
				
					double balance1=Double.parseDouble(balance);
					
					
					AccountInformation account=new AccountInformation();
					account.setCustomerId(number);
					account.setBalance(balance1);
					account.setBranch(name1);
				
					
					
					
					
				try {
					check.intCheck(number);
					check.updateCheck(operation);
					check.userCheck(name, name1);
					check.userCheck(balance,message);
					logic.insertAccount(account);
					
				}
				catch(ClassNotFoundException|IOException e)
				{
					request.setAttribute("error",message);
					System.out.println("Exception in add account servlet");
				}
				
				catch(Exception ex)
				{
					ex.printStackTrace();
					System.out.println("Exception in addAccount");
				}
		request.setAttribute("message",message);
		request.getRequestDispatcher("AddAccount.jsp").forward(request, response);
		}
	
		
	if(operation.equals("addCustomer"))
	{
		
		String name=request.getParameter("Enter Name");
		String address=request.getParameter("Enter Address");
		String mobileNumber=request.getParameter("Enter MobileNumber");
		String email=request.getParameter("Enter email");
		String message="Information updated successfully";
		long mobile=Long.parseLong(mobileNumber);
	
   try {
		check.userCheck(name,address);
		check.userCheck(mobileNumber, email);
		check.numberCheck(mobile);
		PrintWriter out=response.getWriter();
		CustomerInformation custom=new CustomerInformation();
		custom.setCustomerName(name);
		custom.setAddress(address);
		custom.setMobileNumber(mobile);
		custom.setEmail(email);
		
		try {
			
			logic.insertCustomer(custom);
			
		}
		catch(Exception e)
		{
			request.setAttribute("error", message);
			out.println("error in inserting details");
		}
		}
  catch(Exception e)
   {
	  request.setAttribute("error", message);
	  System.out.println("Exception in addCustomer");
   }
   
    request.setAttribute("message", message);
	request.getRequestDispatcher("AddCustomer.jsp").forward(request, response);
	}
	
	 if(operation.equals("updateCustomer")) {
			String name=request.getParameter("replace Name");
			String trim=name.trim();
			String address=request.getParameter("replace Address");
			String mobilenumber=request.getParameter("replace MobileNumber");
			String mail=request.getParameter("replace email");
			String message="Information updated successfully";
	 try {
			 check.userCheck(trim,address);
			 check.userCheck(mobilenumber,mail);
			 check.updateCheck(operation);
			 Long number=Long.parseLong(mobilenumber);
			 check.numberCheck(number);
			 CustomerInformation custom=new CustomerInformation();
			 custom.setCustomerName(trim);
			 custom.setAddress(address);
			 custom.setMobileNumber(number);
			 custom.setEmail(mail);
			 
			 
			 try {
				 logic.updationCustomer(custom);
			 }
			 catch(IOException|ClassNotFoundException e)
			 {
				 request.setAttribute("error",message);
				 System.out.println("Exception in input mismatch update Customer");
			 }}
			 catch(Exception e)
			 {
				 request.setAttribute("error",message);
				 System.out.println("error in updation servlet ");
			 }
			request.setAttribute("message", message);
			 request.getRequestDispatcher("UpdateCustomer.jsp").forward(request, response);
		}	
		
	 if(operation.equals("updateAccount"))
	 {
		 
		  
			String number1=request.getParameter("customerId");
			String branch=request.getParameter("branch");
			String balance=request.getParameter("balance");
			String status=request.getParameter("status");
			String message="Account updated Successfully ";
						
		try {
			check.userCheck(status,number1);
		    check.userCheck(branch, balance);
		    check.updateCheck(operation);
			
			double balance1=Double.parseDouble(balance);
			check.balanceCheck(balance1);
			
			int numForm1=Integer.parseInt(number1);
			check.intCheck(numForm1);
			boolean bool=Boolean.parseBoolean(status);
			
			AccountInformation account=new AccountInformation();
			
			account.setCustomerId(numForm1);
			account.setBranch(branch);
			account.setBalance(balance1);
			account.setStatus(bool);
			
		
			logic.updateAccount(account);
		
		}
		catch(Exception ex)
		{
			 request.setAttribute("error",message);
			 ex.printStackTrace();
			System.out.println("Exception in updating account status");
		}
		 request.setAttribute("updateAccount",message);
		  request.getRequestDispatcher("UpdateAccount.jsp").forward(request, response);
	 }
	 
	 if(operation.equals("transaction")) {
			String name=request.getParameter("accId");
			String name1=request.getParameter("AccId1");
			double num=Double.parseDouble(request.getParameter("balance"));
	        String transfer="Amount Transcated Successfully";
	        
	        int numBer=Integer.parseInt(name);
	        int number2=Integer.parseInt(name1);
	      
	       
	      
	       try {
	    	 check.userCheck(name, name1);
	    	 check.checkNumber(numBer, number2);
		     check.balanceCheck(num);
		    
		    
		        
		
		
			
				try {
			            logic.updateWithdraw(numBer, number2, number2);
						logic.updatedeposit(numBer,number2,num);		
				    
						
				
					}
				catch(ClassNotFoundException|IOException e)
				  {
					request.setAttribute("error",transfer);
					System.out.println("Exception in amount deposit servlet");
					e.printStackTrace();
		         	}
			
				request.setAttribute("message",transfer);
				request.getRequestDispatcher("Transaction.jsp").forward(request, response);
				
			}
	       catch(Exception ex)
	       {
	    	   ex.printStackTrace();
	    	   System.out.println("Exception in transaction ");
	       }
	 }
	 
	 if(operation.equals("transfer"))
		{
			String name=request.getParameter("accId");
			String name1=request.getParameter("AccId1");
			String message="Amount Transaction successfully";
	      try  {
	        
	        check.userCheck(name, name);

			double num=Double.parseDouble(request.getParameter("amount"));
	      
	        int number1=Integer.parseInt(name);
	        int number2=Integer.parseInt(name1);
	        check.updateCheck(message);
	        check.checkNumber(number2, number1);
	        AccountInformation acc=new AccountInformation();
			acc.setAccountId(number1);
			acc.setAccountId(number2);
			acc.setBalance(num);  

				try {
				    logic.updateWithdraw(number1, number2, number2);
					logic.updatedeposit(number1,number2,num);
				
				    }
				catch(ClassNotFoundException|IOException e)
				  {
					request.setAttribute("error",message);
					System.out.println("Exception in amount deposit in account servlet");
					e.printStackTrace();
			}
			
				
	      }
	      catch(Exception e)
	      {
	    	  request.setAttribute("error",message);
	    	  e.printStackTrace();
	    	  System.out.println("Exception in transfer");

	      }
	      request.setAttribute("message",message);
		  request.getRequestDispatcher("TransactionInAccount.jsp").forward(request, response);
		}
		 
	 
	}
}
	 