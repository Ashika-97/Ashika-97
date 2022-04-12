package PatternsCheck;

import java.util.Scanner;

public class PatternsRun {
    PatternsLogic pat=new PatternsLogic();
    static Scanner scan=new Scanner(System.in);
   public void trianglePattern()
   {
	   System.out.println("Enter the number ");
	   int n=scan.nextInt();
	   pat.trianglePattern(n);
	//   pat.rightTriasngle();
	//   pat.leftTriangle();
   }
   public void rightPattern()
   {
	   System.out.println("Enter the number ");
	   int n=scan.nextInt();
	   pat.rightTriasngle(n);
   }
   public void leftPatterns()
   {
	   System.out.println("Enter the number ");
	   int n=scan.nextInt();
	   pat.leftTriangle(n);
   }
  public void diamondPattern()
  {
	  System.out.println("Enter a number to print diamonds ");
	  int n=scan.nextInt();
	  pat.diamondPattern(n); 
  }
  
  
  public void rightPascl()
  {
	  System.out.println("Enter a number to print right pascals ");
	  int n=scan.nextInt();
	  pat.rightPascal(n); 
  }
  
  public void sandGlassPattern()
  {
	  System.out.println("Enter a number to print sand glass pascals ");
	  int n=scan.nextInt();
	  pat.sandGlass(n);
  }

  
  public void hollowTriangle()
  {
	  System.out.println("Enter a number to print hollow triangle ");
	  int n=scan.nextInt();
	  pat.hollowTrianglePyra(n);	  
  }
  
  public void hollowDiamondpattern()
  {
	  System.out.println("Enter a number to print hollow diamond pattern ");
	  int n=scan.nextInt();
	  pat.hollowDiamond(n);
  }
  public void numberPrinting()
  {
	  System.out.println("Enter a number to print number printing ");
	  int n=scan.nextInt();
	  pat.numberPattern(n);
  }
  public void numberPascals()
  {
	  System.out.println("Enter a number to print number pascals");
	  int n=scan.nextInt();
	  pat.pascalNumber(n);
	   
  }
  
  
  public void numberDiamond()
  {
	  System.out.println("Enter a number to print number pascals");
	  int n=scan.nextInt();
	  pat.diamondNumber(n);
	  
  }
  
  public void zPatter()
  {
	  System.out.println("Enter the number to process z pattern ");
      int n=scan.nextInt();
      pat.zpattern(n);
        
  }
  
  public void spiralPatterns()
  {
	  System.out.println("Enter the number to process spiarlpattern ");
      int n=scan.nextInt();
      pat.spiralPattern(n);
  }
  
  public void lookAndSays()
  {
	  System.out.println("Enter a number to print look and say ");
	  int n=scan.nextInt();
	  pat.lookAndSay(n);
  }
  
  public void spiralModification()
  {
	  System.out.println("Enter a number to print spiral rows ");
	  int n=scan.nextInt();
	  pat.spiralModify(n);
  }
  
  public void progPattern()
  {
	  System.out.println("Enter a string to print single k pattern ");
	  String s=scan.nextLine();
	  pat.kPatternProg(s);
  }
  
  public void xoPattern()
  {
	  System.out.println("Enter a number to print xo patterns rows ");
	  int n=scan.nextInt();
	  System.out.println("Enter the number to print xo patterns columns");
	  int m=scan.nextInt();
	  pat.XOPatterns(n,m);
  }
  
public static void main(String[] args)
{
	PatternsRun task=new PatternsRun();
	System.out.println("Enter a number in pattern ");
	int n=scan.nextInt();
	scan.nextLine();
	switch(n)
	{
	case 1:task.trianglePattern();
	
	case 2:task.rightPattern();
	
	case 3:task.leftPatterns();
	
	case 4:task.diamondPattern();
	
	case 5:task.rightPascl();
	
	case 6: task.sandGlassPattern();
	 
	case 7: task.hollowTriangle();
	
	case 8:task.hollowDiamondpattern();
	
	case 9:task.numberPrinting();
	
	case 10:task.numberPascals();
	
	case 11:task.numberDiamond();
	
	case 12:task.xoPattern();
	
	case 13:task.zPatter();
	
	case 14:task.spiralPatterns();
	
	case 15:task.lookAndSays();
	
	case 16:task.spiralModification();
	
	case 17:task.progPattern();
	
	
	}
}
} 
