/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] g) {
        int m=g.length;
        if(m==0) return 0;
        int n=g[0].length;
        if(n==0) return 0;

        int f[][]=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j]+=g[i][j];
                if(i==0&&j==0) ;
                else if(i==0) f[i][j]+=f[i][j-1];
                else if(j==0) f[i][j]+=f[i-1][j];
                else f[i][j]+=Math.min(f[i-1][j], f[i][j-1]); 
            }
        }

        return f[m-1][n-1];
    }
}
// @lc code=end

