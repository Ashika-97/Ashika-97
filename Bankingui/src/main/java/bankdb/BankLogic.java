package bankdb;

import java.sql.SQLException;
import java.util.*;

public class BankLogic   implements  BankInterface {
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
	public  Map<Integer,CustomerInformation> selectAllCustomer(int id) throws Exception{
		 Map<Integer,CustomerInformation> map=custom.selectionAllCustomer(id);
		 return map;
	}
	
	public  Map<Integer,CustomerInformation> selectCustomer() throws Exception{
		 Map<Integer,CustomerInformation> map=custom.selectionCustomers();
		 return map;
	}
	
	public void updationCustomer(CustomerInformation cus) throws Exception
	{
		custom.updateCustomer(cus);
	}
	
	public void changeCustomerStatusOnly(int cusId,int status)
	{
		custom.changeStatusCustomer(cusId, status);
	}
	public void changeCustomerstatus(int accId,int status)
	{
		account.changeStatusAccountCustomer(accId, status);
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
	public Map<Integer,Map<Integer,AccountInformation>> CustomerAccounts(int id) throws SQLException
	{
		Map<Integer,Map<Integer,AccountInformation>> accMap=account.getAllCustomers(id);
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
	
	public ArrayList<String>  getBranchesList() throws SQLException
	{
		ArrayList<String> list1= account.getCustomersAccountBranch();
		return list1;
	}
	
	public void updatedeposit(int number1,int  number2,double num) throws Exception
	{
		account.amountdeposit(number1,number2,num);
	}
	
	public void updateWithdraw(int number1,int  number2,double num) throws Exception
	{
		account.amountWithdrawalAccount(number1,number2,num);
	}
	public void  changeStatusAccount(int accId,int cusId,int num1)
	{
		account.changeStatusAccount(accId, cusId, num1);
	}

	@Override
	public void creationCustomer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertionCustomer(CustomerInformation custom) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<Integer, CustomerInformation> selectionCustomer(String userName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, CustomerInformation> selectionAllCustomer(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, CustomerInformation> selectionCustomers() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCustomer(CustomerInformation custom) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeStatusCustomer(int cusId, int statusnumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<Integer, CustomerInformation> activeCustomerList(boolean status) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void creationAccount() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertionAccount(AccountInformation acc1) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<Integer, Map<Integer, AccountInformation>> AllAccounts() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeStatusAccountCustomer(int accId, int statusnumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<Integer, AccountInformation> activeAccountList(boolean status) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, Map<Integer, AccountInformation>> getAllCustomers(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getCustomersAccountBranch() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void amountdeposit(AccountInformation acc) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void amountWithdrawalAccount(AccountInformation acc) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletionAccount(AccountInformation account1) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dropAccountTable() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeCall() {
		// TODO Auto-generated method stub
		
	}

	
	
}
