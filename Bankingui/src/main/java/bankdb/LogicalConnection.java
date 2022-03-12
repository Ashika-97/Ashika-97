package bankdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class LogicalConnection {


     private static String url="jdbc:mysql://localhost/bankdb";
     private static String username="root";
     private static String password="Root@123";
     
     public static void closeConnection() 
     {
    	 if(conn!=null) {
    		 try {
				conn.close();
			} 
    		 catch (SQLException e) {}
    	 }
     }
  
    private  static Connection conn=null;
	
public static Connection getConnection()
{
	if(conn==null) {
		try {
            Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url,username,password);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}

		return conn;

	
}	


public static void creationTable(String query)
{
	  try(Statement createStatement=getConnection().createStatement();)
      {
       createStatement.executeUpdate(query);	
       System.out.println("Table creation First stage complete ");
     } catch (SQLException e) {
		
		e.printStackTrace();
		System.out.println("Exception in customer table : ");
	}
}
	
	
}





