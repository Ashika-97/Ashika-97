package PatternsCheck;

public class PatternsLogic {
       public void trianglePattern(int m)
       {
    	   int n=m;
    	   for(int i=0;i<n;i++)
    	   {
    		   for(int j=n-i;j>1;j--)
    		   {
    			   System.out.print(" ");
    		   }
    		   for(int j=0;j<i;j++)
    		   {
    			   System.out.print("* ");
    		   }
    		   System.out.println();
    	   }
    	  /* int space=n-1;
    	   for(int i=0;i<n;i++)
    	   {
    		   for(int j=0;j<space;j++)
    		   {
    			   System.out.print(" ");
    		   }
    		   for(int j=0;j<=i;j++)
    		   {
    			   System.out.print("*");
    		   }
    		   System.out.println();
    		   space--;
    	   }*/
       }
       public void rightTriasngle(int m)
       {
    	   int n=m;
    	   for(int i=0;i<n-1;i++)
    	   {
    		   for(int j=0;j<=i;j++)
    		   {
    			   System.out.print(" *");
    		   }
    		   System.out.println();
    	   }
       }
       public void leftTriangle(int m)
       {
    	   int n=m;
    	   for(int i=0;i<n;i++)
    	   {
    		   for(int j=1;j<(n-i+1);j++)
    		   {
    			   System.out.print(" ");
    		   }
    		   for(int j=0;j<=i;j++)
    		   {
    			   System.out.print("*");
    		   }
    		   System.out.println();
    	   }
       }
    
       
       public void diamondPattern(int n)
       {
    	   int i,j;
    	  
           for (i = 1; i <= n; i++) 
           {
               for (j = 1; j <= n-i; j++) 
               {
                   System.out.print(" ");
               }
              
               for (j = 1; j <= 2 * i - 1; j++) 
               {
                   System.out.print("*");                
               }
               System.out.println("");
           }
         
           for (i = 1; i <= n - 1; i++) 
           {
               for (j = 1; j <= i; j++) 
               {
                   System.out.print(" ");
               }
            
               for (j = 1; j <= 2 * (n - i) - 1; j++) 
               {
                   System.out.print("*");
               }
               System.out.println("");
           }   
       }
       
       public void rightPascal(int n)
       {
    	   for(int i=0;i<n;i++)
    	   {
    		   for(int j=0;j<=i;j++)
    		   {
    			   System.out.print("* ");
    		   }
    		   System.out.println();
    	   }
    	   for(int i=n-1;i>0;i--)
    	   {
    		   for(int j=0;j<=i-1;j++)
    		   {
    			   System.out.print("* ");
    		   }
    	       System.out.println();
    	   }
    	   
       }
       
       public void sandGlass(int n)
       {
    	   int i,j,k;
    	   for( i=0;i <= n-1;i++)
    	   {
    		  for( j = 0;j < i;j++)
    		  {
    			  System.out.print(" ");
    		  }
    		 
    		  for( k = i;k <= n-1;k++)
    		  {
    			  System.out.print("* ");
    		  }
    		  System.out.println();
    		  
    	   }
    
    	   
           for (i =n-1; i >= 0; i--) 
           {
               for (j = 0; j < i; j++) 
               {
                   System.out.print(" ");
               }
              
               for (k = i; k <= n - 1; k++) 
               {
                   System.out.print("* ");                
               }
               System.out.println();
           }
       }
     public void hollowTrianglePyra(int n)
     {
    	 for(int i=1;i<=n;i++)
         {
          
         for(int j=1;j<=n-i;j++)
          
         {
         System.out.print(" ");
         }
         if(i==1 || i==n)
         {
         for(int j=1;j<=i*2-1;j++)
          
         {
         System.out.print("*");
         }
         }
         else
         {
         for(int j=1;j<=i*2-1;j++)
          
         { 
         if(j==1 || j==i*2-1)
         {
         System.out.print("*");
         
         }
         else
         { 
         System.out.print(" ");
         }
         }}
         System.out.println();
          
         }
     }
    
