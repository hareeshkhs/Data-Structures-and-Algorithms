/*
Link: https://practice.geeksforgeeks.org/problems/find-k-th-smallest-element-in-bst/1

Given a BST and an integer K. Find the Kth Smallest element in the BST. 

Example 1:

Input:
      2
    /   \
   1     3
K = 2
Output: 2
Example 2:

Input:
        2
      /  \
     1    3
K = 5
Output: -1


*/

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currrNode = q.remove();
        
              // Get the currrent node's value from the string
              String currrVal = s[i];
        
              // If the left child is not null
              if(!currrVal.equals("N")) 
              {
        
                  // Create the left child for the currrent node
                  currrNode.left = new Node(Integer.parseInt(currrVal));
        
                  // Push it to the queue
                  q.add(currrNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currrVal = s[i];
        
              // If the right child is not null
              if(!currrVal.equals("N")) 
              {
        
                  // Create the right child for the currrent node
                  currrNode.right = new Node(Integer.parseInt(currrVal));
        
                  // Push it to the queue
                  q.add(currrNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            int k = Integer.parseInt(br.readLine().trim());
            
            Solution T = new Solution();
            System.out.println(T.KthSmallestElement(root,k));
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }


class Solution
{
    // Return the Kth smallest element in the given BST 
    int count =0;
    int result = -1;
	void kthSmallestUtil(Node root, int k ) 
    { 
        
        if (root == null || count >= k) 
            return; 
        kthSmallestUtil(root.left, k);  
        count++;

        if (count == k) { 
            result = root.data;
            return; 
        }
        kthSmallestUtil(root.right, k);
    }
    
    public int KthSmallestElement(Node root, int K) 
    {
        // Write your code here
        kthSmallestUtil(root, K); 
        return result;
        
    }
    
    
}