/*
Link: https://practice.geeksforgeeks.org/problems/three-way-partitioning/1

Given an array of size n and a range [a, b]. The task is to partition the array around the range such that array is divided into three parts.
1) All elements smaller than a come first.
2) All elements in range a to b come next.
3) All elements greater than b appear in the end.
The individual elements of three sets can appear in any order. You are required to return the modified array.


Example 1:

Input: 
n = 5
A[] = {1, 2, 3, 3, 4}
[a, b] = [1, 2]
Output: 1
Explanation: One possible arrangement is:
{1, 2, 3, 3, 4}. If you return a valid
arrangement, output will be 1.


Example 2:

Input: 
n = 3 
A[] = {1, 2, 3}
[a, b] = [1, 3]
Output: 1
Explanation: One possible arrangement 
is: {1, 2, 3}. If you return a valid
arrangement, output will be 1.

*/

//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String[] args)throws IOException {
        BufferedReader read= new BufferedReader(new InputStreamReader(System.in));
        int t  =Integer.parseInt(read.readLine());
         
        while(t-->0)
        {
            int N = Integer.parseInt(read.readLine());
            int array[] = new int[N];
            Map<Integer, Integer> mp = new HashMap<>();
            
            String input_line[] = read.readLine().trim().split(" ");
            for(int i=0;i<N;i++)
            {
                array[i] = Integer.parseInt(input_line[i]);
                if (mp.containsKey(array[i]))  
                { 
                    mp.put(array[i], mp.get(array[i]) + 1); 
                }  
                else
                { 
                    mp.put(array[i], 1); 
                } 
            }
            
            input_line = read.readLine().trim().split(" ");
            int a = Integer.parseInt(input_line[0]);
            int b = Integer.parseInt(input_line[1]);
        
            int original[] = new int[N];
            
            for(int i=0; i<N;i++)
            {
                original[i] = array[i];
            }

            int k1=0,k2=0,k3=0;
            int kk1=0;int kk2=0;int kk3=0;

            for(int i=0;i<N;i++)
            {
                if(original[i]>b)
                    k3++;
                else if(original[i]<=b && original[i]>=a)
                    k2++;
                else if(original[i]<b)
                    k1++;
            }
            Solution ob = new Solution();
            ob.threeWayPartition(array,a,b);

            for(int i=0;i<k1;i++)
            {
                if(array[i]<b)
                kk1++;
            }
            
            for(int i=k1;i<k1+k2;i++)
            {
                if(array[i]<=b && array[i]>=a)
                kk2++;
                
            }
            
            for(int i=k1+k2;i<k1+k2+k3;i++)
            {
                if(array[i]>b)
                kk3++;
            }
            Boolean ok = false;
            if(k1==kk1 && k2 ==kk2 && k3 == kk3)
                ok = true;

            for(int i=0;i<array.length;i++)
                mp.put(array[i], mp.get(array[i]) - 1);
            
            for(int i=0;i<array.length;i++)
                if(mp.get(array[i])!=0)
                    ok=false;
            
            if(ok)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    //Function to partition the array around the range such 
    //that array is divided into three parts.
    public void threeWayPartition(int arr[], int a, int b)
    {
        int  n = arr.length;
        
        int start = 0, end = n-1;
          
         // Traverse elements from left
        for(int i = 0; i <= end;)
        {
              
            if(arr[i] < a)
            {
                  
                int temp = arr[start];
                arr[start] = arr[i];
                arr[i] = temp;
                start++;
                i++;
                  
            }
            else if(arr[i] > b)
            {
                  
                int temp = arr[end];
                arr[end] = arr[i];
                arr[i] = temp;
                end--;
                   
            }
              
            else
               i++;
        }
    }
}
