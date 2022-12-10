import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 */

// @lc code=start
/**
 * 一个n*n的棋盘，里面的对角线和反对角线都是2*n-1个
 * 一条直线是y=a*x+b
 * 截距是b，就可以把b作为下标来判断唯一的斜线
 * 由于b可能是负数，所以给b加上一个偏移量n
 */
class Solution {
    private int n;
    private char[][] g;
    private List<List<String>> ans;
    private boolean[] col,dg,udg;

    public List<List<String>> solveNQueens(int _n) {
        n=_n;
        g=new char[n][n];
        ans=new LinkedList<>();

        col=new boolean[n];
        dg=new boolean[n*2];
        udg=new boolean[n*2];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j]='.';
            }
        }

        dfs(0);

        return ans;
    }

    private void dfs(int u) {
        if(u==n){
            List<String> t=new LinkedList<>();
            for (char[] str : g) {
                t.add(new String(str));
            }
            ans.add(t);
            return;
        }

        for (int i = 0; i < n; i++) {
            //比较列
            if(col[i]) continue;

            //比较对角线
            if(dg[u-i+n]) continue;

            //比较斜对角线
            if(udg[u+i]) continue;

            col[i]=dg[u-i+n]=udg[u+i]=true;
            g[u][i]='Q';

            dfs(u+1);

            col[i]=dg[u-i+n]=udg[u+i]=false;
            g[u][i]='.';
        }
    }
}
// @lc code=end

