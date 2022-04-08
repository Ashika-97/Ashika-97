package StringSet3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

public class StringSet3Logic {
	  String string;
	  String st1[] = { "", "one", "two", "three", "four", "five", "six", "seven",
	                   "eight", "nine", };
	  String st2[] = { "hundred", "thousand", "lakh", "crore" };
	  String st3[] = { "ten", "eleven", "twelve", "thirteen", "fourteen",
	                   "fifteen", "sixteen", "seventeen", "eighteen", "ninteen", };
	  String st4[] = { "twenty", "thirty", "fourty", "fifty", "sixty", "seventy",
	                   "eighty", "ninety" };
	
	
	
	
	
	public int prefixSuffix(String s)
	{
		
		  int n=s.length(); 
		  int i=1; for(i=1;i<=n;i++) 
		  {
		  if(s.substring(0,s.length()-i).equals(s.substring(i))) 
		     return s.length()-i;
		  } 
		  return 0;
		 
	
/*	int n=s.length();
	int[] arr=new int[n];
	int i=1;int count=0;
	while(i<n)
	{
		if(s.charAt(i)==s.charAt(count))
		{
			count++;
			arr[i]=count;
			i++;
			
		}
		else {
			if(count==0)
			{
				arr[i]=0;
				i++;
			}
			else {
				count=arr[count-1];
			}
		}
	}
	
	return count;*/
	
	}
	
	public boolean KAnagram(String s1,String s2,int k)
	{
		if(s1.length() != s2.length())
			  return false;
		
		int[] a=new int[26];
		int[] b=new int[26];
		int count=0;
		for(int i=0;i<s1.length();i++)
		{
			a[s1.charAt(i)-'a']++;
		}
		for(int j=0;j<s2.length();j++)
		{
			b[s2.charAt(j)- 'a']++;
		}
		
		for(int i=0;i<s1.length();i++)
		{
			if(a[i]>b[i]) 
			{
			count=Math.abs(a[i]-b[i]);
		    }
		}
		
		if(count<=k)
			return true;
		else
		  return false;	
		
	
	}
	
	public int longestSubstring(String S)
	{
		 
      ArrayList<Character> al = new ArrayList<>();
      int i= 0, j = 0, max = 0;
      while(j < S.length() ){
          if(al.contains(S.charAt(j) ))
          {
              al.remove(0);
              i++;
          }
          else
          {
        	  //System.out.println();
              al.add(S.charAt(j) );
              max = Math.max(max, al.size());
              j++;
          }
      }
      return max;
    }
		
	public String convert(int number) {
	    int n = 1;
	    int word;
	    string = "";
	    while (number != 0) {
	      switch (n) {
	        case 1:
	          word = number % 100;
	          pass(word);
	          if (number > 100 && number % 100 != 0) {
	            show("and ");
	            //System.out.print("ankit");
	          }
	          number /= 100;
	          break;
	        case 2:
	          word = number % 10;
	          if (word != 0) {
	            show(" ");
	            show(st2[0]);
	            show(" ");
	            pass(word);
	          }
	          number /= 10;
	          break;
	        case 3:
	          word = number % 100;
	          if (word != 0) {
	            show(" ");
	            show(st2[1]);
	            show(" ");
	            pass(word);
	          }
	          number /= 100;
	          break;
	        case 4:
	          word = number % 100;
	          if (word != 0) {
	            show(" ");
	            show(st2[2]);
	            show(" ");
	            pass(word);
	          }
	          number /= 100;
	          break;
	        case 5:
	          word = number % 100;
	          if (word != 0) {
	            show(" ");
	            show(st2[3]);
	            show(" ");
	            pass(word);
	          }
	          number /= 100;
	          break;
	        }
	        n++;
	      }
	      return string;
	    }
       
	public void show(String s) {
	    String st;
	    st = string;
	    string = s;
	    string += st;
	  }
	  public void pass(int number) {
	    int word, q;
	    if (number < 10) {
	      show(st1[number]);
	    }
	    if (number > 9 && number < 20) {
	      show(st3[number - 10]);
	    }
	    if (number > 19) {
	      word = number % 10;
	      if (word == 0) {
	        q = number / 10;
	        show(st4[q - 2]);
	      } else {
	        q = number / 10;
	        show(st1[word]);
	        show(" ");
	        show(st4[q - 2]);
	      }
	    }
	   }

	  

	 
	public boolean rotatedString(String s1,String s2)
	{
		
		return ((s1.length()== s2.length())&& ((s1+s1).indexOf(s2) != -1));
		
	}
	
