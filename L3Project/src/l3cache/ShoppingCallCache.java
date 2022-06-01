package l3cache;

import java.util.List;
import java.util.Map;

import exception.CustomException;
import l3Model.AdminInfo;
import l3Model.CustomerInfo;
import l3Model.StockInfo;


public class ShoppingCallCache {
	
	 static ShoppingCache cache=new ShoppingCache();

	public  Map<String,CustomerInfo> addCustomerDetails(CustomerInfo custom) throws CustomException
	{
		return ShoppingCallCache.cache.addCustomer(custom);
	}
	public List<StockInfo>  addListOfStock(StockInfo stock) throws CustomException
	{
		return cache.showListofGadegets(stock);
	}
	
	public boolean passwordValidate(String password) throws CustomException
	{
		return cache.validatepassword(password);
	}
	 
	public String passwordEncrypt(String password) throws CustomException
	{
		return cache.passwordEncryption(password);
	}
   
	public boolean loginCredentials(String username,String password) throws CustomException
	{
		return cache.login(username, password);
	}
	
	public List<StockInfo> getsearchedGadget(String searchBrand) throws CustomException
	{
		return cache.getCustomerSearchedGadgets(searchBrand);
	}
	
	
	public List<StockInfo> getSearcheBrand(String searchGadget,String searchBrand) throws CustomException
	{
		return cache.getCustomerSearchedBrand(searchGadget, searchBrand);
	}
	
	public List<StockInfo>  getSearchModel(String searchGadget,String searchBrand,String searchModel)throws CustomException
	{
		return cache.getCustomerSearchedModel(searchGadget, searchBrand, searchModel);
	}
	
	public boolean addAdminAccount(AdminInfo admin) throws CustomException
	{
		return  cache.adminAccountAdd(admin);
	}

	public boolean adminLogin(String username,String password) throws CustomException
	{
		return  cache.adminLogin(username, password);
	}
	
	public List<List<StockInfo>> listOfStocksShownLessThanTen() throws CustomException
	{
		return cache.showListOfStocksToAdminLessThanTen();
	}

	public boolean adminIdCheck(int id) throws CustomException
	{
		return cache.adminIdCheck(id);
	}
	
	public double amountCalculate(String category,String brand,String model,String userName) throws CustomException
	{
		return cache.amountCalculate(category, brand, model, userName);
	}
	public String addTocart(String category,String brand,String model,String userName,double amount) throws CustomException
	{
		return cache.bookedGadgets(category, brand, model, userName, amount);
	}
	
	public void dealTheHighestStock()throws CustomException
	{
		cache.discountForHighStocks();
	}
	
	public String customerHistoryInvoice(String userName) throws CustomException
	{
		return cache.showHistory(userName);
	}
	
	public String customerHistoryInfoAboutPurchase(String userName) throws CustomException
	{
		return cache.showHistoryAbountPurchasedItem(userName);
	}
	
	public boolean passwordChange(String userName,long mobieNumber,String password) throws CustomException
	{
		return cache.changePassword(userName, mobieNumber, password);
	}
	
	public double uniqueDiscountForPurchasedItem(int count,int discount) throws CustomException
	{
		return cache.uniqueDiscount(count, discount);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
 