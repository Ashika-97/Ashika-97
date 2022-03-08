
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.*;
import javax.servlet.http.*;
import bankdb.*;





public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private LogicalLayer logic;
	
	
	@Override
	/*public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		config.getServletContext().setAttribute("logic", new LogicalLayer());
	}*/

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BankLogic logic=new BankLogic();
		LogicalNextLayer log=new LogicalNextLayer();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		
		 userInformation user=null;
		 HttpSession session=request.getSession();
		 
		try {
			user = log.validate(username, password);
		
		} catch (SQLException e1) {
		
			e1.printStackTrace();
		}
		
		 Map<Integer,CustomerInformation> map=null;
		 try {
			 
			if(user!=null && user.getRoleId()==1 )
			 {
				 
				    map=logic.selectCustomer(username);
				    
		    	if(map!=null) {
				    request.setAttribute("Map",map);
				    
					session.setAttribute("user",username);
					
                    request.getRequestDispatcher("Customer.jsp").forward(request, response); 
                   
                    for(Entry<Integer, CustomerInformation> customerMap:map.entrySet())
                    {
                    int cusId=customerMap.getKey();
                    request.setAttribute("mess",cusId);
                    request.getRequestDispatcher("CustomerAccountDetails.jsp").forward(request, response);
                    }
		    	
		    	
		    	}
			 
	}
			
			else if(user!=null && user.getRoleId()==2)
			 {
				 session.setAttribute("user",username);
				 request.getRequestDispatcher("Admin.jsp").forward(request, response);
			 }
		
			
		} 
		 
		catch (Exception e) {
			System.out.println("Error in getting results");
			e.printStackTrace();
		}
}	
}
		 
		 
		 
		
/*for(Entry<Integer, CustomerInformation> customerMap:map.entrySet())
{
int cusId=customerMap.getKey();
request.setAttribute("mess",customerMap);
request.getRequestDispatcher("CustomerAccountDetails.jsp").forward(request, response);
}*/