	static boolean isPalindrome(String str)
    {
        int i = 0, j = str.length() - 1;
         
     
        while (i < j)
        {
           
            if (str.charAt(i++) != str.charAt(j--))
            return false;
        }
        
        return true;
    }
     
  
    public String removePalinWords(String str)
    {
     
        String final_str = "", word = "";
         
     
        str = str + " ";
        int n = str.length();
         
    
        for (int i = 0; i < n; i++)
        {
         
      
            if (str.charAt(i) != ' ')
              word = word + str.charAt(i);
         
            else
            {
                if (!(isPalindrome(word)))
                    final_str += word + " ";
             
              
                word = "";
            }
        }
         
    
        return final_str;
    }
	
	public String firstCharacter(String str)
	{
	     HashMap<Character,Integer>  characterhashtable = new LinkedHashMap<Character ,Integer>();
		int length ;
		Character ch;
		length= str.length();  
		for (int i=0;i < length;i++)
		{
		    ch = str.charAt(i);
		    if(characterhashtable.containsKey(ch))
		    {
		      
		        characterhashtable.put(  ch ,  characterhashtable.get(ch) +1 );
		    }
		    else
		    {
		        characterhashtable.put( ch , 1 ) ;
		    }
		}
		for(Entry<Character,Integer> entry: characterhashtable.entrySet())
		{
		    if(entry.getValue() == 1)
		        return entry.getKey()+"";
		}
		   String out="no repeated character";
		    return out;
	}
	
	public  void twoSetOfString(String s1,String s2)
	{
		if(s1.length()!=s2.length())
		{
			System.out.println(false);
		}
		int num=s1.length();
		
		String res="";
	
		ArrayList<String> list=new ArrayList<>();
	
		for(int i=0;i<num;i++)
		{
			if(s1.charAt(i) != s2.charAt(i))
				{
					res+=s1.charAt(i);
					res+=s2.charAt(i);
					list.add(res);
				}	
			res="";
		}
	System.out.println(list);
			
	}
	
	public String sameWordsNonBuilt(String name,String input,String input1)
	{
		int n1=name.length();
		
		
		String variable="";
		String variable2="";
	  
	  for(int i=0;i<n1;i++)
	  {
		  if(name.charAt(i)==' ')
		  {
			  if(input.contains(variable) && input1.contains(variable))
			  {
				  variable2+=variable + " ";
			  }
			  variable="";
		  }
		  else {
			  variable+=name.charAt(i);
		  }
		  
	  }
	  return variable2;
		  
   }
	
public void printCombinations(String S)
{	
	List<String> list = new ArrayList<>();
	  
	permute(S, " ", list);
	System.out.println(list);
}

static void permute(String str, String input, List<String> list) {
	if (str.length() <=2 ) {
		list.add(input);

	}
	for (int i = 0; i < str.length(); i++) 
	{
		char ch = str.charAt(i);
		String text = str.substring(0, i) + str.substring(i + 1);
		permute(text, input + ch, list);

	}
}

	
	
  public String decodedString(String s)
  {
	  if (s.length() == 0) {
          return s;
      }
      
      Stack<String> stack = new Stack<>();
      StringBuilder decodeWords = new StringBuilder();
      
      for (int i = 0; i < s.length(); ++i) {
          if (s.substring(i, i + 1).equals("]"))
           {
              String words = new String();
              String num = new String();
              StringBuilder ans = new StringBuilder();
              while (!stack.isEmpty() && !stack.peek().equals("[")) 
              {
                  words = stack.pop() + words;
              }
              stack.pop();
              while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) 
              
              {
                  num = stack.pop() + num;
              }
              for (int j = 0; j < Integer.parseInt(num); ++j) 
              {
                  ans.append(words);
              }
              stack.push(ans.toString());
          }
          else
          {
              stack.push(s.substring(i, i + 1));
          }
      }
      
      while (!stack.isEmpty()) {
          decodeWords.insert(0, stack.pop());
      }
      
