/*
Link: https://practice.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1

The problem is to find shortest distances between every pair of vertices in a given edge weighted directed Graph. The Graph is represented as adjancency matrix, and the matrix denotes the weight of the edegs (if it exists) else -1. Do it in-place.
 

Example 1:

Input: matrix = {{0,25},{-1,0}}
Output: {{0,25},{-1,0}}
Explanation: The shortest distance between
every pair is already given(if it exists).
Example 2:

Input: matrix = {{0,1,43},{1,0,6},{-1,-1,0}}
Output: {{0,1,7},{1,0,6},{-1,-1,0}}
Explanation: We can reach 3 from 1 as 1->2->3
and the cost will be 1+6=7 which is less than 
43.

*/

//Initial template for JAVA

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j]  =Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            obj.shortest_distance(matrix);
            for(int i = 0; i < n; i++){
                for(int j  = 0; j < n; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function template for JAVA

class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        int INF = Integer.MAX_VALUE;
		int n = matrix.length;
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(matrix[i][j] == -1)
					matrix[i][j] = INF;
			}
		}
		
		for (int k = 0; k < n; ++k) {
		    for (int i = 0; i < n; ++i) {
		        for (int j = 0; j < n; ++j) {
		            if (matrix[i][k] < INF && matrix[k][j] < INF 
		                    && matrix[i][k] + matrix[k][j] < INF)
		                matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]); 
		        }
		    }
		}
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(matrix[i][j] >= INF)
					matrix[i][j] = -1;
			}
		}
    }
}