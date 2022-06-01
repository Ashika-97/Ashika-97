package bankrun;

import java.util.Scanner;

import CustomException;
import bankLogic.BankCache;
import internetBanking.AccountPojo;
import internetBanking.CustomerPojo;

public class BankRunner {
	static Scanner scan=new Scanner(System.in);
	CallBankLogic task=new CallBankLogic();
    
    //initial values Customer Details
    //1
    public void initialValuesInserting1()
    {
    	CustomerPojo custom=new CustomerPojo();
    	custom.setCustomerId(101);
    	custom.setUserName(1001);
    	custom.setBranch("chennai");
    	custom.setPassword("pass@1001");
    	System.out.println("the runner is in "+ custom);
    	try {
			task.customerDetailsAdd(custom);
		} 
    	catch (CustomException e) 
    	{			
    		e.printStackTrace();
		}
    
    //2
  
    	CustomerPojo custom2=new CustomerPojo();
    	custom2.setCustomerId(102);
    	custom2.setBranch("chennai");
    	custom2.setUserName(1002);
    	custom2.setPassword("pass@1002");
    	try {
    		task.customerDetailsAdd(custom2);
		} 
    	catch (CustomException e) {
		
			e.printStackTrace();
		}
  
    //3
  CustomerPojo custom3=new CustomerPojo();
    	custom3.setCustomerId(103);
    	custom3.setUserName(1003);
    	custom3.setBranch("karaikudi");
    	custom3.setPassword("pass@1003");
    	try {
    		task.customerDetailsAdd(custom3);
		} 
    	catch (CustomException e) {
			
			e.printStackTrace();
		}
   
    //4
  
    	CustomerPojo custom4=new CustomerPojo();
    	custom4.setCustomerId(104);
    	custom4.setBranch("karaikudi");
    	custom4.setUserName(1004);
    	custom4.setPassword("pass@1004");
    	try {
    		task.customerDetailsAdd(custom4);
		}
    	catch (CustomException e) {
		
			e.printStackTrace();
		}
    }
    // inserted
    
