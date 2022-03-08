package bankdb;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class AccountDb  {

	
	
public void creationAccount()
		{

				String query=("CREATE TABLE IF NOT EXISTS AccountDetails("
						+ "accountId bigint Not Null AUTO_INCREMENT ,"
						+ "customerId bigint,"
						+ "branch varchar(100) Not Null,"
						+ "balance Double,"
						+ "status Tinyint,"
						+ "PRIMARY KEY (accountId),"
						+ "FOREIGN KEY(customerId) REFERENCES CustomerDetails(customerId));");
									
				LogicalConnection.creationTable(query);
		}





public  void insertionAccount(AccountInformation acc1) throws SQLException
	{
	
	            String insert=("INSERT INTO AccountDetails(branch,balance,status,customerId) VALUES (?,?,?,?);");
	            try ( PreparedStatement post=LogicalConnection.getConnection().prepareStatement(insert))
		           	 {
	    	                String branch=acc1.getBranch();
	                    	post.setString(1, branch);
	                     	double balance=acc1.getBalance();
	                     	post.setDouble(2,balance);
	                     	boolean bool=acc1.getStatus();
	                      	post.setBoolean(3,bool);
	                      	int cusId=acc1.getCustomerId();
	                     	post.setInt(4, cusId);
		                  	post.executeUpdate();		
		                	System.out.println("Inserting successfully in Account inserting layer! ");
			          }
	               catch(Exception e)
	  	            {
	                   	e.printStackTrace();
	  		            System.out.println("Exception occurs in Account dblayer insertion"+ e.getMessage());
	                }
			   		  
	 }
		
public  Map<Integer,Map<Integer,AccountInformation >> AllAccounts() throws SQLException
    {
			        
			        Map<Integer,Map<Integer,AccountInformation>> finalMap=new HashMap<>();
			      
			        String query="SELECT * From AccountDetails";
			        try(PreparedStatement statement=LogicalConnection.getConnection().prepareStatement(query);
			    		   ResultSet result=statement.executeQuery();)
			            {
			               	while(result.next())
			    	           {  
			               	       AccountInformation pojo=new AccountInformation();
			               	        //String number1=result.getString("accountId");
			               	       pojo.setAccountId(result.getInt("accountId"));
			               	       int num=pojo.getAccountId();
			    	               pojo.setBalance(result.getDouble("balance"));
			    	               pojo.setBranch(result.getString("branch"));
			    	               pojo.setCustomerId(result.getInt("customerId"));
			    	               pojo.setStatus(result.getBoolean("status"));
			    	               pojo.setAccountId(result.getInt("accountId"));
			    	               Map<Integer, AccountInformation>  map=new HashMap<>();
			    	               map.put(num, pojo);
			       	               finalMap.put(result.getInt("customerId"), map);
			    	           
			    	           }
			    	
			                      
			           }
			  
			        catch(Exception e)
			   	        {
			    	        System.out.println("Exception occurs in dblayer Selection " + e.getMessage());
			            }
			       ;
				return finalMap;	
	}
  
public void changeStatusAccount(int accId,int cusId,int statusnumber)
         {   
	           boolean bool;
	           
	           if(statusnumber==1)
	           {
	        	   bool=true;
	           }
	           else {
	        	   bool=false;
	           }
	                String update="Update AccountDetails Set Status=? Where AccountId=?";
	                try(PreparedStatement state=LogicalConnection.getConnection().prepareStatement(update))
	        	           {
	        	        	   state.setBoolean(1, bool);
	        	        	   state.setInt(2,accId);
	        	        	   state.executeUpdate();
	        	           }
                     
		              
                  
	          catch(Exception e)
	             {
	        	     e.printStackTrace();
	            	 System.out.println("Exception in status changing in Account Db "+ e.getMessage());
	             }
         
         }
  
public Map<Integer,AccountInformation>  activeAccountList(boolean status) throws SQLException
       {
	
	           String query="Select accountId,balance,branch,status From AccountDetails Where status=? ";
               
               Map<Integer,AccountInformation> resultMap=new HashMap<>();
             
              
	           try(PreparedStatement state=LogicalConnection.getConnection().prepareStatement(query);)
	             {
		           state.setBoolean(1,status);
		           try(ResultSet result=state.executeQuery();)
		              {
		               while(result.next())
		                 {
		            	   AccountInformation acc= new AccountInformation();
		            	    int num1=result.getInt("accountId");
		            	    acc.setAccountId(num1);
		            	    acc.setBalance(result.getDouble("balance"));
		            	    acc.setStatus(status);
		            	    acc.setBranch(result.getString("branch"));
		            	    resultMap.put(acc.getAccountId(), acc);
		            	          	   
		                  }
		             }
		
		
		catch(Exception e)
		{
			System.out.println("Exception in activeAccount list "+ e.getMessage());
		}
		System.out.println("Active Account Exceuted!");
	}
	catch(Exception e)
	{
		System.out.println("Exception in activeAccount list "+ e.getMessage());
	}
	return resultMap;
}
    

		
public void amountdeposit(AccountInformation acc) throws SQLException
        
   {
	   
	String query="Select balance from AccountDetails where accountId=?";
	
	try(PreparedStatement state=LogicalConnection.getConnection().prepareStatement(query);)
	{  
		int acc1=acc.getAccountId();
		state.setInt(1,acc1);
		try(ResultSet result=state.executeQuery())
	   {
			double balanceAmount=0;
		if(acc1!=0)
		  {
		   while(result.next())
		     {
			  
			balanceAmount=result.getDouble("balance");
			balanceAmount+=acc.getBalance();
			
		     }
		  
			String modify="update AccountDetails set balance=? where accountId=?";
			try(PreparedStatement create=LogicalConnection.getConnection().prepareStatement(modify);)
			{
			
				create.setDouble(1, balanceAmount);
				create.setInt(2, acc1);
				create.executeUpdate();
				
			}
		  }}
		
		System.out.println("Amount deposited successfully!");	
	}
		
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception in amountDeposit layer in AccountDb");}
	
	}
			
			
public void amountWithdrawalAccount(AccountInformation acc) throws SQLException
{
     int initialAmount=1000;
     String withdraw="select accountId,balance,customerId From AccountDetails where accountId=?";
    try(PreparedStatement post=LogicalConnection.getConnection().prepareStatement(withdraw);)
     {   
	       double balance=acc.getBalance();
	       int id=acc.getAccountId();
	       post.setInt(1,id);
	       try(ResultSet result=post.executeQuery())
	       {
	    	   while(result.next())
	    	   {
	    		   double balanceAmount=0;
	    		   if(balance>initialAmount)
	    		   {
	    			   balanceAmount=result.getDouble("balance");
	    			   balanceAmount-=balance;    			   
	    			   
	    		   }
	    		   String updateAmount="Update AccountDetails set balance=? where accountId=?";
	    		   try(PreparedStatement update=LogicalConnection.getConnection().prepareStatement(updateAmount))
	    		   {
	    			   update.setDouble(1,balanceAmount);
	    			   update.setInt(2,id);
	    			   update.executeUpdate();
	    			   System.out.println("Amount witdrawn successfully");
	    		   }
	    	   }   		   
	    	   }}
	    	   catch(Exception e)
	    	   {
	    		   System.out.println("Exception in withdrawn");
	    	   }
	    	
}
	
		
/*public void amountWithdrawalAccount(AccountInformation acc) throws Exception
	{
		
		int initialAmount=500;
		String query="Select accountId,balance,customerId From AccountDetails where accountId=?";	
		try(PreparedStatement state=LogicalConnection.getConnection().prepareStatement(query);)
		{
			
			double balance=acc.getBalance();
			state.setInt(1,acc.getAccountId());
			try(ResultSet result=state.executeQuery();)
			{
		    	while(result.next())
			      {
		    		double balanceAmount=0;
		    		if(balance<initialAmount) 
		    		{
				    balanceAmount=result.getDouble("balance");
				   
				    balanceAmount-=balance;
				     }
		    		System.out.println("after balance:"+balanceAmount);
		               String update=("Update AccountDetails Set balance=? Where accountId=?;");
		               
		               try(PreparedStatement post=LogicalConnection.getConnection().prepareStatement(update))
				           {
		    	             post.setDouble(1,balanceAmount);
		    	             post.setInt(2,acc.getAccountId());
				             post.executeUpdate();
				             post.executeUpdate();	
				             System.out.println("the balance is "+ balanceAmount);
				             System.out.println("Amount withdrawn successfully ");
				           }
			      }
		}}
			catch(Exception e)
			  {
			       	e.printStackTrace();
				    System.out.println("Exception in amountwithdrawal layer in AccountDb");
			   }
		
		}*/
		
	
public  void updateAccount(AccountInformation account) throws SQLException
  {
          int count=0;
          String updated="Update AccountDetails  Set branch=?,balance=?,status=? where accountId=? and customerId=?";
	      try(PreparedStatement create=LogicalConnection.getConnection().prepareStatement(updated);)
	         {
	    	  String branchName=account.getBranch();
		      create.setString(1, branchName);
		      create.setDouble(2,account.getBalance());
		      boolean bool=account.getStatus();
		      create.setBoolean(3, bool);
		      int accId=account.getAccountId();
		      create.setInt(4, accId);
		      int cusId=account.getCustomerId();
		      create.setInt(5, cusId);
	
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


public  void deletionAccount(AccountInformation account1) throws SQLException
{
	
	String delete="DELETE FROM AccountDetails where accountId=? or customerId=?";
	try(PreparedStatement state=LogicalConnection.getConnection().prepareStatement(delete);) 
	{  
		state.setInt(1, account1.getAccountId());
		state.setInt(2,account1.getCustomerId());
		state.executeUpdate();	
		System.out.println("deleted successfully");
	}
	 catch(Exception e)
   	 {
   		 System.out.println("Exception occurs in dblayer delete");
    }
	
}

public  void dropAccountTable() throws SQLException
  {
		 
     String input="DROP TABLE AccountDetails";
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