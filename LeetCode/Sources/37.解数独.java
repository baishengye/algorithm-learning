/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 */

// @lc code=start
class Solution {
    boolean row[][];
    boolean col[][];
    boolean cell[][][];
    public void solveSudoku(char[][] board) {
        row=new boolean[9][9];//9行，每一行中数字i是否存在
        col=new boolean[9][9];//9行，每一列中数字i是否存在
        cell=new boolean[3][3][9];//3*3个九宫格，每个9宫格中数字i是否存在

        //初始化
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j]!='.'){
                    int t=board[i][j]-'1';//0~8
                    row[i][t]=true;//第i行标记为存在t了
                    col[j][t]=true;//第j列标记为存在t了
                    cell[i/3][j/3][t]=true;//九宫格标记为存在t了
                }
            }
        }

        dfs(board,0,0);
    }
    private boolean dfs(char[][] board, int x, int y) {
        if(y==9){//y一定会比x先到达边界(我们是行优先遍历的)
            x++;
            y=0;
        }
        if(x==9) return true;

        if(board[x][y]!='.')//本身就是数字的就不用填
            return dfs(board, x, y+1);

        for (int i = 0; i < 9; i++) {//判断0~8重不重复
            if(!row[x][i]&&!col[y][i]&&!cell[x/3][y/3][i]){//如果没有重复
                row[x][i]=true;//第i行标记为存在t了
                col[y][i]=true;//第j列标记为存在t了
                cell[x/3][y/3][i]=true;//九宫格标记为存在t了
                board[x][y]=(char) ('1'+i);

                if(dfs(board, x, y+1)) return true;

                row[x][i]=false;//回复现场
                col[y][i]=false;
                cell[x/3][y/3][i]=false;
                board[x][y]='.';
            }
        }

        return false;
    }
}
// @lc code=end

