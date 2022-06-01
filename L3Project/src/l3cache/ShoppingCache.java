package l3cache;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.regex.Pattern;

import exception.CustomException;
import l3Model.AdminInfo;
import l3Model.CustomerInfo;
import l3Model.StockInfo;
import shoppingFile.ShoppingCartInterface;
import shoppingFile.ShoppingFile;
import shoppingFile.ShoppingFileCache;


public  class ShoppingCache {
	
	 ShoppingFileCache cache=new ShoppingFileCache();
	 ShoppingCartInterface layer=new ShoppingFile();
	
	 static Map<String,CustomerInfo> customerMap=new HashMap<>();
	 static Map<String,List<StockInfo>> stockMap=new HashMap<>();
	 Map<String,List<AdminInfo>>   adminMap=new HashMap<>();
	 List<List<StockInfo>> stockList=new ArrayList<>();
	 int[] adminId= {11,12,13,14,15};
     long invoiceNumber=121011;
    
     
 	
	
 	 
	 public void writeObjectToFile(Map<String,CustomerInfo>  custom,Map<String,List<StockInfo>> stock) throws CustomException
	 {
		 layer.write(customerMap, stockMap);
	 }
	 
	 public ShoppingCache() 
	 {
		 cache=layer.readObject();
		 customerMap=cache.customMap;
		 stockMap=cache.stockInfoMap;
		// adminMap=cache.adminMap;
	 }
     
     public String calculateDaysYear() throws CustomException
     {

 		Calendar cal=Calendar.getInstance();
 		int year=cal.get(Calendar.YEAR);
 		int month=cal.get(Calendar.MONTH);
 		int date=cal.get(Calendar.DATE);
 		String res= date+"/"+month +"/"+ year;
 		
 		return res;	
     }

    public void nullCheckString(String user) throws CustomException
    {
    	if(user==null || user.isEmpty())
    	{
    		throw new CustomException("type can't be empty");
    	}
    }
	public long autoGenerateInvoiceNumber()
	{
		return ++invoiceNumber;
	}
	

	public Map<String,CustomerInfo> addCustomer(CustomerInfo custom) throws CustomException
	{
		customerMap.put(custom.getUsername(), custom);
		return customerMap;
	}
	
	
	public List<StockInfo> showListofGadegets(StockInfo stock) throws CustomException
	{
		List<StockInfo> list=new ArrayList<>();
		if(!stockMap.containsKey(stock.getCategory()))
		{
			list=new ArrayList <>();
		}
		list.add(stock);
		stockList.add(list);
		stockMap.put(stock.getCategory(), list);
		writeObjectToFile(customerMap,stockMap);
		return list;
	}
	
	
	public boolean validatepassword(String password) throws CustomException
	{
		nullCheckString(password);
		 char ch='0';
		for(int i=0;i< password.length();i++)
		{
	    ch=password.charAt(i);
		if( ch >= 'A'&& ch <='Z' || ch >= 'a' && ch <= 'z' || ch >= '0' && ch <='9')
		{
		   return true;	
		}
		}
		return false;
	}
	
	
	public String passwordEncryption(String password) throws CustomException
	{
		char ch='0';
		String returnPassword="";
		for(int i=0;i<password.length();i++)
		{
			ch=password.charAt(i);
			int val=ch+1;
			returnPassword+=(char)val;
			
		}
		//System.out.println(returnPassword);
		return returnPassword;
	}
	
