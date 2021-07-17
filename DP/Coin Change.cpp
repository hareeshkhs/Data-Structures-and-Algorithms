/*
Link: https://practice.geeksforgeeks.org/problems/coin-change2448/1

Given a value N, find the number of ways to make change for N cents, if we have infinite supply of each of S = { S1, S2, .. , SM } valued coins. 

Example 1:

Input:
n = 4 , m = 3
S[] = {1,2,3}
Output: 4
Explanation: Four Possible ways are:
{1,1,1,1},{1,1,2},{2,2},{1,3}.

â€‹Example 2:

Input:
n = 10 , m = 4
S[] ={2,5,3,6}
Output: 5
Explanation: Five Possible ways are:
{2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} 
and {5,5}.
*/

#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends

#define ll long long
class Solution
{
  public:
    long long int count( int a[], int m, int n )
    {
        ll dp[n+1][m+1];
    for(ll i=0; i<=n; i++)
        dp[i][0] = 0;
    for(ll i=0; i<=m; i++)
        dp[0][i] = 0;
    for(ll i=1; i<=n; i++)
    {
        for(ll j=1; j<=m; j++)
        {
            if(a[j-1] > i)
                dp[i][j] = dp[i][j-1];
            else if(a[j-1] == i)
                dp[i][j] = dp[i][j-1] + 1;
            else
                dp[i][j] = dp[i-a[j-1]][j] + dp[i][j-1];
        }
    }
    return dp[n][m];
    }
};

// { Driver Code Starts.
int main()
{
    int t;
    cin>>t;
	while(t--)
	{
		int n,m;
		cin>>n>>m;
		int arr[m];
		for(int i=0;i<m;i++)
		    cin>>arr[i];
	    Solution ob;
		cout<<ob.count(arr,m,n)<<endl;
	}
    
    
    return 0;
}  // } Driver Code Ends

/*
Different Codes:

class Solution
{
    public long count(int S[], int m, int n) 
    { 
        long dp[][] =new long[n+1][m+1];
        for(int i=0; i<=n; i++)
            dp[i][0] = 0;
        for(int i=0; i<=m; i++)
            dp[0][i] = 0;
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=m; j++)
            {
                if(S[j-1] > i)
                    dp[i][j] = dp[i][j-1];
                else if(S[j-1] == i)
                    dp[i][j] = dp[i][j-1] + 1;
                else
                    dp[i][j] = dp[i-S[j-1]][j] + dp[i][j-1];
            }
        }
        return dp[n][m];
    } 
}

class Solution
{
    public long count(int S[], int m, int n) 
    { 
        long[] table = new long[n+1];
 
        // Initialize all table values as 0
        Arrays.fill(table, 0);   //O(n)
 
        // Base case (If given value is 0)
        table[0] = 1;
 
        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i=0; i<m; i++)
            for (int j=S[i]; j<=n; j++)
                table[j] += table[j-S[i]];
 
        return table[n];
    } 
}

*/