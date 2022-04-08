package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysRun {
          static Scanner scan=new Scanner(System.in);
          ArraysLogic  arrays=new ArraysLogic();


	public void Rotation()
	{
		 
		 
			System.out.println("Enter a number to give the many number of loop ");
			int num=scan.nextInt();
		    int b=0;
		    while(num>b)
			{
		      System.out.println("Enter the  number ");
			  int number=scan.nextInt();
			  System.out.println("Enter th rotation num");
			  int d=scan.nextInt();
			  int[] ans=new int[number];
			  for(int h=0;h<number;h++)
			  {
				  System.out.println("Enter the arrays ");
				  ans[h]=scan.nextInt();
			  }
			  for(int k=d;k<ans.length;k++)
			  {
				  System.out.print(ans[k]+" "); 
			  }
			  for(int s=0;s<d;s++)
			  {
				  System.out.print(ans[s]+" ");
			  }
			  System.out.println();
			  num--;
			
		}
	}
	
	public void greaterArrays()
	{
		System.out.println("Enter a number of times you want to perform the operation greatest count"); 
		int n=scan.nextInt(); 
		for(int i=0;i<n;i++) 
		{
		 System.out.println("enter a number of arrays to print");	
		int number=scan.nextInt();
		int[] arr=new int[number];
		for(int j=0;j < number;j++)
		{
			System.out.println("Enter the arrays "+ j );
			arr[j]=scan.nextInt();	
		}
		System.out.println(Arrays.toString(arrays.greaterArray(arr)));
		}
	}
	
	public void swappingOfArrays()
	{
		System.out.println("Enter a no of times you want to perform the operation swapping of arrays "); 
		int n=scan.nextInt(); 
		for(int i=0;i<n;i++) 
		{
		System.out.println("enter a number of arrays to print");	
		int number=scan.nextInt();
		int[] arr=new int[number];
		for(int j=0;j < number;j++)
		{
			System.out.println("Enter the arrays "+ j );
			arr[j]=scan.nextInt();	
		}
		System.out.println(Arrays.toString(arrays.swapArray(arr, number)));
		}
	}
	
	
	public void sortArray()
	{
		System.out.println("Enter a no of times you want to perform the operation swapping of arrays "); 
		int n=scan.nextInt(); 
		for(int i=0;i<n;i++) 
		{
		System.out.println("enter a number of arrays to print");
		int Number=scan.nextInt();
		long[] arr=new long[Number];
		for(int j=0;j< Number; j++)
		{
			arr[j]=scan.nextInt();
		}
		System.out.println(arrays.alternateSort(arr, Number));
		}
	}
	
	public void majorityElements()
	{
		System.out.println("Enter a no of times you want to perform the operation majority count "); 
		int n=scan.nextInt(); 
		for(int i=0;i<n;i++) 
		{
		System.out.println("enter a number of arrays to print");
		int Number=scan.nextInt();
		int[] arr=new int[Number];
		for(int j=0;j< Number; j++)
		{
			arr[j]=scan.nextInt();
		}
		System.out.println(arrays.majorityElement(arr,Number));
		}
	}
	public void shuffleElements()
	{
		System.out.println("Enter a no of times you want to perform the operation shuffleElements"); 
		int n=scan.nextInt(); 
		for(int i=0;i<n;i++) 
		{
		System.out.println("enter a number of arrays to print");
		int Number=scan.nextInt();
		int[] arr=new int[Number];
		for(int j=0;j< Number; j++)
		{
			arr[j]=scan.nextInt();
		}
		System.out.println(Arrays.toString(arrays.shuffle(arr,Number/2)));
		}
	}
	public void balancedArrays()
	{
		System.out.println("Enter a no of times you want to perform the operation swapping of arrays "); 
		int n=scan.nextInt(); 
		for(int i=0;i<n;i++) 
		{
		System.out.println("enter a number of arrays to print");
		int Number=scan.nextInt();
		long[] arr=new long[Number];
		for(int j=0;j< Number; j++)
		{
			arr[j]=scan.nextInt();
		}
		System.out.println(arrays.balancedArray(arr, Number));
		}
	}
	public void minDifference()
	{
	System.out.println("Enter a no of times you want to perform the operation min diff"); 
	int n=scan.nextInt(); 
	for(int i=0;i<n;i++) 
	{
	System.out.println("enter a number of arrays to print");
	int Number=scan.nextInt();
	int[] arr=new int[Number];
	for(int j=0;j< Number; j++)
	{
		arr[j]=scan.nextInt();
	}
	System.out.println(arrays.minimum_difference(arr));
	}
	}
	public void majorityCheck()
	{
	System.out.println("Enter a no of times you want to perform the operation majority count"); 
	int n=scan.nextInt(); 
	for(int i=0;i<n;i++) 
	{
	System.out.println("enter a number of arrays to print");
	int Number=scan.nextInt();
	int[] arr=new int[Number];
	for(int j=0;j< Number; j++)
	{
		arr[j]=scan.nextInt();
	}
	System.out.println(arrays.Majority(arr, Number));
	}
	}
	
	public void kadanes()
	{
	System.out.println("Enter a no of times you want to perform the operation majority count"); 
	int n=scan.nextInt(); 
	for(int i=0;i<n;i++) 
	{
	System.out.println("enter a number of arrays to print");
	int Number=scan.nextInt();
	int[] arr=new int[Number];
	for(int j=0;j< Number; j++)
	{
		arr[j]=scan.nextInt();
	}
	System.out.println(arrays.kadeanesAlgorithm(arr, Number));
	}
	}
	public void goodPairOfCount()
	{
	System.out.println("Enter a no of times you want to perform the operation good pair count"); 
	int n=scan.nextInt(); 
	for(int i=0;i<n;i++) 
	{
	System.out.println("enter a number of arrays to print");
	int Number=scan.nextInt();
	int[] arr=new int[Number];
	for(int j=0;j< Number; j++)
	{
		arr[j]=scan.nextInt();
	}
	System.out.println(arrays.goodPair(arr));
	}
	}
	public void minimumDistance()
	{
	System.out.println("Enter a no of times you want to perform the operation minimum difference"); 
	int n=scan.nextInt(); 
	for(int i=0;i<n;i++) 
	{
	System.out.println("enter a number of arrays to print");
	int Number=scan.nextInt();
	int[] arr=new int[Number];
	for(int j=0;j< Number; j++)
	{
		System.out.println("Enter the number of arrays ");
		arr[j]=scan.nextInt();
	}
	System.out.println("Enter the x value to matched ");
	int x=scan.nextInt();
	System.out.println("Enter the y value to be matched");
	int y=scan.nextInt();
	System.out.println(arrays.minDist(arr,Number,x,y));
	}
	}
	
	public void leaderMax()
	{
	System.out.println("Enter a no of times you want to perform leaders"); 
	int n=scan.nextInt(); 
	for(int i=0;i<n;i++) 
	{
	System.out.println("enter a number of arrays to print");
	int Number=scan.nextInt();
	int[] arr=new int[Number];
	for(int j=0;j< Number; j++)
	{
		arr[j]=scan.nextInt();
	}
	System.out.println(arrays.kadeanesAlgorithm(arr, Number));
	}
	}
	public void positiveRearrange()
	{
	System.out.println("Enter a no of times you want to perform leaders"); 
	int n=scan.nextInt(); 
	for(int i=0;i<n;i++) 
	{
	System.out.println("enter a number of arrays to print");
	int Number=scan.nextInt();
	int[] arr=new int[Number];
	for(int j=0;j< Number; j++)
	{
		arr[j]=scan.nextInt();
	}
	arrays.postiveNegative(arr, Number);
	}
	}
	public void subArray()
	{
	System.out.println("Enter a no of times you want to perform subarray"); 
	int n=scan.nextInt(); 
	for(int i=0;i<n;i++) 
	{
	System.out.println("enter a number of arrays to print");
	int Number=scan.nextInt();
	int[] arr=new int[Number];
	for(int j=0;j< Number; j++)
	{
		arr[j]=scan.nextInt();
	}
	System.out.println(arrays.findsum(arr, Number));
	}
	}
	
	public void firstNonRepeating()
	{
	System.out.println("Enter a no of times you want to perform subarray"); 
	int n=scan.nextInt(); 
	for(int i=0;i<n;i++) 
	{
	System.out.println("enter a number of arrays to print");
	int Number=scan.nextInt();
	int[] arr=new int[Number];
	for(int j=0;j< Number; j++)
	{
		arr[j]=scan.nextInt();
	}
	System.out.println(arrays.firstNonRepeating(arr, Number));
	}
	}
	
	public void findMinimumSorted()
	{
	System.out.println("Enter a no of times you want to perform subarray"); 
	int n=scan.nextInt(); 
	for(int i=0;i<n;i++) 
	{
	System.out.println("enter a number of arrays to print");
	int Number=scan.nextInt();
	int[] arr=new int[Number];
	for(int j=0;j< Number; j++)
	{
		arr[j]=scan.nextInt();
	}
	System.out.println(arrays.minSortedElement(arr, Number));
	}
	}
	
	public void givenIndex()
	{
	System.out.println("Enter a no of times you want to perform subarray"); 
	int n=scan.nextInt(); 
	for(int i=0;i<n;i++) 
	{
	System.out.println("enter a number of arrays to print");
	int Number=scan.nextInt();
	int[] arr=new int[Number];
	for(int j=0;j< Number; j++)
	{
		arr[j]=scan.nextInt();
	}
	System.out.println("Enter a index occurs in the found ");
	int index=scan.nextInt();
	System.out.println(arrays.minSortedElement(arr, index));
	}
	}
	
	public void countPairsWithGivenSum()
	{
	System.out.println("Enter a no of times you want to perform subarray"); 
	int n=scan.nextInt(); 
	for(int i=0;i<n;i++) 
	{
	System.out.println("enter a number of arrays to print");
	int Number=scan.nextInt();
	int[] arr=new int[Number];
	for(int j=0;j< Number; j++)
	{
		arr[j]=scan.nextInt();
	}
	System.out.println("Enter a sum amount to be equal ");
	int k=scan.nextInt();
	System.out.println(arrays.getPairsCount(arr,Number,k));
	}
	}
	public static void main(String[] args)
	{
		ArraysRun run=new ArraysRun();
		System.out.println("Enter a number to run the loop");
		int n=scan.nextInt();
		
		switch(n)
		{
		
		case 1:
			run.Rotation();
		case 2:
		    run.greaterArrays();
		case 3:
		    run.swappingOfArrays();
		case 4:
		    run.sortArray();
		case 5:
			run.majorityElements();	
		case 6:	
			run.shuffleElements();
		case 7:	
			run.balancedArrays();
		case 8:	
			 run.minDifference();
		case 9:	
			run.majorityCheck();
		case 10:	
			run.kadanes();
		case 11:	
			run.goodPairOfCount();
		case 12:	
			run.minimumDistance();
		case 13:	
			run.leaderMax();
		case 14:	
			run.positiveRearrange();
		case 15:	
			run.subArray();
		case 16:	
			 run.firstNonRepeating();
		case 17:	
			run.findMinimumSorted();
		case 18:	
			run.givenIndex();
		case 19:	
			run.countPairsWithGivenSum();
		

		}
	}
}
