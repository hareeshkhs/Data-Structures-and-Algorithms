/*
Link: https://practice.geeksforgeeks.org/problems/reverse-a-string-using-stack/1

You are given a string S, the task is to reverse the string using stack.

Example 1:

Input: S="GeeksforGeeks"
Output: skeeGrofskeeG

*/

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            Solution obj = new Solution();
            System.out.println(obj.reverse(sc.next()));
        }
	}
}
// } Driver Code Ends


class Solution {
    
    public String reverse(String S){
        Stack<Character>s =  new Stack<>();
        for(int i =0;i<S.length();i++){
            s.push(S.charAt(i));
        }
        char arr[] = new char[S.length()];
        for(int i =0;i<S.length();i++){
            arr[i]=s.pop();
        }
        String str = String.valueOf(arr);
        return str.toString();
    }
}
/*
public String reverse(String S){
        String ans="";
        Stack<Character> s = new Stack<>();
        for (int i=0; i<S.length(); i++)
        {
            s.push(S.charAt(i));
        }
        
        while(!s.isEmpty()){
            ans+=s.pop();
        }
        return ans;
}
*/