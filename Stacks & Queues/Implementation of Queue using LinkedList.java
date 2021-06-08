/*
Implementation of Queue using Linkedlist
*/
import java.util.Scanner;
class Node {
	int data;
	Node next;

	public Node(int data)
	{
		this.data = data;
		this.next = null;
	}
}
class Queue {
    
	Node front, rear;

	public Queue()
	{
		this.front = this.rear = null;
	}
	void enqueue(int data)
	{
		Node temp = new Node(data);
		if (this.rear == null) {
			this.front = this.rear = temp;
			return;
		}
		this.rear.next = temp;
		this.rear = temp;
	}

	void dequeue()
	{
		if (this.front == null)
			return;
		Node temp = this.front;
		this.front = this.front.next;
		
		if (this.front == null)
			this.rear = null;
	}
}

// Driver class
public class Main {
	public static void main(String[] args)
	{
		Queue q = new Queue();
		q.enqueue(10);
		q.enqueue(20);
		q.dequeue();
		q.dequeue();
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		q.dequeue();
		System.out.println("Queue Front : " + q.front.data);
		System.out.println("Queue Rear : " + q.rear.data);
	}
}