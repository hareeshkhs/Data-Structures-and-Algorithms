/*
Link: https://practice.geeksforgeeks.org/problems/edit-distance3702/1

Given two strings s and t. Find the minimum number of operations that need to be performed on str1 to convert it to str2. The possible operations are:

Insert
Remove
Replace
 

Example 1:

Input: 
s = "geek", t = "gesek"
Output: 1
Explanation: One operation is required 
inserting 's' between two 'e's of str1.
Example 2:

Input : 
s = "gfg", t = "gfg"
Output: 
0
Explanation: Both strings are same.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function editDistance() which takes strings s and t as input parameters and returns the minimum number of operation required to make both strings equal. 


Expected Time Complexity: O(|s|*|t|)
Expected Space Complexity: O(|s|*|t|)

*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    public int editDistance(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        int dp[][] = new int[slen+1][tlen+1];
        
        for(int i = 0;i<=slen;i++) {
            dp[i][0] = i;
        }
        for(int j = 0;j<=tlen;j++) {
            dp[0][j] = j;
        }
        
        for(int i = 1;i<=slen;i++){
            for(int j=1;j<=tlen;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = min(dp[i-1][j], dp[i-1][j-1], dp[i][j-1])+1;
                }
            }
        }
        return dp[slen][tlen];
    }
    int min(int a, int b, int c) 
    { 
        return (a < b) ? (a < c ? a : c) : (b < c ? b : c);
    }
}