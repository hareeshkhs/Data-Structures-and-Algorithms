/*
Link: https://practice.geeksforgeeks.org/problems/stack-using-two-queues/1

Implement a Stack using two queues q1 and q2.

Example 1:

Input:
push(2)
push(3)
pop()
push(4)
pop()
Output: 3 4
Explanation:
push(2) the stack will be {2}
push(3) the stack will be {2 3}
pop()   poped element will be 3 the 
        stack will be {2}
push(4) the stack will be {2 4}
pop()   poped element will be 4  
Example 2:

Input:
push(2)
pop()
pop()
push(3)
Output: 2 -1

*/

import java.util.*;


class StackUsingQueues
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			Queues g = new Queues();
			
			int q = sc.nextInt();
			while(q>0)
			{
				int QueryType = sc.nextInt();
				if(QueryType == 1)
				{
					int a = sc.nextInt();
					g.push(a);
				}
				else if(QueryType == 2)
				System.out.print(g.pop()+" ");
			q--;
			}	
			System.out.println();
				
			
			
		t--;
		}
	}
}

// } Driver Code Ends




class Queues
{
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    
    //Function to push an element into stack using two queues.
    void push(int a)
    {
	    while(!q1.isEmpty())
		{
			int k = q1.peek();
			
			//popping element from first queue.
			q1.remove();
			
			//pushing it into second queue.
			q2.add(k);
		}
		
		//q1 is empty now and we push the given number into first queue.
		q1.add(a);
		
		//while second queue is not empty, we keep popping the front element
        //from second queue and storing that element in first queue.
		while(!q2.isEmpty())
		{
			int k = q2.peek();
			//popping element from second queue.
			q2.remove();
			
			//pushing it into first queue.
			q1.add(k);
			
		}	
    }
    
    //Function to pop an element from stack using two queues. 
    int pop()
    {
	    if(!q1.isEmpty())
		{
		    //we store the front element from the queue in a 
            //variable and pop that element.
			int r = q1.peek();
			q1.remove();
			
			//returning the popped element.
			return r;
		}
		//else we return -1.
		return -1;
    }
	
}