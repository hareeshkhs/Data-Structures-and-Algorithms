/*
Write a program to reverse an array or string
Given an array (or string), the task is to reverse the array/string.

Example 1:
Input:
s = Geeks
Output: skeeG

Example 2:
Input:
s = for
Output: rof
*/
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static void main(String[] args)throws IOException{
	    Scanner sc = new Scanner(System.in);
	    String str=sc.nextLine();
	    System.out.println("Reverse form: " + new Reverse().reverseWord(str));
	}
}

class Reverse
{
    public static String reverseWord(String str)
    {
        char ch[]=str.toCharArray();
        String rev="";  
        for(int i=ch.length-1;i>=0;i--){ 
            rev+=ch[i];
        }  
        return rev;
    }
}