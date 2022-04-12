package sorted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SortingLogics
   {

	public int[] selectionSorting(int[] arr)
	{
		int pos=0;
		for(int i=0;i<arr.length-1;i++)
		{
			pos=i;
			for(int j=i+1;j<arr.length;j++)
			{
				
				if(arr[i]>arr[j])
				{
					pos=j;
				}
			}
					int temp=arr[pos];
					arr[pos]=arr[i];
					arr[i]=temp;
				
		}
		return arr;
	}
	
	public int[] bubbleSort(int[] arr)
	{
		int n=arr.length;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<n-i-1;j++)
			{
				if(arr[j]>arr[j+1])
				{
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		return arr;
	}
	
	public int[] insertionSort(int[] arr)
	{
		int n=arr.length,j;
		for(int i=1;i<n;i++)
		{
		  j=i;
		  while(j>0 && arr[j-1] > arr[j])
		  {
			  int temp=arr[j];
			  arr[j]=arr[j-1];
			  arr[j-1]=temp;
			  j--;
		  }
		}
		return arr;
	}
	
	
	public int kthSmallest(int[] arr, int k)
	{
		int j,n=arr.length;
		for(int i=0;i<arr.length;i++)
		{
			j=0;
			while(j>n-i-1)
			{
				if(arr[j]>arr[j+1])
				{
				int temp=arr[j];
				arr[j]=arr[j+1];
				arr[j+1]=temp;
			}
				j++;
		}
		}
		return arr[k-1];
	}
	
	
	public  boolean anagrams(String a,String b)
	{
		 
        char[] ch=a.toCharArray();
        char[] ch1=b.toCharArray();
        Arrays.sort(ch);
        Arrays.sort(ch1);
        int x=a.length();
        int y=b.length();
        
        if(x!=y)
          return false;
           
           String val=String.valueOf(ch);
           String res=String.valueOf(ch1);
           
           
        if(!val.equals(res))
        	return false;
        
        
     return true;
	}
	
    public  boolean check(long A[],long B[],int N)
    {
    	if(A.length !=B.length)
    	    return false;
    	
    	int count=0;
        //Your code here
    	long[] a=sort(A);
    	long[] b=sort(B);
    	
    	System.out.println(Arrays.toString(a));
    	System.out.println(Arrays.toString(b));
    	for(int i=0;i<A.length;i++)
    	{
    		if(a[i]==b[i])
    			count++;
    	}
        
    	if(count==A.length)
    		return true;
    	
        return false;
    }
    
    
    
    
    public static long[] sort(long[] arr)
    {
      
    	int n=arr.length,j;
		for(int i=1;i<n;i++)
		{
		  j=i;
		  while(j>0 && arr[j-1] > arr[j])
		  {
			  long temp=arr[j];
			  arr[j]=arr[j-1];
			  arr[j-1]=temp;
			  j--;
		  }
		}
		//System.out.println(Arrays.toString(arr));
		return arr;
	} 
      
    public void sortAbs(int arr[],int n,int k)
    {
		 TreeMap<Integer, ArrayList<Integer>> m=new TreeMap<>();
		
		for (int i = 0; i < n; i++)
		{
		int diff = Math.abs(k - arr[i]);
		if (m.containsKey(diff))
		{
		ArrayList<Integer> al = m.get(diff);
		al.add(arr[i]);
		m.put(diff, al);
		}
		else
		{
		    ArrayList<Integer> al = new
		                   ArrayList<>();
		    al.add(arr[i]);
		    m.put(diff,al);
		}
		}
		
		int index = 0;
		for (Map.Entry entry : m.entrySet())
		{
		ArrayList<Integer> al = m.get(entry.getKey());
		for (int i = 0; i < al.size(); i++)
		    arr[index++] = al.get(i);
		}
 
		
		
	
		for (int i = 0; i < n; i++)
		    System.out.print(arr[i] + " ");
		
    }
		
    boolean arraySortedOrNot(int[] arr, int n) {
             
        for(int i=0;i<n-1;i++)
        {
            if(arr[i] > arr[i+1])
               return false;
        }
        
       
        
        return true;
    }

    public int sumOfInteger(int[] arr,int n)
    {
    	
    	Arrays.sort(arr);
    	int start=0,end=n-1;
    	int ans=arr[0]+arr[n-1];
    	System.out.println(Arrays.toString(arr));
    	while(start < end)
    	{
    		int sum=arr[start]+arr[end];
    		
    		if(sum == 0)
    			{
    			return 0;
    			}
    		
    		if(sum < 0)
    		{
    			start++;
    		}
    		else {
    			end--;
    		}
    		if(Math.abs(sum) < Math.abs(ans))
    			{
    			ans=sum;
    			}
    		
    		if(Math.abs(sum) == Math.abs(ans))
    			{
    			ans=Math.max(ans, sum);
    			}
    	}
    	return ans;
    }
    
    public int toyCount(int N, int k, int arr[])
    {
        // code here
        Arrays.sort(arr);
        int sum=0;
        int count=0;
        for(int i=0;i<N;i++)
        {
            if(arr[i] <=k )
            {
            k=k-arr[i];
            sum+=arr[i];
            count++;
            }
        }
        return count;
    }
    
    
    public ArrayList<Integer> candyStore(int arr[],int N,int k){
        // code here
        ArrayList<Integer> al=new ArrayList<Integer>();
    
     /*   for(int i=0;i<N;i++)
        {
            int j=i;
            while(j< N-i-1)
            {
                if(arr[j] > arr[j+1])
                {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
                j++;
            }
        }*/
        Arrays.sort(arr);
        int min = 0;
        int max = 0;
        
        for(int i=0; i<N; i++){
            min += arr[i];
            N = N-k;
        }
        
        int ind=0;
        for(int i=arr.length-1; i>=ind; i--){
            max += arr[i];
            ind += k;
        }
        
        al.add(min);
        al.add(max);
        
        return al;
    }

    void bitonicGenerator(long[] arr, int n)
    {
    
       List<Long> list=new ArrayList<Long>();
       List<Long> list1=new ArrayList<Long>();
    
        for(int i=0;i<n;i++)
        {
            if(i % 2 ==0)
                 list.add(arr[i]);
            
        }
        Collections.sort(list);
        for(int i=n-1;i>=0;i--)
        {
        	if(i%2 == 1 )
        		list1.add(arr[i]);
        }
        Collections.sort(list1,Collections.reverseOrder());
        int j=0;
        for(long temp:list)
        	{
        	arr[j]=temp;
        	j++;
        	}
        for(long temp1:list1)
        {
        	arr[j]=temp1;
        	j++;
        }
        System.out.println(Arrays.toString(arr));
        } 

    public int[] mergeSort(int[] arr)
    {
    	int num=arr.length;
    	if(num<=1)
    	{
    		return arr;
    	}
    	
    	int mid=num/2;
    	int[] left=new int[mid];
    	int[] right;
    	if(num%2 == 0)
    	{
    		right=new int[mid];
    	}
    	else
    	{
    		right=new int[mid+1];
    	}
    	
    	for(int i=0;i<mid;i++)
    	{
    		left[i]=arr[i];
    	}
    	for(int j=0;j<right.length;j++)
    	{
    		right[j]=arr[mid+j];
    	}
    	
    	int[] result=new int[num];
    	
    	left=mergeSort(left);
    	right=mergeSort(right);
    	result=merge(left,right);
    	return result;
    }

    public int[] merge(int[] left,int[] right)
    {
    	int[] result=new int[left.length+right.length];
    	
    	int leftPoint=0,rightPoint=0,resultPoint=0;
    	
    	while(leftPoint<left.length || rightPoint<right.length)
    	{
    		if(leftPoint < left.length && rightPoint < right.length)
    		{
    			if(left[leftPoint] < right[rightPoint])
    			{
    				result[resultPoint++]=left[leftPoint++];
    			}
    			else
    			{
    				result[resultPoint++]=right[rightPoint++];
    			}
    		}
    		else if(leftPoint<left.length)
    		{
    			result[resultPoint++]=left[leftPoint++];
    		}
    		else if(rightPoint<right.length)
    		{
    			result[resultPoint++]=right[rightPoint++];
    		}
    	}
    	return result;
    }
    
	
	public int[] quickSort(int[] arr,int low,int high)
	{
    if(low>high)
	{
		return arr;
	}
	
	int mid=low+(high-low)/2;
	
	int pivot=arr[mid];
	int i=low;
	int j=high;
	
	while(i<=j)
	{
		if(arr[i]<pivot)
		{
			i++;
		}
		if(arr[j]>pivot)
		{
			j--;
		}
		
		if(i<=j)
		{
			int temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			i++;
			j--;
		}
	}
	if(low<j)
	{
		quickSort(arr,low,j);
	}
	if(high>i)
	{
		quickSort(arr,i,high);
	}
	return arr;
	}

	  public void twoArraysAlignSpace(int arr1[], int arr2[], int n, int m)
	  {
	       
		    int []ans =new int [n+m];
		      for(int i=0;i<n;i++){
		          ans[i]=arr1[i];
		      }
		      for(int i=n,j=0;i<m+n;i++){
		          ans[i]=arr2[j++];
		      }
		    bubbleSort(ans);
		  
		   //System.out.println("the sorted arrays is "+ Arrays.toString(ans));
		   for(int i=0;i<n;i++){
		       arr1[i]=ans[i];
		   }
		   for(int i=0,j=n;i<m;i++){
		       arr2[i]=ans[j++];
		   }
	       System.out.println(Arrays.toString(arr1));
	       System.out.println(Arrays.toString(arr2));
	  }
   
	 public int minSwaps(int nums[])
	    {
	    int n=nums.length;

	    int a[]=new int[n]; 

		for(int i=0;i<n;i++) 
		{
		 a[i]=nums[i];
		}
		 Arrays.sort(a); 
	
		 HashMap<Integer,Integer> hm=new HashMap<>(); 
	
		for(int i=0;i<n;i++) 
		{
		hm.put(a[i],i);
		}
		 int count=0;
	
		 for(int i=0;i<n;i++) { 
	
		while(hm.get(nums[i])!=i) {
	
		 count++; 
	
		swap(nums,hm.get(nums[i]),i); 
	
		}
	
		 } 

	return count; 

	    } 

	static void swap(int a[],int i,int j) { 

	int temp=a[i];

	 a[i]=a[j];

	 a[j]=temp;

	 }
   
	
  public ArrayList<Integer> sortByFrequency(int[] arr,int n)
  {
	  Arrays.sort(arr);
      
      ArrayList<Integer> list = new ArrayList<Integer>();
      
      TreeMap<Integer, Integer> map = new TreeMap<>();
      
      for(int i = 0; i < n; i++)
      {
          map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
      }
      
      ArrayList<Entry<Integer, Integer>> list1 = new ArrayList<>(map.entrySet());
      map.clear();
      
      Collections.sort(list1, new Comparator<Map.Entry<Integer,Integer>>(){
          public int compare(Entry<Integer, Integer> a, Entry<Integer, Integer> b)
          {
              int res = b.getValue() - a.getValue();
              
              if(res == 0)
            	  return a.getKey() - b.getKey();
              
              return res;
          }
          
          });
      
      for(Map.Entry<Integer, Integer> e : list1)
      {
          int i = e.getValue();
          while(i > 0)
          {
              list.add(e.getKey());
              i--;
          }
      }
      return list;
          
  }

    
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   }
	
	


