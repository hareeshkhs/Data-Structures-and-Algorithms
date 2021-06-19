/*
Link: https://practice.geeksforgeeks.org/problems/count-triplets-with-sum-smaller-than-x5549/1

Given an array arr[] of distinct integers of size N and a sum value X, the task is to find count of triplets with the sum smaller than the given sum value X.

 

Example 1:

Input: N = 6, X = 2
arr[] = {-2, 0, 1, 3}
Output:  2
Explanation: Below are triplets with 
sum less than 2 (-2, 0, 1) and (-2, 0, 3). 

Example 2:

Input: N = 5, X = 12
arr[] = {5, 1, 3, 4, 7}
Output: 4
Explanation: Below are triplets with 
sum less than 12 (1, 3, 4), (1, 3, 5), 
(1, 3, 7) and (1, 4, 5).

*/

//Initial Template for Java

//Initial Template for Java

import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java



class Solution
{
    long countTriplets(long arr[], int n,int sum)
    {
        Arrays.sort(arr);
	    long count = 0;
	    for (int i = 0; i < n - 2; i++)
	    {
	        int j = i + 1, k = n - 1;
	        while (j < k)
	        {
	            if (arr[i] + arr[j] + arr[k] >= sum)
	                k--;
	            else
	            {
	                count += (k - j);
	                j++;
	            }
	        }
	    }
	    return count;
    }
}


// { Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int k =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
//            String line2 = br.readLine();
//            String[] a2 = line2.trim().split("\\s+");
//            long b[] = new long[m];
//            for (int i = 0; i < m; i++) {
//                b[i] = Long.parseLong(a2[i]);
//            }
            Solution ob = new Solution();
            long ans=ob.countTriplets(a,n,k);
            System.out.println(ans);
        }
    }
}



  // } Driver Code Ends