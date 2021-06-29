/*
Link: https://practice.geeksforgeeks.org/problems/negative-weight-cycle3504/1

Given a weighted directed graph with n nodes and m edges. Nodes are labeled from 0 to n-1, the task is to check if it contains a negative weight cycle or not.
Note: edges[i] is defined as u, v and weight.
 

Example 1:

Input: n = 3, edges = {{0,1,-1},{1,2,-2},
{2,0,-3}}
Output: 1
Explanation: The graph contains negative weight
cycle as 0->1->2->0 with weight -1,-2,-3,-1.
Example 2:

Input: n = 3, edges = {{0,1,-1},{1,2,-2},
{2,0,3}}
Output: 0
Explanation: The graph does not contain any
negative weight cycle.

*/

//Initial Template for Java

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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] edges = new int[m][3];
            for(int i = 0; i < m; i++){
                String S2[] = br.readLine().trim().split(" ");
                for(int j = 0; j < 3; j++)
                    edges[i][j] = Integer.parseInt(S2[j]);
            }
            Solution obj = new Solution();
            int ans = obj.isNegativeWeightCycle(n, edges);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        int inf = 1000000000;
        int[] d = new int[n];
        int[] p = new int[n];
        
        Arrays.fill(d,0);
        Arrays.fill(p,-1);
        
        int x = -1;
        
        for(int i=0; i<n; i++)
        {
            x = -1;
            for(int j = 0; j<edges.length; j++)
            {
                if(d[edges[j][0]] + edges[j][2] < d[edges[j][1]])
                {
                    d[edges[j][1]] = d[edges[j][0]] + edges[j][2];
                    p[edges[j][1]] = edges[j][0];
                    x = edges[j][1];
                }
            }
        }
        if(x == -1)
            return 0;
        else
            return 1;
    }
}