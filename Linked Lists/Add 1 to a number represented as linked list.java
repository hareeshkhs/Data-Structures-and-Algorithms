/*
Link: https://practice.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1

A number N is represented in Linked List such that each digit corresponds to a node in linked list. You need to add 1 to it.

Example 1:

Input:
LinkedList: 4->5->6
Output: 457 
Example 2:

Input:
LinkedList: 1->2->3
Output: 124
*/

import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    public static Node reverse(Node head) 
    // this function reverses the linked list
    {
        Node prev = null;
        Node current = head;
        Node next;
        
        while (current != null) 
        { 
            next = current.next;     // storing next node
            current.next = prev;     // linking current node to previous
            prev = current;           // updating prev
            current = next;           // updating current
        }
        
        return prev; 
    } 

    public static Node addOne(Node head) 
    { 
        head = reverse(head);           // reversing list to make addition easy
        
        Node current = head;
        int carry = 1;
        
        while(carry!=0)
        {
            current.data += 1;         // adding one to current node
            
            if(current.data < 10)return reverse(head);
                // if no carry we can reverse back list and return it
            else current.data = 0;
                // else we continue with taking carry forward
            
            if(current.next == null) break;
                // if, end of list, we break from loop
            else current = current.next;
                // else we move to next node
        }
        
        current.next = new Node(1);  // adding new node for the carried 1
        return reverse(head);
    }
}
