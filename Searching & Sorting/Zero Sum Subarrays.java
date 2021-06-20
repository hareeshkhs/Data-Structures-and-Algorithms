/*
Link: https://practice.geeksforgeeks.org/problems/zero-sum-subarrays1825/1

You are given an array arr[] of size n. Find the total count of sub-arrays having their sum equal to 0.


Example 1:

Input:
n = 6
arr[] = {0,0,5,5,0,0}
Output: 6
Explanation: The 6 subarrays are 
[0], [0], [0], [0], [0,0], and [0,0].

Example 2:

Input:
n = 10
arr[] = {6,-1,-3,4,-2,2,4,6,-12,-7}
Output: 4
Explanation: The 4 subarrays are [-1 -3 4]
[-2 2], [2 4 6 -12], and [-1 -3 4 -2 2]

*/

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    int n;
		    n=sc.nextInt();
		    
		    long arr[]=new long[n];
	
		    
		    for(int i=0;i<n;i++)
		    {
		        arr[i]=sc.nextLong();
		    }
            Solution ob = new Solution();
		    System.out.println(ob.findSubarray(arr,n));
		}
		
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    //Function to count subarrays with sum equal to 0.
    public static long findSubarray(long[] arr ,int n) 
    {
        long sum=0, counter=0; 
     //using Hashmap to store the prefix sum which has appeared already.
     HashMap<Long, Long>mp=new HashMap<>();
    
        //iterating over the array.
        for(int i=0;i<n;i++)
        {
            //storing prefix sum.
            sum+=arr[i];
            
            //if prefix sum is zero that means we get a subarray with sum=0.
            if(sum==0)
            {
                //incrementing the counter.
                counter++;
                //System.out.println(sum);
            }
            
            //if prefix sum is already present in Hashmap then it is repeated 
            //which means there is a subarray whose summation is 0.
            if(mp.containsKey(sum)) 
            {
               //we add the value at prefix sum in Hashmap to counter.
               //System.out.println(sum);
               counter+=mp.get(sum);
            }
            
            //incrementing the count of prefix sum obtained in Hashmap.
            if(mp.containsKey(sum))
            {
                long k=mp.get(sum);
                k++;
                mp.put(sum,k);
                
            }
            else
             mp.put(sum,1L);
            
        }
       
       //returning the counter.
       return counter ;
    }
}