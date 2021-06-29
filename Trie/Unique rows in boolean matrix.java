/*
Link: https://practice.geeksforgeeks.org/problems/unique-rows-in-boolean-matrix/1

Given a binary matrix your task is to find all unique rows of the given matrix.

Example 1:

Input:
row = 3, col = 4 
M[][] = {{1 1 0 1},{1 0 0 1},{1 1 0 1}}
Output: 1 1 0 1 $1 0 0 1 $
Explanation: Above the matrix of size 3x4
looks like
1 1 0 1
1 0 0 1
1 1 0 1
The two unique rows are 1 1 0 1 and
1 0 0 1 .
*/

import java.lang.Math;
import java.util.*;
class UniqueRows{
public static void main(String[] args)
 {  Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int r=sc.nextInt();
			int c=sc.nextInt();
			int[][] a=new int [r][c];
			for(int i=0;i<r;i++)
				for(int j=0;j<c;j++)
					a[i][j]=sc.nextInt();
			GfG g=new GfG();
			ArrayList<ArrayList<Integer>> arr = g.uniqueRow(a,r,c);
			for(int i = 0;i<arr.size();i++){
			    ArrayList<Integer> demo = arr.get(i);
			    for(int j = 0;j<demo.size();j++){
			        System.out.print(demo.get(j)+" ");
			    }
			    System.out.print("$");
			}
			System.out.println();
		}
 }
}// } Driver Code Ends


/*Complete the given function*/
class GfG{
		public static ArrayList<ArrayList<Integer>> uniqueRow(int a[][],int r, int c){
			int[] ar=new int[r];
			Arrays.fill(ar,0);
			ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
			
			for(int j=0;j<r;j++)
			for(int i=c-1;i>=0;i--){
				ar[j]+=a[j][i]*(int)Math.pow(2,c-i-1);
			}
			for(int i=0;i<r;i++)
				for(int j=i+1;j<r;j++)
					if(ar[i]==ar[j])
						ar[j]=-1;
			for(int i=0;i<r;i++){
				if(ar[i]>=0){
				    ArrayList<Integer> demo = new ArrayList<Integer>();
					for(int j=0;j<c;j++){
					    demo.add(a[i][j]);
					    
					}
				    arr.add(demo);
			    }
			}
			return arr;
		}
}
