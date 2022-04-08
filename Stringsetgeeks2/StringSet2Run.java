package Stringsetgeeks2;

import java.util.Scanner;

public class StringSet2Run {
    static Scanner scan=new Scanner(System.in);
	static StringSet2Logic log=new StringSet2Logic();
	
	
	public void PangramGeeks()
	{
		System.out.println("Enter a number of times to run the pangram ");
		int number=scan.nextInt();
		scan.nextLine();
		for(int i=0;i < number;i++) {
		System.out.println("Enter a Text to test pangram ");
		String name=scan.nextLine();
		System.out.println(log.testPangram(name));}
	}
	
	public void removeTwoStringGeeks()
	{

		System.out.println("Enter a number of times to run thetwo String charcter presents removal");
		int number=scan.nextInt();
		scan.nextLine();
		for(int i=0;i < number;i++) 
		{
		System.out.println("Enter a String  ");
		String input=scan.nextLine();
		System.out.println("Enter a String 2 length less than first ");
		String name=scan.nextLine();
		System.out.println(log.removeChars(input, name));
		}
	}
	
	public void romanGeeks()
	{

		System.out.println("Enter a number of times to run thetwo String charcter presents removal");
		int number=scan.nextInt();
		scan.nextLine();
		for(int i=0;i < number;i++) 
		{
		 System.out.println("Enter a Roman characters ");
		 String name=scan.nextLine();
		 System.out.println(log.romanToInt(name));
			
		}
	}
	public void everyFirstLetter()
	{
		System.out.println("Enter a number of times to run get everey word first letter ");
		int number=scan.nextInt();
		scan.nextLine();
		for(int i=0;i < number;i++) 
		{
			System.out.println("Enter a String ");
			String input=scan.nextLine();
			System.out.println(log.firstLetter(input));
		}
		
	}
	public void isomorphic()
	{
		System.out.println("Enter a number of times to run to get isomorphic ");
		int number=scan.nextInt();
		scan.nextLine();
		for(int i=0;i < number;i++) 
		{
			System.out.println("Enter a first String ");
			String input=scan.nextLine();
			System.out.println("Enter a second String");
			String input1=scan.nextLine();
			System.out.println(StringSet2Logic.areIsomorphic(input, input1));
		}
	}
	
	public void permuteInclusion()
	{
		System.out.println("Enter a number of times to run to get permutation inclusion check ");
		int number=scan.nextInt();
		scan.nextLine();
		for(int i=0;i < number;i++) 
		{
			System.out.println("Enter a string less than second string size");
			String text=scan.nextLine();
			System.out.println("Enter a second String ");
			String text1=scan.nextLine();
			System.out.println(log.permutation(text, text1));
			
			
		}
	}
	public void validIp()
	{
		System.out.println("Enter a number of times to run the ip addres validation");
		int number=scan.nextInt();
		scan.nextLine();
		for(int i=0;i < number;i++) 
		{
			System.out.println("Enter a string in Ip address format");
			String text=scan.nextLine();
			System.out.println(log.isValid(text));
		}
		
		
	}
	public void repeatVowels()
	{
		System.out.println("Enter a number of times to repeat the vowels interchange");
		int number=scan.nextInt();
		scan.nextLine();
		for(int i=0;i < number;i++) 
		{
			System.out.println("Enter the String");
			String input=scan.nextLine();
			System.out.println(log.modify(input));
		}
		
	}
	public void bracketsValid()
	{
		System.out.println("Enter a number of times to check the brackets");
		int number=scan.nextInt();
		scan.nextLine();
		for(int i=0;i < number;i++) 
		{
			System.out.println("Enter the String");
			String input=scan.nextLine();
			System.out.println(log.isBrackets(input));
		}
		
	}
	public void rotatedTwoShift()
	{
		System.out.println("Enter a number of times to check the rotated string contains");
		int number=scan.nextInt();
		scan.nextLine();
		for(int i=0;i < number;i++) 
		{
			System.out.println("Enter the String");
			String input=scan.nextLine();
			System.out.println("Enter the second String");
			String input1=scan.nextLine();
			System.out.println(StringSet2Logic.isRotated(input, input1));
		}
		
	}
	public void encrypt()
	{
		System.out.println("Enter a number of times to check the encrypt");
		int number=scan.nextInt();
		scan.nextLine();
		for(int i=0;i < number;i++) 
		{
			System.out.println("Enter the String");
			String input=scan.nextLine();
			System.out.println(log.encryptString(input));
		}
		
	}
	public void minDel()
	{	
	System.out.println("Enter a number of times to check the minimum deletions");
	int number=scan.nextInt();
	scan.nextLine();
	for(int i=0;i < number;i++) 
	{
		System.out.println("Enter the String");
		String input=scan.nextLine();
		System.out.println(log.minimumDeletion(input));
	}
	
   }
	public void palindromeGeeks()
	{	
	System.out.println("Enter a number of times to check the palindrome insertion");
	int number=scan.nextInt();
	scan.nextLine();
	for(int i=0;i < number;i++) 
	{
		System.out.println("Enter the String");
		String input=scan.nextLine();
		System.out.println(log.countMin(input));
	}
	
   }
	public void countAndSayLeet()
	{
	System.out.println("Enter a number of times to count and say");
	int number=scan.nextInt();
	scan.nextLine();
	for(int i=0;i < number;i++) 
	{
		System.out.println("Enter the String");
		int num=scan.nextInt();
		System.out.println(log.countAndSay(num));
	}
	}
	
	
	public static void main(String[] args)
	{
		StringSet2Run run=new StringSet2Run();
		System.out.println("Enter a number to get the methods ");
		int num=scan.nextInt();
		scan.nextLine();
		switch(num)
		{
		case 1:
			run.PangramGeeks();
		case 2:
			run.removeTwoStringGeeks();
		case 3:
			run.romanGeeks();
		case 4:
			 run.repeatVowels();
		case 5:
			 run.bracketsValid();
		case 6:
		   run.validIp();
		case 7:
			 run.everyFirstLetter();
		case 8:
		     run.isomorphic();
		case 9:
			run.permuteInclusion();
		case 10:
			run.rotatedTwoShift();
		case 11:
			run.encrypt();
		case 12:
			run.minDel();
		case 13:
			run.palindromeGeeks();
		case 14:
			run.countAndSayLeet();
		}
	}
	
}
