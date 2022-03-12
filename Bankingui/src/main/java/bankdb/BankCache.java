package bankdb;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BankCache {
	
	public Map<Integer,CustomerInformation> map;
	
	public Map<Integer,Map<Integer,AccountInformation>> accountInfoMap;
	
	Map<Integer,AccountInformation> account;
	BankLogic bank=new BankLogic();
	
	public BankCache()
	{
		storeMap(map, accountInfoMap);
	}
	
	public void  storeMap(Map<Integer,CustomerInformation> customMap,Map<Integer,Map<Integer,AccountInformation>> account)
	{
		map=customMap;
		accountInfoMap=account;
	}
	
	
	public  void  getAddCustomer(CustomerInformation custom1) throws Exception
	{
	  map.put(custom1.getCustomerId(), custom1)	;
	  
	}
	
	public  Map<Integer,CustomerInformation> selectionCustomerName(String userName) throws Exception
	{ 
		CustomerInformation userMap=null;
		int id=0;
		for( Map.Entry<Integer,CustomerInformation>  customMap:map.entrySet())
		{
			
			userMap=customMap.getValue();
			if(userMap.getCustomerName()==userName)
			{
				 id=userMap.getCustomerId();
			}
		if(id!=0)
		{
			map.get(id);
		}
		 
	}
	return map;
		
	}
	
	public  Map<Integer,CustomerInformation> selectCustomersId(int id)
	{
		CustomerInformation userMap=null;
		
		for( Map.Entry<Integer,CustomerInformation>  customMap:map.entrySet())
		{
			
			userMap=customMap.getValue();
			if(userMap.getCustomerId()==id)
			{
			  map.get(id);
			}
		}
		return map;
	}
	
	
	
	public Map<Integer,CustomerInformation> selectAllCustomers()
	{
	 		
		return map;
	}
	
	public void updateCustomerDetails(CustomerInformation custom)
	{
		if(custom!=null) {
		int id=custom.getCustomerId();
		
		map.replace(id, custom);
		}
		
	}
	
	public void changeCustomStatus(int cusId,int status)
	{ 
		CustomerInformation custom=null;
		boolean bool;
		if(status==1)
		{
			bool= true;
		}
		else
		{
			bool=false;
		}
		
		for(Map.Entry<Integer,CustomerInformation> customMap:map.entrySet())
		{ 
			int id=customMap.getKey();
		   custom.setCustomerId(id);
		   custom.setStatus(bool);
			custom=customMap.getValue();
			
		if(cusId==id)
		{
			map.replace(id, custom);
		
		}
		}
	}
	
	public Map<Integer,CustomerInformation> activeCustomerLists(boolean status)
	{
		CustomerInformation custom=null;
	
		
		for(Map.Entry<Integer,CustomerInformation> accMap:map.entrySet())
		{
			int id=accMap.getKey();
			custom=accMap.getValue();
			custom.setStatus(status);
			if(custom.getStatus()==true)
			{
				map.get(id);
			}
		}
		return map;
	}
		
	
	public void insertAccountDetails(AccountInformation account)
	{  
		Map<Integer,AccountInformation> info=new HashMap<>();
		
		if(account!=null)
		{
			info.put(account.getAccountId(), account);
			accountInfoMap.put(account.getCustomerId(),info);
			
			
		}
				
	}
	
	public  Map<Integer,Map<Integer,AccountInformation>> allAccountDetails()
	{
		return accountInfoMap;	
		
	}
		
	public void changeAccountStatus(int accId,int cusId,int status)
	{    
		Map<Integer,AccountInformation> accountsMap=new HashMap<>();
	    int customerId=0;
	    int accountId=0;
	    boolean bool;
        
        if(status==1)
        {
     	   bool=true;
        }
        else {
     	   bool=false;
        }
	     AccountInformation account=null;
		for(Map.Entry<Integer,Map<Integer,AccountInformation>> accMap:accountInfoMap.entrySet())
		{
			customerId=accMap.getKey();
			accountsMap=accMap.getValue();
			
			for(Map.Entry<Integer,AccountInformation> informMap:accountsMap.entrySet())
			{
				accountId=informMap.getKey();
				account=informMap.getValue();
			}
		
		if((customerId==cusId)&& (accountId==accId) && (account.getStatus()==bool))
		{
			accountInfoMap.replace(customerId,accountsMap);
		}
			
		}
	}
	
	
	public  Map<Integer,AccountInformation> activeAccountsDetails(boolean status)
	{
		 Map<Integer,AccountInformation> accMap=new HashMap<>();
		 int cusId=0;
		 int accId=0;
		 AccountInformation accounts=null;
		for(Map.Entry<Integer,Map<Integer,AccountInformation>> initialMap:accountInfoMap.entrySet())
		{
			cusId=initialMap.getKey();
			accMap=initialMap.getValue();
			for(Map.Entry<Integer,AccountInformation> account:accMap.entrySet())
			{
				accId=account.getKey();
				accounts=account.getValue();
				if(accounts.getStatus()==status)
				{
					accountInfoMap.get(cusId);
				}
				
			   }	
			 
		}
			
	return	account;
	}
	
	
	public Map<Integer,Map<Integer,AccountInformation>>  CustomerList(int id)
	{
		if(id<=0)
		{
			System.out.println("id is less than or equal to zero");
		}
		accountInfoMap.get(id);
		return accountInfoMap;
	}
	
	public void depositAmount(int id,double balance)
	{
		int cusId=0;
		int accId=0;
		Map<Integer,AccountInformation> account=new HashMap<>();
		AccountInformation acc=null;
		for(Map.Entry<Integer,Map<Integer,AccountInformation>> initialMap:accountInfoMap.entrySet())
		{
			cusId=initialMap.getKey();
			account=initialMap.getValue();
			for(Map.Entry<Integer,AccountInformation> accMap:account.entrySet())
			{
				accId=accMap.getKey();
				acc=accMap.getValue();	
			}
		}
		if(id==accId)
		{
			double amount=acc.getBalance();
			amount=amount+balance;
			acc.setBalance(accId);
			account.put(accId, acc);
		}
		accountInfoMap.replace(cusId, account);
		
	}
	
	
	public void withdrawAmount(int id,double balance)
	{
		int cusId=0;
		int accId=0;
		Map<Integer,AccountInformation> account=new HashMap<>();
		AccountInformation acc=null;
		for(Map.Entry<Integer,Map<Integer,AccountInformation>> initialMap:accountInfoMap.entrySet())
		{
			cusId=initialMap.getKey();
			account=initialMap.getValue();
			for(Map.Entry<Integer,AccountInformation> accMap:account.entrySet())
			{
				accId=accMap.getKey();
				acc=accMap.getValue();	
			}
		}
		if(id==accId)
		{
			double amount=acc.getBalance();
			amount=amount-1000;
			if(amount>balance) {
			amount=amount-balance;
			acc.setBalance(accId);
			account.put(accId, acc);
		}}
		accountInfoMap.replace(cusId, account);
		
	}
	public void updateAccountDetails(AccountInformation acc)
	{
		int cusId=0;
		int accId=0;
		
		Map<Integer,AccountInformation> resMap=new HashMap<>();
		Map<Integer,AccountInformation> allAccount=new HashMap<>();
		for(Map.Entry<Integer,Map<Integer,AccountInformation>> accMap:accountInfoMap.entrySet())
		{
		   	cusId=accMap.getKey();
		   	resMap=accMap.getValue();
		   	for(Map.Entry<Integer,AccountInformation> initialMap:resMap.entrySet())
		   	{
		   		accId=initialMap.getKey();
		   		allAccount.put(cusId, acc);
		   		if(acc.getAccountId()==accId)
		   		{
		   			accountInfoMap.replace(cusId, allAccount);
		   		}
		   		
		   		
		   	}
			
			
		}
		
	
		
	}
		
 public void deleteAccountDetails(AccountInformation acc)
 {
	    int cusId=0;
		int accId=0;
		
		Map<Integer,AccountInformation> resMap=new HashMap<>();
		Map<Integer,AccountInformation> allAccount=new HashMap<>();
		for(Map.Entry<Integer,Map<Integer,AccountInformation>> accMap:accountInfoMap.entrySet())
		{
		   	cusId=accMap.getKey();
		   	resMap=accMap.getValue();
		   	for(Map.Entry<Integer,AccountInformation> initialMap:resMap.entrySet())
		   	{
		   		accId=initialMap.getKey();
		   		allAccount.put(cusId, acc);
		   		if(accId==acc.getAccountId() || cusId==acc.getCustomerId())
		   		{
		   			accountInfoMap.remove(cusId,allAccount);
		   		}
		   	}
		}
    }
	
	
	
	
}	
	
	
	
	
	
	
	
	
	