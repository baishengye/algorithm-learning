import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */

// @lc code=start
class Solution {

    // public int uniquePaths(int m, int n) {
    //     int f[][]=new int[m][n];
    //     for (int i = 0; i < m; i++) {
    //         for (int j = 0; j < n; j++) {
    //             f[i][j]=1;
    //     }

    //     for (int i = 1; i < m; i++) {
    //         for (int j = 1; j < n; j++) {
    //             f[i][j]=f[i][j-1]+f[i-1][j];
    //         }
    //     }

    //     return f[m-1][n-1];
    // }


    public int uniquePaths(int m, int n) {
        int f[]=new int[n];
        for (int i = 0; i < n; i++) {
                f[i]=1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[j]=f[j]+f[j-1];
            }
        }

        return f[n-1];
    }
}
// @lc code=end

