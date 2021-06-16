/*
Link: https://practice.geeksforgeeks.org/problems/find-the-median0527/1

Given an array arr[] of N integers, calculate the median
 

Example 1:

Input: N = 5
arr[] = 90 100 78 89 67
Output: 89
Explanation: After sorting the array 
middle element is the median 

Example 2:

Input: N = 4
arr[] = 56 67 30 79â€‹
Output: 61
Explanation: In case of even number of 
elemebts average of two middle elements 
is the median

*/

//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v  = new int[n];
            for(int  i = 0; i < n; i++)
                v[i] = Integer.parseInt(S[i]);
            Solution ob = new Solution();
            int ans = ob.find_fact(v);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int find_fact(int[] v)
    {
        int n=v.length;
        sort(v, 0, n-1);
        int median=0;
        if(n%2==1)
            median=v[(n+1)/2-1];
        else
            median=(v[n/2-1]+v[n/2])/2;
            
        return median;
    }
    int partition(int arr[], int low, int high)
    {
        int pivot = arr[high]; 
        int i = (low-1); 
        for (int j=low; j<high; j++)
        {
            if (arr[j] <= pivot)
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
  
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
  
        return i+1;
    }
  
    void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            int pi = partition(arr, low, high);
  
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }
}