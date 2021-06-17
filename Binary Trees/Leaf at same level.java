/*
Link: https://practice.geeksforgeeks.org/problems/leaf-at-same-level/1

Given a Binary Tree, check if all leaves are at same level or not.

Example 1:

Input: 
            1
          /   \
         2     3

Output: 1

Explanation: 
Leaves 2 and 3 are at same level.

Example 2:

Input:
            10
          /    \
        20      30
       /  \        
     10    15

Output: 0

Explanation:
Leaves 10, 15 and 30 are not at same level.

*/

//Initial Template for Java

// INITIAL CODE
import java.util.*;
import java.lang.*;
import java.io.*;

// A Binary Tree node
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class Is_Leaves_At_Same_Level
{
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }

    // driver function to test the above functions
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t=Integer.parseInt(br.readLine());
        
        while(t > 0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
        
            Solution g = new Solution();
	    	boolean b = g.check(root);
		   	if(b == true)
		    	System.out.println(1);
	    	else
		   	    System.out.println(0);
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Solution
{
    boolean check(Node root)
    {
        if (root == null)
                 return true;
 
             // create a queue for level order traversal
             Queue<Node> q = new LinkedList<>();
             q.add(root);
          
             int result = Integer.MAX_VALUE;
             int level = 0;
 
             // traverse until the queue is empty
             while (q.size() != 0) {
                    int size = q.size();
                    level++;
 
                    // traverse for complete level
                    while (size > 0) {
                         Node temp = q.remove();
 
                         // check for left child
                         if (temp.left != null) {
                             q.add(temp.left);
 
                              // if its leaf node
                              if (temp.left.left == null && temp.left.right == null) {
                                  
                                  // if it's first leaf node, then update result
                                  if (result == Integer.MAX_VALUE)
                                      result = level;
 
                                  // if it's not first leaf node, then compare 
                                  // the level with level of previous leaf node.
                                  else if (result != level)
                                       return false;
                              }
                         }
                          
                          // check for right child
                          if (temp.right != null) {
                             q.add(temp.right);
 
                              // if its leaf node
                             if (temp.right.left == null && temp.right.right == null) {
                                  
                                  // if it's first leaf node, then update result
                                  if (result == Integer.MAX_VALUE)
                                      result = level;
 
                                  // if it's not first leaf node, then compare 
                                  // the level with level of previous leaf node.
                                  else if (result != level)
                                       return false;
                              }
                         }
                         size--;
                    }
 
             }
             return true;
    }
}
