/*
Link: https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1

Given an array arr[] of size N and an integer K. Find the maximum for each and every contiguous subarray of size K.

Example 1:

Input:
N = 9, K = 3
arr[] = 1 2 3 1 4 5 2 3 6
Output: 
3 3 4 5 5 5 6 
Explanation: 
1st contiguous subarray = {1 2 3} Max = 3
2nd contiguous subarray = {2 3 1} Max = 3
3rd contiguous subarray = {3 1 4} Max = 4
4th contiguous subarray = {1 4 5} Max = 5
5th contiguous subarray = {4 5 2} Max = 5
6th contiguous subarray = {5 2 3} Max = 5
7th contiguous subarray = {2 3 6} Max = 6
Example 2:

Input:
N = 10, K = 4
arr[] = 8 5 10 7 9 4 15 12 90 13
Output: 
10 10 10 15 15 90 90
Explanation: 
1st contiguous subarray = {8 5 10 7}, Max = 10
2nd contiguous subarray = {5 10 7 9}, Max = 10
3rd contiguous subarray = {10 7 9 4}, Max = 10
4th contiguous subarray = {7 9 4 15}, Max = 15
5th contiguous subarray = {9 4 15 12}, 
Max = 15
6th contiguous subarray = {4 15 12 90},
Max = 90
7th contiguous subarray = {15 12 90 13}, 
Max = 90

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(k)

*/

import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main(String args[])
    {
        //taking input using class Scanner
        Scanner sc = new Scanner(System.in);
        
        //taking total count of testcases
        int t = sc.nextInt();
        
        
        
        while(t-- > 0)
        {
            //taking total number of elements
            int n = sc.nextInt();
            
            //taking size of subArrays 
            int k = sc.nextInt();
            
            //Declaring and Intializing an array of size n
            int arr[] = new int[n];
            
            //adding all the elements to the array 
            for(int i = 0; i <n; i++)
            {
                arr[i] =sc.nextInt();
            }
            
            //Calling the method max_of_subarrays of class solve
            //and storing the result in an ArrayList
            ArrayList <Integer> res = new Solution().max_of_subarrays(arr, n, k);
            
            //printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends




class Solution
{
    //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        Deque<Integer> Qi = new LinkedList<Integer>();
        
        ArrayList<Integer> res = new ArrayList<Integer>();
 
        /* Process first k (or first window)
        elements of array */
        int i;
        for (i = 0; i < k; ++i)
        {
            
            // For every element, the previous
            // smaller elements are useless so
            // remove them from Qi
            while (!Qi.isEmpty() && arr[i] >=
                           arr[Qi.peekLast()])
               
                // Remove from rear
                Qi.removeLast();
 
            // Add new element at rear of queue
            Qi.addLast(i);
        }
 
        // Process rest of the elements,
        // i.e., from arr[k] to arr[n-1]
        for (; i < n; ++i)
        {
         
            // The element at the front of the
            // queue is the largest element of
            // previous window, so print it
            res.add(arr[Qi.peek()]);
 
            // Remove the elements which
            // are out of this window
            while ((!Qi.isEmpty()) && Qi.peek() <=
                                             i - k)
                Qi.removeFirst();
 
            // Remove all elements smaller
            // than the currently
            // being added element (remove
            // useless elements)
            while ((!Qi.isEmpty()) && arr[i] >=
                              arr[Qi.peekLast()])
                Qi.removeLast();
 
            // Add current element at the rear of Qi
            Qi.addLast(i);
        }
 
        // Print the maximum element of last window
        res.add(arr[Qi.peek()]);
        return res;
    }
}