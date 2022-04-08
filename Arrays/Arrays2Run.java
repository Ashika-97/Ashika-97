package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Arrays2Run {
	
	static Scanner scan=new Scanner(System.in);
	Arrays2Logic log=new Arrays2Logic();
	
	public void minChocolates()
	{
		System.out.println("Enter the number of arrays you want ? ");
		long n=scan.nextLong();
		Long[] arr=new Long[(int) n];
		ArrayList<Long> list=new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			arr[i]=scan.nextLong();
			list.add(arr[i]);
		}
		System.out.println("Enter the number of distribution ");
		long m=scan.nextLong();
		System.out.println(log.findMinDiff(list, n, m));
		
		
		
	}
	
	public void coinChange()
	{
		System.out.println("Enter a number ");
		int n=scan.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=scan.nextInt();
		}
		System.out.println("Enter a number of possibleoutcomes ");
		int num=scan.nextInt();
		System.out.println(log.count(arr, n, num));
		
		
	}
	
	public void sumPairClosedToX()
	{
		System.out.println("Enter a number ");
		int n=scan.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=scan.nextInt();
		}
		System.out.println("Enter a number for x ");
		int x=scan.nextInt();
		System.out.println(Arrays.toString(log.sumClosest(arr, x)));
		
		
		
		
	}
	public void rotateOne()
	{
		System.out.println("Enter a number ");
		int n=scan.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=scan.nextInt();
		}
		
		log.rotate(arr, n);
	}
	
	
	  public void mismatchArray() {
	  System.out.println("Enter a number to provide array "); 
	  int n=scan.nextInt();
	  scan.nextLine(); 
	  String[] arr=new String[n]; 
	  String[] arr1=new String[n];
	  for(int i=0;i<n;i++) 
	  { System.out.println("Enter the first Array ");
	  arr[i]=scan.nextLine(); 
	  System.out.println("Enter the second Array ");
	  arr1[i]=scan.nextLine(); 
	  } 
	  System.out.println(log.mismatchedArray(arr, arr1)); 
	  }
	  
	  public void union()
	  { 
		System.out.println("Enter a number to provide array ");
	  int n=scan.nextInt(); scan.nextLine();
	  ArrayList<Integer> list=new ArrayList<>();
	  ArrayList<Integer> list1=new ArrayList<>();
	  int[] arr=new int[n];
	  int[] arr1=new int[n];
	  for(int i=0;i<n;i++) 
	  {
	  System.out.println("Enter the first Array ");
	  arr[i]=scan.nextInt();
	  list.add(arr[i]);
	  }
	  System.out.println("Enter a number of array for second list");
	  int num=scan.nextInt();
	  for(int i=0;i<num;i++)
	  {
	  System.out.println("Enter the second Array "); 
	  arr1[i]=scan.nextInt();
	  list1.add(arr1[i]);
	  }
	  System.out.println(log.unionArray(list, list1)); 
	  log.exceptArray(list, list1);
	  log.intersectArray(list, list1);
	  }
	 
	
	
	  
	  
	public void tripletMultiply()
	{
	 System.out.println("Enter a number of array to enter ");	
	 int n=scan.nextInt();
	 int[] arr=new int[n];
	 ArrayList<Integer> arraylist=new ArrayList<>();
	 for(int i=0;i<n;i++)
	 {
		 System.out.println("Enter a arr to add in the list ");
		 arr[i]=scan.nextInt();
		 arraylist.add(arr[i]);
	 }
	System.out.println(log.tripleMultiply(arraylist,n));
	}
	
	public void pairDifference()
	{
		System.out.println("Enter a number of array ");
		int n=scan.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=scan.nextInt();
		}
		System.out.println("Enter a diiference equal");
		int m=scan.nextInt();
		System.out.println(log.findPair(arr, n, m));
		
		
	}
	
	
	
	public void rotateSameLength()
	{
		System.out.println("Enter a number of array ");
		int n=scan.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=scan.nextInt();
		}
		log.rotataeSame(arr, n);
		
	}
	
	public void leftRotated()
	{
		System.out.println("Enter a number of array ");
		int n=scan.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=scan.nextInt();
		}
		System.out.println("Enter a left rotated condition ");
		int num=scan.nextInt();
		log.leftRotation(arr, num);
				
	}
	
	public void longSubSdeq()
	{
	  System.out.println("Enter the number of array ");
	  int num=scan.nextInt();
	  int[] arr=new int[num];
	  for(int i=0;i<num;i++)
	  {
		  arr[i]=scan.nextInt();
	  }
	  System.out.println(log.longSub(arr, num));
			
	}
	
	
	public void nonDec()
	{
		System.out.println("Enter a number of array to put ");
		int n=scan.nextInt();
		int[] nums=new int[n];
		for(int i=0;i<n;i++)
		{
		  nums[i]=scan.nextInt();
		}
		System.out.println(log.checkPossibility(nums));
		
	}
	
	public void duplicate() 
	  {
	  System.out.println("Enter a number "); 
	  int n=scan.nextInt();
	  int[] arr=new int[n];
	  for(int i=0;i<n;i++)
	  {
	  arr[i]=scan.nextInt(); 
	  }
	  log.numOfDuplicate(arr);
	  }
	
	public void grandchildCount()
	{
		System.out.println("Enter a number of details to give");
        int n=scan.nextInt();
        scan.nextLine();
		Map<String,String> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
        	System.out.println("Enter the name ");
        	String name=scan.nextLine();
        	System.out.println("Enter the second name ");
        	String input=scan.nextLine();
        	map.put(name,input);
        }
        System.out.println("Enter the search name ");
        String father=scan.nextLine();
	    log.grandChild(map,father);
	   
	}
	

	
	public void overlap()
	{
		System.out.println("Enter a number of array to put ");
		int n=scan.nextInt();
		scan.nextLine();
		ArrayList<Integer> list=new ArrayList<>();
		int[][] nums=new int[n][n];
		for(int i=0;i<n;i++)
		{
			
			for(int j=0;j<n;j++)
			{
				System.out.println("Enter the values ");
		  nums[i][j]=scan.nextInt();
		}
			
		}
		System.out.println(log.overlappingIntervels(nums));
		
	}
	
	public void subSet()
	{
		System.out.println("Enter the number of array to provide ");
		int n=scan.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=scan.nextInt();
		}
		System.out.println(log.canPartition(arr));
	}
	
	public void perfectSum()
	{
		System.out.println("Enter a number ");
		int n=scan.nextInt();
		System.out.println(log.perfectDigits(n));
		
	}
	
	
	public void minimumArrayPrint()
	{
		System.out.println("Enter the number of array ");
		int n=scan.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=scan.nextInt();
		}
		log.minimumPairDiffrerence(arr);
	}
	
	
	
	
	
	
	//
	
	public void sumOfdigits()
	{

		System.out.println("Enter a number of array ");
		int n=scan.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=scan.nextInt();
		}
		System.out.println(Arrays.toString(log.sumOfDigits(arr)));	
		
		
	}
	
	
	
	public void patternPrinting()
	{
		System.out.println("Enter the array Of Size ");
	    int n=scan.nextInt();
	    int[] arr=new int[n];
	    for(int i=0;i<n;i++)
	    {
	    	 arr[i]=scan.nextInt();
	    }
	log.display();
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 
	  public static void main(String[] args)
	  {
		  Arrays2Run run=new Arrays2Run();
		  System.out.println("Enter a number ");
		  int n=scan.nextInt();
		  
		  
		  switch(n)
		  {
		  case 1:
			  run.minChocolates();//1
		  case 2:
			  run.coinChange();//2
		  case 3:
			  run.sumPairClosedToX();//3
		  case 4:
			 run.rotateOne();//4
		  case 5:
		      run.mismatchArray();//5
		  case 6:	  
			  run.pairDifference();//6
		  case 7:
			  run.rotateSameLength();//7
		  case 8:
			  run.union();//8
		  case 9:	
			  run.duplicate();//9
		  case 10:	
			  run.longSubSdeq();//10
		  case 11:
			  run.grandchildCount();//11
		  case 12:
			  run.nonDec();//12
		  case 13:	  
			  run.overlap();//13
		  case 14:	  
			  run.subSet();
		  case 15:	
			  run.tripletMultiply();//15
		  case 16:	  
			   run.perfectSum();
		  case 17:
			  run.leftRotated();//17
		  case 18:
			  run.sumOfdigits();
		  case 19:
			  run.minimumArrayPrint();
		  case 20:
			 run.patternPrinting();
			  
		  }		  
		  
	  }

}
