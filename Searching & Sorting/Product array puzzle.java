/*
Link: https://practice.geeksforgeeks.org/problems/product-array-puzzle4525/1

Given an array nums[] of size n, construct a Product Array P (of same size n) such that P[i] is equal to the product of all the elements of nums except nums[i].

 

Example 1:

Input:
n = 5
nums[] = {10, 3, 5, 6, 2}
Output:
180 600 360 300 900
Explanation: 
For i=0, P[i] = 3*5*6*2 = 180.
For i=1, P[i] = 10*5*6*2 = 600.
For i=2, P[i] = 10*3*6*2 = 360.
For i=3, P[i] = 10*3*5*2 = 300.
For i=4, P[i] = 10*3*5*6 = 900.
Example 2:

Input:
n = 2
nums[] = {12,0}
Output:
0 12


*/

//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
        	int[] array = new int[n];
        	for (int i=0; i<n ; i++ ) {
        		array[i] = sc.nextInt();
        	}
            Solution ob = new Solution();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(array, n); 

           	for (int i = 0; i < n; i++) { 
				System.out.print(ans[i]+" ");
			} 
            System.out.println();
            t--;
        }
    } 
} 
  

// } Driver Code Ends


//User function Template for Java


class Solution 
{ 
	public static long[] productExceptSelf(int arr[], int n) 
	{ 
        long[] prod = new long[n];
		// Base case 
		if (n == 1) { 
			prod[0] = 1;
			return prod; 
		} 

		long temp = 1; 

		/* Initialize the product array as 1 */
		for (int i = 0; i < n; i++) 
			prod[i] = 1; 

		/* In this loop, temp variable contains product of 
		elements on left side excluding arr[i] */
		for (int i = 0; i < n; i++) { 
			prod[i] = temp; 
			temp *= arr[i]; 
		} 
		/* Initialize temp to 1 for product on right side */
		temp = 1; 

		/* In this loop, temp variable contains product of 
		elements on right side excluding arr[i] */
		for (int i = n - 1; i >= 0; i--) { 
			prod[i] *= temp; 
			temp *= arr[i]; 
		} 
		return prod; 
	} 
} 
