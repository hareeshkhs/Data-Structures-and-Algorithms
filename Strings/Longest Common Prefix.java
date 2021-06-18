/*
Link: https://leetcode.com/problems/longest-common-prefix/

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";
        String pre = strs[0];
        int i = 1;
        //System.out.println(strs.length);
        while(i < strs.length){
            //int value=strs[i].indexOf(pre);
            while(strs[i].indexOf(pre) != 0){
                //System.out.println(strs[i].indexOf(pre));
                pre = pre.substring(0,pre.length()-1);
                //System.out.println(pre);
            }
            i++;
        }
        return pre;
    }
}