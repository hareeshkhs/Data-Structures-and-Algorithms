/*
Link: https://practice.geeksforgeeks.org/problems/clone-a-linked-list-with-next-and-random-pointer/1

You are given a special linked list with N nodes where each node has a next pointer pointing to its next node. You are also given M random pointers , where you will be given M number of pairs denoting two nodes a and b  i.e. a->arb = b.


Example 1:

Input:
N = 4, M = 2
value = {1,2,3,4}
pairs = {{1,2},{2,4}}
Output: 1
Explanation: In this test case, there
re 4 nodes in linked list.  Among these
4 nodes,  2 nodes have arbit pointer
set, rest two nodes have arbit pointer
as NULL. Second line tells us the value
of four nodes. The third line gives the
information about arbitrary pointers.
The first node arbit pointer is set to
node 2.  The second node arbit pointer
is set to node 4.

Example 2:

Input:
N = 4, M = 2
value[] = {1,3,5,9}
pairs[] = {{1,1},{3,4}}
Output: 1
Explanation: In the given testcase ,
applying the method as stated in the
above example, the output will be 1.

*/

import java.util.*;

class Node {
    int data;
    Node next, arb;

    Node(int d) {
        data = d;
        next = arb = null; 
    }
}

class Cloning {
    static Node head;

    public static void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = node;
        }
    }

    public static boolean validation(Node head, Node res, Node cloned_add,
                              Node generated_add) {

        if (generated_add == cloned_add) return false;

        Node temp1 = head;
        Node temp2 = res;

        int len1 = 0, len2 = 0;
        while (temp1 != null) {
            len1++;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            len2++;
            temp2 = temp2.next;
        }

        /*if lengths not equal */

        if (len1 != len2) return false;

        temp1 = head;
        temp2 = res;
        while (temp1 != null) {
            if (temp1.data != temp2.data) return false;
            if (temp1.arb != null && temp2.arb != null) {
                if (temp1.arb.data != temp2.arb.data) return false;
            } else if (temp1.arb != null && temp2.arb == null)
                return false;
              else if(temp1.arb== null && temp2.arb !=null)
                return false;

            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }
    //   public static void printList()

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            Node generated_add = null;
            int n = sc.nextInt();
            int q = sc.nextInt();

            int a1 = sc.nextInt();
            Node head = new Node(a1);
            addToTheLast(head);

            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                addToTheLast(new Node(a));
            }

            for (int i = 0; i < q; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                Node tempA = head;
                int count = -1;

                while (tempA != null) {
                    count++;
                    if (count == a - 1) break;
                    tempA = tempA.next;
                }
                Node tempB = head;
                count = -1;

                while (tempB != null) {
                    count++;
                    if (count == b - 1) break;
                    tempB = tempB.next;
                }

                // when both a is greater than N
                if (a <= n) tempA.arb = tempB;
            }

            generated_add = head;
            Clone g = new Clone();
            Node res = g.copyList(head);

            Node cloned_add = res;

            if (validation(head, res, cloned_add, generated_add) == true)
                System.out.println("1");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*
class Node {
    int data;
    Node next, arb;

    Node(int d) 
    { 
        data = d;
        next = arb = null; 
        
    }
}*/
// function to copy linked list
class Clone {
    Node copyList(Node head) {
        Node cloneHead = null;
        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            cloneHead = new Node(temp.data);
            map.put(temp, cloneHead);
            temp = temp.next;
        }
        temp = head;
        cloneHead = map.get(temp);
        while (temp != null) {
            cloneHead.next = map.get(temp.next);
            cloneHead.arb = map.get(temp.arb);
            temp = temp.next;
            cloneHead = cloneHead.next;
        }
        Node resNode = map.get(head);
        return resNode;
    }
}

