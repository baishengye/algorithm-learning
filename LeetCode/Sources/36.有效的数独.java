import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
//Arrays.fill(arrayname,value) 方法
//和Arrays.fill(arrayname ,starting index ,ending index ,value) 
//方法向数组中填充元素
class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] st=new boolean[9];

        //判断每行有没有重复元素
        for(int i=0;i<9;i++){
            Arrays.fill(st, false);
            for (int j = 0; j < 9; j++) {
                if(board[i][j]!='.'){
                    int t=board[i][j]-'1';
                    if(st[t]) return false;
                    st[t]=true;
                }
            }
        }

        //判断列有没有重复元素
        for(int i=0;i<9;i++){
            Arrays.fill(st, false);
            for (int j = 0; j < 9; j++) {
                if(board[j][i]!='.'){
                    int t=board[j][i]-'1';
                    if(st[t]) return false;
                    st[t]=true;
                }
            }
        }

        //判9宫格有没有重复元素
        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                Arrays.fill(st, false);
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        if(board[i+x][j+y]!='.'){
                            int t=board[i+x][j+y]-'1';
                            if(st[t]) return false;
                            st[t]=true;
                        }
                    }
                }
            }
        }

        return true;
    }
}
// @lc code=end