	public boolean login(String userName,String password) throws CustomException
	{
		nullCheckString(userName);
		nullCheckString(password);
		userName.toLowerCase();
		
		if(customerMap.containsKey(userName))
		{
			CustomerInfo user=customerMap.get(userName);
			String encrypt=passwordEncryption(password);
			//System.out.println("the getpassword "+ user.getPassword());
			//System.out.println("the encrypted pass is "+ encrypt);
			if((user.getUsername().equals(userName)) && user.getPassword().equals(encrypt))
			{
				return true;
			}
		}
		return false;
	}
	
	
	public List<StockInfo> getCustomerSearchedGadgets(String searchGadgets) throws CustomException
	{
		nullCheckString(searchGadgets);
		searchGadgets.toLowerCase();
		if(stockMap== null)
		{
			throw new CustomException("your searched item is not in the list ");
		}
		long invoice=autoGenerateInvoiceNumber();
		List<StockInfo> stockList1=stockMap.get(searchGadgets);
		for(int i=0;i< stockList1.size()-1;i++)
		{
			StockInfo info=stockList1.get(i);
			info.setInvoiceNumber(invoice);
			stockList1.add(info);
		}
		return stockList1;
		
	}
	public double amountCalculate(String category,String brand,String model,String userName) throws CustomException
	{
		if(stockMap == null)
		{
			throw new CustomException("Stocks are empty ");
		}
		CustomerInfo custom=customerMap.get(userName);
		List<StockInfo> list=stockMap.get(category);
		
		double price=0;
		for(int i=0;i< list.size();i++)
		{
			StockInfo stock=list.get(i);
			if(stock.getCategory().equals(category) && stock.getBrand().equals(brand) && stock.getModel().equals(model))
			{
				if(custom.getPurchasedCount() < stock.getStockCount())
				{
				price=(stock.getPrice() * 20)/100;	
				}
				else {
					price=stock.getPrice();
				}
			  }
			}
		return price;
	}
	int count=5;
	public String bookedGadgets(String category,String brand,String model,String userName,double amount) throws CustomException
	{
		if(stockMap == null)
		{
			throw new CustomException("Stocks are empty ");
		}
		CustomerInfo custom=customerMap.get(userName);
		List<StockInfo> list=stockMap.get(category);
		String result="";
		String coupenCode="";
		String input="";
		String date=calculateDaysYear();
		double totalAmount=0;
		long invoice=autoGenerateInvoiceNumber();
		for(int i=0;i< list.size();i++)
		{
			StockInfo stock=list.get(i);
			if(!stock.getBrand().equals(brand)) 
			{
				if(!stock.getCategory().equals(category))
				{
					if( !stock.getModel().equals(model))
						
			{
				throw new CustomException("couldn't find your respective type of brand/category/model");
			}
				}
			}
			list.remove(i);
			stockMap.put(category, list);
			if(stock.getCategory().equals(category) && stock.getBrand().equals(brand) && stock.getModel().equals(model))
			{
							
					custom.setPurchasedItem(category);
					if(amount == stock.getPrice() && custom.getPurchasedCount() > stock.getStockCount())
					{		
						if(count >15)
						{
							count=3;
						}
						 coupenCode=generateCoupenCode(count++);
						custom.setAmount(amount);
						custom.setCoupenCode(coupenCode);
					}
					else if(custom.getPurchasedCount() < stock.getStockCount())
					{
						double price=(amount*20)/100;
					
						stock.setPrice(price);
						if(stock.getPrice() == amount)
						{
							custom.setAmount(amount);
						
						}
						
					}
					totalAmount+=custom.getAmount();
					custom.setTotalAmount(custom.getTotalAmount()+totalAmount);
					custom.setPurchasedCount(custom.getPurchasedCount()+1);
				 	custom.setAddtoCart(category);
				 	custom.setDate(date);
				 	custom.setAddtoCart("yes");
				 	custom.setInvoiceNumber(invoice);
				    if(custom.getPurchasedCount() > 3)
				    {
				    	custom.setCoupenCode("");
				    }
				    custom.setInvoiceNumber(invoice);
				    
				    input+= "/n"+"your gadgets "+ category +"and brand "+ brand +" is booked "+"your invoice number is "+ invoice +" coupencode is "+ coupenCode; 
				    custom.setAddtoCart(input);
				    customerMap.put(userName, custom);
				
			}
			
		}
		
		result+="your invoice Number is "+ invoice +"your purchased date is "+ date ;
		return result;
	}
	
	public String generateCoupenCode(int length) throws CustomException
	{
		/*
		 * char[] chars = "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
		 * StringBuilder sb = new StringBuilder();
		 * 
		 * for (int i = 0; i < chars.length; i++) { char c = chars[i]; sb.append(c); }
		 * String output = sb.toString(); System.out.println(output); return output ;
		 */
		 char[] chars = "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
	        StringBuilder sb = new StringBuilder();
	        Random random = new SecureRandom();
	        for (int i = 0; i < chars.length; i++) {
	            char c = chars[random.nextInt(chars.length)];
	            sb.append(c);
	        }
	        String output = sb.toString();
	        System.out.println(output);
	        return output ;
	    
		
	}
	public List<StockInfo>  getCustomerSearchedBrand(String searchGadgets,String brand) throws CustomException
	{
		if(stockMap == null)
		{
			throw new CustomException("sorry your searched item is not in the list ");
		}
		nullCheckString(searchGadgets);
		nullCheckString(brand);
		searchGadgets.toLowerCase();
		brand.toLowerCase();
		List<StockInfo>  list=stockMap.get(searchGadgets);
		List<StockInfo> list1=new ArrayList<>();
		StockInfo info=null;
		long invoice=autoGenerateInvoiceNumber();
		for(int i=0;i < list.size();i++)
		{
			 info=list.get(i);
			 info.setInvoiceNumber(invoice);
			 if(info.getCategory().equals(searchGadgets) && info.getBrand().equals(brand))
			 {
				 list1.add(list.get(i));
			 }
		}
		
		return list1;
		
	}
	
