/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //核心:把二维数组看成一维数组来做
        int n=matrix.length;
        if(n==0) return false;
        int m=matrix[0].length;
        if(m==0) return false;

        int l=0,r=m*n-1;
        while(l<r){
            int mid=(l+r)/2;
            if(matrix[mid/m][mid%m]>=target) r=mid;
            else l=mid+1;
        }

        if(matrix[r/m][r%m]==target) return true;

        return false;
    }
}
// @lc code=end

