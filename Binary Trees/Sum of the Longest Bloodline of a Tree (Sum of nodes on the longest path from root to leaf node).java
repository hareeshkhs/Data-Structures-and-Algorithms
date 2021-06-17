/*
Link: https://practice.geeksforgeeks.org/problems/sum-of-the-longest-bloodline-of-a-tree/1

Given a binary tree of size N. Your task is to complete the function sumOfLongRootToLeafPath(), that find the sum of all nodes on the longest path from root to leaf node.
If two or more paths compete for the longest path, then the path having maximum sum of nodes is being considered.

Example 1:

Input: 
        4        
       / \       
      2   5      
     / \ / \     
    7  1 2  3    
      /
     6
Output: 13
Explanation:
        4        
       / \       
      2   5      
     / \ / \     
    7  1 2  3 
      /
     6

The highlighted nodes (4, 2, 1, 6) above are 
part of the longest root to leaf path having
sum = (4 + 2 + 1 + 6) = 13
Example 2:

Input: 
          1
        /   \
       2     3
      / \   / \
     4   5 6   7
Output: 11

*/

//Initial Template for Java

import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node left, right;
    
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class BinaryTree
{
     public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
           // int n = sc.nextInt();
            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
            int n = sc.nextInt();
            Node root = null;
            while (n > 0)
            {	
			
		int n1 = sc.nextInt();
                int n2 = sc.nextInt();
		char lr= sc.next().charAt(0);
				
               
                Node parent = m.get(n1);
                if (parent == null)
                {
                    parent = new Node(n1);
                    m.put(n1, parent);
                    if (root == null)
                        root = parent;
                }
                Node child = new Node(n2);
                if (lr == 'L')
                    parent.left = child;
                else
                    parent.right = child;
                m.put(n2, child);
                n--;
            }
			
           
            GfG gfg = new GfG();
            System.out.println(gfg.sumOfLongRootToLeafPath(root));
            
        }
        
    }
}// } Driver Code Ends


//User function Template for Java

/*
node class of binary tree
class Node {
	int data;
	Node left, right;
};
*/
// your task is to complete this function
class GfG
{
    class Height{
        int h;
        int s;
        Height(int h, int s){
            this.h = h;
            this.s = s;
        }
    }
    public int sumOfLongRootToLeafPath(Node root)
    {
        
        if(root == null)
          return 0;
    	Height h = helper(root, new Height(0,0) );
    	return h.s;
    }
    
    Height helper(Node root, Height h){
        if( root == null ){
            return h;
        }
        // h.h = h.h+1;
        // h.s = h.s + root.data;
        Height l = helper(root.left, new Height(h.h+1, h.s + root.data));
        Height r = helper(root.right, new Height(h.h+1, h.s + root.data));
        if( l.h > r.h ){
            return new Height(l.h, l.s);
        } else if( l.h == r.h ) {
            return new Height(l.h, Math.max(l.s, r.s) );
        }
        return new Height(r.h, r.s);
        
    }
}