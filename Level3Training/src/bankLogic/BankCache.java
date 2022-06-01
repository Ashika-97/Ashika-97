package bankLogic;

import java.util.*;


import internetBanking.AccountPojo;
import internetBanking.CustomerPojo;



public class BankCache {
       
	Map<Integer,CustomerPojo>  customMap=new HashMap<>();
	Map<Integer,AccountPojo> accountMap=new HashMap<>();
//	Map<Integer,Map<Integer,AccountPojo>> finalMap=new HashMap<>();
	Map<Integer,ArrayList<String >>  list=new HashMap<>();
	
	
	private int accId=3000;
	private int cusId=100;
	
	public int getAccountId()
	{
	   return ++accId;
	}
	public int getCustomerId()
	{
		return ++cusId;
	}
	
	//initially login Account
	public String loginDetails(int userId,String password,int id)
	{

	   int name=customMap.get(id).getUserName();
	
	   String pass=customMap.get(id).getPassword();
	  
	   if(name != userId && pass != password)
	   {
		   return "userName or Password invalid ";
		   
	   }
		
	   return "login Successfully";	  
	}
	
	public  String  addCustomerDetails(CustomerPojo custom1)  throws  CustomException
	{
		customMap.put(getCustomerId(), custom1);
		return "custom details added successfully";
	}
	
	
	public CustomerPojo getCustomerDetails(int id ) throws CustomException
	{
		return customMap.get(id);
	}
	
	//

	public void addAccountDetails(AccountPojo account) throws CustomException
	{
		//Map<Integer,AccountPojo> acc=accountMap.get()
		
		if(account != null)
		     accountMap.put(getAccountId(), account);
		//	finalMap.put(customId,acc);
		
	
	}
	public AccountPojo getAccountDetails(int accId) throws CustomException
	{
	     AccountPojo accountpoj=accountMap.get(accId);
		return accountpoj;
	}
	//2
	public String openAccount(CustomerPojo custom)
	{
		customMap.put(custom.getCustomerId(), custom);
		
		return "Account opened Successfully"; 
	}
	
	
	//3
	public long balaceEnquiryCheck(int accountId) throws CustomException
	{
		AccountPojo accI1=accountMap.get(accountId);
		int id=accI1.getAccountId();
		long bal=0;
		if(accI1 != null && accountId == id )
		{
			bal+=accI1.getBalance();
		}
		return bal;
		
	}
	
	
	//7
	public void depositMoney(long number,int accountId,AccountPojo account) throws Exception
	{   
	  System.out.println("the accId is "+ accountId);
	  System.out.println("the balance is "+ number);

		AccountPojo input=accountMap.get(accountId);
		System.out.println("the input is "+ input);
		  if(input != null)
		    {
		
		    long balance=input.getBalance();
		    System.out.println("the amount is deposit "+ balance);
			balance+= number;
			input.setBalance(balance);
			 System.out.println("the amount after is  after deposit "+ balance);
		   // input.put(accId, account);
		    
		  }
		
		accountMap.put(accountId,account);
		System.out.println("the deposited amount Details "+ accountMap);
	}
	
    int initialAmount=1000;
	public void amountWithdrawal(int accId,long balance,AccountPojo account) throws Exception
	{  
		
		  AccountPojo input=accountMap.get(accId);
		  if(input!=null) {
			
		  long amount=input.getBalance();
		  System.out.println("the amount is  in withdraw"+ amount);
		  if(amount>initialAmount)
		   {
		  amount-=balance;
		  System.out.println("the bal is  in withdraw after "+ amount);
		  input.setBalance(amount);
		   }
		  accountMap.put(accId, input);
		//finalMap.put(accId,input);
		System.out.println("the accountMap "+ accountMap);
	     }
   }
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//7
/*	public void depositMoney(int cusId1,long balance,AccountPojo account,int accountId)
	{
		Map<Integer,AccountPojo> map=finalMap.get(cusId1);
		if(map != null)
		{
			AccountPojo acc=map.get(accountId);
			if(acc!= null)
			{
				long balance1=acc.getBalance();
				balance1+=balance;
				acc.setBalance(balance1);
				map.put(cusId1, account);
			}
		}
		finalMap.put(cusId1, map);
		
		
		for(Map.Entry<Integer,Map<Integer,AccountPojo>> keys:finalMap.entrySet())
		{
			
			Map<Integer,AccountPojo> map1=keys.getValue();
			
			if(map1 != null)
			{
				AccountPojo entry=map1.get(accountId);
				if(entry != null)
				{
					long wbal=entry.getBalance();
					wbal+=balance;
					entry.setBalance(wbal);
					map1.put(accountId, entry);
				}
				//finalMap.put(customerId1, map1);
				
				System.out.println(finalMap.get(cusId1));
			}
			
	}
	}
}*/
	
	
	
/*	public void withdrawMoney(int customId,long balance,AccountPojo acc)
	{
		Map<Integer,AccountPojo> map=finalMap.get(customId);
		if(map != null)
		{
			AccountPojo  acc1=map.get(a)
		}
		
		Map<Integer,AccountInfo> input=finalMap.get(accId);
		if(input!=null) {
			AccountInfo info=input.get(accId);
			if(info!=null) {
		    long amount=info.getBalance();
		  if(amount>initialAmount)
		   {
		  amount-=number;
		  info.setBalance(amount);
		  input.put(getAccId(), account);
		}
		
		finalMap.put(accId,input);
		}
	}*/
		
		
		
		
	
	
	//history
//	public ArrayList<String> accountHistory(int accountId,int customId)
//	{
//		
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

