/*
Link: https://practice.geeksforgeeks.org/problems/longest-prefix-suffix2527/1

Given a string of characters, find the length of the longest proper prefix which is also a proper suffix.

Example 1:

Input: s = "abab"
Output: 2
Explanation: "ab" is the longest proper 
prefix and suffix. 
Example 2:

Input: s = "aaaa"
Output: 3
Explanation: "aaa" is the longest proper 
prefix and suffix.

*/

//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.lps(s));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    int lps(String s) {
        int n = s.length();
	
		int lps[] = new int[n];
		
		// lps[0] is always 0
		lps[0] = 0;
	
		// length of the previous
		// longest prefix suffix
		int len = 0;
	
		// the loop calculates lps[i]
		// for i = 1 to n-1
		int i = 1;
		while (i < n)
		{
			if (s.charAt(i) == s.charAt(len))
			{
				len++;
				lps[i] = len;
				i++;
			}
			
			// (pat[i] != pat[len])
			else
			{
				// This is tricky. Consider
				// the example. AAACAAAA
				// and i = 7. The idea is
				// similar to search step.
				if (len != 0)
				{
					len = lps[len-1];
	
					// Also, note that we do
					// not increment i here
				}
				
				// if (len == 0)
				else
				{
					lps[i] = 0;
					i++;
				}
			}
		}
	
		int res = lps[n-1];
	
		// Since we are looking for
		// non overlapping parts.
		return res;
    }
}