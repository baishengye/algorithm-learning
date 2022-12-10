import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] a, int[] b) {
        List<int[]> ans=new LinkedList<>();
        int k=0;
        //把a中的区间分成三个部分
        //左端不与b重复的部分
        while(k<a.length&&a[k][1]<b[0]) ans.add(a[k++]);

        //a与b重复的部分(或者根本没有重复)
        if(k<a.length){
            b[0]=Math.min(a[k][0], b[0]);
            while(k<a.length&&a[k][0]<=b[1]){
                b[1]=Math.max(a[k++][1], b[1]);
            }
        }
        ans.add(b);

        //右端不与b重合
        while(k<a.length) ans.add(a[k++]);

        return ans.toArray(new int[ans.size()][]);

    }
}
// @lc code=end

