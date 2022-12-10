/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        if(m==0) return 0;
        int n=obstacleGrid[0].length;
        if(n==0) return 0;
        int f[][]=new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(obstacleGrid[i][j]==1){
                    f[i][j]=0;
                    continue;
                }

                if(i==0&&j==0) f[i][j]=1;
                else if(i==0) f[i][j]=f[i][j-1];
                else if(j==0) f[i][j]=f[i-1][j];
                else f[i][j]=f[i-1][j]+f[i][j-1];
            }
        }

        return f[m-1][n-1];
    }
}
// @lc code=end