	public List<StockInfo> getCustomerSearchedModel(String searchGadgets,String brand,String model) throws CustomException
	{
		if(stockMap == null)
		{
			throw new CustomException("sorry your searched item is not in the list ");
		}
		searchGadgets.toLowerCase();
		brand.toLowerCase();
		model.toLowerCase();
		List<StockInfo>  list=stockMap.get(searchGadgets);
		List<StockInfo>   list1=new ArrayList<>();
		StockInfo info=null;
		long invoice=autoGenerateInvoiceNumber();
		for(int i=0;i < list.size();i++)
		{
			 info=list.get(i);
			 info.setInvoiceNumber(invoice);
		     if(info.getBrand().equals(brand) && info.getModel().equals(model))
		     {
		    	 list1.add(list.get(i));
		     }
		}
		return list1;
		
	}
	
	public boolean  adminAccountAdd(AdminInfo admin) throws CustomException
	{
		nullCheckString(admin.getUserName());
		nullCheckString(admin.getPassword());
		List<AdminInfo> list=new ArrayList<>();
		
		String encrypt=passwordEncryption(admin.getPassword());
		admin.setPassword(encrypt);
		list.add(admin);
		adminMap.put(admin.getUserName(), list);
		if(adminMap != null)
		{
			return true;
		}
		return false;
	}
	
	
	public boolean adminLogin(String userName,String password) throws CustomException
	{
		if(adminMap == null)
		{
			throw new CustomException("sorry, please sign up in admin account");
		}
		String encrypt=passwordEncryption(password);
		for(String  map:adminMap.keySet())
		{
			List<AdminInfo>  list1=adminMap.get(map);
			for(int i=0;i< list1.size();i++)
			{
			 AdminInfo admin=list1.get(i);	
			
				if(userName.equals(map) && encrypt.equals(admin.getPassword()))
				{
					return true;
			  }
		    }
			}
		return false;
	}
	
	public List<List<StockInfo>> showListOfStocksToAdminLessThanTen() throws CustomException
	{
		
		List<StockInfo> list=new ArrayList<>();
		
		for(String value:stockMap.keySet())
		{
			list=stockMap.get(value);
			if(list.size() <= 10)
			{
				stockList.add(list);
			}
		}
		return stockList;
	}
	
	public boolean  adminIdCheck(int id) throws CustomException
	{
		for(int i=0;i< adminId.length;i++)
		{
			if(adminId[i]== id)
			{
				return true;
			}
		}
		
		return false;
	}
	
   public  void discountForHighStocks() throws CustomException
   {
	   if(stockMap == null)
	   {
		   throw new CustomException("Details are empty ");
	   }
	   
	   for(String value:stockMap.keySet())
	   {
	   List<StockInfo> list=stockMap.get(value);
	   if(list.size() > 10)
	   {
		   for(int i=0;i< list.size();i++)
		   {
		    StockInfo info=list.get(i);
		    double price=(info.getPrice()*10)/100;
		    info.setPrice(price);
		    list.add(info);
		    stockMap.put(value, list);
		    
	        }
       }
	 }
   }
   
   public String showHistory(String userName) throws CustomException
   {
	   CustomerInfo info=customerMap.get(userName);
	   String res="";
	   res+=info.getInvoiceNumber() +"/n"+ info.getDate();
	   return res;
   }
	
	
   public String showHistoryAbountPurchasedItem(String userName) throws CustomException
   {
	   String res="";
	   CustomerInfo info=customerMap.get(userName);
	  
	   res+="/n"+info.getAddtoCart() +"/n"+info.getAmount();
	   return res;
   }
   
//   public boolean passwordChangeAutnentication(String password) throws CustomException
//   {
//	   nullCheckString(password);
//	   boolean val=validatepassword(password);
//	   String res=passwordEncryption(password);
//	   boolean res1=validatepassword(res);
//	   if(val && res1)
//	   {
//		   return true;
//	   }
//	   return false;
//   }
   
   public boolean changePassword(String username,long mobileNumber,String password) throws CustomException
   {
	   if(!customerMap.containsKey(username))
	   {
		   return false;
	   }
	   CustomerInfo info=customerMap.get(username);
	   if((info.getMobileNumber() ==  mobileNumber) && (info.getUsername().equals(username)))
	   {
		   boolean res=validatepassword(password);
		   if(res)
		   {
		   String pass=passwordEncryption(password);
		   info.setPassword(pass);
		   customerMap.put(username, info);
		   return true;
		   
	   }
	   }
	   return false;
   }
	   
	   
	 public double uniqueDiscount(int count,int discount) throws CustomException
	 {
		 double amountMoney=0;
	 
		 for(Map.Entry<String, List<StockInfo>> map:stockMap.entrySet())
		 {
		  List<StockInfo> list=stockMap.get(map.getKey());
		  for(int i=0;i< list.size();i++)
		  {
			  StockInfo info=list.get(i);
			  if(count < info.getStockCount())
			  {
				  amountMoney=(info.getPrice()*discount)/100;
			  }
		  }
		 }
		 return amountMoney;
	 }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}
