package bankdb;
import java.sql.*;
import java.util.*;


public class Roledb {
	      

public void creationAccount()
		{

				String query=("CREATE TABLE IF NOT EXISTS Roledb("
						+ "roleId bigint Not Null AUTO_INCREMENT ,"
						+ "roleName varchar(100) Not Null,"
						+ "PRIMARY KEY (roleId),");
									
				LogicalConnection.creationTable(query);
		}

public  void insertionAccount(RoleInformation role) throws Exception
	{
	
	            String insert=("INSERT INTO Roledb(roleName) VALUES (?) where roleId=?;");
	            try ( PreparedStatement post=LogicalConnection.getConnection().prepareStatement(insert))
		           	 {
	    	                String name=role.getRoleName();     
	                    	post.setString(1,name);
	                    	int id= role.getRoleId();
	                    	post.setInt(2,id);
		                  	post.executeUpdate();		
		                	System.out.println("Inserting successfully in Account inserting layer! ");
			          }
	               catch(Exception e)
	  	            {
	                   	e.printStackTrace();
	  		            System.out.println("Exception occurs in Account dblayer insertion");
	                }
			   		  
	 }
		
public  Map<String,Map<String,RoleInformation >> selectionParticularly(RoleInformation account) throws Exception
    {
			        Map<String, RoleInformation>  map=new HashMap<>();
			        Map<String,Map<String,RoleInformation>> finalMap=new HashMap<>();
			      
			        String query="SELECT roleName From Roledb where roleId=?";
			        try(PreparedStatement statement=LogicalConnection.getConnection().prepareStatement(query);)
			    		
			            {
			        	statement.setInt(1,account.getRoleId());
			        	try(   ResultSet result=statement.executeQuery();){
			               	while(result.next())
			    	           {  
			               	       RoleInformation pojo=new RoleInformation();
			    	               String number1=result.getString("roleId");
			    	               pojo.setRoleName(result.getString("roleName"));
			    	               map.put(number1, pojo);
			       	               finalMap.put(number1, map);
			    	           
			    	           }}
			    	
			                       System.out.println("Selection in Account get");
			           }
			  
			        catch(Exception e)
			   	        {
			    	        System.out.println("Exception occurs in dblayer Selection " + e.getMessage());
			            }
				return finalMap;	
	}

public  Map<Integer,Map<Integer,RoleInformation >> allAccounts() throws Exception
{
		        Map<Integer, RoleInformation>  map=new HashMap<>();
		        Map<Integer,Map<Integer,RoleInformation>> finalMap=new HashMap<>();
		      
		        String query="SELECT * From Roledb";
		        try(PreparedStatement statement=LogicalConnection.getConnection().prepareStatement(query);ResultSet result=statement.executeQuery();)
		    		
		            {
		               	while(result.next())
		    	           {  
		               		RoleInformation pojo=new RoleInformation();
		    	               int number1=result.getInt("roleId");
		    	               pojo.setRoleName(result.getString("roleName"));
		    	               map.put(number1, pojo);
		       	               finalMap.put(number1, map);
		    	           
		    	           }
		    	
		                       System.out.println("Selection in Account get");
		            }
		  
		        catch(Exception e)
		   	        {
		    	        System.out.println("Exception occurs in dblayer Selection " + e.getMessage());
		            }
			return finalMap;	
}


public RoleInformation adminvalidate(String roleName,int id) throws SQLException
{

	Map<Integer,RoleInformation> map=null;
	RoleInformation role=new RoleInformation(); 
	String selectquery="select * from Roledb where roleName=? and roleId=?";
	try(PreparedStatement statement=LogicalConnection.getConnection().prepareStatement(selectquery))
	{
	statement.setString(1,roleName);
	statement.setInt(2, id);
	try(ResultSet result=statement.executeQuery();)
	{
		while(result.next())
		{
			
			role.setRoleId(result.getInt("roleId"));
			role.setRoleName(result.getString("roleName"));
		    map.put(role.getRoleId(), role);	
		}
	}
	
  }
	return role;
}



public  void updateAccount(RoleInformation role) throws Exception
  {
          int count=0;
          String updated="Update Roledb  Set roleName=? where roleId=?";
	      try(PreparedStatement create=LogicalConnection.getConnection().prepareStatement(updated);)
	         {
	    	 
		      create.setString(1,role.getRoleName());
		      create.setInt(2,role.getRoleId());
		    count=create.executeUpdate();
		    System.out.println(" updation successfully ");
	         }
	       catch(Exception e)
   	        {
	    	   e.printStackTrace();
   		       System.out.println("Exception occurs in dblayer drop ");
                    }
	        System.out.println("the update count is "+ count);
	        
}


public  void deletionAccount(RoleInformation role) throws Exception
{
	
	String delete="DELETE FROM Roledb where roleId=? ";
	try(PreparedStatement state=LogicalConnection.getConnection().prepareStatement(delete);) 
	{  
		state.setInt(1,role.getRoleId());
		state.executeUpdate();	
		System.out.println("deleted successfully");
	}
	 catch(Exception e)
   	 {
   		 System.out.println("Exception occurs in dblayer delete");
    }
	
}

public  void dropAccountTable() throws Exception
  {
		 
     String input="DROP TABLE Roledb";
 	 try(Statement state=LogicalConnection.getConnection().createStatement();)
 	 {  
 		state.executeUpdate(input);
 		System.out.println("drop statement executed"); 
 	 }
 	 catch(Exception e)
 	 {
 		 System.out.println("Exception occurs in dblayer drop");
  }

}

public void closeCall() 
{
	LogicalConnection.closeConnection();

}

}

		

		