     public void hollowDiamond(int n)
     {
    	 int i,j;
    	 for(i=1;i<=n;i++)
    	 {
    		 for(j=n;j>i;j--)
    		 {
    			 System.out.print(" ");
    		 }
    	 
    	 System.out.print("*");
    	 for(j=1;j<2*(i-1);j++)
    	 {
    		 System.out.print(" ");
    	 }
    	 if(i==1)
    		 System.out.println();
    	 
    	 else {
    		 System.out.print("*");
    		 System.out.println();
    	 }
    	 }
    	 for(i=n-1;i>=1;i--)
    	 {
    		 for(j=n;j>i;j--)
    		 {
    			 System.out.print(" ");
    		 }
    		 System.out.print("*");
    	 
    	 for(j=1;j<2*(i-1);j++)
    	 {
    		 System.out.print(" ");
    	 }
    	 if(i==1)
    		 System.out.println();
    	 
    	 else {
    		 System.out.print("*");
    		 System.out.println();
    	 }
    	 
    	 
    	 }
     }
     
     
     
    
    public void numberPattern(int n)
    {
    	for(int i=1;i<=n;i++)
    	{
    		for(int j=1;j<=i;j++)
    		{
    			System.out.print(j+" ");
    		}
    	  System.out.println();
    	}
    }
       
       
    public void  pascalNumber(int n)
    {
    	for(int i=1;i<=n;i++)
    	{
    		for(int j=0;j<n-i;j++)
    		{
    			System.out.print(" ");
    		}
    		int c=1;
    		for(int k=1;k<=i;k++)
    		{
    			System.out.print(c+" ");
    			c=c*(i-k)/k;
    		}
    		System.out.println();
    	}
    	
       }
       
       public void diamondNumber(int n)
       {
    	   int num = n / 2, num1 = 1;
    	   
           for (int i = 1; i <= n; i++) 
           {           
               for (int j = 1; j <= num; j++)
               {
            	   System.out.print(" ");
               }
            
               int count = num1 / 2 + 1;
               for (int k = 1; k <= num1; k++) {
                   System.out.print(count);
                   if (k <= num1 / 2)
                       count--;
                   else
                       count++;
               }
    
               System.out.println();
               if (i <= n / 2) {
    
                   num = num - 1;
                   num1 = num1 + 2;
               }
    
               else {
    
                   num = num + 1;
                   num1 = num1 - 2;
               }
           }
        }   
       
       
       public void zpattern(int n)
       {
    	for(int i=0;i<n;i++)
    	{
    		for(int j=0;j<n;j++)
    		{
    			if(i == 0 || i == n-1 || j == n-i-1 )
    			{
    				System.out.print("*");
    			}
    			else {
    				System.out.print(" ");
    			}
    		}
    			System.out.println();
    		
    	}
       }
       
       public void spiralPattern(int n)
       {
    	 int patternSize;
    	 patternSize = 2 * n - 1;
    	      for( int i = 1; i <= patternSize; i++){
    	         for(int  j = 1; j <= patternSize; j++){
    	            System.out.print(Math.max(Math.abs(i - n), Math.abs(j - n)) + 1 + " ");
    	         }
    	         System.out.println();
    	      }
    	   
       }
       public void lookAndSay(int n)
       {

    	    if (n == 1)     
    	    	System.out.println("1");
    	    if (n == 2)     
    	    	System.out.println("11");
    	 
    	    String str="11";
    	    for(int i=3;i<=n;i++)
    	    {
    	    	str+="$";
    	    	int len=str.length();
    	    	int count=1;
    	    	String res="";
    	    	char[] ch=str.toCharArray();
    	    	for(int j=1;j< len;j++)
    	    	{
    	    		if(ch[j] != ch[j-1])
    	    		{
    	    			res+=count+0;
    	    			res+=ch[j-1];
    	    			count=1;
    	    		}
    	    		else {
    	    			count++;
    	    		}
    	    	}
    	    	str=res;
    	    	
    	    }
    	    System.out.println(str);
       }       	    
    	    
    	    
    	    
    	    
    	    
    	    
    	    
    	    
    	    
    	    
    	    
    	    
    	    
    	    
    	    
    	    
    	    
