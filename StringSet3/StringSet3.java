package StringSet3;
import java.util.*;

public class StringSet3 
{
      static Scanner scan=new Scanner(System.in);
      static StringSet3Logic set=new StringSet3Logic();
      
      
      
      public void prefix()
      {
    	  System.out.println("Enter a number to run the loop number of times ");
    	  int num=scan.nextInt();
    	  scan.nextLine();
    	  for(int i=0;i<num;i++)
    	  {
    	  System.out.println("Enter a String ");
    	  String name=scan.nextLine();
    	  System.out.println(set.prefixSuffix(name));
          }
      }
      
      
      public void Kanagrams()
      {
    	  System.out.println("Enter a number to run the loop number of times ");
    	  int num=scan.nextInt();
    	  scan.nextLine();
    	  for(int i=0;i<num;i++)
    	  {
    	  System.out.println("Enter a String ");
    	  String name=scan.nextLine();
    	  System.out.println("Enter a String ");
    	  String name1=scan.nextLine();
    	  System.out.println("Enter a number within change happened limit ");
    	  int k=scan.nextInt();
    	  System.out.println(set.KAnagram(name, name1, k));
          }
      
      }
	
	public void longestSub()
	{
		  System.out.println("Enter a number to run the loop number of times ");
    	  int num=scan.nextInt();
    	  scan.nextLine();
    	  for(int i=0;i<num;i++)
    	  {
    	  System.out.println("Enter a String ");
    	  String name=scan.nextLine();
    	  System.out.println(set.longestSubstring(name));
    	  }
	}
	
	public void numberToWords()
	{
	  System.out.println("Enter a number to run the loop number of times ");
   	  int num=scan.nextInt();
   	  scan.nextLine();
   	  for(int i=0;i<num;i++)
   	  {
   	  System.out.println("Enter a number ");
   	  int num1=scan.nextInt();
   	  System.out.println(set.convert(num1));
   	  }
	}
	public void rotationsOfString()
	{
		  System.out.println("Enter a number to run the loop number of times ");
	   	  int num=scan.nextInt();
	   	  scan.nextLine();
	   	  for(int i=0;i<num;i++)
	   	  {
	   	  System.out.println("Enter a number ");
	   	  String num1=scan.nextLine();
	   	  System.out.println("enter A rotated String ");
	   	  String num2=scan.nextLine();
	   	  System.out.println(set.rotatedString(num1, num2));
	   	  }
		
		
		
	}
	public void palindromeRemove()
	{
		  System.out.println("Enter a number to run the loop number of times ");
	   	  int num=scan.nextInt();
	   	  scan.nextLine();
	   	  for(int i=0;i<num;i++)
	   	  {
	   	  System.out.println("Enter a String with palindrome words ");
	   	  String num1=scan.nextLine();
	   	 
	   	  System.out.println(set.removePalinWords(num1));
	   	  }	
	}
	public void firstNonCharacter()
	{
		System.out.println("Enter a number to run the loop number of times ");
	   	  int num=scan.nextInt();
	   	  scan.nextLine();
	   	  for(int i=0;i<num;i++)
	   	  {
	   		  System.out.println("Enter a string to non repeated character ");
	   		  String name=scan.nextLine();
	   		  System.out.println(set.firstCharacter(name));
	   	  }
	}
	
	public void nonSubstring()
	{
		  System.out.println("Enter a number to run the loop number of times ");
	   	  int num=scan.nextInt();
	   	  scan.nextLine();
	   	  for(int i=0;i<num;i++)
	   	  {
	   		  System.out.println("Enter a string to check substring ");
	   		  String name=scan.nextLine();
	   		  System.out.println("Enter a another string ");
	   		  String input=scan.nextLine();
	   		  set.twoSetOfString(name, input);
	   	  }
		
		
	}
	
	public void nonBuiltfunction()
	{
		  System.out.println("Enter a number to run the loop number of times ");
	   	  int num=scan.nextInt();
	   	  scan.nextLine();
	   	  for(int i=0;i<num;i++)
	   	  {
	   		  System.out.println("Enter a string to check substring ");
	   		  String name=scan.nextLine();
	   		  System.out.println("Enter a another string ");
	   		  String input=scan.nextLine();
	   		  System.out.println("Enter a String ");
	   		  String input1=scan.nextLine();
	   		  System.out.println(set.sameWordsNonBuilt(name, input, input1));
	   	  }		
	}
	
	
	public void permute()
	{

		  System.out.println("Enter a number to run the loop number of times ");
	   	  int num=scan.nextInt();
	   	  scan.nextLine();
	   	  for(int i=0;i<num;i++)
	   	  {
	   		  System.out.println("Enter a string ");
	   		  String name=scan.nextLine();
	   		  set.printCombinations(name);
	   	  }
		
	}
	
	public void decode()
	{
		  System.out.println("Enter a number to run the loop number of times ");
	   	  int num=scan.nextInt();
	   	  scan.nextLine();
	   	  for(int i=0;i<num;i++)
	   	  {
	   		  System.out.println("Enter a string ");
	   		  String name=scan.nextLine();
	   	      System.out.println(set.decodedString(name));
	   	  }
	}
	
	public void lexicographic()
	{
		  System.out.println("Enter a number to run the loop number of times ");
	   	  int num=scan.nextInt();
	   	  scan.nextLine();
	   	  for(int i=0;i<num;i++)
	   	  {
	   		  System.out.println("Enter a string for lexicogrphic  ");
	   		  String name=scan.nextLine();
	   		  System.out.println("Enter a String for lexicogrphically checking ");
		      String name1=scan.nextLine();
		      set.lexicoGraphically(name, name1);
	   	  }
		
	}
	public void balancedWords()
	{

		  System.out.println("Enter a number to run the loop number of times ");
	   	  int num=scan.nextInt();
	   	  scan.nextLine();
	   	  for(int i=0;i<num;i++)
	   	  {
	   		  System.out.println("Enter a String to check balanced Words ");
	   		  String input=scan.nextLine();
	   		  System.out.println(set.balanceWords(input));
	   	  }
	}
	public void mappingDigits()
	{

		  System.out.println("Enter a number to run the loop number of times ");
	   	  int num=scan.nextInt();
	   	  scan.nextLine();
	   	  for(int i=0;i<num;i++)
	   	  {
	   		  System.out.println("Enter a String to mapping ");
	   		  String input=scan.nextLine();
	   		  System.out.println(set.letterCombinations(input));
	   	  }
	}
	
	
	public static void main(String[] args)
	{
		StringSet3 run=new StringSet3();
		System.out.println("Enter a number to proceed the functions ");
		int n=scan.nextInt();
		
		
		
		switch(n)
		{
		case 1:
			run.prefix();
		case 2:
			run.Kanagrams();
		case 3:
			run.longestSub();
		case 4:
			run.numberToWords();
		case 5:
			run.rotationsOfString();
		case 6:
			run.palindromeRemove();
		case 7:
			run.firstNonCharacter();
		case 8:
			run.nonSubstring();
		case 9:
			run.nonBuiltfunction();
		case 10:
			run.permute();
		case 11:
			run.decode();
		case 12:
		    run.lexicographic();  
		case 13:
			run.balancedWords();
		case 14:
			run.mappingDigits();
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
