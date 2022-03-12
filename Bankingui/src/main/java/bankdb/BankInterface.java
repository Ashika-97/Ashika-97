package bankdb;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public interface BankInterface {
   
	public void creationCustomer();
	
	public  void insertionCustomer(CustomerInformation custom) throws SQLException;
    
	public  Map<Integer,CustomerInformation> selectionCustomer(String userName) throws SQLException;
	
	public  Map<Integer,CustomerInformation> selectionAllCustomer(int id) throws SQLException;
	
	public  Map<Integer,CustomerInformation> selectionCustomers() throws SQLException;
	
	public  void updateCustomer(CustomerInformation custom) throws SQLException;
	
	public void changeStatusCustomer(int cusId,int statusnumber);
	
	public Map<Integer,CustomerInformation>  activeCustomerList(boolean status) throws SQLException;
	
	public void creationAccount();
	
	public  void insertionAccount(AccountInformation acc1) throws SQLException;
	
	public  Map<Integer,Map<Integer,AccountInformation >> AllAccounts() throws SQLException; 
	
	public void changeStatusAccount(int accId,int cusId,int statusnumber);
	
	public void changeStatusAccountCustomer(int accId,int statusnumber); 
	
	public Map<Integer,AccountInformation>  activeAccountList(boolean status) throws SQLException;
	
	public Map<Integer,Map<Integer,AccountInformation>> getAllCustomers(int id) throws SQLException;
	
	public ArrayList<String> getCustomersAccountBranch() throws SQLException;		
	
	public void amountdeposit(AccountInformation acc) throws SQLException;			
	
	public void amountWithdrawalAccount(AccountInformation acc) throws SQLException;
	
	public  void updateAccount(AccountInformation account) throws SQLException;
	
	public  void deletionAccount(AccountInformation account1) throws SQLException;
	
	public  void dropAccountTable() throws SQLException;
	
	public void closeCall();
	
		
}
