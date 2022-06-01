package l3Run;

import java.util.Scanner;

import exception.CustomException;
import l3Model.AdminInfo;
import l3Model.CustomerInfo;
import l3Model.StockInfo;
import l3cache.ShoppingCallCache;

public class ZkartRun {
	
	ShoppingCallCache callcache=new ShoppingCallCache();
	Scanner scan=new Scanner(System.in);
	static ZkartRun run=new ZkartRun();
	
		
	public void addDummyValues() throws CustomException
	{
		CustomerInfo custom=new CustomerInfo();
		custom.setEmailId("user1@zoho.com");
		custom.setPassword("edlok");
		String encryptedPassword=callcache.passwordEncrypt("edlok");
		System.out.println(encryptedPassword);
		boolean flag=callcache.passwordValidate(encryptedPassword);
		if(flag)
		{
			custom.setPassword(encryptedPassword);
		}
		custom.setMobileNumber(901801901);
	    custom.setPurchasedItem("laptop");
	    custom.setUsername("reka");
	    callcache.addCustomerDetails(custom);
	    
	    CustomerInfo custom1=new CustomerInfo();
		custom1.setEmailId("user2@zoho.com");
		custom1.setPassword("asxaE");
		String encryptedPassword1=callcache.passwordEncrypt("asxaE");
		boolean flag1=callcache.passwordValidate(encryptedPassword1);
		if(flag1)
		{
			custom1.setPassword(encryptedPassword1);
		}
		custom1.setMobileNumber(901121901);
	    custom1.setPurchasedItem("watch");
	    custom1.setUsername("priya");
	    callcache.addCustomerDetails(custom1);
	    
	    
	    CustomerInfo custom2=new CustomerInfo();
		custom2.setEmailId("user3@zoho.com");
		custom2.setPassword("ftYy");
		String encryptedPassword2=callcache.passwordEncrypt("ftYy");
		System.out.println(encryptedPassword2);
		boolean flag2=callcache.passwordValidate(encryptedPassword2);
		if(flag2)
		{
			custom2.setPassword(encryptedPassword2);
		}
		custom2.setMobileNumber(911231901);
	    custom2.setPurchasedItem("phone");
	    custom2.setUsername("vino");
	    System.out.println(callcache.addCustomerDetails(custom2));
	    
	    StockInfo stock=new StockInfo();
	    stock.setCategory("laptop");
	    stock.setBrand("apple");
	    stock.setModel("mac-5");
	    stock.setPrice(90000);
	    System.out.println(callcache.addListOfStock(stock));
	
	    StockInfo stock1=new StockInfo();
	    stock1.setCategory("watch");
	    stock1.setBrand("titan");
	    stock1.setModel("brand-25");
	    stock1.setPrice(5000);
	    System.out.println(callcache.addListOfStock(stock1));
	    
	    StockInfo stock2=new StockInfo();
	    stock2.setCategory("phone");
	    stock2.setBrand("samsung");
	    stock2.setModel("S-20");
	    stock2.setPrice(80000);
	    System.out.println(callcache.addListOfStock(stock2));
	}

	
	public void addStockList()
	{
		StockInfo stock=new StockInfo();
		System.out.println("Enter the category/gadget name");
		String gadgetName=scan.nextLine();
		stock.setCategory(gadgetName);
		System.out.println("Enter the brand ");
		String brandName=scan.nextLine();
		stock.setBrand(brandName);
		System.out.println("Enter the type of model ");
		String model=scan.nextLine();
		stock.setModel(model);
		System.out.println("Enter the price of your gadget");
		double price=scan.nextDouble();
		stock.setPrice(price);
		scan.nextLine();
		try {
		System.out.println(callcache.addListOfStock(stock));
		}
		catch(CustomException custom)
		{
			System.out.println(custom.getMessage());
		}
	}
	
