/*
Link: https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N - 1, N - 1). Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
Note: In a path, no cell can be visited more than one time.

Example 1:

Input:
N = 4
m[][] = {{1, 0, 0, 0},
         {1, 1, 0, 1}, 
         {1, 1, 0, 0},
         {0, 1, 1, 1}}
Output:
DDRDRR DRDDRR
Explanation:
The rat can reach the destination at 
(3, 3) from (0, 0) by two paths - DRDDRR 
and DDRDRR, when printed in sorted order 
we get DDRDRR DRDDRR.
Example 2:
Input:
N = 2
m[][] = {{1, 0},
         {1, 0}}
Output:
-1
Explanation:
No path exists and destination cell is 
blocked.

*/

// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static int[][] visited = new int[5][5];
    public static ArrayList<String> result = new ArrayList<String>();

    public static void path(int[][] m, int x, int y, String dir, int n) {
        if (x == n - 1 && y == n - 1) {
            result.add(dir);
            return;
        }

        if (m[x][y] == 0 || visited[x][y] == 1) {
            return;
        }

        visited[x][y] = 1;
        if (x > 0) {
            path(m, x - 1, y, dir + 'U', n);
        }
        if (y > 0) {
            path(m, x, y - 1, dir + 'L', n);
        }
        if (x < n - 1) {
            path(m, x + 1, y, dir + 'D', n);
        }
        if (y < n - 1) {
            path(m, x, y + 1, dir + 'R', n);
        }
        visited[x][y] = 0;
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        try {
            Arrays.fill(visited, 0);
        } 
        catch (ArrayStoreException ex) {
        }
        result.clear();
        if (m[0][0] == 0 || m[n - 1][n - 1] == 0) {
            return result;
        }

        path(m, 0, 0, "", n);
        Collections.sort(result);
        return result;
    }
}