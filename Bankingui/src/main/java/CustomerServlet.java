

import java.io.IOException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bankdb.AccountInformation;
import bankdb.*;



public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CustomerServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BankLogic logic=new BankLogic();
		String operation=request.getParameter("operation");
		
	 if(operation.equals("updateCustomer")) {
		String name=request.getParameter("replace Name");
		String address=request.getParameter("replace Address");
		String mobilenumber=request.getParameter("replace MobileNumber");
		
		String message="Information updated successfully";
		
		 CustomerInformation custom=new CustomerInformation();
		 custom.setCustomerName(name);
		 custom.setAddress(address);
		 custom.setMobileNumber(mobilenumber);
		 
		 
		 
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
	}	 
}	 
	 
/*	 if(operation.equals("updateAccount"))
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
	  logic.getUpdate(account);
  }
  catch(Exception ex)
  {
	  System.out.println("error in update Account");
  }
  request.setAttribute("message",message);
  request.getRequestDispatcher("UpdateAccount.jsp").forward(request, response);

}
}*/