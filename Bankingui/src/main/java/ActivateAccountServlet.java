

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
		
		
		BankLogic logic=(BankLogic) request.getServletContext().getAttribute("logic");
		String type=request.getParameter("operation");
		
		if(type.equals("activate")) {
		String customer=request.getParameter("cusId");
		String account=request.getParameter("accId");
		String message="Account activated Successfully";
	    
		int num=Integer.parseInt(customer);
		int num1=Integer.parseInt(account);
		
		
		
		try {
			logic.changeStatusAccount(num1, num,1);
			 
		   }
		catch(Exception e)
		{
			System.out.println("Exception in Activating Account");
			 request.setAttribute("error", message);
			request.getRequestDispatcher("Activate.jsp").forward(request, response);
		}
		request.setAttribute("message", message);
		 request.getRequestDispatcher("Activate.jsp").forward(request, response);

		
	}
				
		
		if(type.equals("activateCustomer"))
		{
			String cusId=request.getParameter("cusId");
			String message="Customer Activated Successfully";
			int num=Integer.parseInt(cusId);
			try {
				logic.changeCustomerStatusOnly(num,1);
				
			}
			catch(Exception e)
			{
				System.out.println("Exception in Activate Account for Customer");
				request.setAttribute("error", message);
				request.getRequestDispatcher("ActivateCustomer.jsp").forward(request, response);
			}
             request.setAttribute("message", message);
			request.getRequestDispatcher("ActivateCustomer.jsp").forward(request, response);
		}
	

   }
}
