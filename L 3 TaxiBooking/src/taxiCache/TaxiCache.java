package taxiCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import taxiPojo.CustomException;
import taxiPojo.CustomerPojo;
import taxiPojo.TaxiPojo;

public class TaxiCache {
	
   static  Map<Character,List<Integer>> availableTaxi=new HashMap<>();
   static Map<Integer,List<TaxiPojo>>   taxiMap=new HashMap<>();
   static Map<Integer,CustomerPojo>  customerMap=new HashMap<>();
    int taxiNumber=1997;
    
    
    char[] ch= {'A','B','C','D','E','F'};
    public int autoGenearateTaxiNumber()
    {
    	return ++taxiNumber;
    }
    
    
    public int showAvailableTaxi(char pickup) throws CustomException
    {
    	if(availableTaxi == null)
    	{
    		throw new CustomException("No availableTaxi here ");
    	}
    	if(taxiMap == null )
    	{
    		throw new CustomException("All taxi are booked");
    	}
    	int min=Integer.MAX_VALUE;
    	List<Integer> list=availableTaxi.get(pickup);
    	
    	

		List<TaxiPojo>  list1=null;
		List<TaxiPojo>  list2=null;
    	if(availableTaxi.containsKey(pickup))
    	{
    		for(int i=0;i< list.size()-1;i++)
    		{
    			int num=list.get(i);
    			int num1=list.get(i+1);
    			
    			  list1=taxiMap.get(num);
    			  list2=taxiMap.get(num1);
			
			    	TaxiPojo taxi=null;
			    	TaxiPojo taxi1=null;
			    	
			    	if(list1 != null && list2!=null)
			    	{
			    	for(int j=0;j< list1.size() || j < list2.size();j++)
			    	{
			    		taxi=list1.get(j);
			    		taxi1=list2.get(j);
			    	
			    	
				    	if(taxi.getAmount() < taxi1.getAmount())
				    	{
				    		min=num;
				    	}
				    	else {
				    		min=num1;
				    	}
			         }
			    }
    		}	
         }
    	else if( availableTaxi!= null)
    	{
    		for(char character:availableTaxi.keySet())
    		{
    			int val=calculateDistance(pickup,character);
    			min=Math.min(val, min);
    			System.out.println("the taxi "+ character +" go to position "+ pickup);
    		}
    		
    	}
    	else
    	{
    		throw new CustomException("All taxi are booked");
    	}
    	return min;
    }
    
    
   
    public int calculateDistance(char pickup,char drop) throws CustomException
    {
    	int start=0,end=0;
    	for(int i=0;i< ch.length;i++)
    	{
    		if(ch[i]==pickup)
    		{
    		start=i;	
    		}
    		if(ch[i]== drop)
    		{
    			end=i;
    		}
    	}
    	int min=Math.abs(start-end);
    	
    	return min;
    }
     
    List<Integer>  list2=null;
    public CustomerPojo bookTaxi(CustomerPojo custom) throws CustomException
    {
    	int taxiAutoNum=autoGenearateTaxiNumber();
    	TaxiPojo taxinum=new TaxiPojo();
    	custom.setTaxiNumber(taxiAutoNum);
    	List<TaxiPojo>  list1;
    	
    	
    	if(!taxiMap.containsKey(taxiAutoNum));
    	{
    		list1=new ArrayList<>();
    	}
    	if(!availableTaxi.containsKey(custom.getDrop()))
    	{
    		list2=new ArrayList<>();
    	}
    	list2.add(taxiAutoNum);
    	taxinum.setCustomerId(custom.getCustomerId());
    	taxinum.setPickup(custom.getPickup());
    	taxinum.setDrop(custom.getDrop());
    	taxinum.setTaxiNum(taxiAutoNum);
    	int time=calculateDistance(custom.getPickup(),custom.getDrop());
    	taxinum.setTime(time);
        int amountCalculate=balanceAmount(time,custom.getAmount());
        custom.setAmount(amountCalculate);
    	double getTotalAmount=taxinum.getTotalAmount()+amountCalculate;
        taxinum.setTotalAmount(getTotalAmount);
        taxinum.setAmount(amountCalculate);
        list1.add(taxinum);
        customerMap.put(custom.getCustomerId(), custom);
        availableTaxi.put(custom.getDrop(),list2);
        taxiMap.put(taxiAutoNum, list1);
       
       return custom;
    }
	
