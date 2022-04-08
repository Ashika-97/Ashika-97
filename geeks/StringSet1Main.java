package geeks;

import java.util.ArrayList;
import java.util.Scanner;

public class StringSet1Main {
     static Scanner scan=new Scanner(System.in);
	StringSet1Logic log=new StringSet1Logic();
    
    public void printPatterGeeks()
    {
    	System.out.println("Enter a String");
    	String name=scan.nextLine();
    	log.printPattern(name);
    }
    public void RemainingStringGeeks()
    {
    	System.out.println("Enter a String ");
    	String name=scan.nextLine();
    	System.out.println("Enter a number ");
    	int number=scan.nextInt();
    	scan.nextLine();
    	System.out.println("Enter a character ");
    	char ch=scan.next().charAt(0);
    	System.out.println(log.printString(name, ch,number));
    }
    
    public void RemainigDot()
    {
    	System.out.println("Enter a String ");
    	String input=scan.nextLine();
    	System.out.println(log.reverseWord(input));
    }
    public void remainigSpace()
    {
    	System.out.println("Enter a String ");
    	String input=scan.nextLine();
    	System.out.println(log.reverseSpace(input));
    }
	
    public void cross()
    {
    	System.out.println("Enter a string");
    	String name=scan.nextLine();
    	System.out.println(log.crossPattern(name));
    }
    
    
    public void pangram()
    {
    	System.out.println("Enter a String ");
    	String inut=scan.nextLine();
    	System.out.println("Enter a integer ");
    	int num=scan.nextInt();
    	System.out.println(log.pangram(inut, num));
    }
    public void maximumNumberOfCharacter()
    {
    	System.out.println("Enter a string");
    	String input=scan.nextLine();
    	System.out.println(log.maximumCharacter(input));
    }
    public void shuffleCode()
    {
    	System.out.println("Enter a String");
    	String name=scan.nextLine();
    	int[] num= {4,5,6,7,0,1,2,3};
    	System.out.println(log.restoreString(name, num));
    }
    public void stringArray()
    {
    	System.out.println("Enter a int size array");
    	int num=scan.nextInt();
    	scan.nextLine();
    	String[] arr=new String[num];
    	for(int i=0;i<arr.length;i++)
    	{
    		System.out.println("Enter the "+ i +"array");
    		arr[i]=scan.nextLine();
    		
    	}
    	System.out.println("Enter a int size fpr second array");
    	int num1=scan.nextInt();
    	scan.nextLine();
    	String[] arr1=new String[num1];
    	for(int i=0;i<arr1.length;i++)
    	{
    		System.out.println("Enter the "+ i +"array");
    		arr1[i]=scan.nextLine();
    	}
    	System.out.println(log.arrayStringsAreEqual(arr, arr1));
    }
    public  void wordBreakGeeks()
    {
    	
    	System.out.println("Enter a number of array to add ");
    	ArrayList<String> list=new ArrayList<>();
    	int n=scan.nextInt();
    	scan.nextLine();
    	String[] str=new String[n];
    	for(int i=0;i<n;i++)
    	{
    		System.out.println("Enter a "+ i +" array");
    		str[i]=scan.nextLine();
    		list.add(str[i]);
    		
    	}
    	System.out.println(list);
    	System.out.println("Enter a String to search ");
    	String name=scan.nextLine();
    	System.out.println(StringSet1Logic.wordBreak(name, list));
    }
   
	
	public void AnagramGeeks()
	{
		System.out.println("Enter a number");
	    int num=scan.nextInt();
	    scan.nextLine();
	    String[] arr=new String[num];
	    for(int i=0;i<arr.length;i++)
	    {
	    	System.out.println("Enter a number of array ");
	    	arr[i]=scan.nextLine();
	    }
	    System.out.println(log.Anagram(arr));
	}
	
	
	public static void main(String[] args)
	{
		StringSet1Main set=new StringSet1Main();
		System.out.println("Enter a number to get the method ");
		int n=scan.nextInt();
		scan.nextLine();
	
	switch(n)
	{
	
	case 1:
		set.printPatterGeeks();
	case 2:
		set.wordBreakGeeks();
	case 3:
		set.RemainingStringGeeks();
	case 5:
		set.RemainigDot();
	case 6:
		set.remainigSpace();
	case 7:
		set.cross();
	case 8:
		set.pangram();
	case 9:
		set.maximumNumberOfCharacter();
	case 10:
		set.shuffleCode();
	case 12:
		set.stringArray();
	case 14:
		set.AnagramGeeks();
	}
	
	
	
	
	}
}
