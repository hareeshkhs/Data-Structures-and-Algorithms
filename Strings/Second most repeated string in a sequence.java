/*
Link: https://practice.geeksforgeeks.org/problems/second-most-repeated-string-in-a-sequence0534/1

Given a sequence of strings, the task is to find out the second most repeated (or frequent) string in the given sequence.

Note: No two strings are the second most repeated, there will be always a single string.

Example 1:

Input:
N = 6
arr[] = {aaa, bbb, ccc, bbb, aaa, aaa}
Output: bbb
Explanation: "bbb" is the second most 
occurring string with frequency 2.

â€‹Example 2:

Input: 
N = 6
arr[] = {geek, for, geek, for, geek, aaa}
Output: for
Explanation: "for" is the second most
occurring string with frequency 2.

*/

//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            for(int i = 0;i<n;i++)
                arr[i] = sc.next();
            
            Solution ob = new Solution();
            
            System.out.println(ob.secFrequent(arr, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    String secFrequent(String arr[], int N)
    {
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        for(String str:arr){
            //System.out.println(str);
            if(map.containsKey(str)){
                map.put(str,map.get(str)+1);
            }
            else{
                map.put(str,1);
            }
        }
        int first_max = Integer.MIN_VALUE, sec_max = Integer.MIN_VALUE;
          
        Iterator<Map.Entry<String, Integer>> itr = map.entrySet().iterator();
        while (itr.hasNext()) 
        {
            Map.Entry<String, Integer> entry = itr.next();
            int v = entry.getValue();
            if( v > first_max) {
                sec_max = first_max;
                first_max = v;
            }
       
            else if (v > sec_max && v != first_max)
                sec_max = v;
        }
        itr = map.entrySet().iterator();
        while (itr.hasNext()) 
        {
            Map.Entry<String, Integer> entry = itr.next();
            int v = entry.getValue();
            if (v == sec_max)
                return entry.getKey();
        }
         
        return null;
    }
}