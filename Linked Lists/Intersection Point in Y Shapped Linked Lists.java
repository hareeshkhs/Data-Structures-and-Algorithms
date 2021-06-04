/*
Link: https://practice.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/1

Given two singly linked lists of size N and M, write a program to get the point where two linked lists intersect each other.

Example 1:

Input:
LinkList1 = 3->6->9->common
LinkList2 = 10->common
common = 15->30->NULL
Output: 15

Example 2:

Input: 
Linked List 1 = 4->1->common
Linked List 2 = 5->6->1->common
common = 8->4->5->NULL
Output: 8
Explanation: 

4              5
|              |
1              6
 \             /
  8   -----  1 
   |
   4
   |
  5
  |
  NULL

*/

import java.util.*;

class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}
	
class LinkedList_Intersection
{
    Node head = null;  
	Node tail = null;

public void addToTheLast(Node node) 
{

  if (head == null) {
   head = node;
   tail = head;
  } else {
   //Node temp = head;
   //while (temp.next != null)
    //temp = temp.next;

   //temp.next = node;
   tail.next=node;
   tail = node;
  }
}

  /* Function to print linked list */
    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	
	 
 
     /* Driver program to test above functions */
    public static void main(String args[])
    {
       
         
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 
		 while(t>0)
         {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			int n3 = sc.nextInt();
			LinkedList_Intersection llist1 = new LinkedList_Intersection();
		    LinkedList_Intersection llist2 = new LinkedList_Intersection();
			LinkedList_Intersection llist3 = new LinkedList_Intersection();
			
				int a1=sc.nextInt();
				Node head1= new Node(a1);
				Node tail1= head1;
				
				for (int i = 1; i < n1; i++) 
				{
					int a = sc.nextInt(); 
					tail1.next = (new Node(a));
					tail1= tail1.next;
				}
			
			
				int b1=sc.nextInt();
				Node head2 = new Node(b1);
				Node tail2 = head2;
				for (int i = 1; i < n2; i++) 
				{
					int b = sc.nextInt();  
					tail2.next = (new Node(b));
					tail2= tail2.next;
				}
				
				int c1=sc.nextInt();
				Node head3= new Node(c1);
				tail1.next = head3;
				tail2.next = head3;
				Node tail3=head3;
				for (int i = 1; i < n3; i++) 
				{
					int c = sc.nextInt();   
					tail3.next = (new Node(c));
					tail3= tail3.next;
				}
				
				Intersect obj = new Intersect();
				System.out.println(obj.intersectPoint(head1, head2));
			t--;			
         }
    }
}
// } Driver Code Ends


/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
 Linked List class
class LinkedList
{
    Node head;  // head of list
}*/

class Intersect
{
    //Function to find intersection point in Y shaped Linked Lists.
	int intersectPoint(Node head1, Node head2)
	{
	    int n1=0, n2=0;
        Node temp=null;
        
        //finding length of list1.
        for(temp = head1; temp!=null; temp=temp.next)
            n1+=1;
            
        //finding length of list2.
        for(temp = head2; temp!=null; temp=temp.next)
            n2+=1;
        
        //if list1 is longer, we ignore some of its starting
        //elements till it has as many elements as list2.
        for(  ; n1>n2 ; n1-=1 )
            head1 = head1.next;
        
        // similarly, if list2 is longer, we ignore some of its starting
        //elements till it has as many elements as list1.
        for(  ; n2>n1 ; n2-=1 )
            head2 = head2.next;
        
        //now we simply traverse ahead till we get the intersection point, if 
        //there is none, this loop will break when both pointers point at NULL.
        while( head1 != head2 )
        {
            head1 = head1.next;
            head2 = head2.next;
        }
        // if head1 is not NULL, we return its data otherwise we return -1.
        if(head1!=null) 
        return head1.data;
        return -1; 
	}
}

/*
int intersectPoint(Node head1, Node head2)
{
        HashSet<Node> hs = new HashSet<Node>();
        int value;
        while (n1 != null) {
            hs.add(n1);
            n1 = n1.next;
        }
        while (n2 != null) {
            if (hs.contains(n2)) {
                value=n2.data
                return value;
            }
            n2 = n2.next;
        }
        return -1;
}
*/