/*
Link: https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

Given a connected undirected graph. Perform a Depth First Traversal of the graph.
Note: Use recursive approach to find the DFS traversal of the graph starting from the 0th vertex from left to right according to the graph.

Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)

*/

class Solution
{
    //Function to return a list containing the DFS traversal of the graph.
    private void dfs(int ch, boolean[] vis, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> adj)
    {
        //marking vertex as visited and adding it to output list.
        vis[ch] = true;
        ans.add(ch);
        
        //iterating over connected components of the vertex and if any 
	    //of them is not visited then calling the function recursively.
        for(int i = 0; i < adj.get(ch).size(); i++)
            if(!vis[adj.get(ch).get(i)])
                dfs(adj.get(ch).get(i), vis, ans, adj);
    }
    
    //Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj)
    {
        //using a boolean list to mark all the vertices as not visited.
        boolean[] vis = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<Integer>();
	    dfs(0, vis, ans, adj);
	    
	    //returning the output list.
	    return ans;
    }
}