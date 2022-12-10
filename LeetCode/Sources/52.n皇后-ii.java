/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N皇后 II
 */

// @lc code=start
class Solution {
    private boolean col[],dg[],udg[];
    private int ans;
    private int n;


    public int totalNQueens(int _n) {
        n=_n;
        col=new boolean[n];
        dg=new boolean[n*2];
        udg=new boolean[n*2];

        dfs(0);

        return ans;
    }


    private void dfs(int u) {
        if(u==n){
            ans++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if(col[i]) continue;
            if(dg[u+i]) continue;
            if(udg[u-i+n]) continue;

            col[i]=dg[u+i]=udg[u-i+n]=true;

            dfs(u+1);

            col[i]=dg[u+i]=udg[u-i+n]=false;
        }
    }
}
// @lc code=end

