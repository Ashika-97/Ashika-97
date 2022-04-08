package Stringsetgeeks2;

import java.util.*;

public class StringSet2Logic {
        
	public boolean testPangram(String S)
	{
		Set<Character> set=new HashSet<>();
		S=S.toLowerCase();
	    char[] ch=S.toCharArray();
	    for(char ch1:ch)
	    {
	    	if(ch1!=' ')
	    	  {
	    		set.add(ch1);
	    	  }
	    }
	    if(set.size()>=26)
	    	return true;
	    else
	    	return false;
	}
   public String removeChars(String string1, String string2)
   {
	   int num=string1.length();
	   int num1=string2.length();
	   string1=string1.toLowerCase();
	   string2=string2.toLowerCase();
	   String name="";
	   String name1="";
	   if(num > num1)
	   {
		   for(int i=0;i<num;i++)
		   {
		    name=""+string1.charAt(i);
			   if(!string2.contains(name))
			   {
				   name1+=string1.charAt(i);
			   }
	       }
       }
	   else {
		   System.out.println("Enter the first string length more than second");
	   }
	return name1;
	
  }
   
   public int romanToInt(String s) 
   {
	 Map<Character,Integer> map=new HashMap<>();
	 map.put('I',1);
	 map.put('V',5);
	 map.put('X',10);
	 map.put('L',50);
	 map.put('C',100);
	 map.put('D',500);
	 map.put('M',1000);
   
	 int res=0;
	 char ch1='0';
	 for(char ch:s.toCharArray())
	 {
           res+=map.get(ch);
           if(ch1!='0' && map.get(ch)> map.get(ch1))
        	   {
        	   res -= 2*map.get(ch1);
        	   }
   
       ch1=ch;
   
	 }
	 return res;
   }
   
   
   public String firstLetter(String name)
   {
	   String inp="";
	   for(String s:name.split(" "))
	   {
		   inp+=s.charAt(0);
	   }
	   return inp;
   }
   
   public static boolean areIsomorphic(String str1,String str2)
   {
	   HashMap<Character,Integer> map1=new HashMap<>();
	   HashMap<Character,Integer> map2=new HashMap<>();
	   
	   if(str1.length()!=str2.length())
		   return false;
	  
	   for(int i=0;i<str1.length();i++)
	   {
		   if(!map1.containsKey(str1.charAt(i)))
		   {
			   map1.put(str1.charAt(i),i);
		   }
		   if(!map2.containsKey(str2.charAt(i)))
		   {
			   map2.put(str2.charAt(i),i);
		   }
		   int a=map1.get(str1.charAt(i));
		   int b=map2.get(str2.charAt(i));
		   if(a!=b)
		      return false;
	   }
	   return true;
		   
	}
   
   public boolean permutation(String s1,String s2)
   {
	   s1=sort(s1);
	   int i=1,len=s1.length();
	   String d="";
	   while(len < s2.length())
	   {
		   d=sort(s2.substring(i,len+1));
		   if(s1.equals(d))
			   return true;
		   
		   i++;
		   len++;
		  
		   		   
	   }
	   
	   return false;
   }
   public String sort(String s1)
   {
	   char[] ch=s1.toCharArray();
	   Arrays.sort(ch);
	   String res=new String(ch);
	   return res;
   }
   
   public boolean isValid(String s) {
       String[] arr=s.split("\\.");
      
       if( arr.length != 4)
    	   return false;
	   if(s.charAt(s.length()-1)=='.')
	   {
		   return false;
	   }
	   
	   for(int i=0;i<arr.length;i++)
	   {
		   
		   if(arr.length ==0 && arr[i].length() >3)
			   return false;
		   
		   int num=Integer.parseInt(arr[i]);
		   
		   if(num < 0 && num >255)
			   return false;
		   if(num==0 &&  arr[i].length() >1)
			   return false;
		   if(num > 0 && arr[i].charAt(0)=='0' )
			   return false;
	   }
	   return true;
	   }
   
   public String modify(String s)
   {
       Set<Character> set=new HashSet<Character>();
       set.add('a');
       set.add('e');
       set.add('i');
       set.add('o');
       set.add('u');
       char[] ch=s.toCharArray();
       Stack<Character> stack=new Stack<>();
       for(char c:ch)
       {
    	   if(set.contains(c))
    	   {
    		 stack.push(c);  
    	   }
       }
	   for(int i=0;i< s.length();i++)
	   {
		   if(set.contains(ch[i]))
	   		   {
			  ch[i]= stack.pop();
	   		   }
	   }
   
   String val=String.valueOf(ch);
   
   return val;
   }
   
