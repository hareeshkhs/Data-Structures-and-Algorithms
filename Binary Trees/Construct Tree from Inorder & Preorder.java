/*
Link: https://practice.geeksforgeeks.org/problems/construct-tree-1/1

Given 2 Arrays of Inorder and preorder traversal. Construct a tree and print the Postorder traversal. 

Example 1:

Input:
N = 4
inorder[] = {1 6 8 7}
preorder[] = {1 6 7 8}
Output: 8 7 6 1
Example 2:

Input:
N = 6
inorder[] = {3 1 4 0 5 2}
preorder[] = {0 1 3 4 2 5}
Output: 3 4 1 5 2 0
Explanation: The tree will look like
       0
    /     \
   1       2
 /   \    /
3    4   5

*/

import java.util.*;
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

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}// } Driver Code Ends


class Solution
{
    public static int findIndex(int arr[], int start, int target)
    {
        int i=0;
        while( arr[start+i] != target ) i++;
        return i;
    }

    public static Node buildUtil(int inorder[], int preorder[], int inStart, int preStart, int n)
    {
        if(n==0) 
            return null;
        
        Node ret = new Node( preorder[preStart] );
        
        int i = findIndex( inorder, inStart, preorder[preStart] );
        
        ret.left = buildUtil( inorder, preorder, inStart, preStart+1, i );
        ret.right = buildUtil( inorder, preorder, inStart+i+1, preStart+i+1, n-i-1 );
        
        return ret;
    }
    
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        return buildUtil(inorder, preorder, 0, 0, n);
    }
}