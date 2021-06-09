/*
Link: https://practice.geeksforgeeks.org/problems/special-stack/1

Design a data-structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull() and an additional operation getMin() which should return minimum element from the SpecialStack. Your task is to complete all the functions, using stack data-Structure.

Example 1:

Input:
Stack: 18 19 29 15 16
Output: 15
Explanation:
The minimum element of the stack is 15.

*/

class SpeStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			Stack<Integer> s=new Stack<>();
			GfG g=new GfG();
			while(!g.isEmpty(s)){
			    g.pop(s);
			}
			while(!g.isFull(s,n)){
				g.push(sc.nextInt(),s);
			}
		System.out.println(g.min(s));
		}
	}
}// } Driver Code Ends


/*Complete the function(s) below*/
class GfG{
	public void push(int a,Stack<Integer> s)
	{
	    s.push(a);
	}
	public int pop(Stack<Integer> s)
        {
        int value = (int)s.pop();
        return value;
	}
	public int min(Stack<Integer> s)
        {
        int m=(int)s.pop();
		while(!s.empty()){
			int n=(int)s.pop();
			if(n<m)
				m=n;
		}
		return m;
	}
	public boolean isFull(Stack<Integer>s, int n)
        {
        if(s.size()==n){
            return true;
        }else{
            return false;
        }
	}
	public boolean isEmpty(Stack<Integer>s)
        {
        boolean result = s.empty();
        return result;
	}
}