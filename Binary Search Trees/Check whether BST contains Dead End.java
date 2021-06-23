/*
Link: https://practice.geeksforgeeks.org/problems/check-whether-bst-contains-dead-end/1

Given a Binary search Tree that contains positive integer values greater then 0. The task is to complete the function isDeadEnd which returns true if the BST contains a dead end else returns false. Here Dead End means, we are not able to insert any element after that node.

Examples:

Input :   
               8
             /   \ 
           5      9
         /  \     
        2    7 
       /
      1     
          
Output : Yes
Explanation : Node "1" is the dead End because after that 
              we cant insert any element.       

Input :     
              8
            /   \ 
           7     10
         /      /   \
        2      9     13

Output : Yes
Explanation : We can't insert any element at 
              node 9.


*/

import java.util.Scanner;
import java.io.*;
class Node {
        int data;
        Node left, right;
 
        Node(int item) {
            data = item;
            left = right = null;
        }
    }
class BinarySearchTree {
    public static Node root;
    BinarySearchTree() { 
        root = null; 
    }
    void insert(int key) {
       root = insertRec(root, key);
    }
    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);
        return root;
    }
 
    public static void inorder()  {
       inorderRec(root);
    }
    public static void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data);
            inorderRec(root.right);
        }
    }
 
    // Driver Program to test above functions
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int []a=new int[n];
            BinarySearchTree obj1=new BinarySearchTree();
            for(int i=0;i<n;i++)
            {
                int b=sc.nextInt();
                obj1.insert(b);
            }
            //inorder();
            GFG obj=new GFG();
            boolean k=obj.isDeadEnd(root);
            if(k==true)
            System.out.println("1");
            else
            System.out.println("0");
        }       
    }
}

// } Driver Code Ends


/*class Node {
        int data;
        Node left, right;
 
        Node(int item) {
            data = item;
            left = right = null;
        }
    }*/

//Function should return true if a deadEnd is found in the bst otherwise return false.
class GFG
{
    public static boolean isDeadEnd(Node root)
    {
        //Add your code here.
        return isDeadEndUtil(root,1,Integer.MAX_VALUE);
    }
    
    private static boolean isDeadEndUtil(Node root,int min,int max)
    {
        if(root==null)
            return false;
        if(max-min==0)
            return true;
        return (isDeadEndUtil(root.left,min,root.data-1) || isDeadEndUtil(root.right,root.data+1,max));
    }
}