    //initialValuesforAccount
    public void initialValuesForAccount() 
    {
    	//1
    	AccountPojo account=new AccountPojo();
    	account.setAccountId(3001);
    	account.setCustomerId(101);
    	account.setBalance(1000);
    	account.setBranch("karaikudi");
    	account.setStatus(true);
    	try {
    		task.addAccount(account);
    	}
    	catch (Exception e) {
    		
			e.printStackTrace();
		}
    	//2
    	AccountPojo account1=new AccountPojo();
    	account.setAccountId(3002);
    	account.setCustomerId(102);
    	account1.setBalance(200000);
    	account1.setBranch("karaikudi");
    	account1.setStatus(true);
    	try {
    		task.addAccount(account1);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	//3
    	AccountPojo account3=new AccountPojo();
    	account3.setAccountId(3003);
    	account3.setCustomerId(103);
    	account3.setBalance(200000);
    	account3.setBranch("karaikudi");
    	account3.setStatus(true);
    	try {
    		task.addAccount(account3);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	//4
    	AccountPojo account2=new AccountPojo();
    	account2.setAccountId(3004);
    	account2.setCustomerId(104);
    	account2.setBalance(200000);
    	account2.setBranch("karaikudi");
    	account2.setStatus(true);
    	try {
    		task.addAccount(account2);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	   	
    }
    
    //method function starts
	public void loginCredentials()
	{
		System.out.println("Enter a userId ");
		int number=scan.nextInt();
		scan.nextLine();
		System.out.println("Enter the password ");
		String password=scan.nextLine();
		System.out.println("Enter the customerId ");
		int id=scan.nextInt();
		scan.nextLine();
		try {
		System.out.println(task.userCredentails(number, password, id));
		}
		catch(Exception exception)
		{
			System.out.println("Exception in login Main "+ exception.getMessage());
		}
		
	}
	//
	public void customerAdd()
	{
		CustomerPojo custom=new CustomerPojo();
		System.out.println("Enter the customer name ");
		String name=scan.nextLine();
		custom.setCustomerName(name);
		System.out.println("Enter the address ");
		String address=scan.nextLine();
		custom.setAddress(address);
		System.out.println("Enter the branch ");
		String branch=scan.nextLine();
		custom.setBranch(branch);
		System.out.println("Enter the initialAmount ");
		long balance=scan.nextLong();
		custom.setBalance(balance);
		System.out.println("Enter the mobileNumber ");
		long number=scan.nextLong();
		custom.setMobileNumber(number);
		scan.nextLine();
		try {
			System.out.println(task.customerDetailsAdd(custom));
		} 
		catch (CustomException e)
		{
	
			e.printStackTrace();
		}
		
		
	}
	//
	public void addingAccounts()
	{
		AccountPojo acc=new AccountPojo();
		System.out.println("Enter the balance ");
		long bal=scan.nextLong();
		scan.nextLine();
		acc.setBalance(bal);
		System.out.println("Enter the branch");
		String branch=scan.nextLine();
		acc.setBranch(branch);
		acc.setStatus(true);
		try {
			task.addAccount(acc);
		}
		catch(Exception exception)
		{
			System.out.println("Exception in adding Accounts Main "+ exception.getMessage());
		}
		
		
	}
	
	//
	public void sepCustomerDetails()
	{
		System.out.println("Enter the id to get the customer Deatils ");
		int n=scan.nextInt();
		scan.nextLine();
		try {
		System.out.println(task.getCustomerInfo(n));
		}
		catch(Exception exception)
		{
			System.out.println("Exception in login Main "+ exception.getMessage());
		}
		
	}
	//
	public void sepAccountDetails()
	{
	System.out.println("Enter the acc id to get the account ");
	int cusId=scan.nextInt();
	scan.nextLine();
	try {
		System.out.println(task.getAccountDetails(cusId));
	}
	catch(Exception exception)
	{
		System.out.println("Exception in login Main "+ exception.getMessage());
	}
	}
	
	//7
	public void openingAccount()
	{
		CustomerPojo custom=new CustomerPojo();
		System.out.println("Enter the userName");
		String name=scan.nextLine();
		custom.setCustomerName(name);
		System.out.println("Enter the customerId  ");
		int cusId=scan.nextInt();
		custom.setCustomerId(cusId);
		System.out.println("Enter the userId for login and this will be your userId login");
		int id=scan.nextInt();
		scan.nextLine();
		custom.setUserName(id);
		System.out.println("enter the password ");
		String pass=scan.nextLine();
		custom.setPassword(pass);
		try {
		System.out.println(task.openAccount(custom));
		}
		catch(Exception ex)
		{
			System.out.println("Exception in open Account "+ ex.getMessage());
		}
		
	}
	//6
	public void balanceEnquiry()
	{
		System.out.println("Enter the AccountId to get the Balance details ");
		int accId=scan.nextInt();
		//System.out.println("Enter the customerId to get the Balance details ");
	//	int customId=scan.nextInt();
		scan.nextLine();
		try {
			System.out.println("the balance is "+ task.balanceCheck(accId));
		}
		catch (CustomException e) {
		
			e.printStackTrace();
		}
	}
	//7
	public void depositMoney()
	{
		AccountPojo acc=new AccountPojo();
		System.out.println("Enter the accId to deposit");
		int accId=scan.nextInt();
		System.out.println("Enter the balnce to deposit");
		long bal=scan.nextLong();
		System.out.println("Enter the deposited transferred accountNumber ");
		int accId2=scan.nextInt();
		scan.nextLine();
		try {
			task.TransferDetails(accId, bal, acc,accId2);
		}
		catch(Exception ex)
		{
			System.out.println("Exception in "+ ex.getMessage());
		}
		
	}
	
	
	public static void main(String[] args)
	{
		BankRunner run=new BankRunner();
		System.out.println("Enter the number to get the process ");
		int n=scan.nextInt();
		scan.nextLine();
		run.initialValuesInserting1();
		run.initialValuesForAccount();
		
		
		switch(n)
		{
		case 1:run.loginCredentials();
		
		case 2:run.customerAdd();
		
		case 3:run.addingAccounts();
		
		case 4: run.sepAccountDetails();
		
		case 5:run.sepCustomerDetails();
		
		case 6:run.balanceEnquiry();
		
		case 7:run.openingAccount();
		
		case 8:run.depositMoney();
			
		case 9:
			
		case 10:
		
		
		
		
		
		
		
		
		
		
		
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
