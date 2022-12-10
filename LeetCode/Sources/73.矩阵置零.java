/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] 矩阵置零
 */

// @lc code=start
class Solution {
    /**
     * 核心思路就是用第一行和第一列来存储对应的列和行需不需要归0
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        if(m==0) return ;
        int n=matrix[0].length;
        if(n==0) return ;

        
        int r0=1;//r0存储第一行需不需要归0
        for(int j=0;j<n;j++){
            if(matrix[0][j]==0){
                r0=0;
                break;
            }
        }
            
        int c0=1;//c0存储第一列需不需要归0
        for(int i=0;i<m;i++){
            if(matrix[i][0]==0){
                c0=0;
                break;
            }
        }

        
        for(int i=1;i<m;i++){
            for (int j = 1; j < n; j++) {
                if(matrix[i][j]==0){
                    matrix[0][j]=0;//存储所有列是否需要归0
                    matrix[i][0]=0;//存储所有行是否需要归0
                }
            }
        }  

        //行归0
        for (int i = 1; i < m; i++) {
            if(matrix[i][0]==0){
                for (int j = 0; j < n; j++) {
                    matrix[i][j]=0;
                }
            }
        }

        //列归0
        for (int j = 1; j < n; j++) {
            if(matrix[0][j]==0){
                for (int i = 0; i < m; i++) {
                    matrix[i][j]=0;
                }
            }
        }

        //第一行归0
        if(r0==0){
            for(int j=0;j<n;j++){
                   matrix[0][j]=0;
            }
        }

        //第一列归0
        if(c0==0){
            for(int i=0;i<m;i++){
                   matrix[i][0]=0;
            }
        }
    }
}
// @lc code=end

