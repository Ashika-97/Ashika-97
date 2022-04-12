package sorted;

import java.util.Arrays;
import java.util.Scanner;

public class SortingMain {
	
	static Scanner scan=new Scanner(System.in);
	SortingLogics sort=new SortingLogics();
	
	public void selectionSort()
	{
		System.out.println("Enter the number of arrays to put inside sorting selection ");
		int n=scan.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=scan.nextInt();
		}
	System.out.println(Arrays.toString(sort.selectionSorting(arr)));
	}

	public void bubbleSorting()
	{
		System.out.println("Enter the number of arrays to put in bubble sort ");
		int n=scan.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=scan.nextInt();
		}
		System.out.println(Arrays.toString(sort.bubbleSort(arr)));
	}
	
	public void insertionSorting()
	{
		System.out.println("Enter the number of arrays to put in bubble sort ");
		int n=scan.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=scan.nextInt();
		}
		System.out.println(Arrays.toString(sort.insertionSort(arr)));
	}
	
	
	public void kthSmallestElements()
	{
		System.out.println("Enter the number of arrays to give ");
		int n=scan.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=scan.nextInt();
		}
		System.out.println("Enter the number to get index  after sorted");
		int num=scan.nextInt();
		System.out.println(sort.kthSmallest(arr,num));
	}
	
	public void anagram()
	{
		System.out.println("Enter the first String ");
		String input=scan.nextLine();
		System.out.println("Enter the second String ");
		String name=scan.nextLine();
		System.out.println(sort.anagrams(input, name));
	}
	
	public void ArraysareEqual()
	{
		System.out.println("Enter the arra input");
		int n=scan.nextInt();
		long[] arr=new long[n];
		for(int i=0;i< n;i++)
		{
			arr[i]=scan.nextLong();
		}
		;
		long[] arr1=new long[n];
		for(int j=0;j<n;j++)
		{
		  arr1[j]=scan.nextLong();
		}
		System.out.println(sort.check(arr, arr1, n));
	}
	
	
	public void sortbyAbsDiff()
	{
		System.out.println("Enter the number of input ");
		int n=scan.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=scan.nextInt();
		}
		System.out.println("Enter the diffrence value ");
		int k=scan.nextInt();
		sort.sortAbs(arr, n, k);
	}
	
	public void booleanArraySortedorNot()
	{
		System.out.println("Enter tha number of inputs");
		int n=scan.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=scan.nextInt();
		}
		System.out.println(sort.arraySortedOrNot(arr, n));
	}
	
	
	public void sumOfInteger()
	{
		System.out.println("Enter the number of input ");
		int n=scan.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=scan.nextInt();
		}
		System.out.println(sort.sumOfInteger(arr, n));
	}
	
	
	public void toycounts()
	{
		System.out.println("Enter the number of input ");
		int n=scan.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=scan.nextInt();
	    }
		System.out.println("Enter the amount ");
		int k=scan.nextInt();
		System.out.println(sort.toyCount(n, k, arr));
	}
	
	public void candy()
	{
		System.out.println("Enter the number of input ");
		int n=scan.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=scan.nextInt();
	    }
		System.out.println("Enter the amount ");
		int k=scan.nextInt();
		System.out.println(sort.candyStore(arr, n, k));
	}
	public void bitonicGen()
	{
		System.out.println("Enter the number of input ");
		int n=scan.nextInt();
		long[] arr=new long[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=scan.nextLong();
	    }
		sort.bitonicGenerator(arr, n);
	}
	
	
	public void mergedSorting()
	{
		System.out.println("Enter the number of arrays to put in merge sort ");
		int n=scan.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
		{
		 arr[i]=scan.nextInt();
		}
		System.out.println(Arrays.toString(sort.mergeSort(arr)));
	
	}
	
	public void quickSorting()
	{
		System.out.println("Enter the number of arrays to put inside ");
		int n=scan.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=scan.nextInt();
		}
		int l=0;
		
		System.out.println(Arrays.toString(sort.quickSort(arr,l,n-1)));
	}
	
	
	public void merge2Array()
	{
		System.out.println("Enter the number of arrays to put inside ");
		int n=scan.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=scan.nextInt();
		}
		System.out.println("Enter the second array number ");
		int m=scan.nextInt();
		int[] arr1=new int[m];
		for(int i=0;i<m;i++)
		{
			arr1[i]=scan.nextInt();
		}
		sort.twoArraysAlignSpace(arr, arr1, n, m);
	}
	
	
	public void minimumSwaps()
	{
		System.out.println("Enter the number of arrays to put inside ");
		int n=scan.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=scan.nextInt();
		}
		System.out.println(sort.minSwaps(arr));
	}
	
	public void sortByElementsByFrequency()
	{
		System.out.println("Enter the number of arrays to put inside ");
		int n=scan.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=scan.nextInt();
		}
		System.out.println(sort.sortByFrequency(arr, n));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args)
	{
		SortingMain input=new SortingMain();
		System.out.println("Enter the number to proceed sortings ");
		int n=scan.nextInt();
		scan.nextLine();
		
		
		switch(n)
		{
		case 1:input.selectionSort();
		
		case 2:input.bubbleSorting();
		
		case 3:input.insertionSorting();
		
		case 4:input.mergedSorting();
		
		case 5:input.kthSmallestElements();
		
		case 6:input.anagram();
		
		case 7:input.ArraysareEqual();
		
		case 8:input.sortbyAbsDiff();
		
		case 9:input.booleanArraySortedorNot();
		
		case 10:input.sumOfInteger();
		
		case 11:input.toycounts();
		
		case 12:input.candy();
		
		case 13:input.bitonicGen();
		
		case 14:input.quickSorting();
		
		case 15:input.merge2Array();
		
		case 16:input.minimumSwaps();
		
		case 17:input.sortByElementsByFrequency();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
