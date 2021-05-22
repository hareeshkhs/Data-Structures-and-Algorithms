/*
Maximum and minimum of an array using minimum number of comparisons.
Write a program to Print minimum and maximum in an array. Your program should make the minimum number of comparisons. 
Example:
Input:
Arr[] = { 1,2,4,5,-3,91 }
Output:
Maximum element : 91
Minimum Element : -3
*/
// Java program of above implementation
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
    
	static class Pair {

		int min;
		int max;
	}

	static Pair getMinMax(int arr[], int low, int high) {
		Pair minmax = new Pair();
		Pair mml = new Pair();
		Pair mmr = new Pair();
		int mid;

		// If there is only one element
		if (low == high) {
			minmax.max = arr[low];
			minmax.min = arr[low];
			return minmax;
		}

		/* If there are two elements */
		if (high == low + 1) {
			if (arr[low] > arr[high]) {
				minmax.max = arr[low];
				minmax.min = arr[high];
			} else {
				minmax.max = arr[high];
				minmax.min = arr[low];
			}
			return minmax;
		}

		/* If there are more than 2 elements */
		mid = (low + high) / 2;
		mml = getMinMax(arr, low, mid);
		mmr = getMinMax(arr, mid + 1, high);

		/* compare minimums of two parts*/
		if (mml.min < mmr.min) {
			minmax.min = mml.min;
		} else {
			minmax.min = mmr.min;
		}

		/* compare maximums of two parts*/
		if (mml.max > mmr.max) {
			minmax.max = mml.max;
		} else {
			minmax.max = mmr.max;
		}

		return minmax;
	}

	/* Driver program to test above function */
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Size of Array: ");  
		int n=sc.nextInt();
		int[] arr = new int[100];  
		System.out.println("Enter the elements of the array: ");  
		for(int i=0; i<n; i++)  
		{  
		    arr[i]=sc.nextInt();
		}
		Pair minmax = getMinMax(arr, 0, n - 1);
		System.out.printf("\nMaximum element : %d", minmax.max);
		System.out.printf("\nMinimum element : %d", minmax.min);

	}
}