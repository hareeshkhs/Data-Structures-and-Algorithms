/*
Link: https://practice.geeksforgeeks.org/problems/merge-k-sorted-arrays/1

Given K sorted arrays arranged in the form of a matrix of size K*K. The task is to merge them into one sorted array.
Example 1:

Input:
K = 3
arr[][] = {{1,2,3},{4,5,6},{7,8,9}}
Output: 1 2 3 4 5 6 7 8 9
Explanation:Above test case has 3 sorted
arrays of size 3, 3, 3
arr[][] = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
The merged list will be 
[1, 2, 3, 4, 5, 6, 7, 8, 9].
Example 2:

Input:
K = 4
arr[][]={{1,2,3,4}{2,2,3,4},{5,5,6,6},{7,8,9,9}}
Output:
1 2 2 2 3 3 4 4 5 5 6 6 7 8 9 9 
Explanation: Above test case has 4 sorted
arrays of size 4, 4, 4, 4
arr[][] = [[1, 2, 2, 2], [3, 3, 4, 4],
[5, 5, 6, 6]  [7, 8, 9, 9 ]]
The merged list will be 
[1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 
6, 6, 7, 8, 9, 9 ].

*/

//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to merge k sorted arrays.
    public static class HeapItem implements Comparable<HeapItem>
    {
        int[] array;                
        int index;        
      
        //declaring HeapItem.
        public HeapItem(int[] arr, int index) 
        {
           array = arr;
           this.index=index;
        }   
        @Override
        public int compareTo(HeapItem h)
        {
          if(array[index] > h.array[h.index])
              return 1;
          else if(array[index] < h.array[h.index])
              return -1;
          else
              return 0;
        }
        
    }
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arrays,int k) 
    {
      
        //implementing heap using priority queue.
        PriorityQueue<HeapItem> pq = new PriorityQueue<HeapItem>();             
        
        //adding arrays to the heap.
        for (int i = 0; i < arrays.length; i++) 
        {
            pq.add(new HeapItem(arrays[i], 0));
        }
        
        //using a list to store the resultant array after merging.
        ArrayList<Integer> result = new ArrayList<Integer>(); 
        
        //using a loop while priority queue is not empty.
        while (!pq.isEmpty())
        {
            HeapItem current = pq.remove();
            //adding the element at current in list.
            result.add(current.array[current.index]);                       
            if (current.index < current.array.length-1) 
            {  
        	    current.index++;
        	    pq.add(current); 
            }
        }
        //returning the result.
        return result;
    } 
}