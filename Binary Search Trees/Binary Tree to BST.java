/*
Link: https://practice.geeksforgeeks.org/problems/binary-tree-to-bst/1

Given a Binary Tree, convert it to Binary Search Tree in such a way that keeps the original structure of Binary Tree intact.
 

Example 1:

Input:
      1
    /   \
   2     3
Output: 1 2 3

Example 2:

Input:
          1
       /    \
     2       3
   /        
 4       
Output: 1 2 3 4
Explanation:
The converted BST will be

        3
      /   \
    2     4
  /
 1

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

class GFG {
    
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
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            Solution g = new Solution();
            Node rootA = g.binaryTreeToBST(root);
            printInorder(rootA);
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

/*Structure of the node class is
class Node
{
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
} */

class index
{
    int x = 0;
}
class Solution
{
    void arrayToBST(int arr[], Node root, index index_ptr)
    {
        if(root == null)
            return ;
        
        arrayToBST(arr, root.left, index_ptr);
        root.data = arr[index_ptr.x];
        index_ptr.x++;
        arrayToBST(arr, root.right, index_ptr);
    }
    void storeInorder(Node node, int inorder[], index index_ptr)
    {
        //int index_ptr = 0;
        if(node == null)
            return ;
        
        storeInorder(node.left, inorder, index_ptr);
        inorder[index_ptr.x] = node.data;
        index_ptr.x++;
        storeInorder(node.right, inorder, index_ptr);
    }
    int countNodes(Node root)
    {
        if(root == null)
            return 0;
        return countNodes(root.left) + countNodes(root.right)+1;
    }
    Node binaryTreeToBST (Node root)
    {
        if(root == null)
            return null;
        
        int n = countNodes(root);
        
        int arr[] = new int[n];
        index index = new index();
        storeInorder(root, arr,index);
        
        Arrays.sort(arr);
        index.x = 0;
        arrayToBST(arr, root, index);
        return root;
    }
}

 