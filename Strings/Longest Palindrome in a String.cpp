/*
Link: https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string3411/1

Given a string S, find the longest palindromic substring in S. Substring of string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S). Palindrome string: A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S. Incase of conflict, return the substring which occurs first ( with the least starting index).


Example 1:

Input:
S = "aaaabbaa"
Output: aabbaa
Explanation: The longest Palindromic
substring is "aabbaa".
Example 2:

Input: 
S = "abc"
Output: a
Explanation: "a", "b" and "c" are the 
longest palindromes with same length.
The result is the one with the least
starting index.

*/

#include<bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
class Solution {
  public:
    string longestPalin (string S)
    {
        int fi = 0, fj = 0, j, k, n = S.length ();
    
        for (int i = 0; i < n; ++i)
        {
            // odd length palindrome with current index as center
            j = i - 1;
            k = i + 1;
            while (j >= 0 and k < n)
            {
                if (S[j] != S[k])
                    break;
                j--;
                k++;
            }
            if (k - j - 1 > fj - fi + 1)
            {
                fi = j + 1;
                fj = k - 1;
            }
    
            // even length palindrome if possible
            if (i < n - 1 and S[i] == S[i + 1])
            {
                j = i - 1;
                k = i + 2;
                while (j >= 0 and k < n)
                {
                    if (S[j] != S[k])
                        break;
                    j--;
                    k++;
                }
                if (k - j - 1 > fj - fi + 1)
                {
                    fi = j + 1;
                    fj = k - 1;
                }
            }
        }
    
        return S.substr (fi, fj - fi + 1);
    }
};

// { Driver Code Starts.

int main()
{
    int t; cin >> t;
    while (t--)
    {
        string S; cin >> S;
        
        Solution ob;
        cout << ob.longestPalin (S) << endl;
    }
}
  // } Driver Code Ends