/*
Link: https://practice.geeksforgeeks.org/problems/valid-substring0624/1/

Given a string S consisting only of opening and closing parenthesis 'ie '('  and ')', find out the length of the longest valid(well-formed) parentheses substring.
NOTE: Length of smallest the valid substring ( ) is 2.

Example 1:

Input: S = "(()("
Output: 2
Explanation: The longest valid 
substring is "()". Length = 2.
Example 2:

Input: S = "()(())("
Output: 6
Explanation: The longest valid 
substring is "()(())". Length = 6.

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
            System.out.println(ob.findMaxLen(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    static int findMaxLen(String S) {
        int n = S.length();

        Stack<Integer> stk = new Stack<>();
        stk.push(-1);
        int result = 0;
 
        for (int i = 0; i < n; i++)
        {
            if (S.charAt(i) == '(')
                stk.push(i);
 
            else
            {
                if(!stk.empty())
                    stk.pop();
                
                if (!stk.empty())
                    result = Math.max(result, i - stk.peek());

                else
                    stk.push(i);
            }
        }
        return result;
    }
};