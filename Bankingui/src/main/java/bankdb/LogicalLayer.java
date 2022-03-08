package bankdb;

import java.util.Map;

public class LogicalLayer {

	BankInterface bank=new BankLogic();
	BankInterface object=new BankCache();
		
		public void getCustomerCreation() throws Exception
		{
			bank.creationCustomer();
		}
		
		public void getInsertionCustomer(CustomerInformation custom1) throws Exception
		{
			bank.insertionCustomer(custom1);
		}
		
		public  Map<Integer,CustomerInformation> getSelectionCustomer(String userName) throws Exception
		{
			Map<Integer,CustomerInformation> map=bank.selectionCustomer(userName);
			return map;
		}
		
		public  Map<Integer,CustomerInformation> selectonlyCustomer() throws Exception
		{
			 Map<Integer,CustomerInformation> map=bank.selectionAllCustomer();
			 return map;
		}
		
		public void getUpdationCustomer(CustomerInformation custom1) throws Exception
		{
			bank.updateCustomer(custom1);
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
		
	
		
}
