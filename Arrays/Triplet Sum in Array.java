/*
Link: https://practice.geeksforgeeks.org/problems/triplet-sum-in-array-1587115621/1

Given an array arr of size n and an integer X. Find if there's a triplet in the array which sums up to the given integer X.


Example 1:

Input:
n = 6, X = 13
arr[] = [1 4 45 6 10 8]
Output:
1
Explanation:
The triplet {1, 4, 8} in 
the array sums up to 13.
Example 2:

Input:
n = 5, X = 10
arr[] = [1 2 4 3 6]
Output:
1
Explanation:
The triplet {1, 3, 6} in 
the array sums up to 10.

*/

//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int X = Integer.parseInt(inputLine[1]);
		    int A[] = new int[n];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        A[i] = Integer.parseInt(inputLine[i]);
		    }
		    Solution ob=new Solution();
		    boolean ans = ob.find3Numbers(A, n, X);
		    System.out.println(ans?1:0);
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find if there exists a triplet in the 
    //array A[] which sums up to X.
    public static boolean find3Numbers(int A[], int n, int sum) { 
        
        for (int i = 1; i < n; ++i) {
            int key = A[i];
            int j = i - 1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && A[j] > key) {
                A[j + 1] = A[j];
                j = j - 1;
            }
            A[j + 1] = key;
        }
        int low,high;
        for (int i = 0; i < n - 2; i++) {
 
            // To find the other two elements, start two index variables
            // from two corners of the array and move them toward each
            // other
            low = i + 1; // index of the first element in the remaining elements
            high = n - 1; // index of the last element
            while (low < high) {
                if (A[i] + A[low] + A[high] == sum) {
                    //System.out.print("Triplet is " + A[i] + ", " + A[l] + ", " + A[r]+"\n");
                    return true;
                }
                else if (A[i] + A[low] + A[high] < sum)
                    low++;
 
                else if(A[i] + A[low] + A[high] > sum)
                    high--;
            }
        }
 
        // If we reach here, then no triplet was found
        return false;
    }
}
