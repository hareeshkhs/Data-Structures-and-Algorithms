/*
Link: https://www.geeksforgeeks.org/find-first-node-of-loop-in-a-linked-list/

Write a function findFirstLoopNode() that checks whether a given Linked List contains a loop. If the loop is present then it returns point to the first node of the loop. Else it returns NULL.

Example : 

Input : Head of below linked list
1 -> 2 -> 3
     ^    |
     |    |
     5____4

Output : Pointer to node 2
*/

// driver code

import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
}

class GFG
{
    public static Node newNode(int data){
        Node temp = new Node();
        temp.data = data;
        temp.next = null;
        return temp;
    }
    
    public static void makeLoop(Node head, int x){
        if (x == 0)
            return;
        Node curr = head;
        Node last = head;

        int currentPosition = 1;
        while (currentPosition < x)
        {
            curr = curr.next;
            currentPosition++;
        }
        
        while (last.next != null)
            last = last.next;
        last.next = curr;
    }
    
    public static int length(Node head){
        int ret=0;
        while(head!=null)
        {
            ret += 1;
            head = head.next;
        }
        return ret;
    }
    
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t--> 0)
        {
            int n = sc.nextInt();
            
            int num = sc.nextInt();
            Node head = newNode(num);
            Node tail = head;
            
            for(int i=0; i<n-1; i++)
            {
                num = sc.nextInt();
                tail.next = newNode(num);
                tail = tail.next;
            }
            
            int pos = sc.nextInt();
            makeLoop(head, pos);
            
            solver x = new solver();
            x.firstnodeofLoop(head);
        }
    }
}
// } Driver Code Ends


/*
class Node
{
    int data;
    Node next;
}
*/

class solver
{
    public static void firstnodeofLoop(Node head){
        Node fast = head.next;
        Node slow = head;
        
        while( fast != slow)
        {
            if( fast==null || fast.next==null) 
                break;
            
            fast=fast.next.next;
            slow=slow.next;
        }
        System.out.println(fast.data);
    }
}