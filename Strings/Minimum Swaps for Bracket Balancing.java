/*
Link: https://practice.geeksforgeeks.org/problems/minimum-swaps-for-bracket-balancing2704/1

You are given a string S of 2N characters consisting of N ‘[‘ brackets and N ‘]’ brackets. A string is considered balanced if it can be represented in the for S2[S1] where S1 and S2 are balanced strings. We can make an unbalanced string balanced by swapping adjacent characters. Calculate the minimum number of swaps necessary to make a string balanced.
Note - Strings S1 and S2 can be empty.

 

Example 1:

Input  : []][][
Output : 2
Explanation :
First swap: Position 3 and 4
[][]][
Second swap: Position 5 and 6
[][][]

 

Example 2:

Input : [[][]]
Output : 0 
Explanation:
String is already balanced.

*/

//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {   
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.minimumNumberOfSwaps(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static int minimumNumberOfSwaps(String s){
        char[] chars = s.toCharArray();
        
        int countLeft = 0, countRight = 0;

        int swap = 0 , imbalance = 0;
         
        for(int i =0; i< chars.length; i++)
        {
            if(chars[i] == '[')
            {
                countLeft++;
                if(imbalance > 0)
                {
                    swap += imbalance;
                    imbalance--;    
                }
            } else if(chars[i] == ']' )
            {
                countRight++;
                imbalance = (countRight-countLeft);
            }
        }
        return swap;
    }
}