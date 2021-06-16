/*
Link: https://practice.geeksforgeeks.org/problems/maximum-product-subarray3604/1

Given an array Arr that contains N integers (may be positive, negative or zero). Find the product of the maximum product subarray.

Example 1:

Input:
N = 5
Arr[] = {6, -3, -10, 0, 2}
Output: 180
Explanation: Subarray with maximum product
is 6, -3, -10 which gives product as 180.
Example 2:

Input:
N = 6
Arr[] = {2, 3, 4, 5, -1, 0}
Output: 120
Explanation: Subarray with maximum product
is 2, 3, 4, 5 which gives product as 120.

*/


import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
    
        long max_ending_here = 1;
 
        long min_ending_here = 1;
 
        long max_so_far = 0;
        int flag = 0;
 
        for (int i = 0; i < n; i++)
        {
            if (arr[i] > 0)
            {
                max_ending_here = max_ending_here * arr[i];
                min_ending_here
                    = Math.min(min_ending_here * arr[i], 1);
                flag = 1;
            }
 
            else if (arr[i] == 0)
            {
                max_ending_here = 1;
                min_ending_here = 1;
            }
 
            else {
                long temp = max_ending_here;
                max_ending_here
                    = Math.max(min_ending_here * arr[i], 1);
                min_ending_here = temp * arr[i];
            }
 
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
        }
 
        if (flag == 0 && max_so_far == 0)
            return 0;
        return max_so_far;
    }

}