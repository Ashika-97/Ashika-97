package geeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringSet1Logic {

	public void printPattern(String s)
	{
		String inp="";
		String res="";
		int n=s.length()/2;
		inp=s.substring(0,n);
		res=s.substring(n);
		res+=inp;
		for(int i=0;i<s.length();i++)
		{
			inp=res.substring(0,i+1);
			System.out.print(inp+"$ ");
		}
	}
	
	public String printString(String S, char ch, int count)
	{
		StringBuilder sb=new StringBuilder();
		int num=0;
		for(int i=0;i<S.length();i++)
		{
		
			if(count==num)
			{
				for(int j=i;j<S.length();j++) {
					
				sb.append(S.charAt(j));
				
			}
				break;
				}
			if(S.charAt(i)==ch)
			{
				num++;
			}
		}
				
		String result=String.valueOf(sb);
		
		return  (result.length()==0)? "empty String":result;
	}
	
	public String reverseWord(String s)
	{
		String res="";
		String eq="";
		int n=s.length();
		for(char ch:s.toCharArray())
		{
			if(ch=='.')
			{
				res=res+eq+ch;
			    eq=" ";
			}
			else {
				eq=ch+eq;
			}
		}
		res=res+eq;
		return res;
	}
	public String reverseSpace(String s)
	{
		int num=0;
		int len=s.length()-1;
		char[] ch=s.toCharArray();
		while(num<len) {
		if(ch[num]==' ')
		{
			num++;
		}
		if(ch[len]==' ')
		{
			len++;
		}
		
		if(ch[len]!=' ' && ch[len]!=0)
		{
			char temp=ch[num];
			ch[num]=ch[len];
			ch[len]=temp;
			len--;
			num++;
		}}
		String result=String.valueOf(ch);
		return result;
	}
	
	public String crossPattern(String s)
	{
		int h=0;
		int n=s.length();
		int t=0;
		char[] ch=new char[n*n];
		for(int i=0;i<n;i++)
		{
			h=n-i-1;
			for(int j=0;j<n;j++)
			{
				if((i==j)||(j==h))
				{
				ch[t]=s.charAt(j);
				t++;
						}
				else {
					ch[t]=' ';
					t++;
				}
			}
		}
		String result=String.valueOf(ch);
		return result;
	}
	public boolean pangram(String s,int k)
	{
		int n=s.length();
		Set<Character> set=new HashSet<>();
		for(int i=0;i<n;i++)
		{
			if(s.charAt(i)>='a' && s.charAt(i)<='z')
			{
				set.add(s.charAt(i));
			}
			
		}
		if(set.size()>=26 && 26-set.size()<=k)
		   return true;
		else
			return false;
	}
	
	
	public int maximumCharacter(String s)
	{
		int number=0;
		for(int i=0;i<s.length();i++)
		{
			number=Math.max(number,s.lastIndexOf(s.charAt(i))-i);
		}
		return number-1;
		
		
	}
	public String restoreString(String word,int[] indices)
	{
		int number=0;
		int n=word.length();
	    char[] ch=word.toCharArray();
		for(int num:indices)
		{
		    ch[num]=word.charAt(number);
			number++;
		}
		String result=String.valueOf(ch);
		return result;
	}
	
	 public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
		 String res="";
		 String ans="";
		 for(int i=0;i<word1.length;i++)
		 {
			 res+=word1[i];
		 }
		 for(int j=0;j<word2.length;j++)
		 {
			 ans+=word2[j];
		 }
		 if(res.equals(ans))
			 return true;
		 else
			 return false;
	 }
	
	 public static int wordBreak(String str, ArrayList<String> B )
	 {
		 int n=str.length();
		 if(str.length() == 0)
		 {
			 return 1;
		 }
		 for(int i=1;i<= n;i++)
		 {
			 String res=str.substring(0, i);
			 if(B.contains(res) && wordBreak(str.substring(i),B)==1)
				 return 1;
			 
		 }
		 return 0;
		 
		 
		 
	 }
	 
		public List<List<String>> Anagram(String[] strArr){
			
			List<List<String>> list=new ArrayList<>();
			HashMap<String,List<String>> map=new HashMap<>();
			for(String s:strArr)
			{
				char[] ch=s.toCharArray();
				Arrays.sort(ch);
				String input=Arrays.toString(ch);
				if(map.containsKey(input))
				{
					map.get(input).add(s);
				}
				else {
					List<String> li=new ArrayList<>();
					li.add(s);
					map.put(input, li);
				}
			}
			for(String ans:map.keySet())
			{
				list.add(map.get(ans));
			}
			
			return list;
		}
		}