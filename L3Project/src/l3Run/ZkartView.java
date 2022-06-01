package l3Run;

import java.util.Scanner;

import exception.CustomException;
import l3cache.ShoppingCallCache;

public class ZkartView {
	static Scanner scan=new Scanner(System.in);
	static ZkartRun call=new ZkartRun();
	
	public void showOptionsForAdmin()
	{
		System.out.println("1-Admin login ");
		System.out.println();
		//System.out.println("2-Admin login ");
		
		
	}
	
	
	
	public void showOptionsForCustomer()
	{
		System.out.println("1-Customer new account signup");
		System.out.println();
		System.out.println("2-Customer login");
		System.out.println();
		
	}
	
	
	
	
	public static void main(String[] args)
	{
		ZkartView view=new ZkartView();
		//view.showOptionsForAdmin();
		//view.showOptionsForCustomer();
		try {
			call.addDummyValues();
		} catch (CustomException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		boolean flag=true;
		System.out.println("Enter the number 1-Customer site ;2-Admin site");
		int number=scan.nextInt();
		switch(number)
		{
		case 1:
		{
		while(flag)
		{
			view.showOptionsForCustomer();
			System.out.println("Enter the choices to to seek the customer details ");
			int n=scan.nextInt();
			scan.nextLine();
		
		switch(n)
		{
		case 1:call.newAccountSignUp();
		break;
		
		case 2:call.loginUserPass();
		break;
		case 3:flag=false;
		break;
		}
		
		}
		}
		
		case 2: 
			{
				boolean flag1=true;
			
				while(flag1)
				{
	
					try {
						call.addDummyValues();
					} catch (CustomException e) {
						
						System.out.println(e.getMessage());
					}
					System.out.println("Enter the choices to to seek the Admin  ");
					int num=scan.nextInt();
					scan.nextLine();
					
						
					switch(num)
					{
					
					case 1: call.adminLogin();
					break;
//					case 2:try {
//							call.addDummyValues();
//						} catch (CustomException e) {
//							
//							System.out.println(e.getMessage());
//						}
//					break;
					
					case 2:flag=false;
					//case 2:call.addStockList();
				//	break;
					
//					case 3:call.adminLogin();
//					break;
//					
//					case 4:call.dealersHighDiscount();
//					break;
					
				
			
			     }
		     }
				
			}
		}	
		
	}

}
