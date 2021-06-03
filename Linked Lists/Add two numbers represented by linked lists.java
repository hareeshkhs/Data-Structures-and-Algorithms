/*
Link: https://practice.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1

Given two numbers represented by two linked lists of size N and M. The task is to return a sum list. The sum list is a linked list representation of the addition of two input numbers from the last.

Example 1:

Input:
N = 2
valueN[] = {4,5}
M = 3
valueM[] = {3,4,5}
Output: 3 9 0  
Explanation: For the given two linked
list (4 5) and (3 4 5), after adding
the two linked list resultant linked
list will be (3 9 0).
Example 2:

Input:
N = 2
valueN[] = {6,3}
M = 1
valueM[] = {7}
Output: 7 0
Explanation: For the given two linked
list (6 3) and (7), after adding the
two linked list resultant linked list
will be (7 0).
*/

// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}
// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    public static Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        Node next = null;
        
        while(curr != null)
        {
            next = curr.next;     
            curr.next = prev;     
            prev = curr;          
            curr = next;        
        }
        
        return prev;
    }
    static Node addTwoLists(Node first, Node second){

        first = reverse(first);      
        second = reverse(second);     
        
        Node sum = null;
        int carry = 0;
        
        while( first!=null || second!=null || carry>0 )
        {
            int newVal = carry;
            
            if(first!=null) newVal+=first.data;
            if(second!=null) newVal+=second.data;
            
            carry = newVal / 10;
            
            newVal = newVal % 10;
            
            Node newNode = new Node(newVal);
            
            newNode.next = sum;
            
            sum = newNode;
            
            if(first!=null) first = first.next;      
            if(second!=null) second = second.next;
        }
        return sum;
    }
}