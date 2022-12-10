/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int ans[][]=new int[n][n];

        int dx[]={0,1,0,-1},dy[]={1,0,-1,0};
        int len=n*n;
        for (int i = 0,j = 0,d = 1, k = 0; i < n&&j < n&&d <= len;d++) {
            ans[i][j]=d;
            int x=i+dx[k],y=j+dy[k];
            if(x<0||x>=n||y<0||y>=n||ans[x][y]!=0){
                k=(k+1)%4;
                x=i+dx[k];
                y=j+dy[k];
            }
            i=x;
            j=y;
        }

        return ans;
    }
}
// @lc code=end

