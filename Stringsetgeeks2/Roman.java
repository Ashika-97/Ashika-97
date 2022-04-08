package Stringsetgeeks2;

import java.util.*;

public class Roman {
	
	/*
	 * public String abc(String inp,int len) {
	 */	/*
	 *   ​int​ ​j​ = ​1​; ​ if​ (​len​ == ​inp​.​length​() - ​1​) {
	 * ​                        ​return​ ​"not balanced"​; ​                }
	 * ​                ​char​ ​ch1​ = ​inp​.​charAt​(​len​);
	 * ​                ​int​ ​out​ = ​0​;
	 * ​                ​Map​<​Character​, ​Integer​> ​map​ = ​new​ ​HashMap​<
	 * ​Character​, ​Integer​>();
	 * ​                ​for​ (​char​ ​ch​ = ​'a'​; ​ch​ <= ​'z'​; ++​ch​) {
	 * ​                        ​map​.​put​(​ch​, ​j​);
	 * ​                        ​j​++; ​                }
	 * ​                ​j​ = ​1​; ​                ​int​ ​output​ = ​0​;
	 * ​                ​int​ ​ind​ = ​inp​.​indexOf​(​ch1​);
	 * ​                ​for​ (​int​ ​i​ = ​ind​ + ​1​; ​i​ < ​inp​.​length​(); ​i​+
	 * +) {
	 * ​                        ​output​ += ​j​ * ​map​.​get​(​inp​.​charAt​(​i​));
	 * ​                        ​j​++; ​                }
	 * ​                ​j​ = ​1​;
	 * ​                ​for​ (​int​ ​i​ = ​0​; ​i​ < ​ind​; ​i​++) {
	 * ​                        ​out​ += ​j​ * ​map​.​get​(​inp​.​charAt​(​i​));
	 * ​                        ​j​++; ​                }
	 * ​                ​if​ (​output​ - ​out​ == ​0​) {
	 * ​                        ​return​ ​"balanced at "​ + ​inp​.​charAt​(​len​);
	 * ​                } ​else​ {
	 * ​                        ​return​ ​balancePoint​(​inp​, ​len​ + ​1​);
	 * ​                } }
	 */
	
	

   public static void main(String[] args)
   { 
   
   String str="abcd";
   int n = str.length();
   StringBuilder sb = new StringBuilder(str);
   String t = sb.reverse().toString();
   System.out.println(n - lcs(str,t,n,n));
}

static int lcs(String a ,String b,int m,int n){
   int[][]dp = new int[m+1][n+1];
   
   for(int i=1;i<dp.length;i++)
   {
       for(int j=1;j<dp[0].length;j++)
       {
           if(a.charAt(i-1) == b.charAt(j-1))
           {
               dp[i][j] = dp[i-1][j-1] + 1;
              // System.out.println("the dp is if in it "+dp[i][j]);
           }
           else
           {
               dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
              // System.out.println("the dp else is "+ dp[i][j]);
           }
       }
   }
   System.out.println("the total dp[m][n] is "+ dp[m][n]);
   return dp[m][n];
}

}


