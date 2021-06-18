/*
Link: https://leetcode.com/problems/search-a-2d-matrix/

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length;
        int col=matrix[0].length;
        int found=0;
        int interval=0;
        for(int i=0;i<row;i++){
            if(matrix[i][0]<=target && matrix[i][col-1]>=target){
                interval=i;
                found=1;
                break;
            }
        }
        if(found==0)
            return false;
        else{
            int arr[] = matrix[interval];  
            int result = Arrays.binarySearch(arr,target);  
            if (result < 0)
                return false; 
            else  
                return true;  
        }
    }
}