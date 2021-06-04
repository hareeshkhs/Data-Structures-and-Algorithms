/*
Link: https://www.geeksforgeeks.org/move-last-element-to-front-of-a-given-linked-list/

Write a function that moves the last element to the front in a given Singly Linked List. For example, if the given Linked List is 1->2->3->4->5, then the function should change the list to 5->1->2->3->4.

*/

import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
    
}
class GFG{
   static void printList(Node node) 
   { 		
        while (node != null) 
	    { 	
            System.out.print(node.data + " "); 
		    node = node.next; 
	    } 
	    System.out.println(); 
    }
    public static void main(String args[]) throws IOException { 
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t > 0){
        
        	int n = sc.nextInt();
        
            Node head = new Node(sc.nextInt());
            Node tail = head;
        
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
        
            Solution ob = new Solution();
            System.out.println("Before:");
            printList(head);
            head = ob.lasttofront(head);
            System.out.println("\nAfter:");
            printList(head); 
            t--;
        }
    } 
} 
   // } Driver Code Ends


//function Template for Java

/* linked list node class:

class Node {
    int value;
    Node next;
    Node(int value) {
        this.value = value;
    }
}

*/

class Solution
{
    //Function to move last element to front in a linked list.
    Node lasttofront(Node head)
    {
        if(head == null || head.next == null) 
            return head;
        Node current = head.next;
        Node prev = head;
        while (current.next != null) 
	    { 	
	        prev = prev.next;
		    current = current.next;
	    }
	    prev.next = null;
	    current.next = head;
	    head = current;
	    //System.out.println(prev.data);
	    //System.out.println(current.data);
        return head;
    }
}