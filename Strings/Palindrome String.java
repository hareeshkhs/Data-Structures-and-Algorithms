/*
Link: https://practice.geeksforgeeks.org/problems/palindrome-string0817/1

Given a string S, check if it is palindrome or not.

Example 1:

Input: S = "abba"
Output: 1
Explanation: S is a palindrome
Example 2:

Input: S = "abc" 
Output: 0
Explanation: S is not a palindrome

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
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPlaindrome(S));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    int isPlaindrome(String S) {
        int turn=1;
        S = S.toLowerCase();  
        for(int i = 0; i < S.length()/2; i++){  
            if(S.charAt(i) != S.charAt(S.length()-i-1)){  
                turn=0; 
                break;  
            }  
        }
        return turn;
    }
};