/*
Link: https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.

Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)

*/

import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if(new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else System.out.println("0");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

class Solution 
{
    //Function to detect cycle in a directed graph.
    boolean isCyclicUtil(int i, boolean[] visited,
                                      boolean[] recStack, ArrayList<ArrayList<Integer>> adj) 
    {
        
        //marking the current node as visited and part of recursion stack. 
        if (recStack[i])
            return true;

        if (visited[i])
            return false;
            
        visited[i] = true;

        recStack[i] = true;
        List<Integer> children = adj.get(i);
        
        //calling function recursively for all the vertices
		//adjacent to this vertex.
        for (Integer c: children)
            if (isCyclicUtil(c, visited, recStack, adj))
                return true;
        
        //removing the vertex from recursion stack.       
        recStack[i] = false;

        return false;
    }
    
    //Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        //marking all vertices as not visited and not a part of recursion stack
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        
        
        //calling the recursive helper function to detect cycle in  
		//different DFS trees.
        for (int i = 0; i < V; i++)
            if (isCyclicUtil(i, visited, recStack, adj))
                return true;

        return false;
    }
}