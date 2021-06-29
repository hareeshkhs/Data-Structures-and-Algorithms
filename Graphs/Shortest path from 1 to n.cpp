/*
Link: https://practice.geeksforgeeks.org/problems/shortest-path-from-1-to-n0156/1

Consider a directed graph whose vertices are numbered from 1 to n. There is an edge from a vertex i to a vertex j iff either j = i + 1 or j = 3 * i. The task is to find the minimum number of edges in a path in G from vertex 1 to vertex n.


Example 1:

Input:
N = 9
Output:
2
Explanation:
9 -> 3 -> 1, so
number of steps are 2. 
â€‹Example 2:

Input:
N = 4
Output:
2
Explanation:
4 -> 3 -> 1, so
number of steps are 2.

*/

//Initial template for c++

#include<bits/stdc++.h> 
using namespace std; 

 // } Driver Code Ends
//User function Template for C++

class Solution{   
public:
    int minimumStep(int n){
        int ans = 0;
        while(n > 1){
            if(n % 3 == 0){
                ans++;
                n /= 3;
            }else{
                n--;
                ans++;
            }
        }
        return ans;
    }
};

// { Driver Code Starts.

int main() 
{ 
    int t;
    cin>>t;
    while(t--)
    {
        int n;
        cin >> n;
        Solution ob;
        cout << ob.minimumStep(n) << endl;
    
    }
    return 0; 
} 

  // } Driver Code Ends