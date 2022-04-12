package matrices;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixRun {
   
	  static Scanner scan=new Scanner(System.in);
	  MatrixLogic matrix=new MatrixLogic();
	
	
	public void matrixSums()
	{
		System.out.println("Enter the 2d number of rows ");
		int n=scan.nextInt();
		System.out.println("Enter the 2d number of columns ");
		int m=scan.nextInt();
		int[][] grid=new int[n][m];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				grid[i][j]=scan.nextInt();
			}
		}
		System.out.println(matrix.sumOfMatrix(n, m, grid));
	}
	
	public void rotateMatrix()
	{
		System.out.println("Enter the 2d number of rows ");
		int n=scan.nextInt();
		int[][] grid=new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				grid[i][j]=scan.nextInt();
			}
		}
		matrix.rotate(grid);
	}
	public void transpose()
	{
	System.out.println("Enter the 2d number of rows ");
	int n=scan.nextInt();
	int[][] grid=new int[n][n];
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
			grid[i][j]=scan.nextInt();
		}
	}
	matrix.transpose(grid, n);
	}
	public void unique()
	{
		System.out.println("Enter the 2d number of rows ");
		int n=scan.nextInt();
		System.out.println("Enter the 2d number of columns ");
		int m=scan.nextInt();
		int[][] grid=new int[n][m];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				grid[i][j]=scan.nextInt();
			}
		}
		System.out.println(matrix.uniqueRows(grid,n,m));
	}
	
	public void settingZeroes()
	{
		System.out.println("Enter the 2d number of rows ");
		int n=scan.nextInt();
		System.out.println("Enter the 2d number of columns ");
		int m=scan.nextInt();
		int[][] grid=new int[n][m];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				grid[i][j]=scan.nextInt();
			}
		}
		matrix.setZeroes(grid);
	}
	
	public void grid()
	{
		System.out.println("Enter the 2d number of rows ");
		int n=scan.nextInt();
		System.out.println("Enter the 2d number of columns ");
		int m=scan.nextInt();
		scan.nextLine();
		
		char[][] grid=new char[n][m];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				grid[i][j]=scan.next().charAt(0);
			}
		}
		scan.nextLine();
		System.out.println("Enter a search word ");
		String word=scan.nextLine();
	   System.out.println(matrix.grid(grid, word));
		
	}
	
	public void sortTheArrayin()
	{
		System.out.println("Enter the 2d number of rows ");
		int n=scan.nextInt();
		System.out.println("Enter the 2d number of columns ");
		int m=scan.nextInt();
		int[][] grid=new int[n][m];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				grid[i][j]=scan.nextInt();
			}
		}
		matrix.sortInsideArray(grid);
	}
	
	public void maxRectangle()
	{
		System.out.println("Enter the 2d number of rows ");
		int n=scan.nextInt();
		System.out.println("Enter the 2d number of columns ");
		int m=scan.nextInt();
		scan.nextLine();
		
		char[][] grid=new char[n][m];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				grid[i][j]=scan.next().charAt(0);
			}
		}
		System.out.println(matrix.maximalRectangle(grid));
	}
	
	public void rotateArray()
	{
		System.out.println("Enter the 2d number of rows ");
		int n=scan.nextInt();
		System.out.println("Enter the 2d number of columns ");
		int m=scan.nextInt();
		int[][] grid=new int[n][m];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				grid[i][j]=scan.nextInt();
			}
		}
		System.out.println("Enter the number of rotation to rotate ");
		int x=scan.nextInt();
		System.out.println(matrix.isSuperSimilar(n, m, grid, x));
	}
	
	public static void main(String[] args)
	{
		MatrixRun run=new MatrixRun();
		System.out.println("Enter the number ");
		int n=scan.nextInt();
		scan.nextLine();
		
		
		switch(n)
		{
		
		case 1:run.matrixSums();
		
		case 2:run.rotateMatrix();
		
		case 3:run.transpose();
		
		case 4:run.unique();
		
		case 5:run.settingZeroes();
		
		case 6:run.grid();
		
		case 7:run.sortTheArrayin();
		
		case 8:run.maxRectangle();
		
		case 9:run.rotateArray();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		}
	}
}
