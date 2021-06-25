/*
Link: https://practice.geeksforgeeks.org/problems/is-binary-tree-heap/1

Given a binary tree you need to check if it follows max heap property or not.

Input:
The task is to complete the method which takes one argument, root of Binary Tree. The struct Node has a data part which stores the data, pointer to left child and pointer to right child.There are multiple test cases. For each test case, this method will be called individually.

Output:
The function should return true if property holds else false.
 

Example 1:

Input:
      5
    /  \
   2    3
Output: 1
Example 2:

Input:
       10
     /   \
    20   30 
  /   \
 40   60
Output: 0

*/

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

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

public class GfG {
    
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
    static void printInorder(Node root){
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException {
	        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
	        while(t-- > 0){
	            String s= br.readLine();
	            Node root = buildTree(s);
	            
	            Solution ob=new Solution();
	            if(ob.isHeap(root))
	                System.out.println(1);
	            else
	                System.out.println(0);
	        }
	}
}// } Driver Code Ends


// User Function template for JAVA

/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution
{
	int countNodes(Node root)
	{
		if(root==null)
			return 0;
		return(1 + countNodes(root.left) + countNodes(root.right));
	}

	boolean isValid(Node tree, int level, int no)
	{
		if(tree==null)
			return true;
		if(level >= no)
			return false;
		return isValid(tree.left, 2*level+1, no) && isValid(tree.right, 2*level+2, no);
		
	}
	
	boolean propHoldes(Node root)
	{
		if(root.left == null && root.right==null)
			return true;
		if(root.right == null)
			return root.data>root.left.data;
		else
		{
			if(root.data >= root.left.data && root.data >= root.right.data)
				return propHoldes(root.left) && propHoldes(root.right);
			else
				return false;
		}
	}
	boolean isHeap(Node tree)
	{
		if(tree == null)
			return true;
		int no_of_nodes = countNodes(tree);
		
		if(isValid(tree, 0 , no_of_nodes)==true && propHoldes(tree)==true)
			return true;
		return false;
	}
}