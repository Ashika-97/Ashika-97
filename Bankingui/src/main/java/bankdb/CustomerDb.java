package bankdb;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CustomerDb{

	
	
	  
	public void creationCustomer()
		{
			
				String query=("CREATE TABLE IF NOT EXISTS CustomerDetails(CustomerId bigint Not Null AUTO_INCREMENT ,"
						+ "CustomerName varchar(25) Not Null,"
						+ "address varchar(255) Not Null,"
						+ "mobileNumber BigInt,"
						+"status tinyInt,"
						+"Email varchar(100),"
						+ " PRIMARY KEY (CustomerId));");
				
				LogicalConnection.creationTable(query);
		}

	public  void insertionCustomer(CustomerInformation custom) throws Exception
		{ 


		String insert="INSERT INTO CustomerDetails(CustomerName,MobileNumber,address,status,Email) VALUES (?,?,?,?,?);";
		try ( PreparedStatement post=LogicalConnection.getConnection().prepareStatement(insert))
			 {
			String name=custom.getCustomerName();
			if(name.isEmpty() || name==null)
			{
				throw new Exception("name cant be empty in accounts");
			}
			post.setString(1, name);
			long mobNo=custom.getMobileNumber();
			post.setLong(2, mobNo);
			String address=custom.getAddress();
			post.setString(3,address);
			post.setBoolean(4,true);
			post.setString(5,custom.getEmail());
			post.executeUpdate();	
			System.out.println("insertion Of Customer exceuted successfully ");
			
			 }
		catch(SQLException e)
			 {
			     e.printStackTrace();
				 System.out.println("Exception occurs in customer dblayer customer insertion");
		}
	 }
		
	public  Map<Integer,CustomerInformation> selectionCustomer(String userName) throws SQLException
		{
			 Map<Integer,CustomerInformation>  map=new HashMap<>();
			 
			 String query="SELECT * From CustomerDetails where customerName=?";
			    try(PreparedStatement statement=LogicalConnection.getConnection().prepareStatement(query);)
			       {
			    	statement.setString(1, userName);
			    	try(ResultSet result=statement.executeQuery();){
			    	while(result.next())
			    	  {  
			    	   CustomerInformation pojo=new CustomerInformation();
			    	   int number1=result.getInt("customerId");
			    	   pojo.setCustomerId(number1);
			    	   pojo.setCustomerName(result.getString("customerName"));
			    	   pojo.setAddress(result.getString("address"));
			    	   pojo.setMobileNumber(result.getLong("mobileNumber"));
			    	   pojo.setStatus(result.getBoolean("status"));
			    	   pojo.setEmail(result.getString("Email"));
			    	   map.put(1, pojo); 
			    	  }
			    	System.out.println("selection executed in customer db layer succcessfully! ");
			    }
			       }	  
			    catch(SQLException e)
			   	 {
			   		 System.out.println("Exception occurs in customer dblayer Selection " + e.getMessage());
			    }
				return map;
		}
	       
	
	
	public  Map<Integer,CustomerInformation> selectionAllCustomer(int id) throws SQLException
	{
		 Map<Integer,CustomerInformation>  map=new HashMap<>();
		 
		 String query="SELECT * From CustomerDetails where customerId=? ";
		    try(PreparedStatement statement=LogicalConnection.getConnection().prepareStatement(query);)
		    { 
		    	statement.setInt(1, id);
		    	try(ResultSet result=statement.executeQuery();)
		    	{
		    	while(result.next())
		    	  {  
		    	   CustomerInformation pojo=new CustomerInformation();
		    	   int number1=result.getInt("customerId");
		    	   pojo.setCustomerId(number1);
		    	   pojo.setCustomerName(result.getString("customerName"));
		    	   pojo.setAddress(result.getString("address"));
		    	   pojo.setMobileNumber(result.getLong("mobileNumber"));
		    	   pojo.setStatus(result.getBoolean("status"));
		    	   pojo.setEmail(result.getString("Email"));
		    	   map.put(number1, pojo); 
		    	  }
		    	System.out.println("selection executed in customer db layer succcessfully! ");
		    }}
		       	  
		    catch(SQLException e)
		   	 {
		   		 System.out.println("Exception occurs in customer dblayer Selection " + e.getMessage());
		    }
			return map;
	}
	
	
	public  Map<Integer,CustomerInformation> selectionCustomers() throws SQLException
	{
		 Map<Integer,CustomerInformation>  map=new HashMap<>();
		 
		 String query="SELECT * From CustomerDetails ";
		    try(PreparedStatement statement=LogicalConnection.getConnection().prepareStatement(query);ResultSet result=statement.executeQuery();)
		    { 
		    	while(result.next())
		    	  {  
		    	   CustomerInformation pojo=new CustomerInformation();
		    	   int number1=result.getInt("customerId");
		    	   pojo.setCustomerId(number1);
		    	   pojo.setCustomerName(result.getString("customerName"));
		    	   pojo.setAddress(result.getString("address"));
		    	   pojo.setMobileNumber(result.getLong("mobileNumber"));
		    	   pojo.setStatus(result.getBoolean("status"));
		    	   pojo.setEmail(result.getString("Email"));
		    	   map.put(number1, pojo); 
		    	  }
		    	System.out.println("selection executed in customer db layer succcessfully! ");
		    }
		       	  
		    catch(SQLException e)
		   	 {
		   		 System.out.println("Exception occurs in customer dblayer Selection " + e.getMessage());
		    }
			return map;
	}
	
	
	
	public  void updateCustomer(CustomerInformation custom) throws SQLException
		{

		
		 String updated="Update CustomerDetails  Set customerName=?,mobileNumber=?,address=?,Email=? where customerId=?";
			try(PreparedStatement create=LogicalConnection.getConnection().prepareStatement(updated);)
			{
				String name=custom.getCustomerName();
				create.setString(1, name);
				create.setLong(2,custom.getMobileNumber());
				create.setString(3,custom.getAddress());
				int id1=custom.getCustomerId();
				create.setInt(4, id1);
				create.setString(4,custom.getEmail());
				create.executeUpdate();
				System.out.println("updation successfully in customer db layer!");
			}
			 catch(SQLException e)
		   	 {
		   		 System.out.println("Exception occurs in customer dblayer update layer ");
		    }
			
		}
	
	public void changeStatusCustomer(int cusId,int statusnumber)
    {   
          boolean bool;
          
          if(statusnumber==1)
          {
       	   bool=true;
          }
          else {
       	   bool=false;
          }
               String update="Update CustomerDetails Set status=? Where customerId=?";
               try(PreparedStatement state=LogicalConnection.getConnection().prepareStatement(update))
       	           {
       	        	   state.setBoolean(1, bool);
       	        	   state.setInt(2,cusId);
       	        	  int row= state.executeUpdate();
       	        	  System.out.println(row);
       	           }
                
         catch(Exception e)
            {
       	     e.printStackTrace();
           	 System.out.println("Exception in status changing in Account Db "+ e.getMessage());
            }
    }
	
	public Map<Integer,CustomerInformation>  activeCustomerList(boolean status) throws SQLException
    {
	
	           String query="Select * From CustomerDetails Where status=? ";
            
            Map<Integer,CustomerInformation> resultMap=new HashMap<>();
          
           
	           try(PreparedStatement state=LogicalConnection.getConnection().prepareStatement(query);)
	             {
		           state.setBoolean(1,status);
		           try(ResultSet result=state.executeQuery();)
		              {
		               while(result.next())
		                 {
		            	   CustomerInformation custom= new CustomerInformation();
		            	    int num1=result.getInt("customerId");
		            	    custom.setCustomerId(num1);
		            	    custom.setCustomerName(result.getString("customerName"));
		            	    custom.setAddress(result.getString("address"));
		            	    custom.setMobileNumber(result.getLong("mobileNumber"));
		            	    resultMap.put(num1, custom);
		            	          	   
		                  }
		             }
		           catch(SQLException e)
		           {
		        	   System.out.println("Exception in customer activation");
		           }
	             }
	           catch(Exception ex)
	           {
	        	   System.out.println("Exception in customer active");
	           }
	       return resultMap;    
    }   
	
	
	
	
}






/*<select name="cusId">
<%
BankLogic bank1=new BankLogic();
Map<Integer,CustomerInformation> cusMap=bank1.selectAllCustomer();
for(Map.Entry<Integer,CustomerInformation> map:cusMap.entrySet())
{
	int cusId=map.getKey();

%>
<option value="customerId"><%= cusId%></option>s
<%}

%>
</select>*/