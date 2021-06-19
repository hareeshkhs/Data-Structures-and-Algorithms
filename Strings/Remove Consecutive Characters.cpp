/*
Link: https://practice.geeksforgeeks.org/problems/consecutive-elements2306/1

Given a string S delete the characters which are appearing more than once consecutively.

Example 1:

Input:
S = aabb
Output:  ab 
Explanation: 'a' at 2nd position is
appearing 2nd time consecutively.
Similiar explanation for b at
4th position.

Example 2:

Input:
S = aabaa
Output:  aba
Explanation: 'a' at 2nd position is
appearing 2nd time consecutively.
'a' at fifth position is appearing
2nd time consecutively.

*/

#include <bits/stdc++.h> 
using namespace std; 


 // } Driver Code Ends

class Solution{
    public:
    string removeConsecutiveCharacter(string s)
    {
        //only entering those elements in stack which are unique consecutively.
    	stack<char> st;
    	for(int i=0;i<s.length();i++)
    		{
    			if( (st.empty()==0 && st.top()!=s[i] ) || st.empty() == 1  )
    				st.push(s[i]);
    		}
    	// storing stack elements in string.	
    	string res;
    	while(st.empty()==0)
    		{
    			res+=st.top();
    			st.pop();	
    		}
    	
    	// reversing the string because stack is a LIFO data structure.	
    	reverse(res.begin(),res.end());
    	return res;		
    }
};

// { Driver Code Starts.
int main() 
{ 
    int t;
    cin>>t;
    while(t--)
    {
        string s;
        cin>>s;
        Solution ob;
        cout<<ob.removeConsecutiveCharacter(s)<<endl;
    }
} 



  // } Driver Code Ends