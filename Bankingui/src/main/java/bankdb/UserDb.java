package bankdb;

	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
	import java.util.Map;

import com.mysql.cj.protocol.Resultset;


	public class UserDb {

		 
		public void creationCustomer()
			{
				
					String query=("CREATE TABLE IF NOT EXISTS Userdb(userId bigint Not Null AUTO_INCREMENT ,"
							+ "userName varchar(25) Not Null,"
							+"password varchar(100),"
							+"roleId int not null,"
							+"customerId int not null,"
							+ " PRIMARY KEY(userId)"
							+ "Foreign Key(roleId) REFERENCES roledb(roleId)); ");
							
					LogicalConnection.creationTable(query);
			}


	
		public  void insertionCustomer(userInformation user) throws Exception
			{ 


			String insert="INSERT INTO Userdb(userName,password,roleId,customerId) VALUES (?,?,?,?);";
			try ( PreparedStatement post=LogicalConnection.getConnection().prepareStatement(insert))
				 {
			
				post.setString(1,user.getUserName());
				post.setString(2,user.getPassword());
				post.setInt(3,user.getRoleId());
				post.setInt(4, user.getCustomerId());
				post.executeUpdate();	
				System.out.println("insertion Of user exceuted successfully ");
				
				 }
			catch(Exception e)
				 {
				     e.printStackTrace();
					 System.out.println("Exception occurs in user dblayer customer insertion");
			}
		 }
		
	
		public userInformation userValidate(String username,String password) throws SQLException
		{
			
			Map<Integer,userInformation> map=new HashMap<>();
			String select="select * from Userdb where userName=? and password=?;";
			userInformation user=new userInformation();
			 
			try(PreparedStatement prepare=LogicalConnection.getConnection().prepareStatement(select))
			{
				prepare.setString(1,username);
				prepare.setString(2,password);
			try(ResultSet result=prepare.executeQuery())
			{  
				 
				while(result.next())
				{
					
					user.setCustomerId(result.getInt("customerId"));
					user.setRoleId(result.getInt("roleId"));
					user.setUserId(result.getInt("userId"));
					user.setUserName(result.getString("userName"));
					user.setPassword(result.getString("password"));
					map.put(user.getUserId(), user);
				}
				
				
			}
			}
			return user;
				
		}
			
		public  Map<String,userInformation> selectionCustomer(userInformation user) throws Exception
			{
				 Map<String,userInformation>  map=new HashMap<>();
				 
				 String query="SELECT userName,userId,roleId,customerId,password From Userdb where userId=?";
				    try(PreparedStatement statement=LogicalConnection.getConnection().prepareStatement(query);
				    		ResultSet result=statement.executeQuery();)
				       {
				    	int name=user.getUserId();
				    	
				    	statement.setInt(1,name);
				    
				    	while(result.next())
				    	  {  
				    		userInformation pojo=new userInformation();
				    	   String number1=result.getString("userId");
				    	   user.setUserName(result.getString("userName"));
				    	   user.setUserId(result.getInt("roleId"));
				    	   user.setUserId(result.getInt("userId"));
				    	   user.setPassword(result.getString("password"));
				    	   user.setCustomerId(result.getInt("customerId"));
				    	   map.put(number1, pojo); 
				    	  }
				    	System.out.println("selection executed in user db layer succcessfully! ");
				    }
				  
				    catch(Exception e)
				   	 {
				    	e.printStackTrace();
				   		 System.out.println("Exception occurs in user dblayer Selection " + e.getMessage());
				    }
					return map;
			}
		
		
		
		         
		public  void updateCustomer(userInformation user) throws Exception
			{

			
			 String updated="Update Userdb  Set userName=? where userId=?";
				try(PreparedStatement create=LogicalConnection.getConnection().prepareStatement(updated);)
				{
					create.setString(1,user.getUserName());
					create.setInt(2,user.getRoleId());
					create.executeUpdate();
					System.out.println("updation successfully in user db layer!");
				}
				 catch(Exception e)
			   	 {
			   		 System.out.println("Exception occurs in Userdb layer update layer ");
			    }
				
			}
		}

		
		
		
		
	
	
	
