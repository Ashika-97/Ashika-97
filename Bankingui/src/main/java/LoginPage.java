
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.http.*;
import bankdb.*;



public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BankLogic logic;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		config.getServletContext().setAttribute("logic", new BankLogic());
		config.getServletContext();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ValidityCheck check=new ValidityCheck();
		LogicalNextLayer log=new LogicalNextLayer();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String type=request.getParameter("type");
	   
		userInformation user=null;

		HttpSession session=request.getSession();
		
		 
		try {
			user = log.validate(username, password);
			} 
		
		catch(SQLException e1) {
		
			e1.printStackTrace();
		}
		
		 try{
			 
			 if(user!=null && user.getRoleId()==1 )
			    {      
				    check.userCheck(username, password);
					session.setAttribute("user",username);
					session.setAttribute("id",user.getCustomerId());
                    request.getRequestDispatcher("Customer.jsp").forward(request, response); 
                      
		    	}
			 
			 else if(user!=null  && user.getRoleId()==2)
			    {
				 check.userCheck(username, password);
				 session.setAttribute("user",username);
				 request.getRequestDispatcher("Admin.jsp").forward(request, response);
			    }
			
			 if(type.equals("logout"))
			   {
				session.invalidate();
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			   }
			
			
			
			else
			  {
				throw new Exception("invalid password");
				
			  }
			 doGet(request,response);
		
		   }
		 catch (Exception e) 
		 {
			 System.out.println("Error in getting results");
			 request.setAttribute("err", e.getMessage());
			 request.getRequestDispatcher("Login.jsp").forward(request, response);

			
		  } 
		
		 
	 }
}	





























		 //  request.setAttribute("mess",cusId);
//request.getRequestDispatcher("CustomerAccountDetails.jsp").forward(request, response);
		 
		 
		
/*for(Entry<Integer, CustomerInformation> customerMap:map.entrySet())
{
int cusId=customerMap.getKey();
request.setAttribute("mess",customerMap);
request.getRequestDispatcher("CustomerAccountDetails.jsp").forward(request, response);
}

*
*
*
*
*
*
*
*
*
*
*
*
*    for(Entry<Integer, CustomerInformation> customerMap:map.entrySet())
                    {
                      cusId=customerMap.getKey();
                     
                    }
                    Map<Integer,Map<Integer,AccountInformation>> accMap= logic.CustomerAccounts(cusId);
                    request.setAttribute("mess", accMap);
                    request.getRequestDispatcher("CustomerAccountDetails.jsp").forward(request, response);
		    	*/