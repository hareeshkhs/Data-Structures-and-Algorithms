/*
Link: https://practice.geeksforgeeks.org/problems/factorials-of-large-numbers2508/1

Given an integer N, find its factorial.

Example 1:

Input: N = 5
Output: 120
Explanation : 5! = 1*2*3*4*5 = 120

Example 2:

Input: N = 10
Output: 3628800
Explanation :
10! = 1*2*3*4*5*6*7*8*9*10 = 3628800

*/

//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int N = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.factorial(N);
            for (Integer val: ans) 
                System.out.print(val); 
            System.out.println();
        }   
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static ArrayList<Integer> factorial(int N){
        if(N==0){
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        list.add(1);
	        return list;
	    }
	   
	    ArrayList<Integer> faith = factorial(N-1);
	    //System.out.println(faith);
	    int size = faith.size()-1;
	    //System.out.println(faith.size() + "  " + size);
	    int carry=0;
	    while(size>0){
	        int num=faith.get(size)*(N)+carry;
	        faith.set(size,num%10);
	        carry=num/10;
	        size--;
	    }
	    //System.out.println(faith + " "+ faith.get(size)+"N"+N);
	    int temp=N*faith.get(0)+carry;
	    faith.set(0, temp%10);
	    temp=temp/10;
	    //System.out.println(temp);
	    while(temp>0){
	        //System.out.println(temp%2);
	        faith.add(0,temp%10);
			temp = temp/10;
	    }
	    return faith;
    }
}