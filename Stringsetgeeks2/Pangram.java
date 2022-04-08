package Stringsetgeeks2;

import java.util.HashSet;
import java.util.Set;

public class Pangram {
   public static void main(String[] args)
   {
	   String s="the quick brown fox jumps over the lazy dog";
	   Set<Character> set=new HashSet<>();
	   for(int i=0;i<s.length();i++)
	   {  if(s.charAt(i)!=' ') {
		   set.add(s.charAt(i));
	   }
	   }
	   if(set.size() >=26)
	   {
		   System.out.println("the size is "+ true);
		   System.out.println("the set is "+ set.size());
	   }
	   else {
		   System.out.println("the size not conatins "+ false);
	   }
   }
	
	
	
}
