package matrices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

public class MatrixLogic
{
    
	int sumOfMatrix(int N, int M, int[][] Grid) {
        // code here
        int a=0;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                a +=Grid[i][j];
            }
        }
        return a;
    }

	
	  public void rotate(int matrix[][]) 
	    {
	       
	        int n=matrix.length,k=0;
	         int[][] arr=new int[n][n];
	            for(int j=n-1;j >= 0;j--,k++)
	            {
	                 for(int i=0;i<n;i++)
	                    {
	                      arr[k][i] = matrix[i][j];
	            }
	        }
	            
	            
	            for(int i=0;i<n;i++)
	            {
	            	for(int j=0;j<n;j++)
	            	{
	            		matrix[i][j]=arr[i][j];
	            	}
	            }
	          
	        for(int i=0;i<n;i++)
	        {
	        	for(int j=0;j<n;j++)
	        	{
	        		
	        		System.out.println(matrix[i][j]);
	        		
	        	}
	        }
	        	
	        
	        
	    }
	
	 
		  public void transpose(int matrix[][], int n)
		    {
		        // code here
		        int k=0;
		      int[][] arr=new int[n][n];
		      for(int i=0;i<n;i++,k++)
		      {
		          for(int j=0;j<n;j++)
		          {
		              arr[k][j]=matrix[j][i];
		          }
		      }
		      
	      for(int i=0;i<n;i++)
	      {
	    	  for(int j=0;j<n;j++)
	    	  {
	    		  System.out.print(arr[i][j]);
	    	  }
	      }
	         }
	  
	  public ArrayList<ArrayList<Integer>> uniqueRows(int[][] arr,int r,int c)
	  {
		  ArrayList<ArrayList<Integer>> fullList=new ArrayList<>();
		  Set<ArrayList<Integer>> set=new HashSet<>();
		  
		  for(int i=0;i<r;i++)
		  {
			  ArrayList<Integer> list=new ArrayList<>();
			  for(int j=0;j<c;j++)
			  {
				  list.add(arr[i][j]);
			  }
		  
		  if(!set.contains(list))
		  {
			  set.add(list);
			  fullList.add(list);
		  }
		  
		  }
		  return fullList;
		  
	  }
	  
	    public void setZeroes(int[][] matrix) {
	        
	    	int n=matrix.length;
	    	int m=matrix[0].length;
	    	
	    	
	        int[] a=new int[n];
	        int[] b=new int[m];
	        for(int i=0;i<n;i++)
	        {
	            for(int j=0;j<m;j++)
	            {
	                if(matrix[i][j] == 0)
	                {
	                	a[i]=1;
	                	b[j]=1;
	                }
	         }
	        }
	           for(int i=0;i<n;i++)
	           {
	        	   for(int j=0;j< m;j++)
	        	   {
	        		   if(a[i]==1 || b[j] == 1 )
	        		   {
	        			   matrix[i][j]=0;
	        	   }
	           }
	            
	        }
	           for(int i=0;i<n;i++)
	           {
	        	   for(int j=0;j<m;j++)
	        	   {
	        		   System.out.print(matrix[i][j]);
	        	   }
	           }
	    }
	    
	    
	    public ArrayList<ArrayList<Integer>> grid(char[][] grid,String word)
	    {
	    	
	    	   ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		        
		        for(int row=0;row<grid.length;row++)
		        {
		            for(int col=0;col<grid[0].length;col++)
		            {
		                if(searchWord(grid,row,col,word))
		                {
		                    ArrayList<Integer> num=new ArrayList<>();
		                    num.add(row);
		                    num.add(col);
		                    list.add(num);
		                }
		            }
		        }
		        
		        int[][] result= new int[list.size()][2] ;
		        
		        for(int i=0;i<result.length;i++)
		        {
		            result[i][0]=list.get(i).get(0);
		            result[i][1]=list.get(i).get(1);
		        }
		        
		        for(int i=0;i<result.length;i++)
		        {
		        	for(int j=0;j<2;j++)
		        	{
		        		System.out.println(result[i][j]);
		        	}
		        }
		        
		    return list;
	    }
	    public boolean searchWord(char[][] grid,int row,int col,String word)
	    {
	    	int[] x= {-1,-1,-1, 0, 0, 1, 1,1};
	    	int[] y= {-1, 0, 1,-1, 1,-1, 0,1};
	    	
	    	 if(grid[row][col]!=word.charAt(0))
		        {
		            return false;
		        }
		        
		        for(int dir=0;dir<8;dir++)
		        {
		            int k,rd=row+x[dir],cd=col+y[dir];
		            
		            int wordLen=word.length();
		            
		            for(k=1;k<wordLen;k++)
		            {
		                
		                if(rd>=grid.length || rd<0|| cd>=grid[0].length|| cd<0)
		                {
		                    break;
		                }
		                
		                if(grid[rd][cd]!=word.charAt(k))
		                {
		                    break;
		                }
		                rd +=x[dir];
		                cd +=y[dir];
		            }
		            
		            if(k==wordLen)
		            {
		                return true;
		            }
		        }
		        
		        
		        return false;
		    }
	  
	  public void sortInsideArray(int[][] arr)
	  {
		  Vector<Integer> vector=new Vector<>();
		  for(int i=0;i<arr.length;i++)
		  {
				  vector.add(arr[i][i]);
			  
		  }
		  Collections.sort(vector);
		  
		 for(int i=0;i<arr.length;i++)
		 {
			  arr[i][i]=vector.get(i);
			 }
		 
		 for(int i=0;i<arr.length;i++)
		 {
			 for(int j=0;j<arr[0].length;j++)
			 {
				 System.out.print(arr[i][j]+" ");
			 }
			 System.out.println();
		 }
		
	  }
	  
	   public int maximalRectangle(char[][] matrix) {
	        if (matrix.length == 0)
	            return 0;

	            int ans = 0;
	            int[] hist = new int[matrix[0].length];

	            for (char[] row : matrix) {
	              for (int i = 0; i < row.length; ++i)
	                hist[i] = row[i] == '0' ? 0 : hist[i] + 1;
	              ans = Math.max(ans, largestRectangleArea(hist));
	            }

	            return ans;
	            }

	            private int largestRectangleArea(int[] heights) {
	            int ans = 0;
	            Stack<Integer> stack = new Stack<>();

	            for (int i = 0; i <= heights.length; ++i) {
	              while (!stack.isEmpty() && (i == heights.length || heights[stack.peek()] > heights[i])) {
	                final int h = heights[stack.pop()];
	                final int w = stack.isEmpty() ? i : i - stack.peek() - 1;
	                ans = Math.max(ans, h * w);
	              }
	              stack.push(i);
	            }

	            return ans;
	     }

	
	    public int isSuperSimilar(int n, int m, int mat[][], int x)
	      {
	         if(x%m==0)
	             return 1;
	                
	         x%=m;
	                
	         for(int i=0;i<mat.length;i++)
	          {
	           for(int j=0;j<mat[0].length;j++)
	             {
	        	   if(mat[i][(j+x)%m]!=mat[i][j])
	                    return 0;
	              }
	          }
	                
	                return 1;
	         }        

	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  public void zeroBasedIndex(int[] arr,int n)
	  {
		  int count=0,num=1;
		  int[][] input=new int[n][n];
		  ArrayList<ArrayList<Integer>> fullList=new ArrayList<>();
		  for(int i=0;i<n;i++)
		  { 
			  count=0;
			  ArrayList<Integer> list=new ArrayList<>();
			  for(int j=0;j<n;j++)
			  {
				  
			  }
		  }
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	
	
	
	
}
