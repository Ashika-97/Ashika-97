package bankdb;

import java.sql.SQLException;
import java.util.Map;

public class BankCache implements BankInterface {
	
	public Map<Integer,CustomerInformation> map;
	
	public Map<Integer,Map<Integer,AccountInformation>> accountMap;
	
	Map<Integer,AccountInformation> account;
	BankLogic bank=new BankLogic();
	
	public BankCache()
	{
		storeMap(map, accountMap);
	}
	
	public void  storeMap(Map<Integer,CustomerInformation> customMap,Map<Integer,Map<Integer,AccountInformation>> account)
	{
		map=customMap;
		accountMap=account;
	}
	
	public void getCustomerCreation() throws Exception
	{
		bank.createCustomer();
	}
	
	public   Map<Integer,CustomerInformation> getAddCustomer(CustomerInformation custom1) throws Exception
	{
	  map.put(custom1.getCustomerId(), custom1)	;
	  return map;
	}
	
	public  Map<Integer,CustomerInformation> selectionCustomerId(String userName) throws Exception
	{ if(map.containsValue(userName)) {
		  return null;
	}
	return map;
		
	}
	
	public  Map<Integer,CustomerInformation> getOnlyAllCustomer() throws Exception{
		 
		 return map;
	}
	public void customerChangingStatus(int cusId,int  status,CustomerInformation custom)
	{
		if(map.get(cusId) != null)
		{
		map.put(cusId,custom);	
		}
		
	}
	
	public Map<Integer,CustomerInformation> trueCustomer(boolean status) throws SQLException
	{
		map.get(status);
		return map;
	}
	
	public void updationCustomer(CustomerInformation custom1) throws Exception
	{
	map.put(custom1.getCustomerId(), custom1);
	}
	
	public void creationAccountId() throws Exception
	{
		bank.createAccount();
	}
	
	public void getInsertionAccount(AccountInformation acc1) throws Exception
	{
		account.put(acc1.getAccountId(),acc1);
		
	}
	
	public  Map<Integer,Map<Integer,AccountInformation >> allSelectionAccount() throws Exception
	{
		 accountMap.put(, account)
		 return account;
	}
	
	public  Map<Integer,AccountInformation>  allActiveAccount(boolean status) throws Exception
	{
		Map<Integer,AccountInformation> accMap= bank.selectactiveaccount(status);
		return accMap;
	}
	
	public void DepositAmount(AccountInformation acc) throws Exception
	{
		bank.updatedeposit(acc);
	}
	
	
	public void WithdrawAmount(AccountInformation acc) throws Exception
	{
		
		bank.updateWithdraw(acc);

	}
	
	public void getChangeStatus(int accId,int cusId,int status) throws Exception
	{
       
		bank.changeStatusAccount(accId, cusId, status);
	  
	}
		
	public void  UpdateAccount(AccountInformation acc) throws Exception
	{   
		bank.updateAccount(acc);
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
	public Map<Integer, CustomerInformation> selectionAllCustomer() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCustomer(CustomerInformation custom) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeStatusCustomer(int cusId, int status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<Integer, CustomerInformation> activeCustomerList(boolean status) {
		// TODO Auto-generated method stub
		return null;
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
	public void changeStatusAccount(int accId, int cusId, int statusnumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<Integer, AccountInformation> activeAccountList(boolean status) throws SQLException {
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
	public void updateAccount(AccountInformation account) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<Integer, CustomerInformation> selectionCustomer(String userName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void creationAccount() {
		// TODO Auto-generated method stub
		
	}
}