/*
Link: https://practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1

Given two sequences, find the length of longest subsequence present in both of them. Both the strings are of uppercase.

Example 1:

Input:
A = 6, B = 6
str1 = ABCDGH
str2 = AEDFHR
Output: 3
Explanation: LCS for input Sequences
“ABCDGH” and “AEDFHR” is “ADH” of
length 3.
Example 2:

Input:
A = 3, B = 2
str1 = ABC
str2 = AC
Output: 2
Explanation: LCS of "ABC" and "AC" is
"AC" of length 2.
Your Task:
Complete the function lcs() which takes the length of two strings respectively and two strings as input parameters and returns the length of the longest subsequence present in both of them.

Expected Time Complexity : O(|str1|*|str2|)
Expected Auxiliary Space: O(|str1|*|str2|)

*/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}// } Driver Code Ends





class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int m, int n, String s1, String s2)
    {
        int L[][] = new int[m+1][n+1];
    
        for(int i=0;i<=s1.length();i++){
            for(int j=0;j<=s2.length();j++){
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (s1.charAt(i-1) == s2.charAt(j-1))
                    L[i][j] = L[i-1][j-1] + 1;
                else
                    L[i][j] = max(L[i-1][j], L[i][j-1]);
            }
        }
        return L[m][n];
    }
    static int max(int a, int b) 
    { 
        return (a > b)? a : b; 
    }
}

/*

class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
    {
        Integer dp[][]=new Integer[s1.length()+1][s2.length()+1];
        return longestSubseq(dp,s1,s2,0,0);
    }
    static int longestSubseq(Integer[][]dp, String s1, String s2, int i,int j){
        if(i>s1.length()-1 || j>s2.length()-1){
            return 0;
        }
        if(dp[i][j]==null){
            if(s1.charAt(i)==s2.charAt(j)){
                dp[i][j]=1+longestSubseq(dp,s1,s2,i+1,j+1);
                return dp[i][j];
            }
            int c2=longestSubseq(dp,s1,s2,i,j+1);
            int c3=longestSubseq(dp,s1,s2,i+1,j);
            dp[i][j]=Math.max(c2,c3);
        }
        return dp[i][j];
    }
    
}

*/