	public void newAccountSignUp()
	{
		CustomerInfo custom=new CustomerInfo();
		System.out.println("Enter the username");
		String username=scan.nextLine();
		custom.setUsername(username);
		System.out.println("Enter the password");
		String password=scan.nextLine();
		String encryptedPassword="";
		try {
			encryptedPassword=callcache.passwordEncrypt(password);
			boolean flag=callcache.passwordValidate(encryptedPassword);
		
			
				while(!flag)
				{
					System.out.println("Enter the password");
					password=scan.nextLine();
					encryptedPassword=callcache.passwordEncrypt(password);
					flag=callcache.passwordValidate(encryptedPassword);
					
				}
				
				if(flag)
				{
					custom.setPassword(encryptedPassword);
				}
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
		
		custom.setPassword(password);
		System.out.println("Enter the email-Id");
		String mailId=scan.nextLine();
		custom.setEmailId(mailId);
		System.out.println("Enter the mobileNumber");
		long mobileNumber=scan.nextLong();
		custom.setMobileNumber(mobileNumber);
		scan.nextLine();
		
		try {
			System.out.println(callcache.addCustomerDetails(custom));
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
	}
	public void customerSite()
	{
		System.out.println("1-Search gadgets ");
		System.out.println("2-search gadgets and brands");
		System.out.println("3-search gadgets,brands and models");
		//System.out.println("1- Shopping");
		System.out.println("4-Customer history seek");
		System.out.println("5-password change");
	}
	
	
	public void loginUserPass()
	{
		System.out.println("Enter the username");
		String username=scan.nextLine();
		System.out.println("Enter the password");
		String password=scan.nextLine();
	
		try {
			
		boolean result=callcache.loginCredentials(username, password);
		System.out.println(result);
		while(result)
		{
			customerSite();
			System.out.println("Enter a number to proceed the process ");
			int n=scan.nextInt();
			scan.nextLine();
			switch(n)
			{
			case 1:run.searchGadegets(username);
			break;
			case 2:run.serachGadgetsAndBrand(username);
			break;
			case 3: run.seachGadgetBrandModel(username);
			break;
			case 4:run.orderHistory(username);
			break;
			case 5:run.passwordAutneticationchange(username);
			break;
			case 6:result=false;
		    }
		 }
		}
		catch (CustomException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	public void searchGadegets(String username) throws CustomException
	{   
		
		boolean confirm=true;
		while(confirm)
		{
		System.out.println("Enter the gadgets you want to search");
		String search=scan.nextLine();
	    try {
	    	System.out.println(callcache.getsearchedGadget(search));
	    }
	    catch(CustomException exception)
	    {
	    	System.out.println(exception.getMessage());
	    }
	    double clac=0;
	    System.out.println("Do you want this to add to cart");
	    String val=scan.nextLine();
	    if(val.equals("yes"))
	    {
	    	double amount= addToCartDetails(username);
	    	if(amount > 1000)
	    	{
	    	System.out.println("Kindly pay the amount "+ amount);
	    	clac=scan.nextDouble();
	    	}
	    	while(clac!= amount && amount > 0.0)
	    	{
	    		System.out.println("Kindly pay the amount "+ amount);
		    	 clac=scan.nextDouble();
	    	}
	    	if(amount <=0.0)
	    	{
	    		throw new CustomException("serach the correct item ");
	    	}
	    	try {
	    	System.out.println(callcache.addTocart(search, "", "", username, amount));
	    	}
	    	catch(CustomException exception)
	    	{
	    		System.out.println(exception.getMessage());
	    	}
	    }
	    System.out.println("If you want to search any other items");
	    String val1=scan.nextLine();
	    if(val1.equals("yes"))
	    {
	    	confirm = true;
	    }
	    else {
	    	confirm=false;
	    }
		}
	}
	
	public double addToCartDetails(String userName)
	{
		System.out.println("Enter the category ");
		String category=scan.nextLine();
		System.out.println("Enter the brand");
		String brand=scan.nextLine();
		System.out.println("Enter the model");
		String model=scan.nextLine();
		double amount=0;
		scan.nextLine();
		try {
			amount=callcache.amountCalculate(category, brand, model, userName);
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
		return  amount;
		
	}
	public void serachGadgetsAndBrand(String userName)
	{
		boolean confirm=true;
		while(confirm)
		{
		System.out.println("Enter the gadgets ");
		String gadgets=scan.nextLine();
		System.out.println("Enter the type of  brand ");
		String brand=scan.nextLine();
		double clac=0;
		try {
			System.out.println(callcache.getSearcheBrand(gadgets, brand));
			 System.out.println("Do you want this to add to cart");
			    String val=scan.nextLine();
			    if(val.equals("yes"))
			    {
			    	double amount= addToCartDetails(userName);
			    	if(amount > 1000)
			    	{
			    	System.out.println("Kindly pay the amount "+ amount);
			    	clac=scan.nextDouble();
			    	}
			    	while(clac!= amount && amount <=0.0)
			    	{
			    		System.out.println("Kindly pay the amount "+ amount);
				    	 clac=scan.nextDouble();
			    	}
			    	try {
			    	System.out.println(callcache.addTocart(gadgets,brand, "", userName, amount));
			    	}
			    	catch(CustomException exception)
			    	{
			    		System.out.println(exception.getMessage());
			    	}
			    }
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
		System.out.println("If you want to search any items");
		String val=scan.nextLine();
		if(val.equals("yes"))
		 {
		   	confirm = true;
		   }
		else {
		   	confirm=false;
		   }
		}
	}
	
	public void seachGadgetBrandModel(String userName)
	{
		boolean confirm=true;
		while(confirm)
		{
	
		System.out.println("Enter the gadgets name");
		String gadgets=scan.nextLine();
		System.out.println("Enter the brand type ");
		String brand=scan.nextLine();
		System.out.println("Enter the model ");
		String model=scan.nextLine();
		double clac=0;
		try {
			System.out.println(callcache.getSearchModel(gadgets, brand, model));
			 System.out.println("Do you want this to add to cart");
			    String val=scan.nextLine();
			    if(val.equals("yes"))
			    {
			    	double amount= addToCartDetails(userName);
			    	if(amount > 1000)
			    	{
			    	System.out.println("Kindly pay the amount "+ amount);
			    	clac=scan.nextDouble();
			    	}
			    	while(clac!= amount && amount <=0.0)
			    	{
			    		System.out.println("Kindly pay the amount "+ amount);
				    	 clac=scan.nextDouble();
			    	}
			    	try {
			    	System.out.println(callcache.addTocart(gadgets, brand, model, userName, amount));
			    	}
			    	catch(CustomException exception)
			    	{
			    		System.out.println(exception.getMessage());
			    	}
			    }
		}
		catch(CustomException exception) {
			System.out.println(exception.getMessage());
		}
		System.out.println("If you want to search any items");
		String val=scan.nextLine();
		if(val.equals("yes"))
		{
		  	confirm = true;
		 }
		else {
		 	confirm=false;
		 }
		}
	}
	
	public void addAdminAccounts()
	{
		AdminInfo admin=new AdminInfo();
		System.out.println("Enter the userName ");
		String name=scan.nextLine();
		admin.setUserName(name);
		System.out.println("Enter the password ");
		String password=scan.nextLine();
		String encrypt="";
		
		try {
			encrypt=callcache.passwordEncrypt(password);
			boolean flag=callcache.passwordValidate(password);
			while(flag=false)
			{
				System.out.println("Enter the password ");
				 password=scan.nextLine();
			}
			if(flag)
			{
				admin.setPassword(encrypt);
			}
			System.out.println("Enter the id number ");
			int id=scan.nextInt();
			boolean check=callcache.adminIdCheck(id);
		
		   while(check=false)
		   {
				System.out.println("Please enter the id correctly");
				id=scan.nextInt();
				check=callcache.adminIdCheck(id);
			}
			if(check)
			{
				admin.setPassword(password);
			}
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
		
	}
	public void adminSite()
	{
		//System.out.println("1-Admin login");
		System.out.println("1-Stocks add");
		System.out.println("2-List Of Stocks less than ten seek");
		System.out.println("3-unique discount");
        System.out.println("4-Deal Of the moment discount");
	}
	
	public void adminLogin()
	{
		System.out.println("Enter the username ");
		String username=scan.nextLine();
		System.out.println("Enter the password");
		String password=scan.nextLine();
		try {
			boolean flag=callcache.adminLogin(username, password);
			while(flag)
			{
				//listOfStockShowForAdminLessThanTen();
				adminSite();
				System.out.println("Enter a number to proceed the datas ");
				int num=scan.nextInt();
				scan.nextLine();
				switch(num)
				{
				case 1:run.addStockList();
				break;
				case 2:run.listOfStockShowForAdminLessThanTen();
				break;
				case 3:run.uniqueDiscountForThreePurchases();
				break;
				case 4:run.dealersHighDiscount();
				break;
				case 5:flag=false;
				break;
				}
				
			}
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
	}
	
	public void listOfStockShowForAdminLessThanTen()
	{
		try {
			System.out.println("The list of stocks are ");
			System.out.println(callcache.listOfStocksShownLessThanTen());
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
	}
	
	public void dealersHighDiscount()
	{
		try {
			callcache.dealTheHighestStock();
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
	}
	public void uniqueDiscountForThreePurchases()
	{
		System.out.println("Enter the number of counts to give the discount ");
		int count=scan.nextInt();
		System.out.println("Enter the number of percent in number to give discount ");
		int number=scan.nextInt();
		try {
			System.out.println(callcache.uniqueDiscountForPurchasedItem(count, number));
		}
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
	}
	public void orderHistory(String userName)
	{
		try {
		System.out.println(callcache.customerHistoryInvoice(userName));
		System.out.println(callcache.customerHistoryInfoAboutPurchase(userName));
	    }
		catch(CustomException exception)
		{
			System.out.println(exception.getMessage());
		}
	
	}
	
	
	public void passwordAutneticationchange(String userName)
	{
		System.out.println("Enter a mobileNumber to change the password ");
		long mobileNumber=scan.nextLong();
		System.out.println("Enter to change password ");
		String password=scan.nextLine();
		 try {
		boolean flag1=callcache.passwordValidate(password);
		while(!flag1)
		{
			System.out.println("Enter to change password ");
			password=scan.nextLine();
		}
	
	
	    boolean result=callcache.passwordChange(userName, mobileNumber, password);	
	    System.out.println(result);
	 }
	 catch(CustomException exception)
	 {
		 System.out.println(exception.getMessage());
	 }
	
	}
	
	
	
	
//	public void customerMethods()
//	{
//		customerSite();
//		Scanner scan=new Scanner(System.in);
//		ZkartRun run=new ZkartRun();
//		boolean flag=true;
//		
//		while(flag)
//		{
//			System.out.println("Enter a number to proceed the process ");
//			int n=scan.nextInt();
//			switch(n)
//			{
//			case 1:run.loginUserPass();
//			break;
//			case 2:
//			}
//			
//		}
//		
//		
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
