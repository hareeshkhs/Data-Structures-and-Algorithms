/*
Link: https://practice.geeksforgeeks.org/problems/brothers-from-different-root/1

Given two BSTs containing N1 and N2 distinct nodes respectively and given a value x. Your task is to complete the function countPairs(), that returns the count of all pairs from both the BSTs whose sum is equal to x.

Examples:

Input : BST 1:    5        
                /   \      
               3     7      
              / \   / \    
             2  4  6   8   

        BST 2:    10        
                /   \      
               6     15      
              / \   /  \    
             3  8  11  18
        x = 16
    
Output : 3
The pairs are:
(5, 11), (6, 10) and (8, 8)

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

class BST
{
     public static Node insert(Node node, int data)
    {
     if (node == null)
     {
            return (new Node(data));
    } else 
        {
             
           
            if (data < node.data)
            {
                node.left = insert(node.left, data);
            } else if (data > node.data) 
            {
                node.right = insert(node.right, data);
            }
 
            
            return node;
        }
    
    }
     public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        
        while(t-- > 0)
        {
           
            Node root1 = null;
            Node root2 = null;
             int n1 = sc.nextInt();
             
            
             while(n1-- > 0)
            {
               int data = sc.nextInt();
                root1 = insert(root1, data);
            }
            
            int n2 = sc.nextInt();
             while(n2 -- > 0)
            {
               int data = sc.nextInt();
                root2 = insert(root2, data);
            }
            
            int s = sc.nextInt();
            
            GfG gfg = new GfG();
            System.out.println(gfg.countPairs(root1, root2, s));
        }
        
        
    }
}
// } Driver Code Ends


//User function Template for Java

/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

//User function Template for Java
/*class Node
{
    int data;
    Node left, right;
    
    Node(int key)
    {
        data = key;
        left = right = null;
    }
    
}*/
class GfG
{
    
    public  int countPairs(Node root1, Node root2, int x){
        
        List<Integer> list1 = new ArrayList<>() ;
        List<Integer> list2 = new ArrayList<>() ;
        inorder(root1,list1) ;
        inorder(root2,list2) ;
        int ans = 0 ;
        int i = 0 ;
        int j = list2.size()-1 ;
        int n = list1.size() ;
        int m = list2.size() ;
        while(i < n && j > -1){
            if(list1.get(i)+list2.get(j) == x){
                ans++ ;
                i++ ;
                j-- ;
            }
            else if(list1.get(i)+list2.get(j) < x){
                i++ ;
            }
            else{
                j-- ;
            }
        }
        return ans ;
    }
    
    public void inorder(Node root , List<Integer> al){
        
        if(root == null) return ;
        inorder(root.left,al) ;
        al.add(root.data) ;
        inorder(root.right,al) ;
    }
}