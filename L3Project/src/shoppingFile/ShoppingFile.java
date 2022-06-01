package shoppingFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import exception.CustomException;
import l3Model.AdminInfo;
import l3Model.CustomerInfo;
import l3Model.StockInfo;
import l3cache.ShoppingCache;

public class ShoppingFile implements ShoppingCartInterface {
	
	
	public void write(Map<String,CustomerInfo>  map,Map<String,List<StockInfo>>  stock) throws CustomException
	{
		//ShoppingCache cache=new ShoppingCache();
		//ShoppingFileCache fileCache=new ShoppingFileCache();
		File file=null;
		try {
		  file=new File("ShoppingCart.txt");
		  System.out.println("File "+map);
		if(file.exists())
		{
			System.out.println("File created Successfully ");
		
		}
		else {
			file.createNewFile();
			System.out.println("File created Successfully1 ");
		}
		FileOutputStream out=new FileOutputStream(file);
		ObjectOutputStream object=new ObjectOutputStream(out);
		object.writeObject(map);
		object.writeObject(stock);
		//object.writeObject(adminMap);
		out.close();
		object.close();
		
		System.out.println("File writed Successfully ");
		
		}
		catch(IOException exception)
		{
			System.out.println("exception in "+exception.getMessage());
		}
	}

	public ShoppingFileCache readObject() 
	{
		ShoppingFileCache cache=new ShoppingFileCache();
		
		try {
			FileInputStream fileIn=new FileInputStream("ShoppingCart.txt");
			ObjectInputStream object=new ObjectInputStream(fileIn);
			Map<String,CustomerInfo> map=(Map<String,CustomerInfo>) object.readObject();
			Map<String,List<StockInfo>> mapList=(Map<String,List<StockInfo>>) object.readObject();
			//Map<String,List<AdminInfo>>  adminapList=(Map<String,List<AdminInfo>>)  object.readObject();
			cache.mapEqualizer(map, mapList);
			fileIn.close();
			object.close();
		
			cache.mapEqualizer(map, mapList);
		   }
		catch(CustomException | IOException | ClassNotFoundException exception)
		{
			System.out.println("exception in read "+exception.getMessage());
		}
		return cache;
	}

	
		
	
}
