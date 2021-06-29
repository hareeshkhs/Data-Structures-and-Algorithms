/*
Link: https://practice.geeksforgeeks.org/problems/trie-insert-and-search0651/1

Trie is an efficient information retrieval data structure. Use this data structure to store Strings and search strings. Your task is to use TRIE data structure and search the given string A. If found print 1 else 0.

Example 1:

Input:
N = 8
key[] = {the,a,there,answer,any,by,
         bye,their}
search = the
Output: 1
Explanation: the is present in the given
string "the a there answer any by bye
their"
Example 2:

Input:
N = 8
key[] = {the,a,there,answer,any,by,
         bye,their}
search = geeks
Output: 0
Explanation: geeks is not present in the
given string "the a there answer any by
bye their"


*/

// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            sc.nextLine();
            String[] keys = sc.nextLine().split(" ");

            TrieNode root = new TrieNode();
            for (int i = 0; i < n; i++) {
                insert(root, keys[i]);
            }
            String abc = sc.nextLine();
            if (search(root, abc))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }

    static final int ALPHABET_SIZE = 26;

    // trie node
    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++) children[i] = null;
        }
    };

    
 // } Driver Code Ends
// User function Template for Java


//Function to insert string into TRIE.
static void insert(TrieNode root, String key) 
{
    int level;
    int length = key.length();
    int index;
    TrieNode pCrawl = root;
      
    for (level = 0; level < length; level++)
    {
        index = key.charAt(level) - 'a';
        if (pCrawl.children[index] == null)
            pCrawl.children[index] = new TrieNode();
      
        pCrawl = pCrawl.children[index];
    }
      
    // mark last node as leaf
    pCrawl.isEndOfWord = true;
}

//Function to use TRIE data structure and search the given string.
static boolean search(TrieNode root, String key)
{
    int level;
    int length = key.length();
    int index;
    TrieNode pCrawl = root;
      
    for (level = 0; level < length; level++)
    {
        index = key.charAt(level) - 'a';
      
        if (pCrawl.children[index] == null)
            return false;
      
        pCrawl = pCrawl.children[index];
    }
      
    return (pCrawl.isEndOfWord);
}


// { Driver Code Starts.
}  // } Driver Code Ends