	public int  balanceAmount(int time,long customerAmount) throws CustomException
	{
		int amountCalculate=time*15;
    	if(customerAmount == 100)
    	{
    		
    		int amount=amountCalculate*10;
    		amountCalculate=amount-100;
    	}
    	else {
    		amountCalculate*=10;
    	}
    	return amountCalculate;
		
	}
	
	public boolean customerExits(double amount,int customerId) throws CustomException
	{
		if(!customerMap.containsKey(customerId))
		{
			throw new CustomException("customer not available ");
		}
		
		
		CustomerPojo custo=customerMap.get(customerId);
		List<TaxiPojo> list=taxiMap.get(custo.getTaxiNumber());
		char ch1Point=custo.getDrop();
		if(list!= null)
		{
			for(int i=0;i< list.size();i++)
			{
		   TaxiPojo taxipojo=list.get(i);
		   
		   if(taxipojo.getAmount() == amount)
		   {
			   taxipojo.setDrop(ch1Point);
			   list.add(taxipojo);
			   taxiMap.put(taxiNumber, list);
		   
			   return true;
		   }
		  
		}
	   }
		return false;
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

/*Map<Integer,TaxiPojo>  taxi=new HashMap<>();//taxiNumber
List<Character> list=new ArrayList<>();
Map<Integer,CustomerPojo> custom=new HashMap<>();//customerId
int taxiNumber=0;
char[] ch= {'A','B','C','D','E','F'};


public int taxiNumberGenerate()
{
	return ++taxiNumber;
}

public double calculateAmountFromDistance(int km) throws CustomException
{
  return km*10*15;
}


public String bookTaxi(CustomerPojo customer) throws CustomException
{

	int taxiNum=taxiNumberGenerate();
	TaxiPojo taxiSet=new TaxiPojo();
	taxiSet.setTaxiNumber(taxiNum);
	taxiSet.setCustomerId(customer.getCustomerId());
	taxiSet.setPickUpPoint(customer.getPickupPoint());
	taxiSet.setDropPoint(customer.getDropPoint());
	taxiSet.setPosition(customer.getDropPoint());
	double amount=amountCalculateCustomer(customer.getPickupPoint(),customer.getDropPoint());
	if(customer.getAmount()==100)
	{
		amount-=100;
	}
	taxiSet.setAmount(amount);
	list.add(taxiSet.getPosition());
	taxi.put(taxiNum, taxiSet);
	custom.put(customer.getCustomerId(), customer);
	return "your call taxiNumber is " + taxiNumber;
}


public int  taxiKilometreDistance(char pickUp,char dropPoint) throws CustomException
{
	int val=0,val1=0,min=0;
	
	for(int i=1;i<= ch.length;i++)
	{
		if(ch[i] == pickUp)
		{
			val=i;
		}
		else if(ch[i]== dropPoint)
		{
			val1=i;
		}
	}
	
	min=Math.abs(val-val1);

	return min;
}


public double amountCalculateCustomer(char pickUp,char dropPoint) throws CustomException
{
	int km=taxiKilometreDistance(pickUp,dropPoint);
	double balAmount=calculateAmountFromDistance(km);
	return balAmount;
}

public char showAvailability(char pickuppoint) throws CustomException
{
	if(list== null)
	{
		throw new CustomException("Taxis are not available");
	}
	
	char pos='A';
	for(int i=0;i<list.size();i++)
	{
	
	pos=list.get(i);
	}
	
	return pos;
}*/
