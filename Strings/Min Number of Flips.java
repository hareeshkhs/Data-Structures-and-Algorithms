/*
Link: https://practice.geeksforgeeks.org/problems/min-number-of-flips3210/1

Given a binary string, that is it contains only 0s and 1s. We need to make this string a sequence of alternate characters by flipping some of the bits, our goal is to minimize the number of bits to be flipped.

Example 1:

Input:
S = "001"
Output: 1
Explanation: We can flip the 0th bit to 1
to have "101".
â€‹Example 2:

Input: 
S = "0001010111"
Output: 2
Explanation: We can flip the 1st and 8th bit
to have "0101010101".

*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution ob = new Solution();
            
            System.out.println(ob.minFlips(S));
                        
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    public int minFlips(String str) {
        int minflips0=0;
        int minflips1=0;
        char start = '0';
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) != start)
                minflips0++;
            start = flip(start);
        }
        start = '1';
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) != start)
                minflips1++;
            start = flip(start);
        }
        return Math.min(minflips0,minflips1);
    }
    static char flip(char ch)
    {
        return (ch == '0') ? '1' : '0';
    }
}