    	/* 
    	    String str = "11";
    	    for (int i = 3; i <= n; i++)
    	    {
    	        str += '$';
    	        int len = str.length();
    	 
    	        int cnt = 1; 
    	        String tmp = ""; 
    	        char []arr = str.toCharArray();
    	         
    	     
    	        for (int j = 1; j < len; j++)
    	        {
    	        
    	            if (arr[j] != arr[j - 1])
    	            {
    	             
    	                tmp += cnt + 0;
    	 
    	            
    	                tmp += arr[j - 1];
    	 
    	                cnt = 1;
    	            }
    	 
    	            else cnt++;
    	        }
    	 
    	        str = tmp;
    	    }
       }*/
       
       public void XOPatterns(int n,int m)
       {
    	 /*  for(int i=1;i<=n;i++)
    	   {
    		   for(int j=1;j<=m;j++)
    		   {
    			   if(i == 1 || i == n || j==1 || j==n || ((i==j) && i== n/2 + 1 && j== n/2 +1) ) 
    				   System.out.print("X ");
    			   else
    				   System.out.print("O ");
    			   
    			 
    		   }
    		   System.out.println();
    	   
       }*/  	   
    	   
       int i, k = 0, l = 0;
       
    
       int r = m, c = n;
    
       char a[][] = new char[m][n];
    
         
       char x = 'X';
    
    
       while (k < m && l < n)
       {
         
           for (i = l; i < n; ++i)
               a[k][i] = x;
           k++;
 
           for (i = k; i < m; ++i)
               a[i][n-1] = x;
           n--;
    
          
           if (k < m)
           {
               for (i = n-1; i >= l; --i)
                   a[m-1][i] = x;
               m--;
           }
    
           if (l < n)
           {
               for (i = m-1; i >= k; --i)
                   a[i][l] = x;
               l++;
           }
    
         
           x = (x == '0')? 'X': '0';
       }
 
       for (i = 0; i < r; i++)
       {
           for (int j = 0; j < c; j++)
               System.out.print(a[i][j] + " ");
           System.out.println();
       }
   
       }
       
       
       
       
       
       
       
       
       
       
       
       
       
       public void kPatternProg(String s)
       {
    	 
    	   int len=s.length()/2;
    	   int n=len;
    	   String res=s.substring(0,n);
    	   String inp=s.substring(n);
    	   for(int i=0,k=inp.length()-1;i< res.length() || k>0;i++,k--)
    	   {
    		   System.out.println(res.charAt(i)+""+inp.charAt(k));
    	   }
    	   System.out.println(s.charAt(n));
    	   for(int j=n-1,k=1;j>=0 || k< n;j--,k++)
    	   {
    		  
    		   System.out.println(res.charAt(j)+""+ inp.charAt(k));
    		   
    	   }
       }
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       public void spiralModify(int size)
       {
    	   int row = 0, col = 0;
    	   
           int boundary = size - 1;
           int sizeLeft = size - 1;
           int flag = 1;
     
           char move = 'r';
     
           int matrix[][] = new int[size][size];
     
           for (int i = 1; i < size * size + 1; i++) {
     
               matrix[row][col] = i;
     
               switch (move) {
     
          
               case 'r':
                   col += 1;
                   break;
     
               case 'l':
                   col -= 1;
                   break;
     
               case 'u':
                   row -= 1;
                   break;
     
               case 'd':
                   row += 1;
                   break;
               }
     
               if (i == boundary) {
     
                   boundary += sizeLeft;
     
                   if (flag != 2) {
     
                       flag = 2;
                   }
                   else {
     
                       flag = 1;
                       sizeLeft -= 1;
                   }
     
                   switch (move) {
     
                 
                   case 'r':
                       move = 'd';
                       break;
     
                   case 'd':
                       move = 'l';
                       break;
     
           
                   case 'l':
                       move = 'u';
                       break;
     
                   case 'u':
                       move = 'r';
                       break;
                   }
               }
           }
     
      
           for (row = 0; row < size; row++) {
               for (col = 0; col < size; col++) {
     
                   int n = matrix[row][col];
                   System.out.print((n < 10) ? (n + " ")
                                             : (n + " "));
               }
     
               System.out.println();
           }
       }
     
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
}
