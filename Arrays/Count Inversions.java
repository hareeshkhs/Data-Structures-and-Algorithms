/*
Link: https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1

Given an array of integers. Find the Inversion Count in the array. 

Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum. 
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
 

Example 1:

Input: N = 5, arr[] = {2, 4, 1, 3, 5}
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 
has three inversions (2, 1), (4, 1), (4, 3).
Example 2:

Input: N = 5
arr[] = {2, 3, 4, 5, 6}
Output: 0
Explanation: As the sequence is already 
sorted so there is no inversion count.
Example 3:

Input: N = 3, arr[] = {10, 10, 10}
Output: 0
Explanation: As all the elements of array 
are same, so there is no inversion count.


*/


import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static long inversionCount(long arr[], long N)
    {
        long count=0;
        long[] aux = Arrays.copyOf(arr, arr.length);
        count=mergesort(arr, aux, 0, arr.length - 1);
        return count;
    }
    static long merge(long[] arr, long[] aux, int low, int mid, int high)
    {
        int k = low, i = low, j = mid + 1;
        long inversionCount = 0;
 
        while (i <= mid && j <= high)
        {
            if (arr[i] <= arr[j]) {
                aux[k++] = arr[i++];
            }
            else {
                aux[k++] = arr[j++];
                inversionCount += (mid - i + 1); 
            }
        }
 
        while (i <= mid) {
            aux[k++] = arr[i++];
        }
 
        for (i = low; i <= high; i++) {
            arr[i] = aux[i];
        }
 
        return inversionCount;
    }  

    static long mergesort(long[] arr, long[] aux, int low, int high)
    {
        if (high == low) { 
            return 0;
        }
 
        int mid = (high+low)/2;
        long inversionCount = 0;
 
        inversionCount = mergesort(arr, aux, low, mid);
 
        inversionCount += mergesort(arr, aux, mid + 1, high);
 
        inversionCount += merge(arr, aux, low, mid, high);
 
        return inversionCount;
    }
}