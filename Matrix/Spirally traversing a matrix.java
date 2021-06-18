/*
Link: https://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1

Given a matrix of size r*c. Traverse the matrix in spiral form.

Example 1:

Input:
r = 4, c = 4
matrix[][] = {{1, 2, 3, 4},
           {5, 6, 7, 8},
           {9, 10, 11, 12},
           {13, 14, 15,16}}
Output: 
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10

Example 2:

Input:
r = 3, c = 4  
matrix[][] = {{1, 2, 3, 4},
           {5, 6, 7, 8},
           {9, 10, 11, 12}}
Output: 
1 2 3 4 8 12 11 10 9 5 6 7
Explanation:
Applying same technique as shown above, 
output for the 2nd testcase will be 
1 2 3 4 8 12 11 10 9 5 6 7.

*/

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}// } Driver Code Ends





class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int row, int col)
    {
        int total=row*col;
        ArrayList<Integer> list=new ArrayList<Integer>();
        int count=0;
        int a=0,b=0,c=0,d=0,i=0,j=0,k=0,l=0;
        while(count<total){
            //System.out.println(c+" "+col);
            for(i=c;i<col;i++){
                //System.out.println("A:"+a+"I:"+i+"M"+matrix[a][i]);
                list.add(matrix[a][i]);
                count++;
            }
            a++;
            i--;
            if(count>=total)
                break;
            for(j=a;j<row;j++){
                //System.out.println("J:"+j+"I:"+(i)+"M"+matrix[j][i]);
                list.add(matrix[j][i]);
                count++;
            }
            i--;
            j--;
            if(count>=total)
                break;
            for(k=i;k>=b;k--){
                //System.out.println("J:"+(j)+"K:"+k+"M"+matrix[j][k]);
                list.add(matrix[j][k]);
                count++;
            }
            j--;
            //System.out.println(count+" "+total);
            if(count>=total)
                break;
            for(l=j;l>d;l--){
                //System.out.println("l:"+l+"B:"+b+"M"+matrix[l][b]);
                list.add(matrix[l][b]);
                count++;
            }
            c++;
            row--;
            col--;
            b++;
            d++;
        }
        return list;
    }
}
