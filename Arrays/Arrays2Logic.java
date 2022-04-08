package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Arrays2Logic {

	public long findMinDiff(ArrayList<Long> a, long n, long m) {

		Collections.sort(a);
		long ans = Integer.MAX_VALUE;
		for (int i = 0; i <= (int) n - m; i++) {
			long minw = a.get(i);
			long maxw = a.get(i + (int) m - 1);
			long b = maxw - minw;
			if (b < ans)
				ans = b;
		}
		return ans;
	}

	public long count(int S[], int m, int n) {
		long dp[] = new long[n + 1];
		dp[0] = 1;

		for (int i = 0; i < S.length; i++) {
			for (int j = S[i]; j < dp.length; j++) {
				dp[j] += dp[j - S[i]];
			}

		}
		return dp[n];

	}

	public int[] sumClosest(int[] arr, int x) {
		int l = 0;
		int r = arr.length - 1;
		int diff = Integer.MAX_VALUE;
		int a[] = new int[2];
		while (l < r) {
			if (Math.abs(arr[l] + arr[r] - x) < diff) {
				a[0] = arr[l];
				a[1] = arr[r];
				diff = Math.abs(arr[l] + arr[r] - x);

			}
			if ((arr[l] + arr[r] > x)) {
				r--;
			}

			else {
				l++;
			}

		}
		return a;
	}

	public void rotate(int[] arr, int n) {
		int var1 = arr[n - 1];
		for (int i = n - 1; i > 0; i--) {
			arr[i] = arr[i - 1];
		}
		arr[0] = var1;
		System.out.println(Arrays.toString(arr));
		/*
		 * ArrayList<Integer> list=new ArrayList<>(); list.add(arr[n-1]);
		 * 
		 * int i=0; while( i< n-1) { list.add(arr[i]); i++;
		 * 
		 * } System.out.println(list);
		 */

	}

	public ArrayList<String> mismatchedArray(String[] arr1, String[] arr2) {

		ArrayList<String> list = new ArrayList<String>();
		String out = "";
		if (arr1.length != arr2.length) {
			System.out.println("length mismatched");
		}
		for (int i = 0; i < arr1.length; i++) {
			if (!arr1[i].equals(arr2[i]) && i < arr1.length - 1 && (!arr1[i + 1].equals(arr2[i + 1]))) {
				out += arr1[i] + "" + arr2[i];
				list.add(out);
				out = "";
				out += arr1[i + 1] + "" + arr2[i + 1];
				list.add(out);
				i++;
			} else {
				if (!arr1[i].equals(arr2[i])) {
					out += "" + arr1[i];
					list.add(out);
					out = "";
					out += "" + arr2[i];
					list.add(out);
				}
			}
			out = "";
		}
		return list;

	}

	public ArrayList<Integer> unionArray(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {

		Set<Integer> set = new HashSet<>();
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr1.size(); i++) {
			set.add(arr1.get(i));

		}
		for (int i = 0; i < arr2.size(); i++) {
			set.add(arr2.get(i));

		}

		for (int k : set) {
			list.add(k);
		}

		return list;
	}

	public void exceptArray(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr1.size(); i++) {
			int num = arr1.get(i);
			if (num % 2 == 0) {
				list.add(arr1.get(i));
			}
		}
		for (int i = 0; i < arr2.size(); i++) {
			int num1 = arr2.get(i);
			if (num1 % 2 != 0) {
				list.add(arr2.get(i));
			}
		}
		System.out.println("the list is " + list);

	}

	public void intersectArray(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> list1 = new ArrayList<>();
		for (int i = 0; i < arr2.size(); i++) {
			list.add(arr2.get(i));
		}
		for (int j = 0; j < arr1.size(); j++) {
			if (list.contains(arr1.get(j))) {
				list1.add(arr1.get(j));
			}
		}
		System.out.println(list1);

	}

	/*
	 * public void arrayChangeCount(int[] arr) {
	 * 
	 * 
	 * int count=0;
	 * 
	 * for(int i=0;i<arr.length;i++) {
	 * 
	 * for(int j=i+1;j<arr.length;j++) { if(arr[i]==arr[j]) { count++; }
	 * 
	 * 
	 * } if(count>1) { System.out.println("the arr is "+ arr[i] +"-"+ count); } }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 */

	public boolean findPair(int arr[], int size, int n) {
		Arrays.sort(arr);
		int i = 0, j = 1;
		while (i < size - 1 && j < size) {
			if (i != j) {
				if (arr[j] - arr[i] == n) {
					System.out.println("(" + arr[i] + "," + arr[j] + ")");
					return true;
				}

				else if (arr[j] - arr[i] < n)
					j++;

				else
					i++;
			} else {
				j++;
			}
		}
		return false;
	}

	public void rotataeSame(int[] arr, int n) {
		for (int i = 0; i < n; i++) {
			int temp = arr[n - 1];
			for (int j = n - 1; j > 0; j--) {
				arr[j] = arr[j - 1];
			}
			arr[0] = temp;
		}
		System.out.println(Arrays.toString(arr));
	}

	public void leftRotation(int[] arr, int n) {
		int len = arr.length;
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = n; i < len; i++) {
			list.add(arr[i]);
		}
		for (int i = 0; i < n; i++) {
			list.add(arr[i]);
		}
		System.out.println(list);

	}

	public long tripleMultiply(ArrayList<Integer> list, int num) {
		if (num < 3)
			return -1;

		int[] arr = new int[num];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}

		int max_product = Integer.MIN_VALUE;

		for (int i = 0; i < num - 2; i++) {
			for (int j = i + 1; j < num - 1; j++) {
				for (int k = j + 1; k < num; k++) {
					max_product = Math.max(max_product, arr[i] * arr[j] * arr[k]);
				}
			}
		}

		return max_product;
	}

	public int longSub(int arr[], int n) {
		int max_ref = 0;
		if (n == 1)
			return 1;

		int res, max_ending_here = 1;

		for (int i = 1; i < n; i++) {
			res = longSub(arr, i);
			if (arr[i - 1] < arr[n - 1] && res + 1 > max_ending_here)
				max_ending_here = res + 1;
		}

		if (max_ref < max_ending_here)
			max_ref = max_ending_here;

		return max_ending_here;
	}

	public boolean checkPossibility(int[] nums) {
		int modified = 0, prev = nums[0], index = 0;
		for (index = 0; index < nums.length; ++index) {
			if (nums[index] < prev) {
				if (++modified > 1)
					return false;
				if (index - 2 >= 0 && nums[index - 2] > nums[index])
					continue;
			}
			prev = nums[index];
		}
		return true;

	}

	public int[][] overlappingIntervels(int[][] intervals) {
		if (intervals.length == 1) {
			return intervals;
		}

		Arrays.sort(intervals, (int1, int2) -> Integer.compare(int1[0], int2[0]));

		List<int[]> output = new ArrayList<>();

		int size = intervals.length;
		int i = 0;
		for (; i < size;) {
			int startI = intervals[i][0];
			int endI = intervals[i][1];
			while (i < size && intervals[i][0] <= endI) {

				endI = Math.max(intervals[i][1], endI);
				++i;
			}

			output.add(new int[] { startI, endI });
		}

		return output.toArray(new int[output.size()][]);
	}

	public void numOfDuplicate(int[] arr) {
		Arrays.sort(arr);
		int count = 1;
		for (int i = 0; i < arr.length; i++) {
			while (i < arr.length - 1 && arr[i] == arr[i + 1]) {
				count++;
				i++;
			}

			System.out.println("(" + arr[i] + "," + count + ")");

			count = 1;
		}
	}



	public boolean canPartition(int[] arr) {
		int sum = 0;

		for (int i : arr)
			sum += i;

		if (sum % 2 != 0)
			return false;

		boolean[][] dp = new boolean[arr.length + 1][(sum / 2) + 1];

		for (int i = 0; i < dp.length; i++)
			dp[i][0] = true;

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (dp[i - 1][j])
					dp[i][j] = true;
				else {
					if (arr[i - 1] <= j)
						dp[i][j] = dp[i - 1][j - arr[i - 1]];
				}
			}
		}

		return dp[dp.length - 1][dp[0].length - 1];
	}

	public int perfectDigits(int num) {

		int count = 0;
        for (int curr = 1;; curr++) {
  
            // Find sum of digits in current no.
            int sum = 0;
            for (int x = curr; x > 0; x = x / 10)
                sum = sum + x % 10;
  
            // If sum is 10, we increment count
            if (sum == 10)
                count++;
  
            // If count becomes n, we return current
            // number.
            if (count == num)
                return curr;
        }

	}

	//

	public void display() {
		int n = 5;
		for (int i = 1; i <= n; i++) {
			int k = i;

			for (int j = 1; j <= i; j++) {
				System.out.print(k + " ");

				k = k + n - j;
			}
			System.out.println();
		}
	}

	
	public void minimumPairDiffrerence(int[] arr)
	{
		
		int diff=Integer.MAX_VALUE ;
		int val=0;
		int val1=0;
		int sum=0;
		
		int[] a=new int[2];
	    for(int i=0;i< arr.length-1;i++)
	     {
	    	for(int j=i+1;j<arr.length;j++)
	    	{
			  sum=Math.abs(arr[i]-arr[j]);
			  
	    	
	    if(sum < diff)
	    {
	    	  diff=Math.min(arr[i]-arr[i+1],diff);
	    	  val=arr[i];
			  val1=arr[j];
	    }
	    	}
	     }
	    a[0]=val;
	    a[1]=val1;
	    
		System.out.println(Arrays.toString(a));	
	}
	public int sumOf(int a)
	{
		int count=0;
		
		while(a>0)
		{
			int value=a%10;
			count=count+value;
			a=a/10;
		}
		return count;
	}
	
	public int[] sumOfDigits(int[] arr) 
	{
	  int sum=0;
	  int sum1=0;
	  for(int i=0;i<arr.length-1;i++)
	  {
		  for(int j=i+1;j<arr.length;j++)
		  {
			  sum=sumOf(arr[i]);
			  sum1=sumOf(arr[j]);
			  
			  if(sum > sum1 || ((sum==sum1) && arr[i]>arr[j]))
			  {
				  int var=arr[i];
				  arr[i]=arr[j];
				  arr[j]=var;
			  }			  
		  }
	  }
	  return arr;
	}



public List<String> getKeyfromVal(Map<String, String> map, String value) {
	List<String> returnKey = new ArrayList<String>();
	for (String key : map.keySet()) {
		if (value.equals(map.get(key))) {
			returnKey.add(key);
		}
	}
	return returnKey;
}

public void grandChild(Map<String, String> map, String checkname) {
	int count = 0;

	List<String> keySets = getKeyfromVal(map, checkname);

	for (String name : keySets) {
		List<String> answerList = getKeyfromVal(map, name);
		count += answerList.size();
	}

	System.out.println("the count is " + count);

}












}




