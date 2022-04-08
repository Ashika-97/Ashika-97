package geeks;

public class Totaldecoding {
	public static void main(String[] args) {
 /*      String s="123";
		int n = s.length();
		char str[] = s.toCharArray();
		
		long mod = 1000000007;
		
		long dp[] = new long [n+1];
		
		dp[0] = dp[1] = 1;
		
		for(int i = 1; i < n; i++){
			if(str[i] == '0' && str[i-1] > '2')
				System.out.println(0);
		}
		
		for(int i = 2; i <= n; i++){
			if(str[i-1] > '0')
				dp[i] = dp[i-1];
		
			if(str[i-2] == '1' || (str[i-2] == '2' && str[i-1] < '7'))
				dp[i] +=dp[i-2];
		
			dp[i] %= mod;
		}
		
		System.out.println((int)dp[n]);
   }
}  */    
       String str="123";
       if(str.charAt(0) == '0')
    	   {
    	   System.out.println(0);
    	   }
      
       int[] dp = new int[str.length()];
       dp[0] = 1;
       for(int i = 1; i < str.length(); i++) 
       {
           if(str.charAt(i) == '0' && str.charAt(i - 1) == '0') 
           {
               dp[i] = 0;
           } 
           
           else if (str.charAt(i) == '0' && str.charAt(i - 1) != '0') 
           {
               if(str.charAt(i - 1) == '1' || str.charAt(i - 1) == '2')
               { 
            	   dp[i] = i >= 2 ? dp[i - 2] % 1000000007: 1;
               
               }
            }
             else if (str.charAt(i) != '0' && str.charAt(i - 1) == '0') 
             {
               dp[i] = dp[i - 1] % 1000000007;
           }  
             else
             {
               if(Integer.parseInt(str.substring(i - 1, i + 1)) <= 26) {
                   dp[i] = i >= 2 ? dp[i - 2] % 1000000007 : 1;
               }
               dp[i] = (dp[i] % 1000000007 + dp[i - 1] % 1000000007);
           }
       }
 
      System.out.println(dp[str.length() - 1] % 1000000007);
}
}
 
