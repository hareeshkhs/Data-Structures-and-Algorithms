/*
Link: https://practice.geeksforgeeks.org/problems/palindromic-array-1587115620/1

Given a Integer array A[] of n elements. Your task is to complete the function PalinArray. Which will return 1 if all the elements of the Array are palindrome otherwise it will return 0.

Input:
The first line of input contains an integer denoting the no of test cases. Then T test cases follow. Each test case contains two lines. The first line of input contains an integer n denoting the size of the arrays. In the second line are N space separated values of the array A[].

Output:
For each test case in a new line print the required result.

*/

import java.util.*;
class PalindromicArray{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i = 0 ;i < n; i++)
				a[i]=sc.nextInt();
			GfG g = new GfG();
			System.out.println(g.palinArray(a , n));
		}
	}
}// } Driver Code Ends


/*Complete the Function below*/
class GfG
{
	public static int palinArray(int[] arr, int n)
	{
	    for(int i=0;i<n;i++){
	        int num=arr[i];
	        int sum=0,r;
	        int temp=num;
	        while(num != 0){
	            r=num%10;
	            sum=(sum*10)+r;
	            num=num/10;
	        }
	        if(temp!=sum){
	            return 0;
	        }
	    }
	    return 1;
	}
}