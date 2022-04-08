package bankdb;

import java.sql.*;
import java.util.*;


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

public void changeStatusAccountCustomer(int accId,int statusnumber)
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
            
     catch(SQLException e)
        {
   	     e.printStackTrace();
       	 System.out.println("Exception in status changing for custom Account in Account Db "+ e.getMessage());
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
 

public Map<Integer,Map<Integer,AccountInformation>> getAllCustomers(int id) throws SQLException
{
	Map<Integer,Map<Integer,AccountInformation>> accMap=new HashMap<>();
	Map<Integer,AccountInformation> map=new HashMap<>();
	String query="select * From AccountDetails where customerId=?";
	try(PreparedStatement create=LogicalConnection.getConnection().prepareStatement(query))
	{
		create.setInt(1, id);
		try(ResultSet result=create.executeQuery())
		{
			while(result.next()) {
			AccountInformation acc=new AccountInformation();
			acc.setAccountId(result.getInt("accountId"));
			acc.setBalance(result.getDouble("balance"));
			acc.setBranch(result.getString("branch"));
			acc.setStatus(result.getBoolean("status"));
			map.put(acc.getAccountId(),acc);
			accMap.put(id, map);
			
			
		}}
		catch(Exception e)
		{
			System.out.println("Exception in Account to Customer Selection");
		}
		
		
		
		
		
	}
	return accMap;
	
	
}


public ArrayList<String> getCustomersAccountBranch() throws SQLException
{
	
	String query="select distinct branch From AccountDetails ";
	ArrayList<String> list=new ArrayList<String>();
	try(PreparedStatement create=LogicalConnection.getConnection().prepareStatement(query);ResultSet result=create.executeQuery())
	{
			while(result.next()) {
			   String name=result.getString("branch");
		
			    list.add(name);
			
		}}
		catch(Exception e)
		{
			System.out.println("Exception in Account to Customer Selection");
		}
		
	return list;
	
}

		
public void amountdeposit(int number1,int number2,double num) throws SQLException
        
   {
	   
	String query="Select balance from AccountDetails where accountId=?";
	double balanceAmount=0;
	try(PreparedStatement state=LogicalConnection.getConnection().prepareStatement(query);)
	{  
		int acc1=number2;
		state.setInt(1,number2);
		try(ResultSet result=state.executeQuery())
	    {
		
		
		   while(result.next())
		     {
			  
			balanceAmount=result.getDouble("balance");
			balanceAmount+=num;
			
		     }
		  System.out.println("the balance amount is "+ balanceAmount);
			String modify="update AccountDetails set balance=? where accountId=?";
			try(PreparedStatement create=LogicalConnection.getConnection().prepareStatement(modify);)
			{
			
				create.setDouble(1, balanceAmount);
				create.setInt(2, acc1);
				create.executeUpdate();
				
			
		  }}
		
		System.out.println("Amount deposited successfully!");	
	}
		
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception in amountDeposit layer in AccountDb");}
	
	}
			
			
public void amountWithdrawalAccount(int number1,int number2,double num) throws SQLException
{
	
	String updateAmount="Update AccountDetails set balance=? where accountId=?";
	   try(PreparedStatement update=LogicalConnection.getConnection().prepareStatement(updateAmount);ResultSet result=update.executeQuery();)
	   {

		   double amount=num;
		   amount=amount-1000;
		   double balance=result.getDouble("balance");
		   if(balance >amount)
		   {
		   balance=balance-num;
		   }
		   
		   update.setDouble(1,balance);
		   update.setInt(2,number2);
		   update.executeUpdate();
		   System.out.println("Amount witdrawn successfully");
		   }
	
  		   

catch(SQLException e)
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


/*int initialAmount=1000;
String withdraw="select balance From AccountDetails where accountId=?";
try(PreparedStatement post=LogicalConnection.getConnection().prepareStatement(withdraw);)
{   
      
      int id=acc.getAccountId();
      post.setInt(1,id);
      double balance=acc.getBalance();
      System.out.println("balance:"+balance);
      try(ResultSet result=post.executeQuery())
      {
   	   while(result.next())
   	   {
   		   double balanceAmount=0;
   		   balanceAmount=result.getDouble("balance");
   		   if(balanceAmount > initialAmount)
   		   {
   			  
   			   balanceAmount=balanceAmount-balance;    			   
   			   System.out.println("balance:"+balanceAmount);
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
   	   }}*/