   public boolean isBrackets(String s)
    {
	   if(s.length()%2 !=0)
		   return false;
	   
	   Stack<Character> stack=new Stack<>();
	  
	   for(char c:s.toCharArray())
	   switch(c)
	   {
	   case '(' :
		    stack.push(c);
		    
	   case ')' :
		   if(stack.isEmpty()!=true && stack.peek()==')')
		    {
		    	stack.pop();
		    }
		   else {
				stack.push(c);
			   }
	
	   case '{' :
		    stack.push(c);
		    
	   case '}' :
		   if(stack.isEmpty()!=true && stack.peek()=='}')
		    {
		    	stack.pop();
		    }
		   else {
				stack.push(c);
			   }
		    
	   case '[' :
		    stack.push(c);
		    
	   case ']' :
		   if(stack.isEmpty()!=true && stack.peek()==']')
		    {
		    	stack.pop();
		    }
		   else {
			stack.push(c);
		   }
	  default:
		  break;
	   }
	   return stack.isEmpty();
	
    }
   
   
   public static boolean isRotated(String s1,String s2)
   {
	   if(s1.length()==s2.length())
		   {
		   return true;
		   }
	   if(s1.length()!=s2.length())
	   {
		   return false;
	   }
	   
	   s2+=s2;
	   int result=s2.indexOf(s1);
	   System.out.println("the result is "+ result);
	   if(result==2 || result == s1.length()-2)
	   {
		   return true;
	   }
	   
	   
	   return false;
		   
   }
   
   public String encryptString(String S)
   {
	StringBuilder sb=new StringBuilder();  
	int count=1;
	   if(S.length()==1)
		   return S;
	   
	   for(int i=0;i<S.length();i++)
	   {
		   if((i-1)>=0 && S.charAt(i)==S.charAt(i-1))
			   count++;
		   else {
			   sb.append(Integer.toHexString(count)).append(S.charAt(i));
			   count=1;
		   }
	   }
	   return sb.toString();
  }
   
   
   public int minimumDeletion(String S)
   {
	  int n = S.length();
	  StringBuilder sb=new StringBuilder(S).reverse();
	  String str=sb.toString();
	  int arr[][]=new int[n+1][n+1];
	  for(int i=0;i<=n;i++)
	  {
		  for(int j=0;j<=n;j++)
		  {
			  if(i==0 || j==0) {
				   arr[i][j]=0;
			  }
			  
			  else if(S.charAt(i-1)==str.charAt(j-1))
			  {
				  arr[i][j]=1+arr[i-1][j-1];
			  }
			  else {
				  arr[i][j]=Math.max(arr[i][j-1],arr[i-1][j]);
			  }
		  }
	  }
	  return n-arr[n][n];
	    
 
 }
  public int countMin(String str)
   {
     int n=str.length();
     StringBuilder sb=new StringBuilder(str);
     String s=sb.toString();
     String rev=sb.reverse().toString();
     return n-logic(s,rev,n,n);
   }
  public int logic(String a,String b,int t,int l)
  {
	  int[][] log=new int[t+1][l+1];
	  for(int i=1;i<=t;i++)
	  {
		  for(int j=1;j<=l;j++)
		  {
			  if(a.charAt(i-1)==b.charAt(j-1))
			  {
				  log[i][j]=log[i-1][j-1]+1;
			  }
			  else {
				  log[i][j]=Math.max(log[i-1][j],log[i][j-1]);
			  }
		  }
	  }
	  return log[t][l];
  }
  
  
  
  public String countAndSay(int n)
  {
	    if(n == 1){
	        return "1";
	    }
	    
	    String temp =  countAndSay(n-1);
	    
	    String ans ="";
	    int i=0;
	    while(temp.length() != i) {
	        
	        int count = 1;
	        
	        while(i+1<temp.length() && temp.charAt(i) == temp.charAt(i+1)){
	            count++;
	            i++;
	        }
	        ans+=Integer.toString(count)+temp.charAt(i);
	        i++;
	    }
	    return ans;
	    
	}
  
  
}
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
	   
   
   
   
   
   
   
   
   