      return decodeWords.toString();
 	  
  }
	
	
	
	
 public void lexicoGraphically(String s,String s1)
 {
	 Map<Character,Character> map=new HashMap<>();
	 map.put('a', 'z');
	 map.put('b', 'y');
	 map.put('c', 'x');
	 map.put('d', 'w');
	 map.put('e', 'v');
	 map.put('f', 'u');
	 map.put('g', 't');
	 map.put('h', 's');
	 map.put('i', 'r');
	 map.put('j', 'q');
	 map.put('k', 'p');
	 map.put('l', 'o');
	 map.put('m', 'n');
	 map.put('n', 'm');
	 map.put('o', 'l');
	 map.put('p', 'k');
	 map.put('q', 'j');
	 map.put('r', 'i');
	 map.put('s', 'h');
	 map.put('t', 'g');
	 map.put('u', 'f');
	 map.put('v', 'e');
	 map.put('w', 'd');
	 map.put('x', 'c');
	 map.put('y', 'b');
	 map.put('z', 'a');
	 
	int count=0;
	if(s1.length() != s.length())
	{
		System.out.println("length not equals");
	}
	for(int i=0;i<s.length();i++)
	{
		char ch=s.charAt(i);
		char ch1=s1.charAt(i);
		if(map.containsKey(ch) || map.containsValue(ch))
		{
		  if(map.get(ch)== ch1 || ch==map.get(ch1))
			  {
			   count++;
		      }
		  else {
			  System.out.println("values are not matched ");
		  }
		  
		}
		else {
			System.out.println("string not presents");
		}	
		
	}
	if(count==s.length())
	{
		System.out.println("String presents");
	}
	 	 
 }
	
	
public String balanceWords(String s)
{
	
	
	Map<Character,Integer> map=new HashMap<>();
	map.put('a', 1);
	map.put('b', 2);
	map.put('c', 3);
	map.put('d', 4);
	map.put('e', 5);
	map.put('f', 6);
	map.put('g', 7);
	map.put('h', 8);
	map.put('i', 9);
	map.put('j',10);
	map.put('k',11);
	map.put('l',12);
	map.put('m',13);
	map.put('n',14);
	map.put('o',15);
	map.put('p',16);
	map.put('q',17);
	map.put('r',18);
	map.put('s',19);
	map.put('t',20);
	map.put('u',21);
	map.put('v',22);
	map.put('w',23);
	map.put('x',24);
	map.put('y',25);
	map.put('z',26);
	
	int n=s.length();
	int num=0;
	int k=1;
	String var="";
	String res="";
	int right=0;
	int left=0;
	for(int i=1;i<n-1;i++)
	{
		char cht=s.charAt(i);
		if(map.get(cht) > map.get(s.charAt(i+1)))
		{
		num=map.get(cht);	
		}
		else {
			num=map.get(s.charAt(i+1));
		}
		//System.out.println(num);
		var=s.substring(i+1);
		res=s.substring(0,i);
		if(res.length()==0 || var.length()==0)
		{
		 String name="empty substring get";
		 return name;
		}
	
		/*
		 * System.out.println("the var is "+ var); System.out.println(var.length());
		 * System.out.println("the res is "+ res);
		 */
		int l=0;
		while(l<var.length())
		{
		
			char ch=var.charAt(l);
			int value=map.get(ch);
		    right+=k*value;
		    
		    k++;
		    l++;
		}
		
		
		k=1;
		for(int m=0;m < res.length();m++)
		{
			
			char ch1=res.charAt(m);
			int value1=map.get(ch1);
			left+=k*value1;
			k++;
			
	    }
		//System.out.println("the left is "+ left);
		if(left == right)
		{
			String input="the words are balanced at "+s.charAt(i);
			return  input;
			
		}
		else {
			break;
			//i++;
		}
	
	
	
	
	
	}
	String output="words are not balanced ";
	return output;	
}
	
	
	
	


	    public List<String> letterCombinations(String D) {
	        int len = D.length();
	        List<String> ans = new ArrayList<>();
	        if (len == 0)
	        	return ans;
	        bfs(0, len, new StringBuilder(), ans, D);
	        return ans;
	    }

	    public void bfs(int pos, int len, StringBuilder sb, List<String> ans, String D) {
	    	
	    	final char[][] L = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},
	    		    {'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
	        if (pos == len) 
	        	ans.add(sb.toString());
	        else {
	            char[] letters = L[Character.getNumericValue(D.charAt(pos))];
	            for (int i = 0; i < letters.length; i++)
	                bfs(pos+1, len, new StringBuilder(sb).append(letters[i]), ans, D);
	        }
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
}