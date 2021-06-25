/*
Link: https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not. 

*/

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
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends





class Solution
{
    //Function to detect cycle in an undirected graph.
    Boolean isCyclicUtil(int v, 
                 Boolean visited[], int parent, ArrayList<ArrayList<Integer>> adj)
    {
        //marking the current vertex as visited.
        visited[v] = true;
        Integer i;

        Iterator<Integer> it = adj.get(v).iterator();
        while (it.hasNext())
        {
            i = it.next();

            //if an adjacent is not visited, then calling function 
            //recursively for that adjacent vertex.
            if (!visited[i])
            {
                if (isCyclicUtil(i, visited, v, adj))
                    return true;
            }

            //if an adjacent is visited and it is not a parent of current
            //vertex then there is a cycle and we return true.
            else if (i != parent)
                return true;
        }
        return false;
    }
    
    //Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //using a boolean list to mark all the vertices as not visited.
        Boolean visited[] = new Boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        //iterating over all the vertices.
        for (int u = 0; u < V; u++)
        {  
            //if vertex is not visited, we call the function to detect cycle.
            if (!visited[u]) 
                
                //if cycle is found, we return true.
                if (isCyclicUtil(u, visited, -1, adj))
                    return true;
        }

        return false;
    }
}