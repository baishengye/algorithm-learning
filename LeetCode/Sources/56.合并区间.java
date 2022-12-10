import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        
        List<int[]> ans=new LinkedList<>();

        int l=intervals[0][0],r=intervals[0][1];
        for (int[] is : intervals) {
            if(is[0]>r){
                int t[]={l,r};
                ans.add(t);
                l=is[0];
                r=is[1];
            }else{
                r=Math.max(r, is[1]);
            }
        }
        int t[]={l,r};
        ans.add(t);

        return ans.toArray(new int[ans.size()][2]);
    }
}
// @lc code=end

