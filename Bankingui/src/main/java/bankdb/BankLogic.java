package bankdb;

import java.sql.SQLException;
import java.util.*;

public class BankLogic  {
   AccountDb account=new AccountDb();
   CustomerDb custom=new CustomerDb();
	
	
	public void createCustomer() throws Exception
	{
		custom.creationCustomer();
	}
	
	public void insertCustomer(CustomerInformation cus) throws Exception
	{
		custom.insertionCustomer(cus);
	}
	
	public Map<Integer,CustomerInformation> selectCustomer(String userName) throws Exception
	{
		Map<Integer,CustomerInformation> map=custom.selectionCustomer(userName);
		return map;
	}
	public  Map<Integer,CustomerInformation> selectAllCustomer() throws Exception{
		 Map<Integer,CustomerInformation> map=custom.selectionAllCustomer();
		 return map;
	}
	public void updationCustomer(CustomerInformation cus) throws Exception
	{
		custom.updateCustomer(cus);
	}
	public void changeCustomerstatus(int cusId,int status)
	{
		custom.changeStatusCustomer(cusId, status);
	}
	public Map<Integer,CustomerInformation> activeCustomer(boolean status) throws SQLException
	{
		 Map<Integer,CustomerInformation> map=custom.activeCustomerList(status);
		 return map;
	}
	
	public void createAccount() throws Exception
	{
		account.creationAccount();
	}
	public void insertAccount(AccountInformation acc) throws Exception
	{
		account.insertionAccount(acc);
	}
	public Map<Integer,Map<Integer,AccountInformation>> selectAccount() throws Exception
	{
		Map<Integer,Map<Integer,AccountInformation>>accMap=account.AllAccounts();
		return accMap;
	}
	public Map<Integer,AccountInformation> selectactiveaccount(boolean bool) throws Exception
	{
		Map<Integer, AccountInformation> accountMap=account.activeAccountList(bool);	
		return accountMap;
	}
	public void updateAccount(AccountInformation acc) throws SQLException
	{
		account.updateAccount(acc);
	}
	
	public void updatedeposit(AccountInformation acc) throws Exception
	{
		account.amountdeposit(acc);
	}
	
	public void updateWithdraw(AccountInformation acc) throws Exception
	{
		account.amountWithdrawalAccount(acc);
	}
	public void  changeStatusAccount(int accId,int cusId,int num1)
	{
		account.changeStatusAccount(accId, cusId, num1);
	}

	
	
}
