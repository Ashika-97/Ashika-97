package bankdb;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class LogicalLayer {

	BankInterface bank=new BankLogic();
	BankCache cache=new BankCache();
		
		public void getCustomerCreation() throws Exception
		{
			bank.creationCustomer();
		}
		
		public void InsertionCustomer(CustomerInformation custom1) throws Exception
		{
			bank.insertionCustomer(custom1);
		}
		
		public  Map<Integer,CustomerInformation> getSelectionCustomer(String userName) throws Exception
		{
			Map<Integer,CustomerInformation> map=bank.selectionCustomer(userName);
			return map;
		}
		
		public  Map<Integer,CustomerInformation> getSelectonlyCustomer() throws Exception
		{
			 Map<Integer,CustomerInformation> map=bank.selectionCustomers();
			 return map;
		}
		
		public Map<Integer,CustomerInformation> getselectCustomerById(int id) throws SQLException
		{
			Map<Integer,CustomerInformation> map=bank.selectionAllCustomer(id);
			return map;
		}
		
		public void changeStatusForCustomerOnly(int cusId,int status)
		{
			bank.changeStatusCustomer(cusId, status);
		}
		
		
		public void UpdationCustomer(CustomerInformation custom1) throws Exception
		{
			bank.updateCustomer(custom1);
		}
		public Map<Integer,CustomerInformation> getActiveCustomers(boolean status) throws SQLException
		{
			Map<Integer,CustomerInformation> map=bank.activeCustomerList(status);
			return map;
		}
		
		public void getCreationAccount() throws Exception
		{
			bank.creationAccount();
		}
		
		public void getInsertionAccount(AccountInformation acc1) throws Exception
		{
			bank.insertionAccount(acc1);
		}
		
		public  Map<Integer,Map<Integer,AccountInformation >> getSelectionAccount() throws Exception
		{
			 Map<Integer,Map<Integer,AccountInformation >> map=bank.AllAccounts();
			 return map;
		}
		
		public  Map<Integer,AccountInformation>  getActiveAccount(boolean status) throws Exception
		{
			Map<Integer,AccountInformation> accMap= bank.activeAccountList(status);
			return accMap;
		}
		
		public void getDepositAmount(AccountInformation acc) throws Exception
		{
			bank.amountdeposit(acc);
		}
		
		
		public void getWithdrawAmount(AccountInformation acc) throws Exception
		{
			
			bank.amountWithdrawalAccount(acc);

		}
		
		public void changeStatus(int accId,int cusId,int status) throws Exception
		{
           
			bank.changeStatusAccount(accId, cusId, status);
		  
		}
			
		public void  getUpdate(AccountInformation acc) throws Exception
		{   
			bank.updateAccount(acc);
		}
		
		public Map<Integer,Map<Integer,AccountInformation>> getAllCustomersInAccount(int id) throws SQLException
		{
			Map<Integer,Map<Integer,AccountInformation>> map=bank.getAllCustomers(id);
			return map;
		}
		
		public ArrayList<String> getAllBranches() throws SQLException
		{
			ArrayList<String> list=bank.getCustomersAccountBranch();
			return list;
		}
		
		public void changeCustomerStatusInAccounts(int id,int status)
		{
			bank.changeStatusAccountCustomer(id, status);
		}
		
		public void  storecache(Map<Integer,CustomerInformation> customMap,Map<Integer,Map<Integer,AccountInformation>> account)
		{
			cache.storeMap(customMap, account);
		}
       		
		public void addDetails(CustomerInformation custom) throws Exception
		{
			cache.getAddCustomer(custom);
		}
		public Map<Integer,CustomerInformation> selectCustomerName(String name) throws Exception
		{
			 Map<Integer,CustomerInformation> map=cache.selectionCustomerName(name);
			 return map;
		}
		
	
		public Map<Integer,CustomerInformation> selectCustomerId(int id)
		{
			Map<Integer,CustomerInformation> map=cache.selectCustomersId(id);
	
		   return map;
		}
		
		public Map<Integer,CustomerInformation> selectCustomer()
		{
			Map<Integer,CustomerInformation> map=cache.selectAllCustomers();
			return map;
		}
		
		public void upadteCustomer(CustomerInformation custom)
		{
		 cache.updateCustomerDetails(custom);
		}
		
		public void changeCustomerStatus(int id,int status)
		{
			cache.changeCustomStatus(id, status);
		}
		
		public Map<Integer,CustomerInformation>  activeCustomerList(boolean status)
		{
			Map<Integer,CustomerInformation> map=cache.activeCustomerLists(status);
			return map;
		}
		
		public void insertAccount(AccountInformation account)
		{
			cache.insertAccountDetails(account);
			
		}
		
		public Map<Integer,Map<Integer,AccountInformation>> getAllAccounts()
		{
			Map<Integer,Map<Integer,AccountInformation>> accMap=cache.allAccountDetails();
			return accMap;
		}
		
		public void changeAccountStatus(int accId,int cusId,int status)
		{
			cache.changeAccountStatus(status, cusId, status);
		}
		
		public Map<Integer,AccountInformation> activeAccountsList(boolean status)
		{
			Map<Integer,AccountInformation> accmap=cache.activeAccountsDetails(status);
			return accmap;
		}
		public Map<Integer,Map<Integer,AccountInformation>> getAllCustomer(int id)
		{
			Map<Integer,Map<Integer,AccountInformation>> accMap=cache.CustomerList(id);
			return accMap;
		}
		
		public void cashDeposit(int id,double balance)
		{
			cache.depositAmount(id, balance);
		}
		

		public void cashWithdraw(int id,double balance)
		{
			cache.withdrawAmount(id, balance);
		}
		public void cacheUpdateAccount(AccountInformation account)
		{
			cache.updateAccountDetails(account);
		}
		
		public void cacheDelete(AccountInformation acc)
		{
			cache.deleteAccountDetails(acc);
		}
		
		
		
	
		
}
