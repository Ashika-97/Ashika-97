package geeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicateArray {

	public static void main(String[] args) { 
	int arr[]= {9,2,3,9,5,2,7,3,7,7};
	int n = 10 ;
	Set<Integer> set=new HashSet<>();
	ArrayList<Integer> list=new ArrayList<>();

	for(int i=0;i < n;i++)
	{
		if(set.contains(arr[i]))
		{
			if(!list.contains(arr[i])) {
			list.add(arr[i]);
			Collections.sort(list);
		}}
		set.add(arr[i]);
	}
   if(!list.isEmpty()) {
	System.out.println("the list is "+ list);
	}
   else {
	     System.out.println("the list else part is "+ -1);
   }
	
}
}
