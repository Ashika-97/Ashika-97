package Arrays;

import java.util.*;;

public class ArraysLogic {

   public int[] greaterArray(int[] num)
   {
	  int[] result=new int[num.length];
	  
	  for(int i=0;i<result.length;i++)
	  {
		  int count=0;
		  for(int j=0;j<result.length;j++)
		  {
			  if(j != i && num[j] < num[i])
			  {
				  count++;
				  result[i]=count;
			  }
		  }
	  }
	  return result;	
	}

  public int[] swapArray(int[] arr,int n)
  {
	for(int i=0;i < n-1;i+=2)
	{
		int num=arr[i];
		arr[i]=arr[i+1];
		arr[i+1]=num;
		
	}
	
	return arr;
	
  }	
 public ArrayList<Long> alternateSort(long arr[] ,int N)
  {
	 Arrays.sort(arr);
	 ArrayList<Long> list=new ArrayList<>();
	 int l=0;
	 int r=N-1;
	 while(l<=r)
	 {
		list.add(arr[r]);
		list.add(arr[l]);
		l++;
		r--;
	 }
	 return list;	 
  }

 public int majorityElement(int a[], int size)
 {
    if(size == 0)
    {
    	return a[0];
    }
	 Arrays.sort(a);
	 int n=size/2;
	 int count=0;
	 
	 for(int i=0;i< size-1;i++)
	 {
		 if(a[i] == a[i+1])
		 {
			 count++;
			 if(count >= n)
			 {
				 return a[i];
			 }
		 }
		 else {
			 count=0;
		 }
	 }
	 return -1;
 }

 public int[] shuffle(int[] nums, int n) {
      
     int[] ans = new int[nums.length];
     int k = 0;
     int l = 0;

     while(l<= n && k < nums.length){
         ans[k++] = nums[l++];
         ans[k++] = nums[n++];
     }
     return ans;
 
     
 }
 
 public long balancedArray(long[] arr,int n)
 {
	 long val=0;
	 long val1=0;
	 int size=n/2;
	 
	 for(int i=0;i<size;i++)
	 {
		 val+=arr[i];
	 }
	 for(int j=size;j<n;j++)
	 {
		 val1+=arr[j];
	 }
	 long ans=val-val1;
	 return Math.abs(ans); 
 }

 public int minimum_difference(int[] nums)
 {
     
     Arrays.sort(nums);
     int min = Integer.MAX_VALUE;
     for(int i = 0; i < nums.length-1;i++) {
     int firstValue = nums[i];
     int secondValue = nums[i+1];
     min = Math.min(min, Math.abs(secondValue-firstValue));
     
     }

return min;
     
 }

 public int Majority(int[] num,int size)
 {
	 if(num.length == 0 )
		  return num.length;
	 Arrays.sort(num);
	 int count=0;
	 int n=size/2;
	 for(int i=0;i< size;i++)
	 {
		 if(num[i]==num[i+1])
			 count++;
		 
		 if(count >= n)
		 {
			 return count;
		 }
	 }
	 return -1;
	 
 }
 public long kadeanesAlgorithm(int[] num,int n)
 {
	 if(num.length == 0 )
		  return num.length;
	 
	 
	 long max=num[0];
	 long res=num[0];
	 for(int i=1;i< n;i++)
	 {
		 max=Math.max(max+num[i],num[i]);
		 res=Math.max(res,max);
	 }
	 
	 return res;
	 
	 
 }

 public int goodPair(int[] num)
 {
	 int count=0;
	 
	 for(int i=0;i<num.length;i++)
	 {
		 for(int j=i+1;j<num.length;j++)
		 {
			 if( i != j && num[i] == num[j])
				 count++;
		 }
	 }
	 return count;
	 
 }

 int minDist(int a[], int n, int x, int y) {
 {
	 int val=-1;
	 int res=-1;
	 int count=Integer.MAX_VALUE;
	 for(int i=0;i< n;i++)
	 {
		 if(a[i] == x)
			 val=a[i];
		 
		 if(a[i] == y)
			 res=a[i];
		 
		 if(val != -1 && res !=-1)
		 {
			 int number=Math.abs(res-val);
			 count=Math.min(count, number);
		 }
		 
		 if(res == -1 || val==-1)
			 return -1;
	 }
	 return count;
 }
	 
	 
 }
 
 
  public ArrayList<Integer> leaders(int arr[], int n)
  {
    ArrayList<Integer> list=new ArrayList<>();
    int current=arr[n-1];
    list.add(current);
    
    for(int i=n-2;i>=0;i--)
    {
    	if(arr[i] >= current)
    	{
    		current=arr[i];
    		list.add(current);
    	}
    	
    }
    Collections.reverse(list);
    
    return list;
  }
 
  public void postiveNegative(int arr[], int n) {
      
   int pos=0;
   
   
   ArrayList<Integer> list=new ArrayList<>();
   ArrayList<Integer> list1=new ArrayList<>();
 
   for(int i=0;i<n;i++)
   {
	   if(arr[i] > 0)
		   list.add(arr[i]);
	   
	   else {
		   list1.add(arr[i]);
	   }
	   
   }
   for(int j=0;j < list.size() || j<list1.size() ;j++)
   {
	   if(j < list.size())
	   {
     	   arr[pos++]=list.get(j);
        }
	   if(j<list1.size())
	   {
		   arr[pos++]=list1.get(j);
	   }
   }
   System.out.println(Arrays.toString(arr));
  } 
 
  public boolean findsum(int arr[],int n)
  {
	  Set<Integer> set=new HashSet<>();
	  int sum=0;
	  for(int i=0;i<arr.length;i++)
	  {
		  sum+=arr[i];
		  if(set.contains(sum))
			  return true;
		  
		  set.add(sum);
	  }
	  return false;	  
  }
 
  public int firstNonRepeating(int arr[], int n) 
  { 
	 HashMap<Integer,Integer> map=new HashMap<>(); 
	 
	 for(int i=0;i<arr.length;i++)
	 {
		 if(map.containsKey(arr[i]))
		 {
			 map.put(arr[i],map.get(i)+1);
		 }
		 else {
			 map.put(arr[i],1);
		 }
	 }
	 
	 for(int i=0;i<n;i++)
	 {
		 if(map.get(i)==1)
			 return arr[i];
	 }
	 return 0;
	  
  }
 
  int minSortedElement(int arr[], int n)
  {
      
      Arrays.sort(arr);
     return arr[0];
  }
 
  public static int kthSmallest(int[] arr, int k) 
  { 
   
      Arrays.sort(arr);
      int num=arr[k-1];
      return num;
  } 

  public int getPairsCount(int[] arr, int n, int k)
  {
    HashMap<Integer,Integer> map=new HashMap<>();
    int res=0;
    for(int i=0;i<n;i++)
    {
    	int num=k-arr[i];
    	if(map.containsKey(num))
    		res+=map.get(num);
    
         if(map.containsKey(arr[i]))
         {
        	 map.put(arr[i], map.get(arr[i])+1);
         }
         else
        	 map.put(arr[i],1);
    
    
    }
    return res;
  }






























}
