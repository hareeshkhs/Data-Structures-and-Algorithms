/*
Link: https://practice.geeksforgeeks.org/problems/preorder-to-postorder4423/1

Given an array arr[] of N nodes representing preorder traversal of BST. The task is to print its postorder traversal.

Example 1:

Input:
N = 5
arr[]  = {40,30,35,80,100}
Output: 35 30 100 80 40
Explanation: PreOrder: 40 30 35 80 100
InOrder: 30 35 40 80 100
Therefore, the BST will be:
              40
           /      \
         30       80
           \        \   
           35      100
Hence, the postOrder traversal will
be: 35 30 100 80 40
Example 2:

Input:
N = 8
arr[]  = {40,30,32,35,80,90,100,120}
Output: 35 32 30 120 100 90 80 40

*/

//Initial Template for Java


import java.util.*;
import java.io.*;

class Node { 
	int data; 
	Node left, right; 
	Node(int d) { 
		data = d; 
		left = right = null; 
	} 
} 


class GFG {
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String[] inputline = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputline[0]);
            inputline = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputline[i]);
            }
            
            Node res = constructTree(arr, n);
            printPostorder(res);
            System.out.println();
        }
    }
    
    
    
    
 // } Driver Code Ends
//User function Template for Java


//Function that constructs BST from its preorder traversal.
public static Node constructTree(int pre[], int size) 
{
    Node root = new Node(pre[0]);
	
	//creating a stack of capacity equal to size of array.
	Stack<Node> s = new Stack<Node>(); 
	//pushing root into the stack.
	s.push(root); 
	
	//iterating over rest of the array elements.
	for (int i = 1; i < size; ++i)
	{ 
		Node temp = null; 
		
		//we keep on popping from stack while data at top of stack is less
        //than the current array element.
		while (!s.isEmpty() && pre[i] > s.peek().data) 
		{ 
			temp = s.pop(); 
		} 
		
		//we make this greater value as the right child and push it into stack.
		if (temp != null)
		{ 
			temp.right = new Node(pre[i]); 
			s.push(temp.right); 
		} 
		//if current array element is less than data at top of stack, we make
        //it as the left child of the stack's top node and push it into stack.
		else 
		{ 
			s.peek().left = new Node(pre[i]); 
			s.push(s.peek().left); 
		} 
	} 
	return root; 
} 

// { Driver Code Starts.


public static 	void printInorder(Node node) { 
		if (node == null) { 
			return; 
		} 
		printInorder(node.left); 
		System.out.print(node.data + " "); 
		printInorder(node.right); 
	} 
	
public static 	void printPostorder(Node node) { 
		if (node == null) { 
			return; 
		} 
		printPostorder(node.left); 
		printPostorder(node.right);
		System.out.print(node.data + " "); 
	} 
	
public static 	void printPreorder(Node node) { 
		if (node == null) { 
			return; 
		} 
		System.out.print(node.data + " "); 
		printPreorder(node.left); 
		printPreorder(node.right);
	} 

}  // } Driver Code Ends