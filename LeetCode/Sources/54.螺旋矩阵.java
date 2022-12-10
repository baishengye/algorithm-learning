import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    private int dx[]={0,1,0,-1},dy[]={1,0,-1,0};
    private List<Integer> ans;

    public List<Integer> spiralOrder(int[][] matrix) {
        ans=new LinkedList<>();
        if(matrix==null||matrix.length==0||matrix[0].length==0) return ans;
        
        int row=matrix.length;
        int col=matrix[0].length;
        int inf=101;

        int k=0;
        int x=0,y=0;
        int cnt=row*col;
        ans.add(matrix[0][0]);

        while(cnt>1){
            k%=4;

            matrix[x][y]=inf;

            int a=x+dx[k];
            int b=y+dy[k];
            if(a<0||a>=row||b<0||b>=col||matrix[a][b]==inf){
                k++;
            }else{
                ans.add(matrix[a][b]);
                x=a;
                y=b;
                cnt--;
            }
        }

        return ans;
    }
}
// @lc code=end

