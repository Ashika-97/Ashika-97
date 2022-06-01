package shoppingFile;

import java.util.List;
import java.util.Map;

import exception.CustomException;
import l3Model.AdminInfo;
import l3Model.CustomerInfo;
import l3Model.StockInfo;
import l3cache.ShoppingCache;

public interface ShoppingCartInterface {
	
	
	public void write(Map<String,CustomerInfo> map,Map<String,List<StockInfo>>  stockList) throws CustomException;
	
	public ShoppingFileCache readObject() ;

	

}
