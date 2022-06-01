package shoppingFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exception.CustomException;
import l3Model.AdminInfo;
import l3Model.CustomerInfo;
import l3Model.StockInfo;

public class ShoppingFileCache {
	
	
	public Map<String,CustomerInfo> customMap=new HashMap<>();
	public Map<String,List<StockInfo>> stockInfoMap=new HashMap<>();
	//public Map<String,List<AdminInfo>> adminMap;
	
	public void mapEqualizer(Map<String,CustomerInfo> custom,Map<String,List<StockInfo>> stock) throws CustomException
	{
		this.customMap=custom;
		this.stockInfoMap=stock;
		//this.adminMap=adminList;
	}
	
	public boolean addCustomer(CustomerInfo custom) throws CustomException
	{
		customMap.put(custom.getUsername(),custom);
		return true;
	}
	
	public boolean addStock(StockInfo stock) throws CustomException
	{
		List<StockInfo> list=new ArrayList<>();
		list.add(stock);
		stockInfoMap.put(stock.getCategory(), list);
		return true;
	}
	
	public List<StockInfo>  getSearchStock(String category) throws CustomException
	{
		return stockInfoMap.get(category);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
