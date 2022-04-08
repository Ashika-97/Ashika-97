package Arrays;

import java.util.*;


public class SortingOfelementsByFrequency {
	   static Scanner scan=new Scanner(System.in);
	   static int n=scan.nextInt();
	   static int[] arr1=new int[n];
	   static int[] arr=forLoop(arr1);
	   
	   
	   
	   
	      public  static  int[] forLoop(int[] arr) {
		   for(int i=0;i<arr.length;i++)
		   {
			   arr[i]=scan.nextInt();
		   }
		   return arr;
		   }
	
	
	
	
	 public static void main(String[] args)
	    {
	        List<Integer> list =new ArrayList<>();
	        try {
				for(int l:arr)
				{
					list.add(l);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        sortBasedOnFrequencyAndValue(list);
	    }
	   
	    // Compare Function
	    public static void sortBasedOnFrequencyAndValue(List<Integer> list)
	    {
	        int n = arr.length;
	        final HashMap<Integer, Integer> mapCount= new HashMap<Integer, Integer>();
	        final HashMap<Integer, Integer> mapIndex= new HashMap<Integer, Integer>();
	        for (int i = 0; i < n; i++) {
	            if (mapCount.containsKey(arr[i])) {
	                mapCount.put(arr[i],mapCount.get(arr[i]) + 1);
	            }
	            else {
	                mapCount.put(arr[i],1); // Map to capture Count of elements
	                mapIndex.put(arr[i],i); // Map to capture 1st occurrence of elements
	            }
	        }
	 
	     Collections.sort(list, new Comparator<Integer>() {
	            public int compare(Integer n1, Integer n2)
	            {
	                int freq1 = mapCount.get(n1);
	                int freq2 = mapCount.get(n2);
	                if (freq1 != freq2) {
	                    return freq2 - freq1;
	                }
	                else {
	                    return mapIndex.get(n1)- mapIndex.get(n2); // Elements with Lesser
	                                 // Index gets Higher
	                                 // Priority
	                }
	            }
	        });
	        System.out.println(list);
	    }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/* public static HashMap<Integer, Integer> SortByValue(HashMap<Integer, Integer> hm){
	       
			
		 List<Map.Entry<Integer, Integer>> lst = new LinkedList<Map.Entry<Integer, Integer>>(hm.entrySet());
       Collections.sort(lst,new Comparator<Map.Entry<Integer, Integer>>(){
           public int compare(Map.Entry<Integer, Integer> m1, Map.Entry<Integer, Integer> m2){
               if(m1.getValue() == m2.getValue())
                   return m1.getKey()-m2.getKey();
               else
                   return m2.getValue()-m1.getValue();
           }
       });
       HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
       for (Map.Entry<Integer, Integer> aa : lst) {
           temp.put(aa.getKey(), aa.getValue());
       }
       return temp;
       
   }
public static void main (String[] args) 
{
 Scanner sc = new Scanner(System.in);
 int t = sc.nextInt();
 while(t-- > 0)
 {
     int n = sc.nextInt();
     int arr[] = new int[n];
     for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
        if(hm.containsKey(arr[i]))
        {
          int temp = hm.get(arr[i]);
          hm.put(arr[i],temp+1);
        }
           else
            hm.put(arr[i],1);
     }
     Map<Integer, Integer> mp = SortByValue(hm);
     for(Map.Entry<Integer, Integer> entry: mp.entrySet())
     {
         int j = entry.getValue();
         while(j-- > 0)
             System.out.print(entry.getKey() + " " );
     }
     System.out.println();
 }
}

}
*/