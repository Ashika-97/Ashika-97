

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bankdb.*;

public class ActivateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ActivateAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String customer=request.getParameter("cusId");
		String account=request.getParameter("accId");
		
	    
		int num=Integer.parseInt(customer);
		int num1=Integer.parseInt(account);
		BankLogic logic=new BankLogic();
		
		
		try {
			logic.changeStatusAccount(num1, num,1);
		   }
		catch(Exception e)
		{
			System.out.println("Exception in Activating Account");
		}
	 
	  
	  request.getRequestDispatcher("Activate.jsp").forward(request, response);
		
	}

}
