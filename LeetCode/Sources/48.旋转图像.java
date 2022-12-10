/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        //先对角线交换
        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix[0].length-1; j >= i; j--) {
                swap(matrix,i,j,j,i);
            }
        }

        //左右交换
        for (int i = 0; i < matrix.length; i++) {
            int l=0,r=matrix[i].length-1;
            while(l<r){
                swap(matrix, i , l, i , r);
                l++;
                r--;
            }
        }
    }

    private void swap(int[][] matrix, int x1, int y1,int x2,int y2) {
        int t=matrix[x1][y1];
        matrix[x1][y1]=matrix[x2][y2];
        matrix[x2][y2]=t;
    }
}
// @lc code=end

