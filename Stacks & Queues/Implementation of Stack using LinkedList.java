/*
Implementation of stack using Linkedlist
*/
import java.util.Scanner;
public class Main {
 
    Node root;
 
    static class Node {
        int data;
        Node next;
 
        Node(int data)
        { 
            this.data = data;
        }
    }
 
    public boolean isEmpty()
    {
        if (root == null) {
            return true;
        }
        else
            return false;
    }
 
    public void push(int data)
    {
        Node newNode = new Node(data);
 
        if (root == null) {
            root = newNode;
        }
        else {
            Node temp = root;
            root = newNode;
            newNode.next = temp;
        }
        System.out.println("pushed to stack");
    }
 
    public void pop()
    {
        int popped = Integer.MIN_VALUE;
        if (root == null) {
            System.out.println("Stack is Empty");
        }
        else {
            popped = root.data;
            root = root.next;
            System.out.println(popped + " popped from stack");
        }
    }
    public void display()
    {
        if (root == null) {
            System.out.println("Stack is empty");
        }
        Node ptr = root;
        while(ptr!=null){
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }
    public void peek()
    {
        if (root == null) {
            System.out.println("Stack is empty");
        }
        else {
            System.out.println("Top element is " + root.data);
        }
    }
 
    // Driver code
    public static void main(String[] args)
    {
        int choice=0;  
        Scanner sc = new Scanner(System.in);  
        Main s = new Main();  
        System.out.println("*********Stack operations using array*********\n");  
        System.out.println("------------------------------------------------");  
        while(choice != 5)  
        {  
            System.out.println("\nChoose one from the below options...");  
            System.out.println("\n1.Push\n2.Pop\n3.Show\n4.Peek\n5.Exit");  
            System.out.println("\nEnter your choice: ");        
            choice = sc.nextInt();  
            switch(choice)  
            {  
                case 1:  
                {   
                    System.out.println("Enter value to push: ");
                    int value = sc.nextInt();
                    s.push(value);  
                    break;  
                }  
                case 2:  
                {  
                    s.pop();
                    break;  
                }  
                case 3:  
                {  
                    s.display();  
                    break;  
                }
                case 4:   
                {  
                    s.peek();
                    break;   
                }
                case 5:   
                {  
                    System.out.println("Exiting....");  
                    System.exit(0);  
                    break;   
                }  
                default:  
                {  
                    System.out.println("Please Enter valid choice ");  
                }   
            };  
        }
    }
}