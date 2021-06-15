/*
Link: https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s/0

Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.


Example 1:

Input: 
N = 5
arr[]= {0 2 1 2 0}
Output:
0 0 1 2 2
Explanation:
0s 1s and 2s are segregated 
into ascending order.
Example 2:

Input: 
N = 3
arr[] = {0 1 0}
Output:
0 0 1
Explanation:
0s 1s and 2s are segregated 
into ascending order.

*/

//Initial template for Java

import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function template for Java

class Solution
{
    public static void sort012(int a[], int n)
    {
        int count=0;
        int num0=0;
        int num1=0;
        int num2=0;
        for (int i=0;i<n;i++){
            if(a[i]==0){
                num0=num0+1;
            }
            if(a[i]==1){
                num1=num1+1;
            }
            if(a[i]==2){
                num2=num2+1;
            }
        }
        int j=0;
        int value=0;
        for(j=0;j<n;j++){
            if(count==num0){
                value=1;
            }
            if(count==num0+num1){
                value=2;
            }
            a[j]=value;
            count=count+1;
        }
    }
}

// { Driver Code Starts.

class GFG {
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob=new Solution();
            ob.sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}

  // } Driver Code Ends